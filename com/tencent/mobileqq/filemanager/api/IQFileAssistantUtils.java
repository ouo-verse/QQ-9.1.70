package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQFileAssistantUtils extends QRouteApi {
    boolean checkNotifyDeviceOnline(BaseQQAppInterface baseQQAppInterface);

    int decodeMessageDeviceType(msg_comm$Msg msg_comm_msg);

    int getCurrentDeviceType();

    int getCurrentTargetDeviceType();

    int getMachineHeadResId(int i3);

    String getMachineNickName(Context context, int i3);

    int getMachineType(int i3);

    String getNewVersionDatalineUin(BaseQQAppInterface baseQQAppInterface);

    long getOfflineDelay(BaseQQAppInterface baseQQAppInterface);

    long getOnlyOfflineLimitSize(BaseQQAppInterface baseQQAppInterface);

    boolean isAutoDownloadOffline(BaseQQAppInterface baseQQAppInterface, long j3);

    boolean isFileAssistantAio(String str);

    boolean isIgonreDataLineLogic(BaseQQAppInterface baseQQAppInterface, RecentUser recentUser);

    boolean isMessageSender(MessageRecord messageRecord);

    boolean isNeedShowPadOpts(BaseQQAppInterface baseQQAppInterface);

    boolean isNewVersionDataline();

    boolean isNewVersionDataline(BaseQQAppInterface baseQQAppInterface);

    boolean isOldDatalineMsgRecord(MessageRecord messageRecord);

    void notifyUpdateRecentFileAssistant(BaseQQAppInterface baseQQAppInterface);

    void openNewDatalineAio(Context context);

    void openNewDatalineAioSingle(Context context, Intent intent);

    @Deprecated
    void openNewVersionDatalineSwitch();

    void reParseFileAssistantInfo(BaseQQAppInterface baseQQAppInterface, Intent intent, Bundle bundle);

    void resetFileAssistantOnlineMark(BaseQQAppInterface baseQQAppInterface);

    void saveMessageDeviceType(MessageRecord messageRecord, int i3);

    void setFileAssistantOnlineMark(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16);

    void setSendTarget(int i3);

    boolean userOfflineOnly(BaseQQAppInterface baseQQAppInterface, long j3);
}
