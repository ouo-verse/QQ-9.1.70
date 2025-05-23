package com.tencent.ecommerce.biz.hr;

import android.content.Context;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ui.api.IECRenderViewRegister;
import com.tencent.ecommerce.biz.hr.component.HRAPNGView;
import com.tencent.ecommerce.biz.hr.component.HRAdsorptionPullView;
import com.tencent.ecommerce.biz.hr.component.HRCircleAvatarView;
import com.tencent.ecommerce.biz.hr.component.HRFragmentView;
import com.tencent.ecommerce.biz.hr.component.HRGameButton;
import com.tencent.ecommerce.biz.hr.component.HRGuildMixBackgroundView;
import com.tencent.ecommerce.biz.hr.component.HRPAGView;
import com.tencent.ecommerce.biz.hr.component.HRQQFaceImageView;
import com.tencent.ecommerce.biz.hr.component.HRSearchBar;
import com.tencent.ecommerce.biz.hr.module.HRBridgeModule;
import com.tencent.ecommerce.biz.hr.module.f;
import com.tencent.ecommerce.biz.hr.module.g;
import com.tencent.ecommerce.biz.hr.module.h;
import com.tencent.ecommerce.biz.hr.prop.ECHRDtViewPropHandler;
import com.tencent.kuikly.core.render.android.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/ECKuiklyExport;", "", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "a", "b", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECKuiklyExport {

    /* renamed from: a, reason: collision with root package name */
    public static final ECKuiklyExport f102513a = new ECKuiklyExport();

    ECKuiklyExport() {
    }

    public final void a(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        kuiklyRenderExport.a("HRBridgeModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new HRBridgeModule();
            }
        });
        kuiklyRenderExport.a("HRShareModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new h();
            }
        });
        kuiklyRenderExport.a("HRCacheModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalModule$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.ecommerce.biz.hr.module.b();
            }
        });
        kuiklyRenderExport.a("KRNotifyModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalModule$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new f();
            }
        });
        kuiklyRenderExport.a("HROpenTelemetryModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalModule$1$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new g();
            }
        });
        kuiklyRenderExport.a("CalendarModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalModule$1$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.ecommerce.biz.hr.module.c();
            }
        });
    }

    public final void b(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        b.a.a(kuiklyRenderExport, "HRPAGView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRPAGView(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "HRQQFaceImageView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$2
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRQQFaceImageView(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "HRAPNGView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$3
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRAPNGView(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "ECFragmentView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$4
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRFragmentView(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "HRAdsorptionPullView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$5
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRAdsorptionPullView(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "HRGuildMixBackgroundView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$6
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRGuildMixBackgroundView(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "HRSearchBar", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$7
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRSearchBar(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "HRGameButton", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$8
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRGameButton(context);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "ECCirAvatarView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECKuiklyExport$registerExternalRenderView$1$9
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRCircleAvatarView(context);
            }
        }, null, 4, null);
        IECRenderViewRegister renderViewRegister = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRenderViewRegister();
        if (renderViewRegister != null) {
            renderViewRegister.registerKuiklyRenderView(kuiklyRenderExport);
        }
    }

    public final void c(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        kuiklyRenderExport.d(new ECHRDtViewPropHandler());
    }
}
