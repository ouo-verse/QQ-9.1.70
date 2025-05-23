package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellActiveAdv;
import com.qzone.proxy.feedcomponent.model.CellGoods;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.widget.AsynAutoGifImageView;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.view.AsyncImageable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedGoods extends BaseFeedView implements AsynAutoGifImageView.a, FeedChildView {
    static final String COLOR_FOR_NORMAL_BUTTON_TEXT = "#ffffffff";
    static final String COLOR_FOR_YELLOW_BUTTON_TEXT = "#ff812a13";
    public static FeedViewSection.SectionController FeedGoodsController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedGoods.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData != null) {
                return ((businessFeedData.getFeedCommInfo().feedsAttr & 1024) == 0 || businessFeedData.getGoods() == null) && businessFeedData.getActiveAdv() == null;
            }
            return true;
        }
    };
    static final String TAG = "FeedGoods";
    protected CellPictureInfo cellPictureInfo;
    TextView mActionButton;
    AsyncImageable.AsyncImageListener mAsyncImageListener;
    CellActiveAdv mCellActiveAdv;
    CellGoods mCellGoods;
    int mClickPosX;
    ViewGroup mContainerGoodsData;
    FeedPictureInfo mFeedPictureInfo;
    AsynAutoGifImageView mImageGoods;
    View.OnClickListener mListener;
    int mPhotoMode;
    TextView mTextDisPrice;
    TextView mTextDisPriceSuperScript;
    TextView mTextGoodsDesc;
    TextView mTextGoodsName;
    TextView mTextRightDesc;
    View.OnTouchListener mTouchListener;

    public FeedGoods(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPhotoMode = 0;
        this.mClickPosX = -1;
        this.mTouchListener = new View.OnTouchListener() { // from class: com.qzone.module.feedcomponent.ui.FeedGoods.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FeedGoods.this.mClickPosX = (int) motionEvent.getX();
                return false;
            }
        };
        this.mListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedGoods.3
            /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                boolean z16;
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedGoods feedGoods = FeedGoods.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedGoods.onFeedElementClickListener;
                if (gVar != null) {
                    if (feedGoods.mCellActiveAdv != null) {
                        FeedElement feedElement = FeedElement.NOTHING;
                        int i3 = feedGoods.feedPosition;
                        gVar.onClick(view, feedElement, i3, Integer.valueOf(i3));
                    } else {
                        if (view.getId() == com.qzone.adapter.feedcomponent.j.O(2231)) {
                            if (FeedGoods.this.isDirectAppDownloadFeed()) {
                                int width = FeedGoods.this.mImageGoods.getWidth();
                                int i16 = FeedGoods.this.mClickPosX;
                                if (i16 >= width * 0.78d && i16 <= width) {
                                    z16 = true;
                                    if (!z16) {
                                        FeedGoods feedGoods2 = FeedGoods.this;
                                        com.qzone.proxy.feedcomponent.ui.g gVar2 = feedGoods2.onFeedElementClickListener;
                                        FeedElement feedElement2 = FeedElement.DOWNLOAD_APP;
                                        int i17 = feedGoods2.feedPosition;
                                        gVar2.onClick(view, feedElement2, i17, new com.qzone.proxy.feedcomponent.model.f(i17, 0, false));
                                    } else {
                                        FeedGoods feedGoods3 = FeedGoods.this;
                                        if (feedGoods3.mCellGoods != null && !feedGoods3.isHasJumpUrl()) {
                                            FeedGoods feedGoods4 = FeedGoods.this;
                                            feedGoods4.onFeedElementClickListener.onClick(view, FeedElement.BUY_ACTION, feedGoods4.feedPosition, null);
                                        } else {
                                            FeedGoods feedGoods5 = FeedGoods.this;
                                            com.qzone.proxy.feedcomponent.ui.g gVar3 = feedGoods5.onFeedElementClickListener;
                                            FeedElement feedElement3 = FeedElement.PHOTO;
                                            int i18 = feedGoods5.feedPosition;
                                            gVar3.onClick(view, feedElement3, i18, new com.qzone.proxy.feedcomponent.model.f(i18, 0, false));
                                        }
                                    }
                                }
                            }
                            z16 = false;
                            if (!z16) {
                            }
                        } else if (view.getId() == com.qzone.adapter.feedcomponent.j.O(2238)) {
                            FeedGoods feedGoods6 = FeedGoods.this;
                            com.qzone.proxy.feedcomponent.ui.g gVar4 = feedGoods6.onFeedElementClickListener;
                            FeedElement feedElement4 = FeedElement.BUY_ACTION;
                            int i19 = feedGoods6.feedPosition;
                            gVar4.onClick(view, feedElement4, i19, Integer.valueOf(i19));
                        }
                        FeedGoods.this.mClickPosX = -1;
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mAsyncImageListener = new AsyncImageable.AsyncImageListener() { // from class: com.qzone.module.feedcomponent.ui.FeedGoods.4
            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageLoaded(AsyncImageable asyncImageable) {
                AsynAutoGifImageView asynAutoGifImageView = FeedGoods.this.mImageGoods;
                if (asynAutoGifImageView == null || asynAutoGifImageView.getBackground() == null) {
                    return;
                }
                ((GradientDrawable) FeedGoods.this.mImageGoods.getBackground().mutate()).setSize(0, 0);
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageFailed(AsyncImageable asyncImageable) {
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageStarted(AsyncImageable asyncImageable) {
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            }
        };
        initUI(context);
    }

    void initUI(Context context) {
        ScaleProcessor scaleProcessor;
        removeAllViews();
        CellGoods cellGoods = this.mCellGoods;
        if ((cellGoods != null && cellGoods.layoutType == 2) || this.mCellActiveAdv != null) {
            scaleProcessor = new ScaleProcessor(-1, AreaConst.DEFAULT_FULL_FEED_WIDTH / 2, true);
            LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1646), this);
            ViewGroup viewGroup = (ViewGroup) findViewById(com.qzone.adapter.feedcomponent.j.O(2232));
            this.mContainerGoodsData = viewGroup;
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.height = AreaConst.DEFAULT_FULL_FEED_WIDTH / 2;
            this.mContainerGoodsData.setLayoutParams(layoutParams);
        } else {
            scaleProcessor = new ScaleProcessor(AreaConst.DEFAULT_FULL_FEED_WIDTH, -1, true);
            LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1645), this);
            this.mContainerGoodsData = (ViewGroup) findViewById(com.qzone.adapter.feedcomponent.j.O(2232));
        }
        AsynAutoGifImageView asynAutoGifImageView = (AsynAutoGifImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2231));
        this.mImageGoods = asynAutoGifImageView;
        asynAutoGifImageView.setAsyncImageProcessor(scaleProcessor);
        this.mImageGoods.setAsyncImageListener(this.mAsyncImageListener);
        this.mImageGoods.setOnClickListener(this.mListener);
        if (this.mCellGoods != null) {
            this.mImageGoods.setOnTouchListener(this.mTouchListener);
        }
        this.mTextGoodsName = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2233));
        this.mTextGoodsDesc = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2234));
        this.mTextDisPrice = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2236));
        this.mTextRightDesc = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2237));
        TextView textView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2238));
        this.mActionButton = textView;
        textView.setOnClickListener(this.mListener);
        this.mTextDisPriceSuperScript = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2235));
    }

    public boolean isDirectAppDownloadFeed() {
        Map<Integer, String> map;
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        return (cellPictureInfo == null || (map = cellPictureInfo.busiParam) == null || !"1".equals(map.get(61))) ? false : true;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public boolean isEmptyData() {
        return this.mFeedPictureInfo == null && this.mCellGoods == null && this.mCellActiveAdv == null;
    }

    public boolean isHasJumpUrl() {
        Map<Integer, String> map;
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        return (cellPictureInfo == null || (map = cellPictureInfo.busiParam) == null || !"1".equals(map.get(15))) ? false : true;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.AsynAutoGifImageView.a
    public boolean isListViewScrollIdle() {
        return com.qzone.adapter.feedcomponent.i.H().g1();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        AsynAutoGifImageView asynAutoGifImageView = this.mImageGoods;
        if (asynAutoGifImageView != null) {
            asynAutoGifImageView.setImageDrawable(null);
            this.mImageGoods.b();
            this.onFeedElementClickListener = null;
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
        AsynAutoGifImageView asynAutoGifImageView = this.mImageGoods;
        if (asynAutoGifImageView != null) {
            asynAutoGifImageView.onStateIdle();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
        if (this.mCellActiveAdv != null) {
            updateActiveAdv();
        } else {
            updateGoodsImage();
            updateGoodsData();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
        ViewGroup viewGroup = this.mContainerGoodsData;
        if (viewGroup == null || viewGroup.getBackground() == null) {
            return;
        }
        this.mContainerGoodsData.getBackground().setAlpha(i3);
    }

    public void setCellPictureInfo(CellPictureInfo cellPictureInfo) {
        this.cellPictureInfo = cellPictureInfo;
    }

    public void setFeedActiveAdvData(CellActiveAdv cellActiveAdv) {
        this.mCellActiveAdv = cellActiveAdv;
    }

    public void setGoodsData(CellGoods cellGoods) {
        this.mCellGoods = cellGoods;
    }

    public void setGoodsPicture(FeedPictureInfo feedPictureInfo) {
        this.mFeedPictureInfo = feedPictureInfo;
    }

    public void setPhotoMode(int i3) {
        this.mPhotoMode = i3;
    }

    void setupGoodsData(int i3, String str) {
        if (TextUtils.isEmpty(this.mCellGoods.goodsName)) {
            setViewGone(this.mTextGoodsName);
        } else {
            this.mTextGoodsName.setText(this.mCellGoods.goodsName);
            setViewVisbile(this.mTextGoodsName);
        }
        if (TextUtils.isEmpty(this.mCellGoods.goodsDesc)) {
            setViewGone(this.mTextGoodsDesc);
        } else {
            this.mTextGoodsDesc.setText(this.mCellGoods.goodsDesc);
            setViewVisbile(this.mTextGoodsDesc);
        }
        if (TextUtils.isEmpty(this.mCellGoods.rightPriceDesc)) {
            setViewGone(this.mTextRightDesc);
        } else {
            this.mTextRightDesc.setText(this.mCellGoods.rightPriceDesc);
            setViewVisbile(this.mTextRightDesc);
        }
        if (TextUtils.isEmpty(this.mCellGoods.disPrice)) {
            setViewGone(this.mTextDisPrice);
            setViewGone(this.mTextDisPriceSuperScript);
        } else {
            String str2 = this.mCellGoods.disPrice;
            int indexOf = str2.indexOf(".");
            if (indexOf > 0 && this.mTextDisPriceSuperScript != null) {
                int i16 = indexOf + 1;
                this.mTextDisPrice.setText(str2.substring(0, i16));
                this.mTextDisPriceSuperScript.setText(str2.substring(i16));
                setViewVisbile(this.mTextDisPriceSuperScript);
            } else {
                this.mTextDisPrice.setText(str2);
                setViewGone(this.mTextDisPriceSuperScript);
            }
            setViewVisbile(this.mTextDisPrice);
        }
        if (!TextUtils.isEmpty(this.mCellGoods.btnTitle)) {
            this.mActionButton.setText(this.mCellGoods.btnTitle);
        }
        this.mActionButton.setTextColor(Color.parseColor(str));
        this.mActionButton.setBackgroundResource(i3);
        setViewVisbile(this.mActionButton);
    }

    void updateActiveAdv() {
        PictureItem pictureItem;
        CellActiveAdv cellActiveAdv = this.mCellActiveAdv;
        if (cellActiveAdv != null && (pictureItem = cellActiveAdv.picData) != null) {
            PictureUrl pictureUrl = pictureItem.currentUrl;
            updateCommImage(pictureUrl.width, pictureUrl.height, pictureUrl.url);
            this.mTextGoodsDesc.setText(this.mCellActiveAdv.copy);
            this.mTextGoodsDesc.setMaxLines(4);
            this.mTextGoodsDesc.setTextSize(1, 15.0f);
            this.mTextGoodsDesc.setTextColor(-16777216);
            this.mActionButton.setTextSize(1, 15.0f);
            this.mActionButton.setText(this.mCellActiveAdv.buttonText);
            setViewGone(this.mTextGoodsName);
            setViewGone(this.mTextDisPrice);
            setViewGone(this.mTextRightDesc);
            setViewGone(this.mTextDisPriceSuperScript);
            int h16 = com.qzone.adapter.feedcomponent.j.h(583);
            this.mActionButton.setTextColor(Color.parseColor(COLOR_FOR_NORMAL_BUTTON_TEXT));
            this.mActionButton.setBackgroundResource(h16);
            return;
        }
        setViewGone(this.mImageGoods);
    }

    void updateCommImage(int i3, int i16, String str) {
        if (this.mImageGoods.getBackground() != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.mImageGoods.getBackground().mutate();
            if (i16 > 0 && this.mFeedPictureInfo.f50256s > 0) {
                int c16 = com.qzone.adapter.feedcomponent.b.c();
                int c17 = com.qzone.adapter.feedcomponent.b.c();
                FeedPictureInfo feedPictureInfo = this.mFeedPictureInfo;
                gradientDrawable.setSize(c16, (c17 * feedPictureInfo.f50257t) / feedPictureInfo.f50256s);
            } else {
                gradientDrawable.setSize(com.qzone.adapter.feedcomponent.b.c(), com.qzone.adapter.feedcomponent.b.c() / 2);
            }
        }
        this.mImageGoods.setAsyncClipSize(i3, i16);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mImageGoods.setAsyncImage(str);
    }

    void updateGoodsData() {
        if (this.mCellGoods == null) {
            setViewGone(this.mContainerGoodsData);
            setViewGone(this.mTextGoodsDesc);
            return;
        }
        int h16 = com.qzone.adapter.feedcomponent.j.h(583);
        int i3 = this.mCellGoods.btnColor;
        String str = COLOR_FOR_NORMAL_BUTTON_TEXT;
        if (i3 == 0) {
            h16 = com.qzone.adapter.feedcomponent.j.h(583);
        } else if (i3 == 1) {
            h16 = com.qzone.adapter.feedcomponent.j.h(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST);
            str = COLOR_FOR_YELLOW_BUTTON_TEXT;
        } else if (i3 == 2) {
            h16 = com.qzone.adapter.feedcomponent.j.h(584);
        }
        int i16 = this.mCellGoods.goodsType;
        if (i16 != 1 && i16 != 2 && i16 != 3) {
            setupGoodsData(h16, str);
        } else {
            setupGoodsData(h16, str);
        }
        setViewVisbile(this.mContainerGoodsData);
    }

    void updateGoodsImage() {
        FeedPictureInfo feedPictureInfo = this.mFeedPictureInfo;
        if (feedPictureInfo == null) {
            setViewGone(this.mImageGoods);
            return;
        }
        String str = (feedPictureInfo.h() == null || TextUtils.isEmpty(this.mFeedPictureInfo.h().url)) ? null : this.mFeedPictureInfo.h().url;
        FeedPictureInfo feedPictureInfo2 = this.mFeedPictureInfo;
        updateCommImage(feedPictureInfo2.f50256s, feedPictureInfo2.f50257t, str);
        if (this.mFeedPictureInfo.d() == FeedPictureInfo.ImageType.IMAGE_GIF && this.mFeedPictureInfo.i()) {
            this.mImageGoods.setAsynGifImage(this.mFeedPictureInfo.b().url, this);
        }
        setViewVisbile(this.mImageGoods);
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.mFeedPictureInfo = null;
        this.mCellGoods = null;
        this.mCellActiveAdv = null;
        this.mPhotoMode = 0;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.feedType == 4098) {
            MyFeedViewBuilder.setGoodsData(this, businessFeedData, com.qzone.adapter.feedcomponent.i.H().W());
            return;
        }
        if ((businessFeedData.getFeedCommInfo().feedsAttr & 1024) != 0) {
            FeedPictureInfo[] u16 = com.qzone.adapter.feedcomponent.d.u(businessFeedData, com.qzone.adapter.feedcomponent.i.H().W());
            if (u16 != null && u16.length > 0) {
                setGoodsPicture(u16[0]);
            }
            setGoodsData(businessFeedData.getGoods());
            setPhotoMode(com.qzone.adapter.feedcomponent.i.H().W());
        } else if (businessFeedData.getActiveAdv() != null) {
            setFeedActiveAdvData(businessFeedData.getActiveAdv());
        }
        update();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }
}
