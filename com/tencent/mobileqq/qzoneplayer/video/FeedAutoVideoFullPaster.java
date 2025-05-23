package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes35.dex */
public class FeedAutoVideoFullPaster extends BaseVideo {

    /* renamed from: d, reason: collision with root package name */
    private DescTextView f279790d;

    /* renamed from: e, reason: collision with root package name */
    private DescTextView f279791e;

    /* loaded from: classes35.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoFullPaster.a(FeedAutoVideoFullPaster.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes35.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoFullPaster.a(FeedAutoVideoFullPaster.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes35.dex */
    public interface c {
    }

    public FeedAutoVideoFullPaster(Context context) {
        super(context);
        b();
        initData();
    }

    static /* synthetic */ c a(FeedAutoVideoFullPaster feedAutoVideoFullPaster) {
        feedAutoVideoFullPaster.getClass();
        return null;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void getTimeview() {
        if (this.mTimeview == null && this.hasTimeview) {
            Context context = getContext();
            if (this.bottomShadow == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.bottomShadow = relativeLayout;
                relativeLayout.setContentDescription("bottomShadow");
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, FeedVideoEnv.dp35);
                layoutParams.gravity = 53;
                this.bottomShadow.setBackground(FeedVideoEnv.feedResources.getDrawable(AppConstants.RiskHintTemplate.TEMPLATE_TYPE_RISK_FOR_PROTECT));
                this.bottomShadow.setVisibility(8);
                addView(this.bottomShadow, layoutParams);
                DescTextView descTextView = new DescTextView(context, "mDetailJumpView");
                this.f279790d = descTextView;
                descTextView.setTextColor(-1);
                this.f279790d.setTextSize(12.0f);
                this.f279790d.setPadding(FeedVideoEnv.dp12, 0, 0, 0);
                this.f279790d.setCompoundDrawablesWithIntrinsicBounds(FeedVideoEnv.feedResources.getDrawable(1102), (Drawable) null, (Drawable) null, (Drawable) null);
                this.f279790d.setCompoundDrawablePadding(FeedVideoEnv.dp5);
                this.f279790d.setText("\u8be6\u60c5\u70b9\u51fb");
                this.f279790d.setSingleLine();
                this.f279790d.setOnClickListener(new a());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(9);
                layoutParams2.addRule(15);
                this.bottomShadow.addView(this.f279790d, layoutParams2);
                DescTextView descTextView2 = new DescTextView(context, "mTimeview");
                this.mTimeview = descTextView2;
                descTextView2.setId(View.generateViewId());
                this.mTimeview.setTextColor(-1);
                this.mTimeview.setTextSize(12.0f);
                this.mTimeview.setPadding(FeedVideoEnv.dp15 / 2, 0, FeedVideoEnv.dp12, 0);
                this.mTimeview.setGravity(17);
                this.mTimeview.setSingleLine();
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(15);
                this.bottomShadow.addView(this.mTimeview, layoutParams3);
                DescTextView descTextView3 = new DescTextView(context, "mSkipPasterAdvView");
                this.f279791e = descTextView3;
                descTextView3.setTextColor(-1);
                this.f279791e.setTextSize(12.0f);
                this.f279791e.setCompoundDrawablesWithIntrinsicBounds(FeedVideoEnv.feedResources.getDrawable(1101), (Drawable) null, (Drawable) null, (Drawable) null);
                this.f279791e.setCompoundDrawablePadding(FeedVideoEnv.dp5);
                this.f279791e.setText("\u8df3\u8fc7\u5e7f\u544a");
                this.f279791e.setSingleLine();
                this.f279791e.setOnClickListener(new b());
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.addRule(0, this.mTimeview.getId());
                layoutParams4.addRule(15);
                this.bottomShadow.addView(this.f279791e, layoutParams4);
            }
        }
        RelativeLayout relativeLayout2 = this.bottomShadow;
        if (relativeLayout2 != null) {
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) relativeLayout2.getLayoutParams();
            layoutParams5.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp35;
            layoutParams5.gravity = 53;
            this.bottomShadow.setLayoutParams(layoutParams5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void initChildView() {
        super.initChildView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void measureCover(int i3, int i16) {
        BaseVideoCover baseVideoCover = this.mVideoCover;
        if (baseVideoCover != null && baseVideoCover.getVisibility() != 8) {
            this.mVideoCover.measure(i3, i16);
        }
        RelativeLayout relativeLayout = this.bottomShadow;
        if (relativeLayout == null || relativeLayout.getVisibility() == 8) {
            return;
        }
        this.bottomShadow.measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.dp35, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        BaseVideoCover baseVideoCover = this.mVideoCover;
        int i17 = baseVideoCover.picWidth;
        int i18 = baseVideoCover.picHeight;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            super.onMeasure(i3, i16);
        } else {
            int defaultSize = View.getDefaultSize(0, i3);
            int defaultSize2 = View.getDefaultSize(0, i16);
            if (i17 > 0 && i18 > 0) {
                int i19 = i17 * defaultSize2;
                int i26 = defaultSize * i18;
                if (i19 > i26) {
                    defaultSize2 = i26 / i17;
                } else if (i19 < i26) {
                    defaultSize = i19 / i18;
                }
            }
            View view = this.mVideoView;
            if (view != null && view.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVideoView.getLayoutParams();
                this.mVideoView.measure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2 - (marginLayoutParams.topMargin * 2), 1073741824));
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824);
            ViewGroup.LayoutParams layoutParams2 = this.mVideoCover.getLayoutParams();
            layoutParams2.height = -1;
            layoutParams2.width = -1;
            this.mVideoCover.setLayoutParams(layoutParams2);
            this.mVideoCover.measure(makeMeasureSpec, makeMeasureSpec2);
            setMeasuredDimension(defaultSize, defaultSize2);
        }
        RelativeLayout relativeLayout = this.bottomShadow;
        if (relativeLayout != null) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams3.topMargin = getMeasuredHeight() - FeedVideoEnv.dp35;
            layoutParams3.gravity = 53;
            this.bottomShadow.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onReceivedMessage(Message message) {
        super.onReceivedMessage(message);
        int i3 = message.what;
        if (i3 == 1) {
            getBaseVideoManager().enableAutoVideoSound();
            return;
        }
        if (i3 == 4) {
            this.bottomShadow.setVisibility(8);
            return;
        }
        if (i3 == 17) {
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullPaster.3
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideoFullPaster.this.bottomShadow.setVisibility(0);
                }
            }, 500);
            getBaseVideoManager().enableAutoVideoSound();
        } else {
            if (i3 != 20) {
                return;
            }
            getBaseVideoManager().enableAutoVideoSound();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onSetVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        getBaseVideoManager().schedulePreload(this.mVideoPlayInfo.a());
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        super.setVideoPlayInfo(videoPlayInfo);
    }

    private void b() {
        this.hasSoundTipLayout = false;
        this.hasSoundLinesLayout = false;
        this.mPlayCountView = null;
        this.mSoundLinesLayout = null;
    }

    public FeedAutoVideoFullPaster(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
        initData();
    }

    public FeedAutoVideoFullPaster(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
        initData();
    }

    private void initData() {
    }

    public void setPasterVideoEventListener(c cVar) {
    }
}
