package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "UNKNOWN", "DataChanged", "ZoomLevelChanged", "MoveFinished", "MoveSlowDown", "AutoZoomInHide", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public enum RenderReason {
    UNKNOWN,
    DataChanged,
    ZoomLevelChanged,
    MoveFinished,
    MoveSlowDown,
    AutoZoomInHide;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason$a;", "", "", "ordinal", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason;", "a", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.RenderReason$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RenderReason a(int ordinal) {
            RenderReason renderReason;
            boolean z16;
            RenderReason[] values = RenderReason.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    renderReason = values[i3];
                    if (renderReason.ordinal() == ordinal) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    renderReason = null;
                    break;
                }
            }
            if (renderReason == null) {
                return RenderReason.UNKNOWN;
            }
            return renderReason;
        }

        Companion() {
        }
    }
}
