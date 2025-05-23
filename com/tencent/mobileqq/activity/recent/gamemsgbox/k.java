package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/k;", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "info", "", "f", "", "appId", "c", "e", "d", "", "g", "i", "a", "", "I", "gameBoxScene", "<init>", "(I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class k extends com.tencent.qqnt.chats.main.vm.datasource.filter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int gameBoxScene;

    public k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.gameBoxScene = i3;
        }
    }

    private final boolean c(String appId, com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerContact(info)) {
            return true;
        }
        String a16 = e.f185509a.a();
        if (a16 == null) {
            return false;
        }
        if (!Intrinsics.areEqual(a16, "all")) {
            if (Intrinsics.areEqual(a16, "partner")) {
                if (!f(info)) {
                    return true;
                }
            } else if (!Intrinsics.areEqual(appId, a16)) {
                return true;
            }
        }
        return false;
    }

    private final boolean d(com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        return !((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerContact(info);
    }

    private final boolean e(String appId, com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerContact(info)) {
            return true;
        }
        return !Intrinsics.areEqual(appId, "1112198072");
    }

    private final boolean f(com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        AppRuntime peekAppRuntime;
        boolean z16;
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerBox(info) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        List<com.tencent.mobileqq.gamecenter.data.n> recentPartnerList = ((IGameMsgManagerService) runtimeService).getRecentPartnerList();
        if (recentPartnerList != null) {
            for (com.tencent.mobileqq.gamecenter.data.n nVar : recentPartnerList) {
                if (nVar != null && nVar.o(info.s())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void g(final String appId) {
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.j
            @Override // java.lang.Runnable
            public final void run() {
                k.h(k.this, appId);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(k this$0, String appId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        this$0.i(appId);
    }

    private final void i(String appId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGameMsgBoxManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        SharedPreferences gameMsgBoxSp = ((IGameMsgBoxManager) runtimeService).getGameMsgBoxSp();
        int i3 = gameMsgBoxSp.getInt("size", 0);
        for (int i16 = 0; i16 < i3; i16++) {
            if (Intrinsics.areEqual(appId, String.valueOf(gameMsgBoxSp.getLong(String.valueOf(i16), 0L)))) {
                return;
            }
        }
        gameMsgBoxSp.edit().putLong(String.valueOf(i3), Long.parseLong(appId)).apply();
        int i17 = i3 + 1;
        gameMsgBoxSp.edit().putInt("size", i17).apply();
        QLog.i("updateGameAppIdListLocal", 1, "appId=" + appId + ", size=" + i17);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.filter.a
    public boolean a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        TempChatGameSession gameSessionFromPeerUid;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.n() != 105 || (gameSessionFromPeerUid = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUid(info.k())) == null) {
            return true;
        }
        String valueOf = String.valueOf(gameSessionFromPeerUid.gameAppId);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        GameSwitchConfig findGameSwitchConfig = ((IGameMsgManagerService) runtimeService).findGameSwitchConfig(valueOf);
        if (findGameSwitchConfig == null || findGameSwitchConfig.mSyncSwitch != 1 || findGameSwitchConfig.mBlockSwitch == 1) {
            return true;
        }
        g(valueOf);
        int i3 = this.gameBoxScene;
        if (i3 != 2) {
            if (i3 != 3) {
                return c(valueOf, info);
            }
            return d(info);
        }
        return e(valueOf, info);
    }
}
