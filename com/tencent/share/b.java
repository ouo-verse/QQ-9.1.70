package com.tencent.share;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.common.util.k;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 ;2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010$\u0012\b\u0010-\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J&\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0004R\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010(\u001a\u0004\u0018\u00010$8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010-\u001a\u0004\u0018\u00010)8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010,R$\u00103\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00106\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R$\u00109\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010.\u001a\u0004\b7\u00100\"\u0004\b8\u00102R$\u0010<\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010.\u001a\u0004\b:\u00100\"\u0004\b;\u00102R$\u0010?\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010.\u001a\u0004\b=\u00100\"\u0004\b>\u00102R$\u0010B\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010.\u001a\u0004\b@\u00100\"\u0004\bA\u00102R\u0018\u0010D\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010CR$\u0010H\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010 \u001a\u0004\bE\u0010\"\"\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/share/b;", "", "", "forWhat", "", "c", "f", "uinType", "", "uin", "nickname", "e", "d", "", "t", "shareUrl", "sourcePuin", "defaultUrl", "msgId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "g", h.F, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "b", "action", "a", "p", "u", "o", "Landroid/app/Activity;", "Landroid/app/Activity;", "getHostActivity", "()Landroid/app/Activity;", "hostActivity", "Lcom/tencent/biz/pubaccount/CustomWebView;", "Lcom/tencent/biz/pubaccount/CustomWebView;", "getWebview", "()Lcom/tencent/biz/pubaccount/CustomWebView;", "webview", "Lmqq/app/AppRuntime;", "Lmqq/app/AppRuntime;", "getRuntime", "()Lmqq/app/AppRuntime;", "runtime", "Ljava/lang/String;", "getOnShareHandler", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "onShareHandler", "getOnShareQQFriendHandler", "j", "onShareQQFriendHandler", "getOnShareQQSpecifiedFriendHandler", "k", "onShareQQSpecifiedFriendHandler", "getOnShareQZoneHandler", "l", "onShareQZoneHandler", "getOnShareWXFriendHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onShareWXFriendHandler", "getOnShareWXTimelineHandler", DomainData.DOMAIN_NAME, "onShareWXTimelineHandler", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "shareProgressDialog", "getActivityForLaunchPlugin", "setActivityForLaunchPlugin", "(Landroid/app/Activity;)V", "activityForLaunchPlugin", "<init>", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lmqq/app/AppRuntime;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity hostActivity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final CustomWebView webview;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AppRuntime runtime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String onShareHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String onShareQQFriendHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String onShareQQSpecifiedFriendHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String onShareQZoneHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String onShareWXFriendHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String onShareWXTimelineHandler;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProgressDialog shareProgressDialog;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity activityForLaunchPlugin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/share/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.share.b$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64183);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull Activity hostActivity, @Nullable CustomWebView customWebView, @Nullable AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(hostActivity, "hostActivity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hostActivity, customWebView, appRuntime);
            return;
        }
        this.hostActivity = hostActivity;
        this.webview = customWebView;
        this.runtime = appRuntime;
    }

    private final void c(int forWhat) {
        String str;
        if (forWhat != 1) {
            if (forWhat != 2) {
                if (forWhat != 3) {
                    if (forWhat != 4) {
                        if (forWhat != 6) {
                            if (forWhat != 7) {
                                if (forWhat != 8) {
                                    if (forWhat != 11) {
                                        str = "-1";
                                    } else {
                                        str = "11";
                                    }
                                } else {
                                    str = "4";
                                }
                            } else {
                                str = "6";
                            }
                        } else {
                            str = "5";
                        }
                    } else {
                        str = "3";
                    }
                } else {
                    str = "2";
                }
            } else {
                str = "1";
            }
        } else {
            str = "0";
        }
        QQProgressDialog b16 = b();
        if (b16 != null) {
            b16.show();
        }
        CustomWebView customWebView = this.webview;
        if (customWebView != null) {
            customWebView.callJs(this.onShareHandler, str);
        } else {
            QLog.w("WebShare", 1, "notifyOnShare webview is null");
        }
    }

    private final void d() {
        CustomWebView customWebView;
        String str = this.onShareQQFriendHandler;
        if (str != null && (customWebView = this.webview) != null) {
            customWebView.callJs(str, "0");
        }
    }

    private final void e(int uinType, String uin, String nickname) {
        if (this.onShareQQSpecifiedFriendHandler != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("targetUinType", uinType);
                jSONObject.put(IProfileProtocolConst.PARAM_TARGET_UIN, uin);
                jSONObject.put("targetNickname", nickname);
            } catch (JSONException e16) {
                QLog.e("WebShare", 1, "notifyOnShareQQSpecifiedFriend process data error!", e16);
            }
            CustomWebView customWebView = this.webview;
            if (customWebView != null) {
                customWebView.callJs(this.onShareQQSpecifiedFriendHandler, jSONObject.toString());
            }
        }
    }

    private final void f() {
        CustomWebView customWebView;
        String str = this.onShareQZoneHandler;
        if (str != null && (customWebView = this.webview) != null) {
            customWebView.callJs(str, "1");
        }
    }

    private final void g() {
        CustomWebView customWebView;
        String str = this.onShareWXFriendHandler;
        if (str != null && (customWebView = this.webview) != null) {
            customWebView.callJs(str, "2");
        }
    }

    private final void h() {
        CustomWebView customWebView;
        String str = this.onShareWXTimelineHandler;
        if (str != null && (customWebView = this.webview) != null) {
            customWebView.callJs(str, "3");
        }
    }

    private final void q(String shareUrl, String sourcePuin, String defaultUrl, String msgId) {
        if (!TextUtils.isEmpty(this.onShareHandler)) {
            c(3);
        } else if (!TextUtils.isEmpty(this.onShareWXFriendHandler)) {
            g();
        }
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
        if (sourcePuin != null && !Intrinsics.areEqual("", sourcePuin)) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B07", "0X8005B07", 1003, 0, sourcePuin, msgId, defaultUrl, ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(defaultUrl), false);
        }
        ReportCenter.f().p("", "", "", "1000", "103", "0", false);
    }

    private final void r() {
        if (!TextUtils.isEmpty(this.onShareHandler)) {
            c(4);
        } else if (!TextUtils.isEmpty(this.onShareWXTimelineHandler)) {
            h();
        }
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
        ReportCenter.f().p("", "", "", "1000", "104", "0", false);
    }

    private final void s() {
        String str;
        CustomWebView customWebView = this.webview;
        if (customWebView != null) {
            str = customWebView.getUrl();
        } else {
            str = null;
        }
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, k.g(str, new String[0]), 100);
        if (!TextUtils.isEmpty(this.onShareHandler)) {
            c(1);
        } else if (!TextUtils.isEmpty(this.onShareQQFriendHandler)) {
            d();
        } else {
            QLog.e("WebShare", 1, "onShareHandler and onShareQQFriendHandler is empty");
        }
        ReportCenter.f().p("", "", "", "1000", "101", "0", false);
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
    }

    private final boolean t() {
        String str;
        String str2;
        boolean equals;
        Activity activity;
        PluginBaseActivity pluginBaseActivity;
        if (this.activityForLaunchPlugin == null) {
            equals = StringsKt__StringsJVMKt.equals(this.hostActivity.getPackageName(), "com.tencent.qqreadinjoy", true);
            if (equals) {
                Activity activity2 = this.hostActivity;
                if (activity2 instanceof PluginBaseActivity) {
                    pluginBaseActivity = (PluginBaseActivity) activity2;
                } else {
                    pluginBaseActivity = null;
                }
                if (pluginBaseActivity != null) {
                    activity = pluginBaseActivity.getOutActivity();
                } else {
                    activity = null;
                }
            } else {
                activity = this.hostActivity;
            }
            this.activityForLaunchPlugin = activity;
        }
        QZoneShareData qZoneShareData = new QZoneShareData();
        CustomWebView customWebView = this.webview;
        if (customWebView != null) {
            str = customWebView.getTitle();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        qZoneShareData.mTitle = str;
        qZoneShareData.mSummary = null;
        qZoneShareData.mImageUrls = new ArrayList<>(1);
        CustomWebView customWebView2 = this.webview;
        if (customWebView2 != null) {
            str2 = customWebView2.getUrl();
        } else {
            str2 = null;
        }
        qZoneShareData.targetUrl = k.g(str2, new String[0]);
        qZoneShareData.mShareBeginTime = SwiftBrowserShareMenuHandler.f314290n0;
        qZoneShareData.from = 2;
        CustomWebView customWebView3 = this.webview;
        if (customWebView3 != null) {
            qZoneShareData.mWebUrl = customWebView3.getUrl();
        }
        AppRuntime appRuntime = this.runtime;
        if (appRuntime != null) {
            QZoneShareManager.shareToQzone(this.activityForLaunchPlugin, appRuntime.getCurrentAccountUin(), qZoneShareData, null, -1);
        } else {
            com.tencent.biz.qrcode.util.h.T(1, R.string.f169964ab);
        }
        return true;
    }

    public final void a(int action, int uinType, @NotNull String uin, @NotNull String nickname) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(action), Integer.valueOf(uinType), uin, nickname);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        if (action == 72 && !TextUtils.isEmpty(this.onShareQQSpecifiedFriendHandler)) {
            e(uinType, uin, nickname);
        }
        s();
    }

    @Nullable
    public final QQProgressDialog b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (QQProgressDialog) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (this.shareProgressDialog == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.hostActivity, this.hostActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.shareProgressDialog = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.f169961a6);
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("WebShare", 2, "dialog show time :" + currentTimeMillis);
            }
        }
        return this.shareProgressDialog;
    }

    public final void i(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.onShareHandler = str;
        }
    }

    public final void j(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.onShareQQFriendHandler = str;
        }
    }

    public final void k(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.onShareQQSpecifiedFriendHandler = str;
        }
    }

    public final void l(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.onShareQZoneHandler = str;
        }
    }

    public final void m(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.onShareWXFriendHandler = str;
        }
    }

    public final void n(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.onShareWXTimelineHandler = str;
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        QLog.d("WebShare", 1, "share2Channel onShareHandler = " + this.onShareHandler);
        if (!TextUtils.isEmpty(this.onShareHandler)) {
            c(11);
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (!TextUtils.isEmpty(this.onShareHandler)) {
            c(2);
        } else if (!TextUtils.isEmpty(this.onShareQZoneHandler)) {
            f();
        } else {
            t();
        }
        ReportCenter.f().p("", "", "", "1000", "102", "0", false);
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
    }

    public final void u(int action) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, action);
            return;
        }
        CustomWebView customWebView = this.webview;
        if (customWebView != null) {
            str = customWebView.getUrl();
        } else {
            str = null;
        }
        String url = k.g(str, new String[0]);
        if (action == 9) {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, url, 100);
        } else {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, url, 100);
        }
        if (!WXShareHelper.b0().e0()) {
            i3 = R.string.f173257ih1;
        } else if (!WXShareHelper.b0().f0()) {
            i3 = R.string.f173258ih2;
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            com.tencent.biz.qrcode.util.h.T(0, i3);
        } else {
            if (action == 9) {
                Intrinsics.checkNotNullExpressionValue(url, "url");
                Intrinsics.checkNotNullExpressionValue(url, "url");
                q(url, "", url, "");
                return;
            }
            r();
        }
    }
}
