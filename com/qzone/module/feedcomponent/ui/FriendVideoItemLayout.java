package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.AvatarAreaView;
import com.qzone.module.feedcomponent.ui.common.RoundedCornerRelativeLayout;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.tencent.luggage.wxa.gf.u;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FriendVideoItemLayout extends RoundedCornerRelativeLayout {
    private static final String TAG = "FRIENDVIDEO";
    public static final int VIDEO_HEIGHT = AreaManager.dp200;
    public AvatarAreaView avatarImageView;
    public View cover;
    public TextView hotInfoView;
    public boolean liked;
    public ImageView mBorderView;
    private BusinessFeedData mFeedData;
    private Drawable mGradientDrawable;
    public int mIndex;
    public FeedVideoView mVideoView;
    public CellTextView nickNameView;
    public ImageView praisview;

    public FriendVideoItemLayout(Context context) {
        super(context);
        this.liked = false;
        setContentDescription("\u597d\u53cb\u77ed\u89c6\u9891");
        initUI(context);
    }

    @Override // com.qzone.module.feedcomponent.ui.common.RoundedCornerRelativeLayout, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        try {
            if (this.mGradientDrawable == null) {
                this.mGradientDrawable = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(856));
            }
            this.mGradientDrawable.setBounds(0, 0, getMeasuredWidth(), AreaManager.dp50);
            this.mGradientDrawable.draw(canvas);
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.d("Feed", "", th5);
        }
    }

    public FeedVideoView getVideoView() {
        return this.mVideoView;
    }

    public void setCoverIndex(int i3) {
        setTag(Integer.valueOf(i3));
    }

    public void setData(BusinessFeedData businessFeedData, int i3) {
        String str;
        if (businessFeedData == null) {
            com.qzone.proxy.feedcomponent.b.c(TAG, "friend video feeddata is null");
            return;
        }
        this.mFeedData = businessFeedData;
        String str2 = "Null";
        if (com.qzone.adapter.feedcomponent.i.H().X0()) {
            PictureUrl pictureUrl = businessFeedData.getVideoInfo() != null ? businessFeedData.getVideoInfo().coverUrl : null;
            if (pictureUrl == null) {
                str = "Null";
            } else {
                str = businessFeedData.getVideoInfo().coverUrl.url;
            }
            if (pictureUrl == null) {
                com.qzone.proxy.feedcomponent.b.c(TAG, "videoinfo is null");
                return;
            }
            com.qzone.proxy.feedcomponent.b.c(TAG, String.format("cover size:%d %d, url:%s, widthPassed in: %d", Integer.valueOf(pictureUrl.width), Integer.valueOf(pictureUrl.height), str, Integer.valueOf(i3)));
        }
        this.nickNameView.setText(businessFeedData.getCellUserInfo().getUser().nickName);
        this.avatarImageView.setUser(businessFeedData.getCellUserInfo().getUser());
        if (FriendVideoFeedView.isWeishiVideoContainer(businessFeedData)) {
            this.mBorderView.setImageDrawable(FriendVideoFeedView.avatarBorderWeishi);
        } else {
            this.mBorderView.setImageDrawable(FriendVideoFeedView.avatarBorder);
        }
        this.mVideoView.setLayoutParams(new RelativeLayout.LayoutParams(i3, VIDEO_HEIGHT));
        if (businessFeedData.getVideoInfo() != null) {
            businessFeedData.getVideoInfo().playType = (byte) (businessFeedData.getVideoInfo().playType & (-3));
        }
        this.mVideoView.setMaxVideoWidth(i3);
        this.mVideoView.setFeedData(businessFeedData, businessFeedData.getVideoInfo());
        this.nickNameView.setMaxWidth(i3 - AreaManager.dp75);
        if (com.qzone.adapter.feedcomponent.i.H().X0()) {
            Object[] objArr = new Object[1];
            if (businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().coverUrl != null) {
                str2 = businessFeedData.getVideoInfo().coverUrl.url;
            }
            objArr[0] = str2;
            com.qzone.proxy.feedcomponent.b.c(TAG, String.format("video cover url %s", objArr));
        }
        FeedAutoVideo feedAutoVideo = this.mVideoView.mAutoVideoView;
        feedAutoVideo.mVideoCover.showPlayIcon = false;
        feedAutoVideo.hideDurationTextView();
        this.mVideoView.mAutoVideoView.hideSoundLine();
        this.mVideoView.mAutoVideoView.mVideoCover.setShowOpenFreeTrafficIcon(false);
        this.mVideoView.setPadding(0, 0, 0, 0);
        ((ViewGroup.MarginLayoutParams) this.mVideoView.getLayoutParams()).topMargin = 0;
        ViewGroup.LayoutParams layoutParams = this.cover.getLayoutParams();
        if (layoutParams != null && layoutParams.width != i3) {
            layoutParams.width = i3;
            this.cover.setLayoutParams(layoutParams);
        }
        if (businessFeedData.getRecBusinessFeedDatas() != null && businessFeedData.getRecBusinessFeedDatas().size() > 0) {
            this.hotInfoView.setVisibility(0);
            this.hotInfoView.setText("" + businessFeedData.getRecBusinessFeedDatas().size());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hotInfoView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.setMargins(AreaManager.dp37, AreaManager.dp110 + AreaManager.dp45, 0, 0);
                this.hotInfoView.setLayoutParams(layoutParams2);
            }
        } else {
            this.hotInfoView.setVisibility(8);
        }
        if (businessFeedData.getLikeInfo().isLiked) {
            this.praisview.setImageDrawable(AreaManager.FEED_VIDEO_BANNER_PRAISE_P);
        } else {
            this.praisview.setImageDrawable(AreaManager.FEED_VIDEO_BANNER_PRAISE_N);
        }
        int i16 = AreaManager.dp22;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i16, i16);
        layoutParams3.addRule(9, -1);
        layoutParams3.setMargins(i3 - AreaManager.dp32, AreaManager.dp110 + AreaManager.dp52, 0, 0);
        this.praisview.setLayoutParams(layoutParams3);
        requestLayout();
    }

    public void setFeedPos(int i3, int i16) {
        this.mIndex = i16;
        FeedVideoView feedVideoView = this.mVideoView;
        if (feedVideoView != null) {
            feedVideoView.setFeedPos(i3, i16);
        }
    }

    private void initUI(Context context) {
        enableRoundedCorner(true);
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        FeedVideoView feedVideoView = new FeedVideoView(context);
        this.mVideoView = feedVideoView;
        feedVideoView.setAdjustToHeight(true, VIDEO_HEIGHT);
        this.mVideoView.mAutoVideoView.hideSoundLine();
        this.mVideoView.setInterceptTouchEvent(true);
        this.mVideoView.setId(com.qzone.adapter.feedcomponent.j.O(2747));
        addView(this.mVideoView);
        this.avatarImageView = new AvatarAreaView(context);
        int i3 = AreaManager.dp27;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams.addRule(5, -1);
        int i16 = AreaManager.dp13;
        int i17 = AreaManager.dp160;
        layoutParams.setMargins(i16, i17, 0, 0);
        this.avatarImageView.setSize(i3);
        this.avatarImageView.setContentDescription("\u5934\u50cf");
        addView(this.avatarImageView, layoutParams);
        ImageView imageView = new ImageView(context);
        this.mBorderView = imageView;
        imageView.setImageDrawable(FriendVideoFeedView.avatarBorder);
        int i18 = AreaManager.dp33;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i18, i18);
        layoutParams2.addRule(5, -1);
        int i19 = AreaManager.dp10;
        layoutParams2.setMargins(i19, i17 - AreaManager.f48752dp3, 0, 0);
        addView(this.mBorderView, layoutParams2);
        this.cover = new View(context);
        int i26 = AreaManager.dp80;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i26);
        layoutParams3.setMargins(0, AreaManager.dp120, 0, 0);
        Drawable drawable = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(856));
        this.mGradientDrawable = drawable;
        drawable.setBounds(0, 0, AreaManager.dp200, i26);
        this.cover.setBackgroundDrawable(this.mGradientDrawable);
        addView(this.cover, layoutParams3);
        this.nickNameView = new CellTextView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(5, -1);
        int i27 = AreaManager.dp48;
        int i28 = AreaManager.dp110;
        layoutParams4.setMargins(i27, AreaManager.dp55 + i28, 0, 0);
        this.nickNameView.setTextSize(AreaManager.dp14);
        this.nickNameView.setTextColor(-1);
        this.nickNameView.setMaxLine(1);
        this.nickNameView.setTextGravity(1);
        addView(this.nickNameView, layoutParams4);
        ImageView imageView2 = new ImageView(context);
        this.praisview = imageView2;
        imageView2.setImageDrawable(AreaManager.FEED_VIDEO_BANNER_PRAISE_P);
        int i29 = AreaManager.dp22;
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(i29, i29);
        layoutParams5.addRule(9, -1);
        layoutParams5.setMargins(0, AreaManager.dp52 + i28, i19, 0);
        addView(this.praisview, layoutParams5);
        this.hotInfoView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(0, i28, 0, 0);
        layoutParams6.addRule(5, -1);
        this.hotInfoView.setTextSize(12.0f);
        this.hotInfoView.setTextColor(-1);
        this.hotInfoView.setGravity(17);
        this.hotInfoView.setBackgroundDrawable(FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(u.CTRL_INDEX)));
        addView(this.hotInfoView, layoutParams6);
    }
}
