package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.widget.CoverView;
import java.util.Observer;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CoverVideoView extends CoverView implements CoverView.OnPageChangeListener {
    private MiniAppVideoController videoController;
    private FrameLayout videoLayout;

    public CoverVideoView(Activity activity) {
        super(activity);
        MiniAppVideoController miniAppVideoController = new MiniAppVideoController(activity);
        this.videoController = miniAppVideoController;
        FrameLayout ui5 = miniAppVideoController.getUI();
        this.videoLayout = ui5;
        if (ui5 != null) {
            addView(this.videoLayout, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void fullScreen() {
        if (!this.videoController.isFullScreen()) {
            this.videoController.fullScreen();
        }
    }

    public Observer getVideoPlayerStatusObserver() {
        return this.videoController.getVideoPlayerStatusObserver();
    }

    public void initVideoPlayerSettings(JSONObject jSONObject) {
        this.videoController.initVideoPlayerSettings(jSONObject);
    }

    public boolean isFullScreen() {
        return this.videoController.isFullScreen();
    }

    public boolean isPageBackground() {
        MiniAppVideoController miniAppVideoController = this.videoController;
        if (miniAppVideoController != null) {
            return miniAppVideoController.isPageBackground();
        }
        return false;
    }

    public boolean isPlaying() {
        return this.videoController.isPlaying();
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onAddColorNote() {
        MiniAppVideoController miniAppVideoController = this.videoController;
        if (miniAppVideoController != null) {
            miniAppVideoController.stop();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageBackground() {
        MiniAppVideoController miniAppVideoController = this.videoController;
        if (miniAppVideoController != null) {
            miniAppVideoController.onPageBackground();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageForeground() {
        MiniAppVideoController miniAppVideoController = this.videoController;
        if (miniAppVideoController != null) {
            miniAppVideoController.onPageForeground();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewDestory() {
        MiniAppVideoController miniAppVideoController = this.videoController;
        if (miniAppVideoController != null) {
            miniAppVideoController.release();
        }
    }

    public boolean pauseWithUi() {
        return this.videoController.pauseWithUi();
    }

    public void play() {
        this.videoController.play();
    }

    public void playDanmu(String str, int i3) {
        this.videoController.playDanmu(str, i3);
    }

    public boolean playWithUi() {
        return this.videoController.playWithUi();
    }

    public void release() {
        this.videoController.release();
    }

    public boolean seekTo(int i3) {
        return this.videoController.seekTo(i3);
    }

    public void setData(String str) {
        this.videoController.setData(str);
    }

    public void setJsService(IJsService iJsService) {
        this.videoController.setJsService(iJsService);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setMiniAppContext(IMiniAppContext iMiniAppContext) {
        this.videoController.setMiniAppContext(iMiniAppContext);
    }

    public void setPageWebViewId(int i3) {
        this.videoController.setPageWebViewId(i3);
    }

    public void setVideoPath(String str) {
        this.videoController.setVideoPath(str);
    }

    public void setVideoPlayerId(int i3) {
        this.videoController.setVideoPlayerId(i3);
    }

    public void smallScreen() {
        if (this.videoController.isFullScreen()) {
            this.videoController.smallScreen();
        }
    }

    public void stop() {
        this.videoController.stop();
    }

    public void updateVideoPlayerSettings(JSONObject jSONObject) {
        this.videoController.updateConfig(jSONObject);
        this.videoController.updateVideoPlayerSettings(jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewPause() {
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewResume() {
    }
}
