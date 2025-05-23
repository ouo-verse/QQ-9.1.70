package com.tencent.mobileqq.qrscan;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface f {
    boolean a(int i3, String str, String str2, ScannerParams scannerParams);

    boolean b(int i3, int i16, Intent intent);

    boolean c(int i3, int i16, Intent intent);

    boolean d(String str, String str2, ScannerParams scannerParams);

    String getName();

    void onDestroy();
}
