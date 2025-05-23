package com.tencent.biz.pubaccount.weishi.image;

import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi.report.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSImageDownListener implements iy.a {

    /* renamed from: a, reason: collision with root package name */
    private long f80851a = SystemClock.uptimeMillis();

    /* renamed from: b, reason: collision with root package name */
    private int f80852b;

    /* renamed from: c, reason: collision with root package name */
    private c f80853c;

    public WSImageDownListener(c cVar) {
        this.f80853c = cVar;
    }

    private void d(final URL url, long j3, final String str, final ImageView imageView, final int i3) {
        final String url2 = url.toString();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.image.WSImageDownListener.1
            @Override // java.lang.Runnable
            public void run() {
                File file = AbsDownloader.getFile(url.toString());
                if (file == null) {
                    return;
                }
                long length = file.length();
                ImageView imageView2 = imageView;
                g.d().j(imageView2 instanceof KandianUrlImageView ? ((KandianUrlImageView) imageView2).mController.g() : null, true, false, length, url2, str, i3);
            }
        });
    }

    @Override // iy.a
    public void a(URL url, Object obj) {
        if (obj instanceof k52.b) {
            ((k52.b) obj).get();
        }
        if (this.f80853c == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.f80851a;
        this.f80852b = 0;
        this.f80851a = 0L;
        if (this.f80853c.g()) {
            d(url, uptimeMillis, this.f80853c.f(), this.f80853c.a(), this.f80853c.b());
        }
        iy.a c16 = this.f80853c.c();
        if (c16 != null) {
            c16.a(url, obj);
        }
    }

    @Override // iy.a
    public void b(URL url, int i3) {
        iy.a c16 = this.f80853c.c();
        if (c16 != null) {
            c16.b(url, i3);
        }
    }

    @Override // iy.a
    public void c(URL url, Throwable th5) {
        x.f("WSImageDownListener", "url = " + url + ", onLoadFailed!!!");
        if (this.f80853c == null) {
            return;
        }
        g.d().j(null, false, false, 0L, url.toString(), this.f80853c.f(), this.f80853c.b());
        if (this.f80852b < 3) {
            this.f80851a = SystemClock.uptimeMillis();
            this.f80852b++;
            if (this.f80853c.a() instanceof KandianUrlImageView) {
                ((KandianUrlImageView) this.f80853c.a()).setImage(url);
            }
        } else {
            this.f80851a = 0L;
            this.f80852b = 0;
        }
        iy.a c16 = this.f80853c.c();
        if (c16 != null) {
            c16.c(url, th5);
        }
    }

    public void e() {
        this.f80851a = SystemClock.uptimeMillis();
    }
}
