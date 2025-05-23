package com.tencent.kuikly.core.render.android.expand.component;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewPlayControl;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "KRVideoViewPlayControlNone", "KRVideoViewPlayControlPreplay", "KRVideoViewPlayControlPlay", "KRVideoViewPlayControlPause", "KRVideoViewPlayControlStop", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public enum KRVideoViewPlayControl {
    KRVideoViewPlayControlNone,
    KRVideoViewPlayControlPreplay,
    KRVideoViewPlayControlPlay,
    KRVideoViewPlayControlPause,
    KRVideoViewPlayControlStop;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewPlayControl$a;", "", "", "value", "Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewPlayControl;", "a", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRVideoViewPlayControl$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final KRVideoViewPlayControl a(int value) {
            KRVideoViewPlayControl kRVideoViewPlayControl;
            boolean z16;
            KRVideoViewPlayControl[] values = KRVideoViewPlayControl.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    kRVideoViewPlayControl = values[i3];
                    if (kRVideoViewPlayControl.ordinal() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    kRVideoViewPlayControl = null;
                    break;
                }
            }
            if (kRVideoViewPlayControl == null) {
                return KRVideoViewPlayControl.KRVideoViewPlayControlNone;
            }
            return kRVideoViewPlayControl;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
