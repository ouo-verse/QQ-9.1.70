package com.tencent.guildlive.aio.input;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0014\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0014\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+\u00a8\u0006,"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "<init>", "()V", "GuideHideKeyboard", "GuildClearEditInput", "GuildHandlerPermissionsChange", "GuildInputHint", "GuildInputPanelChange", "GuildInputReplyMsg", "GuildLiveLongClickAvatar", "GuildMultiSelectState", "GuildReplaceInputEmotion", "GuildSendResp", "GuildShowKeyboard", "InitAtCluster", "LiveInputToast", "MultiSelectCountChanged", "RecoverDraft", "ReeditMsg", "SendSuccessUIState", "UpdateInputText", "UpdateTextWatcherUIState", "VideoScreenChange", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuideHideKeyboard;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildClearEditInput;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildHandlerPermissionsChange;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildInputHint;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildInputPanelChange;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildInputReplyMsg;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildLiveLongClickAvatar;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildMultiSelectState;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildReplaceInputEmotion;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildSendResp;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildShowKeyboard;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$InitAtCluster;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$LiveInputToast;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$MultiSelectCountChanged;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$RecoverDraft;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$ReeditMsg;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$SendSuccessUIState;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$UpdateInputText;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$UpdateTextWatcherUIState;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$VideoScreenChange;", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class GuildLiveAioInputUIState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuideHideKeyboard;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuideHideKeyboard extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GuideHideKeyboard f112723d = new GuideHideKeyboard();

        GuideHideKeyboard() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildClearEditInput;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuildClearEditInput extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GuildClearEditInput f112724d = new GuildClearEditInput();

        GuildClearEditInput() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildHandlerPermissionsChange;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "I", "a", "()I", "permissions", "<init>", "(I)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildHandlerPermissionsChange extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int permissions;

        public GuildHandlerPermissionsChange(int i3) {
            super(null);
            this.permissions = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildInputHint;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "channelName", "<init>", "(Ljava/lang/String;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildInputHint extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildInputHint(@NotNull String channelName) {
            super(null);
            Intrinsics.checkNotNullParameter(channelName, "channelName");
            this.channelName = channelName;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildInputPanelChange;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "Z", "b", "()Z", "panelShow", "e", "a", "keyboardShow", "<init>", "(ZZ)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildInputPanelChange extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean panelShow;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean keyboardShow;

        public GuildInputPanelChange(boolean z16, boolean z17) {
            super(null);
            this.panelShow = z16;
            this.keyboardShow = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getKeyboardShow() {
            return this.keyboardShow;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getPanelShow() {
            return this.panelShow;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildInputReplyMsg;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "a", "()Lcom/tencent/aio/data/msglist/a;", "msg", "", "e", "Z", "b", "()Z", "isInsertAt", "<init>", "(Lcom/tencent/aio/data/msglist/a;Z)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildInputReplyMsg extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.data.msglist.a msg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isInsertAt;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildInputReplyMsg(@NotNull com.tencent.aio.data.msglist.a msg2, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
            this.isInsertAt = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.data.msglist.a getMsg() {
            return this.msg;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsInsertAt() {
            return this.isInsertAt;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildLiveLongClickAvatar;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildLiveLongClickAvatar extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem msgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildLiveLongClickAvatar(@NotNull GuildMsgItem msgItem) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getMsgItem() {
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildMultiSelectState;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "Z", "a", "()Z", "show", "<init>", "(Z)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildMultiSelectState extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean show;

        public GuildMultiSelectState(boolean z16) {
            super(null);
            this.show = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildReplaceInputEmotion;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "emotionCode", "<init>", "(Ljava/lang/String;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildReplaceInputEmotion extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String emotionCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildReplaceInputEmotion(@NotNull String emotionCode) {
            super(null);
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
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildSendResp;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Lcom/tencent/aio/msgservice/j;", "", "d", "Lcom/tencent/aio/msgservice/j;", "a", "()Lcom/tencent/aio/msgservice/j;", "resp", "<init>", "(Lcom/tencent/aio/msgservice/j;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildSendResp extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.msgservice.j<String> resp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildSendResp(@NotNull com.tencent.aio.msgservice.j<String> resp) {
            super(null);
            Intrinsics.checkNotNullParameter(resp, "resp");
            this.resp = resp;
        }

        @NotNull
        public final com.tencent.aio.msgservice.j<String> a() {
            return this.resp;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildShowKeyboard;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuildShowKeyboard extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GuildShowKeyboard f112735d = new GuildShowKeyboard();

        GuildShowKeyboard() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$InitAtCluster;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Lcom/tencent/aio/data/AIOParam;", "d", "Lcom/tencent/aio/data/AIOParam;", "a", "()Lcom/tencent/aio/data/AIOParam;", "aioParam", "<init>", "(Lcom/tencent/aio/data/AIOParam;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class InitAtCluster extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOParam aioParam;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitAtCluster(@NotNull AIOParam aioParam) {
            super(null);
            Intrinsics.checkNotNullParameter(aioParam, "aioParam");
            this.aioParam = aioParam;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AIOParam getAioParam() {
            return this.aioParam;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$LiveInputToast;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "msg", "", "e", "I", "a", "()I", "iconType", "<init>", "(Ljava/lang/Object;I)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class LiveInputToast extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object msg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int iconType;

        public /* synthetic */ LiveInputToast(Object obj, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i16 & 2) != 0 ? 0 : i3);
        }

        /* renamed from: a, reason: from getter */
        public final int getIconType() {
            return this.iconType;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Object getMsg() {
            return this.msg;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveInputToast(@NotNull Object msg2, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
            this.iconType = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$MultiSelectCountChanged;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "I", "a", "()I", "count", "<init>", "(I)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class MultiSelectCountChanged extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int count;

        public MultiSelectCountChanged(int i3) {
            super(null);
            this.count = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$RecoverDraft;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "msgElements", "Lcom/tencent/aio/data/AIOParam;", "e", "Lcom/tencent/aio/data/AIOParam;", "a", "()Lcom/tencent/aio/data/AIOParam;", "aioParam", "<init>", "(Ljava/util/ArrayList;Lcom/tencent/aio/data/AIOParam;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class RecoverDraft extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<MsgElement> msgElements;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOParam aioParam;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecoverDraft(@NotNull ArrayList<MsgElement> msgElements, @NotNull AIOParam aioParam) {
            super(null);
            Intrinsics.checkNotNullParameter(msgElements, "msgElements");
            Intrinsics.checkNotNullParameter(aioParam, "aioParam");
            this.msgElements = msgElements;
            this.aioParam = aioParam;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AIOParam getAioParam() {
            return this.aioParam;
        }

        @NotNull
        public final ArrayList<MsgElement> b() {
            return this.msgElements;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$ReeditMsg;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "getContext", "()Lcom/tencent/aio/api/runtime/a;", "context", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/aio/api/runtime/a;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class ReeditMsg extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.api.runtime.a context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReeditMsg(@NotNull MsgRecord msgRecord, @NotNull com.tencent.aio.api.runtime.a context) {
            super(null);
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(context, "context");
            this.msgRecord = msgRecord;
            this.context = context;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$SendSuccessUIState;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SendSuccessUIState extends GuildLiveAioInputUIState {
        public SendSuccessUIState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$UpdateInputText;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "msg", "<init>", "(Ljava/lang/String;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateInputText extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String msg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateInputText(@NotNull String msg2) {
            super(null);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$UpdateTextWatcherUIState;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Lcom/tencent/aio/data/AIOParam;", "d", "Lcom/tencent/aio/data/AIOParam;", "a", "()Lcom/tencent/aio/data/AIOParam;", "aioParam", "<init>", "(Lcom/tencent/aio/data/AIOParam;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateTextWatcherUIState extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOParam aioParam;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateTextWatcherUIState(@NotNull AIOParam aioParam) {
            super(null);
            Intrinsics.checkNotNullParameter(aioParam, "aioParam");
            this.aioParam = aioParam;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AIOParam getAioParam() {
            return this.aioParam;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$VideoScreenChange;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "", "d", "I", "a", "()I", "videoScreenState", "<init>", "(I)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class VideoScreenChange extends GuildLiveAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int videoScreenState;

        public VideoScreenChange(int i3) {
            super(null);
            this.videoScreenState = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVideoScreenState() {
            return this.videoScreenState;
        }
    }

    public /* synthetic */ GuildLiveAioInputUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    GuildLiveAioInputUIState() {
    }
}
