package com.tencent.richmediabrowser.animation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AnimationManager extends AbstractAnimationManager {
    public static final String KEY_THUMBNAL_BOUND = "KEY_THUMBNAL_BOUND";
    AnimationView animationView;
    View bgView;
    int densityDpi;
    private MainBrowserPresenter mMainBrowserPresenter;
    RelativeLayout mRoot;
    MainBrowserModel model;
    View recyclerView;
    View rootView;

    public AnimationManager(Context context, MainBrowserModel mainBrowserModel, RelativeLayout relativeLayout) {
        this.mRoot = relativeLayout;
        this.model = mainBrowserModel;
        this.densityDpi = context.getResources().getDisplayMetrics().densityDpi;
    }

    private Rect getAnimationEndDstRect() {
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null) {
            return mainBrowserPresenter.getAnimationEndDstRect();
        }
        return null;
    }

    private Drawable makeAnimationRect(Rect rect, Rect rect2, Rect rect3, Rect rect4, BrowserAnimation browserAnimation, boolean z16) {
        if (browserAnimation == null) {
            return null;
        }
        Drawable animationDrawable = browserAnimation.getAnimationDrawable();
        Rect thumbRect = browserAnimation.getThumbRect();
        if (thumbRect == null || animationDrawable == null || !browserAnimation.needAnimation(z16)) {
            return null;
        }
        int width = this.recyclerView.getWidth();
        int height = this.recyclerView.getHeight();
        int intrinsicWidth = animationDrawable.getIntrinsicWidth();
        int intrinsicHeight = animationDrawable.getIntrinsicHeight();
        rect2.set(0, 0, intrinsicWidth, intrinsicHeight);
        rect3.set(thumbRect);
        Rect animationEndDstRect = getAnimationEndDstRect();
        if (animationEndDstRect == null) {
            animationEndDstRect = AnimationUtils.getAnimationEndDstRect(intrinsicWidth, intrinsicHeight, width, height);
        }
        rect4.set(animationEndDstRect);
        return animationDrawable;
    }

    public void init() {
        this.recyclerView = this.mRoot.findViewById(R.id.i4l);
        this.animationView = (AnimationView) this.mRoot.findViewById(R.id.f164333s8);
        this.rootView = this.mRoot.findViewById(R.id.root);
        this.bgView = this.mRoot.findViewById(R.id.a4f);
    }

    @Override // com.tencent.richmediabrowser.animation.AbstractAnimationManager
    public void onDestroy() {
        super.onDestroy();
        AnimationView animationView = this.animationView;
        if (animationView != null) {
            animationView.onDestroy();
        }
    }

    @Override // com.tencent.richmediabrowser.animation.AnimationLister
    public void onEnterAnimationEnd() {
        this.mIsAnimating = false;
        this.animationView.setVisibility(4);
        Iterator<AnimationLister> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onEnterAnimationEnd();
        }
        this.listeners.clear();
    }

    @Override // com.tencent.richmediabrowser.animation.AnimationLister
    public void onEnterAnimationStart() {
        Iterator<AnimationLister> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onEnterAnimationStart();
        }
    }

    @Override // com.tencent.richmediabrowser.animation.AnimationLister
    public void onExitAnimationEnd() {
        this.mIsAnimating = false;
        this.animationView.setVisibility(4);
        Iterator<AnimationLister> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onExitAnimationEnd();
        }
        this.listeners.clear();
    }

    @Override // com.tencent.richmediabrowser.animation.AnimationLister
    public void onExitAnimationStart() {
        Iterator<AnimationLister> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onExitAnimationStart();
        }
    }

    public void setMainBrowserPresenter(MainBrowserPresenter mainBrowserPresenter) {
        this.mMainBrowserPresenter = mainBrowserPresenter;
    }

    @Override // com.tencent.richmediabrowser.animation.AbstractAnimationManager
    public boolean startEnterAnimation() {
        BrowserAnimation b16;
        boolean z16 = true;
        if (isAnimating()) {
            return true;
        }
        if (this.recyclerView == null) {
            init();
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        RichMediaBrowserInfo selectedItem = this.model.getSelectedItem();
        if (selectedItem == null || selectedItem.baseData == null || (b16 = this.mMainBrowserPresenter.getParamsBuilder().b(selectedItem.baseData)) == null) {
            return false;
        }
        Rect startSrcRect = b16.getStartSrcRect();
        Rect rect3 = new Rect();
        Drawable makeAnimationRect = makeAnimationRect(null, rect3, rect, rect2, b16, true);
        this.mIsAnimating = true;
        if (makeAnimationRect == null) {
            z16 = false;
        }
        this.isRectAnimation = z16;
        if (!z16) {
            this.animationView.setVisibility(4);
        } else {
            this.animationView.setVisibility(0);
            this.animationView.setAnimationListener(this);
            AnimationView animationView = this.animationView;
            animationView.isImgCenterCropMode = b16.isImgCenterCropMode;
            if (startSrcRect == null) {
                animationView.startEnterAnimation(makeAnimationRect, rect, rect2, b16.getCutValue(), this.animationDuring);
            } else {
                animationView.startEnterAnimationFreeMode(makeAnimationRect, startSrcRect, rect3, rect, rect2, this.animationDuring);
            }
        }
        return this.isRectAnimation;
    }

    @Override // com.tencent.richmediabrowser.animation.AbstractAnimationManager
    public boolean startExitAnimation() {
        BrowserAnimation b16;
        boolean z16 = true;
        if (isAnimating()) {
            return true;
        }
        if (this.recyclerView == null) {
            init();
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        RichMediaBrowserInfo selectedItem = this.model.getSelectedItem();
        if (selectedItem == null || selectedItem.baseData == null || (b16 = this.mMainBrowserPresenter.getParamsBuilder().b(selectedItem.baseData)) == null) {
            return false;
        }
        Rect startSrcRect = b16.getStartSrcRect();
        Rect rect3 = new Rect();
        Drawable makeAnimationRect = makeAnimationRect(startSrcRect, rect3, rect, rect2, b16, false);
        this.mIsAnimating = true;
        if (makeAnimationRect == null) {
            z16 = false;
        }
        this.isRectAnimation = z16;
        if (!z16) {
            this.animationView.setVisibility(4);
        } else {
            this.animationView.setVisibility(0);
            this.animationView.setAnimationListener(this);
            AnimationView animationView = this.animationView;
            animationView.isImgCenterCropMode = b16.isImgCenterCropMode;
            animationView.startBackAnimation(makeAnimationRect, rect, rect2, b16.getCutValue(), b16.getStartX(), b16.getStartY(), this.animationDuring);
            if (startSrcRect == null) {
                this.animationView.startBackAnimation(makeAnimationRect, rect, rect2, b16.getCutValue(), b16.getStartX(), b16.getStartY(), this.animationDuring);
            } else {
                this.animationView.startBackAnimationFreeMode(makeAnimationRect, startSrcRect, rect3, rect, rect2, this.animationDuring);
            }
        }
        return this.isRectAnimation;
    }
}
