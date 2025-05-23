package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class GroupLiveTRTCStatistics {
    static IPatchRedirector $redirector_;
    public int appCpu;
    public int downLoss;
    public int gatewayRtt;
    public ArrayList<GroupLiveTRTCLocalStatistics> localArray;
    public long receiveBytes;
    public ArrayList<GroupLiveTRTCRemoteStatistics> remoteArray;
    public int rtt;
    public long sendBytes;
    public int systemCpu;
    public int upLoss;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class GroupLiveTRTCLocalStatistics {
        static IPatchRedirector $redirector_;
        public int audioBitrate;
        public int audioCaptureState;
        public int audioSampleRate;
        public int frameRate;
        public int height;
        public int streamType;
        public int videoBitrate;
        public int width;

        public GroupLiveTRTCLocalStatistics() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class GroupLiveTRTCRemoteStatistics {
        static IPatchRedirector $redirector_;
        public int audioBitrate;
        public int audioBlockRate;
        public int audioPacketLoss;
        public int audioSampleRate;
        public int audioTotalBlockTime;
        public int finalLoss;
        public int frameRate;
        public int height;
        public int jitterBufferDelay;
        public int point2PointDelay;
        public int streamType;
        public String userId;
        public int videoBitrate;
        public int videoBlockRate;
        public int videoPacketLoss;
        public int videoTotalBlockTime;
        public int width;

        public GroupLiveTRTCRemoteStatistics() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public GroupLiveTRTCStatistics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
