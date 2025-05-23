package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.kuikly.core.render.android.expand.component.blur.l;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.n;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0003?@\u0014B\u000f\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0010\u001a\u0004\u0018\u00010\f*\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0003H\u0014J\b\u0010\u0019\u001a\u00020\u0003H\u0014R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001bR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\"R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00108\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Li01/c;", "", "V", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "T", "", "coverUrl", "U", "Landroid/graphics/drawable/BitmapDrawable;", "bitmapDrawable", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/image/URLDrawable;", "W", "propKey", "", "propValue", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "H", "Ljava/lang/String;", "tag", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView$b;", "I", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView$b;", "mSourceVideoViewInfo", "", "J", "mTargetViewNativeRef", "K", "mCoverUrl", "", "L", UserInfo.SEX_FEMALE, "mBlurRadius", "", "M", "mRefreshInterval", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/n;", "N", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/n;", "mBlurHelper", "Landroid/os/Handler;", "Landroid/os/Handler;", "mUiHandler", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView$SafeRefreshTask;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView$SafeRefreshTask;", "mRefreshTask", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "mCoverImageBlurDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", ExifInterface.LATITUDE_SOUTH, "a", "SafeRefreshTask", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyVideoBlurView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private final String tag;

    /* renamed from: I, reason: from kotlin metadata */
    private b mSourceVideoViewInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private int mTargetViewNativeRef;

    /* renamed from: K, reason: from kotlin metadata */
    private String mCoverUrl;

    /* renamed from: L, reason: from kotlin metadata */
    private float mBlurRadius;

    /* renamed from: M, reason: from kotlin metadata */
    private long mRefreshInterval;

    /* renamed from: N, reason: from kotlin metadata */
    private n mBlurHelper;

    /* renamed from: P, reason: from kotlin metadata */
    private final Handler mUiHandler;

    /* renamed from: Q, reason: from kotlin metadata */
    private final SafeRefreshTask mRefreshTask;

    /* renamed from: R, reason: from kotlin metadata */
    private volatile Drawable mCoverImageBlurDrawable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView$SafeRefreshTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView;", "d", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "blurViewRef", "view", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class SafeRefreshTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.qqnt.avatar.meta.refresh.c<QQKuiklyVideoBlurView> blurViewRef;

        public SafeRefreshTask(QQKuiklyVideoBlurView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.blurViewRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(view);
        }

        @Override // java.lang.Runnable
        public void run() {
            QQKuiklyVideoBlurView qQKuiklyVideoBlurView = this.blurViewRef.get();
            if (qQKuiklyVideoBlurView != null) {
                qQKuiklyVideoBlurView.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView$b;", "", "", "b", "Landroid/view/View;", "a", "", "d", "c", "", "I", "nativeViewRef", "Lcom/tencent/kuikly/core/render/android/a;", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyContext", "", "Ljava/lang/String;", "logTag", "Landroid/view/View;", "videoView", "Lcom/tencent/mobileqq/qqecommerce/base/video/e;", "e", "Lcom/tencent/mobileqq/qqecommerce/base/video/e;", "videoStateProvider", "<init>", "(ILcom/tencent/kuikly/core/render/android/a;Ljava/lang/String;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int nativeViewRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.kuikly.core.render.android.a kuiklyContext;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String logTag;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private View videoView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private com.tencent.mobileqq.qqecommerce.base.video.e videoStateProvider;

        public b(int i3, com.tencent.kuikly.core.render.android.a aVar, String logTag) {
            Intrinsics.checkNotNullParameter(logTag, "logTag");
            this.nativeViewRef = i3;
            this.kuiklyContext = aVar;
            this.logTag = logTag;
        }

        private final void b() {
            if (this.videoView != null) {
                return;
            }
            com.tencent.kuikly.core.render.android.a aVar = this.kuiklyContext;
            View b16 = aVar != null ? aVar.b(this.nativeViewRef) : null;
            if (b16 instanceof com.tencent.mobileqq.qqecommerce.base.video.e) {
                this.videoView = b16;
                this.videoStateProvider = (com.tencent.mobileqq.qqecommerce.base.video.e) b16;
            }
            QLog.d(this.logTag, 1, "initVideoView: view=" + b16);
        }

        public final View a() {
            b();
            return this.videoView;
        }

        public final boolean c() {
            com.tencent.mobileqq.qqecommerce.base.video.e eVar;
            return d() && (eVar = this.videoStateProvider) != null && eVar.d();
        }

        public final boolean d() {
            b();
            com.tencent.mobileqq.qqecommerce.base.video.e eVar = this.videoStateProvider;
            return eVar != null && eVar.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyVideoBlurView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "QQKuiklyVideoBlurView[" + hashCode() + "]";
        this.tag = str;
        this.mTargetViewNativeRef = -1;
        this.mBlurRadius = 10.0f;
        this.mRefreshInterval = 1000L;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mRefreshTask = new SafeRefreshTask(this);
        QLog.d(str, 1, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        if (T()) {
            this.mBlurHelper = new n();
        }
    }

    private final void P() {
        this.mUiHandler.removeCallbacks(this.mRefreshTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        if (T()) {
            b bVar = this.mSourceVideoViewInfo;
            boolean z16 = false;
            if (bVar != null && bVar.c()) {
                z16 = true;
            }
            if (z16) {
                invalidate();
            }
        }
        this.mUiHandler.postDelayed(this.mRefreshTask, this.mRefreshInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(final BitmapDrawable bitmapDrawable) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.j
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyVideoBlurView.S(QQKuiklyVideoBlurView.this, bitmapDrawable);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(QQKuiklyVideoBlurView this$0, BitmapDrawable bitmapDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmapDrawable, "$bitmapDrawable");
        l.Companion companion = l.INSTANCE;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this$0.mCoverImageBlurDrawable = companion.a(bitmapDrawable, context, this$0.mBlurRadius);
        this$0.postInvalidate();
    }

    private final boolean T() {
        return Build.VERSION.SDK_INT >= 31;
    }

    private final void U(String coverUrl) {
        QLog.d(this.tag, 1, "loadCoverImage: coverUrl: " + coverUrl);
        URLDrawable urlDrawable = URLDrawable.getDrawable(coverUrl, URLDrawable.URLDrawableOptions.obtain());
        if (urlDrawable.getStatus() == 1) {
            Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
            BitmapDrawable W = W(urlDrawable);
            if (W != null) {
                R(W);
                return;
            }
        }
        urlDrawable.setURLDrawableListener(new c(urlDrawable, new com.tencent.qqnt.avatar.meta.refresh.c(this)));
        urlDrawable.startDownload();
    }

    private final void V() {
        this.mUiHandler.removeCallbacks(this.mRefreshTask);
        this.mUiHandler.postDelayed(this.mRefreshTask, this.mRefreshInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BitmapDrawable W(URLDrawable uRLDrawable) {
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable instanceof RegionDrawable) {
            return new BitmapDrawable(getResources(), ((RegionDrawable) currDrawable).getBitmap());
        }
        if (currDrawable instanceof BitmapDrawable) {
            return (BitmapDrawable) currDrawable;
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        QLog.i(this.tag, 1, "setProp propKey=" + propKey + ", propValue=" + propValue);
        switch (propKey.hashCode()) {
            case -1428201511:
                if (propKey.equals("blurRadius")) {
                    this.mBlurRadius = ((Float) propValue).floatValue();
                    return true;
                }
                break;
            case -1387368869:
                if (propKey.equals("refreshRate")) {
                    this.mRefreshInterval = 1000 / Math.min(((Integer) propValue).intValue(), 1);
                    return true;
                }
                break;
            case -618653741:
                if (propKey.equals("videoCoverUrl")) {
                    String str = (String) propValue;
                    if (!TextUtils.equals(str, this.mCoverUrl)) {
                        this.mCoverUrl = str;
                        U(str);
                    }
                    return true;
                }
                break;
            case 111908127:
                if (propKey.equals("targetBlurViewNativeRef")) {
                    int intValue = ((Integer) propValue).intValue();
                    this.mTargetViewNativeRef = intValue;
                    this.mSourceVideoViewInfo = new b(intValue, get_kuiklyRenderContext(), this.tag);
                    return true;
                }
                break;
        }
        return super.b(propKey, propValue);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d(this.tag, 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        V();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d(this.tag, 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        P();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z16;
        Drawable drawable;
        b bVar;
        View a16;
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        if (T() && canvas.isHardwareAccelerated() && (bVar = this.mSourceVideoViewInfo) != null && (a16 = bVar.a()) != null && bVar.d()) {
            n nVar = this.mBlurHelper;
            if (nVar != null) {
                nVar.b(a16, getWidth(), getHeight(), this.mBlurRadius);
            }
            n nVar2 = this.mBlurHelper;
            if (nVar2 != null) {
                nVar2.a(canvas);
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (drawable = this.mCoverImageBlurDrawable) == null) {
            return;
        }
        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.draw(canvas);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoBlurView$c", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements URLDrawable.URLDrawableListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f263151e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.avatar.meta.refresh.c<QQKuiklyVideoBlurView> f263152f;

        c(URLDrawable uRLDrawable, com.tencent.qqnt.avatar.meta.refresh.c<QQKuiklyVideoBlurView> cVar) {
            this.f263151e = uRLDrawable;
            this.f263152f = cVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
            QLog.w(QQKuiklyVideoBlurView.this.tag, 1, "loadCoverImage: onLoadCanceled");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            QLog.w(QQKuiklyVideoBlurView.this.tag, 1, "loadCoverImage: failed: " + cause);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            QQKuiklyVideoBlurView qQKuiklyVideoBlurView;
            QQKuiklyVideoBlurView qQKuiklyVideoBlurView2 = QQKuiklyVideoBlurView.this;
            URLDrawable urlDrawable = this.f263151e;
            Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
            BitmapDrawable W = qQKuiklyVideoBlurView2.W(urlDrawable);
            QLog.d(QQKuiklyVideoBlurView.this.tag, 1, "loadCoverImage: success");
            if (W == null || (qQKuiklyVideoBlurView = this.f263152f.get()) == null) {
                return;
            }
            qQKuiklyVideoBlurView.R(W);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
        }
    }
}
