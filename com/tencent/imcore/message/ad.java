package com.tencent.imcore.message;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ad {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static c f116454a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f116455b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f116456c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f116457d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f116458e;

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f116459f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f116460g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f116461h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f116462i;

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f116463j;

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f116464k;

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f116465l;

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f116466m;

    /* renamed from: n, reason: collision with root package name */
    static Comparator<MessageRecord> f116467n;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Comparator<MessageRecord> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageRecord messageRecord, MessageRecord messageRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord, (Object) messageRecord2)).intValue();
            }
            if (messageRecord.longMsgIndex > messageRecord2.longMsgIndex) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements Comparator<MessageRecord> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageRecord messageRecord, MessageRecord messageRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord, (Object) messageRecord2)).intValue();
            }
            return (int) (messageRecord.shmsgseq - messageRecord2.shmsgseq);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface c {
        boolean a(MessageRecord messageRecord);

        boolean b(MessageRecord messageRecord);

        boolean c(int i3);

        boolean d(MessageRecord messageRecord, MessageRecord messageRecord2);

        MessageRecord e(ArrayList<MessageRecord> arrayList);

        boolean f(MessageRecord messageRecord);

        int g();

        boolean h(AppRuntime appRuntime, MessageRecord messageRecord);

        boolean i(MessageRecord messageRecord);

        void j(Exception exc, List<MessageRecord> list);

        boolean k(MessageRecord messageRecord, MessageRecord messageRecord2, String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37422);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f116454a = new com.tencent.imcore.message.msgproxy.c();
        f116455b = new int[]{MessageRecord.MSG_TYPE_REVOKE_GRAY_TIPS, MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT, MessageRecord.MSG_TYPE_TROOP_FEE, MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT_OBJ, MessageRecord.MSG_TYPE_CONFIGURABLE_TAB_VISIBLE_GRAY_TIPS, MessageRecord.MSG_TYPE_HOMEWORK_PRAISE, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, MessageRecord.MSG_TYPE_GUILD_GRAYTIP_NOT_ROAM, MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI, MessageRecord.MSG_TYPE_GUILD_GIFT};
        f116456c = new int[]{MessageRecord.MSG_TYPE_PUBLIC_ACCOUNT, MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT, MessageRecord.MSG_TYPE_TROOP_FEE, MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT_OBJ};
        f116457d = new int[]{-1004, -1012, -4002, -4003, -4004, MessageRecord.MSG_TYPE_TEXT_GROUP_CREATED, -1013, MessageRecord.MSG_TYPE_TROOP_GAP_GRAY_TIPS, MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS, MessageRecord.MSG_TYPE_SPLIT_LINE_GRAY_TIPS, -1016, -1017, MessageRecord.MSG_TYPE_DISCUSS_UPGRADE_TO_GROUP_TIPS, MessageRecord.MSG_TYPE_STRUCT_TROOP_NOTIFICATION, MessageRecord.MSG_TYPE_OPERATE_TIPS, MessageRecord.MSG_TYPE_SOUGOU_INPUT_TIPS, MessageRecord.MSG_TYPE_RED_PACKET_TIPS, MessageRecord.MSG_TYPE_HONGBAO_KEYWORDS_TIPS, -5000, -5001, 1018, MessageRecord.MSG_TYPE_MULTI_VIDEO, MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS, MessageRecord.MSG_TYPE_CONFIGURABLE_TAB_VISIBLE_GRAY_TIPS, MessageRecord.MSG_TYPE_SPECIALCARE_TIPS, MessageRecord.MSG_TYPE_MEETING_NOTIFY, MessageRecord.MSG_TYPE_SENSITIVE_MSG_MASK_TIPS, MessageRecord.MSG_TYPE_BAT_PROCESS_FILE, MessageRecord.MSG_TYPE_TIM_GUIDE, MessageRecord.MSG_TYPE_QQWALLET_TIPS, MessageRecord.MSG_TYPE_DING_DONG_GRAY_TIPS, MessageRecord.MSG_TYPE_SHARE_HOT_CHAT_GRAY_TIPS, MessageRecord.MSG_TYPE_HOMEWORK_PRAISE, MessageRecord.MSG_TYPE_APPROVAL_GRAY_TIPS, MessageRecord.MSG_TYPE_FOLD_MSG_GRAY_TIPS, MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS, MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS, MessageRecord.MSG_TYPE_TIM_AIOMSG_TIPS};
        f116458e = new int[]{-4003, MessageRecord.MSG_TYPE_RENEWAL_TAIL_TIP, -4004, MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS, MessageRecord.MSG_TYPE_FOLD_MSG_GRAY_TIPS};
        f116459f = new int[]{-1000, -2000, -2002, -2005, MessageRecord.MSG_TYPE_MIX, MessageRecord.MSG_TYPE_LONG_MIX, MessageRecord.MSG_TYPE_LONG_TEXT, -20000, -2007, MessageRecord.MSG_TYPE_STRUCT_MSG, MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT, -8018};
        f116460g = new int[]{-2000, -2002, -2007, MessageRecord.MSG_TYPE_STICKER_MSG, MessageRecord.MSG_TYPE_STRUCT_MSG, MessageRecord.MSG_TYPE_SHAKE_WINDOW, MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO, MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT, MessageRecord.MSG_TYPE_MIX, MessageRecord.MSG_TYPE_TROOP_STORY, -7001, MessageRecord.MSG_TYPE_MEDIA_LIGHTVIDEO, -8018, MessageRecord.MSG_TYPE_VIDEO_EMOTICON};
        f116461h = new int[]{-1001, -2009, MessageRecord.MSG_TYPE_MULTI_VIDEO, -4008};
        f116462i = new int[]{MessageRecord.MSG_TYPE_TROOP_GAP_GRAY_TIPS, MessageRecord.MSG_TYPE_TEXT_GROUP_CREATED, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL};
        f116463j = new int[]{MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, MessageRecord.MSG_TYPE_GUILD_GRAYTIP_NOT_ROAM, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI, MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI, MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI};
        f116464k = new int[]{1000, 1004, 1020};
        f116465l = new int[]{1001, 10002, 1010};
        f116466m = new int[]{0, 1, 3000, 1025, 1024, 10007};
        s.a();
        f116467n = new a();
    }

    private static boolean A(MessageRecord messageRecord) {
        return f116454a.f(messageRecord);
    }

    public static boolean B(MessageRecord messageRecord) {
        for (int i3 : f116457d) {
            if (i3 == messageRecord.msgtype) {
                return true;
            }
        }
        return A(messageRecord);
    }

    public static boolean C(int i3) {
        for (int i16 : ao.f116568b) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean D(int i3) {
        for (int i16 : ao.f116571e) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean E(String str, int i3) {
        if (str != null && str.length() >= 6) {
            if (i3 == 0 || i3 == 1 || i3 == 3000) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean F(AppRuntime appRuntime, MessageRecord messageRecord) {
        if (ao.B(messageRecord) && !ao.z(messageRecord.frienduin, messageRecord.istroop) && L(appRuntime, messageRecord)) {
            return true;
        }
        return false;
    }

    public static boolean G(int i3) {
        return f116454a.c(i3);
    }

    private static boolean H(MessageRecord messageRecord) {
        return f116454a.a(messageRecord);
    }

    public static boolean I(int i3) {
        for (int i16 : f116460g) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private static boolean J(MessageRecord messageRecord) {
        return f116454a.i(messageRecord);
    }

    public static boolean K(int i3) {
        for (int i16 : f116464k) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private static boolean L(AppRuntime appRuntime, MessageRecord messageRecord) {
        return f116454a.h(appRuntime, messageRecord);
    }

    public static boolean M(int i3) {
        for (int i16 : f116463j) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean N(int i3) {
        for (int i16 : f116461h) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private static void O(List<MessageRecord> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            QLog.d("Q.msg.MsgProxyUtils", 1, "backupAioMsgList = [" + i3 + "] = " + list.get(i3));
        }
    }

    public static void P(String str, int i3, List<MessageRecord> list, com.tencent.mobileqq.service.message.e eVar) {
        try {
            Q(str, i3, list, eVar);
        } catch (Throwable th5) {
            QLog.e("Q.msg.MsgProxyUtils", 1, "mergeLongMsg: ", th5);
        }
    }

    private static void Q(String str, int i3, List<MessageRecord> list, com.tencent.mobileqq.service.message.e eVar) {
        HashMap hashMap;
        Iterator it;
        int i16;
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList(list);
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            for (MessageRecord messageRecord : list) {
                if (messageRecord.isLongMsg()) {
                    String g16 = ao.g(messageRecord);
                    if (hashMap2.containsKey(g16)) {
                        i16 = i18;
                        if (Math.abs(((MessageRecord) ((ArrayList) hashMap2.get(g16)).get(i17)).time - messageRecord.time) <= 480) {
                            ((ArrayList) hashMap2.get(g16)).add(messageRecord);
                        } else {
                            i19++;
                            String l3 = ao.l(g16, i19);
                            hashMap2.put(l3, (ArrayList) hashMap2.get(g16));
                            Pair pair = null;
                            int i26 = 0;
                            while (i26 < arrayList3.size()) {
                                pair = (Pair) arrayList3.get(i26);
                                if (((String) pair.first).equals(g16)) {
                                    break;
                                } else {
                                    i26++;
                                }
                            }
                            if (pair != null) {
                                arrayList3.remove(i26);
                                arrayList3.add(i26, new Pair(l3, (Integer) pair.second));
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(messageRecord);
                            hashMap2.put(g16, arrayList4);
                            arrayList3.add(new Pair(g16, Integer.valueOf(i16)));
                        }
                    } else {
                        i16 = i18;
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(messageRecord);
                        hashMap2.put(g16, arrayList5);
                        arrayList3.add(new Pair(g16, Integer.valueOf(i16)));
                    }
                    arrayList2.add(messageRecord);
                    i18 = i16;
                } else {
                    i18++;
                }
                i17 = 0;
            }
            list.removeAll(arrayList2);
            if (!hashMap2.isEmpty() && !arrayList3.isEmpty()) {
                if (eVar.Q0(str, i3) != null) {
                    ArrayList arrayList6 = new ArrayList();
                    Iterator it5 = hashMap2.keySet().iterator();
                    while (it5.hasNext()) {
                        String str2 = (String) it5.next();
                        ArrayList arrayList7 = (ArrayList) hashMap2.get(str2);
                        if (!arrayList7.isEmpty()) {
                            it = it5;
                            if (((MessageRecord) arrayList7.get(0)).longMsgCount > arrayList7.size() && !((MessageRecord) arrayList7.get(0)).isSendFromLocal()) {
                                if (eVar.q1(str, i3, str2)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: incomplete online msg: uin=" + str + ",istroop=" + i3 + ",key=" + str2);
                                    }
                                    arrayList6.add(str2);
                                    Iterator it6 = arrayList3.iterator();
                                    while (true) {
                                        if (it6.hasNext()) {
                                            if (TextUtils.equals((CharSequence) ((Pair) it6.next()).first, str2)) {
                                                it6.remove();
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: complete online msg: uin=" + str + ",istroop=" + i3 + ",key=" + str2);
                                }
                                eVar.D1(str, i3, str2);
                            }
                        } else {
                            it = it5;
                        }
                        it5 = it;
                    }
                    if (!arrayList6.isEmpty()) {
                        Iterator it7 = arrayList6.iterator();
                        while (it7.hasNext()) {
                            hashMap2.remove((String) it7.next());
                        }
                    }
                }
                int size = arrayList3.size() - 1;
                while (size >= 0) {
                    Pair pair2 = (Pair) arrayList3.get(size);
                    ArrayList arrayList8 = (ArrayList) hashMap2.get(pair2.first);
                    try {
                        Collections.sort(arrayList8, f116467n);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.MsgProxyUtils", 2, "sort long msg error", e16);
                        }
                    }
                    ArrayList arrayList9 = new ArrayList();
                    Iterator it8 = arrayList8.iterator();
                    int i27 = 0;
                    while (it8.hasNext()) {
                        MessageRecord messageRecord2 = (MessageRecord) it8.next();
                        if (y(messageRecord2)) {
                            arrayList9.add(messageRecord2);
                            hashMap = hashMap2;
                        } else {
                            if (!arrayList9.isEmpty()) {
                                if (QLog.isColorLevel()) {
                                    hashMap = hashMap2;
                                    QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: uin=" + str + ",istroop=" + i3 + ",key=" + ao.g((MessageRecord) arrayList9.get(0)));
                                } else {
                                    hashMap = hashMap2;
                                }
                                a(list, ((Integer) pair2.second).intValue() + i27, f(arrayList9), arrayList);
                                arrayList9.clear();
                                i27++;
                            } else {
                                hashMap = hashMap2;
                            }
                            a(list, ((Integer) pair2.second).intValue() + i27, messageRecord2, arrayList);
                            i27++;
                        }
                        hashMap2 = hashMap;
                    }
                    HashMap hashMap3 = hashMap2;
                    if (!arrayList9.isEmpty()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: uin=" + str + ",istroop=" + i3 + ",key=" + ao.g((MessageRecord) arrayList9.get(0)));
                        }
                        a(list, ((Integer) pair2.second).intValue() + i27, f(arrayList9), arrayList);
                        arrayList9.clear();
                    }
                    size--;
                    hashMap2 = hashMap3;
                }
            }
        }
    }

    public static boolean R(int i3) {
        for (int i16 : f116455b) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static void S(MessageRecord messageRecord, boolean z16) {
        if (z16) {
            messageRecord.extLong |= 1;
            messageRecord.saveExtInfoToExtStr("one_way", "true");
        } else {
            messageRecord.removeExtInfoToExtStr("one_way");
        }
    }

    public static void T(c cVar) {
        f116454a = cVar;
    }

    private static void a(List<MessageRecord> list, int i3, MessageRecord messageRecord, List<MessageRecord> list2) {
        try {
            list.add(i3, messageRecord);
        } catch (Exception e16) {
            QLog.e("Q.msg.MsgProxyUtils", 1, "addToTailWhenException: ", e16);
            O(list2);
            list.add(messageRecord);
            f116454a.j(e16, list2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r0 == (-2002)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r0 == (-2005)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (c(r8, r9) != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003f, code lost:
    
        if (c(r8, r9) != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        if (c(r8, r9) != false) goto L146;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16) {
        int i3 = messageRecord.msgtype;
        int i16 = messageRecord2.msgtype;
        boolean z17 = true;
        boolean z18 = false;
        if (i3 == i16) {
            long j3 = messageRecord.msgUid;
            if (j3 != 0) {
                if (z16) {
                    if (j3 == messageRecord2.msgUid && messageRecord.shmsgseq == messageRecord2.shmsgseq) {
                        z18 = true;
                    }
                    if (!z18) {
                        if (i3 != -2005) {
                        }
                        if (messageRecord2.istroop == 1008) {
                        }
                    }
                    z17 = z18;
                }
            }
        } else {
            if (i3 == -1000) {
            }
            z17 = z18;
        }
        if (z17 && QLog.isColorLevel()) {
            QLog.w("Q.msg.MsgProxyUtils", 2, "friend---------------msgFilter istroop: " + messageRecord2.istroop + " friendUin: " + messageRecord2.frienduin + " senderUin: " + messageRecord2.senderuin + " LOC_shmsgseq: " + messageRecord.shmsgseq + " NEW_shmsgseq:" + messageRecord.shmsgseq + " LOC_msgType: " + messageRecord.msgtype + " NEW_msgType" + messageRecord2.msgtype + " LOC_msgtime: " + messageRecord.time + " NEW_msgtime:" + messageRecord2.time + " LOC_msgUid:" + messageRecord.msgUid + " NEW_msgUid:" + messageRecord2.msgUid + " LOC_msgContent: " + messageRecord.getLogColorContent() + " NEW_msgContent:" + messageRecord2.getLogColorContent());
        }
        return z17;
    }

    private static boolean c(MessageRecord messageRecord, MessageRecord messageRecord2) {
        int i3 = messageRecord.msgtype;
        if (i3 == -1034) {
            return d(messageRecord, messageRecord2);
        }
        if (i3 == -1042) {
            return d(messageRecord, messageRecord2);
        }
        if (i3 != -2000 && i3 != -1000) {
            if (i3 == -2002) {
                return d(messageRecord, messageRecord2);
            }
            if (i3 == -2005) {
                return d(messageRecord, messageRecord2);
            }
            if (i3 == -5007) {
                return d(messageRecord, messageRecord2);
            }
            if (Math.abs(messageRecord.time - messageRecord2.time) < 30 && messageRecord.shmsgseq == messageRecord2.shmsgseq) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "other equal : mr.shmsgseq = " + messageRecord.shmsgseq);
                }
                if (d(messageRecord, messageRecord2)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        if (Math.abs(messageRecord.time - messageRecord2.time) < 30 && messageRecord.shmsgseq == messageRecord2.shmsgseq && d(messageRecord, messageRecord2)) {
            return true;
        }
        return false;
    }

    private static boolean d(MessageRecord messageRecord, MessageRecord messageRecord2) {
        int i3 = messageRecord.msgtype;
        int i16 = messageRecord2.msgtype;
        if (i3 != i16) {
            return false;
        }
        String str = messageRecord.f203106msg;
        String str2 = messageRecord2.f203106msg;
        if (i16 == -1000) {
            return TextUtils.equals(str, str2);
        }
        return f116454a.k(messageRecord, messageRecord2, str, str2);
    }

    public static boolean e(MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17) {
        String str;
        int i3;
        int i16;
        String str2 = messageRecord.frienduin;
        if (str2 == null || !str2.equals(messageRecord2.frienduin)) {
            return false;
        }
        if (!z16) {
            if (!z17) {
                if (Math.abs(messageRecord.time - messageRecord2.time) >= 30 || !d(messageRecord, messageRecord2)) {
                    return false;
                }
                return true;
            }
            if (messageRecord.shmsgseq != messageRecord2.shmsgseq) {
                return false;
            }
            int i17 = messageRecord.msgtype;
            int i18 = messageRecord2.msgtype;
            if (i17 == i18) {
                return true;
            }
            if ((i17 == -1000 && i18 == -2007) || i17 == -2006 || i18 == -2006) {
                return true;
            }
            if ((i17 == -1000 && i18 == -2011) || H(messageRecord)) {
                return true;
            }
            int i19 = messageRecord2.msgtype;
            if (i19 == -1051 && ((i16 = messageRecord.msgtype) == -1000 || i16 == -2011)) {
                return true;
            }
            int i26 = messageRecord.msgtype;
            if (i26 == -2011 && i19 == -1000) {
                return true;
            }
            if (i19 == -1051 && i26 == -1035) {
                return true;
            }
            if (i26 != -1051 || i19 != -1035) {
                return false;
            }
            return true;
        }
        if (!messageRecord.isSendFromLocal()) {
            return false;
        }
        if ((!TextUtils.equals(messageRecord.getExtInfoFromExtStr("key_troop_sending_message_success"), "1") && (i3 = messageRecord.extraflag) != 32772 && i3 != 32768 && (messageRecord.msgtype != -1035 || i3 != 32770)) || messageRecord.msgtype == -2006 || (str = messageRecord.senderuin) == null || !str.equals(messageRecord2.senderuin)) {
            return false;
        }
        long j3 = messageRecord2.msgUid;
        if (j3 != 0 && messageRecord.msgUid == j3) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxyUtils", 2, "compTroopMsgContent RewriteSeq: find msg by uid=" + messageRecord.msgUid);
            }
            return true;
        }
        if ((Math.abs(messageRecord.time - messageRecord2.time) >= l() + 30 && Math.abs(messageRecord.shmsgseq - messageRecord2.shmsgseq) >= 2) || !d(messageRecord, messageRecord2)) {
            return false;
        }
        return true;
    }

    @NonNull
    private static MessageRecord f(ArrayList<MessageRecord> arrayList) {
        return f116454a.e(arrayList);
    }

    public static String g(int i3) {
        if (i3 != 1001 && i3 != 10002) {
            if (i3 != 1009) {
                if (i3 != 1010) {
                    return AppConstants.LBS_HELLO_UIN;
                }
                return AppConstants.DATE_UIN;
            }
            return AppConstants.SAME_STATE_BOX_UIN;
        }
        return AppConstants.LBS_HELLO_UIN;
    }

    public static List<MessageRecord> h(List<MessageRecord> list, boolean z16) {
        return i(list, z16, 15);
    }

    public static List<MessageRecord> i(List<MessageRecord> list, boolean z16, int i3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            if (z16) {
                Collections.sort(list, new b());
            }
            long j3 = list.get(list.size() - 1).shmsgseq;
            int i16 = 0;
            for (int size = list.size() - 1; size >= 0; size--) {
                MessageRecord messageRecord = list.get(size);
                if (u(messageRecord.msgtype) && messageRecord.shmsgseq == 0) {
                    arrayList.add(0, list.get(size));
                } else {
                    long j16 = messageRecord.shmsgseq;
                    if (j3 - j16 > 1) {
                        break;
                    }
                    if (j3 != j16 || size >= list.size() - 1) {
                        i16++;
                    }
                    j3 = list.get(size).shmsgseq;
                    arrayList.add(0, list.get(size));
                    if (i16 >= i3) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public static int j(List<MessageRecord> list, com.tencent.mobileqq.service.message.e eVar) {
        int i3 = 0;
        if (list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (MessageRecord messageRecord : list) {
                if (!messageRecord.isread && !messageRecord.isLongMsg()) {
                    i3++;
                } else if (!messageRecord.isread && messageRecord.isLongMsg() && !eVar.p1(messageRecord) && !hashSet.contains(ao.g(messageRecord))) {
                    i3++;
                    hashSet.add(ao.g(messageRecord));
                }
            }
        }
        return i3;
    }

    public static String k(MessageRecord messageRecord) {
        int i3 = messageRecord.istroop;
        if (i3 != 1000 && i3 != 1004) {
            if (i3 == 1 && J(messageRecord)) {
                return "80000000";
            }
            if (TextUtils.equals(AppConstants.FILE_ASSISTANT_UIN, messageRecord.senderuin)) {
                messageRecord.senderuin = messageRecord.selfuin;
            }
            return messageRecord.senderuin;
        }
        if (messageRecord.isSend()) {
            return messageRecord.selfuin;
        }
        return messageRecord.frienduin;
    }

    private static int l() {
        return f116454a.g();
    }

    public static int m(String str) {
        if (str.startsWith("mr_discusssion")) {
            return 3000;
        }
        if (str.startsWith("mr_friend")) {
            return 0;
        }
        return 1;
    }

    public static boolean n(List<MessageRecord> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            MessageRecord messageRecord = list.get(i3);
            if (!B(messageRecord) && messageRecord.msgtype != -2006) {
                return true;
            }
        }
        return false;
    }

    public static <T extends MessageRecord> void o(List<T> list, T t16, boolean z16) {
        if (list != null) {
            int i3 = t16.istroop;
            if (i3 != 3000 && i3 != 1) {
                if (ao.r(i3)) {
                    q(list, t16, z16);
                    return;
                } else if (t16.istroop == 10014) {
                    p(list, t16, z16);
                    return;
                } else {
                    list.add(t16);
                    return;
                }
            }
            p(list, t16, z16);
        }
    }

    public static <T extends MessageRecord> void p(List<T> list, T t16, boolean z16) {
        if (list == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxyUtils", 2, "insertToListBySeq, list is null");
                return;
            }
            return;
        }
        int i3 = 0;
        boolean z17 = true;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxyUtils", 2, "insertToListBySeq, list size: ", Integer.valueOf(list.size()));
        }
        boolean z18 = false;
        for (T t17 : list) {
            long j3 = t17.shmsgseq;
            long j16 = t16.shmsgseq;
            if (j3 > j16) {
                break;
            }
            if (j3 == j16) {
                z18 = v(t16, t17);
                if (!z18) {
                    if (!z16) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i3++;
        }
        z17 = z18;
        if (!z17) {
            list.add(t16);
        } else {
            list.add(i3, t16);
        }
    }

    public static <T extends MessageRecord> void q(List<T> list, T t16, boolean z16) {
        if (list == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxyUtils", 2, "insertToListByTime, list is null");
                return;
            }
            return;
        }
        int i3 = 0;
        boolean z17 = false;
        for (T t17 : list) {
            long j3 = t17.time;
            long j16 = t16.time;
            if (j3 <= j16) {
                if (j3 == j16) {
                    z17 = v(t16, t17);
                    if (z17) {
                        break;
                    } else if (!z16) {
                    }
                }
                i3++;
            }
            z17 = true;
        }
        if (!z17) {
            list.add(t16);
        } else {
            list.add(i3, t16);
        }
    }

    public static boolean r(MessageRecord messageRecord) {
        if (messageRecord.msgtype == -5008 && messageRecord.shmsgseq == 0) {
            return "1".equals(messageRecord.getExtInfoFromExtStr("troop_mini_app_sys"));
        }
        return false;
    }

    public static boolean s(int i3) {
        for (int i16 : f116466m) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean t(String str) {
        return AppConstants.MSG_BOX_FOLLOW_UIN.equals(str);
    }

    public static boolean u(int i3) {
        for (int i16 : f116462i) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private static <T extends MessageRecord> boolean v(T t16, MessageRecord messageRecord) {
        return f116454a.d(t16, messageRecord);
    }

    public static boolean w(String str) {
        return AppConstants.MSG_BOX_INTERACT_UIN.equals(str);
    }

    public static boolean x(int i3, int i16) {
        if ((ao.c(i3) == 1001 || ao.c(i3) == 10002) && i16 != -3001 && i16 != -3000 && i16 != -1032 && i16 != -1031 && i16 != -1003) {
            return true;
        }
        return false;
    }

    public static boolean y(MessageRecord messageRecord) {
        return f116454a.b(messageRecord);
    }

    public static boolean z(MessageRecord messageRecord) {
        for (int i3 : ao.f116573g) {
            if (i3 == messageRecord.msgtype) {
                return true;
            }
        }
        return A(messageRecord);
    }
}
