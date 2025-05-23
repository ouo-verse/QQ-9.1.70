package com.qzone.album.business.photolist.ui;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.common.account.LoginData;
import com.qzone.util.ar;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes39.dex */
public class QZonePhotoListVipBar {

    /* renamed from: a, reason: collision with root package name */
    private BasePhotoModelController f43286a;

    /* renamed from: b, reason: collision with root package name */
    private ViewStub f43287b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f43288c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f43289d;

    /* renamed from: e, reason: collision with root package name */
    private View f43290e;

    /* renamed from: f, reason: collision with root package name */
    private r5.b f43291f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ r5.a f43295d;

        a(r5.a aVar) {
            this.f43295d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePhotoListVipBar.this.f43288c.setVisibility(8);
            u4.a.z().Y(QZonePhotoListVipBar.this.f43286a.q2(), QZonePhotoListVipBar.this.f43286a.k(), QZonePhotoListVipBar.this.f43286a.q2().getString(R.string.gia));
            if (QZonePhotoListVipBar.this.f43286a.k3()) {
                r5.b.F().J(LoginData.getInstance().getUin(), 6, 2, this.f43295d.f430741a);
            } else {
                r5.b.F().J(LoginData.getInstance().getUin(), 2, 2, this.f43295d.f430741a);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ r5.a f43297d;

        b(r5.a aVar) {
            this.f43297d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePhotoListVipBar.this.f43286a.k3()) {
                r5.b.F().D(LoginData.getInstance().getUin(), 6, 1, this.f43297d.f430741a);
            } else {
                r5.b.F().D(LoginData.getInstance().getUin(), 2, 1, this.f43297d.f430741a);
            }
            QZonePhotoListVipBar.this.f43288c.setVisibility(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZonePhotoListVipBar(BasePhotoModelController basePhotoModelController) {
        this.f43286a = basePhotoModelController;
        e();
    }

    private void e() {
        if (this.f43291f == null) {
            this.f43291f = r5.b.F();
        }
        if (this.f43286a.k3()) {
            this.f43291f.H(6, 3);
        } else {
            this.f43291f.H(2, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3, int i16) {
        int l3 = ar.l();
        int i17 = (i3 * l3) / i16;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l3, i17);
        ImageView imageView = this.f43289d;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout = this.f43288c;
            if (relativeLayout != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.height = i17;
                if (!this.f43286a.k3()) {
                    layoutParams2.bottomMargin = ar.e(56.0f);
                }
                this.f43288c.setLayoutParams(layoutParams2);
                this.f43288c.setVisibility(0);
            }
        }
    }

    public void f(r5.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f430742b)) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.f43286a.q2().findViewById(R.id.flo);
        this.f43287b = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.f43288c = (RelativeLayout) this.f43286a.q2().findViewById(R.id.f166470fe2);
        this.f43289d = (ImageView) this.f43286a.q2().findViewById(R.id.gjx);
        this.f43290e = this.f43286a.q2().findViewById(R.id.gjw);
        ImageView imageView = this.f43289d;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f43289d.setVisibility(8);
            Drawable loadImage = ImageLoader.getInstance().loadImage(aVar.f430742b, new ImageLoader.ImageLoadListener() { // from class: com.qzone.album.business.photolist.ui.QZonePhotoListVipBar.1
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    QZonePhotoListVipBar.this.f43289d.post(new Runnable() { // from class: com.qzone.album.business.photolist.ui.QZonePhotoListVipBar.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZonePhotoListVipBar.this.f43289d.setImageDrawable(drawable);
                            int intrinsicHeight = drawable.getIntrinsicHeight();
                            int intrinsicWidth = drawable.getIntrinsicWidth();
                            QZonePhotoListVipBar.this.f43289d.setVisibility(0);
                            QZonePhotoListVipBar.this.g(intrinsicHeight, intrinsicWidth);
                        }
                    });
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                }
            });
            if (loadImage != null) {
                this.f43289d.setImageDrawable(loadImage);
                int intrinsicHeight = loadImage.getIntrinsicHeight();
                int intrinsicWidth = loadImage.getIntrinsicWidth();
                this.f43289d.setVisibility(0);
                g(intrinsicHeight, intrinsicWidth);
            }
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(aVar.f430741a, LoginData.getInstance().getUinString());
            this.f43289d.setOnClickListener(new a(aVar));
        }
        View view = this.f43290e;
        if (view != null) {
            view.setOnClickListener(new b(aVar));
        }
    }
}
