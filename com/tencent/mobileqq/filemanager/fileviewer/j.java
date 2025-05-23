package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface j {
    int a();

    int b();

    int c();

    void d(FileManagerEntity fileManagerEntity);

    String e();

    FileManagerEntity getEntity();

    String getFileId();

    String getFileName();

    String getFilePath();

    long getFileSize();

    int getFileType();

    String getPeerUin();

    long getSessionId();

    String getUuid();

    boolean o();

    void p(boolean z16);

    String q();

    void r(boolean z16);

    WeiYunFileInfo s();

    void setState(int i3);

    void t(String str);

    String u();

    int v();

    long w();

    String x();

    boolean y();
}
