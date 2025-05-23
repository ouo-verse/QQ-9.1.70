package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.ej;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g implements Manager {
    static IPatchRedirector $redirector_;
    public HashMap<String, MessageForFoldMsgGrayTips> C;
    public HashMap<String, MessageForFoldMsgGrayTips> D;
    private final Object E;
    public HashMap<String, String> F;
    public HashMap<String, String> G;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f243713d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f243714e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f243715f;

    /* renamed from: h, reason: collision with root package name */
    public int f243716h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f243717i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f243718m;

    public g(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f243714e = false;
        this.f243715f = true;
        this.f243716h = 10;
        this.f243717i = true;
        this.f243718m = true;
        this.E = new Object();
        this.F = new HashMap<>();
        this.G = new HashMap<>();
        this.f243713d = qQAppInterface;
    }

    public static boolean c(QQAppInterface qQAppInterface) {
        e(qQAppInterface);
        return ((g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER)).f243717i;
    }

    public static boolean d(QQAppInterface qQAppInterface) {
        e(qQAppInterface);
        return ((g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER)).f243715f;
    }

    public static void e(QQAppInterface qQAppInterface) {
        g gVar = (g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
        if (!gVar.f243714e) {
            String account = qQAppInterface.getAccount();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp());
            if (defaultSharedPreferences.contains(account + "_" + AppConstants.Preferences.REDBAG_FOLD_MSG_CONFIG_VERSION)) {
                gVar.f243715f = defaultSharedPreferences.getBoolean(account + "_" + AppConstants.Preferences.REDBAG_FOLD_MSG_SWITCH, MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT);
                gVar.f243716h = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.REDBAG_FOLD_MSG_NUM, MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT);
                gVar.f243717i = defaultSharedPreferences.getBoolean(account + "_" + AppConstants.Preferences.REDBAG_FOLD_INDEX_SWITCH, MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX);
                gVar.f243718m = defaultSharedPreferences.getBoolean(account + "_" + AppConstants.Preferences.REDBAG_FOLD_INDEX_WITH_REDBAGID, MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID);
            }
            if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, String.format("getFoldSwitch, first init, switch: %s, num: %d, indexSwitch: %s, indexWithId: %s ", Boolean.valueOf(gVar.f243715f), Integer.valueOf(gVar.f243716h), Boolean.valueOf(gVar.f243717i), Boolean.valueOf(gVar.f243718m)));
            }
        }
        gVar.f243714e = true;
    }

    public static boolean g(QQAppInterface qQAppInterface, int i3, String str) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(QQAppInterface qQAppInterface, int i3, String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String[] split;
        boolean z26;
        boolean z27;
        boolean z28;
        String[] split2;
        int intValue;
        String[] split3;
        int intValue2;
        boolean z29;
        String[] split4;
        int intValue3;
        String[] split5;
        boolean z36 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
        int i16 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
        boolean z37 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
        boolean z38 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
        try {
            if (!TextUtils.isEmpty(str) && (split = str.split("\\|")) != null) {
                int length = split.length;
                int i17 = 0;
                z16 = false;
                z17 = false;
                z18 = false;
                z19 = false;
                while (i17 < length) {
                    try {
                        String str2 = split[i17];
                        if (str2.contains("msgfold_switch") && (split5 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null) {
                            z26 = z36;
                            if (split5.length == 2) {
                                try {
                                    int intValue4 = Integer.valueOf(split5[1].trim()).intValue();
                                    if (intValue4 == 1 || intValue4 == 0) {
                                        if (intValue4 == 1) {
                                            z27 = true;
                                        } else {
                                            z27 = false;
                                        }
                                        z16 = true;
                                        if (!str2.contains("msgfold_num") && (split4 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null) {
                                            z28 = z27;
                                            if (split4.length == 2 && (intValue3 = Integer.valueOf(split4[1].trim()).intValue()) >= 0) {
                                                i16 = intValue3;
                                                z17 = true;
                                            }
                                        } else {
                                            z28 = z27;
                                        }
                                        if (str2.contains("Index_switch") && (split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split3.length == 2 && ((intValue2 = Integer.valueOf(split3[1].trim()).intValue()) == 1 || intValue2 == 0)) {
                                            if (intValue2 != 1) {
                                                z29 = true;
                                            } else {
                                                z29 = false;
                                            }
                                            z37 = z29;
                                            z18 = true;
                                        }
                                        if (str2.contains("with_redbagid") && (split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split2.length == 2 && ((intValue = Integer.valueOf(split2[1].trim()).intValue()) == 1 || intValue == 0)) {
                                            if (intValue != 1) {
                                                z38 = true;
                                            } else {
                                                z38 = false;
                                            }
                                            z19 = true;
                                        }
                                        i17++;
                                        z36 = z28;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    z36 = z26;
                                    if (QLog.isColorLevel()) {
                                        QLog.e("msgFold", 2, "updatePasswdMsgFodConfig error " + e.getMessage());
                                    }
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (z17) {
                                    }
                                    z36 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
                                    i16 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
                                    z37 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
                                    z38 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
                                    boolean z39 = z36;
                                    int i18 = i16;
                                    boolean z46 = z37;
                                    boolean z47 = z38;
                                    g gVar = (g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
                                    gVar.f243714e = true;
                                    gVar.f243715f = z39;
                                    gVar.f243716h = i18;
                                    gVar.f243717i = z46;
                                    gVar.f243718m = z47;
                                    ea.K4(qQAppInterface.getApp(), qQAppInterface.getAccount(), i3, z39, i18, z46, z47);
                                }
                            }
                        } else {
                            z26 = z36;
                        }
                        z27 = z26;
                        if (!str2.contains("msgfold_num")) {
                        }
                        z28 = z27;
                        if (str2.contains("Index_switch")) {
                            if (intValue2 != 1) {
                            }
                            z37 = z29;
                            z18 = true;
                        }
                        if (str2.contains("with_redbagid")) {
                            if (intValue != 1) {
                            }
                            z19 = true;
                        }
                        i17++;
                        z36 = z28;
                    } catch (Exception e17) {
                        e = e17;
                    }
                }
            } else {
                z16 = false;
                z17 = false;
                z18 = false;
                z19 = false;
            }
        } catch (Exception e18) {
            e = e18;
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, String.format("received RedBagFoldMsgConfig remote version: %d, msgFoldSwitch: %s, msgFoldNum: %s, msgFoldIndexSwitch: %s, msgFoldIndexWithId: %s", Integer.valueOf(i3), Boolean.valueOf(z36), Integer.valueOf(i16), Boolean.valueOf(z37), Boolean.valueOf(z38)));
        }
        if (z17 || !z16 || !z18 || !z19) {
            z36 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
            i16 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
            z37 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
            z38 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
        }
        boolean z392 = z36;
        int i182 = i16;
        boolean z462 = z37;
        boolean z472 = z38;
        g gVar2 = (g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
        gVar2.f243714e = true;
        gVar2.f243715f = z392;
        gVar2.f243716h = i182;
        gVar2.f243717i = z462;
        gVar2.f243718m = z472;
        ea.K4(qQAppInterface.getApp(), qQAppInterface.getAccount(), i3, z392, i182, z462, z472);
    }

    public void a(String str, int i3, String str2, String str3, MessageForFoldMsgGrayTips messageForFoldMsgGrayTips) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, str3, messageForFoldMsgGrayTips);
            return;
        }
        if (!TextUtils.isEmpty(str3)) {
            String str4 = str + i3 + str3;
            HashMap<String, MessageForFoldMsgGrayTips> hashMap = this.D;
            if (hashMap != null && !hashMap.containsKey(str4)) {
                this.D.put(str4, messageForFoldMsgGrayTips);
                if (QLog.isColorLevel()) {
                    QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagIndex: %s num: %d", str, Integer.valueOf(i3), str3, Integer.valueOf(messageForFoldMsgGrayTips.foldMsgCount)));
                    return;
                }
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            String str5 = str + i3 + str2;
            HashMap<String, MessageForFoldMsgGrayTips> hashMap2 = this.C;
            if (hashMap2 != null && !hashMap2.containsKey(str5)) {
                this.C.put(str5, messageForFoldMsgGrayTips);
                if (QLog.isColorLevel()) {
                    QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagId: %s num: %d", str, Integer.valueOf(i3), str2, Integer.valueOf(messageForFoldMsgGrayTips.foldMsgCount)));
                }
            }
        }
    }

    public MessageRecord b(List<MessageRecord> list, MessageForFoldMsg messageForFoldMsg, LinkedHashSet<String> linkedHashSet, int i3, boolean z16, boolean z17) {
        Lock e16;
        MessageForFoldMsgGrayTips messageForFoldMsgGrayTips;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, list, messageForFoldMsg, linkedHashSet, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        if (this.C == null) {
            this.C = new HashMap<>();
        }
        if (this.D == null) {
            this.D = new HashMap<>();
        }
        String str = messageForFoldMsg.frienduin + messageForFoldMsg.istroop + messageForFoldMsg.redBagId;
        String str2 = messageForFoldMsg.frienduin + messageForFoldMsg.istroop + messageForFoldMsg.redBagIndex;
        MessageForFoldMsgGrayTips messageForFoldMsgGrayTips2 = null;
        if (z16 && this.D.containsKey(str2)) {
            MessageForFoldMsgGrayTips messageForFoldMsgGrayTips3 = this.D.get(str2);
            messageForFoldMsgGrayTips3.update(this.f243713d, messageForFoldMsg.frienduin, linkedHashSet, i3, messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex);
            if (this.C.containsKey(str)) {
                messageForFoldMsgGrayTips = messageForFoldMsgGrayTips3;
                i(list, str2, str, messageForFoldMsg.frienduin, messageForFoldMsg.istroop, z17);
            } else {
                messageForFoldMsgGrayTips = messageForFoldMsgGrayTips3;
            }
            if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, String.format("update foldmsg graytips, index mode, uin: %s, type: %d, redBagId: %s, index: %s, num: %d", messageForFoldMsgGrayTips.frienduin, Integer.valueOf(messageForFoldMsgGrayTips.istroop), messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex, Integer.valueOf(messageForFoldMsgGrayTips.foldMsgCount)));
            }
        } else if (z16 && this.C.containsKey(str)) {
            MessageForFoldMsgGrayTips messageForFoldMsgGrayTips4 = this.C.get(str);
            messageForFoldMsgGrayTips4.update(this.f243713d, messageForFoldMsg.frienduin, linkedHashSet, i3, messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex);
            if (!TextUtils.isEmpty(messageForFoldMsg.redBagIndex)) {
                this.C.remove(str);
                this.D.put(str2, messageForFoldMsgGrayTips4);
            }
            if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, String.format("update foldmsg graytips, id mode, uin: %s, type: %d, redBagId: %s, index: %s,  num: %d", messageForFoldMsgGrayTips4.frienduin, Integer.valueOf(messageForFoldMsgGrayTips4.istroop), messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex, Integer.valueOf(messageForFoldMsgGrayTips4.foldMsgCount)));
            }
        } else {
            MessageForFoldMsgGrayTips messageForFoldMsgGrayTips5 = (MessageForFoldMsgGrayTips) q.d(MessageRecord.MSG_TYPE_FOLD_MSG_GRAY_TIPS);
            QQAppInterface qQAppInterface = this.f243713d;
            String str3 = messageForFoldMsg.frienduin;
            q.I(qQAppInterface, messageForFoldMsgGrayTips5, str3, str3, messageForFoldMsg.istroop);
            messageForFoldMsgGrayTips5.shmsgseq = messageForFoldMsg.shmsgseq;
            messageForFoldMsgGrayTips5.time = messageForFoldMsg.time;
            messageForFoldMsgGrayTips5.foldMsgCount = i3;
            messageForFoldMsgGrayTips5.init(this.f243713d, messageForFoldMsg.frienduin, messageForFoldMsg.mPasswdRedBagSender, linkedHashSet, messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex);
            synchronized (this.E) {
                if (!f(messageForFoldMsg.frienduin, messageForFoldMsg.istroop, messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex)) {
                    if (z17) {
                        e16 = this.f243713d.getMessageProxy(0).I().e(messageForFoldMsg.frienduin, messageForFoldMsg.istroop);
                        e16.lock();
                        try {
                            ad.p(list, messageForFoldMsgGrayTips5, true);
                            e16.unlock();
                        } finally {
                        }
                    } else {
                        ad.p(list, messageForFoldMsgGrayTips5, true);
                    }
                    a(messageForFoldMsg.frienduin, messageForFoldMsg.istroop, messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex, messageForFoldMsgGrayTips5);
                    if (QLog.isColorLevel() && ej.a() && list != null && list.size() > 0) {
                        StringBuilder sb5 = new StringBuilder((list.size() * 48) + 64);
                        sb5.append("getFoldGrayTipsFormAIOList after insert,isNeedMsgListLock=");
                        sb5.append(z17);
                        sb5.append(",aioList size=");
                        sb5.append(list.size());
                        sb5.append(":");
                        e16 = this.f243713d.getMessageProxy(0).I().e(messageForFoldMsg.frienduin, messageForFoldMsg.istroop);
                        e16.lock();
                        try {
                            for (MessageRecord messageRecord : list) {
                                sb5.append("(");
                                sb5.append(messageRecord.time);
                                sb5.append(",");
                                sb5.append(messageRecord.shmsgseq);
                                sb5.append(",");
                                sb5.append(messageRecord.msgtype);
                                sb5.append(") ");
                            }
                            e16.unlock();
                            QLog.d("msgFold", 2, sb5.toString());
                        } finally {
                        }
                    }
                    messageForFoldMsgGrayTips2 = messageForFoldMsgGrayTips5;
                } else {
                    QLog.i("msgFold", 1, "filter repeat msg:" + messageForFoldMsg.redBagId + "_" + messageForFoldMsg.redBagIndex);
                    return null;
                }
            }
        }
        ReportController.o(this.f243713d, "CliOper", "", "", "0X80064BC", "0X80064BC", 0, 0, "", "", "", "");
        return messageForFoldMsgGrayTips2;
    }

    public boolean f(String str, int i3, String str2, String str3) {
        boolean z16;
        boolean z17;
        HashMap<String, MessageForFoldMsgGrayTips> hashMap;
        HashMap<String, MessageForFoldMsgGrayTips> hashMap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2, str3)).booleanValue();
        }
        String str4 = str + i3 + str2;
        String str5 = str + i3 + str3;
        if (!TextUtils.isEmpty(str2) && (hashMap2 = this.C) != null && hashMap2.containsKey(str4)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(str3) && (hashMap = this.D) != null && hashMap.containsKey(str5)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    public synchronized void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            ((IPasswdRedBagService) this.f243713d.getRuntimeService(IPasswdRedBagService.class)).loadRedBagInfoToCache(z16);
        }
    }

    public void i(List<MessageRecord> list, String str, String str2, String str3, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, str, str2, str3, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        MessageForFoldMsgGrayTips messageForFoldMsgGrayTips = this.D.get(str);
        MessageForFoldMsgGrayTips messageForFoldMsgGrayTips2 = this.C.get(str2);
        this.C.remove(str);
        messageForFoldMsgGrayTips.update(this.f243713d, messageForFoldMsgGrayTips2.frienduin, messageForFoldMsgGrayTips2.foldUinList, messageForFoldMsgGrayTips2.foldMsgCount, messageForFoldMsgGrayTips2.redBagId, messageForFoldMsgGrayTips2.redBagIndex);
        if (z16) {
            Lock e16 = this.f243713d.getMessageProxy(0).I().e(str3, i3);
            e16.lock();
            try {
                list.remove(messageForFoldMsgGrayTips2);
            } finally {
                e16.unlock();
            }
        } else {
            list.remove(messageForFoldMsgGrayTips2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, "update foldmsg graytips, index mode merge,", ",mst.time=", Long.valueOf(messageForFoldMsgGrayTips2.time), ".msg.shmsgseq=", Long.valueOf(messageForFoldMsgGrayTips2.shmsgseq), ",msg.type=", Integer.valueOf(messageForFoldMsgGrayTips2.msgtype), ",isNeedMsgListLock=", Boolean.valueOf(z16));
        }
    }

    public void k(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, str2);
            return;
        }
        if (z16) {
            h(false);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!this.F.containsKey(str)) {
                this.F.put(str, str2);
            }
            if (!this.G.containsKey(str2)) {
                this.G.put(str2, str);
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }
}
