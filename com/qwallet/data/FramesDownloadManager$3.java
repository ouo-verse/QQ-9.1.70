package com.qwallet.data;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
class FramesDownloadManager$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f41472d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        List j3 = a.j(null, this.f41472d);
        if (j3 != null && j3.size() > 0) {
            Drawable h16 = a.h(null, (File) j3.get(0));
            if (h16 != null && ((BitmapDrawable) h16).getBitmap() != null) {
                a.l(null, 0, h16);
                a.g(null, a.i(null, j3, h16));
                if (a.b(null) != null) {
                    a.m(null, 0, a.b(null));
                    return;
                } else {
                    a.m(null, -5, null);
                    return;
                }
            }
            a.l(null, -4, null);
            return;
        }
        a.l(null, -3, null);
    }
}
