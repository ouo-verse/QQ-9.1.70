package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptMonitor;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements k52.a {

    /* renamed from: h, reason: collision with root package name */
    static int f239055h;

    /* renamed from: i, reason: collision with root package name */
    static int f239056i;

    /* renamed from: a, reason: collision with root package name */
    private String f239057a = "zimage.DrawableController";

    /* renamed from: b, reason: collision with root package name */
    private boolean f239058b = true;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f239059c;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.mobileqq.kandian.base.image.b f239060d;

    /* renamed from: e, reason: collision with root package name */
    public k52.b f239061e;

    /* renamed from: f, reason: collision with root package name */
    ZImageView f239062f;

    /* renamed from: g, reason: collision with root package name */
    iy.a f239063g;

    public b(Drawable drawable, ZImageView zImageView) {
        this.f239059c = drawable;
        this.f239062f = zImageView;
        this.f239057a += ".v" + this.f239062f.hashCode();
    }

    private boolean j(k52.b bVar) {
        k52.b bVar2 = this.f239061e;
        if (bVar2 == null || bVar == null || bVar2.get() != bVar.get() || !(this.f239062f.getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) this.f239062f.getDrawable()).getBitmap() != this.f239061e.get()) {
            return true;
        }
        return false;
    }

    private void k(k52.b bVar, boolean z16) {
        k52.b bVar2 = this.f239061e;
        if (bVar2 != null) {
            bVar2.close();
        }
        this.f239061e = bVar;
        this.f239062f.setImageDrawable(new d(this.f239061e.get()), z16);
    }

    @Override // k52.a
    public void a(com.tencent.mobileqq.kandian.base.image.b bVar, k52.b bVar2) {
        if (bVar.equals(this.f239060d) && bVar2.get() != null) {
            if (bVar2 instanceof a) {
                d(bVar, (a) bVar2, true, "onSuccess");
                return;
            } else {
                QLog.e("zimage.DrawableController", 1, "onSuccess error for bitmap is not CloseableBitmap");
                return;
            }
        }
        bVar2.close();
    }

    @Override // k52.a
    public void b(com.tencent.mobileqq.kandian.base.image.b bVar, Throwable th5) {
        iy.a aVar = this.f239063g;
        if (aVar != null) {
            aVar.c(bVar.f239004a, th5);
        }
    }

    @Override // k52.a
    public void c(com.tencent.mobileqq.kandian.base.image.b bVar, int i3) {
        iy.a aVar = this.f239063g;
        if (aVar != null) {
            aVar.b(bVar.f239004a, i3);
        }
    }

    void d(com.tencent.mobileqq.kandian.base.image.b bVar, k52.b bVar2, boolean z16, String str) {
        this.f239060d = bVar;
        if (QLog.isDevelopLevel()) {
            c.e(this.f239057a, "attachImage " + str + " " + this.f239060d + " " + bVar2 + " total:" + f239055h + " cache:" + f239056i);
        }
        if (!o() || j(bVar2)) {
            k(bVar2, z16);
        }
        com.tencent.mobileqq.kandian.base.image.b bVar3 = this.f239060d;
        if (bVar3 != null) {
            bVar3.f239020q = 0;
            RIJImageOptReport.h(bVar3, true, "attached");
        }
        iy.a aVar = this.f239063g;
        if (aVar != null) {
            aVar.a(bVar.f239004a, bVar2);
        }
    }

    public void e(String str) {
        if (QLog.isDevelopLevel()) {
            c.e(this.f239057a, "attachToWindow " + str + " " + this.f239060d);
        }
    }

    public void f(String str) {
        com.tencent.mobileqq.kandian.base.image.b bVar = this.f239060d;
        if (bVar != null) {
            bVar.f239007d = true;
        }
        if (QLog.isDevelopLevel()) {
            c.e(this.f239057a, "detachFromWindow " + str + " " + this.f239060d + " " + this.f239061e);
        }
        if (!o()) {
            if (this.f239058b && this.f239062f.getDrawable() != null && (this.f239062f.getDrawable() instanceof d)) {
                this.f239062f.setImageDrawable(this.f239059c);
            }
            k52.b bVar2 = this.f239061e;
            if (bVar2 != null) {
                bVar2.close();
                this.f239061e = null;
            }
        }
        if (this.f239060d != null) {
            ((IImageManager) QRoute.api(IImageManager.class)).cancelRequest(this.f239060d, "reset");
            this.f239060d = null;
        }
    }

    public com.tencent.mobileqq.kandian.base.image.b g() {
        return this.f239060d;
    }

    public iy.a h() {
        return this.f239063g;
    }

    public void i(boolean z16) {
        this.f239058b = z16;
    }

    public void l(com.tencent.mobileqq.kandian.base.image.b bVar) {
        TraceUtils.traceBegin("DrawableController.setImageRequest");
        if (this.f239062f.isRound()) {
            bVar.f239010g = 1;
        }
        f239055h++;
        f("resetUrl");
        k52.b bitmap = ((IImageManager) QRoute.api(IImageManager.class)).getBitmap(bVar);
        if (bitmap == null) {
            this.f239060d = bVar;
            this.f239062f.setImageDrawable(this.f239059c);
            ((IRIJImageOptMonitor) QRoute.api(IRIJImageOptMonitor.class)).addMonitor(this.f239060d);
            ((IImageManager) QRoute.api(IImageManager.class)).loadImage(this.f239060d, this);
        } else {
            f239056i++;
            RIJImageOptReport.e(1, bVar);
            d(bVar, bitmap, false, "setImageRequest");
        }
        TraceUtils.traceEnd();
    }

    public void m(Drawable drawable) {
        this.f239059c = drawable;
        if (this.f239060d != null) {
            f("setPlaceHolder");
        }
        this.f239062f.setImageDrawable(drawable);
    }

    public void n(iy.a aVar) {
        this.f239063g = aVar;
    }

    boolean o() {
        if (((IRIJImageOptConfig) QRoute.api(IRIJImageOptConfig.class)).isBitmapOpt() && c.d()) {
            return true;
        }
        return false;
    }
}
