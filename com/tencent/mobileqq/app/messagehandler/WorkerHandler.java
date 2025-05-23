package com.tencent.mobileqq.app.messagehandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class WorkerHandler extends Handler {
    static IPatchRedirector $redirector_ = null;
    public static final int MSG_DO_C2C_UPDATE = 2;
    public static final int MSG_UPDATE_C2C_UNREAD = 1;
    public static final String MSG_UPDATE_UNREAD_TIME = "update_unread_time";
    public static final String MSG_UPDATE_UNREAD_TYPE = "update_unread_type";
    public static final String MSG_UPDATE_UNREAD_UIN = "update_unread_uin";
    private HashSet<String> c2cUnreadWorkerSet;
    private List<Message> c2cUpdateMessageList;
    private final BaseMessageHandler messageHandler;

    public WorkerHandler(BaseMessageHandler baseMessageHandler, Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseMessageHandler, (Object) looper);
            return;
        }
        this.c2cUnreadWorkerSet = new HashSet<>();
        this.c2cUpdateMessageList = new ArrayList();
        this.messageHandler = baseMessageHandler;
    }

    @Deprecated
    public void addC2CUpdateMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) message);
            return;
        }
        synchronized (this.c2cUpdateMessageList) {
            this.c2cUpdateMessageList.add(message);
        }
    }

    @Deprecated
    public void addC2CWorkerToSet(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        synchronized (this.c2cUnreadWorkerSet) {
            Bundle data = message.getData();
            if (data != null && data.containsKey(MSG_UPDATE_UNREAD_UIN) && data.containsKey(MSG_UPDATE_UNREAD_TIME)) {
                String string = data.getString(MSG_UPDATE_UNREAD_UIN);
                int i3 = data.getInt(MSG_UPDATE_UNREAD_TYPE, 0);
                long j3 = data.getLong(MSG_UPDATE_UNREAD_TIME);
                this.c2cUnreadWorkerSet.add(ao.f(string, i3) + ContainerUtils.FIELD_DELIMITER + j3);
            }
        }
    }

    @Deprecated
    public void doC2CUpdateNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        synchronized (this.c2cUpdateMessageList) {
            if (this.c2cUpdateMessageList.size() > 0) {
                Iterator<Message> it = this.c2cUpdateMessageList.iterator();
                while (it.hasNext()) {
                    sendMessage(it.next());
                }
                this.c2cUpdateMessageList.clear();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "updateUnreadWorker doC2CUpdateNow");
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        } else if (message.what == 2) {
            if (QLog.isColorLevel()) {
                QLog.d(BaseMessageHandler.TAG, 2, "updateUnreadWorker C2CWorkerTimeout");
            }
            doC2CUpdateNow();
        }
    }

    @Deprecated
    public boolean hasSameUnreadWorker(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        synchronized (this.c2cUnreadWorkerSet) {
            Bundle data = message.getData();
            if (data == null || !data.containsKey(MSG_UPDATE_UNREAD_UIN) || !data.containsKey(MSG_UPDATE_UNREAD_TIME)) {
                return false;
            }
            String string = data.getString(MSG_UPDATE_UNREAD_UIN);
            int i3 = data.getInt(MSG_UPDATE_UNREAD_TYPE, 0);
            long j3 = data.getLong(MSG_UPDATE_UNREAD_TIME);
            return this.c2cUnreadWorkerSet.contains(ao.f(string, i3) + ContainerUtils.FIELD_DELIMITER + j3);
        }
    }

    @Deprecated
    public void removeUnreadWorker(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        synchronized (this.c2cUnreadWorkerSet) {
            if (this.c2cUnreadWorkerSet.contains(ao.f(str, i3) + ContainerUtils.FIELD_DELIMITER + j3)) {
                this.c2cUnreadWorkerSet.remove(ao.f(str, i3) + ContainerUtils.FIELD_DELIMITER + j3);
            }
        }
    }
}
