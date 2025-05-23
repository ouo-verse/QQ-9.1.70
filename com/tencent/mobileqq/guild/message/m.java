package com.tencent.mobileqq.guild.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.aj;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSummaryDecodersApi;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class m extends b {
    public static com.tencent.mobileqq.guild.message.base.c F;
    private com.tencent.mobileqq.guild.message.lastmsg.b E;

    public m(AppRuntime appRuntime, MsgPool msgPool) {
        super(appRuntime, msgPool);
        this.E = null;
        this.E = new com.tencent.mobileqq.guild.message.lastmsg.b(appRuntime, this);
    }

    private com.tencent.mobileqq.troop.data.c A0(com.tencent.mobileqq.troop.data.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.tencent.mobileqq.troop.data.c cVar2 = new com.tencent.mobileqq.troop.data.c(cVar);
        cVar2.f294891a = cVar.f294891a;
        cVar2.f294892b = cVar.f294892b;
        return cVar2;
    }

    private void B0(Map<String, MessageRecord> map, MessageRecord messageRecord, boolean z16, boolean z17, boolean z18) {
        Iterator<com.tencent.imcore.message.adder.h> it = this.f116282e.getRegistry().b().iterator();
        while (it.hasNext()) {
            it.next().a(this.f116281d, this, messageRecord, z16, z17, z18, map, messageRecord.frienduin, messageRecord.istroop);
        }
    }

    private void C0(String str, int i3, int i16, aj ajVar, long j3, MessageRecord messageRecord, int i17, List<MessageRecord> list, long j16, boolean z16, int i18) {
        long id5;
        aj ajVar2;
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager.GuildMessageManager", 2, String.format("refresh roam doRefreshMsgFromDB() uin=%s type=%s count=%s headseq=%s endSeq=%s roamSuc=%s roamResCode=%s locallist=%s", str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), Integer.valueOf(i18), Integer.valueOf(list.size())));
        }
        if ((list.isEmpty() && j16 > 0) || ((!z16 && list.size() < i16) || (z16 && i18 != 0 && list.size() < i16))) {
            long D0 = D0(str, i3, list, j16);
            com.tencent.imcore.message.f y16 = y(i3);
            if (messageRecord == null) {
                id5 = 0;
            } else {
                id5 = messageRecord.getId();
            }
            List<MessageRecord> Z = y16.Z(str, i3, id5, i17, D0, i16 - list.size(), null);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh roam fail step 0 , size = " + Z.size() + ",seq = " + D0 + " , timestamp = " + System.currentTimeMillis());
            }
            if (Z.isEmpty()) {
                ajVar2 = ajVar;
                ajVar2.f116525c = true;
            } else {
                ajVar2 = ajVar;
                list.addAll(0, Z);
            }
            ajVar2.f116527e = true;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh roam addRoamMsgToList uniseq = " + j3 + " , locallist = " + list.size() + " , timestamp = " + System.currentTimeMillis());
        }
        y(i3).e(str, i3, j3, list);
    }

    private long D0(String str, int i3, List<MessageRecord> list, long j3) {
        StringBuilder sb5;
        long j16;
        if (!list.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (MessageRecord messageRecord : list) {
                if (messageRecord.shmsgseq == list.get(0).shmsgseq) {
                    StringBuilder sb6 = new StringBuilder();
                    if (messageRecord.getId() > 0) {
                        sb5 = new StringBuilder();
                        sb5.append("id&");
                        j16 = messageRecord.getId();
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append("uniseq&");
                        j16 = messageRecord.uniseq;
                    }
                    sb5.append(j16);
                    sb6.append(sb5.toString());
                    sb6.append(ContainerUtils.FIELD_DELIMITER);
                    sb6.append(messageRecord.shmsgseq);
                    hashMap.put(sb6.toString(), messageRecord);
                }
            }
            list.addAll(0, y(i3).p0(str, i3, list.get(0).shmsgseq, hashMap));
            return list.get(0).shmsgseq - 1;
        }
        return j3;
    }

    private HashMap<String, MessageRecord> E0(String str, int i3, List<MessageRecord> list) {
        StringBuilder sb5;
        long j3;
        HashMap<String, MessageRecord> hashMap = new HashMap<>();
        if (list != null && !list.isEmpty()) {
            MessageRecord H = y(i3).H(str, i3, Y0(list));
            if (H != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh find msg in cache id = " + H.getId() + ", msg = " + H.getLogColorContent() + ", uniseq = " + H.uniseq + " , msgtime = " + H.time + " , shMsgSeq = " + H.shmsgseq + " , extra = " + H.extraflag);
                }
                if (!list.isEmpty()) {
                    for (MessageRecord messageRecord : list) {
                        if (messageRecord.shmsgseq == H.shmsgseq) {
                            StringBuilder sb6 = new StringBuilder();
                            if (messageRecord.getId() > 0) {
                                sb5 = new StringBuilder();
                                sb5.append("id&");
                                j3 = messageRecord.getId();
                            } else {
                                sb5 = new StringBuilder();
                                sb5.append("uniseq&");
                                j3 = messageRecord.uniseq;
                            }
                            sb5.append(j3);
                            sb6.append(sb5.toString());
                            sb6.append(ContainerUtils.FIELD_DELIMITER);
                            sb6.append(messageRecord.shmsgseq);
                            hashMap.put(sb6.toString(), messageRecord);
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh can't find msg in cache !!");
            }
            return hashMap;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
        }
        return hashMap;
    }

    private long F0(List<MessageRecord> list) {
        long j3 = 0;
        long j16 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            MessageRecord messageRecord = list.get(size);
            if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(messageRecord)) {
                if (j3 != 0) {
                    long j17 = messageRecord.shmsgseq;
                    if (j3 - j17 != 1) {
                        if (j3 - j17 > 1) {
                            break;
                        }
                    }
                }
                j16 = messageRecord.uniseq;
                j3 = messageRecord.shmsgseq;
            }
        }
        return j16;
    }

    private int G0(long j3, List<MessageRecord> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).uniseq == j3) {
                return i3;
            }
        }
        return 0;
    }

    private List<MessageRecord> H0(List<MessageRecord> list) {
        if (list != null && !list.isEmpty()) {
            long j3 = list.get(list.size() - 1).shmsgseq;
            ArrayList arrayList = new ArrayList();
            int size = list.size() - 1;
            while (size >= 0) {
                MessageRecord messageRecord = list.get(size);
                long j16 = messageRecord.shmsgseq;
                if (j3 - j16 > 1) {
                    break;
                }
                arrayList.add(messageRecord);
                size--;
                j3 = j16;
            }
            int size2 = arrayList.size() / 2;
            int size3 = arrayList.size() - 1;
            int i3 = 0;
            while (i3 < size2) {
                MessageRecord messageRecord2 = (MessageRecord) arrayList.get(i3);
                arrayList.set(i3, (MessageRecord) arrayList.get(size3));
                arrayList.set(size3, messageRecord2);
                i3++;
                size3--;
            }
            return arrayList;
        }
        return list;
    }

    private int I0(List<MessageRecord> list, int i3) {
        int i16 = i3;
        while (i3 < list.size() - 1) {
            long j3 = list.get(i3).shmsgseq;
            i3++;
            if (j3 != list.get(i3).shmsgseq) {
                break;
            }
            i16++;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh same seq  itemListStartPoint= " + i16);
            }
        }
        return i16;
    }

    private int J0(List<MessageRecord> list) {
        int i3 = 0;
        int i16 = 0;
        while (i3 < list.size() - 1) {
            long j3 = list.get(i3).shmsgseq;
            i3++;
            if (j3 != list.get(i3).shmsgseq) {
                break;
            }
            i16++;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh same seq  itemListStartPoint= " + i16);
            }
        }
        return i16;
    }

    private int K0(List<MessageRecord> list, int i3) {
        while (i3 > 0 && list.get(i3 - 1).shmsgseq == list.get(i3).shmsgseq) {
            i3--;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh same seq  itemListStartPoint= " + i3);
            }
        }
        return i3;
    }

    private void N0(String str, int i3, int i16, HashMap<String, MessageRecord> hashMap, List<MessageRecord> list, int i17, List<MessageRecord> list2, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache step 1, timestamp = " + System.currentTimeMillis());
        }
        int i18 = i17 - i16;
        long j16 = list.get(i18).shmsgseq;
        int K0 = K0(list, i18);
        if (K0 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache step 2, timestamp = " + System.currentTimeMillis());
            }
            int I0 = I0(list, i18) + 1;
            if (I0 > i17) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache step 3, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
                }
                list2.addAll(y(i3).p0(str, i3, j3, hashMap));
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache step 4, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
                    return;
                }
                return;
            }
            list2.addAll(list.subList(I0, i17));
            int size = i16 - list2.size();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache step 5, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
            }
            com.tencent.imcore.message.f y16 = y(i3);
            long j17 = j16 - size;
            if (j17 < 0) {
                j17 = 0;
            }
            list2.addAll(0, y16.X(str, i3, j17, j16, i16, true));
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache step 6, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
                return;
            }
            return;
        }
        list2.addAll(list.subList(K0, i17));
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache step 7, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    private void O0(String str, int i3, int i16, HashMap<String, MessageRecord> hashMap, List<MessageRecord> list, int i17, List<MessageRecord> list2) {
        long j3;
        long j16 = list.get(0).shmsgseq;
        int J0 = J0(list) + 1;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache and DB step 0, sameSeq = " + j16 + ",itemListStartPoint = " + J0 + ", timestamp = " + System.currentTimeMillis());
        }
        if (J0 > i17) {
            list2.addAll(y(i3).p0(str, i3, j16, hashMap));
        } else {
            list2.addAll(list.subList(J0, i17));
        }
        int size = i16 - list2.size();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache and DB step 1, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
        long j17 = j16 - size;
        if (j17 >= 0) {
            j3 = j17;
        } else {
            j3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "getLocalListRefreshReadCacheAndDB() called with: beginSeq = [" + j3 + "],endSeq=[" + j16 + "]");
        }
        list2.addAll(0, y(i3).X(str, i3, j3, j16, i16, true));
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache and DB step 2, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    public static com.tencent.mobileqq.guild.message.base.c P0() {
        return F;
    }

    private void R0(List<MessageRecord> list) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAutoRefreshHeadMsgUniseq ");
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb5.append("NO.");
                sb5.append(i3);
                sb5.append(", seq = ");
                sb5.append(list.get(i3).shmsgseq);
                sb5.append(", ");
            }
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, sb5.toString());
        }
    }

    private boolean S0(MessageRecord messageRecord) {
        if (messageRecord.time == 0) {
            messageRecord.time = com.tencent.mobileqq.service.message.e.K0();
        }
        if (messageRecord.msgseq == 0) {
            messageRecord.msgseq = (int) messageRecord.time;
        }
        if (messageRecord.isSendFromLocal() && messageRecord.extraflag == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "addMessage set sendmsg extra " + messageRecord.getBaseInfoString());
            }
            messageRecord.setExtraFlag(32772);
            messageRecord.setSendFailCode(0);
        }
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        if (iGuildMessageUtilsApi.getGuildIdFromMR(messageRecord) == 0) {
            String guildIdOf = ((IGPSService) this.f116281d.getRuntimeService(IGPSService.class, "")).getGuildIdOf(messageRecord.frienduin);
            if (TextUtils.isEmpty(guildIdOf)) {
                guildIdOf = String.valueOf(((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).getGuildId(messageRecord.frienduin));
            }
            if (!TextUtils.isEmpty(guildIdOf)) {
                iGuildMessageUtilsApi.saveGuildIdToMR(messageRecord, guildIdOf);
            } else {
                if (iGuildMessageUtilsApi.isGuest(messageRecord.frienduin) && !TextUtils.isEmpty(guildIdOf)) {
                    iGuildMessageUtilsApi.saveGuildIdToMR(messageRecord, guildIdOf);
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "addMessageRecord, invalid guild id");
                }
                return false;
            }
        }
        return true;
    }

    private void T0(aj ajVar, long j3, long j16, boolean z16, List<MessageRecord> list, long j17, int i3) {
        int i16;
        boolean z17;
        int i17;
        List<MessageRecord> list2;
        int i18;
        aj ajVar2;
        int size;
        int i19;
        String str = ajVar.f116541s;
        int i26 = ajVar.f116542t;
        if (!ajVar.f116527e && j16 >= j3 && j16 > 0 && z16) {
            Bundle bundle = new Bundle();
            bundle.putString("guild_id", ajVar.a().getString("guild_id"));
            bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, ajVar.a().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG));
            int addAndGet = this.f116282e.getPullCounter().addAndGet(1);
            bundle.putInt("counter", addAndGet);
            bundle.putBoolean("success", false);
            bundle.putInt("load_count", ajVar.f116543u);
            this.f116282e.getPullCache().put(Integer.valueOf(addAndGet), list);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "doRefreshMessageListHead() refresh roam step 0 , timestamp = " + System.currentTimeMillis());
            }
            bundle.putInt("roam_msg_pull_direction", i3);
            W0(str, i26, j3, j16, bundle);
            this.f116282e.getAutoPullCache().put(ao.f(str, i26), Boolean.FALSE);
            U0(list);
            boolean z18 = bundle.getBoolean("success");
            i16 = bundle.getInt("resCode", 0);
            z17 = z18;
        } else {
            i16 = 0;
            z17 = true;
        }
        if (z17 && ((i16 == 65534 || i16 == 65535) && (i19 = ajVar.f116540r) < 1)) {
            ajVar.f116524b = null;
            ajVar.f116540r = i19 + 1;
            i18 = i26;
            ajVar2 = ajVar;
            list2 = list;
        } else {
            MessageRecord H = y(i26).H(str, i26, j17);
            if (H == null) {
                i17 = 3;
            } else {
                i17 = H.versionCode;
            }
            list2 = list;
            C0(str, i26, ajVar.f116543u, ajVar, j17, H, i17, list, j16, z17, i16);
            I(list2);
            y(i26).a(str, i26, list2);
            i18 = i26;
            ajVar2 = ajVar;
            ajVar2.f116524b = list2;
            ajVar2.f116540r = 0;
            if (list2 != null && list.size() > 0) {
                boolean z19 = list2.get(list.size() - 1) instanceof st1.j;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager.trooptroop_pull_msg", 2, "context.isLocalOnly = " + ajVar2.f116527e + ", context.retryIndexOfServerError = " + ajVar2.f116540r);
        }
        IMessageFacade iMessageFacade = this.f116282e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doRefreshMessageListHead() refresh finish , context = ");
        sb5.append(ajVar2);
        sb5.append(" , size = ");
        if (list2 == null) {
            size = -1;
        } else {
            size = list.size();
        }
        sb5.append(size);
        iMessageFacade.qLogColor(sb5.toString(), ", timestamp = " + System.currentTimeMillis());
        M(ajVar2, i18);
    }

    private long Y0(List<MessageRecord> list) {
        for (MessageRecord messageRecord : list) {
            if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(messageRecord) && messageRecord.shmsgseq > 0) {
                return messageRecord.uniseq;
            }
        }
        return 0L;
    }

    private boolean b1(List<MessageRecord> list) {
        Iterator<MessageRecord> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shmsgseq > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean c1(int i3, aj ajVar, boolean z16) {
        if (z16) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        }
        ajVar.f116524b = null;
        M(ajVar, i3);
        return true;
    }

    public static void e1(com.tencent.mobileqq.guild.message.base.r rVar) {
        if (rVar instanceof com.tencent.mobileqq.guild.message.base.c) {
            F = (com.tencent.mobileqq.guild.message.base.c) rVar;
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public long A(MessageRecord messageRecord) {
        return messageRecord.shmsgseq;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void K(Message message) {
        String selfTinyId = ((IGPSService) this.f116281d.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (!TextUtils.isEmpty(selfTinyId) && selfTinyId.equals(message.senderuin)) {
            message.nickName = HardCodeUtil.qqStr(R.string.f1506915o);
        } else {
            message.nickName = ((IGuildNicknameApi) QRoute.api(IGuildNicknameApi.class)).getDisplayName(this.f116281d, String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(message)), message.senderuin, message);
        }
        if (TextUtils.isEmpty(message.nickName)) {
            message.nickName = message.senderuin;
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void L(Message message) {
        K(message);
    }

    public List<MessageRecord> L0(String str, int i3, int i16) {
        return M0(str, i3, i16, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.BaseMessageManager
    public void M(aj ajVar, int i3) {
        boolean z16;
        List<MessageRecord> list = ajVar.f116524b;
        if (list != null && list.size() > 0) {
            synchronized (ajVar.f116524b) {
                ((IGuildMsgProxyUtilsApi) QRoute.api(IGuildMsgProxyUtilsApi.class)).pretreatmentAIOMsg(i3, ajVar.f116524b, this.f116281d);
                if (ajVar.f116524b.size() > 0) {
                    ad.P(ajVar.f116541s, ajVar.f116542t, ajVar.f116524b, (com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache());
                }
            }
            z16 = true;
        } else {
            z16 = false;
        }
        String str = ajVar.f116541s;
        int i16 = ajVar.f116543u;
        if (ajVar.f116528f && z16 && ajVar.f116524b.isEmpty() && ajVar.f116535m < 9) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + ajVar.f116535m + " ]");
            }
            ajVar.f116535m++;
            n(str, i3, i16, ajVar);
            return;
        }
        ajVar.f116535m = 0;
        ajVar.f116536n = 0;
        if (ajVar.f116531i) {
            this.f116282e.setChangeAndNotify(ajVar);
        }
    }

    public List<MessageRecord> M0(String str, int i3, int i16, boolean z16) {
        long Y0;
        ArrayList arrayList;
        long j3;
        if (i16 > 0) {
            System.currentTimeMillis();
            List<MessageRecord> l3 = y(i3).l(str, i3);
            if (l3 != null && !l3.isEmpty()) {
                if (z16) {
                    Y0 = F0(l3);
                } else {
                    Y0 = Y0(l3);
                }
                MessageRecord H = y(i3).H(str, i3, Y0);
                HashMap<String, MessageRecord> E0 = E0(str, i3, l3);
                List<MessageRecord> H0 = H0(y(i3).p(str, i3));
                int G0 = G0(Y0, H0);
                synchronized (this) {
                    arrayList = new ArrayList();
                    if (H == null) {
                        j3 = 0;
                    } else {
                        j3 = H.shmsgseq;
                    }
                    if (G0 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh cache miss step 0, timestamp = " + System.currentTimeMillis());
                        }
                        com.tencent.imcore.message.f y16 = y(i3);
                        long j16 = j3 - i16;
                        if (j16 < 0) {
                            j16 = 0;
                        }
                        long j17 = j3 - 1;
                        if (j17 < 0) {
                            j17 = 0;
                        }
                        arrayList.addAll(y16.X(str, i3, j16, j17, i16, true));
                        arrayList.addAll(y(i3).p0(str, i3, j3, E0));
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh cache miss step 1, timestamp = " + System.currentTimeMillis());
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh read cache step 0, cacheIndex = " + G0 + " timestamp = " + System.currentTimeMillis());
                        }
                        if (G0 >= i16) {
                            N0(str, i3, i16, E0, H0, G0, arrayList, j3);
                        } else {
                            O0(str, i3, i16, E0, H0, G0, arrayList);
                        }
                    }
                }
                return arrayList;
            }
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
            }
            return new ArrayList();
        }
        throw new IllegalArgumentException("COUNT MUST > 0 !");
    }

    public void Q0(int i3, String str, String str2, long j3, List<ChatMessage> list) {
        long j16;
        String str3;
        if (list != null && list.size() != 0) {
            Iterator<ChatMessage> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    ChatMessage next = it.next();
                    if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(next)) {
                        j16 = next.shmsgseq;
                        break;
                    }
                } else {
                    j16 = 0;
                    break;
                }
            }
            if (j16 <= j3 && j3 != 0 && j16 != 0) {
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                Iterator<ChatMessage> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    ChatMessage next2 = it5.next();
                    if (next2.shmsgseq == j3) {
                        K0 = next2.time;
                        break;
                    }
                }
                long j17 = K0;
                String currentAccountUin = this.f116281d.getCurrentAccountUin();
                String selfTinyId = ((IGPSService) this.f116281d.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
                MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS);
                if (TextUtils.isEmpty(selfTinyId)) {
                    str3 = currentAccountUin;
                } else {
                    str3 = selfTinyId;
                }
                createMsgRecordByMsgType.init(currentAccountUin, str2, str3, "", j17, MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS, i3, 0L);
                if (!TextUtils.isEmpty(str)) {
                    ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(createMsgRecordByMsgType, str);
                }
                createMsgRecordByMsgType.shmsgseq = j3;
                ArrayList<MessageRecord> arrayList = new ArrayList<>();
                arrayList.add(createMsgRecordByMsgType);
                QLog.i("Q.msg.BaseMessageManager.GuildMessageManager", 1, "insertSeparateMessageIfNeeded, mr shmsgseq: " + createMsgRecordByMsgType.shmsgseq + ", uniseq: " + createMsgRecordByMsgType.uniseq + ", channelId: " + str2);
                this.f116282e.addMessage(arrayList, currentAccountUin, false, false);
                ArrayList arrayList2 = new ArrayList();
                Iterator<ChatMessage> it6 = list.iterator();
                while (it6.hasNext()) {
                    arrayList2.add(it6.next());
                }
                ad.o(arrayList2, createMsgRecordByMsgType, false);
                list.clear();
                Iterator it7 = arrayList2.iterator();
                while (it7.hasNext()) {
                    list.add((ChatMessage) ((MessageRecord) it7.next()));
                }
            }
        }
    }

    public void U0(List<MessageRecord> list) {
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            synchronized (list) {
                try {
                    list.wait(35000L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void V0() {
        BaseMessageManager.b bVar = BaseMessageManager.D;
        if (bVar != null) {
            bVar.refreshAppBadge(this.f116281d);
        }
    }

    public void W0(String str, int i3, long j3, long j16, Bundle bundle) {
        if (i3 == 10014) {
            F.d(this.f116281d, str, j3, j16, true, bundle, 0);
        }
    }

    public boolean X0(aj ajVar, long j3, boolean z16) {
        if (j3 <= 0) {
            ajVar.f116525c = true;
            return false;
        }
        return z16;
    }

    public boolean Z0(int i3, aj ajVar, List<MessageRecord> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
        }
        ajVar.f116524b = null;
        M(ajVar, i3);
        return true;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void a(MessageRecord messageRecord, EntityManager entityManager, boolean z16, boolean z17, boolean z18, boolean z19, BaseMessageManager.a aVar) {
        if (messageRecord == null || !S0(messageRecord)) {
            return;
        }
        String valueOf = String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageRecord));
        B0(aVar.f116303h, messageRecord, z16, z17, z19);
        com.tencent.mobileqq.troop.navigatebar.c b16 = F.b(aVar);
        com.tencent.mobileqq.troop.data.c cVar = null;
        if (b16 != null) {
            com.tencent.mobileqq.troop.data.c a16 = b16.a(messageRecord.frienduin);
            if (a16 != null) {
                if (a16.g() == messageRecord.shmsgseq) {
                    if (messageRecord.isread) {
                        b16.b(messageRecord.frienduin);
                    }
                }
            }
            cVar = a16;
        }
        if (cVar != null) {
            F.e(this.f116281d, messageRecord.frienduin, A0(cVar), messageRecord, true);
        }
        f1(messageRecord, A0(cVar));
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "addMessageRecord, messageInfo = " + cVar + " key = " + valueOf + "mr.frienduin" + messageRecord.frienduin);
        }
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).printAtMsgInfoLog("Q.msg.BaseMessageManager.GuildMessageManager", messageRecord);
    }

    public void a1(List<MessageRecord> list, long j3, List<MessageRecord> list2) {
        for (MessageRecord messageRecord : list) {
            if (messageRecord.shmsgseq < j3) {
                list2.add(messageRecord);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh breakpoint invalid: id = " + messageRecord.getId() + ", msg = " + messageRecord.getLogColorContent() + " , msgtime = " + messageRecord.time + " , shMsgSeq = " + messageRecord.shmsgseq + " , extra = " + messageRecord.extraflag);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh breakpoint valid: id = " + messageRecord.getId() + ", msg = " + messageRecord.getLogColorContent() + " , msgtime = " + messageRecord.time + " , shMsgSeq = " + messageRecord.shmsgseq + " , extra = " + messageRecord.extraflag);
            }
        }
        list.removeAll(list2);
        list2.clear();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh breakpoint step 1, size = " + list.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    public void d1(List<ChatMessage> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage : list) {
                if (chatMessage.msgtype == -4009) {
                    arrayList.add(chatMessage);
                    QLog.i("Q.msg.BaseMessageManager.GuildMessageManager", 1, "removeSeparateMessageIfNeeded, mr shmsgseq: " + chatMessage.shmsgseq + ", uniseq: " + chatMessage.uniseq + ", channelId: " + chatMessage.frienduin);
                    this.f116282e.removeMsgFromCacheByUniseq(chatMessage.frienduin, 10014, chatMessage.msgtype, chatMessage.uniseq);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public void f1(MessageRecord messageRecord, com.tencent.mobileqq.troop.data.c cVar) {
        this.E.g(messageRecord, cVar);
    }

    public void g1(MessageRecord messageRecord, com.tencent.mobileqq.troop.data.c cVar) {
        this.E.h(messageRecord, cVar);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void h(Message message) throws Throwable {
        List<com.tencent.imcore.message.decoder.j> msgSummaryDecoders;
        if (message == null || (msgSummaryDecoders = ((IGuildMsgSummaryDecodersApi) QRoute.api(IGuildMsgSummaryDecodersApi.class)).getMsgSummaryDecoders()) == null) {
            return;
        }
        Iterator<com.tencent.imcore.message.decoder.j> it = msgSummaryDecoders.iterator();
        while (it.hasNext()) {
            it.next().a(message, this, this.f116281d);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void m0(String str, int i3, String str2, String str3, long j3) {
        ((IGuildLastMsgService) this.f116281d.getRuntimeService(IGuildLastMsgService.class, "")).onDraftChangeNotify(str, str3, j3);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void n(String str, int i3, int i16, aj ajVar) {
        long Y0;
        long j3;
        long j16;
        long j17;
        long j18;
        int i17;
        long j19;
        int size;
        boolean z16;
        long j26;
        char c16;
        if (i16 > 0) {
            List<MessageRecord> l3 = y(i3).l(str, i3);
            if (Z0(i3, ajVar, l3)) {
                return;
            }
            if (ajVar.f116530h) {
                R0(l3);
                Y0 = F0(l3);
            } else {
                Y0 = Y0(l3);
            }
            char c17 = 2;
            if (Y0 == 0 && !l3.isEmpty()) {
                Y0 = l3.get(l3.size() - 1).shmsgseq + 1;
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "doRefreshMessageListHead() called set tail headMsgUniseq = [" + Y0 + "]");
            }
            long j27 = Y0;
            boolean b16 = b1(l3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "doRefreshMessageListHead() called with: uin = [" + str + "], type = [" + i3 + "], count = [" + i16 + "], context = [" + ajVar + "], aio head msg headMsgUniseq = [" + j27 + "]");
            }
            if (c1(i3, ajVar, b16)) {
                return;
            }
            MessageRecord H = y(i3).H(str, i3, j27);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "doRefreshMessageListHead() called with: aio head msg = [" + H + "]");
            }
            if (H == null) {
                j3 = 0;
            } else {
                j3 = H.shmsgseq;
            }
            if (j3 == 0) {
                j3 = j27;
            }
            List<MessageRecord> M0 = M0(str, i3, i16, ajVar.f116530h);
            if (M0 != null && !M0.isEmpty()) {
                long j28 = j3;
                int size2 = M0.size() - 1;
                int i18 = 0;
                while (true) {
                    if (size2 >= 0) {
                        MessageRecord messageRecord = M0.get(size2);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            j16 = j27;
                            sb5.append("doRefreshMessageListHead() called with: messageRecord = [");
                            sb5.append(messageRecord);
                            sb5.append("]");
                            c16 = 2;
                            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, sb5.toString());
                        } else {
                            j16 = j27;
                            c16 = c17;
                        }
                        if (((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(messageRecord)) {
                            i18++;
                        } else {
                            long j29 = messageRecord.shmsgseq;
                            if (j28 - j29 > 1) {
                                break;
                            }
                            i18++;
                            j28 = j29;
                        }
                        size2--;
                        c17 = c16;
                        j27 = j16;
                    } else {
                        j16 = j27;
                        break;
                    }
                }
                i17 = i18;
                j17 = j28;
                j19 = 1;
                j18 = j3;
            } else {
                j16 = j27;
                j17 = j3;
                j18 = j17;
                i17 = 0;
                j19 = 1;
            }
            long j36 = j17 - j19;
            int i19 = i16 - i17;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("doRefreshMessageListHead() called with: localContinuesSize = [");
            sb6.append(i17);
            sb6.append("], lastContinuedSeq = [");
            sb6.append(j17);
            sb6.append("], needSize = [");
            sb6.append(i19);
            sb6.append("], count = [");
            sb6.append(i16);
            sb6.append("], localSize = [");
            if (M0 == null) {
                size = 0;
            } else {
                size = M0.size();
            }
            sb6.append(size);
            sb6.append("]");
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 1, sb6.toString());
            if (i19 < 0) {
                i19 = 0;
            }
            long j37 = (j36 - i19) + 1;
            long M02 = ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).M0(str, i3);
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 1, "doRefreshMessageListHead() refresh breakpoint step 0, delSeq = " + M02 + ", endSeq = " + j36 + ",beginSeq = " + j37 + ",lastContinuedSeq = " + j17 + ",localSeqEnd = " + j18 + ", timestamp = " + System.currentTimeMillis());
            boolean X0 = X0(ajVar, j36, true);
            if (j36 <= M02) {
                ajVar.f116525c = true;
                j26 = 0;
                z16 = false;
            } else {
                if (j37 <= M02) {
                    j37 = M02 + 1;
                }
                z16 = X0;
                j26 = 0;
            }
            if (j37 < j26) {
                j37 = j26;
            }
            a1(M0, j37, new ArrayList());
            T0(ajVar, j37, j36, z16, M0, j16, 1);
            return;
        }
        throw new IllegalArgumentException("COUNT MUST > 0 !");
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public boolean o0(MessageRecord messageRecord, boolean z16, int i3) {
        return false;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public List<ChatMessage> t(String str, int i3, long j3, int i16, boolean z16) {
        List<MessageRecord> A;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (j3 >= 0) {
            A = y(i3).B(str, i3, j3, i16);
        } else if (((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isGuest(str)) {
            A = y(i3).A(str, i3, i16, false);
        } else {
            A = y(i3).A(str, i3, i16, true);
        }
        if (A == null) {
            return new ArrayList();
        }
        ArrayList<MessageRecord> arrayList3 = new ArrayList(A.size());
        arrayList3.addAll(A);
        BaseMessageManager.D.i(this, this.f116281d, i3, str, arrayList3, null, false, true);
        ((IGuildMsgProxyUtilsApi) QRoute.api(IGuildMsgProxyUtilsApi.class)).pretreatmentAIOMsg(i3, arrayList3, this.f116281d);
        ad.P(str, i3, arrayList3, (com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache());
        BaseMessageManager.D.z(this.f116282e, str, i3, arrayList3, this);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "newAIOCursor clone " + Integer.valueOf(arrayList3.size()));
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (MessageRecord messageRecord : arrayList3) {
            Iterator<com.tencent.imcore.message.aiolist.f> it = this.f116282e.getRegistry().d().iterator();
            MessageRecord messageRecord2 = messageRecord;
            while (true) {
                if (it.hasNext()) {
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    Object[] a16 = it.next().a(this.f116281d, str, i3, z16, arrayList4, arrayList5, arrayList6, messageRecord2);
                    messageRecord2 = (MessageRecord) a16[0];
                    if (((Boolean) a16[1]).booleanValue()) {
                        break;
                    }
                    arrayList6 = arrayList;
                    arrayList5 = arrayList2;
                } else {
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    break;
                }
            }
            arrayList6 = arrayList;
            arrayList5 = arrayList2;
        }
        ArrayList arrayList7 = arrayList6;
        ArrayList arrayList8 = arrayList5;
        if (!z16) {
            BaseMessageManager.D.F(this.f116281d, arrayList8, arrayList7);
        }
        return arrayList4;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void r0(MessageRecord messageRecord) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.BaseMessageManager
    public void b(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.BaseMessageManager
    public void c(String str, int i3, long j3) {
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void g0(String str, int i3, long j3, boolean z16) {
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void h0(String str, int i3, boolean z16, boolean z17) {
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void l0(String str, int i3, MessageRecord messageRecord, int i16) {
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void B(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle) {
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void i0(String str, int i3, boolean z16, boolean z17, int i16) {
    }
}
