package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FileUtilsApiImpl implements IFileUtilsApi {
    static IPatchRedirector $redirector_;

    public FileUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public void createFileIfNotExits(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            FileUtils.createFileIfNotExits(str);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public void delete(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        } else {
            FileUtils.delete(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public void deleteDirectory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            FileUtils.deleteDirectory(str);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public String estimateFileType(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? FileUtils.estimateFileType(bArr) : (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public boolean fileExists(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        return FileUtils.fileExists(str);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public boolean fileExistsAndNotEmpty(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return FileUtils.fileExistsAndNotEmpty(str);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public boolean moveFile(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return FileUtils.moveFile(str, str2);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public String readFileContent(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) file);
        }
        return FileUtils.readFileContent(file);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IFileUtilsApi
    public String estimateFileType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? FileUtils.estimateFileType(str) : (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
    }
}
