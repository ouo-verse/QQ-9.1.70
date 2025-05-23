package com.qzone.component.banner;

import TianShuJce.AdItem;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.util.ak;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.lang.ref.WeakReference;
import java.util.Map;
import yo.g;

/* loaded from: classes39.dex */
public class QZoneFeedPublishMoodBanner extends Banner {
    private ImageView C;
    private TextView D;
    private TextView E;
    private ImageView F;
    private QZoneDownloadPhotoRunnableImpl G;
    private boolean H;
    private AdItem I;

    /* renamed from: h, reason: collision with root package name */
    private Context f46469h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f46470i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f46471m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class QZoneDownloadPhotoRunnableImpl implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QZoneFeedPublishMoodBanner> f46472d;

        /* renamed from: e, reason: collision with root package name */
        private Drawable f46473e;

        public QZoneDownloadPhotoRunnableImpl(QZoneFeedPublishMoodBanner qZoneFeedPublishMoodBanner) {
            this.f46472d = new WeakReference<>(qZoneFeedPublishMoodBanner);
        }

        public void a(Drawable drawable) {
            this.f46473e = drawable;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<QZoneFeedPublishMoodBanner> weakReference = this.f46472d;
            QZoneFeedPublishMoodBanner qZoneFeedPublishMoodBanner = weakReference == null ? null : weakReference.get();
            ImageView x16 = qZoneFeedPublishMoodBanner != null ? qZoneFeedPublishMoodBanner.x() : null;
            if (this.f46473e == null || x16 == null) {
                return;
            }
            x16.setVisibility(0);
            x16.setImageDrawable(this.f46473e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneFeedPublishMoodBanner.this.I != null && QZoneFeedPublishMoodBanner.this.I.argList != null) {
                yo.d.b(QZoneFeedPublishMoodBanner.this.getContext(), new g(QZoneFeedPublishMoodBanner.this.I.argList.get("url")));
                ak.f(QZoneFeedPublishMoodBanner.this.I, 102);
                QZoneFeedPublishMoodBanner.this.B();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFeedPublishMoodBanner.this.g();
            QZoneFeedPublishMoodBanner.this.H = true;
            QZoneFeedPublishMoodBanner.this.C();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneFeedPublishMoodBanner(Context context) {
        super(context);
        this.H = false;
        this.f46469h = context;
    }

    private void A() {
        TextView textView;
        AdItem adItem = this.I;
        if (adItem != null && E(adItem)) {
            Map<String, String> map = this.I.argList;
            String str = map.get("word");
            String str2 = map.get("pic");
            if (this.G == null) {
                this.G = new QZoneDownloadPhotoRunnableImpl(this);
            }
            if (!TextUtils.isEmpty(str) && (textView = this.D) != null) {
                textView.setText(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                z(str2);
            }
            FrameLayout frameLayout = this.f46470i;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                ak.f(this.I, 101);
                D();
                return;
            }
            return;
        }
        QLog.e("QZoneFeedPublishMoodBanner", 1, "banner show fail: data is invalid");
    }

    private void y() {
        FrameLayout frameLayout = this.f46470i;
        if (frameLayout == null || this.f46469h == null) {
            return;
        }
        this.f46297e = true;
        this.f46471m = (FrameLayout) frameLayout.findViewById(R.id.f68443g2);
        this.F = (ImageView) this.f46470i.findViewById(R.id.f68453g3);
        this.D = (TextView) this.f46470i.findViewById(R.id.f68463g4);
        TextView textView = (TextView) this.f46470i.findViewById(R.id.f68433g1);
        this.E = textView;
        textView.setOnClickListener(new a());
        ImageView imageView = (ImageView) this.f46470i.findViewById(R.id.f68473g5);
        this.C = imageView;
        imageView.setOnClickListener(new b());
        if (QQTheme.isNowThemeIsNightForQzone()) {
            this.f46471m.setBackgroundResource(R.drawable.ldj);
        } else {
            this.f46471m.setBackgroundResource(R.drawable.ldi);
        }
        this.f46470i.setVisibility(8);
    }

    private void z(String str) {
        ImageLoader.getInstance().loadImageAsync(str, new c());
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 10;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 28;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        QLog.d("QZoneFeedPublishMoodBanner", 1, "internal_show fail, needShow: " + z16 + ", mContainer: " + this.f46470i + ", isBannerInitialized: " + this.f46297e + ", mIsBannerClosed: " + this.H);
        FrameLayout frameLayout = this.f46470i;
        if (frameLayout == null || !this.f46297e || this.H) {
            return;
        }
        if (z16) {
            this.f46298f = false;
            A();
        } else {
            frameLayout.setVisibility(8);
            if (this.G != null) {
                QzoneHandlerThreadFactory.getMainHandler().removeCallbacks(this.G);
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        FrameLayout frameLayout;
        return this.f46297e && (frameLayout = this.f46470i) != null && frameLayout.getVisibility() == 0;
    }

    public ImageView x() {
        return this.F;
    }

    private boolean E(AdItem adItem) {
        Map<String, String> map;
        if (adItem != null && (map = adItem.argList) != null) {
            String str = map.get("word");
            String str2 = map.get("pic");
            QLog.d("QZoneFeedPublishMoodBanner", 2, "banner validData: description: " + str + ", picUrl: " + str2);
            return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
        }
        QLog.d("QZoneFeedPublishMoodBanner", 2, "banner validData: adItem is null");
        return false;
    }

    protected void B() {
        LpReportInfo_pf00064.allReport(150, 2, 2);
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        if (inflate instanceof FrameLayout) {
            this.f46470i = (FrameLayout) inflate;
            y();
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        if (aVar != null && aVar.f47123g != null) {
            this.I = com.qzone.component.banner.util.b.a(aVar);
            this.f46298f = true;
            c();
        } else {
            QLog.w("QZoneFeedPublishMoodBanner", 1, "updateBannerData fail: " + aVar);
        }
    }

    protected void C() {
        LpReportInfo_pf00064.allReport(150, 2, 3);
    }

    protected void D() {
        LpReportInfo_pf00064.allReport(150, 2, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements ImageLoader.ImageLoadListener {
        c() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            QLog.e("QZoneFeedPublishMoodBanner", 1, "[onImageFailed] s = " + str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QLog.i("QZoneFeedPublishMoodBanner", 1, "[onImageLoaded] s = " + str);
            if (QZoneFeedPublishMoodBanner.this.G == null) {
                QLog.e("QZoneFeedPublishMoodBanner", 1, "[onImageLoaded] downloadRunnable is null");
            } else {
                QZoneFeedPublishMoodBanner.this.G.a(drawable);
                QzoneHandlerThreadFactory.getMainHandler().post(QZoneFeedPublishMoodBanner.this.G);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
