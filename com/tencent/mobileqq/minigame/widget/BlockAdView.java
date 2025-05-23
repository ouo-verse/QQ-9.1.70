package com.tencent.mobileqq.minigame.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.util.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.utils.MiniAdAntiSpamForClickHelper;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BlockAdView extends RelativeLayout {
    public static final String AD_REF_ID = "biz_src_miniappD";
    public static final int SIDE_GAP_WIDTH_VERTICAL = 0;
    private static final String TAG = "[minigame]BlockAdView";
    private AnimatorSet animatorSet;
    private ArrayList<SingleBlockAdView> blockList;
    private boolean hasEndBlockAdAnimation;
    protected ImageView mAdIcon;
    private final MiniAdAntiSpamForClickHelper mAntiSpamForClickHelper;
    private boolean mIsHorizontal;
    protected LinearLayout mLinearLayout;
    private int mPlayCount;
    private int mRealAdNum;
    public static final int SIDE_GAP_WIDTH_HORIZONTAL = ViewUtils.dpToPx(4.0f);
    public static final int SIDE_GAP_HEIGHT_HORIZONTAL = ViewUtils.dpToPx(4.0f);
    public static final int SIDE_GAP_TOP_HORIZONTAL = ViewUtils.dpToPx(28.0f);
    public static final int SIDE_GAP_HEIGHT_VERTICAL = ViewUtils.dpToPx(4.0f);
    public static final int HORIZONTAL_HEIGHT = ViewUtils.dpToPx(65.0f);
    public static final int VERTICAL_WIDTH = ViewUtils.dpToPx(65.0f);
    public static final int HORIZONTAL_SINGLE_BLOCK_WIDTH = ViewUtils.dpToPx(65.0f);
    public static final int VERTICAL_SINGLE_BLOCK_HEIGHT = ViewUtils.dpToPx(73.0f);
    public static final int AD_TIP_MARGIN = ViewUtils.dpToPx(8.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class SingleBlockAdView extends RelativeLayout {
        private String mAppid;
        private Context mContext;
        private ImageView mIconView;
        private LayoutInflater mLayoutInflater;
        private TextView mNameView;
        private boolean mShowAdIcon;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.minigame.widget.BlockAdView$SingleBlockAdView$2, reason: invalid class name */
        /* loaded from: classes33.dex */
        public class AnonymousClass2 implements View.OnClickListener {
            final /* synthetic */ GdtAd val$gdtAd;

            AnonymousClass2(GdtAd gdtAd) {
                this.val$gdtAd = gdtAd;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$onClick$0(AdFeedbackDialogFragment.Result result) {
                QLog.e(BlockAdView.TAG, 1, String.valueOf(result.result.getErrorCode()));
                if (result.action != 3) {
                    return;
                }
                BlockAdManager.getInstance().hideAllBlockAdView();
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdFeedbackDialogFragment.Listener listener = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.mobileqq.minigame.widget.a
                    @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
                    public final void onResult(AdFeedbackDialogFragment.Result result) {
                        BlockAdView.SingleBlockAdView.AnonymousClass2.lambda$onClick$0(result);
                    }
                };
                AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
                adFeedbackParams.activity = new WeakReference<>((Activity) SingleBlockAdView.this.mContext);
                adFeedbackParams.listener = new WeakReference<>(listener);
                adFeedbackParams.f61346ad = this.val$gdtAd;
                adFeedbackParams.styleId = 0;
                if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
                    adFeedbackParams.styleId = 1;
                }
                try {
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
                } catch (Throwable th5) {
                    QLog.e(BlockAdView.TAG, 1, "innerOpenAdFeedBackDialog", th5);
                }
            }
        }

        public SingleBlockAdView(BlockAdView blockAdView, Context context, boolean z16) {
            this(context, null, 0, z16);
        }

        private void initUI(Context context) {
            this.mContext = context;
            LayoutInflater from = LayoutInflater.from(context);
            this.mLayoutInflater = from;
            from.inflate(R.layout.fi7, (ViewGroup) this, true);
            this.mIconView = (ImageView) findViewById(R.id.z9j);
            this.mNameView = (TextView) findViewById(R.id.z9k);
        }

        public SingleBlockAdView(BlockAdView blockAdView, Context context, AttributeSet attributeSet, boolean z16) {
            this(context, attributeSet, 0, z16);
        }

        public SingleBlockAdView(Context context, AttributeSet attributeSet, int i3, boolean z16) {
            super(context, attributeSet, i3);
            initUI(context);
            this.mShowAdIcon = z16;
        }

        public void setData(MiniAppInfo miniAppInfo, final GdtAd gdtAd, int i3, final String str) {
            if (miniAppInfo == null || TextUtils.isEmpty(miniAppInfo.iconUrl) || TextUtils.isEmpty(miniAppInfo.name)) {
                return;
            }
            this.mShowAdIcon = i3 < 3;
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                imageView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, miniAppInfo.iconUrl, true, 6));
            }
            TextView textView = this.mNameView;
            if (textView != null) {
                textView.setText(miniAppInfo.name);
            }
            BlockAdView.this.mAntiSpamForClickHelper.listenOnTouchEvent(this);
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.widget.BlockAdView.SingleBlockAdView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GdtHandler.Params params = new GdtHandler.Params();
                    params.processId = 11;
                    params.activity = new WeakReference<>((Activity) SingleBlockAdView.this.mContext);
                    params.f108486ad = gdtAd;
                    params.reportForClick = true;
                    params.appAutoDownload = true;
                    params.antiSpamParams = BlockAdView.this.mAntiSpamForClickHelper.getMiniAdAntiSpamForClickParams(BlockAdView.this.mAntiSpamForClickHelper.buildReportParams(BlockAdView.this.mLinearLayout));
                    Bundle bundle = new Bundle();
                    bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_miniappD");
                    params.extra = bundle;
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                    f.f109553a.a(view, 1, gdtAd, str);
                }
            });
            ImageView imageView2 = BlockAdView.this.mAdIcon;
            if (imageView2 == null) {
                return;
            }
            imageView2.setOnClickListener(new AnonymousClass2(gdtAd));
        }
    }

    public BlockAdView(Context context, boolean z16) {
        this(context, null, 0, z16);
    }

    private void adjustUIUsingNewData(BlockAdInfo blockAdInfo) {
        if (checkIsDataInvalid(blockAdInfo)) {
            this.mRealAdNum = 0;
            clearBlockAdAnimation();
            setVisibility(8);
            return;
        }
        if (this.mRealAdNum == 1 && this.mIsHorizontal) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i3 = SIDE_GAP_HEIGHT_HORIZONTAL;
            layoutParams.setMargins(0, i3, 0, i3);
            this.mLinearLayout.setLayoutParams(layoutParams);
        }
        List<GdtAd> subList = blockAdInfo.getGdtAdInfoList().subList(0, this.mRealAdNum);
        List<MiniAppInfo> subList2 = blockAdInfo.getBlockAdInfo().subList(0, this.mRealAdNum);
        clearBlockAdAnimation();
        this.mLinearLayout.removeAllViewsInLayout();
        for (int i16 = 0; i16 < this.mRealAdNum; i16++) {
            SingleBlockAdView singleBlockAdView = new SingleBlockAdView(this, getContext(), this.mRealAdNum < 3);
            singleBlockAdView.setData(subList2.get(i16), subList.get(i16), this.mRealAdNum, blockAdInfo.getCurrentMiniAppId());
            this.mLinearLayout.addView(singleBlockAdView);
            this.blockList.add(singleBlockAdView);
        }
        updateBackground(true);
        updateAdIcon(this.mRealAdNum > 0);
    }

    private boolean checkIsDataInvalid(BlockAdInfo blockAdInfo) {
        return this.mRealAdNum < 1 || blockAdInfo == null || blockAdInfo.getGdtAdInfoList() == null || blockAdInfo.getGdtAdInfoList().size() < this.mRealAdNum || blockAdInfo.getBlockAdInfo() == null || blockAdInfo.getBlockAdInfo().size() < this.mRealAdNum;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPlayCount() {
        return this.mPlayCount;
    }

    public static int getSafeGap() {
        return BlockAdManager.getInstance().gameDpTopx((BlockAdManager.getInstance().getDensity() > 3.0f ? 1 : (BlockAdManager.getInstance().getDensity() == 3.0f ? 0 : -1)) >= 0 ? 8 : 16);
    }

    private void init(Context context, boolean z16) {
        RelativeLayout.LayoutParams layoutParams;
        this.mIsHorizontal = z16;
        LinearLayout linearLayout = new LinearLayout(context);
        this.mLinearLayout = linearLayout;
        linearLayout.setOrientation(!z16 ? 1 : 0);
        if (z16) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i3 = SIDE_GAP_WIDTH_HORIZONTAL;
            layoutParams.setMargins(i3, SIDE_GAP_TOP_HORIZONTAL, i3, SIDE_GAP_HEIGHT_HORIZONTAL);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(VERTICAL_WIDTH, -2);
            layoutParams.setMargins(0, SIDE_GAP_TOP_HORIZONTAL, 0, SIDE_GAP_HEIGHT_VERTICAL);
        }
        this.mLinearLayout.setLayoutParams(layoutParams);
        addView(this.mLinearLayout);
        ImageView imageView = new ImageView(context);
        this.mAdIcon = imageView;
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.n0q));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(38.0f), ViewUtils.dpToPx(15.0f));
        int i16 = AD_TIP_MARGIN;
        layoutParams2.setMargins(i16, i16, 0, 0);
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        this.mAdIcon.setLayoutParams(layoutParams2);
        this.mAdIcon.setVisibility(8);
        addView(this.mAdIcon);
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    private void updateAdIcon(boolean z16) {
        ImageView imageView = this.mAdIcon;
        if (imageView == null) {
            return;
        }
        if (z16) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void destroy() {
        MiniAdAntiSpamForClickHelper miniAdAntiSpamForClickHelper = this.mAntiSpamForClickHelper;
        if (miniAdAntiSpamForClickHelper != null) {
            miniAdAntiSpamForClickHelper.onDestroy();
        }
        clearBlockAdAnimation();
    }

    public int getRealAdNum() {
        return this.mRealAdNum;
    }

    public int getRealHeight() {
        int i3;
        int i16;
        if (this.mIsHorizontal) {
            i3 = HORIZONTAL_HEIGHT;
            i16 = SIDE_GAP_HEIGHT_HORIZONTAL;
        } else {
            i3 = this.mRealAdNum * VERTICAL_SINGLE_BLOCK_HEIGHT;
            i16 = SIDE_GAP_HEIGHT_VERTICAL;
        }
        return i3 + (i16 * 2);
    }

    public int getRealWidth() {
        if (this.mIsHorizontal) {
            return (this.mRealAdNum * HORIZONTAL_SINGLE_BLOCK_WIDTH) + (SIDE_GAP_WIDTH_HORIZONTAL * 2);
        }
        return VERTICAL_WIDTH + 0;
    }

    public void setData(BlockAdInfo blockAdInfo) {
        BlockAdInfo calculateAndAdjustBlockAdInfo = calculateAndAdjustBlockAdInfo(blockAdInfo);
        if (calculateAndAdjustBlockAdInfo == null) {
            this.mRealAdNum = 0;
        }
        adjustUIUsingNewData(calculateAndAdjustBlockAdInfo);
    }

    public BlockAdView(Context context, AttributeSet attributeSet, boolean z16) {
        this(context, attributeSet, 0, z16);
    }

    private void startSingleBlockAnimation() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.ROTATION, 0.0f, 15.0f);
        ofFloat.setDuration(120L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.ROTATION, 15.0f, -15.0f);
        ofFloat2.setDuration(120L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.ROTATION, -15.0f, 15.0f);
        ofFloat3.setDuration(120L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.ROTATION, 15.0f, 0.0f);
        ofFloat4.setDuration(120L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        animatorSet.setInterpolator(new LinearInterpolator());
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        this.animatorSet.playSequentially(arrayList);
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.BlockAdView.3
            @Override // java.lang.Runnable
            public void run() {
                if (BlockAdView.this.hasEndBlockAdAnimation) {
                    return;
                }
                if (BlockAdView.this.getPlayCount() == 0) {
                    BlockAdView.this.animatorSet.setStartDelay(1000L);
                } else if (BlockAdView.this.getPlayCount() % 3 == 0) {
                    BlockAdView.this.animatorSet.setStartDelay(2520L);
                } else {
                    BlockAdView.this.animatorSet.setStartDelay(520L);
                }
                BlockAdView.this.animatorSet.start();
            }
        };
        handler.post(runnable);
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.minigame.widget.BlockAdView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BlockAdView.this.hasEndBlockAdAnimation) {
                    return;
                }
                BlockAdView.this.mPlayCount++;
                handler.post(runnable);
                super.onAnimationEnd(animator);
            }
        });
    }

    public void clearBlockAdAnimation() {
        this.hasEndBlockAdAnimation = true;
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.end();
            this.animatorSet.cancel();
            this.animatorSet.removeAllListeners();
        }
        ArrayList<SingleBlockAdView> arrayList = this.blockList;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mPlayCount = 0;
    }

    public void startBlockAnimation() {
        this.hasEndBlockAdAnimation = false;
        if (this.mRealAdNum == 1) {
            startSingleBlockAnimation();
        } else {
            startMultiBlockAnimation();
        }
    }

    public BlockAdView(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3);
        this.mIsHorizontal = false;
        this.mRealAdNum = 0;
        this.mPlayCount = 0;
        this.hasEndBlockAdAnimation = false;
        this.blockList = new ArrayList<>();
        this.mAntiSpamForClickHelper = new MiniAdAntiSpamForClickHelper();
        init(context, z16);
    }

    private void startMultiBlockAnimation() {
        float dip2px = ViewUtils.dip2px(5.0f);
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("translationY");
        objectAnimator.setFloatValues(0.0f, dip2px);
        ObjectAnimator objectAnimator2 = new ObjectAnimator();
        objectAnimator2.setPropertyName("translationY");
        objectAnimator2.setFloatValues(dip2px, 0.0f);
        ObjectAnimator objectAnimator3 = new ObjectAnimator();
        objectAnimator3.setPropertyName("translationY");
        objectAnimator3.setFloatValues(0.0f, dip2px);
        ObjectAnimator objectAnimator4 = new ObjectAnimator();
        objectAnimator4.setPropertyName("translationY");
        objectAnimator4.setFloatValues(dip2px, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        animatorSet.setInterpolator(new LinearInterpolator());
        ArrayList arrayList = new ArrayList();
        arrayList.add(objectAnimator);
        arrayList.add(objectAnimator2);
        arrayList.add(objectAnimator3);
        arrayList.add(objectAnimator4);
        this.animatorSet.setDuration(120L);
        this.animatorSet.playSequentially(arrayList);
        if (this.blockList.size() < 1) {
            return;
        }
        this.animatorSet.setTarget(this.blockList.get(0));
        this.animatorSet.start();
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.minigame.widget.BlockAdView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BlockAdView.this.hasEndBlockAdAnimation || BlockAdView.this.mRealAdNum == 0) {
                        return;
                    }
                    if (BlockAdView.this.getPlayCount() == 0) {
                        BlockAdView.this.animatorSet.setStartDelay(1000L);
                    } else if (BlockAdView.this.getPlayCount() % (BlockAdView.this.mRealAdNum * 2) == 0) {
                        BlockAdView.this.animatorSet.setStartDelay(BlockAdView.this.mRealAdNum * 600);
                    } else {
                        BlockAdView.this.animatorSet.setStartDelay(120L);
                    }
                    int playCount = BlockAdView.this.getPlayCount() % BlockAdView.this.mRealAdNum;
                    if (BlockAdView.this.blockList.size() <= 0 || BlockAdView.this.blockList.size() <= playCount) {
                        return;
                    }
                    BlockAdView.this.animatorSet.setTarget((SingleBlockAdView) BlockAdView.this.blockList.get(playCount));
                    BlockAdView.this.animatorSet.start();
                } catch (IndexOutOfBoundsException unused) {
                    QLog.e(BlockAdView.TAG, 1, "catch IndexOutOfBoundsException during aniPlayMulti because of clear");
                }
            }
        };
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.minigame.widget.BlockAdView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BlockAdView.this.hasEndBlockAdAnimation) {
                    return;
                }
                BlockAdView.this.mPlayCount++;
                handler.post(runnable);
                super.onAnimationEnd(animator);
            }
        });
        handler.post(runnable);
    }

    private void updateBackground(boolean z16) {
        if (z16) {
            setBackgroundDrawable(getResources().getDrawable(R.drawable.jyx));
        } else {
            setBackgroundColor(getResources().getColor(R.color.a6y));
        }
    }

    private BlockAdInfo calculateAndAdjustBlockAdInfo(BlockAdInfo blockAdInfo) {
        int i3;
        int i16;
        if (blockAdInfo == null) {
            return null;
        }
        int safeGap = getSafeGap();
        int i17 = safeGap * 2;
        int gameWidth = BlockAdManager.getInstance().getGameWidth() - i17;
        int gameHeight = BlockAdManager.getInstance().getGameHeight() - i17;
        int gameDpTopx = BlockAdManager.getInstance().gameDpTopx(blockAdInfo.getLeft());
        int gameDpTopx2 = BlockAdManager.getInstance().gameDpTopx(blockAdInfo.getTop());
        int size = blockAdInfo.getSize();
        this.mRealAdNum = size;
        if (gameDpTopx < safeGap || gameDpTopx2 < safeGap) {
            return null;
        }
        if (this.mIsHorizontal) {
            i16 = HORIZONTAL_HEIGHT + (SIDE_GAP_HEIGHT_HORIZONTAL * 2);
            if (gameDpTopx2 + i16 > gameHeight) {
                return null;
            }
            int i18 = HORIZONTAL_SINGLE_BLOCK_WIDTH;
            if (gameDpTopx + i18 > gameWidth) {
                return null;
            }
            int i19 = SIDE_GAP_WIDTH_HORIZONTAL;
            i3 = (size * i18) + (i19 * 2);
            if (gameDpTopx + i3 > gameWidth) {
                int i26 = ((gameWidth - gameDpTopx) - (i19 * 2)) / i18;
                this.mRealAdNum = i26;
                i3 = (i18 * i26) + (i19 * 2);
                if (i26 == 0) {
                    return null;
                }
            }
        } else {
            int i27 = VERTICAL_WIDTH + 0;
            if (gameDpTopx + i27 > gameWidth) {
                return null;
            }
            int i28 = VERTICAL_SINGLE_BLOCK_HEIGHT;
            if (gameDpTopx2 + i28 > gameHeight) {
                return null;
            }
            int i29 = size * i28;
            if (gameDpTopx2 + i29 > gameHeight) {
                int i36 = ((gameHeight - gameDpTopx2) + 0) / i28;
                this.mRealAdNum = i36;
                int i37 = i28 * i36;
                if (i36 == 0) {
                    return null;
                }
                i3 = i27;
                i16 = i37;
            } else {
                i3 = i27;
                i16 = i29;
            }
        }
        blockAdInfo.setRealWidth(ViewUtils.pxToDp(i3));
        blockAdInfo.setRealHeight(ViewUtils.pxToDp(i16));
        return blockAdInfo;
    }
}
