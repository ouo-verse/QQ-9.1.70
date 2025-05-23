package com.qzone.publish.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.qzone.common.activities.base.BaseActivityForFragmentV2;
import com.qzone.misc.network.report.ClickReport;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneJumpQBrowserInterface;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

/* loaded from: classes39.dex */
public class QZonePublishMoodTabActivity extends BaseActivityForFragmentV2 implements com.qzone.common.activities.titlebuilder.f, com.tencent.mobileqq.webviewplugin.d, com.tencent.mobileqq.webviewplugin.r, b.e, com.tencent.mobileqq.webviewplugin.n, af, QzoneJumpQBrowserInterface {

    /* renamed from: d0, reason: collision with root package name */
    private TextView f51610d0;

    /* renamed from: e0, reason: collision with root package name */
    private Intent f51611e0;

    /* renamed from: j0, reason: collision with root package name */
    Fragment f51616j0;

    /* renamed from: k0, reason: collision with root package name */
    Fragment f51617k0;

    /* renamed from: l0, reason: collision with root package name */
    String f51618l0;

    /* renamed from: o0, reason: collision with root package name */
    com.qzone.common.activities.titlebuilder.c f51621o0;

    /* renamed from: p0, reason: collision with root package name */
    Fragment f51622p0;

    /* renamed from: q0, reason: collision with root package name */
    SystemBarCompact f51623q0;

    /* renamed from: a0, reason: collision with root package name */
    private int f51607a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private int f51608b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    private com.qzone.publish.ui.controller.a f51609c0 = null;

    /* renamed from: f0, reason: collision with root package name */
    String f51612f0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodLeftTab", "\u8bf4\u8bf4");

    /* renamed from: g0, reason: collision with root package name */
    String f51613g0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodRightTab", "\u79d8\u5bc6");

    /* renamed from: h0, reason: collision with root package name */
    String f51614h0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodRightViewFinish", "\u5b8c\u6210");

    /* renamed from: i0, reason: collision with root package name */
    String f51615i0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodRightViewPublish", "\u53d1\u8868");

    /* renamed from: m0, reason: collision with root package name */
    private View.OnClickListener f51619m0 = new a();

