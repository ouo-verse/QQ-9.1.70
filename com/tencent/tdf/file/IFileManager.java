package com.tencent.tdf.file;

import com.tencent.tdf.file.FileManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IFileManager {
    boolean delete(String str);

    boolean exists(String str);

    List<FileManager.FileInfo> getFileInfos(String str);

    boolean makeDir(String str);
}
