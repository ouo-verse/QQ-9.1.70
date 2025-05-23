package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.kandian.base.utils.api.IImageUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016JF\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/pts/util/g;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/DrawableUtil$DrawableHelper;", "Landroid/content/Context;", "context", "", "path", "Landroid/graphics/drawable/Drawable;", ToastView.ICON_LOADING, "failed", "getDrawable", "", "width", "height", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/DrawableUtil$DrawableCallBack;", "drawableCallBack", "getDrawableFromNet", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g implements DrawableUtil.DrawableHelper {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/kandian/biz/pts/util/g$a", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Drawable;", "who", "", "invalidateDrawable", "Ljava/lang/Runnable;", "what", "", RemoteMessageConst.Notification.WHEN, "scheduleDrawable", "unscheduleDrawable", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements Drawable.Callback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DrawableUtil.DrawableCallBack f239404d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f239405e;

        a(DrawableUtil.DrawableCallBack drawableCallBack, URLDrawable uRLDrawable) {
            this.f239404d = drawableCallBack;
            this.f239405e = uRLDrawable;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NotNull Drawable who) {
            Intrinsics.checkNotNullParameter(who, "who");
            QLog.i(LogTag.TAG_READINJOY_PROTEUS, 1, "invalidateDrawable: ");
            this.f239404d.onCallBack(true, this.f239405e);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long when) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/kandian/biz/pts/util/g$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "d", "I", "getReTry", "()I", "setReTry", "(I)V", "reTry", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int reTry;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f239407e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DrawableUtil.DrawableCallBack f239408f;

        b(String str, DrawableUtil.DrawableCallBack drawableCallBack) {
            this.f239407e = str;
            this.f239408f = drawableCallBack;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable drawable, @NotNull Throwable cause) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            Intrinsics.checkNotNullParameter(cause, "cause");
            int i3 = this.reTry;
            this.reTry = i3 + 1;
            if (i3 < 3) {
                drawable.restartDownload();
            } else {
                this.f239408f.onCallBack(false, drawable);
            }
            QLog.i(LogTag.TAG_READINJOY_PROTEUS, 1, "getDrawable: onFileDownloadFailed :" + this.f239407e + "  reTry: " + this.reTry);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable drawable, int progress) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            QLog.i(LogTag.TAG_READINJOY_PROTEUS, 1, "getDrawable: onLoadSuccessed :" + this.f239407e);
            this.f239408f.onCallBack(true, drawable);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/kandian/biz/pts/util/g$c", "Lcom/tencent/image/URLDrawable$DownloadListener;", "", "onFileDownloadStarted", "", "l", "onFileDownloadSucceed", "", "errorCode", "onFileDownloadFailed", "d", "I", "getReTry", "()I", "setReTry", "(I)V", "reTry", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements URLDrawable.DownloadListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int reTry;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f239410e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DrawableUtil.DrawableCallBack f239411f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ URLDrawable f239412h;

        c(String str, DrawableUtil.DrawableCallBack drawableCallBack, URLDrawable uRLDrawable) {
            this.f239410e = str;
            this.f239411f = drawableCallBack;
            this.f239412h = uRLDrawable;
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int errorCode) {
            int i3 = this.reTry;
            this.reTry = i3 + 1;
            if (i3 < 3) {
                this.f239412h.restartDownload();
            } else {
                this.f239411f.onCallBack(false, this.f239412h);
            }
            QLog.i(LogTag.TAG_READINJOY_PROTEUS, 1, "getDrawable: onFileDownloadFailed :" + this.f239410e + "  reTry: " + this.reTry);
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
            QLog.i(LogTag.TAG_READINJOY_PROTEUS, 1, "getDrawable: onFileDownloadStarted :" + this.f239410e);
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long l3) {
            QLog.i(LogTag.TAG_READINJOY_PROTEUS, 1, "getDrawable: onFileDownloadSucceed :" + this.f239410e);
            this.f239411f.onCallBack(true, this.f239412h);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableHelper
    @Nullable
    public Drawable getDrawable(@NotNull Context context, @Nullable String path, @Nullable Drawable loading, @Nullable Drawable failed) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        if (path != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "http", false, 2, null);
            if (startsWith$default) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = loading;
                obtain.mFailedDrawable = failed;
                return URLDrawable.getDrawable(((IImageUtil) QRoute.api(IImageUtil.class)).getDrawableUrl(path), obtain);
            }
            Integer drawableResourceId = ImageCommon.getDrawableResourceId(path);
            if (drawableResourceId != null) {
                try {
                    return context.getResources().getDrawable(drawableResourceId.intValue());
                } catch (Exception e16) {
                    QLog.d(LogTag.TAG_READINJOY_PROTEUS, 2, "getDrawable: cant find in resources dir, do nothing");
                    QLog.e(LogTag.TAG_READINJOY_PROTEUS, 1, e16, new Object[0]);
                }
            }
            QLog.e(LogTag.TAG_READINJOY_PROTEUS, 2, "getDrawable: cant find path :" + path);
            return null;
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableHelper
    @Nullable
    public Drawable getDrawableFromNet(@NotNull Context context, @NotNull String path, @Nullable Drawable loading, @Nullable Drawable failed, int width, int height, @NotNull DrawableUtil.DrawableCallBack drawableCallBack) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(drawableCallBack, "drawableCallBack");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "http", false, 2, null);
        if (startsWith$default) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = loading;
            obtain.mFailedDrawable = failed;
            obtain.mRequestWidth = width;
            obtain.mRequestHeight = height;
            URLDrawable drawable = URLDrawable.getDrawable(((IImageUtil) QRoute.api(IImageUtil.class)).getDrawableUrl(path), obtain);
            drawable.setCallback(new a(drawableCallBack, drawable));
            drawable.setURLDrawableListener(new b(path, drawableCallBack));
            drawable.setDownloadListener(new c(path, drawableCallBack, drawable));
            QLog.i(LogTag.TAG_READINJOY_PROTEUS, 1, "getDrawable: :" + path);
            drawableCallBack.onCallBack(true, drawable);
            if (drawable.getStatus() != 1) {
                drawable.startDownload();
                QLog.i(LogTag.TAG_READINJOY_PROTEUS, 1, "getDrawable: :" + path + "  startDownload ");
            }
            return drawable;
        }
        return getDrawable(context, path, loading, failed);
    }
}
