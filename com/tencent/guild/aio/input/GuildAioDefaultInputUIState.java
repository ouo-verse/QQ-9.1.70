package com.tencent.guild.aio.input;

import android.content.res.Configuration;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.msglist.a;
import com.tencent.aio.msgservice.j;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\u0016\u0018\u0000 \u00042\u00020\u0001: \u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006%"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "<init>", "()V", "d", "a", "GuideClearEditInput", "GuideInputHideState", "GuideInputRecallMsg", "GuideInputReplyMsg", "GuideReplaceInputEmotion", "GuildAtStateEvent", "GuildConfigurationChanged", "GuildFreqLimitInfo", "GuildGuestAuthTipVisibleChange", "GuildHandlerPermissionsChange", "GuildInputDismissPanel", "GuildInputHint", "GuildInputInsertAt", "GuildMultiSelectCountChanged", "GuildMultiSelectModeChanged", "GuildOnlineMemberUpdateLoop", "GuildSendResp", "GuildShowKeyboard", "GuildUpdateMuteChange", "GuildUpdateSpeakThresholdChange", "HideGuildOnlineMember", "InitAtCluster", "NavButtonPaddingBottom", "NotifyAtClusterAioOpened", "OnDestroy", "OnResume", "RecoverDraft", "RefreshSendBtn", "StyleUpdateEvent", "UpdateAtInfo", "UpdateSendBtnClickable", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildAioDefaultInputUIState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuideClearEditInput;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "Z", "a", "()Z", "clearReply", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuideClearEditInput extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean clearReply;

        public GuideClearEditInput() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getClearReply() {
            return this.clearReply;
        }

        public GuideClearEditInput(boolean z16) {
            this.clearReply = z16;
        }

        public /* synthetic */ GuideClearEditInput(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuideInputHideState;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "toString", "", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuideInputHideState extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final GuideInputHideState f110831e = new GuideInputHideState();

        GuideInputHideState() {
        }

        @NotNull
        public String toString() {
            return "GuideInputHideState";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuideInputRecallMsg;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "", "f", "Z", "b", "()Z", "processSpecialSymbol", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuideInputRecallMsg extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean processSpecialSymbol;

        public GuideInputRecallMsg(@NotNull MsgRecord msg2, boolean z16) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
            this.processSpecialSymbol = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsg() {
            return this.msg;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getProcessSpecialSymbol() {
            return this.processSpecialSymbol;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuideInputReplyMsg;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/aio/data/msglist/a;", "e", "Lcom/tencent/aio/data/msglist/a;", "a", "()Lcom/tencent/aio/data/msglist/a;", "msg", "", "f", "Z", "b", "()Z", "isInsertAt", "<init>", "(Lcom/tencent/aio/data/msglist/a;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuideInputReplyMsg extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a msg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean isInsertAt;

        public GuideInputReplyMsg(@NotNull a msg2, boolean z16) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
            this.isInsertAt = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getMsg() {
            return this.msg;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsInsertAt() {
            return this.isInsertAt;
        }

        public /* synthetic */ GuideInputReplyMsg(a aVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(aVar, (i3 & 2) != 0 ? true : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuideReplaceInputEmotion;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "emotionCode", "<init>", "(Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuideReplaceInputEmotion extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String emotionCode;

        public GuideReplaceInputEmotion(@NotNull String emotionCode) {
            Intrinsics.checkNotNullParameter(emotionCode, "emotionCode");
            this.emotionCode = emotionCode;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getEmotionCode() {
            return this.emotionCode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildAtStateEvent;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "ShowHashtagPanel", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static class GuildAtStateEvent extends GuildAioDefaultInputUIState {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildAtStateEvent$ShowHashtagPanel;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildAtStateEvent;", "", "e", "Z", "a", "()Z", ViewStickEventHelper.IS_SHOW, "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes6.dex */
        public static final class ShowHashtagPanel extends GuildAtStateEvent {

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private final boolean isShow;

            public ShowHashtagPanel(boolean z16) {
                this.isShow = z16;
            }

            /* renamed from: a, reason: from getter */
            public final boolean getIsShow() {
                return this.isShow;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildConfigurationChanged;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Landroid/content/res/Configuration;", "e", "Landroid/content/res/Configuration;", "getNewConfig", "()Landroid/content/res/Configuration;", "newConfig", "<init>", "(Landroid/content/res/Configuration;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildConfigurationChanged extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Configuration newConfig;

        public GuildConfigurationChanged(@NotNull Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            this.newConfig = newConfig;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildFreqLimitInfo;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildFreqLimitInfo extends GuildAioDefaultInputUIState {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildGuestAuthTipVisibleChange;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "Z", "a", "()Z", "showTip", "f", "b", "isJubao", "<init>", "(ZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildGuestAuthTipVisibleChange extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean showTip;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean isJubao;

        public GuildGuestAuthTipVisibleChange(boolean z16, boolean z17) {
            this.showTip = z16;
            this.isJubao = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShowTip() {
            return this.showTip;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsJubao() {
            return this.isJubao;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R%\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildHandlerPermissionsChange;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "I", "b", "()I", "permissions", "", "", "f", "Ljava/util/Map;", "getBusPermissions", "()Ljava/util/Map;", "busPermissions", "", h.F, "Z", "a", "()Z", "needHide", "<init>", "(ILjava/util/Map;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildHandlerPermissionsChange extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int permissions;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Map<String, Integer> busPermissions;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean needHide;

        public /* synthetic */ GuildHandlerPermissionsChange(int i3, Map map, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? null : map, (i16 & 4) != 0 ? false : z16);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNeedHide() {
            return this.needHide;
        }

        /* renamed from: b, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }

        public GuildHandlerPermissionsChange(int i3, @Nullable Map<String, Integer> map, boolean z16) {
            this.permissions = i3;
            this.busPermissions = map;
            this.needHide = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildInputDismissPanel;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuildInputDismissPanel extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final GuildInputDismissPanel f110844e = new GuildInputDismissPanel();

        GuildInputDismissPanel() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildInputHint;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "channelName", "", "f", "Z", "b", "()Z", "showRobotHint", "<init>", "(Ljava/lang/String;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildInputHint extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean showRobotHint;

        public GuildInputHint(@NotNull String channelName, boolean z16) {
            Intrinsics.checkNotNullParameter(channelName, "channelName");
            this.channelName = channelName;
            this.showRobotHint = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShowRobotHint() {
            return this.showRobotHint;
        }

        public /* synthetic */ GuildInputHint(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildInputInsertAt;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildInputInsertAt extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem msg;

        public GuildInputInsertAt(@NotNull GuildMsgItem msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getMsg() {
            return this.msg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildMultiSelectCountChanged;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "I", "a", "()I", "count", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildMultiSelectCountChanged extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int count;

        public GuildMultiSelectCountChanged(int i3) {
            this.count = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildMultiSelectModeChanged;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "e", "Z", "a", "()Z", "mode", "f", "b", "isJubao", h.F, "c", "isShowInputBar", "<init>", "(ZZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildMultiSelectModeChanged extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean mode;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isJubao;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShowInputBar;

        public GuildMultiSelectModeChanged(boolean z16, boolean z17, boolean z18) {
            this.mode = z16;
            this.isJubao = z17;
            this.isShowInputBar = z18;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getMode() {
            return this.mode;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsJubao() {
            return this.isJubao;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsShowInputBar() {
            return this.isShowInputBar;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildMultiSelectModeChanged)) {
                return false;
            }
            GuildMultiSelectModeChanged guildMultiSelectModeChanged = (GuildMultiSelectModeChanged) other;
            if (this.mode == guildMultiSelectModeChanged.mode && this.isJubao == guildMultiSelectModeChanged.isJubao && this.isShowInputBar == guildMultiSelectModeChanged.isShowInputBar) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z16 = this.mode;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            ?? r26 = this.isJubao;
            int i17 = r26;
            if (r26 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            boolean z17 = this.isShowInputBar;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "GuildMultiSelectModeChanged(mode=" + this.mode + ", isJubao=" + this.isJubao + ", isShowInputBar=" + this.isShowInputBar + ")";
        }

        public /* synthetic */ GuildMultiSelectModeChanged(boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildOnlineMemberUpdateLoop;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "", "f", "J", "getChannelId", "()J", "channelId", "<init>", "(Ljava/lang/String;J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildOnlineMemberUpdateLoop extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long channelId;

        public GuildOnlineMemberUpdateLoop(@NotNull String guildId, long j3) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.guildId = guildId;
            this.channelId = j3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildSendResp;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/aio/msgservice/j;", "", "e", "Lcom/tencent/aio/msgservice/j;", "a", "()Lcom/tencent/aio/msgservice/j;", "resp", "<init>", "(Lcom/tencent/aio/msgservice/j;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildSendResp extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final j<String> resp;

        public GuildSendResp(@NotNull j<String> resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            this.resp = resp;
        }

        @NotNull
        public final j<String> a() {
            return this.resp;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildShowKeyboard;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "toString", "", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuildShowKeyboard extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final GuildShowKeyboard f110855e = new GuildShowKeyboard();

        GuildShowKeyboard() {
        }

        @NotNull
        public String toString() {
            return "GuildShowKeyboard";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildUpdateMuteChange;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "I", "b", "()I", "permissions", "", "f", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "muteTxt", "", h.F, "Z", "d", "()Z", "isSelectMode", "i", "c", "showRealAuth", "<init>", "(ILjava/lang/String;ZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildUpdateMuteChange extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int permissions;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String muteTxt;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean isSelectMode;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean showRealAuth;

        public /* synthetic */ GuildUpdateMuteChange(int i3, String str, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? false : z17);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getMuteTxt() {
            return this.muteTxt;
        }

        /* renamed from: b, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getShowRealAuth() {
            return this.showRealAuth;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSelectMode() {
            return this.isSelectMode;
        }

        public GuildUpdateMuteChange(int i3, @NotNull String muteTxt, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(muteTxt, "muteTxt");
            this.permissions = i3;
            this.muteTxt = muteTxt;
            this.isSelectMode = z16;
            this.showRealAuth = z17;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildUpdateSpeakThresholdChange;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "I", "c", "()I", "permissions", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "b", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "limit", "", h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "guildId", "", "i", "Z", "d", "()Z", "isSelectMode", "<init>", "(ILcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;Ljava/lang/String;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildUpdateSpeakThresholdChange extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int permissions;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IGuildSpeakableThresholdPermission limit;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean isSelectMode;

        public GuildUpdateSpeakThresholdChange(int i3, @NotNull IGuildSpeakableThresholdPermission limit, @NotNull String guildId, boolean z16) {
            Intrinsics.checkNotNullParameter(limit, "limit");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.permissions = i3;
            this.limit = limit;
            this.guildId = guildId;
            this.isSelectMode = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final IGuildSpeakableThresholdPermission getLimit() {
            return this.limit;
        }

        /* renamed from: c, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSelectMode() {
            return this.isSelectMode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$HideGuildOnlineMember;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class HideGuildOnlineMember extends GuildAioDefaultInputUIState {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$InitAtCluster;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "a", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class InitAtCluster extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.api.runtime.a aioContext;

        public InitAtCluster(@NotNull com.tencent.aio.api.runtime.a aioContext) {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            this.aioContext = aioContext;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.api.runtime.a getAioContext() {
            return this.aioContext;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$NavButtonPaddingBottom;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "I", "getHeight", "()I", "height", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class NavButtonPaddingBottom extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int height;

        public NavButtonPaddingBottom(int i3) {
            this.height = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$NotifyAtClusterAioOpened;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NotifyAtClusterAioOpened extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final NotifyAtClusterAioOpened f110866e = new NotifyAtClusterAioOpened();

        NotifyAtClusterAioOpened() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$OnDestroy;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OnDestroy extends GuildAioDefaultInputUIState {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$OnResume;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OnResume extends GuildAioDefaultInputUIState {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$RecoverDraft;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "msgElements", "", "f", "Z", "b", "()Z", "processSpecialSymbol", "<init>", "(Ljava/util/ArrayList;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class RecoverDraft extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<MsgElement> msgElements;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean processSpecialSymbol;

        public RecoverDraft(@NotNull ArrayList<MsgElement> msgElements, boolean z16) {
            Intrinsics.checkNotNullParameter(msgElements, "msgElements");
            this.msgElements = msgElements;
            this.processSpecialSymbol = z16;
        }

        @NotNull
        public final ArrayList<MsgElement> a() {
            return this.msgElements;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getProcessSpecialSymbol() {
            return this.processSpecialSymbol;
        }

        public /* synthetic */ RecoverDraft(ArrayList arrayList, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(arrayList, (i3 & 2) != 0 ? true : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$RefreshSendBtn;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "I", "a", "()I", "selectedMediaCount", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class RefreshSendBtn extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int selectedMediaCount;

        public RefreshSendBtn(int i3) {
            this.selectedMediaCount = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getSelectedMediaCount() {
            return this.selectedMediaCount;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$StyleUpdateEvent;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "Z", "a", "()Z", "isDarkMode", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class StyleUpdateEvent extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isDarkMode;

        public StyleUpdateEvent(boolean z16) {
            this.isDarkMode = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsDarkMode() {
            return this.isDarkMode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$UpdateAtInfo;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "a", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "f", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "atTinyId", h.F, "c", "atUserName", "<init>", "(Lcom/tencent/aio/api/runtime/a;Ljava/lang/String;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateAtInfo extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.api.runtime.a aioContext;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String atTinyId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String atUserName;

        public UpdateAtInfo(@NotNull com.tencent.aio.api.runtime.a aioContext, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            this.aioContext = aioContext;
            this.atTinyId = str;
            this.atUserName = str2;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.api.runtime.a getAioContext() {
            return this.aioContext;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getAtTinyId() {
            return this.atTinyId;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getAtUserName() {
            return this.atUserName;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$UpdateSendBtnClickable;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "e", "Z", "a", "()Z", "clickable", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateSendBtnClickable extends GuildAioDefaultInputUIState {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean clickable;

        public UpdateSendBtnClickable(boolean z16) {
            this.clickable = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getClickable() {
            return this.clickable;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
