package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.module.feedcomponent.ui.FeedFriendBirthdayGiftView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFriendBirthdayGift;
import com.qzone.proxy.feedcomponent.model.FriendBirthdayGift;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes39.dex */
public class FeedFriendBirthdayGiftPanel extends BaseFeedView implements View.OnClickListener, FeedChildView {
    public static FeedViewSection.SectionController BirthdayGiftController = null;
    private static final String TAG = "BIRTHGIFT";
    static int gUniNum = 0;
    static final boolean hideFeedWhenLastFriendPresented;
    static final ImageLoader sImageLoader;
    static final int sMaxGiftNum = 3;
    Runnable asyncRunnable;
    final PicListener mDownloadListener;
    BusinessFeedData mFeedData;
    final ArrayList<FriendBirthdayGift> mFriendBirthdayGifts;
    final ArrayList<Drawable> mGiftsDrawableList;
    final ArrayList<BirthdayGiftViewHodler> mGiftsViewArraryList;
    final NormalFeedImageProcessor mImageProcessor;
    int mMagic;
    FriendBirthdayGift mMoreGiftItem;
    FeedFriendBirthdayGiftView mMoreGiftView;
    FeedFriendBirthdayGiftView.OnSendGiftListener mOnSendGiftListener;
    static final int sGiftIconWidth = com.qzone.proxy.feedcomponent.util.g.a(54.0f);
    static final int sGiftIconHeight = com.qzone.proxy.feedcomponent.util.g.a(54.0f);
    static final Handler sMianHandle = new Handler(Looper.getMainLooper());
    static final Drawable sDefaultBackground = AreaManager.DEFAULT_BACKGROUND;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class BirthdayGiftViewHodler {
        FeedFriendBirthdayGiftView mGiftView;
        View mPlaceHodler;

        public BirthdayGiftViewHodler(FeedFriendBirthdayGiftView feedFriendBirthdayGiftView, View view) {
            this.mGiftView = feedFriendBirthdayGiftView;
            this.mPlaceHodler = view;
        }

        public void onUpdate() {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.onUpdate();
            }
        }

