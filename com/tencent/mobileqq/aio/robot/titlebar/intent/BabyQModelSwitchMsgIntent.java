package com.tencent.mobileqq.aio.robot.titlebar.intent;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import k81.RobotAIModelData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/intent/BabyQModelSwitchMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnAIModelSwitch", "Lcom/tencent/mobileqq/aio/robot/titlebar/intent/BabyQModelSwitchMsgIntent$OnAIModelSwitch;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class BabyQModelSwitchMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/intent/BabyQModelSwitchMsgIntent$OnAIModelSwitch;", "Lcom/tencent/mobileqq/aio/robot/titlebar/intent/BabyQModelSwitchMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lk81/a;", "d", "Lk81/a;", "a", "()Lk81/a;", "modelData", "<init>", "(Lk81/a;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class OnAIModelSwitch extends BabyQModelSwitchMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotAIModelData modelData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAIModelSwitch(@NotNull RobotAIModelData modelData) {
            super(null);
            Intrinsics.checkNotNullParameter(modelData, "modelData");
            this.modelData = modelData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotAIModelData getModelData() {
            return this.modelData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnAIModelSwitch) && Intrinsics.areEqual(this.modelData, ((OnAIModelSwitch) other).modelData)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.aio.robot.titlebar.intent.BabyQModelSwitchMsgIntent.OnAIModelSwitch";
        }

        public int hashCode() {
            return this.modelData.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnAIModelSwitch(modelData=" + this.modelData + ")";
        }
    }

    public /* synthetic */ BabyQModelSwitchMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    BabyQModelSwitchMsgIntent() {
    }
}
