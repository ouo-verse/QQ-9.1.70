package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class AdCoverVideoView extends BaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    private int f90291d;

    /* renamed from: e, reason: collision with root package name */
    private RFWPlayerOptions f90292e;

    /* renamed from: f, reason: collision with root package name */
    private RFWPlayer f90293f;

    /* renamed from: h, reason: collision with root package name */
    private String f90294h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements IRFWPlayerSdkInitListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            QLog.d(AdCoverVideoView.this.getLogTag(), 4, "onInitSuccess");
            AdCoverVideoView.this.n0();
        }
    }

    public AdCoverVideoView(@NonNull Context context) {
        this(context, null);
    }

    private void addCallBack(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void addViewToTarget(View view) {
        if (view == 0) {
            QLog.e(getLogTag(), 1, "addViewToTarget: current video view should not be null.");
            return;
        }
        if (view instanceof ISPlayerVideoView) {
            ((ISPlayerVideoView) view).enableViewCallback();
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
            QLog.d(getLogTag(), 4, "addViewToTarget: remove view group, viewGroup(" + viewGroup.hashCode() + "), currentVideoView:" + view.hashCode());
        }
        addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
        QLog.d(getLogTag(), 4, "addViewToTarget: add view finish, container child count: " + getChildCount() + " | currentVideoView: " + view.hashCode());
    }

    private void cleanOldISPlayer() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.AdCoverVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                View childAt = AdCoverVideoView.this.getChildAt(0);
                if (childAt instanceof ISPlayerVideoView) {
                    AdCoverVideoView.this.removeView(childAt);
                    QLog.d(AdCoverVideoView.this.getLogTag(), 4, "remove old player view");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogTag() {
        if (this.f90292e != null) {
            return "AdCoverVideoView_" + this.f90292e.tag();
        }
        return "AdCoverVideoView";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.AdCoverVideoView.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (AdCoverVideoView.this.q0() == null) {
                    return;
                }
                if (!AdCoverVideoView.this.q0().isReady()) {
                    QLog.w(AdCoverVideoView.this.getLogTag(), 1, "addVideoView: player not ready");
                    return;
                }
                View videoView = AdCoverVideoView.this.q0().getVideoView();
                ViewGroup viewGroup = (ViewGroup) videoView.getParent();
                if (videoView instanceof ISPlayerVideoView) {
                    ((ISPlayerVideoView) videoView).disableViewCallback();
                }
                if (viewGroup != null) {
                    viewGroup.removeView(videoView);
                }
                AdCoverVideoView.this.addViewToTarget(videoView);
                QLog.d(AdCoverVideoView.this.getLogTag(), 4, "addVideoView: player ready");
            }
        });
    }

    private void o0() {
        String str;
        RFWPlayerOptions rFWPlayerOptions = this.f90292e;
        if (rFWPlayerOptions != null && !rFWPlayerOptions.isValid()) {
            QLog.w(getLogTag(), 1, "setVideoPath inValid may be not onScreen");
            return;
        }
        RFWPlayerOptions rFWPlayerOptions2 = this.f90292e;
        if (rFWPlayerOptions2 != null) {
            str = rFWPlayerOptions2.tag();
        } else {
            str = "";
        }
        RFWPlayer f16 = com.tencent.biz.qqcircle.richframework.widget.video.a.c().f(str, this.f90291d, this.f90294h);
        this.f90293f = f16;
        if (f16 == null) {
            QLog.w(getLogTag(), 1, "createNewCoverVideoPlayer error: player is null");
            return;
        }
        f16.setEnablePerfReport(true);
        this.f90293f.loadPlayOptions(this.f90292e);
        this.f90293f.setLoopback(true);
        this.f90293f.setOutputMute(true);
        if (this.f90293f.getRealPlayer() != null) {
            this.f90293f.getRealPlayer().setXYaxis(2);
        }
        QLog.d(getLogTag(), 4, "new player instance");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        this.f90291d = i3;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    public void loadPlayOptions(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            QLog.w(getLogTag(), 1, "startVideo error: empty options");
            return;
        }
        this.f90292e = rFWPlayerOptions;
        addCallBack(rFWPlayerOptions);
        o0();
    }

    public RFWPlayerOptions p0() {
        return this.f90292e;
    }

    public RFWPlayer q0() {
        return this.f90293f;
    }

    public void r0(boolean z16) {
        if (this.f90292e == null) {
            return;
        }
        com.tencent.biz.qqcircle.richframework.widget.video.a.c().o(this.f90291d, this.f90292e.tag(), z16);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        if (q0() != null && this.f90292e != null) {
            com.tencent.biz.qqcircle.richframework.widget.video.a.c().releasePlayer(this.f90292e.tag());
            cleanOldISPlayer();
        }
    }

    public void setAdVideoReportUrl(String str) {
        this.f90294h = str;
    }

    public AdCoverVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
