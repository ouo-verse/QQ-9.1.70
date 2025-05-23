package com.tencent.luggage.wxa.a8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ag.j;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    private static final String TAG = "MicroMsg.AppBrand.PipPluginHandlerCommons";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120899a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.vj.e.values().length];
            f120899a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.vj.e.FAIL_SINCE_IS_EXITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f120899a[com.tencent.luggage.wxa.vj.e.FAIL_SINCE_NOT_IN_PIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f120899a[com.tencent.luggage.wxa.vj.e.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Nullable
    public static com.tencent.luggage.wxa.kj.v getPageView(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.xd.d e16 = cVar.e();
        if (!(e16 instanceof com.tencent.luggage.wxa.kj.v)) {
            com.tencent.luggage.wxa.tn.w.h(TAG, "getPageView, component(%s) is not AppBrandPageView", e16);
            if (!(e16 instanceof com.tencent.luggage.wxa.ic.l)) {
                com.tencent.luggage.wxa.tn.w.h(TAG, "getPageView, component(%s) is not AppBrandService", e16);
                return null;
            }
            return ((com.tencent.luggage.wxa.ic.l) e16).J();
        }
        return (com.tencent.luggage.wxa.kj.v) e16;
    }

    public final com.tencent.luggage.wxa.vj.f a(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.ic.g runtime = vVar.getRuntime();
        if (runtime == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePipInfo, null == runtime");
            return null;
        }
        com.tencent.luggage.wxa.vj.f Z = runtime.Z();
        if (Z == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePipInfo, null == pipManager");
            return null;
        }
        return Z;
    }

    public boolean amIPipPlayer(@Nullable com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.kj.v pageView;
        com.tencent.luggage.wxa.vj.f a16;
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "amIPipPlayer");
        if (cVar == null || (pageView = getPageView(cVar)) == null || (a16 = a(pageView)) == null) {
            return false;
        }
        return a16.b(getKey());
    }

    public void exitPip(@NonNull com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "exitPip");
        com.tencent.luggage.wxa.kj.v pageView = getPageView(cVar);
        if (pageView == null) {
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            return;
        }
        com.tencent.luggage.wxa.vj.f a16 = a(pageView);
        if (a16 == null) {
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            return;
        }
        int i3 = a.f120899a[a16.a(getId()).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                cVar.a(com.tencent.luggage.wxa.af.e.f121305a);
                return;
            } else {
                cVar.a(com.tencent.luggage.wxa.af.g.f121344m);
                return;
            }
        }
        cVar.a(com.tencent.luggage.wxa.af.g.f121345n);
    }

    public abstract int getId();

    public abstract String getKey();

    public abstract String getLogTag();

    public abstract c getPipInfoProvider();

    public abstract j.b getType();

    public void handlePipInfo(@NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull String str) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handlePipInfo");
        com.tencent.luggage.wxa.kj.v pageView = getPageView(cVar);
        if (pageView == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePipInfo, null == pageView");
            return;
        }
        com.tencent.luggage.wxa.kj.n b06 = pageView.b0();
        if (b06 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePipInfo, null == page");
            return;
        }
        com.tencent.luggage.wxa.vj.f a16 = a(pageView);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePipInfo, null == pipManager");
            return;
        }
        a16.a(pageView);
        JSONObject a17 = cVar.a();
        if (a17 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePipInfo, null == dataJsonObj");
            return;
        }
        c pipInfoProvider = getPipInfoProvider();
        com.tencent.luggage.wxa.ag.b a18 = pipInfoProvider.a(a17.toString());
        if (a18 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePipInfo, null == pipExtra");
        } else {
            a16.a(pageView, getKey(), getId(), a18, pipInfoProvider.b(), pipInfoProvider.c(), pipInfoProvider.a(), new com.tencent.luggage.wxa.vj.c(a16.c(), b06.getCurrentUrl(), str));
        }
    }

    public void removePipId(@NonNull com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.vj.f a16;
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "removePipId");
        com.tencent.luggage.wxa.kj.v pageView = getPageView(cVar);
        if (pageView == null || (a16 = a(pageView)) == null) {
            return;
        }
        a16.a(pageView, getType(), getKey());
    }
}
