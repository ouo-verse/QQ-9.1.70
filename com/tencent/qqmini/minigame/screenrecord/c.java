package com.tencent.qqmini.minigame.screenrecord;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.qqmini.minigame.ui.ScreenRecordNormalPreview;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IScreenRecord;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private ScreenRecordNormalPreview f346682a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f346683b;

    /* renamed from: c, reason: collision with root package name */
    private IMiniAppContext f346684c;

    /* renamed from: d, reason: collision with root package name */
    private String f346685d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f346686e;

    public c(ViewGroup viewGroup) {
        this.f346683b = viewGroup;
    }

    private ScreenRecordNormalPreview b() {
        return new ScreenRecordNormalPreview(this.f346683b.getContext());
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public void a(IMiniAppContext iMiniAppContext, TritonEngine tritonEngine, IScreenRecord iScreenRecord) {
        this.f346684c = iMiniAppContext;
    }

    public void c() {
        IMiniAppContext iMiniAppContext = this.f346684c;
        if (iMiniAppContext == null || !(iMiniAppContext instanceof BaseRuntime)) {
            return;
        }
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if (miniAppInfo != null) {
            miniAppInfo.recordVideoPath = this.f346685d;
            AppMode appMode = miniAppInfo.appMode;
            appMode.disableAddToMyApp = true;
            appMode.disableAddToMyFavor = true;
        }
        ShareState recordShareState = ((BaseRuntime) this.f346684c).getRecordShareState();
        if (recordShareState != null) {
            recordShareState.launchFrom = 2;
            recordShareState.withShareQQ = true;
            recordShareState.withShareTinyWorld = true;
            recordShareState.save2Local = !this.f346686e;
            recordShareState.showDebug = false;
            recordShareState.showMonitor = false;
            recordShareState.withShareGuild = false;
            recordShareState.withShareWeChatFriend = false;
            recordShareState.withShareWeChatMoment = false;
            recordShareState.withShareQzone = true;
            recordShareState.withShareTicket = false;
            recordShareState.showRestart = false;
            recordShareState.stagingJsonParams = null;
        }
        ShareProxy shareProxy = (ShareProxy) ProxyManager.get(ShareProxy.class);
        if (shareProxy != null) {
            shareProxy.showSharePanel(this.f346684c);
        }
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public boolean e(String str, boolean z16) {
        if (this.f346683b == null) {
            return false;
        }
        this.f346686e = z16;
        this.f346685d = str;
        this.f346682a = b();
        this.f346683b.addView(this.f346682a, new RelativeLayout.LayoutParams(-1, -1));
        this.f346682a.g(str);
        c();
        SDKMiniProgramLpReportDC04239.report4ScreenRecord(this.f346684c.getMiniAppInfo(), "lp_result", "expo", "", "", "");
        return true;
    }

    @Override // com.tencent.qqmini.minigame.screenrecord.b
    public boolean remove() {
        ScreenRecordNormalPreview screenRecordNormalPreview = this.f346682a;
        if (screenRecordNormalPreview != null) {
            screenRecordNormalPreview.e();
            this.f346683b.removeView(this.f346682a);
            this.f346682a = null;
            return true;
        }
        return false;
    }
}
