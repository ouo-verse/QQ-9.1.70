package com.tencent.kuikly.core.render.android.expand.component;

import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewContentMode;", "", "", "value", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "KRVideoViewContentModeScaleAspectFit", "KRVideoViewContentModeScaleAspectFill", "KRVideoViewContentModeScaleToFill", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public enum KRVideoViewContentMode {
    KRVideoViewContentModeScaleAspectFit(HVideoConstants.ResizeType.RESIZE_CONTAIN),
    KRVideoViewContentModeScaleAspectFill("cover"),
    KRVideoViewContentModeScaleToFill("stretch");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewContentMode$a;", "", "", NodeProps.RESIZE_MODE, "Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewContentMode;", "a", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRVideoViewContentMode$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final KRVideoViewContentMode a(@NotNull String resizeMode) {
            KRVideoViewContentMode kRVideoViewContentMode;
            Intrinsics.checkNotNullParameter(resizeMode, "resizeMode");
            KRVideoViewContentMode[] values = KRVideoViewContentMode.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    kRVideoViewContentMode = values[i3];
                    if (Intrinsics.areEqual(kRVideoViewContentMode.value, resizeMode)) {
                        break;
                    }
                    i3++;
                } else {
                    kRVideoViewContentMode = null;
                    break;
                }
            }
            if (kRVideoViewContentMode == null) {
                return KRVideoViewContentMode.KRVideoViewContentModeScaleAspectFit;
            }
            return kRVideoViewContentMode;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    KRVideoViewContentMode(String str) {
        this.value = str;
    }
}
