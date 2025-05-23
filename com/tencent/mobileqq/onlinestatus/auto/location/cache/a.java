package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
class a extends b {

    /* renamed from: d, reason: collision with root package name */
    private static File f255528d;

    /* renamed from: c, reason: collision with root package name */
    private final int f255529c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, int i3) {
        super(str);
        b.f255530b = "DiskLoader";
        this.f255529c = i3;
        File file = new File(MobileQQ.sMobileQQ.getCacheDir(), "/poi/");
        f255528d = file;
        file.mkdirs();
    }

    public int c() {
        String[] list = f255528d.list();
        if (list == null) {
            return 0;
        }
        return list.length;
    }
}
