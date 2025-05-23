package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveUserLevelService;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.userlevel.IQQLiveUserLevelChangeListener;
import com.tencent.mobileqq.qqlive.callback.userlevel.UserLevelUpgrade;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import sr4.i;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveUserLevelServiceImpl implements IQQLiveUserLevelService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLiveUserLevelServiceImpl";
    private static final int USER_LEVEL_CHANGED = 55;
    private final CopyOnWriteArraySet<IQQLiveUserLevelChangeListener> liveUserLevelChangeListeners;
    private ILiveRoom room;

    public QQLiveUserLevelServiceImpl(ILiveRoom iLiveRoom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iLiveRoom);
        } else {
            this.liveUserLevelChangeListeners = new CopyOnWriteArraySet<>();
            this.room = iLiveRoom;
        }
    }

    private void initPushListener(IQQLiveSDK iQQLiveSDK) {
        if (((ni2.b) iQQLiveSDK.getExtModule("roomPush")) == null) {
            return;
        }
        this.room.registerHighPriorityListener(55, new IQQCmdPushCallback() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.QQLiveUserLevelServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveUserLevelServiceImpl.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
            public void onFail(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                    return;
                }
                QLog.i(QQLiveUserLevelServiceImpl.TAG, 1, "errCode:" + i3 + "errMsg:" + str);
            }

            @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
            public void onReceive(byte[] bArr) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(QQLiveUserLevelServiceImpl.TAG, 1, "get 55 user level upgrade push");
                }
                try {
                    QQLiveUserLevelServiceImpl.this.notifyAllListeners(i.c(bArr));
                } catch (InvalidProtocolBufferNanoException e16) {
                    QLog.i(QQLiveUserLevelServiceImpl.TAG, 1, "UserLevelService parse data:" + e16.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllListeners(i iVar) {
        UserLevelUpgrade userLevelUpgrade = new UserLevelUpgrade(iVar.f434414a, iVar.f434415b, iVar.f434416c);
        Iterator<IQQLiveUserLevelChangeListener> it = this.liveUserLevelChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().userLevelChanged(userLevelUpgrade);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.liveUserLevelChangeListeners.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else if (iQQLiveSDK != null) {
            initPushListener(iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveUserLevelService
    public void registerUserLevelChangedListener(IQQLiveUserLevelChangeListener iQQLiveUserLevelChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iQQLiveUserLevelChangeListener);
        } else if (iQQLiveUserLevelChangeListener != null) {
            this.liveUserLevelChangeListeners.add(iQQLiveUserLevelChangeListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "QQLiveUserLevelServiceImpl reset");
        }
        this.liveUserLevelChangeListeners.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveUserLevelService
    public void unRegisterUserLevelChangedListener(IQQLiveUserLevelChangeListener iQQLiveUserLevelChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iQQLiveUserLevelChangeListener);
        } else if (iQQLiveUserLevelChangeListener != null) {
            this.liveUserLevelChangeListeners.remove(iQQLiveUserLevelChangeListener);
        }
    }
}
