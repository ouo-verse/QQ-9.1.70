package com.tencent.robot.slash.dialog.content.avatarbar;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnClickAvatar", "SelectPosition", "SubmitList", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent$OnClickAvatar;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent$SelectPosition;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent$SubmitList;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class AvatarBarMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent$OnClickAvatar;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "d", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "getUiModelData", "()Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "uiModelData", "e", "I", "a", "()I", "avatarPosition", "<init>", "(Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnClickAvatar extends AvatarBarMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final b.UIModelData uiModelData;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int avatarPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnClickAvatar(@NotNull b.UIModelData uiModelData, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(uiModelData, "uiModelData");
            this.uiModelData = uiModelData;
            this.avatarPosition = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getAvatarPosition() {
            return this.avatarPosition;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnClickAvatar)) {
                return false;
            }
            OnClickAvatar onClickAvatar = (OnClickAvatar) other;
            if (Intrinsics.areEqual(this.uiModelData, onClickAvatar.uiModelData) && this.avatarPosition == onClickAvatar.avatarPosition) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.uiModelData.hashCode() * 31) + this.avatarPosition;
        }

        @NotNull
        public String toString() {
            return "OnClickAvatar(uiModelData=" + this.uiModelData + ", avatarPosition=" + this.avatarPosition + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent$SelectPosition;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "position", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SelectPosition extends AvatarBarMsgIntent {

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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent$SubmitList;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "dataList", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitList extends AvatarBarMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<b.UIModelData> dataList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitList(@NotNull List<b.UIModelData> dataList) {
            super(null);
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.dataList = dataList;
        }

        @NotNull
        public final List<b.UIModelData> a() {
            return this.dataList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SubmitList) && Intrinsics.areEqual(this.dataList, ((SubmitList) other).dataList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.dataList.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubmitList(dataList=" + this.dataList + ")";
        }
    }

    public /* synthetic */ AvatarBarMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    AvatarBarMsgIntent() {
    }
}
