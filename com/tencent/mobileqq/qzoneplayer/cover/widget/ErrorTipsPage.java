package com.tencent.mobileqq.qzoneplayer.cover.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoClickElement;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes35.dex */
public class ErrorTipsPage extends AbsCoverUI {
    private volatile String mDefaultLoadFailedText;
    private String mDefaultRetryText;
    protected TextView mErrorIcon;
    protected TextView mRetryIcon;

    public ErrorTipsPage(Context context) {
        super(context);
        this.mDefaultLoadFailedText = "\u89c6\u9891\u64ad\u653e\u5931\u8d25";
        this.mDefaultRetryText = "\u91cd\u65b0\u64ad\u653e";
    }

    @Deprecated
    public void clickActionButton() {
        TextView textView = this.mRetryIcon;
        if (textView != null) {
            textView.performClick();
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(17);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void initChildView() {
        this.mErrorIcon = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(615));
        TextView textView = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(616));
        this.mRetryIcon = textView;
        textView.setOnClickListener(this);
        setVisibility(8);
    }

    public boolean isActionButtonShown() {
        TextView textView = this.mRetryIcon;
        return textView != null && textView.isShown();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mBaseVideoClickListener != null && view.getId() == FeedVideoEnv.feedResources.getViewId(616)) {
            this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.ERROR_PAGE_RETRY, this.mPos, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void reset() {
        super.reset();
    }

    public void setLoadFailedText(String str) {
        this.mDefaultLoadFailedText = str;
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.cover.widget.ErrorTipsPage.1
            @Override // java.lang.Runnable
            public void run() {
                ErrorTipsPage errorTipsPage = ErrorTipsPage.this;
                errorTipsPage.mErrorIcon.setText(errorTipsPage.mDefaultLoadFailedText);
            }
        });
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowDefaultView(Message message) {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowErrorView() {
        setVisibility(0);
        this.mErrorIcon.setVisibility(0);
        this.mErrorIcon.setText(this.mDefaultLoadFailedText);
        this.mRetryIcon.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPauseView() {
        setVisibility(4);
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
        setVisibility(0);
        String str = this.mDefaultLoadFailedText;
        String str2 = this.mDefaultRetryText;
        this.mErrorIcon.setText(str);
        this.mRetryIcon.setText(str2);
        this.mErrorIcon.setVisibility(0);
        this.mRetryIcon.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowStopView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowWaitView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdateUI() {
    }
}
