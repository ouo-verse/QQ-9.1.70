package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.graphics.Bitmap;
import com.tencent.cache.api.e;
import com.tencent.mobileqq.kandian.base.image.g;
import com.tencent.mobileqq.kandian.base.image.h;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements k52.b, e {

    /* renamed from: d, reason: collision with root package name */
    private g<Bitmap> f239054d;

    public a(Bitmap bitmap, h<Bitmap> hVar) {
        this.f239054d = new g<>(bitmap, hVar);
        if (QLog.isColorLevel()) {
            c.f(toString(), "onCreate", true);
        }
    }

    @Override // k52.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public synchronized a mo197clone() {
        if (QLog.isColorLevel()) {
            c.f(toString(), "clone", true);
        }
        return new a(this.f239054d);
    }

    public boolean b() {
        if (this.f239054d != null) {
            return true;
        }
        return false;
    }

    @Override // k52.b
    public void close() {
        synchronized (this) {
            if (this.f239054d != null) {
                if (QLog.isColorLevel()) {
                    c.f(toString(), "close", true);
                }
                this.f239054d.b();
                this.f239054d = null;
            } else {
                c.e(toString(), "close twice");
            }
        }
    }

    @Override // k52.b
    public Bitmap get() {
        g<Bitmap> gVar = this.f239054d;
        if (gVar != null) {
            return gVar.c();
        }
        ReportController.o(null, "dc01160", "", "", "0X80098F1", "0X80098F1", 0, 1, null, null, "", "");
        return null;
    }

    @Override // com.tencent.cache.api.e
    public Bitmap getBitmap() {
        c.e(toString(), "entryObjRemoved getBitmap");
        close();
        g<Bitmap> gVar = this.f239054d;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    @Override // com.tencent.cache.api.f
    public int getByteSize() {
        return 0;
    }

    public String toString() {
        Integer num;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("zimage.closeable@");
        sb5.append(hashCode());
        sb5.append("_bitmap@");
        g<Bitmap> gVar = this.f239054d;
        if (gVar != null && gVar.c() != null) {
            num = Integer.valueOf(this.f239054d.c().hashCode());
        } else {
            num = null;
        }
        sb5.append(num);
        return sb5.toString();
    }

    public a(g<Bitmap> gVar) {
        gVar.a();
        this.f239054d = gVar;
        if (QLog.isColorLevel()) {
            c.f(toString(), "createFromClone", true);
        }
    }
}
