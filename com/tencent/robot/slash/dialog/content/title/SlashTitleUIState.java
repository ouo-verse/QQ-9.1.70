package com.tencent.robot.slash.dialog.content.title;

import a74.CustomTitleInfo;
import androidx.fragment.app.a;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "DialogDismiss", "TitleBannerState", "TitleTipState", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$DialogDismiss;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$TitleBannerState;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$TitleTipState;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class SlashTitleUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$DialogDismiss;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class DialogDismiss extends SlashTitleUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final DialogDismiss f368508d = new DialogDismiss();

        DialogDismiss() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$TitleBannerState;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "e", "()I", QQBrowserActivityConstants.KEY_TITLE_STYLE, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "robotName", "", "f", "J", "()J", "robotUin", h.F, "c", "robotTinyId", "La74/a;", "i", "La74/a;", "a", "()La74/a;", "customTitleInfo", "<init>", "(ILjava/lang/String;JJLa74/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class TitleBannerState extends SlashTitleUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int titleStyle;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final long robotUin;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final long robotTinyId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final CustomTitleInfo customTitleInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleBannerState(int i3, @NotNull String robotName, long j3, long j16, @Nullable CustomTitleInfo customTitleInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(robotName, "robotName");
            this.titleStyle = i3;
            this.robotName = robotName;
            this.robotUin = j3;
            this.robotTinyId = j16;
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
            if (!(other instanceof TitleBannerState)) {
                return false;
            }
            TitleBannerState titleBannerState = (TitleBannerState) other;
            if (this.titleStyle == titleBannerState.titleStyle && Intrinsics.areEqual(this.robotName, titleBannerState.robotName) && this.robotUin == titleBannerState.robotUin && this.robotTinyId == titleBannerState.robotTinyId && Intrinsics.areEqual(this.customTitleInfo, titleBannerState.customTitleInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((this.titleStyle * 31) + this.robotName.hashCode()) * 31) + a.a(this.robotUin)) * 31) + a.a(this.robotTinyId)) * 31;
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
            return "TitleBannerState(titleStyle=" + this.titleStyle + ", robotName=" + this.robotName + ", robotUin=" + this.robotUin + ", robotTinyId=" + this.robotTinyId + ", customTitleInfo=" + this.customTitleInfo + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$TitleTipState;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "showTip", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class TitleTipState extends SlashTitleUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean showTip;

        /* renamed from: a, reason: from getter */
        public final boolean getShowTip() {
            return this.showTip;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof TitleTipState) && this.showTip == ((TitleTipState) other).showTip) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.showTip;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "TitleTipState(showTip=" + this.showTip + ")";
        }
    }

    public /* synthetic */ SlashTitleUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    SlashTitleUIState() {
    }
}
