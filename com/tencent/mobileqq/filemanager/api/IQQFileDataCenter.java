package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes12.dex */
public interface IQQFileDataCenter extends IRuntimeService {
    void insertTBSToolFileEntity(FileManagerEntity fileManagerEntity);

    void insertToFMList(FileManagerEntity fileManagerEntity);

    void insertToMemMap(FileManagerEntity fileManagerEntity);

    FileManagerEntity queryByFileIdForMemory(String str);

    FileManagerEntity queryBySessionId(long j3);

    FileManagerEntity queryFileEntity(long j3, String str, int i3, long j16);

    FileManagerEntity queryFileEntityByUuid(String str);

    List<FileManagerEntity> queryMaxRecentReocrds();

    List<FileManagerEntity> queryMaxRecentReocrdsWithUin(String str);

    void setAioDelete(FileManagerEntity fileManagerEntity);

    void updateFileEntity(FileManagerEntity fileManagerEntity);

    void updateTBSToolFileEntity(FileManagerEntity fileManagerEntity);
}
