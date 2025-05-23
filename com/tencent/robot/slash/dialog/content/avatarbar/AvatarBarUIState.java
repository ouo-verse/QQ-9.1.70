package com.tencent.robot.slash.dialog.content.avatarbar;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "SelectPosition", "SubmitList", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState$SelectPosition;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState$SubmitList;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class AvatarBarUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState$SelectPosition;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "position", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SelectPosition extends AvatarBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        public SelectPosition(int i3) {
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
            if ((other instanceof SelectPosition) && this.position == ((SelectPosition) other).position) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.position;
        }

        @NotNull
        public String toString() {
            return "SelectPosition(position=" + this.position + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState$SubmitList;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "uiDataList", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitList extends AvatarBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<b.UIModelData> uiDataList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitList(@NotNull List<b.UIModelData> uiDataList) {
            super(null);
            Intrinsics.checkNotNullParameter(uiDataList, "uiDataList");
            this.uiDataList = uiDataList;
        }

        @NotNull
        public final List<b.UIModelData> a() {
            return this.uiDataList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SubmitList) && Intrinsics.areEqual(this.uiDataList, ((SubmitList) other).uiDataList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.uiDataList.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubmitList(uiDataList=" + this.uiDataList + ")";
        }
    }

    public /* synthetic */ AvatarBarUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    AvatarBarUIState() {
    }
}
