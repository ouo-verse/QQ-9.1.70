package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class FeedViewSection implements r {
    public static final int IDX_FEED_ALBUM_REC = 114;
    public static final int IDX_FEED_APP_SHARE_CARD = 23;
    public static final int IDX_FEED_BIRTHDAY_GIFT = 103;
    public static final int IDX_FEED_BOTTOM_GUIDE = 115;
    public static final int IDX_FEED_CAMPUS_CARD = 21;
    public static final int IDX_FEED_COMMENT = 111;
    public static final int IDX_FEED_CONTENT = 13;
    public static final int IDX_FEED_CONTENT_FORWOARD = 40;
    public static final int IDX_FEED_DATE_HEADER = 2;
    public static final int IDX_FEED_FAKE_GAP = 3;
    public static final int IDX_FEED_FAMOUS_RECOMM = 50;
    public static final int IDX_FEED_FOLLOW_GUIDE = 112;
    public static final int IDX_FEED_FRIEND_LISTENING = 32;
    public static final int IDX_FEED_FRIEND_PLAYING = 31;
    public static final int IDX_FEED_GDT_CAROUSEL_CARD = 61;
    public static final int IDX_FEED_GDT_DESCRIPTION = 12;
    public static final int IDX_FEED_GOODS = 65;
    public static final int IDX_FEED_HAND_BLOG = 20;
    public static final int IDX_FEED_HAND_BLOG_FORWARD = 45;
    public static final int IDX_FEED_HEADER_INTEREST = 7;
    public static final int IDX_FEED_HEADER_RECOMM = 6;
    public static final int IDX_FEED_HEADER_RECOMM_NON_AD = 8;
    public static final int IDX_FEED_HEADER_TOP = 5;
    public static final int IDX_FEED_NEW_PICTEXT_CARD = 54;
    public static final int IDX_FEED_OPERATE = 110;
    public static final int IDX_FEED_PERSONALIZED_TAG = 11;
    public static final int IDX_FEED_PICTEXT_CARD = 51;
    public static final int IDX_FEED_QCIRCLE_PICTEXT_CARD = 53;
    public static final int IDX_FEED_QQLIVE_TITLE = 117;
    public static final int IDX_FEED_QZONE_CARD = 22;
    public static final int IDX_FEED_RECOMM_ACTION = 62;
    public static final int IDX_FEED_RECOMM_ACTION_AD = 64;
    public static final int IDX_FEED_RECOMM_ACTION_NON_AD = 63;
    public static final int IDX_FEED_RECOMM_FRIEND_CARD = 102;
    public static final int IDX_FEED_RECOMM_TITLE = 9;
    public static final int IDX_FEED_RECOMM_VIDEO = 52;
    public static final int IDX_FEED_SCROLLER_CONTAINER = 30;
    public static final int IDX_FEED_SEARCH_TIP = 1;
    public static final int IDX_FEED_SEPARATOR = 0;
    public static final int IDX_FEED_SHAI_SHAI_CONTENT = 24;
    public static final int IDX_FEED_SHAI_SHAI_RECOMMEND = 116;
    public static final int IDX_FEED_SPECIAL_CARE = 101;
    public static final int IDX_FEED_SUGGEST_MORE = 100;
    public static final int IDX_FEED_TITLE = 10;
    public static final int IDX_FEED_TITLE_FORWARD = 33;
    private static final int NORMAL_VIEW_CACHE_SIZE = 10;
    private static final int SPECIAL_VIEW_CACHE_SIZE = 2;
    public static final String TAG = "feedview_reconstuction";
    private static final Map<Class<? extends View>, ViewCreator> sViewStore = new ConcurrentHashMap();
    protected int feedPosition;
    Context mContext;
    protected BusinessFeedData mFeedData;
    protected boolean mIsEmpty;
    protected FeedViewOptions mOptions;
    protected NormalAbsFeedView mRootView;
    protected SectionController mSectionController;
    public FeedViewSection nextSection;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    private WeakReference<? extends NormalAbsFeedView> parentView;
    public FeedViewSection previousSection;
    protected View rootContainer;
    int viewIdx;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class AudioFeedBubbleCreator extends NormalViewCreator {
        AudioFeedBubbleCreator(Context context) {
            super(context);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.ViewCreator
        View create(Context context) {
            return new AudioFeedBubble(context, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class CanvasCellCommentViewCreator extends NormalViewCreator {
        CanvasCellCommentViewCreator(Context context) {
            super(context);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.ViewCreator
        View create(Context context) {
            return new CanvasCellCommentView(context, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class CanvasFeedContentViewCreator extends NormalViewCreator {
        CanvasFeedContentViewCreator(Context context) {
            super(context);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.ViewCreator
        View create(Context context) {
            return new CanvasFeedContentView(context, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class CanvasLeftThumbViewCreator extends NormalViewCreator {
        CanvasLeftThumbViewCreator(Context context) {
            super(context);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.ViewCreator
        View create(Context context) {
            return new CanvasLeftThumbView(context, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class CanvasTitleViewCreator extends NormalViewCreator {
        CanvasTitleViewCreator(Context context) {
            super(context);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.ViewCreator
        View create(Context context) {
            return new CanvasTitleView(context, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class FeedPicTextCardViewCreator extends NormalViewCreator {
        FeedPicTextCardViewCreator(Context context) {
            super(context);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.ViewCreator
        View create(Context context) {
            return new FeedPicTextCardView(context, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class FeedVideoViewCreator extends NormalViewCreator {
        FeedVideoViewCreator(Context context) {
            super(context);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.ViewCreator
        View create(Context context) {
            return new FeedVideoView(context, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class FeedViewOptions {
        public boolean canComment;
        public boolean canGiveBack;
        public boolean canJoinAlbum;
        public boolean canLookUp;
        public boolean canReply;
        public boolean canReturnGift;
        private WeakReference<Context> context;
        public boolean isInterest;
        public boolean isMessage;
        public boolean isTodayInHistoryDetail;
        public boolean joinedAlbum;
        public boolean titleGapVisible;
        public boolean isPreGenerateView = false;
        public boolean isPassive = false;
        public boolean isFromMessag = false;
        public boolean isDetail = false;

        public Context getContext() {
            WeakReference<Context> weakReference = this.context;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public void setContext(Context context) {
            this.context = new WeakReference<>(context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class ReflectViewCreator extends ViewCreator {
        private final Constructor<? extends View> constructor;

        ReflectViewCreator(Class<? extends View> cls) throws NoSuchMethodException {
            super(2);
            this.constructor = cls.getConstructor(Context.class, AttributeSet.class);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.ViewCreator
        View create(Context context) {
            try {
                return this.constructor.newInstance(context, null);
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.b.j(FeedViewSection.TAG, "create: failed", e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface SectionController {
        boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewOptions feedViewOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ViewCreator {
        final int size;
        final Queue<View> views = new LinkedList();

        ViewCreator(int i3) {
            this.size = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void addCache(View view) {
            if (this.views.size() > this.size) {
                return;
            }
            this.views.offer(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized View getCache() {
            return this.views.poll();
        }

        View create(Context context) {
            return null;
        }
    }

    public FeedViewSection(Context context, NormalAbsFeedView normalAbsFeedView) {
        this.mRootView = normalAbsFeedView;
        this.mContext = normalAbsFeedView != null ? normalAbsFeedView.getContext() : context;
        this.rootContainer = normalAbsFeedView;
    }

    public static void generateViewCache(Context context) {
        Map<Class<? extends View>, ViewCreator> map = sViewStore;
        map.put(CanvasTitleView.class, new CanvasTitleViewCreator(context));
        map.put(CanvasFeedContentView.class, new CanvasFeedContentViewCreator(context));
        map.put(CanvasCellCommentView.class, new CanvasCellCommentViewCreator(context));
        map.put(FeedPicTextCardView.class, new FeedPicTextCardViewCreator(context));
        map.put(CanvasLeftThumbView.class, new CanvasLeftThumbViewCreator(context));
        map.put(AudioFeedBubble.class, new AudioFeedBubbleCreator(context));
        map.put(FeedVideoView.class, new FeedVideoViewCreator(context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x0033, TryCatch #1 {, blocks: (B:6:0x0011, B:15:0x0019, B:10:0x002c, B:11:0x0031, B:18:0x0020), top: B:5:0x0011, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void putViewBackToCache(View view) {
        Class<?> cls = view.getClass();
        Map<Class<? extends View>, ViewCreator> map = sViewStore;
        ViewCreator viewCreator = map.get(cls);
        if (viewCreator == null) {
            synchronized (FeedViewSection.class) {
                ViewCreator viewCreator2 = map.get(cls);
                if (viewCreator2 == null) {
                    try {
                        viewCreator = new ReflectViewCreator(cls);
                    } catch (Exception e16) {
                        com.qzone.proxy.feedcomponent.b.j(TAG, "putViewBackToCache: failed", e16);
                    }
                    if (viewCreator != null) {
                        sViewStore.put(cls, viewCreator);
                    }
                }
                viewCreator = viewCreator2;
                if (viewCreator != null) {
                }
            }
        }
        if (viewCreator == null) {
            return;
        }
        viewCreator.addCache(view);
    }

    public final void applyFeedData() {
        onApplyFeedData();
    }

    public ViewGroup.LayoutParams generateLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = AreaConst.MARGIN_LEFT;
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = AreaConst.MARGIN_RIGHT;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T generateView(Class<T> cls, int i3) {
        return (T) generateView(cls, i3, true);
    }

    public final Context getContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        return null;
    }

    public final int getFeedPosition() {
        return this.feedPosition;
    }

    public View getOrGenerateView(NormalAbsFeedView normalAbsFeedView) {
        this.parentView = new WeakReference<>(normalAbsFeedView);
        if (isEmpty()) {
            return null;
        }
        View obtainView = obtainView();
        if (!this.mOptions.isPreGenerateView) {
            applyFeedData();
        }
        return obtainView;
    }

    public List<View> getOrGenerateViews(NormalAbsFeedView normalAbsFeedView) {
        this.parentView = new WeakReference<>(normalAbsFeedView);
        if (isEmpty()) {
            com.qzone.proxy.feedcomponent.b.e(TAG, "SectionEmpty:" + this.mIsEmpty + " Section:" + this + " Controller:" + this.mSectionController);
            return null;
        }
        List<View> obtainViews = obtainViews();
        if (!this.mOptions.isPreGenerateView) {
            applyFeedData();
        }
        return obtainViews;
    }

    public FeedChildView getView() {
        return null;
    }

    public FeedChildView getViews() {
        return null;
    }

    public boolean haveMultipleViews() {
        return false;
    }

    public View insertView() {
        View obtainView;
        String str;
        WeakReference<? extends NormalAbsFeedView> weakReference = this.parentView;
        if (weakReference == null) {
            if (com.qzone.adapter.feedcomponent.i.H().X0()) {
                com.qzone.proxy.feedcomponent.b.j(TAG, "attempt to add view while feedview is unset", new RuntimeException());
            }
            return null;
        }
        NormalAbsFeedView normalAbsFeedView = weakReference.get();
        if (normalAbsFeedView == null) {
            if (com.qzone.adapter.feedcomponent.i.H().X0()) {
                com.qzone.proxy.feedcomponent.b.j(TAG, "attempt to add view while feedview has been collected", new RuntimeException());
            }
            return null;
        }
        if (isEmpty() || (obtainView = obtainView()) == null) {
            return null;
        }
        if (obtainView.getParent() != null) {
            if (com.qzone.adapter.feedcomponent.i.H().X0()) {
                com.qzone.proxy.feedcomponent.b.j(TAG, "attempt to add a view that is already in another view group", new RuntimeException());
            }
            return obtainView;
        }
        try {
            normalAbsFeedView.addView(obtainView, this.viewIdx);
        } catch (Exception unused) {
            if (("insert view failed, feedkey: " + this.mFeedData) != null) {
                str = this.mFeedData.getFeedCommInfo().feedskey;
            } else {
                str = "";
            }
            com.qzone.proxy.feedcomponent.b.d(TAG, str, new RuntimeException());
        }
        for (FeedViewSection feedViewSection = this.nextSection; feedViewSection != null; feedViewSection = feedViewSection.nextSection) {
            feedViewSection.viewIdx++;
        }
        return obtainView;
    }

    public boolean isEmpty() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return true;
        }
        SectionController sectionController = this.mSectionController;
        if (sectionController != null) {
            return sectionController.isSectionEmpty(businessFeedData, this.mOptions);
        }
        return this.mIsEmpty;
    }

    public View obtainView() {
        if (com.qzone.adapter.feedcomponent.i.H().X0()) {
            throw new RuntimeException("Subclasses of FeedViewSection should override at least 1 method in getOrGenerateViews / getOrGenerateView and override haveMultipleViews for callers to invoke right method");
        }
        return null;
    }

    public List<View> obtainViews() {
        if (com.qzone.adapter.feedcomponent.i.H().X0()) {
            throw new RuntimeException("Subclasses of FeedViewSection should override at least 1 method in getOrGenerateViews / getOrGenerateView and override haveMultipleViews for callers to invoke right method");
        }
        return null;
    }

    protected abstract void onApplyFeedData();

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public abstract /* synthetic */ void onRecycled();

    public abstract void onStateIdle();

    public abstract void onStateScrolling();

    protected abstract void onUpdate();

    public abstract void reset();

    public abstract void setAlpha(int i3);

    public void setFeedData(BusinessFeedData businessFeedData, FeedViewOptions feedViewOptions) {
        this.mFeedData = businessFeedData;
        this.mOptions = feedViewOptions;
    }

    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setSectionController(SectionController sectionController) {
        this.mSectionController = sectionController;
    }

    public final void update() {
        onUpdate();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class NormalViewCreator extends ViewCreator {
        NormalViewCreator(Context context) {
            super(10);
            synchronized (this) {
                for (int size = this.views.size(); size < this.size; size++) {
                    this.views.offer(create(context));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setViewVisbile(View view) {
        setVisibility(0, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T generateView(Class<T> cls, int i3, boolean z16) {
        ViewCreator viewCreator;
        if (z16) {
            try {
                Map<Class<? extends View>, ViewCreator> map = sViewStore;
                if (map.containsKey(cls) && (viewCreator = map.get(cls)) != null) {
                    View cache = viewCreator.getCache();
                    if (cls.isInstance(cache)) {
                        if (com.qzone.adapter.feedcomponent.i.H().X0()) {
                            com.qzone.proxy.feedcomponent.b.e(TAG, "view inflated" + cache.toString());
                        }
                        return cls.cast(cache);
                    }
                }
            } catch (Throwable th5) {
                com.qzone.proxy.feedcomponent.b.d(TAG, "inflate view err", th5);
                try {
                    return cls.cast(cls.getConstructor(Context.class, AttributeSet.class).newInstance(this.mContext, null));
                } catch (Exception unused) {
                    com.qzone.proxy.feedcomponent.b.d(TAG, "inflate view second time err", th5);
                    return null;
                }
            }
        }
        return cls.cast(cls.getConstructor(Context.class, AttributeSet.class).newInstance(this.mContext, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setViewGone(View view) {
        setVisibility(8, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setVisibility(int i3, View view) {
        if (view == null || view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }

    public FeedViewSection(Context context, View view, Object obj) {
        this.rootContainer = view;
        this.mContext = context;
    }

    protected static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    protected void attachView(NormalAbsFeedView normalAbsFeedView) {
    }

    protected void attachViewForRootContainer(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInsertedIntoView() {
    }
}