    /* renamed from: n0, reason: collision with root package name */
    private View.OnClickListener f51620n0 = new b();

    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePublishMoodTabActivity.this.f51609c0 != null) {
                QZonePublishMoodTabActivity.this.f51609c0.O4(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePublishMoodTabActivity.this.f51609c0 != null) {
                QZonePublishMoodTabActivity.this.f51609c0.Vf(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements TabHost.OnTabChangeListener {
        c() {
        }

        @Override // android.widget.TabHost.OnTabChangeListener
        public void onTabChanged(String str) {
            if (QZonePublishMoodTabActivity.this.f51609c0 != null) {
                QZonePublishMoodTabActivity.this.f51609c0.x4();
            }
            QZonePublishMoodTabActivity.this.Y2();
            ClickReport.q("438", "6", "7", true);
        }
    }

    private void U2() {
        this.f51621o0.E(this.f51612f0);
        this.f51621o0.F(this.f51613g0);
        this.f51621o0.K(new c());
    }

    private void V2() {
        this.f51611e0 = getIntent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = this.f51617k0;
        if (fragment != null && fragment.isAdded()) {
            beginTransaction.hide(this.f51617k0);
            this.f51617k0.setUserVisibleHint(false);
        }
        if (this.f51616j0 == null) {
            this.f51616j0 = new QZonePublishMoodNewStyleActivity();
        }
        if (this.f51616j0.isAdded()) {
            beginTransaction.show(this.f51616j0);
        } else {
            beginTransaction.add(R.id.ckj, this.f51616j0, "mood");
        }
        com.qzone.publish.ui.controller.a aVar = (com.qzone.publish.ui.controller.a) this.f51616j0;
        this.f51609c0 = aVar;
        aVar.pd(this);
        this.f51622p0 = this.f51616j0;
        this.f51618l0 = "mood";
        beginTransaction.commit();
        this.f51616j0.setUserVisibleHint(true);
        W2(0);
        if (QZLog.isColorLevel()) {
            QZLog.d("publishmood_time_tag" + this.TAG, 2, "switchToMood");
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.d
    public boolean Q() {
        return this.f51609c0.Q();
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    /* renamed from: S2, reason: merged with bridge method [inline-methods] */
    public Share getShare() {
        return this.f51609c0.getShare();
    }

    public View T2() {
        com.qzone.common.activities.titlebuilder.c cVar = this.f51621o0;
        if (cVar == null) {
            return null;
        }
        return cVar.u();
    }

    public void W2(int i3) {
        this.f51621o0.S(i3, this.f51620n0, this.f51619m0);
    }

    @Override // com.qzone.common.activities.base.BaseActivityForFragmentV2
    protected void dispatchOnActivityResult(int i3, int i16, Intent intent) {
        Fragment fragment = this.f51622p0;
        if (fragment != null) {
            fragment.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public String getCurrentUrl() {
        return this.f51609c0.getCurrentUrl();
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public Activity getHostActivity() {
        return this.f51609c0.getHostActivity();
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebView getHostWebView() {
        return this.f51609c0.getHostWebView();
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public Handler getMainHandler() {
        return getHandler();
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public QQProgressDialog getSharePD() {
        Share share = this.f51609c0.getShare();
        if (share != null) {
            return share.getSharePD();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public String getShareUrl() {
        return null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public CustomWebView getWebView() {
        return this.f51609c0.getWebView();
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebViewProvider getWebViewProvider() {
        return this.f51609c0.getHostFragment();
    }

    @Override // com.tencent.mobileqq.webviewplugin.d
    public void gotoSelectPicture(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        this.f51609c0.gotoSelectPicture(webViewPlugin, intent, b16);
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public boolean isActivityResume() {
        return this.f51609c0.isActivityResume();
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean isEnableNightMask() {
        return !QZoneConfigHelper.O0();
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean needMiniAIO() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivityForFragmentV2, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i3;
        super.onCreate(bundle);
        setContentView(R.layout.bq7);
        this.f51610d0 = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        com.qzone.common.activities.titlebuilder.c cVar = new com.qzone.common.activities.titlebuilder.c(this);
        this.f51621o0 = cVar;
        cVar.K3(getIntent());
        int i16 = Build.VERSION.SDK_INT;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            super.getWindow().addFlags(67108864);
        }
        V2();
        this.f51607a0 = this.f51608b0;
        if (bundle != null) {
            QZonePublishMoodBaseActivity.f51439h6 = bundle;
            this.f51618l0 = bundle.getString("currentFragmentTag");
            if (bundle.containsKey("currentTabIndex")) {
                i3 = bundle.getInt("currentTabIndex");
            } else {
                i3 = this.f51608b0;
            }
            this.f51607a0 = i3;
        }
        U2();
        QZonePublishMoodBaseActivity.f51439h6 = null;
        if (this.f51618l0 != null) {
            this.f51622p0 = getSupportFragmentManager().findFragmentByTag(this.f51618l0);
        } else {
            this.f51616j0 = new QZonePublishMoodNewStyleActivity();
            if (i16 >= 24) {
                getSupportFragmentManager().beginTransaction().add(R.id.ckj, this.f51616j0, "mood").commitNow();
            } else {
                getSupportFragmentManager().beginTransaction().add(R.id.ckj, this.f51616j0, "mood").commit();
            }
            this.f51622p0 = this.f51616j0;
            this.f51618l0 = "mood";
        }
        com.qzone.publish.ui.controller.a aVar = (com.qzone.publish.ui.controller.a) this.f51622p0;
        this.f51609c0 = aVar;
        aVar.pd(this);
        this.f51616j0 = getSupportFragmentManager().findFragmentByTag("mood");
        this.f51617k0 = getSupportFragmentManager().findFragmentByTag("secret");
        if (this.f51607a0 == 1) {
            W2(1);
        } else {
            W2(0);
        }
        final String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SECRET_SHUOSHUO, QzoneConfig.SECONDARY_PUBLISH_SECRET_SHUOSHUO_H5_URL, QzoneConfig.DefaultValue.DEFAULT_PUBLISH_SECRET_SHUOSHUO_H5_URL);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodTabActivity.1
            @Override // java.lang.Runnable
            public void run() {
                WebSoService.j().G(config, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f51609c0.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        int color;
        super.onResume();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getActivity().getWindow().addFlags(67108864);
            ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
            if (com.qzone.common.activities.titlebuilder.c.M()) {
                if (this.f51623q0 == null) {
                    SystemBarCompact systemBarCompact = new SystemBarCompact((Activity) this, true, getResources().getColor(R.color.qzone_skin_common_white2black_color));
                    this.f51623q0 = systemBarCompact;
                    this.f51621o0.R(systemBarCompact);
                    SystemBarCompact systemBarCompact2 = this.f51623q0;
                    if (com.tencent.mobileqq.simpleui.b.c()) {
                        color = SimpleUIUtil.getSimpleUiBgColor();
                    } else {
                        color = getResources().getColor(R.color.qzone_skin_common_white2black_color);
                    }
                    systemBarCompact2.setStatusBarColor(color);
                    this.f51623q0.init();
                    return;
                }
                return;
            }
            if (this.f51623q0 == null) {
                SystemBarCompact systemBarCompact3 = new SystemBarCompact((Activity) this, true, getResources().getColor(R.color.a8k));
                this.f51623q0 = systemBarCompact3;
                this.f51621o0.R(systemBarCompact3);
                this.f51623q0.init();
            }
            if (com.tencent.mobileqq.simpleui.b.c()) {
                this.f51623q0.setStatusBarColor(SimpleUIUtil.getSimpleUiBgColor());
                if (ImmersiveUtils.couldSetStatusTextColor()) {
                    ImmersiveUtils.setStatusTextColor(SimpleUIUtil.useDarkResource(), getActivity().getWindow());
                    return;
                } else {
                    this.f51623q0.setStatusBarColor(SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
                    return;
                }
            }
            this.f51623q0.setStatusBarColor(getResources().getColor(R.color.qzone_skin_common_white2black_color));
            if (ImmersiveUtils.couldSetStatusTextColor()) {
                ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNightForQzone(), getActivity().getWindow());
            } else {
                this.f51623q0.setStatusBarColor(SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentFragmentTag", this.f51618l0);
        bundle.putInt("currentTabIndex", this.f51607a0);
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        return this.f51609c0.pluginStartActivityForResult(webViewPlugin, intent, b16);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setShareUrl(String str) {
        return this.f51609c0.setShareUrl(str);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setSummary(String str, String str2, String str3, String str4, Bundle bundle) {
        return this.f51609c0.setSummary(str, str2, str3, str4, bundle);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean shareStructMsgForH5(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return false;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public void showActionSheet() {
        this.f51609c0.showActionSheet();
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
        return this.f51609c0.switchRequestCode(webViewPlugin, b16);
    }

    @Override // com.tencent.mobileqq.webviewplugin.d
    public String v0() {
        return this.f51609c0.v0();
    }

    @Override // com.tencent.mobileqq.webviewplugin.d
    public String w() {
        return this.f51609c0.w();
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public void IOnSetTheme() {
        setTheme(R.style.a6t);
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public ViewGroup Kd() {
        return (ViewGroup) findViewById(R.id.jqh);
    }

    @Override // com.qzone.common.activities.base.BaseActivityForFragmentV2, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            com.qzone.publish.ui.controller.a aVar = this.f51609c0;
            if (aVar == null) {
                return true;
            }
            aVar.onBack();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void destroy() {
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void reset() {
    }
}
