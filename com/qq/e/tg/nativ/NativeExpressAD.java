package com.qq.e.tg.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.AbstractAD;
import com.qq.e.tg.cfg.VideoOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NativeExpressAD extends AbstractAD<NEADI> {
    public static final int EVENT_TYPE_AD_WILL_OPEN_OVERLAY = 20;
    public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSED = 7;
    public static final int EVENT_TYPE_ON_AD_CLOSE_OVERLAY = 10;
    public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
    public static final int EVENT_TYPE_ON_AD_LEFT_APPLICATION = 8;
    public static final int EVENT_TYPE_ON_AD_LOADED = 2;
    public static final int EVENT_TYPE_ON_AD_OPEN_OVERLAY = 9;
    public static final int EVENT_TYPE_ON_NO_AD = 1;
    public static final int EVENT_TYPE_ON_RENDER_FAILED = 3;
    public static final int EVENT_TYPE_ON_RENDER_SUCCESS = 4;
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 21;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 16;
    public static final int EVENT_TYPE_ON_VIDEO_ERROR = 17;
    public static final int EVENT_TYPE_ON_VIDEO_INIT = 11;
    public static final int EVENT_TYPE_ON_VIDEO_LOADING = 12;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_CLOSE = 19;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_OPEN = 18;
    public static final int EVENT_TYPE_ON_VIDEO_PAUSE = 15;
    public static final int EVENT_TYPE_ON_VIDEO_READY = 13;
    public static final int EVENT_TYPE_ON_VIDEO_START = 14;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f40543a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f40544b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f40545c;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f40546d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private VideoOption f40547e;

    /* renamed from: f, reason: collision with root package name */
    private ADSize f40548f;

    /* renamed from: g, reason: collision with root package name */
    private NativeExpressADListener f40549g;

    /* renamed from: h, reason: collision with root package name */
    private String f40550h;

    /* renamed from: i, reason: collision with root package name */
    private LoadAdParams f40551i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeExpressADListener f40552a;

        /* renamed from: b, reason: collision with root package name */
        private NativeExpressMediaListener f40553b;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f40552a = nativeExpressADListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    NativeExpressAD.a(this.f40552a, aDEvent);
                    return;
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                    NativeExpressAD.a(this.f40553b, aDEvent);
                    return;
                case 20:
                default:
                    return;
            }
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f40553b = nativeExpressMediaListener;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface NativeExpressADListener extends AbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADCloseOverlay(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onADOpenOverlay(NativeExpressADView nativeExpressADView);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2) && aDSize != null && context != null) {
            this.f40548f = aDSize;
            this.f40549g = nativeExpressADListener;
            this.f40550h = str2;
            this.adType = PM.NATIVE_EXPRESS_AD;
            a(context, str, str2, nativeExpressADListener);
            return;
        }
        GDTLogger.e(String.format("NativeExpressAD Constructor params error, adSize=%s, appid=%s, posId=%s, context=%s", aDSize, str, str2, context));
        a(nativeExpressADListener, 2001);
    }

    @Override // com.qq.e.tg.AbstractAD
    protected final /* synthetic */ NEADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate(context, this.f40548f, str, str2, new ADListenerAdapter(this.f40549g));
    }

    public void loadAD(int i3) {
        loadAD(i3, null);
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f40551i = loadAdParams;
        if (loadAdParams != null && !TextUtils.isEmpty(loadAdParams.getPassThroughInfoJsonString()) && loadAdParams.getPassThroughInfoJsonString().getBytes().length >= 512) {
            GDTLogger.e("NativeExpressAD setAdParams too large ,current size: " + loadAdParams.toString().getBytes().length);
        }
    }

    public void setMaxVideoDuration(int i3) {
        this.f40544b = i3;
        if (this.f40544b > 0 && this.f40543a > this.f40544b) {
            GDTLogger.e("maxVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5c0f\u4e8eminVideoDuration");
        }
        NEADI a16 = a();
        if (a16 != null) {
            a16.setMaxVideoDuration(this.f40544b);
        }
    }

    public void setMinVideoDuration(int i3) {
        this.f40543a = i3;
        if (this.f40544b > 0 && this.f40543a > this.f40544b) {
            GDTLogger.e("minVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5927\u4e8emaxVideoDuration");
        }
        NEADI a16 = a();
        if (a16 != null) {
            a16.setMinVideoDuration(this.f40543a);
        }
    }

    public void setTag(Map map) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.f40550h);
            } catch (Exception e16) {
                GDTLogger.e("NativeUnifiedAD#setTag Exception");
                e16.printStackTrace();
            }
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f40547e = videoOption;
        NEADI a16 = a();
        if (a16 != null && videoOption != null) {
            a16.setVideoOption(videoOption);
        }
    }

    public void setVideoPlayPolicy(int i3) {
        if (i3 != 1 && i3 != 2) {
            GDTLogger.e("videoPlayPolicy\u53c2\u6570\u6709\u8bef\uff0c\u53ea\u80fd\u662fVideoPlayPolicy.AUTO \u6216 VideoPlayPolicy.MANUAL");
            return;
        }
        this.f40545c = i3;
        NEADI a16 = a();
        if (a16 != null) {
            a16.setVideoPlayPolicy(this.f40545c);
        }
    }

    static /* synthetic */ void a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener == null) {
            GDTLogger.i("No DevADListener Bound");
            return;
        }
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                GDTLogger.e("AdEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 2:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    nativeExpressADListener.onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 3:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onRenderFail((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 4:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onRenderSuccess((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADExposure((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 6:
                if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParas()[0];
                nativeExpressADListener.onADClicked(nativeExpressADView);
                if (aDEvent.getParas()[1] instanceof String) {
                    nativeExpressADView.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[1]);
                    return;
                }
                return;
            case 7:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADClosed((NativeExpressADView) aDEvent.getParas()[0]);
                    ((NativeExpressADView) aDEvent.getParas()[0]).negativeFeedback();
                    return;
                } else {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
            case 8:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADLeftApplication((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 9:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADOpenOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 10:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADCloseOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            default:
                return;
        }
    }

    public void loadAD(int i3, LoadAdParams loadAdParams) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
            return;
        }
        if (loadAdParams != null) {
            setAdParams(loadAdParams);
        }
        if (this.f40545c == 0) {
            GDTLogger.i("\u8bf7\u8c03\u7528setVideoPlayPolicy()\u63a5\u53e3\uff0c\u8bbe\u7f6e\u201c\u7528\u6237\u611f\u77e5\u7684\u89c6\u9891\u5e7f\u544a\u64ad\u653e\u7b56\u7565\u201d\uff0c\u6709\u52a9\u4e8e\u63d0\u9ad8\u89c6\u9891\u5e7f\u544a\u7684eCPM\u503c\uff1b\u5982\u679c\u5e7f\u544a\u4f4d\u4e0d\u652f\u6301\u89c6\u9891\u5e7f\u544a\uff0c\u8bf7\u5ffd\u7565\u672c\u63d0\u793a\u3002");
        }
        if (!b()) {
            this.f40546d.add(Integer.valueOf(i3));
            return;
        }
        NEADI a16 = a();
        if (a16 == null) {
            GDTLogger.e("Native Express AD Init error, see more logs");
            return;
        }
        LoadAdParams loadAdParams2 = this.f40551i;
        if (loadAdParams2 != null) {
            a16.loadAd(i3, loadAdParams2);
        } else {
            a16.loadAd(i3);
        }
    }

    static /* synthetic */ void a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        if (nativeExpressMediaListener == null) {
            GDTLogger.i("No media listener");
            return;
        }
        switch (aDEvent.getType()) {
            case 11:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoInit((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 12:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoLoading((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 13:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                    nativeExpressMediaListener.onVideoReady((NativeExpressADView) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 14:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoStart((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 15:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPause((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 16:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoComplete((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 17:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                    nativeExpressMediaListener.onVideoError((NativeExpressADView) aDEvent.getParas()[0], AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                } else {
                    GDTLogger.e("Native express media event paras error!");
                    return;
                }
            case 18:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPageOpen((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 19:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPageClose((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 20:
            default:
                return;
            case 21:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoCached((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
        }
    }

    @Override // com.qq.e.tg.AbstractAD
    protected final /* synthetic */ void a(NEADI neadi) {
        NEADI neadi2 = neadi;
        if (neadi2 != null) {
            neadi2.setMinVideoDuration(this.f40543a);
            neadi2.setMaxVideoDuration(this.f40544b);
            neadi2.setVideoPlayPolicy(this.f40545c);
        }
        VideoOption videoOption = this.f40547e;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        Iterator<Integer> it = this.f40546d.iterator();
        while (it.hasNext()) {
            loadAD(it.next().intValue());
        }
    }
}
