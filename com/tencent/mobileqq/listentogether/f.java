package com.tencent.mobileqq.listentogether;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x857.TroopTips0x857$MediaChangePushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f$MediaUserInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f$MsgBody;

/* compiled from: P */
/* loaded from: classes33.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static String f240916a = "ListenTogether.PushHelper";

    /* renamed from: b, reason: collision with root package name */
    private static String f240917b = "is_open_with_open";

    /* renamed from: c, reason: collision with root package name */
    private static final String f240918c = HardCodeUtil.qqStr(R.string.irt);

    /* renamed from: d, reason: collision with root package name */
    private static final String f240919d = HardCodeUtil.qqStr(R.string.f1624820j);

    private static void e(QQAppInterface qQAppInterface, String str, int i3, String str2, int i16, String str3, long j3, long j16, Bundle bundle) {
        if (!((!TextUtils.isEmpty(str)) & ((i16 == 31 && TextUtils.isEmpty(str3)) ? false : true) & (i16 != 31 || i3 == 1) & ((i16 == 31 && str3.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())) ? false : true) & (i16 == 31 || !TextUtils.isEmpty(str2))) || !((i16 == 31 && bundle.getBoolean(f240917b, false)) ? false : true)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f240916a, 2, "insertGrayTips begin uin:" + str + " uinType:" + i3 + " grayTips:" + str2 + " sub_type:" + i16 + " operUin:" + str3 + " msgSeq:" + j3 + " msgTime:" + j16);
        }
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, str, str2, i3, (i16 == 1 || i16 == 3 || i16 == 2 || i16 == 4) ? MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL : MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 131083, com.tencent.mobileqq.service.message.e.K0());
        b(str2, i16, gVar);
        boolean a16 = a(i3, str, i16, str3, gVar);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.hasRead = 0;
        messageForUniteGrayTip.subType = i16;
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        messageForUniteGrayTip.tipParam.f213693p = str + "_" + i3 + "_listen_together_" + j3 + "_" + j16;
        f(qQAppInterface, gVar, i3, str, a16);
        if (QLog.isDebugVersion()) {
            QLog.d(f240916a, 4, "insertGrayTips end  uin:" + str + " uinType:" + i3 + " wording:" + gVar.f213683f);
        }
    }

    private static boolean a(int i3, String str, int i16, String str2, com.tencent.mobileqq.graytip.g gVar) {
        String str3;
        if (i16 == 31) {
            if (QLog.isColorLevel()) {
                QLog.i(f240916a, 2, String.format("dealGrayTipsJoin uinType=%d uin=%s subType=%d operUin=%s", Integer.valueOf(i3), MobileQQ.getShortUinStr(str), Integer.valueOf(i16), str2));
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            ListenTogetherManager J = ListenTogetherManager.J(qQAppInterface);
            int i17 = i3 == 1 ? 1 : 2;
            boolean l06 = J.l0(i17, str);
            String f16 = tr2.g.f(16, d72.b.k(qQAppInterface, str, i17, str2));
            Resources resources = BaseApplicationImpl.getApplication().getResources();
            Object[] objArr = new Object[2];
            objArr[0] = f16;
            if (l06) {
                str3 = "";
            } else {
                str3 = " " + f240919d;
            }
            objArr[1] = str3;
            String string = resources.getString(R.string.f1625420p, objArr);
            gVar.f213683f = string;
            String str4 = f240919d;
            int indexOf = string.indexOf(str4);
            if (indexOf != -1) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_action", 59);
                gVar.b(indexOf, str4.length() + indexOf, bundle);
                return true;
            }
        }
        return false;
    }

    public static void c(QQAppInterface qQAppInterface, long j3, long j16, TroopTips0x857$MediaChangePushInfo troopTips0x857$MediaChangePushInfo) {
        String str;
        String str2;
        String str3;
        if (troopTips0x857$MediaChangePushInfo != null) {
            Bundle bundle = new Bundle();
            int i3 = troopTips0x857$MediaChangePushInfo.uint32_msg_type.has() ? troopTips0x857$MediaChangePushInfo.uint32_msg_type.get() : -1;
            if (troopTips0x857$MediaChangePushInfo.bytes_msg_info.has()) {
                troopTips0x857$MediaChangePushInfo.bytes_msg_info.get().toStringUtf8();
            }
            if (!troopTips0x857$MediaChangePushInfo.uint64_group_id.has()) {
                str = "";
            } else {
                str = String.valueOf(troopTips0x857$MediaChangePushInfo.uint64_group_id.get());
            }
            if (!troopTips0x857$MediaChangePushInfo.uint64_oper_uin.has()) {
                str2 = "";
            } else {
                str2 = String.valueOf(troopTips0x857$MediaChangePushInfo.uint64_oper_uin.get());
            }
            if (!troopTips0x857$MediaChangePushInfo.bytes_gray_tips.has()) {
                str3 = "";
            } else {
                str3 = troopTips0x857$MediaChangePushInfo.bytes_gray_tips.get().toStringUtf8();
            }
            long j17 = troopTips0x857$MediaChangePushInfo.uint64_msg_seq.has() ? troopTips0x857$MediaChangePushInfo.uint64_msg_seq.get() : 0L;
            int i16 = troopTips0x857$MediaChangePushInfo.uint32_join_nums.has() ? troopTips0x857$MediaChangePushInfo.uint32_join_nums.get() : 0;
            boolean z16 = troopTips0x857$MediaChangePushInfo.is_join_when_start.get();
            bundle.putBoolean(f240917b, z16);
            if (QLog.isColorLevel()) {
                QLog.i(f240916a, 2, "decodeGroupPush, msg_type = " + i3 + " groupUin = " + str + " oper_uin = " + str2 + " gray_tips = " + str3 + " timeStamp = " + j17 + " joinedNum = " + i16 + " isOpenWithJoin = " + z16);
            }
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) qQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
            long X = listenTogetherManager.X(1, str);
            if (j17 < X) {
                QLog.d(f240916a, 1, String.format("decodeGroupPush, filter oldTimeStamp: %s, timeStamp: %s, msyType: %s, groupUin: %s", Long.valueOf(j17), Long.valueOf(X), Integer.valueOf(i3), str));
                return;
            }
            if (i3 == 31 || i3 == 32) {
                listenTogetherManager.c1(1, str, j3, j17, d72.b.i(1, i16, 0));
            }
            listenTogetherManager.d1(1, str, j3, str2, i3, j17, i3 == 16 ? Integer.valueOf(troopTips0x857$MediaChangePushInfo.uint32_play_mode.get()) : null);
            e(qQAppInterface, str, 1, str3, i3, str2, j3, j16, bundle);
            return;
        }
        QLog.d(f240916a, 1, "decodeGroupPush, pushInfo == null");
    }

    private static void b(String str, int i3, com.tencent.mobileqq.graytip.g gVar) {
        if (i3 == 1 || i3 == 3) {
            int indexOf = str.indexOf(f240918c);
            if (indexOf != -1) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_action", 46);
                gVar.b(indexOf, indexOf + 4, bundle);
                return;
            }
            QLog.d(f240916a, 1, String.format("grayTips: %s don't contain keyword", str));
        }
    }

    private static void f(QQAppInterface qQAppInterface, com.tencent.mobileqq.graytip.g gVar, int i3, String str, boolean z16) {
        int i16;
        String uidFromUin;
        LocalGrayTip m3;
        if (i3 == 1) {
            uidFromUin = str;
            i16 = 2;
        } else {
            i16 = 1;
            uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        }
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(uidFromUin, i16, 1010L, 1, true, true, null);
        if (z16) {
            int length = gVar.f213683f.length();
            String str2 = gVar.f213683f;
            String str3 = f240919d;
            m3 = localGrayTipBuilder.g(str2.substring(0, length - str3.length()), 1).h(str3, new com.tencent.mobileqq.listentogether.nt.b(i3, str), 3).m();
        } else {
            m3 = localGrayTipBuilder.g(gVar.f213683f, 1).m();
        }
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(qQAppInterface, m3, null);
    }

    public static void d(QQAppInterface qQAppInterface, byte[] bArr, long j3, long j16, boolean z16) {
        int i3;
        SubMsgType0x11f$MsgBody subMsgType0x11f$MsgBody;
        int i16;
        String valueOf;
        long j17;
        String str;
        String str2;
        String stringUtf8;
        long j18;
        long j19;
        int i17;
        String str3;
        if (qQAppInterface == null) {
            return;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (QLog.isColorLevel()) {
            QLog.i(f240916a, 2, "decodePush0x210_0x11f, msgSeq = " + j3 + " msgTime = " + j16 + " selfUin:" + currentAccountUin + " isOffline = " + z16);
        }
        if (bArr != null && !TextUtils.isEmpty(currentAccountUin)) {
            try {
                subMsgType0x11f$MsgBody = new SubMsgType0x11f$MsgBody();
                subMsgType0x11f$MsgBody.mergeFrom(bArr);
                i16 = subMsgType0x11f$MsgBody.uint32_msg_type.get();
                valueOf = String.valueOf(subMsgType0x11f$MsgBody.uint64_oper_uin.get());
                j17 = subMsgType0x11f$MsgBody.uint64_msg_seq.has() ? subMsgType0x11f$MsgBody.uint64_msg_seq.get() : 0L;
                List<SubMsgType0x11f$MediaUserInfo> list = subMsgType0x11f$MsgBody.rpt_msg_media_uin.get();
                String str4 = "";
                if (list == null || list.size() <= 0) {
                    str = "";
                    str2 = str;
                } else {
                    String str5 = "";
                    for (SubMsgType0x11f$MediaUserInfo subMsgType0x11f$MediaUserInfo : list) {
                        String valueOf2 = String.valueOf(subMsgType0x11f$MediaUserInfo.uint64_to_uin.get());
                        int i18 = subMsgType0x11f$MediaUserInfo.uint32_join_state.get();
                        if (currentAccountUin.equals(valueOf2)) {
                            str3 = currentAccountUin;
                            str5 = d72.b.i(2, 0, i18);
                        } else {
                            str3 = currentAccountUin;
                            str4 = valueOf2;
                        }
                        currentAccountUin = str3;
                    }
                    str2 = str5;
                    str = str4;
                }
                stringUtf8 = subMsgType0x11f$MsgBody.bytes_gray_tips.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    i3 = 2;
                    QLog.i(f240916a, 2, "decodePush0x210_0x11f, msg_type = " + i16 + " friend_uin = " + str + " oper_uin = " + valueOf + " gray_tips = " + stringUtf8 + " timeStamp = " + j17 + " statusTips = " + str2);
                }
                try {
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                i3 = 1;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                if (z16) {
                    if (i16 != 1 && i16 != 2 && i16 != 3 && i16 != 4) {
                        try {
                            QLog.d(f240916a, 1, "filter offline msg, msgType:" + i16);
                            return;
                        } catch (Throwable th7) {
                            th = th7;
                            i3 = 1;
                        }
                    } else {
                        j18 = j17;
                        long j26 = qQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp17", 0L);
                        if (j18 / 1000 < j26) {
                            String str6 = f240916a;
                            Object[] objArr = new Object[2];
                            objArr[0] = Long.valueOf(j18 / 1000);
                            try {
                                objArr[1] = Long.valueOf(j26);
                                QLog.d(str6, 1, String.format("filter offline msg, timestamp: %s < incUpdateTimeStamp: %s", objArr));
                                return;
                            } catch (Throwable th8) {
                                th = th8;
                                i3 = 1;
                            }
                        }
                    }
                    QLog.i(f240916a, i3, "decodePush0x210_0x11f decode error, e=" + th.toString());
                    return;
                }
                j18 = j17;
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) qQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
                long X = listenTogetherManager.X(2, str);
                if (j18 <= X) {
                    String str7 = f240916a;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = Long.valueOf(j18);
                    objArr2[1] = Long.valueOf(X);
                    objArr2[2] = Integer.valueOf(i16);
                    objArr2[3] = str;
                    QLog.d(str7, 1, String.format("decodePush0x210_0x11f, filter oldTimeStamp: %s, timeStamp: %s, msyType: %s, friendUin: %s", objArr2));
                    return;
                }
                if (i16 == 31 || i16 == 32) {
                    j19 = j18;
                    i17 = 1;
                    try {
                        listenTogetherManager.c1(2, str, j3, j19, str2);
                    } catch (Throwable th9) {
                        th = th9;
                        i3 = i17;
                    }
                } else {
                    i17 = 1;
                    j19 = j18;
                }
                listenTogetherManager.d1(2, str, j3, valueOf, i16, j19, i16 == 16 ? Integer.valueOf(subMsgType0x11f$MsgBody.uint32_play_mode.get()) : null);
                e(qQAppInterface, str, 0, stringUtf8, i16, valueOf, j3, j16, new Bundle());
                return;
            }
            QLog.d(f240916a, 1, "filter friendUin: " + str + ", operatorUin: " + valueOf);
            return;
        }
        QLog.i(f240916a, 1, "decodePush0x210_0x11f pbData = null");
    }
}
