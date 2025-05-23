package com.tencent.mobileqq.qqlive.data.datareport;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class StatisticData {
    static IPatchRedirector $redirector_;
    public int appCpu;
    public int downLoss;
    public ArrayList<LocalStatisticsData> localArray;
    public long receiveBytes;
    public int rtt;
    public long sendBytes;
    public int systemCpu;
    public int upLoss;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class LocalStatisticsData {
        static IPatchRedirector $redirector_;
        public int audioBitrate;
        public int audioCaptureState;
        public int audioSampleRate;
        public int frameRate;
        public int height;
        public int streamType;
        public int videoBitrate;
        public int width;

        public LocalStatisticsData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "LocalStatisticsData{width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + ", videoBitrate=" + this.videoBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioBitrate=" + this.audioBitrate + ", streamType=" + this.streamType + ", audioCaptureState=" + this.audioCaptureState + '}';
        }
    }

    public StatisticData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "StatisticData{appCpu=" + this.appCpu + ", systemCpu=" + this.systemCpu + ", rtt=" + this.rtt + ", upLoss=" + this.upLoss + ", downLoss=" + this.downLoss + ", sendBytes=" + this.sendBytes + ", receiveBytes=" + this.receiveBytes + ", localArray=" + this.localArray + '}';
    }
}
