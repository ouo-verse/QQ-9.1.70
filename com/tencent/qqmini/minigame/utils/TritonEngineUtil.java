package com.tencent.qqmini.minigame.utils;

import android.os.Looper;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.widget.MiniToast;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\u000b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqmini/minigame/utils/TritonEngineUtil;", "", "", "a", "", "msg", "", "c", "Lkotlin/Lazy;", "b", "()Z", "isPublicVersion", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class TritonEngineUtil {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy isPublicVersion;

    /* renamed from: b, reason: collision with root package name */
    public static final TritonEngineUtil f346833b = new TritonEngineUtil();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqmini.minigame.utils.TritonEngineUtil$isPublicVersion$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                Object obj = ProxyManager.get(MiniAppProxy.class);
                Intrinsics.checkExpressionValueIsNotNull(obj, "ProxyManager.get(MiniAppProxy::class.java)");
                return ((MiniAppProxy) obj).isPublicVersion();
            }
        });
        isPublicVersion = lazy;
    }

    TritonEngineUtil() {
    }

    @JvmStatic
    public static final boolean a() {
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null && qQCustomizedProxy.enableMiniGameInspect()) {
            return true;
        }
        return false;
    }

    private final boolean b() {
        return ((Boolean) isPublicVersion.getValue()).booleanValue();
    }

    public final void c(@NotNull final String msg2) {
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        if (b()) {
            return;
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            AppLoaderFactory g16 = AppLoaderFactory.g();
            Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
            MiniToast.makeText(g16.getContext(), 2, msg2, 1).show();
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.utils.TritonEngineUtil$showEngineDebugToast$1
            @Override // java.lang.Runnable
            public final void run() {
                AppLoaderFactory g17 = AppLoaderFactory.g();
                Intrinsics.checkExpressionValueIsNotNull(g17, "AppLoaderFactory.g()");
                MiniToast.makeText(g17.getContext(), 2, msg2, 1).show();
            }
        });
    }
}
