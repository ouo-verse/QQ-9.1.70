package com.tencent.mobileqq.vas.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.floatscreen.ColorScreenManagerImpl;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasSingedApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasSingedApi;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "T", "", "impl", "dynamicCall", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/vas/api/IVasManager;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/vip/IVipStatusManager;", "vipStatus$delegate", "Lkotlin/Lazy;", "getVipStatus", "()Lcom/tencent/mobileqq/vip/IVipStatusManager;", "vipStatus", "Lcom/tencent/mobileqq/vas/floatscreen/ColorScreenManagerImpl;", "colorScreen$delegate", "getColorScreen", "()Lcom/tencent/mobileqq/vas/floatscreen/ColorScreenManagerImpl;", ColorScreenJsPlugin.BUSINESS_NAME, "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasSingedApiImpl implements IVasSingedApi {
    private static final String MAIN_PROCESS_NAME = BaseApplication.getContext().getPackageName();
    private static final String PROCESS_NAME = MobileQQ.processName;

    @NotNull
    public static final String TAG = "VasSingedApiImpl";

    /* renamed from: colorScreen$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy colorScreen;

    /* renamed from: vipStatus$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy vipStatus;

    public VasSingedApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IVipStatusManager>() { // from class: com.tencent.mobileqq.vas.api.impl.VasSingedApiImpl$vipStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IVipStatusManager invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasSingedApiImpl.this.dynamicCall(new com.tencent.mobileqq.vip.s());
                return (IVipStatusManager) dynamicCall;
            }
        });
        this.vipStatus = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ColorScreenManagerImpl>() { // from class: com.tencent.mobileqq.vas.api.impl.VasSingedApiImpl$colorScreen$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ColorScreenManagerImpl invoke() {
                return new ColorScreenManagerImpl();
            }
        });
        this.colorScreen = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends IVasManager> T dynamicCall(Object impl) {
        Object proxy = RemoteProxy.getProxy(impl.getClass());
        Intrinsics.checkNotNull(proxy, "null cannot be cast to non-null type T of com.tencent.mobileqq.vas.api.impl.VasSingedApiImpl.dynamicCall");
        return (T) proxy;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSingedApi
    @NotNull
    public IVipStatusManager getVipStatus() {
        return (IVipStatusManager) this.vipStatus.getValue();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        QLog.i(TAG, 1, "onCreate on " + PROCESS_NAME);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "onDestroy on " + PROCESS_NAME);
        getColorScreen().onDestroy();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSingedApi
    @NotNull
    public ColorScreenManagerImpl getColorScreen() {
        return (ColorScreenManagerImpl) this.colorScreen.getValue();
    }
}
