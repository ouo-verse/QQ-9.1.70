package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyLibrary extends QRouteApi {
    long getCoreJsFileLength(String str);

    String getCoreJsFilePath(String str);

    String getDebugCoreJsPath(String str);

    int getHippyLibraryId();

    HashMap<String, String> getLibraryVersions();

    boolean isLibraryExists();

    boolean isLibraryLoaded();

    boolean isUseDebugSo();

    void loadLibraryIfNeed(LibraryLoadListener libraryLoadListener);

    void preDownload();

    void removeListener(LibraryLoadListener libraryLoadListener);
}
