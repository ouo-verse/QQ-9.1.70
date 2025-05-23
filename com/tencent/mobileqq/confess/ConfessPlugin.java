package com.tencent.mobileqq.confess;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.k;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.n;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class ConfessPlugin extends WebViewPlugin {
    String C;
    String D;
    private int E = Integer.MIN_VALUE;
    private ProgressDialog F = null;
    JSONObject G = null;
    Runnable H = new Runnable() { // from class: com.tencent.mobileqq.confess.ConfessPlugin.2
        @Override // java.lang.Runnable
        public void run() {
            String str = ConfessPlugin.this.C;
            if (TextUtils.isEmpty(str)) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.confess.ConfessPlugin.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfessPlugin.this.s();
                    }
                });
                return;
            }
            Object[] f16 = com.tencent.mobileqq.campuscircle.a.c().f(str);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.confess.ConfessPlugin.2.2
                @Override // java.lang.Runnable
                public void run() {
                    ConfessPlugin.this.s();
                }
            });
            if (f16 != null && f16.length == 3) {
                boolean booleanValue = ((Boolean) f16[0]).booleanValue();
                boolean booleanValue2 = ((Boolean) f16[1]).booleanValue();
                Object obj = f16[2];
                List list = obj == null ? null : (List) obj;
                if (!booleanValue2) {
                    ConfessPlugin confessPlugin = ConfessPlugin.this;
                    confessPlugin.callJs(confessPlugin.D, "\"\u672c\u7fa4\u6210\u5458\u4e0d\u80fd\u5411\u597d\u53cb\u53d1\u8d77\u52a0\u7fa4\u9080\u8bf7\u3002\"");
                    return;
                } else {
                    if (list != null && list.size() != 0) {
                        if (ConfessPlugin.this.z(str, booleanValue, (ArrayList) list)) {
                            return;
                        }
                        ConfessPlugin confessPlugin2 = ConfessPlugin.this;
                        confessPlugin2.callJs(confessPlugin2.D, "\"\u9080\u8bf7\u7fa4\u6210\u5458\u5f02\u5e38\u3002\"");
                        return;
                    }
                    ConfessPlugin confessPlugin3 = ConfessPlugin.this;
                    confessPlugin3.callJs(confessPlugin3.D, "\"\u83b7\u53d6\u7fa4\u6210\u5458\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\u3002\"");
                    return;
                }
            }
            ConfessPlugin confessPlugin4 = ConfessPlugin.this;
            confessPlugin4.callJs(confessPlugin4.D, "\"\u9080\u8bf7\u7fa4\u6210\u5458\u5f02\u5e38\u3002\"");
        }
    };

    /* renamed from: d, reason: collision with root package name */
    QQProgressDialog f202144d;

    /* renamed from: e, reason: collision with root package name */
    WXShareHelper.a f202145e;

    /* renamed from: f, reason: collision with root package name */
    String f202146f;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.mobileqq.armap.f f202147h;

    /* renamed from: i, reason: collision with root package name */
    protected String f202148i;

    /* renamed from: m, reason: collision with root package name */
    protected ChooseFriendReceiver f202149m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes33.dex */
    public static class ChooseFriendReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private ConfessPlugin f202152d;

        public ChooseFriendReceiver(ConfessPlugin confessPlugin, Handler handler) {
            super(handler);
            this.f202152d = confessPlugin;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i("ConfessPlugin", 2, String.format("onReceiveResult resultCode=%d", Integer.valueOf(i3)));
            }
            if (i3 == 0 && bundle != null) {
                this.f202152d.t(bundle.getStringArrayList("choose_friend_uins"), bundle.getStringArrayList("choose_friend_names"));
            } else {
                this.f202152d.t(null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action != 1 && action != 3) || !(view instanceof TextView)) {
                    return false;
                }
                TextView textView = (TextView) view;
                int currentTextColor = textView.getCurrentTextColor();
                textView.setTextColor(Color.argb(255, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
                return false;
            }
            if (!(view instanceof TextView)) {
                return false;
            }
            TextView textView2 = (TextView) view;
            int currentTextColor2 = textView2.getCurrentTextColor();
            textView2.setTextColor(Color.argb(128, Color.red(currentTextColor2), Color.green(currentTextColor2), Color.blue(currentTextColor2)));
            return false;
        }
    }

    private void A(boolean z16) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("ConfessPlugin", 2, "onShareConfessCallback success:" + z16 + " mShareMsgCallback=" + this.f202146f);
        }
        if (TextUtils.isEmpty(this.f202146f)) {
            return;
        }
        String str2 = this.f202146f;
        String[] strArr = new String[1];
        if (z16) {
            str = "{'retCode': 0}";
        } else {
            str = "{'retCode': 1}";
        }
        strArr[0] = str;
        callJs(str2, strArr);
    }

    private void B(int i3) {
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessPlugin", 2, String.format("setRightBtnMaxLen %d", Integer.valueOf(i3)));
        }
        TextView textView = (TextView) a16.findViewById(R.id.ivTitleBtnRightText);
        if (textView == null) {
            return;
        }
        if (this.E == Integer.MIN_VALUE) {
            this.E = textView.getMaxWidth();
        }
        if (i3 == 0) {
            textView.setMaxWidth(this.E);
        } else if (i3 > 0) {
            textView.setMaxWidth(BaseAIOUtils.f(i3, a16.getResources()));
        }
    }

    private void C() {
        try {
            WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
            if (webViewFragment == null) {
                return;
            }
            TextView textView = webViewFragment.getSwiftTitleUI().f314054i;
            TextView textView2 = webViewFragment.getSwiftTitleUI().C;
            a aVar = new a();
            if (textView != null) {
                textView.setOnTouchListener(aVar);
            }
            if (textView2 != null) {
                textView2.setOnTouchListener(aVar);
            }
        } catch (Exception e16) {
            QLog.e("ConfessPlugin", 1, "setTitleTextClickEffective exception e = ", e16);
        }
    }

    private void doCallback(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        super.callJs(str, str2);
    }

    private Context getCurrentContext() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private void r(Activity activity) {
        if (this.f202144d == null) {
            WebViewPlugin.b bVar = this.mRuntime;
            y d16 = bVar.d(bVar.a());
            if (d16 instanceof n) {
                this.f202144d = ((Share) ((n) d16).getShare()).getSharePD();
            } else {
                this.f202144d = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        QQProgressDialog qQProgressDialog = this.f202144d;
        if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
            return;
        }
        this.f202144d.dismiss();
    }

    private void u(JSONObject jSONObject) {
        String str;
        String str2;
        boolean z16;
        Context currentContext = getCurrentContext();
        if (currentContext != null && jSONObject != null && !TextUtils.isEmpty(this.f202148i)) {
            String optString = jSONObject.optString("title", HardCodeUtil.qqStr(R.string.kzi));
            JSONObject optJSONObject = jSONObject.optJSONObject(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            if (optJSONObject != null) {
                str = optJSONObject.optString("title");
                str2 = optJSONObject.optString("content");
                z16 = true;
            } else {
                str = "";
                str2 = "";
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ConfessPlugin", 2, "chooseFriends needConfirm: " + z16 + " confirmTitle: " + str + " confirmContent: " + str2);
            }
            if (this.f202149m == null) {
                this.f202149m = new ChooseFriendReceiver(this, new Handler());
            }
            Parcel obtain = Parcel.obtain();
            this.f202149m.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            Intent intent = new Intent(currentContext, (Class<?>) ForwardRecentActivity.class);
            intent.putExtra("forward_type", 15);
            intent.putExtra("only_single_selection", true);
            intent.putExtra("choose_friend_title", optString);
            intent.putExtra("choose_friend_is_qqfriends", true);
            intent.putExtra("choose_friend_callback", resultReceiver);
            intent.putExtra("choose_friend_isForConfess", true);
            if (z16) {
                intent.putExtra("choose_friend_needConfirm", z16);
                intent.putExtra("choose_friend_confirmTitle", str);
                intent.putExtra("choose_friend_confirmContent", str2);
            }
            super.startActivityForResult(intent, (byte) 12);
            return;
        }
        t(null, null);
    }

    private void y(JSONObject jSONObject) {
        String str;
        Activity a16 = this.mRuntime.a();
        if (this.mRuntime.b() != null && a16 != null) {
            String str2 = "";
            if (!jSONObject.has("url")) {
                str = "";
            } else {
                str = jSONObject.optString("url");
            }
            if (jSONObject.has("callback")) {
                str2 = jSONObject.optString("callback");
            }
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i("ConfessPlugin", 2, "handleOpenGroupConfess invalidate url");
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                callJs(str2, "invalidate url");
                return;
            }
            Intent intent = new Intent(a16, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            intent.setFlags(603979776);
            a16.startActivity(intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessPlugin", 2, "handleOpenGroupConfess app is null  or activity is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(String str, boolean z16, ArrayList<String> arrayList) {
        Context currentContext = getCurrentContext();
        if (currentContext == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, str);
        intent.putExtra("param_type", 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_IS_TROOP_ADMIN, z16);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, currentContext.getString(R.string.b9f));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, currentContext.getString(R.string.dpe));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 100);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(currentContext, intent);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "sayHonest";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("ConfessPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, strArr));
        }
        if ("sayHonest".equals(str2)) {
            if ("shareConfessMessage".equals(str3)) {
                this.f202146f = null;
                A(false);
                QLog.e("ConfessPlugin", 1, "shareConfessMessage exception e = nonsupport");
                return true;
            }
            if ("openConfessAIO".equals(str3)) {
                try {
                    v(new JSONObject(strArr[0]));
                } catch (Exception e16) {
                    QLog.e("ConfessPlugin", 1, "openConfessAIO exception e = ", e16);
                }
            } else if ("setFirstOpen".equals(str3)) {
                try {
                    ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.mRuntime.b().getAccount(), "confess_first_open", Integer.valueOf(new JSONObject(strArr[0]).optInt("value")));
                } catch (Exception e17) {
                    QLog.e("ConfessPlugin", 1, "METHOD_SET_FIRST_OPEN exception e = ", e17);
                }
            } else if ("getFirstOpen".equals(str3)) {
                try {
                    String account = this.mRuntime.b().getAccount();
                    String optString = new JSONObject(strArr[0]).optString("callback");
                    int intValue = ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(account, "confess_first_open", (Object) 0)).intValue();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("value", intValue);
                    callJs(optString, jSONObject.toString());
                } catch (Exception e18) {
                    QLog.e("ConfessPlugin", 1, "METHOD_GET_FIRST_OPEN exception e = ", e18);
                }
            } else if ("clearRedPoint".equals(str3)) {
                try {
                    com.tencent.mobileqq.campuscircle.a.c().b("frd_rec_confess");
                    callJs(new JSONObject(strArr[0]).optString("callback"), "");
                } catch (Exception e19) {
                    QLog.e("ConfessPlugin", 1, "METHOD_CLEAR_FRD_REC exception e = ", e19);
                }
            } else if ("setrightbtn_maxlen".equals(str3)) {
                try {
                    B(new JSONObject(strArr[0]).optInt("limit", 0));
                } catch (Exception e26) {
                    QLog.e("ConfessPlugin", 1, "METHOD_SETRIGHTBTN_MAXLEN exception e = ", e26);
                }
            } else if ("hideReport".equals(str3)) {
                try {
                    WebViewProvider f16 = this.mRuntime.f();
                    if (f16 != null && (swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) f16.getComponentProvider().a(4)) != null) {
                        swiftBrowserShareMenuHandler.F = false;
                    }
                } catch (Exception e27) {
                    QLog.e("ConfessPlugin", 1, "METHOD_HIDE_REPORT exception e = ", e27);
                }
            } else if ("titleTextClickEffective".equals(str3)) {
                C();
            } else if ("openGroupAIO".equals(str3)) {
                try {
                    x(new JSONObject(strArr[0]));
                } catch (Exception e28) {
                    QLog.e("ConfessPlugin", 1, "METHOD_SETRIGHTBTN_MAXLEN exception e = ", e28);
                }
            } else if (VasCommonJsPlugin.H5_CALLBACK_GETFRIENDINFO.equals(str3)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    this.f202148i = jSONObject2.optString("callback");
                    u(jSONObject2);
                } catch (Exception e29) {
                    t(null, null);
                    QLog.e("ConfessPlugin", 1, "METHOD_GET_FRIEND_INFO exception e = ", e29);
                }
            } else {
                if ("inviteMemberToGroup".equals(str3)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(strArr[0]);
                        String string = jSONObject3.getString("troopUin");
                        String optString2 = jSONObject3.optString("callback");
                        if (TextUtils.isEmpty(string)) {
                            return false;
                        }
                        this.C = k.a(string);
                        this.D = optString2;
                        if (this.f202144d == null) {
                            r(this.mRuntime.a());
                        }
                        QQProgressDialog qQProgressDialog = this.f202144d;
                        if (qQProgressDialog != null) {
                            qQProgressDialog.setMessage(R.string.c7z);
                            if (!this.f202144d.isShowing()) {
                                this.f202144d.show();
                            }
                        }
                        ThreadManagerV2.postImmediately(this.H, null, true);
                        return true;
                    } catch (Exception e36) {
                        QLog.e("ConfessPlugin", 1, "METHOD_INVITE_TROOP_MEMBERS exception e = ", e36);
                        return true;
                    }
                }
                if ("openConfessRankAIO".equals(str3)) {
                    try {
                        w(new JSONObject(strArr[0]));
                    } catch (Exception e37) {
                        QLog.e("ConfessPlugin", 1, "OpenConfessRankAIO exception e = ", e37);
                    }
                } else if ("openGroupConfess".equals(str3)) {
                    try {
                        y(new JSONObject(strArr[0]));
                    } catch (Exception e38) {
                        QLog.e("ConfessPlugin", 1, "openGroupConfess exception e = ", e38);
                    }
                } else if ("updateConfessSwitch".equals(str3)) {
                    try {
                        i3 = new JSONObject(strArr[0]).optInt("switchValue");
                    } catch (Exception e39) {
                        QLog.e("ConfessPlugin", 1, "updateConfessSwitch exception e = ", e39);
                        i3 = 0;
                    }
                    com.tencent.mobileqq.campuscircle.a.c().j(i3);
                }
            }
            return false;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (QLog.isColorLevel()) {
            QLog.d("ConfessPlugin", 2, "onActivityResult requestCode=" + ((int) b16) + "  resultCode=" + i3 + " mShareMsgCallback=" + this.f202146f);
        }
        s();
        if (b16 != 10 && b16 != 11) {
            if (b16 == 12 && i3 == 0 && !TextUtils.isEmpty(this.f202148i)) {
                t(null, null);
                return;
            }
            return;
        }
        A(i3 == -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        s();
        if (this.f202145e != null) {
            WXShareHelper.b0().q0(this.f202145e);
            this.f202145e = null;
        }
        com.tencent.mobileqq.armap.f fVar = this.f202147h;
        if (fVar != null) {
            fVar.destroy();
            this.f202147h = null;
        }
        s();
        this.f202146f = null;
        this.G = null;
        super.onDestroy();
    }

    private void v(JSONObject jSONObject) {
        int i3;
        int i16;
        long j3;
        int i17;
        String str;
        char c16;
        String str2;
        String str3;
        String str4;
        String str5;
        Activity a16 = this.mRuntime.a();
        AppInterface b16 = this.mRuntime.b();
        if (b16 != null && a16 != null) {
            int optInt = jSONObject.optInt("chatType");
            int optInt2 = jSONObject.optInt("topicId");
            String optString = jSONObject.optString("confess");
            String optString2 = jSONObject.optString("confessorNick");
            String optString3 = jSONObject.optString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            int optInt3 = jSONObject.optInt("confessorSex");
            String optString4 = jSONObject.optString("callback");
            String a17 = k.a(jSONObject.optString("confessorUin"));
            String a18 = k.a(jSONObject.optString("toUin"));
            int optInt4 = jSONObject.optInt("bg_type");
            long optLong = jSONObject.optLong("confessTime");
            String currentAccountUin = b16.getCurrentAccountUin();
            if (TextUtils.equals(currentAccountUin, a18) || !ChatActivityUtils.P(a18) || !ChatActivityUtils.P(a17) || !Friends.isValidUin(a18) || !Friends.isValidUin(a17) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                i3 = optInt4;
                i16 = optInt3;
                j3 = optLong;
                i17 = optInt;
                str = optString3;
                c16 = 0;
                str2 = a18;
                str3 = a17;
                str4 = optString4;
                if (!TextUtils.isEmpty(str4)) {
                    callJs(str4, "invalidate params");
                }
            } else if (optInt == 0) {
                i17 = optInt;
                Intent intent = new Intent(a16, (Class<?>) ChatActivity.class);
                intent.putExtra("open_chat_from_frd_rec_confess", true);
                intent.putExtra(ConfessInfo.KEY_CONFESS_TOPICID, optInt2);
                intent.putExtra(ConfessInfo.KEY_CONFESS_DESC, optString);
                intent.putExtra(ConfessInfo.KEY_CONFESSOR_UIN, a17);
                intent.putExtra(ConfessInfo.KEY_CONFESSOR_NICK, optString2);
                intent.putExtra(ConfessInfo.KEY_CONFESSOR_SEX, optInt3);
                intent.putExtra(ConfessInfo.KEY_CONFESS_BG_TYPE, optInt4);
                intent.putExtra(ConfessInfo.KEY_CONFESS_REC_NICK_NAME, optString3);
                intent.putExtra(ConfessInfo.KEY_CONFESS_REC_UIN, a18);
                j3 = optLong;
                intent.putExtra(ConfessInfo.KEY_CONFESS_TIME, j3);
                intent.putExtra("uin", a18);
                intent.putExtra("uintype", 0);
                a16.startActivity(intent);
                i3 = optInt4;
                str2 = a18;
                str3 = a17;
                i16 = optInt3;
                str = optString3;
                c16 = 0;
                str4 = optString4;
            } else {
                i17 = optInt;
                if (TextUtils.equals(a17, a18)) {
                    str5 = optString4;
                    c16 = 0;
                } else if (TextUtils.equals(a17, currentAccountUin)) {
                    str5 = optString4;
                    c16 = 0;
                } else if (TextUtils.isEmpty(optString4)) {
                    c16 = 0;
                    str4 = optString4;
                    i3 = optInt4;
                    str2 = a18;
                    str3 = a17;
                    i16 = optInt3;
                    str = optString3;
                    j3 = optLong;
                } else {
                    c16 = 0;
                    callJs(optString4, "undefined chat type");
                    i3 = optInt4;
                    str2 = a18;
                    str3 = a17;
                    i16 = optInt3;
                    str = optString3;
                    str4 = optString4;
                    j3 = optLong;
                }
                int i18 = TextUtils.equals(a18, a17) ? 1034 : 1033;
                str = optString3;
                Bundle bundle = new Bundle();
                bundle.putBoolean("open_chat_from_rec_confess", true);
                bundle.putInt(ConfessInfo.KEY_CONFESS_TOPICID, optInt2);
                bundle.putString(ConfessInfo.KEY_CONFESS_DESC, optString);
                bundle.putString(ConfessInfo.KEY_CONFESSOR_UIN, a17);
                bundle.putString(ConfessInfo.KEY_CONFESSOR_NICK, optString2);
                bundle.putInt(ConfessInfo.KEY_CONFESSOR_SEX, optInt3);
                j3 = optLong;
                bundle.putLong(ConfessInfo.KEY_CONFESS_TIME, j3);
                i3 = optInt4;
                str2 = a18;
                str3 = a17;
                str4 = str5;
                i16 = optInt3;
                ConfessMsgUtil.m(a16, a18, i18, optInt2, optString2, bundle);
            }
            if (QLog.isDevelopLevel()) {
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[11];
                objArr[c16] = Integer.valueOf(i17);
                objArr[1] = Integer.valueOf(optInt2);
                objArr[2] = optString;
                objArr[3] = optString2;
                objArr[4] = str3;
                objArr[5] = Integer.valueOf(i16);
                objArr[6] = Long.valueOf(j3);
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = Integer.valueOf(i3);
                objArr[10] = str4;
                QLog.i("ConfessPlugin", 4, String.format(locale, "handleOpenConfessAIO [chatType: %s, topicId: %s, confess: %s, confessorNick: %s, confessorUin: %s, confessorSex: %s, confessorTime:%l,  nick_name: %s, toUin: %s, bg_type: %s, callback: %s]", objArr));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessPlugin", 2, "handleOpenConfessAIO app is null  or activity is null!");
        }
    }

    private void w(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        int i16;
        Activity a16 = this.mRuntime.a();
        AppInterface b16 = this.mRuntime.b();
        if (b16 != null && a16 != null) {
            String currentAccountUin = b16.getCurrentAccountUin();
            int optInt = jSONObject.has("chatType") ? jSONObject.optInt("chatType") : 0;
            int optInt2 = jSONObject.has("topicId") ? jSONObject.optInt("topicId") : 0;
            String str5 = "";
            if (!jSONObject.has("confess")) {
                str = "";
            } else {
                str = jSONObject.optString("confess");
            }
            int optInt3 = jSONObject.has("confessNum") ? jSONObject.optInt("confessNum") : 0;
            int optInt4 = jSONObject.has("gender") ? jSONObject.optInt("gender") : 0;
            if (!jSONObject.has("callback")) {
                str2 = "";
            } else {
                str2 = jSONObject.optString("callback");
            }
            if (!jSONObject.has("toUin")) {
                str3 = "";
            } else {
                str3 = jSONObject.optString("toUin");
            }
            if (!jSONObject.has("fromEncodeUin")) {
                str4 = "";
            } else {
                str4 = k.a(jSONObject.optString("fromEncodeUin"));
            }
            int optInt5 = jSONObject.has("bg_type") ? jSONObject.optInt("bg_type") : 0;
            if (jSONObject.has("confessorNick")) {
                str5 = jSONObject.optString("confessorNick");
            }
            if (jSONObject.has("confessorSex")) {
                i16 = jSONObject.optInt("confessorSex");
                i3 = optInt;
            } else {
                i3 = optInt;
                i16 = 0;
            }
            long optLong = jSONObject.has("confessTime") ? jSONObject.optLong("confessTime") : 0L;
            if (TextUtils.equals(currentAccountUin, str3) || !ChatActivityUtils.P(str3) || !Friends.isValidUin(str3) || TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i("ConfessPlugin", 2, "handleOpenConfessRankAIO invalidate params");
                }
                if (!TextUtils.isEmpty(str2)) {
                    callJs(str2, "invalidate params");
                }
            }
            if (TextUtils.equals(str4, str3) && !TextUtils.isEmpty(str2)) {
                callJs(str2, "invalidate params confessorUin = toUin");
            }
            Intent intent = new Intent(a16, (Class<?>) ChatActivity.class);
            intent.putExtra("open_chat_from_frd_rec_confess", true);
            intent.putExtra("open_chat_from_frd_rank_confess", true);
            intent.putExtra(ConfessInfo.KEY_CONFESS_TOPICID, optInt2);
            intent.putExtra(ConfessInfo.KEY_CONFESSOR_UIN, str4);
            intent.putExtra(ConfessInfo.KEY_CONFESS_DESC, str);
            intent.putExtra(ConfessInfo.KEY_CONFESSOR_FRIEND_SEX, optInt4);
            intent.putExtra(ConfessInfo.KEY_CONFESSOR_NICK, str5);
            intent.putExtra(ConfessInfo.KEY_CONFESSOR_NUM, optInt3);
            intent.putExtra(ConfessInfo.KEY_CONFESS_BG_TYPE, optInt5);
            intent.putExtra(ConfessInfo.KEY_CONFESS_REC_UIN, str3);
            intent.putExtra(ConfessInfo.KEY_CONFESSOR_SEX, i16);
            int i17 = optInt2;
            intent.putExtra(ConfessInfo.KEY_CONFESS_TIME, optLong);
            intent.putExtra("uin", str3);
            intent.putExtra("uintype", 0);
            a16.startActivity(intent);
            if (QLog.isDevelopLevel()) {
                QLog.i("ConfessPlugin", 4, String.format(Locale.getDefault(), "handleOpenConfessRankAIO [chatType: %s, topicId: %s, confess: %s, toUin: %s, friendSex: %s , confessorSex: %s ,bg_type: %s, callback: %s, confessNum: %s, confessorUin: %s, confessorNick: %s, confessTime : %s]", Integer.valueOf(i3), Integer.valueOf(i17), str, str3, Integer.valueOf(optInt4), Integer.valueOf(i16), Integer.valueOf(optInt5), str2, Integer.valueOf(optInt3), str4, str5, Long.valueOf(optLong)));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessPlugin", 2, "handleOpenConfessRankAIO app is null  or activity is null!");
        }
    }

    private void x(JSONObject jSONObject) {
        Activity a16 = this.mRuntime.a();
        if (this.mRuntime.b() != null && a16 != null) {
            String str = "";
            String a17 = k.a(jSONObject.optString("groupUin", ""));
            int optInt = jSONObject.optInt("chatType");
            int optInt2 = jSONObject.optInt("topicId");
            String a18 = k.a(jSONObject.optString("confessorUin", ""));
            String a19 = k.a(jSONObject.optString("toUin", ""));
            String optString = jSONObject.optString("topic");
            int optInt3 = jSONObject.optInt("confessorSex");
            String optString2 = jSONObject.optString("confessToNick");
            long optLong = jSONObject.optLong("confessTime");
            int optInt4 = jSONObject.optInt("confessToNickType");
            if (jSONObject.has("confessorNick")) {
                str = jSONObject.optString("confessorNick");
            }
            String optString3 = jSONObject.optString("callback");
            if ((!ChatActivityUtils.P(a19) || !ChatActivityUtils.P(a18) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || optInt != 0) && !TextUtils.isEmpty(optString3)) {
                callJs(optString3, "invalidate params");
            }
            if (optInt == 0) {
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a16), null);
                m3.putExtra("open_chat_from_group_rec_confess", true);
                m3.putExtra(ConfessInfo.KEY_CONFESS_TOPICID, optInt2);
                m3.putExtra(ConfessInfo.KEY_CONFESS_DESC, optString);
                m3.putExtra(ConfessInfo.KEY_CONFESSOR_UIN, a18);
                if (TextUtils.isEmpty(str)) {
                    str = HardCodeUtil.qqStr(optInt3 == 1 ? R.string.kzg : R.string.kzj);
                }
                m3.putExtra(ConfessInfo.KEY_CONFESSOR_NICK, str);
                m3.putExtra(ConfessInfo.KEY_CONFESSOR_SEX, optInt3);
                m3.putExtra(ConfessInfo.KEY_CONFESS_BG_TYPE, optInt2 % 4);
                m3.putExtra(ConfessInfo.KEY_CONFESS_REC_NICK_NAME, optString2);
                m3.putExtra(ConfessInfo.KEY_CONFESS_REC_UIN, a19);
                m3.putExtra(ConfessInfo.KEY_CONFESS_TIME, optLong);
                m3.putExtra(ConfessInfo.KEY_CONFESS_REC_NICK_TYPE, optInt4);
                m3.putExtra("uin", a17);
                m3.putExtra("uintype", 1);
                a16.startActivity(m3);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessPlugin", 2, "handleOpenConfessAIO app is null  or activity is null!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[Catch: JSONException -> 0x00c3, TRY_ENTER, TryCatch #0 {JSONException -> 0x00c3, blocks: (B:3:0x0006, B:7:0x0012, B:9:0x0018, B:11:0x001e, B:15:0x002a, B:18:0x003f, B:19:0x0047, B:21:0x005c, B:23:0x0062, B:24:0x0071, B:27:0x0098, B:28:0x00a6, B:30:0x00ac, B:31:0x00b7, B:35:0x00a2), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac A[Catch: JSONException -> 0x00c3, TryCatch #0 {JSONException -> 0x00c3, blocks: (B:3:0x0006, B:7:0x0012, B:9:0x0018, B:11:0x001e, B:15:0x002a, B:18:0x003f, B:19:0x0047, B:21:0x005c, B:23:0x0062, B:24:0x0071, B:27:0x0098, B:28:0x00a6, B:30:0x00ac, B:31:0x00b7, B:35:0x00a2), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2 A[Catch: JSONException -> 0x00c3, TryCatch #0 {JSONException -> 0x00c3, blocks: (B:3:0x0006, B:7:0x0012, B:9:0x0018, B:11:0x001e, B:15:0x002a, B:18:0x003f, B:19:0x0047, B:21:0x005c, B:23:0x0062, B:24:0x0071, B:27:0x0098, B:28:0x00a6, B:30:0x00ac, B:31:0x00b7, B:35:0x00a2), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void t(List<String> list, List<String> list2) {
        JSONObject jSONObject;
        String str;
        String str2;
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (list != null && list2 != null) {
                for (int i3 = 0; i3 < list.size() && i3 < list2.size(); i3++) {
                    if (!TextUtils.isEmpty(list.get(i3))) {
                        String str3 = list.get(i3);
                        if (TextUtils.isEmpty(list2.get(i3))) {
                            str = "";
                        } else {
                            str = list2.get(i3);
                        }
                        jSONObject = new JSONObject();
                        jSONObject.put("uin", str3);
                        jSONObject.put("name", str);
                        WebViewPlugin.b bVar = this.mRuntime;
                        if (bVar == null || bVar.b() == null) {
                            str2 = "";
                        } else {
                            str2 = this.mRuntime.b().getCurrentAccountUin();
                        }
                        ReportController.o(null, "dc00898", "", "", "0X80092F7", "0X80092F7", 0, 0, "", "", str2, str3);
                        if (jSONObject == null) {
                            jSONObject2.put("retCode", 0);
                            jSONObject2.put(GuildMsgItem.NICK_FRIEND, jSONObject);
                        } else {
                            jSONObject2.put("retCode", -1);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("ConfessPlugin", 2, jSONObject2.toString());
                        }
                        doCallback(this.f202148i, jSONObject2.toString());
                        this.f202148i = null;
                    }
                }
            }
            jSONObject = null;
            if (jSONObject == null) {
            }
            if (QLog.isColorLevel()) {
            }
            doCallback(this.f202148i, jSONObject2.toString());
            this.f202148i = null;
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934593L) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfessPlugin", 1, "EVENT_LOAD_START");
            }
            QLog.e("ConfessPlugin", 1, "EVENT_LOAD_START");
        } else if (j3 == 8589934594L) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfessPlugin", 1, "EVENT_LOAD_FINISH");
            }
        } else if (j3 == 8589934595L) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfessPlugin", 1, "EVENT_LOAD_ERROR");
            }
        } else if (j3 == 8589934597L) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfessPlugin", 1, "EVENT_ACTIVITY_PAUSE");
            }
        } else if (j3 == 2 && QLog.isColorLevel()) {
            QLog.d("ConfessPlugin", 1, "KEY_EVENT_ACTIVITY_RESUME");
        }
        return super.handleEvent(str, j3, map);
    }
}
