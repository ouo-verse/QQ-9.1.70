package com.tencent.qqmini.sdk.launcher.shell;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IMiniAppFileManager {
    String getAbsolutePath(String str);

    String getTmpPath(String str);

    String getTmpPathByWxFilePath(String str);

    String getWxFilePath(String str);
}
