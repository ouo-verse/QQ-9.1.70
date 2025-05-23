package bi3;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import bi3.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import fi3.be;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t74.m;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0019\u0018\u0000 *2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\n \u001e*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lbi3/a;", "Lzh3/a;", "", "percentage", "", "b", "Lfi3/be;", "a", "Lfi3/be;", "mBinding", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mDescLabel", "c", "mTitle", "Landroid/widget/ProgressBar;", "d", "Landroid/widget/ProgressBar;", "mProgress", "e", "mPercentage", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mBackgroundImage", "bi3/a$b", "g", "Lbi3/a$b;", "mProgressListener", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "kotlin.jvm.PlatformType", h.F, "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "mBgDrawableOpt", "Lcom/tencent/image/URLDrawable;", "i", "Lcom/tencent/image/URLDrawable;", "mBgDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "j", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements zh3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final be mBinding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final TextView mDescLabel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final TextView mTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ProgressBar mProgress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView mPercentage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView mBackgroundImage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final b mProgressListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final URLDrawable.URLDrawableOptions mBgDrawableOpt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final URLDrawable mBgDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"bi3/a$b", "Lji3/c;", "", "progress", "curPhase", "totalPhase", "", "onProgress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements ji3.c {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(a this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b(i3);
        }

        @Override // ji3.c
        public void onProgress(int progress, int curPhase, int totalPhase) {
            final int b16;
            b16 = c.b(progress, curPhase, totalPhase);
            QLog.d("ZPlanHotPatchProgressViewHelper", 1, "onProgress callback in view helper, total percentage: " + b16);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final a aVar = a.this;
            uIHandlerV2.post(new Runnable() { // from class: bi3.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.b(a.this, b16);
                }
            });
        }
    }

    public a(Context context) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(context, "context");
        be g16 = be.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.mBinding = g16;
        TextView textView = g16.f399077d;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.zplanHotPatchDesc");
        this.mDescLabel = textView;
        TextView textView2 = g16.f399080g;
        Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.zplanHotPatchTitle");
        this.mTitle = textView2;
        ProgressBar progressBar = g16.f399079f;
        Intrinsics.checkNotNullExpressionValue(progressBar, "mBinding.zplanHotPatchProgress");
        this.mProgress = progressBar;
        TextView textView3 = g16.f399078e;
        Intrinsics.checkNotNullExpressionValue(textView3, "mBinding.zplanHotPatchPercentage");
        this.mPercentage = textView3;
        ImageView imageView = g16.f399076c;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.zplanHotPatchBackground");
        this.mBackgroundImage = imageView;
        this.mProgressListener = new b();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        try {
            drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.f159865h40, null);
        } catch (OutOfMemoryError unused) {
            QLog.e("ZPlanHotPatchProgressViewHelper", 1, "decode background placeholder drawable oom, fallback to transparent.");
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mUseApngImage = true;
        this.mBgDrawableOpt = obtain;
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        URLDrawable drawable2 = URLDrawable.getDrawable(zPlanFeatureSwitch.Q0(), obtain);
        this.mBgDrawable = drawable2;
        TextView textView4 = this.mPercentage;
        m mVar = m.f435564a;
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        textView4.setTypeface(mVar.d(assets));
        this.mDescLabel.setText(zPlanFeatureSwitch.R0());
        this.mTitle.setText(zPlanFeatureSwitch.e2());
        this.mBackgroundImage.setImageDrawable(drawable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int percentage) {
        this.mPercentage.setText(percentage + "%");
        this.mProgress.setProgress(percentage);
    }
}
