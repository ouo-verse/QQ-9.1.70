package com.tencent.mobileqq.guild.discoveryv2.content.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001PB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\bH\u0010IB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u00a2\u0006\u0004\bH\u0010LB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\u0006\u0010M\u001a\u00020\u0013\u00a2\u0006\u0004\bH\u0010NJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0017J\u0014\u0010\u0017\u001a\u00020\u00052\n\u0010\u0016\u001a\u00020\u0015\"\u00020\u0013H\u0017J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J0\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010\"\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010#\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013H\u0017J\b\u0010(\u001a\u00020\u0011H\u0016J \u0010,\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0016J\u000e\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/R\u0016\u00104\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010-\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\"\u0010G\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/DiscoveryV2RefreshFooter;", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshFooter;", "Landroid/content/Context;", "context", "", "b", "Landroid/view/View;", "getView", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "getSpinnerStyle", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "", "success", "", "onFinish", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "isDragging", "", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "isSupportHorizontalDrag", "duration", "dragRate", "animationOnly", "autoOpen", "noMoreData", "setNoMoreData", "", FileReaderHelper.TXT_EXT, "setNoMoreText", "d", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldRefreshState", "e", "curRefreshState", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshLoadingView;", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshLoadingView;", "loadingView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "noMoreView", "i", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "getFooterSpinnerStyle", "()Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "setFooterSpinnerStyle", "(Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;)V", "footerSpinnerStyle", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes13.dex */
public final class DiscoveryV2RefreshFooter extends FrameLayout implements IRefreshFooter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RefreshState oldRefreshState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RefreshState curRefreshState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RefreshLoadingView loadingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView noMoreView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean noMoreData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SpinnerStyle footerSpinnerStyle;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f217358a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.Loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.None.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f217358a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscoveryV2RefreshFooter(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(Context context) {
        RefreshLoadingView refreshLoadingView = new RefreshLoadingView(context);
        refreshLoadingView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bi.b(20), bi.b(20));
        layoutParams.topMargin = bi.b(10);
        layoutParams.gravity = 49;
        refreshLoadingView.setLayoutParams(layoutParams);
        this.loadingView = refreshLoadingView;
        TextView textView = new TextView(context);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, bi.b(40)));
        textView.setGravity(17);
        textView.setText(HardCodeUtil.qqStr(R.string.f1514517q));
        this.noMoreView = textView;
        textView.setVisibility(8);
        RefreshLoadingView refreshLoadingView2 = this.loadingView;
        TextView textView2 = null;
        if (refreshLoadingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            refreshLoadingView2 = null;
        }
        addView(refreshLoadingView2);
        TextView textView3 = this.noMoreView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noMoreView");
        } else {
            textView2 = textView3;
        }
        addView(textView2);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    /* renamed from: getSpinnerStyle, reason: from getter */
    public SpinnerStyle getFooterSpinnerStyle() {
        return this.footerSpinnerStyle;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "onFinish " + refreshLayout + ", " + success);
            return 400;
        }
        return 400;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "onHorizontalDrag " + percentX + ", " + offsetX + ", " + offsetMax);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "onInitialized " + kernel + ", " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        boolean z16;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "onMoving " + isDragging + ", " + percent + ", " + offset + ", " + height + ", " + maxDragHeight);
        }
        if (isDragging) {
            RefreshLoadingView refreshLoadingView = this.loadingView;
            RefreshLoadingView refreshLoadingView2 = null;
            if (refreshLoadingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                refreshLoadingView = null;
            }
            if (refreshLoadingView.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                RefreshLoadingView refreshLoadingView3 = this.loadingView;
                if (refreshLoadingView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                } else {
                    refreshLoadingView2 = refreshLoadingView3;
                }
                refreshLoadingView2.setRotation((offset / maxDragHeight) * 360);
            }
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onReleased(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "onReleased " + refreshLayout + ", " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "onStartAnimator " + refreshLayout + ", " + height + ", " + maxDragHeight);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15, types: [android.widget.TextView] */
    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    @SuppressLint({"RestrictedApi"})
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        boolean z16 = true;
        Logger.f235387a.d().i("DiscoveryV2RefreshFooter", 1, "onStateChanged " + refreshLayout + ", " + oldState + ", " + newState + ", noMoreData= " + this.noMoreData);
        RefreshLoadingView refreshLoadingView = null;
        if (this.noMoreData) {
            TextView textView = this.noMoreView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noMoreView");
                textView = null;
            }
            if (textView.getVisibility() != 8) {
                z16 = false;
            }
            if (z16) {
                ?? r56 = this.noMoreView;
                if (r56 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("noMoreView");
                } else {
                    refreshLoadingView = r56;
                }
                refreshLoadingView.setVisibility(0);
                return;
            }
            return;
        }
        this.oldRefreshState = oldState;
        this.curRefreshState = newState;
        int i3 = b.f217358a[newState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                RefreshLoadingView refreshLoadingView2 = this.loadingView;
                if (refreshLoadingView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                } else {
                    refreshLoadingView = refreshLoadingView2;
                }
                refreshLoadingView.d();
                return;
            }
            return;
        }
        RefreshLoadingView refreshLoadingView3 = this.loadingView;
        if (refreshLoadingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            refreshLoadingView3 = null;
        }
        refreshLoadingView3.e();
        RefreshLoadingView refreshLoadingView4 = this.loadingView;
        if (refreshLoadingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            refreshLoadingView = refreshLoadingView4;
        }
        refreshLoadingView.a();
    }

    public final void setFooterSpinnerStyle(@NotNull SpinnerStyle spinnerStyle) {
        Intrinsics.checkNotNullParameter(spinnerStyle, "<set-?>");
        this.footerSpinnerStyle = spinnerStyle;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter
    public boolean setNoMoreData(boolean noMoreData) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "setNoMoreData noMoreData=" + noMoreData);
        }
        this.noMoreData = noMoreData;
        TextView textView = null;
        if (noMoreData) {
            RefreshLoadingView refreshLoadingView = this.loadingView;
            if (refreshLoadingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                refreshLoadingView = null;
            }
            refreshLoadingView.setVisibility(8);
            TextView textView2 = this.noMoreView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noMoreView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return true;
        }
        RefreshLoadingView refreshLoadingView2 = this.loadingView;
        if (refreshLoadingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            refreshLoadingView2 = null;
        }
        refreshLoadingView2.setVisibility(0);
        TextView textView3 = this.noMoreView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noMoreView");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
        return true;
    }

    public final void setNoMoreText(@NotNull String txt) {
        Intrinsics.checkNotNullParameter(txt, "txt");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "setNoMoreText txt=" + txt);
        }
        if (!TextUtils.isEmpty(txt)) {
            TextView textView = this.noMoreView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noMoreView");
                textView = null;
            }
            textView.setText(txt);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshFooter", "setPrimaryColors " + colors);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscoveryV2RefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscoveryV2RefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        RefreshState refreshState = RefreshState.None;
        this.oldRefreshState = refreshState;
        this.curRefreshState = refreshState;
        SpinnerStyle Scale = SpinnerStyle.Scale;
        Intrinsics.checkNotNullExpressionValue(Scale, "Scale");
        this.footerSpinnerStyle = Scale;
        b(context);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    public View getView() {
        return this;
    }
}
