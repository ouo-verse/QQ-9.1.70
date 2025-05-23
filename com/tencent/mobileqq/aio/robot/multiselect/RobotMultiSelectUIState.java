package com.tencent.mobileqq.aio.robot.multiselect;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "SetTouchBarVisibility", "UpdateOperation", "UpdateSelectCount", "Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState$SetTouchBarVisibility;", "Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState$UpdateOperation;", "Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState$UpdateSelectCount;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class RobotMultiSelectUIState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState$SetTouchBarVisibility;", "Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class SetTouchBarVisibility extends RobotMultiSelectUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibility;

        public SetTouchBarVisibility(int i3) {
            super(null);
            this.visibility = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SetTouchBarVisibility) && this.visibility == ((SetTouchBarVisibility) other).visibility) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.visibility;
        }

        @NotNull
        public String toString() {
            return "SetTouchBarVisibility(visibility=" + this.visibility + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState$UpdateOperation;", "Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "type", "<init>", "(I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class UpdateOperation extends RobotMultiSelectUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        public UpdateOperation(int i3) {
            super(null);
            this.type = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateOperation) && this.type == ((UpdateOperation) other).type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.type;
        }

        @NotNull
        public String toString() {
            return "UpdateOperation(type=" + this.type + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState$UpdateSelectCount;", "Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "count", "<init>", "(I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class UpdateSelectCount extends RobotMultiSelectUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int count;

        public UpdateSelectCount(int i3) {
            super(null);
            this.count = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateSelectCount) && this.count == ((UpdateSelectCount) other).count) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.count;
        }

        @NotNull
        public String toString() {
            return "UpdateSelectCount(count=" + this.count + ")";
        }
    }

    public /* synthetic */ RobotMultiSelectUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotMultiSelectUIState() {
    }
}
