package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class HlsPlaylistTracker implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    private static final double PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5d;
    private final HlsDataSourceFactory dataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final Uri initialPlaylistUri;
    private boolean isLive;
    private HlsMasterPlaylist masterPlaylist;
    private final int minRetryCount;
    private final ParsingLoadable.Parser<HlsPlaylist> playlistParser;
    private HlsMasterPlaylist.HlsUrl primaryHlsUrl;
    private final PrimaryPlaylistListener primaryPlaylistListener;
    private HlsMediaPlaylist primaryUrlSnapshot;
    private final List<PlaylistEventListener> listeners = new ArrayList();
    private final Loader initialPlaylistLoader = new Loader("HlsPlaylistTracker:MasterPlaylist");
    private final IdentityHashMap<HlsMasterPlaylist.HlsUrl, MediaPlaylistBundle> playlistBundles = new IdentityHashMap<>();
    private final Handler playlistRefreshHandler = new Handler();
    private long initialStartTimeUs = -9223372036854775807L;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>>, Runnable {
        private long blacklistUntilMs;
        private long earliestNextLoadTimeMs;
        private long lastSnapshotChangeMs;
        private long lastSnapshotLoadMs;
        private boolean loadPending;
        private final ParsingLoadable<HlsPlaylist> mediaPlaylistLoadable;
        private final Loader mediaPlaylistLoader = new Loader("HlsPlaylistTracker:MediaPlaylist");
        private IOException playlistError;
        private HlsMediaPlaylist playlistSnapshot;
        private final HlsMasterPlaylist.HlsUrl playlistUrl;

        public MediaPlaylistBundle(HlsMasterPlaylist.HlsUrl hlsUrl) {
            this.playlistUrl = hlsUrl;
            this.mediaPlaylistLoadable = new ParsingLoadable<>(HlsPlaylistTracker.this.dataSourceFactory.createDataSource(4), UriUtil.resolveToUri(HlsPlaylistTracker.this.masterPlaylist.baseUri, hlsUrl.url), 4, HlsPlaylistTracker.this.playlistParser);
        }

        private boolean blacklistPlaylist() {
            this.blacklistUntilMs = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.this.notifyPlaylistBlacklisting(this.playlistUrl, 60000L);
            if (HlsPlaylistTracker.this.primaryHlsUrl == this.playlistUrl && !HlsPlaylistTracker.this.maybeSelectNewPrimaryUrl()) {
                return true;
            }
            return false;
        }

        private void loadPlaylistImmediately() {
            this.mediaPlaylistLoader.startLoading(this.mediaPlaylistLoadable, this, HlsPlaylistTracker.this.minRetryCount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processLoadedPlaylist(HlsMediaPlaylist hlsMediaPlaylist) {
            HlsMediaPlaylist hlsMediaPlaylist2 = this.playlistSnapshot;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.lastSnapshotLoadMs = elapsedRealtime;
            HlsMediaPlaylist latestPlaylistSnapshot = HlsPlaylistTracker.this.getLatestPlaylistSnapshot(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.playlistSnapshot = latestPlaylistSnapshot;
            if (latestPlaylistSnapshot != hlsMediaPlaylist2) {
                this.playlistError = null;
                this.lastSnapshotChangeMs = elapsedRealtime;
                HlsPlaylistTracker.this.onPlaylistUpdated(this.playlistUrl, latestPlaylistSnapshot);
            } else if (!latestPlaylistSnapshot.hasEndTag) {
                if (hlsMediaPlaylist.mediaSequence + hlsMediaPlaylist.segments.size() < this.playlistSnapshot.mediaSequence) {
                    this.playlistError = new PlaylistResetException(this.playlistUrl.url);
                } else if (elapsedRealtime - this.lastSnapshotChangeMs > C.usToMs(r12.targetDurationUs) * HlsPlaylistTracker.PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT) {
                    this.playlistError = new PlaylistStuckException(this.playlistUrl.url);
                    blacklistPlaylist();
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist3 = this.playlistSnapshot;
            long j3 = hlsMediaPlaylist3.targetDurationUs;
            if (hlsMediaPlaylist3 == hlsMediaPlaylist2) {
                j3 /= 2;
            }
            this.earliestNextLoadTimeMs = elapsedRealtime + C.usToMs(j3);
            if (this.playlistUrl == HlsPlaylistTracker.this.primaryHlsUrl && !this.playlistSnapshot.hasEndTag) {
                loadPlaylist();
            }
        }

        public HlsMediaPlaylist getPlaylistSnapshot() {
            return this.playlistSnapshot;
        }

        public boolean isSnapshotValid() {
            int i3;
            if (this.playlistSnapshot == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, C.usToMs(this.playlistSnapshot.durationUs));
            HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
            if (!hlsMediaPlaylist.hasEndTag && (i3 = hlsMediaPlaylist.playlistType) != 2 && i3 != 1 && this.lastSnapshotLoadMs + max <= elapsedRealtime) {
                return false;
            }
            return true;
        }

        public void loadPlaylist() {
            this.blacklistUntilMs = 0L;
            if (!this.loadPending && !this.mediaPlaylistLoader.isLoading()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.earliestNextLoadTimeMs) {
                    this.loadPending = true;
                    HlsPlaylistTracker.this.playlistRefreshHandler.postDelayed(this, this.earliestNextLoadTimeMs - elapsedRealtime);
                } else {
                    loadPlaylistImmediately();
                }
            }
        }

        public void maybeThrowPlaylistRefreshError() throws IOException {
            this.mediaPlaylistLoader.maybeThrowError();
            IOException iOException = this.playlistError;
            if (iOException == null) {
            } else {
                throw iOException;
            }
        }

        public void release() {
            this.mediaPlaylistLoader.release();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.loadPending = false;
            loadPlaylistImmediately();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j3, long j16, boolean z16) {
            HlsPlaylistTracker.this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, 4, j3, j16, parsingLoadable.bytesLoaded());
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j3, long j16) {
            HlsPlaylist result = parsingLoadable.getResult();
            if (result instanceof HlsMediaPlaylist) {
                processLoadedPlaylist((HlsMediaPlaylist) result);
                HlsPlaylistTracker.this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, 4, j3, j16, parsingLoadable.bytesLoaded());
            } else {
                this.playlistError = new ParserException("Loaded playlist has unexpected type.");
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public int onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j3, long j16, IOException iOException) {
            boolean z16 = iOException instanceof ParserException;
            HlsPlaylistTracker.this.eventDispatcher.loadError(parsingLoadable.dataSpec, 4, j3, j16, parsingLoadable.bytesLoaded(), iOException, z16);
            if (z16) {
                return 3;
            }
            return ChunkedTrackBlacklistUtil.shouldBlacklist(iOException) ? blacklistPlaylist() : true ? 0 : 2;
        }
    }

    /* loaded from: classes2.dex */
    public interface PlaylistEventListener {
        void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j3);

        void onPlaylistChanged();
    }

    /* loaded from: classes2.dex */
    public static final class PlaylistResetException extends IOException {
        public final String url;

        PlaylistResetException(String str) {
            this.url = str;
        }
    }

    /* loaded from: classes2.dex */
    public static final class PlaylistStuckException extends IOException {
        public final String url;

        PlaylistStuckException(String str) {
            this.url = str;
        }
    }

    /* loaded from: classes2.dex */
    public interface PrimaryPlaylistListener {
        void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist);
    }

    public HlsPlaylistTracker(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, MediaSourceEventListener.EventDispatcher eventDispatcher, int i3, PrimaryPlaylistListener primaryPlaylistListener, ParsingLoadable.Parser<HlsPlaylist> parser) {
        this.initialPlaylistUri = uri;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.eventDispatcher = eventDispatcher;
        this.minRetryCount = i3;
        this.primaryPlaylistListener = primaryPlaylistListener;
        this.playlistParser = parser;
    }

    private void createBundles(List<HlsMasterPlaylist.HlsUrl> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            HlsMasterPlaylist.HlsUrl hlsUrl = list.get(i3);
            this.playlistBundles.put(hlsUrl, new MediaPlaylistBundle(hlsUrl));
        }
    }

    private static HlsMediaPlaylist.Segment getFirstOldOverlappingSegment(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i3 = (int) (hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence);
        List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
        if (i3 < list.size()) {
            return list.get(i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HlsMediaPlaylist getLatestPlaylistSnapshot(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (!hlsMediaPlaylist2.isNewerThan(hlsMediaPlaylist)) {
            if (hlsMediaPlaylist2.hasEndTag) {
                return hlsMediaPlaylist.copyWithEndTag();
            }
            return hlsMediaPlaylist;
        }
        return hlsMediaPlaylist2.copyWith(getLoadedPlaylistStartTimeUs(hlsMediaPlaylist, hlsMediaPlaylist2), getLoadedPlaylistDiscontinuitySequence(hlsMediaPlaylist, hlsMediaPlaylist2));
    }

    private int getLoadedPlaylistDiscontinuitySequence(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i3;
        if (hlsMediaPlaylist2.hasDiscontinuitySequence) {
            return hlsMediaPlaylist2.discontinuitySequence;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryUrlSnapshot;
        if (hlsMediaPlaylist3 != null) {
            i3 = hlsMediaPlaylist3.discontinuitySequence;
        } else {
            i3 = 0;
        }
        if (hlsMediaPlaylist == null) {
            return i3;
        }
        HlsMediaPlaylist.Segment firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (firstOldOverlappingSegment != null) {
            return (hlsMediaPlaylist.discontinuitySequence + firstOldOverlappingSegment.relativeDiscontinuitySequence) - hlsMediaPlaylist2.segments.get(0).relativeDiscontinuitySequence;
        }
        return i3;
    }

    private long getLoadedPlaylistStartTimeUs(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        long j3;
        if (hlsMediaPlaylist2.hasProgramDateTime) {
            return hlsMediaPlaylist2.startTimeUs;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryUrlSnapshot;
        if (hlsMediaPlaylist3 != null) {
            j3 = hlsMediaPlaylist3.startTimeUs;
        } else {
            j3 = 0;
        }
        if (hlsMediaPlaylist == null) {
            return j3;
        }
        int size = hlsMediaPlaylist.segments.size();
        HlsMediaPlaylist.Segment firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (firstOldOverlappingSegment != null) {
            return hlsMediaPlaylist.startTimeUs + firstOldOverlappingSegment.relativeStartTimeUs;
        }
        if (size == hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence) {
            return hlsMediaPlaylist.getEndTimeUs();
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeSelectNewPrimaryUrl() {
        List<HlsMasterPlaylist.HlsUrl> list = this.masterPlaylist.variants;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i3 = 0; i3 < size; i3++) {
            MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(list.get(i3));
            if (elapsedRealtime > mediaPlaylistBundle.blacklistUntilMs) {
                this.primaryHlsUrl = mediaPlaylistBundle.playlistUrl;
                mediaPlaylistBundle.loadPlaylist();
                return true;
            }
        }
        return false;
    }

    private void maybeSetPrimaryUrl(HlsMasterPlaylist.HlsUrl hlsUrl) {
        if (hlsUrl != this.primaryHlsUrl && this.masterPlaylist.variants.contains(hlsUrl)) {
            HlsMediaPlaylist hlsMediaPlaylist = this.primaryUrlSnapshot;
            if (hlsMediaPlaylist == null || !hlsMediaPlaylist.hasEndTag) {
                this.primaryHlsUrl = hlsUrl;
                this.playlistBundles.get(hlsUrl).loadPlaylist();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPlaylistBlacklisting(HlsMasterPlaylist.HlsUrl hlsUrl, long j3) {
        int size = this.listeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.listeners.get(i3).onPlaylistBlacklisted(hlsUrl, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlaylistUpdated(HlsMasterPlaylist.HlsUrl hlsUrl, HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsUrl == this.primaryHlsUrl) {
            if (this.primaryUrlSnapshot == null) {
                this.isLive = !hlsMediaPlaylist.hasEndTag;
                this.initialStartTimeUs = hlsMediaPlaylist.startTimeUs;
            }
            this.primaryUrlSnapshot = hlsMediaPlaylist;
            this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(hlsMediaPlaylist);
        }
        int size = this.listeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.listeners.get(i3).onPlaylistChanged();
        }
    }

    public void addListener(PlaylistEventListener playlistEventListener) {
        this.listeners.add(playlistEventListener);
    }

    public long getInitialStartTimeUs() {
        return this.initialStartTimeUs;
    }

    public HlsMasterPlaylist getMasterPlaylist() {
        return this.masterPlaylist;
    }

    public HlsMediaPlaylist getPlaylistSnapshot(HlsMasterPlaylist.HlsUrl hlsUrl) {
        HlsMediaPlaylist playlistSnapshot = this.playlistBundles.get(hlsUrl).getPlaylistSnapshot();
        if (playlistSnapshot != null) {
            maybeSetPrimaryUrl(hlsUrl);
        }
        return playlistSnapshot;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public boolean isSnapshotValid(HlsMasterPlaylist.HlsUrl hlsUrl) {
        return this.playlistBundles.get(hlsUrl).isSnapshotValid();
    }

    public void maybeThrowPlaylistRefreshError(HlsMasterPlaylist.HlsUrl hlsUrl) throws IOException {
        this.playlistBundles.get(hlsUrl).maybeThrowPlaylistRefreshError();
    }

    public void maybeThrowPrimaryPlaylistRefreshError() throws IOException {
        this.initialPlaylistLoader.maybeThrowError();
        HlsMasterPlaylist.HlsUrl hlsUrl = this.primaryHlsUrl;
        if (hlsUrl != null) {
            maybeThrowPlaylistRefreshError(hlsUrl);
        }
    }

    public void refreshPlaylist(HlsMasterPlaylist.HlsUrl hlsUrl) {
        this.playlistBundles.get(hlsUrl).loadPlaylist();
    }

    public void release() {
        this.initialPlaylistLoader.release();
        Iterator<MediaPlaylistBundle> it = this.playlistBundles.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.playlistRefreshHandler.removeCallbacksAndMessages(null);
        this.playlistBundles.clear();
    }

    public void removeListener(PlaylistEventListener playlistEventListener) {
        this.listeners.remove(playlistEventListener);
    }

    public void start() {
        this.initialPlaylistLoader.startLoading(new ParsingLoadable(this.dataSourceFactory.createDataSource(4), this.initialPlaylistUri, 4, this.playlistParser), this, this.minRetryCount);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j3, long j16, boolean z16) {
        this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, 4, j3, j16, parsingLoadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j3, long j16) {
        HlsMasterPlaylist hlsMasterPlaylist;
        HlsPlaylist result = parsingLoadable.getResult();
        boolean z16 = result instanceof HlsMediaPlaylist;
        if (z16) {
            hlsMasterPlaylist = HlsMasterPlaylist.createSingleVariantMasterPlaylist(result.baseUri);
        } else {
            hlsMasterPlaylist = (HlsMasterPlaylist) result;
        }
        this.masterPlaylist = hlsMasterPlaylist;
        this.primaryHlsUrl = hlsMasterPlaylist.variants.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hlsMasterPlaylist.variants);
        arrayList.addAll(hlsMasterPlaylist.audios);
        arrayList.addAll(hlsMasterPlaylist.subtitles);
        createBundles(arrayList);
        MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(this.primaryHlsUrl);
        if (z16) {
            mediaPlaylistBundle.processLoadedPlaylist((HlsMediaPlaylist) result);
        } else {
            mediaPlaylistBundle.loadPlaylist();
        }
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, 4, j3, j16, parsingLoadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j3, long j16, IOException iOException) {
        boolean z16 = iOException instanceof ParserException;
        this.eventDispatcher.loadError(parsingLoadable.dataSpec, 4, j3, j16, parsingLoadable.bytesLoaded(), iOException, z16);
        return z16 ? 3 : 0;
    }
}
