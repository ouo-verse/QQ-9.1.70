package com.tencent.av.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavCacheClearHelper {
    public static void c() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.QavCacheClearHelper.1
            @Override // java.lang.Runnable
            public void run() {
                QavCacheClearHelper.e();
                QavCacheClearHelper.d();
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        FileUtils.delete(com.tencent.av.b.i() + 132, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        FileUtils.delete(com.tencent.av.b.m(), false);
    }
}
