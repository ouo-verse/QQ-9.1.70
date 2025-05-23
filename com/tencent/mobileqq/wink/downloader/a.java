package com.tencent.mobileqq.wink.downloader;

import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.open.base.g;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {
    public static void a(String str, ResDownLoadListener resDownLoadListener) {
        b.f318210a.b(str, b(str), resDownLoadListener);
    }

    public static String b(String str) {
        return b.f318210a.d() + "/" + g.d(str) + ".mp4";
    }
}
