package com.tencent.youtu.ytagreflectlivecheck.requester;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface LiveStyleRequester {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LiveStyleAndroidData {
        static IPatchRedirector $redirector_;
        public float lux;

        public LiveStyleAndroidData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.lux = 0.0f;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SeleceData {
        static IPatchRedirector $redirector_;
        public LiveStyleAndroidData android_data;
        public int change_point_num;
        public int platform;
        public int protocal;
        public String reflect_param;
        public String version;

        public SeleceData(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
                return;
            }
            this.platform = 2;
            this.protocal = 1;
            this.version = YTAGReflectLiveCheckInterface.VERSION;
            this.reflect_param = " version 2 ";
            this.change_point_num = 2;
            LiveStyleAndroidData liveStyleAndroidData = new LiveStyleAndroidData();
            this.android_data = liveStyleAndroidData;
            liveStyleAndroidData.lux = f16;
        }
    }
}
