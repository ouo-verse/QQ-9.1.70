package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.richmediabrowser.animation.AbstractAnimationManager;
import com.tencent.richmediabrowser.animation.AnimateUtils;
import com.tencent.richmediabrowser.animation.AnimationLister;
import com.tencent.richmediabrowser.animation.AnimationManager;
import com.tencent.richmediabrowser.animation.AnimationView;
import com.tencent.richmediabrowser.animation.IGalleryAnimationEvent;
import com.tencent.richmediabrowser.animation.ViscousFluidInterpolator;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.progress.AbstractProgressView;
import com.tencent.richmediabrowser.view.progress.GalleryProgressView;
import com.tencent.richmediabrowser.view.progress.ProgressViewHelper;
import com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter;
import com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScrollListener;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserBaseScene implements IGalleryAnimationEvent, AnimationLister {
    private static final String TAG = "GalleryBaseScene";
    private AbstractAnimationManager animationManager;
    protected View bgView;
    public BrowserRecyclerView.a brvTouchEventConsumer;
    public BrowserScaleView.a bsvCustomLister;
    private RelativeLayout contentView;
    private boolean isEnter = false;
    public LinearLayoutManager linearLayoutManager;
    public PagerSnapHelper linearSnapHelper;
    public BrowserAdapter mAdapter;
    public Context mContext;
    public RelativeLayout mRoot;
    public MainBrowserPresenter mainBrowserPresenter;
    protected AbstractProgressView progressView;
    protected ProgressViewHelper progressViewHelper;
    public BrowserRecyclerView recyclerView;
    protected RelativeLayout rootView;
    public BrowserScrollListener scrollListener;

    public BrowserBaseScene(Context context) {
        this.mContext = context;
    }

    public boolean back() {
        if (needExitRectAnimation()) {
            getAnimationManager().addAnimationListener(this);
            doExitAnimation(getAnimationManager().startExitAnimation());
            return false;
        }
        onExitAnimationEnd();
        return false;
    }

    public void buildParams(Intent intent) {
        BrowserScrollListener browserScrollListener = new BrowserScrollListener();
        this.scrollListener = browserScrollListener;
        browserScrollListener.setMainBrowserPresenter(this.mainBrowserPresenter);
    }

    public void buildView() {
        onCreate();
        RelativeLayout relativeLayout = this.mRoot;
        if (relativeLayout != null) {
            relativeLayout.addView(createAnimationView());
        }
        this.animationManager = createAnimationManager(this.mContext, this.mainBrowserPresenter.browserModel);
    }

    public AbstractAnimationManager createAnimationManager(Context context, MainBrowserModel mainBrowserModel) {
        AnimationManager animationManager = new AnimationManager(context, mainBrowserModel, this.mRoot);
        animationManager.setMainBrowserPresenter(this.mainBrowserPresenter);
        return animationManager;
    }

    public AnimationView createAnimationView() {
        AnimationView animationView = new AnimationView(this.mContext, null);
        animationView.setId(R.id.f164333s8);
        animationView.setVisibility(4);
        return animationView;
    }

    protected BrowserAdapter createGalleryAdapter(Context context) {
        return new BrowserAdapter(context);
    }

    protected AbstractProgressView createProgressBar() {
        return new GalleryProgressView();
    }

    @Override // com.tencent.richmediabrowser.animation.IGalleryAnimationEvent
    public void doEnterAnimation(boolean z16) {
        if (this.bgView.getAnimation() != null) {
            this.bgView.clearAnimation();
        }
        if (this.recyclerView.getAnimation() != null) {
            this.recyclerView.clearAnimation();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(getAnimationManager().getAnimationDuring());
        alphaAnimation.setFillAfter(true);
        if (z16) {
            this.bgView.startAnimation(alphaAnimation);
        } else {
            alphaAnimation.setAnimationListener(new AnimateUtils.AnimationAdapter() { // from class: com.tencent.richmediabrowser.view.BrowserBaseScene.1
                @Override // com.tencent.richmediabrowser.animation.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    BrowserBaseScene.this.getAnimationManager().onEnterAnimationEnd();
                    BrowserBaseScene.this.getAnimationManager().resetAnimationDuring();
                }

                @Override // com.tencent.richmediabrowser.animation.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    BrowserBaseScene.this.getAnimationManager().onEnterAnimationStart();
                }
            });
            getRootView().startAnimation(alphaAnimation);
        }
    }

    @Override // com.tencent.richmediabrowser.animation.IGalleryAnimationEvent
    public void doExitAnimation(boolean z16) {
        if (this.bgView.getAnimation() != null) {
            this.bgView.clearAnimation();
        }
        if (getRootView().getAnimation() != null) {
            getRootView().clearAnimation();
        }
        if (z16) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setFillAfter(true);
            this.bgView.startAnimation(alphaAnimation);
            alphaAnimation.setDuration(getAnimationManager().getAnimationDuring());
            return;
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setInterpolator(new ViscousFluidInterpolator());
        alphaAnimation2.setDuration(getAnimationManager().getAnimationDuring());
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, this.rootView.getWidth() / 2, this.rootView.getHeight() / 2);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        scaleAnimation.setDuration(getAnimationManager().getAnimationDuring());
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.addAnimation(alphaAnimation2);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new AnimateUtils.AnimationAdapter() { // from class: com.tencent.richmediabrowser.view.BrowserBaseScene.2
            @Override // com.tencent.richmediabrowser.animation.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BrowserBaseScene.this.getAnimationManager().onExitAnimationEnd();
                BrowserBaseScene.this.getAnimationManager().resetAnimationDuring();
            }

            @Override // com.tencent.richmediabrowser.animation.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                BrowserBaseScene.this.getAnimationManager().onExitAnimationStart();
            }
        });
        this.bgView.startAnimation(alphaAnimation2);
        this.recyclerView.startAnimation(animationSet);
    }

    public void enter() {
        if (this.isEnter) {
            return;
        }
        this.isEnter = true;
        if (needEnterRectAnimation()) {
            getAnimationManager().addAnimationListener(this);
            doEnterAnimation(getAnimationManager().startEnterAnimation());
        } else {
            setGalleryBlack();
            onEnterAnimationEnd();
        }
    }

    public AbstractAnimationManager getAnimationManager() {
        return this.animationManager;
    }

    public RelativeLayout getContentView() {
        return this.contentView;
    }

    public int getPosition(View view) {
        if (view != null) {
            return this.linearLayoutManager.getPosition(view);
        }
        return -1;
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public RelativeLayout getRootView() {
        return this.rootView;
    }

    public void hideProgress() {
        AbstractProgressView abstractProgressView = this.progressView;
        if (abstractProgressView != null) {
            abstractProgressView.hide();
        }
    }

    public boolean isAnimating() {
        return getAnimationManager().isAnimating();
    }

    public boolean needEnterRectAnimation() {
        return false;
    }

    public boolean needExitRectAnimation() {
        return false;
    }

    public void onCreate() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.fgn, (ViewGroup) null);
        this.mRoot = relativeLayout;
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).addContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        }
        this.rootView = (RelativeLayout) this.mRoot.findViewById(R.id.root);
        this.recyclerView = (BrowserRecyclerView) this.mRoot.findViewById(R.id.i4l);
        this.bgView = this.mRoot.findViewById(R.id.a4f);
        this.contentView = (RelativeLayout) this.rootView.findViewById(R.id.content);
        AbstractProgressView createProgressBar = createProgressBar();
        this.progressView = createProgressBar;
        if (createProgressBar != null) {
            createProgressBar.init(this.mContext, this);
        }
        this.progressViewHelper = new ProgressViewHelper();
        BrowserAdapter createGalleryAdapter = createGalleryAdapter(this.mContext);
        this.mAdapter = createGalleryAdapter;
        createGalleryAdapter.setPresenter(this.mainBrowserPresenter);
        AbstractProgressView abstractProgressView = this.progressView;
        if (abstractProgressView != null) {
            this.progressViewHelper.setProgressView(abstractProgressView);
            this.progressView.show();
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 0, false);
        this.linearLayoutManager = linearLayoutManager;
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(this.mAdapter);
        this.recyclerView.addOnScrollListener(this.scrollListener);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.linearSnapHelper = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.recyclerView);
        this.recyclerView.setMainBrowserPresenter(this.mainBrowserPresenter);
        this.recyclerView.setLinearLayoutManager(this.linearLayoutManager);
        this.recyclerView.setPageSnapHelper(this.linearSnapHelper);
        this.mRoot.setVisibility(0);
    }

    public void onDestroy() {
        AbstractAnimationManager abstractAnimationManager = this.animationManager;
        if (abstractAnimationManager != null) {
            abstractAnimationManager.onDestroy();
        }
    }

    @Override // com.tencent.richmediabrowser.animation.AnimationLister
    public void onEnterAnimationEnd() {
        BrowserRecyclerView browserRecyclerView = this.recyclerView;
        if (browserRecyclerView != null && browserRecyclerView.getVisibility() != 0) {
            this.recyclerView.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.mRoot;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.richmediabrowser.animation.AnimationLister
    public void onEnterAnimationStart() {
        BrowserRecyclerView browserRecyclerView;
        if (this.mainBrowserPresenter != null && getAnimationManager().isRectAnimation && (browserRecyclerView = this.recyclerView) != null) {
            browserRecyclerView.setVisibility(4);
        }
    }

    @Override // com.tencent.richmediabrowser.animation.AnimationLister
    public void onExitAnimationEnd() {
        if (this.mContext != null) {
            BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "BrowserBaseScene.onExitAnimationEnd[" + this.mContext.hashCode() + "]");
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
    }

    @Override // com.tencent.richmediabrowser.animation.AnimationLister
    public void onExitAnimationStart() {
        BrowserRecyclerView browserRecyclerView;
        if (this.mainBrowserPresenter != null && getAnimationManager().isRectAnimation && (browserRecyclerView = this.recyclerView) != null) {
            browserRecyclerView.setVisibility(4);
        }
        AbstractProgressView abstractProgressView = this.progressView;
        if (abstractProgressView != null && abstractProgressView.isShow()) {
            this.progressView.hide();
        }
    }

    public void onItemSelected(int i3) {
        AbstractProgressView abstractProgressView;
        if (!isAnimating() && (abstractProgressView = this.progressView) != null && !abstractProgressView.isShow()) {
            this.progressView.show();
        }
        BrowserLogHelper.getInstance().getGalleryLog().i(TAG, 2, "GalleryBaseView.onItemSelected(): position=" + i3);
    }

    public void onLoadFinish(int i3, boolean z16) {
        this.progressViewHelper.onLoadFinish(i3, z16);
    }

    public void onLoadStart(int i3, int i16) {
        this.progressViewHelper.onLoadStart(i3, i16);
    }

    public void onLoadSuccessed(int i3, boolean z16) {
        this.progressViewHelper.onLoadFinish(i3, z16);
    }

    public void onWindowFocusChanged() {
        enter();
        this.mRoot.setVisibility(0);
    }

    public void setGalleryBlack() {
        BrowserRecyclerView browserRecyclerView = this.recyclerView;
        if (browserRecyclerView != null) {
            browserRecyclerView.setBackgroundColor(-16777216);
        }
    }

    public void showContentView(boolean z16) {
        int i3;
        RelativeLayout relativeLayout = this.contentView;
        if (relativeLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
        }
    }

    protected void updateSystemUIVisablity() {
        this.mRoot.setSystemUiVisibility(4);
    }

    public void buildComplete() {
    }
}
