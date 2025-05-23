package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.os.Process;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Leo {
    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }
}
