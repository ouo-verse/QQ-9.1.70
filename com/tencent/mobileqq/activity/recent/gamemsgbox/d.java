package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msgbox.IGameMsgExtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0011\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/d;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "chatItem", "", "a", "info", "", "c", "b", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "d", "e", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.d$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52689);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(View view, com.tencent.qqnt.chats.core.adapter.itemdata.g chatItem) {
        ((IGameMsgExtApi) QRoute.api(IGameMsgExtApi.class)).clickApplyPartnerBox(view, chatItem.x().b());
    }

    private final String b(com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        TempChatGameSession gameSession;
        ArrayList<RecentContactExtAttr> p16 = info.p();
        if (p16 != null) {
            Iterator<RecentContactExtAttr> it = p16.iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next != null && (gameSession = next.gameSession) != null) {
                    Intrinsics.checkNotNullExpressionValue(gameSession, "gameSession");
                    return String.valueOf(gameSession.gameAppId);
                }
            }
            return "";
        }
        return "";
    }

    private final String c(com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        TempChatGameSession gameSession;
        ArrayList<RecentContactExtAttr> p16 = info.p();
        if (p16 != null) {
            Iterator<RecentContactExtAttr> it = p16.iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next != null && (gameSession = next.gameSession) != null) {
                    Intrinsics.checkNotNullExpressionValue(gameSession, "gameSession");
                    String str = gameSession.peerOpenId;
                    Intrinsics.checkNotNullExpressionValue(str, "this.peerOpenId");
                    return str;
                }
            }
            return "";
        }
        return "";
    }

    private final void d(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        String str;
        if (item.x().b() > 0) {
            str = "0";
        } else {
            str = "1";
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(QZoneShareManager.GLORY_OF_KINGS, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92050", "928869", c(item), "", "20", str);
    }

    private final void e(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(b(item), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92053", "989348", c(item), "", "20", "");
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(params.b() instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
        if (((com.tencent.qqnt.chats.core.adapter.itemdata.g) b16).n() != 105) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerBox(gVar)) {
            a(params.c(), gVar);
            return true;
        }
        String a16 = n.a(gVar.k());
        if (a16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(MobileQQ.sMobileQQ, a16, 5);
        QLog.i("GameBoxChatItemClick", 1, "enterGameMsgAio,friend=" + a16);
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerContact(gVar)) {
            d(gVar);
        } else if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isGamePartnerContact(gVar)) {
            e(gVar);
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).booleanValue();
        }
        return b.C9598b.a(this, aVar);
    }
}
