package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.h;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.l;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.t;
import com.tencent.mobileqq.webviewplugin.u;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class VasCommonJsPlugin extends VasWebviewJsPlugin implements l {
    public static final String H5_CALLBACK_GETFRIENDINFO = "getFriendInfo";
    private static final String LOG_TAG_WEB = "WebQlog";
    public static final String PLUGIN_NAMESPACE_FRIEND_DATA = "friendData";
    public static final String PLUGIN_NAMESPACE_QW_DATA = "qw_data";
    public static final String PLUGIN_NAMESPACE_QW_DEBUG = "qw_debug";
    private static final String TAG = "VasCommonJsPlugin";
    private JsDebugDialog deBugDialog;
    protected String mCallback;
    protected ChooseFriendReceiver mChoFriReceiver;
    protected ChooseH5PTVReceiver mH5PTVReceiver;
    private y uiInterface;
    private int businessType = 0;
    private int businessSubType = 0;
    private String logicMethod = "";
    private List<String> logInfo = Collections.synchronizedList(new ArrayList());
    private boolean logStop = false;
    private boolean logShowTag = true;
    private final byte REQUEST_CODE_FRIENDS = 17;
    private Bundle mReqBundle = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String[] val$args;

        AnonymousClass1(String[] strArr) {
            this.val$args = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$run$0(JSONObject jSONObject, Integer num, String str) {
            String str2 = "callback";
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.put("code", num);
                    jSONObject2.put("msg", str);
                    VasCommonJsPlugin.super.callJs(jSONObject.optString("callback"), jSONObject2.toString());
                    return null;
                } catch (JSONException e16) {
                    QLog.e(VasCommonJsPlugin.TAG, 1, "error updating:" + e16);
                    String optString = jSONObject.optString("callback");
                    VasCommonJsPlugin vasCommonJsPlugin = VasCommonJsPlugin.this;
                    str2 = jSONObject2.toString();
                    VasCommonJsPlugin.super.callJs(optString, str2);
                    jSONObject = null;
                    return null;
                }
            } catch (Throwable th5) {
                VasCommonJsPlugin.super.callJs(jSONObject.optString(str2), jSONObject2.toString());
                throw th5;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final JSONObject jSONObject = new JSONObject(this.val$args[0]);
                String optString = jSONObject.optString("bundle_name");
                QLog.i(VasCommonJsPlugin.TAG, 1, "start kuiklyPreLoad name:" + optString);
                ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).preloadKuiklyResByRule(optString, new Function2() { // from class: com.tencent.mobileqq.vaswebviewplugin.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit lambda$run$0;
                        lambda$run$0 = VasCommonJsPlugin.AnonymousClass1.this.lambda$run$0(jSONObject, (Integer) obj, (String) obj2);
                        return lambda$run$0;
                    }
                });
            } catch (Exception e16) {
                QLog.e(VasCommonJsPlugin.TAG, 1, "kuiklyPreLoad exception:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes35.dex */
    public static class ChooseFriendReceiver extends ResultReceiver {
        private VasCommonJsPlugin mJsPlugin;

        public ChooseFriendReceiver(VasCommonJsPlugin vasCommonJsPlugin, Handler handler) {
            super(handler);
            this.mJsPlugin = vasCommonJsPlugin;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (i3 != 0 || bundle == null) {
                this.mJsPlugin.errorCallBack();
                return;
            }
            JSONObject jsBackJson = this.mJsPlugin.getJsBackJson(null, bundle.getStringArrayList("choose_friend_uins"), bundle.getStringArrayList("choose_friend_phones"), bundle.getStringArrayList("choose_friend_names"), null, bundle.getStringArrayList("choose_friend_group_uins"), bundle.getStringArrayList("choose_friend_group_names"), bundle.getIntegerArrayList("choose_friend_group_counts"), bundle.getIntegerArrayList("choose_friend_group_types"));
            if (jsBackJson != null) {
                JSONObject prosBLCallback = this.mJsPlugin.prosBLCallback(bundle, jsBackJson);
                VasCommonJsPlugin vasCommonJsPlugin = this.mJsPlugin;
                vasCommonJsPlugin.lambda$chooseFriends$0(vasCommonJsPlugin.mCallback, prosBLCallback.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes35.dex */
    public static class ChooseH5PTVReceiver extends ResultReceiver {
        private VasCommonJsPlugin mJsPlugin;

        public ChooseH5PTVReceiver(VasCommonJsPlugin vasCommonJsPlugin, Handler handler) {
            super(handler);
            this.mJsPlugin = vasCommonJsPlugin;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (i3 == 0 && bundle != null) {
                this.mJsPlugin.doChooseFriendResultForH5(bundle.getStringArrayList("choose_friend_uins"), bundle.getStringArrayList("choose_friend_phones"), bundle.getStringArrayList("choose_friend_names"), bundle.getStringArrayList("choose_friend_types"));
                return;
            }
            this.mJsPlugin.doChooseFriendResultForH5(null, null, null, null);
        }
    }

    private void H5chooseFriends(String str) {
        Context currentContext = getCurrentContext();
        if (currentContext != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("title", HardCodeUtil.qqStr(R.string.uxv));
                int optInt = jSONObject.optInt("type", 0);
                if (QLog.isColorLevel()) {
                    QLog.d("h5ptv", 2, "type=" + optInt);
                }
                this.mCallback = jSONObject.optString("callback");
                int intValue = Integer.valueOf(jSONObject.optString("limitNum", "0")).intValue();
                boolean booleanValue = Boolean.valueOf(jSONObject.optString("isMulti", "false")).booleanValue();
                boolean z16 = (optInt & 1) != 0;
                boolean z17 = (optInt & 2) != 0;
                if (this.mH5PTVReceiver == null) {
                    this.mH5PTVReceiver = new ChooseH5PTVReceiver(this, new Handler());
                }
                if (booleanValue) {
                    if (intValue < 1) {
                        errorCallBack();
                        return;
                    }
                    Intent startSelectMemberActivityIntentForJsPlugin = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin(currentContext);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_MAX, intValue);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
                    startSelectMemberActivityIntentForJsPlugin.addFlags(67108864);
                    super.startActivityForResult(startSelectMemberActivityIntentForJsPlugin, (byte) 17);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                this.mH5PTVReceiver.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
                Intent intent = new Intent(currentContext, (Class<?>) ForwardRecentActivity.class);
                intent.putExtra("forward_type", 25);
                intent.putExtra("choose_friend_title", optString);
                intent.putExtra("choose_friend_is_qqfriends", z16);
                intent.putExtra("choose_friend_is_contacts", z17);
                intent.putExtra("choose_friend_callback", resultReceiver);
                intent.putExtra("choose_friend_h5_type", optInt);
                super.startActivityForResult(intent, (byte) 17);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                doChooseFriendResultForH5(null, null, null, null);
                return;
            }
        }
        doChooseFriendResultForH5(null, null, null, null);
    }

    public static void debug(String str, final WebView webView) {
        try {
            final String str2 = "location.href=\"jsbridge://qw_debug/log?p=" + URLEncoder.encode("{\"msg\":\"nativeinfo==" + str + "\"}", "utf-8") + "\"";
            if (Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    webView.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + str2);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else {
                webView.post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.6
                    @Override // java.lang.Runnable
                    public void run() {
                        WebView webView2 = WebView.this;
                        if (webView2 != null) {
                            try {
                                webView2.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + str2);
                            } catch (Exception e17) {
                                e17.printStackTrace();
                            }
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doCallback, reason: merged with bridge method [inline-methods] */
    public void lambda$chooseFriends$0(String str, String str2) {
        QLog.i(TAG, 2, "doCallback: " + str + " js: " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        super.callJs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorCallBack() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", "-1");
            jSONObject.put("msg", "error, parameters wrong...");
        } catch (JSONException unused) {
        }
        QLog.i(TAG, 2, "errorCallBack: " + jSONObject);
        lambda$chooseFriends$0(this.mCallback, jSONObject.toString());
    }

    private Context getCurrentContext() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(62:22|(3:203|204|(60:206|25|26|27|28|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|(3:54|55|56)(1:164)|(4:58|59|60|61)(1:160)|62|63|(3:146|147|(28:149|66|67|68|69|70|71|72|73|74|75|76|77|78|(0)(0)|81|(0)(0)|84|(0)|87|(0)|90|(0)|93|(0)|(0)|106|(0)(0)))|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(0)(0)|81|(0)(0)|84|(0)|87|(0)|90|(0)|93|(0)|(0)|106|(0)(0)))|24|25|26|27|28|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|(0)(0)|(0)(0)|62|63|(0)|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(0)(0)|81|(0)(0)|84|(0)|87|(0)|90|(0)|93|(0)|(0)|106|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0366, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0367, code lost:
    
        r22 = r0;
        r0 = r10;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0373, code lost:
    
        r45 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x037e, code lost:
    
        r41 = r37;
        r37 = r35;
        r35 = r5;
        r33 = r5;
        r31 = r5;
        r29 = r5;
        r27 = r11;
        r12 = r13;
        r14 = r15;
        r15 = r5;
        r10 = r5;
        r43 = r39;
        r39 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x036d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x036e, code lost:
    
        r22 = r0;
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0376, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0377, code lost:
    
        r22 = r0;
        r0 = r10;
        r45 = r41;
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0398, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0399, code lost:
    
        r22 = r0;
        r0 = r10;
        r43 = r39;
        r45 = r41;
        r5 = -1;
        r39 = 0;
        r41 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03a8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x03a9, code lost:
    
        r22 = r0;
        r0 = r10;
        r41 = r37;
        r43 = r39;
        r5 = -1;
        r7 = false;
        r39 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03b7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03b8, code lost:
    
        r22 = r0;
        r0 = r10;
        r35 = r5;
        r5 = -1;
        r7 = false;
        r37 = -1;
        r39 = -1;
        r41 = -1;
        r43 = -1;
        r45 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03cd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03ce, code lost:
    
        r22 = r0;
        r0 = r10;
        r33 = r5;
        r5 = -1;
        r7 = false;
        r35 = -1;
        r37 = -1;
        r39 = -1;
        r41 = -1;
        r43 = -1;
        r45 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03e5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03e6, code lost:
    
        r22 = r0;
        r0 = r10;
        r31 = r5;
        r5 = -1;
        r7 = false;
        r33 = -1;
        r35 = -1;
        r37 = -1;
        r39 = -1;
        r41 = -1;
        r43 = -1;
        r45 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03ff, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0400, code lost:
    
        r22 = r0;
        r0 = r10;
        r29 = r5;
        r5 = -1;
        r7 = false;
        r31 = -1;
        r33 = -1;
        r35 = -1;
        r37 = -1;
        r39 = -1;
        r41 = -1;
        r43 = -1;
        r45 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0422, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0423, code lost:
    
        r22 = r0;
        r0 = r10;
        r27 = r11;
        r12 = r13;
        r14 = r15;
        r15 = r5;
        r5 = -1;
        r7 = false;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0433, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0434, code lost:
    
        r25 = r6;
        r22 = r0;
        r0 = r10;
        r12 = r13;
        r14 = r15;
        r15 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0441, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0442, code lost:
    
        r22 = r0;
        r0 = r10;
        r12 = r13;
        r14 = r15;
        r15 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x044d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x044e, code lost:
    
        r22 = r0;
        r0 = r10;
        r12 = r13;
        r14 = r15;
        r15 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0459, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x045a, code lost:
    
        r22 = r0;
        r12 = r13;
        r14 = r15;
        r15 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0464, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0465, code lost:
    
        r22 = r0;
        r12 = r13;
        r14 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0302 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x065f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getPerformance(JSONObject jSONObject, WebView webView) throws JSONException {
        Exception exc;
        boolean z16;
        long j3;
        boolean z17;
        long j16;
        long j17;
        long j18;
        boolean isMainPageUseLocalFile;
        boolean z18;
        long j19;
        long j26;
        long j27;
        long j28;
        long j29;
        long j36;
        long j37;
        long j38;
        long j39;
        long j46;
        long j47;
        long j48;
        long j49;
        long j56;
        long j57;
        long j58;
        long j59;
        long j65;
        long j66;
        long j67;
        long openUrlAfterCheckOfflineTime;
        long readIndexFromOfflineTime;
        long detect302Time;
        boolean isReloadUrl;
        boolean z19;
        long j68;
        long j69;
        long j75;
        long j76;
        long j77;
        long j78;
        long j79;
        long j85;
        long j86;
        long j87;
        long j88;
        long j89;
        String str;
        long j95;
        long j96;
        long j97;
        long j98;
        long j99;
        long j100;
        long j101;
        long j102;
        long j103;
        long j104;
        long j105;
        long j106;
        boolean z26;
        int i3;
        long j107;
        boolean z27;
        long j108;
        long j109;
        long j110;
        long j111;
        String str2;
        String str3;
        boolean z28;
        OfflinePlugin offlinePlugin;
        long j112;
        OfflinePlugin offlinePlugin2;
        long j113;
        long j114;
        long j115;
        long j116;
        WebViewPlugin m3;
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        QLog.i(TAG, 2, "baseInterface = " + d16);
        if (d16 == null && (this.mRuntime.b() instanceof x05.a)) {
            QLog.i(TAG, 2, "start check if plugin has WebviewReportSpeedInterface interface...");
            x05.a aVar = (x05.a) this.mRuntime.b();
            if (aVar.d0() instanceof y) {
                QLog.i(TAG, 2, "plugin has interface for getPerformance...");
                d16 = (y) aVar.d0();
            }
        }
        y yVar = this.uiInterface;
        if (yVar == null) {
            yVar = d16;
        }
        if (yVar != null) {
            try {
            } catch (Exception e16) {
                exc = e16;
                z16 = false;
                j3 = -1;
                z17 = false;
                j16 = -1;
                j17 = 0;
                j18 = -1;
                isMainPageUseLocalFile = false;
                z18 = true;
                j27 = -1;
                j29 = -1;
                j36 = -1;
                j37 = -1;
                j38 = -1;
                j39 = -1;
                j46 = -1;
                j47 = -1;
                j48 = -1;
                j49 = -1;
                j56 = -1;
                exc.printStackTrace();
                str = TAG;
                j95 = j37;
                j96 = j38;
                j97 = j39;
                j98 = j46;
                j99 = j47;
                j100 = j48;
                j101 = j49;
                j102 = j56;
                boolean z29 = z17;
                z19 = z16;
                isReloadUrl = z29;
                j103 = j36;
                j104 = j3;
                long j117 = j17;
                j105 = j29;
                j106 = j117;
                if (yVar instanceof t) {
                }
                if (j27 == -1) {
                }
                jSONObject.put("clickStart", j16);
                jSONObject.put("pageStart", j108);
                long j118 = j108;
                jSONObject.put("pageFinish", this.onPageFinishedTime);
                jSONObject.put("webviewStart", j18);
                jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                jSONObject.put("isFirstRequest", z18);
                jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                jSONObject.put("isWebViewCache", z19);
                jSONObject.put("onCreate", j105);
                jSONObject.put("viewInflate", j107);
                jSONObject.put("getWebView", j95);
                jSONObject.put("initBrowser", j96);
                jSONObject.put("init", j97);
                jSONObject.put("initTBS", j98);
                jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                jSONObject.put("nonWhiteScreen", j104);
                jSONObject.put("initWebViewTime", j106);
                jSONObject.put("isDirectAddress", false);
                StringBuilder sb5 = new StringBuilder("speed data:");
                sb5.append("clickStartTime = " + j16);
                sb5.append("webviewStartTime = " + j18);
                sb5.append("pageStartTime = " + j118);
                sb5.append("click to create :" + (j18 - j16));
                sb5.append(", create to loadUrl : " + (j118 - j18));
                QLog.d(str, 1, sb5.toString());
                j109 = j100;
                if (j109 > 0) {
                }
                j110 = j101;
                if (j110 > 0) {
                }
                j111 = j102;
                if (j111 > 0) {
                }
                jSONObject.put("isReloadUrl", isReloadUrl);
                if (i3 > 0) {
                }
                if (webView != null) {
                }
                if (QLog.isColorLevel()) {
                }
            }
            if (yVar instanceof u) {
                j18 = ((u) yVar).getmOnCreateMilliTimeStamp();
                try {
                    isMainPageUseLocalFile = ((u) yVar).isMainPageUseLocalFile();
                } catch (Exception e17) {
                    exc = e17;
                    z16 = false;
                    j3 = -1;
                    z17 = false;
                    j16 = -1;
                    j17 = 0;
                    isMainPageUseLocalFile = false;
                    z18 = true;
                    j27 = -1;
                    j29 = -1;
                    j36 = -1;
                    j37 = -1;
                    j38 = -1;
                    j39 = -1;
                    j46 = -1;
                    j47 = -1;
                    j48 = -1;
                    j49 = -1;
                    j56 = -1;
                    exc.printStackTrace();
                    str = TAG;
                    j95 = j37;
                    j96 = j38;
                    j97 = j39;
                    j98 = j46;
                    j99 = j47;
                    j100 = j48;
                    j101 = j49;
                    j102 = j56;
                    boolean z292 = z17;
                    z19 = z16;
                    isReloadUrl = z292;
                    j103 = j36;
                    j104 = j3;
                    long j1172 = j17;
                    j105 = j29;
                    j106 = j1172;
                    if (yVar instanceof t) {
                    }
                    if (j27 == -1) {
                    }
                    jSONObject.put("clickStart", j16);
                    jSONObject.put("pageStart", j108);
                    long j1182 = j108;
                    jSONObject.put("pageFinish", this.onPageFinishedTime);
                    jSONObject.put("webviewStart", j18);
                    jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                    jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                    jSONObject.put("isFirstRequest", z18);
                    jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                    jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                    jSONObject.put("isWebViewCache", z19);
                    jSONObject.put("onCreate", j105);
                    jSONObject.put("viewInflate", j107);
                    jSONObject.put("getWebView", j95);
                    jSONObject.put("initBrowser", j96);
                    jSONObject.put("init", j97);
                    jSONObject.put("initTBS", j98);
                    jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                    jSONObject.put("nonWhiteScreen", j104);
                    jSONObject.put("initWebViewTime", j106);
                    jSONObject.put("isDirectAddress", false);
                    StringBuilder sb52 = new StringBuilder("speed data:");
                    sb52.append("clickStartTime = " + j16);
                    sb52.append("webviewStartTime = " + j18);
                    sb52.append("pageStartTime = " + j1182);
                    sb52.append("click to create :" + (j18 - j16));
                    sb52.append(", create to loadUrl : " + (j1182 - j18));
                    QLog.d(str, 1, sb52.toString());
                    j109 = j100;
                    if (j109 > 0) {
                    }
                    j110 = j101;
                    if (j110 > 0) {
                    }
                    j111 = j102;
                    if (j111 > 0) {
                    }
                    jSONObject.put("isReloadUrl", isReloadUrl);
                    if (i3 > 0) {
                    }
                    if (webView != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                }
                try {
                    z18 = ((u) yVar).getmPerfFirstLoadTag();
                } catch (Exception e18) {
                    exc = e18;
                    z16 = false;
                    j3 = -1;
                    z17 = false;
                    j16 = -1;
                    j17 = 0;
                    z18 = true;
                    j27 = -1;
                    j29 = -1;
                    j36 = -1;
                    j37 = -1;
                    j38 = -1;
                    j39 = -1;
                    j46 = -1;
                    j47 = -1;
                    j48 = -1;
                    j49 = -1;
                    j56 = -1;
                    exc.printStackTrace();
                    str = TAG;
                    j95 = j37;
                    j96 = j38;
                    j97 = j39;
                    j98 = j46;
                    j99 = j47;
                    j100 = j48;
                    j101 = j49;
                    j102 = j56;
                    boolean z2922 = z17;
                    z19 = z16;
                    isReloadUrl = z2922;
                    j103 = j36;
                    j104 = j3;
                    long j11722 = j17;
                    j105 = j29;
                    j106 = j11722;
                    if (yVar instanceof t) {
                    }
                    if (j27 == -1) {
                    }
                    jSONObject.put("clickStart", j16);
                    jSONObject.put("pageStart", j108);
                    long j11822 = j108;
                    jSONObject.put("pageFinish", this.onPageFinishedTime);
                    jSONObject.put("webviewStart", j18);
                    jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                    jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                    jSONObject.put("isFirstRequest", z18);
                    jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                    jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                    jSONObject.put("isWebViewCache", z19);
                    jSONObject.put("onCreate", j105);
                    jSONObject.put("viewInflate", j107);
                    jSONObject.put("getWebView", j95);
                    jSONObject.put("initBrowser", j96);
                    jSONObject.put("init", j97);
                    jSONObject.put("initTBS", j98);
                    jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                    jSONObject.put("nonWhiteScreen", j104);
                    jSONObject.put("initWebViewTime", j106);
                    jSONObject.put("isDirectAddress", false);
                    StringBuilder sb522 = new StringBuilder("speed data:");
                    sb522.append("clickStartTime = " + j16);
                    sb522.append("webviewStartTime = " + j18);
                    sb522.append("pageStartTime = " + j11822);
                    sb522.append("click to create :" + (j18 - j16));
                    sb522.append(", create to loadUrl : " + (j11822 - j18));
                    QLog.d(str, 1, sb522.toString());
                    j109 = j100;
                    if (j109 > 0) {
                    }
                    j110 = j101;
                    if (j110 > 0) {
                    }
                    j111 = j102;
                    if (j111 > 0) {
                    }
                    jSONObject.put("isReloadUrl", isReloadUrl);
                    if (i3 > 0) {
                    }
                    if (webView != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                }
                try {
                    boolean z36 = ((u) yVar).getisWebViewCache();
                    try {
                        j19 = ((u) yVar).getmClickTime();
                    } catch (Exception e19) {
                        exc = e19;
                        z16 = z36;
                        j3 = -1;
                        z17 = false;
                        j16 = -1;
                        j17 = 0;
                        j27 = -1;
                        j29 = -1;
                        j36 = -1;
                        j37 = -1;
                        j38 = -1;
                        j39 = -1;
                        j46 = -1;
                        j47 = -1;
                        j48 = -1;
                        j49 = -1;
                        j56 = -1;
                        exc.printStackTrace();
                        str = TAG;
                        j95 = j37;
                        j96 = j38;
                        j97 = j39;
                        j98 = j46;
                        j99 = j47;
                        j100 = j48;
                        j101 = j49;
                        j102 = j56;
                        boolean z29222 = z17;
                        z19 = z16;
                        isReloadUrl = z29222;
                        j103 = j36;
                        j104 = j3;
                        long j117222 = j17;
                        j105 = j29;
                        j106 = j117222;
                        if (yVar instanceof t) {
                        }
                        if (j27 == -1) {
                        }
                        jSONObject.put("clickStart", j16);
                        jSONObject.put("pageStart", j108);
                        long j118222 = j108;
                        jSONObject.put("pageFinish", this.onPageFinishedTime);
                        jSONObject.put("webviewStart", j18);
                        jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                        jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                        jSONObject.put("isFirstRequest", z18);
                        jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                        jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                        jSONObject.put("isWebViewCache", z19);
                        jSONObject.put("onCreate", j105);
                        jSONObject.put("viewInflate", j107);
                        jSONObject.put("getWebView", j95);
                        jSONObject.put("initBrowser", j96);
                        jSONObject.put("init", j97);
                        jSONObject.put("initTBS", j98);
                        jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                        jSONObject.put("nonWhiteScreen", j104);
                        jSONObject.put("initWebViewTime", j106);
                        jSONObject.put("isDirectAddress", false);
                        StringBuilder sb5222 = new StringBuilder("speed data:");
                        sb5222.append("clickStartTime = " + j16);
                        sb5222.append("webviewStartTime = " + j18);
                        sb5222.append("pageStartTime = " + j118222);
                        sb5222.append("click to create :" + (j18 - j16));
                        sb5222.append(", create to loadUrl : " + (j118222 - j18));
                        QLog.d(str, 1, sb5222.toString());
                        j109 = j100;
                        if (j109 > 0) {
                        }
                        j110 = j101;
                        if (j110 > 0) {
                        }
                        j111 = j102;
                        if (j111 > 0) {
                        }
                        jSONObject.put("isReloadUrl", isReloadUrl);
                        if (i3 > 0) {
                        }
                        if (webView != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                    try {
                        j26 = ((u) yVar).getmTimeBeforeLoadUrl();
                        try {
                            j28 = ((u) yVar).getonCreateTime();
                            try {
                                j57 = ((u) yVar).getviewInflateTime();
                                try {
                                    j58 = ((u) yVar).getgetWebViewTime();
                                    try {
                                        j59 = ((u) yVar).getinitBrowserTime();
                                        try {
                                            j65 = ((u) yVar).getinitTime();
                                            try {
                                                j66 = ((u) yVar).getinitTBSTime();
                                                try {
                                                    j67 = ((u) yVar).getpluginFinished();
                                                    try {
                                                        openUrlAfterCheckOfflineTime = ((u) yVar).getOpenUrlAfterCheckOfflineTime();
                                                    } catch (Exception e26) {
                                                        e = e26;
                                                        j16 = j19;
                                                        j39 = j65;
                                                        j46 = j66;
                                                        j47 = j67;
                                                        j3 = -1;
                                                        z17 = false;
                                                        j17 = 0;
                                                        j48 = -1;
                                                        j49 = -1;
                                                        j56 = -1;
                                                    }
                                                } catch (Exception e27) {
                                                    e = e27;
                                                    j16 = j19;
                                                    j38 = j59;
                                                    j39 = j65;
                                                    j46 = j66;
                                                    j3 = -1;
                                                    z17 = false;
                                                    j17 = 0;
                                                    j47 = -1;
                                                    j48 = -1;
                                                    j49 = -1;
                                                    j56 = -1;
                                                }
                                                try {
                                                    readIndexFromOfflineTime = ((u) yVar).getReadIndexFromOfflineTime();
                                                    try {
                                                        detect302Time = ((u) yVar).getDetect302Time();
                                                    } catch (Exception e28) {
                                                        e = e28;
                                                        j16 = j19;
                                                        j47 = j67;
                                                        j48 = openUrlAfterCheckOfflineTime;
                                                        j49 = readIndexFromOfflineTime;
                                                        j3 = -1;
                                                        z17 = false;
                                                        j17 = 0;
                                                        j56 = -1;
                                                        j38 = j59;
                                                        j39 = j65;
                                                        j46 = j66;
                                                        j29 = j28;
                                                        j36 = j57;
                                                        j37 = j58;
                                                        exc = e;
                                                        z16 = z36;
                                                        j27 = j26;
                                                        exc.printStackTrace();
                                                        str = TAG;
                                                        j95 = j37;
                                                        j96 = j38;
                                                        j97 = j39;
                                                        j98 = j46;
                                                        j99 = j47;
                                                        j100 = j48;
                                                        j101 = j49;
                                                        j102 = j56;
                                                        boolean z292222 = z17;
                                                        z19 = z16;
                                                        isReloadUrl = z292222;
                                                        j103 = j36;
                                                        j104 = j3;
                                                        long j1172222 = j17;
                                                        j105 = j29;
                                                        j106 = j1172222;
                                                        if (yVar instanceof t) {
                                                        }
                                                        if (j27 == -1) {
                                                        }
                                                        jSONObject.put("clickStart", j16);
                                                        jSONObject.put("pageStart", j108);
                                                        long j1182222 = j108;
                                                        jSONObject.put("pageFinish", this.onPageFinishedTime);
                                                        jSONObject.put("webviewStart", j18);
                                                        jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                                                        jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                                                        jSONObject.put("isFirstRequest", z18);
                                                        jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                                                        jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                                                        jSONObject.put("isWebViewCache", z19);
                                                        jSONObject.put("onCreate", j105);
                                                        jSONObject.put("viewInflate", j107);
                                                        jSONObject.put("getWebView", j95);
                                                        jSONObject.put("initBrowser", j96);
                                                        jSONObject.put("init", j97);
                                                        jSONObject.put("initTBS", j98);
                                                        jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                                                        jSONObject.put("nonWhiteScreen", j104);
                                                        jSONObject.put("initWebViewTime", j106);
                                                        jSONObject.put("isDirectAddress", false);
                                                        StringBuilder sb52222 = new StringBuilder("speed data:");
                                                        sb52222.append("clickStartTime = " + j16);
                                                        sb52222.append("webviewStartTime = " + j18);
                                                        sb52222.append("pageStartTime = " + j1182222);
                                                        sb52222.append("click to create :" + (j18 - j16));
                                                        sb52222.append(", create to loadUrl : " + (j1182222 - j18));
                                                        QLog.d(str, 1, sb52222.toString());
                                                        j109 = j100;
                                                        if (j109 > 0) {
                                                        }
                                                        j110 = j101;
                                                        if (j110 > 0) {
                                                        }
                                                        j111 = j102;
                                                        if (j111 > 0) {
                                                        }
                                                        jSONObject.put("isReloadUrl", isReloadUrl);
                                                        if (i3 > 0) {
                                                        }
                                                        if (webView != null) {
                                                        }
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                    }
                                                } catch (Exception e29) {
                                                    e = e29;
                                                    j16 = j19;
                                                    j46 = j66;
                                                    j47 = j67;
                                                    j48 = openUrlAfterCheckOfflineTime;
                                                    j3 = -1;
                                                    z17 = false;
                                                    j17 = 0;
                                                    j49 = -1;
                                                    j56 = -1;
                                                    j37 = j58;
                                                    j38 = j59;
                                                    j39 = j65;
                                                    j27 = j26;
                                                    j29 = j28;
                                                    j36 = j57;
                                                    exc = e;
                                                    z16 = z36;
                                                    exc.printStackTrace();
                                                    str = TAG;
                                                    j95 = j37;
                                                    j96 = j38;
                                                    j97 = j39;
                                                    j98 = j46;
                                                    j99 = j47;
                                                    j100 = j48;
                                                    j101 = j49;
                                                    j102 = j56;
                                                    boolean z2922222 = z17;
                                                    z19 = z16;
                                                    isReloadUrl = z2922222;
                                                    j103 = j36;
                                                    j104 = j3;
                                                    long j11722222 = j17;
                                                    j105 = j29;
                                                    j106 = j11722222;
                                                    if (yVar instanceof t) {
                                                    }
                                                    if (j27 == -1) {
                                                    }
                                                    jSONObject.put("clickStart", j16);
                                                    jSONObject.put("pageStart", j108);
                                                    long j11822222 = j108;
                                                    jSONObject.put("pageFinish", this.onPageFinishedTime);
                                                    jSONObject.put("webviewStart", j18);
                                                    jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                                                    jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                                                    jSONObject.put("isFirstRequest", z18);
                                                    jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                                                    jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                                                    jSONObject.put("isWebViewCache", z19);
                                                    jSONObject.put("onCreate", j105);
                                                    jSONObject.put("viewInflate", j107);
                                                    jSONObject.put("getWebView", j95);
                                                    jSONObject.put("initBrowser", j96);
                                                    jSONObject.put("init", j97);
                                                    jSONObject.put("initTBS", j98);
                                                    jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                                                    jSONObject.put("nonWhiteScreen", j104);
                                                    jSONObject.put("initWebViewTime", j106);
                                                    jSONObject.put("isDirectAddress", false);
                                                    StringBuilder sb522222 = new StringBuilder("speed data:");
                                                    sb522222.append("clickStartTime = " + j16);
                                                    sb522222.append("webviewStartTime = " + j18);
                                                    sb522222.append("pageStartTime = " + j11822222);
                                                    sb522222.append("click to create :" + (j18 - j16));
                                                    sb522222.append(", create to loadUrl : " + (j11822222 - j18));
                                                    QLog.d(str, 1, sb522222.toString());
                                                    j109 = j100;
                                                    if (j109 > 0) {
                                                    }
                                                    j110 = j101;
                                                    if (j110 > 0) {
                                                    }
                                                    j111 = j102;
                                                    if (j111 > 0) {
                                                    }
                                                    jSONObject.put("isReloadUrl", isReloadUrl);
                                                    if (i3 > 0) {
                                                    }
                                                    if (webView != null) {
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                }
                                            } catch (Exception e36) {
                                                e = e36;
                                                j16 = j19;
                                                j37 = j58;
                                                j38 = j59;
                                                j39 = j65;
                                                j3 = -1;
                                                z17 = false;
                                                j17 = 0;
                                                j46 = -1;
                                                j47 = -1;
                                                j48 = -1;
                                                j49 = -1;
                                                j56 = -1;
                                            }
                                        } catch (Exception e37) {
                                            e = e37;
                                            j16 = j19;
                                            j36 = j57;
                                            j37 = j58;
                                            j38 = j59;
                                            j3 = -1;
                                            z17 = false;
                                            j17 = 0;
                                            j39 = -1;
                                            j46 = -1;
                                            j47 = -1;
                                            j48 = -1;
                                            j49 = -1;
                                            j56 = -1;
                                        }
                                    } catch (Exception e38) {
                                        e = e38;
                                        j16 = j19;
                                        j29 = j28;
                                        j36 = j57;
                                        j37 = j58;
                                        j3 = -1;
                                        z17 = false;
                                        j17 = 0;
                                        j38 = -1;
                                        j39 = -1;
                                        j46 = -1;
                                        j47 = -1;
                                        j48 = -1;
                                        j49 = -1;
                                        j56 = -1;
                                    }
                                } catch (Exception e39) {
                                    e = e39;
                                    j16 = j19;
                                    j27 = j26;
                                    j29 = j28;
                                    j36 = j57;
                                    j3 = -1;
                                    z17 = false;
                                    j17 = 0;
                                    j37 = -1;
                                    j38 = -1;
                                    j39 = -1;
                                    j46 = -1;
                                    j47 = -1;
                                    j48 = -1;
                                    j49 = -1;
                                    j56 = -1;
                                    exc = e;
                                    z16 = z36;
                                    exc.printStackTrace();
                                    str = TAG;
                                    j95 = j37;
                                    j96 = j38;
                                    j97 = j39;
                                    j98 = j46;
                                    j99 = j47;
                                    j100 = j48;
                                    j101 = j49;
                                    j102 = j56;
                                    boolean z29222222 = z17;
                                    z19 = z16;
                                    isReloadUrl = z29222222;
                                    j103 = j36;
                                    j104 = j3;
                                    long j117222222 = j17;
                                    j105 = j29;
                                    j106 = j117222222;
                                    if (yVar instanceof t) {
                                    }
                                    if (j27 == -1) {
                                    }
                                    jSONObject.put("clickStart", j16);
                                    jSONObject.put("pageStart", j108);
                                    long j118222222 = j108;
                                    jSONObject.put("pageFinish", this.onPageFinishedTime);
                                    jSONObject.put("webviewStart", j18);
                                    jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                                    jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                                    jSONObject.put("isFirstRequest", z18);
                                    jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                                    jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                                    jSONObject.put("isWebViewCache", z19);
                                    jSONObject.put("onCreate", j105);
                                    jSONObject.put("viewInflate", j107);
                                    jSONObject.put("getWebView", j95);
                                    jSONObject.put("initBrowser", j96);
                                    jSONObject.put("init", j97);
                                    jSONObject.put("initTBS", j98);
                                    jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                                    jSONObject.put("nonWhiteScreen", j104);
                                    jSONObject.put("initWebViewTime", j106);
                                    jSONObject.put("isDirectAddress", false);
                                    StringBuilder sb5222222 = new StringBuilder("speed data:");
                                    sb5222222.append("clickStartTime = " + j16);
                                    sb5222222.append("webviewStartTime = " + j18);
                                    sb5222222.append("pageStartTime = " + j118222222);
                                    sb5222222.append("click to create :" + (j18 - j16));
                                    sb5222222.append(", create to loadUrl : " + (j118222222 - j18));
                                    QLog.d(str, 1, sb5222222.toString());
                                    j109 = j100;
                                    if (j109 > 0) {
                                    }
                                    j110 = j101;
                                    if (j110 > 0) {
                                    }
                                    j111 = j102;
                                    if (j111 > 0) {
                                    }
                                    jSONObject.put("isReloadUrl", isReloadUrl);
                                    if (i3 > 0) {
                                    }
                                    if (webView != null) {
                                    }
                                    if (QLog.isColorLevel()) {
                                    }
                                }
                            } catch (Exception e46) {
                                e = e46;
                                j16 = j19;
                                j27 = j26;
                                j29 = j28;
                                j3 = -1;
                                z17 = false;
                                j17 = 0;
                                j36 = -1;
                            }
                        } catch (Exception e47) {
                            exc = e47;
                            z16 = z36;
                            j16 = j19;
                            j27 = j26;
                            j3 = -1;
                            z17 = false;
                            j17 = 0;
                            j29 = -1;
                            j36 = -1;
                            j37 = -1;
                            j38 = -1;
                            j39 = -1;
                            j46 = -1;
                            j47 = -1;
                            j48 = -1;
                            j49 = -1;
                            j56 = -1;
                            exc.printStackTrace();
                            str = TAG;
                            j95 = j37;
                            j96 = j38;
                            j97 = j39;
                            j98 = j46;
                            j99 = j47;
                            j100 = j48;
                            j101 = j49;
                            j102 = j56;
                            boolean z292222222 = z17;
                            z19 = z16;
                            isReloadUrl = z292222222;
                            j103 = j36;
                            j104 = j3;
                            long j1172222222 = j17;
                            j105 = j29;
                            j106 = j1172222222;
                            if (yVar instanceof t) {
                            }
                            if (j27 == -1) {
                            }
                            jSONObject.put("clickStart", j16);
                            jSONObject.put("pageStart", j108);
                            long j1182222222 = j108;
                            jSONObject.put("pageFinish", this.onPageFinishedTime);
                            jSONObject.put("webviewStart", j18);
                            jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                            jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                            jSONObject.put("isFirstRequest", z18);
                            jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                            jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                            jSONObject.put("isWebViewCache", z19);
                            jSONObject.put("onCreate", j105);
                            jSONObject.put("viewInflate", j107);
                            jSONObject.put("getWebView", j95);
                            jSONObject.put("initBrowser", j96);
                            jSONObject.put("init", j97);
                            jSONObject.put("initTBS", j98);
                            jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                            jSONObject.put("nonWhiteScreen", j104);
                            jSONObject.put("initWebViewTime", j106);
                            jSONObject.put("isDirectAddress", false);
                            StringBuilder sb52222222 = new StringBuilder("speed data:");
                            sb52222222.append("clickStartTime = " + j16);
                            sb52222222.append("webviewStartTime = " + j18);
                            sb52222222.append("pageStartTime = " + j1182222222);
                            sb52222222.append("click to create :" + (j18 - j16));
                            sb52222222.append(", create to loadUrl : " + (j1182222222 - j18));
                            QLog.d(str, 1, sb52222222.toString());
                            j109 = j100;
                            if (j109 > 0) {
                            }
                            j110 = j101;
                            if (j110 > 0) {
                            }
                            j111 = j102;
                            if (j111 > 0) {
                            }
                            jSONObject.put("isReloadUrl", isReloadUrl);
                            if (i3 > 0) {
                            }
                            if (webView != null) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } catch (Exception e48) {
                        exc = e48;
                        z16 = z36;
                        j16 = j19;
                        j3 = -1;
                        z17 = false;
                        j17 = 0;
                        j27 = -1;
                        j29 = -1;
                        j36 = -1;
                        j37 = -1;
                        j38 = -1;
                        j39 = -1;
                        j46 = -1;
                        j47 = -1;
                        j48 = -1;
                        j49 = -1;
                        j56 = -1;
                        exc.printStackTrace();
                        str = TAG;
                        j95 = j37;
                        j96 = j38;
                        j97 = j39;
                        j98 = j46;
                        j99 = j47;
                        j100 = j48;
                        j101 = j49;
                        j102 = j56;
                        boolean z2922222222 = z17;
                        z19 = z16;
                        isReloadUrl = z2922222222;
                        j103 = j36;
                        j104 = j3;
                        long j11722222222 = j17;
                        j105 = j29;
                        j106 = j11722222222;
                        if (yVar instanceof t) {
                        }
                        if (j27 == -1) {
                        }
                        jSONObject.put("clickStart", j16);
                        jSONObject.put("pageStart", j108);
                        long j11822222222 = j108;
                        jSONObject.put("pageFinish", this.onPageFinishedTime);
                        jSONObject.put("webviewStart", j18);
                        jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                        jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                        jSONObject.put("isFirstRequest", z18);
                        jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                        jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                        jSONObject.put("isWebViewCache", z19);
                        jSONObject.put("onCreate", j105);
                        jSONObject.put("viewInflate", j107);
                        jSONObject.put("getWebView", j95);
                        jSONObject.put("initBrowser", j96);
                        jSONObject.put("init", j97);
                        jSONObject.put("initTBS", j98);
                        jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                        jSONObject.put("nonWhiteScreen", j104);
                        jSONObject.put("initWebViewTime", j106);
                        jSONObject.put("isDirectAddress", false);
                        StringBuilder sb522222222 = new StringBuilder("speed data:");
                        sb522222222.append("clickStartTime = " + j16);
                        sb522222222.append("webviewStartTime = " + j18);
                        sb522222222.append("pageStartTime = " + j11822222222);
                        sb522222222.append("click to create :" + (j18 - j16));
                        sb522222222.append(", create to loadUrl : " + (j11822222222 - j18));
                        QLog.d(str, 1, sb522222222.toString());
                        j109 = j100;
                        if (j109 > 0) {
                        }
                        j110 = j101;
                        if (j110 > 0) {
                        }
                        j111 = j102;
                        if (j111 > 0) {
                        }
                        jSONObject.put("isReloadUrl", isReloadUrl);
                        if (i3 > 0) {
                        }
                        if (webView != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                    try {
                        isReloadUrl = ((u) yVar).getIsReloadUrl();
                        z19 = z36;
                        j16 = j19;
                        j68 = openUrlAfterCheckOfflineTime;
                        j69 = readIndexFromOfflineTime;
                        j75 = detect302Time;
                        j76 = -1;
                        j77 = 0;
                        j78 = j65;
                        j79 = j66;
                        j85 = j67;
                        j86 = j57;
                        j87 = j58;
                        j88 = j59;
                        j27 = j26;
                        j89 = j28;
                        str = TAG;
                        j95 = j87;
                        j96 = j88;
                        j97 = j78;
                        j98 = j79;
                        j99 = j85;
                        j100 = j68;
                        j101 = j69;
                        j102 = j75;
                        j103 = j86;
                        j104 = j76;
                        long j119 = j77;
                        j105 = j89;
                        j106 = j119;
                    } catch (Exception e49) {
                        e = e49;
                        j16 = j19;
                        j48 = openUrlAfterCheckOfflineTime;
                        j49 = readIndexFromOfflineTime;
                        j56 = detect302Time;
                        j3 = -1;
                        z17 = false;
                        j17 = 0;
                        j39 = j65;
                        j46 = j66;
                        j47 = j67;
                        j36 = j57;
                        j37 = j58;
                        j38 = j59;
                        j27 = j26;
                        j29 = j28;
                        exc = e;
                        z16 = z36;
                        exc.printStackTrace();
                        str = TAG;
                        j95 = j37;
                        j96 = j38;
                        j97 = j39;
                        j98 = j46;
                        j99 = j47;
                        j100 = j48;
                        j101 = j49;
                        j102 = j56;
                        boolean z29222222222 = z17;
                        z19 = z16;
                        isReloadUrl = z29222222222;
                        j103 = j36;
                        j104 = j3;
                        long j117222222222 = j17;
                        j105 = j29;
                        j106 = j117222222222;
                        if (yVar instanceof t) {
                        }
                        if (j27 == -1) {
                        }
                        jSONObject.put("clickStart", j16);
                        jSONObject.put("pageStart", j108);
                        long j118222222222 = j108;
                        jSONObject.put("pageFinish", this.onPageFinishedTime);
                        jSONObject.put("webviewStart", j18);
                        jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                        jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                        jSONObject.put("isFirstRequest", z18);
                        jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                        jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                        jSONObject.put("isWebViewCache", z19);
                        jSONObject.put("onCreate", j105);
                        jSONObject.put("viewInflate", j107);
                        jSONObject.put("getWebView", j95);
                        jSONObject.put("initBrowser", j96);
                        jSONObject.put("init", j97);
                        jSONObject.put("initTBS", j98);
                        jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                        jSONObject.put("nonWhiteScreen", j104);
                        jSONObject.put("initWebViewTime", j106);
                        jSONObject.put("isDirectAddress", false);
                        StringBuilder sb5222222222 = new StringBuilder("speed data:");
                        sb5222222222.append("clickStartTime = " + j16);
                        sb5222222222.append("webviewStartTime = " + j18);
                        sb5222222222.append("pageStartTime = " + j118222222222);
                        sb5222222222.append("click to create :" + (j18 - j16));
                        sb5222222222.append(", create to loadUrl : " + (j118222222222 - j18));
                        QLog.d(str, 1, sb5222222222.toString());
                        j109 = j100;
                        if (j109 > 0) {
                        }
                        j110 = j101;
                        if (j110 > 0) {
                        }
                        j111 = j102;
                        if (j111 > 0) {
                        }
                        jSONObject.put("isReloadUrl", isReloadUrl);
                        if (i3 > 0) {
                        }
                        if (webView != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (Exception e56) {
                    exc = e56;
                    z16 = false;
                    j3 = -1;
                    z17 = false;
                    j16 = -1;
                    j17 = 0;
                    j27 = -1;
                    j29 = -1;
                    j36 = -1;
                    j37 = -1;
                    j38 = -1;
                    j39 = -1;
                    j46 = -1;
                    j47 = -1;
                    j48 = -1;
                    j49 = -1;
                    j56 = -1;
                    exc.printStackTrace();
                    str = TAG;
                    j95 = j37;
                    j96 = j38;
                    j97 = j39;
                    j98 = j46;
                    j99 = j47;
                    j100 = j48;
                    j101 = j49;
                    j102 = j56;
                    boolean z292222222222 = z17;
                    z19 = z16;
                    isReloadUrl = z292222222222;
                    j103 = j36;
                    j104 = j3;
                    long j1172222222222 = j17;
                    j105 = j29;
                    j106 = j1172222222222;
                    if (yVar instanceof t) {
                    }
                    if (j27 == -1) {
                    }
                    jSONObject.put("clickStart", j16);
                    jSONObject.put("pageStart", j108);
                    long j1182222222222 = j108;
                    jSONObject.put("pageFinish", this.onPageFinishedTime);
                    jSONObject.put("webviewStart", j18);
                    jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                    jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                    jSONObject.put("isFirstRequest", z18);
                    jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                    jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                    jSONObject.put("isWebViewCache", z19);
                    jSONObject.put("onCreate", j105);
                    jSONObject.put("viewInflate", j107);
                    jSONObject.put("getWebView", j95);
                    jSONObject.put("initBrowser", j96);
                    jSONObject.put("init", j97);
                    jSONObject.put("initTBS", j98);
                    jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                    jSONObject.put("nonWhiteScreen", j104);
                    jSONObject.put("initWebViewTime", j106);
                    jSONObject.put("isDirectAddress", false);
                    StringBuilder sb52222222222 = new StringBuilder("speed data:");
                    sb52222222222.append("clickStartTime = " + j16);
                    sb52222222222.append("webviewStartTime = " + j18);
                    sb52222222222.append("pageStartTime = " + j1182222222222);
                    sb52222222222.append("click to create :" + (j18 - j16));
                    sb52222222222.append(", create to loadUrl : " + (j1182222222222 - j18));
                    QLog.d(str, 1, sb52222222222.toString());
                    j109 = j100;
                    if (j109 > 0) {
                    }
                    j110 = j101;
                    if (j110 > 0) {
                    }
                    j111 = j102;
                    if (j111 > 0) {
                    }
                    jSONObject.put("isReloadUrl", isReloadUrl);
                    if (i3 > 0) {
                    }
                    if (webView != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                }
                if (yVar instanceof t) {
                    t tVar = (t) yVar;
                    i3 = tVar.getCurrentPid();
                    z26 = tVar.N3();
                } else {
                    z26 = false;
                    i3 = 0;
                }
                if (j27 == -1) {
                    j107 = j103;
                    boolean z37 = z26;
                    j108 = this.onPageStartedTime;
                    z27 = z37;
                } else {
                    j107 = j103;
                    z27 = z26;
                    j108 = j27;
                }
                jSONObject.put("clickStart", j16);
                jSONObject.put("pageStart", j108);
                long j11822222222222 = j108;
                jSONObject.put("pageFinish", this.onPageFinishedTime);
                jSONObject.put("webviewStart", j18);
                jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                jSONObject.put("isFirstRequest", z18);
                jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                jSONObject.put("isWebViewCache", z19);
                jSONObject.put("onCreate", j105);
                jSONObject.put("viewInflate", j107);
                jSONObject.put("getWebView", j95);
                jSONObject.put("initBrowser", j96);
                jSONObject.put("init", j97);
                jSONObject.put("initTBS", j98);
                jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                jSONObject.put("nonWhiteScreen", j104);
                jSONObject.put("initWebViewTime", j106);
                jSONObject.put("isDirectAddress", false);
                StringBuilder sb522222222222 = new StringBuilder("speed data:");
                sb522222222222.append("clickStartTime = " + j16);
                sb522222222222.append("webviewStartTime = " + j18);
                sb522222222222.append("pageStartTime = " + j11822222222222);
                sb522222222222.append("click to create :" + (j18 - j16));
                sb522222222222.append(", create to loadUrl : " + (j11822222222222 - j18));
                QLog.d(str, 1, sb522222222222.toString());
                j109 = j100;
                if (j109 > 0) {
                    jSONObject.put("packageCheckFinish", j109);
                }
                j110 = j101;
                if (j110 > 0) {
                    jSONObject.put("readIndexTime", j110);
                }
                j111 = j102;
                if (j111 > 0) {
                    jSONObject.put("redirect302Time", j111);
                }
                jSONObject.put("isReloadUrl", isReloadUrl);
                if (i3 > 0) {
                    jSONObject.put("pid", i3);
                    jSONObject.put("isabnormalstart", z27 ? 2 : 1);
                }
                if (webView != null) {
                    jSONObject.put("isX5", webView.getX5WebViewExtension() == null ? "0" : "1");
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    String str4 = "";
                    sb6.append("");
                    if (j111 <= 0) {
                        str2 = "";
                    } else {
                        str2 = ", redirect 302 cost: " + (j111 - j11822222222222);
                    }
                    sb6.append(str2);
                    if (j109 <= 0) {
                        str3 = "";
                    } else {
                        str3 = ", check offline res cost: " + (j109 - j11822222222222);
                    }
                    sb6.append(str3);
                    if (j110 > 0) {
                        str4 = ", read index cost: " + (j110 - j11822222222222);
                    }
                    sb6.append(str4);
                    QLog.i("QQBrowser_report", 2, sb6.toString());
                    return;
                }
                return;
            }
        }
        if (this.mRuntime.a() instanceof com.tencent.mobileqq.webview.swift.u) {
            SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) super.getBrowserComponent(-2);
            OfflinePlugin offlinePlugin3 = (this.mRuntime.e() == null || (m3 = this.mRuntime.e().getPluginEngine().m("offline")) == null || !(m3 instanceof OfflinePlugin)) ? null : (OfflinePlugin) m3;
            if (swiftBrowserStatistics != null) {
                long j120 = swiftBrowserStatistics.f314361h;
                if (offlinePlugin3 != null) {
                    try {
                    } catch (Exception e57) {
                        exc = e57;
                        j18 = j120;
                        z16 = false;
                        j3 = -1;
                        z17 = false;
                        j16 = -1;
                        j17 = 0;
                        isMainPageUseLocalFile = false;
                        z18 = true;
                        j27 = -1;
                        j29 = -1;
                        j36 = -1;
                        j37 = -1;
                        j38 = -1;
                        j39 = -1;
                        j46 = -1;
                        j47 = -1;
                        j48 = -1;
                        j49 = -1;
                        j56 = -1;
                        exc.printStackTrace();
                        str = TAG;
                        j95 = j37;
                        j96 = j38;
                        j97 = j39;
                        j98 = j46;
                        j99 = j47;
                        j100 = j48;
                        j101 = j49;
                        j102 = j56;
                        boolean z2922222222222 = z17;
                        z19 = z16;
                        isReloadUrl = z2922222222222;
                        j103 = j36;
                        j104 = j3;
                        long j11722222222222 = j17;
                        j105 = j29;
                        j106 = j11722222222222;
                        if (yVar instanceof t) {
                        }
                        if (j27 == -1) {
                        }
                        jSONObject.put("clickStart", j16);
                        jSONObject.put("pageStart", j108);
                        long j118222222222222 = j108;
                        jSONObject.put("pageFinish", this.onPageFinishedTime);
                        jSONObject.put("webviewStart", j18);
                        jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                        jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                        jSONObject.put("isFirstRequest", z18);
                        jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                        jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                        jSONObject.put("isWebViewCache", z19);
                        jSONObject.put("onCreate", j105);
                        jSONObject.put("viewInflate", j107);
                        jSONObject.put("getWebView", j95);
                        jSONObject.put("initBrowser", j96);
                        jSONObject.put("init", j97);
                        jSONObject.put("initTBS", j98);
                        jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                        jSONObject.put("nonWhiteScreen", j104);
                        jSONObject.put("initWebViewTime", j106);
                        jSONObject.put("isDirectAddress", false);
                        StringBuilder sb5222222222222 = new StringBuilder("speed data:");
                        sb5222222222222.append("clickStartTime = " + j16);
                        sb5222222222222.append("webviewStartTime = " + j18);
                        sb5222222222222.append("pageStartTime = " + j118222222222222);
                        sb5222222222222.append("click to create :" + (j18 - j16));
                        sb5222222222222.append(", create to loadUrl : " + (j118222222222222 - j18));
                        QLog.d(str, 1, sb5222222222222.toString());
                        j109 = j100;
                        if (j109 > 0) {
                        }
                        j110 = j101;
                        if (j110 > 0) {
                        }
                        j111 = j102;
                        if (j111 > 0) {
                        }
                        jSONObject.put("isReloadUrl", isReloadUrl);
                        if (i3 > 0) {
                        }
                        if (webView != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                    if (offlinePlugin3.T) {
                        z28 = true;
                        boolean z38 = swiftBrowserStatistics.f314377u0;
                        boolean z39 = swiftBrowserStatistics.G0;
                        j16 = swiftBrowserStatistics.f314358f;
                        long j121 = swiftBrowserStatistics.R;
                        offlinePlugin = offlinePlugin3;
                        long j122 = swiftBrowserStatistics.S;
                        j27 = j121;
                        long j123 = swiftBrowserStatistics.T;
                        long j124 = swiftBrowserStatistics.L;
                        long j125 = swiftBrowserStatistics.M;
                        long j126 = swiftBrowserStatistics.N;
                        long j127 = swiftBrowserStatistics.Q;
                        if (offlinePlugin == null) {
                            j112 = j127;
                            offlinePlugin2 = offlinePlugin;
                            try {
                                j113 = offlinePlugin2.L;
                            } catch (Exception e58) {
                                exc = e58;
                                z16 = z39;
                                j46 = j112;
                                j3 = -1;
                                z17 = false;
                                j47 = 0;
                                j48 = -1;
                                j49 = -1;
                                j56 = -1;
                                j39 = j126;
                                j38 = j125;
                                j37 = j124;
                                j36 = j123;
                                j29 = j122;
                                j18 = j120;
                                isMainPageUseLocalFile = z28;
                                z18 = z38;
                                j17 = 0;
                                exc.printStackTrace();
                                str = TAG;
                                j95 = j37;
                                j96 = j38;
                                j97 = j39;
                                j98 = j46;
                                j99 = j47;
                                j100 = j48;
                                j101 = j49;
                                j102 = j56;
                                boolean z29222222222222 = z17;
                                z19 = z16;
                                isReloadUrl = z29222222222222;
                                j103 = j36;
                                j104 = j3;
                                long j117222222222222 = j17;
                                j105 = j29;
                                j106 = j117222222222222;
                                if (yVar instanceof t) {
                                }
                                if (j27 == -1) {
                                }
                                jSONObject.put("clickStart", j16);
                                jSONObject.put("pageStart", j108);
                                long j1182222222222222 = j108;
                                jSONObject.put("pageFinish", this.onPageFinishedTime);
                                jSONObject.put("webviewStart", j18);
                                jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                                jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                                jSONObject.put("isFirstRequest", z18);
                                jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                                jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                                jSONObject.put("isWebViewCache", z19);
                                jSONObject.put("onCreate", j105);
                                jSONObject.put("viewInflate", j107);
                                jSONObject.put("getWebView", j95);
                                jSONObject.put("initBrowser", j96);
                                jSONObject.put("init", j97);
                                jSONObject.put("initTBS", j98);
                                jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                                jSONObject.put("nonWhiteScreen", j104);
                                jSONObject.put("initWebViewTime", j106);
                                jSONObject.put("isDirectAddress", false);
                                StringBuilder sb52222222222222 = new StringBuilder("speed data:");
                                sb52222222222222.append("clickStartTime = " + j16);
                                sb52222222222222.append("webviewStartTime = " + j18);
                                sb52222222222222.append("pageStartTime = " + j1182222222222222);
                                sb52222222222222.append("click to create :" + (j18 - j16));
                                sb52222222222222.append(", create to loadUrl : " + (j1182222222222222 - j18));
                                QLog.d(str, 1, sb52222222222222.toString());
                                j109 = j100;
                                if (j109 > 0) {
                                }
                                j110 = j101;
                                if (j110 > 0) {
                                }
                                j111 = j102;
                                if (j111 > 0) {
                                }
                                jSONObject.put("isReloadUrl", isReloadUrl);
                                if (i3 > 0) {
                                }
                                if (webView != null) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                            }
                        } else {
                            j112 = j127;
                            offlinePlugin2 = offlinePlugin;
                            j113 = 0;
                        }
                        if (offlinePlugin2 == null) {
                            j114 = j113;
                            try {
                                j115 = offlinePlugin2.M;
                            } catch (Exception e59) {
                                exc = e59;
                                z16 = z39;
                                j48 = j114;
                                j3 = -1;
                                z17 = false;
                                j47 = 0;
                                j49 = -1;
                                j56 = -1;
                                j46 = j112;
                                j39 = j126;
                                j38 = j125;
                                j37 = j124;
                                j36 = j123;
                                j29 = j122;
                                j18 = j120;
                                isMainPageUseLocalFile = z28;
                                z18 = z38;
                                j17 = 0;
                                exc.printStackTrace();
                                str = TAG;
                                j95 = j37;
                                j96 = j38;
                                j97 = j39;
                                j98 = j46;
                                j99 = j47;
                                j100 = j48;
                                j101 = j49;
                                j102 = j56;
                                boolean z292222222222222 = z17;
                                z19 = z16;
                                isReloadUrl = z292222222222222;
                                j103 = j36;
                                j104 = j3;
                                long j1172222222222222 = j17;
                                j105 = j29;
                                j106 = j1172222222222222;
                                if (yVar instanceof t) {
                                }
                                if (j27 == -1) {
                                }
                                jSONObject.put("clickStart", j16);
                                jSONObject.put("pageStart", j108);
                                long j11822222222222222 = j108;
                                jSONObject.put("pageFinish", this.onPageFinishedTime);
                                jSONObject.put("webviewStart", j18);
                                jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                                jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                                jSONObject.put("isFirstRequest", z18);
                                jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                                jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                                jSONObject.put("isWebViewCache", z19);
                                jSONObject.put("onCreate", j105);
                                jSONObject.put("viewInflate", j107);
                                jSONObject.put("getWebView", j95);
                                jSONObject.put("initBrowser", j96);
                                jSONObject.put("init", j97);
                                jSONObject.put("initTBS", j98);
                                jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                                jSONObject.put("nonWhiteScreen", j104);
                                jSONObject.put("initWebViewTime", j106);
                                jSONObject.put("isDirectAddress", false);
                                StringBuilder sb522222222222222 = new StringBuilder("speed data:");
                                sb522222222222222.append("clickStartTime = " + j16);
                                sb522222222222222.append("webviewStartTime = " + j18);
                                sb522222222222222.append("pageStartTime = " + j11822222222222222);
                                sb522222222222222.append("click to create :" + (j18 - j16));
                                sb522222222222222.append(", create to loadUrl : " + (j11822222222222222 - j18));
                                QLog.d(str, 1, sb522222222222222.toString());
                                j109 = j100;
                                if (j109 > 0) {
                                }
                                j110 = j101;
                                if (j110 > 0) {
                                }
                                j111 = j102;
                                if (j111 > 0) {
                                }
                                jSONObject.put("isReloadUrl", isReloadUrl);
                                if (i3 > 0) {
                                }
                                if (webView != null) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                            }
                        } else {
                            j114 = j113;
                            j115 = 0;
                        }
                        long j128 = swiftBrowserStatistics.U;
                        if (offlinePlugin2 != null) {
                            try {
                            } catch (Exception e65) {
                                exc = e65;
                                j56 = j128;
                                z16 = z39;
                                j48 = j114;
                                j49 = j115;
                                j3 = -1;
                                z17 = false;
                                j47 = 0;
                                j46 = j112;
                                j39 = j126;
                                j38 = j125;
                                j37 = j124;
                                j36 = j123;
                                j29 = j122;
                                j18 = j120;
                                isMainPageUseLocalFile = z28;
                                z18 = z38;
                                j17 = 0;
                                exc.printStackTrace();
                                str = TAG;
                                j95 = j37;
                                j96 = j38;
                                j97 = j39;
                                j98 = j46;
                                j99 = j47;
                                j100 = j48;
                                j101 = j49;
                                j102 = j56;
                                boolean z2922222222222222 = z17;
                                z19 = z16;
                                isReloadUrl = z2922222222222222;
                                j103 = j36;
                                j104 = j3;
                                long j11722222222222222 = j17;
                                j105 = j29;
                                j106 = j11722222222222222;
                                if (yVar instanceof t) {
                                }
                                if (j27 == -1) {
                                }
                                jSONObject.put("clickStart", j16);
                                jSONObject.put("pageStart", j108);
                                long j118222222222222222 = j108;
                                jSONObject.put("pageFinish", this.onPageFinishedTime);
                                jSONObject.put("webviewStart", j18);
                                jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                                jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                                jSONObject.put("isFirstRequest", z18);
                                jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                                jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                                jSONObject.put("isWebViewCache", z19);
                                jSONObject.put("onCreate", j105);
                                jSONObject.put("viewInflate", j107);
                                jSONObject.put("getWebView", j95);
                                jSONObject.put("initBrowser", j96);
                                jSONObject.put("init", j97);
                                jSONObject.put("initTBS", j98);
                                jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                                jSONObject.put("nonWhiteScreen", j104);
                                jSONObject.put("initWebViewTime", j106);
                                jSONObject.put("isDirectAddress", false);
                                StringBuilder sb5222222222222222 = new StringBuilder("speed data:");
                                sb5222222222222222.append("clickStartTime = " + j16);
                                sb5222222222222222.append("webviewStartTime = " + j18);
                                sb5222222222222222.append("pageStartTime = " + j118222222222222222);
                                sb5222222222222222.append("click to create :" + (j18 - j16));
                                sb5222222222222222.append(", create to loadUrl : " + (j118222222222222222 - j18));
                                QLog.d(str, 1, sb5222222222222222.toString());
                                j109 = j100;
                                if (j109 > 0) {
                                }
                                j110 = j101;
                                if (j110 > 0) {
                                }
                                j111 = j102;
                                if (j111 > 0) {
                                }
                                jSONObject.put("isReloadUrl", isReloadUrl);
                                if (i3 > 0) {
                                }
                                if (webView != null) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                            }
                            if (offlinePlugin2.K) {
                                j116 = j128;
                                z17 = true;
                                long j129 = swiftBrowserStatistics.V;
                                j3 = swiftBrowserStatistics.D;
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("getPerformance: isWebViewCache = ");
                                sb7.append(z39);
                                sb7.append(", isPreloadWebProcess = ");
                                sb7.append(SwiftBrowserStatistics.f314343h1);
                                QLog.d(TAG, 1, sb7.toString());
                                isReloadUrl = z17;
                                z19 = z39;
                                j76 = j3;
                                j75 = j116;
                                j68 = j114;
                                j79 = j112;
                                j78 = j126;
                                j88 = j125;
                                j87 = j124;
                                j86 = j123;
                                j89 = j122;
                                j18 = j120;
                                isMainPageUseLocalFile = z28;
                                z18 = z38;
                                j77 = j129;
                                j69 = j115;
                                j85 = 0;
                                str = TAG;
                                j95 = j87;
                                j96 = j88;
                                j97 = j78;
                                j98 = j79;
                                j99 = j85;
                                j100 = j68;
                                j101 = j69;
                                j102 = j75;
                                j103 = j86;
                                j104 = j76;
                                long j1192 = j77;
                                j105 = j89;
                                j106 = j1192;
                                if (yVar instanceof t) {
                                }
                                if (j27 == -1) {
                                }
                                jSONObject.put("clickStart", j16);
                                jSONObject.put("pageStart", j108);
                                long j1182222222222222222 = j108;
                                jSONObject.put("pageFinish", this.onPageFinishedTime);
                                jSONObject.put("webviewStart", j18);
                                jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                                jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                                jSONObject.put("isFirstRequest", z18);
                                jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                                jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                                jSONObject.put("isWebViewCache", z19);
                                jSONObject.put("onCreate", j105);
                                jSONObject.put("viewInflate", j107);
                                jSONObject.put("getWebView", j95);
                                jSONObject.put("initBrowser", j96);
                                jSONObject.put("init", j97);
                                jSONObject.put("initTBS", j98);
                                jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                                jSONObject.put("nonWhiteScreen", j104);
                                jSONObject.put("initWebViewTime", j106);
                                jSONObject.put("isDirectAddress", false);
                                StringBuilder sb52222222222222222 = new StringBuilder("speed data:");
                                sb52222222222222222.append("clickStartTime = " + j16);
                                sb52222222222222222.append("webviewStartTime = " + j18);
                                sb52222222222222222.append("pageStartTime = " + j1182222222222222222);
                                sb52222222222222222.append("click to create :" + (j18 - j16));
                                sb52222222222222222.append(", create to loadUrl : " + (j1182222222222222222 - j18));
                                QLog.d(str, 1, sb52222222222222222.toString());
                                j109 = j100;
                                if (j109 > 0) {
                                }
                                j110 = j101;
                                if (j110 > 0) {
                                }
                                j111 = j102;
                                if (j111 > 0) {
                                }
                                jSONObject.put("isReloadUrl", isReloadUrl);
                                if (i3 > 0) {
                                }
                                if (webView != null) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                            }
                        }
                        j116 = j128;
                        z17 = false;
                        long j1292 = swiftBrowserStatistics.V;
                        j3 = swiftBrowserStatistics.D;
                        StringBuilder sb72 = new StringBuilder();
                        sb72.append("getPerformance: isWebViewCache = ");
                        sb72.append(z39);
                        sb72.append(", isPreloadWebProcess = ");
                        sb72.append(SwiftBrowserStatistics.f314343h1);
                        QLog.d(TAG, 1, sb72.toString());
                        isReloadUrl = z17;
                        z19 = z39;
                        j76 = j3;
                        j75 = j116;
                        j68 = j114;
                        j79 = j112;
                        j78 = j126;
                        j88 = j125;
                        j87 = j124;
                        j86 = j123;
                        j89 = j122;
                        j18 = j120;
                        isMainPageUseLocalFile = z28;
                        z18 = z38;
                        j77 = j1292;
                        j69 = j115;
                        j85 = 0;
                        str = TAG;
                        j95 = j87;
                        j96 = j88;
                        j97 = j78;
                        j98 = j79;
                        j99 = j85;
                        j100 = j68;
                        j101 = j69;
                        j102 = j75;
                        j103 = j86;
                        j104 = j76;
                        long j11922 = j77;
                        j105 = j89;
                        j106 = j11922;
                        if (yVar instanceof t) {
                        }
                        if (j27 == -1) {
                        }
                        jSONObject.put("clickStart", j16);
                        jSONObject.put("pageStart", j108);
                        long j11822222222222222222 = j108;
                        jSONObject.put("pageFinish", this.onPageFinishedTime);
                        jSONObject.put("webviewStart", j18);
                        jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                        jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                        jSONObject.put("isFirstRequest", z18);
                        jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                        jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                        jSONObject.put("isWebViewCache", z19);
                        jSONObject.put("onCreate", j105);
                        jSONObject.put("viewInflate", j107);
                        jSONObject.put("getWebView", j95);
                        jSONObject.put("initBrowser", j96);
                        jSONObject.put("init", j97);
                        jSONObject.put("initTBS", j98);
                        jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                        jSONObject.put("nonWhiteScreen", j104);
                        jSONObject.put("initWebViewTime", j106);
                        jSONObject.put("isDirectAddress", false);
                        StringBuilder sb522222222222222222 = new StringBuilder("speed data:");
                        sb522222222222222222.append("clickStartTime = " + j16);
                        sb522222222222222222.append("webviewStartTime = " + j18);
                        sb522222222222222222.append("pageStartTime = " + j11822222222222222222);
                        sb522222222222222222.append("click to create :" + (j18 - j16));
                        sb522222222222222222.append(", create to loadUrl : " + (j11822222222222222222 - j18));
                        QLog.d(str, 1, sb522222222222222222.toString());
                        j109 = j100;
                        if (j109 > 0) {
                        }
                        j110 = j101;
                        if (j110 > 0) {
                        }
                        j111 = j102;
                        if (j111 > 0) {
                        }
                        jSONObject.put("isReloadUrl", isReloadUrl);
                        if (i3 > 0) {
                        }
                        if (webView != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                }
                z28 = false;
                boolean z382 = swiftBrowserStatistics.f314377u0;
                boolean z392 = swiftBrowserStatistics.G0;
                j16 = swiftBrowserStatistics.f314358f;
                long j1212 = swiftBrowserStatistics.R;
                offlinePlugin = offlinePlugin3;
                long j1222 = swiftBrowserStatistics.S;
                j27 = j1212;
                long j1232 = swiftBrowserStatistics.T;
                long j1242 = swiftBrowserStatistics.L;
                long j1252 = swiftBrowserStatistics.M;
                long j1262 = swiftBrowserStatistics.N;
                long j1272 = swiftBrowserStatistics.Q;
                if (offlinePlugin == null) {
                }
                if (offlinePlugin2 == null) {
                }
                long j1282 = swiftBrowserStatistics.U;
                if (offlinePlugin2 != null) {
                }
                j116 = j1282;
                z17 = false;
                long j12922 = swiftBrowserStatistics.V;
                j3 = swiftBrowserStatistics.D;
                StringBuilder sb722 = new StringBuilder();
                sb722.append("getPerformance: isWebViewCache = ");
                sb722.append(z392);
                sb722.append(", isPreloadWebProcess = ");
                sb722.append(SwiftBrowserStatistics.f314343h1);
                QLog.d(TAG, 1, sb722.toString());
                isReloadUrl = z17;
                z19 = z392;
                j76 = j3;
                j75 = j116;
                j68 = j114;
                j79 = j112;
                j78 = j1262;
                j88 = j1252;
                j87 = j1242;
                j86 = j1232;
                j89 = j1222;
                j18 = j120;
                isMainPageUseLocalFile = z28;
                z18 = z382;
                j77 = j12922;
                j69 = j115;
                j85 = 0;
                str = TAG;
                j95 = j87;
                j96 = j88;
                j97 = j78;
                j98 = j79;
                j99 = j85;
                j100 = j68;
                j101 = j69;
                j102 = j75;
                j103 = j86;
                j104 = j76;
                long j119222 = j77;
                j105 = j89;
                j106 = j119222;
                if (yVar instanceof t) {
                }
                if (j27 == -1) {
                }
                jSONObject.put("clickStart", j16);
                jSONObject.put("pageStart", j108);
                long j118222222222222222222 = j108;
                jSONObject.put("pageFinish", this.onPageFinishedTime);
                jSONObject.put("webviewStart", j18);
                jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
                jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
                jSONObject.put("isFirstRequest", z18);
                jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
                jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
                jSONObject.put("isWebViewCache", z19);
                jSONObject.put("onCreate", j105);
                jSONObject.put("viewInflate", j107);
                jSONObject.put("getWebView", j95);
                jSONObject.put("initBrowser", j96);
                jSONObject.put("init", j97);
                jSONObject.put("initTBS", j98);
                jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
                jSONObject.put("nonWhiteScreen", j104);
                jSONObject.put("initWebViewTime", j106);
                jSONObject.put("isDirectAddress", false);
                StringBuilder sb5222222222222222222 = new StringBuilder("speed data:");
                sb5222222222222222222.append("clickStartTime = " + j16);
                sb5222222222222222222.append("webviewStartTime = " + j18);
                sb5222222222222222222.append("pageStartTime = " + j118222222222222222222);
                sb5222222222222222222.append("click to create :" + (j18 - j16));
                sb5222222222222222222.append(", create to loadUrl : " + (j118222222222222222222 - j18));
                QLog.d(str, 1, sb5222222222222222222.toString());
                j109 = j100;
                if (j109 > 0) {
                }
                j110 = j101;
                if (j110 > 0) {
                }
                j111 = j102;
                if (j111 > 0) {
                }
                jSONObject.put("isReloadUrl", isReloadUrl);
                if (i3 > 0) {
                }
                if (webView != null) {
                }
                if (QLog.isColorLevel()) {
                }
            }
        }
        isReloadUrl = false;
        j76 = -1;
        z19 = false;
        j16 = -1;
        j77 = 0;
        j18 = -1;
        isMainPageUseLocalFile = false;
        z18 = true;
        j27 = -1;
        j89 = -1;
        j86 = -1;
        j87 = -1;
        j88 = -1;
        j78 = -1;
        j79 = -1;
        j85 = -1;
        j68 = -1;
        j69 = -1;
        j75 = -1;
        str = TAG;
        j95 = j87;
        j96 = j88;
        j97 = j78;
        j98 = j79;
        j99 = j85;
        j100 = j68;
        j101 = j69;
        j102 = j75;
        j103 = j86;
        j104 = j76;
        long j1192222 = j77;
        j105 = j89;
        j106 = j1192222;
        if (yVar instanceof t) {
        }
        if (j27 == -1) {
        }
        jSONObject.put("clickStart", j16);
        jSONObject.put("pageStart", j108);
        long j1182222222222222222222 = j108;
        jSONObject.put("pageFinish", this.onPageFinishedTime);
        jSONObject.put("webviewStart", j18);
        jSONObject.put("isUseLocalSrc", isMainPageUseLocalFile);
        jSONObject.put("noLocalSrcType", HtmlOffline.f78400c);
        jSONObject.put("isFirstRequest", z18);
        jSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.f314343h1);
        jSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.f314344i1);
        jSONObject.put("isWebViewCache", z19);
        jSONObject.put("onCreate", j105);
        jSONObject.put("viewInflate", j107);
        jSONObject.put("getWebView", j95);
        jSONObject.put("initBrowser", j96);
        jSONObject.put("init", j97);
        jSONObject.put("initTBS", j98);
        jSONObject.put(VasWebviewConstants.KEY_PLUGIN_FINISHED_TIME, j99);
        jSONObject.put("nonWhiteScreen", j104);
        jSONObject.put("initWebViewTime", j106);
        jSONObject.put("isDirectAddress", false);
        StringBuilder sb52222222222222222222 = new StringBuilder("speed data:");
        sb52222222222222222222.append("clickStartTime = " + j16);
        sb52222222222222222222.append("webviewStartTime = " + j18);
        sb52222222222222222222.append("pageStartTime = " + j1182222222222222222222);
        sb52222222222222222222.append("click to create :" + (j18 - j16));
        sb52222222222222222222.append(", create to loadUrl : " + (j1182222222222222222222 - j18));
        QLog.d(str, 1, sb52222222222222222222.toString());
        j109 = j100;
        if (j109 > 0) {
        }
        j110 = j101;
        if (j110 > 0) {
        }
        j111 = j102;
        if (j111 > 0) {
        }
        jSONObject.put("isReloadUrl", isReloadUrl);
        if (i3 > 0) {
        }
        if (webView != null) {
        }
        if (QLog.isColorLevel()) {
        }
    }

    private static void processWebLog(AppInterface appInterface, Context context, String str, String str2, String str3, boolean z16) {
        String str4;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("|");
        sb5.append(str2);
        sb5.append("|");
        sb5.append(str3);
        sb5.append("|");
        sb5.append("ANDROID");
        sb5.append("|");
        sb5.append(AppSetting.f99554n);
        sb5.append("|");
        sb5.append(ah.t());
        sb5.append("|");
        sb5.append(MobileQQ.getShortUinStr(appInterface.getCurrentAccountUin()));
        sb5.append("|");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("|");
        String str5 = "\u672a\u77e5";
        if (TextUtils.isEmpty(ah.G(context).f307419c)) {
            str4 = "\u672a\u77e5";
        } else {
            str4 = ah.G(context).f307419c;
        }
        sb5.append(str4);
        sb5.append("|");
        if (!TextUtils.isEmpty(ah.G(context).f307417a)) {
            str5 = ah.G(context).f307417a;
        }
        sb5.append(str5);
        if (z16) {
            QLog.w("WebLog", 1, sb5.toString());
        } else if (QLog.isDevelopLevel()) {
            QLog.w("WebLog", 2, sb5.toString());
        }
    }

    public static void webLog(AppInterface appInterface, Context context, JSONObject jSONObject) {
        try {
            processWebLog(appInterface, context, jSONObject.getString("id"), jSONObject.getString("subid"), jSONObject.getString("content"), jSONObject.getBoolean("isall"));
        } catch (JSONException | Exception unused) {
        }
    }

    public void commitPerformanceToWebsite(JsBridgeListener jsBridgeListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            getPerformance(jSONObject, this.mRuntime.e());
            getPerformanceFromX5(jSONObject);
            jsBridgeListener.c(jSONObject);
        } catch (JSONException e16) {
            jsBridgeListener.e("JSONException:" + e16.getMessage());
            e16.printStackTrace();
        } catch (Exception e17) {
            jsBridgeListener.e("Exception:" + e17.getMessage());
            e17.printStackTrace();
        }
    }

    public void doChooseFriendResultForH5(List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        String str;
        String str2;
        String str3;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (list != null && list2 != null && list3 != null && list4 != null) {
                for (int i3 = 0; i3 < list.size() && i3 < list2.size() && i3 < list3.size() && i3 < list4.size(); i3++) {
                    String str4 = "";
                    if (TextUtils.isEmpty(list.get(i3))) {
                        str = "";
                    } else {
                        str = list.get(i3);
                    }
                    if (TextUtils.isEmpty(list2.get(i3))) {
                        str2 = "";
                    } else {
                        str2 = list2.get(i3);
                    }
                    if (TextUtils.isEmpty(list3.get(i3))) {
                        str3 = "";
                    } else {
                        str3 = list3.get(i3);
                    }
                    if (!TextUtils.isEmpty(list4.get(i3))) {
                        str4 = list4.get(i3);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("uin", str);
                    jSONObject2.put("phone", str2);
                    jSONObject2.put("name", str3);
                    jSONObject2.put("type", str4);
                    jSONArray.mo162put(jSONObject2);
                }
            }
            jSONObject.put("friends", jSONArray);
            lambda$chooseFriends$0(this.mCallback, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public String getCurrentNetwork() {
        int i3;
        try {
            i3 = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
        } catch (Exception unused) {
            i3 = 0;
        }
        if (i3 == 1) {
            return "wifi";
        }
        if (i3 == 2) {
            return "2G";
        }
        if (i3 == 3) {
            return "3G";
        }
        if (i3 != 4) {
            return "";
        }
        return "4G";
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b3, code lost:
    
        if (r24 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        if (r25 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b7, code lost:
    
        if (r26 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b9, code lost:
    
        r0 = new org.json.JSONArray();
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c3, code lost:
    
        if (r1 >= r23.size()) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c9, code lost:
    
        if (r1 >= r24.size()) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cf, code lost:
    
        if (r1 >= r25.size()) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d5, code lost:
    
        if (r1 >= r26.size()) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e1, code lost:
    
        if (android.text.TextUtils.isEmpty(r4.get(r1)) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e3, code lost:
    
        r2 = r4.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f5, code lost:
    
        if (android.text.TextUtils.isEmpty(r24.get(r1)) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f7, code lost:
    
        r3 = r24.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0103, code lost:
    
        if (r25.get(r1) == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0105, code lost:
    
        r8 = r25.get(r1).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0115, code lost:
    
        if (r26.get(r1) == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0117, code lost:
    
        r14 = r26.get(r1).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0124, code lost:
    
        if (r14 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0128, code lost:
    
        if (r14 != 8) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0141, code lost:
    
        r1 = r1 + 1;
        r4 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012a, code lost:
    
        r4 = new org.json.JSONObject();
        r4.put("uin", r2);
        r4.put("name", r3);
        r4.put("type", r14);
        r4.put("count", r8);
        r0.mo162put(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0122, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0110, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00fe, code lost:
    
        r3 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ea, code lost:
    
        r2 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected JSONObject getJsBackJson(Intent intent, List<String> list, List<String> list2, List<String> list3, List<Integer> list4, List<String> list5, List<String> list6, List<Integer> list7, List<Integer> list8) {
        List<String> list9 = list;
        List<String> list10 = list2;
        List<String> list11 = list3;
        List<String> list12 = list5;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (list9 != null && list10 != null && list11 != null) {
                int i3 = 0;
                while (i3 < list.size() && i3 < list2.size() && i3 < list3.size()) {
                    String str = !TextUtils.isEmpty(list9.get(i3)) ? list9.get(i3) : "";
                    String str2 = !TextUtils.isEmpty(list10.get(i3)) ? list10.get(i3) : "";
                    String str3 = !TextUtils.isEmpty(list11.get(i3)) ? list11.get(i3) : "";
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("uin", str);
                    jSONObject2.put("phone", str2);
                    jSONObject2.put("name", str3);
                    if (list4 != null && list4.size() > i3) {
                        jSONObject2.put("type", list4.get(i3));
                    } else {
                        jSONObject2.put("type", 1);
                    }
                    jSONArray.mo162put(jSONObject2);
                    i3++;
                    list9 = list;
                    list10 = list2;
                    list11 = list3;
                }
            }
            JSONArray jSONArray2 = null;
            jSONObject.put("friends", jSONArray);
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                jSONObject.put("groups", jSONArray2);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.l
    public String[] getMultiNameSpace() {
        return new String[]{PLUGIN_NAMESPACE_QW_DEBUG, PLUGIN_NAMESPACE_QW_DATA, PLUGIN_NAMESPACE_FRIEND_DATA};
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "";
    }

    public void getNickName(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getNickName " + jSONObject.toString());
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("uins");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(jSONArray.getString(i3));
            }
            this.mReqBundle.clear();
            this.mReqBundle.putStringArrayList("uins", arrayList);
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("getNickName", str, this.mOnRemoteResp.key, this.mReqBundle));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "createShortcut failed: " + e16.getMessage());
            }
            super.callJsOnError(str, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        CustomWebView e16;
        Activity a16;
        if (TextUtils.isEmpty(str2) || !(str2.startsWith(PLUGIN_NAMESPACE_QW_DEBUG) || str2.startsWith(PLUGIN_NAMESPACE_QW_DATA) || str2.startsWith(PLUGIN_NAMESPACE_FRIEND_DATA))) {
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            jsBridgeListener.e("method empty");
            return true;
        }
        this.logicMethod = str3;
        try {
            if ("log".equals(str3)) {
                if (!this.logStop && this.logShowTag) {
                    this.logInfo.add(new JSONObject(strArr[0]).getString("msg"));
                    JsDebugDialog jsDebugDialog = this.deBugDialog;
                    if (jsDebugDialog != null && jsDebugDialog.isShowing()) {
                        this.deBugDialog.log(this.logInfo);
                    }
                }
            } else if ("show".equals(str3)) {
                if (this.logStop) {
                    jsBridgeListener.e("erro:please start log first");
                } else {
                    if (this.deBugDialog == null) {
                        this.deBugDialog = new JsDebugDialog(this.mRuntime.a());
                    }
                    if (new JSONObject(strArr[0]).getBoolean("flag")) {
                        this.logShowTag = true;
                    } else {
                        this.logShowTag = false;
                    }
                    this.deBugDialog.show();
                    this.deBugDialog.log(this.logInfo);
                }
            } else if ("hide".equals(str3)) {
                JsDebugDialog jsDebugDialog2 = this.deBugDialog;
                if (jsDebugDialog2 != null) {
                    jsDebugDialog2.dismiss();
                }
                if (new JSONObject(strArr[0]).getBoolean("flag")) {
                    this.logShowTag = true;
                } else {
                    this.logShowTag = false;
                }
            } else if ("start".equals(str3)) {
                this.logStop = false;
            } else if ("stop".equals(str3)) {
                this.logStop = true;
                this.logInfo.clear();
                JsDebugDialog jsDebugDialog3 = this.deBugDialog;
                if (jsDebugDialog3 != null) {
                    jsDebugDialog3.log(this.logInfo);
                }
            } else if ("qlog".equals(str3)) {
                if (QLog.isColorLevel()) {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    if (jSONObject.has("msg")) {
                        QLog.d(LOG_TAG_WEB, 2, jSONObject.getString("msg"));
                    }
                }
            } else if ("getPerformance".equals(str3)) {
                if (strArr != null && strArr.length > 0) {
                    String optString = new JSONObject(strArr[0]).optString("pageId", "");
                    SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) super.getBrowserComponent(-2);
                    if (swiftBrowserStatistics != null) {
                        swiftBrowserStatistics.C = optString;
                    }
                    VasBaseWebviewUtil.reportX5SpeedData(swiftBrowserStatistics);
                }
                commitPerformanceToWebsite(jsBridgeListener);
            } else if ("getVipType".equals(str3)) {
                JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
                if (jsonFromJSBridge == null) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
                }
                getVipType(jsonFromJSBridge, jsonFromJSBridge.optString("callback"));
            } else if ("startIpcService".equals(str3)) {
                if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                    ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(this.mRuntime.a().getApplicationContext());
                }
            } else if ("stopIpcService".equals(str3)) {
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doUnbindService(this.mRuntime.a().getApplicationContext());
            } else if ("isIpcStarted".equals(str3)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isIpcStarted", ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded());
                jsBridgeListener.c(jSONObject2);
            } else if (H5_CALLBACK_GETFRIENDINFO.equals(str3)) {
                if (strArr.length <= 0) {
                    chooseFriends(null);
                } else {
                    chooseFriends(strArr[0]);
                }
            } else if ("getFriendRemark".equals(str3)) {
                JSONObject jSONObject3 = new JSONObject(strArr[0]);
                getNickName(jSONObject3, jSONObject3.getString("callback"));
            } else if ("getDomainIpList".equals(str3)) {
                JSONObject jsonFromJSBridge2 = WebViewPlugin.getJsonFromJSBridge(str);
                if (jsonFromJSBridge2 == null) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge2.toString());
                }
                super.getDomainIpList(jsonFromJSBridge2, jsonFromJSBridge2.optString("callback"));
            } else if ("getDensity".equals(str3)) {
                JSONObject jsonFromJSBridge3 = WebViewPlugin.getJsonFromJSBridge(str);
                if (jsonFromJSBridge3 == null) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge3.toString());
                }
                getDensity(jsonFromJSBridge3.optString("callback"));
            } else {
                if ("detailLog".equals(str3)) {
                    webLog(this.mRuntime.b(), this.mRuntime.a(), new JSONObject(strArr[0]));
                    return true;
                }
                if ("selectedFriendInfo".equals(str3)) {
                    if (strArr.length <= 0) {
                        H5chooseFriends(null);
                    } else {
                        H5chooseFriends(strArr[0]);
                    }
                } else if ("setCurrentActivityShakeFlag".equals(str3)) {
                    if (!TextUtils.isEmpty(strArr[0]) && strArr[0].contains("flag") && (a16 = this.mRuntime.a()) != null && !this.isDestroy && !a16.isFinishing()) {
                        int optInt = new JSONObject(strArr[0]).optInt("flag");
                        if (a16 instanceof QBaseActivity) {
                            ((QBaseActivity) a16).mCurrentActivityShakeFlag = optInt > 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "setCurrentActivityShakeFlag:" + optInt);
                        }
                    }
                } else if ("enableConsoleBlackList".equals(str3)) {
                    JSONObject jsonFromJSBridge4 = WebViewPlugin.getJsonFromJSBridge(str);
                    if (jsonFromJSBridge4 == null || (e16 = this.mRuntime.e()) == null) {
                        return true;
                    }
                    WebChromeClient webChromeClient = e16.getWebChromeClient();
                    JSONObject jSONObject4 = new JSONObject();
                    if (webChromeClient instanceof h) {
                        ((h) webChromeClient).f79647b = true;
                        jSONObject4.put("code", 0);
                    } else {
                        jSONObject4.put("code", 1);
                    }
                    super.callJs(jsonFromJSBridge4.optString("callback"), jSONObject4.toString());
                } else if ("kuiklyPreLoad".equals(str3)) {
                    ThreadManagerV2.excute(new AnonymousClass1(strArr), 16, null, false);
                } else {
                    jsBridgeListener.e("no such method");
                    return false;
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            jsBridgeListener.e("Exception:" + e17.getMessage());
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onActivityResult requestCode = " + ((int) b16) + " resultCode = " + i3);
        }
        if (i3 == -1) {
            if (b16 == 17) {
                backH5Friends(intent);
            }
        } else if (b16 == 17) {
            errorCallBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle == null || bundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            return;
        }
        String string = bundle.getString("cmd");
        String string2 = bundle.getString("callbackid");
        Bundle bundle2 = bundle.getBundle("response");
        if (bundle2 == null) {
            QLog.e(TAG, 1, "onResponse respbundle = null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "response:" + string);
        }
        if (string == null || !"getNickName".equals(string)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (bundle2.containsKey("friendsMap")) {
                for (Map.Entry entry : ((HashMap) bundle2.getSerializable("friendsMap")).entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                jSONObject.put("remarks", jSONObject2);
            }
        } catch (Throwable th5) {
            super.callJsOnError(string2, th5.getMessage());
        }
        lambda$chooseFriends$0(string2, jSONObject.toString());
    }

    public void setUiInterface(y yVar) {
        this.uiInterface = yVar;
    }

    public void showMsgBox(JSONObject jSONObject, final JsBridgeListener jsBridgeListener) {
        try {
            String string = jSONObject.getString("prompt");
            String string2 = jSONObject.getString("title");
            String string3 = jSONObject.getString("button");
            String[] split = string3.split("\t");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "CommonJsHandler showMsgBox prompt=" + string + ",title=" + string2 + ",button=" + string3);
            }
            if (split.length >= 1) {
                final QQCustomDialogThreeBtns createCustomThreeBtnsDialog = DialogUtil.createCustomThreeBtnsDialog(this.mRuntime.a(), 230);
                createCustomThreeBtnsDialog.setTitle(string2);
                createCustomThreeBtnsDialog.setMessage(string);
                createCustomThreeBtnsDialog.setLeftButton(split[0], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("result", 0);
                            jSONObject2.put("message", "btn0 press");
                            jsBridgeListener.c(jSONObject2);
                        } catch (Exception e16) {
                            jsBridgeListener.e("Exception:" + e16.getMessage());
                            e16.printStackTrace();
                        }
                    }
                });
                if (split.length >= 2) {
                    createCustomThreeBtnsDialog.setMiddleButton(split[1], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("result", 1);
                                jSONObject2.put("message", "btn1 press");
                                jsBridgeListener.c(jSONObject2);
                            } catch (Exception e16) {
                                jsBridgeListener.e("Exception:" + e16.getMessage());
                                e16.printStackTrace();
                            }
                        }
                    });
                }
                if (split.length >= 3) {
                    createCustomThreeBtnsDialog.setRightButton(split[2], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("result", 1);
                                jSONObject2.put("message", "btn1 press");
                                jsBridgeListener.c(jSONObject2);
                            } catch (Exception e16) {
                                jsBridgeListener.e("Exception:" + e16.getMessage());
                                e16.printStackTrace();
                            }
                        }
                    });
                }
                createCustomThreeBtnsDialog.setCanceledOnTouchOutside(false);
                createCustomThreeBtnsDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.5
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                        if (i3 != 4 || !createCustomThreeBtnsDialog.isShowing()) {
                            return false;
                        }
                        createCustomThreeBtnsDialog.dismiss();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("message", " press");
                            jsBridgeListener.c(jSONObject2);
                            return true;
                        } catch (Exception e16) {
                            jsBridgeListener.e("Exception:" + e16.getMessage());
                            e16.printStackTrace();
                            return true;
                        }
                    }
                });
                createCustomThreeBtnsDialog.show();
                return;
            }
            jsBridgeListener.e("not find buttons" + string3);
        } catch (JSONException e16) {
            jsBridgeListener.e("JSONException params error:" + e16.getMessage());
            e16.printStackTrace();
        } catch (Exception e17) {
            jsBridgeListener.e("Exception:" + e17.getMessage());
            e17.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject prosBLCallback(Bundle bundle, JSONObject jSONObject) {
        if (1 == this.businessType && this.logicMethod.equals(H5_CALLBACK_GETFRIENDINFO)) {
            try {
                jSONObject.put("dialog_input_callback", bundle.getString("emsg"));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    /* loaded from: classes35.dex */
    class JsDebugDialog extends Dialog {
        TextView textView;

        public JsDebugDialog(Context context) {
            super(context);
            super.getWindow().setFlags(1024, 1024);
            super.requestWindowFeature(1);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            ScrollView scrollView = new ScrollView(context);
            scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            scrollView.addView(this.textView);
            relativeLayout.addView(scrollView);
            super.setContentView(relativeLayout);
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            this.textView.setText("");
            super.dismiss();
        }

        public void log(List<String> list) {
            if (list == null) {
                return;
            }
            this.textView.setText("");
            String str = (String) this.textView.getText();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str = str + "log:" + it.next() + "\n";
            }
            this.textView.setText(str);
        }
    }

    private void chooseFriends(String str) {
        String str2;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        Context currentContext = getCurrentContext();
        if (currentContext != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("title", HardCodeUtil.qqStr(R.string.uxw));
                String optString2 = jSONObject.optString("dialog_sub_title", "");
                String optString3 = jSONObject.optString("dialog_input", "");
                int optInt = jSONObject.optInt("type", 0);
                this.mCallback = jSONObject.optString("callback");
                boolean booleanValue = Boolean.valueOf(jSONObject.optString("isMulti", "false")).booleanValue();
                int intValue = Integer.valueOf(jSONObject.optString("limitNum", "0")).intValue();
                boolean z17 = (optInt & 1) != 0;
                boolean z18 = (optInt & 2) != 0;
                boolean z19 = (optInt & 12) != 0;
                boolean z26 = (optInt & 32) != 0;
                if (jSONObject.optInt("select_mode", 0) == 1) {
                    final String optString4 = jSONObject.optString("callback");
                    String optString5 = jSONObject.optString("over_limit_tips");
                    if (!TextUtils.isEmpty(optString5)) {
                        jSONObject.put("overLimitTips", optString5);
                    }
                    VasUtil.getService().getGxh().openSelectFriendsPanel(IGXHManager.FriendSelectParams.fromJson(jSONObject), com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vaswebviewplugin.d
                        @Override // com.tencent.mobileqq.vas.api.f.b
                        public final void onCallback(String str3) {
                            VasCommonJsPlugin.this.lambda$chooseFriends$0(optString4, str3);
                        }
                    }));
                    return;
                }
                this.businessType = jSONObject.optInt("business_type", 0);
                this.businessSubType = jSONObject.optInt("business_sub_type", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("from_group");
                if (optJSONObject != null) {
                    String optString6 = optJSONObject.optString("group_uin");
                    int optInt2 = optJSONObject.optInt("group_type");
                    i16 = optJSONObject.optInt("enable_filter_robot", 0);
                    i17 = optJSONObject.optInt("enable_select_all");
                    i18 = optJSONObject.optInt("enable_show_myself", 1);
                    i19 = optJSONObject.optInt("enable_show_myself_first", 0);
                    int optInt3 = optJSONObject.optInt("forbid_only_choose_myself", 0);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("group_members");
                    i26 = optInt3;
                    if (optJSONArray != null) {
                        for (int i27 = 0; i27 < optJSONArray.length(); i27++) {
                            String optString7 = optJSONArray.optString(i27);
                            if (!TextUtils.isEmpty(optString7)) {
                                arrayList.add(optString7);
                            }
                        }
                    }
                    str2 = optString6;
                    i3 = optInt2;
                } else {
                    str2 = null;
                    i3 = 0;
                    i16 = 0;
                    i17 = 0;
                    i18 = 1;
                    i19 = 0;
                    i26 = 1;
                }
                if (!booleanValue) {
                    if (this.mChoFriReceiver == null) {
                        this.mChoFriReceiver = new ChooseFriendReceiver(this, new Handler());
                    }
                    Parcel obtain = Parcel.obtain();
                    this.mChoFriReceiver.writeToParcel(obtain, 0);
                    obtain.setDataPosition(0);
                    Parcelable parcelable = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    Intent intent = new Intent(currentContext, (Class<?>) ForwardRecentActivity.class);
                    intent.putExtra("forward_type", 15);
                    intent.putExtra("choose_friend_title", optString);
                    intent.putExtra("choose_friend_dialog_sub_title", optString2);
                    intent.putExtra("choose_friend_dialog_input", optString3);
                    intent.putExtra("choose_friend_is_qqfriends", z17);
                    intent.putExtra("choose_friend_is_contacts", z18);
                    intent.putExtra("choose_friend_is_groupchats", z19);
                    intent.putExtra("choose_friend_is_create_group_chat", z26);
                    intent.putExtra("choose_friend_callback", parcelable);
                    intent.putExtra("choose_friend_businessType", this.businessType);
                    intent.putExtra("choose_friend_businessSubType", this.businessSubType);
                    super.startActivityForResult(intent, (byte) 0);
                    return;
                }
                if (intValue < 1) {
                    errorCallBack();
                    return;
                }
                Intent startSelectMemberActivityIntentForJsPlugin = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin(currentContext);
                startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
                startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
                startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_MAX, intValue);
                startSelectMemberActivityIntentForJsPlugin.addFlags(67108864);
                if (!TextUtils.isEmpty(optString)) {
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, optString);
                }
                if (!TextUtils.isEmpty(str2) && (i3 == 4 || i3 == 8)) {
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 32);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, false);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_OVERLOAD_TIPS_INCLUDE_DEFAULT_COUNT, true);
                    startSelectMemberActivityIntentForJsPlugin.putExtra("group_uin", str2);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, i17 != 0);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_SHOW_MYSELF, i18 != 0);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_IS_PUT_MYSELF_FIRST, i19 != 0);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_IS_FORBID_ONLY_CHOOSE_MYSELF, i26 != 0);
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_FILTER_ROBOT, i16 != 0);
                    if (arrayList.size() > 0) {
                        if (arrayList.size() > intValue) {
                            for (int size = arrayList.size() - 1; size >= intValue; size--) {
                                arrayList.remove(size);
                            }
                        }
                        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECTED_FRIENDS, arrayList);
                    }
                    if (arrayList.size() > 0) {
                        z16 = false;
                        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ALL_SELECT_MAX_NUM, 0);
                    } else {
                        z16 = false;
                    }
                    if (i3 == 4) {
                        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
                        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_DISCUSSION_MEMBER, z16);
                    } else if (i3 == 8) {
                        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, z16);
                        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_DISCUSSION_MEMBER, true);
                    }
                } else {
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
                }
                super.startActivityForResult(startSelectMemberActivityIntentForJsPlugin, (byte) 17);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                errorCallBack();
                return;
            }
        }
        errorCallBack();
    }

    public void getDensity(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            AppInterface b16 = this.mRuntime.b();
            if (b16 != null) {
                jSONObject.put("density", ThemeUtil.getThemeDensity(b16.getApplication()));
                jSONObject.put("result", 0);
            } else {
                jSONObject.put("result", -1);
            }
            super.callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            super.callJs(str, e16.getMessage());
            e16.printStackTrace();
        }
    }

    private void backH5Friends(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() != 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                String stringExtra = intent.getStringExtra("group_uin");
                String stringExtra2 = intent.getStringExtra("group_name");
                int intExtra = intent.getIntExtra("group_type", 0);
                int intExtra2 = intent.getIntExtra("group_member_type", 0);
                if (stringExtra != null) {
                    arrayList.add(stringExtra);
                    if (stringExtra2 == null) {
                        stringExtra2 = "";
                    }
                    arrayList2.add(stringExtra2);
                    arrayList3.add(Integer.valueOf(intExtra));
                    arrayList4.add(Integer.valueOf(intExtra2));
                }
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    ResultRecord resultRecord = (ResultRecord) it.next();
                    arrayList5.add(resultRecord.uin);
                    arrayList6.add("");
                    arrayList7.add(resultRecord.name);
                    arrayList8.add(Integer.valueOf(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "doChooseFriendResult...");
                }
                JSONObject jsBackJson = getJsBackJson(intent, arrayList5, arrayList6, arrayList7, arrayList8, arrayList, arrayList2, arrayList4, arrayList3);
                QLog.i(TAG, 2, "doChooseFriendResult: " + jsBackJson);
                if (jsBackJson != null) {
                    lambda$chooseFriends$0(this.mCallback, jsBackJson.toString());
                    return;
                }
                return;
            }
            errorCallBack();
        } catch (Exception unused) {
            errorCallBack();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034 A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:44:0x0010, B:46:0x0014, B:9:0x0034, B:11:0x003a, B:12:0x0053, B:15:0x0071, B:18:0x008d, B:20:0x009f, B:24:0x00a9, B:27:0x00c1, B:30:0x00c7, B:38:0x00a1, B:3:0x001b, B:5:0x0025, B:7:0x002e), top: B:43:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getPerformanceFromX5(JSONObject jSONObject) throws JSONException {
        JSONObject x5Performance;
        SwiftBrowserStatistics swiftBrowserStatistics;
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        if (d16 != null) {
            try {
                if (d16 instanceof u) {
                    x5Performance = ((u) d16).getX5Performance();
                    if (x5Performance == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "report X5 performance: " + x5Performance);
                        }
                        long optLong = x5Performance.optLong("first_screen");
                        long optLong2 = x5Performance.optLong("dns_end") - x5Performance.optLong("dns_start");
                        if (optLong2 < 0) {
                            optLong2 = 0;
                        }
                        long optLong3 = x5Performance.optLong("send_start");
                        long optLong4 = x5Performance.optLong("connect_end") - x5Performance.optLong("connect_start");
                        if (optLong4 < 0) {
                            optLong4 = 0;
                        }
                        long optLong5 = x5Performance.optLong("recv_start");
                        long optLong6 = x5Performance.optLong("recv_end");
                        long j3 = optLong3 == 0 ? optLong6 - optLong5 : optLong6 - optLong3;
                        long j16 = j3 >= 0 ? j3 : 0L;
                        long optLong7 = x5Performance.optLong("ssl_handshake_end") - x5Performance.optLong("ssl_handshake_start");
                        long j17 = optLong7 >= 0 ? optLong7 : 0L;
                        long j18 = optLong - optLong5;
                        long j19 = j18 >= 0 ? j18 : 0L;
                        QLog.i("Web_X5_Performance", 1, "Web_X5_Load_Index, DNS cost: " + optLong2 + ", ssl_handshake cost: " + j17 + ", Connect cost: " + optLong4 + ", receive Cost: " + j16 + ", website Render Cost: " + j19);
                        jSONObject.put("X5_dns", optLong2);
                        jSONObject.put("X5_sslHandeShake", j17);
                        jSONObject.put("X5_connect", optLong4);
                        jSONObject.put("X5_receive", j16);
                        jSONObject.put("X5_websiteRender", j19);
                        return;
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        x5Performance = (!(this.mRuntime.a() instanceof com.tencent.mobileqq.webview.swift.u) || (swiftBrowserStatistics = (SwiftBrowserStatistics) super.getBrowserComponent(-2)) == null) ? null : swiftBrowserStatistics.H0;
        if (x5Performance == null) {
        }
    }
}
