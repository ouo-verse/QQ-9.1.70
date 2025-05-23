package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.MiniAppRecommdExtendViewFlipper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.widget.ThemeImageView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J*\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppRvItemIconSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "isPlayAnim", "", "mIconAnimIn", "Landroid/view/animation/TranslateAnimation;", "mIconAnimOut", "mItemData", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "mItemsImageIv", "Landroid/widget/ImageView;", "mNewDesktopImageView", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "mViewFlipper", "Lcom/tencent/mobileqq/mini/entry/desktop/widget/MiniAppRecommdExtendViewFlipper;", "getViewStubLayoutId", "", "onBindData", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "position", "", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "onVisibleChanged", NodeProps.VISIBLE, QZoneJsConstants.ACTION_START_ANIMATION, "startSwitchAnimation", "stopAnimation", "Companion", "SpringTranslationInterpolator", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemIconSection extends AbsMiniAppRvItemSection {
    private static final String TAG = "MiniAppDesktopPart.MiniAppRvItemIconSection";
    private boolean isPlayAnim;
    private TranslateAnimation mIconAnimIn;
    private TranslateAnimation mIconAnimOut;
    private DesktopAppInfo mItemData;
    private ImageView mItemsImageIv;
    private RoundRectImageView mNewDesktopImageView;
    private MiniAppRecommdExtendViewFlipper mViewFlipper;

    private final void startAnimation() {
        DesktopAppInfo desktopAppInfo = this.mItemData;
        if (desktopAppInfo != null) {
            Intrinsics.checkNotNull(desktopAppInfo);
            if (desktopAppInfo.mMiniAppInfo != null) {
                DesktopAppInfo desktopAppInfo2 = this.mItemData;
                Intrinsics.checkNotNull(desktopAppInfo2);
                if (desktopAppInfo2.mMiniAppInfo.motionPics != null) {
                    DesktopAppInfo desktopAppInfo3 = this.mItemData;
                    Intrinsics.checkNotNull(desktopAppInfo3);
                    if (desktopAppInfo3.mMiniAppInfo.motionPics.size() > 0) {
                        this.isPlayAnim = true;
                        Context context = getRootView().getContext();
                        DesktopAppInfo desktopAppInfo4 = this.mItemData;
                        Intrinsics.checkNotNull(desktopAppInfo4);
                        Drawable icon = MiniAppUtils.getIcon(context, desktopAppInfo4.mMiniAppInfo.appStoreAnimPicUrl, true, R.drawable.hog, 48);
                        ImageView imageView = this.mItemsImageIv;
                        ImageView imageView2 = null;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                            imageView = null;
                        }
                        imageView.setImageDrawable(icon);
                        ImageView imageView3 = this.mItemsImageIv;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                        } else {
                            imageView2 = imageView3;
                        }
                        imageView2.invalidate();
                        startSwitchAnimation();
                    }
                }
            }
        }
    }

    private final void startSwitchAnimation() {
        MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper = this.mViewFlipper;
        MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper2 = null;
        if (miniAppRecommdExtendViewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
            miniAppRecommdExtendViewFlipper = null;
        }
        miniAppRecommdExtendViewFlipper.setVisibility(0);
        if (this.mIconAnimIn == null || this.mIconAnimOut == null) {
            return;
        }
        MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper3 = this.mViewFlipper;
        if (miniAppRecommdExtendViewFlipper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
            miniAppRecommdExtendViewFlipper3 = null;
        }
        miniAppRecommdExtendViewFlipper3.setInAnimation(this.mIconAnimIn);
        MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper4 = this.mViewFlipper;
        if (miniAppRecommdExtendViewFlipper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
            miniAppRecommdExtendViewFlipper4 = null;
        }
        miniAppRecommdExtendViewFlipper4.setOutAnimation(this.mIconAnimOut);
        MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper5 = this.mViewFlipper;
        if (miniAppRecommdExtendViewFlipper5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
            miniAppRecommdExtendViewFlipper5 = null;
        }
        miniAppRecommdExtendViewFlipper5.setFlipInterval(Constants.Action.ACTION_APP_GUARD);
        MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper6 = this.mViewFlipper;
        if (miniAppRecommdExtendViewFlipper6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
        } else {
            miniAppRecommdExtendViewFlipper2 = miniAppRecommdExtendViewFlipper6;
        }
        miniAppRecommdExtendViewFlipper2.startFlipping();
    }

    private final void stopAnimation() {
        DesktopAppInfo desktopAppInfo = this.mItemData;
        if (desktopAppInfo != null) {
            Intrinsics.checkNotNull(desktopAppInfo);
            if (desktopAppInfo.mMiniAppInfo == null || !this.isPlayAnim) {
                return;
            }
            this.isPlayAnim = false;
            MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper = this.mViewFlipper;
            MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper2 = null;
            if (miniAppRecommdExtendViewFlipper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                miniAppRecommdExtendViewFlipper = null;
            }
            miniAppRecommdExtendViewFlipper.stopFlipping();
            ImageView imageView = this.mItemsImageIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                imageView = null;
            }
            Context context = getRootView().getContext();
            DesktopAppInfo desktopAppInfo2 = this.mItemData;
            Intrinsics.checkNotNull(desktopAppInfo2);
            imageView.setImageDrawable(MiniAppUtils.getIcon(context, desktopAppInfo2.mMiniAppInfo.iconUrl, true));
            MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper3 = this.mViewFlipper;
            if (miniAppRecommdExtendViewFlipper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
            } else {
                miniAppRecommdExtendViewFlipper2 = miniAppRecommdExtendViewFlipper3;
            }
            miniAppRecommdExtendViewFlipper2.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(DesktopItemInfo desktopItemInfo, int i3, List list) {
        onBindData2(desktopItemInfo, i3, (List<Object>) list);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        if (visible) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(DesktopItemInfo data, int position, List<Object> payload) {
        if (data == null || !(data instanceof DesktopAppInfo)) {
            return;
        }
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) data;
        if (desktopAppInfo.mMiniAppInfo != null) {
            this.mItemData = desktopAppInfo;
            Context context = getRootView().getContext();
            MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
            Drawable icon = MiniAppUtils.getIcon(context, miniAppInfo != null ? miniAppInfo.iconUrl : null, true);
            if (desktopAppInfo.mModuleType == 2 && position == 0) {
                ImageView imageView = this.mItemsImageIv;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                    imageView = null;
                }
                imageView.setVisibility(0);
                ImageView imageView2 = this.mItemsImageIv;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                    imageView2 = null;
                }
                imageView2.setImageDrawable(icon);
                RoundRectImageView roundRectImageView = this.mNewDesktopImageView;
                if (roundRectImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewDesktopImageView");
                    roundRectImageView = null;
                }
                roundRectImageView.setVisibility(8);
            } else {
                MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper = this.mViewFlipper;
                if (miniAppRecommdExtendViewFlipper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                    miniAppRecommdExtendViewFlipper = null;
                }
                miniAppRecommdExtendViewFlipper.setVisibility(8);
                ImageView imageView3 = this.mItemsImageIv;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                    imageView3 = null;
                }
                imageView3.setVisibility(8);
                RoundRectImageView roundRectImageView2 = this.mNewDesktopImageView;
                if (roundRectImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewDesktopImageView");
                    roundRectImageView2 = null;
                }
                roundRectImageView2.setVisibility(0);
                RoundRectImageView roundRectImageView3 = this.mNewDesktopImageView;
                if (roundRectImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewDesktopImageView");
                    roundRectImageView3 = null;
                }
                roundRectImageView3.setImageDrawable(icon);
            }
            ArrayList<String> arrayList = desktopAppInfo.mMiniAppInfo.motionPics;
            if (arrayList != null && arrayList.size() > 0) {
                MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper2 = this.mViewFlipper;
                if (miniAppRecommdExtendViewFlipper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                    miniAppRecommdExtendViewFlipper2 = null;
                }
                miniAppRecommdExtendViewFlipper2.setVisibility(0);
                MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper3 = this.mViewFlipper;
                if (miniAppRecommdExtendViewFlipper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                    miniAppRecommdExtendViewFlipper3 = null;
                }
                if (miniAppRecommdExtendViewFlipper3.mHandler == null) {
                    MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper4 = this.mViewFlipper;
                    if (miniAppRecommdExtendViewFlipper4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                        miniAppRecommdExtendViewFlipper4 = null;
                    }
                    MiniAppRecommdExtendViewFlipper.ViewFlipperHandler viewFlipperHandler = new MiniAppRecommdExtendViewFlipper.ViewFlipperHandler(miniAppRecommdExtendViewFlipper4);
                    MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper5 = this.mViewFlipper;
                    if (miniAppRecommdExtendViewFlipper5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                        miniAppRecommdExtendViewFlipper5 = null;
                    }
                    miniAppRecommdExtendViewFlipper5.mHandler = viewFlipperHandler;
                }
                Iterator<String> it = desktopAppInfo.mMiniAppInfo.motionPics.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    ImageView imageView4 = new ImageView(getRootView().getContext());
                    imageView4.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    imageView4.setImageDrawable(MiniAppUtils.getIcon(getRootView().getContext(), next, true));
                    imageView4.setScaleType(ImageView.ScaleType.CENTER);
                    MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper6 = this.mViewFlipper;
                    if (miniAppRecommdExtendViewFlipper6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                        miniAppRecommdExtendViewFlipper6 = null;
                    }
                    miniAppRecommdExtendViewFlipper6.addView(imageView4);
                }
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                this.mIconAnimIn = translateAnimation;
                translateAnimation.setDuration(700L);
                TranslateAnimation translateAnimation2 = this.mIconAnimIn;
                if (translateAnimation2 != null) {
                    translateAnimation2.setInterpolator(new SpringTranslationInterpolator(0.4f));
                }
                TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
                this.mIconAnimOut = translateAnimation3;
                translateAnimation3.setDuration(100L);
                TranslateAnimation translateAnimation4 = this.mIconAnimOut;
                if (translateAnimation4 == null) {
                    return;
                }
                translateAnimation4.setInterpolator(new AccelerateInterpolator());
                return;
            }
            MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper7 = this.mViewFlipper;
            if (miniAppRecommdExtendViewFlipper7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                miniAppRecommdExtendViewFlipper7 = null;
            }
            miniAppRecommdExtendViewFlipper7.setVisibility(8);
            MiniAppRecommdExtendViewFlipper miniAppRecommdExtendViewFlipper8 = this.mViewFlipper;
            if (miniAppRecommdExtendViewFlipper8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewFlipper");
                miniAppRecommdExtendViewFlipper8 = null;
            }
            miniAppRecommdExtendViewFlipper8.mHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.rjn);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.miniapp_items_image)");
            RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById;
            this.mNewDesktopImageView = roundRectImageView;
            if (roundRectImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewDesktopImageView");
                roundRectImageView = null;
            }
            roundRectImageView.setCornerRadiusAndMode(ViewUtils.dip2px(24.0f), 1);
            View findViewById2 = containerView.findViewById(R.id.rjn);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.miniapp_items_image)");
            ImageView imageView = (ImageView) findViewById2;
            this.mItemsImageIv = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                imageView = null;
            }
            if (imageView instanceof ThemeImageView) {
                ImageView imageView2 = this.mItemsImageIv;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                    imageView2 = null;
                }
                Intrinsics.checkNotNull(imageView2, "null cannot be cast to non-null type com.tencent.widget.ThemeImageView");
                ((ThemeImageView) imageView2).setSupportMaskView(false);
            }
            ImageView imageView3 = this.mItemsImageIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemsImageIv");
                imageView3 = null;
            }
            imageView3.setForeground(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppRvItemIconSection$SpringTranslationInterpolator;", "Landroid/view/animation/Interpolator;", "factor", "", "(F)V", "getInterpolation", "input", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class SpringTranslationInterpolator implements Interpolator {
        private final float factor;

        public SpringTranslationInterpolator(float f16) {
            this.factor = f16;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return (float) ((Math.pow(2.0d, (-10) * input) * Math.sin(((input - (r2 / 4)) * 6.283185307179586d) / this.factor)) + 1);
        }
    }
}
