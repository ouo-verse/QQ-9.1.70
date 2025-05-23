package com.tencent.imcore.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class ai {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public BaseMessageManagerForTroopAndDisc f116521a;

    public ai(BaseMessageManagerForTroopAndDisc baseMessageManagerForTroopAndDisc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseMessageManagerForTroopAndDisc);
        } else {
            this.f116521a = baseMessageManagerForTroopAndDisc;
        }
    }

    private void c(String str, int i3, int i16, aj ajVar, long j3, MessageRecord messageRecord, int i17, List<MessageRecord> list, long j16, boolean z16) {
        long j17 = 0;
        if ((list.isEmpty() && j16 > 0) || (!z16 && list.size() < i16)) {
            long d16 = d(str, i3, list, j16);
            f y16 = this.f116521a.y(i3);
            if (messageRecord != null) {
                j17 = messageRecord.getId();
            }
            List<MessageRecord> Y = y16.Y(str, i3, j17, i17, d16, i16 - list.size(), null);
            if (QLog.isColorLevel()) {
                QLog.d("RandomGetMessageLoader", 2, "refresh roam fail step 0 , size = " + Y.size() + ",seq = " + d16 + " , timestamp = " + System.currentTimeMillis());
            }
            if (Y.isEmpty()) {
                ajVar.f116525c = true;
                return;
            } else {
                list.addAll(Y);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "refresh roam addRoamMsgToList uniseq = " + j3 + " , locallist = " + list.size() + " , timestamp = " + System.currentTimeMillis());
        }
        this.f116521a.y(i3).f(str, i3, j3, j16, list);
    }

    private long d(String str, int i3, List<MessageRecord> list, long j3) {
        StringBuilder sb5;
        long j16;
        if (!list.isEmpty()) {
            long j17 = list.get(list.size() - 1).shmsgseq;
            HashMap hashMap = new HashMap();
            for (MessageRecord messageRecord : list) {
                if (messageRecord.shmsgseq == j17) {
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
            list.addAll(this.f116521a.y(i3).p0(str, i3, j17, hashMap));
            return j17 + 1;
        }
        return j3;
    }

    private void e(List<MessageRecord> list, ArrayList<MessageRecord> arrayList) {
        QLog.d("RandomGetMessageLoader", 1, "doRemoveIncompleteLongMsg");
        if (arrayList != null && !arrayList.isEmpty() && arrayList.get(0).longMsgCount > arrayList.size() && !arrayList.get(0).isSendFromLocal()) {
            QLog.d("RandomGetMessageLoader", 1, "doRemoveIncompleteLongMsg find incomplete msg");
            list.removeAll(arrayList);
        }
    }

    private HashMap<String, MessageRecord> f(String str, int i3, List<MessageRecord> list, long j3) {
        StringBuilder sb5;
        long j16;
        HashMap<String, MessageRecord> hashMap = new HashMap<>();
        if (list != null && !list.isEmpty()) {
            MessageRecord H = this.f116521a.y(i3).H(str, i3, j3);
            if (H != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("RandomGetMessageLoader", 2, "refresh find msg in cache id = " + H.getId() + ", msg = " + H.getLogColorContent() + ", uniseq = " + H.uniseq + " , msgtime = " + H.time + " , shMsgSeq = " + H.shmsgseq + " , extra = " + H.extraflag);
                }
                if (!list.isEmpty()) {
                    for (MessageRecord messageRecord : list) {
                        if (messageRecord.shmsgseq == H.shmsgseq) {
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
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("RandomGetMessageLoader", 2, "refresh can't find msg in cache !!");
            }
            return hashMap;
        }
        if (QLog.isColorLevel()) {
            QLog.w("RandomGetMessageLoader", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
        }
        return hashMap;
    }

    private MessageRecord g(List<MessageRecord> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    private int h(List<MessageRecord> list, int i3, int i16) {
        int i17 = i3;
        while (i3 < i16) {
            long j3 = list.get(i3).shmsgseq;
            i3++;
            if (j3 != list.get(i3).shmsgseq) {
                break;
            }
            i17++;
            if (QLog.isColorLevel()) {
                QLog.d("RandomGetMessageLoader", 2, "refresh same seq  itemListStartPoint= " + i17);
            }
        }
        return i17;
    }

    private int i(List<MessageRecord> list, int i3, int i16) {
        int i17 = i3;
        int i18 = i17;
        while (i17 >= i16 + 1 && list.get(i17).shmsgseq == list.get(i17 - 1).shmsgseq) {
            if (QLog.isColorLevel()) {
                QLog.d("RandomGetMessageLoader", 2, "refresh same seq  itemListStartPoint= " + i3);
            }
            i18--;
            i17--;
        }
        return i18;
    }

    private void k(String str, int i3, int i16, List<MessageRecord> list, int i17, int i18, List<MessageRecord> list2, long j3) {
        String str2;
        String str3;
        int i19;
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "getLocalListRefreshReadCache refresh read cache step 1, timestamp = " + System.currentTimeMillis());
        }
        int i26 = (i17 + i16) - 1;
        long j16 = list.get(i26).shmsgseq;
        int h16 = h(list, i26, i18);
        List<MessageRecord> l3 = this.f116521a.y(i3).l(str, i3);
        if (h16 == i18) {
            if (QLog.isColorLevel()) {
                QLog.d("RandomGetMessageLoader", 2, "refresh read cache step 2, timestamp = " + System.currentTimeMillis());
            }
            int i27 = i(list, i26, i17);
            if (i27 <= i17) {
                if (QLog.isColorLevel()) {
                    QLog.d("RandomGetMessageLoader", 2, "refresh read cache step 3, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
                }
                list2.addAll(this.f116521a.y(i3).p0(str, i3, j16, f(str, i3, l3, j16)));
                if (j16 == j3 - 1) {
                    list2.addAll(this.f116521a.y(i3).p0(str, i3, j3, f(str, i3, l3, j3)));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("RandomGetMessageLoader", 2, "refresh read cache step 4, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
                    return;
                }
                return;
            }
            list2.addAll(list.subList(i17, i27));
            int size = i16 - list2.size();
            if (QLog.isColorLevel()) {
                QLog.d("RandomGetMessageLoader", 2, "refresh read cache step 5, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
            }
            long j17 = (size + j16) - 1;
            if (j17 >= j3) {
                j17 = j3 - 1;
            }
            if (j17 < 0) {
                j17 = 0;
            }
            if (j16 > j17) {
                return;
            }
            list2.addAll(this.f116521a.y(i3).W(str, i3, j16, j17));
            if (j17 == j3 - 1) {
                str2 = "RandomGetMessageLoader";
                str3 = ", timestamp = ";
                i19 = 2;
                list2.addAll(this.f116521a.y(i3).p0(str, i3, j3, f(str, i3, l3, j3)));
            } else {
                str2 = "RandomGetMessageLoader";
                str3 = ", timestamp = ";
                i19 = 2;
            }
            if (QLog.isColorLevel()) {
                QLog.d(str2, i19, "refresh read cache step 6, size = " + list2.size() + str3 + System.currentTimeMillis());
                return;
            }
            return;
        }
        list2.addAll(list.subList(i17, h16 + 1));
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "refresh read cache step 7, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    private void l(String str, int i3, int i16, List<MessageRecord> list, int i17, int i18, List<MessageRecord> list2, long j3) {
        long j16;
        String str2;
        long j17 = list.get(i18).shmsgseq;
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "getLocalListRefreshReadCacheAndDB refresh read cache and DB step 0, sameSeq = " + j17 + ", timestamp = " + System.currentTimeMillis());
        }
        list2.addAll(list.subList(i17, i18 + 1));
        List<MessageRecord> l3 = this.f116521a.y(i3).l(str, i3);
        list2.addAll(this.f116521a.y(i3).p0(str, i3, j17, f(str, i3, l3, j17)));
        int size = i16 - list2.size();
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "refresh read cache and DB step 1, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
        long j18 = j17 + 1;
        long j19 = (size + j18) - 1;
        if (j18 >= 0) {
            j16 = j18;
        } else {
            j16 = 0;
        }
        if (j19 >= j3) {
            j19 = j3 - 1;
        }
        if (j19 < 0) {
            j19 = 0;
        }
        if (j16 > j19) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "getLocalListRefreshReadCacheAndDB() called with: beginSeq = [" + j16 + "],endSeq=[" + j19 + "]");
        }
        list2.addAll(this.f116521a.y(i3).W(str, i3, j16, j19));
        if (j19 == j3 - 1) {
            str2 = "RandomGetMessageLoader";
            list2.addAll(this.f116521a.y(i3).p0(str, i3, j3, f(str, i3, l3, j3)));
        } else {
            str2 = "RandomGetMessageLoader";
        }
        if (QLog.isColorLevel()) {
            QLog.d(str2, 2, "refresh read cache and DB step 2, size = " + list2.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(String str, int i3, long j3, long j16, int i16, boolean z16) {
        List<MessageRecord> l3 = this.f116521a.y(i3).l(str, i3);
        if (l3 != null && !l3.isEmpty()) {
            int size = l3.size();
            int i17 = -1;
            int i18 = 0;
            for (int i19 = 0; i19 < size; i19++) {
                MessageRecord messageRecord = l3.get(i19);
                if (QLog.isColorLevel()) {
                    QLog.d("RandomGetMessageLoader", 2, "isLoadSuccess curIndex: ", Integer.valueOf(i19), ", curMsg shmsgseq: ", Long.valueOf(messageRecord.shmsgseq), ", msg detail: " + messageRecord);
                }
                if (ad.B(messageRecord)) {
                    QLog.d("RandomGetMessageLoader", 1, "isLoadSuccess filter local troop msg: ", messageRecord);
                } else {
                    long j17 = messageRecord.shmsgseq;
                    if (j17 == j16) {
                        QLog.d("RandomGetMessageLoader", 1, "isLoadSuccess loadCount: ", Integer.valueOf(i18), ", lastIndex: ", Integer.valueOf(i17));
                        if (z16) {
                            if (i18 >= i16) {
                                return true;
                            }
                        } else if (i18 > 0) {
                            return true;
                        }
                        if (i17 < 0 || l3.get(i17).shmsgseq < j16 - 1) {
                            return false;
                        }
                        return true;
                    }
                    if (j17 >= j3) {
                        i18++;
                        i17 = i19;
                    }
                }
            }
        }
        return false;
    }

    private void p(List<MessageRecord> list, long j3, List<MessageRecord> list2) {
        for (MessageRecord messageRecord : list) {
            if (messageRecord.shmsgseq > j3) {
                list2.add(messageRecord);
                if (QLog.isColorLevel()) {
                    QLog.d("RandomGetMessageLoader", 2, "refresh breakpoint invalid: id = " + messageRecord.getId() + ", msg = " + messageRecord.getLogColorContent() + " , msgtime = " + messageRecord.time + " , shMsgSeq = " + messageRecord.shmsgseq + " , extra = " + messageRecord.extraflag);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("RandomGetMessageLoader", 2, "refresh breakpoint valid: id = " + messageRecord.getId() + ", msg = " + messageRecord.getLogColorContent() + " , msgtime = " + messageRecord.time + " , shMsgSeq = " + messageRecord.shmsgseq + " , extra = " + messageRecord.extraflag);
            }
        }
        list.removeAll(list2);
        list2.clear();
        if (QLog.isColorLevel()) {
            QLog.d("RandomGetMessageLoader", 2, "refresh breakpoint step 1, size = " + list.size() + ", timestamp = " + System.currentTimeMillis());
        }
    }

    private void q(List<MessageRecord> list) {
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            int size = list.size();
            String str = "";
            String str2 = "";
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                MessageRecord messageRecord = list.get(i16);
                if (messageRecord.isLongMsg()) {
                    String g16 = ao.g(messageRecord);
                    if (hashMap.containsKey(g16)) {
                        if (Math.abs(((MessageRecord) ((ArrayList) hashMap.get(g16)).get(0)).time - messageRecord.time) <= 480) {
                            ((ArrayList) hashMap.get(g16)).add(messageRecord);
                        } else {
                            i3++;
                            String l3 = ao.l(g16, i3);
                            hashMap.put(l3, (ArrayList) hashMap.get(g16));
                            if (TextUtils.equals(str, g16)) {
                                str = l3;
                            } else if (TextUtils.equals(str2, g16)) {
                                str2 = l3;
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(messageRecord);
                            hashMap.put(g16, arrayList);
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(messageRecord);
                        hashMap.put(g16, arrayList2);
                    }
                    if (i16 == 0) {
                        str = g16;
                    } else if (i16 == size - 1) {
                        str2 = g16;
                    }
                }
            }
            e(list, (ArrayList) hashMap.get(str));
            e(list, (ArrayList) hashMap.get(str2));
        }
    }

    public void b(String str, int i3, long j3, int i16, long j16, aj ajVar, boolean z16) {
        int i17;
        MessageRecord messageRecord;
        String str2;
        long j17;
        int i18;
        long j18;
        boolean z17;
        long j19;
        String str3;
        long j26;
        MessageRecord messageRecord2;
        List<MessageRecord> list;
        boolean z18;
        int i19;
        int size;
        int i26;
        long j27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), ajVar, Boolean.valueOf(z16));
            return;
        }
        QLog.d("RandomGetMessageLoader", 1, "doRefreshMessageListHead uin: ", str, ", type:", Integer.valueOf(i3), ", firstSeq:", Long.valueOf(j3), ", count:", Integer.valueOf(i16), ", blockCStartSeq:", Long.valueOf(j16));
        if (i16 > 0) {
            if (this.f116521a.c1(i3, ajVar, this.f116521a.y(i3).l(str, i3))) {
                return;
            }
            List<MessageRecord> j28 = j(str, i3, i16, j3, j16);
            MessageRecord g16 = g(j28);
            QLog.d("RandomGetMessageLoader", 1, "doRefreshMessageListHead() called with: aio head msg = [" + g16 + "]");
            String str4 = "RandomGetMessageLoader";
            long j29 = j3 - 1;
            if (g16 == null) {
                i17 = 3;
            } else {
                i17 = g16.versionCode;
            }
            if (j28 != null && !j28.isEmpty()) {
                int size2 = j28.size();
                long j36 = j29;
                int i27 = 0;
                int i28 = 0;
                while (true) {
                    if (i27 < size2) {
                        MessageRecord messageRecord3 = j28.get(i27);
                        if (QLog.isColorLevel()) {
                            String str5 = str4;
                            messageRecord = g16;
                            str2 = str5;
                            QLog.d(str2, 2, "doRefreshMessageListHead() called with: messageRecord = [" + messageRecord3 + "]");
                        } else {
                            String str6 = str4;
                            messageRecord = g16;
                            str2 = str6;
                        }
                        if (this.f116521a.W0(messageRecord3)) {
                            i26 = size2;
                        } else {
                            long j37 = messageRecord3.shmsgseq;
                            if (j37 - j36 > 1) {
                                break;
                            }
                            i28++;
                            i26 = size2;
                            if (QLog.isColorLevel()) {
                                j27 = j37;
                                QLog.d(str2, 2, "doRefreshMessageListHead() find continue seq:", Long.valueOf(j37), ", localSize: ", Integer.valueOf(i28));
                            } else {
                                j27 = j37;
                            }
                            j36 = j27;
                        }
                        i27++;
                        size2 = i26;
                        MessageRecord messageRecord4 = messageRecord;
                        str4 = str2;
                        g16 = messageRecord4;
                    } else {
                        String str7 = str4;
                        messageRecord = g16;
                        str2 = str7;
                        break;
                    }
                }
                i18 = i28;
                j17 = j36;
            } else {
                messageRecord = g16;
                str2 = str4;
                j17 = j29;
                i18 = 0;
            }
            int max = Math.max(i16 - i18, 0);
            long j38 = j17 + 1;
            long j39 = (max + j38) - 1;
            QLog.d(str2, 1, "doRefreshMessageListHead() called with: localSize = [" + i18 + "], lastContinuedSeq = [" + j17 + "], needSize = [" + max + "], count = [" + i16 + "]");
            long M0 = ((com.tencent.mobileqq.service.message.e) this.f116521a.f116281d.getMsgCache()).M0(str, i3);
            QLog.d(str2, 1, "refresh breakpoint step 0, delSeq = " + M0 + ", endSeq = " + j39 + ",beginSeq = " + j38 + ",lastContinuedSeq = " + j17 + ",localSeqEnd = " + j29 + ", timestamp = " + System.currentTimeMillis());
            boolean Y0 = this.f116521a.Y0(ajVar, j39, true);
            if (j39 <= M0) {
                ajVar.f116525c = true;
                j18 = 1;
                Y0 = false;
            } else if (j38 <= M0) {
                j18 = 1;
                j38 = M0 + 1;
            } else {
                j18 = 1;
            }
            if (j38 < 0) {
                j38 = 0;
            }
            long j46 = j16 - j18;
            if (j38 > j46) {
                j19 = j38;
                z17 = false;
            } else {
                long min = Math.min(j38, j46);
                j39 = Math.min(j39, j46);
                z17 = Y0;
                j19 = min;
            }
            QLog.d(str2, 1, "doRefreshMessageListHead roam request beginSeq:", Long.valueOf(j19), ", endSeq:", Long.valueOf(j39), ", needPullMsg:", Boolean.valueOf(z17));
            p(j28, j39, new ArrayList());
            if (j39 >= j19 && j39 > 0 && z17) {
                ajVar.f116545w = true;
                Bundle bundle = new Bundle();
                int addAndGet = this.f116521a.f116282e.getPullCounter().addAndGet(1);
                bundle.putInt("counter", addAndGet);
                bundle.putBoolean("success", false);
                bundle.putInt("load_count", i16);
                bundle.putBoolean("troop_unread_jump_opt", true);
                bundle.putLong("pullUpStartTime", System.currentTimeMillis());
                this.f116521a.f116282e.getPullCache().put(Integer.valueOf(addAndGet), j28);
                QLog.d(str2, 1, "refresh roam step 0 , timestamp = " + System.currentTimeMillis());
                str3 = str2;
                messageRecord2 = messageRecord;
                long j47 = j39;
                j26 = j39;
                list = j28;
                this.f116521a.a1(str, i3, j19, j47, bundle);
                this.f116521a.f116282e.getAutoPullCache().put(ao.f(str, i3), Boolean.FALSE);
                this.f116521a.X0(list);
                boolean z19 = bundle.getBoolean("success");
                QLog.d(str3, 1, "refresh roam step 4 , size = " + list.size() + " , timestamp = " + System.currentTimeMillis());
                if (this.f116521a.f116282e.getAutoPullCache().containsKey(ao.f(str, i3)) && this.f116521a.f116282e.getAutoPullCache().get(ao.f(str, i3)).booleanValue()) {
                    this.f116521a.f116282e.qLogColor("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                    ajVar.f116524b = null;
                    o(ajVar, i3);
                    return;
                }
                z18 = z19;
            } else {
                str3 = str2;
                j26 = j39;
                messageRecord2 = messageRecord;
                list = j28;
                z18 = true;
            }
            q(list);
            String str8 = str3;
            List<MessageRecord> list2 = list;
            c(str, i3, i16, ajVar, j3, messageRecord2, i17, list, j26, z18);
            QLog.d("RandomGetMessageLoader.trooptroop_pull_msg", 1, "context.isLocalOnly = ", Boolean.valueOf(ajVar.f116527e), ", isNeedNotify = ", Boolean.valueOf(z16));
            this.f116521a.I(list2);
            if (z16) {
                QLog.d(str8, 1, "doRefreshMessageListHead add message to aio list, size: ", Integer.valueOf(list2.size()));
                i19 = i3;
                this.f116521a.y(i19).b(str, i19, list2);
            } else {
                i19 = i3;
            }
            ajVar.f116524b = list2;
            IMessageFacade iMessageFacade = this.f116521a.f116282e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refresh finish , context = ");
            sb5.append(ajVar);
            sb5.append(" , size = ");
            if (list2 == null) {
                size = -1;
            } else {
                size = list2.size();
            }
            sb5.append(size);
            iMessageFacade.qLogColor(sb5.toString(), ", timestamp = " + System.currentTimeMillis());
            o(ajVar, i19);
            return;
        }
        throw new IllegalArgumentException("COUNT MUST > 0 !");
    }

    public List<MessageRecord> j(String str, int i3, int i16, long j3, long j16) {
        ArrayList arrayList;
        int i17;
        int i18;
        int i19;
        int i26;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16));
        }
        if (i16 > 0) {
            List<MessageRecord> l3 = this.f116521a.y(i3).l(str, i3);
            if (l3 != null && !l3.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                long j18 = (j3 + i16) - 1;
                if (j18 >= j16) {
                    j18 = j16 - 1;
                }
                long j19 = 0;
                long j26 = j3 >= 0 ? j3 : 0L;
                long j27 = j18 >= 0 ? j18 : 0L;
                QLog.d("RandomGetMessageLoader", 1, "getLocalList startSeq:", Long.valueOf(j26), ", endSeq: ", Long.valueOf(j27));
                if (j26 <= j27) {
                    synchronized (this) {
                        List<MessageRecord> p16 = this.f116521a.y(i3).p(str, i3);
                        int i27 = -1;
                        if (p16 == null || p16.isEmpty()) {
                            i18 = -1;
                            i19 = -1;
                        } else {
                            int size = p16.size();
                            int i28 = -1;
                            i19 = -1;
                            int i29 = 0;
                            while (i29 < size) {
                                MessageRecord messageRecord = p16.get(i29);
                                if (i28 == i27) {
                                    i26 = size;
                                    j17 = messageRecord.uniseq;
                                    if (j17 == j26) {
                                        i28 = i29;
                                        i19 = i28;
                                    } else {
                                        i29++;
                                        size = i26;
                                        i27 = -1;
                                    }
                                } else {
                                    i26 = size;
                                    j17 = messageRecord.uniseq;
                                    if (j17 > j27 || j17 - j19 > 1) {
                                        break;
                                    }
                                    i19 = i29;
                                }
                                j19 = j17;
                                i29++;
                                size = i26;
                                i27 = -1;
                            }
                            i18 = i28;
                        }
                        QLog.d("RandomGetMessageLoader", 1, "getLocalList startCacheIndex:", Integer.valueOf(i18), ", endCacheIndex: ", Integer.valueOf(i19), ", lastContinueSeq: ", Long.valueOf(j19));
                        if (i18 == -1) {
                            arrayList2.addAll(this.f116521a.y(i3).W(str, i3, j26, j27));
                            if (j27 == j16 - 1) {
                                arrayList2.addAll(this.f116521a.y(i3).p0(str, i3, j16, f(str, i3, l3, j16)));
                            }
                            i17 = 1;
                            arrayList = arrayList2;
                        } else {
                            arrayList = arrayList2;
                            if ((i19 - i18) + 1 >= i16) {
                                i17 = 1;
                                k(str, i3, i16, p16, i18, i19, arrayList, j16);
                            } else {
                                i17 = 1;
                                l(str, i3, i16, p16, i18, i19, arrayList, j16);
                            }
                        }
                    }
                } else {
                    arrayList = arrayList2;
                    i17 = 1;
                }
                Object[] objArr = new Object[2];
                objArr[0] = "getLocalList localList size:";
                objArr[i17] = Integer.valueOf(arrayList.size());
                QLog.d("RandomGetMessageLoader", i17, objArr);
                if (QLog.isColorLevel()) {
                    for (MessageRecord messageRecord2 : arrayList) {
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = "getLocalList item shmsgseq :";
                        objArr2[i17] = Long.valueOf(messageRecord2.shmsgseq);
                        objArr2[2] = ", item detail: ";
                        objArr2[3] = messageRecord2;
                        QLog.d("RandomGetMessageLoader", 2, objArr2);
                    }
                }
                return arrayList;
            }
            if (QLog.isColorLevel()) {
                QLog.w("RandomGetMessageLoader", 2, "getLocalList refreshTroopMessageListHead ERROR: AIO is closed !!");
            }
            return new ArrayList();
        }
        throw new IllegalArgumentException("COUNT MUST > 0 !");
    }

    public boolean m(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle) {
        long j3;
        List<MessageRecord> list3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), list, list2, bundle)).booleanValue();
        }
        boolean z16 = bundle.getBoolean("troop_unread_jump_opt", false);
        QLog.d("RandomGetMessageLoader", 1, "handleRefreshMessageListHeadResult troopUnreadJumpOpt:", Boolean.valueOf(z16));
        if (!z16) {
            return false;
        }
        boolean z17 = bundle.getBoolean("success");
        long j16 = bundle.getLong("beginSeq", -1L);
        long j17 = bundle.getLong("endSeq", -1L);
        int i16 = bundle.getInt("load_count", 15);
        r(bundle, list == null ? -1 : list.size(), z17);
        boolean z18 = bundle.getBoolean("key_from_parallel_pull", false);
        List<MessageRecord> list4 = this.f116521a.f116282e.getPullCache().get(Integer.valueOf(bundle.getInt("counter")));
        IMessageFacade iMessageFacade = this.f116521a.f116282e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("refresh roam step 1 , result = ");
        sb5.append(list == null ? -1 : list.size());
        sb5.append(" , success = ");
        sb5.append(z17);
        sb5.append(" , beginSeq = ");
        sb5.append(j16);
        sb5.append(" , endSeq = ");
        sb5.append(j17);
        iMessageFacade.qLogColor(sb5.toString(), " , time = [" + System.currentTimeMillis() + "]");
        this.f116521a.f116282e.getPullCache().remove(Integer.valueOf(bundle.getInt("counter")));
        if (list4 != null) {
            int size = list4.size();
            List<MessageRecord> arrayList = list2 == null ? new ArrayList<>() : list2;
            if (list == null || list.isEmpty()) {
                list3 = list4;
                j3 = j16;
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list4);
                long j18 = j17 + 1;
                long j19 = j17 + i16;
                list3 = list4;
                j3 = j16;
                arrayList2.addAll(this.f116521a.y(i3).W(str, i3, j18, j19));
                this.f116521a.R0(list, arrayList, arrayList2);
                QLog.d("RandomGetMessageLoader", 1, "handleRefreshMessageListHeadResult roam result size:", Integer.valueOf(list.size()), ", insertList size: ", Integer.valueOf(arrayList.size()));
            }
            bundle.putBoolean("success", z17);
            if (!arrayList.isEmpty()) {
                this.f116521a.y(arrayList.get(0).istroop).d(arrayList, null);
            }
            Iterator<MessageRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f116521a.S0(list3, it.next());
            }
            QLog.d("RandomGetMessageLoader", 1, "handleRefreshMessageListHeadResult localList size before: ", Integer.valueOf(size), ", after insert: ", Integer.valueOf(list3.size()));
            synchronized (list3) {
                list3.notify();
            }
        } else {
            j3 = j16;
        }
        if (!z18) {
            return true;
        }
        this.f116521a.f116282e.clearInAioParallerPullMsgMark(str, j3, j17);
        return true;
    }

    void o(aj ajVar, int i3) {
        List<MessageRecord> list = ajVar.f116524b;
        if (list != null && list.size() > 0) {
            QLog.d("RandomGetMessageLoader", 1, "refreshHeadComplete refresh list size:", Integer.valueOf(ajVar.f116524b.size()));
            synchronized (ajVar.f116524b) {
                BaseMessageManager.D.pretreatmentAIOMsg(i3, ajVar.f116524b, this.f116521a.f116281d);
                if (ajVar.f116524b.size() > 0) {
                    ad.P(ajVar.f116541s, ajVar.f116542t, ajVar.f116524b, (com.tencent.mobileqq.service.message.e) this.f116521a.f116281d.getMsgCache());
                }
            }
        }
        ajVar.f116535m = 0;
        ajVar.f116536n = 0;
        if (ajVar.f116531i) {
            this.f116521a.f116282e.setChangeAndNotify(ajVar);
        }
    }

    void r(Bundle bundle, int i3, boolean z16) {
        long j3 = bundle.getLong("endTime", 0L) - bundle.getLong("pullUpStartTime", 0L);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reqDuration", String.valueOf(j3));
        hashMap.put("count", String.valueOf(i3));
        hashMap.put("success", String.valueOf(z16));
        QLog.d("RandomGetMessageLoader", 1, "duration = " + j3 + " count = " + i3 + " success = " + z16);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actRefreshTroopHeadPullUp", true, 0L, 0L, hashMap, "");
    }
}
