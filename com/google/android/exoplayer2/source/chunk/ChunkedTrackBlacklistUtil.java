package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.HttpDataSource;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ChunkedTrackBlacklistUtil {
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    private static final String TAG = "ChunkedTrackBlacklist";

    ChunkedTrackBlacklistUtil() {
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i3, Exception exc) {
        return maybeBlacklistTrack(trackSelection, i3, exc, 60000L);
    }

    public static boolean shouldBlacklist(Exception exc) {
        if (!(exc instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i3 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        if (i3 != 404 && i3 != 410) {
            return false;
        }
        return true;
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i3, Exception exc, long j3) {
        if (!shouldBlacklist(exc)) {
            return false;
        }
        boolean blacklist = trackSelection.blacklist(i3, j3);
        int i16 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        if (blacklist) {
            Log.w(TAG, "Blacklisted: duration=" + j3 + ", responseCode=" + i16 + ", format=" + trackSelection.getFormat(i3));
        } else {
            Log.w(TAG, "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i16 + ", format=" + trackSelection.getFormat(i3));
        }
        return blacklist;
    }
}
