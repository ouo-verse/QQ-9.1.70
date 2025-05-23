package com.tencent.mobileqq.vas.updatesystem.callback;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface QuickUpdateBusinessCallback {
    boolean canUpdate(long j3, String str, String str2);

    boolean deleteFiles(long j3, String str);

    TagItemInfo getItemInfo(long j3, String str);

    boolean isFileExists(long j3, String str);
}
