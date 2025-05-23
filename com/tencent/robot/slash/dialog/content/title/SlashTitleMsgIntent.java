package com.tencent.robot.slash.dialog.content.title;

import a74.CustomTitleInfo;
import androidx.fragment.app.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "d", "a", "OnTitleRightClickMsgIntent", "OnTitleRobotClickMsgIntent", "RefreshTitle", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRightClickMsgIntent;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$RefreshTitle;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class SlashTitleMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRightClickMsgIntent;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnTitleRightClickMsgIntent extends SlashTitleMsgIntent {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final OnTitleRightClickMsgIntent f368500e = new OnTitleRightClickMsgIntent();

        OnTitleRightClickMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "robotUin", "f", "a", "robotTinyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnTitleRobotClickMsgIntent extends SlashTitleMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotUin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotTinyId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnTitleRobotClickMsgIntent(@NotNull String robotUin, @NotNull String robotTinyId) {
            super(null);
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(robotTinyId, "robotTinyId");
            this.robotUin = robotUin;
            this.robotTinyId = robotTinyId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getRobotTinyId() {
            return this.robotTinyId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getRobotUin() {
            return this.robotUin;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnTitleRobotClickMsgIntent)) {
                return false;
            }
            OnTitleRobotClickMsgIntent onTitleRobotClickMsgIntent = (OnTitleRobotClickMsgIntent) other;
            if (Intrinsics.areEqual(this.robotUin, onTitleRobotClickMsgIntent.robotUin) && Intrinsics.areEqual(this.robotTinyId, onTitleRobotClickMsgIntent.robotTinyId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.robotUin.hashCode() * 31) + this.robotTinyId.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnTitleRobotClickMsgIntent(robotUin=" + this.robotUin + ", robotTinyId=" + this.robotTinyId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\n\u0010\u001aR\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$RefreshTitle;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "robotName", "", "f", "J", "d", "()J", "robotUin", h.F, "c", "robotTinyId", "i", "I", "()I", QQBrowserActivityConstants.KEY_TITLE_STYLE, "La74/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "La74/a;", "a", "()La74/a;", "customTitleInfo", "<init>", "(Ljava/lang/String;JJILa74/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class RefreshTitle extends SlashTitleMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final long robotUin;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final long robotTinyId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final int titleStyle;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final CustomTitleInfo customTitleInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefreshTitle(@NotNull String robotName, long j3, long j16, int i3, @Nullable CustomTitleInfo customTitleInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(robotName, "robotName");
            this.robotName = robotName;
            this.robotUin = j3;
            this.robotTinyId = j16;
            this.titleStyle = i3;
            this.customTitleInfo = customTitleInfo;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final CustomTitleInfo getCustomTitleInfo() {
            return this.customTitleInfo;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getRobotName() {
            return this.robotName;
        }

        /* renamed from: c, reason: from getter */
        public final long getRobotTinyId() {
            return this.robotTinyId;
        }

        /* renamed from: d, reason: from getter */
        public final long getRobotUin() {
            return this.robotUin;
        }

        /* renamed from: e, reason: from getter */
        public final int getTitleStyle() {
            return this.titleStyle;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RefreshTitle)) {
                return false;
            }
            RefreshTitle refreshTitle = (RefreshTitle) other;
            if (Intrinsics.areEqual(this.robotName, refreshTitle.robotName) && this.robotUin == refreshTitle.robotUin && this.robotTinyId == refreshTitle.robotTinyId && this.titleStyle == refreshTitle.titleStyle && Intrinsics.areEqual(this.customTitleInfo, refreshTitle.customTitleInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((this.robotName.hashCode() * 31) + a.a(this.robotUin)) * 31) + a.a(this.robotTinyId)) * 31) + this.titleStyle) * 31;
            CustomTitleInfo customTitleInfo = this.customTitleInfo;
            if (customTitleInfo == null) {
                hashCode = 0;
            } else {
                hashCode = customTitleInfo.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "RefreshTitle(robotName=" + this.robotName + ", robotUin=" + this.robotUin + ", robotTinyId=" + this.robotTinyId + ", titleStyle=" + this.titleStyle + ", customTitleInfo=" + this.customTitleInfo + ")";
        }
    }

    public /* synthetic */ SlashTitleMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    SlashTitleMsgIntent() {
    }
}
