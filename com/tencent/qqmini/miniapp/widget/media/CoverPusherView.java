package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class CoverPusherView extends CoverView implements CoverView.OnPageChangeListener {
    private MiniAppLivePusher livePusher;

    public CoverPusherView(@NonNull IMiniAppContext iMiniAppContext) {
        super(iMiniAppContext.getContext());
        this.livePusher = new MiniAppLivePusher(iMiniAppContext);
        addView(this.livePusher, new FrameLayout.LayoutParams(-1, -1));
    }

    public void initLivePusherSettings(RequestEvent requestEvent, JSONObject jSONObject) {
        this.livePusher.initLivePusherSettings(requestEvent, jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageBackground() {
        QMLog.e(CoverView.TAG, "CoverPusherView onPageBackground");
        this.livePusher.enterBackground();
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageForeground() {
        QMLog.e(CoverView.TAG, "CoverPusherView onPageForeground");
        this.livePusher.enterForeground();
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewDestory() {
        this.livePusher.release();
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewPause() {
        this.livePusher.enterBackground();
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onPageWebViewResume() {
        this.livePusher.enterForeground();
    }

    public void operateLivePusher(String str, RequestEvent requestEvent, JSONObject jSONObject) {
        this.livePusher.operateLivePusher(str, requestEvent, jSONObject);
    }

    public void release() {
        this.livePusher.release();
    }

    public void setAtyRef(WeakReference<Activity> weakReference) {
        this.livePusher.setAtyRef(weakReference);
    }

    public void setData(String str) {
        this.livePusher.data = str;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setLivePusherId(int i3) {
        this.livePusher.livePusherId = i3;
    }

    public void setMiniAppContext(IMiniAppContext iMiniAppContext) {
        this.livePusher.miniAppContextRef = new WeakReference<>(iMiniAppContext);
    }

    public void setPageWebviewId(int i3) {
        this.livePusher.webviewId = i3;
    }

    public void updateLivePusherSettings(JSONObject jSONObject) {
        this.livePusher.updateLivePusherSetting(jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener
    public void onAddColorNote() {
    }
}
