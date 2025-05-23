package com.tencent.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TRTCStatistics {
    static IPatchRedirector $redirector_;
    public int appCpu;
    public int downLoss;
    public int gatewayRtt;
    public ArrayList<TRTCLocalStatistics> localArray;
    public long receiveBytes;
    public ArrayList<TRTCRemoteStatistics> remoteArray;
    public int rtt;
    public long sendBytes;
    public int systemCpu;
    public int upLoss;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCLocalStatistics {
        static IPatchRedirector $redirector_;
        public int audioBitrate;
        public int audioCaptureState;
        public int audioSampleRate;
        public int frameRate;
        public int height;
        public int streamType;
        public int videoBitrate;
        public int width;

        public TRTCLocalStatistics() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCRemoteStatistics {
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
        public int remoteNetworkRTT;
        public int remoteNetworkUplinkLoss;
        public int streamType;
        public String userId;
        public int videoBitrate;
        public int videoBlockRate;
        public int videoPacketLoss;
        public int videoTotalBlockTime;
        public int width;

        public TRTCRemoteStatistics() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TRTCStatistics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
