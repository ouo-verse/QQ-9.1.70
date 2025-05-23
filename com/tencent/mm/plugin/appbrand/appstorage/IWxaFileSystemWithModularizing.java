package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.rc.t;
import com.tencent.luggage.wxa.tk.i;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public interface IWxaFileSystemWithModularizing extends r {
    /* synthetic */ boolean accept(String str);

    @NonNull
    /* synthetic */ l access(String str);

    @Override // com.tencent.luggage.wxa.rc.r
    @Nullable
    /* synthetic */ v allocTempFile(String str);

    @Override // com.tencent.luggage.wxa.rc.r
    /* synthetic */ boolean canRenameFile(String str);

    @Override // com.tencent.luggage.wxa.rc.r
    /* synthetic */ boolean canSaveToLocal(String str);

    /* synthetic */ void cleanupDirectory();

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l copyTo(String str, v vVar, boolean z16);

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l createTempFileFrom(v vVar, String str, boolean z16, i iVar);

    @Override // com.tencent.luggage.wxa.rc.r
    @Nullable
    /* synthetic */ v getAbsoluteFile(String str);

    @Nullable
    /* synthetic */ v getAbsoluteFile(String str, boolean z16);

    @Override // com.tencent.luggage.wxa.rc.r
    @Nullable
    /* synthetic */ v getPrivateAbsoluteFile(String str);

    @Override // com.tencent.luggage.wxa.rc.r
    @Nullable
    /* synthetic */ List getSavedFileList();

    @Override // com.tencent.luggage.wxa.rc.r
    @Nullable
    /* synthetic */ t getStorageSpaceStatistics();

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l getTempDirectory(i iVar);

    /* synthetic */ void initialize();

    @Override // com.tencent.luggage.wxa.rc.r
    /* synthetic */ boolean isSavedFile(String str);

    @NonNull
    /* synthetic */ l isdir(String str);

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l mkdir(String str, boolean z16);

    @Nullable
    a0.a openReadPartialInfo(String str);

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l readDir(String str, i iVar);

    @NonNull
    /* synthetic */ l readFile(String str, long j3, long j16, i iVar);

    @NonNull
    /* synthetic */ l readFile(String str, i iVar);

    @Override // com.tencent.luggage.wxa.rc.r
    @Nullable
    /* synthetic */ InputStream readStream(String str);

    @NonNull
    /* synthetic */ l readZipEntry(String str, i iVar, String str2, long j3, long j16);

    /* synthetic */ void release();

    @Override // com.tencent.luggage.wxa.rc.r
    /* synthetic */ boolean removeSavedFile(String str);

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l rmdir(String str, boolean z16);

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l saveFile(v vVar, String str, i iVar);

    /* synthetic */ void setMaxTotalSize(long j3);

    @NonNull
    /* synthetic */ l stat(String str, FileStructStat fileStructStat);

    @NonNull
    /* synthetic */ l statDir(String str, List list);

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l unlink(String str);

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l unzip(String str, @NonNull v vVar);

    @Override // com.tencent.luggage.wxa.rc.r
    @NonNull
    /* synthetic */ l writeFile(String str, InputStream inputStream, boolean z16);
}
