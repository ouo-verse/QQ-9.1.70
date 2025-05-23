package com.tencent.kuikly.core.render.android.context;

import com.tencent.kuikly.core.IKuiklyCoreEntry;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/kuikly/core/render/android/context/KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "callNative", "", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1 implements IKuiklyCoreEntry.Delegate {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KTNativeKotlinBridgeDelegator f117526a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1(KTNativeKotlinBridgeDelegator kTNativeKotlinBridgeDelegator) {
        this.f117526a = kTNativeKotlinBridgeDelegator;
    }

    @Override // com.tencent.kuikly.core.IKuiklyCoreEntry.Delegate
    @Nullable
    public Object callNative(int methodId, @Nullable final Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5) {
        if (methodId == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodAsyncContextThread.getValue()) {
            KuiklyRenderThreadManager.f118203b.e(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.context.KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1$callNative$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1.this.f117526a.g(arg0);
                }
            });
            return null;
        }
        if (methodId == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodAsyncKMPContextThread.getValue()) {
            KuiklyRenderThreadManager.f118203b.f(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.context.KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1$callNative$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1.this.f117526a.g(arg0);
                }
            });
            return null;
        }
        if (methodId == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodAsyncUIThread.getValue()) {
            KuiklyRenderThreadManager.f118203b.j(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.context.KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1$callNative$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1.this.f117526a.g(arg0);
                }
            }, false);
            return null;
        }
        if (methodId == KuiklyRenderNativeMethod.KuiklyRenderNativeMethodISContextThread.getValue()) {
            return Integer.valueOf(KuiklyRenderThreadManager.f118203b.d() ? 1 : 0);
        }
        IKuiklyCoreEntry.Delegate delegate = this.f117526a.getDelegate();
        if (delegate == null) {
            return null;
        }
        return delegate.callNative(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
    }
}
