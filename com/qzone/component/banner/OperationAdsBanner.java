package com.qzone.component.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.qzone.widget.AsynAutoGifImageView;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.qzone.widget.FeedImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.HashSet;
import yo.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class OperationAdsBanner extends Banner {
    public boolean C;
    public boolean D;
    private HashSet<String> E;
    private float F;
    private com.qzone.feed.business.model.a G;
    private View.OnClickListener H;
    private AsyncImageable.AsyncImageListener I;
    private AutoGifDrawable.GifDownloadCallBackListener J;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f46437h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f46438i;

    /* renamed from: m, reason: collision with root package name */
    private AsynAutoGifImageView f46439m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OperationAdsBanner operationAdsBanner = OperationAdsBanner.this;
            if (operationAdsBanner.f46297e && operationAdsBanner.G != null) {
                OperationAdsBanner.this.g();
                OperationAdsBanner.this.f46439m.f60157f = null;
                OperationAdsBanner.this.C = true;
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClose(OperationAdsBanner.this.G.f47123g.strTraceInfo, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements AsynAutoGifImageView.a {
        d() {
        }

        @Override // com.qzone.widget.AsynAutoGifImageView.a
        public boolean isListViewScrollIdle() {
            return true;
        }
    }

    public OperationAdsBanner(Context context) {
        super(context);
        this.D = true;
        this.E = new HashSet<>();
        this.F = 0.0f;
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 700;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 5;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        com.qzone.feed.business.model.a aVar;
        if (this.f46297e) {
            AsynAutoGifImageView asynAutoGifImageView = this.f46439m;
            if (asynAutoGifImageView != null && z16 && asynAutoGifImageView.getDrawable() == null && this.f46439m.f() == null) {
                QZLog.w("BUG_NULL_BANNER_BG", "OperationAdsBanner image uninitialized.");
                return;
            }
            this.f46437h.setVisibility(z16 ? 0 : 8);
            if (z16) {
                this.f46298f = false;
                if (!(getContext() instanceof QZoneFriendFeedXActivity) || (aVar = this.G) == null || aVar.f47123g == null) {
                    return;
                }
                if (this.D) {
                    if (aVar != null && !aVar.f47133q) {
                        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.G.f47123g.strTraceInfo, null);
                        com.qzone.component.banner.util.a.d(e(), false, this.G.f47123g.iAdID);
                        this.G.f47133q = true;
                        QZLog.d("OperationAdsBanner", 1, "just exposed:" + this.G.f47123g.strTraceInfo);
                        return;
                    }
                    QZLog.w("OperationAdsBanner", "has already exposed:" + this.G.f47123g.strTraceInfo);
                    return;
                }
                this.D = true;
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && this.f46437h.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.C = true;
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(this.G.f47123g.strTraceInfo, null);
        HashMap hashMap = new HashMap();
        hashMap.put("key1", "adbanner");
        if (QZLog.isDevelopLevel()) {
            QZLog.d("OperationAdsBanner", 4, "----jump url:" + this.G.f47123g.strJmpUrl);
            QZLog.d("OperationAdsBanner", 4, "----schemeUrl url:" + this.G.f47123g.schemeUrl);
        }
        g gVar = new g(this.G.f47123g.schemeUrl);
        gVar.f450709b = this.G.f47123g.strJmpUrl;
        gVar.f450714g = hashMap;
        yo.d.b(getContext(), gVar);
        com.qzone.component.banner.util.a.b(e(), 0, true, String.valueOf(this.G.f47123g.iAdID), true);
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        BusinessADBannerData businessADBannerData;
        if (aVar == null || (businessADBannerData = aVar.f47123g) == null || !this.f46297e) {
            return;
        }
        this.G = aVar;
        if (businessADBannerData.hasCloseButton) {
            ImageView imageView = this.f46438i;
            if (imageView != null) {
                imageView.setOnClickListener(this.H);
            }
            this.f46298f = true;
        }
        String str = aVar.f47123g.strPicUrl;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("gif")) {
            this.f46439m.setLayerType(1, null);
            this.f46439m.setAdjustViewBounds(false);
            String str2 = this.f46439m.f60157f;
            if (str2 != null && str2.equals(str)) {
                c();
            } else {
                this.f46439m.setAsynGifImage(str, new d(), this.J);
            }
            this.f46439m.h();
            return;
        }
        FeedImageView feedImageView = new FeedImageView(getContext());
        feedImageView.setAsyncImageListener(this.I);
        feedImageView.setAsyncImage(aVar.f47123g.strPicUrl);
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewStub.inflate();
        this.f46437h = frameLayout;
        if (frameLayout == null) {
            return;
        }
        this.f46439m = (AsynAutoGifImageView) frameLayout.findViewById(R.id.fek);
        this.f46438i = (ImageView) this.f46437h.findViewById(R.id.feb);
        this.H = new a();
        this.I = new b();
        this.J = new c();
        this.F = ViewUtils.getDensity();
        if (this.f46439m == null || this.f46438i == null) {
            return;
        }
        this.f46437h.setVisibility(8);
        this.f46297e = true;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements AsyncImageable.AsyncImageListener {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                OperationAdsBanner.this.C = true;
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(OperationAdsBanner.this.G.f47123g.strTraceInfo, null);
                HashMap hashMap = new HashMap();
                hashMap.put("key1", "adbanner");
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("OperationAdsBanner", 4, "----jump url:" + OperationAdsBanner.this.G.f47123g.strJmpUrl);
                    QZLog.d("OperationAdsBanner", 4, "----schemeUrl url:" + OperationAdsBanner.this.G.f47123g.schemeUrl);
                }
                g gVar = new g(OperationAdsBanner.this.G.f47123g.schemeUrl);
                gVar.f450709b = OperationAdsBanner.this.G.f47123g.strJmpUrl;
                gVar.f450714g = hashMap;
                yo.d.b(OperationAdsBanner.this.getContext(), gVar);
                com.qzone.component.banner.util.a.b(OperationAdsBanner.this.e(), 0, true, String.valueOf(OperationAdsBanner.this.G.f47123g.iAdID), true);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        b() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            Drawable drawable;
            if (OperationAdsBanner.this.G == null || !OperationAdsBanner.this.f46297e || (drawable = ((AsyncImageView) asyncImageable).getDrawable()) == null) {
                return;
            }
            int d16 = u5.a.d();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth != 0) {
                int i3 = (int) ((d16 * intrinsicHeight) / intrinsicWidth);
                ViewGroup.LayoutParams layoutParams = OperationAdsBanner.this.f46439m.getLayoutParams();
                layoutParams.width = d16;
                layoutParams.height = i3;
                OperationAdsBanner.this.f46439m.setLayoutParams(layoutParams);
                OperationAdsBanner.this.f46437h.setPadding(0, (int) (OperationAdsBanner.this.F * 15.0f), 0, (int) (OperationAdsBanner.this.F * 1.0f));
                drawable.setBounds(0, 0, d16, i3);
            }
            OperationAdsBanner.this.f46439m.setVisibility(0);
            OperationAdsBanner.this.f46439m.setImageDrawable(drawable);
            OperationAdsBanner.this.f46439m.setOnClickListener(new a());
            OperationAdsBanner.this.c();
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements AutoGifDrawable.GifDownloadCallBackListener {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                OperationAdsBanner.this.z();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        c() {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (OperationAdsBanner.this.G == null || !OperationAdsBanner.this.f46297e || drawable == null) {
                return;
            }
            int d16 = u5.a.d();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth != 0) {
                int i3 = (int) ((d16 * intrinsicHeight) / intrinsicWidth);
                ViewGroup.LayoutParams layoutParams = OperationAdsBanner.this.f46439m.getLayoutParams();
                layoutParams.width = d16;
                layoutParams.height = i3;
                OperationAdsBanner.this.f46439m.setLayoutParams(layoutParams);
                OperationAdsBanner.this.f46437h.setPadding(0, (int) (OperationAdsBanner.this.F * 15.0f), 0, (int) (OperationAdsBanner.this.F * 1.0f));
                drawable.setBounds(0, 0, d16, i3);
            }
            OperationAdsBanner.this.f46439m.setOnClickListener(new a());
            OperationAdsBanner.this.c();
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
