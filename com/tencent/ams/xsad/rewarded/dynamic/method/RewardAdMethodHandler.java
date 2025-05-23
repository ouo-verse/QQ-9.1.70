package com.tencent.ams.xsad.rewarded.dynamic.method;

import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdError;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.event.ModuleEvent;
import com.tencent.ams.xsad.rewarded.utils.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardAdMethodHandler implements DKMethodHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final RewardedAdListener f71801d;

    /* renamed from: e, reason: collision with root package name */
    private final b f71802e;

    /* renamed from: f, reason: collision with root package name */
    private RewardedAdData f71803f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface RewardAdEvent {
        public static final String CLOSE_REWARD_AD = "closeRewardAd";
        public static final String GET_AD_INFO = "getAdInfo";
        public static final String ON_CLOSE_CLICKED = "onCloseClicked";
        public static final String ON_MODULE_EVENT = "onModuleEvent";
        public static final String ON_MUTE_CLICKED = "onMuteClicked";
        public static final String ON_ORIGINAL_EXPOSURE = "onOriginalExposure";
        public static final String ON_SHOW = "onShow";
        public static final String ON_USER_EARNED_REWARD = "onUserEarnedReward";
        public static final String SWITCH_AD_INFO = "switchAdInfo";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements RewardedAdListener.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DKMethodHandler.Callback f71804a;

        a(DKMethodHandler.Callback callback) {
            this.f71804a = callback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardAdMethodHandler.this, (Object) callback);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener.b
        public void a(RewardedAdListener.a aVar) {
            RewardedAdError rewardedAdError;
            RewardedAdData rewardedAdData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            c.c("RewardAdMethodHandler", "switch ad info callback, data: " + aVar);
            DKMethodHandler.Callback callback = this.f71804a;
            if (callback != null) {
                if (aVar != null && (rewardedAdData = aVar.f71724b) != null) {
                    callback.onResult(com.tencent.ams.xsad.rewarded.dynamic.b.a(rewardedAdData));
                } else if (aVar != null && (rewardedAdError = aVar.f71723a) != null) {
                    callback.onFailure(rewardedAdError.a(), aVar.f71723a.b());
                } else {
                    callback.onFailure(-3, null);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    public RewardAdMethodHandler(RewardedAdListener rewardedAdListener, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rewardedAdListener, (Object) bVar);
        } else {
            this.f71801d = rewardedAdListener;
            this.f71802e = bVar;
        }
    }

    private void a(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleCloseRewardAd");
        if (this.f71801d != null) {
            this.f71801d.jb((int) (jSONObject.optDouble(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, 0.0d) * 1000.0d));
        }
        if (callback != null) {
            callback.onResult(null);
        }
        b bVar = this.f71802e;
        if (bVar != null) {
            bVar.a();
        }
    }

    private void b(DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleGetAdInfo");
        String a16 = com.tencent.ams.xsad.rewarded.dynamic.b.a(this.f71803f);
        if (callback != null) {
            callback.onResult(a16);
        }
    }

    private void c(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleModuleEvent, params: " + jSONObject);
        if (jSONObject != null && this.f71801d != null) {
            this.f71801d.K6(new ModuleEvent.b().d(jSONObject.optInt("event")).e(com.tencent.ams.xsad.rewarded.utils.a.a(jSONObject.optJSONObject("eventParams"))).c());
            if (callback != null) {
                callback.onResult(null);
            }
        }
    }

    private void d(DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleOnCloseClicked");
        RewardedAdListener rewardedAdListener = this.f71801d;
        if (rewardedAdListener != null) {
            rewardedAdListener.a5();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void e(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleOnMuteClicked, params: " + jSONObject);
        if (this.f71801d != null && jSONObject != null) {
            this.f71801d.J1(jSONObject.optBoolean("isMute"));
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void f(DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleOnShow");
        RewardedAdListener rewardedAdListener = this.f71801d;
        if (rewardedAdListener != null) {
            rewardedAdListener.we();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void g(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleOnUserEarnedReward");
        RewardedAdListener rewardedAdListener = this.f71801d;
        if (rewardedAdListener != null) {
            rewardedAdListener.yg(j(jSONObject));
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void h(DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleOriginalExposure");
        RewardedAdListener rewardedAdListener = this.f71801d;
        if (rewardedAdListener != null) {
            rewardedAdListener.onOriginalExposure();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void i(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        c.c("RewardAdMethodHandler", "handleSwitchAdInfo, params: " + jSONObject);
        int i3 = 0;
        if (jSONObject != null) {
            i3 = jSONObject.optInt("scene", 0);
        }
        RewardedAdListener rewardedAdListener = this.f71801d;
        if (rewardedAdListener != null) {
            rewardedAdListener.m6(i3, new a(callback));
        }
    }

    private com.tencent.ams.xsad.rewarded.b j(JSONObject jSONObject) {
        com.tencent.ams.xsad.rewarded.b bVar = new com.tencent.ams.xsad.rewarded.b();
        if (jSONObject != null) {
            bVar.f71729a = jSONObject.optString("uniqueKey");
            bVar.f71731c = jSONObject.optInt("rewardStage");
            bVar.f71732d = jSONObject.optInt("stageRewardType");
            bVar.f71730b = jSONObject.optBoolean("isDirectUnlocked");
        }
        return bVar;
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "RewardAd";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0072, code lost:
    
        if (r10.equals(com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler.RewardAdEvent.GET_AD_INFO) == false) goto L14;
     */
    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, dKEngine, str, jSONObject, callback)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            c.e("RewardAdMethodHandler", "methodName is empty.");
            return false;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1388921872:
                if (str.equals(RewardAdEvent.ON_USER_EARNED_REWARD)) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1012968068:
                if (str.equals("onShow")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case -739669969:
                if (str.equals(RewardAdEvent.ON_MODULE_EVENT)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case -388267921:
                if (str.equals(RewardAdEvent.ON_MUTE_CLICKED)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case -293028361:
                if (str.equals(RewardAdEvent.ON_ORIGINAL_EXPOSURE)) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 272711271:
                break;
            case 711559109:
                if (str.equals(RewardAdEvent.SWITCH_AD_INFO)) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1012339146:
                if (str.equals(RewardAdEvent.CLOSE_REWARD_AD)) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1482731150:
                if (str.equals(RewardAdEvent.ON_CLOSE_CLICKED)) {
                    c16 = '\b';
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                g(jSONObject, callback);
                return true;
            case 1:
                f(callback);
                return true;
            case 2:
                c(jSONObject, callback);
                return true;
            case 3:
                e(jSONObject, callback);
                return true;
            case 4:
                h(callback);
                return true;
            case 5:
                b(callback);
                return true;
            case 6:
                i(jSONObject, callback);
                return true;
            case 7:
                a(jSONObject, callback);
                return true;
            case '\b':
                d(callback);
                return true;
            default:
                return false;
        }
    }

    public void k(RewardedAdData rewardedAdData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rewardedAdData);
        } else {
            this.f71803f = rewardedAdData;
        }
    }
}
