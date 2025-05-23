package com.tencent.mobileqq.activity.aio.photo;

import android.os.Environment;
import android.os.StatFs;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    public static long a() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
    }
}
