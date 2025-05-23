package com.tencent.mobileqq.guild.temp.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Set;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildFileTransferWrapper extends QRouteApi {
    boolean cancelSend(BaseQQAppInterface baseQQAppInterface, long j3);

    void resendFile(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity);

    void uploadFileToGuild(BaseQQAppInterface baseQQAppInterface, String str, String str2, Set<FileInfo> set);
}
