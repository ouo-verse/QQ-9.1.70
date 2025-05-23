package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.r;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes18.dex */
public interface IOrderMediaMsgService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onSendBegin(MessageRecord messageRecord);

        void onSendEnd(boolean z16, long j3);
    }

    boolean addCallback(String str, long j3, View view, r rVar);

    void addOrderMsg(MessageRecord messageRecord, String str);

    void addOrderMsgStatus(String str, MessageRecord messageRecord, String str2);

    void enqueueMediaMsgByMsgList(String str, ArrayList<ChatMessage> arrayList);

    void enqueueMediaMsgByPath(String str, String str2);

    void enqueueMediaMsgByUniseq(String str, long j3);

    com.tencent.mobileqq.richmedia.ordersend.a getMsgController();

    boolean isMediaMsgInQueue(String str, long j3);

    boolean isMediaMsgInQueueNotHead(String str, long j3);

    boolean isSessionOrderSending(String str);

    void removeMediaMsgByUniseq(String str, long j3);

    void sendOrderMsg(MessageRecord messageRecord, bo boVar);

    void sendOrderMsg(MessageRecord messageRecord, bo boVar, a aVar);

    void updateMediaMsgByUniseq(String str, long j3, long j16);
}
