package com.tencent.mobileqq.guild.message;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi;
import com.tencent.mobileqq.guild.message.api.IGuildFillMsgHoleService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.group_pro_proto.common.common$Msg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class s extends com.tencent.mobileqq.guild.message.base.q {

    /* renamed from: d, reason: collision with root package name */
    public static int f230789d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static int f230790e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static com.tencent.mobileqq.guild.message.base.h f230791f;

    /* renamed from: c, reason: collision with root package name */
    final String f230792c;

    public s(AppInterface appInterface) {
        super(appInterface);
        this.f230792c = "BaseGuildMessageProcessor.GuildOnlineMessageProcessor";
    }

    private boolean G(List<common$Msg> list, int i3, Bundle bundle) {
        if (i3 == f230789d) {
            return ((IGuildFillMsgHoleService) this.f230314a.getRuntimeService(IGuildFillMsgHoleService.class, "")).checkNeedFillMsgHole(list, 1, bundle);
        }
        return false;
    }

    private HashMap<Long, List<common$Msg>> H(List<common$Msg> list) {
        HashMap<Long, List<common$Msg>> hashMap = new HashMap<>();
        if (list == null) {
            return hashMap;
        }
        for (common$Msg common_msg : list) {
            long j3 = common_msg.head.routing_head.channel_id.get();
            if (hashMap.get(Long.valueOf(j3)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(common_msg);
                hashMap.put(Long.valueOf(j3), arrayList);
            } else {
                hashMap.get(Long.valueOf(j3)).add(common_msg);
            }
        }
        return hashMap;
    }

    private void I(List<common$Msg> list, int i3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (common$Msg common_msg : list) {
            if (u(common_msg)) {
                ((IGuildMsgFactory) this.f230314a.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(7).a(common_msg, Integer.valueOf(i3));
            } else if (p(common_msg)) {
                arrayList2.add(common_msg);
            } else {
                arrayList3.add(common_msg);
            }
        }
        if (arrayList2.size() > 0) {
            ((IGuildMsgFactory) this.f230314a.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(8).a(arrayList2, Integer.valueOf(i3));
        }
        if (arrayList3.size() > 0) {
            Collections.sort(arrayList3, new Comparator() { // from class: com.tencent.mobileqq.guild.message.r
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int L;
                    L = s.this.L((common$Msg) obj, (common$Msg) obj2);
                    return L;
                }
            });
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                N(Arrays.asList((common$Msg) it.next()), i3, arrayList);
            }
        }
        if (arrayList.size() > 0) {
            y(arrayList);
        }
    }

    public static boolean J() {
        com.tencent.mobileqq.guild.message.base.h hVar = f230791f;
        if (hVar != null) {
            return hVar.c();
        }
        return true;
    }

    public static boolean K(AppInterface appInterface) {
        com.tencent.mobileqq.guild.message.base.h hVar = f230791f;
        if (hVar != null) {
            return hVar.d(appInterface);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int L(common$Msg common_msg, common$Msg common_msg2) {
        int i3 = (int) (common_msg.head.content_head.msg_seq.get() - common_msg2.head.content_head.msg_seq.get());
        if (i3 == 0) {
            return (v(common_msg) ? 1 : 0) - (v(common_msg2) ? 1 : 0);
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x006e, code lost:
    
        if ((r6.get(0) instanceof tencent.im.group_pro_proto.common.common$Msg) != false) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void M(List list, int i3, Bundle bundle) {
        int size;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("decodeMsgList, size : ");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, sb5.toString());
        }
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            if (list.get(0) instanceof byte[]) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    byte[] bArr = (byte[]) it.next();
                    try {
                        common$Msg common_msg = new common$Msg();
                        common_msg.mergeFrom(bArr);
                        arrayList.add(common_msg);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, "processPush: exception occurs while parsing the pb bytes.", e16);
                        }
                    }
                }
            }
            list = arrayList;
            if (!G(list, i3, bundle)) {
                Iterator<List<common$Msg>> it5 = H(list).values().iterator();
                while (it5.hasNext()) {
                    I(it5.next(), i3);
                }
            }
        }
    }

    private void N(List<common$Msg> list, int i3, List<MessageRecord> list2) {
        ArrayList arrayList;
        common$Msg common_msg;
        if (list == null) {
            return;
        }
        String currentAccountUin = this.f230314a.getCurrentAccountUin();
        List<common$Msg> arrayList2 = new ArrayList<>();
        List<common$Msg> arrayList3 = new ArrayList<>();
        boolean z16 = true;
        i(list, arrayList2, arrayList3, true);
        B(arrayList3, true);
        ArrayList arrayList4 = new ArrayList();
        Iterator<common$Msg> it = arrayList3.iterator();
        while (it.hasNext()) {
            common$Msg next = it.next();
            com.tencent.mobileqq.troop.data.c cVar = new com.tencent.mobileqq.troop.data.c();
            ArrayList<MessageRecord> e16 = e(next, currentAccountUin, cVar, -1L);
            if (QLog.isColorLevel()) {
                QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, "processPush, after decodeMsg, msgTempListSize: " + e16.size());
            }
            D(e16);
            if (QLog.isColorLevel()) {
                QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, "processPush : after visibleBlankMsgFilter, msgListSize: " + e16.size());
            }
            if (e16.size() == 0) {
                QLog.e("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", z16 ? 1 : 0, "processPushAfterDecodeMsg : after visibleBlankMsgFilter, msgTempList = 0");
            } else {
                ArrayList<MessageRecord> arrayList5 = new ArrayList<>();
                ArrayList<MessageRecord> arrayList6 = new ArrayList<>();
                h(e16, arrayList5, arrayList6, z16);
                if (QLog.isColorLevel()) {
                    QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, "processPush : after filterDuplicatedMsg, msgListSize: " + arrayList5.size() + ", msgFilteredRecords size: " + arrayList6.size());
                }
                F(arrayList6);
                if (arrayList5.size() != 0) {
                    ArrayList<MessageRecord> arrayList7 = new ArrayList<>();
                    MessageRecord messageRecord = null;
                    int i16 = 0;
                    while (i16 < arrayList5.size()) {
                        MessageRecord messageRecord2 = arrayList5.get(i16);
                        c(arrayList7, messageRecord2);
                        ArrayList arrayList8 = arrayList4;
                        if (messageRecord != null) {
                            common_msg = next;
                            if (messageRecord2.shmsgseq <= messageRecord.shmsgseq) {
                                i16++;
                                arrayList4 = arrayList8;
                                next = common_msg;
                            }
                        } else {
                            common_msg = next;
                        }
                        messageRecord = messageRecord2;
                        i16++;
                        arrayList4 = arrayList8;
                        next = common_msg;
                    }
                    ArrayList arrayList9 = arrayList4;
                    common$Msg common_msg2 = next;
                    if (QLog.isColorLevel()) {
                        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, "processPush : after checkAndHandleSelfSendMessage, msgListSize: " + arrayList7.size());
                    }
                    Iterator<MessageRecord> it5 = arrayList7.iterator();
                    while (it5.hasNext()) {
                        d(it5.next());
                    }
                    com.tencent.mobileqq.guild.message.base.h hVar = f230791f;
                    if (hVar != null) {
                        hVar.b(this.f230314a, arrayList5, cVar);
                    }
                    ((IMessageFacade) this.f230314a.getRuntimeService(IMessageFacade.class, "")).addMessage(arrayList7, String.valueOf(currentAccountUin), BaseMessageHandlerUtils.hasRecvAndUnreadMsg(arrayList7) && this.f230314a.isBackgroundStop, false, true);
                    ((IGuildMsgSeqTimeService) this.f230314a.getRuntimeService(IGuildMsgSeqTimeService.class, "")).updateLastSeqAndTime(arrayList7);
                    P(messageRecord);
                    com.tencent.mobileqq.guild.message.base.h hVar2 = f230791f;
                    if (hVar2 != null) {
                        hVar2.a(this.f230314a, arrayList7);
                    }
                    b(arrayList7);
                    list2.addAll(arrayList7);
                    if (v(common_msg2)) {
                        arrayList = arrayList9;
                        arrayList.addAll(arrayList7);
                    } else {
                        arrayList = arrayList9;
                    }
                    arrayList4 = arrayList;
                    z16 = true;
                }
            }
        }
        o(arrayList2, arrayList4, 2);
    }

    public static void O(com.tencent.mobileqq.guild.message.base.r rVar) {
        if (rVar instanceof com.tencent.mobileqq.guild.message.base.h) {
            f230791f = (com.tencent.mobileqq.guild.message.base.h) rVar;
        }
    }

    protected void F(ArrayList<MessageRecord> arrayList) {
        MessageRecord A;
        String selfTinyId = ((IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            String str = next.senderuin;
            if (str != null && str.equalsIgnoreCase(selfTinyId) && !iGuildMessageUtilsApi.isSysMsg(next) && (A = A(next)) != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, "checkAndHandleDuplicatedSelfSendMsg, messageRecord = " + next.getBaseInfoString() + ", findMr = " + A.getBaseInfoString());
                }
                ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).handleSelfSendMsg(this.f230314a, next, A, 1);
                ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).handleNeedAddSubscribeGrayTip(this.f230314a, next.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_ID_EXT_STR), next.frienduin);
            }
        }
    }

    protected void P(MessageRecord messageRecord) {
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        if (!iGuildMessageUtilsApi.isSysMsg(messageRecord) && !iGuildMessageUtilsApi.isLocalOnlyMsg(messageRecord)) {
            IGuildAioMsgFilterApi.a aVar = new IGuildAioMsgFilterApi.a();
            try {
                aVar.f230115b = messageRecord.shmsgseq;
                aVar.f230116c = iGuildMessageUtilsApi.getCntSeqFromMR(messageRecord);
                aVar.f230114a = messageRecord.uniseq;
                ((IGuildAioMsgFilterApi) QRoute.api(IGuildAioMsgFilterApi.class)).updateLatestOnlineMsgMsgSeqItem(messageRecord.frienduin, aVar, false);
            } catch (NumberFormatException e16) {
                QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 1, "processPushAfterDecodeMsg, e = " + e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.s
    public void a(Object... objArr) {
        if (objArr != null && objArr.length == 3) {
            M((List) objArr[0], ((Integer) objArr[1]).intValue(), (Bundle) objArr[2]);
        } else {
            n(getClass().getName());
        }
    }
}
