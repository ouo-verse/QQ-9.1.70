package com.tencent.mobileqq.qqgamepub.ipc;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static volatile b f264599f;

    /* renamed from: d, reason: collision with root package name */
    private int f264600d;

    /* renamed from: e, reason: collision with root package name */
    private int f264601e;

    public b(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    private void c(String str, Bundle bundle, int i3, AppRuntime appRuntime) {
        if ("doOnDestory".equals(str)) {
            ((IGameMsgManagerService) appRuntime.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
            return;
        }
        if ("getGameMsgUrl".equals(str)) {
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appRuntime.getRuntimeService(IGameMsgManagerService.class, "");
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_get_msg_list_url", iGameMsgManagerService.getGameMsgListUrl());
            callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
            return;
        }
        if ("saveGalleryDataToMsg".equals(str)) {
            ((IGamePubAccountMsgService) appRuntime.getRuntimeService(IGamePubAccountMsgService.class, "")).saveGalleryDataToMsg(bundle);
            return;
        }
        if ("clearUnreadMsg".equals(str)) {
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).setMsgRead();
            return;
        }
        if ("openSessionPage".equals(str)) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).openGameMsgSessionPage(appRuntime.getApplication(), null, "other");
            return;
        }
        if ("action_set_clean_req_time".equals(str)) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).setLastCleanReqMsgTime(appRuntime.getAccount(), System.currentTimeMillis());
        } else if ("callbackGameStrategyAnswer".equals(str)) {
            this.f264601e = i3;
        } else if ("callbackGameStrategyQuestion".equals(str)) {
            this.f264600d = i3;
        }
    }

    public static b d() {
        if (f264599f == null) {
            synchronized (b.class) {
                if (f264599f == null) {
                    f264599f = new b("QQGameIPCModule");
                }
            }
        }
        return f264599f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i3, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_get_msg", arrayList);
        callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    public void callbackStrategyAnswer(int i3, int i16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.f264601e == 0) {
            return;
        }
        QLog.i("QQGamePub_QQGameIPCModule.IPCModule", 1, "callbackStrategyAnswer");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i3);
        bundle.putInt("appId", i16);
        bundle.putLong("questionId", j3);
        bundle.putLong("answerId", j16);
        try {
            callbackResult(this.f264601e, EIPCResult.createSuccessResult(bundle));
        } catch (Exception e16) {
            QLog.e("QQGamePub_QQGameIPCModule.IPCModule", 1, e16, new Object[0]);
        }
    }

    public void callbackStrategyQuestion(int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        if (this.f264600d == 0) {
            return;
        }
        QLog.i("QQGamePub_QQGameIPCModule.IPCModule", 1, "callbackStrategyQuestion");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i3);
        bundle.putInt("appId", i16);
        bundle.putLong("questionId", j3);
        try {
            callbackResult(this.f264600d, EIPCResult.createSuccessResult(bundle));
        } catch (Exception e16) {
            QLog.e("QQGamePub_QQGameIPCModule.IPCModule", 1, e16, new Object[0]);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_QQGameIPCModule.IPCModule", 2, "onCall action=" + str + ",params=" + bundle);
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof BaseQQAppInterface)) {
            return null;
        }
        if ("findMessage".equals(str)) {
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getBusinessMsgList(3, 5, new IQQGamePubMsgApi.a() { // from class: com.tencent.mobileqq.qqgamepub.ipc.a
                @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.a
                public final void onSuccess(ArrayList arrayList) {
                    b.this.e(i3, arrayList);
                }
            }, "findMessage");
        } else if ("deleteMessage".equals(str)) {
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).deleteMsg(bundle.getLong("msgId"));
        } else if ("getGameMsg".equals(str)) {
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) waitAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
            List<GameCenterSessionInfo> sessionInfoList = iGameMsgManagerService.getSessionInfoList();
            ArrayList arrayList = new ArrayList();
            if (sessionInfoList != null) {
                arrayList.addAll(sessionInfoList);
            }
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GameCenterSessionInfo gameCenterSessionInfo = (GameCenterSessionInfo) it.next();
                    if (gameCenterSessionInfo != null) {
                        gameCenterSessionInfo.n0((BaseQQAppInterface) waitAppRuntime);
                    }
                }
            } catch (Exception e16) {
                QLog.e("QQGamePub_QQGameIPCModule.IPCModule", 1, e16, new Object[0]);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("key_get_game_msg", arrayList);
            bundle2.putInt("key_get_game_view_type", iGameMsgManagerService.getViewType());
            bundle2.putBoolean("key_get_game_show_on_list", iGameMsgManagerService.getNeedPopMsgView());
            bundle2.putBoolean("key_get_game_show_req_msg_unread", iGameMsgManagerService.getShowReqMsgUnread());
            bundle2.putBoolean("key_get_game_gray_user", iGameMsgManagerService.isGrayOpen());
            callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
        } else if ("doOnResume".equals(str)) {
            ((IGameMsgManagerService) waitAppRuntime.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).setMsgRead();
        } else {
            c(str, bundle, i3, waitAppRuntime);
        }
        return null;
    }
}
