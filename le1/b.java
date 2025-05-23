package le1;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b5\u00106J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0018\u001a\u00020\u0006*\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\\\u0010%\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0006R\u0016\u0010*\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010+R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010.R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010/R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00100R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00100R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00100R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010.R$\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u001901j\b\u0012\u0004\u0012\u00020\u0019`28\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00103\u00a8\u00067"}, d2 = {"Lle1/b;", "", "Landroid/widget/TextView;", "tvName", "", "gameName", "", "k", "Landroid/widget/ImageView;", "ivIcon", "iconUrl", "", "isLandScape", "j", "ivBg", "loadingUrl", "i", "progressTips", "Landroid/widget/ProgressBar;", "progressBar", "ivProgressAnim", "l", "url", "isBg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "f", "color", "", "radius", "Landroid/graphics/drawable/Drawable;", "b", "d", "e", "Landroid/graphics/drawable/ClipDrawable;", "c", h.F, "o", "g", "a", "I", "curProgress", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "fgDrawable", "Landroid/widget/TextView;", "Landroid/widget/ProgressBar;", "Landroid/widget/ImageView;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "loadStateList", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int curProgress;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable bgDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable fgDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView progressTips;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProgressBar progressBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivProgressAnim;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> loadStateList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"le1/b$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: le1.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C10719b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f414421a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f414422b;

        C10719b(boolean z16, ImageView imageView) {
            this.f414421a = z16;
            this.f414422b = imageView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Resources resources;
            float f16;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            if (this.f414421a) {
                resources = this.f414422b.getResources();
                f16 = 6.0f;
            } else {
                resources = this.f414422b.getResources();
                f16 = 8.0f;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.tencent.mobileqq.gamecenter.yungame.a.d(f16, resources));
        }
    }

    public b() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusStart.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusCheckingAuth.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusPrepareData.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusGameConfigGot.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusCheckingDevice.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusDeviceAllocated.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusLoadingGameArchive.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusDeviceReadyToConnect.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusRTCConnecting.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusRTCConnected.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusLoadingFinished.getStatusCode()));
        arrayList.add(Integer.valueOf(GmCgPlayStatus.StatusFirstFramedRendered.getStatusCode()));
        this.loadStateList = arrayList;
    }

    private final Drawable b(int color, float radius) {
        if (this.bgDrawable == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(radius);
            gradientDrawable.setColor(color);
            this.bgDrawable = gradientDrawable;
        }
        Drawable drawable = this.bgDrawable;
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    private final ClipDrawable c(int color, float radius) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{radius, radius, radius, radius, radius, radius, radius, radius}, null, null));
        shapeDrawable.getPaint().setColor(color);
        return new ClipDrawable(shapeDrawable, 8388611, 1);
    }

    private final Drawable d(int color, float radius) {
        if (this.fgDrawable == null) {
            this.fgDrawable = e(color, radius);
        }
        Drawable drawable = this.fgDrawable;
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    private final Drawable e(int color, float radius) {
        return new LayerDrawable(new ClipDrawable[]{c(color, radius)});
    }

    private final int f(int statusCode) {
        int coerceAtLeast;
        int indexOf = this.loadStateList.indexOf(Integer.valueOf(statusCode));
        if (indexOf != -1) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((indexOf + 1) * 100) / this.loadStateList.size(), this.curProgress);
            this.curProgress = coerceAtLeast;
            return coerceAtLeast;
        }
        return -1;
    }

    private final void i(ImageView ivBg, String loadingUrl, boolean isLandScape) {
        if (TextUtils.isEmpty(loadingUrl)) {
            if (isLandScape) {
                loadingUrl = "https://img.gamecenter.qq.com/xgame/gm/1686637902947_c9214c5fff8fae3a5586ba2cc56a706b.jpg";
            } else {
                loadingUrl = "https://img.gamecenter.qq.com/xgame/gm/1686637908036_e4bd370d175f66ec01604f5da3f934fc.jpg";
            }
        }
        n(this, ivBg, loadingUrl, false, 2, null);
        this.ivBg = ivBg;
    }

    private final void j(ImageView ivIcon, String iconUrl, boolean isLandScape) {
        float f16;
        if (!TextUtils.isEmpty(iconUrl)) {
            n(this, ivIcon, iconUrl, false, 2, null);
            ivIcon.setOutlineProvider(new C10719b(isLandScape, ivIcon));
            ivIcon.setClipToOutline(true);
            ViewGroup.LayoutParams layoutParams = ivIcon.getLayoutParams();
            if (isLandScape) {
                f16 = 42.0f;
            } else {
                f16 = 60.0f;
            }
            int d16 = com.tencent.mobileqq.gamecenter.yungame.a.d(f16, ivIcon.getResources());
            layoutParams.width = d16;
            layoutParams.height = d16;
            ivIcon.setLayoutParams(layoutParams);
        }
        this.ivIcon = ivIcon;
    }

    private final void k(TextView tvName, String gameName) {
        tvName.setText(gameName);
        this.tvName = tvName;
    }

    private final void l(TextView progressTips, ProgressBar progressBar, ImageView ivProgressAnim, boolean isLandScape) {
        float f16;
        String str;
        float f17;
        if (isLandScape) {
            f16 = 38.0f;
        } else {
            f16 = 24.0f;
        }
        int d16 = com.tencent.mobileqq.gamecenter.yungame.a.d(f16, progressTips.getResources());
        ViewGroup.LayoutParams layoutParams = progressTips.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (isLandScape) {
                f17 = 34.5f;
            } else {
                f17 = 195.0f;
            }
            layoutParams2.bottomMargin = com.tencent.mobileqq.gamecenter.yungame.a.d(f17, progressTips.getResources());
            layoutParams2.leftMargin = d16;
            layoutParams2.rightMargin = d16;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = progressTips.getResources().getString(R.string.f1628421i);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.load_progress_tips)");
            String format = String.format(string, Arrays.copyOf(new Object[]{0}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            progressTips.setText(format);
        }
        progressTips.setLayoutParams(layoutParams);
        this.progressTips = progressTips;
        progressBar.setVisibility(0);
        float d17 = com.tencent.mobileqq.gamecenter.yungame.a.d(4.0f, progressBar.getResources());
        progressBar.setBackground(b(progressBar.getResources().getColor(R.color.cys), d17));
        progressBar.setProgressDrawable(d(progressBar.getResources().getColor(R.color.b9o), d17));
        ViewGroup.LayoutParams layoutParams3 = progressBar.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.leftMargin = d16;
            layoutParams4.rightMargin = d16;
        }
        progressBar.setLayoutParams(layoutParams3);
        this.progressBar = progressBar;
        ViewGroup.LayoutParams layoutParams5 = ivProgressAnim.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            layoutParams6.leftMargin = d16;
            layoutParams6.rightMargin = d16;
        }
        ivProgressAnim.setLayoutParams(layoutParams5);
        if (isLandScape) {
            str = "https://img.gamecenter.qq.com/xgame/gm/1683802717292_c2a6657a1af8db19e60cc15f822ad871.png";
        } else {
            str = "https://img.gamecenter.qq.com/xgame/gm/1683802730557_1488aa18fac7b126c31e1e2eb43e01c3.png";
        }
        n(this, ivProgressAnim, str, false, 2, null);
        this.ivProgressAnim = ivProgressAnim;
    }

    private final void m(ImageView imageView, String str, boolean z16) {
        com.tencent.mobileqq.gamecenter.yungame.a.i(str, z16, imageView);
    }

    static /* synthetic */ void n(b bVar, ImageView imageView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        bVar.m(imageView, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    public final void g() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        TextView textView = this.progressTips;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.ivBg;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.ivIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        TextView textView2 = this.tvName;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ImageView imageView3 = this.ivProgressAnim;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }

    public final void h(@NotNull TextView progressTips, @NotNull ProgressBar progressBar, @NotNull ImageView ivBg, @NotNull TextView tvName, @NotNull ImageView ivIcon, @NotNull ImageView ivProgressAnim, @Nullable String loadingUrl, boolean isLandScape, @Nullable String gameName, @Nullable String iconUrl) {
        Intrinsics.checkNotNullParameter(progressTips, "progressTips");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(ivBg, "ivBg");
        Intrinsics.checkNotNullParameter(tvName, "tvName");
        Intrinsics.checkNotNullParameter(ivIcon, "ivIcon");
        Intrinsics.checkNotNullParameter(ivProgressAnim, "ivProgressAnim");
        if (QLog.isColorLevel()) {
            QLog.d("LoadProgressManager", 2, "[init] loadingUrl:" + loadingUrl + ",isLandScape:" + isLandScape + ",gameName:" + gameName + ",iconUrl:" + iconUrl);
        }
        l(progressTips, progressBar, ivProgressAnim, isLandScape);
        i(ivBg, loadingUrl, isLandScape);
        j(ivIcon, iconUrl, isLandScape);
        k(tvName, gameName);
    }

    public final void o(int statusCode) {
        int f16 = f(statusCode);
        if (f16 > -1) {
            ProgressBar progressBar = this.progressBar;
            if (progressBar != null) {
                progressBar.setProgress(f16);
            }
            TextView textView = this.progressTips;
            if (textView != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = textView.getResources().getString(R.string.f1628421i);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.load_progress_tips)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(f16)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView.setText(format);
            }
            if (f16 >= 100) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: le1.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.p(b.this);
                    }
                }, 200L);
            }
        }
    }
}
