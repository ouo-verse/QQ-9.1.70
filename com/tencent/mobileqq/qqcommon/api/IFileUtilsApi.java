package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IFileUtilsApi extends QRouteApi {
    public static final String API_FILE_TYPE_JPEG = "jpg";

    void createFileIfNotExits(String str);

    void delete(String str, boolean z16);

    void deleteDirectory(String str);

    String estimateFileType(String str);

    String estimateFileType(byte[] bArr);

    boolean fileExists(String str);

    boolean fileExistsAndNotEmpty(String str);

    boolean moveFile(String str, String str2);

    String readFileContent(File file);
}
