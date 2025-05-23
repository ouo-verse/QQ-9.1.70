package com.tencent.luggage.wxa.rc;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface r extends com.tencent.luggage.wxa.h1.b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        String a();

        long b();

        long lastModified();
    }

    boolean accept(String str);

    l access(String str);

    com.tencent.luggage.wxa.cp.v allocTempFile(String str);

    boolean canRenameFile(String str);

    boolean canSaveToLocal(String str);

    l copyTo(String str, com.tencent.luggage.wxa.cp.v vVar, boolean z16);

    l createTempFileFrom(com.tencent.luggage.wxa.cp.v vVar, String str, boolean z16, com.tencent.luggage.wxa.tk.i iVar);

    com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str);

    com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str, boolean z16);

    com.tencent.luggage.wxa.cp.v getPrivateAbsoluteFile(String str);

    List getSavedFileList();

    t getStorageSpaceStatistics();

    l getTempDirectory(com.tencent.luggage.wxa.tk.i iVar);

    void initialize();

    boolean isSavedFile(String str);

    l isdir(String str);

    l mkdir(String str, boolean z16);

    l readDir(String str, com.tencent.luggage.wxa.tk.i iVar);

    l readFile(String str, long j3, long j16, com.tencent.luggage.wxa.tk.i iVar);

    l readFile(String str, com.tencent.luggage.wxa.tk.i iVar);

    InputStream readStream(String str);

    l readZipEntry(String str, com.tencent.luggage.wxa.tk.i iVar, String str2, long j3, long j16);

    void release();

    boolean removeSavedFile(String str);

    l rmdir(String str, boolean z16);

    l saveFile(com.tencent.luggage.wxa.cp.v vVar, String str, com.tencent.luggage.wxa.tk.i iVar);

    l stat(String str, FileStructStat fileStructStat);

    l statDir(String str, List list);

    l unlink(String str);

    l unzip(String str, com.tencent.luggage.wxa.cp.v vVar);

    l writeFile(String str, InputStream inputStream, boolean z16);
}
