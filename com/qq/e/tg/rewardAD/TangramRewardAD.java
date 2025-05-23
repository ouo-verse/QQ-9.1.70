package com.qq.e.tg.rewardAD;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.qq.e.comm.pi.IEGRVADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramRewardAD {

    /* renamed from: a, reason: collision with root package name */
    private TangramRewardADListener f40612a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f40613b;

    /* renamed from: c, reason: collision with root package name */
    private IEGRVADI f40614c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f40615d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f40616e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f40617f;

    /* renamed from: g, reason: collision with root package name */
    private LoadAdParams f40618g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f40619h = true;

    /* renamed from: i, reason: collision with root package name */
    private ICustomAdDataGenerator f40620i;

    /* renamed from: j, reason: collision with root package name */
    private int f40621j;

    /* renamed from: k, reason: collision with root package name */
    private ADListenerAdapter f40622k;

    /* renamed from: l, reason: collision with root package name */
    private String f40623l;

    /* renamed from: m, reason: collision with root package name */
    private RewardDialogContentViewHolder f40624m;

    /* renamed from: n, reason: collision with root package name */
    private String f40625n;

    /* renamed from: o, reason: collision with root package name */
    private String f40626o;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ADListenerAdapter implements ADListener {
        public static final int EVENT_TYPE_ON_AD_CACHED = 2;
        public static final int EVENT_TYPE_ON_AD_CLICK = 6;
        public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
        public static final int EVENT_TYPE_ON_AD_COMPLETE = 7;
        public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
        public static final int EVENT_TYPE_ON_AD_LOADED = 1;
        public static final int EVENT_TYPE_ON_AD_PLAY = 10;
        public static final int EVENT_TYPE_ON_AD_SHOW = 3;
        public static final int EVENT_TYPE_ON_ERROR = 9;
        public static final int EVENT_TYPE_ON_EXTRA_REWARD = 20;
        public static final int EVENT_TYPE_ON_REWARD = 5;
        public static final int EVENT_TYPE_ON_S2S_REWARD_SUCCESS = 16;
        public TangramRewardADListener adListener;
        public JSONObject passThroughData;

        public ADListenerAdapter(TangramRewardADListener tangramRewardADListener) {
            this.adListener = tangramRewardADListener;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
        @Override // com.qq.e.comm.adevent.ADListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onADEvent(ADEvent aDEvent) {
            Object obj;
            Object obj2;
            Object obj3;
            int i3;
            int i16;
            int type = aDEvent.getType();
            Object obj4 = null;
            String str = null;
            int i17 = 0;
            if (type != 16) {
                if (type != 20) {
                    switch (type) {
                        case 1:
                            try {
                                if (aDEvent.getParas() != null && (aDEvent.getParas() instanceof String[])) {
                                    String[] strArr = (String[]) aDEvent.getParas();
                                    if (strArr.length > 0) {
                                        this.passThroughData = new JSONObject(strArr[0]).optJSONObject("pass_through_data");
                                    }
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            this.adListener.onADLoad();
                            return;
                        case 2:
                            this.adListener.onADCached();
                            return;
                        case 3:
                            this.adListener.onADShow();
                            return;
                        case 4:
                            this.adListener.onADExpose();
                            return;
                        case 5:
                            this.adListener.onReward();
                            return;
                        case 6:
                            this.adListener.onADClick();
                            return;
                        case 7:
                            this.adListener.onADComplete();
                            return;
                        case 8:
                            this.adListener.onADClose();
                            return;
                        case 9:
                            if (aDEvent.getParas() != null) {
                                Object[] paras = aDEvent.getParas();
                                if (paras.length > 0) {
                                    Object obj5 = paras[0];
                                    if (obj5 instanceof Integer) {
                                        i16 = ((Integer) obj5).intValue();
                                        if (paras.length > 1) {
                                            Object obj6 = paras[1];
                                            if (obj6 instanceof Integer) {
                                                i17 = ((Integer) obj6).intValue();
                                            }
                                        }
                                        i3 = i17;
                                        i17 = i16;
                                    }
                                }
                                i16 = 0;
                                if (paras.length > 1) {
                                }
                                i3 = i17;
                                i17 = i16;
                            } else {
                                i3 = 0;
                            }
                            this.adListener.onError(AdErrorConvertor.formatRewardErrorCode(i17, i3));
                            return;
                        case 10:
                            if (aDEvent.getParas() != null && aDEvent.getParas().length == 1) {
                                Object obj7 = aDEvent.getParas()[0];
                                if (obj7 instanceof TangramRewardADData) {
                                    this.adListener.onADPlay((TangramRewardADData) obj7);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                if (aDEvent.getParas() != null && aDEvent.getParas().length == 1) {
                    Object obj8 = aDEvent.getParas()[0];
                    TangramRewardADListener tangramRewardADListener = this.adListener;
                    if (tangramRewardADListener instanceof TangramRewardADListenerV2) {
                        if (obj8 instanceof String) {
                            str = (String) obj8;
                        }
                        ((TangramRewardADListenerV2) tangramRewardADListener).onExtraReward(str);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.adListener != null && aDEvent.getParas() != null) {
                if (aDEvent.getParas().length >= 3) {
                    obj = aDEvent.getParas()[0];
                    obj2 = aDEvent.getParas()[1];
                    obj3 = aDEvent.getParas()[2];
                } else {
                    obj = null;
                    obj2 = null;
                    obj3 = null;
                }
                if (aDEvent.getParas().length >= 4) {
                    obj4 = aDEvent.getParas()[3];
                }
                RewardResult rewardResult = new RewardResult();
                if ((obj instanceof Boolean) && (obj2 instanceof String) && (obj3 instanceof Integer)) {
                    rewardResult.a(((Boolean) obj).booleanValue());
                    rewardResult.a(((Integer) obj3).intValue());
                    rewardResult.a((String) obj2);
                }
                if (obj4 instanceof Integer) {
                    rewardResult.setUserMaxGradientRewardLevel(((Integer) obj4).intValue());
                }
                try {
                    this.adListener.onReward(rewardResult);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    public TangramRewardAD(final Context context, final String str, final String str2, final TangramRewardADListener tangramRewardADListener) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && tangramRewardADListener != null) {
            this.f40612a = tangramRewardADListener;
            this.f40615d = true;
            this.f40616e = true;
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.REWARD_AD);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            TangramRewardAD.this.f40622k = new ADListenerAdapter(tangramRewardADListener);
                                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                            TangramRewardAD tangramRewardAD = TangramRewardAD.this;
                                            tangramRewardAD.f40614c = pOFactory.gettangramrewardVideoADDelegate(context, str, str2, tangramRewardAD.f40622k);
                                            TangramRewardAD.this.f40614c.setVideoVolumeOn(TangramRewardAD.this.f40619h);
                                            TangramRewardAD.this.f40614c.setCustomAdDataGenerator(TangramRewardAD.this.f40620i);
                                            TangramRewardAD.this.f40614c.setGainRewardTime(TangramRewardAD.this.f40621j);
                                            TangramRewardAD.this.f40614c.setOneMoreAdTips(TangramRewardAD.this.f40623l);
                                            TangramRewardAD.this.f40614c.setRewardDialogContentViewHolder(TangramRewardAD.this.f40624m);
                                            TangramRewardAD.this.f40614c.setCustomExtraRewardInfo(TangramRewardAD.this.f40625n);
                                            TangramRewardAD.this.f40614c.setCustomGradientRewardInfo(TangramRewardAD.this.f40626o);
                                            TangramRewardAD.a(TangramRewardAD.this, true);
                                            if (TangramRewardAD.this.f40617f) {
                                                TangramRewardAD.this.loadAD();
                                                return;
                                            }
                                            return;
                                        }
                                        TangramRewardAD.a(TangramRewardAD.this, 2001);
                                    } catch (Throwable th5) {
                                        GDTLogger.e("Exception while init Core", th5);
                                        TangramRewardAD.a(TangramRewardAD.this, 2001);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th5) {
                            GDTLogger.e("Exception while init Reward AD Core", th5);
                        }
                    }
                    TangramRewardAD.a(TangramRewardAD.this, 2001);
                }
            });
            return;
        }
        GDTLogger.e(String.format("TangramRewardAD Constructor params error, context=%s, appID=%s, posID=%s, TangramRewardADListener=%s", context, str, str2, tangramRewardADListener));
    }

    public int getECPM() {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi != null) {
            return iegrvadi.getECPM();
        }
        GDTLogger.e("please invoke getECPM method after callback \"onADLoad\" ");
        return -1;
    }

    public String getECPMLevel() {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi != null) {
            return iegrvadi.getECPMLevel();
        }
        GDTLogger.e("please invoke getECPMLevel method after callback \"onADLoad\" ");
        return null;
    }

    public long getExpireTimestamp() {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi != null) {
            return iegrvadi.getExpireTimestamp();
        }
        GDTLogger.e("please invoke getExpireTimestamp method after callback \"onADLoad\" ");
        return 0L;
    }

    public JSONObject getPassThroughData() {
        ADListenerAdapter aDListenerAdapter = this.f40622k;
        if (aDListenerAdapter == null) {
            return null;
        }
        return aDListenerAdapter.passThroughData;
    }

    public boolean hasShown() {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi != null) {
            return iegrvadi.hasShown();
        }
        GDTLogger.e("please invoke hasShown method after callback \"onADLoad\" ");
        return false;
    }

    public void loadAD() {
        if (this.f40615d && this.f40616e) {
            if (!this.f40613b) {
                this.f40617f = true;
                return;
            }
            IEGRVADI iegrvadi = this.f40614c;
            if (iegrvadi != null) {
                iegrvadi.setLoadAdParams(this.f40618g);
                this.f40614c.loadAD();
                return;
            } else {
                GDTLogger.e("Tangram Reward AD Init error, see more logs");
                return;
            }
        }
        GDTLogger.e("AD init Params OR Context error, details in logs produced while init TangramRewardAD");
    }

    public void setCloseDialogTips(String str, String str2, String str3) throws Exception {
        setRewardADCloseDialogTips(str, str2, str3, null, null, null);
    }

    public void setCustomAdDataGenerator(ICustomAdDataGenerator iCustomAdDataGenerator) {
        this.f40620i = iCustomAdDataGenerator;
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            return;
        }
        iegrvadi.setCustomAdDataGenerator(iCustomAdDataGenerator);
    }

    public void setCustomExtraRewardInfo(String str) {
        this.f40625n = str;
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            return;
        }
        iegrvadi.setCustomExtraRewardInfo(str);
    }

    public void setCustomGradientRewardInfo(String str) {
        this.f40626o = str;
        GDTLogger.i("setCustomGradientRewardInfo = " + str);
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            return;
        }
        iegrvadi.setCustomGradientRewardInfo(str);
    }

    public void setExposurePassThroughInfo(Map<String, String> map) {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            GDTLogger.e("please invoke setSlot method after callback \"onADLoad\" ");
        } else {
            iegrvadi.setExposurePassThroughInfo(map);
        }
    }

    public void setGainRewardTime(int i3) {
        if (i3 < 10 || i3 > 60) {
            GDTLogger.e("\u6fc0\u52b1\u65f6\u957f\u8bbe\u7f6e\u65e0\u6548\uff0c\u6709\u6548\u533a\u95f4\u4e3a10-60\u79d2");
        }
        this.f40621j = i3;
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            return;
        }
        iegrvadi.setGainRewardTime(i3);
    }

    public void setLeftTopTips(String str, String str2) throws Exception {
        setRewardADTopTips(str, str2, null, null);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f40618g = loadAdParams;
    }

    public void setOneMoreAdTips(String str) {
        this.f40623l = str;
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            return;
        }
        iegrvadi.setOneMoreAdTips(str);
    }

    public void setRewardADCloseDialogTips(String str, String str2, String str3, String str4, String str5, String str6) throws Exception {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            GDTLogger.e("please invoke setCloseDialogTips method after callback \"onADLoad\" ");
            return;
        }
        if (str != null) {
            try {
                iegrvadi.setCloseDialogTips(str, str2, str3);
            } catch (Exception unused) {
                throw new Exception("UnknownFormatConversionException");
            }
        }
        if (str4 != null) {
            this.f40614c.setPageCloseDialogTips(str4, str5, str6);
        }
    }

    public void setRewardADTopTips(String str, String str2, String str3, String str4) throws Exception {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            GDTLogger.e("please invoke setLeftTopTips method after callback \"onADLoad\" ");
            return;
        }
        if (str != null && str2 != null) {
            try {
                iegrvadi.setLeftTopTips(null, str, str2);
            } catch (Exception unused) {
                throw new Exception("UnknownFormatConversionException");
            }
        }
        if (str3 == null || str4 == null) {
            return;
        }
        this.f40614c.setPageTopTips(str3, str4);
    }

    public void setRewardDialogContentViewHolder(RewardDialogContentViewHolder rewardDialogContentViewHolder) {
        this.f40624m = rewardDialogContentViewHolder;
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            return;
        }
        iegrvadi.setRewardDialogContentViewHolder(rewardDialogContentViewHolder);
    }

    public void setVideoVolumeOn(boolean z16) {
        this.f40619h = z16;
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            return;
        }
        iegrvadi.setVideoVolumeOn(z16);
    }

    public void showAD() {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi != null) {
            iegrvadi.showAD();
        } else {
            GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }

    public void setRewardADTopTips(String str, String str2, String str3, String str4, String str5) throws Exception {
        IEGRVADI iegrvadi = this.f40614c;
        if (iegrvadi == null) {
            GDTLogger.e("please invoke setLeftTopTips method after callback \"onADLoad\" ");
            return;
        }
        if (str2 != null && str3 != null) {
            try {
                iegrvadi.setLeftTopTips(str, str2, str3);
            } catch (Exception unused) {
                throw new Exception("UnknownFormatConversionException");
            }
        }
        if (str4 == null || str5 == null) {
            return;
        }
        this.f40614c.setPageTopTips(str4, str5);
    }

    static /* synthetic */ void a(TangramRewardAD tangramRewardAD, int i3) {
        final int i16 = 2001;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.rewardAD.TangramRewardAD.2
            @Override // java.lang.Runnable
            public void run() {
                if (TangramRewardAD.this.f40612a != null) {
                    TangramRewardAD.this.f40612a.onError(AdErrorConvertor.formatErrorCode(i16));
                }
            }
        });
    }

    static /* synthetic */ boolean a(TangramRewardAD tangramRewardAD, boolean z16) {
        tangramRewardAD.f40613b = true;
        return true;
    }
}
