package com.tencent.guild.aio.reserve2.busi.navigate.button.holder;

import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "()V", "NavButtonPaddingBottom", "NavButtonUnreadCntText", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildAIoNavigateButtonUIState implements GuildReserve2UIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonPaddingBottom;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState;", "", "d", "I", "a", "()I", NodeProps.PADDING_BOTTOM, "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class NavButtonPaddingBottom extends GuildAIoNavigateButtonUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int paddingBottom;

        public NavButtonPaddingBottom(int i3) {
            this.paddingBottom = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPaddingBottom() {
            return this.paddingBottom;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00112\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\r\u001a\u0004\u0018\u00010\nJ\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0007R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState;", "", "count", "", h.F, "c", "", "d", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", "f", "a", "b", "g", FileReaderHelper.OPEN_FILE_FROM_FORCE, "i", "I", "mUnreadCount", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "mAIOBottomMsg", "mLatestAIOTopMsg", "mLatestAIOMsg", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class NavButtonUnreadCntText extends GuildAIoNavigateButtonUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mUnreadCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private GuildMsgItem mAIOBottomMsg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private GuildMsgItem mLatestAIOTopMsg;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private GuildMsgItem mLatestAIOMsg;

        public static /* synthetic */ void j(NavButtonUnreadCntText navButtonUnreadCntText, GuildMsgItem guildMsgItem, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            navButtonUnreadCntText.i(guildMsgItem, z16);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getMAIOBottomMsg() {
            return this.mAIOBottomMsg;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final GuildMsgItem getMLatestAIOMsg() {
            return this.mLatestAIOMsg;
        }

        /* renamed from: c, reason: from getter */
        public final int getMUnreadCount() {
            return this.mUnreadCount;
        }

        public final boolean d() {
            GuildMsgItem guildMsgItem;
            if (this.mAIOBottomMsg != null && (guildMsgItem = this.mLatestAIOMsg) != null) {
                Intrinsics.checkNotNull(guildMsgItem);
                long msgSeq = guildMsgItem.getMsgSeq();
                GuildMsgItem guildMsgItem2 = this.mAIOBottomMsg;
                Intrinsics.checkNotNull(guildMsgItem2);
                if (msgSeq > guildMsgItem2.getMsgSeq()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
        
            if (r0 >= r2.getMsgSeq()) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean e() {
            GuildMsgItem guildMsgItem = this.mAIOBottomMsg;
            if (guildMsgItem != null && this.mLatestAIOTopMsg != null) {
                Intrinsics.checkNotNull(guildMsgItem);
                long msgSeq = guildMsgItem.getMsgSeq();
                GuildMsgItem guildMsgItem2 = this.mLatestAIOTopMsg;
                Intrinsics.checkNotNull(guildMsgItem2);
            }
            if (this.mUnreadCount > 0 && !d()) {
                return true;
            }
            return false;
        }

        public final void f(@Nullable GuildMsgItem msg2) {
            this.mAIOBottomMsg = msg2;
        }

        public final void g(@Nullable GuildMsgItem msg2) {
            this.mLatestAIOMsg = msg2;
        }

        public final void h(int count) {
            this.mUnreadCount = count;
        }

        public final void i(@Nullable GuildMsgItem msg2, boolean force) {
            if (msg2 == null) {
                return;
            }
            GuildMsgItem guildMsgItem = this.mLatestAIOTopMsg;
            if (guildMsgItem != null) {
                Intrinsics.checkNotNull(guildMsgItem);
                if (guildMsgItem.getMsgSeq() >= msg2.getMsgSeq() && !force) {
                    return;
                }
            }
            this.mLatestAIOTopMsg = msg2;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
