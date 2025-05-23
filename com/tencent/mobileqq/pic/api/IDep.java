package com.tencent.mobileqq.pic.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.manager.ServerConfigManager;
import msf.msgsvc.msg_ctrl$MsgCtrl;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IDep extends QRouteApi {
    void addWaitingEssenceMsg(String str, long j3);

    void bindAnonymousInfo(MessageRecord messageRecord);

    void consumeAllThumbsInPendingQueue();

    void fillStickInfo(MessageForPic messageForPic, PicMessageExtraData picMessageExtraData);

    msg_ctrl$MsgCtrl getMsgCtrlForPicMsg(String str);

    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf getPicDownEncryptConf();

    String getServerConfigValue(AppInterface appInterface, ServerConfigManager.ConfigType configType, String str);

    String getZhituText();

    void reportEmotionPicMonitor(MessageRecord messageRecord, String str, boolean z16);
}
