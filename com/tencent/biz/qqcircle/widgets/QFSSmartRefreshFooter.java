package com.tencent.biz.qqcircle.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001\u0004B\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=B\u001b\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b<\u0010@B#\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\u0006\u0010A\u001a\u00020\u0011\u00a2\u0006\u0004\b<\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0017J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0017J\u0014\u0010\u0015\u001a\u00020\u00032\n\u0010\u0014\u001a\u00020\u0013\"\u00020\u0011H\u0017J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0017J0\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0017J \u0010 \u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0017J \u0010!\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0017J \u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0017J\b\u0010&\u001a\u00020\u000fH\u0016J \u0010*\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u000fH\u0016J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0017R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001e\u00109\u001a\n 6*\u0004\u0018\u000105058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006D"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSSmartRefreshFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshFooter;", "", "a", "Landroid/view/View;", "getView", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "getSpinnerStyle", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "", "success", "", "onFinish", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "isDragging", "", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "isSupportHorizontalDrag", "duration", "dragRate", "animationOnly", "autoOpen", "noMoreData", "setNoMoreData", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "hintView", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "f", "Landroid/graphics/drawable/Drawable;", "defaultLoadingDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSSmartRefreshFooter extends LinearLayout implements IRefreshFooter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView hintView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Drawable defaultLoadingDrawable;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f93445a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.PullUpToLoad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f93445a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSSmartRefreshFooter(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i3;
        int i16;
        int i17;
        int i18;
        setOrientation(0);
        setGravity(17);
        ImageView imageView = new ImageView(getContext());
        this.loadingView = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(cx.a(20.0f), cx.a(20.0f)));
        ImageView imageView2 = this.loadingView;
        TextView textView = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            imageView2 = null;
        }
        imageView2.setImageDrawable(this.defaultLoadingDrawable);
        ImageView imageView3 = this.loadingView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            imageView3 = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = imageView3.getLayoutParams();
            if (layoutParams2 != null) {
                i17 = layoutParams2.width;
            } else {
                i17 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = imageView3.getLayoutParams();
            if (layoutParams3 != null) {
                i18 = layoutParams3.height;
            } else {
                i18 = -2;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i17, i18);
        }
        marginLayoutParams.topMargin = cx.a(5.0f);
        ImageView imageView4 = this.loadingView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            imageView4 = null;
        }
        ViewGroup.LayoutParams layoutParams4 = imageView4.getLayoutParams();
        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
        } else {
            marginLayoutParams2 = null;
        }
        if (marginLayoutParams2 == null) {
            ViewGroup.LayoutParams layoutParams5 = imageView4.getLayoutParams();
            if (layoutParams5 != null) {
                i3 = layoutParams5.width;
            } else {
                i3 = -2;
            }
            ViewGroup.LayoutParams layoutParams6 = imageView4.getLayoutParams();
            if (layoutParams6 != null) {
                i16 = layoutParams6.height;
            } else {
                i16 = -2;
            }
            marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i3, i16);
        }
        marginLayoutParams2.bottomMargin = cx.a(5.0f);
        this.hintView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.setMarginStart(cx.a(5.0f));
        TextView textView2 = this.hintView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
            textView2 = null;
        }
        textView2.setLayoutParams(layoutParams7);
        TextView textView3 = this.hintView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
            textView3 = null;
        }
        textView3.setTextSize(1, 14.0f);
        TextView textView4 = this.hintView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
            textView4 = null;
        }
        textView4.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_light));
        TextView textView5 = this.hintView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
            textView5 = null;
        }
        textView5.setTypeface(Typeface.defaultFromStyle(1));
        TextView textView6 = this.hintView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
            textView6 = null;
        }
        textView6.setText(getContext().getResources().getText(R.string.f221456av));
        ImageView imageView5 = this.loadingView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            imageView5 = null;
        }
        addView(imageView5);
        TextView textView7 = this.hintView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
        } else {
            textView = textView7;
        }
        addView(textView);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    /* renamed from: getSpinnerStyle */
    public SpinnerStyle getFooterSpinnerStyle() {
        SpinnerStyle Translate = SpinnerStyle.Translate;
        Intrinsics.checkNotNullExpressionValue(Translate, "Translate");
        return Translate;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        ImageView imageView = this.loadingView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            imageView = null;
        }
        imageView.setVisibility(8);
        TextView textView2 = this.hintView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
        } else {
            textView = textView2;
        }
        textView.setVisibility(8);
        return 500;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onReleased(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    @SuppressLint({"RestrictedApi"})
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        int i3 = b.f93445a[newState.ordinal()];
        if (i3 == 1 || i3 == 2) {
            ImageView imageView = this.loadingView;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                imageView = null;
            }
            imageView.setVisibility(0);
            TextView textView2 = this.hintView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSSmartRefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSmartRefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultLoadingDrawable = LoadingUtil.getLoadingDrawable(getContext(), 2);
        a();
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter
    @SuppressLint({"RestrictedApi"})
    public boolean setNoMoreData(boolean noMoreData) {
        return noMoreData;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
    }
}
