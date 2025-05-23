package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.EventParamsModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.en;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sd implements VisualLayer {

    /* renamed from: c, reason: collision with root package name */
    private static final int f150184c = 15;

    /* renamed from: a, reason: collision with root package name */
    int f150185a;

    /* renamed from: b, reason: collision with root package name */
    se f150186b;

    /* renamed from: d, reason: collision with root package name */
    private eg f150187d;

    /* renamed from: e, reason: collision with root package name */
    private List<VisualLayer.OnLayerStatusChangedListener> f150188e;

    /* renamed from: f, reason: collision with root package name */
    private int f150189f;

    /* renamed from: g, reason: collision with root package name */
    private int f150190g;

    /* renamed from: h, reason: collision with root package name */
    private float f150191h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f150192i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f150193j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f150194k;

    /* renamed from: l, reason: collision with root package name */
    private final String f150195l;

    /* renamed from: m, reason: collision with root package name */
    private final String f150196m;

    /* renamed from: n, reason: collision with root package name */
    private VectorOverlay f150197n;

    /* renamed from: o, reason: collision with root package name */
    private en f150198o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f150199p = true;

    /* renamed from: q, reason: collision with root package name */
    private volatile int f150200q = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sd$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    public final class AnonymousClass3 implements VectorOverlay.OnVectorOverlayLoadListener {
        AnonymousClass3() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay.OnVectorOverlayLoadListener
        public final void onVectorOverlayLoaded(boolean z16) {
            if (z16) {
                sd.this.a(0);
            } else {
                sd.this.a(20);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sd$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    public final class AnonymousClass4 implements VectorOverlay.OnVectorOverlayClickListener {
        AnonymousClass4() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay.OnVectorOverlayClickListener
        public final void onClicked(LatLng latLng, String str, String str2) {
            sd.this.a(VisualLayer.OnLayerStatusChangedListener.EventType.ON_CLICK, JsonUtils.modelToJsonString(new EventParamsModelClass.ClickEventParams(sd.this.f150195l, latLng, str, str2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sd$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    public final class AnonymousClass5 implements IAnimatorModel.IAnimatorEndListener {
        AnonymousClass5() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel.IAnimatorEndListener
        public final void onAnimatorEnd() {
            sd.this.a(VisualLayer.OnLayerStatusChangedListener.EventType.ON_TRANSLATEANIMATION_COMPLETE, JsonUtils.modelToJsonString(new EventParamsModelClass.TranslateAnimationCompleteEventParams(sd.this.f150195l)));
        }
    }

    public sd(VisualLayerOptions visualLayerOptions) {
        int lastIndexOf;
        String layerId = visualLayerOptions.getLayerId();
        if (visualLayerOptions.getLayerId().lastIndexOf("_") == -1) {
            lastIndexOf = visualLayerOptions.getLayerId().length();
        } else {
            lastIndexOf = visualLayerOptions.getLayerId().lastIndexOf("_");
        }
        String substring = layerId.substring(0, lastIndexOf);
        this.f150196m = substring;
        int intValue = visualLayerOptions.getLayerId().lastIndexOf("_") != -1 ? Integer.valueOf(visualLayerOptions.getLayerId().substring(visualLayerOptions.getLayerId().lastIndexOf("_") + 1)).intValue() : 0;
        if (intValue == 0) {
            this.f150195l = substring;
        } else {
            this.f150195l = substring + "_" + intValue;
        }
        a(visualLayerOptions);
    }

    private <T extends en> T c() {
        return (T) this.f150198o;
    }

    private String d() {
        return this.f150196m;
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public final void addLayerStatusChangedListener(VisualLayer.OnLayerStatusChangedListener onLayerStatusChangedListener) {
        if (this.f150188e == null) {
            this.f150188e = new ArrayList();
        }
        this.f150188e.remove(onLayerStatusChangedListener);
        this.f150188e.add(onLayerStatusChangedListener);
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public final void clearCache() {
        eg egVar;
        if (!isRemoved() && !TextUtils.isEmpty(this.f150195l) && (egVar = this.f150187d) != null) {
            egVar.c(this.f150195l);
        }
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public final VisualLayer copy() {
        eg egVar = this.f150187d;
        if (egVar != null) {
            return this.f150187d.a(new VisualLayerOptions(this.f150196m + "_" + egVar.a(this.f150196m)).newBuilder().setAlpha(this.f150191h).setZIndex(this.f150190g).setTimeInterval(this.f150185a).setClickEnable(this.f150194k).build());
        }
        return null;
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public final void enableClick(boolean z16) {
        if (this.f150194k != z16) {
            this.f150194k = z16;
            VectorOverlay vectorOverlay = this.f150197n;
            if (vectorOverlay != null) {
                vectorOverlay.enableClick(z16);
            }
        }
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public final String executeCommand(TencentMap tencentMap, String str) {
        CommandFunctionModelClass.BaseCommandFunction a16 = sh.a(str);
        if (a16 == null) {
            return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse));
        }
        String str2 = a16.commandFunction;
        if (TextUtils.isEmpty(str2)) {
            return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported));
        }
        LogUtil.b(ky.f149119y, "executeCommand functionType: [" + str2 + "]");
        CommandFunctionModelClass.BaseCommandFunction a17 = sh.a(str, str2);
        VectorOverlay vectorOverlay = this.f150197n;
        if (vectorOverlay != null) {
            ReturnInfoModelClass.ReturnStatus executeCommandFunction = vectorOverlay.executeCommandFunction(a17);
            LogUtil.b(ky.f149119y, "executeCommand returnJson:" + sh.a(executeCommandFunction));
            return sh.a(executeCommandFunction);
        }
        return sh.a(new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.internal.bindErrorMsg("mOverlay is null")));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public final ReturnInfoModelClass.ReturnStatus executeCommandFunction(CommandFunctionModelClass.BaseCommandFunction baseCommandFunction) {
        VectorOverlay vectorOverlay = this.f150197n;
        if (vectorOverlay != null) {
            return vectorOverlay.executeCommandFunction(baseCommandFunction);
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public final float getAlpha() {
        return this.f150191h;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public final String getId() {
        return this.f150195l;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final int getLevel() {
        return this.f150189f;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public final String getType() {
        VectorOverlay vectorOverlay = this.f150197n;
        if (vectorOverlay == null) {
            return "";
        }
        return vectorOverlay.getType();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final int getZIndex() {
        return this.f150190g;
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public final boolean isClickEnabled() {
        VectorOverlay vectorOverlay = this.f150197n;
        if (vectorOverlay != null) {
            return vectorOverlay.isClickEnabled();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final boolean isRemoved() {
        return this.f150192i;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final boolean isVisible() {
        return this.f150193j;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void releaseData() {
        if (!isRemoved() && !TextUtils.isEmpty(this.f150195l)) {
            a();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void remove() {
        List<VisualLayer.OnLayerStatusChangedListener> list = this.f150188e;
        if (list != null) {
            list.clear();
            this.f150188e = null;
        }
        a();
        eg egVar = this.f150187d;
        if (egVar != null) {
            egVar.b(this.f150195l);
            this.f150187d = null;
        }
        this.f150192i = true;
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public final void removeLayerStatusChangedListener(VisualLayer.OnLayerStatusChangedListener onLayerStatusChangedListener) {
        List<VisualLayer.OnLayerStatusChangedListener> list = this.f150188e;
        if (list != null) {
            list.remove(onLayerStatusChangedListener);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public final void setAlpha(float f16) {
        if (this.f150191h != f16) {
            this.f150191h = f16;
            VectorOverlay vectorOverlay = this.f150197n;
            if (vectorOverlay != null) {
                vectorOverlay.setOpacity(f16);
            }
        }
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public final void setLevel(int i3) {
        if (this.f150189f != i3 && i3 != 0) {
            this.f150189f = i3;
            VectorOverlay vectorOverlay = this.f150197n;
            if (vectorOverlay != null) {
                vectorOverlay.setLevel(i3);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public final void setOpacity(float f16) {
        setAlpha(f16);
    }

    @Override // com.tencent.map.sdk.comps.vis.VisualLayer
    public final void setTimeInterval(int i3) {
        if (this.f150185a != i3) {
            this.f150199p = true;
            this.f150185a = i3;
            if (i3 > 0 && i3 < 15) {
                this.f150185a = 15;
            }
            c(this.f150187d);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay, com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay
    public final void setVisibility(boolean z16) {
        setVisible(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public final void setVisible(boolean z16) {
        if (this.f150193j != z16) {
            this.f150193j = z16;
            VectorOverlay vectorOverlay = this.f150197n;
            if (vectorOverlay != null) {
                vectorOverlay.setVisibility(z16);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final void setZIndex(int i3) {
        if (this.f150190g != i3) {
            this.f150190g = i3;
            VectorOverlay vectorOverlay = this.f150197n;
            if (vectorOverlay != null) {
                vectorOverlay.setZIndex(i3);
            }
        }
    }

    private void a(se seVar) {
        this.f150186b = seVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(eg egVar) {
        if (egVar == null || !this.f150199p) {
            return;
        }
        this.f150199p = false;
        int i3 = this.f150185a;
        if (i3 > 0) {
            if (i3 < 15) {
                this.f150185a = 15;
            }
            egVar.a(this.f150195l, this.f150185a);
            return;
        }
        egVar.g(this.f150195l);
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
    private void d(eg egVar) {
        LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] #drawLayer");
        en enVar = this.f150198o;
        if (enVar == null || !enVar.c() || egVar == null) {
            return;
        }
        en enVar2 = this.f150198o;
        se seVar = this.f150186b;
        BaseOverlayProvider a16 = seVar != null ? seVar.a(enVar2) : null;
        if (a16 == null) {
            LogUtil.d(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] \u521b\u5efaOverlayProvider\u5931\u8d25");
            a(4);
            return;
        }
        LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] \u521b\u5efaOverlayProvider:" + a16);
        a16.setVectorOverlayLoadedListener((VectorOverlay.OnVectorOverlayLoadListener) new AnonymousClass3());
        a16.setVectorOverlayClickListener(new AnonymousClass4());
        if (a16 instanceof GLModelOverlayProvider) {
            ((GLModelOverlayProvider) a16).setTransAnimatorEndListener(new AnonymousClass5());
        }
        a16.enableClick(this.f150194k);
        if (this.f150197n == null) {
            this.f150197n = egVar.n_().f147916c.getMap().addVectorOverlay(a16);
            LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] \u521b\u5efaOverlay:" + this.f150197n);
            return;
        }
        egVar.n_().f147916c.getMap().updateVectorOverlay(this.f150197n, a16);
        LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] \u66f4\u65b0Overlay:" + this.f150197n);
    }

    private int b() {
        return this.f150185a;
    }

    public final void a() {
        VectorOverlay vectorOverlay = this.f150197n;
        if (vectorOverlay != null) {
            vectorOverlay.remove();
            this.f150197n = null;
        }
    }

    public final void b(final eg egVar) {
        if (egVar == null) {
            return;
        }
        egVar.b(this.f150195l, new Callback<byte[]>() { // from class: com.tencent.mapsdk.internal.sd.2
            private void a(byte[] bArr) {
                if (bArr != null && bArr.length > 0) {
                    LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + sd.this.f150195l + "] \u5237\u65b0\u56fe\u5c42\u6570\u636e[" + bArr.length + "]");
                    if (sd.this.a(bArr, true)) {
                        sd.a(sd.this, egVar);
                        egVar.a(sd.this.f150195l, bArr);
                    }
                }
                sd.this.c(egVar);
            }

            @Override // com.tencent.map.tools.Callback
            public final /* synthetic */ void callback(byte[] bArr) {
                byte[] bArr2 = bArr;
                if (bArr2 != null && bArr2.length > 0) {
                    LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + sd.this.f150195l + "] \u5237\u65b0\u56fe\u5c42\u6570\u636e[" + bArr2.length + "]");
                    if (sd.this.a(bArr2, true)) {
                        sd.a(sd.this, egVar);
                        egVar.a(sd.this.f150195l, bArr2);
                    }
                }
                sd.this.c(egVar);
            }
        });
    }

    private boolean b(int i3) {
        if (this.f150200q == i3) {
            return false;
        }
        int i16 = this.f150200q;
        if (i16 == 0 ? i3 > this.f150200q : !(i16 != 1 && i16 != 2 && i16 != 3 && i16 != 4 && i16 != 20)) {
            i3 = this.f150200q;
        }
        if (this.f150200q == i3) {
            return false;
        }
        this.f150200q = i3;
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public final void setZIndex(float f16) {
        setZIndex((int) f16);
    }

    public final void a(final eg egVar) {
        this.f150187d = egVar;
        if (egVar.e(this.f150195l)) {
            egVar.a(this.f150195l, new Callback<byte[]>() { // from class: com.tencent.mapsdk.internal.sd.1
                private void a(byte[] bArr) {
                    int i3;
                    StringBuilder sb5 = new StringBuilder("\u56fe\u5c42id[");
                    sb5.append(sd.this.f150195l);
                    sb5.append("] \u8bfb\u53d6\u672c\u5730\u56fe\u5c42\u6570\u636e[");
                    if (bArr != null) {
                        i3 = bArr.length;
                    } else {
                        i3 = 0;
                    }
                    sb5.append(i3);
                    sb5.append("]");
                    LogUtil.b(ky.f149119y, sb5.toString());
                    if (bArr != null && bArr.length > 0 && sd.this.a(bArr, false)) {
                        sd.a(sd.this, egVar);
                    }
                    sd.this.b(egVar);
                }

                @Override // com.tencent.map.tools.Callback
                public final /* synthetic */ void callback(byte[] bArr) {
                    int i3;
                    byte[] bArr2 = bArr;
                    StringBuilder sb5 = new StringBuilder("\u56fe\u5c42id[");
                    sb5.append(sd.this.f150195l);
                    sb5.append("] \u8bfb\u53d6\u672c\u5730\u56fe\u5c42\u6570\u636e[");
                    if (bArr2 != null) {
                        i3 = bArr2.length;
                    } else {
                        i3 = 0;
                    }
                    sb5.append(i3);
                    sb5.append("]");
                    LogUtil.b(ky.f149119y, sb5.toString());
                    if (bArr2 != null && bArr2.length > 0 && sd.this.a(bArr2, false)) {
                        sd.a(sd.this, egVar);
                    }
                    sd.this.b(egVar);
                }
            });
        } else if (egVar.a()) {
            a(2);
        } else {
            egVar.f(this.f150195l);
        }
    }

    public final void a(VisualLayerOptions visualLayerOptions) {
        if (visualLayerOptions != null) {
            setAlpha(visualLayerOptions.getAlpha());
            setLevel(visualLayerOptions.getLevel());
            setTimeInterval(visualLayerOptions.getTimeInterval());
            setVisible(visualLayerOptions.isVisible());
            setZIndex(visualLayerOptions.getZIndex());
            enableClick(visualLayerOptions.isClickEnabled());
        }
    }

    public final boolean a(byte[] bArr, boolean z16) {
        en enVar;
        en.b bVar;
        StringBuilder sb5 = new StringBuilder("\u56fe\u5c42id[");
        sb5.append(this.f150195l);
        sb5.append("] #parseLayerData[");
        sb5.append(bArr != null ? bArr.length : 0);
        sb5.append("]");
        LogUtil.b(ky.f149119y, sb5.toString());
        se seVar = this.f150186b;
        en a16 = seVar != null ? seVar.a(bArr) : null;
        this.f150198o = a16;
        if (a16 != null && this.f150187d != null && a16.c()) {
            en enVar2 = this.f150198o;
            String d16 = this.f150187d.d(this.f150195l);
            se seVar2 = this.f150186b;
            this.f150198o = seVar2 != null ? seVar2.a(enVar2, d16) : null;
            this.f150187d.a(getId(), this.f150198o.a(), this.f150198o.b());
            LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] \u521b\u5efaProtocol\u5bf9\u8c61\uff1a\u6210\u529f");
            return true;
        }
        if (z16 && (enVar = this.f150198o) != null && (bVar = enVar.f148208b) != null && bVar.f148227a == 0) {
            LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] \u521b\u5efaProtocol\u5bf9\u8c61\uff1a\u7f51\u7edc\u8fd4\u56de\u6570\u636e\u7248\u672c\u65e0\u53d8\u5316, \u65e0\u9700\u66f4\u65b0\u672c\u5730\u6570\u636e");
            return false;
        }
        a(3);
        LogUtil.d(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] \u521b\u5efaProtocol\u5bf9\u8c61\uff1a\u5931\u8d25");
        return false;
    }

    private en a(byte[] bArr) {
        se seVar = this.f150186b;
        if (seVar != null) {
            return seVar.a(bArr);
        }
        return null;
    }

    private en a(en enVar, String str) {
        se seVar = this.f150186b;
        if (seVar != null) {
            return seVar.a(enVar, str);
        }
        return null;
    }

    private BaseOverlayProvider a(en enVar) {
        se seVar = this.f150186b;
        if (seVar != null) {
            return seVar.a(enVar);
        }
        return null;
    }

    public final void a(final int i3) {
        LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + this.f150195l + "] notifyStatusChange want from[" + this.f150200q + "]to[" + i3 + "]");
        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.sd.6
            @Override // java.lang.Runnable
            public final void run() {
                if (!sd.a(sd.this, i3) || sd.this.f150188e == null) {
                    return;
                }
                LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + sd.this.f150195l + "] notifyStatusChange do success");
                ArrayList<VisualLayer.OnLayerStatusChangedListener> arrayList = new ArrayList(sd.this.f150188e);
                sd.this.a(VisualLayer.OnLayerStatusChangedListener.EventType.ON_LAYER_LOAD_FINISH, JsonUtils.modelToJsonString(new EventParamsModelClass.LoadFinishEventParams(sd.this.f150195l, EventParamsModelClass.LoadFinishEventParams.LoadFinishInfo.getById(i3))));
                for (VisualLayer.OnLayerStatusChangedListener onLayerStatusChangedListener : arrayList) {
                    if (onLayerStatusChangedListener != null) {
                        onLayerStatusChangedListener.onLayerLoadFinish(i3);
                    }
                }
            }
        }, 10L);
    }

    public final void a(final String str, final String str2) {
        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.sd.7
            @Override // java.lang.Runnable
            public final void run() {
                if (sd.this.f150188e == null) {
                    return;
                }
                for (VisualLayer.OnLayerStatusChangedListener onLayerStatusChangedListener : new ArrayList(sd.this.f150188e)) {
                    if (onLayerStatusChangedListener != null) {
                        onLayerStatusChangedListener.onEvent(this, str, str2);
                    }
                }
            }
        }, 10L);
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.tencent.tencentmap.mapsdk.maps.TencentMap] */
    static /* synthetic */ void a(sd sdVar, eg egVar) {
        LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + sdVar.f150195l + "] #drawLayer");
        en enVar = sdVar.f150198o;
        if (enVar == null || !enVar.c() || egVar == null) {
            return;
        }
        en enVar2 = sdVar.f150198o;
        se seVar = sdVar.f150186b;
        BaseOverlayProvider a16 = seVar != null ? seVar.a(enVar2) : null;
        if (a16 == null) {
            LogUtil.d(ky.f149119y, "\u56fe\u5c42id[" + sdVar.f150195l + "] \u521b\u5efaOverlayProvider\u5931\u8d25");
            sdVar.a(4);
            return;
        }
        LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + sdVar.f150195l + "] \u521b\u5efaOverlayProvider:" + a16);
        a16.setVectorOverlayLoadedListener((VectorOverlay.OnVectorOverlayLoadListener) new AnonymousClass3());
        a16.setVectorOverlayClickListener(new AnonymousClass4());
        if (a16 instanceof GLModelOverlayProvider) {
            ((GLModelOverlayProvider) a16).setTransAnimatorEndListener(new AnonymousClass5());
        }
        a16.enableClick(sdVar.f150194k);
        if (sdVar.f150197n == null) {
            sdVar.f150197n = egVar.n_().f147916c.getMap().addVectorOverlay(a16);
            LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + sdVar.f150195l + "] \u521b\u5efaOverlay:" + sdVar.f150197n);
            return;
        }
        egVar.n_().f147916c.getMap().updateVectorOverlay(sdVar.f150197n, a16);
        LogUtil.b(ky.f149119y, "\u56fe\u5c42id[" + sdVar.f150195l + "] \u66f4\u65b0Overlay:" + sdVar.f150197n);
    }

    static /* synthetic */ boolean a(sd sdVar, int i3) {
        if (sdVar.f150200q == i3) {
            return false;
        }
        int i16 = sdVar.f150200q;
        if (i16 == 0 ? i3 > sdVar.f150200q : !(i16 != 1 && i16 != 2 && i16 != 3 && i16 != 4 && i16 != 20)) {
            i3 = sdVar.f150200q;
        }
        if (sdVar.f150200q == i3) {
            return false;
        }
        sdVar.f150200q = i3;
        return true;
    }
}
