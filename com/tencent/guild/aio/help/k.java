package com.tencent.guild.aio.help;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.gift.IGuildGiftApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\b*\u0001\u0018\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/aio/help/k;", "Lcom/tencent/aio/main/businesshelper/h;", "", tl.h.F, "i", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "k", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "", "Z", "stopPyUser", "com/tencent/guild/aio/help/k$b", "f", "Lcom/tencent/guild/aio/help/k$b;", "action", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class k implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean stopPyUser;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/help/k$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            k.this.k(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void e() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.StartGiftAnimationEvent.class).getQualifiedName(), this.action);
        com.tencent.aio.main.businesshelper.b bVar2 = this.param;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar2 = null;
        }
        bVar2.a().e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgItemContentViewClickEvent.class).getQualifiedName(), this.action);
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar3 = null;
        }
        bVar3.a().e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.StopGiftAnimationByUserEvent.class).getQualifiedName(), this.action);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.help.j
            @Override // java.lang.Runnable
            public final void run() {
                k.g();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        ((IGuildGiftApi) QRoute.api(IGuildGiftApi.class)).enterRoom();
    }

    private final void h() {
        ((IGuildGiftApi) QRoute.api(IGuildGiftApi.class)).exitRoom();
        ((IGuildGiftApi) QRoute.api(IGuildGiftApi.class)).releaseAnimationEngine();
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.StartGiftAnimationEvent.class).getQualifiedName(), this.action);
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgItemContentViewClickEvent.class).getQualifiedName(), this.action);
    }

    private final void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.help.i
            @Override // java.lang.Runnable
            public final void run() {
                k.j();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        ((IGuildGiftApi) QRoute.api(IGuildGiftApi.class)).preLoadGiftData("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(MsgIntent i3) {
        com.tencent.aio.main.businesshelper.b bVar;
        com.tencent.aio.main.businesshelper.b bVar2;
        if (i3 instanceof GuildMsgListIntent.StartGiftAnimationEvent) {
            if (!this.stopPyUser) {
                IGuildGiftApi iGuildGiftApi = (IGuildGiftApi) QRoute.api(IGuildGiftApi.class);
                com.tencent.aio.main.businesshelper.b bVar3 = this.param;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar2 = null;
                } else {
                    bVar2 = bVar3;
                }
                GuildMsgListIntent.StartGiftAnimationEvent startGiftAnimationEvent = (GuildMsgListIntent.StartGiftAnimationEvent) i3;
                iGuildGiftApi.startGiftAnimation(bVar2, startGiftAnimationEvent.getGuildMsgItem(), startGiftAnimationEvent.getIsClick(), startGiftAnimationEvent.getIsNewGiftMessage(), startGiftAnimationEvent.getGuildId());
                return;
            }
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMsgItemContentViewClickEvent) {
            IGuildGiftApi iGuildGiftApi2 = (IGuildGiftApi) QRoute.api(IGuildGiftApi.class);
            com.tencent.aio.main.businesshelper.b bVar4 = this.param;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            } else {
                bVar = bVar4;
            }
            GuildMsgListIntent.GuildMsgItemContentViewClickEvent guildMsgItemContentViewClickEvent = (GuildMsgListIntent.GuildMsgItemContentViewClickEvent) i3;
            com.tencent.aio.data.msglist.a msgItem = guildMsgItemContentViewClickEvent.getMsgItem();
            Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            iGuildGiftApi2.startGiftAnimation(bVar, (GuildMsgItem) msgItem, true, false, ((GuildMsgItem) guildMsgItemContentViewClickEvent.getMsgItem()).getMsgRecord().guildId);
            return;
        }
        if (i3 instanceof GuildMsgListIntent.StopGiftAnimationByUserEvent) {
            this.stopPyUser = true;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 17;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GuildGiftHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.stopPyUser = false;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 3) {
                if (state == 12) {
                    h();
                    return;
                }
                return;
            }
            i();
            return;
        }
        e();
    }
}
