package com.tencent.sqshow.zootopia.avatar.loading.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.al;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B'\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0005\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010'R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00065"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/view/ZPlanAvatarSceneLoadingView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "", "f", "", "targetState", "g", "d", "Landroid/view/View;", "e", "pauseAnim", "resumeAnim", "destroy", "Landroid/view/ViewGroup;", "getView", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "listener", "setCloseListener", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "getCloseIcon", HippyTKDListViewAdapter.X, "Landroid/view/View$OnClickListener;", "l", "setOnLoadingClickListener", "setSwitchState", "styleMode", "setStyleMode", "Landroid/animation/ObjectAnimator;", "p", "", "o", "Ln74/al;", "Ln74/al;", "mBinding", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "mCloseListener", "", "Ljava/lang/String;", "mLoadingTextHint", tl.h.F, "I", "mCurrentProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAvatarSceneLoadingView extends FrameLayout implements ISceneLoadingView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final al mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ISceneLoadingView.b mCloseListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mLoadingTextHint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCurrentProgress;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarSceneLoadingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ZPlanAvatarSceneLoadingView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISceneLoadingView.b bVar = this$0.mCloseListener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.onCloseClick(it);
        }
    }

    private final View e() {
        IZplanCacheApi iZplanCacheApi = (IZplanCacheApi) QRoute.api(IZplanCacheApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Object cache = iZplanCacheApi.getCache(context, ZplanCacheComponentType.CARD_TOP_LIST);
        if (cache instanceof View) {
            return (View) cache;
        }
        return null;
    }

    private final void f() {
        this.mBinding.f418665f.setText(this.mCurrentProgress + "%");
    }

    private final void g(final int targetState) {
        ViewGroup.LayoutParams layoutParams = this.mBinding.f418669j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.weight = targetState == 2 ? 23.5f : 11.7f;
        }
        ViewGroup.LayoutParams layoutParams3 = this.mBinding.f418662c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.weight = targetState == 2 ? 44.2f : 12.8f;
        }
        this.mBinding.f418664e.setVisibility(targetState == 2 ? 0 : 8);
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.h
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarSceneLoadingView.h(ZPlanAvatarSceneLoadingView.this, targetState);
            }
        });
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZPlanAvatarSceneLoadingView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d(i3);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public View getCloseIcon() {
        ImageView imageView = this.mBinding.f418664e;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.loadingBackIcon");
        return imageView;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.d
    public void k() {
        ISceneLoadingView.a.b(this);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public long o() {
        return 0L;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public ObjectAnimator p() {
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.d
    public boolean s(com.tencent.sqshow.zootopia.scene.component.c cVar) {
        return ISceneLoadingView.a.a(this, cVar);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void setCloseListener(ISceneLoadingView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mCloseListener = listener;
    }

    @Override // c84.a
    public void setProgress(int progress) {
        if (this.mCurrentProgress == 100) {
            return;
        }
        this.mCurrentProgress = progress;
        f();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void setSwitchState(int targetState) {
        g(targetState);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public View x() {
        LinearLayout linearLayout = this.mBinding.f418661b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.bgContainer");
        return linearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    /* renamed from: z */
    public boolean getMRecordAvatarIsShowing() {
        return ISceneLoadingView.a.c(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarSceneLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void destroy() {
        QLog.i("ZPlanAvatarSceneLoadingView_", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mBinding.f418663d.c();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void pauseAnim() {
        QLog.i("ZPlanAvatarSceneLoadingView_", 1, "pauseAnim");
        this.mBinding.f418663d.e();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void resumeAnim() {
        QLog.i("ZPlanAvatarSceneLoadingView_", 1, "resumeAnim");
        this.mBinding.f418663d.f();
    }

    public /* synthetic */ ZPlanAvatarSceneLoadingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarSceneLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        al g16 = al.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        this.mLoadingTextHint = c84.c.f30451a.a();
        g16.f418664e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.avatar.loading.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanAvatarSceneLoadingView.c(ZPlanAvatarSceneLoadingView.this, view);
            }
        });
        setOnClickListener(null);
        if (ZPlanQQMC.INSTANCE.enableCenterLoadingTips()) {
            g16.f418665f.setVisibility(0);
            g16.f418666g.setVisibility(0);
            g16.f418667h.setVisibility(0);
        } else {
            g16.f418665f.setVisibility(8);
            g16.f418666g.setVisibility(8);
            g16.f418667h.setVisibility(8);
        }
    }

    private final void d(int targetState) {
        int statusBarHeight;
        if (targetState == 1) {
            View e16 = e();
            if (e16 != null) {
                ViewGroup.LayoutParams layoutParams = e16.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    statusBarHeight = layoutParams2.topMargin;
                } else {
                    statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
                }
                int height = e16.getHeight() + statusBarHeight;
                ViewGroup.LayoutParams layoutParams3 = this.mBinding.f418668i.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = height;
                }
            }
        } else {
            ViewGroup.LayoutParams layoutParams4 = this.mBinding.f418668i.getLayoutParams();
            if (layoutParams4 != null) {
                layoutParams4.height = 0;
            }
        }
        requestLayout();
    }

    public void setStyleMode(int styleMode) {
        if (styleMode == 1) {
            g(1);
        } else if (styleMode == 2) {
            g(2);
        } else if (styleMode == 3) {
            g(2);
        }
        requestLayout();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public ViewGroup getView() {
        return this;
    }

    public void setOnLoadingClickListener(View.OnClickListener l3) {
    }
}
