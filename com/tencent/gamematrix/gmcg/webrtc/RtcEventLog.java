package com.tencent.gamematrix.gmcg.webrtc;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.tencwebrtc.PeerConnection;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RtcEventLog {
    private static final int OUTPUT_FILE_MAX_BYTES = 10000000;
    private static final String TAG = "RtcEventLog";
    private final PeerConnection peerConnection;
    private RtcEventLogState state = RtcEventLogState.INACTIVE;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    enum RtcEventLogState {
        INACTIVE,
        STARTED,
        STOPPED
    }

    public RtcEventLog(PeerConnection peerConnection) {
        if (peerConnection != null) {
            this.peerConnection = peerConnection;
            return;
        }
        throw new NullPointerException("The peer connection is null.");
    }

    public void start() {
        RtcEventLogState rtcEventLogState = this.state;
        RtcEventLogState rtcEventLogState2 = RtcEventLogState.STARTED;
        if (rtcEventLogState == rtcEventLogState2) {
            Log.e(TAG, "RtcEventLog has already started.");
        } else if (!this.peerConnection.startRtcEventLog(-1, 10000000)) {
            Log.e(TAG, "Failed to start RTC event log.");
        } else {
            this.state = rtcEventLogState2;
            Log.d(TAG, "RtcEventLog started.");
        }
    }

    public void stop() {
        if (this.state != RtcEventLogState.STARTED) {
            Log.e(TAG, "RtcEventLog was not started.");
            return;
        }
        this.peerConnection.stopRtcEventLog();
        this.state = RtcEventLogState.STOPPED;
        Log.d(TAG, "RtcEventLog stopped.");
    }

    public void start(File file) {
        RtcEventLogState rtcEventLogState = this.state;
        RtcEventLogState rtcEventLogState2 = RtcEventLogState.STARTED;
        if (rtcEventLogState == rtcEventLogState2) {
            Log.e(TAG, "RtcEventLog has already started.");
            return;
        }
        try {
            if (!this.peerConnection.startRtcEventLog(ParcelFileDescriptor.open(file, 1006632960).detachFd(), 10000000)) {
                Log.e(TAG, "Failed to start RTC event log.");
            } else {
                this.state = rtcEventLogState2;
                Log.d(TAG, "RtcEventLog started.");
            }
        } catch (IOException e16) {
            Log.e(TAG, "Failed to create a new file", e16);
        }
    }
}
