package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kc1.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileModel extends QRouteApi {
    b newFileModel(MessageForFile messageForFile);

    b newFileModel(FileManagerEntity fileManagerEntity);

    b newFileModel(String str);
}
