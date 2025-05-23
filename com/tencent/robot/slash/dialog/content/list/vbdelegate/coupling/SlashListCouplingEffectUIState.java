package com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling;

import com.tencent.robot.widget.list.vb.CommonListUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/coupling/SlashListCouplingEffectUIState;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "()V", "ScrollToPosition", "Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/coupling/SlashListCouplingEffectUIState$ScrollToPosition;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class SlashListCouplingEffectUIState extends CommonListUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/coupling/SlashListCouplingEffectUIState$ScrollToPosition;", "Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/coupling/SlashListCouplingEffectUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "position", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class ScrollToPosition extends SlashListCouplingEffectUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        public ScrollToPosition(int i3) {
            super(null);
            this.position = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ScrollToPosition) && this.position == ((ScrollToPosition) other).position) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.position;
        }

        @NotNull
        public String toString() {
            return "ScrollToPosition(position=" + this.position + ")";
        }
    }

    public /* synthetic */ SlashListCouplingEffectUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    SlashListCouplingEffectUIState() {
    }
}
