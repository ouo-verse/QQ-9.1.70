package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface c {
    void d(String str);

    void e();

    void f(boolean z16, long j3, int i3, String str, String str2, Bundle bundle);

    void onDownloadProgress(long j3, long j16);

    void onDownloadSuccess(String str);
}
