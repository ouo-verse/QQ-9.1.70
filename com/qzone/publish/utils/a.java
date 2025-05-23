package com.qzone.publish.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private String f52135b;

    /* renamed from: d, reason: collision with root package name */
    private Context f52137d;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f52141h;

    /* renamed from: i, reason: collision with root package name */
    private int f52142i;

    /* renamed from: j, reason: collision with root package name */
    private String f52143j;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f52134a = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private String f52136c = "";

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.widget.a f52138e = new com.qzone.widget.a();

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.widget.a f52139f = new com.qzone.widget.a();

    /* renamed from: g, reason: collision with root package name */
    private List<Bitmap> f52140g = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    public a(Context context, String str, String str2, Map<String, String> map) {
        new HashMap();
        this.f52142i = 0;
        this.f52143j = "";
        this.f52137d = context;
        this.f52135b = str;
        this.f52141h = map;
        i();
    }

    private void f(int i3) {
        this.f52138e.h(1);
        this.f52138e.m(30);
        this.f52138e.k(false);
        this.f52138e.i(false);
        this.f52138e.l(this.f52137d.getResources().getColor(R.color.black));
        this.f52138e.j(this.f52135b);
        this.f52138e.f(this.f52142i, this.f52143j);
        this.f52138e.e(i3, 0);
    }

    private void i() {
        Map<String, String> map = this.f52141h;
        if (map != null) {
            try {
                this.f52142i = Integer.parseInt(map.get("diy_font_id"));
            } catch (Exception e16) {
                QZLog.e("MoodComposer", e16.getMessage());
            }
            this.f52143j = this.f52141h.get("diy_font_url");
        }
    }

    public void d(String str, b bVar) {
        Downloader commonDownloader = DownloaderFactory.getInstance(this.f52137d).getCommonDownloader();
        File localFileByUrl = ImageManager.getLocalFileByUrl(this.f52137d, str, null);
        if (localFileByUrl == null) {
            return;
        }
        commonDownloader.download(str, localFileByUrl.getAbsolutePath(), new C0447a(localFileByUrl, bVar));
    }

    private void g(int i3) {
        try {
            this.f52136c = new SimpleDateFormat("[ yyyy.M.d ]").format(new Date());
        } catch (Throwable th5) {
            QZLog.i("MoodComposer", 1, "error initDateArea", th5);
        }
        if (TextUtils.isEmpty(this.f52136c)) {
            return;
        }
        this.f52139f.h(1);
        this.f52139f.m(24);
        this.f52139f.k(false);
        this.f52139f.i(false);
        this.f52139f.l(this.f52137d.getResources().getColor(R.color.f157116k8));
        this.f52139f.j(this.f52136c);
        this.f52139f.e(i3, 0);
    }

    public Bitmap e(List<String> list) {
        if (list != null && !list.isEmpty()) {
            int i3 = 0;
            while (true) {
                if (i3 >= (list.size() <= 9 ? list.size() : 9)) {
                    break;
                }
                this.f52134a.add(list.get(i3));
                i3++;
            }
        }
        for (String str : this.f52134a) {
            if (URLUtil.isNetworkUrl(str)) {
                File imageFile = ImageLoader.getInstance().getImageFile(str);
                if (imageFile != null && imageFile.exists()) {
                    Bitmap q16 = com.qzone.util.image.c.q(imageFile.getAbsolutePath(), 750);
                    if (q16 != null) {
                        this.f52140g.add(q16);
                    }
                } else {
                    QZLog.w("MoodComposer", "selected qzone picture not exist.");
                }
            } else {
                Bitmap q17 = com.qzone.util.image.c.q(str, 750);
                if (q17 != null) {
                    this.f52140g.add(q17);
                }
            }
        }
        return h(750);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap h(int i3) {
        int b16;
        boolean z16;
        Drawable drawable;
        int i16;
        int i17;
        int i18;
        List<Bitmap> list = this.f52140g;
        if (list != null && !list.isEmpty()) {
            int i19 = 0;
            for (Bitmap bitmap : this.f52140g) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    i19 += bitmap.getHeight() + 6;
                }
            }
            if (!TextUtils.isEmpty(this.f52135b) || this.f52140g.size() > 1) {
                int i26 = i3 - 140;
                g(i26);
                if (!TextUtils.isEmpty(this.f52135b)) {
                    f(i26);
                    Iterator<TextCell> it = this.f52138e.c().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z16 = false;
                            break;
                        }
                        TextCell next = it.next();
                        if (next.isEmo() && !next.isDrawableLoaded) {
                            z16 = true;
                            break;
                        }
                    }
                    b16 = i19 + this.f52139f.b() + 20 + 48 + this.f52138e.b();
                } else {
                    b16 = i19 + this.f52139f.b() + 48;
                    z16 = false;
                }
                drawable = this.f52137d.getResources().getDrawable(R.drawable.g68);
                if (drawable != null) {
                    i16 = (drawable.getIntrinsicHeight() * 2) / 3;
                    i17 = (drawable.getIntrinsicWidth() * 2) / 3;
                    b16 += 54 + i16;
                } else {
                    i16 = 0;
                    i17 = 0;
                }
                i18 = b16 + 30;
            } else {
                i18 = i19 - 6;
                drawable = null;
                z16 = false;
                i16 = 0;
                i17 = 0;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(i3, i18, Bitmap.Config.ARGB_8888);
                if (createBitmap != null) {
                    createBitmap.eraseColor(-777);
                }
                Canvas canvas = new Canvas(createBitmap);
                canvas.save();
                for (int i27 = 0; i27 < this.f52140g.size(); i27++) {
                    Bitmap bitmap2 = this.f52140g.get(i27);
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        if (QZLog.isDevelopLevel()) {
                            QZLog.d("MoodComposer", 4, i27 + "th select bitmap width = " + bitmap2.getWidth() + ", height = " + bitmap2.getHeight());
                        }
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                        canvas.translate(0.0f, bitmap2.getHeight() + 6);
                    }
                }
                if (z16) {
                    try {
                        Thread.currentThread();
                        LockMethodProxy.sleep(500L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.f52135b) || this.f52140g.size() > 1) {
                    canvas.translate(0.0f, 48);
                    canvas.save();
                    int i28 = i3 / 2;
                    canvas.translate(i28 - (this.f52139f.d() / 2), 0.0f);
                    this.f52139f.a(canvas);
                    canvas.restore();
                    canvas.translate(0.0f, this.f52139f.b());
                    if (!TextUtils.isEmpty(this.f52135b)) {
                        canvas.translate(0.0f, 20);
                        canvas.save();
                        canvas.translate(i28 - (this.f52138e.d() / 2), 0.0f);
                        this.f52138e.a(canvas);
                        canvas.restore();
                        canvas.translate(0.0f, this.f52138e.b());
                    }
                    if (drawable != null) {
                        canvas.translate((i3 - i17) / 2, 54);
                        drawable.setBounds(0, 0, i17, i16);
                        drawable.draw(canvas);
                    }
                }
                canvas.restore();
                return createBitmap;
            } catch (OutOfMemoryError e17) {
                QZLog.e("MoodComposer", "OutOfMemoryError. ", e17);
            }
        }
        return null;
    }

    /* compiled from: P */
    /* renamed from: com.qzone.publish.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0447a implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f52144a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f52145b;

        C0447a(File file, b bVar) {
            this.f52144a = file;
            this.f52145b = bVar;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            QZLog.e("MoodComposer", "download signin pic failed");
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            Bitmap bitmap;
            if (QZLog.isColorLevel()) {
                QZLog.i("MoodComposer", 2, "download signin pic succeed");
            }
            try {
                bitmap = BitmapFactory.decodeFile(this.f52144a.getAbsolutePath());
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (bitmap == null || this.f52145b == null) {
                return;
            }
            if (TextUtils.isEmpty(a.this.f52135b)) {
                this.f52145b.a(bitmap);
                return;
            }
            a.this.f52140g.add(bitmap);
            Bitmap h16 = a.this.h(bitmap.getWidth());
            if (h16 != null) {
                this.f52145b.a(h16);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}
