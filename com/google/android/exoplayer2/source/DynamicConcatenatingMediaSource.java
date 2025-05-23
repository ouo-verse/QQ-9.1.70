package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DynamicConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> implements PlayerMessage.Target {
    private static final int MSG_ADD = 0;
    private static final int MSG_ADD_MULTIPLE = 1;
    private static final int MSG_MOVE = 3;
    private static final int MSG_ON_COMPLETION = 4;
    private static final int MSG_REMOVE = 2;
    private final List<DeferredMediaPeriod> deferredMediaPeriods;
    private final boolean isAtomic;
    private MediaSource.Listener listener;
    private final Map<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod;
    private final List<MediaSourceHolder> mediaSourceHolders;
    private final List<MediaSource> mediaSourcesPublic;
    private int periodCount;
    private ExoPlayer player;
    private boolean preventListenerNotification;
    private final MediaSourceHolder query;
    private ShuffleOrder shuffleOrder;
    private int windowCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        private final SparseIntArray childIndexByUid;
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final Timeline[] timelines;
        private final int[] uids;
        private final int windowCount;

        public ConcatenatedTimeline(Collection<MediaSourceHolder> collection, int i3, int i16, ShuffleOrder shuffleOrder, boolean z16) {
            super(z16, shuffleOrder);
            this.windowCount = i3;
            this.periodCount = i16;
            int size = collection.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new int[size];
            this.childIndexByUid = new SparseIntArray();
            int i17 = 0;
            for (MediaSourceHolder mediaSourceHolder : collection) {
                this.timelines[i17] = mediaSourceHolder.timeline;
                this.firstPeriodInChildIndices[i17] = mediaSourceHolder.firstPeriodIndexInChild;
                this.firstWindowInChildIndices[i17] = mediaSourceHolder.firstWindowIndexInChild;
                int[] iArr = this.uids;
                int i18 = mediaSourceHolder.uid;
                iArr[i17] = i18;
                this.childIndexByUid.put(i18, i17);
                i17++;
            }
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByChildUid(Object obj) {
            int i3;
            if (!(obj instanceof Integer) || (i3 = this.childIndexByUid.get(((Integer) obj).intValue(), -1)) == -1) {
                return -1;
            }
            return i3;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByPeriodIndex(int i3) {
            return Util.binarySearchFloor(this.firstPeriodInChildIndices, i3 + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByWindowIndex(int i3) {
            return Util.binarySearchFloor(this.firstWindowInChildIndices, i3 + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected Object getChildUidByChildIndex(int i3) {
            return Integer.valueOf(this.uids[i3]);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstPeriodIndexByChildIndex(int i3) {
            return this.firstPeriodInChildIndices[i3];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstWindowIndexByChildIndex(int i3) {
            return this.firstWindowInChildIndices[i3];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.periodCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected Timeline getTimelineByChildIndex(int i3) {
            return this.timelines[i3];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.windowCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class DeferredTimeline extends ForwardingTimeline {
        private final Object replacedId;
        private static final Object DUMMY_ID = new Object();
        private static final Timeline.Period period = new Timeline.Period();
        private static final DummyTimeline dummyTimeline = new DummyTimeline();

        public DeferredTimeline() {
            this(dummyTimeline, null);
        }

        public DeferredTimeline cloneWithNewTimeline(Timeline timeline) {
            Object obj;
            if (this.replacedId == null && timeline.getPeriodCount() > 0) {
                obj = timeline.getPeriod(0, period, true).uid;
            } else {
                obj = this.replacedId;
            }
            return new DeferredTimeline(timeline, obj);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            Timeline timeline = this.timeline;
            if (DUMMY_ID.equals(obj)) {
                obj = this.replacedId;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i3, Timeline.Period period2, boolean z16) {
            this.timeline.getPeriod(i3, period2, z16);
            if (Util.areEqual(period2.uid, this.replacedId)) {
                period2.uid = DUMMY_ID;
            }
            return period2;
        }

        public Timeline getTimeline() {
            return this.timeline;
        }

        DeferredTimeline(Timeline timeline, Object obj) {
            super(timeline);
            this.replacedId = obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class DummyTimeline extends Timeline {
        DummyTimeline() {
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            if (obj == null) {
                return 0;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i3, Timeline.Period period, boolean z16) {
            return period.set(null, null, 0, -9223372036854775807L, -9223372036854775807L);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i3, Timeline.Window window, boolean z16, long j3) {
            return window.set(null, -9223372036854775807L, -9223372036854775807L, false, true, 0L, -9223372036854775807L, 0, 0, 0L);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class EventDispatcher {
        public final Handler eventHandler;
        public final Runnable runnable;

        public EventDispatcher(Runnable runnable) {
            Looper mainLooper;
            this.runnable = runnable;
            if (Looper.myLooper() != null) {
                mainLooper = Looper.myLooper();
            } else {
                mainLooper = Looper.getMainLooper();
            }
            this.eventHandler = new Handler(mainLooper);
        }

        public void dispatchEvent() {
            this.eventHandler.post(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class MediaSourceHolder implements Comparable<MediaSourceHolder> {
        public int activeMediaPeriods;
        public int childIndex;
        public int firstPeriodIndexInChild;
        public int firstWindowIndexInChild;
        public boolean isPrepared;
        public boolean isRemoved;
        public final MediaSource mediaSource;
        public DeferredTimeline timeline;
        public final int uid = System.identityHashCode(this);

        public MediaSourceHolder(MediaSource mediaSource, DeferredTimeline deferredTimeline, int i3, int i16, int i17) {
            this.mediaSource = mediaSource;
            this.timeline = deferredTimeline;
            this.childIndex = i3;
            this.firstWindowIndexInChild = i16;
            this.firstPeriodIndexInChild = i17;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull MediaSourceHolder mediaSourceHolder) {
            return this.firstPeriodIndexInChild - mediaSourceHolder.firstPeriodIndexInChild;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class MessageData<T> {

        @Nullable
        public final EventDispatcher actionOnCompletion;
        public final T customData;
        public final int index;

        public MessageData(int i3, T t16, @Nullable Runnable runnable) {
            EventDispatcher eventDispatcher;
            this.index = i3;
            if (runnable != null) {
                eventDispatcher = new EventDispatcher(runnable);
            } else {
                eventDispatcher = null;
            }
            this.actionOnCompletion = eventDispatcher;
            this.customData = t16;
        }
    }

    public DynamicConcatenatingMediaSource() {
        this(false, new ShuffleOrder.DefaultShuffleOrder(0));
    }

    private void addMediaSourceInternal(int i3, MediaSource mediaSource) {
        MediaSourceHolder mediaSourceHolder;
        DeferredTimeline deferredTimeline = new DeferredTimeline();
        if (i3 > 0) {
            MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i3 - 1);
            mediaSourceHolder = new MediaSourceHolder(mediaSource, deferredTimeline, i3, mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.timeline.getWindowCount(), mediaSourceHolder2.firstPeriodIndexInChild + mediaSourceHolder2.timeline.getPeriodCount());
        } else {
            mediaSourceHolder = new MediaSourceHolder(mediaSource, deferredTimeline, 0, 0, 0);
        }
        correctOffsets(i3, 1, deferredTimeline.getWindowCount(), deferredTimeline.getPeriodCount());
        this.mediaSourceHolders.add(i3, mediaSourceHolder);
        prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
    }

    private void addMediaSourcesInternal(int i3, Collection<MediaSource> collection) {
        Iterator<MediaSource> it = collection.iterator();
        while (it.hasNext()) {
            addMediaSourceInternal(i3, it.next());
            i3++;
        }
    }

    private void correctOffsets(int i3, int i16, int i17, int i18) {
        this.windowCount += i17;
        this.periodCount += i18;
        while (i3 < this.mediaSourceHolders.size()) {
            this.mediaSourceHolders.get(i3).childIndex += i16;
            this.mediaSourceHolders.get(i3).firstWindowIndexInChild += i17;
            this.mediaSourceHolders.get(i3).firstPeriodIndexInChild += i18;
            i3++;
        }
    }

    private int findMediaSourceHolderByPeriodIndex(int i3) {
        MediaSourceHolder mediaSourceHolder = this.query;
        mediaSourceHolder.firstPeriodIndexInChild = i3;
        int binarySearch = Collections.binarySearch(this.mediaSourceHolders, mediaSourceHolder);
        if (binarySearch < 0) {
            return (-binarySearch) - 2;
        }
        while (binarySearch < this.mediaSourceHolders.size() - 1) {
            int i16 = binarySearch + 1;
            if (this.mediaSourceHolders.get(i16).firstPeriodIndexInChild != i3) {
                break;
            }
            binarySearch = i16;
        }
        return binarySearch;
    }

    private void maybeNotifyListener(@Nullable EventDispatcher eventDispatcher) {
        if (!this.preventListenerNotification) {
            this.listener.onSourceInfoRefreshed(this, new ConcatenatedTimeline(this.mediaSourceHolders, this.windowCount, this.periodCount, this.shuffleOrder, this.isAtomic), null);
            if (eventDispatcher != null) {
                this.player.createMessage(this).setType(4).setPayload(eventDispatcher).send();
            }
        }
    }

    private void moveMediaSourceInternal(int i3, int i16) {
        int min = Math.min(i3, i16);
        int max = Math.max(i3, i16);
        int i17 = this.mediaSourceHolders.get(min).firstWindowIndexInChild;
        int i18 = this.mediaSourceHolders.get(min).firstPeriodIndexInChild;
        List<MediaSourceHolder> list = this.mediaSourceHolders;
        list.add(i16, list.remove(i3));
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(min);
            mediaSourceHolder.firstWindowIndexInChild = i17;
            mediaSourceHolder.firstPeriodIndexInChild = i18;
            i17 += mediaSourceHolder.timeline.getWindowCount();
            i18 += mediaSourceHolder.timeline.getPeriodCount();
            min++;
        }
    }

    private void removeMediaSourceInternal(int i3) {
        MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i3);
        this.mediaSourceHolders.remove(i3);
        DeferredTimeline deferredTimeline = mediaSourceHolder.timeline;
        correctOffsets(i3, -1, -deferredTimeline.getWindowCount(), -deferredTimeline.getPeriodCount());
        mediaSourceHolder.isRemoved = true;
        if (mediaSourceHolder.activeMediaPeriods == 0) {
            releaseChildSource(mediaSourceHolder);
        }
    }

    private void updateMediaSourceInternal(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        if (mediaSourceHolder != null) {
            DeferredTimeline deferredTimeline = mediaSourceHolder.timeline;
            if (deferredTimeline.getTimeline() == timeline) {
                return;
            }
            int windowCount = timeline.getWindowCount() - deferredTimeline.getWindowCount();
            int periodCount = timeline.getPeriodCount() - deferredTimeline.getPeriodCount();
            if (windowCount != 0 || periodCount != 0) {
                correctOffsets(mediaSourceHolder.childIndex + 1, 0, windowCount, periodCount);
            }
            mediaSourceHolder.timeline = deferredTimeline.cloneWithNewTimeline(timeline);
            if (!mediaSourceHolder.isPrepared) {
                for (int size = this.deferredMediaPeriods.size() - 1; size >= 0; size--) {
                    if (this.deferredMediaPeriods.get(size).mediaSource == mediaSourceHolder.mediaSource) {
                        this.deferredMediaPeriods.get(size).createPeriod();
                        this.deferredMediaPeriods.remove(size);
                    }
                }
            }
            mediaSourceHolder.isPrepared = true;
            maybeNotifyListener(null);
            return;
        }
        throw new IllegalArgumentException();
    }

    public synchronized void addMediaSource(MediaSource mediaSource) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, null);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection) {
        addMediaSources(this.mediaSourcesPublic.size(), collection, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        MediaPeriod createPeriod;
        MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(findMediaSourceHolderByPeriodIndex(mediaPeriodId.periodIndex));
        MediaSource.MediaPeriodId copyWithPeriodIndex = mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex - mediaSourceHolder.firstPeriodIndexInChild);
        if (!mediaSourceHolder.isPrepared) {
            createPeriod = new DeferredMediaPeriod(mediaSourceHolder.mediaSource, copyWithPeriodIndex, allocator);
            this.deferredMediaPeriods.add(createPeriod);
        } else {
            createPeriod = mediaSourceHolder.mediaSource.createPeriod(copyWithPeriodIndex, allocator);
        }
        this.mediaSourceByMediaPeriod.put(createPeriod, mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriods++;
        return createPeriod;
    }

    public synchronized MediaSource getMediaSource(int i3) {
        return this.mediaSourcesPublic.get(i3);
    }

    public synchronized int getSize() {
        return this.mediaSourcesPublic.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i3, Object obj) throws ExoPlaybackException {
        EventDispatcher eventDispatcher;
        if (i3 == 4) {
            ((EventDispatcher) obj).dispatchEvent();
            return;
        }
        this.preventListenerNotification = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        MessageData messageData = (MessageData) obj;
                        ShuffleOrder cloneAndRemove = this.shuffleOrder.cloneAndRemove(messageData.index);
                        this.shuffleOrder = cloneAndRemove;
                        this.shuffleOrder = cloneAndRemove.cloneAndInsert(((Integer) messageData.customData).intValue(), 1);
                        moveMediaSourceInternal(messageData.index, ((Integer) messageData.customData).intValue());
                        eventDispatcher = messageData.actionOnCompletion;
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    MessageData messageData2 = (MessageData) obj;
                    this.shuffleOrder = this.shuffleOrder.cloneAndRemove(messageData2.index);
                    removeMediaSourceInternal(messageData2.index);
                    eventDispatcher = messageData2.actionOnCompletion;
                }
            } else {
                MessageData messageData3 = (MessageData) obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData3.index, ((Collection) messageData3.customData).size());
                addMediaSourcesInternal(messageData3.index, (Collection) messageData3.customData);
                eventDispatcher = messageData3.actionOnCompletion;
            }
        } else {
            MessageData messageData4 = (MessageData) obj;
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData4.index, 1);
            addMediaSourceInternal(messageData4.index, (MediaSource) messageData4.customData);
            eventDispatcher = messageData4.actionOnCompletion;
        }
        this.preventListenerNotification = false;
        maybeNotifyListener(eventDispatcher);
    }

    public synchronized void moveMediaSource(int i3, int i16) {
        moveMediaSource(i3, i16, null);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public synchronized void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        super.prepareSource(exoPlayer, z16, listener);
        this.player = exoPlayer;
        this.listener = listener;
        this.preventListenerNotification = true;
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
        addMediaSourcesInternal(0, this.mediaSourcesPublic);
        this.preventListenerNotification = false;
        maybeNotifyListener(null);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder remove = this.mediaSourceByMediaPeriod.remove(mediaPeriod);
        if (mediaPeriod instanceof DeferredMediaPeriod) {
            this.deferredMediaPeriods.remove(mediaPeriod);
            ((DeferredMediaPeriod) mediaPeriod).releasePeriod();
        } else {
            remove.mediaSource.releasePeriod(mediaPeriod);
        }
        int i3 = remove.activeMediaPeriods - 1;
        remove.activeMediaPeriods = i3;
        if (i3 == 0 && remove.isRemoved) {
            releaseChildSource(remove);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        super.releaseSource();
        this.mediaSourceHolders.clear();
        this.player = null;
        this.listener = null;
        this.shuffleOrder = this.shuffleOrder.cloneAndClear();
        this.windowCount = 0;
        this.periodCount = 0;
    }

    public synchronized void removeMediaSource(int i3) {
        removeMediaSource(i3, null);
    }

    public DynamicConcatenatingMediaSource(boolean z16) {
        this(z16, new ShuffleOrder.DefaultShuffleOrder(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        updateMediaSourceInternal(mediaSourceHolder, timeline);
    }

    public DynamicConcatenatingMediaSource(boolean z16, ShuffleOrder shuffleOrder) {
        this.shuffleOrder = shuffleOrder;
        this.mediaSourceByMediaPeriod = new IdentityHashMap();
        this.mediaSourcesPublic = new ArrayList();
        this.mediaSourceHolders = new ArrayList();
        this.deferredMediaPeriods = new ArrayList(1);
        this.query = new MediaSourceHolder(null, null, -1, -1, -1);
        this.isAtomic = z16;
    }

    public synchronized void addMediaSource(MediaSource mediaSource, @Nullable Runnable runnable) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, runnable);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection, @Nullable Runnable runnable) {
        addMediaSources(this.mediaSourcesPublic.size(), collection, runnable);
    }

    public synchronized void moveMediaSource(int i3, int i16, @Nullable Runnable runnable) {
        if (i3 == i16) {
            return;
        }
        List<MediaSource> list = this.mediaSourcesPublic;
        list.add(i16, list.remove(i3));
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.createMessage(this).setType(3).setPayload(new MessageData(i3, Integer.valueOf(i16), runnable)).send();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized void removeMediaSource(int i3, @Nullable Runnable runnable) {
        this.mediaSourcesPublic.remove(i3);
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.createMessage(this).setType(2).setPayload(new MessageData(i3, null, runnable)).send();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized void addMediaSource(int i3, MediaSource mediaSource) {
        addMediaSource(i3, mediaSource, null);
    }

    public synchronized void addMediaSources(int i3, Collection<MediaSource> collection) {
        addMediaSources(i3, collection, null);
    }

    public synchronized void addMediaSource(int i3, MediaSource mediaSource, @Nullable Runnable runnable) {
        Assertions.checkNotNull(mediaSource);
        Assertions.checkArgument(!this.mediaSourcesPublic.contains(mediaSource));
        this.mediaSourcesPublic.add(i3, mediaSource);
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.createMessage(this).setType(0).setPayload(new MessageData(i3, mediaSource, runnable)).send();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized void addMediaSources(int i3, Collection<MediaSource> collection, @Nullable Runnable runnable) {
        Iterator<MediaSource> it = collection.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            MediaSource next = it.next();
            Assertions.checkNotNull(next);
            if (this.mediaSourcesPublic.contains(next)) {
                z16 = false;
            }
            Assertions.checkArgument(z16);
        }
        this.mediaSourcesPublic.addAll(i3, collection);
        if (this.player != null && !collection.isEmpty()) {
            this.player.createMessage(this).setType(1).setPayload(new MessageData(i3, collection, runnable)).send();
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
