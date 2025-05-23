package com.qq.e.tg.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.AbstractAD;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NativeUnifiedAD extends AbstractAD<NUADI> {

    /* renamed from: a, reason: collision with root package name */
    private ADListener f40571a;

    /* renamed from: c, reason: collision with root package name */
    private List<String> f40573c;

    /* renamed from: d, reason: collision with root package name */
    private String f40574d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f40575e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f40576f;

    /* renamed from: i, reason: collision with root package name */
    private LoadAdParams f40579i;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f40572b = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private int f40577g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f40578h = 0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class AdListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeADUnifiedListener f40583a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f40583a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            NativeUnifiedAD.a(aDEvent, this.f40583a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class AdListenerAdapterV2 implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<NativeADUnifiedListener> f40584a;

        public AdListenerAdapterV2(WeakReference<NativeADUnifiedListener> weakReference) {
            this.f40584a = weakReference;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            NativeADUnifiedListener nativeADUnifiedListener;
            WeakReference<NativeADUnifiedListener> weakReference = this.f40584a;
            if (weakReference != null) {
                nativeADUnifiedListener = weakReference.get();
            } else {
                nativeADUnifiedListener = null;
            }
            NativeUnifiedAD.a(aDEvent, nativeADUnifiedListener);
        }
    }

    @Deprecated
    public NativeUnifiedAD(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        if (!a(context, str, str2)) {
            a(nativeADUnifiedListener, 4002);
            return;
        }
        this.f40571a = new AdListenerAdapter(nativeADUnifiedListener);
        this.f40574d = str2;
        this.adType = PM.NATIVE_UNIFIED_AD;
        a.a(str2, nativeADUnifiedListener instanceof Context);
        a(context, str, str2, nativeADUnifiedListener);
    }

    @Override // com.qq.e.tg.AbstractAD
    protected final /* synthetic */ NUADI a(Context context, POFactory pOFactory, String str, String str2) {
        if (pOFactory != null) {
            return pOFactory.getNativeAdManagerDelegate(context, str, str2, this.f40571a);
        }
        return null;
    }

    public String getAdNetWorkName() {
        NUADI a16 = a();
        if (a16 != null) {
            return a16.getAdNetWorkName();
        }
        GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onADLoaded\"");
        return null;
    }

    public void loadData(int i3) {
        loadData(i3, null);
    }

    public void setCategories(List<String> list) {
        this.f40573c = list;
        NUADI a16 = a();
        if (a16 != null && list != null) {
            a16.setCategories(list);
        }
    }

    public void setMaxVideoDuration(int i3) {
        this.f40576f = i3;
        if (this.f40576f > 0 && this.f40575e > this.f40576f) {
            GDTLogger.e("maxVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5c0f\u4e8eminVideoDuration");
        }
        NUADI a16 = a();
        if (a16 != null) {
            a16.setMaxVideoDuration(this.f40576f);
        }
    }

    public void setMinVideoDuration(int i3) {
        this.f40575e = i3;
        if (this.f40576f > 0 && this.f40575e > this.f40576f) {
            GDTLogger.e("minVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5927\u4e8emaxVideoDuration");
        }
        NUADI a16 = a();
        if (a16 != null) {
            a16.setMinVideoDuration(this.f40575e);
        }
    }

    public void setTag(Map map) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.f40574d);
            } catch (Exception e16) {
                GDTLogger.e("NativeUnifiedAD#setTag Exception");
                e16.printStackTrace();
            }
        }
    }

    public void setVideoADContainerRender(int i3) {
        if (i3 != 1 && i3 != 2) {
            GDTLogger.e("videoADContainerRender\u53c2\u6570\u6709\u8bef\uff0c\u53ea\u80fd\u662fVideoADContainerRender.SDK \u6216 VideoADContainerRender.DEV");
            return;
        }
        this.f40578h = i3;
        NUADI a16 = a();
        if (a16 != null) {
            a16.setVideoADContainerRender(i3);
        }
    }

    public void setVideoPlayPolicy(int i3) {
        if (i3 != 1 && i3 != 2) {
            GDTLogger.e("videoPlayPolicy\u53c2\u6570\u6709\u8bef\uff0c\u53ea\u80fd\u662fVideoPlayPolicy.AUTO \u6216 VideoPlayPolicy.MANUAL");
            return;
        }
        this.f40577g = i3;
        NUADI a16 = a();
        if (a16 != null) {
            a16.setVideoPlayPolicy(i3);
        }
    }

    public NativeUnifiedAD(NativeUnifiedParams nativeUnifiedParams) {
        NativeADUnifiedListener nativeADUnifiedListener = nativeUnifiedParams.getWeakNativeListener() != null ? nativeUnifiedParams.getWeakNativeListener().get() : null;
        if (nativeUnifiedParams.getWeakNativeListener() != null) {
            nativeUnifiedParams.getWeakNativeListener().get();
        }
        if (!a(nativeUnifiedParams.getWeakContext() != null ? nativeUnifiedParams.getWeakContext().get() : null, nativeUnifiedParams.getAppId(), nativeUnifiedParams.getPosId())) {
            a(nativeADUnifiedListener, 4002);
            return;
        }
        this.f40571a = new AdListenerAdapterV2(nativeUnifiedParams.getWeakNativeListener());
        this.f40574d = nativeUnifiedParams.getPosId();
        this.adType = PM.NATIVE_UNIFIED_AD;
        a(nativeUnifiedParams.getWeakContext() != null ? nativeUnifiedParams.getWeakContext().get() : null, nativeUnifiedParams.getAppId(), nativeUnifiedParams.getPosId(), nativeADUnifiedListener);
    }

    private void a(int i3, boolean z16) {
        List<Integer> list;
        if (!c()) {
            GDTLogger.e("Parameters or context error, details in init NativeUnifiedAD log");
            return;
        }
        if (!b()) {
            if (!z16 || (list = this.f40572b) == null) {
                return;
            }
            list.add(Integer.valueOf(i3));
            return;
        }
        NUADI a16 = a();
        if (a16 != null) {
            LoadAdParams loadAdParams = this.f40579i;
            if (loadAdParams != null) {
                a16.loadData(i3, loadAdParams);
            } else {
                a16.loadData(i3);
            }
        }
    }

    public void loadData(int i3, LoadAdParams loadAdParams) {
        if (loadAdParams != null) {
            this.f40579i = loadAdParams;
            if (!TextUtils.isEmpty(loadAdParams.getPassThroughInfoJsonString()) && this.f40579i.getPassThroughInfoJsonString().getBytes().length >= 512) {
                GDTLogger.e("NativeUnifiedAD setAdParams too large ,current size: " + this.f40579i.toString().getBytes().length);
            }
        }
        a(i3, true);
        if (this.f40577g == 0) {
            GDTLogger.i("\u8bf7\u8c03\u7528setVideoPlayPolicy()\u63a5\u53e3\uff0c\u8bbe\u7f6e\u201c\u7528\u6237\u611f\u77e5\u7684\u89c6\u9891\u5e7f\u544a\u64ad\u653e\u7b56\u7565\u201d\uff0c\u6709\u52a9\u4e8e\u63d0\u9ad8\u89c6\u9891\u5e7f\u544a\u7684eCPM\u503c\uff1b\u5982\u679c\u5e7f\u544a\u4f4d\u4e0d\u652f\u6301\u89c6\u9891\u5e7f\u544a\uff0c\u8bf7\u5ffd\u7565\u672c\u63d0\u793a\u3002");
        }
        if (this.f40578h == 0) {
            GDTLogger.i("\u8bf7\u8c03\u7528setVideoADContainerRender()\u63a5\u53e3\uff0c\u8bbe\u7f6e\u201c\u7528\u6237\u9996\u6b21\u770b\u5230\u7684\u89c6\u9891\u5e7f\u544a\u5bb9\u5668\u201d\u6e32\u67d3\u7b56\u7565\uff0c\u6709\u52a9\u4e8e\u63d0\u9ad8\u89c6\u9891\u5e7f\u544a\u7684eCPM\u503c\uff1b\u5982\u679c\u5e7f\u544a\u4f4d\u4e0d\u652f\u6301\u89c6\u9891\u5e7f\u544a\uff0c\u8bf7\u5ffd\u7565\u672c\u63d0\u793a\u3002");
        }
    }

    static /* synthetic */ void a(ADEvent aDEvent, NativeADUnifiedListener nativeADUnifiedListener) {
        if (nativeADUnifiedListener == null || aDEvent == null) {
            GDTLogger.i("not bind NativeADUnifiedListener");
            return;
        }
        Object[] paras = aDEvent.getParas();
        int type = aDEvent.getType();
        if (type != 1) {
            if (type == 2 && paras.length > 0) {
                Object obj = paras[0];
                if (obj instanceof Integer) {
                    nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) obj).intValue()));
                    return;
                }
                return;
            }
            return;
        }
        if (paras.length == 1) {
            Object obj2 = paras[0];
            if (obj2 instanceof List) {
                List list = (List) obj2;
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                    }
                }
                nativeADUnifiedListener.onADLoaded(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.tg.AbstractAD
    public final void a(final AbstractAD.BasicADListener basicADListener, final int i3) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.nativ.NativeUnifiedAD.1
            @Override // java.lang.Runnable
            public void run() {
                NativeUnifiedAD.super.a(basicADListener, i3);
            }
        });
    }

    @Override // com.qq.e.tg.AbstractAD
    protected final /* synthetic */ void a(NUADI nuadi) {
        NUADI nuadi2 = nuadi;
        if (nuadi2 != null) {
            nuadi2.setMinVideoDuration(this.f40575e);
            nuadi2.setMaxVideoDuration(this.f40576f);
            nuadi2.setVideoPlayPolicy(this.f40577g);
            nuadi2.setVideoADContainerRender(this.f40578h);
        }
        List<String> list = this.f40573c;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f40572b.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        if (context != null && !StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            return true;
        }
        GDTLogger.e(String.format("NativeUnifiedAD constructor parameters error, appId=%s, posId=%s, context=%s", str, str2, context));
        return false;
    }
}
