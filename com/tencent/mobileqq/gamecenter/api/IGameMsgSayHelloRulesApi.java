package com.tencent.mobileqq.gamecenter.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGameMsgSayHelloRulesApi extends QRouteApi {
    void doInit(int i3, AppInterface appInterface, String str, int i16, int i17, String str2, String str3, List<ChatMessage> list);

    boolean isAbleToAction();

    void onMsgUpdate(MessageRecord messageRecord);

    void recordAction();

    void updateRelation(int i3);
}
