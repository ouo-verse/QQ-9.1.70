package com.tencent.qqmini.minigame.floatview;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.widget.FloatGameView;
import com.tencent.qqmini.minigame.widget.GameBoxView;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.SharedPreferencesUtil;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import ku3.d;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FloatBoxManager extends com.tencent.qqmini.minigame.floatview.a implements View.OnClickListener, IMiniGameEnv.IMiniGameFloatViewOperator {
    private FloatGameView C;
    private ku3.a D = new ku3.a();
    private d E = null;
    private long F = 0;
    private int G = 0;

    /* renamed from: m, reason: collision with root package name */
    private GameBoxView f346378m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements FloatGameView.c {
        a() {
        }

        @Override // com.tencent.qqmini.minigame.widget.FloatGameView.c
        public void onClose() {
            FloatBoxManager floatBoxManager = FloatBoxManager.this;
            floatBoxManager.f346396d.removeView(floatBoxManager.C);
            FloatBoxManager.this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements AsyncResult {
        b() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            if (QMLog.isColorLevel()) {
                QMLog.i("floatBox.FloatBoxManager", "getGameFloatEnableConfig [onReceiveResult], isSuccess:" + z16 + ",result:" + jSONObject);
            }
            if (z16) {
                FloatBoxManager.this.D(jSONObject.optBoolean("isShowGameBoxFloatEnable"));
            }
        }
    }

    private void A(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("box");
            if (optJSONObject != null) {
                this.D.f413045a = optJSONObject.optBoolean("isDisplay");
                this.D.f413046b = optJSONObject.optString("iconUrl");
                this.D.f413047c = optJSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
                this.D.f413048d = optJSONObject.optString("taskUrl");
                this.D.f413049e = optJSONObject.optString("boxTitle");
                this.D.f413050f = optJSONObject.optString("dialogTitle");
                this.D.f413052h = optJSONObject.optInt("displayDuration", 3);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("redDot");
                if (optJSONObject2 != null) {
                    ku3.b bVar = new ku3.b();
                    bVar.f413053a = optJSONObject2.optBoolean("display");
                    bVar.f413054b = optJSONObject2.optInt("adId");
                    bVar.f413055c = optJSONObject2.optInt("adPosId");
                    bVar.f413056d = optJSONObject2.optString(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO);
                    bVar.f413057e = optJSONObject2.optString("ext");
                    bVar.f413058f = optJSONObject2.optInt("source");
                    this.D.f413051g = bVar;
                }
                this.D.a("floatBox.FloatBoxManager");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("floatGame");
            if (optJSONObject3 != null && optJSONObject3.optBoolean("display")) {
                this.E = new d();
                byte[] decode = Base64.decode(optJSONObject3.optString("appInfo"), 0);
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(decode, 0, decode.length);
                obtain.setDataPosition(0);
                this.E.f413064a = MiniAppInfo.CREATOR.createFromParcel(obtain);
                this.E.f413066c = optJSONObject3.optBoolean("display");
                this.E.f413065b = optJSONObject3.optString(QZoneDTLoginReporter.SCHEMA);
                this.E.f413067d = optJSONObject3.optString("via");
            }
            QMLog.d("floatBox.FloatBoxManager", "[parseFloatBoxInfo] floatGame:" + this.E);
        } catch (Exception e16) {
            QMLog.e("floatBox.FloatBoxManager", "[parseFloatBoxInfo],error!" + e16);
        }
    }

    private void B(@Nullable HashMap<String, String> hashMap) {
        MiniAppInfo miniAppInfo;
        if (hashMap == null) {
            return;
        }
        String str = hashMap.get("appId");
        if (!TextUtils.isEmpty(str) && this.f346378m != null && (miniAppInfo = this.f346400i) != null && str.equals(miniAppInfo.appId)) {
            this.f346378m.A();
        }
    }

    private void C() {
        String str;
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            IMiniAppContext iMiniAppContext = this.f346397e;
            if (iMiniAppContext instanceof GameRuntime) {
                qQCustomizedProxy.showCallOutPopupWindow(((GameRuntime) iMiniAppContext).getPage().getCapsuleButton().getMoreView(), "\u53ef\u5728\u8fd9\u91cc\u518d\u6b21\u5f00\u542f\u201c\u6211\u7684\u6e38\u620f\u201d");
                MiniAppInfo miniAppInfo = this.f346400i;
                if (miniAppInfo == null) {
                    str = "";
                } else {
                    str = miniAppInfo.appId;
                }
                SDKMiniProgramLpReportDC04239.reportAsync(null, "page_view", "em_expo", "minigame_mission_againmygame_entrance", "", str, "");
                SharedPreferencesUtil.getPreference().edit().putLong(u(), System.currentTimeMillis()).apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z16) {
        IMiniAppContext iMiniAppContext = this.f346397e;
        if (iMiniAppContext instanceof GameRuntime) {
            ((GameRuntime) iMiniAppContext).getShareState().isShowGameBoxFloatEnable = z16;
        }
    }

    private void q(Context context) {
        String str;
        String str2;
        if (context == null) {
            return;
        }
        if (!this.D.f413045a) {
            QMLog.i("floatBox.FloatBoxManager", "[attachViewIfAllowed] NOT show float box.");
            return;
        }
        GameBoxView gameBoxView = new GameBoxView(context);
        this.f346378m = gameBoxView;
        gameBoxView.setOnClickListener(this);
        this.f346378m.setData(this.D);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        this.f346396d.addView(this.f346378m, layoutParams);
        this.f346378m.setY(DisplayUtil.dip2px(context, 166.0f));
        MiniAppInfo miniAppInfo = this.f346400i;
        if (miniAppInfo == null) {
            str = "";
        } else {
            str = miniAppInfo.appId;
        }
        String str3 = str;
        if (this.f346378m.C()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        SDKMiniProgramLpReportDC04239.reportAsync(miniAppInfo, "page_view", "em_expo", "minigame_mission_entrance", "", str3, str2);
        this.f346378m.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.floatview.FloatBoxManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (FloatBoxManager.this.f346378m != null) {
                    int x16 = (int) FloatBoxManager.this.f346378m.getX();
                    int width = FloatBoxManager.this.f346378m.getWidth() + x16;
                    QMLog.i("floatBox.FloatBoxManager", "float box init x:" + x16 + ",calculatedWidth:" + width);
                    FloatBoxManager.this.f346378m.setScreenWidth(width);
                }
            }
        }, 500L);
    }

    private void r(Context context) {
        d dVar = this.E;
        if (dVar != null && dVar.f413066c) {
            this.C = new FloatGameView(this.f346396d.getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(55.0f), -2);
            layoutParams.gravity = 5;
            layoutParams.rightMargin = ViewUtils.dpToPx(10.0f);
            this.f346396d.addView(this.C, layoutParams);
            this.C.setY(DisplayUtil.dip2px(this.f346396d.getContext(), 226.0f));
            this.C.e(this.f346400i, this.E, this.f346398f);
            this.C.setOnCloseListener(new a());
        }
    }

    private String u() {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy == null) {
            return "key_last_show_open_guide_time_";
        }
        return "key_last_show_open_guide_time_" + miniAppProxy.getUin();
    }

    private String v(String str, String str2) {
        MiniAppInfo miniAppInfo = this.f346400i;
        if (miniAppInfo != null && miniAppInfo.launchParam != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("gameBoxTitle=");
            sb5.append(str2);
            sb5.append("&appId=");
            sb5.append(this.f346400i.appId);
            sb5.append("&taskType=");
            sb5.append(this.f346400i.launchParam.taskType);
            if (!TextUtils.isEmpty(this.f346400i.launchParam.taskId)) {
                sb5.append("&taskId=");
                sb5.append(this.f346400i.launchParam.taskId);
            }
            if (!TextUtils.isEmpty(this.f346400i.launchParam.taskAppId)) {
                sb5.append("&taskAppId=");
                sb5.append(this.f346400i.launchParam.taskAppId);
            }
            GameBoxView gameBoxView = this.f346378m;
            if (gameBoxView != null && gameBoxView.C()) {
                sb5.append("&&redPointData=");
                sb5.append(this.D.f413051g.a());
            }
            if (QMLog.isDebugEnabled()) {
                QMLog.d("floatBox.FloatBoxManager", "[getUrlWithTaskInfo], " + sb5.toString());
            }
            return com.tencent.qqmini.minigame.plugins.b.b(str, sb5.toString());
        }
        return str;
    }

    private void w(String str) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy == null) {
            return;
        }
        channelProxy.getGameLaunchConfig(str, new AsyncResult() { // from class: com.tencent.qqmini.minigame.floatview.FloatBoxManager.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, final JSONObject jSONObject) {
                if (QMLog.isColorLevel()) {
                    QMLog.i("floatBox.FloatBoxManager", "[onReceiveResult], isSuccess:" + z16 + ",result:" + jSONObject);
                }
                if (!z16) {
                    return;
                }
                QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
                if (qQCustomizedProxy != null) {
                    FloatBoxManager floatBoxManager = FloatBoxManager.this;
                    qQCustomizedProxy.checkShowExpireDialog(floatBoxManager.f346400i, floatBoxManager.f346398f, jSONObject);
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.floatview.FloatBoxManager.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FloatBoxManager.this.b(jSONObject.toString());
                    }
                });
            }
        });
    }

    private void x(String str) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy == null) {
            return;
        }
        channelProxy.getGameFloatEnableConfig(str, new b());
    }

    private boolean y() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.F <= 1000) {
            return true;
        }
        this.F = currentTimeMillis;
        return false;
    }

    private void z(boolean z16) {
        D(true);
        if (z16) {
            if (com.tencent.qqmini.minigame.helper.a.a(SharedPreferencesUtil.getPreference().getLong(u(), 0L), System.currentTimeMillis())) {
                QMLog.i("floatBox.FloatBoxManager", "onRemoveBoxView: showOpenDialog too frequently.");
            } else {
                C();
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv.IMiniGameFloatViewOperator
    public void addFloatView(String str, @Nullable Bundle bundle) {
        ViewGroup viewGroup;
        GameBoxView gameBoxView = this.f346378m;
        if (gameBoxView != null && gameBoxView.getParent() != null) {
            QMLog.i("floatBox.FloatBoxManager", "enableView appId=" + str + ", but game box already exists.");
            return;
        }
        ku3.a aVar = this.D;
        if (aVar != null && (viewGroup = this.f346396d) != null) {
            aVar.f413045a = true;
            q(viewGroup.getContext());
            s(this.D.f413052h * 1000);
            D(false);
        }
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void b(String str) {
        ViewGroup viewGroup;
        if (this.f346400i != null && (viewGroup = this.f346396d) != null) {
            Context context = viewGroup.getContext();
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            A(str);
            r(context);
            q(context);
            HippyPageProxy hippyPageProxy = (HippyPageProxy) ProxyManager.get(HippyPageProxy.class);
            if (hippyPageProxy != null) {
                hippyPageProxy.downloadJSBundle(this.D.f413047c, 2);
            }
            if (this.G == 3) {
                s(this.D.f413052h * 1000);
                return;
            }
            return;
        }
        QMLog.w("floatBox.FloatBoxManager", "rootView:" + this.f346396d + ",mAppInfo:" + this.f346400i);
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void c() {
        QMLog.i("floatBox.FloatBoxManager", "[detachView] remove game box view.");
        if (this.f346396d == null) {
            return;
        }
        GameBoxView gameBoxView = this.f346378m;
        if (gameBoxView != null) {
            gameBoxView.n();
            this.f346396d.removeView(this.f346378m);
            this.f346378m = null;
        }
        FloatGameView floatGameView = this.C;
        if (floatGameView != null) {
            this.f346396d.removeView(floatGameView);
            this.C = null;
        }
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void e(String str) {
        w(str);
        x(str);
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void f() {
        c();
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void g(int i3) {
        super.g(i3);
        QMLog.d("floatBox.FloatBoxManager", "[onLoadingAdStatusChanged] -status:" + i3);
        this.G = i3;
        if (i3 != 3) {
            return;
        }
        s(this.D.f413052h * 1000);
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void k(ViewGroup viewGroup) {
        this.f346396d = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HippyPageProxy hippyPageProxy;
        MiniAppInfo miniAppInfo;
        String str;
        String str2;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f346378m && !y() && (hippyPageProxy = (HippyPageProxy) ProxyManager.get(HippyPageProxy.class)) != null && this.f346397e != null && (miniAppInfo = this.f346400i) != null && miniAppInfo.launchParam != null) {
            ku3.a aVar = this.D;
            String v3 = v(aVar.f413047c, aVar.f413050f);
            HashMap<String, String> hashMap = new HashMap<>();
            if (this.f346378m.C()) {
                hashMap.put("redDot", this.D.f413051g.a());
            }
            hippyPageProxy.openHippyPage(this.f346397e, v3, this.D.f413050f, 2, hashMap);
            MiniAppInfo miniAppInfo2 = this.f346400i;
            if (miniAppInfo2 == null) {
                str = "";
            } else {
                str = miniAppInfo2.appId;
            }
            String str3 = str;
            if (this.f346378m.C()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            SDKMiniProgramLpReportDC04239.reportAsync(miniAppInfo2, "page_view", "em_click", "minigame_mission_entrance", "", str3, str2);
            if (this.D.f413051g.f413058f != 2) {
                this.f346378m.A();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv.IMiniGameFloatViewOperator
    public void removeFloatView(String str, @Nullable Bundle bundle) {
        boolean z16;
        c();
        if (bundle != null) {
            z16 = bundle.getBoolean("isShowOpenGuide");
        } else {
            z16 = false;
        }
        z(z16);
    }

    public void s(int i3) {
        GameBoxView gameBoxView = this.f346378m;
        if (gameBoxView != null) {
            gameBoxView.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.floatview.FloatBoxManager.5
                @Override // java.lang.Runnable
                public void run() {
                    if (FloatBoxManager.this.f346378m != null) {
                        FloatBoxManager.this.f346378m.z();
                    }
                }
            }, i3);
        }
    }

    public ku3.a t() {
        return this.D;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv.IMiniGameFloatViewOperator
    public void updateFloatView(@NonNull String str, @Nullable HashMap<String, String> hashMap) {
        if ("removeGameBoxEntryRedDot".equals(str)) {
            B(hashMap);
        }
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    @Nullable
    public IMiniGameEnv.IMiniGameFloatViewOperator d() {
        return this;
    }
}
