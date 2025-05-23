package com.tencent.biz.subscribe.part;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mobileqq.utils.eh;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
class ViewUtils$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ View f96127d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f96128e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f96129f;

    @Override // java.lang.Runnable
    public void run() {
        final Bitmap a16 = b.a(this.f96127d.getResources(), this.f96128e, Integer.valueOf(this.f96127d.getWidth()), Integer.valueOf(this.f96127d.getHeight()));
        QLog.d("ViewUtils", 2, " qrWhiteBitmap = " + a16);
        if (a16 != null) {
            try {
                eh.a(a16, this.f96129f);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
            }
            this.f96127d.post(new Runnable() { // from class: com.tencent.biz.subscribe.part.ViewUtils$1.1
                @Override // java.lang.Runnable
                public void run() {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(a16);
                    QLog.d("ViewUtils", 2, " qrWhiteBitmap after blur =  bd" + bitmapDrawable);
                    ViewUtils$1.this.f96127d.setBackgroundDrawable(bitmapDrawable);
                }
            });
        }
    }
}
