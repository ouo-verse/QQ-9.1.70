package com.tencent.ams.fusion.widget.olympic2024;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.ams.fusion.widget.olympic2024.GalleryItemView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicGalleryView extends HorizontalScrollView implements GalleryItemView.VideoStatusListener {
    static IPatchRedirector $redirector_ = null;
    private static final float CARD_SCALE_FACTOR = 1.08f;
    private static final int END_PAGE_INTERVAL = 300;
    private static final int FIRST_CARD_KEEP_TIME = 660;
    private static final int FIRST_CARD_SHOWN_LEFT_OFFSET;
    private static final int GALLERY_ITEM_MAX_COUNT = 6;
    private static final int ITEM_CHANGE_INTERVAL = 100;
    private static final int ITEM_MOVE_INTERVAL = 1000;
    private static final int ITEM_SCROLL_INTERVAL = 300;
    private static final int ONE_FRAME_INTERVAL = 16;
    public static final int OPENING_CEREMONY = 1;
    private static final float OPENING_CEREMONY_CARD_PERCENT = 0.925f;
    private static final int OPENING_CEREMONY_CARD_SHOW_GAP;
    private static final float OPENING_CEREMONY_LEFT_MARGIN_PERCENT = 0.037499994f;
    private static final String TAG = "OlympicGalleryView";
    public static final int WIN_GOLD = 0;
    private static final int WIN_GOLD_CARD_SHOW_GAP;
    private final AutoMoveTask mAutoMoveTask;
    private LinearLayout mContainer;
    private int mCurrentItemIndex;
    private int mDestScrollX;
    private volatile boolean mFirstMoveStarted;
    private final Runnable mFirstMoveTask;
    private int mGalleryType;
    private Runnable mImmediatelyMoveTask;
    private GalleryItemListener mItemListener;
    private List<GalleryItemView> mItemViews;
    private int mLeftMargin;
    private volatile boolean mNeedResumeFirstMoveTask;
    private volatile boolean mPaused;
    private Scroller mScroller;
    private List<Integer> mVideoCompletedList;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class AutoMoveTask implements Runnable {
        static IPatchRedirector $redirector_;
        private final OlympicGalleryView mGalleryView;
        private int mItemIndexToMove;

        public AutoMoveTask(OlympicGalleryView olympicGalleryView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) olympicGalleryView);
            } else {
                this.mGalleryView = olympicGalleryView;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            GalleryItemView galleryItemView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            OlympicGalleryView olympicGalleryView = this.mGalleryView;
            if (olympicGalleryView != null && !Utils.isEmpty(olympicGalleryView.mItemViews)) {
                if (this.mGalleryView.mPaused) {
                    Logger.e(OlympicGalleryView.TAG, "AutoMoveTask run paused return.");
                    return;
                }
                if (this.mItemIndexToMove >= this.mGalleryView.mItemViews.size() - 2) {
                    return;
                }
                Logger.d(OlympicGalleryView.TAG, " start auto move --- " + this.mItemIndexToMove);
                try {
                    this.mGalleryView.changeItemAlphaAndRotationWhenDismiss(this.mItemIndexToMove);
                    if (this.mGalleryView.mItemListener != null) {
                        this.mGalleryView.mItemListener.beforeItemSwitch(this.mItemIndexToMove, false);
                    }
                    int width = (((GalleryItemView) this.mGalleryView.mItemViews.get(this.mGalleryView.mCurrentItemIndex)).getWidth() + this.mGalleryView.mLeftMargin) - (this.mGalleryView.isOpeningCeremonyType() ? OlympicGalleryView.OPENING_CEREMONY_CARD_SHOW_GAP : OlympicGalleryView.WIN_GOLD_CARD_SHOW_GAP);
                    OlympicGalleryView olympicGalleryView2 = this.mGalleryView;
                    olympicGalleryView2.mDestScrollX = olympicGalleryView2.getScrollX() + width;
                    Logger.d(OlympicGalleryView.TAG, " auto move --- dx:" + width + " destX :" + this.mGalleryView.mDestScrollX);
                    this.mGalleryView.smoothScrollByWithDuration(width, 0, 300);
                    int i3 = this.mItemIndexToMove + 1;
                    this.mItemIndexToMove = i3;
                    long j3 = 1000;
                    if (i3 < this.mGalleryView.mItemViews.size() - 1 && (galleryItemView = (GalleryItemView) this.mGalleryView.mItemViews.get(this.mItemIndexToMove)) != null && galleryItemView.isVideoType()) {
                        galleryItemView.startVideo(300L);
                        j3 = Math.max(galleryItemView.getVideoDuration(), 1000L);
                    }
                    Logger.d(OlympicGalleryView.TAG, " launch next move task delay:" + j3 + 300);
                    Utils.runOnUiThread(this, j3 + 300);
                    this.mGalleryView.onSwitchToItem(this.mItemIndexToMove);
                    if (this.mGalleryView.mItemListener != null) {
                        this.mGalleryView.mItemListener.afterItemSwitch(this.mItemIndexToMove, false);
                    }
                } catch (Throwable th5) {
                    Logger.e(OlympicGalleryView.TAG, th5);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class ImmediatelyMoveTask implements Runnable {
        static IPatchRedirector $redirector_;
        private final OlympicGalleryView mGalleryView;

        public ImmediatelyMoveTask(OlympicGalleryView olympicGalleryView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) olympicGalleryView);
            } else {
                this.mGalleryView = olympicGalleryView;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            OlympicGalleryView olympicGalleryView = this.mGalleryView;
            if (olympicGalleryView == null || Utils.isEmpty(olympicGalleryView.mItemViews) || this.mGalleryView.mCurrentItemIndex > this.mGalleryView.mItemViews.size() - 2) {
                return;
            }
            Logger.d(OlympicGalleryView.TAG, " start move Immediately cx:" + this.mGalleryView.getScrollX() + " dx:" + this.mGalleryView.mDestScrollX);
            try {
                OlympicGalleryView olympicGalleryView2 = this.mGalleryView;
                olympicGalleryView2.changeItemAlphaAndRotationWhenDismiss(olympicGalleryView2.mCurrentItemIndex);
                if (this.mGalleryView.mItemListener != null) {
                    this.mGalleryView.mItemListener.beforeItemSwitch(this.mGalleryView.mCurrentItemIndex, true);
                }
                int width = (((GalleryItemView) this.mGalleryView.mItemViews.get(this.mGalleryView.mCurrentItemIndex)).getWidth() + this.mGalleryView.mLeftMargin) - (this.mGalleryView.isOpeningCeremonyType() ? OlympicGalleryView.OPENING_CEREMONY_CARD_SHOW_GAP : OlympicGalleryView.WIN_GOLD_CARD_SHOW_GAP);
                if (this.mGalleryView.getScrollX() < this.mGalleryView.mDestScrollX) {
                    i3 = this.mGalleryView.mDestScrollX - this.mGalleryView.getScrollX();
                } else {
                    i3 = 0;
                }
                OlympicGalleryView olympicGalleryView3 = this.mGalleryView;
                olympicGalleryView3.mDestScrollX = olympicGalleryView3.getScrollX() + width + i3;
                this.mGalleryView.smoothScrollByWithDuration(width + i3, 0, 300);
                OlympicGalleryView olympicGalleryView4 = this.mGalleryView;
                olympicGalleryView4.onSwitchToItem(olympicGalleryView4.mCurrentItemIndex + 1);
                if (this.mGalleryView.mItemListener != null) {
                    this.mGalleryView.mItemListener.afterItemSwitch(this.mGalleryView.mCurrentItemIndex, true);
                }
            } catch (Throwable th5) {
                Logger.e(OlympicGalleryView.TAG, th5);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18802);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        WIN_GOLD_CARD_SHOW_GAP = (int) Utils.dp2px(11.0f);
        OPENING_CEREMONY_CARD_SHOW_GAP = (int) Utils.dp2px(20.0f);
        FIRST_CARD_SHOWN_LEFT_OFFSET = (int) Utils.dp2px(15.0f);
    }

    public OlympicGalleryView(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.mGalleryType = 0;
        this.mCurrentItemIndex = Integer.MIN_VALUE;
        this.mItemViews = new ArrayList();
        this.mItemListener = null;
        this.mImmediatelyMoveTask = null;
        this.mVideoCompletedList = new CopyOnWriteArrayList();
        this.mNeedResumeFirstMoveTask = false;
        this.mFirstMoveTask = new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicGalleryView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (OlympicGalleryView.this.mPaused) {
                    Logger.d(OlympicGalleryView.TAG, "first move task return, pause");
                    OlympicGalleryView.this.mNeedResumeFirstMoveTask = true;
                    return;
                }
                Logger.d(OlympicGalleryView.TAG, "begin first move x:" + OlympicGalleryView.this.getScrollX());
                try {
                    if (!Utils.isEmpty(OlympicGalleryView.this.mItemViews) && OlympicGalleryView.this.mItemViews.get(0) != null && ((GalleryItemView) OlympicGalleryView.this.mItemViews.get(0)).getGalleryItem() != null) {
                        OlympicGalleryView.this.mFirstMoveStarted = true;
                        OlympicGalleryView.this.enlargeFirstCard();
                        OlympicGalleryView.this.changeFirstItemRotation();
                        int width = ((GalleryItemView) OlympicGalleryView.this.mItemViews.get(0)).getGalleryItem().getWidth(OlympicGalleryView.this.getContext());
                        if (OlympicGalleryView.this.isOpeningCeremonyType()) {
                            width = (int) (width * OlympicGalleryView.OPENING_CEREMONY_CARD_PERCENT);
                        }
                        int i16 = (width / 2) - OlympicGalleryView.FIRST_CARD_SHOWN_LEFT_OFFSET;
                        OlympicGalleryView.this.mDestScrollX = i16;
                        OlympicGalleryView.this.smoothScrollByWithDuration(i16, 0, 300);
                        OlympicGalleryView.this.onSwitchToItem(0);
                        Utils.runOnUiThread(OlympicGalleryView.this.mAutoMoveTask, 960L);
                    }
                } catch (Throwable unused) {
                }
            }
        };
        this.mAutoMoveTask = new AutoMoveTask(this);
        this.mGalleryType = i3;
        initViews(context, i3);
    }

    private void addItemView(GalleryItem galleryItem, int i3, int i16) {
        int i17;
        if (galleryItem != null && galleryItem.isValid()) {
            GalleryItemView galleryItemView = new GalleryItemView(getContext());
            this.mItemViews.add(galleryItemView);
            galleryItemView.setIndex(i3);
            galleryItemView.setGalleryItem(galleryItem, this.mGalleryType, i16);
            galleryItemView.setCompleteListener(this);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(0, 0);
            int width = galleryItem.getWidth(getContext());
            int winGoldHeight = galleryItem.getWinGoldHeight(getContext());
            marginLayoutParams.topMargin = (int) (Utils.getScreenWidth(getContext()) * galleryItem.getItemCenterYOffsetRatio(this.mGalleryType));
            this.mLeftMargin = (Utils.getScreenWidth(getContext()) / 2) - (galleryItem.getWidth(getContext()) / 2);
            if (isOpeningCeremonyType()) {
                width = (int) (width * OPENING_CEREMONY_CARD_PERCENT);
                winGoldHeight = (int) (galleryItem.getOpeningCeremonyHeight(getContext()) * OPENING_CEREMONY_CARD_PERCENT);
                this.mLeftMargin = (int) (this.mLeftMargin + (galleryItem.getWidth(getContext()) * OPENING_CEREMONY_LEFT_MARGIN_PERCENT));
            }
            marginLayoutParams.width = width;
            marginLayoutParams.height = winGoldHeight;
            if (isOpeningCeremonyType()) {
                i17 = OPENING_CEREMONY_CARD_SHOW_GAP;
            } else {
                i17 = WIN_GOLD_CARD_SHOW_GAP;
            }
            marginLayoutParams.leftMargin = Math.max(0, this.mLeftMargin - i17);
            if (i3 == 0) {
                marginLayoutParams.leftMargin = (Utils.getScreenWidth(getContext()) / 2) - FIRST_CARD_SHOWN_LEFT_OFFSET;
            }
            marginLayoutParams.rightMargin = 0;
            if (i3 == i16 - 1) {
                marginLayoutParams.rightMargin = this.mLeftMargin;
            }
            this.mContainer.addView(galleryItemView, marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeFirstItemRotation() {
        if (!Utils.isEmpty(this.mItemViews) && this.mItemViews.get(0) != null) {
            GalleryItemView galleryItemView = this.mItemViews.get(0);
            if (galleryItemView.getGalleryItem() != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.ROTATION, galleryItemView.getRotation(), galleryItemView.getGalleryItem().getDisplayRotation());
                ofFloat.setDuration(100L);
                ofFloat.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeItemAlphaAndRotationWhenDismiss(int i3) {
        GalleryItemView galleryItemView;
        Logger.d(TAG, "[changeItemAlphaWhenMoving] :" + i3);
        if (Utils.isEmpty(this.mItemViews) || i3 >= this.mItemViews.size() || (galleryItemView = this.mItemViews.get(i3)) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(galleryItemView, c.f123400v, 1.0f, 0.0f);
        if (isOpeningCeremonyType()) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.SCALE_X, OPENING_CEREMONY_CARD_PERCENT);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.SCALE_Y, OPENING_CEREMONY_CARD_PERCENT);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300L);
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            animatorSet.start();
            return;
        }
        if (galleryItemView.getGalleryItem() != null) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.ROTATION, galleryItemView.getRotation(), galleryItemView.getGalleryItem().getDismissRotation());
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(300L);
            animatorSet2.playTogether(ofFloat, ofFloat4);
            animatorSet2.start();
        }
    }

    private boolean checkVideoSrcExist(List<GalleryItem> list) {
        boolean z16;
        if (Utils.isEmpty(list)) {
            return false;
        }
        int i3 = 0;
        boolean z17 = false;
        while (true) {
            if (i3 < list.size()) {
                GalleryItem galleryItem = list.get(i3);
                if (galleryItem != null && !TextUtils.isEmpty(galleryItem.getVideoPath())) {
                    if (!new File(galleryItem.getVideoPath()).exists()) {
                        GalleryItemListener galleryItemListener = this.mItemListener;
                        if (galleryItemListener != null) {
                            galleryItemListener.onVideoItemError(i3, -100);
                        }
                        z16 = false;
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                }
                i3++;
            } else {
                z16 = true;
                break;
            }
        }
        Logger.d(TAG, "checkVideoSrcExist hasVideo:" + z17 + " videoSrcAllExist:" + z16);
        if (z17 && !z16) {
            Logger.i(TAG, "notify downgrade to all pic gallery!");
        }
        if (!z17 || !z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enlargeFirstCard() {
        GalleryItemView galleryItemView;
        if (this.mGalleryType != 1 || Utils.isEmpty(this.mItemViews) || (galleryItemView = this.mItemViews.get(0)) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.SCALE_X, CARD_SCALE_FACTOR);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.SCALE_Y, CARD_SCALE_FACTOR);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(50L);
        animatorSet.start();
    }

    private GalleryItemView getCurrentItem() {
        try {
            if (this.mCurrentItemIndex >= 0 && !Utils.isEmpty(this.mItemViews) && this.mCurrentItemIndex < this.mItemViews.size()) {
                return this.mItemViews.get(this.mCurrentItemIndex);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOpeningCeremonyType() {
        if (this.mGalleryType == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchToItem(int i3) {
        if (i3 >= 0 && i3 > this.mCurrentItemIndex) {
            this.mCurrentItemIndex = i3;
            GalleryItemListener galleryItemListener = this.mItemListener;
            if (galleryItemListener != null) {
                Logger.d(TAG, "notify onItemSwitch :" + i3);
                galleryItemListener.onItemSwitch(i3);
            }
        }
    }

    private List<GalleryItem> preProcessItemDatas(List<GalleryItem> list) {
        if (Utils.isEmpty(list)) {
            return null;
        }
        if (checkVideoSrcExist(list)) {
            return list;
        }
        if (list.size() < 6) {
            int size = 6 / list.size();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                for (GalleryItem galleryItem : list) {
                    if (galleryItem != null) {
                        arrayList.add(galleryItem.obtain());
                    }
                }
            }
            int size2 = 6 % list.size();
            if (size2 != 0) {
                for (int i16 = 0; i16 < size2; i16++) {
                    if (list.get(i16) != null) {
                        arrayList.add(list.get(i16).obtain());
                    }
                }
            }
            Logger.d(TAG, "preProcessItemDatas :" + arrayList.size());
            return arrayList;
        }
        return list;
    }

    public void changeItemAlphaAndRotationWhenShow(int i3, boolean z16) {
        int i16;
        GalleryItemView galleryItemView;
        float displayRotation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        Logger.d(TAG, "changeItemAlphaAndRotationWhenShow :" + i3);
        if (!Utils.isEmpty(this.mItemViews) && (i16 = i3 + 1) < this.mItemViews.size() && (galleryItemView = this.mItemViews.get(i16)) != null && galleryItemView.getGalleryItem() != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(galleryItemView, c.f123400v, galleryItemView.getGalleryItem().getInitAlpha(), galleryItemView.getGalleryItem().getDisplayAlpha());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(100L);
            if (isOpeningCeremonyType()) {
                animatorSet.playTogether(ofFloat, ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.SCALE_X, CARD_SCALE_FACTOR), ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.SCALE_Y, CARD_SCALE_FACTOR));
                animatorSet.start();
                return;
            }
            float[] fArr = new float[2];
            fArr[0] = galleryItemView.getRotation();
            if (z16) {
                displayRotation = 0.0f;
            } else {
                displayRotation = galleryItemView.getGalleryItem().getDisplayRotation();
            }
            fArr[1] = displayRotation;
            animatorSet.playTogether(ofFloat, ObjectAnimator.ofFloat(galleryItemView, BasicAnimation.KeyPath.ROTATION, fArr));
            animatorSet.start();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
    }

    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mItemViews.size();
    }

    public void initViews(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mContainer = linearLayout;
        linearLayout.setGravity(16);
        this.mContainer.setOrientation(0);
        this.mScroller = new Scroller(context);
        addView(this.mContainer);
    }

    public void onInteractiveSucceed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        GalleryItemView currentItem = getCurrentItem();
        if (currentItem == null) {
            return;
        }
        if (currentItem.isVideoType()) {
            currentItem.pauseVideo();
        }
        Utils.removeCallbacks(this.mAutoMoveTask);
        Utils.removeCallbacks(this.mFirstMoveTask);
        if (this.mImmediatelyMoveTask == null) {
            this.mImmediatelyMoveTask = new ImmediatelyMoveTask(this);
        }
        Utils.runOnUiThread(this.mImmediatelyMoveTask);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onScrollChanged(i3, i16, i17, i18);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.VideoStatusListener
    public void onVideoComplete(int i3, MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) mediaPlayer);
            return;
        }
        this.mVideoCompletedList.add(Integer.valueOf(i3));
        GalleryItemListener galleryItemListener = this.mItemListener;
        if (galleryItemListener != null) {
            galleryItemListener.onVideoItemComplete(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.VideoStatusListener
    public void onVideoError(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        GalleryItemListener galleryItemListener = this.mItemListener;
        if (galleryItemListener != null) {
            galleryItemListener.onVideoItemError(i3, i16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.VideoStatusListener
    public void onVideoPause(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        GalleryItemListener galleryItemListener = this.mItemListener;
        if (galleryItemListener != null) {
            galleryItemListener.onVideoItemPause(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.VideoStatusListener
    public void onVideoPlayUpdate(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        GalleryItemListener galleryItemListener = this.mItemListener;
        if (galleryItemListener != null) {
            galleryItemListener.onVideoItemPlayUpdate(i3, j3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.VideoStatusListener
    public void onVideoResume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        GalleryItemListener galleryItemListener = this.mItemListener;
        if (galleryItemListener != null) {
            galleryItemListener.onVideoItemResume(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemView.VideoStatusListener
    public void onVideoStarted(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        GalleryItemListener galleryItemListener = this.mItemListener;
        if (galleryItemListener != null) {
            galleryItemListener.onVideoItemStart(i3, j3);
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Logger.i(TAG, " gallery view pause ");
        this.mPaused = true;
        GalleryItemView currentItem = getCurrentItem();
        if (currentItem == null) {
            return;
        }
        if (currentItem.isVideoType()) {
            currentItem.pauseVideo();
        }
        Utils.removeCallbacks(this.mAutoMoveTask);
    }

    public void playTransitionPageAnimation() {
        int i3;
        GalleryItemView galleryItemView;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Logger.d(TAG, "playTransitionPageAnimation");
        if (!Utils.isEmpty(this.mItemViews) && (i3 = this.mCurrentItemIndex) >= 0 && i3 <= this.mItemViews.size() - 1) {
            GalleryItemView galleryItemView2 = this.mItemViews.get(this.mCurrentItemIndex);
            if (galleryItemView2 != null) {
                if (isOpeningCeremonyType()) {
                    f16 = 1.1664001f;
                } else {
                    f16 = CARD_SCALE_FACTOR;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(galleryItemView2, BasicAnimation.KeyPath.SCALE_X, f16);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(galleryItemView2, BasicAnimation.KeyPath.SCALE_Y, f16);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(300L);
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryView.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicGalleryView.this);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                            iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                        } else if (OlympicGalleryView.this.mItemListener != null) {
                            OlympicGalleryView.this.mItemListener.onEndAnimationFinish();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                            iPatchRedirector2.redirect((short) 5, (Object) this, (Object) animator);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                        } else if (OlympicGalleryView.this.mItemListener != null) {
                            OlympicGalleryView.this.mItemListener.onEndAnimationStart();
                        }
                    }
                });
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setStartDelay(500L);
                animatorSet.start();
            }
            int i16 = this.mCurrentItemIndex + 1;
            if (i16 >= 0 && i16 < this.mItemViews.size() && (galleryItemView = this.mItemViews.get(i16)) != null) {
                galleryItemView.setVisibility(4);
            }
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (!this.mPaused) {
            return;
        }
        this.mPaused = false;
        if (this.mNeedResumeFirstMoveTask) {
            Logger.i(TAG, "need resume FirstMoveTask");
            Utils.removeCallbacks(this.mFirstMoveTask);
            Utils.runOnUiThread(this.mFirstMoveTask, 300L);
            this.mNeedResumeFirstMoveTask = false;
            return;
        }
        GalleryItemView currentItem = getCurrentItem();
        if (currentItem == null) {
            return;
        }
        if (this.mVideoCompletedList.contains(Integer.valueOf(this.mCurrentItemIndex))) {
            Logger.e(TAG, "video completed can not start again.");
            return;
        }
        if (currentItem.isVideoType()) {
            currentItem.resumeVideo();
        }
        Logger.i(TAG, "gallery view resume autoMove");
        Utils.removeCallbacks(this.mAutoMoveTask);
        Utils.runOnUiThread(this.mAutoMoveTask);
    }

    public void setEndAnimationListener(GalleryItemListener galleryItemListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) galleryItemListener);
        } else {
            this.mItemListener = galleryItemListener;
        }
    }

    public void setItems(List<GalleryItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            return;
        }
        List<GalleryItem> preProcessItemDatas = preProcessItemDatas(list);
        if (Utils.isEmpty(preProcessItemDatas)) {
            Logger.w(TAG, "setItems: empty items");
            return;
        }
        for (int i3 = 0; i3 < preProcessItemDatas.size(); i3++) {
            addItemView(preProcessItemDatas.get(i3), i3, preProcessItemDatas.size());
        }
    }

    public void smoothScrollByWithDuration(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.mScroller.startScroll(getScrollX(), getScrollY(), i3, i16, i17);
            invalidate();
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (!this.mFirstMoveStarted) {
            Utils.runOnUiThread(this.mFirstMoveTask);
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        GalleryItemView currentItem = getCurrentItem();
        if (currentItem == null) {
            return;
        }
        if (currentItem.isVideoType()) {
            currentItem.stopVideo();
        }
        Utils.removeCallbacks(this.mAutoMoveTask);
        Utils.removeCallbacks(this.mFirstMoveTask);
        Utils.removeCallbacks(this.mImmediatelyMoveTask);
        this.mVideoCompletedList.clear();
    }
}
