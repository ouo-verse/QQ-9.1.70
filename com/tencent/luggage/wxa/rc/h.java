package com.tencent.luggage.wxa.rc;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements r {
    public l a(long j3, long j16, long j17) {
        l lVar = l.OK;
        if (j3 >= 0 && j3 <= j17 - 1) {
            if (j16 >= 1 && j16 <= j17 - j3) {
                return lVar;
            }
            return l.ERR_ILLEGAL_READ_LENGTH;
        }
        return l.ERR_ILLEGAL_READ_POSITION;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public boolean accept(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l access(String str) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v allocTempFile(String str) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public boolean canRenameFile(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public boolean canSaveToLocal(String str) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l copyTo(String str, com.tencent.luggage.wxa.cp.v vVar, boolean z16) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l createTempFileFrom(com.tencent.luggage.wxa.cp.v vVar, String str, boolean z16, com.tencent.luggage.wxa.tk.i iVar) {
        return l.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str, boolean z16) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v getPrivateAbsoluteFile(String str) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public List getSavedFileList() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public t getStorageSpaceStatistics() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l getTempDirectory(com.tencent.luggage.wxa.tk.i iVar) {
        return l.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public boolean isSavedFile(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l isdir(String str) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l mkdir(String str, boolean z16) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l readDir(String str, com.tencent.luggage.wxa.tk.i iVar) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readFile(String str, com.tencent.luggage.wxa.tk.i iVar) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public InputStream readStream(String str) {
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        if (readFile(str, iVar) == l.OK) {
            return new com.tencent.luggage.wxa.h6.a((ByteBuffer) iVar.f141499a);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readZipEntry(String str, com.tencent.luggage.wxa.tk.i iVar, String str2, long j3, long j16) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public boolean removeSavedFile(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l rmdir(String str, boolean z16) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l saveFile(com.tencent.luggage.wxa.cp.v vVar, String str, com.tencent.luggage.wxa.tk.i iVar) {
        return l.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l stat(String str, FileStructStat fileStructStat) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l statDir(String str, List list) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l unlink(String str) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l unzip(String str, com.tencent.luggage.wxa.cp.v vVar) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l writeFile(String str, InputStream inputStream, boolean z16) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str) {
        return getAbsoluteFile(str, false);
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readFile(String str, long j3, long j16, com.tencent.luggage.wxa.tk.i iVar) {
        return l.ERR_PERMISSION_DENIED;
    }

    public void cleanupDirectory() {
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void initialize() {
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void release() {
    }

    public void setMaxTotalSize(long j3) {
    }
}
