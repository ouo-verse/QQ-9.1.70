package com.tencent.luggage.wxa.k7;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.i3.n;
import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.q7.u;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerMultiTaskActivity0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.v6.c;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.xweb.XWebSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001\u0006B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0006\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0006\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/luggage/wxa/k7/e;", "Lcom/tencent/luggage/wxa/o1/a;", "", "I", "Lcom/tencent/luggage/wxa/c5/e;", "runtime", "a", "Lcom/tencent/luggage/wxa/p5/f;", "Landroid/view/View;", "N", "from", "Lcom/tencent/luggage/wxa/j4/d;", DownloadInfo.spKey_Config, "Lcom/tencent/luggage/wxa/bk/e;", "stat", "", "Lcom/tencent/luggage/wxa/ic/g;", "_rt", "", "backResult", "Ljava/lang/Runnable;", "callback", "Lcom/tencent/luggage/wxa/fd/i;", "cfg", "b", "Lcom/tencent/luggage/wxa/kk/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/luggage/wxa/kk/a;", "ctrl", BdhLogUtil.LogTag.Tag_Req, "Z", "enableStashPersistentRuntime", "Ljava/lang/Class;", "clz", "<init>", "(Lcom/tencent/luggage/wxa/kk/a;Ljava/lang/Class;)V", ExifInterface.LATITUDE_SOUTH, "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.o1.a {

    /* renamed from: Q, reason: from kotlin metadata */
    public final com.tencent.luggage.wxa.kk.a ctrl;

    /* renamed from: R, reason: from kotlin metadata */
    public final boolean enableStashPersistentRuntime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull com.tencent.luggage.wxa.kk.a ctrl, @NotNull Class<? extends com.tencent.luggage.wxa.c5.e> clz) {
        super(ctrl, clz);
        Intrinsics.checkNotNullParameter(ctrl, "ctrl");
        Intrinsics.checkNotNullParameter(clz, "clz");
        this.ctrl = ctrl;
        this.enableStashPersistentRuntime = !(ctrl.a() instanceof WxaContainerMultiTaskActivity0);
    }

    @Override // com.tencent.luggage.wxa.c5.d
    /* renamed from: I, reason: from getter */
    public boolean getEnableStashPersistentRuntime() {
        return this.enableStashPersistentRuntime;
    }

    @Override // com.tencent.luggage.wxa.o1.a
    public View N() {
        Context context = this.ctrl.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "ctrl.context");
        return new h(context, null, false).getLoadingSplash();
    }

    @Override // com.tencent.luggage.wxa.o1.a
    public boolean a(com.tencent.luggage.wxa.p5.f runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        return true;
    }

    @Override // com.tencent.luggage.wxa.o1.a, com.tencent.luggage.wxa.c5.d, com.tencent.luggage.wxa.ic.j
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.c5.e a(i cfg) {
        com.tencent.luggage.wxa.p5.f b16;
        ViewGroup viewGroup;
        e eVar;
        Activity j3;
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        if (cfg instanceof c.d) {
            return new c.f(this);
        }
        if (cfg instanceof com.tencent.luggage.wxa.j4.d) {
            com.tencent.luggage.wxa.j4.d dVar = (com.tencent.luggage.wxa.j4.d) cfg;
            if (1024 == dVar.i().f122984c || dVar.N.f125847a == 1) {
                com.tencent.luggage.wxa.c5.g gVar = com.tencent.luggage.wxa.c5.g.f123332a;
                String str = cfg.f125808a;
                Intrinsics.checkNotNullExpressionValue(str, "cfg.appId");
                if (gVar.a(str, cfg.d()) == null && (b16 = com.tencent.luggage.wxa.p6.h.b(cfg.f125808a)) != null && b16.l0() == cfg.d()) {
                    ViewParent parent = b16.K().getParent();
                    if (parent instanceof ViewGroup) {
                        viewGroup = (ViewGroup) parent;
                    } else {
                        viewGroup = null;
                    }
                    if (viewGroup != null) {
                        viewGroup.removeView(b16.K());
                    }
                    v e06 = b16.e0();
                    if (e06 instanceof e) {
                        eVar = (e) e06;
                    } else {
                        eVar = null;
                    }
                    if (eVar != null) {
                        eVar.k(b16);
                        eVar.d();
                        if (b16.B0()) {
                            eVar.f(b16);
                        }
                    }
                    b16.a((v) null);
                    b16.a((v) this);
                    WindowAndroidActivityImpl h16 = h();
                    if (h16 != null && (j3 = h16.j()) != null) {
                        f.f131770a.b(j3);
                    }
                    return b16;
                }
            }
        }
        com.tencent.luggage.wxa.c5.e a16 = super.a(cfg);
        Intrinsics.checkNotNullExpressionValue(a16, "super.createRuntime(cfg)");
        return a16;
    }

    @Override // com.tencent.luggage.wxa.c5.d
    public boolean a(com.tencent.luggage.wxa.c5.e runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        if (!super.a(runtime)) {
            return false;
        }
        if (((com.tencent.luggage.wxa.g7.d) runtime).Q1()) {
            return true;
        }
        return XWebSdk.isXWebView();
    }

    @Override // com.tencent.luggage.wxa.c5.d
    public void a(com.tencent.luggage.wxa.c5.e from, com.tencent.luggage.wxa.j4.d config, com.tencent.luggage.wxa.bk.e stat) {
        super.a(from, config, stat);
        if (from == null || config == null) {
            return;
        }
        String str = config.f130793e0;
        boolean z16 = false;
        if (!(str == null || str.length() == 0)) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            try {
                String str2 = config.f130793e0;
                Intrinsics.checkNotNullExpressionValue(str2, "config.thirdPartyHostExtraData");
                config.f130793e0 = new n(str2, z16, 2, defaultConstructorMarker).c();
            } catch (Exception e16) {
                w.b("Luggage.WxaRuntimeContainer", "load reset legal nativeExtraData get exception:" + e16);
                config.f130793e0 = null;
            }
        }
        if (config.n()) {
            return;
        }
        com.tencent.luggage.wxa.q7.w wVar = com.tencent.luggage.wxa.q7.w.f138211a;
        String appId = from.getAppId();
        Intrinsics.checkNotNull(appId);
        String str3 = config.f125808a;
        Intrinsics.checkNotNull(str3);
        wVar.a(appId, str3, w0.c());
    }

    @Override // com.tencent.luggage.wxa.ic.j, com.tencent.luggage.wxa.ic.v
    public void a(com.tencent.luggage.wxa.ic.g _rt, Object backResult, Runnable callback) {
        super.a(_rt, backResult, callback);
        i S = _rt != null ? _rt.S() : null;
        com.tencent.luggage.wxa.j4.d dVar = S instanceof com.tencent.luggage.wxa.j4.d ? (com.tencent.luggage.wxa.j4.d) S : null;
        if (dVar == null || dVar.n()) {
            return;
        }
        u uVar = u.f138189a;
        long j3 = dVar.T;
        String str = dVar.f125808a;
        Intrinsics.checkNotNullExpressionValue(str, "config.appId");
        uVar.b(j3, str);
    }
}
