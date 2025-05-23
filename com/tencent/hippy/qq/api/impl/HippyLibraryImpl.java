package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyLibraryImpl implements IHippyLibrary {
    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public long getCoreJsFileLength(String str) {
        String coreJsFilePath = HippyQQLibraryManager.getInstance().getCoreJsFilePath(str);
        if (coreJsFilePath != null) {
            File file = new File(coreJsFilePath);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        }
        return -1L;
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public String getCoreJsFilePath(String str) {
        return HippyQQLibraryManager.getInstance().getCoreJsFilePath(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public String getDebugCoreJsPath(String str) {
        return HippyQQLibraryManager.getInstance().getDebugCoreJsFilePath(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public int getHippyLibraryId() {
        return HippyQQLibraryManager.getInstance().getHippyLibraryId();
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public HashMap<String, String> getLibraryVersions() {
        return HippyQQLibraryManager.getInstance().getLibraryVersions();
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public boolean isLibraryExists() {
        return HippyQQLibraryManager.getInstance().isLibraryExists();
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public boolean isLibraryLoaded() {
        return HippyQQLibraryManager.getInstance().isLibraryLoaded();
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public boolean isUseDebugSo() {
        return HippyQQLibraryManager.getInstance().isUseInspector();
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public void loadLibraryIfNeed(LibraryLoadListener libraryLoadListener) {
        HippyQQLibraryManager.getInstance().loadLibraryIfNeed(libraryLoadListener);
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public void preDownload() {
        HippyQQLibraryManager.getInstance().downloadSo();
    }

    @Override // com.tencent.hippy.qq.api.IHippyLibrary
    public void removeListener(LibraryLoadListener libraryLoadListener) {
        HippyQQLibraryManager.getInstance().removeLibraryLoadListener(libraryLoadListener);
    }
}
