package com.tencent.qqnt.emotion.stickerrecommended.adapter;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.g;
import com.tencent.qqnt.emotion.stickerrecommended.o;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<URLDrawable> f356456a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f356457b;

    /* renamed from: c, reason: collision with root package name */
    private long f356458c;

    /* renamed from: d, reason: collision with root package name */
    private int f356459d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f356460e;

    /* renamed from: f, reason: collision with root package name */
    private b f356461f;

    /* renamed from: g, reason: collision with root package name */
    private URLDrawable.URLDrawableListener f356462g;

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.emotion.stickerrecommended.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    class C9616a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f356463d;

        C9616a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
                return;
            }
            a.this.f356456a.remove(uRLDrawable);
            if (QLog.isColorLevel()) {
                QLog.d("StickerDrawableDownloader", 2, "firstDrawableListener onLoadCanceled");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                a.this.j(uRLDrawable);
                a.this.f356456a.remove(uRLDrawable);
                if (QLog.isColorLevel() && System.currentTimeMillis() - this.f356463d > 1000) {
                    QLog.d("StickerDrawableDownloader", 2, "firstDrawableListener onLoadFialed");
                    this.f356463d = System.currentTimeMillis();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            a.this.k(uRLDrawable, System.currentTimeMillis() - a.this.f356458c);
            a.this.f356457b = true;
            a.this.f356456a.remove(uRLDrawable);
            if (a.this.f356461f != null) {
                a.this.f356461f.a(a.this.f356457b);
                a.this.l(null);
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerDrawableDownloader", 2, "firstDrawableListener downloadSuccess");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface b {
        void a(boolean z16);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f356456a = new ArrayList<>(5);
        this.f356462g = new C9616a();
        this.f356460e = BaseApplication.getContext().getResources().getDrawable(R.drawable.f160231dr);
        this.f356459d = (int) (BaseApplication.getContext().getResources().getDisplayMetrics().density * 6.0f);
    }

    @NotNull
    private URLDrawable.URLDrawableOptions i(g gVar) {
        URLDrawable.URLDrawableOptions uRLDrawableOptions = gVar.getURLDrawableOptions();
        if (uRLDrawableOptions == null) {
            uRLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        }
        Drawable drawable = this.f356460e;
        uRLDrawableOptions.mLoadingDrawable = drawable;
        uRLDrawableOptions.mFailedDrawable = drawable;
        uRLDrawableOptions.mPlayGifImage = true;
        uRLDrawableOptions.mGifRoundCorner = this.f356459d;
        return uRLDrawableOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(URLDrawable uRLDrawable) {
        if (uRLDrawable == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        URL url = uRLDrawable.getURL();
        if (url != null) {
            hashMap.put("sticker_url", url.toString());
        }
        StatisticCollector.d(BaseApplication.getContext()).c(null, "StickerRecImgLoad", false, 0L, 0L, hashMap, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(URLDrawable uRLDrawable, long j3) {
        if (uRLDrawable == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("first_sticker", String.valueOf(!this.f356457b));
        URL url = uRLDrawable.getURL();
        if (url != null) {
            hashMap.put("sticker_url", url.toString());
        }
        StatisticCollector.d(BaseApplication.getContext()).c(null, "StickerRecImgLoad", true, j3, 0L, hashMap, "");
    }

    public void h(List<g> list) {
        URLDrawable uRLDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        this.f356458c = System.currentTimeMillis();
        int i3 = 5;
        if (list.size() < 5) {
            i3 = list.size();
        }
        this.f356456a.clear();
        this.f356457b = false;
        for (int i16 = 0; i16 < i3; i16++) {
            g gVar = list.get(i16);
            if (gVar != null && (uRLDrawable = gVar.getURLDrawable(gVar.getProtocolURL(), i(gVar))) != null) {
                if ((gVar instanceof o) && ((o) gVar).k() == 3) {
                    this.f356457b = true;
                } else {
                    uRLDrawable.setURLDrawableListener(this.f356462g);
                    if (uRLDrawable.getStatus() != 1) {
                        this.f356456a.add(uRLDrawable);
                        uRLDrawable.addHeader("my_uin", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
                        uRLDrawable.addHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_NEED_BIG, "true");
                        uRLDrawable.startDownload();
                    } else {
                        this.f356457b = true;
                    }
                }
            }
        }
        b bVar = this.f356461f;
        if (bVar != null) {
            bVar.a(this.f356457b);
        }
    }

    public void l(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f356461f = bVar;
        }
    }
}
