package com.tencent.ams.mosaic.jsengine.common.file;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IFile {
    int createNewFile();

    int deleteFile();

    IFile[] fileList();

    String getAbsolutePath();

    long getLength();

    long getModifyDate();

    String getName();

    IFile getParent();

    IReader getReader();

    IWriter getWriter(boolean z16);

    boolean isDirectory();

    boolean isExists();

    boolean isFile();

    int mkdirs();

    boolean updateModifyDate(long j3);
}
