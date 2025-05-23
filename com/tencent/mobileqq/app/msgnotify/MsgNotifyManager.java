package com.tencent.mobileqq.app.msgnotify;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MsgNotifyManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "notification";
    public static Callback sCallback;
    private Message incomingMsg;
    private final AppInterface mApp;
    private final List<Message> messages;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface Callback {
        int getUnNotificationSenderNum(Message message, MsgNotifyManager msgNotifyManager);

        boolean isNotCount(boolean z16, Message message, MsgNotifyManager msgNotifyManager);

        void onCancelNotification(Message message, Message message2, MsgNotifyManager msgNotifyManager);

        void onRemove(int i3, Message message, MsgNotifyManager msgNotifyManager);

        void onRemove(String str, int i3, Message message, MsgNotifyManager msgNotifyManager);
    }

    public MsgNotifyManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.messages = new ArrayList();
            this.mApp = appInterface;
        }
    }

    private int getUnNotificationSenderNum(Message message) {
        return sCallback.getUnNotificationSenderNum(message, this);
    }

    private boolean isNotCount(boolean z16, Message message) {
        return sCallback.isNotCount(z16, message, this);
    }

    private boolean msgConversationEquals(MessageRecord messageRecord, MessageRecord messageRecord2) {
        return ao.f(messageRecord.frienduin, messageRecord.istroop).equals(ao.f(messageRecord2.frienduin, messageRecord2.istroop));
    }

    private boolean needAddMessage(Message message) {
        return !((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isTroopGuildPushMsg(message);
    }

    private void onCancelNotification(Message message, Message message2) {
        sCallback.onCancelNotification(message, message2, this);
    }

    private void onRemove(String str, int i3, Message message) {
        sCallback.onRemove(str, i3, message, this);
    }

    public static void setCallback(Callback callback) {
        sCallback = callback;
    }

    public void addMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) message);
            return;
        }
        if (!needAddMessage(message)) {
            return;
        }
        synchronized (this.messages) {
            Message existedMsg = getExistedMsg(message);
            if (existedMsg != null) {
                message.msgInfoList = existedMsg.msgInfoList;
                List<Message> list = this.messages;
                list.set(list.indexOf(existedMsg), message);
            } else {
                this.messages.add(message);
            }
            if (message.msgInfoList == null) {
                message.msgInfoList = new ArrayList<>();
            }
            message.msgInfoList.add(new MsgCacheInfo(message.frienduin, message.istroop, message.uniseq, message.msgUid, message.shmsgseq));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x008b, code lost:
    
        com.tencent.qphone.base.util.QLog.d("notification", 1, "cancelNotificationWhenRevokeMessage, not in cache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0095, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cancelNotificationWhenRevokeMessage(MessageRecord messageRecord) {
        ArrayList<MsgCacheInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) messageRecord);
            return;
        }
        QLog.d("notification", 1, "cancelNotificationWhenRevokeMessage, " + messageRecord);
        if (this.mApp.isBackgroundPause && this.messages.size() != 0) {
            synchronized (this.messages) {
                Message existedMsg = getExistedMsg(messageRecord);
                if (existedMsg != null && (arrayList = existedMsg.msgInfoList) != null && !arrayList.isEmpty()) {
                    int size = existedMsg.msgInfoList.size();
                    int i3 = size - 1;
                    int i16 = i3;
                    while (true) {
                        if (i16 >= 0) {
                            MsgCacheInfo msgCacheInfo = existedMsg.msgInfoList.get(i16);
                            int i17 = msgCacheInfo.uinType;
                            if (i17 == 3000 || ((i17 == 1 && msgCacheInfo.shmsgseq == messageRecord.shmsgseq) || (msgCacheInfo.msguid == messageRecord.msgUid && msgCacheInfo.shmsgseq == messageRecord.shmsgseq))) {
                                break;
                            } else {
                                i16--;
                            }
                        } else {
                            i16 = -1;
                            break;
                        }
                    }
                    Message message = null;
                    if (i16 == i3 && size > 1) {
                        MsgCacheInfo msgCacheInfo2 = existedMsg.msgInfoList.get(size - 2);
                        MessageRecord msgItemByUniseq = ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(msgCacheInfo2.friendUin, msgCacheInfo2.uinType, msgCacheInfo2.uniseq);
                        if (msgItemByUniseq == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, preMsg not in cache");
                            }
                            return;
                        }
                        MessageRecord.copyMessageRecordBaseField(existedMsg, msgItemByUniseq);
                        existedMsg.emoRecentMsg = null;
                        existedMsg.fileType = -1;
                        ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).decodeMsg(existedMsg);
                        if (QLog.isColorLevel()) {
                            QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, match the last msg");
                        }
                    }
                    existedMsg.msgInfoList.remove(i16);
                    int i18 = existedMsg.counter - 1;
                    existedMsg.counter = i18;
                    if (i18 <= 0 || existedMsg.msgInfoList.isEmpty()) {
                        this.messages.remove(existedMsg);
                    }
                    if (!this.messages.isEmpty()) {
                        List<Message> list = this.messages;
                        message = list.get(list.size() - 1);
                    }
                    onCancelNotification(existedMsg, message);
                    return;
                }
                QLog.d("notification", 1, "cancelNotificationWhenRevokeMessage, conversation not in cache");
                return;
            }
        }
        QLog.d("notification", 1, "cancelNotificationWhenRevokeMessage, isBackground: ", Boolean.valueOf(this.mApp.isBackgroundPause));
    }

    public void clearMessageCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        synchronized (this.messages) {
            for (Message message : this.messages) {
                message.counter = 0;
                message.msgInfoList = null;
            }
            this.messages.clear();
        }
    }

    public AppInterface getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (AppInterface) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mApp;
    }

    public int getCounterByType(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        synchronized (this.messages) {
            i16 = 0;
            for (Message message : this.messages) {
                if (message.istroop == i3) {
                    i16 += message.counter;
                }
            }
        }
        return i16;
    }

    public Message getExistedMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Message) iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageRecord);
        }
        if (messageRecord == null) {
            return null;
        }
        for (Message message : this.messages) {
            if (msgConversationEquals(message, messageRecord)) {
                return message;
            }
        }
        return null;
    }

    public List<Message> getInBackgroundMessages() {
        List<Message> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        synchronized (this.messages) {
            list = (List) ((ArrayList) this.messages).clone();
        }
        return list;
    }

    public Message getIncomingMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Message) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.incomingMsg;
    }

    public int getNewConversationSizeWithoutPublicAccount(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, z16)).intValue();
        }
        synchronized (this.messages) {
            i3 = 0;
            for (Message message : this.messages) {
                int i16 = message.istroop;
                if (i16 != 1008 && i16 != 1044 && i16 != 1045 && !isNotCount(z16, message)) {
                    i3 = 7000 == message.istroop ? i3 + getUnNotificationSenderNum(message) : i3 + 1;
                }
            }
        }
        return i3;
    }

    public int getTotalCounter(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, z16)).intValue();
        }
        synchronized (this.messages) {
            i3 = 0;
            for (Message message : this.messages) {
                int i16 = message.istroop;
                if (i16 != 1044 && i16 != 1045 && !isNotCount(z16, message)) {
                    i3 += message.counter;
                }
            }
        }
        return i3;
    }

    public void ondestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (this.messages) {
            this.messages.clear();
        }
    }

    public void removeNotification(String str, int i3) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3);
            return;
        }
        QLog.d("notification", 1, "removeNotification uin" + str + ",type:" + i3);
        if (this.mApp.isBackgroundPause && this.messages.size() != 0) {
            synchronized (this.messages) {
                Iterator<Message> it = this.messages.iterator();
                Message message = null;
                while (true) {
                    z16 = false;
                    if (it.hasNext()) {
                        Message next = it.next();
                        if ((i3 == next.istroop || (ao.r(i3) && ao.r(next.istroop))) && next.frienduin.equals(str)) {
                            next.counter = 0;
                            it.remove();
                            z17 = true;
                            break;
                        }
                        message = next;
                    } else {
                        z17 = false;
                        break;
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("removeNotification remove:");
                sb5.append(z17);
                sb5.append(",preMsg is null");
                if (message == null) {
                    z16 = true;
                }
                sb5.append(z16);
                sb5.append(",iterator.hasNext():");
                sb5.append(it.hasNext());
                QLog.d("notification", 1, sb5.toString());
                if (z17) {
                    if (message == null && it.hasNext()) {
                        message = it.next();
                    }
                    onRemove(str, i3, message);
                }
            }
        }
    }

    public void removeNotificationMsgByUinType(int i3) {
        Message message;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "showNotificationMsg type:" + i3);
        }
        if (this.mApp.isBackgroundPause && this.messages.size() != 0) {
            synchronized (this.messages) {
                Iterator<Message> it = this.messages.iterator();
                while (it.hasNext()) {
                    if (it.next().istroop == i3) {
                        it.remove();
                    }
                }
                if (!this.messages.isEmpty()) {
                    message = this.messages.get(r1.size() - 1);
                } else {
                    message = null;
                }
                onRemove(i3, message);
            }
        }
    }

    public void setIncomingMsg(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) message);
        } else {
            this.incomingMsg = message;
        }
    }

    private void onRemove(int i3, Message message) {
        sCallback.onRemove(i3, message, this);
    }

    public int getTotalCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? getTotalCounter(false) : ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
    }

    public int getNewConversationSizeWithoutPublicAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? getNewConversationSizeWithoutPublicAccount(false) : ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
    }
}
