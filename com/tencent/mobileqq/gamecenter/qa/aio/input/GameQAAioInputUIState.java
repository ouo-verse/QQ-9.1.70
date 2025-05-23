package com.tencent.mobileqq.gamecenter.qa.aio.input;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\f\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "AioFoldFinish", "AioFoldStart", "AioUnFoldFinish", "GuideClearEditInput", "GuideInputRecallMsg", "GuideInputReplyMsg", "GuildHandlePermissionsChange", "GuildInputInsertAt", "GuildMultiSelectCountChanged", "GuildMultiSelectModeChanged", "KeyboardStatusChange", "SessionInfoChange", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$AioFoldFinish;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$AioFoldStart;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$AioUnFoldFinish;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuideClearEditInput;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuideInputRecallMsg;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuideInputReplyMsg;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuildHandlePermissionsChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuildInputInsertAt;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuildMultiSelectCountChanged;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuildMultiSelectModeChanged;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$KeyboardStatusChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$SessionInfoChange;", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public abstract class GameQAAioInputUIState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$AioFoldFinish;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class AioFoldFinish extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AioFoldFinish f212326d = new AioFoldFinish();

        AioFoldFinish() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$AioFoldStart;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class AioFoldStart extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AioFoldStart f212327d = new AioFoldStart();

        AioFoldStart() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$AioUnFoldFinish;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class AioUnFoldFinish extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AioUnFoldFinish f212328d = new AioUnFoldFinish();

        AioUnFoldFinish() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuideClearEditInput;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class GuideClearEditInput extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GuideClearEditInput f212329d = new GuideClearEditInput();

        GuideClearEditInput() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuideInputRecallMsg;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class GuideInputRecallMsg extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuideInputRecallMsg(@NotNull MsgRecord msg2) {
            super(null);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsg() {
            return this.msg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuideInputReplyMsg;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "a", "()Lcom/tencent/aio/data/msglist/a;", "msg", "", "e", "Z", "b", "()Z", "isInsertAt", "<init>", "(Lcom/tencent/aio/data/msglist/a;Z)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class GuideInputReplyMsg extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.data.msglist.a msg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isInsertAt;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuideInputReplyMsg(@NotNull com.tencent.aio.data.msglist.a msg2, boolean z16) {
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuildHandlePermissionsChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "", "d", "I", "a", "()I", "permissions", "<init>", "(I)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class GuildHandlePermissionsChange extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int permissions;

        public GuildHandlePermissionsChange(int i3) {
            super(null);
            this.permissions = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuildInputInsertAt;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "a", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class GuildInputInsertAt extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildMsgItem msg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildInputInsertAt(@NotNull GuildMsgItem msg2) {
            super(null);
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuildMultiSelectCountChanged;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "", "d", "I", "a", "()I", "count", "<init>", "(I)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class GuildMultiSelectCountChanged extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int count;

        public GuildMultiSelectCountChanged(int i3) {
            super(null);
            this.count = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$GuildMultiSelectModeChanged;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "mode", "e", "b", "isJubao", "f", "c", "isShowInputBar", "<init>", "(ZZZ)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class GuildMultiSelectModeChanged extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean mode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isJubao;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShowInputBar;

        public GuildMultiSelectModeChanged(boolean z16, boolean z17, boolean z18) {
            super(null);
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
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$KeyboardStatusChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "", "d", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "show", "<init>", "(Ljava/lang/Boolean;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class KeyboardStatusChange extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Boolean show;

        public KeyboardStatusChange(@Nullable Boolean bool) {
            super(null);
            this.show = bool;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Boolean getShow() {
            return this.show;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState$SessionInfoChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "Lvd1/b;", "d", "Lvd1/b;", "a", "()Lvd1/b;", "gameSessionInfo", "<init>", "(Lvd1/b;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class SessionInfoChange extends GameQAAioInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final vd1.b gameSessionInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SessionInfoChange(@NotNull vd1.b gameSessionInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(gameSessionInfo, "gameSessionInfo");
            this.gameSessionInfo = gameSessionInfo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final vd1.b getGameSessionInfo() {
            return this.gameSessionInfo;
        }
    }

    public /* synthetic */ GameQAAioInputUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    GameQAAioInputUIState() {
    }
}
