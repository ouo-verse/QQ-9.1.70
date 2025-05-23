package com.tencent.mobileqq.guild.feed.nativepublish.functionbar;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001:\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "<init>", "()V", "FunctionBarVisibility", "FunctionButtonsVisibilityState", "HideVideoInsertGuide", "InitBliVideoInsertGuide", "ReplayPartSelect", "SetEmojiSelected", "SetMarginBottom", "UpdateEmojiButton", "UpdateFunctionBarIfIsBeyondGuild", "UpdateInsertLoadingStatus", "a", "UpdatePublishBtnEnable", "UpdateTextCountOverLimit", "UpdateVideoEntranceStatus", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedPublishFunctionBarMviUIState implements MviUIState {

    @AutoEventName
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$FunctionBarVisibility;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class FunctionBarVisibility extends GuildFeedPublishFunctionBarMviUIState implements MsgIntent {
        @Override // com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMviUIState, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMviUIState.FunctionBarVisibility";
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return MsgIntent.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$FunctionButtonsVisibilityState;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "I", "a", "()I", "stateFlag", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class FunctionButtonsVisibilityState extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int stateFlag;

        public FunctionButtonsVisibilityState(int i3) {
            this.stateFlag = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getStateFlag() {
            return this.stateFlag;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$HideVideoInsertGuide;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class HideVideoInsertGuide extends GuildFeedPublishFunctionBarMviUIState {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$InitBliVideoInsertGuide;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class InitBliVideoInsertGuide extends GuildFeedPublishFunctionBarMviUIState {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$ReplayPartSelect;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "Ljava/lang/String;", "getPartName", "()Ljava/lang/String;", "partName", "", "e", "Z", "isSquare", "()Z", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$a;", "f", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$a;", "a", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$a;", "enableState", "<init>", "(Ljava/lang/String;ZLcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ReplayPartSelect extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String partName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isSquare;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a enableState;

        public ReplayPartSelect(@Nullable String str, boolean z16, @NotNull a enableState) {
            Intrinsics.checkNotNullParameter(enableState, "enableState");
            this.partName = str;
            this.isSquare = z16;
            this.enableState = enableState;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getEnableState() {
            return this.enableState;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$SetEmojiSelected;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "Z", "getSelected", "()Z", "selected", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class SetEmojiSelected extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean selected;

        public SetEmojiSelected(boolean z16) {
            this.selected = z16;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$SetMarginBottom;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "I", "getMarginBottom", "()I", NodeProps.MARGIN_BOTTOM, "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class SetMarginBottom extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int marginBottom;

        public SetMarginBottom(int i3) {
            this.marginBottom = i3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$UpdateEmojiButton;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "Z", "a", "()Z", "showKeyboard", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class UpdateEmojiButton extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean showKeyboard;

        public UpdateEmojiButton() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShowKeyboard() {
            return this.showKeyboard;
        }

        public UpdateEmojiButton(boolean z16) {
            this.showKeyboard = z16;
        }

        public /* synthetic */ UpdateEmojiButton(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$UpdateFunctionBarIfIsBeyondGuild;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "Z", "isBeyondGuild", "()Z", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class UpdateFunctionBarIfIsBeyondGuild extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isBeyondGuild;

        public UpdateFunctionBarIfIsBeyondGuild(boolean z16) {
            this.isBeyondGuild = z16;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$UpdateInsertLoadingStatus;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "Z", "getVisible", "()Z", NodeProps.VISIBLE, "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class UpdateInsertLoadingStatus extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean visible;

        public UpdateInsertLoadingStatus(boolean z16) {
            this.visible = z16;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$UpdatePublishBtnEnable;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "Z", "a", "()Z", "enable", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class UpdatePublishBtnEnable extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean enable;

        public UpdatePublishBtnEnable(boolean z16) {
            this.enable = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$UpdateTextCountOverLimit;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "I", "a", "()I", "overCount", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class UpdateTextCountOverLimit extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int overCount;

        public UpdateTextCountOverLimit() {
            this(0, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getOverCount() {
            return this.overCount;
        }

        public UpdateTextCountOverLimit(int i3) {
            this.overCount = i3;
        }

        public /* synthetic */ UpdateTextCountOverLimit(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$UpdateVideoEntranceStatus;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "", "d", "Z", "getEnable", "()Z", "enable", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class UpdateVideoEntranceStatus extends GuildFeedPublishFunctionBarMviUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean enable;

        public UpdateVideoEntranceStatus(boolean z16) {
            this.enable = z16;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$a;", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a {
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
