package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.view.CornerImageView;
import com.qzone.module.feedcomponent.view.RadioCornerImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedAppShareCardView extends RelativeLayout implements View.OnClickListener {
    private static final float CONTENT_PIC_WIDTH_HEIGHT_RADIO = 1.4958333f;
    int feedPosition;
    private int mActualHeight;
    private int mActualWeight;
    private final int mAvatarMaxCount;
    private Button mBottomBarActionButton;
    private TextView mBottomBarDescView;
    private CornerImageView mBottomBarIconView;
    private TextView mBottomBarTitleView;
    private View mBottomBarmContainer;
    private View mBottomTailContainer;
    private CornerImageView mBottomTailIcon;
    private TextView mBottomTailTitle;
    private VisitAndPraiseAvatarsView mContentAvatarsView;
    private TextView mContentDescView;
    private RadioCornerImageView mContentPicView;
    protected BusinessFeedData mFeedData;
    com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;

    public FeedAppShareCardView(Context context) {
        this(context, null);
    }

    private void drawBackground(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        Paint paint = new Paint();
        paint.setColor(com.qzone.adapter.feedcomponent.j.m());
        paint.setShadowLayer(AreaConst.f48749dp4, 0, AreaConst.f48747dp2, 335544320);
        int i3 = AreaConst.dp6;
        RectF rectF = new RectF(paddingLeft, paddingTop, width, height);
        float f16 = i3;
        canvas.drawRoundRect(rectF, f16, f16, paint);
    }

    private void setBigTailStyle(CellBottomRecomm cellBottomRecomm) {
        int i3;
        PictureUrl pictureUrl;
        PictureItem pictureItem = cellBottomRecomm.picinfo;
        if (pictureItem != null && (pictureUrl = pictureItem.currentUrl) != null) {
            String str = pictureUrl.url;
            if (!TextUtils.isEmpty(str)) {
                com.qzone.adapter.feedcomponent.j.V(this.mBottomBarIconView);
                this.mBottomBarIconView.setAsyncImage(str);
            }
        }
        int i16 = 0;
        if (TextUtils.isEmpty(cellBottomRecomm.title)) {
            i3 = 8;
        } else {
            this.mBottomBarTitleView.setText(cellBottomRecomm.title);
            i3 = 0;
        }
        if (!TextUtils.isEmpty(cellBottomRecomm.summary)) {
            this.mBottomBarDescView.setText(cellBottomRecomm.summary);
        }
        if (TextUtils.isEmpty(cellBottomRecomm.buttontext)) {
            i16 = 8;
        } else {
            this.mBottomBarActionButton.setText(cellBottomRecomm.buttontext);
        }
        this.mBottomBarmContainer.setVisibility(i3);
        this.mBottomBarActionButton.setVisibility(i16);
    }

    private void setSmallTailStyle(CellBottomRecomm cellBottomRecomm) {
        PictureUrl pictureUrl;
        PictureItem pictureItem = cellBottomRecomm.picinfo;
        if (pictureItem != null && (pictureUrl = pictureItem.currentUrl) != null) {
            String str = pictureUrl.url;
            if (!TextUtils.isEmpty(str)) {
                com.qzone.adapter.feedcomponent.j.V(this.mBottomBarIconView);
                this.mBottomTailIcon.setAsyncImage(str);
                this.mBottomTailIcon.setAsyncClipSize(this.mActualHeight, this.mActualWeight);
            }
        }
        if (!TextUtils.isEmpty(cellBottomRecomm.title)) {
            this.mBottomTailTitle.setText(cellBottomRecomm.title);
            this.mBottomTailContainer.setVisibility(0);
            View view = this.mBottomBarmContainer;
            if (view != null) {
                view.setVisibility(8);
            }
            SmallTailReportUtil.reportBigSmallTailExpose();
            return;
        }
        this.mBottomTailContainer.setVisibility(8);
    }

    public int getFeedPosition() {
        return this.feedPosition;
    }

    protected void initView(Context context) {
        View.inflate(context, DittoUIEngine.g().getResourceId("@layout/qzone_widget_feed_app_share_card"), this);
        int i3 = AreaConst.dp8;
        setPadding(i3, AreaConst.f48749dp4, i3, 0);
        setWillNotDraw(false);
        setLayerType(1, null);
        RadioCornerImageView radioCornerImageView = (RadioCornerImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2871));
        this.mContentPicView = radioCornerImageView;
        int i16 = AreaConst.dp6;
        radioCornerImageView.setRadius(new float[]{i16, i16, i16, i16, 0.0f, 0.0f, 0.0f, 0.0f});
        this.mContentPicView.setWidthHeightRadio(CONTENT_PIC_WIDTH_HEIGHT_RADIO);
        this.mContentAvatarsView = (VisitAndPraiseAvatarsView) findViewById(com.qzone.adapter.feedcomponent.j.O(2872));
        this.mContentDescView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2873));
        this.mBottomBarmContainer = findViewById(com.qzone.adapter.feedcomponent.j.O(2874));
        CornerImageView cornerImageView = (CornerImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2875));
        this.mBottomBarIconView = cornerImageView;
        cornerImageView.setRadius(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, i16, i16});
        this.mBottomBarTitleView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2876));
        this.mBottomBarDescView = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2877));
        this.mBottomBarActionButton = (Button) findViewById(com.qzone.adapter.feedcomponent.j.O(2878));
        this.mContentPicView.setOnClickListener(this);
        this.mBottomBarmContainer.setOnClickListener(this);
        this.mBottomBarActionButton.setOnClickListener(this);
        View findViewById = findViewById(com.qzone.adapter.feedcomponent.j.O(2914));
        this.mBottomTailContainer = findViewById;
        findViewById.setOnClickListener(this);
        CornerImageView cornerImageView2 = (CornerImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2915));
        this.mBottomTailIcon = cornerImageView2;
        int i17 = AreaConst.f48748dp3;
        cornerImageView2.setRadius(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, i17, i17});
        this.mBottomTailTitle = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2916));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onApplyFeedData() {
        int i3;
        List<CellLikeInfo.LikeMan> convertUserList;
        BusinessFeedData businessFeedData = this.mFeedData;
        int i16 = 8;
        if (businessFeedData != null && businessFeedData.isAppShareCardFeed()) {
            int i17 = 0;
            setVisibility(0);
            CellPictureInfo pictureInfo = this.mFeedData.getPictureInfo();
            if (pictureInfo != null) {
                ArrayList<PictureItem> arrayList = pictureInfo.pics;
                if (arrayList != null && arrayList.size() > 0 && pictureInfo.pics.get(0).currentUrl != null) {
                    String str = pictureInfo.pics.get(0).currentUrl.url;
                    if (!TextUtils.isEmpty(str)) {
                        com.qzone.adapter.feedcomponent.j.V(this.mContentPicView);
                        this.mContentPicView.setAsyncImage(str);
                    }
                }
                ArrayList<User> arrayList2 = pictureInfo.facemans;
                if (arrayList2 == null || arrayList2.size() <= 0 || (convertUserList = convertUserList(pictureInfo.facemans)) == null || convertUserList.size() <= 0) {
                    i3 = 8;
                } else {
                    this.mContentAvatarsView.setAvatarSize(AreaManager.dp22);
                    int size = convertUserList.size();
                    int i18 = this.mAvatarMaxCount;
                    if (size > i18) {
                        this.mContentAvatarsView.setPraiseData(convertUserList.subList(0, i18), 0, false, null, -1, -1);
                    } else {
                        this.mContentAvatarsView.setPraiseData(convertUserList, 0, false, null, -1, -1);
                    }
                    this.mContentAvatarsView.setAvatarPressEnable(false);
                    this.mContentAvatarsView.requestLayout();
                    i3 = 0;
                }
                if (TextUtils.isEmpty(pictureInfo.shareNewReason)) {
                    i17 = 8;
                } else {
                    this.mContentDescView.setText(pictureInfo.shareNewReason);
                }
                i16 = i3;
            } else {
                i17 = 8;
            }
            CellBottomRecomm cellBottomRecomm = this.mFeedData.getCellBottomRecomm();
            if (cellBottomRecomm != null) {
                if (com.qzone.adapter.feedcomponent.i.H().V0()) {
                    setSmallTailStyle(cellBottomRecomm);
                } else {
                    setBigTailStyle(cellBottomRecomm);
                }
            }
            this.mContentAvatarsView.setVisibility(i16);
            this.mContentDescView.setVisibility(i17);
            invalidate();
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar != null) {
            RadioCornerImageView radioCornerImageView = this.mContentPicView;
            if (view == radioCornerImageView) {
                gVar.onClick(radioCornerImageView, FeedElement.PHOTO, getFeedPosition(), new com.qzone.proxy.feedcomponent.model.f(this.feedPosition, 0, false, false));
            } else {
                View view2 = this.mBottomBarmContainer;
                if (view != view2 && view != this.mBottomTailContainer) {
                    Button button = this.mBottomBarActionButton;
                    if (view == button) {
                        gVar.onClick(button, FeedElement.FEED_APP_SHARE_CARD_CONTENT_BOTTOM_BAR_ACTION_BUTTON, getFeedPosition(), null);
                        if (this.mFeedData != null) {
                            com.qzone.adapter.feedcomponent.i.H().D(12, 211, 1, System.currentTimeMillis(), this.mFeedData.getFeedCommInfo().isRealTimeTTTReport());
                        }
                    }
                } else {
                    gVar.onClick(view2, FeedElement.FEED_APP_SHARE_CARD_CONTENT_BOTTOM_BAR, getFeedPosition(), null);
                    if (this.mFeedData != null) {
                        com.qzone.adapter.feedcomponent.i.H().D(12, 211, 1, System.currentTimeMillis(), this.mFeedData.getFeedCommInfo().isRealTimeTTTReport());
                        if (view == this.mBottomTailContainer) {
                            SmallTailReportUtil.reportBigSmallTailClick();
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
    }

    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public FeedAppShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActualHeight = com.qzone.proxy.feedcomponent.util.g.a(11.0f);
        this.mActualWeight = com.qzone.proxy.feedcomponent.util.g.a(11.0f);
        this.mAvatarMaxCount = com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "feed_app_share_card_avatar_max_count", 3);
        initView(context);
    }

    private List<CellLikeInfo.LikeMan> convertUserList(ArrayList<User> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            CellLikeInfo.LikeMan likeMan = new CellLikeInfo.LikeMan();
            likeMan.user = arrayList.get(i3);
            arrayList2.add(likeMan);
        }
        return arrayList2;
    }
}
