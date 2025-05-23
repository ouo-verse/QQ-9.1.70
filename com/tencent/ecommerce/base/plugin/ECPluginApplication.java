package com.tencent.ecommerce.base.plugin;

import android.app.Application;
import ch0.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.ecommerce.base.customview.vnode.a;
import com.tencent.ecommerce.base.customview.vnode.b;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderTimerView;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rh0.a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/ECPluginApplication;", "Landroid/app/Application;", "", "onCreate", "<init>", "()V", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECPluginApplication extends Application {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ECPluginApplication";
    public static volatile Application appContext;
    private static volatile boolean hasInit;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/ECPluginApplication$a;", "", "Landroid/app/Application;", "application", "", "c", "", "<set-?>", "hasInit", "Z", "b", "()Z", "e", "(Z)V", "appContext", "Landroid/app/Application;", "a", "()Landroid/app/Application;", "d", "(Landroid/app/Application;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.plugin.ECPluginApplication$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        Companion() {
        }

        private final void e(boolean z16) {
            ECPluginApplication.hasInit = z16;
        }

        public final Application a() {
            Application application = ECPluginApplication.appContext;
            if (application == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appContext");
            }
            return application;
        }

        public final boolean b() {
            return ECPluginApplication.hasInit;
        }

        public final void c(Application application) {
            if (b()) {
                return;
            }
            d(application);
            ECSkin.INSTANCE.init(a());
            yi0.a.f450402c.d();
            com.tencent.ecommerce.base.style.service.a.f100995b.b();
            PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-ec-count-adjuster", new a.C11139a());
            PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-dot-nine-view", new a.C1026a());
            PTSNodeFactory.registerCustomViewNodeVirtual("text", PTSConstant.CUSTOM_VIEW_TYPE_TIMER, new b.a());
            PTSNodeFactory.registerCustomViewNodeVirtual("text", "qq-ec-apply-sample-countdown-label", new ECApplySampleOrderTimerView.a());
            PTSNodeFactory.registerNodeVirtual(PTSConstant.VNT_RICH_TEXT, new a.C0192a());
            CustomMethodsRegister.registerCustomMethod(new com.tencent.ecommerce.biz.common.b());
            ECPluginGlobalReceiver.f100880a.a(a());
            com.tencent.ecommerce.base.eventbus.a.f100697c.e();
            cg0.a.b(ECPluginApplication.TAG, "isPluginMode: false, sdkVersion: master-3318");
            e(true);
        }

        public final void d(Application application) {
            ECPluginApplication.appContext = application;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        cg0.a.b(TAG, "onCreate");
        INSTANCE.c(this);
    }
}
