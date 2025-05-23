package com.qzone.homepage.ui.Facade;

import android.graphics.Bitmap;
import com.qzone.homepage.ui.Facade.f;
import com.tencent.component.media.image.ImageLoader;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g extends f {

    /* renamed from: c, reason: collision with root package name */
    private static g f47592c;

    /* renamed from: d, reason: collision with root package name */
    private static a f47593d;

    g() {
    }

    public static synchronized g l() {
        g gVar;
        synchronized (g.class) {
            if (f47592c == null) {
                f47592c = new g();
            }
            gVar = f47592c;
        }
        return gVar;
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void b(String str, int i3, int i16, String str2) {
        j(str);
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void d(String str, int i3, int i16, String str2) {
        j(str);
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void e(String str, int i3, int i16, String str2) {
        j(str);
        a aVar = f47593d;
        if (aVar != null) {
            aVar.e(str, i3, i16, str2);
        }
    }

    public void k(String str, List<String> list) {
        if (g(str) == null && list != null) {
            if (list.size() == 1) {
                f.a aVar = new f.a(str, 1, this);
                String str2 = list.get(0);
                if (f.i(str2, h.l().i())) {
                    aVar.onDownloadSucceed(str2);
                    return;
                }
                f(str, aVar);
                ImageLoader.Options options = new ImageLoader.Options();
                options.useMainThread = true;
                options.needCallBackProcessPercent = true;
                options.extraProcessor = new c();
                options.imageConfig = Bitmap.Config.RGB_565;
                options.fileRootPath = h.l().j();
                this.f47585a.downloadImage(list.get(0), aVar, options);
                return;
            }
            f.a aVar2 = new f.a(str, list.size(), this);
            f(str, aVar2);
            for (String str3 : list) {
                if (f.i(str3, h.l().i())) {
                    aVar2.onDownloadSucceed(str3);
                } else {
                    ImageLoader.Options options2 = new ImageLoader.Options();
                    options2.useMainThread = true;
                    options2.needCallBackProcessPercent = true;
                    options2.extraProcessor = new c();
                    options2.imageConfig = Bitmap.Config.RGB_565;
                    options2.fileRootPath = h.l().j();
                    this.f47585a.downloadImage(str3, aVar2, options2);
                }
            }
        }
    }

    public void m(a aVar) {
        f47593d = aVar;
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void a(String str, int i3) {
    }
}
