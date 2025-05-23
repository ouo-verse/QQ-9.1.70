package com.tencent.mobileqq.activity.home.chats.biz.guild;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.GuildPublicAccountParams;
import com.tencent.mobileqq.guild.api.IGuildDiscoverApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ay;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.adapter.itemdata.h;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.GuildAbstractType;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u00020\t*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\t*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0002\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/ItemClickUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "recentItem", "", "j", "Landroid/os/Bundle;", "", "k", "d", "", "type", "c", "g", "Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "publicAccountParams", "e", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "interestedIn", "invoke", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ItemClickUseCase implements com.tencent.qqnt.chats.main.vm.usecase.click.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\t\u001a\u00020\b*\u00020\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/ItemClickUseCase$a;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "recentItem", "", "c", "d", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "", "e", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.chats.biz.guild.ItemClickUseCase$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(g recentItem) {
            if (recentItem.n() == 16) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(g recentItem) {
            if (recentItem.n() == 103 && recentItem.l() == Long.parseLong(AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String e(@NotNull b.a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            if (aVar.b() instanceof g) {
                com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = aVar.b();
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
                g gVar = (g) b16;
                return "ClickParams(item=" + gVar.k() + "/guildId=" + ex3.a.f(gVar.s()) + "/guildName=" + ay.a(ex3.a.g(gVar.s())) + ")";
            }
            return "ClickParams(item=not RecentContactChatItem)";
        }

        Companion() {
        }
    }

    private final int c(int type) {
        if (type != 4) {
            if (type != 6) {
                return 0;
            }
            return 5;
        }
        return 1;
    }

    private final void d(Bundle bundle, g gVar) {
        boolean z16;
        GuildContactInfo guildContactInfo = gVar.s().guildContactInfo;
        String str = guildContactInfo.locationId;
        if (str == null) {
            str = "";
        }
        int c16 = c(guildContactInfo.grayAbstractType.mainType);
        if (c16 > 0) {
            bundle.putInt("guild_feed_list_top_type", c16);
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !Intrinsics.areEqual(str, "0")) {
                bundle.putString("guild_feed_list_top_business", str);
            }
            GuildAbstractType guildAbstractType = guildContactInfo.grayAbstractType;
            QLog.i("Guild.ItemClickUseCase", 1, "[openStandaloneGuild] handleInsertData guildAbstractMainType: " + guildAbstractType.mainType + ", guildAbstractSubType: " + guildAbstractType.subType + ", locationId:" + str);
        }
    }

    private final void e(Context context, GuildPublicAccountParams publicAccountParams) {
        if (publicAccountParams == null) {
            publicAccountParams = new GuildPublicAccountParams(1);
        }
        ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).openDiscoverFromPublicAccount(context, publicAccountParams);
    }

    static /* synthetic */ void f(ItemClickUseCase itemClickUseCase, Context context, GuildPublicAccountParams guildPublicAccountParams, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            guildPublicAccountParams = null;
        }
        itemClickUseCase.e(context, guildPublicAccountParams);
    }

    private final boolean g(final Context context, g recentItem) {
        if (recentItem.x().b() > 0) {
            w e16 = f.e();
            if (e16 != null) {
                e16.setMsgRead(new Contact(recentItem.n(), recentItem.k(), ""), new IOperateCallback() { // from class: com.tencent.mobileqq.activity.home.chats.biz.guild.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        ItemClickUseCase.h(i3, str);
                    }
                });
            }
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).asyncGetLastMsgRecord(recentItem.s(), new IMsgOperateCallback() { // from class: com.tencent.mobileqq.activity.home.chats.biz.guild.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    ItemClickUseCase.i(ItemClickUseCase.this, context, i3, str, arrayList);
                }
            });
            return true;
        }
        f(this, context, null, 2, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ItemClickUseCase this$0, Context context, int i3, String str, ArrayList list) {
        Object last;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Logger.f235387a.d().i("Guild.ItemClickUseCase", 1, "asyncGetLastMsgRecord " + i3 + ", " + str + ", " + list.size());
        Intrinsics.checkNotNullExpressionValue(list, "list");
        if (!list.isEmpty()) {
            IPublicAccountMsgExtMrg iPublicAccountMsgExtMrg = (IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class);
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            Intrinsics.checkNotNullExpressionValue(last, "list.last()");
            this$0.e(context, RecentUtil.D(iPublicAccountMsgExtMrg.getBusiIdExtra((MsgRecord) last)));
            return;
        }
        f(this$0, context, null, 2, null);
    }

    private final boolean j(Context context, g recentItem) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("guild_facade_type", GuildFacadeType.ChatList);
        k(bundle, recentItem);
        d(bundle, recentItem);
        bundle.putBoolean(JumpGuildParam.EXTRA_NEED_OPEN_PUBLISHER, h.a(recentItem));
        af1.a b16 = af1.a.INSTANCE.b(ex3.a.f(recentItem.s()), "", bundle);
        if (recentItem.o() != 9) {
            com.tencent.mobileqq.guild.report.b.g("msg_tab_list_channel", "Guild.ItemClickUseCase");
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(context, b16.getJumpGuildParam());
        return true;
    }

    private final void k(Bundle bundle, g gVar) {
        bundle.putSerializable("JumpSource", "chat_list");
        bundle.putSerializable("UnreadType", Integer.valueOf(gVar.x().c()));
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        Companion companion = INSTANCE;
        QLog.i("Guild.ItemClickUseCase", 1, "interestedIn " + companion.e(params));
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        if (companion.c(gVar) || companion.d(gVar)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        Companion companion = INSTANCE;
        QLog.i("Guild.ItemClickUseCase", 1, "invoke " + companion.e(params));
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        try {
            if (companion.c(gVar)) {
                Context context = params.c().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "params.view.context");
                j(context, gVar);
            }
            if (companion.d(gVar)) {
                Context context2 = params.c().getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "params.view.context");
                return g(context2, gVar);
            }
        } catch (Exception e16) {
            QLog.e("Guild.ItemClickUseCase", 1, "invoke " + INSTANCE.e(params), e16);
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a aVar) {
        return b.C9598b.a(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, String str) {
    }
}
