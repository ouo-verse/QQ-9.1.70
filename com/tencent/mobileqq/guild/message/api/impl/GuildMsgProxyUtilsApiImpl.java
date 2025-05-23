package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.emoji.IGuildEmoPreviewApi;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi;
import com.tencent.mobileqq.guild.message.p;
import com.tencent.mobileqq.guild.temp.api.IMessageRecordFactoryApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.NTOperateUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes14.dex */
public class GuildMsgProxyUtilsApiImpl implements IGuildMsgProxyUtilsApi {
    private static String TAG = "GuildMsgProxyUtilsApiImpl";
    private final Comparator mGuildMsgComparator = new a();

    /* loaded from: classes14.dex */
    class a implements Comparator<MessageRecord> {
        a() {
        }

        private long b(MessageRecord messageRecord, MessageRecord messageRecord2) {
            return messageRecord.getId() - messageRecord2.getId();
        }

        private long c(MessageRecord messageRecord, MessageRecord messageRecord2) {
            if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(messageRecord)) {
                return -1L;
            }
            if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(messageRecord2)) {
                return 1L;
            }
            return 0L;
        }

        private long d(MessageRecord messageRecord, MessageRecord messageRecord2) {
            return messageRecord.shmsgseq - messageRecord2.shmsgseq;
        }

        private long e(MessageRecord messageRecord, MessageRecord messageRecord2) {
            return f(messageRecord, messageRecord2, messageRecord.time - messageRecord2.time);
        }

        private long f(MessageRecord messageRecord, MessageRecord messageRecord2, long j3) {
            if (j3 == 0) {
                boolean N = ad.N(messageRecord.msgtype);
                boolean N2 = ad.N(messageRecord2.msgtype);
                if (N) {
                    if (N2) {
                        return messageRecord.time - messageRecord2.time;
                    }
                    return 1L;
                }
                if (N2) {
                    return -1L;
                }
                return j3;
            }
            return j3;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageRecord messageRecord, MessageRecord messageRecord2) {
            long d16 = d(messageRecord, messageRecord2);
            if (d16 == 0) {
                d16 = c(messageRecord, messageRecord2);
            }
            if (d16 == 0) {
                d16 = e(messageRecord, messageRecord2);
            }
            if (d16 == 0) {
                d16 = b(messageRecord, messageRecord2);
            }
            return (int) d16;
        }
    }

    private MarketFaceElement fetchMarketFaceEle(MsgRecord msgRecord) {
        Iterator<MsgElement> it = msgRecord.getElements().iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.getElementType() == 11 && next.getMarketFaceElement() != null) {
                return next.getMarketFaceElement();
            }
        }
        return new MarketFaceElement();
    }

    private BaseQQAppInterface getAppRuntime() {
        return (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private void handlePicMsg(List<MessageRecord> list, MsgRecord msgRecord) {
        for (int i3 = 0; i3 < msgRecord.getElements().size(); i3++) {
            MsgElement msgElement = msgRecord.getElements().get(i3);
            if (msgElement.getPicElement() != null) {
                ChatMessage createPicMessage = ((IMessageRecordFactoryApi) QRoute.api(IMessageRecordFactoryApi.class)).createPicMessage(getAppRuntime(), msgRecord, msgElement);
                createPicMessage.uniseq = msgRecord.getMsgId();
                list.add(createPicMessage);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi
    public boolean compGuildMsgContent(AppRuntime appRuntime, MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17) {
        return p.a(appRuntime, messageRecord, messageRecord2, z16, z17);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi
    public int[] getLocalOnlyMsgTypes() {
        return p.f230724b;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi
    public void pretreatmentAIOMsg(int i3, List<MessageRecord> list, AppRuntime appRuntime) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList(8);
            HashSet<Long> hashSet = new HashSet<>(8);
            String str = null;
            for (MessageRecord messageRecord : list) {
                if (messageRecord == null) {
                    arrayList.add(messageRecord);
                } else {
                    if (TextUtils.isEmpty(str)) {
                        str = messageRecord.frienduin;
                    }
                    if (messageRecord.msgtype == -2006 || !messageRecord.isValid) {
                        arrayList.add(messageRecord);
                        if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(messageRecord)) {
                            hashSet.add(Long.valueOf(messageRecord.shmsgseq));
                        }
                    }
                }
            }
            list.removeAll(arrayList);
            if (i3 == 10014) {
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setPreRemoveRoamMsgSeqSet(str, hashSet);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi
    public void sortMsg(List<MessageRecord> list) {
        if (list == null) {
            return;
        }
        try {
            Collections.sort(list, this.mGuildMsgComparator);
        } catch (IllegalArgumentException e16) {
            QLog.e(TAG, 1, "sortMsg: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi
    public List<MessageRecord> transToCompatMsgType(List<MsgRecord> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (MsgRecord msgRecord : list) {
            NTOperateUtils nTOperateUtils = NTOperateUtils.f359554a;
            if (nTOperateUtils.f(msgRecord)) {
                MarketFaceElement fetchMarketFaceEle = fetchMarketFaceEle(msgRecord);
                QLog.i(TAG, 1, "faceDsc=" + fetchMarketFaceEle.getFaceName());
                MessageRecord messageRecord = (MessageRecord) ((IGuildEmoPreviewApi) QRoute.api(IGuildEmoPreviewApi.class)).createMarketFace(fetchMarketFaceEle, str2, str);
                messageRecord.uniseq = msgRecord.getMsgId();
                messageRecord.shmsgseq = msgRecord.getMsgSeq();
                arrayList.add(messageRecord);
            } else if (nTOperateUtils.e(msgRecord)) {
                handlePicMsg(arrayList, msgRecord);
            }
        }
        return arrayList;
    }
}
