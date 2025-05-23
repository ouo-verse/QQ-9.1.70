package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CoverLiveView extends CoverView implements CoverView.OnPageChangeListener {
    private boolean isPageBackground;
    private MiniAppLivePlayer livePlayer;

    public CoverLiveView(@NonNull Context context) {
        super(context);
        this.livePlayer = new MiniAppLivePlayer(context);
        addView(this.livePlayer, new FrameLayout.LayoutParams(-1, -1));
    }

    private boolean isWrongParams(ViewGroup.LayoutParams layoutParams) {
        if (!isFullScreen() && this.livePlayer.isFullScreenSize(layoutParams.width, layoutParams.height)) {
            long currentTimeMillis = System.currentTimeMillis() - this.livePlayer.lastSmallScreenTime;
            if (currentTimeMillis < 1000) {
                Log.w(CoverView.TAG, "setLayoutParams: wrong set size " + currentTimeMillis, new Throwable());
                return true;
            }
            return false;
        }
        return false;
    }

    public void initLivePlayerSettings(RequestEvent requestEvent, JSONObject jSONObject) {
        this.livePlayer.initLivePlayerSettings(requestEvent, jSONObject);
    }

    public boolean isFullScreen() {
        return this.livePlayer.isFullScreen();
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageBackground() {
        if (!this.isPageBackground) {
            this.isPageBackground = this.livePlayer.enterBackground();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageForeground() {
        if (this.isPageBackground) {
            this.isPageBackground = !this.livePlayer.enterForeground();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewDestory() {
        this.livePlayer.release();
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewPause() {
        if (!this.isPageBackground) {
            this.isPageBackground = this.livePlayer.enterBackground();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewResume() {
        if (this.isPageBackground) {
            this.isPageBackground = !this.livePlayer.enterForeground();
        }
    }

    public void operateLivePlayer(String str, RequestEvent requestEvent, JSONObject jSONObject) {
        this.livePlayer.operateLivePlayer(str, requestEvent, jSONObject);
    }

    public void release() {
        this.livePlayer.release();
    }

    public void setAtyRef(WeakReference<Activity> weakReference) {
        this.livePlayer.setAtyRef(weakReference);
    }

    public void setBaseRuntime(BaseRuntime baseRuntime) {
        this.livePlayer.baseRuntime = baseRuntime;
    }

    public void setData(String str) {
        this.livePlayer.data = str;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (isWrongParams(layoutParams)) {
            return;
        }
        super.setLayoutParams(layoutParams);
    }

    public void setLivePlayerId(int i3) {
        this.livePlayer.livePlayerId = i3;
    }

    public void setMiniAppContext(IMiniAppContext iMiniAppContext) {
        this.livePlayer.miniAppContextRef = new WeakReference<>(iMiniAppContext);
    }

    public void setPageWebviewId(int i3) {
        this.livePlayer.webviewId = i3;
    }

    public void smallScreen() {
        this.livePlayer.smallScreen();
    }

    public void updateLivePlayerSettings(JSONObject jSONObject) {
        this.livePlayer.updateLivePlayerSetting(jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onAddColorNote() {
    }
}
