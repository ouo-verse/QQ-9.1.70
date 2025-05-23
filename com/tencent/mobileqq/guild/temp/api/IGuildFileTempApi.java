package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildFileTempApi extends QRouteApi {
    Object getNewGuildFileDownloader(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    Object getNewGuildFileModel(BaseQQAppInterface baseQQAppInterface, Activity activity, Object obj, int i3);

    Object getNewVideoForGuild(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    void handleGuildFileMsg(BaseQQAppInterface baseQQAppInterface, Object obj, MessageForFile messageForFile, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar);
}
