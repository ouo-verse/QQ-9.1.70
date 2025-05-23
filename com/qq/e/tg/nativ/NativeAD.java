package com.qq.e.tg.nativ;

import android.content.Context;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.NADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.AbstractAD;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NativeAD extends AbstractAD<NADI> {

    /* renamed from: a, reason: collision with root package name */
    private NativeAdListener f40539a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f40540b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<String> f40541c;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class ADListenerAdapter implements ADListener {
        ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeAD.this.f40539a == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            int type = aDEvent.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeADDataRef) && (aDEvent.getParas()[1] instanceof Integer)) {
                                NativeAD.this.f40539a.onADError((NativeADDataRef) aDEvent.getParas()[0], AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[1]).intValue()));
                                return;
                            }
                            GDTLogger.e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
                            return;
                        }
                        return;
                    }
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeADDataRef)) {
                        NativeAD.this.f40539a.onADStatusChanged((NativeADDataRef) aDEvent.getParas()[0]);
                        return;
                    }
                    GDTLogger.e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
                    return;
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    NativeAD.this.f40539a.onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
                return;
            }
            if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                NativeAD.this.f40539a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                return;
            }
            GDTLogger.e("AdEvent.Paras error for NativeAD(" + aDEvent + ")");
        }

        /* synthetic */ ADListenerAdapter(NativeAD nativeAD, byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface NativeAdListener extends AbstractAD.BasicADListener {
        void onADError(NativeADDataRef nativeADDataRef, AdError adError);

        void onADLoaded(List<NativeADDataRef> list);

        void onADStatusChanged(NativeADDataRef nativeADDataRef);
    }

    public NativeAD(Context context, String str, String str2, NativeAdListener nativeAdListener) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2) && context != null) {
            this.f40539a = nativeAdListener;
            this.adType = PM.NATIVE_AD;
            a(context, str, str2, nativeAdListener);
        } else {
            GDTLogger.e(String.format("GDTNativeAd Contructor paras error,appid=%s,posId=%s,context=%s", str, str2, context));
            a(nativeAdListener, 2001);
        }
    }

    public void loadAD(int i3) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
            return;
        }
        if (!b()) {
            this.f40540b.add(Integer.valueOf(i3));
            return;
        }
        NADI a16 = a();
        if (a16 != null) {
            a16.loadAd(i3);
        } else {
            GDTLogger.e("NativeAD Init error,See More Logs");
        }
    }

    public void setCategories(List<String> list) {
        this.f40541c = list;
        NADI a16 = a();
        if (a16 != null && list != null) {
            a16.setCategories(list);
        }
    }

    @Override // com.qq.e.tg.AbstractAD
    protected final /* synthetic */ NADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeADDelegate(context, str, str2, new ADListenerAdapter(this, (byte) 0));
    }

    @Override // com.qq.e.tg.AbstractAD
    protected final /* synthetic */ void a(NADI nadi) {
        List<String> list = this.f40541c;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f40540b.iterator();
        while (it.hasNext()) {
            loadAD(it.next().intValue());
        }
    }
}
