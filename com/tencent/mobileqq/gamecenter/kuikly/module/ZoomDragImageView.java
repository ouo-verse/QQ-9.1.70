package com.tencent.mobileqq.gamecenter.kuikly.module;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.matrix.OnScaleBeginListener;
import com.tencent.richframework.widget.matrix.OnScaleEndListener;
import com.tencent.richframework.widget.matrix.RFWMatrixImageView;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001'B\u0011\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R;\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014j\u0004\u0018\u0001`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR;\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014j\u0004\u0018\u0001`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/module/ZoomDragImageView;", "Lcom/tencent/richframework/widget/matrix/RFWMatrixImageView;", "Li01/c;", "Lcom/tencent/richframework/widget/matrix/OnScaleBeginListener;", "Lcom/tencent/richframework/widget/matrix/OnScaleEndListener;", "", "propKey", "", "propValue", "", "b", "url", "", "setUrl", "", "scaleFactor", "onScaleBegin", "onScaleEnd", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onScaleBeginCallback", "D", "onScaleEndCallback", "Lcom/tencent/image/URLDrawable;", "E", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ZoomDragImageView extends RFWMatrixImageView implements i01.c, OnScaleBeginListener, OnScaleEndListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> onScaleBeginCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> onScaleEndCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private URLDrawable urlDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String url;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/gamecenter/kuikly/module/ZoomDragImageView$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            QLog.d("QQKuiklyPictureView", 2, "[onLoadCanceled]");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            QLog.d("QQKuiklyPictureView", 2, "[onLoadFialed]");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            QLog.d("QQKuiklyPictureView", 2, "[onLoadCanceled]");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            if (drawable == null) {
                return;
            }
            QLog.d("QQKuiklyPictureView", 2, "[onLoadSuccessed] imgWidth:" + drawable.getIntrinsicWidth() + " , imgHeight:" + drawable.getIntrinsicHeight());
            ZoomDragImageView.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ZoomDragImageView zoomDragImageView = ZoomDragImageView.this;
            zoomDragImageView.setImageDrawable(zoomDragImageView.urlDrawable);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZoomDragImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.url = "";
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setOnScaleBeginListener(this);
        setOnScaleEndListener(this);
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        Function1<Object, Unit> function1 = null;
        switch (propKey.hashCode()) {
            case 116079:
                if (propKey.equals("url")) {
                    setUrl(propValue.toString());
                    return true;
                }
                break;
            case 146211168:
                if (propKey.equals("onBeginScale")) {
                    if (TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        function1 = (Function1) propValue;
                    }
                    this.onScaleBeginCallback = function1;
                    return true;
                }
                break;
            case 188941358:
                if (propKey.equals("onEndScale")) {
                    if (TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        function1 = (Function1) propValue;
                    }
                    this.onScaleEndCallback = function1;
                    return true;
                }
                break;
            case 715339530:
                if (propKey.equals("maximumScale")) {
                    setMaximumScale(com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return true;
                }
                break;
            case 1189765596:
                if (propKey.equals("minimumScale")) {
                    setMinimumScale(com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return true;
                }
                break;
            case 1641242935:
                if (propKey.equals("zoomScale")) {
                    setScale(com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return true;
                }
                break;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // com.tencent.richframework.widget.matrix.OnScaleBeginListener
    public void onScaleBegin(float scaleFactor) {
        Function1<Object, Unit> function1 = this.onScaleBeginCallback;
        if (function1 != null) {
            function1.invoke(Float.valueOf(scaleFactor));
        }
    }

    @Override // com.tencent.richframework.widget.matrix.OnScaleEndListener
    public void onScaleEnd(float scaleFactor) {
        Function1<Object, Unit> function1 = this.onScaleEndCallback;
        if (function1 != null) {
            function1.invoke(Float.valueOf(scaleFactor));
        }
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    public final void setUrl(@Nullable String url) {
        Integer num;
        this.url = url;
        if (url != null) {
            URLDrawable drawable = URLDrawable.getDrawable(url);
            this.urlDrawable = drawable;
            if (drawable != null) {
                num = Integer.valueOf(drawable.getStatus());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                QLog.d("QQKuiklyPictureView", 2, "[setUrl] drawable already exist.");
            } else if ((num == null || num.intValue() != 2) && (num == null || num.intValue() != 3)) {
                URLDrawable uRLDrawable = this.urlDrawable;
                if (uRLDrawable != null) {
                    uRLDrawable.setURLDrawableListener(new b());
                }
                URLDrawable uRLDrawable2 = this.urlDrawable;
                if (uRLDrawable2 != null) {
                    uRLDrawable2.startDownload();
                }
            }
            setScaleType(ImageView.ScaleType.FIT_CENTER);
            setImageDrawable(this.urlDrawable);
        }
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }
}
