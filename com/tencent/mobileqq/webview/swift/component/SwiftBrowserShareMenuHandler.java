package com.tencent.mobileqq.webview.swift.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.TextUtils;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.an;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.widget.RangeButtonView;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserShareMenuHandler extends b.C8976b implements ShareActionSheet.OnItemClickListener, RangeButtonView.OnChangeListener, DialogInterface.OnDismissListener, com.tencent.mobileqq.webviewplugin.o, com.tencent.mobileqq.webview.swift.y {
    static IPatchRedirector $redirector_;

    /* renamed from: m0, reason: collision with root package name */
    public static final int[] f314289m0;

    /* renamed from: n0, reason: collision with root package name */
    public static long f314290n0;
    public ShareActionSheetBuilder C;
    public final ArrayList<String> D;
    public long E;
    public boolean F;
    public boolean G;
    private String H;
    public int I;
    public String J;
    public String K;
    public String L;
    public String M;
    private int N;
    private int P;
    public String Q;
    public String R;
    public String S;
    com.tencent.biz.troop.b T;
    boolean U;
    public int V;
    private int W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f314291a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f314292b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f314293c0;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList<IPublicAccountJavascriptInterface.a> f314294d0;

    /* renamed from: e, reason: collision with root package name */
    private int f314295e;

    /* renamed from: e0, reason: collision with root package name */
    private e f314296e0;

    /* renamed from: f, reason: collision with root package name */
    public Activity f314297f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f314298f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f314299g0;

    /* renamed from: h, reason: collision with root package name */
    public WebViewFragment f314300h;

    /* renamed from: h0, reason: collision with root package name */
    protected Bundle f314301h0;

    /* renamed from: i, reason: collision with root package name */
    public Share f314302i;

    /* renamed from: i0, reason: collision with root package name */
    public String f314303i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f314304j0;

    /* renamed from: k0, reason: collision with root package name */
    private long f314305k0;

    /* renamed from: l0, reason: collision with root package name */
    private long f314306l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f314307m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f314308d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f314309e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f314310f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f314311h;

        AnonymousClass1(String str, String str2, String str3, String str4) {
            this.f314308d = str;
            this.f314309e = str2;
            this.f314310f = str3;
            this.f314311h = str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SwiftBrowserShareMenuHandler.this, str, str2, str3, str4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, String str2, String str3, String str4, int i3, Object obj) {
            String str5;
            boolean z16;
            com.tencent.mobileqq.teamwork.o y16 = SwiftBrowserShareMenuHandler.this.f314302i.y();
            if (obj instanceof String) {
                str5 = (String) obj;
            } else {
                str5 = null;
            }
            y16.f292311q = str5;
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            SwiftBrowserShareMenuHandler.this.L(str, str2, str3, str4);
            if (z16) {
                WebViewFragment webViewFragment = SwiftBrowserShareMenuHandler.this.f314300h;
                if (webViewFragment instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) {
                    ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) webViewFragment).Zh(i3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(final String str, final String str2, final String str3, final String str4, final int i3, Object obj) {
            if (!((Boolean) obj).booleanValue()) {
                SwiftBrowserShareMenuHandler.this.L(str, str2, str3, str4);
            } else {
                TeamWorkHandlerUtils.m(SwiftBrowserShareMenuHandler.this.f314300h.getAppRuntime().getCurrentAccountUin(), SwiftBrowserShareMenuHandler.this.f314302i.y(), new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.webview.swift.component.i
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj2) {
                        SwiftBrowserShareMenuHandler.AnonymousClass1.this.d(str, str2, str3, str4, i3, obj2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, String str2, String str3, String str4, int i3, Object obj) {
            String str5;
            boolean z16;
            com.tencent.mobileqq.teamwork.o y16 = SwiftBrowserShareMenuHandler.this.f314302i.y();
            if (obj instanceof String) {
                str5 = (String) obj;
            } else {
                str5 = null;
            }
            y16.f292311q = str5;
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            SwiftBrowserShareMenuHandler.this.L(str, str2, str3, str4);
            if (z16) {
                WebViewFragment webViewFragment = SwiftBrowserShareMenuHandler.this.f314300h;
                if (webViewFragment instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) {
                    ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) webViewFragment).Zh(i3);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            final int i3 = SwiftBrowserShareMenuHandler.this.f314302i.y().f292297c;
            if (SwiftBrowserShareMenuHandler.this.f314302i.y().f292297c == 0) {
                String currentAccountUin = SwiftBrowserShareMenuHandler.this.f314300h.getAppRuntime().getCurrentAccountUin();
                String str = SwiftBrowserShareMenuHandler.this.f314302i.y().f292308n;
                String str2 = SwiftBrowserShareMenuHandler.this.f314302i.y().f292307m;
                final String str3 = this.f314308d;
                final String str4 = this.f314309e;
                final String str5 = this.f314310f;
                final String str6 = this.f314311h;
                TeamWorkHandlerUtils.q(currentAccountUin, str, str2, 1, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.webview.swift.component.g
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        SwiftBrowserShareMenuHandler.AnonymousClass1.this.e(str3, str4, str5, str6, i3, obj);
                    }
                });
                return;
            }
            String currentAccountUin2 = SwiftBrowserShareMenuHandler.this.f314300h.getAppRuntime().getCurrentAccountUin();
            com.tencent.mobileqq.teamwork.o y16 = SwiftBrowserShareMenuHandler.this.f314302i.y();
            final String str7 = this.f314308d;
            final String str8 = this.f314309e;
            final String str9 = this.f314310f;
            final String str10 = this.f314311h;
            TeamWorkHandlerUtils.m(currentAccountUin2, y16, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.webview.swift.component.h
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    SwiftBrowserShareMenuHandler.AnonymousClass1.this.f(str7, str8, str9, str10, i3, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ITroopMemberApiClientApi.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserShareMenuHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            if (bundle.getInt("type") == com.tencent.mobileqq.troop.troopapps.api.b.f299364f) {
                Boolean valueOf = Boolean.valueOf(bundle.getBoolean("isSuccess"));
                if (SwiftBrowserShareMenuHandler.this.f314297f.isFinishing() && SwiftBrowserShareMenuHandler.this.f314300h.isDestroyed()) {
                    return;
                }
                if (valueOf.booleanValue()) {
                    QQToast.makeText(BaseApplicationImpl.getApplication(), 2, R.string.f173224i53, 0).show(SwiftBrowserShareMenuHandler.this.f314300h.getWebTitleBarInterface().getTitleBarHeight());
                } else {
                    QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.f173221i50, 0).show(SwiftBrowserShareMenuHandler.this.f314300h.getWebTitleBarInterface().getTitleBarHeight());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements ScreenShotUtil.e<String> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserShareMenuHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        public void b(Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) exc);
                return;
            }
            QLog.e("SwiftBrowserShareMenuHandler", 1, "onScreenShotError , error is " + exc.getMessage());
            if (SwiftBrowserShareMenuHandler.this.f314441d.getActivity() == null) {
                QLog.e("SwiftBrowserShareMenuHandler", 1, "screen long shot onScreenShotError, activity is null");
            } else {
                QQToast.makeText(SwiftBrowserShareMenuHandler.this.f314441d.getActivity(), R.string.vxv, 0).show();
            }
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String c(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
            }
            String str = ScreenShotUtil.b() + System.currentTimeMillis() + ".jpg";
            z81.b.a(bitmap, str, Bitmap.CompressFormat.JPEG, 100, true);
            return str;
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bitmap);
                return;
            }
            if (SwiftBrowserShareMenuHandler.this.f314441d.getActivity() == null) {
                QLog.e("SwiftBrowserShareMenuHandler", 1, "screen long shot error, activity is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("screen_path", str);
            intent.putExtra("is_web_screen_long_shot", true);
            PublicFragmentActivity.b.a(SwiftBrowserShareMenuHandler.this.f314441d.getActivity(), intent, PublicTransFragmentActivity.class, ScreenShotFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f314318d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f314319e;

        c(int i3, String str) {
            this.f314318d = i3;
            this.f314319e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SwiftBrowserShareMenuHandler.this, Integer.valueOf(i3), str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SwiftBrowserShareMenuHandler.this.o(this.f314318d, this.f314319e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements ITroopMemberApiClientApi.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserShareMenuHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            int i3 = bundle.getInt("fontSize", 1);
            QLog.d("SwiftBrowserShareMenuHandler", 2, "adjustFontSize curFontSizeIndex=", Integer.valueOf(SwiftBrowserShareMenuHandler.this.V), " globalFontSizeIndex=", Integer.valueOf(i3));
            SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = SwiftBrowserShareMenuHandler.this;
            if (i3 != swiftBrowserShareMenuHandler.V) {
                swiftBrowserShareMenuHandler.V = i3;
                swiftBrowserShareMenuHandler.j(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        void a(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            f314289m0 = new int[]{95, 100, 107, 115, 127};
            f314290n0 = -1L;
        }
    }

    public SwiftBrowserShareMenuHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = new ArrayList<>();
        this.E = 4L;
        this.F = true;
        this.G = false;
        this.I = 0;
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.T = null;
        this.U = false;
        this.V = 1;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f314291a0 = false;
        this.f314292b0 = false;
        this.f314293c0 = false;
        this.f314294d0 = null;
        this.f314296e0 = null;
        this.f314298f0 = true;
        this.f314299g0 = true;
        this.f314303i0 = "general_url";
        this.f314304j0 = false;
        this.f314305k0 = -1L;
        this.f314306l0 = -1L;
    }

    private boolean A(String str) {
        if (this.f314300h == null) {
            if (this.f314441d.getWebView() != null) {
                SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) this.f314441d.getProvider().a(-2);
                if (!TextUtils.isEmpty(this.f314441d.getWebView().getUrl()) && swiftBrowserStatistics != null) {
                    String url = this.f314441d.getWebView().getUrl();
                    if (!TextUtils.isEmpty(swiftBrowserStatistics.A0) && (swiftBrowserStatistics.A0.equals(url) || swiftBrowserStatistics.A0.equals(str))) {
                        return true;
                    }
                }
            } else {
                throw new InvalidParameterException("ACTION_REFRESH_FREIEND_VIEW should be handled by QQBrowserActivity!");
            }
        } else {
            SwiftBrowserStatistics swiftBrowserStatistics2 = (SwiftBrowserStatistics) this.f314441d.getProvider().a(-2);
            if (!TextUtils.isEmpty(this.f314300h.getWebView().getUrl()) && swiftBrowserStatistics2 != null) {
                String url2 = this.f314300h.getWebView().getUrl();
                if (!TextUtils.isEmpty(swiftBrowserStatistics2.A0) && (swiftBrowserStatistics2.A0.equals(url2) || swiftBrowserStatistics2.A0.equals(str))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void B() {
        if (z(this.f314302i.getShareUrl())) {
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "is not need load share js..");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserShareMenuHandler", 2, "loadShareJs");
        }
        J(System.currentTimeMillis());
        int intValue = WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
        if (intValue < 0) {
            intValue = 190;
        }
        String format = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", Integer.valueOf(intValue), Integer.valueOf(intValue));
        if (this.f314441d.getWebView() != null) {
            this.f314441d.getWebView().loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + format + ";");
        }
    }

    private void C(int i3, String str) {
        DialogUtil.createNoTitleDialog(this.f314297f, x(i3), R.string.auh, R.string.igh, new DialogInterface.OnClickListener(i3, str) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f314312d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f314313e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler$4$1, reason: invalid class name */
            /* loaded from: classes20.dex */
            public class AnonymousClass1 implements Runnable {
                static IPatchRedirector $redirector_;

                AnonymousClass1() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void c(int i3, Object obj) {
                    SwiftBrowserShareMenuHandler.this.f314302i.j(2, i3, 3, ((Boolean) obj).booleanValue());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void d(final int i3, final Object obj) {
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            SwiftBrowserShareMenuHandler.AnonymousClass4.AnonymousClass1.this.c(i3, obj);
                        }
                    }, 3000L);
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        final int i3 = SwiftBrowserShareMenuHandler.this.f314302i.y().f292297c;
                        TeamWorkHandlerUtils.q(SwiftBrowserShareMenuHandler.this.f314300h.getAppRuntime().getCurrentAccountUin(), SwiftBrowserShareMenuHandler.this.f314302i.y().f292308n, SwiftBrowserShareMenuHandler.this.f314302i.y().f292307m, 2, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.webview.swift.component.j
                            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                            public final void a(Object obj) {
                                SwiftBrowserShareMenuHandler.AnonymousClass4.AnonymousClass1.this.d(i3, obj);
                            }
                        });
                    }
                }
            }

            {
                this.f314312d = i3;
                this.f314313e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SwiftBrowserShareMenuHandler.this, Integer.valueOf(i3), str);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                } else {
                    ThreadManagerV2.excute(new AnonymousClass1(), 128, null, false);
                    SwiftBrowserShareMenuHandler.this.o(this.f314312d, this.f314313e);
                }
            }
        }, new c(i3, str)).show();
    }

    private void K(String str) {
        if (!TextUtils.isEmpty(this.f314302i.f97463p0)) {
            this.f314302i.R(str, 2, true);
        } else if (!TextUtils.isEmpty(this.f314302i.f97467t0)) {
            this.f314302i.V();
        } else {
            if (this.f314302i.f97464q0 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 1);
                } catch (JSONException unused) {
                }
                DoraemonUtil.f(this.f314302i.f97464q0, jSONObject);
            }
            this.f314302i.f0();
        }
        ReportCenter.f().p("", "", "", "1000", "102", "0", false);
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(this.f314302i.f97463p0)) {
            this.f314302i.R(str, 3, false);
        } else if (!TextUtils.isEmpty(this.f314302i.f97468u0)) {
            this.f314302i.W();
        } else {
            if (this.f314302i.f97464q0 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 2);
                } catch (JSONException unused) {
                }
                DoraemonUtil.f(this.f314302i.f97464q0, jSONObject);
            }
            this.f314302i.E(str, 3, true);
        }
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
        if (str2 != null && !"".equals(str2)) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B07", "0X8005B07", 1003, 0, str2, str4, str3, ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(str3), false);
        }
        ReportCenter.f().p("", "", "", "1000", "103", "0", false);
    }

    private void M(String str) {
        if (!TextUtils.isEmpty(this.f314302i.f97463p0)) {
            this.f314302i.R(str, 4, false);
        } else if (!TextUtils.isEmpty(this.f314302i.f97469v0)) {
            this.f314302i.X();
        } else {
            if (this.f314302i.f97464q0 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 3);
                } catch (JSONException unused) {
                }
                DoraemonUtil.f(this.f314302i.f97464q0, jSONObject);
            }
            this.f314302i.E(str, 4, true);
        }
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
        ReportCenter.f().p("", "", "", "1000", "104", "0", false);
    }

    private void N(String str) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(this.f314302i.f97463p0)) {
            this.f314302i.R(str, 8, false);
        } else {
            this.f314302i.E(str, 8, false);
        }
        String str4 = this.H;
        if (this.f314441d.getWebView() != null) {
            str4 = this.f314441d.getWebView().getUrl();
        }
        try {
            str2 = Uri.parse(str4).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = "";
        }
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2;
        }
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800787A", "0X800787A", 0, 0, str3, str4, "", "");
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, str4, this.W);
    }

    private void R(String str, String str2, String str3) {
        Share share = this.f314302i;
        if (share == null) {
            return;
        }
        share.f97472y0 = A(str);
        P(str, str2, str3, 11);
    }

    private void l(String str) {
        ((ClipboardManager) this.f314297f.getSystemService("clipboard")).setText(str);
        com.tencent.biz.qrcode.util.h.T(2, R.string.aev);
        if (this.Z && !TextUtils.isEmpty(this.f314302i.f97463p0)) {
            this.f314302i.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i3, String str) {
        if (i3 == 1) {
            l(str);
            return;
        }
        if (i3 == 3) {
            K(str);
        } else if (i3 == 10) {
            M(str);
        } else if (i3 == 12) {
            N(str);
        }
    }

    private Intent v() {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1001);
        intent.putExtra("pluginName", "web_share");
        return intent;
    }

    private String x(int i3) {
        if (i3 == 1) {
            WebViewFragment webViewFragment = this.f314300h;
            return webViewFragment.getString(R.string.hyf, webViewFragment.getString(R.string.aes));
        }
        if (i3 == 3) {
            WebViewFragment webViewFragment2 = this.f314300h;
            return webViewFragment2.getString(R.string.hyf, webViewFragment2.getString(R.string.hji));
        }
        if (i3 == 10) {
            WebViewFragment webViewFragment3 = this.f314300h;
            return webViewFragment3.getString(R.string.hyf, webViewFragment3.getString(R.string.hjd));
        }
        if (i3 == 12) {
            WebViewFragment webViewFragment4 = this.f314300h;
            return webViewFragment4.getString(R.string.hyf, webViewFragment4.getString(R.string.dye));
        }
        WebViewFragment webViewFragment5 = this.f314300h;
        return webViewFragment5.getString(R.string.hyf, webViewFragment5.getString(R.string.ia8));
    }

    private void y() {
        Intent intent = this.f314297f.getIntent();
        WebViewFragment webViewFragment = this.f314300h;
        if (webViewFragment != null) {
            intent = webViewFragment.getIntent();
        }
        String stringExtra = intent.getStringExtra("url");
        this.H = stringExtra;
        if (stringExtra == null) {
            String stringExtra2 = intent.getStringExtra("key_params_qq");
            this.H = stringExtra2;
            if (stringExtra2 == null) {
                this.H = "";
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.I = extras.getInt(IPublicAccountBrowser.KEY_UIN_TYPE);
            this.J = extras.getString(IPublicAccountBrowser.KEY_PUB_UIN);
            String string = extras.getString("msg_id");
            this.K = string;
            if (string == null) {
                this.K = "";
            }
            String string2 = extras.getString("source_puin");
            this.L = string2;
            if (string2 == null) {
                this.L = "";
            }
            String string3 = extras.getString("friendUin");
            this.M = string3;
            if (string3 == null) {
                this.M = "";
            }
            this.N = extras.getInt("appid");
            this.P = extras.getInt(QQBrowserActivity.TROOP_ID);
            boolean z16 = extras.getBoolean(QQBrowserActivity.KEY_FROM_FAV);
            this.f314304j0 = z16;
            if (z16) {
                this.f314305k0 = extras.getLong(QQBrowserActivity.KEY_FAV_ID);
                this.f314306l0 = extras.getLong(QQBrowserActivity.KEY_FAV_GROUP_ID);
            }
            this.W = extras.getInt("articalChannelId", 100);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.o
    public String A4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.L;
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (k()) {
            com.tencent.biz.troop.b bVar = this.T;
            if (bVar != null) {
                bVar.l0(this.f314295e);
            }
            this.f314295e = p().w(new d());
            return;
        }
        j(1);
    }

    public void E(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.H = str;
        }
    }

    public void F(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.Y = z16;
        }
    }

    public void G(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
        } else {
            this.f314291a0 = z16;
        }
    }

    public void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.Z = z16;
        }
    }

    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.X = z16;
        }
    }

    public void J(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            ((SwiftBrowserStatistics) this.f314441d.getProvider().a(-2)).f314356e = j3;
        }
    }

    public void O(int i3) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        String shareUrl = getShareUrl();
        if (shareUrl == null) {
            shareUrl = this.H;
        }
        String str3 = shareUrl;
        Uri parse = Uri.parse(str3);
        if (!PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE.equalsIgnoreCase(parse.getHost()) && !PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(parse.getHost())) {
            return;
        }
        try {
            str = parse.getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i3 != 21) {
            switch (i3) {
                case 1:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, HippyQQConstants.HIPPY_BID, "");
                    return;
                case 2:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, "1001", "");
                    return;
                case 3:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, "1002", "");
                    return;
                case 4:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR, "");
                    return;
                case 5:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR, "");
                    return;
                case 6:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, PluginJumpManager.CONFIG_BID, "");
                    return;
                case 7:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, "1010", "");
                    return;
                case 8:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, "1009", "");
                    return;
                case 9:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, "1003", "");
                    return;
                case 10:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, "");
                    return;
                case 11:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, AppConstants.GRAY_TIP_BUSI_ID, "");
                    return;
                case 12:
                    ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, "1012", "");
                    return;
                default:
                    return;
            }
        }
        ReportController.n(null, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X8007C04", "0X8007C04", 0, 1, 0, str2, str3, "1013", "");
    }

    public void P(String str, String str2, String str3, int i3) {
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, str3, Integer.valueOf(i3));
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str4 = str3;
        } else {
            str4 = str2;
        }
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, str4, this.W);
        this.f314302i.e0(i3);
        if (!TextUtils.isEmpty(this.f314302i.f97463p0)) {
            this.f314302i.R(str, i3, true);
        } else if (!TextUtils.isEmpty(this.f314302i.f97465r0)) {
            this.f314302i.T();
        } else {
            if (this.f314302i.f97464q0 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 0);
                } catch (JSONException unused) {
                }
                DoraemonUtil.f(this.f314302i.f97464q0, jSONObject);
            }
            this.f314302i.E(str, i3, false);
        }
        ReportCenter.f().p("", "", "", "1000", "101", "0", false);
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
    }

    public void S(Share share, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, share, Long.valueOf(j3));
        } else {
            T(share, j3, true, true);
        }
    }

    public void T(Share share, long j3, boolean z16, boolean z17) {
        Activity activity;
        String str;
        int i3;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, share, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (share != null && (activity = this.f314297f) != null && !activity.isFinishing()) {
            String str4 = this.H;
            WebViewFragment webViewFragment = this.f314300h;
            if (webViewFragment != null) {
                str4 = webViewFragment.getRedirect302Url();
            }
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareButtonEvent(str4);
            this.f314302i = share;
            this.E = j3;
            y();
            B();
            k();
            if (this.C == null) {
                ShareActionSheetBuilder shareActionSheetBuilder = new ShareActionSheetBuilder(this.f314297f, false, 2);
                this.C = shareActionSheetBuilder;
                shareActionSheetBuilder.setIntentForStartForwardRecentActivity(v());
            }
            SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler) this.f314441d.getProvider().a(64);
            if (swiftBrowserScreenShotHandler != null) {
                str = swiftBrowserScreenShotHandler.k();
            } else {
                str = null;
            }
            SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) this.f314441d.getProvider().a(-2);
            if (this.f314300h != null && swiftBrowserStatistics != null) {
                if (swiftBrowserStatistics.C0) {
                    this.C.setActionSheetTitle(Html.fromHtml("<font color='#777777'>\u5e94\u7528\u7531 </font><font color='#00a5e0'>" + this.Q + "</font><font color='#777777'> \u63d0\u4f9b</font>"));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    sb5.append(this.P);
                    ReportController.n(null, "P_CliOper", "Grp_open", "", "third_app", "exp_menu", 0, 1, 0, sb5.toString(), "" + this.N, "", "");
                } else if (!TextUtils.isEmpty(str)) {
                    this.C.setActionSheetTitle(str);
                } else {
                    this.C.setActionSheetTitle(BaseApplicationImpl.getApplication().getString(R.string.wmx));
                }
            }
            this.C.setActionSheetItems(q());
            this.C.setItemClickListenerV2(this);
            this.C.setOnDismissListener(this);
            ShareActionSheetBuilder shareActionSheetBuilder2 = this.C;
            int i16 = 8;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            if (z17) {
                i16 = 0;
            }
            shareActionSheetBuilder2.setRowVisibility(i3, 0, i16);
            try {
                this.C.show();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserShareMenuHandler", 2, "actionSheet.show exception=" + e16);
                }
            }
            if (this.f314300h != null && this.I == 1008) {
                String shareUrl = getShareUrl();
                if (shareUrl == null) {
                    shareUrl = this.f314300h.getUrl();
                }
                String str5 = shareUrl;
                if (TextUtils.isEmpty(this.J)) {
                    return;
                }
                try {
                    str2 = Uri.parse(str5).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                } catch (Exception e17) {
                    e17.printStackTrace();
                    str2 = "";
                }
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2;
                }
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005F78", "0X8005F78", 0, 0, this.J, str5, this.K, str3, false);
            }
            if (this.f314293c0) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008CAA", "0X8008CAA", 0, 0, "", "", "", "", false);
            } else if (this.f314292b0) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008CAB", "0X8008CAB", 0, 0, "", "", "", "", false);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.e();
        this.U = false;
        this.f314297f = this.f314441d.getActivity();
        this.f314300h = (WebViewFragment) this.f314441d.getWebViewProvider();
        y();
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3, (Object) bundle);
            return;
        }
        super.f(i3, bundle);
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 10) {
                        E(bundle.getString("url", ""));
                        return;
                    }
                    return;
                } else {
                    ShareActionSheetBuilder shareActionSheetBuilder = this.C;
                    if (shareActionSheetBuilder != null) {
                        shareActionSheetBuilder.onConfigurationChanged();
                        return;
                    }
                    return;
                }
            }
            this.U = true;
            com.tencent.biz.troop.b bVar = this.T;
            if (bVar != null) {
                bVar.l0(this.f314295e);
                this.T.q();
            }
            this.D.clear();
            return;
        }
        if (bundle != null && bundle.getInt("state_machine_step", -1) == 1) {
            D();
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.o
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.J;
    }

    @Override // com.tencent.mobileqq.webviewplugin.o
    public String getMsgid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.K;
    }

    public String getShareUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        Share share = this.f314302i;
        if (share == null) {
            return "";
        }
        return share.getShareUrl();
    }

    public void i(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) eVar);
        } else {
            this.f314296e0 = eVar;
        }
    }

    @TargetApi(14)
    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        if (this.f314441d.getWebView() != null && !this.U) {
            int[] iArr = f314289m0;
            if (i3 < iArr.length && i3 >= 0) {
                this.V = i3;
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106253", true);
                QLog.d("SwiftBrowserShareMenuHandler", 2, "9170_webview_textzoom_fix textZoomSwitch=", Boolean.valueOf(isSwitchOn));
                int i16 = iArr[i3];
                if (isSwitchOn) {
                    i16 = (int) (GlobalDisplayMetricsManager.getScale() * i16);
                }
                this.f314441d.getWebView().getSettings().setTextZoom(i16);
                Share share = this.f314302i;
                if (share != null) {
                    share.N(i3, i16);
                    return;
                }
                return;
            }
            QLog.d("SwiftBrowserShareMenuHandler", 2, "adjustFontSize fontSizeIndex=", Integer.valueOf(i3));
        }
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        this.f314307m = false;
        if (((v) this.f314441d.getProvider().a(2)).f314512m.f314630m) {
            return false;
        }
        if (this.f314441d.getWebView() != null) {
            this.f314441d.getWebView();
            int tbsCoreVersion = WebView.getTbsCoreVersion(BaseApplication.getContext());
            if (tbsCoreVersion > 0 && tbsCoreVersion < 36201) {
                this.f314307m = false;
                return false;
            }
        }
        this.f314307m = true;
        return true;
    }

    public void m(int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) actionSheetItem);
            return;
        }
        String shareUrl = getShareUrl();
        Bundle bundle = new Bundle();
        WebViewFragment webViewFragment = this.f314300h;
        if (webViewFragment != null) {
            bundle.putString("qq", webViewFragment.getUin());
            bundle.putString("public_uin", this.J);
            bundle.putString("source_public_uin", this.L);
            bundle.putString("default_url", this.f314300h.getUrl());
            bundle.putString("msg_id", this.K);
            bundle.putString("troop_app_info_url", this.S);
            bundle.putString("troop_app_share_url", this.R);
            bundle.putInt("troop_id", this.P);
            bundle.putInt("troop_app_id", this.N);
            bundle.putInt(IPublicAccountBrowser.KEY_UIN_TYPE, this.I);
        }
        if (i3 == 72 && actionSheetItem != null) {
            bundle.putString("to_qq", actionSheetItem.uin);
            bundle.putString("to_uin_name", actionSheetItem.label);
            bundle.putInt(ShortVideoConstants.TO_UIN_TYPE, actionSheetItem.uinType);
            bundle.putString("guild_id", actionSheetItem.guildId);
        }
        n(i3, shareUrl, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013d  */
    @TargetApi(12)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(int i3, String str, Bundle bundle) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i16;
        int i17;
        int i18;
        String str10;
        String str11;
        int i19;
        String str12;
        String str13;
        int i26;
        int i27;
        int i28;
        com.tencent.mobileqq.webview.util.k webColorNoteInjector;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        Uri parse;
        String host;
        String str20;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, bundle);
            return;
        }
        String str21 = "";
        if (bundle == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        } else {
            str5 = bundle.getString("qq", "");
            str6 = bundle.getString("public_uin", "");
            String string = bundle.getString("source_public_uin", "");
            String string2 = bundle.getString("default_url", "");
            String string3 = bundle.getString("msg_id", "");
            i17 = bundle.getInt("troop_app_id", 0);
            int i29 = bundle.getInt("troop_id", 0);
            str4 = bundle.getString("troop_app_info_url", "");
            bundle.getInt(IPublicAccountBrowser.KEY_UIN_TYPE, 0);
            int i36 = bundle.getInt(ShortVideoConstants.TO_UIN_TYPE, 0);
            String string4 = bundle.getString("to_qq", "");
            String string5 = bundle.getString("to_uin_name", "");
            this.f314301h0 = bundle;
            str8 = string3;
            str9 = string5;
            i16 = i29;
            str3 = string;
            i18 = i36;
            str7 = string4;
            str2 = string2;
        }
        String str22 = this.H;
        WebViewFragment webViewFragment = this.f314300h;
        String str23 = str4;
        if (webViewFragment != null) {
            str10 = webViewFragment.getRedirect302Url();
            CustomWebView webView = this.f314300h.getWebView();
            if (webView != null) {
                str11 = webView.getOriginalUrl();
                if (!TextUtils.isEmpty(str11) && !str11.equals(str)) {
                    try {
                        parse = Uri.parse(str11);
                        str12 = str11;
                        try {
                            host = parse.getHost();
                            if (!parse.isHierarchical()) {
                                i19 = i16;
                                try {
                                    str20 = parse.getQueryParameter("_pflag");
                                } catch (Exception unused) {
                                }
                            } else {
                                i19 = i16;
                                str20 = null;
                            }
                        } catch (Exception unused2) {
                            i19 = i16;
                        }
                    } catch (Exception unused3) {
                    }
                    if (!TextUtils.isEmpty(str20) && (PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host) || "url.cn".equalsIgnoreCase(host))) {
                        if (((Integer.parseInt(str20) >> 3) & 1) == 1) {
                            str13 = str12;
                            if (i3 == 1) {
                                if (this.f314302i.y() != null && this.f314302i.y().f292297c == 0) {
                                    C(i3, str13);
                                } else {
                                    l(str13);
                                }
                            } else {
                                int i37 = i17;
                                String str24 = str10;
                                if (i3 == 11) {
                                    boolean matches = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(str13).matches();
                                    try {
                                        str18 = URLEncoder.encode(str13, "UTF-8");
                                    } catch (UnsupportedEncodingException unused4) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
                                        }
                                        str18 = null;
                                    }
                                    if (matches) {
                                        String valueOf = String.valueOf(NetConnInfoCenter.getServerTime());
                                        String encodeHexStr = MD5Utils.encodeHexStr(str18 + 200 + valueOf + "jubao@article@123");
                                        if (encodeHexStr != null && !encodeHexStr.isEmpty()) {
                                            encodeHexStr = encodeHexStr.toLowerCase();
                                        }
                                        str19 = "https://post.mp.qq.com/jubao/index?qq=" + str5 + "&mp_uin=" + str6 + "&scene=200&sub_appname=article_webview&timestamp=" + valueOf + "&sign=" + encodeHexStr + "&article_url=" + str18 + "&_wv=3";
                                    } else {
                                        str19 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str18 + "&qq=" + str5 + "&_wv=7";
                                    }
                                    Intent intent = new Intent(this.f314297f, (Class<?>) QQBrowserActivity.class);
                                    intent.putExtra("url", str19);
                                    intent.putExtra("hide_more_button", true);
                                    this.f314297f.startActivity(intent);
                                    ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
                                    if (str3 != null && !"".equals(str3)) {
                                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B07", "0X8005B07", 1008, 0, str3, str8, str2, ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(str2), false);
                                    }
                                } else {
                                    i26 = 72;
                                    if (i3 != 2 && i3 != 72 && i3 != 73) {
                                        if (i3 == 26) {
                                            if (bundle != null) {
                                                bundle.putString("to_qq", AppConstants.DATALINE_PC_UIN);
                                                bundle.putInt(ShortVideoConstants.TO_UIN_TYPE, 6000);
                                                WebViewFragment webViewFragment2 = this.f314300h;
                                                if (webViewFragment2 != null) {
                                                    bundle.putString("to_uin_name", webViewFragment2.getString(R.string.f173131w80));
                                                }
                                            }
                                            n(72, str13, bundle);
                                            O(i26);
                                        }
                                        if (i3 == 4) {
                                            com.tencent.mobileqq.browser.a.f(this.f314297f, str13, str5);
                                        } else if (i3 == 5) {
                                            if (this.f314300h != null && this.f314297f != null) {
                                                if (!TextUtils.isEmpty(str13)) {
                                                    HashMap hashMap = new HashMap();
                                                    hashMap.put(MttLoader.KEY_PID, String.valueOf(50079));
                                                    hashMap.put(MttLoader.KEY_EUSESTAT, String.valueOf(5));
                                                    hashMap.put("ChannelID", BaseApplication.getContext().getApplicationInfo().processName);
                                                    hashMap.put("PosID", Integer.toString(0));
                                                    int loadUrl = MttLoader.loadUrl(BaseApplication.getContext(), MttLoader.getValidQBUrl(BaseApplication.getContext(), str13), hashMap, null);
                                                    if (4 == loadUrl || 5 == loadUrl || loadUrl != 0) {
                                                        Intent intent2 = new Intent();
                                                        intent2.putExtra("url", "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html");
                                                        RouteUtils.startActivity(this.f314297f, intent2, RouterConstants.UI_ROUTE_BROWSER);
                                                    }
                                                }
                                                ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
                                                ReportController.o(null, "P_CliOper", "VIPCOMIC", "", "0X80061A0", "0X80061A0", 1000, 0, com.tencent.biz.common.util.k.f(str2, new String[0]), null, null, null);
                                                if (str3 != null && !"".equals(str3)) {
                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B07", "0X8005B07", 1005, 0, str3, str8, str2, ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(str2), false);
                                                }
                                            } else {
                                                throw new InvalidParameterException("ACTION_OPEN_IN_QQ_BROWSER should be handled by QQBrowserActivity!");
                                            }
                                        } else if (i3 == 3) {
                                            f314290n0 = System.currentTimeMillis();
                                            if (TextUtils.isEmpty(str24)) {
                                                str17 = str12;
                                            } else {
                                                str17 = str24;
                                            }
                                            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, str17, this.W);
                                            if (this.f314302i.y() != null && this.f314302i.y().f292297c == 0) {
                                                C(i3, str13);
                                            } else {
                                                K(str13);
                                            }
                                        } else if (i3 == 6) {
                                            if (this.f314302i.setShareUrl(str13)) {
                                                this.f314302i.E(str13, 9, false);
                                            }
                                            if (str3 != null && !"".equals(str3)) {
                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B07", "0X8005B07", 1007, 0, str3, str8, str2, ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(str2), false);
                                            }
                                        } else if (i3 == 129) {
                                            WebViewFragment webViewFragment3 = this.f314300h;
                                            if (webViewFragment3 != null) {
                                                QfavHelper.w(this.f314297f, webViewFragment3.getAppRuntime().getCurrentAccountUin(), this.f314305k0, this.f314306l0);
                                            }
                                        } else if (i3 != 9 && i3 != 10) {
                                            if (i3 == 13) {
                                                this.f314302i.E(str13, 5, true);
                                            } else if (i3 == 15) {
                                                if (this.f314300h != null) {
                                                    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                                                        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f173222i51, 0).show(this.f314300h.getWebTitleBarInterface().getTitleBarHeight());
                                                        return;
                                                    }
                                                    p().g(i37, new a());
                                                    ReportController.n(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, "" + i19, "" + i37, "", "");
                                                } else {
                                                    throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
                                                }
                                            } else {
                                                int i38 = i19;
                                                if (i3 == 16) {
                                                    Intent intent3 = new Intent(this.f314297f, (Class<?>) QQBrowserActivity.class);
                                                    intent3.putExtra("url", str23);
                                                    intent3.putExtra("hide_operation_bar", true);
                                                    intent3.putExtra("hide_more_button", true);
                                                    this.f314297f.startActivity(intent3);
                                                    ReportController.n(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, "" + i38, "" + i37, "", "");
                                                } else if (i3 == 17) {
                                                    if (bundle == null) {
                                                        str16 = "";
                                                    } else {
                                                        str16 = bundle.getString("troop_app_share_url", "");
                                                    }
                                                    Intent intent4 = new Intent(this.f314297f, (Class<?>) QQBrowserActivity.class);
                                                    intent4.putExtra("url", str16);
                                                    intent4.putExtra("hide_operation_bar", true);
                                                    intent4.putExtra("hide_more_button", true);
                                                    this.f314297f.startActivity(intent4);
                                                    ReportController.n(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, "" + i38, "" + i37, "", "");
                                                } else if (i3 == 18) {
                                                    if (this.f314300h != null) {
                                                        SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) this.f314441d.getProvider().a(-2);
                                                        if (!TextUtils.isEmpty(this.f314300h.getWebView().getUrl()) && swiftBrowserStatistics != null) {
                                                            swiftBrowserStatistics.f314377u0 = false;
                                                            swiftBrowserStatistics.R = System.currentTimeMillis();
                                                            this.f314300h.getWebView().reload();
                                                            this.f314300h.getWebView().setOnCustomScrollChangeListener(null);
                                                            swiftBrowserStatistics.a0(this.f314300h.getWebView(), this.f314300h.getWebView().getUrl(), 1, 0, 0, 0, 0, null);
                                                        } else {
                                                            String currentUrl = this.f314300h.getCurrentUrl();
                                                            if (!TextUtils.isEmpty(currentUrl) && swiftBrowserStatistics != null) {
                                                                swiftBrowserStatistics.f314377u0 = false;
                                                                swiftBrowserStatistics.R = System.currentTimeMillis();
                                                                this.f314300h.getWebView().loadUrl(currentUrl);
                                                                swiftBrowserStatistics.a0(this.f314300h.getWebView(), currentUrl, 1, 0, 0, 0, 0, null);
                                                            }
                                                        }
                                                        ReportController.n(null, "P_CliOper", "Grp_open", "", "third_app", "refresh_menu", 0, 1, 0, "" + i38, "" + i37, "", "");
                                                    } else {
                                                        throw new InvalidParameterException("ACTION_REFRESH_TROOP_APP_VIEW should be handled by QQBrowserActivity!");
                                                    }
                                                } else if (i3 != 7) {
                                                    if (i3 != 19 && i3 != 20) {
                                                        if (i3 == 21) {
                                                            SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler) this.f314441d.getProvider().a(64);
                                                            if (swiftBrowserScreenShotHandler != null) {
                                                                swiftBrowserScreenShotHandler.c(null, null, 2);
                                                            }
                                                            try {
                                                                str15 = Uri.parse(this.H).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                                                            } catch (Exception e16) {
                                                                e16.printStackTrace();
                                                                str15 = "";
                                                            }
                                                            if (str15 != null) {
                                                                str21 = str15;
                                                            }
                                                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007071", "0X8007071", 0, 0, str21, "", "", "");
                                                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007071", "", str21, "", "", "");
                                                        } else if (i3 == 12) {
                                                            if (this.f314302i.y() != null && this.f314302i.y().f292297c == 0) {
                                                                C(i3, str13);
                                                            } else {
                                                                N(str13);
                                                            }
                                                        } else if (i3 == 34) {
                                                            if (!TextUtils.isEmpty(this.f314302i.f97463p0)) {
                                                                this.f314302i.S();
                                                            } else if (QLog.isColorLevel()) {
                                                                QLog.d("diandian", 2, "dian dian is here");
                                                            }
                                                        } else {
                                                            long j3 = 0;
                                                            if (i3 == 35) {
                                                                ArrayList<IPublicAccountJavascriptInterface.a> arrayList = this.f314294d0;
                                                                if (arrayList != null) {
                                                                    Iterator<IPublicAccountJavascriptInterface.a> it = arrayList.iterator();
                                                                    while (it.hasNext()) {
                                                                        IPublicAccountJavascriptInterface.a next = it.next();
                                                                        if (next.f79347a == 3) {
                                                                            try {
                                                                                JSONObject jSONObject = new JSONObject(next.f79349c);
                                                                                j3 = jSONObject.getLong("uin");
                                                                                str14 = jSONObject.optString("name");
                                                                                break;
                                                                            } catch (JSONException e17) {
                                                                                e17.printStackTrace();
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                str14 = null;
                                                                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f314297f, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.f314297f, 1, j3 + "", null, 3096, 1, str14, null, null, null, null));
                                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
                                                            } else if (i3 == 30) {
                                                                ArrayList<IPublicAccountJavascriptInterface.a> arrayList2 = this.f314294d0;
                                                                if (arrayList2 != null && this.f314292b0) {
                                                                    Iterator<IPublicAccountJavascriptInterface.a> it5 = arrayList2.iterator();
                                                                    while (true) {
                                                                        if (!it5.hasNext()) {
                                                                            break;
                                                                        }
                                                                        IPublicAccountJavascriptInterface.a next2 = it5.next();
                                                                        if (next2.f79347a == 1) {
                                                                            try {
                                                                                j3 = new JSONObject(next2.f79349c).getLong("uin");
                                                                                break;
                                                                            } catch (JSONException e18) {
                                                                                e18.printStackTrace();
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                Intent intent5 = new Intent();
                                                                Bundle bundle2 = new Bundle();
                                                                intent5.setComponent(new ComponentName(this.f314297f, (Class<?>) ChatActivity.class));
                                                                bundle2.putString("uin", String.valueOf(j3));
                                                                bundle2.putInt("uintype", 1008);
                                                                intent5.putExtras(bundle2);
                                                                intent5.putExtra(IPublicAccountUtil.TAG_FROM_READINJOY, true);
                                                                intent5.setFlags(67108864);
                                                                this.f314297f.startActivity(intent5);
                                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
                                                            } else {
                                                                if (i3 == 37 && this.f314293c0) {
                                                                    ArrayList<IPublicAccountJavascriptInterface.a> arrayList3 = this.f314294d0;
                                                                    if (arrayList3 != null) {
                                                                        Iterator<IPublicAccountJavascriptInterface.a> it6 = arrayList3.iterator();
                                                                        while (true) {
                                                                            if (!it6.hasNext()) {
                                                                                break;
                                                                            }
                                                                            IPublicAccountJavascriptInterface.a next3 = it6.next();
                                                                            if (next3.f79347a == 1) {
                                                                                try {
                                                                                    j3 = new JSONObject(next3.f79349c).getLong("uin");
                                                                                    break;
                                                                                } catch (JSONException e19) {
                                                                                    e19.printStackTrace();
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.f314297f), null);
                                                                    m3.putExtra("uin", j3 + "");
                                                                    m3.putExtra("uintype", 0);
                                                                    this.f314297f.startActivity(m3);
                                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
                                                                    return;
                                                                }
                                                                if (i3 == 31) {
                                                                    ArrayList<IPublicAccountJavascriptInterface.a> arrayList4 = this.f314294d0;
                                                                    if (arrayList4 != null) {
                                                                        Iterator<IPublicAccountJavascriptInterface.a> it7 = arrayList4.iterator();
                                                                        while (true) {
                                                                            if (!it7.hasNext()) {
                                                                                break;
                                                                            }
                                                                            IPublicAccountJavascriptInterface.a next4 = it7.next();
                                                                            if (next4.f79347a == 2) {
                                                                                try {
                                                                                    j3 = new JSONObject(next4.f79349c).getLong(IPublicAccountBrowser.KEY_PUB_UIN);
                                                                                    break;
                                                                                } catch (JSONException e26) {
                                                                                    e26.printStackTrace();
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f314297f, IPublicAccountDetailActivity.ROUTE_NAME);
                                                                    activityURIRequest.extra().putString("uin", j3 + "");
                                                                    activityURIRequest.extra().putBoolean(IPublicAccountDetailActivity.FROM_JS, true);
                                                                    QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
                                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
                                                                } else if (i3 == 38) {
                                                                    this.f314302i.O();
                                                                } else if (i3 == 68) {
                                                                    com.tencent.mobileqq.teamwork.u.q(1, !((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser(this.f314297f) ? 1 : 0);
                                                                    String shareUrl = getShareUrl();
                                                                    if (shareUrl == null) {
                                                                        shareUrl = this.H;
                                                                    }
                                                                    Share share = this.f314302i;
                                                                    if (share != null) {
                                                                        str21 = share.B();
                                                                    }
                                                                    com.tencent.mobileqq.teamwork.u.f(shareUrl, str21);
                                                                } else if (i3 != 70 && i3 != 82) {
                                                                    if (i3 == 71) {
                                                                        ReportController.o(null, "dc00898", "", "", "0X800A9A4", "0X800A9A4", 0, 0, "1", "", "", "");
                                                                        ScreenShotUtil.g(this.f314441d.getWebView(), new b());
                                                                    } else if (i3 == 171) {
                                                                        R(str13, str24, str12);
                                                                    }
                                                                } else {
                                                                    Activity activity = this.f314297f;
                                                                    if ((activity instanceof QQBrowserActivity) && (webColorNoteInjector = ((QQBrowserActivity) activity).getWebColorNoteInjector()) != null) {
                                                                        webColorNoteInjector.d();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (i3 == 19) {
                                                            i28 = 6;
                                                        } else {
                                                            i28 = 7;
                                                        }
                                                        if (!TextUtils.isEmpty(this.f314302i.f97463p0)) {
                                                            this.f314302i.R(str13, i28, false);
                                                        } else {
                                                            this.f314302i.E(str13, i28, true);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            String str25 = str12;
                                            String str26 = str24;
                                            if (TextUtils.isEmpty(str26)) {
                                                str26 = str25;
                                            }
                                            if (i3 == 9) {
                                                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, str26, this.W);
                                            } else {
                                                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, str26, this.W);
                                            }
                                            if (!WXShareHelper.b0().e0()) {
                                                i27 = R.string.f173257ih1;
                                            } else if (!WXShareHelper.b0().f0()) {
                                                i27 = R.string.f173258ih2;
                                            } else {
                                                i27 = -1;
                                            }
                                            if (i27 != -1) {
                                                com.tencent.biz.qrcode.util.h.T(0, i27);
                                            } else if (i3 == 9) {
                                                if (this.f314302i.y() != null) {
                                                    this.f314302i.getSharePD().show();
                                                    ThreadManagerV2.excute(new AnonymousClass1(str13, str3, str2, str8), 128, null, false);
                                                } else {
                                                    L(str13, str3, str2, str8);
                                                }
                                            } else if (this.f314302i.y() != null && this.f314302i.y().f292297c == 0) {
                                                C(i3, str13);
                                            } else {
                                                M(str13);
                                            }
                                        }
                                    } else {
                                        String str27 = str12;
                                        e eVar = this.f314296e0;
                                        if (eVar != null) {
                                            eVar.a(str13);
                                        } else {
                                            this.f314302i.f97472y0 = A(str13);
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SwiftBrowserShareMenuHandler", 2, "ShareArkFromH5 mShare.isShareArk=", Boolean.valueOf(this.f314302i.f97472y0), ",\n shareUrl=", com.tencent.biz.common.util.k.f(str13, new String[0]));
                                            }
                                            if (i3 == 72 && !TextUtils.isEmpty(this.f314302i.f97466s0)) {
                                                this.f314302i.U(i18, str7, str9);
                                            }
                                            P(str13, str24, str27, 1);
                                        }
                                    }
                                }
                            }
                            i26 = i3;
                            O(i26);
                        }
                    }
                    str13 = str;
                    if (i3 == 1) {
                    }
                    i26 = i3;
                    O(i26);
                }
                i19 = i16;
                str12 = str11;
                str13 = str;
                if (i3 == 1) {
                }
                i26 = i3;
                O(i26);
            }
        } else {
            str10 = str22;
        }
        str11 = null;
        if (!TextUtils.isEmpty(str11)) {
            parse = Uri.parse(str11);
            str12 = str11;
            host = parse.getHost();
            if (!parse.isHierarchical()) {
            }
            if (!TextUtils.isEmpty(str20)) {
                if (((Integer.parseInt(str20) >> 3) & 1) == 1) {
                }
            }
            str13 = str;
            if (i3 == 1) {
            }
            i26 = i3;
            O(i26);
        }
        i19 = i16;
        str12 = str11;
        str13 = str;
        if (i3 == 1) {
        }
        i26 = i3;
        O(i26);
    }

    @Override // com.tencent.widget.RangeButtonView.OnChangeListener
    public void onChange(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (i3 == i16) {
                return;
            }
            j(i16);
            p().B0(this.V);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        WebViewFragment webViewFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) dialogInterface);
            return;
        }
        if ((this.E & 131072) != 0 && (webViewFragment = this.f314300h) != null) {
            an.e(webViewFragment.getActivity());
        }
        WebViewFragment webViewFragment2 = this.f314300h;
        if (webViewFragment2 != null && webViewFragment2.getUIStyleHandler() != null && (this.f314300h.getHostActivity() instanceof TeamWorkDocEditBrowserActivity) && !TextUtils.isEmpty(this.f314300h.getUrl()) && this.f314300h.getUrl().contains("sheet")) {
            this.f314300h.getUIStyleHandler().N();
        }
        try {
            Share share = this.f314302i;
            if (share != null && share.getSharePD() != null) {
                this.f314302i.getSharePD().dismiss();
            }
        } catch (Throwable th5) {
            QLog.e("SwiftBrowserShareMenuHandler", 1, th5, new Object[0]);
        }
        if (this.f314301h0 != null && QLog.isColorLevel()) {
            QLog.d("SwiftBrowserShareMenuHandler", 2, "onDismiss() called don't clear mExtraParams for time sequence problems");
        }
    }

    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
        } else {
            if (actionSheetItem == null) {
                return;
            }
            this.C.dismiss();
            m(actionSheetItem.action, actionSheetItem);
        }
    }

    public com.tencent.biz.troop.b p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (com.tencent.biz.troop.b) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (this.T == null) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.T = A;
            A.p();
        }
        return this.T;
    }

    public List<ShareActionSheetBuilder.ActionSheetItem>[] q() {
        AppRuntime appRuntime;
        boolean z16;
        ArrayList<IPublicAccountJavascriptInterface.a> arrayList;
        ArrayList<IPublicAccountJavascriptInterface.a> arrayList2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList arrayList3 = new ArrayList();
        SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) this.f314441d.getProvider().a(-2);
        if (this.f314300h != null && swiftBrowserStatistics != null && swiftBrowserStatistics.C0) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(15));
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(16));
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(17));
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(18));
            return new ArrayList[]{arrayList3};
        }
        if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            appRuntime = BaseApplicationImpl.getApplication().getRuntime();
        } else {
            appRuntime = null;
        }
        IPublicAccountH5AbilityPlugin iPublicAccountH5AbilityPlugin = (IPublicAccountH5AbilityPlugin) QRoute.api(IPublicAccountH5AbilityPlugin.class);
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && this.Y && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_DIANDIAN) && !TextUtils.isEmpty(this.f314302i.f97463p0)) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(34));
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_QQ) && (this.E & 8) == 0) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_CHANNEL) && (this.E & WebViewConstants.WV.HIDE_SHARE_TO_QCHANNEL) == 0 && ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached()) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_QZONE) && (this.E & 16) == 0) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_WX_FRIEND) && (this.E & 16384) == 0) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_WX_FRIEND_LINE) && (this.E & 32768) == 0) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        }
        Intent intent = this.f314297f.getIntent();
        if (intent != null && intent.getBooleanExtra("use_wei_bo_sdk", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((z16 || this.X) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_SINA_WEIBO)) {
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
            QidianManager.g(this.f314297f, arrayList3);
        }
        if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SHARE_QIYEQQ) && (this.E & 32) == 0 && new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity(packageManager) != null) {
            arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(20));
        }
        arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        ArrayList arrayList4 = new ArrayList();
        if (this.f314298f0) {
            Activity activity = this.f314297f;
            if (activity instanceof QQBrowserActivity) {
                QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) activity;
                String originalUrl = qQBrowserActivity.getOriginalUrl();
                com.tencent.mobileqq.webview.util.k webColorNoteInjector = qQBrowserActivity.getWebColorNoteInjector();
                if (webColorNoteInjector != null && webColorNoteInjector.a(originalUrl)) {
                    if (!webColorNoteInjector.isColorNoteExist()) {
                        i3 = 70;
                    } else {
                        i3 = 82;
                    }
                    arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(i3));
                }
            }
        }
        if (this.f314292b0 && (arrayList2 = this.f314294d0) != null) {
            Iterator<IPublicAccountJavascriptInterface.a> it = arrayList2.iterator();
            while (it.hasNext()) {
                IPublicAccountJavascriptInterface.a next = it.next();
                ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(30);
                int i16 = next.f79347a;
                if (i16 != 1) {
                    if (i16 == 2) {
                        arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(31));
                    }
                } else {
                    if (TextUtils.isEmpty(next.f79348b)) {
                        build.label = BaseApplicationImpl.getApplication().getString(R.string.d5p);
                    } else {
                        build.label = next.f79348b;
                    }
                    arrayList4.add(build);
                }
            }
        }
        if (this.f314293c0 && (arrayList = this.f314294d0) != null) {
            Iterator<IPublicAccountJavascriptInterface.a> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                IPublicAccountJavascriptInterface.a next2 = it5.next();
                ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(37);
                int i17 = next2.f79347a;
                if (i17 != 1) {
                    if (i17 == 3) {
                        arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(35));
                    }
                } else {
                    if (TextUtils.isEmpty(next2.f79348b)) {
                        build2.label = BaseApplicationImpl.getApplication().getString(R.string.d5p);
                    } else {
                        build2.label = next2.f79348b;
                    }
                    arrayList4.add(build2);
                }
            }
        }
        SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler) this.f314441d.getProvider().a(64);
        if (swiftBrowserScreenShotHandler != null && swiftBrowserScreenShotHandler.m() && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SCREEN_SHOT_SHARE)) {
            arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(21));
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.FAVORITE) && (this.E & 8192) == 0) {
            arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
        }
        if (this.f314304j0) {
            arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(129));
        }
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount()) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.EXPORT_TENCENT_DOCS) && (((v) this.f314441d.getProvider().a(2)).f314512m.f314621d & 16384) == 0) {
            String shareUrl = getShareUrl();
            if (shareUrl == null) {
                shareUrl = this.H;
            }
            if (com.tencent.mobileqq.teamwork.u.n(shareUrl)) {
                arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(68));
                com.tencent.mobileqq.teamwork.u.q(0, 1);
            }
        }
        if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.COPY_URL) && (this.E & 32) == 0) {
            arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        }
        if ((TextUtils.isEmpty(this.H) || !ITeamWorkHandler.DOCS_DOMAIN.equals(Uri.parse(this.H).getHost())) && !iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.SCREEN_LONG_SHOT_SHARE) && (this.E & 32768) == 0 && this.f314441d.getWebView() != null && this.f314441d.getWebView().getX5WebViewExtension() != null) {
            arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(71));
        }
        if (!iPublicAccountH5AbilityPlugin.contains(this.D, IPublicAccountH5AbilityPlugin.EXPOSE_ARTICLE) && this.F) {
            arrayList4.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        return new ArrayList[]{arrayList3, arrayList4};
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.Y;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.f314291a0;
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.X;
    }

    public Bundle u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Bundle) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.f314301h0;
    }

    public boolean z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        String shareUrl = this.f314302i.getShareUrl();
        if (TextUtils.isEmpty(this.f314302i.B()) || TextUtils.isEmpty(this.f314302i.x()) || TextUtils.isEmpty(shareUrl) || !shareUrl.equals(com.tencent.biz.common.util.k.g(str, new String[0]))) {
            return false;
        }
        return true;
    }
}
