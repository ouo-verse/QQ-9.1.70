package com.tencent.kuikly.core.render.android.context;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b \u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "KuiklyRenderNativeMethodUnknown", "KuiklyRenderNativeMethodCreateRenderView", "KuiklyRenderNativeMethodRemoveRenderView", "KuiklyRenderNativeMethodInsertSubRenderView", "KuiklyRenderNativeMethodSetViewProp", "KuiklyRenderNativeMethodSetRenderViewFrame", "KuiklyRenderNativeMethodCalculateRenderViewSize", "KuiklyRenderNativeMethodCallViewMethod", "KuiklyRenderNativeMethodCallModuleMethod", "KuiklyRenderNativeMethodCreateShadow", "KuiklyRenderNativeMethodRemoveShadow", "KuiklyRenderNativeMethodSetShadowProp", "KuiklyRenderNativeMethodSetShadowForView", "KuiklyRenderNativeMethodSetTimeout", "KuiklyRenderNativeMethodCallShadowMethod", "KuiklyRenderNativeMethodFireFatalException", "KuiklyRenderNativeMethodSyncFlushUI", "KuiklyRenderNativeMethodCallTDFNativeMethod", "KuiklyRenderNativeMethodAsyncContextThread", "KuiklyRenderNativeMethodAsyncKMPContextThread", "KuiklyRenderNativeMethodAsyncUIThread", "KuiklyRenderNativeMethodISContextThread", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public enum KuiklyRenderNativeMethod {
    KuiklyRenderNativeMethodUnknown(0),
    KuiklyRenderNativeMethodCreateRenderView(1),
    KuiklyRenderNativeMethodRemoveRenderView(2),
    KuiklyRenderNativeMethodInsertSubRenderView(3),
    KuiklyRenderNativeMethodSetViewProp(4),
    KuiklyRenderNativeMethodSetRenderViewFrame(5),
    KuiklyRenderNativeMethodCalculateRenderViewSize(6),
    KuiklyRenderNativeMethodCallViewMethod(7),
    KuiklyRenderNativeMethodCallModuleMethod(8),
    KuiklyRenderNativeMethodCreateShadow(9),
    KuiklyRenderNativeMethodRemoveShadow(10),
    KuiklyRenderNativeMethodSetShadowProp(11),
    KuiklyRenderNativeMethodSetShadowForView(12),
    KuiklyRenderNativeMethodSetTimeout(13),
    KuiklyRenderNativeMethodCallShadowMethod(14),
    KuiklyRenderNativeMethodFireFatalException(15),
    KuiklyRenderNativeMethodSyncFlushUI(16),
    KuiklyRenderNativeMethodCallTDFNativeMethod(17),
    KuiklyRenderNativeMethodAsyncContextThread(18),
    KuiklyRenderNativeMethodAsyncKMPContextThread(19),
    KuiklyRenderNativeMethodAsyncUIThread(20),
    KuiklyRenderNativeMethodISContextThread(21);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod$a;", "", "", "value", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeMethod;", "a", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.context.KuiklyRenderNativeMethod$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final KuiklyRenderNativeMethod a(int value) {
            KuiklyRenderNativeMethod kuiklyRenderNativeMethod;
            boolean z16;
            KuiklyRenderNativeMethod[] values = KuiklyRenderNativeMethod.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    kuiklyRenderNativeMethod = values[i3];
                    if (kuiklyRenderNativeMethod.getValue() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    kuiklyRenderNativeMethod = null;
                    break;
                }
            }
            if (kuiklyRenderNativeMethod == null) {
                return KuiklyRenderNativeMethod.KuiklyRenderNativeMethodUnknown;
            }
            return kuiklyRenderNativeMethod;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    KuiklyRenderNativeMethod(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
