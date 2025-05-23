package com.tencent.mobileqq.qzoneplayer.cover.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoClickElement;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoData;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.qzoneplayer.video.l;
import com.tencent.mobileqq.qzoneplayer.video.s;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* loaded from: classes35.dex */
public class NetChangeWarnPage extends AbsCoverUI {
    protected TextView mActionButton;
    protected boolean mIsNetworkDisconnect;
    protected TextView mNetDisconnectTxtView;
    protected BaseVideo mParent;
    protected LinearLayout mWarnLayout;
    protected TextView mWarnTextView;

    public NetChangeWarnPage(Context context, BaseVideo baseVideo) {
        super(context);
        this.mIsNetworkDisconnect = false;
        this.mParent = baseVideo;
    }

    @Deprecated
    public void clickActionButton() {
        TextView textView = this.mActionButton;
        if (textView != null) {
            textView.performClick();
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(16);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void initChildView() {
        this.mWarnTextView = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(610));
        this.mActionButton = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(611));
        this.mNetDisconnectTxtView = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(612));
        this.mWarnLayout = (LinearLayout) findViewById(FeedVideoEnv.feedResources.getViewId(629));
        this.mActionButton.setOnClickListener(this);
        setVisibility(8);
    }

    public boolean isActionButtonShown() {
        TextView textView = this.mActionButton;
        return textView != null && textView.isShown();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == FeedVideoEnv.feedResources.getViewId(611)) {
            this.mBaseVideoPresenter.onClick(view, isAdv(), VideoClickElement.NET_RESUME, this.mPos, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdateUI() {
        showCoverWarnPage();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void reset() {
        super.reset();
        updateUI();
    }

    protected void showCoverWarnPage() {
        BaseVideoCover.CoverWarnType coverWarnType;
        long j3;
        VideoData.BaseVideoCoverData baseVideoCoverData;
        VideoPlayInfo videoPlayInfo;
        SegmentVideoInfo segmentVideoInfo;
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (isParentInit()) {
            BaseVideoPresenter baseVideoPresenter = this.mBaseVideoPresenter;
            if (baseVideoPresenter != null) {
                coverWarnType = baseVideoPresenter.getWarnType();
            } else {
                coverWarnType = BaseVideoCover.CoverWarnType.DEFAULT;
            }
            BaseVideoPresenter baseVideoPresenter2 = this.mBaseVideoPresenter;
            boolean z16 = baseVideoPresenter2 != null && baseVideoPresenter2.isVideoPicMixMode();
            if (BaseVideoCover.CoverWarnType.DEFAULT != coverWarnType && !z16) {
                if (BaseVideoCover.CoverWarnType.NETWORK_CHANGE == coverWarnType) {
                    setVisibility(0);
                    this.mNetDisconnectTxtView.setVisibility(8);
                    VideoData videoData = this.mBaseVideoData;
                    if (videoData == null || (baseVideoCoverData = videoData.baseVideoCoverData) == null || (videoPlayInfo = baseVideoCoverData.videoPlayInfo) == null || (segmentVideoInfo = videoPlayInfo.segmentVideoInfo) == null || segmentVideoInfo.getDefaultUrl() == null) {
                        j3 = -1;
                    } else {
                        String defaultUrl = this.mBaseVideoData.baseVideoCoverData.videoPlayInfo.segmentVideoInfo.getDefaultUrl();
                        l h16 = s.g().h(this.mBaseVideoData.baseVideoCoverData.videoPlayInfo.segmentVideoInfo.getDefaultUrl(), false);
                        if (h16 != null && (arrayList = h16.f280002b) != null && arrayList.size() > 0) {
                            defaultUrl = h16.f280002b.get(0).url;
                        }
                        j3 = VideoManager.getInstance().getUnCachedSize(defaultUrl);
                        PlayerUtils.log(5, "zakiwang", "remainUnCachedBytes:" + j3);
                    }
                    String string = FeedVideoEnv.feedResources.getString(1382);
                    if (j3 > 0) {
                        string = "\u5f53\u524d\u4e3a\u975ewifi\u73af\u5883\uff0c\u89c2\u770b\u5c06\u6d88\u8017" + getRemainUnCachedSize(j3) + "\u6d41\u91cf";
                    }
                    this.mWarnTextView.setVisibility(0);
                    this.mWarnTextView.setText(string);
                    this.mActionButton.setVisibility(0);
                    this.mParent.isTimeViewVisible(false);
                    this.mParent.setShowCoverWarnType(true);
                } else if (BaseVideoCover.CoverWarnType.NETWORK_DISCONNECT == coverWarnType) {
                    setVisibility(0);
                    LinearLayout linearLayout = this.mWarnLayout;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    this.mIsNetworkDisconnect = true;
                    this.mNetDisconnectTxtView.setVisibility(0);
                    this.mParent.isTimeViewVisible(false);
                    this.mParent.setShowCoverWarnType(true);
                    return;
                }
            } else {
                setVisibility(8);
            }
            this.mIsNetworkDisconnect = false;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowDefaultView(Message message) {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowErrorView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPauseView() {
        setVisibility(0);
        showCoverWarnPage();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayCompleteView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayFloatCompleteView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayingView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowRetryView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowStopView() {
        setVisibility(0);
        showCoverWarnPage();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowWaitView() {
        setVisibility(4);
    }

    public static String getRemainUnCachedSize(long j3) {
        if (j3 > 1073741824) {
            float f16 = ((float) j3) / 1.07374182E9f;
            if (j3 > 107374182400L) {
                return ((int) (f16 + 0.5f)) + "G";
            }
            return String.format("%.1f", Float.valueOf(f16)) + "G";
        }
        if (j3 > 1048576) {
            float f17 = ((float) j3) / 1048576.0f;
            if (j3 > 1047527424) {
                return "999M";
            }
            if (j3 > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                return ((int) (f17 + 0.5f)) + "M";
            }
            return String.format("%.1f", Float.valueOf(f17)) + "M";
        }
        if (j3 <= 1024) {
            if (j3 > 0) {
                return "0K";
            }
            return "";
        }
        float f18 = ((float) j3) / 1024.0f;
        if (j3 > 1022976) {
            return "999K";
        }
        if (j3 > FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            return ((int) (f18 + 0.5f)) + "K";
        }
        return String.format("%.1f", Float.valueOf(f18)) + "K";
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
    }
}
