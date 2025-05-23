package com.tencent.mobileqq.guild.channel.frame.unread;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.api.IChatsUnreadAPI;
import com.tencent.qqnt.kernel.invorker.d;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u001c\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/unread/GuildChannelUnreadCountManager;", "", "", "g", "d", "e", "", "a", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "channelId", "Lcom/tencent/mobileqq/guild/channel/frame/unread/a;", "b", "Lcom/tencent/mobileqq/guild/channel/frame/unread/a;", "()Lcom/tencent/mobileqq/guild/channel/frame/unread/a;", "setUnreadCb", "(Lcom/tencent/mobileqq/guild/channel/frame/unread/a;)V", "unreadCb", "", "c", "I", "()I", "f", "(I)V", "unreadCnt", "com/tencent/mobileqq/guild/channel/frame/unread/GuildChannelUnreadCountManager$b", "Lcom/tencent/mobileqq/guild/channel/frame/unread/GuildChannelUnreadCountManager$b;", "unreadMsgCntObs", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/channel/frame/unread/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChannelUnreadCountManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a unreadCb;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int unreadCnt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b unreadMsgCntObs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/channel/frame/unread/GuildChannelUnreadCountManager$b", "Lcom/tencent/qqnt/kernel/invorker/d;", "", "listType", "unreadCnt", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "", "O0", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements d {
        b() {
        }

        @Override // com.tencent.qqnt.kernel.invorker.d
        public void O0(int listType, int unreadCnt, @Nullable List<RecentContactInfo> changedList) {
            if (listType == 1) {
                GuildChannelUnreadCountManager.this.g();
            }
        }
    }

    public GuildChannelUnreadCountManager(@NotNull String channelId, @NotNull a unreadCb) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(unreadCb, "unreadCb");
        this.channelId = channelId;
        this.unreadCb = unreadCb;
        this.unreadMsgCntObs = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.redpt.GuildChannelUnreadCountHelper_updateUnreadCnt", null, null, null, new GuildChannelUnreadCountManager$updateUnreadCnt$1(this, null), 14, null);
        }
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final a getUnreadCb() {
        return this.unreadCb;
    }

    /* renamed from: c, reason: from getter */
    public final int getUnreadCnt() {
        return this.unreadCnt;
    }

    public final void d() {
        ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).addExpandRecentContactListener(this.unreadMsgCntObs);
        g();
    }

    public final void e() {
        ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).removeExpandRecentContactListener(this.unreadMsgCntObs);
    }

    public final void f(int i3) {
        this.unreadCnt = i3;
    }
}
