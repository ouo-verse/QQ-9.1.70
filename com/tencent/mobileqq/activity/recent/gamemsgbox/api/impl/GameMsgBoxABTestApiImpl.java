package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GameMsgBoxABTestApiImpl implements IGameMsgBoxABTestApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GameMsgBoxABTestApiImpl";

    public GameMsgBoxABTestApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi
    public boolean isGameBoxMuteGrayDotNewStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_MESSAGE_REMINDER_DND).isExperiment()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi
    public boolean isGameMsgAddTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi
    public void reportGameTabExposure(MqqHandler mqqHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mqqHandler);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            boolean z16 = false;
            objArr[0] = "reportGameTabExp-handler is null: ";
            if (mqqHandler == null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            objArr[2] = "is exp: ";
            objArr[3] = Boolean.valueOf(isGameMsgAddTab());
            QLog.d(TAG, 2, objArr);
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_GAME_BOX);
        if (mqqHandler != null) {
            mqqHandler.post(new Runnable(expEntity) { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxABTestApiImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ExpEntityInfo f185483d;

                {
                    this.f185483d = expEntity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameMsgBoxABTestApiImpl.this, (Object) expEntity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f185483d.reportExpExposure();
                    }
                }
            });
        } else {
            expEntity.reportExpExposure();
        }
    }
}
