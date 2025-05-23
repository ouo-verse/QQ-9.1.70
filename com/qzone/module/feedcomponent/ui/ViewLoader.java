package com.qzone.module.feedcomponent.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.module.feedcomponent.util.MultiHashMap;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import cooperation.qzone.util.TimeCostTrace;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ViewLoader {
    public static final int PRE_LOAD_FEEDVIEW_IN_CONTAINER_QUANTITY = 5;
    static final String TAG = "ViewLoader";
    public static ViewLoader mInstance;
    boolean mFriendAnniversaryFeedView;
    boolean mFunctionGuideFeedView;
    boolean mLoadFeedView;
    boolean mLoadFeedViewInAdvContainer;
    boolean mLoadFeedViewInContainer;
    boolean mLoadFeedViewInGalleryContainer;
    boolean mLoadFeedViewWithDateList;
    RegisterAnniversaryFeedView mRegisterAnniversaryFeedViewCache;
    boolean mRegisterAnniversaryFeedViewCached;
    boolean mVerticalRecommendFriendsFeedView;
    String themeId;
    public SubViewHolder<CellTextView> mCellTextView = new SubViewHolder<>();
    final ConcurrentLinkedQueue<FeedView> mFeedViewList = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FeedView> mFeedViewWithDateList = new ConcurrentLinkedQueue<>();
    final MultiHashMap<Integer, FeedView> mFeedViewCacheMap = new MultiHashMap<>();
    final ConcurrentLinkedQueue<FeedContainer> mFeedContainerCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FeedView> mFeedViewInContainerCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FeedAdvContainer> mFeedAdvContainerCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FeedView> mFeedViewInAdvContainerCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FeedGalleryContainer> mFeedGalleryContainerCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FeedView> mFeedViewInGalleryContainerCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FunctionGuideFeedView> mFunctionGuideFeedViewCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FriendAnniversaryFeedView> mFriendAnniversaryFeedViewCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<NegativeFeedbackFeedView> mNegativeFeedbackFeedViewCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<RecomFollowVerticalFeedView> mRecomFollowVerticalViewCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FriendVideoFeedView> mFriendVideoFeedViewCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<FrdLikeVideoFeedView> mFrdLikeVideoFeedViewCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<NewGuideView> mNewGuideViewCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<IssuedFeedView> mIssuedFeedViewCache = new ConcurrentLinkedQueue<>();
    final ConcurrentLinkedQueue<BirthdayCardFeedView> mBirthdayCardFeedViewCache = new ConcurrentLinkedQueue<>();
    Context mContext = FeedGlobalEnv.getContext();

    ViewLoader() {
    }

    public static ViewLoader getInstance() {
        if (mInstance == null) {
            mInstance = new ViewLoader();
        }
        return mInstance;
    }

    public void clear() {
        this.mFeedViewList.clear();
        this.mFeedViewCacheMap.clear();
        this.mFeedViewWithDateList.clear();
        this.mFeedContainerCache.clear();
        this.mFeedAdvContainerCache.clear();
        this.mFeedGalleryContainerCache.clear();
    }

    public void loadAdvFeedView(Context context, com.qzone.proxy.feedcomponent.ui.g gVar) {
        if (!this.mLoadFeedViewInContainer) {
            this.mLoadFeedViewInContainer = true;
            ConcurrentLinkedQueue<FeedView> concurrentLinkedQueue = this.mFeedViewInContainerCache;
            for (int i3 = 0; i3 < 3; i3++) {
                concurrentLinkedQueue.add((FeedView) com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().generateFeedView(context, gVar, false, true));
            }
            this.mFeedContainerCache.add(new FeedContainer(context));
        }
        if (!this.mLoadFeedViewInAdvContainer) {
            this.mLoadFeedViewInAdvContainer = true;
            ConcurrentLinkedQueue<FeedView> concurrentLinkedQueue2 = this.mFeedViewInAdvContainerCache;
            for (int i16 = 0; i16 < 5; i16++) {
                concurrentLinkedQueue2.add((FeedView) com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().generateFeedView(context, gVar, false, true));
            }
            ConcurrentLinkedQueue<FeedAdvContainer> concurrentLinkedQueue3 = this.mFeedAdvContainerCache;
            for (int i17 = 0; i17 < 2; i17++) {
                concurrentLinkedQueue3.add(new FeedAdvContainer(context, null));
            }
        }
        if (!this.mFunctionGuideFeedView) {
            this.mFunctionGuideFeedView = true;
            ConcurrentLinkedQueue<FunctionGuideFeedView> concurrentLinkedQueue4 = this.mFunctionGuideFeedViewCache;
            for (int i18 = 0; i18 < 2; i18++) {
                concurrentLinkedQueue4.add((FunctionGuideFeedView) com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().gererateFunctionGuideFeedView(context));
            }
        }
        if (!this.mFriendAnniversaryFeedView) {
            this.mFriendAnniversaryFeedView = true;
            ConcurrentLinkedQueue<FriendAnniversaryFeedView> concurrentLinkedQueue5 = this.mFriendAnniversaryFeedViewCache;
            for (int i19 = 0; i19 < 2; i19++) {
                concurrentLinkedQueue5.add((FriendAnniversaryFeedView) com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().gererateFriendAnniversaryFeedView(context));
            }
        }
        if (this.mRegisterAnniversaryFeedViewCached) {
            return;
        }
        this.mRegisterAnniversaryFeedViewCached = true;
        this.mRegisterAnniversaryFeedViewCache = new RegisterAnniversaryFeedView(context);
    }

    public FeedAdvContainer obtainFeedAdvContainer(Context context, BusinessFeedData businessFeedData) {
        FeedAdvContainer poll = this.mFeedAdvContainerCache.poll();
        return poll == null ? new FeedAdvContainer(context, businessFeedData) : poll;
    }

    public BirthdayCardFeedView obtainFeedBirthdayContainer(Context context, BusinessFeedData businessFeedData) {
        BirthdayCardFeedView poll = this.mBirthdayCardFeedViewCache.poll();
        return poll == null ? new BirthdayCardFeedView(context, businessFeedData) : poll;
    }

    public FeedContainer obtainFeedContainer(Context context) {
        FeedContainer poll = this.mFeedContainerCache.poll();
        return poll == null ? new FeedContainer(context) : poll;
    }

    public FeedGalleryContainer obtainFeedGalleryContainer(Context context, BusinessFeedData businessFeedData) {
        FeedGalleryContainer poll = this.mFeedGalleryContainerCache.poll();
        return poll == null ? new FeedGalleryContainer(context, businessFeedData) : poll;
    }

    public FeedView obtainFeedViewInContainer(Context context) {
        FeedView poll = this.mFeedViewInContainerCache.poll();
        return poll == null ? FeedViewBuilder.generateFeedView(context, null, false, true) : poll;
    }

    public FrdLikeVideoFeedView obtainFrdLikeVideoFeedView(Context context) {
        FrdLikeVideoFeedView poll = this.mFrdLikeVideoFeedViewCache.poll();
        return poll == null ? new FrdLikeVideoFeedView(context) : poll;
    }

    public FrdLikeVideoSlideFeedView obtainFrdLikeVideoSlideFeedView(Context context) {
        return new FrdLikeVideoSlideFeedView(context);
    }

    public FriendAnniversaryFeedView obtainFriendAnniversyFeedView(Context context) {
        FriendAnniversaryFeedView poll = this.mFriendAnniversaryFeedViewCache.poll();
        return poll == null ? new FriendAnniversaryFeedView(context) : poll;
    }

    public FriendVideoFeedView obtainFriendVideoFeedView(Context context) {
        FriendVideoFeedView poll = this.mFriendVideoFeedViewCache.poll();
        return poll == null ? new FriendVideoFeedView(context) : poll;
    }

    public FunctionGuideFeedView obtainFunctionGuideFeedView(Context context) {
        FunctionGuideFeedView poll = this.mFunctionGuideFeedViewCache.poll();
        return poll == null ? new FunctionGuideFeedView(context) : poll;
    }

    public NegativeFeedbackFeedView obtainNegativeFeedbackFeedView(Context context) {
        NegativeFeedbackFeedView poll = this.mNegativeFeedbackFeedViewCache.poll();
        return poll == null ? new NegativeFeedbackFeedView(context) : poll;
    }

    public NewGuideView obtainNewGuideView(Context context) {
        NewGuideView poll = this.mNewGuideViewCache.poll();
        return poll == null ? new NewGuideView(context) : poll;
    }

    public FunctionGuideFeedView obtainNewJoinUserFeedView(Context context) {
        FunctionGuideFeedView poll = this.mFunctionGuideFeedViewCache.poll();
        return poll == null ? new FunctionGuideFeedView(context) : poll;
    }

    public IssuedFeedView obtainNewUserFeedView(Context context) {
        IssuedFeedView poll = this.mIssuedFeedViewCache.poll();
        return poll == null ? new IssuedFeedView(context) : poll;
    }

    public RegisterAnniversaryFeedView obtainRegisterAnniversyFeedView(Context context) {
        RegisterAnniversaryFeedView registerAnniversaryFeedView = this.mRegisterAnniversaryFeedViewCache;
        if (registerAnniversaryFeedView != null) {
            return registerAnniversaryFeedView;
        }
        RegisterAnniversaryFeedView registerAnniversaryFeedView2 = new RegisterAnniversaryFeedView(context);
        this.mRegisterAnniversaryFeedViewCache = registerAnniversaryFeedView2;
        return registerAnniversaryFeedView2;
    }

    public RecomFollowVerticalFeedView obtainVerticalRecomFollowFeedView(Context context) {
        RecomFollowVerticalFeedView poll = this.mRecomFollowVerticalViewCache.poll();
        return poll == null ? new RecomFollowVerticalFeedView(context) : poll;
    }

    public void recycleFeedViewInAdvContainer(FeedView feedView) {
        if (this.mFeedViewInAdvContainerCache.contains(feedView)) {
            return;
        }
        this.mFeedViewInAdvContainerCache.add(feedView);
    }

    public synchronized void recyleFeedView(boolean z16, int i3) {
        MultiHashMap<Integer, FeedView> multiHashMap = this.mFeedViewCacheMap;
        if (multiHashMap != null && multiHashMap.sizeOf(Integer.valueOf(i3)) != 0) {
            for (FeedView feedView : this.mFeedViewCacheMap.get((Object) Integer.valueOf(i3))) {
                if (feedView.getParent() != null) {
                    this.mFeedViewCacheMap.remove(Integer.valueOf(i3), feedView);
                    com.qzone.proxy.feedcomponent.b.c("recyleFeedView", " feedview has parent" + feedView);
                } else {
                    feedView.setOnFeedElementClickListener(null);
                    feedView.setOnClickListener(null);
                    feedView.setOnLongClickListener(null);
                    feedView.setTag(null);
                    feedView.setOnKeyListener(null);
                    feedView.setOnFocusChangeListener(null);
                    feedView.setOnTouchListener(null);
                    feedView.setOnCreateContextMenuListener(null);
                    feedView.setOnFeedEventListener(null);
                    feedView.onRecycled();
                    if (z16) {
                        if (!this.mFeedViewWithDateList.contains(feedView) && !(feedView.getContext() instanceof Activity)) {
                            this.mFeedViewWithDateList.add(feedView);
                        } else {
                            com.qzone.proxy.feedcomponent.b.c("recyleFeedView", " mFeedViewWithDateList has double");
                        }
                    } else if (!this.mFeedViewList.contains(feedView) && !(feedView.getContext() instanceof Activity)) {
                        this.mFeedViewList.add(feedView);
                    } else {
                        com.qzone.proxy.feedcomponent.b.c("recyleFeedView ", "mFeedViewList has double");
                    }
                }
            }
            this.mFeedViewCacheMap.remove((Object) Integer.valueOf(i3));
        }
    }

    public void recyleFeedViewInContainer(FeedView feedView) {
        if (this.mFeedViewInContainerCache.contains(feedView)) {
            return;
        }
        this.mFeedViewInContainerCache.add(feedView);
    }

    public void loadFeedView(int i3, int i16, Context context, com.qzone.proxy.feedcomponent.ui.g gVar, boolean z16) {
        if (z16) {
            loadFeedViewToList(i3, i16, context, gVar, z16);
        } else {
            loadFeedViewToList(i3, i16, context, gVar, z16);
        }
    }

    void loadFeedViewToList(int i3, int i16, Context context, com.qzone.proxy.feedcomponent.ui.g gVar, boolean z16) {
        ConcurrentLinkedQueue<FeedView> concurrentLinkedQueue;
        if (z16) {
            concurrentLinkedQueue = this.mFeedViewWithDateList;
        } else {
            concurrentLinkedQueue = this.mFeedViewList;
        }
        for (int i17 = 0; i17 < i16; i17++) {
            if (concurrentLinkedQueue.size() >= i3) {
                return;
            }
            System.currentTimeMillis();
            concurrentLinkedQueue.add(FeedViewBuilder.generateFeedView(context, gVar, z16, false));
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.qzone.proxy.feedcomponent.b.a(TimeCostTrace.TAG_QZONE_LAUNCH, "loadFeedViewToList end");
        com.qzone.proxy.feedcomponent.b.a(TimeCostTrace.TAG_QZONE_LAUNCH, "preload class cache cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public FeedView obtianFeedView(Context context, com.qzone.proxy.feedcomponent.ui.g gVar, boolean z16, boolean z17, int i3) {
        FeedView poll;
        if (z16) {
            poll = this.mFeedViewWithDateList.poll();
        } else {
            poll = this.mFeedViewList.poll();
        }
        com.qzone.proxy.feedcomponent.b.c("FeedView", "obtianFeedView from cache,FeedView:" + poll);
        if (poll != null) {
            poll.setOnFeedElementClickListener(gVar);
            poll.setBlankListener();
        } else {
            poll = FeedViewBuilder.generateFeedView(context, gVar, z16, z17);
        }
        com.qzone.proxy.feedcomponent.b.c("FeedView", "obtianFeedView end.");
        if (i3 < 0) {
            if (com.qzone.adapter.feedcomponent.i.H().X0()) {
                throw new RuntimeException("ActivityId should not be less than 0");
            }
            return poll;
        }
        if (poll != null) {
            this.mFeedViewCacheMap.add(Integer.valueOf(i3), poll);
        }
        return poll;
    }

    public void recycleFunctionGuideFeedView(AbsFeedView absFeedView) {
        if (absFeedView == null || !(absFeedView instanceof FunctionGuideFeedView)) {
            return;
        }
        this.mFunctionGuideFeedViewCache.add((FunctionGuideFeedView) absFeedView);
    }

    public void recycleFeedAdvContainer(AbsFeedView absFeedView) {
        if (absFeedView == null) {
            return;
        }
        if (absFeedView instanceof FeedAdvContainer) {
            this.mFeedAdvContainerCache.add((FeedAdvContainer) absFeedView);
        } else if (absFeedView instanceof FeedGalleryContainer) {
            this.mFeedGalleryContainerCache.add((FeedGalleryContainer) absFeedView);
        } else if (absFeedView instanceof FeedContainer) {
            this.mFeedContainerCache.add((FeedContainer) absFeedView);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class SubViewHolder<T extends View> {
        boolean mLoadView;
        LinkedList<T> mViewList = new LinkedList<>();

        public SubViewHolder() {
        }

        public T obtain(int i3) {
            T poll = this.mViewList.poll();
            return poll == null ? (T) LayoutInflater.from(ViewLoader.this.mContext).inflate(i3, (ViewGroup) null) : poll;
        }

        public void putBack(int i3, List<T> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i16 = 0; i16 < list.size(); i16++) {
                T t16 = list.get(i16);
                t16.setOnClickListener(null);
                t16.setOnLongClickListener(null);
                t16.setTag(null);
                t16.setOnKeyListener(null);
                t16.setOnFocusChangeListener(null);
                t16.setOnTouchListener(null);
                t16.setOnCreateContextMenuListener(null);
                this.mViewList.add(t16);
            }
        }

        public void load(int i3, int i16) {
            if (i3 == 0 || i16 == 0 || this.mLoadView) {
                return;
            }
            for (int i17 = 0; i17 < i16; i17++) {
                this.mViewList.add(LayoutInflater.from(ViewLoader.this.mContext).inflate(i3, (ViewGroup) null));
            }
            this.mLoadView = true;
        }

        public void putBack(int i3, T t16) {
            t16.setOnClickListener(null);
            t16.setOnLongClickListener(null);
            t16.setTag(null);
            t16.setOnKeyListener(null);
            t16.setOnFocusChangeListener(null);
            t16.setOnTouchListener(null);
            t16.setOnCreateContextMenuListener(null);
            this.mViewList.add(t16);
        }
    }

    public FeedView obtainFeedViewInAdvContainer(Context context, boolean z16) {
        if (z16) {
            return FeedViewBuilder.generateFeedView(context, null, false, false);
        }
        FeedView poll = this.mFeedViewInAdvContainerCache.poll();
        return poll == null ? FeedViewBuilder.generateFeedView(context, null, false, false) : poll;
    }
}
