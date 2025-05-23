package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.nearby.k;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype21;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f202191a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f202191a = HardCodeUtil.qqStr(R.string.uda);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0075 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg) {
        hummer_commelem$MsgElemInfo_servtype21 hummer_commelem_msgeleminfo_servtype21;
        if (list2 != null && list != null && list.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.TroopConfess", 2, "decodeTroopConfessMsgElem");
            }
            for (im_msg_body$Elem im_msg_body_elem : list) {
                if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.uint32_service_type.get() == 21 && im_msg_body_elem.common_elem.uint32_business_type.get() == 3 && im_msg_body_elem.common_elem.bytes_pb_elem.has()) {
                    hummer_commelem$MsgElemInfo_servtype21 hummer_commelem_msgeleminfo_servtype212 = null;
                    try {
                        hummer_commelem_msgeleminfo_servtype21 = new hummer_commelem$MsgElemInfo_servtype21();
                        try {
                            hummer_commelem_msgeleminfo_servtype21.mergeFrom(im_msg_body_elem.common_elem.bytes_pb_elem.get().toByteArray());
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e = e16;
                            hummer_commelem_msgeleminfo_servtype212 = hummer_commelem_msgeleminfo_servtype21;
                            e.printStackTrace();
                            hummer_commelem_msgeleminfo_servtype21 = hummer_commelem_msgeleminfo_servtype212;
                            if (hummer_commelem_msgeleminfo_servtype21 != null) {
                            }
                        }
                    } catch (InvalidProtocolBufferMicroException e17) {
                        e = e17;
                    }
                    if (hummer_commelem_msgeleminfo_servtype21 != null) {
                        return;
                    }
                    TroopConfessMsg troopConfessMsg = new TroopConfessMsg();
                    troopConfessMsg.convertFrom(hummer_commelem_msgeleminfo_servtype21);
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.msg.TroopConfess", 2, String.format("decodeTroopConfessMsgElem %s", troopConfessMsg.toString()));
                    }
                    MessageForTroopConfess messageForTroopConfess = (MessageForTroopConfess) q.d(MessageRecord.MSG_TYPE_TROOP_CONFESS);
                    messageForTroopConfess.msgtype = MessageRecord.MSG_TYPE_TROOP_CONFESS;
                    messageForTroopConfess.f203106msg = troopConfessMsg.getSimpleMsg();
                    messageForTroopConfess.msgData = troopConfessMsg.getBytes();
                    messageForTroopConfess.isToSelf = troopConfessMsg.isToSelf();
                    if (messageForTroopConfess.msgData == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("Q.msg.TroopConfess", 2, "decode msgData null");
                        }
                    } else {
                        list2.add(messageForTroopConfess);
                    }
                }
            }
        }
    }

    @Deprecated
    private static List<TroopMemberInfo> c(final String str) {
        final ArrayList arrayList = new ArrayList();
        final long currentTimeMillis = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, null, false, "Q.msg.TroopConfess", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.confess.f
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                g.h(arrayList, str, currentTimeMillis, countDownLatch, z16, list);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            QLog.e("Q.msg.TroopConfess", 1, "[getAllTroopMembers] error:" + e16.getMessage());
        }
        return arrayList;
    }

    public static Object[] d(String str) {
        QQAppInterface qQAppInterface;
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        int size;
        boolean z19;
        TroopInfo k3;
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.TroopConfess", 2, "TroopConfessUtil.getTroopMembers " + str);
        }
        ArrayList arrayList = null;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null || TextUtils.isEmpty(qQAppInterface.getCurrentAccountUin())) {
            return null;
        }
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(str)) != null) {
            if (k3.isOwner()) {
                i3 = 2;
            } else if (k3.isOwnerOrAdmin()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if ((k3.dwGroupFlagExt & 128) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        } else {
            z16 = false;
            i3 = 0;
        }
        if (i3 <= 0 && !z16) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.TroopConfess", 2, String.format("TroopConfessUtil.getTroopMembers canInvite=%s memLevel:%d", Boolean.valueOf(z17), Integer.valueOf(i3)));
        }
        if (!z17) {
            Object[] objArr = new Object[3];
            if (i3 > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            objArr[0] = Boolean.valueOf(z19);
            objArr[1] = Boolean.valueOf(z16);
            objArr[2] = null;
            return objArr;
        }
        List<TroopMemberInfo> c16 = c(str);
        if (c16 != null) {
            arrayList = new ArrayList(c16.size());
            for (TroopMemberInfo troopMemberInfo : c16) {
                if (Utils.M(troopMemberInfo.memberuin)) {
                    arrayList.add(troopMemberInfo.memberuin);
                }
            }
        }
        if (QLog.isColorLevel()) {
            Object[] objArr2 = new Object[1];
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            objArr2[0] = Integer.valueOf(size);
            QLog.i("Q.msg.TroopConfess", 2, String.format("TroopConfessUtil.getTroopMembers findUins:%d", objArr2));
        }
        Object[] objArr3 = new Object[3];
        if (i3 > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        objArr3[0] = Boolean.valueOf(z18);
        objArr3[1] = Boolean.valueOf(z16);
        objArr3[2] = arrayList;
        return objArr3;
    }

    public static boolean e(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (messageRecord.isOpenTroopMessage) {
            return true;
        }
        if (messageRecord.istroop != 1) {
            return false;
        }
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && troopManager.a0()) {
            return true;
        }
        return false;
    }

    public static boolean f(QQAppInterface qQAppInterface, String str, boolean z16) {
        if (!z16) {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(str, "TroopConfessUtil", null, null);
        }
        TroopInfo B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str);
        if (B != null && (B.dwGroupFlagExt3 & 8192) == 0) {
            return true;
        }
        return false;
    }

    public static boolean g(QQAppInterface qQAppInterface) {
        TroopManager troopManager;
        if (qQAppInterface == null || (troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) == null) {
            return false;
        }
        return troopManager.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(List list, String str, long j3, CountDownLatch countDownLatch, boolean z16, List list2) {
        if (z16) {
            list.addAll(list2);
        }
        QLog.i("Q.msg.TroopConfess", 1, "[getAllTroopMembers] groupCode=" + str + ", cost time=" + (System.currentTimeMillis() - j3));
        countDownLatch.countDown();
    }

    public static String i(String str, String str2) {
        try {
            for (String str3 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] d16 = bi.d(str3, ContainerUtils.KEY_VALUE_DELIMITER);
                if (d16.length == 2 && "url_prefix".equals(d16[0]) && !TextUtils.isEmpty(d16[1])) {
                    String str4 = d16[0] + ContainerUtils.KEY_VALUE_DELIMITER + d16[1];
                    String str5 = new String(PluginBaseInfoHelper.Base64Helper.decode(d16[1], 0));
                    if (!str5.contains("&gc=")) {
                        str5 = String.format("%s&gc=%s", str5, k.b(str2));
                    }
                    return str.replace(str4, d16[0] + ContainerUtils.KEY_VALUE_DELIMITER + PluginBaseInfoHelper.Base64Helper.encodeToString(str5.getBytes(), 2));
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.TroopConfess", 2, e16.getMessage(), e16);
            }
        }
        return str;
    }
}
