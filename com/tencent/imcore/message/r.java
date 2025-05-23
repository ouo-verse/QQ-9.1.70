package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ej;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class r {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f116715a;

        /* renamed from: b, reason: collision with root package name */
        LinkedHashSet<String> f116716b;

        /* renamed from: c, reason: collision with root package name */
        long f116717c;

        /* renamed from: d, reason: collision with root package name */
        MessageForFoldMsg f116718d;

        /* renamed from: e, reason: collision with root package name */
        boolean f116719e;

        /* renamed from: f, reason: collision with root package name */
        long f116720f;

        /* renamed from: g, reason: collision with root package name */
        MessageForFoldMsg f116721g;

        /* renamed from: h, reason: collision with root package name */
        boolean f116722h;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f116715a = 0;
            this.f116716b = new LinkedHashSet<>();
            this.f116717c = Long.MAX_VALUE;
            this.f116718d = null;
            this.f116719e = false;
            this.f116720f = 0L;
            this.f116721g = null;
            this.f116722h = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(BaseMessageManager baseMessageManager, QQAppInterface qQAppInterface, List<MessageRecord> list, List<MessageRecord> list2, boolean z16, boolean z17) {
        int i3;
        int i16;
        String str;
        List<MessageRecord> list3;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            String str4 = "msgFold";
            if (QLog.isColorLevel() && ej.a() && list.size() > 0) {
                StringBuilder sb5 = new StringBuilder((list.size() * 48) + 64);
                sb5.append("BaseMessageManager mergeFoldMsgGrayTips(),searchList size=");
                sb5.append(list.size());
                sb5.append(":");
                for (MessageRecord messageRecord : list) {
                    sb5.append("(");
                    sb5.append(messageRecord.time);
                    sb5.append(",");
                    sb5.append(messageRecord.shmsgseq);
                    sb5.append(",");
                    sb5.append(messageRecord.msgtype);
                    sb5.append(") ");
                }
                QLog.d("msgFold", 2, sb5.toString());
            }
            com.tencent.mobileqq.managers.g gVar = (com.tencent.mobileqq.managers.g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
            HashMap hashMap = new HashMap();
            Iterator<MessageRecord> it = list.iterator();
            while (true) {
                i3 = 0;
                boolean z18 = false;
                if (!it.hasNext()) {
                    break;
                }
                MessageRecord next = it.next();
                if (next instanceof MessageForFoldMsg) {
                    MessageForFoldMsg messageForFoldMsg = (MessageForFoldMsg) next;
                    if (!TextUtils.isEmpty(messageForFoldMsg.redBagIndex) && !TextUtils.isEmpty(messageForFoldMsg.redBagId)) {
                        gVar.k(true, messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex);
                    }
                    if (TextUtils.isEmpty(messageForFoldMsg.redBagIndex) && !TextUtils.isEmpty(messageForFoldMsg.redBagId)) {
                        if (gVar.F.containsKey(messageForFoldMsg.redBagId)) {
                            messageForFoldMsg.redBagIndex = gVar.F.get(messageForFoldMsg.redBagId);
                        }
                        if ((!z16 || !gVar.f(messageForFoldMsg.frienduin, messageForFoldMsg.istroop, messageForFoldMsg.redBagId, messageForFoldMsg.redBagIndex)) && (!messageForFoldMsg.isSend() || messageForFoldMsg.foldFlag || messageForFoldMsg.msgtype != -2006)) {
                            if (!z18) {
                                str3 = messageForFoldMsg.redBagIndex;
                            } else {
                                str3 = messageForFoldMsg.redBagId;
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                a aVar = (a) hashMap.get(str3);
                                if (aVar == null) {
                                    aVar = new a();
                                    hashMap.put(str3, aVar);
                                }
                                aVar.f116722h = z18;
                                if (!messageForFoldMsg.foldFlag) {
                                    aVar.f116719e = true;
                                    long j3 = messageForFoldMsg.shmsgseq;
                                    str2 = str4;
                                    if (j3 > aVar.f116720f) {
                                        aVar.f116720f = j3;
                                        aVar.f116721g = messageForFoldMsg;
                                    }
                                } else {
                                    str2 = str4;
                                    aVar.f116715a++;
                                    aVar.f116716b.add(messageForFoldMsg.senderuin);
                                    long j16 = messageForFoldMsg.shmsgseq;
                                    if (j16 < aVar.f116717c) {
                                        aVar.f116717c = j16;
                                        aVar.f116718d = messageForFoldMsg;
                                    }
                                }
                            }
                        }
                    }
                    z18 = true;
                    if (!z16) {
                    }
                    if (!z18) {
                    }
                    if (!TextUtils.isEmpty(str3)) {
                    }
                } else {
                    str2 = str4;
                }
                str4 = str2;
            }
            String str5 = str4;
            if (!hashMap.isEmpty()) {
                b(qQAppInterface, hashMap);
                Iterator it5 = hashMap.entrySet().iterator();
                while (it5.hasNext()) {
                    a aVar2 = (a) ((Map.Entry) it5.next()).getValue();
                    if (aVar2.f116715a > 0) {
                        if (aVar2.f116719e) {
                            aVar2.f116718d = aVar2.f116721g;
                        }
                        if (list2 == null) {
                            list3 = baseMessageManager.v(qQAppInterface, list.get(i3).frienduin, list.get(i3).istroop);
                        } else {
                            list3 = list2;
                        }
                        if (list3 == null) {
                            QLog.e("Q.msg.BaseMessageManager", 1, "mergeFoldMsgGrayTips null aioList");
                            return;
                        }
                        i16 = i3;
                        MessageRecord b16 = gVar.b(list3, aVar2.f116718d, aVar2.f116716b, aVar2.f116715a, z16, z17);
                        if (b16 != null && list2 == null) {
                            if (QLog.isColorLevel() && ej.a() && list2 != null && list2.size() > 0) {
                                StringBuilder sb6 = new StringBuilder((list2.size() * 48) + 32);
                                sb6.append("insert to clone list,addlist size=");
                                sb6.append(list2.size());
                                sb6.append(":");
                                for (MessageRecord messageRecord2 : list2) {
                                    sb6.append("(");
                                    sb6.append(messageRecord2.time);
                                    sb6.append(",");
                                    sb6.append(messageRecord2.shmsgseq);
                                    sb6.append(",");
                                    sb6.append(messageRecord2.msgtype);
                                    sb6.append(") ");
                                }
                                str = str5;
                                QLog.d(str, 2, sb6.toString());
                            } else {
                                str = str5;
                            }
                            ad.p(list, b16, true);
                            str5 = str;
                            i3 = i16;
                        } else {
                            str = str5;
                        }
                    } else {
                        i16 = i3;
                        str = str5;
                    }
                    str5 = str;
                    i3 = i16;
                }
            }
        }
    }

    public static void b(QQAppInterface qQAppInterface, HashMap<String, a> hashMap) {
        boolean z16;
        HashSet hashSet = new HashSet();
        com.tencent.mobileqq.managers.g gVar = (com.tencent.mobileqq.managers.g) qQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
        gVar.h(false);
        if (gVar.G.isEmpty()) {
            return;
        }
        for (Map.Entry<String, a> entry : hashMap.entrySet()) {
            a value = entry.getValue();
            if (value.f116722h) {
                String str = gVar.G.get(entry.getKey());
                if (!TextUtils.isEmpty(str) && hashMap.containsKey(str)) {
                    a aVar = hashMap.get(str);
                    hashSet.add(str);
                    value.f116715a += aVar.f116715a;
                    value.f116716b.addAll(aVar.f116716b);
                    if (!value.f116719e && !aVar.f116719e) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    value.f116719e = z16;
                    long j3 = value.f116720f;
                    long j16 = aVar.f116720f;
                    if (j3 < j16) {
                        value.f116720f = j16;
                        MessageForFoldMsg messageForFoldMsg = aVar.f116721g;
                        value.f116721g = messageForFoldMsg;
                        messageForFoldMsg.redBagIndex = entry.getKey();
                    }
                    long j17 = value.f116717c;
                    long j18 = aVar.f116717c;
                    if (j17 > j18) {
                        value.f116717c = j18;
                        MessageForFoldMsg messageForFoldMsg2 = aVar.f116718d;
                        value.f116718d = messageForFoldMsg2;
                        messageForFoldMsg2.redBagIndex = entry.getKey();
                    }
                }
            }
        }
        hashMap.keySet().removeAll(hashSet);
    }
}