        public void setContainerPosition(int i3) {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.setContainerPosition(i3);
            }
        }

        public void setGiftData(FriendBirthdayGift friendBirthdayGift) {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.setGiftData(friendBirthdayGift);
            }
        }

        public void setGiftImage(Drawable drawable) {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.setGiftImage(drawable);
            }
        }

        public void setGiftName(String str) {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.setGiftName(str);
            }
        }

        public void setMagic(int i3) {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.setMagic(i3);
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.setOnClickListener(onClickListener);
            }
        }

        public void setOnSendGiftListener(FeedFriendBirthdayGiftView.OnSendGiftListener onSendGiftListener) {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.setOnSendGiftListener(onSendGiftListener);
            }
        }

        public void setTag(Object obj) {
            FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mGiftView;
            if (feedFriendBirthdayGiftView != null) {
                feedFriendBirthdayGiftView.setTag(obj);
            }
        }

        protected void setViewGone() {
            FeedFriendBirthdayGiftPanel.this.setVisibility(8, this.mGiftView);
            FeedFriendBirthdayGiftPanel.this.setVisibility(8, this.mPlaceHodler);
        }

        protected void setViewVisbile() {
            FeedFriendBirthdayGiftPanel.this.setVisibility(0, this.mGiftView);
            FeedFriendBirthdayGiftPanel.this.setVisibility(0, this.mPlaceHodler);
        }
    }

    public FeedFriendBirthdayGiftPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMagic = -1;
        this.mDownloadListener = new PicListener();
        this.mGiftsDrawableList = new ArrayList<>();
        this.mFriendBirthdayGifts = new ArrayList<>();
        this.mGiftsViewArraryList = new ArrayList<>();
        this.mImageProcessor = new NormalFeedImageProcessor(sGiftIconWidth, sGiftIconHeight, 0.0f, 0.0f);
        this.mOnSendGiftListener = new FeedFriendBirthdayGiftView.OnSendGiftListener() { // from class: com.qzone.module.feedcomponent.ui.FeedFriendBirthdayGiftPanel.3
            @Override // com.qzone.module.feedcomponent.ui.FeedFriendBirthdayGiftView.OnSendGiftListener
            public void onSending(View view) {
                FeedFriendBirthdayGiftPanel.this.onSendFriendBirthdayGift(view);
            }
        };
        initView(context);
    }

    static int getUniNum() {
        int i3 = gUniNum + 1;
        gUniNum = i3;
        return i3;
    }

    public boolean checkMagic(int i3) {
        return this.mMagic == i3;
    }

    Drawable getImageDrawable(FriendBirthdayGift friendBirthdayGift, ImageLoader.Options options) {
        String currentUrl = friendBirthdayGift.getCurrentUrl();
        ImageUrl currentImageUrl = friendBirthdayGift.getCurrentImageUrl();
        if (TextUtils.isEmpty(currentUrl)) {
            friendBirthdayGift.preOpt = options;
            return sDefaultBackground;
        }
        Drawable loadImage = sImageLoader.loadImage(currentImageUrl, currentUrl, this.mDownloadListener, options);
        if (loadImage == null) {
            friendBirthdayGift.preOpt = options;
            return sDefaultBackground;
        }
        com.qzone.proxy.feedcomponent.b.i(TAG, String.format("image cache hit idx:%d url: %s %d", Integer.valueOf(options.arg1), currentUrl, Integer.valueOf(loadImage.hashCode())));
        friendBirthdayGift.preOpt = null;
        loadImage.setBounds(0, 0, sGiftIconWidth, sGiftIconHeight);
        return loadImage;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public boolean isEmptyData() {
        return this.mFeedData == null || this.mFriendBirthdayGifts.size() <= 0;
    }

    void notifyAdvContainerScrollNextPage() {
        com.qzone.proxy.feedcomponent.ui.h hVar = this.onFeedEventListener;
        if (hVar != null) {
            hVar.onEvent(this, 10000, 1, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            if (view.getId() != com.qzone.adapter.feedcomponent.j.O(2393) && view.getId() != com.qzone.adapter.feedcomponent.j.O(2394) && view.getId() != com.qzone.adapter.feedcomponent.j.O(2395)) {
                if (view.getId() == com.qzone.adapter.feedcomponent.j.O(2396)) {
                    onFriendBirthdayMoreGiftClick(view);
                }
            } else {
                onFriendBirthdayGiftClick(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    void onFriendBirthdayGiftClick(View view) {
        int intValue;
        FriendBirthdayGift friendBirthdayGift;
        com.qzone.proxy.feedcomponent.ui.g gVar;
        if ((view.getTag() instanceof Integer) && (intValue = ((Integer) view.getTag()).intValue()) >= 0 && intValue < this.mFriendBirthdayGifts.size() && (friendBirthdayGift = this.mFriendBirthdayGifts.get(intValue)) != null && !friendBirthdayGift.hasSent && (gVar = this.onFeedElementClickListener) != null) {
            gVar.onClick(view, FeedElement.FRIEND_BIRTHDAY_GIFT, this.feedPosition, friendBirthdayGift);
        }
    }

    void onFriendBirthdayMoreGiftClick(View view) {
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar != null) {
            gVar.onClick(view, FeedElement.FRIEND_BITTHDAY_GIFT_MORE, this.feedPosition, this.mMoreGiftItem);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        this.mMagic = getUniNum();
        Iterator<BirthdayGiftViewHodler> it = this.mGiftsViewArraryList.iterator();
        while (it.hasNext()) {
            it.next().setMagic(this.mMagic);
        }
        if (!com.qzone.adapter.feedcomponent.i.H().g1()) {
            Iterator<FriendBirthdayGift> it5 = this.mFriendBirthdayGifts.iterator();
            while (it5.hasNext()) {
                FriendBirthdayGift next = it5.next();
                if (next != null && next.preOpt != null) {
                    sImageLoader.cancel(next.getCurrentUrl(), this.mDownloadListener, next.preOpt);
                }
            }
        }
        this.mFeedData = null;
        this.mFriendBirthdayGifts.clear();
        if (com.qzone.adapter.feedcomponent.i.H().o0()) {
            this.mGiftsDrawableList.clear();
        }
    }

    void onSendFriendBirthdayGift(View view) {
        if (view instanceof FeedFriendBirthdayGiftView) {
            if (this.asyncRunnable != null) {
                getHandler().removeCallbacks(this.asyncRunnable);
            }
            Runnable runnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedFriendBirthdayGiftPanel.2
                @Override // java.lang.Runnable
                public void run() {
                    BusinessFeedData businessFeedData;
                    BusinessFeedData businessFeedData2;
                    if (FeedFriendBirthdayGiftPanel.hideFeedWhenLastFriendPresented && (businessFeedData = FeedFriendBirthdayGiftPanel.this.mFeedData) != null && (businessFeedData2 = businessFeedData.parentFeedData) != null && businessFeedData2.getRecBusinessFeedDatas().indexOf(FeedFriendBirthdayGiftPanel.this.mFeedData) == FeedFriendBirthdayGiftPanel.this.mFeedData.parentFeedData.getRecBusinessFeedDatas().size() - 1) {
                        com.qzone.proxy.feedcomponent.b.i("FRIEND_BIRTHDAT", "send last gift. " + FeedFriendBirthdayGiftPanel.this.feedPosition + "    " + FeedFriendBirthdayGiftPanel.this.mFeedData.getFeedCommInfo().feedskey + "  " + FeedFriendBirthdayGiftPanel.this.mFeedData.parentFeedData.getFeedCommInfo().feedskey);
                        FeedFriendBirthdayGiftPanel feedFriendBirthdayGiftPanel = FeedFriendBirthdayGiftPanel.this;
                        feedFriendBirthdayGiftPanel.onFeedElementClickListener.onClick(feedFriendBirthdayGiftPanel, FeedElement.FEEDBACK, feedFriendBirthdayGiftPanel.feedPosition, null);
                    } else {
                        FeedFriendBirthdayGiftPanel.this.notifyAdvContainerScrollNextPage();
                    }
                    FeedFriendBirthdayGiftPanel.this.asyncRunnable = null;
                }
            };
            this.asyncRunnable = runnable;
            postDelayed(runnable, 500L);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.mMagic = getUniNum();
        this.mFeedData = null;
        Iterator<BirthdayGiftViewHodler> it = this.mGiftsViewArraryList.iterator();
        while (it.hasNext()) {
            it.next().setMagic(this.mMagic);
        }
        this.mFriendBirthdayGifts.clear();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void setContainerPosition(int i3) {
        super.setContainerPosition(i3);
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        CellFriendBirthdayGift cellFriendBirthdayGift;
        ArrayList<FriendBirthdayGift> arrayList;
        this.mMagic = getUniNum();
        this.mFeedData = null;
        this.mFriendBirthdayGifts.clear();
        if (businessFeedData == null || businessFeedData.getCellFriendBirthdayGift() == null || (arrayList = (cellFriendBirthdayGift = businessFeedData.getCellFriendBirthdayGift()).gifts) == null || arrayList.size() <= 0) {
            return;
        }
        this.mFeedData = businessFeedData;
        Iterator<FriendBirthdayGift> it = cellFriendBirthdayGift.gifts.iterator();
        while (it.hasNext()) {
            FriendBirthdayGift next = it.next();
            if (next != null) {
                if (next.moreflag != 0) {
                    this.mMoreGiftItem = next;
                } else {
                    Map<Integer, String> map = next.gifturl;
                    if (map != null && map.size() > 0 && validBirthdayGiftItem(next)) {
                        next.magic = this.mMagic;
                        if (this.mFriendBirthdayGifts.size() < 3) {
                            this.mFriendBirthdayGifts.add(next);
                        }
                    }
                }
            }
        }
        for (int i3 = 0; i3 < this.mFriendBirthdayGifts.size(); i3++) {
            FriendBirthdayGift friendBirthdayGift = this.mFriendBirthdayGifts.get(i3);
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.obj = friendBirthdayGift;
            obtain.arg1 = i3;
            obtain.arg2 = this.mMagic;
            obtain.processor = null;
            obtain.clipWidth = sGiftIconWidth;
            obtain.clipHeight = sGiftIconHeight;
            obtain.extraProcessor = this.mImageProcessor;
            Drawable imageDrawable = getImageDrawable(friendBirthdayGift, obtain);
            if (this.mGiftsDrawableList.size() > i3) {
                this.mGiftsDrawableList.set(i3, imageDrawable);
            } else {
                this.mGiftsDrawableList.add(imageDrawable);
            }
            com.qzone.proxy.feedcomponent.b.i(TAG, "setFeedData idx:" + i3 + " url: " + friendBirthdayGift.getCurrentUrl() + " " + imageDrawable.hashCode());
        }
        update();
    }

    boolean validBirthdayGiftItem(FriendBirthdayGift friendBirthdayGift) {
        Iterator<String> it = friendBirthdayGift.gifturl.values().iterator();
        while (it.hasNext()) {
            if (!TextUtils.isEmpty(it.next())) {
                return true;
            }
        }
        return false;
    }

    static {
        FeedGlobalEnv.g();
        sImageLoader = ImageLoader.getInstance(FeedGlobalEnv.getApplication());
        hideFeedWhenLastFriendPresented = com.qzone.adapter.feedcomponent.i.H().U("QZoneSetting", "SECONDARY_FRIEND_BIRTHDAY_HIDE_FEED_WHEN_LAST_PRENSENTED", true);
        BirthdayGiftController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedFriendBirthdayGiftPanel.1
            @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
            public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
                return businessFeedData == null || !businessFeedData.isSubOfFriendBirthdayContainerFeed();
            }
        };
    }

    void initView(Context context) {
        View.inflate(context, com.qzone.adapter.feedcomponent.j.j(1671), this);
        this.mMoreGiftView = (FeedFriendBirthdayGiftView) findViewById(com.qzone.adapter.feedcomponent.j.O(2396));
        this.mGiftsViewArraryList.add(new BirthdayGiftViewHodler((FeedFriendBirthdayGiftView) findViewById(com.qzone.adapter.feedcomponent.j.O(2393)), findViewById(com.qzone.adapter.feedcomponent.j.O(2402))));
        this.mGiftsViewArraryList.add(new BirthdayGiftViewHodler((FeedFriendBirthdayGiftView) findViewById(com.qzone.adapter.feedcomponent.j.O(2394)), findViewById(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.GROUP_AIO_UPLOAD_PERMISSIONS_GRAY_TIP_ID))));
        this.mGiftsViewArraryList.add(new BirthdayGiftViewHodler((FeedFriendBirthdayGiftView) findViewById(com.qzone.adapter.feedcomponent.j.O(2395)), findViewById(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.GROUP_AIO_HOME_SCHOOL_WELCOME_GRAY_TIP_ID))));
    }

    void onImageLoadSuccess(String str, int i3, int i16, Drawable drawable) {
        BirthdayGiftViewHodler birthdayGiftViewHodler;
        if (drawable == null || !checkMagic(i16) || i3 < 0 || i3 >= this.mGiftsDrawableList.size() || i3 >= this.mGiftsViewArraryList.size() || (birthdayGiftViewHodler = this.mGiftsViewArraryList.get(i3)) == null) {
            return;
        }
        this.mGiftsDrawableList.set(i3, drawable);
        drawable.setBounds(0, 0, sGiftIconWidth, sGiftIconHeight);
        birthdayGiftViewHodler.setGiftImage(drawable);
        com.qzone.proxy.feedcomponent.b.i(TAG, String.format("set image url:%s magic:%d index:%d", str, Integer.valueOf(i16), Integer.valueOf(i3)));
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void onUpdate() {
        BirthdayGiftViewHodler birthdayGiftViewHodler = null;
        int i3 = 0;
        while (i3 < this.mFriendBirthdayGifts.size() && i3 < this.mGiftsViewArraryList.size() && i3 < this.mGiftsDrawableList.size()) {
            birthdayGiftViewHodler = this.mGiftsViewArraryList.get(i3);
            if (birthdayGiftViewHodler != null) {
                FriendBirthdayGift friendBirthdayGift = this.mFriendBirthdayGifts.get(i3);
                if (friendBirthdayGift == null) {
                    birthdayGiftViewHodler.setViewGone();
                } else {
                    Drawable drawable = this.mGiftsDrawableList.get(i3);
                    if (drawable == null) {
                        birthdayGiftViewHodler.setViewGone();
                    } else {
                        birthdayGiftViewHodler.setTag(Integer.valueOf(i3));
                        birthdayGiftViewHodler.setViewVisbile();
                        birthdayGiftViewHodler.setMagic(this.mMagic);
                        birthdayGiftViewHodler.setGiftData(friendBirthdayGift);
                        birthdayGiftViewHodler.setGiftImage(drawable);
                        birthdayGiftViewHodler.setOnClickListener(this);
                        birthdayGiftViewHodler.setGiftName(friendBirthdayGift.giftviewname);
                        birthdayGiftViewHodler.setOnSendGiftListener(this.mOnSendGiftListener);
                        birthdayGiftViewHodler.setContainerPosition(getContainerPosition());
                        com.qzone.proxy.feedcomponent.b.i(TAG, "onupdate idx:" + i3 + " url: " + friendBirthdayGift.getCurrentUrl() + " " + drawable.hashCode());
                    }
                }
            }
            i3++;
        }
        while (i3 < this.mGiftsViewArraryList.size()) {
            this.mGiftsViewArraryList.get(i3).setViewGone();
            i3++;
        }
        FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = this.mMoreGiftView;
        if (feedFriendBirthdayGiftView == null) {
            setViewGone(feedFriendBirthdayGiftView);
        } else {
            setViewVisbile(feedFriendBirthdayGiftView);
            this.mMoreGiftView.setOnClickListener(this);
        }
        Iterator<BirthdayGiftViewHodler> it = this.mGiftsViewArraryList.iterator();
        while (it.hasNext()) {
            BirthdayGiftViewHodler next = it.next();
            if (next != null) {
                next.onUpdate();
                if (birthdayGiftViewHodler != null) {
                    birthdayGiftViewHodler.setOnClickListener(this);
                    birthdayGiftViewHodler.setOnSendGiftListener(this.mOnSendGiftListener);
                }
            }
        }
        FeedFriendBirthdayGiftView feedFriendBirthdayGiftView2 = this.mMoreGiftView;
        if (feedFriendBirthdayGiftView2 != null) {
            feedFriendBirthdayGiftView2.onUpdate();
            setViewVisbile(this.mMoreGiftView);
            this.mMoreGiftView.setOnClickListener(this);
        }
    }

    /* loaded from: classes39.dex */
    public class PicListener implements ImageLoader.ImageLoadListener {
        public PicListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(final String str, final Drawable drawable, final ImageLoader.Options options) {
            if (drawable != null && options != null && FeedFriendBirthdayGiftPanel.this.checkMagic(options.arg2) && (options.obj instanceof FriendBirthdayGift)) {
                FeedFriendBirthdayGiftPanel.sMianHandle.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedFriendBirthdayGiftPanel.PicListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageLoader.Options options2 = options;
                        ((FriendBirthdayGift) options2.obj).preOpt = null;
                        FeedFriendBirthdayGiftPanel.this.onImageLoadSuccess(str, options2.arg1, options2.arg2, drawable);
                    }
                });
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
