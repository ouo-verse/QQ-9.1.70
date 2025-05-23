package com.tencent.mobileqq.wink;

import androidx.annotation.WorkerThread;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightEngine;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00032\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0007J-\u0010\n\u001a\u00020\b2%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004J\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\u0002H\u0007R\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/WinkInitManager;", "", "", "c", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", StateEvent.ProcessResult.SUCCEED, "", "onFinished", "e", "g", "d", "", "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "TAG", "b", "Z", "isLibLoaded", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkInitManager {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<WinkInitManager> f317659d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isLibLoaded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/WinkInitManager$a;", "", "Lcom/tencent/mobileqq/wink/WinkInitManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/WinkInitManager;", "INSTANCE", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.WinkInitManager$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkInitManager a() {
            return (WinkInitManager) WinkInitManager.f317659d.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<WinkInitManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<WinkInitManager>() { // from class: com.tencent.mobileqq.wink.WinkInitManager$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkInitManager invoke() {
                return new WinkInitManager(null);
            }
        });
        f317659d = lazy;
    }

    public /* synthetic */ WinkInitManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 function1, WinkInitManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady() && function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this$0.d()));
        }
    }

    @WorkerThread
    public final boolean c() {
        try {
            LightEngine.init();
            return true;
        } catch (Exception e16) {
            w53.b.c(this.TAG, "LightEngine\u521d\u59cb\u5316\u5931\u8d25 " + e16);
            return false;
        }
    }

    @WorkerThread
    public final boolean d() {
        if (!this.isLibLoaded) {
            this.isLibLoaded = l.e();
            String lightAssetsDir = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightAssetsDir();
            Intrinsics.checkNotNullExpressionValue(lightAssetsDir, "api(IAEResUtil::class.java).lightAssetsDir");
            rd4.c.u(lightAssetsDir);
        }
        w53.b.f(this.TAG, "loadLightAssets result : loadLibResult = " + this.isLibLoaded);
        return this.isLibLoaded;
    }

    public final void e(@Nullable final Function1<? super Boolean, Unit> onFinished) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.k
            @Override // java.lang.Runnable
            public final void run() {
                WinkInitManager.f(Function1.this, this);
            }
        });
    }

    public final void g() {
        WinkDataServiceHandler a16 = com.tencent.mobileqq.wink.edit.manager.e.a();
        if (a16 != null) {
            a16.m3("MqKuaishanEdit");
        }
    }

    WinkInitManager() {
        this.TAG = WinkInitManager.class.getSimpleName();
    }
}
