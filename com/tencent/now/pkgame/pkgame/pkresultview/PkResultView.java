package com.tencent.now.pkgame.pkgame.pkresultview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.component.core.log.LogUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.pkgame.pkgame.pkresultview.PkResultView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lo3.a;
import mo3.d;
import no3.ResultBean;
import no3.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001:B)\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0014R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/pkresultview/PkResultView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Llo3/a;", "Landroid/widget/FrameLayout$LayoutParams;", "params", "", "B0", VasPerfReportUtils.WHILE_UPDATE_ITEM, "Lno3/d;", "resultBean", "H0", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "A0", "D0", "F0", "E0", "", "url", "G0", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "C0", "Lmo3/d;", "J", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/ViewModelProvider;", "e", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "Lno3/c;", "f", "Lno3/c;", "pkResultViewModel", h.F, "Landroid/widget/ImageView;", "ivLeftView", "i", "ivRightView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ivCenterView", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "liveViewPlaceHolder", "D", "Lcom/tencent/image/URLDrawable;", "pkResultAPNGUrlDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/ViewModelProvider;Landroidx/lifecycle/LifecycleOwner;Landroid/widget/FrameLayout$LayoutParams;)V", "E", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PkResultView extends ConstraintLayout implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private View liveViewPlaceHolder;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private URLDrawable pkResultAPNGUrlDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelProvider viewModelProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c pkResultViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivLeftView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivRightView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCenterView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PkResultView(@NotNull Context context, @NotNull ViewModelProvider viewModelProvider, @NotNull LifecycleOwner lifecycleOwner, @NotNull FrameLayout.LayoutParams params) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(params, "params");
        this.lifecycleOwner = lifecycleOwner;
        this.viewModelProvider = viewModelProvider;
        ViewModel viewModel = viewModelProvider.get(c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(Pk\u2026ultViewModel::class.java)");
        this.pkResultViewModel = (c) viewModel;
        B0(params);
        updateView();
    }

    private final ApngOptions A0() {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setUseCache(true);
        apngOptions.setLoadingDrawable(new ColorDrawable(0));
        return apngOptions;
    }

    private final void B0(FrameLayout.LayoutParams params) {
        LayoutInflater.from(getContext()).inflate(R.layout.haw, this);
        View findViewById = findViewById(R.id.y58);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivLeftView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.y8c);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivRightView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.y1_);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivCenterView = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.yme);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.liveViewPlaceHolder = findViewById4;
        View view = null;
        if (findViewById4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveViewPlaceHolder");
            findViewById4 = null;
        }
        ViewGroup.LayoutParams layoutParams = findViewById4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = params.height;
        View view2 = this.liveViewPlaceHolder;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveViewPlaceHolder");
        } else {
            view = view2;
        }
        view.setLayoutParams(layoutParams2);
    }

    private final void C0(ImageView imageView, URLDrawable urlDrawable) {
        imageView.setImageDrawable(urlDrawable);
        urlDrawable.setURLDrawableListener(new b(urlDrawable, imageView));
    }

    private final void D0() {
        G0("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLBIZjFJNupibJYkgqhLQuICh7JkLKg5hMbs3uI5Z5HLGuQ/");
    }

    private final void E0() {
        G0("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEKM0j1JiaC5YnVNeNhN01A9OfAmyYAte8Gfx41ibs6loJWA/");
    }

    private final void F0() {
        G0("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEJ4SZM1MfVEKxXv3OqrbSKdVq5MohHcxhgZzRKSd9ulZw/");
    }

    private final void G0(String url) {
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("PkResultView", url, A0());
        this.pkResultAPNGUrlDrawable = apngURLDrawable;
        if (apngURLDrawable != null) {
            ImageView imageView = this.ivCenterView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCenterView");
                imageView = null;
            }
            C0(imageView, apngURLDrawable);
        }
    }

    private final void H0(ResultBean resultBean) {
        if (resultBean.getLeftResult() != 0 && resultBean.getRightResult() != 0) {
            setVisibility(0);
            int leftResult = resultBean.getLeftResult();
            if (leftResult != 1) {
                if (leftResult != 2) {
                    if (leftResult == 3) {
                        D0();
                        return;
                    }
                    return;
                }
                E0();
                return;
            }
            F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(PkResultView this$0, ResultBean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.H0(it);
    }

    private final void updateView() {
        this.pkResultViewModel.W1().observe(this.lifecycleOwner, new Observer() { // from class: no3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PkResultView.I0(PkResultView.this, (ResultBean) obj);
            }
        });
    }

    @Override // lo3.a
    @NotNull
    public d J() {
        return this.pkResultViewModel;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        URLDrawable uRLDrawable = this.pkResultAPNGUrlDrawable;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/now/pkgame/pkgame/pkresultview/PkResultView$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f339024e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f339025f;

        b(URLDrawable uRLDrawable, ImageView imageView) {
            this.f339024e = uRLDrawable;
            this.f339025f = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable p06, @Nullable Throwable p16) {
            LogUtil.e("PkResultView", "onLoadFailed", new Object[0]);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable p06) {
            LogUtil.i("PkResultView", "onLoadSucceed", new Object[0]);
            int c16 = x.c(PkResultView.this.getContext(), 128.0f);
            float intrinsicWidth = (this.f339024e.getIntrinsicWidth() * 1.0f) / this.f339024e.getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams = this.f339025f.getLayoutParams();
            LogUtil.i("PkResultView", "Bitmap \u5c3a\u5bf8:" + this.f339024e.getIntrinsicWidth() + ", " + this.f339024e.getIntrinsicHeight(), new Object[0]);
            if (this.f339024e.getIntrinsicWidth() >= 0 && this.f339024e.getIntrinsicHeight() >= 0) {
                layoutParams.height = c16;
                layoutParams.width = (int) (c16 * intrinsicWidth);
            } else {
                layoutParams.height = 0;
                layoutParams.width = 0;
            }
            this.f339025f.setLayoutParams(layoutParams);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable p06) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable p06, int p16) {
        }
    }
}
