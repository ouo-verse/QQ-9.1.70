package com.tencent.mobileqq.app.notification.processor.business;

import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i extends com.tencent.mobileqq.app.notification.struct.a {
    static IPatchRedirector $redirector_;

    protected i(QQAppInterface qQAppInterface, com.tencent.mobileqq.app.notification.struct.e eVar) {
        super(qQAppInterface, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) eVar);
        }
    }

    @Override // com.tencent.mobileqq.app.notification.struct.d
    public com.tencent.mobileqq.app.notification.struct.e a(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.app.notification.struct.e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        this.f196405b.j(((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(this.f196404a, message, b()));
        f();
        g(message, this.f196405b);
        Bitmap gameRoleBitmap = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameRoleBitmap(message, this.f196404a);
        String gameRoleNickName = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(message, this.f196404a);
        this.f196405b.k(gameRoleBitmap);
        this.f196405b.i(gameRoleNickName);
        QQAppInterface qQAppInterface = this.f196404a;
        if (qQAppInterface != null) {
            IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) qQAppInterface.getRuntimeService(IGameMsgBoxManager.class, "");
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.f196404a.getRuntimeService(IGameMsgManagerService.class, "");
            if (iGameMsgBoxManager != null) {
                try {
                    String optString = new JSONObject(message.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO)).optString(TinyInfo.KEY_GAME_APP_ID);
                    if (iGameMsgBoxManager.isGameInGameBox(optString)) {
                        if (iGameMsgManagerService != null && iGameMsgManagerService.findGameSwitchConfig(optString).mMuteSwitch == 1) {
                            return null;
                        }
                        this.f196404a.getApplication().getSharedPreferences("gamePushMsgSp", 0).edit().putString("lastPush", optString).apply();
                    }
                } catch (JSONException e16) {
                    QLog.e("GameNotificationProcessor", 1, "json err! ", e16);
                }
            }
        }
        return this.f196405b;
    }

    @Override // com.tencent.mobileqq.app.notification.struct.c
    public int e(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).intValue();
        }
        return 527;
    }
}
