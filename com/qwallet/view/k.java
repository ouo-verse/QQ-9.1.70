package com.qwallet.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k extends BitmapDrawable {

    /* renamed from: a, reason: collision with root package name */
    boolean f41847a;

    public k(String str) {
        super(str);
        this.f41847a = false;
    }

    public synchronized void a() {
        String str;
        this.f41847a = true;
        Bitmap bitmap = getBitmap();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("SafeBitmapDrawable recyle ");
            if (bitmap == null) {
                str = "null";
            } else {
                str = "not null";
            }
            sb5.append(str);
            QLog.i("QwalletMainPageController", 2, sb5.toString());
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            if (QLog.isColorLevel()) {
                QLog.i("QwalletMainPageController", 2, "SafeBitmapDrawable recyled");
            }
            bitmap.recycle();
        }
        setCallback(null);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public synchronized void draw(Canvas canvas) {
        if (!this.f41847a && getBitmap() != null && !getBitmap().isRecycled()) {
            super.draw(canvas);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QwalletMainPageController", 2, "SafeBitmapDrawable draw recyled");
        }
    }

    public k(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.f41847a = false;
    }
}
