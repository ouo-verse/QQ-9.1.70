package com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar;

import com.tencent.mobileqq.guild.aiocombinestyle.component.local.LocalCombineStyleChainFactory;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.bd;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rs0.LiveUserEnterTipsModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/EnterTipsMessageManagerStrategy;", "", "Lrs0/a;", "liveUserEnterTipsModel", "", "e", "", "lists", "g", "f", "Lxr0/a;", "a", "Lxr0/a;", "guildLiveAioOperation", "Lcom/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/QQGuildChatBarLiveFragment;", "b", "Lcom/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/QQGuildChatBarLiveFragment;", "chatBarLiveFragment", "Ljava/util/Queue;", "c", "Ljava/util/Queue;", "enterRoomTipsMsgQueue", "Lcom/tencent/mobileqq/guild/util/bd;", "d", "Lcom/tencent/mobileqq/guild/util/bd;", "guildUIHandler", "<init>", "(Lxr0/a;Lcom/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/QQGuildChatBarLiveFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class EnterTipsMessageManagerStrategy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final xr0.a guildLiveAioOperation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQGuildChatBarLiveFragment chatBarLiveFragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Queue<LiveUserEnterTipsModel> enterRoomTipsMsgQueue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bd guildUIHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/EnterTipsMessageManagerStrategy$a", "Lkotlin/Function0;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements Function0<Unit> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LiveUserEnterTipsModel f226587e;

        a(LiveUserEnterTipsModel liveUserEnterTipsModel) {
            this.f226587e = liveUserEnterTipsModel;
        }

        public void a() {
            if (QQGuildChatBarLiveFragmentKt.f()) {
                return;
            }
            QQGuildChatBarLiveFragmentKt.g(EnterTipsMessageManagerStrategy.this.chatBarLiveFragment, this.f226587e.getTinyId(), false);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public EnterTipsMessageManagerStrategy(@NotNull xr0.a guildLiveAioOperation, @NotNull QQGuildChatBarLiveFragment chatBarLiveFragment) {
        Intrinsics.checkNotNullParameter(guildLiveAioOperation, "guildLiveAioOperation");
        Intrinsics.checkNotNullParameter(chatBarLiveFragment, "chatBarLiveFragment");
        this.guildLiveAioOperation = guildLiveAioOperation;
        this.chatBarLiveFragment = chatBarLiveFragment;
        this.enterRoomTipsMsgQueue = new LinkedBlockingQueue();
        this.guildUIHandler = new bd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(LiveUserEnterTipsModel liveUserEnterTipsModel) {
        this.guildLiveAioOperation.c(LocalCombineStyleChainFactory.f213886a.e(GLiveChannelCore.f226698a.s().getGuildId(), liveUserEnterTipsModel.getTinyId(), liveUserEnterTipsModel.getNickName(), liveUserEnterTipsModel.getIsGuest(), new a(liveUserEnterTipsModel)));
    }

    public final void f() {
        this.guildUIHandler.d();
    }

    public final void g(@NotNull List<? extends LiveUserEnterTipsModel> lists) {
        boolean z16;
        Intrinsics.checkNotNullParameter(lists, "lists");
        if (this.enterRoomTipsMsgQueue.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        for (LiveUserEnterTipsModel liveUserEnterTipsModel : lists) {
            if (this.enterRoomTipsMsgQueue.size() >= 20) {
                break;
            } else {
                this.enterRoomTipsMsgQueue.add(liveUserEnterTipsModel);
            }
        }
        if (z16) {
            this.guildUIHandler.c(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.EnterTipsMessageManagerStrategy$handlerEnterTipsMessage$1
                @Override // java.lang.Runnable
                public void run() {
                    Queue queue;
                    Queue queue2;
                    boolean z17;
                    bd bdVar;
                    queue = EnterTipsMessageManagerStrategy.this.enterRoomTipsMsgQueue;
                    LiveUserEnterTipsModel liveUserEnterTipsModel2 = (LiveUserEnterTipsModel) queue.poll();
                    if (liveUserEnterTipsModel2 != null) {
                        EnterTipsMessageManagerStrategy.this.e(liveUserEnterTipsModel2);
                    }
                    queue2 = EnterTipsMessageManagerStrategy.this.enterRoomTipsMsgQueue;
                    if (queue2.size() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        bdVar = EnterTipsMessageManagerStrategy.this.guildUIHandler;
                        bdVar.c(this, 200L);
                    }
                }
            }, 200L);
        }
    }
}
