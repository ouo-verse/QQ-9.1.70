package com.tencent.mobileqq.aio.robot.titlebar;

import com.tencent.aio.base.mvi.part.TitleUIState;
import k81.RobotModelProfileInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "()V", "MultiSelectModelEvent", "UpdateEarIconEvent", "UpdateModelButton", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState$MultiSelectModelEvent;", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState$UpdateEarIconEvent;", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState$UpdateModelButton;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class RobotTopBarUIState implements TitleUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState$MultiSelectModelEvent;", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isSelectModel", "<init>", "(Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class MultiSelectModelEvent extends RobotTopBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSelectModel;

        public MultiSelectModelEvent(boolean z16) {
            super(null);
            this.isSelectModel = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsSelectModel() {
            return this.isSelectModel;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof MultiSelectModelEvent) && this.isSelectModel == ((MultiSelectModelEvent) other).isSelectModel) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isSelectModel;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "MultiSelectModelEvent(isSelectModel=" + this.isSelectModel + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState$UpdateEarIconEvent;", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "showEar", "<init>", "(Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class UpdateEarIconEvent extends RobotTopBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean showEar;

        public UpdateEarIconEvent(boolean z16) {
            super(null);
            this.showEar = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShowEar() {
            return this.showEar;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateEarIconEvent) && this.showEar == ((UpdateEarIconEvent) other).showEar) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.showEar;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "UpdateEarIconEvent(showEar=" + this.showEar + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState$UpdateModelButton;", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "selectModelId", "Lk81/c;", "e", "Lk81/c;", "a", "()Lk81/c;", "modelProfileInfo", "<init>", "(Ljava/lang/String;Lk81/c;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class UpdateModelButton extends RobotTopBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String selectModelId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotModelProfileInfo modelProfileInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateModelButton(@NotNull String selectModelId, @NotNull RobotModelProfileInfo modelProfileInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(selectModelId, "selectModelId");
            Intrinsics.checkNotNullParameter(modelProfileInfo, "modelProfileInfo");
            this.selectModelId = selectModelId;
            this.modelProfileInfo = modelProfileInfo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotModelProfileInfo getModelProfileInfo() {
            return this.modelProfileInfo;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getSelectModelId() {
            return this.selectModelId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateModelButton)) {
                return false;
            }
            UpdateModelButton updateModelButton = (UpdateModelButton) other;
            if (Intrinsics.areEqual(this.selectModelId, updateModelButton.selectModelId) && Intrinsics.areEqual(this.modelProfileInfo, updateModelButton.modelProfileInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.selectModelId.hashCode() * 31) + this.modelProfileInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateModelButton(selectModelId=" + this.selectModelId + ", modelProfileInfo=" + this.modelProfileInfo + ")";
        }
    }

    public /* synthetic */ RobotTopBarUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    RobotTopBarUIState() {
    }
}
