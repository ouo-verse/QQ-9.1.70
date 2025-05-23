package com.tencent.richframework.gallery.part;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.libra.IPicLoader;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.TransitionAnimUtil;
import com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017\u00a8\u0006\u0004"}, d2 = {"com/tencent/richframework/gallery/part/RFWLayerAnimPart$onInitView$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerAnimPart$onInitView$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View $rootView;
    final /* synthetic */ RFWLayerAnimPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RFWLayerAnimPart$onInitView$1(RFWLayerAnimPart rFWLayerAnimPart, View view) {
        this.this$0 = rFWLayerAnimPart;
        this.$rootView = view;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0118, code lost:
    
        r6 = r10.this$0.currentPicView;
     */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onPreDraw() {
        ILayerOperationInterceptor operationInterceptor;
        boolean z16;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        IPicLoader picLoader;
        IPicLoader picLoader2;
        boolean z17;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView currentImageView;
        ((ViewGroup) this.$rootView).getViewTreeObserver().removeOnPreDrawListener(this);
        this.this$0.isAfterPreDraw = true;
        IGalleryPageProvider galleryPageProvider = RFWLayerIOCUtil.getGalleryPageProvider(this.$rootView);
        if (galleryPageProvider != null) {
            this.this$0.dragLayout = galleryPageProvider.getDragLayout();
            this.this$0.viewPager = galleryPageProvider.getGalleryViewPager().getViewPager2();
            RFWLayerAnimPart.access$getViewPager$p(this.this$0).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$onInitView$1$onPreDraw$1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    RFWLog.i("RFWLayerPagePart", RFWLog.USR, "anim selectedPosition:" + position);
                }
            });
            RFWDragLayout access$getDragLayout$p = RFWLayerAnimPart.access$getDragLayout$p(this.this$0);
            operationInterceptor = this.this$0.getOperationInterceptor();
            if (operationInterceptor != null) {
                z16 = operationInterceptor.canDragClose();
            } else {
                z16 = true;
            }
            access$getDragLayout$p.setFeatureEnable(z16);
            RFWLayerAnimPart.access$getDragLayout$p(this.this$0).setEnableDragVertical(true);
            RFWLayerAnimPart.access$getDragLayout$p(this.this$0).setEnableDragHorizontal(true);
            RFWLayerAnimPart.access$getDragLayout$p(this.this$0).setOnDragListener(new RFWDragLayout.OnDragListener() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$onInitView$1$onPreDraw$2
                @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
                public void onDragging(float factor) {
                    int i3 = (int) (factor * 1.0f * 255.0f);
                    if (i3 < 0) {
                        i3 = 0;
                    } else if (i3 > 255) {
                        i3 = 255;
                    }
                    RFWLayerAnimPart$onInitView$1.this.this$0.updateBackgroundAlpha(i3);
                }

                @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
                public void onEndDrag(boolean isDragToClose) {
                    boolean canShowExitAnim;
                    ILayerOperationListener operationListener;
                    if (isDragToClose) {
                        canShowExitAnim = RFWLayerAnimPart$onInitView$1.this.this$0.canShowExitAnim();
                        if (canShowExitAnim) {
                            RFWLayerAnimPart$onInitView$1.this.this$0.showExitAnim(false);
                        } else {
                            RFWLayerAnimPart$onInitView$1.this.this$0.finishHost();
                        }
                        operationListener = RFWLayerAnimPart$onInitView$1.this.this$0.getOperationListener();
                        if (operationListener != null) {
                            operationListener.onDragClose();
                            return;
                        }
                        return;
                    }
                    RFWLayerAnimPart$onInitView$1.this.this$0.showIgnoreView();
                    RFWLayerAnimPart$onInitView$1.this.this$0.updateBackgroundAlpha(255);
                }

                @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
                public void onStartDrag() {
                    RFWLayerAnimPart$onInitView$1.this.this$0.updateCurrentPicView(true);
                    RFWLayerAnimPart rFWLayerAnimPart = RFWLayerAnimPart$onInitView$1.this.this$0;
                    rFWLayerAnimPart.collectIgnoreViewExcludeTarget(RFWLayerAnimPart.access$getViewPager$p(rFWLayerAnimPart));
                    RFWLayerAnimPart$onInitView$1.this.this$0.changeIgnoreViewAlpha(0.0f);
                }
            });
            RFWLayerAnimPart.access$getDragLayout$p(this.this$0).setDragInterceptDelegate(new RFWDragLayout.DragInterceptDelegate() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$onInitView$1$onPreDraw$3
                @Override // com.tencent.richframework.widget.drag.RFWDragLayout.DragInterceptDelegate
                public final boolean needIntercept(@Nullable MotionEvent motionEvent, float f16, float f17) {
                    if (Math.abs(f16) <= f17) {
                        return true;
                    }
                    return false;
                }
            });
            boolean z18 = false;
            if (RFWLayerAnimPart.access$getInitBean$p(this.this$0).getTransitionBean() != null) {
                imageView = this.this$0.currentPicView;
                if (imageView == null) {
                    RFWLayerAnimPart rFWLayerAnimPart = this.this$0;
                    currentImageView = rFWLayerAnimPart.getCurrentImageView(RFWLayerAnimPart.access$getViewPager$p(rFWLayerAnimPart).getCurrentItem());
                    rFWLayerAnimPart.currentPicView = currentImageView;
                }
                imageView2 = this.this$0.currentPicView;
                if (imageView2 != null) {
                    picLoader2 = this.this$0.getPicLoader();
                    if (picLoader2 != null) {
                        Drawable coverDrawable = TransitionAnimUtil.INSTANCE.getTransViewAndDrawable(RFWLayerAnimPart.access$getTranUUID$p(this.this$0)).getCoverDrawable();
                        boolean isEnterDrawableHasCut = RFWLayerLaunchUtil.isEnterDrawableHasCut(RFWLayerAnimPart.access$getTranUUID$p(this.this$0), RFWLayerAnimPart.access$getEnterMediaInfo$p(this.this$0));
                        if (coverDrawable == null) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        ImageView access$getTempImageView$p = RFWLayerAnimPart.access$getTempImageView$p(this.this$0);
                        imageView4 = this.this$0.currentPicView;
                        Intrinsics.checkNotNull(imageView4);
                        access$getTempImageView$p.setScaleType(imageView4.getScaleType());
                        imageView5 = this.this$0.currentPicView;
                        Intrinsics.checkNotNull(imageView5);
                        if (imageView5.getDrawable() == null && !isEnterDrawableHasCut && imageView6 != null) {
                            imageView6.setImageDrawable(coverDrawable);
                        }
                        if (RFWNetworkUtils.isNetworkAvailable(this.this$0.getActivity()) && (isEnterDrawableHasCut || z17)) {
                            RFWLog.e("RFWLayerAnimPart", RFWLog.USR, "startAnimWithLoadImage hasCut:" + isEnterDrawableHasCut + " isEmptyEnter:" + z17);
                            RFWLayerAnimPart rFWLayerAnimPart2 = this.this$0;
                            if (coverDrawable == null) {
                                z18 = true;
                            }
                            rFWLayerAnimPart2.startAnimWithLoadImage(isEnterDrawableHasCut, z18);
                        } else {
                            RFWLayerAnimPart.access$getTempImageView$p(this.this$0).setImageDrawable(coverDrawable);
                            this.this$0.initAndStartAnim();
                        }
                        return true;
                    }
                }
                int i3 = RFWLog.USR;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("mCurrentView:");
                imageView3 = this.this$0.currentPicView;
                sb5.append(imageView3);
                sb5.append(" mPicLoader:");
                picLoader = this.this$0.getPicLoader();
                sb5.append(picLoader);
                RFWLog.e("RFWLayerAnimPart", i3, sb5.toString());
                this.this$0.resetVisibleAndBg();
            } else {
                RFWLog.e("RFWLayerAnimPart", RFWLog.USR, "bean is null");
                this.this$0.resetVisibleAndBg();
                return true;
            }
        }
        return true;
    }
}
