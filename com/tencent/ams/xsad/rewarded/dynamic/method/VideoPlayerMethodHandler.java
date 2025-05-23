package com.tencent.ams.xsad.rewarded.dynamic.method;

import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.xsad.rewarded.RewardedAdError;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.utils.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VideoPlayerMethodHandler implements DKMethodHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final RewardedAdListener f71806d;

    /* renamed from: e, reason: collision with root package name */
    private long f71807e;

    /* loaded from: classes3.dex */
    @interface PlayerEventId {
        public static final int COMPLETE = 4;
        public static final int ERROR = 5;
        public static final int INTERRUPT = 9;
        public static final int PAUSE = 2;
        public static final int RESUME = 3;
        public static final int START = 1;
    }

    /* loaded from: classes3.dex */
    private @interface VideoPlayerEvent {
        public static final String ON_PLAY_PROGRESS_CHANGED = "onPlayProgressChanged";
        public static final String ON_PLAY_STATUS_CHANGED = "onPlayStatusChanged";
    }

    public VideoPlayerMethodHandler(RewardedAdListener rewardedAdListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rewardedAdListener);
        } else {
            this.f71806d = rewardedAdListener;
        }
    }

    private void c(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (jSONObject != null) {
            long optDouble = (long) (jSONObject.optDouble("position") * 1000.0d);
            this.f71807e = optDouble;
            RewardedAdListener rewardedAdListener = this.f71806d;
            if (rewardedAdListener != null) {
                rewardedAdListener.Od((int) optDouble);
            }
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("VideoPlayerMethodHandler", "handleVideoPlayStatusChanged, params: " + jSONObject);
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("eventId");
            this.f71807e = ((long) jSONObject.optDouble("timeOffset")) * 1000;
            RewardedAdListener rewardedAdListener = this.f71806d;
            if (rewardedAdListener != null) {
                if (optInt != 1) {
                    if (optInt != 2) {
                        if (optInt != 3) {
                            if (optInt != 4) {
                                if (optInt == 5) {
                                    rewardedAdListener.L7(new RewardedAdError(205, "play failed"));
                                }
                            } else {
                                rewardedAdListener.onAdPlayComplete();
                            }
                        } else {
                            rewardedAdListener.onAdPlayResume();
                        }
                    } else {
                        rewardedAdListener.onAdPlayPause();
                    }
                } else {
                    rewardedAdListener.onAdPlayStart();
                }
            }
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void e(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c(jSONObject, callback);
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f71807e;
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "VideoPlayer";
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, dKEngine, str, jSONObject, callback)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            c.e("VideoPlayerMethodHandler", "methodName is empty.");
            return false;
        }
        str.hashCode();
        if (!str.equals("onPlayStatusChanged")) {
            if (!str.equals(VideoPlayerEvent.ON_PLAY_PROGRESS_CHANGED)) {
                return false;
            }
            e(jSONObject, callback);
            return true;
        }
        DynamicUtils.runOnUiThread(new Runnable(jSONObject, callback) { // from class: com.tencent.ams.xsad.rewarded.dynamic.method.VideoPlayerMethodHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ JSONObject f71808d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ DKMethodHandler.Callback f71809e;

            {
                this.f71808d = jSONObject;
                this.f71809e = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VideoPlayerMethodHandler.this, jSONObject, callback);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    VideoPlayerMethodHandler.this.d(this.f71808d, this.f71809e);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        return true;
    }
}
