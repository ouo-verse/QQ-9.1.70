package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qwallet.utils.IPayInterceptApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.util.URLUtil;
import com.tencent.widget.FadeIconImageView;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes32.dex */
public class PublicAccountBrowserImpl extends QQBrowserActivity implements IPublicAccountBrowser {
    private static final String BANNER_TIPS = HardCodeUtil.qqStr(R.string.pmk);
    public static final long CONNECT_APPID = 100298324;
    public static final String FULL_TEXT_URL = "http://s.p.qq.com/pub/msg";
    public static final String FULL_TEXT_URL2 = "http://s.p.qq.com/pub/show";
    public static final String HISTORY_MSG_URL = "http://s.p.qq.com/pub/history";
    protected static final int ITEM_COL_PER_ROW = 3;
    protected static final int ITEM_PER_PAGE = 9;
    public static final String KEY_OPEN_ID = "openid";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TOKEN = "token";
    public static final String PUBLIC_JUMP_URL = "http://s.p.qq.com/pub/jump";
    static final String TAG = "PublicAccountBrowser";
    private FadeIconImageView rightSecondButton;
    protected boolean hideLeftView = false;
    public final Pattern ARTICLE_TITLE_PATTERN = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
    public String publicUin = "";
    public String publicUinName = "";
    public int publicUinType = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(PublicAccountBrowserImpl.this.getApplicationContext(), IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", PublicAccountBrowserImpl.this.publicUin);
            activityURIRequest.extra().putString("uinname", PublicAccountBrowserImpl.this.publicUin);
            activityURIRequest.extra().putString("uintype", PublicAccountBrowserImpl.this.publicUinName);
            activityURIRequest.setFlags(67108864);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        }
    }

    public PublicAccountBrowserImpl() {
        this.mFragmentClass = PublicAccountBrowserFragment.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStyleFromUrl(String str) {
        Map<String, String> argumentsFromURL;
        FadeIconImageView fadeIconImageView;
        FadeIconImageView fadeIconImageView2 = this.rightSecondButton;
        if (fadeIconImageView2 != null) {
            fadeIconImageView2.setVisibility(8);
        }
        if (TextUtils.isEmpty(str) || (argumentsFromURL = URLUtil.getArgumentsFromURL(str)) == null || !"1".equals(argumentsFromURL.get("showProfileBtn")) || (fadeIconImageView = this.rightSecondButton) == null) {
            return;
        }
        fadeIconImageView.setImageResource(R.drawable.b4o);
        this.rightSecondButton.setOnClickListener(new a());
        this.rightSecondButton.setContentDescription(super.getText(R.string.dym));
        this.rightSecondButton.setVisibility(0);
    }

    private void initRightButton() {
        if (this.rightSecondButton == null) {
            this.rightSecondButton = (FadeIconImageView) findViewById(R.id.dsr);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("url");
        if (stringExtra != null && stringExtra.contains("iyouxi.vip.qq.com/vipcenter")) {
            super.doOnCreate(bundle);
            VasWebviewUtil.openQQBrowserActivity(this, stringExtra, 16L, intent, false, -1);
            super.finish();
            return false;
        }
        intent.putExtra(QQWinkConstants.WEB_COLOR_NOTE_TYPE, 2);
        super.doOnCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return true;
        }
        this.publicUin = extras.getString(IPublicAccountBrowser.KEY_PUB_UIN);
        this.publicUinType = extras.getInt(IPublicAccountBrowser.KEY_PUB_UIN_TYPE);
        this.publicUinName = extras.getString(IPublicAccountBrowser.KEY_PUB_UIN_NAME);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        xx.b.INSTANCE.h(getIntent().getStringExtra("friend_uin"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        xx.b.INSTANCE.i();
        final String stringExtra = getIntent().getStringExtra("url");
        initRightButton();
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.1
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountBrowserImpl.this.handleStyleFromUrl(stringExtra);
            }
        }, 200L);
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (getIntent().getBooleanExtra(IPublicAccountBrowser.KEY_FINISH_ANIMATION_OUT_TO_BOTTOM, false)) {
            overridePendingTransition(0, R.anim.f154423k);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountBrowser
    public String getPubUin() {
        return getIntent().getExtras().getString(IPublicAccountBrowser.KEY_PUB_UIN);
    }

    public com.tencent.biz.webviewbase.a getWebAIOController() {
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment instanceof PublicAccountBrowserFragment) {
            return ((PublicAccountBrowserFragment) currentWebViewFragment).Ch();
        }
        QLog.e(TAG, 1, "getWebAIOController fragment error");
        return null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TouchWebView touchWebView = (TouchWebView) findViewById(R.id.webview);
        if (touchWebView != null) {
            touchWebView.addScrollChangedListener(new b());
        }
    }

    /* loaded from: classes32.dex */
    public static class PublicAccountBrowserFragment extends WebViewFragment {
        protected Bundle C;
        protected boolean H;
        com.tencent.biz.webviewbase.a K;
        public String P;
        private SoftReference<e> Q;
        protected String D = null;
        private int E = -1;
        protected boolean F = false;
        protected boolean G = true;
        protected boolean I = false;
        protected boolean J = false;
        public int L = 0;
        public String M = "";
        public String N = "";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class b implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f79369d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Uri f79370e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f79371f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f79372h;

            b(Context context, Uri uri, String str, String str2) {
                this.f79369d = context;
                this.f79370e = uri;
                this.f79371f = str;
                this.f79372h = str2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                PublicAccountBrowserFragment.this.Gh(this.f79369d, this.f79370e, this.f79371f);
                PublicAccountBrowserFragment.this.Ah(dialogInterface, true, this.f79372h);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class c implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f79374d;

            c(String str) {
                this.f79374d = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                PublicAccountBrowserFragment.this.Ah(dialogInterface, false, this.f79374d);
            }
        }

        /* loaded from: classes32.dex */
        class d extends com.tencent.mobileqq.webview.swift.proxy.a {
            d(t tVar) {
                super(tVar);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public boolean afterWebViewEngineHandleOverrideUrl(WebView webView, String str) {
                return PublicAccountBrowserFragment.this.yh(webView, str);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public String getUAMark() {
                return "PA";
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                super.onFinalState(bundle);
                PublicAccountBrowserFragment.this.Fh(bundle);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
                super.onReceivedError(webView, i3, str, str2);
                if (i3 == -8) {
                    com.tencent.biz.qrcode.util.h.T(1, R.string.d67);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return PublicAccountBrowserFragment.this.Ih(webView, str, this.webViewKernelCallBack);
            }
        }

        /* loaded from: classes32.dex */
        private class e extends SwiftBrowserShareMenuHandler {
            e() {
            }

            @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler, com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                this.C.dismiss();
                int i3 = actionSheetItem.action;
                if (i3 == 7) {
                    super.onItemClick(actionSheetItem, shareActionSheet);
                    PublicAccountBrowserFragment.this.Hh(i3);
                    return;
                }
                if (i3 == 8) {
                    PublicAccountBrowserFragment.this.Jh(this.J);
                    PublicAccountBrowserFragment.this.Hh(i3);
                    return;
                }
                super.onItemClick(actionSheetItem, shareActionSheet);
                if (i3 != 2 && i3 != 3) {
                    if (i3 != 6 || PublicAccountBrowserFragment.this.getAppRuntime() == null) {
                        return;
                    }
                    ReportController.o(null, "CliOper", "", PublicAccountBrowserFragment.this.getAppRuntime().getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
                    return;
                }
                if (PublicAccountBrowserFragment.this.getAppRuntime() != null) {
                    ReportController.o(null, "CliOper", "", PublicAccountBrowserFragment.this.getAppRuntime().getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler
            public List<ShareActionSheetBuilder.ActionSheetItem>[] q() {
                boolean z16;
                ArrayList<IPublicAccountJavascriptInterface.a> arrayList;
                ArrayList<IPublicAccountJavascriptInterface.a> arrayList2;
                ArrayList arrayList3 = new ArrayList();
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) PublicAccountBrowserFragment.this.mComponentsProvider.a(4);
                IPublicAccountH5AbilityPlugin iPublicAccountH5AbilityPlugin = (IPublicAccountH5AbilityPlugin) QRoute.api(IPublicAccountH5AbilityPlugin.class);
                if (swiftBrowserShareMenuHandler != null && swiftBrowserShareMenuHandler.r() && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_DIANDIAN)) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(34));
                }
                int i3 = 2;
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_QQ) && (this.E & 8) == 0) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_CHANNEL) && ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab() && (this.E & WebViewConstants.WV.HIDE_SHARE_TO_QCHANNEL) == 0) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_QZONE) && (this.E & 16) == 0) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_WX_FRIEND) && (this.E & 16384) == 0) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_WX_FRIEND_LINE) && (this.E & 32768) == 0) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
                }
                if (swiftBrowserShareMenuHandler != null && swiftBrowserShareMenuHandler.t() && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_SINA_WEIBO)) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(12));
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.OPEN_QQ_BROWSER) && (this.E & 512) == 0) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(5));
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.OPEN_SYS_BROWSER) && (this.E & 256) == 0) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(4));
                }
                PackageManager packageManager = BaseApplicationImpl.getApplication().getPackageManager();
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_QIDIAN) && (16 & this.E) == 0) {
                    QidianManager.g(BaseApplicationImpl.getApplication(), arrayList3);
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_QIYEQQ) && (this.E & 32) == 0 && new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity(packageManager) != null) {
                    arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(20));
                }
                ArrayList arrayList4 = new ArrayList();
                if (!this.f314292b0 || (arrayList2 = this.f314294d0) == null) {
                    z16 = false;
                } else {
                    Iterator<IPublicAccountJavascriptInterface.a> it = arrayList2.iterator();
                    z16 = false;
                    while (it.hasNext()) {
                        IPublicAccountJavascriptInterface.a next = it.next();
                        int i16 = next.f79347a;
                        if (i16 == 1) {
                            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(30);
                            if (TextUtils.isEmpty(next.f79348b)) {
                                build.label = BaseApplicationImpl.getApplication().getString(R.string.d5p);
                            } else {
                                build.label = next.f79348b;
                            }
                            build.icon = R.drawable.f161462dm0;
                            build.iconNeedBg = true;
                            build.argus = "";
                            arrayList4.add(build);
                        } else if (i16 != i3) {
                            i3 = 2;
                        } else {
                            ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(31);
                            build2.label = BaseApplicationImpl.getApplication().getString(R.string.d7a);
                            build2.icon = R.drawable.dls;
                            build2.iconNeedBg = true;
                            build2.argus = "";
                            arrayList4.add(build2);
                        }
                        z16 = true;
                        i3 = 2;
                    }
                }
                if (this.f314293c0 && (arrayList = this.f314294d0) != null) {
                    Iterator<IPublicAccountJavascriptInterface.a> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        IPublicAccountJavascriptInterface.a next2 = it5.next();
                        int i17 = next2.f79347a;
                        if (i17 == 1) {
                            ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(37);
                            if (TextUtils.isEmpty(next2.f79348b)) {
                                build3.label = BaseApplicationImpl.getApplication().getString(R.string.d5p);
                            } else {
                                build3.label = next2.f79348b;
                            }
                            build3.icon = R.drawable.f161462dm0;
                            build3.iconNeedBg = true;
                            build3.argus = "";
                            arrayList4.add(build3);
                        } else if (i17 == 3) {
                            ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(35);
                            build4.label = BaseApplicationImpl.getApplication().getString(R.string.dxz);
                            build4.icon = R.drawable.f161463dm1;
                            build4.iconNeedBg = true;
                            build4.argus = "";
                            arrayList4.add(build4);
                        }
                        z16 = true;
                    }
                }
                SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler) PublicAccountBrowserFragment.this.mComponentsProvider.a(64);
                if (swiftBrowserScreenShotHandler != null && swiftBrowserScreenShotHandler.m() && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SCREEN_SHOT_SHARE)) {
                    ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(21);
                    build5.label = BaseApplicationImpl.getApplication().getString(R.string.dyl);
                    build5.iconNeedBg = true;
                    build5.icon = R.drawable.dlz;
                    build5.argus = "";
                    arrayList4.add(build5);
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.FAVORITE) && (this.E & 8192) == 0) {
                    arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.EXPORT_TENCENT_DOCS) && (((v) this.f314441d.getProvider().a(2)).f314512m.f314621d & 16384) == 0) {
                    String shareUrl = getShareUrl();
                    if (shareUrl == null) {
                        shareUrl = ((WebViewFragment) PublicAccountBrowserFragment.this).mUrl;
                    }
                    if (u.n(shareUrl)) {
                        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(68);
                        build6.label = BaseApplicationImpl.getApplication().getString(R.string.iwn);
                        build6.iconNeedBg = true;
                        build6.icon = R.drawable.i0c;
                        build6.argus = "";
                        arrayList4.add(build6);
                        u.q(0, 0);
                    }
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SET_FONT) && this.f314307m) {
                    arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(7));
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.COPY_URL) && (this.E & 32) == 0) {
                    arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
                }
                if (!TextUtils.isEmpty(this.J) && (this.E & 64) == 0 && !z16) {
                    ShareActionSheetBuilder.ActionSheetItem build7 = ShareActionSheetBuilder.ActionSheetItem.build(8);
                    build7.iconNeedBg = true;
                    build7.argus = "";
                    arrayList4.add(build7);
                }
                if (swiftBrowserShareMenuHandler != null && swiftBrowserShareMenuHandler.s()) {
                    ShareActionSheetBuilder.ActionSheetItem build8 = ShareActionSheetBuilder.ActionSheetItem.build(38);
                    build8.label = BaseApplicationImpl.getApplication().getString(R.string.dy5);
                    build8.icon = R.drawable.dlx;
                    build8.iconNeedBg = true;
                    build8.argus = "";
                    arrayList4.add(build8);
                }
                if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.EXPOSE_ARTICLE)) {
                    arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
                }
                return new ArrayList[]{arrayList3, arrayList4};
            }

            public void U() {
                this.f314297f = null;
            }
        }

        public static String Bh(String str) {
            if (str.startsWith("qqnews://")) {
                return "\u5373\u5c06\u79bb\u5f00\"QQ\"\r\n\u6253\u5f00\"\u817e\u8baf\u65b0\u95fb\"";
            }
            if (!str.startsWith("tenvideo://") && !str.startsWith("tenvideo2://") && !str.startsWith("tenvideo3://") && !str.startsWith("tencent1004498506://")) {
                if (str.startsWith("mttbrowser://")) {
                    return "\u5373\u5c06\u79bb\u5f00\"QQ\"\r\n\u6253\u5f00\"QQ\u6d4f\u89c8\u5668\"";
                }
                if (str.startsWith("qnreading://")) {
                    return "\u5373\u5c06\u79bb\u5f00\"QQ\"\r\n\u6253\u5f00\"\u5929\u5929\u5feb\u62a5\"";
                }
                if (!str.startsWith("weishiandroidscheme://") && !str.startsWith("weishi://")) {
                    if (str.startsWith("tnow://")) {
                        return "\u5373\u5c06\u79bb\u5f00\"QQ\"\r\n\u6253\u5f00\"NOW\u76f4\u64ad\"";
                    }
                    if (str.startsWith("sms://") || str.startsWith("tel://") || str.startsWith("tel://") || str.startsWith("mailto://") || str.startsWith("file://") || str.startsWith("ftp://") || str.startsWith("mqqapi://") || str.startsWith("http://") || str.startsWith("https://") || str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) == -1) {
                        return null;
                    }
                    return "\u5373\u5c06\u79bb\u5f00\"QQ\"\r\n\u6253\u5f00" + HardCodeUtil.qqStr(R.string.pmt);
                }
                return "\u5373\u5c06\u79bb\u5f00\"QQ\"\r\n\u6253\u5f00\"\u5fae\u89c6\"";
            }
            return "\u5373\u5c06\u79bb\u5f00\"QQ\"\r\n\u6253\u5f00\"\u817e\u8baf\u89c6\u9891\"";
        }

        private void Dh() {
            String queryParameter;
            Bundle extras = this.intent.getExtras();
            this.C = extras;
            this.D = extras.getString("uin_name");
            this.L = this.C.getInt(IPublicAccountBrowser.KEY_UIN_TYPE);
            this.P = this.intent.getStringExtra("title");
            String string = this.C.getString("openid");
            String string2 = this.C.getString("token");
            String string3 = this.C.getString("url");
            if (string3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.w(WebViewFragment.TAG, 2, "url not found, use \"\" default");
                }
                string3 = "";
            }
            boolean z16 = false;
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 2, "get a url:" + com.tencent.biz.common.util.k.f(string3, new String[0]));
            }
            if (string3.startsWith(IPublicAccountBrowser.GAME_URL)) {
                if (!string3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    string3 = string3 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                }
                string3 = string3 + "&openid=" + string + "&token=" + string2;
                this.intent.putExtra("url", string3);
            }
            Uri parse = Uri.parse(string3);
            if (parse != null && parse.isHierarchical() && (queryParameter = parse.getQueryParameter("_wv")) != null) {
                try {
                    getUIStyle().f314620c = Long.parseLong(queryParameter.trim());
                    getUIStyleHandler().f314512m.f314620c = getUIStyle().f314620c;
                } catch (NumberFormatException unused) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
                    }
                }
            }
            this.E = this.C.getInt(IPublicAccountBrowser.KEY_CALL_FROM);
            this.intent.removeExtra(IPublicAccountBrowser.KEY_CALL_FROM);
            this.M = this.C.getString(IPublicAccountBrowser.KEY_PUB_UIN);
            String string4 = this.C.getString("msg_id");
            this.N = string4;
            if (string4 == null) {
                this.N = "";
            }
            this.G = !this.C.getBoolean("hide_operation_bar");
            this.F = string3.startsWith(PublicAccountBrowserImpl.FULL_TEXT_URL) || string3.startsWith(PublicAccountBrowserImpl.FULL_TEXT_URL2);
            if (!this.C.containsKey("hide_operation_bar")) {
                boolean z17 = !this.F;
                this.G = z17;
                this.intent.putExtra("hide_operation_bar", !z17);
            }
            String string5 = this.C.getString("webStyle");
            if (string5 != null && string5.equals("noBottomBar")) {
                this.G = false;
            }
            String string6 = this.C.getString("disableshare");
            if (this.C.getBoolean(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, false) || (string6 != null && string6.equals("true"))) {
                z16 = true;
            }
            this.H = z16;
            SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) this.mComponentsProvider.a(4);
            if (!this.H && (getUIStyle().f314620c & 140737488364408L) == 140737488364408L && !swiftBrowserShareMenuHandler.k()) {
                this.H = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 1, "initParams url = " + string3);
            }
            this.intent.putExtra("url", string3);
        }

        private void Eh(Bundle bundle) {
            if (getAppRuntime() != null && !NetworkUtil.isNetSupport(getAppRuntime().getApplication())) {
                QQToast.makeText(getAppRuntime().getApplication(), R.string.f171137ci2, 0).show(getWebTitleBarInterface().getTitleBarHeight());
            }
            if (getUIStyleHandler().f314512m.f314618a) {
                return;
            }
            String string = this.C.getString(IPublicAccountBrowser.KEY_BACK_TEXT);
            if (!TextUtils.isEmpty(string)) {
                getSwiftTitleUI().f314054i.setText(string);
            }
            if (!this.H) {
                getSwiftTitleUI().C.setText("");
                getSwiftTitleUI().E.setImageResource(R.drawable.qui_more_icon_navigation_01_selector);
                getSwiftTitleUI().E.setContentDescription(super.getText(R.string.bbp));
            } else {
                getSwiftTitleUI().C.setVisibility(8);
                getSwiftTitleUI().E.setVisibility(8);
                int a16 = (int) al.a(BaseApplicationImpl.getApplication(), 8.0f);
                if (getSwiftTitleUI().P != null) {
                    ((RelativeLayout.LayoutParams) getSwiftTitleUI().P.getLayoutParams()).setMargins(a16, 0, a16, 0);
                }
            }
            if (this.E == 1001) {
                getSwiftTitleUI().f314054i.setVisibility(8);
                getSwiftTitleUI().E.setVisibility(8);
                getSwiftTitleUI().C.setText(HardCodeUtil.qqStr(R.string.plm));
                getSwiftTitleUI().C.setOnClickListener(this);
                getSwiftTitleUI().C.setVisibility(0);
            }
        }

        public void Ah(DialogInterface dialogInterface, boolean z16, String str) {
            dialogInterface.dismiss();
            if (!z16) {
                if (getAppRuntime() != null) {
                    ReportController.o(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, getAppRuntime().getCurrentAccountUin(), "0X80090F3", "0X80090F3", 0, 0, "", "", "", str);
                }
            } else if (getAppRuntime() != null) {
                ReportController.o(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, getAppRuntime().getCurrentAccountUin(), "0X80090F4", "0X80090F4", 0, 0, "", "", "", str);
            }
        }

        public com.tencent.biz.webviewbase.a Ch() {
            if (this.K == null) {
                a.d dVar = new a.d(getWebTitleBarInterface().getTitleBarView());
                boolean booleanExtra = this.intent.getBooleanExtra(IPublicAccountBrowser.KEY_MSG_SWITCH_BTN, false);
                Bundle bundle = new Bundle();
                bundle.putBoolean("enable_switch", booleanExtra);
                bundle.putString("banner_txt", String.format(PublicAccountBrowserImpl.BANNER_TIPS, this.P, ""));
                bundle.putInt("banner_icon_res", R.drawable.d6f);
                this.K = dVar.b(bundle).a();
            }
            return this.K;
        }

        public void Fh(Bundle bundle) {
            if (this.intent.getIntExtra("reqType", -1) == 5 && !getUIStyleHandler().f314512m.f314618a) {
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int id5 = view.getId();
                        if (id5 == R.id.ivTitleBtnLeft) {
                            if (!PublicAccountBrowserFragment.this.getUIStyleHandler().f314512m.f314618a) {
                                String charSequence = PublicAccountBrowserFragment.this.getSwiftTitleUI().f314054i.getText().toString();
                                if (!charSequence.equals(((WebViewFragment) PublicAccountBrowserFragment.this).intent.getStringExtra(AppConstants.LeftViewText.LEFTVIEWTEXT))) {
                                    ((WebViewFragment) PublicAccountBrowserFragment.this).webView.loadUrl("javascript:onLeftBtn(\"" + charSequence + "\")");
                                    return;
                                }
                                PublicAccountBrowserFragment.this.doOnBackEvent();
                                return;
                            }
                            onClick(view);
                            return;
                        }
                        if (id5 != R.id.ivTitleBtnRightText) {
                            onClick(view);
                            return;
                        }
                        if (PublicAccountBrowserFragment.this.getUIStyleHandler().f314512m.f314618a) {
                            if (PublicAccountBrowserFragment.this.E == 1001) {
                                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            boolean w3 = SubscriptRecommendController.w((AppInterface) PublicAccountBrowserFragment.this.getAppRuntime(), false, ((WebViewFragment) PublicAccountBrowserFragment.this).mUrl);
                                            if (QLog.isColorLevel()) {
                                                QLog.d(WebViewFragment.TAG, 2, "set subscribe full recommend switch = false , result : " + w3);
                                            }
                                        } catch (Exception e16) {
                                            e16.printStackTrace();
                                        }
                                    }
                                });
                                PublicAccountBrowserFragment.this.getActivity().finish();
                                return;
                            } else {
                                onClick(view);
                                return;
                            }
                        }
                        String charSequence2 = PublicAccountBrowserFragment.this.getSwiftTitleUI().C.getText().toString();
                        ((WebViewFragment) PublicAccountBrowserFragment.this).webView.loadUrl("javascript:onRightBtn(\"" + charSequence2 + "\")");
                    }
                };
                getSwiftTitleUI().f314054i.setOnClickListener(onClickListener);
                getSwiftTitleUI().C.setText(R.string.awi);
                getSwiftTitleUI().C.setOnClickListener(onClickListener);
            }
            Eh(bundle);
        }

        void Gh(Context context, Uri uri, String str) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, uri);
            intent.addFlags(268435456);
            try {
                ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(getActivity().getPackageManager(), 0);
                String str2 = "";
                if (resolveActivityInfo != null) {
                    str2 = resolveActivityInfo.packageName;
                }
                StartAppCheckHandler.I2(ZPlanPublishSource.FROM_SCHEME, str, str2, "1", "web", getActivity().getClass().getName());
                context.startActivity(intent);
            } catch (Exception e16) {
                QLog.e(WebViewFragment.TAG, 1, "afterWebViewEngineHandleOverrideUrl error!", e16);
            }
        }

        public boolean Ih(WebView webView, String str, t tVar) {
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://")) {
                return tVar.shouldOverrideUrlLoading(webView, str);
            }
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 2, "shouldOverride: " + com.tencent.biz.common.util.k.f(str, new String[0]));
            }
            String url = webView.getUrl();
            boolean z16 = TextUtils.isEmpty(url) || url.startsWith(PublicAccountBrowserImpl.PUBLIC_JUMP_URL);
            if (!this.G && this.F && !z16) {
                if (!this.I) {
                    Intent intent = new Intent(super.getActivity(), (Class<?>) PublicAccountBrowserImpl.class);
                    if (getAppRuntime() != null) {
                        intent.putExtra("uin", getAppRuntime().getCurrentAccountUin());
                    }
                    intent.putExtra("url", str);
                    super.startActivity(intent);
                    return true;
                }
                return tVar.shouldOverrideUrlLoading(webView, str);
            }
            this.J = false;
            if (!TextUtils.isEmpty(url) && url.startsWith("https://www.urlshare.cn/")) {
                FragmentActivity activity = getActivity();
                if (activity instanceof PublicAccountBrowserImpl) {
                    ((PublicAccountBrowserImpl) activity).handleStyleFromUrl(str);
                }
            }
            return tVar.shouldOverrideUrlLoading(webView, str);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public void activityFinish() {
            super.activityFinish();
            if (this.E == 1001) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            boolean w3 = SubscriptRecommendController.w((AppInterface) PublicAccountBrowserFragment.this.getAppRuntime(), false, ((WebViewFragment) PublicAccountBrowserFragment.this).mUrl);
                            if (QLog.isColorLevel()) {
                                QLog.d(WebViewFragment.TAG, 2, "set subscribe full recommend switch = false , result : " + w3);
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
            return new com.tencent.mobileqq.webview.swift.component.b(this, 1023, new a());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public boolean doOnCreate(Bundle bundle) {
            Dh();
            return super.doOnCreate(bundle);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public t getWebViewKernelCallBack() {
            return new d(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        public void onDestroy() {
            e eVar;
            super.onDestroy();
            SoftReference<e> softReference = this.Q;
            if (softReference == null || (eVar = softReference.get()) == null) {
                return;
            }
            eVar.U();
            this.Q.clear();
        }

        public boolean yh(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            long currentTimeMillis = System.currentTimeMillis();
            boolean tryIntercept = ((IPayInterceptApi) QRoute.api(IPayInterceptApi.class)).tryIntercept(str, this);
            QLog.i(WebViewFragment.TAG, 1, "TryPayIntercept result:" + tryIntercept + " cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
            if (tryIntercept) {
                return true;
            }
            if ("2909288299".equalsIgnoreCase(this.M)) {
                String Bh = Bh(str);
                if (!TextUtils.isEmpty(Bh)) {
                    zh(getActivity(), webView.getUrl(), parse, "QQ", Bh, this.M);
                    return true;
                }
            }
            Gh(getActivity(), parse, webView.getUrl());
            return true;
        }

        void Jh(String str) {
            if (str == null) {
                str = this.M;
            }
            if (str != null) {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(super.getActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
                activityURIRequest.extra().putString("uin", str);
                activityURIRequest.extra().putInt("source", 111);
                QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            }
        }

        /* loaded from: classes32.dex */
        class a implements b.d {
            a() {
            }

            @Override // com.tencent.mobileqq.webview.swift.component.b.d
            public Object a(int i3) {
                e eVar;
                if (i3 != 4) {
                    return null;
                }
                if (PublicAccountBrowserFragment.this.Q != null && (eVar = (e) PublicAccountBrowserFragment.this.Q.get()) != null) {
                    eVar.U();
                    PublicAccountBrowserFragment.this.Q.clear();
                }
                PublicAccountBrowserFragment.this.Q = new SoftReference(new e());
                return PublicAccountBrowserFragment.this.Q.get();
            }
        }

        public void Hh(int i3) {
            String str;
            String shareUrl = getShareUrl();
            if (shareUrl == null) {
                shareUrl = this.mUrl;
            }
            String str2 = shareUrl;
            if (TextUtils.isEmpty(this.M)) {
                return;
            }
            try {
                str = Uri.parse(str2).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
            } catch (Exception e16) {
                e16.printStackTrace();
                str = "";
            }
            String str3 = str == null ? "" : str;
            if (i3 == 7) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800572A", "0X800572A", 1010, 0, this.M, str2, this.N, str3, false);
            } else {
                if (i3 != 8) {
                    return;
                }
                ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str3, str2, "1009", "");
            }
        }

        public void zh(Context context, String str, Uri uri, String str2, String str3, String str4) {
            try {
                try {
                    QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(context, 230, null, str3, HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.pm7), new b(context, uri, str, str4), new c(str4));
                    createCenterTextDialog.show();
                    createCenterTextDialog.setCancelable(false);
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
    }

    /* loaded from: classes32.dex */
    class b implements TouchWebView.OnScrollChangedListener {
        b() {
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        }
    }
}
