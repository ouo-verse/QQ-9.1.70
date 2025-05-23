package com.tencent.mobileqq.nativememorymonitor.library;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IFileMonitor {
    void onFileOpen(String str, int i3, int i16);

    void onFileRemove(String str);

    void onFileRename(String str, String str2);
}
