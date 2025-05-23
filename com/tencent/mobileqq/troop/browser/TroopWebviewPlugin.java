package com.tencent.mobileqq.troop.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.troop.jointype.event.TroopAutoApprovalSettingUpdate;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerFragmentApi;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.api.ITroopSelectorApi;
import com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class TroopWebviewPlugin extends WebViewPlugin implements ITroopMemberApiClientApi.a {
    public static final String I = AppSetting.f99554n;
    QQCustomDialog F;
    public String G;
    public String H;

    /* renamed from: d, reason: collision with root package name */
    protected QQProgressDialog f294641d;

    /* renamed from: e, reason: collision with root package name */
    protected int f294642e;

    /* renamed from: f, reason: collision with root package name */
    String f294643f;

    /* renamed from: i, reason: collision with root package name */
    protected Dialog f294645i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f294646m;

    /* renamed from: h, reason: collision with root package name */
    protected int f294644h = -1;
    public final byte C = 5;
    AtomicBoolean D = new AtomicBoolean(false);
    com.tencent.biz.troop.b E = null;

    /* loaded from: classes35.dex */
    class a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f294650d;

        a(String str) {
            this.f294650d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            long j3 = bundle.getLong("lastMsgTime");
            String string = bundle.getString("lastMsgContent");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lastMsgTime", j3);
                jSONObject.put("lastMsgContent", string);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("ret", 0);
                    jSONObject.put("errorMsg", "");
                } else {
                    jSONObject.put("ret", -1);
                    jSONObject.put("errorMsg", "lastSpeakMsg is empty");
                }
                TroopWebviewPlugin.this.callJs(this.f294650d, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            TroopWebviewPlugin troopWebviewPlugin = TroopWebviewPlugin.this;
            if (dialogInterface == troopWebviewPlugin.f294641d) {
                troopWebviewPlugin.f294641d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            TroopWebviewPlugin troopWebviewPlugin = TroopWebviewPlugin.this;
            if (dialogInterface == troopWebviewPlugin.f294645i) {
                troopWebviewPlugin.f294645i = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class d implements ActionSheet.OnButtonClickListener {
        d() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            TroopWebviewPlugin.this.C();
            if (i3 == 0) {
                TroopWebviewPlugin.this.E("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class e implements ITroopMemberApiClientApi.a {
        e() {
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            QLog.i("WebViewPlugin", 1, "handleGetAvatar callback bundle = " + bundle);
            TroopWebviewPlugin.this.J(bundle.getString("troopUin"), (Bitmap) bundle.getParcelable("troopAvatar"));
        }
    }

    private void B(String str) {
        QBaseActivity qBaseActivity = (QBaseActivity) this.mRuntime.a();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(qBaseActivity, R.string.f171137ci2, 0).show(qBaseActivity.getTitleBarHeight());
            return;
        }
        f0(qBaseActivity.getString(R.string.i9h));
        Intent intent = new Intent(qBaseActivity, (Class<?>) TroopCreateLogicActivity.class);
        intent.putExtra("type", 1);
        intent.putExtra("cfg", str);
        startActivityForResult(intent, (byte) 41);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Dialog dialog = this.f294645i;
        if (dialog != null) {
            if (dialog.isShowing()) {
                this.f294645i.dismiss();
            }
            this.f294645i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str) {
        Activity a16 = this.mRuntime.a();
        f0(a16.getString(R.string.i9m));
        Intent intent = new Intent(a16, (Class<?>) TroopCreateLogicActivity.class);
        intent.putExtra("type", 5);
        intent.putExtra("troop_location", str);
        intent.putExtra("troop_uin", this.f294643f);
        startActivityForResult(intent, (byte) 5);
    }

    private void F(String str) {
        String str2;
        Activity a16 = this.mRuntime.a();
        String[] split = str.split("\\|");
        if (split.length >= 4) {
            str2 = split[3];
        } else {
            str2 = "";
        }
        Intent intent = new Intent();
        intent.putExtra("location", str2);
        intent.putExtra("locationOriginal", str);
        a16.setResult(-1, intent);
        a16.finish();
    }

    private void G(String str) {
        String str2 = "";
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        boolean z16 = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("troopUin", "");
            z16 = jSONObject.optBoolean("closeCurPage", false);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (!TextUtils.isEmpty(str2)) {
            Bundle b16 = aq.b(str2, 9);
            b16.putString(AppConstants.Key.TROOP_INFO_TITLE, a16.getString(R.string.dqq));
            b16.putInt(AppConstants.Key.TROOP_INFO_REPORT_FROM, 1);
            ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(a16, b16, 45);
            a16.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
        }
        if (z16) {
            a16.finish();
        }
    }

    private void H() {
        this.mRuntime.a().finish();
    }

    private void I(JSONObject jSONObject, final String str) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null || this.mRuntime.f().getHostActivity() == null) {
            return;
        }
        QLog.i("WebViewPlugin", 1, "#getAddMethodList");
        JSONArray optJSONArray = jSONObject.optJSONArray("groupUin");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            String optString = jSONObject.optString("userFrom", "2");
            this.E.v(optJSONArray.optString(0), optJSONArray.toString(), optString, new ITroopMemberApiClientApi.a() { // from class: com.tencent.mobileqq.troop.browser.d
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
                public final void callback(Bundle bundle) {
                    TroopWebviewPlugin.this.T(str, bundle);
                }
            });
        } else {
            QLog.e("WebViewPlugin", 1, "#getAddMethodList groupUin is empty.");
            callJs(this.H, "{\"retCode\":1,\"errMsg\":\"params groupUin invalid.\"}");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(final String str, final Bitmap bitmap) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.browser.TroopWebviewPlugin.7
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 == null) {
                    return;
                }
                try {
                    String d16 = SubscribeUtils.d(bitmap2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("uin", str);
                    jSONObject.put("avatarData", d16);
                    TroopWebviewPlugin.this.dispatchJsEvent("getTroopAvatarCallback", jSONObject, null);
                } catch (JSONException e16) {
                    QLog.d("WebViewPlugin", 2, e16, new Object[0]);
                }
            }
        }, 8, null, false);
    }

    private void K(final String str) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null || this.mRuntime.f().getHostActivity() == null) {
            return;
        }
        QLog.i("WebViewPlugin", 1, "#getGroupListAsOwner");
        this.E.z(new ITroopMemberApiClientApi.a() { // from class: com.tencent.mobileqq.troop.browser.b
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public final void callback(Bundle bundle) {
                TroopWebviewPlugin.this.U(str, bundle);
            }
        });
    }

    private void L(String... strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString("callback");
            String optString2 = jSONObject.optString("app_id", "");
            String optString3 = jSONObject.optString("guildId", "");
            Bundle bundle = new Bundle();
            bundle.putString("app_id", optString2);
            bundle.putString("guildId", optString3);
            QIPCClientHelper.getInstance().callServer("BindGroupIPCModule", "getGuildData", bundle, new f(optString));
        } catch (JSONException e16) {
            QLog.e("WebViewPlugin", 1, "[getGuildBindGroupExtraData] e = " + e16);
        }
    }

    private HashMap<String, String> M(JSONObject jSONObject) {
        String optString = jSONObject.optString("exts");
        HashMap<String, String> hashMap = null;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(optString);
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString2 = jSONObject2.optString(str);
                if (!TextUtils.isEmpty(optString2)) {
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    hashMap.put(str, optString2);
                }
            }
            return hashMap;
        } catch (JSONException e16) {
            QLog.e("WebViewPlugin", 1, e16, new Object[0]);
            return null;
        }
    }

    private void N(String str) throws JSONException {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null || this.mRuntime.f().getHostActivity() == null) {
            return;
        }
        this.E.H(str, new e());
    }

    private void O(JSONObject jSONObject) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null || this.mRuntime.f().getHostActivity() == null) {
            return;
        }
        QLog.i("WebViewPlugin", 1, "#handleGroupAutoApproval");
        this.E.O(jSONObject);
    }

    private void R(JSONObject jSONObject) {
        String optString = jSONObject.optString("service");
        String optString2 = jSONObject.optString("method");
        String optString3 = jSONObject.optString("body");
        String optString4 = jSONObject.optString("refer");
        final String optString5 = jSONObject.optString("callback");
        HashMap<String, String> M = M(jSONObject);
        QLog.i("WebViewPlugin", 1, "#ssoForward: service=" + optString + ", mthod=" + optString2 + ", refer=" + optString4 + ", extMap=" + M);
        this.E.N0(optString, optString2, optString3.getBytes(StandardCharsets.UTF_8), optString4, M, new ITroopMemberApiClientApi.a() { // from class: com.tencent.mobileqq.troop.browser.c
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public final void callback(Bundle bundle) {
                TroopWebviewPlugin.this.V(optString5, bundle);
            }
        });
    }

    private void S(String str) {
        String str2;
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        try {
            str2 = new JSONObject(str).getString("troopUin");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, str2);
        intent.putExtra("param_type", 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, this.mRuntime.a().getString(R.string.bzv));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, this.mRuntime.a().getString(R.string.f171151ok));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, this.mRuntime.a().getString(R.string.cmh));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 100);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(a16, intent);
        a16.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(String str, Bundle bundle) {
        String string = bundle.getString("groupAddMethodList", "");
        QLog.d("WebViewPlugin", 1, "#getAddMethodList resp callback= " + str + ", data = " + string);
        callJs(str, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(String str, Bundle bundle) {
        callJs(str, bundle.getString("groupListAsOwner", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(String str, Bundle bundle) {
        byte[] byteArray;
        boolean z16 = bundle.getBoolean("success", false);
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                int i3 = bundle.getInt("code", 0);
                String string = bundle.getString("msg", "");
                jSONObject.put("retCode", i3);
                jSONObject.put("retMsg", string);
                if (z16 && (byteArray = bundle.getByteArray("body")) != null) {
                    jSONObject.put("body", new String(byteArray));
                }
                QLog.i("WebViewPlugin", 1, "#troop ssoForward: isSuccess= " + z16 + " , code=" + i3 + ", msg" + string);
                callJs(str, jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("WebViewPlugin", 1, e16, new Object[0]);
                callJs(str, jSONObject.toString());
            }
        } catch (Throwable th5) {
            callJs(str, jSONObject.toString());
            throw th5;
        }
    }

    private void Y(JSONObject jSONObject) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null || this.mRuntime.f().getHostActivity() == null) {
            return;
        }
        QLog.i("WebViewPlugin", 1, "#openDeduplicationPage");
        Intent intent = new Intent();
        intent.putExtra("troop_uin", jSONObject.optString("groupId"));
        intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, jSONObject.optString("userFrom"));
        QPublicFragmentActivity.b.b(this.mRuntime.a(), intent, QPublicFragmentActivity.class, ((ITroopManagerFragmentApi) QRoute.api(ITroopManagerFragmentApi.class)).getTroopMemberDistinctFragmentClass());
    }

    private void a0(String... strArr) {
        String str = "";
        try {
            str = new JSONObject(strArr[0]).optString("uin", "");
        } catch (JSONException e16) {
            QLog.e("WebViewPlugin", 1, "[openSelectTroopListForAIVoice] e = " + e16);
        }
        Activity a16 = this.mRuntime.a();
        if (!TextUtils.isEmpty(str) && a16 != null) {
            Intent startSelectTroopListForJsPlugin = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectTroopListForJsPlugin(a16);
            startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_CREATE_TROOP, true);
            startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_MANAGE_TROOP, true);
            startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_JOIN_TROOP, true);
            startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_UN_NAME_TROOP, false);
            startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_SET_TOP_TROOP, false);
            startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_BLOCK_OR_GAG_TROOP, false);
            startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_TYPE, 4);
            startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_MAX_NUM, 1);
            startActivityForResult(startSelectTroopListForJsPlugin, (byte) 48);
            return;
        }
        QLog.e("WebViewPlugin", 1, "[openSelectTroopListForAIVoice] activity = " + a16);
    }

    private void b0(String... strArr) {
        int i3;
        Activity a16;
        JSONArray optJSONArray;
        String str = "";
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            QLog.i("WebViewPlugin", 1, "[openSelectTroopListForResult] json = " + jSONObject);
            this.G = jSONObject.optString("callback");
            str = jSONObject.optString("troopUin", "");
            i3 = jSONObject.optInt("selectGroupMaxLimit", 100);
            try {
                optJSONArray = jSONObject.optJSONArray("instructions");
            } catch (Exception e16) {
                e = e16;
                QLog.e("WebViewPlugin", 1, "[openSelectTroopListForResult] exception = " + e);
                int i16 = i3;
                a16 = this.mRuntime.a();
                if (TextUtils.isEmpty(str)) {
                }
                QLog.e("WebViewPlugin", 1, "[openSelectTroopListForResult] activity = " + a16);
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                arrayList.add(Integer.valueOf(optJSONArray.getInt(i17)));
            }
            int i162 = i3;
            a16 = this.mRuntime.a();
            if (TextUtils.isEmpty(str) && !arrayList.isEmpty() && a16 != null) {
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106129", true)) {
                    Intent intent = new Intent();
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN, str);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_INSTRUCTION_LIST, arrayList);
                    ((ITroopSelectorApi) QRoute.api(ITroopSelectorApi.class)).openNewTroopSelector(a16, intent, new TroopSelectorConfig(true, i162, true, false, false, new ArrayList(), 3), 47);
                    return;
                }
                Intent startSelectTroopListForJsPlugin = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectTroopListForJsPlugin(a16);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN, str);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_NAME, "\u9009\u62e9\u7fa4\u804a");
                startSelectTroopListForJsPlugin.putExtra("extra_select_finish_text", "\u5e94\u7528");
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_RECENT_TROOP, false);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_CREATE_TROOP, true);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_MANAGE_TROOP, false);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_JOIN_TROOP, false);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_UN_NAME_TROOP, false);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_SET_TOP_TROOP, false);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_TYPE, 3);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_MAX_NUM, i162);
                startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_INSTRUCTION_LIST, arrayList);
                startActivityForResult(startSelectTroopListForJsPlugin, (byte) 47);
                return;
            }
            QLog.e("WebViewPlugin", 1, "[openSelectTroopListForResult] activity = " + a16);
        }
    }

    private void c0(String... strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Long valueOf = Long.valueOf(jSONObject.optLong("group_code"));
            String optString = jSONObject.optString("group_first_level");
            String optString2 = jSONObject.optString("group_second_level");
            HashMap hashMap = new HashMap();
            hashMap.put("dt_eid", "ev_group_create");
            hashMap.put("eid", "ev_group_create");
            hashMap.put("group_id", valueOf);
            hashMap.put("group_owner_uin", this.mRuntime.c().getCurrentAccountUin());
            hashMap.put("group_first_level", optString);
            if (optString2.isEmpty()) {
                optString2 = "0";
            }
            hashMap.put("group_second_level", optString2);
            hashMap.put("source", 6);
            VideoReport.reportEvent("ev_group_create", hashMap);
        } catch (JSONException e16) {
            QLog.e("WebViewPlugin", 1, "[reportCreateTroopByCatogry] e = " + e16);
        }
    }

    private void d0(String str) {
        Activity a16 = this.mRuntime.a();
        Intent intent = new Intent(a16, (Class<?>) TroopCreateLogicActivity.class);
        intent.putExtra("type", 3);
        intent.putExtra("cfg", str);
        a16.startActivity(intent);
    }

    private void f0(String str) {
        QBaseActivity qBaseActivity = (QBaseActivity) this.mRuntime.a();
        D();
        QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
        qQProgressDialog.setMessage(str);
        qQProgressDialog.setCancelable(false);
        qQProgressDialog.setOnDismissListener(new b());
        this.f294641d = qQProgressDialog;
        qQProgressDialog.show();
    }

    private void y(String... strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", jSONObject.optString("appId", ""));
            bundle.putString("guildId", jSONObject.optString("guildId", ""));
            bundle.putString("code", jSONObject.optString("code"));
            bundle.putString("msg", jSONObject.optString("msg"));
            QIPCClientHelper.getInstance().callServer("BindGroupIPCModule", "callbackToGame", bundle, new g());
        } catch (JSONException e16) {
            QLog.e("WebViewPlugin", 1, "[getGuildBindGroupExtraData] e = " + e16);
        }
    }

    public void A() {
        C();
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mRuntime.a(), null);
        actionSheet.setMainTitle(R.string.i9f);
        actionSheet.addButton(R.string.i9g, 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnDismissListener(new c());
        actionSheet.setOnButtonClickListener(new d());
        this.f294645i = actionSheet;
        actionSheet.show();
    }

    void D() {
        QQProgressDialog qQProgressDialog = this.f294641d;
        if (qQProgressDialog != null) {
            if (qQProgressDialog.isShowing()) {
                this.f294641d.dismiss();
            }
            this.f294641d = null;
        }
    }

    public void P(String str) {
        try {
            String string = new JSONObject(str).getString(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            if (this.mRuntime.a() instanceof TroopTagViewActivity) {
                ((TroopTagViewActivity) this.mRuntime.a()).G2(string);
            }
        } catch (JSONException unused) {
        }
    }

    public void Q(String str) {
        Activity a16 = this.mRuntime.a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(IProfileProtocolConst.PARAM_TROOP_CODE);
            boolean z16 = jSONObject.getBoolean("returnMsgList");
            Bundle b16 = aq.b(string, 13);
            b16.putBoolean("returnMsgList", z16);
            ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(a16, b16);
            if (z16) {
                a16.finish();
            }
        } catch (JSONException unused) {
        }
    }

    public void W(String str) {
        QBaseActivity qBaseActivity = (QBaseActivity) this.mRuntime.a();
        try {
            String optString = new JSONObject(str).optString("location", "");
            if (!this.f294646m) {
                X(optString);
                return;
            }
            if (!NetworkUtil.isNetSupport(qBaseActivity)) {
                QQToast.makeText(qBaseActivity, R.string.f171137ci2, 0).show(qBaseActivity.getTitleBarHeight());
            } else if (TextUtils.isEmpty(optString)) {
                A();
            } else {
                E(optString);
            }
        } catch (Exception unused) {
        }
    }

    public void X(String str) {
        QBaseActivity qBaseActivity = (QBaseActivity) this.mRuntime.a();
        if (!NetworkUtil.isNetSupport(qBaseActivity)) {
            QQToast.makeText(qBaseActivity, R.string.f171137ci2, 0).show(qBaseActivity.getTitleBarHeight());
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            F(str);
        }
    }

    public void Z(String str, String str2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("groupCode=" + str);
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("&groupMemberUin=" + str2);
        }
        if (i3 != -1) {
            stringBuffer.append("&shielded=" + i3);
        }
        String str3 = "mqq://troop_member_card/open_member_recent_chat_view/?" + stringBuffer.toString();
        if (QLog.isColorLevel()) {
            QLog.d("WebViewPlugin", 2, "jump: " + str3);
        }
        this.mRuntime.a().startActivity(new Intent().setData(Uri.parse(str3)));
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "Troop";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934618L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!str2.equals("Troop")) {
            return false;
        }
        addOpenApiListenerIfNeeded(str3, jsBridgeListener);
        int i3 = -1;
        final String str4 = null;
        if ("init".equals(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                int optInt = jSONObject.optInt("appid");
                String optString = jSONObject.optString("openGroupId");
                String optString2 = jSONObject.optString("token");
                if (!TextUtils.isEmpty(optInt + "") && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    String url = this.mRuntime.e().getUrl();
                    int indexOf = url.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    this.E.v0(optInt, optString, optString2, indexOf == -1 ? null : url.substring(0, indexOf), "init", this);
                }
                callJs4OpenApi(jsBridgeListener, 4, JsBridgeListener.a(4, null, null));
                return false;
            } catch (JSONException unused) {
            }
        } else if (!str3.equals("setTitleButton")) {
            if (str3.equals("commitGroupInfo")) {
                B(strArr[0]);
            } else if (str3.equals("shareGroup")) {
                d0(strArr[0]);
            } else if (str3.equals("inviteMemberToGroup")) {
                S(strArr[0]);
            } else if (str3.equals("enterGroupInfoCard")) {
                G(strArr[0]);
            } else if (str3.equals("modifyTroopLocation")) {
                W(strArr[0]);
            } else if (str3.equals("finishCreateGroup")) {
                H();
            } else if (str3.equals("insertCreateGroupSuccessMsg")) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    this.E.u0(jSONObject2.getString("troopUin"), jSONObject2.getString("groupName"), jSONObject2.optInt(QFSEdgeItem.KEY_CATE_ID), jSONObject2.optString("callback"), this);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            } else if (str3.equals("showGroupHeadEditView")) {
                e0(strArr[0]);
            } else if (str3.equals("searchTroop")) {
                QQToast.makeText(this.mRuntime.a(), 0, "\u8be5api\u529f\u80fd\u5df2\u4e0b\u67b6!", 0).show();
            } else if (str3.equals("didModifyGroupTags")) {
                P(strArr[0]);
                jsBridgeListener.c(Boolean.TRUE);
            } else if (str3.equals("openTroopProfileEdit")) {
                Q(strArr[0]);
            } else if (str3.equals("showTroopProfile")) {
                QQToast.makeText(this.mRuntime.a(), 0, "\u8be5api\u529f\u80fd\u5df2\u4e0b\u67b6!", 0).show();
            } else if (str3.equals("getVersion")) {
                jsBridgeListener.c(I);
            } else if (str3.equals("isNetworkConnected")) {
                jsBridgeListener.c(Boolean.valueOf(com.tencent.open.base.a.a(com.tencent.open.adapter.a.f().e())));
            } else if (str3.equals("openUrl")) {
                v(strArr[0]);
            } else if (!str3.equals("setWebDataCache") && !str3.equals("getWebDataCache")) {
                if ("getUniqueTitleNewFlag".equals(str3)) {
                    try {
                        String optString3 = new JSONObject(strArr[0]).optString("callback");
                        Activity a16 = this.mRuntime.a();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(this.mRuntime.b().getCurrentAccountUin());
                        sb5.append("_troopManager");
                        callJs(optString3, "{\"showFlag\":" + ((a16.getSharedPreferences(sb5.toString(), 0).getInt(IUniqueTitleService.UNIQUE_TITLE_NEW_FLAG, 0) & 2) == 0) + "}");
                        return true;
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                } else {
                    if ("setUniqueTitleNewFlag".equals(str3)) {
                        SharedPreferences sharedPreferences = this.mRuntime.a().getSharedPreferences(this.mRuntime.b().getCurrentAccountUin() + "_troopManager", 0);
                        sharedPreferences.edit().putInt(IUniqueTitleService.UNIQUE_TITLE_NEW_FLAG, sharedPreferences.getInt(IUniqueTitleService.UNIQUE_TITLE_NEW_FLAG, 0) | 2).commit();
                        return true;
                    }
                    if ("createDingdong".equals(str3)) {
                        try {
                            new JSONObject(strArr[0]).getString("troopUin");
                        } catch (JSONException e18) {
                            e18.printStackTrace();
                        }
                        return true;
                    }
                    if ("updateTroopBindedPubAccount".equals(str3)) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(strArr[0]);
                            long j3 = jSONObject3.getLong("troopPubAccountUin");
                            JSONArray jSONArray = jSONObject3.getJSONArray("groupCodeList");
                            int length = jSONArray.length();
                            if (length > 0) {
                                long[] jArr = new long[length];
                                for (int i16 = 0; i16 < length; i16++) {
                                    jArr[i16] = jSONArray.getLong(i16);
                                }
                                this.E.P0(j3, jArr);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(PublicAccountDetailActivityImpl.TAG_TROOP, 2, "updateTroopBindedPubAccount:" + strArr[0]);
                            }
                        } catch (JSONException e19) {
                            if (QLog.isColorLevel()) {
                                QLog.e(PublicAccountDetailActivityImpl.TAG_TROOP, 2, e19.toString());
                            }
                        }
                    } else if ("getLastSpeakMessage".equals(str3)) {
                        try {
                            JSONObject jSONObject4 = new JSONObject(strArr[0]);
                            this.E.B(jSONObject4.optString("groupCode"), jSONObject4.optString("groupMemberUin"), new a(jSONObject4.optString("callback")));
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopWebviewPlugin", 2, "getLastSpeakMessage:" + strArr[0]);
                            }
                        } catch (JSONException e26) {
                            e26.printStackTrace();
                        }
                    } else if ("openRecentChatView".equals(str3)) {
                        try {
                            JSONObject jSONObject5 = new JSONObject(strArr[0]);
                            Z(jSONObject5.optString("groupCode"), jSONObject5.optString("groupMemberUin"), jSONObject5.optInt("shielded"));
                        } catch (JSONException e27) {
                            e27.printStackTrace();
                        }
                    } else {
                        String str5 = "{\"ret\":0}";
                        if ("notifyTroopEnterEffectStatus".equals(str3)) {
                            try {
                                JSONObject jSONObject6 = new JSONObject(strArr[0]);
                                String optString4 = jSONObject6.optString("callback");
                                JSONArray optJSONArray = jSONObject6.optJSONArray("groupCodeList");
                                ArrayList<Integer> arrayList = new ArrayList<>();
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                                        if (optJSONArray.optInt(i17) > 0) {
                                            arrayList.add(Integer.valueOf(optJSONArray.optInt(i17)));
                                        }
                                    }
                                }
                                this.E.W(arrayList, jSONObject6.optInt("effectId"), jSONObject6.optInt("svipLevel"), jSONObject6.optInt("svipType"), jSONObject6.optString("effectName"));
                                super.callJs(optString4, "{\"ret\":0}");
                            } catch (JSONException e28) {
                                e28.printStackTrace();
                            }
                        } else if ("returnToTroopAIO".equals(str3)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopWebviewPlugin", 2, "returnToTroopAIO:" + strArr[0]);
                            }
                            try {
                                str4 = new JSONObject(strArr[0]).optString("gc");
                                if (TextUtils.isEmpty(str4)) {
                                    return false;
                                }
                            } catch (JSONException e29) {
                                e29.printStackTrace();
                            }
                            if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel())) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Sensor", 2, "meizu mx2 returnToTroopAIO");
                                }
                                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.browser.TroopWebviewPlugin.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        TroopWebviewPlugin troopWebviewPlugin = TroopWebviewPlugin.this;
                                        SensorAPIJavaScript.returnToAio(troopWebviewPlugin.E, troopWebviewPlugin.mRuntime.a(), str4, true);
                                    }
                                }, 400L);
                            } else {
                                SensorAPIJavaScript.returnToAio(this.E, this.mRuntime.a(), str4, true);
                            }
                        } else if ("notifyCreateTroops".equals(str3)) {
                            try {
                                JSONObject jSONObject7 = new JSONObject(strArr[0]);
                                String optString5 = jSONObject7.optString("groupCode");
                                if (TextUtils.isEmpty(optString5)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("WebViewPlugin", 2, "METHOD_NOTIFY_TROOP_CREATE uin empty");
                                    }
                                    return false;
                                }
                                this.E.V(optString5, jSONObject7.optString("chat_type"), jSONObject7.optString("package_id"), jSONObject7.optString("appChannel"), jSONObject7.optString("pginSource"), jSONObject7.optString("callback"), this);
                            } catch (JSONException e36) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("WebViewPlugin", 2, "METHOD_NOTIFY_TROOP_CREATE," + e36.toString(), e36);
                                }
                            }
                        } else if ("notifySwitchStatus".equals(str3)) {
                            try {
                                JSONObject jSONObject8 = new JSONObject(strArr[0]);
                                String optString6 = jSONObject8.optString("callback");
                                JSONArray optJSONArray2 = jSONObject8.optJSONArray("data");
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    ArrayList<String> arrayList2 = new ArrayList<>();
                                    for (int i18 = 0; i18 < optJSONArray2.length(); i18++) {
                                        JSONObject jSONObject9 = optJSONArray2.getJSONObject(i18);
                                        arrayList2.add(jSONObject9.optString("groupCode") + "," + jSONObject9.optInt("status"));
                                    }
                                    this.E.X(arrayList2);
                                } else {
                                    QLog.e("WebViewPlugin", 1, "notifySwitchStatus dataArray is empty");
                                    str5 = "{\"ret\":-1}";
                                }
                                super.callJs(optString6, str5);
                            } catch (Exception e37) {
                                QLog.e("WebViewPlugin", 1, "notifySwitchStatus error: " + e37.toString());
                            }
                        } else if ("updateTroopAnnouncement".equals(str3)) {
                            try {
                                JSONObject jSONObject10 = new JSONObject(strArr[0]);
                                Activity a17 = this.mRuntime.a();
                                if (a17 != null && jSONObject10.has("lastAnnouncement") && jSONObject10.has("groupCode")) {
                                    long optLong = jSONObject10.optLong("groupCode");
                                    String optString7 = jSONObject10.optString("lastAnnouncement");
                                    Intent intent = new Intent();
                                    intent.putExtra("groupCode", optLong);
                                    intent.putExtra("lastAnnouncement", optString7);
                                    intent.putExtra("updateFromWeb", true);
                                    a17.setResult(-1, intent);
                                    str4 = optString7;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i("WebViewPlugin", 2, String.format("updateTroopAnnouncement [%s, %s, %s]", str4, Boolean.valueOf(jSONObject10.has("lastAnnouncement")), a17));
                                }
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        } else if ("updateTroopAutoApprovalSetting".equals(str3)) {
                            try {
                                JSONObject jSONObject11 = new JSONObject(strArr[0]);
                                Activity a18 = this.mRuntime.a();
                                if (a18 != null && jSONObject11.has("autoApprovalSetting") && jSONObject11.has("groupCode")) {
                                    long optLong2 = jSONObject11.optLong("groupCode");
                                    int optInt2 = jSONObject11.optInt("autoApprovalSetting");
                                    SimpleEventBus.getInstance().dispatchEvent(new TroopAutoApprovalSettingUpdate(true, optLong2, optInt2 == 1), true);
                                    i3 = optInt2;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i("WebViewPlugin", 2, String.format("updateAutoApprovalSetting [%s, %s, %s]", Integer.valueOf(i3), Boolean.valueOf(jSONObject11.has("autoApprovalSetting")), a18));
                                }
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        } else if ("ssoForward".equals(str3)) {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("WebViewPlugin", 2, "ssoForward:" + strArr[0]);
                                }
                                R(new JSONObject(strArr[0]));
                            } catch (Throwable unused2) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("WebViewPlugin", 2, "ssoForward json fail");
                                }
                            }
                        } else if ("openAutoReplaceGroupSelector".equals(str3)) {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("WebViewPlugin", 2, "openGroupSelector:" + strArr[0]);
                                }
                                this.G = null;
                                JSONObject jSONObject12 = new JSONObject(strArr[0]);
                                String optString8 = jSONObject12.optString("callback");
                                AppInterface b16 = this.mRuntime.b();
                                if (b16 != null && b16.isLogin()) {
                                    Activity a19 = this.mRuntime.a();
                                    if (a19 != null) {
                                        this.G = optString8;
                                        String optString9 = jSONObject12.optString("troopUin");
                                        String optString10 = jSONObject12.optString("troopName");
                                        int optInt3 = jSONObject12.optInt("selectGroupMaxLimit", 9);
                                        Intent startSelectTroopListForJsPlugin = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectTroopListForJsPlugin(a19);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_RECENT_TROOP, false);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_CREATE_TROOP, true);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_MANAGE_TROOP, false);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_JOIN_TROOP, false);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_UN_NAME_TROOP, false);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_SET_TOP_TROOP, false);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_TYPE, 1);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN, optString9);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_NAME, optString10);
                                        startSelectTroopListForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_MAX_NUM, optInt3);
                                        startActivityForResult(startSelectTroopListForJsPlugin, (byte) 46);
                                    }
                                }
                                callJs(optString8, "{\"ret\":2, \"errMsg\":\"not login\"}");
                                return true;
                            } catch (Throwable unused3) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("WebViewPlugin", 2, "openGroupSelector json fail");
                                }
                            }
                        } else if ("getAvatar".equals(str3)) {
                            if (strArr != null && strArr.length >= 1) {
                                try {
                                    N(strArr[0]);
                                } catch (Throwable unused4) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("WebViewPlugin", 2, "getavatar json fail");
                                    }
                                }
                            } else {
                                QLog.e("WebViewPlugin", 2, "args is null");
                                return false;
                            }
                        } else if ("groupAutoApproval".equals(str3)) {
                            if (strArr != null && strArr.length >= 1) {
                                try {
                                    O(new JSONObject(strArr[0]));
                                } catch (Throwable unused5) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("WebViewPlugin", 2, "groupAutoApproval json fail");
                                    }
                                }
                            } else {
                                QLog.e("WebViewPlugin", 2, "groupAutoApproval args is null");
                                return false;
                            }
                        } else if ("getGroupListAsOwner".equals(str3)) {
                            if (strArr != null && strArr.length >= 1) {
                                try {
                                    K(new JSONObject(strArr[0]).optString("callback"));
                                } catch (Throwable unused6) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("WebViewPlugin", 2, "getGroupListAsOwner json fail");
                                    }
                                }
                            } else {
                                QLog.e("WebViewPlugin", 2, "getGroupListAsOwner args is null");
                                return false;
                            }
                        } else if ("openGroupDeduplicationPage".equals(str3)) {
                            if (strArr != null && strArr.length >= 1) {
                                try {
                                    Y(new JSONObject(strArr[0]));
                                } catch (Throwable unused7) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("WebViewPlugin", 2, "openGroupDeduplicationPage json fail");
                                    }
                                }
                            } else {
                                QLog.e("WebViewPlugin", 2, "args is null");
                                return false;
                            }
                        } else if ("groupAddMethodList".equals(str3)) {
                            if (strArr != null && strArr.length >= 1) {
                                try {
                                    JSONObject jSONObject13 = new JSONObject(strArr[0]);
                                    I(jSONObject13, jSONObject13.optString("callback"));
                                } catch (Throwable unused8) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("WebViewPlugin", 2, "openGroupDeduplicationPage json fail");
                                    }
                                }
                            } else {
                                QLog.e("WebViewPlugin", 2, "args is null");
                                return false;
                            }
                        } else if ("getGuildData".equals(str3)) {
                            L(strArr);
                        } else if ("callbackToGame".equals(str3)) {
                            y(strArr);
                        } else if ("createNewQun".equals(str3)) {
                            z(strArr);
                        } else if ("reportCreateGroup".equals(str3)) {
                            c0(strArr);
                        } else if ("applyQRobotInstructionCopy".equals(str3)) {
                            b0(strArr);
                        } else {
                            if (!"openTroopListForAIVoice".equals(str3)) {
                                return false;
                            }
                            a0(strArr);
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String string;
        super.onActivityResult(intent, b16, i3);
        QBaseActivity qBaseActivity = (QBaseActivity) this.mRuntime.a();
        if (b16 == 5) {
            if (intent == null || i3 != -1) {
                return;
            }
            int intExtra = intent.getIntExtra("errCode", -1);
            boolean booleanExtra = intent.getBooleanExtra("isClear", false);
            String stringExtra = intent.getStringExtra("location");
            int intExtra2 = intent.getIntExtra(QCircleSchemeAttr.Polymerize.LAT, 0);
            int intExtra3 = intent.getIntExtra("lon", 0);
            if (intExtra == 0) {
                if (booleanExtra) {
                    QQToast.makeText(qBaseActivity, R.string.i9e, 0).show(qBaseActivity.getTitleBarHeight());
                } else {
                    QQToast.makeText(qBaseActivity, R.string.i9j, 0).show(qBaseActivity.getTitleBarHeight());
                }
                Intent intent2 = new Intent();
                intent2.putExtra("location", stringExtra);
                intent2.putExtra(QCircleSchemeAttr.Polymerize.LAT, intExtra2);
                intent2.putExtra("lon", intExtra3);
                qBaseActivity.setResult(-1, intent2);
                qBaseActivity.finish();
                return;
            }
            if (intExtra == 1002) {
                string = qBaseActivity.getString(R.string.i9r);
            } else if (booleanExtra) {
                string = qBaseActivity.getString(R.string.i9d);
            } else {
                string = qBaseActivity.getString(R.string.i9i);
            }
            QQToast.makeText(qBaseActivity, string, 0).show(qBaseActivity.getTitleBarHeight());
            return;
        }
        switch (b16) {
            case 41:
                D();
                if (intent == null || i3 != -1) {
                    return;
                }
                int intExtra4 = intent.getIntExtra("retCode", -1);
                String stringExtra2 = intent.getStringExtra("troopUin");
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "";
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", intExtra4);
                    jSONObject.put("troopUin", TextUtils.isEmpty(stringExtra2) ? "" : stringExtra2);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                x("onCreateGroupResult", jSONObject.toString());
                if (intExtra4 == 0) {
                    this.f294643f = stringExtra2;
                    return;
                }
                return;
            case 42:
                if (intent == null || i3 != -1) {
                    return;
                }
                x("onGroupInfoModified", intent.getStringExtra("modifiedInfo"));
                return;
            case 43:
                if (intent == null || i3 != -1) {
                    return;
                }
                this.f294644h = intent.getIntExtra("isBack", -1);
                return;
            case 44:
                intent.getBooleanExtra("has_head", false);
                return;
            case 45:
                if (TextUtils.isEmpty(this.f294643f)) {
                    return;
                }
                Intent intent3 = new Intent(this.mRuntime.a(), (Class<?>) TroopCreateLogicActivity.class);
                intent3.putExtra("type", 4);
                intent3.putExtra("troop_uin", this.f294643f);
                startActivityForResult(intent3, (byte) 42);
                return;
            case 46:
                if (intent == null || i3 != -1) {
                    return;
                }
                if (!TextUtils.isEmpty(this.G)) {
                    int intExtra5 = intent.getIntExtra("ret", 0);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ret", intExtra5);
                        if (intExtra5 == 0) {
                            jSONObject2.put("selectTroopResult", new JSONObject(intent.getStringExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_RESULT)));
                        } else {
                            jSONObject2.put("errMsg", intent.getStringExtra("errMsg"));
                        }
                        callJs(this.G, jSONObject2.toString());
                        return;
                    } catch (JSONException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("WebViewPlugin", 2, "select contact result json exception", e17);
                        }
                        callJs(this.G, "{\"ret\":3,\"errMsg\":\"Json Parse Error\"}");
                        return;
                    }
                }
                callJs(this.G, "{\"ret\":1,\"errMsg\":\"User cancle\"}");
                return;
            case 47:
                if (intent == null || i3 != -1 || TextUtils.isEmpty(this.G)) {
                    return;
                }
                callJs(this.G, "{\"ret\":0}");
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        int intExtra = this.mRuntime.a().getIntent().getIntExtra("troop_create_from", 0);
        this.f294642e = intExtra;
        if (intExtra != 0) {
            this.mRuntime.a().setResult(-1);
        }
        if (this.D.compareAndSet(false, true)) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.E = A;
            A.p();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        if (this.D.get()) {
            this.E.q();
        }
        QQCustomDialog qQCustomDialog = this.F;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.F = null;
        }
    }

    public void v(String str) {
        try {
            String string = new JSONObject(str).getString("url");
            if (string != null) {
                Activity a16 = this.mRuntime.a();
                com.tencent.mobileqq.troop.browser.a.a(a16, a16.getIntent().getExtras(), string);
            }
        } catch (JSONException unused) {
        }
    }

    protected void x(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replace("\"", "\\\"");
        }
        this.mRuntime.e().loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + str + "(\"" + str2 + "\")");
    }

    private void z(String... strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("isShowNewCreateGroupPage", Integer.valueOf(((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).isNewCreateTroopExperiment() ? 1 : 0));
            callJs(jSONObject.optString("callback"), jSONObject2.toString());
        } catch (JSONException e16) {
            QLog.e("WebViewPlugin", 1, "[callbackToNewCreateTroop] e = " + e16);
        }
    }

    public void e0(String str) {
        QLog.e("WebViewPlugin", 1, "TroopCreateAvatarActivity \u5df2\u5728725\u4e0b\u67b6");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class f implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f294656d;

        f(String str) {
            this.f294656d = str;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult == null) {
                return;
            }
            String string = eIPCResult.data.getString("guildData");
            if (!eIPCResult.isSuccess() && string == null) {
                TroopWebviewPlugin.this.callJs(this.f294656d, "{}");
            } else {
                TroopWebviewPlugin.this.callJs(this.f294656d, string);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
    public void callback(Bundle bundle) {
        String str;
        if (bundle == null) {
            return;
        }
        int i3 = 2;
        if (bundle.getInt("type") == com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_UIN_BY_OPEN_ID) {
            bundle.getBoolean("isSuccess");
            bundle.getInt("appid");
            bundle.getString("openGroupId");
            bundle.getString("token");
            String string = bundle.getString("uin");
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "callback,uin:" + string);
                return;
            }
            return;
        }
        if (bundle.getInt("type") == com.tencent.mobileqq.troop.api.observer.e.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY) {
            boolean z16 = bundle.getBoolean("isSuccess");
            int i16 = bundle.getInt("appid");
            String string2 = bundle.getString("openGroupId");
            String string3 = bundle.getString("token");
            int i17 = bundle.getInt("freq");
            int i18 = bundle.getInt("expireTime");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("apilist");
            int i19 = bundle.getInt("retCode");
            if (!z16) {
                if (i19 != 0) {
                    switch (i19) {
                        case 1000:
                        case 1001:
                        case 1002:
                        case 1003:
                        case 1005:
                        case 1006:
                            i3 = 4;
                            break;
                        case 1004:
                            break;
                        default:
                            i3 = -100;
                            break;
                    }
                } else {
                    i3 = 0;
                }
                callJs4OpenApiIfNeeded("init", i3, " server retCode:" + i19);
                return;
            }
            CustomWebView e16 = this.mRuntime.e();
            if (e16 != null) {
                e16.saveToken(i16, string2, string3, i17, i18, stringArrayList);
                callJs4OpenApiIfNeeded("init", 0, stringArrayList.toString());
                return;
            } else {
                callJs(bundle.getString("callback"), "webView == null");
                return;
            }
        }
        if ("troopCreateOpenAIO".equals(bundle.getString("type"))) {
            boolean z17 = bundle.getBoolean("isSuccess", false);
            JSONObject jSONObject = new JSONObject();
            if (z17) {
                str = "0";
            } else {
                str = "1";
            }
            try {
                jSONObject.put("ret", str);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            callJs(bundle.getString("callback"), jSONObject.toString());
            return;
        }
        callJs(bundle.getString("callback"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934593L || j3 == 8589934601L || j3 != 2 || this.f294644h == -1) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isBack", this.f294644h);
            x("onGetGroupHeadEditViewBack", jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        this.f294644h = -1;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class g implements EIPCResultCallback {
        g() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
        }
    }
}
