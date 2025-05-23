package com.tencent.robot.slash.manager;

import b54.FunctionReportArgs;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\r\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "d", "a", "DismissSlashDialogMsgIntent", "GetCurrentState", "OnReportFunctionClickMsgIntent", "OnReportFunctionImpMsgIntent", "OnSlashDialogChanged", "OnSlashDismissAnimStart", "RetryRequestMsgIntent", "ShowEmptyState", "ShowFailedState", "ShowLoadingState", "ShowNormalState", "UpdateRecentUsedFunctionMsgIntent", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$DismissSlashDialogMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$GetCurrentState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$OnReportFunctionClickMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$OnReportFunctionImpMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$OnSlashDialogChanged;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$OnSlashDismissAnimStart;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$RetryRequestMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$ShowEmptyState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$ShowFailedState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$ShowLoadingState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$ShowNormalState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$UpdateRecentUsedFunctionMsgIntent;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class SlashDialogMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$DismissSlashDialogMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class DismissSlashDialogMsgIntent extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final DismissSlashDialogMsgIntent f368540e = new DismissSlashDialogMsgIntent();

        DismissSlashDialogMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$GetCurrentState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class GetCurrentState extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final GetCurrentState f368541e = new GetCurrentState();

        GetCurrentState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$OnReportFunctionClickMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lb54/a;", "e", "Lb54/a;", "a", "()Lb54/a;", "itemArgs", "<init>", "(Lb54/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnReportFunctionClickMsgIntent extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final FunctionReportArgs itemArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnReportFunctionClickMsgIntent(@NotNull FunctionReportArgs itemArgs) {
            super(null);
            Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
            this.itemArgs = itemArgs;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final FunctionReportArgs getItemArgs() {
            return this.itemArgs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnReportFunctionClickMsgIntent) && Intrinsics.areEqual(this.itemArgs, ((OnReportFunctionClickMsgIntent) other).itemArgs)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.itemArgs.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnReportFunctionClickMsgIntent(itemArgs=" + this.itemArgs + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$OnReportFunctionImpMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lb54/a;", "e", "Lb54/a;", "a", "()Lb54/a;", "itemArgs", "<init>", "(Lb54/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnReportFunctionImpMsgIntent extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final FunctionReportArgs itemArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnReportFunctionImpMsgIntent(@NotNull FunctionReportArgs itemArgs) {
            super(null);
            Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
            this.itemArgs = itemArgs;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final FunctionReportArgs getItemArgs() {
            return this.itemArgs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnReportFunctionImpMsgIntent) && Intrinsics.areEqual(this.itemArgs, ((OnReportFunctionImpMsgIntent) other).itemArgs)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.itemArgs.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnReportFunctionImpMsgIntent(itemArgs=" + this.itemArgs + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$OnSlashDialogChanged;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "e", "Z", "a", "()Z", ViewStickEventHelper.IS_SHOW, "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnSlashDialogChanged extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShow;

        public OnSlashDialogChanged(boolean z16) {
            super(null);
            this.isShow = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnSlashDialogChanged) && this.isShow == ((OnSlashDialogChanged) other).isShow) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isShow;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "OnSlashDialogChanged(isShow=" + this.isShow + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$OnSlashDismissAnimStart;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnSlashDismissAnimStart extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final OnSlashDismissAnimStart f368545e = new OnSlashDismissAnimStart();

        OnSlashDismissAnimStart() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$RetryRequestMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class RetryRequestMsgIntent extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final RetryRequestMsgIntent f368546e = new RetryRequestMsgIntent();

        RetryRequestMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$ShowEmptyState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowEmptyState extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final ShowEmptyState f368547e = new ShowEmptyState();

        ShowEmptyState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$ShowFailedState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowFailedState extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final ShowFailedState f368548e = new ShowFailedState();

        ShowFailedState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$ShowLoadingState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowLoadingState extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final ShowLoadingState f368549e = new ShowLoadingState();

        ShowLoadingState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$ShowNormalState;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowNormalState extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final ShowNormalState f368550e = new ShowNormalState();

        ShowNormalState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$UpdateRecentUsedFunctionMsgIntent;", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "functionInfo", h.F, "I", "b", "()I", "functionType", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateRecentUsedFunctionMsgIntent extends SlashDialogMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CommonBotInfo robotInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CommonBotFeatureInfo functionInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int functionType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateRecentUsedFunctionMsgIntent(@NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo functionInfo, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
            Intrinsics.checkNotNullParameter(functionInfo, "functionInfo");
            this.robotInfo = robotInfo;
            this.functionInfo = functionInfo;
            this.functionType = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final CommonBotFeatureInfo getFunctionInfo() {
            return this.functionInfo;
        }

        /* renamed from: b, reason: from getter */
        public final int getFunctionType() {
            return this.functionType;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final CommonBotInfo getRobotInfo() {
            return this.robotInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRecentUsedFunctionMsgIntent)) {
                return false;
            }
            UpdateRecentUsedFunctionMsgIntent updateRecentUsedFunctionMsgIntent = (UpdateRecentUsedFunctionMsgIntent) other;
            if (Intrinsics.areEqual(this.robotInfo, updateRecentUsedFunctionMsgIntent.robotInfo) && Intrinsics.areEqual(this.functionInfo, updateRecentUsedFunctionMsgIntent.functionInfo) && this.functionType == updateRecentUsedFunctionMsgIntent.functionType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.robotInfo.hashCode() * 31) + this.functionInfo.hashCode()) * 31) + this.functionType;
        }

        @NotNull
        public String toString() {
            return "UpdateRecentUsedFunctionMsgIntent(robotInfo=" + this.robotInfo + ", functionInfo=" + this.functionInfo + ", functionType=" + this.functionType + ")";
        }
    }

    public /* synthetic */ SlashDialogMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    SlashDialogMsgIntent() {
    }
}
