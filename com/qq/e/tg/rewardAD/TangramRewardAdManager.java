package com.qq.e.tg.rewardAD;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.IEGRVADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.TGRVOI;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.JSONUtilStub;
import com.qq.e.tg.rewardAD.RewardConstants;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramRewardAdManager {
    public static final int REWARD_INTERFACE_V1 = 2;
    public static final int REWARD_INTERFACE_V2 = 1;
    public static final int VIDEO_PLAY_ERROR = 5003;

    /* renamed from: a, reason: collision with root package name */
    private static String f40636a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40637b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<Integer, WeakReference<IEGRVADI>> f40638c;

    /* renamed from: d, reason: collision with root package name */
    private static ProgressDialog f40639d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ExtInfo {

        /* renamed from: a, reason: collision with root package name */
        int f40664a;

        /* renamed from: b, reason: collision with root package name */
        long f40665b;

        /* renamed from: c, reason: collision with root package name */
        int f40666c;

        public long getCostTime() {
            return this.f40665b;
        }

        public int getErrorCode() {
            return this.f40666c;
        }

        public int getInterfaceId() {
            return this.f40664a;
        }

        public void setCostTime(long j3) {
            this.f40665b = j3;
        }

        public void setErrorCode(int i3) {
            this.f40666c = i3;
        }

        public void setInterfaceId(int i3) {
            this.f40664a = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface InitCallback {
        void onInitError();

        void onInitSuccess();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class PosParams {

        /* renamed from: a, reason: collision with root package name */
        private String f40667a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f40668b;

        /* renamed from: c, reason: collision with root package name */
        private LoadAdParams f40669c;

        /* renamed from: d, reason: collision with root package name */
        private int f40670d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f40671e = true;

        /* renamed from: f, reason: collision with root package name */
        private String f40672f;

        /* renamed from: g, reason: collision with root package name */
        private String f40673g;

        /* renamed from: h, reason: collision with root package name */
        private String f40674h;

        /* renamed from: i, reason: collision with root package name */
        private String f40675i;

        /* renamed from: j, reason: collision with root package name */
        private String f40676j;

        /* renamed from: k, reason: collision with root package name */
        private String f40677k;

        /* renamed from: l, reason: collision with root package name */
        private String f40678l;

        /* renamed from: m, reason: collision with root package name */
        private String f40679m;

        /* renamed from: n, reason: collision with root package name */
        private String f40680n;

        /* renamed from: o, reason: collision with root package name */
        private String f40681o;

        /* renamed from: p, reason: collision with root package name */
        private String f40682p;

        /* renamed from: q, reason: collision with root package name */
        private Map<String, String> f40683q;

        /* renamed from: r, reason: collision with root package name */
        private RewardAdLoadingCallback f40684r;

        /* renamed from: s, reason: collision with root package name */
        private String f40685s;

        public Map getExposurePassThroughInfo() {
            return this.f40683q;
        }

        public int getGainRewardTime() {
            return this.f40670d;
        }

        public LoadAdParams getLoadAdParams() {
            return this.f40669c;
        }

        public String getOneMoreAdTips() {
            return this.f40685s;
        }

        public String getPageCancelButtonText() {
            return this.f40681o;
        }

        public String getPageConfirmButtonText() {
            return this.f40680n;
        }

        public String getPageDialogText() {
            return this.f40679m;
        }

        public String getPageHasDoneTipsText() {
            return this.f40675i;
        }

        public String getPageUnmetTipsText() {
            return this.f40674h;
        }

        public String getPosId() {
            return this.f40667a;
        }

        public RewardAdLoadingCallback getRewardAdLoadingCallback() {
            return this.f40684r;
        }

        public String getVideoCancelButtonText() {
            return this.f40678l;
        }

        public String getVideoConfirmButtonText() {
            return this.f40677k;
        }

        public String getVideoDialogText() {
            return this.f40676j;
        }

        public String getVideoHasDoneTipsText() {
            return this.f40673g;
        }

        public String getVideoShorterThanRewardLeftTopText() {
            return this.f40682p;
        }

        public String getVideoUnmetTipsText() {
            return this.f40672f;
        }

        public boolean isShowProgressBySdk() {
            return this.f40668b;
        }

        public boolean isVolumeOn() {
            return this.f40671e;
        }

        public void setExposurePassThroughInfo(Map<String, String> map) {
            this.f40683q = map;
        }

        public void setGainRewardTime(int i3) {
            this.f40670d = i3;
        }

        public void setLoadAdParams(LoadAdParams loadAdParams) {
            this.f40669c = loadAdParams;
        }

        public void setOneMoreAdTips(String str) {
            this.f40685s = str;
        }

        public void setPageCancelButtonText(String str) {
            this.f40681o = str;
        }

        public void setPageConfirmButtonText(String str) {
            this.f40680n = str;
        }

        public void setPageDialogText(String str) {
            this.f40679m = str;
        }

        public void setPageHasDoneTipsText(String str) {
            this.f40675i = str;
        }

        public void setPageUnmetTipsText(String str) {
            this.f40674h = str;
        }

        public void setPosId(String str) {
            this.f40667a = str;
        }

        public void setRewardAdLoadingCallback(RewardAdLoadingCallback rewardAdLoadingCallback) {
            this.f40684r = rewardAdLoadingCallback;
        }

        public void setShowProgressBySdk(boolean z16) {
            this.f40668b = z16;
        }

        public void setVideoCancelButtonText(String str) {
            this.f40678l = str;
        }

        public void setVideoConfirmButtonText(String str) {
            this.f40677k = str;
        }

        public void setVideoDialogText(String str) {
            this.f40676j = str;
        }

        public void setVideoHasDoneTipsText(String str) {
            this.f40673g = str;
        }

        public void setVideoShorterThanRewardLeftTopText(String str) {
            this.f40682p = str;
        }

        public void setVideoUnmetTipsText(String str) {
            this.f40672f = str;
        }

        public void setVolumeOn(boolean z16) {
            this.f40671e = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class RealTimeLoadAdListener implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private Context f40686a;

        /* renamed from: b, reason: collision with root package name */
        private String f40687b;

        /* renamed from: c, reason: collision with root package name */
        private PosParams f40688c;

        /* renamed from: d, reason: collision with root package name */
        private TangramRewardAdCallback f40689d;

        public RealTimeLoadAdListener(Context context, String str, PosParams posParams, TangramRewardAdCallback tangramRewardAdCallback) {
            this.f40686a = context;
            this.f40687b = str;
            this.f40688c = posParams;
            this.f40689d = tangramRewardAdCallback;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            final IEGRVADI b16 = TangramRewardAdManager.b(aDEvent);
            switch (aDEvent.getType()) {
                case 1:
                    TangramRewardAdManager.a(aDEvent, b16, this.f40687b, this.f40688c);
                    return;
                case 2:
                case 4:
                case 7:
                case 11:
                case 12:
                case 14:
                default:
                    return;
                case 3:
                    TangramRewardAdManager.b(b16, RewardConstants.EventId.TANGRAM_REWARD_AD_SHOW_SUCCESS, 0, 0, 0, 0L);
                    return;
                case 5:
                    TangramRewardAdCallback tangramRewardAdCallback = this.f40689d;
                    if (tangramRewardAdCallback != null) {
                        tangramRewardAdCallback.onReward();
                        return;
                    }
                    return;
                case 6:
                    TangramRewardAdCallback tangramRewardAdCallback2 = this.f40689d;
                    if (tangramRewardAdCallback2 != null) {
                        try {
                            tangramRewardAdCallback2.onClick();
                            return;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 8:
                    TangramRewardAdCallback tangramRewardAdCallback3 = this.f40689d;
                    if (tangramRewardAdCallback3 != null) {
                        tangramRewardAdCallback3.onAdClose();
                    }
                    if (b16 != null) {
                        TangramRewardAdManager.a().remove(Integer.valueOf(b16.hashCode()));
                    }
                    a();
                    return;
                case 9:
                    TangramRewardAdManager.a(aDEvent, this.f40689d, this.f40687b, this.f40688c, this.f40686a);
                    return;
                case 10:
                    TangramRewardAdManager.a(this.f40686a, this.f40687b, b16, this.f40689d, this.f40688c);
                    return;
                case 13:
                    TangramRewardAdCallback tangramRewardAdCallback4 = this.f40689d;
                    if (tangramRewardAdCallback4 != null) {
                        tangramRewardAdCallback4.onCancel();
                        return;
                    }
                    return;
                case 15:
                    PosParams posParams = this.f40688c;
                    if (b16 != null && aDEvent.getParas() != null && aDEvent.getParas().length == 3) {
                        int intValue = ((Integer) aDEvent.getParas()[0]).intValue();
                        int intValue2 = ((Integer) aDEvent.getParas()[1]).intValue();
                        JSONObject jSONObject = (JSONObject) aDEvent.getParas()[2];
                        if (JSONUtilStub.notNull(jSONObject)) {
                            GDTLogger.d("RewardTangramRewardAdManageradIndex =" + intValue + "isLoadFromCache ==" + intValue2 + "adData = " + jSONObject.toString());
                            if (intValue == 0 && !b16.isShownSuccess()) {
                                TangramRewardAdManager.a(jSONObject.toString(), b16, posParams);
                                b16.reportEvent(RewardConstants.EventId.TANGRAM_REWARD_REALTIME_SHOW_FIRST_AD, 0, null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 16:
                    if (this.f40689d != null && aDEvent.getParas() != null && aDEvent.getParas().length == 3) {
                        Object obj = aDEvent.getParas()[0];
                        Object obj2 = aDEvent.getParas()[1];
                        Object obj3 = aDEvent.getParas()[2];
                        RewardResult rewardResult = new RewardResult();
                        if ((obj instanceof Boolean) && (obj2 instanceof String) && (obj3 instanceof Integer)) {
                            rewardResult.a(((Boolean) obj).booleanValue());
                            rewardResult.a(((Integer) obj3).intValue());
                            rewardResult.a((String) obj2);
                        }
                        this.f40689d.onReward(rewardResult);
                        return;
                    }
                    return;
                case 17:
                    GDTLogger.d("LoadingProgress show");
                    PosParams posParams2 = this.f40688c;
                    if (posParams2 != null && posParams2.getRewardAdLoadingCallback() != null) {
                        try {
                            Context context = this.f40686a;
                            if (context != null) {
                                ((Activity) context).runOnUiThread(new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.RealTimeLoadAdListener.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        RealTimeLoadAdListener.this.f40688c.getRewardAdLoadingCallback().onShowLoading();
                                    }
                                });
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                    ProgressDialog unused = TangramRewardAdManager.f40639d = TangramRewardAdManager.b(this.f40686a, this.f40688c);
                    if (TangramRewardAdManager.f40639d != null) {
                        TangramRewardAdManager.f40639d.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.RealTimeLoadAdListener.2
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                IEGRVADI iegrvadi = b16;
                                if (iegrvadi != null) {
                                    iegrvadi.cancelShowAd();
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 18:
                    a();
                    return;
            }
        }

        private void a() {
            GDTLogger.d("LoadingProgress hide");
            PosParams posParams = this.f40688c;
            if (posParams != null && posParams.getRewardAdLoadingCallback() != null) {
                try {
                    this.f40688c.getRewardAdLoadingCallback().onDissmissLoading();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            a(TangramRewardAdManager.f40639d);
        }

        private void a(final ProgressDialog progressDialog) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.RealTimeLoadAdListener.3
                @Override // java.lang.Runnable
                public void run() {
                    ProgressDialog progressDialog2 = progressDialog;
                    if (progressDialog2 != null && progressDialog2.isShowing()) {
                        progressDialog.dismiss();
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface RewardAdLoadingCallback {
        void onDissmissLoading();

        void onShowLoading();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface TangramRewardAdCallback {
        void onAdClose();

        void onAdShown();

        void onCancel();

        void onClick();

        void onError(int i3, int i16, String str);

        @Deprecated
        void onReward();

        void onReward(RewardResult rewardResult);

        void onStartShow(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface TangramRewardAdPreloadCallback {
        void onAdDataLoadSuccess(String str, String[] strArr);

        void onPreloadError(String str, int i3, int i16, String str2);

        void onPreloadSuccess(String str, int i3);
    }

    private static synchronized Map<Integer, WeakReference<IEGRVADI>> c() {
        Map<Integer, WeakReference<IEGRVADI>> map;
        synchronized (TangramRewardAdManager.class) {
            if (f40638c == null) {
                f40638c = new HashMap();
            }
            map = f40638c;
        }
        return map;
    }

    public static void cancelShowAd(int i3) {
        if (c().containsKey(Integer.valueOf(i3)) && c().get(Integer.valueOf(i3)) != null && c().get(Integer.valueOf(i3)).get() != null) {
            c().get(Integer.valueOf(i3)).get().cancelShowAd();
        }
    }

    public static void cleanAdCache(Context context) {
        IEGRVADI b16 = b(context, "", null);
        if (b16 != null) {
            b16.cleanAdCache();
        }
    }

    public static void deleteOldVideoCache(Context context, long j3) {
        IEGRVADI b16 = b(context, "", null);
        if (b16 != null) {
            b16.deleteOldVideoCache(context, j3);
        }
    }

    public static Map<String, List<TGRVOI>> getPosOrderListFromCache(Context context, String str) {
        a(context, str, (InitCallback) null);
        IEGRVADI b16 = b(context, "", null);
        if (b16 == null) {
            return null;
        }
        return b16.getPosOrderListFromCache();
    }

    public static boolean hasPreloadedAd(Context context, String str) {
        IEGRVADI b16 = b(context, str, null);
        if (b16 != null) {
            return b16.hasPreloadedAd(str);
        }
        return false;
    }

    public static boolean isVideoCacheExist(String str) {
        File downladVideoFile;
        if (TextUtils.isEmpty(str) || (downladVideoFile = FileUtil.getDownladVideoFile(str)) == null) {
            return false;
        }
        return downladVideoFile.exists();
    }

    public static void preloadAd(final Context context, String str, final PosParams posParams, final TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback) {
        if (posParams == null) {
            return;
        }
        a(context, str, new InitCallback() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.4
            @Override // com.qq.e.tg.rewardAD.TangramRewardAdManager.InitCallback
            public final void onInitError() {
                TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback2 = tangramRewardAdPreloadCallback;
                if (tangramRewardAdPreloadCallback2 != null) {
                    tangramRewardAdPreloadCallback2.onPreloadError("", 6001, 6001, "sdk\u521d\u59cb\u5316\u9519\u8bef");
                }
            }

            @Override // com.qq.e.tg.rewardAD.TangramRewardAdManager.InitCallback
            public final void onInitSuccess() {
                TangramRewardAdManager.a(context, posParams.getPosId(), posParams.getLoadAdParams(), tangramRewardAdPreloadCallback, 1);
            }
        });
    }

    public static boolean reportEventToAdServer(Context context, String str, int i3, ExtInfo extInfo) {
        IEGRVADI b16 = b(context, str, null);
        if (b16 == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(i3));
        if (extInfo != null) {
            hashMap.put("cost_time", Long.valueOf(extInfo.f40665b));
            hashMap.put("interface_id", Integer.valueOf(extInfo.f40664a));
            hashMap.put("error_code", Integer.valueOf(extInfo.f40666c));
        }
        b16.reportEvent(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_EVENT_REPORT_BY_FLOW, 0, hashMap);
        return true;
    }

    public static void showAd(final Context context, String str, final PosParams posParams, final TangramRewardAdCallback tangramRewardAdCallback) {
        if (context != null && posParams != null) {
            a(context, str, new InitCallback() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.7
                @Override // com.qq.e.tg.rewardAD.TangramRewardAdManager.InitCallback
                public final void onInitError() {
                    TangramRewardAdCallback tangramRewardAdCallback2 = tangramRewardAdCallback;
                    if (tangramRewardAdCallback2 != null) {
                        tangramRewardAdCallback2.onError(6001, 6001, "sdk\u521d\u59cb\u5316\u9519\u8bef");
                    }
                }

                @Override // com.qq.e.tg.rewardAD.TangramRewardAdManager.InitCallback
                public final void onInitSuccess() {
                    IEGRVADI b16 = TangramRewardAdManager.b(context, posParams.getPosId(), new RealTimeLoadAdListener(context, posParams.getPosId(), posParams, tangramRewardAdCallback));
                    if (b16 == null) {
                        a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6000, "showAd delegate \u4e3a\u7a7a");
                        return;
                    }
                    b16.showAD(context, posParams.getPosId(), posParams, tangramRewardAdCallback);
                    if (tangramRewardAdCallback != null) {
                        int hashCode = b16.hashCode();
                        TangramRewardAdManager.a().put(Integer.valueOf(hashCode), new WeakReference(b16));
                        tangramRewardAdCallback.onStartShow(hashCode);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProgressDialog b(Context context, PosParams posParams) {
        Activity activity;
        if (posParams != null && posParams.isShowProgressBySdk()) {
            try {
                activity = (Activity) context;
            } catch (Exception e16) {
                e16.printStackTrace();
                activity = null;
            }
            if (activity == null) {
                return null;
            }
            ReportProgressDialog reportProgressDialog = new ReportProgressDialog(activity);
            reportProgressDialog.setMessage("\u6b63\u5728\u51c6\u5907\u5e7f\u544a\uff0c\u8bf7\u7a0d\u540e");
            reportProgressDialog.setCancelable(true);
            reportProgressDialog.setProgressStyle(0);
            reportProgressDialog.setIndeterminate(false);
            try {
                reportProgressDialog.show();
                return reportProgressDialog;
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void c(ADEvent aDEvent, String str, TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback, int i3) {
        int i16;
        int i17;
        int i18 = 0;
        if (aDEvent.getParas() != null) {
            Object[] paras = aDEvent.getParas();
            if (paras.length > 0) {
                Object obj = paras[0];
                if (obj instanceof Integer) {
                    i17 = ((Integer) obj).intValue();
                    if (paras.length > 1) {
                        Object obj2 = paras[1];
                        if (obj2 instanceof Integer) {
                            i18 = ((Integer) obj2).intValue();
                        }
                    }
                    i16 = i18;
                    i18 = i17;
                }
            }
            i17 = 0;
            if (paras.length > 1) {
            }
            i16 = i18;
            i18 = i17;
        } else {
            i16 = 0;
        }
        IEGRVADI b16 = b(aDEvent);
        if (b16 != null) {
            b(b16, RewardConstants.EventId.TANGRAM_REWARD_VIDEO_PRELOAD_AD_FAIL, i3, i18, i16, 0L);
        } else {
            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6000, "onPreloadAdError delegate \u4e3a\u7a7a");
        }
        if (tangramRewardAdPreloadCallback != null) {
            AdError formatRewardErrorCode = AdErrorConvertor.formatRewardErrorCode(i18, i16);
            tangramRewardAdPreloadCallback.onPreloadError(str, formatRewardErrorCode.getErrorCode(), formatRewardErrorCode.getSubErrorCode(), formatRewardErrorCode.getErrorMsg());
        }
    }

    public static void preloadAd(final Context context, String str, final List<PosParams> list, final TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback) {
        if (list == null || list.size() == 0) {
            return;
        }
        a(context, str, new InitCallback() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.3
            @Override // com.qq.e.tg.rewardAD.TangramRewardAdManager.InitCallback
            public final void onInitError() {
                TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback2 = tangramRewardAdPreloadCallback;
                if (tangramRewardAdPreloadCallback2 != null) {
                    tangramRewardAdPreloadCallback2.onPreloadError("", 6001, 6001, "sdk\u521d\u59cb\u5316\u9519\u8bef");
                }
            }

            @Override // com.qq.e.tg.rewardAD.TangramRewardAdManager.InitCallback
            public final void onInitSuccess() {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    PosParams posParams = (PosParams) list.get(i3);
                    TangramRewardAdManager.a(context, posParams.getPosId(), posParams.getLoadAdParams(), tangramRewardAdPreloadCallback, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IEGRVADI b(Context context, String str, ADListener aDListener) {
        String str2;
        try {
            POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.REWARD_AD);
            if (pOFactory != null) {
                return pOFactory.gettangramrewardVideoADDelegate(context, f40636a, str, aDListener);
            }
            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6001, "poFactory\u4e3a\u7a7a");
            return null;
        } catch (com.qq.e.comm.managers.plugin.a unused) {
            str2 = "poFactory\u521d\u59cb\u5316pe\u5f02\u5e38";
            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6001, str2);
            return null;
        } catch (Throwable unused2) {
            str2 = "poFactory\u521d\u59cb\u5316\u672a\u77e5\u5f02\u5e38";
            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6001, str2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IEGRVADI b(ADEvent aDEvent) {
        if (aDEvent instanceof RewardAdEvent) {
            return ((RewardAdEvent) aDEvent).getDelegate();
        }
        return null;
    }

    static /* synthetic */ Map a() {
        return c();
    }

    static /* synthetic */ void b(final ADEvent aDEvent, final String str, final TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback, int i3) {
        final IEGRVADI b16 = b(aDEvent);
        if (b16 == null) {
            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6000, "onPreloadAdCached delegate \u4e3a\u7a7a");
        } else {
            b(b16, RewardConstants.EventId.TANGRAM_REWARD_VIDEO_PRELOAD_AD_CACHED_SUCCESS, i3, 0, 0, 0L);
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (ADEvent.this.getParas() != null && (ADEvent.this.getParas() instanceof String[])) {
                        GDTLogger.d("RewardTangramRewardAdManageronPreloadAdCached onPreloadSuccess");
                        String[] strArr = (String[]) ADEvent.this.getParas();
                        b16.checkAndRemoveOldVideoCache();
                        GDTLogger.d("RewardTangramRewardAdManageronPreloadAdCached checkAndRemoveOldVideoCache success");
                        TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback2 = tangramRewardAdPreloadCallback;
                        if (tangramRewardAdPreloadCallback2 != null) {
                            tangramRewardAdPreloadCallback2.onPreloadSuccess(str, strArr.length);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(IEGRVADI iegrvadi, int i3, int i16, int i17, int i18, long j3) {
        if (iegrvadi != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", Integer.valueOf(i17));
            hashMap.put("error_code", Integer.valueOf(i18));
            hashMap.put("cost_time", Long.valueOf(j3));
            iegrvadi.reportEvent(i3, i16, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final InitCallback initCallback) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.2
            @Override // java.lang.Runnable
            public final void run() {
                InitCallback initCallback2 = InitCallback.this;
                if (initCallback2 != null) {
                    initCallback2.onInitSuccess();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, final String str, LoadAdParams loadAdParams, final TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback, final int i3) {
        IEGRVADI b16 = b(context, str, new ADListener() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.5
            @Override // com.qq.e.comm.adevent.ADListener
            public final void onADEvent(ADEvent aDEvent) {
                int type = aDEvent.getType();
                if (type != 1) {
                    if (type != 2) {
                        if (type == 9) {
                            TangramRewardAdManager.c(aDEvent, str, tangramRewardAdPreloadCallback, i3);
                            return;
                        }
                        return;
                    }
                    TangramRewardAdManager.b(aDEvent, str, tangramRewardAdPreloadCallback, i3);
                    return;
                }
                TangramRewardAdManager.a(aDEvent, str, tangramRewardAdPreloadCallback, i3);
            }
        });
        if (b16 == null) {
            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6000, "preloadAd delegate \u4e3a\u7a7a");
        } else {
            b16.preloadAd(context, str, loadAdParams, i3);
        }
    }

    static /* synthetic */ void a(Context context, String str, IEGRVADI iegrvadi, TangramRewardAdCallback tangramRewardAdCallback, PosParams posParams) {
        if (iegrvadi != null) {
            iegrvadi.onAdShow(posParams);
        }
        if (tangramRewardAdCallback != null) {
            tangramRewardAdCallback.onAdShown();
        }
    }

    private static synchronized void a(final Context context, final String str, final InitCallback initCallback) {
        synchronized (TangramRewardAdManager.class) {
            if (context == null) {
                return;
            }
            if (f40637b) {
                if (initCallback != null) {
                    b(initCallback);
                }
            } else {
                f40636a = str;
                GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (GDTADManager.getInstance().initWith(context, str)) {
                            TangramRewardAdManager.a(true);
                            TangramRewardAdManager.b(initCallback);
                            TangramRewardAdManager.cleanAdCache(context);
                        } else {
                            InitCallback initCallback2 = initCallback;
                            if (initCallback2 != null) {
                                initCallback2.onInitError();
                            }
                            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6002, "\u63d2\u4ef6\u521d\u59cb\u5316\u5f02\u5e38");
                        }
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(final ADEvent aDEvent, final IEGRVADI iegrvadi, final String str, final PosParams posParams) {
        if (iegrvadi == null) {
            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6000, "onRealTimeCallError delegate \u4e3a\u7a7a");
        }
        GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAdManager.8
            @Override // java.lang.Runnable
            public final void run() {
                if (ADEvent.this.getParas() != null && (ADEvent.this.getParas() instanceof String[])) {
                    String[] strArr = (String[]) ADEvent.this.getParas();
                    GDTLogger.d("RewardTangramRewardAdManager\u5b9e\u65f6\u62c9\u53d6\u6210\u529f\uff0c\u7f13\u5b58\u5230\u672c\u5730");
                    HashMap hashMap = new HashMap();
                    if (strArr != null) {
                        hashMap.put("count", Integer.valueOf(strArr.length));
                    }
                    iegrvadi.reportEvent(RewardConstants.EventId.TANGRAM_REWARD_REALTIME_LOAD_SUCCESS, 0, hashMap);
                    if (!iegrvadi.isShownSuccess()) {
                        if (strArr == null || strArr.length <= 0) {
                            TangramRewardAdManager.b(iegrvadi, RewardConstants.EventId.TANGRAM_REWARD_VIDEO_NET_SELECT_AD_FAIL, 0, 50010, 0, 0L);
                            GDTLogger.d("RewardTangramRewardAdManager\u7f51\u7edc\u8fd4\u56de\u5e7f\u544a\u4e2a\u6570\u4e3a\u7a7a\uff0c\u5c55\u793a\u672c\u5730\u9009\u5355");
                            iegrvadi.showLocalOrder(str, posParams);
                            return;
                        } else {
                            TangramRewardAdManager.a(strArr[0], iegrvadi, posParams);
                            iegrvadi.updateNativeOrderCache(str, strArr);
                            return;
                        }
                    }
                    GDTLogger.d("RewardTangramRewardAdManager\u7f51\u7edc\u5e7f\u544a\u8fd4\u56de\u8d85\u65f6\uff0c\u5df2\u5c55\u793a\u672c\u5730\u9009\u5355");
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void a(ADEvent aDEvent, TangramRewardAdCallback tangramRewardAdCallback, String str, PosParams posParams, Context context) {
        int i3;
        int i16;
        int i17;
        IEGRVADI b16 = b(aDEvent);
        if (b16 == null) {
            a.a(RewardConstants.EventId.TANGRAM_REWARD_VIDEO_INIT_ERROR, 6000, "onRealTimeCallError  delegate \u4e3a\u7a7a");
            return;
        }
        int i18 = 0;
        if (aDEvent.getParas() != null) {
            Object[] paras = aDEvent.getParas();
            if (paras.length > 0) {
                Object obj = paras[0];
                if (obj instanceof Integer) {
                    i17 = ((Integer) obj).intValue();
                    if (paras.length > 1) {
                        Object obj2 = paras[1];
                        if (obj2 instanceof Integer) {
                            i18 = ((Integer) obj2).intValue();
                        }
                    }
                    i3 = i17;
                    i16 = i18;
                }
            }
            i17 = 0;
            if (paras.length > 1) {
            }
            i3 = i17;
            i16 = i18;
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (i3 == 5001 || i3 == 5002) {
            GDTLogger.d("RewardTangramRewardAdManager\u5e7f\u544a\u52a0\u8f7d\u5931\u8d25\uff0c\u5c55\u793a\u672c\u5730\u9009\u5355");
            b(b16, RewardConstants.EventId.TANGRAM_REWARD_VIDEO_NET_SELECT_AD_FAIL, 0, i3, i16, 0L);
            b16.showLocalOrder(str, posParams);
        } else if (i3 == 5003) {
            b(b16, RewardConstants.EventId.TANGRAM_REWARD_VIDEO_AD_SHOW_ERROR, 0, i3, i16, 0L);
            a(context, str, posParams != null ? posParams.f40669c : null, (TangramRewardAdPreloadCallback) null, 2);
        }
        c().remove(Integer.valueOf(b16.hashCode()));
        if (tangramRewardAdCallback == null || i3 != 5003) {
            return;
        }
        AdError formatRewardErrorCode = AdErrorConvertor.formatRewardErrorCode(i3, i16);
        tangramRewardAdCallback.onError(formatRewardErrorCode.getErrorCode(), formatRewardErrorCode.getSubErrorCode(), formatRewardErrorCode.getErrorMsg());
    }

    static /* synthetic */ void a(ADEvent aDEvent, String str, TangramRewardAdPreloadCallback tangramRewardAdPreloadCallback, int i3) {
        if (b(aDEvent) == null || aDEvent.getParas() == null || !(aDEvent.getParas() instanceof String[])) {
            return;
        }
        String[] strArr = (String[]) aDEvent.getParas();
        GDTLogger.d("RewardTangramRewardAdManageronPreloadAdCached updateNativeOrderCache");
        IEGRVADI b16 = b(aDEvent);
        if (b16 != null) {
            b(b16, RewardConstants.EventId.TANGRAM_REWARD_VIDEO_PRELOAD_AD_SUCCESS, i3, 0, 0, 0L);
            b16.updateNativeOrderCache(str, strArr);
        }
        if (tangramRewardAdPreloadCallback != null) {
            tangramRewardAdPreloadCallback.onAdDataLoadSuccess(str, strArr);
        }
    }

    static /* synthetic */ void a(String str, IEGRVADI iegrvadi, PosParams posParams) {
        if (iegrvadi != null) {
            b(iegrvadi, RewardConstants.EventId.TANGRAM_REWARD_VIDEO_NET_SELECT_AD_SUCCESS, 0, iegrvadi.isNetworkSelectOrderTimeout() ? 1 : 0, 0, 0L);
            GDTLogger.d("RewardTangramRewardAdManager\u5c55\u793a\u5b9e\u65f6\u9009\u5355");
            iegrvadi.showLoadedAd(str, posParams, 2);
        }
    }

    static /* synthetic */ boolean a(boolean z16) {
        f40637b = true;
        return true;
    }
}
