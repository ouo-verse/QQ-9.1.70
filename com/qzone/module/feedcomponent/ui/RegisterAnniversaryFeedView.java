package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.processor.AdvRoundCornerProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RegisterAnniversaryFeedView extends AbsFeedView implements View.OnClickListener {
    View feedBody;
    AvatarImageView mAvatar;
    View mAvatarContainer;
    View mContentArea;
    AsyncImageView mContentBottomAreaPic;
    View mContentTopArea;
    AsyncImageView mContentTopAreaPic;
    AsyncImageView mCornerDecrationIcon;
    TextView mDescLeft;
    TextView mDescMiddle;
    TextView mDescRight;
    AsyncImageView mDropdownButton;
    BusinessFeedData mFeedData;
    protected int mFeedPosition;
    TextView mGuideText;
    TextView mNickName;
    protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    View mOperationArea;
    AsyncImageView mOpertaionIcon;
    TextView mOpertaionText;
    TextView mTitle;
    int mTrans;
    AsyncImageView mVideoPlayBtn;

    public RegisterAnniversaryFeedView(Context context) {
        super(context);
        this.mTrans = 255;
        setBackgroundColor(0);
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1712), (ViewGroup) null);
        this.feedBody = inflate;
        addView(inflate);
        this.mTitle = (TextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2792));
        this.mDropdownButton = (AsyncImageView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2793));
        this.mContentArea = this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2796));
        this.mContentTopArea = this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2797));
        this.mContentTopAreaPic = (AsyncImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2798));
        this.mAvatarContainer = this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2799));
        this.mAvatar = (AvatarImageView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2800));
        this.mNickName = (TextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2801));
        this.mDescLeft = (TextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2803));
        this.mDescMiddle = (TextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2804));
        this.mDescRight = (TextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2805));
        this.mVideoPlayBtn = (AsyncImageView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2802));
        this.mContentBottomAreaPic = (AsyncImageView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2806));
        this.mGuideText = (TextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2807));
        this.mOperationArea = this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2808));
        this.mOpertaionIcon = (AsyncImageView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2809));
        this.mOpertaionText = (TextView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2810));
        this.mCornerDecrationIcon = (AsyncImageView) this.feedBody.findViewById(com.qzone.adapter.feedcomponent.j.O(2811));
        setOnClickListener(this);
        this.mContentTopArea.setOnClickListener(this);
        this.mGuideText.setOnClickListener(this);
        this.mOperationArea.setOnClickListener(this);
        this.mDropdownButton.setOnClickListener(this);
        this.mAvatar.setClickable(false);
        this.mAvatar.setAvatarMask(0);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPosition;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.qzone.proxy.feedcomponent.ui.g gVar = this.mOnFeedElementClickListener;
        if (gVar != null) {
            if (view != this.mContentTopArea && view != this.mGuideText) {
                if (view == this.mOperationArea) {
                    BusinessFeedData businessFeedData = this.mFeedData;
                    if (businessFeedData != null) {
                        gVar.onClick(this, FeedElement.FEED_REGISTER_ANNIVERSARY_OPERATION_AREA_CLICKED, this.mFeedPosition, businessFeedData.getCellGuiding());
                    }
                } else {
                    AsyncImageView asyncImageView = this.mDropdownButton;
                    if (view == asyncImageView) {
                        FeedElement feedElement = FeedElement.FEEDBACK;
                        int i3 = this.mFeedPosition;
                        gVar.onClick(asyncImageView, feedElement, i3, Integer.valueOf(i3));
                    }
                }
            } else {
                BusinessFeedData businessFeedData2 = this.mFeedData;
                if (businessFeedData2 != null) {
                    gVar.onClick(this, FeedElement.FEED_REGISTER_ANNIVERSARY_PIC_AREA_CLICKED, this.mFeedPosition, businessFeedData2.getCellGuiding());
                }
                com.qzone.adapter.feedcomponent.i.H().f2(109, 2, 2, "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        Drawable background;
        Drawable background2;
        this.mTrans = i3;
        View view = this.feedBody;
        if (view != null && (background2 = view.getBackground()) != null) {
            background2.setAlpha(this.mTrans);
        }
        View view2 = this.mContentArea;
        if (view2 == null || (background = view2.getBackground()) == null) {
            return;
        }
        background.mutate();
        background.setAlpha(this.mTrans);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        TextView textView;
        Map<String, String> map;
        int i3;
        int i16;
        AsyncImageView asyncImageView;
        TextView textView2;
        AsyncImageView asyncImageView2;
        TextView textView3;
        AsyncImageView asyncImageView3;
        AsyncImageView asyncImageView4;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        if (businessFeedData != null) {
            this.mFeedData = businessFeedData;
            CellGuiding cellGuiding = businessFeedData.getCellGuiding();
            if (cellGuiding != null && (map = cellGuiding.extendInfo) != null) {
                String str = map.get("top_cover_url");
                String str2 = cellGuiding.extendInfo.get("first_one_caption");
                String str3 = cellGuiding.extendInfo.get("year_num");
                String str4 = cellGuiding.extendInfo.get("first_two_caption");
                String str5 = cellGuiding.extendInfo.get("play_button_url");
                String str6 = cellGuiding.extendInfo.get("bottom_cover_url");
                String str7 = cellGuiding.extendInfo.get("second_caption");
                String str8 = cellGuiding.extendInfo.get("operate_button_url");
                String str9 = cellGuiding.extendInfo.get("operate_button_text");
                String str10 = cellGuiding.extendInfo.get("balloon_url");
                if (!TextUtils.isEmpty(str) && this.mContentTopAreaPic != null) {
                    this.mContentTopAreaPic.setAsyncImageProcessor(new AdvRoundCornerProcessor(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f}, AreaManager.NORMAL_FEED_WIDTH, AreaManager.dp170));
                    this.mContentTopAreaPic.setAsyncImage(str);
                }
                if (TextUtils.isEmpty(str2) || (textView6 = this.mDescLeft) == null) {
                    i3 = 0;
                } else {
                    textView6.setText(str2);
                    i3 = 0;
                    this.mDescLeft.setVisibility(0);
                }
                if (!TextUtils.isEmpty(str3) && (textView5 = this.mDescMiddle) != null) {
                    textView5.setText(str3);
                    AsyncImageView asyncImageView5 = this.mOpertaionIcon;
                    if (asyncImageView5 != null) {
                        asyncImageView5.setVisibility(i3);
                    }
                }
                if (!TextUtils.isEmpty(str4) && (textView4 = this.mDescRight) != null) {
                    textView4.setText(str4);
                    this.mDescRight.setVisibility(i3);
                }
                if (!TextUtils.isEmpty(str5) && (asyncImageView4 = this.mVideoPlayBtn) != null) {
                    asyncImageView4.setAsyncImage(str5);
                    this.mVideoPlayBtn.setVisibility(i3);
                }
                if (!TextUtils.isEmpty(str6) && (asyncImageView3 = this.mContentBottomAreaPic) != null) {
                    asyncImageView3.setAsyncImage(str6);
                }
                if (!TextUtils.isEmpty(str7) && (textView3 = this.mGuideText) != null) {
                    textView3.setText(str7);
                }
                if (TextUtils.isEmpty(str8) || (asyncImageView2 = this.mOpertaionIcon) == null) {
                    i16 = 0;
                } else {
                    asyncImageView2.setAsyncImage(str8);
                    i16 = 0;
                    this.mOpertaionIcon.setVisibility(0);
                }
                if (!TextUtils.isEmpty(str9) && (textView2 = this.mOpertaionText) != null) {
                    textView2.setText(str9);
                    this.mOpertaionText.setVisibility(i16);
                }
                if (!TextUtils.isEmpty(str10) && (asyncImageView = this.mCornerDecrationIcon) != null) {
                    asyncImageView.setAsyncImage(str10);
                    this.mCornerDecrationIcon.setVisibility(i16);
                }
            }
            if (businessFeedData.getRecommHeader() != null && !TextUtils.isEmpty(businessFeedData.getRecommHeader().leftTitle) && (textView = this.mTitle) != null) {
                textView.setText(businessFeedData.getRecommHeader().leftTitle);
            }
            if (businessFeedData.getUser() != null) {
                if (this.mAvatarContainer != null && this.mAvatar != null && businessFeedData.getUser().uin > 0) {
                    com.qzone.adapter.feedcomponent.j.V(this.mAvatar);
                    this.mAvatar.loadAvatar(businessFeedData.getUser().uin);
                    this.mAvatarContainer.setVisibility(0);
                }
                if (!TextUtils.isEmpty(businessFeedData.getUser().nickName)) {
                    this.mNickName.setText(businessFeedData.getUser().nickName);
                    this.mNickName.setVisibility(0);
                }
            }
            com.qzone.adapter.feedcomponent.i.H().f2(109, 2, 1, "");
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedFirstDrawListener(com.qzone.proxy.feedcomponent.ui.i iVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, Boolean bool) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
