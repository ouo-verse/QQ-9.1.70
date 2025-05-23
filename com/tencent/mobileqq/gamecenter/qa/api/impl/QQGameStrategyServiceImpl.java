package com.tencent.mobileqq.gamecenter.qa.api.impl;

import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyService;
import com.tencent.mobileqq.gamecenter.qa.manager.GameStrategyAuthAction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.msgpush.servtype$QuestionChannelSystemMsg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyServiceImpl implements IQQGameStrategyService {
    private static final String TAG = "QQGameStrategyServiceImpl";
    private GameStrategyAuthAction mAuthAction;
    private List<Long> mMsgRandomList = new ArrayList();

    public GameStrategyAuthAction getAuthAction() {
        return this.mAuthAction;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyService
    public void handleSystemMsg(long j3, servtype$QuestionChannelSystemMsg servtype_questionchannelsystemmsg, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleSystemMsg, msgRandom=", Long.valueOf(j3), ", guildId=", str, ", channelId=", str2);
        }
        synchronized (this.mMsgRandomList) {
            if (!this.mMsgRandomList.contains(Long.valueOf(j3))) {
                this.mMsgRandomList.add(Long.valueOf(j3));
                fe1.b.b().c(servtype_questionchannelsystemmsg, str, str2);
            } else {
                QLog.e(TAG, 1, "handleSystemMsg, abort duplicate msg, msgRandom=", Long.valueOf(j3));
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mAuthAction = new GameStrategyAuthAction();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        getAuthAction().e();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyService
    public void openGameStrategyAnswerAction(String str, int i3, ce1.a aVar) {
        getAuthAction().f(str, i3, aVar);
    }
}
