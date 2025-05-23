package com.tencent.mobileqq.gamecenter.qa.api;

import ce1.a;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import tencent.im.group_pro_proto.msgpush.servtype$QuestionChannelSystemMsg;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes12.dex */
public interface IQQGameStrategyService extends IRuntimeService {
    void handleSystemMsg(long j3, servtype$QuestionChannelSystemMsg servtype_questionchannelsystemmsg, String str, String str2);

    void openGameStrategyAnswerAction(String str, int i3, a aVar);
}
