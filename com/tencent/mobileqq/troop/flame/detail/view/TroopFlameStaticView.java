package com.tencent.mobileqq.troop.flame.detail.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001-B'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u000f\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameStaticView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/image/URLDrawable;", "drawable", "Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameStaticView$a;", "callback", "", "b", "Landroid/graphics/Bitmap;", "f", "bitmapCallback", "d", "", "I", "getLevel", "()I", "level", "e", "getNum", WidgetCacheConstellationData.NUM, "", "Z", "getNeedShowNumber", "()Z", "needShowNumber", "Landroid/view/ViewGroup;", h.F, "Landroid/view/ViewGroup;", "rootLayout", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "bgImageView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "numberTextView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/image/URLDrawable;", "c", "number", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;IIZ)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes19.dex */
public final class TroopFlameStaticView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private URLDrawable drawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int level;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int num;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean needShowNumber;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup rootLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView bgImageView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView numberTextView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameStaticView$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void a(@NotNull Bitmap bitmap);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/flame/detail/view/TroopFlameStaticView$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f296094e;

        b(a aVar) {
            this.f296094e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFlameStaticView.this, (Object) aVar);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, (Object) cause);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable, progress);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopFlameStaticView.this.b(drawable, this.f296094e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFlameStaticView(@NotNull Context context, int i3, int i16, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.level = i3;
        this.num = i16;
        this.needShowNumber = z16;
        LayoutInflater.from(context).inflate(R.layout.fzq, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.t6a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.bg_iv)");
        this.bgImageView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f783646v);
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        com.tencent.mobileqq.troop.flame.detail.view.b bVar = com.tencent.mobileqq.troop.flame.detail.view.b.f296107a;
        layoutParams.width = bVar.d(i3, c(), z16);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ViewGroup?>\u2026needShowNumber)\n        }");
        this.rootLayout = viewGroup;
        View findViewById3 = findViewById(R.id.zvw);
        TextView textView = (TextView) findViewById3;
        if (z16 && c() > 0) {
            textView.setText(String.valueOf(c()));
            Intrinsics.checkNotNullExpressionValue(textView, "this");
            bVar.f(textView);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView?>(\u2026)\n            }\n        }");
        this.numberTextView = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(URLDrawable drawable, a callback) {
        this.bgImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.bgImageView.setBackground(drawable);
        if (callback != null) {
            callback.a(f());
        }
    }

    private final int c() {
        return com.tencent.mobileqq.troop.flame.detail.view.b.f296107a.e(this.num);
    }

    public static /* synthetic */ void e(TroopFlameStaticView troopFlameStaticView, a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        troopFlameStaticView.d(aVar);
    }

    private final Bitmap f() {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    public final void d(@Nullable a bitmapCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmapCallback);
            return;
        }
        URLDrawable uRLDrawable = null;
        URLDrawable drawable = URLDrawable.getDrawable(com.tencent.mobileqq.troop.flame.detail.view.b.f296107a.a(this.level, c(), this.needShowNumber), (URLDrawable.URLDrawableOptions) null);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(TroopFlameVi\u2026r, needShowNumber), null)");
        this.drawable = drawable;
        if (drawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawable");
            drawable = null;
        }
        if (drawable.getStatus() == 1) {
            URLDrawable uRLDrawable2 = this.drawable;
            if (uRLDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("drawable");
            } else {
                uRLDrawable = uRLDrawable2;
            }
            b(uRLDrawable, bitmapCallback);
            return;
        }
        URLDrawable uRLDrawable3 = this.drawable;
        if (uRLDrawable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawable");
            uRLDrawable3 = null;
        }
        uRLDrawable3.setURLDrawableListener(new b(bitmapCallback));
        URLDrawable uRLDrawable4 = this.drawable;
        if (uRLDrawable4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawable");
        } else {
            uRLDrawable = uRLDrawable4;
        }
        uRLDrawable.startDownload();
    }
}
