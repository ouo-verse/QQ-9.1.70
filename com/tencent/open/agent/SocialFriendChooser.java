package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.OpenSdkFriendService;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SocialFriendChooser extends FriendChooser implements OpenSdkFriendService.b, HttpCgiAsyncTask.a {
    protected Bundle O0;
    protected String P0;
    protected String Q0;
    protected String R0;
    protected String S0;
    protected String T0;
    protected String U0;
    protected String V0;
    protected String W0;
    protected String X0;
    protected String Y0;
    protected String Z0;

    /* renamed from: a1, reason: collision with root package name */
    protected String f340050a1;

    /* renamed from: b1, reason: collision with root package name */
    protected String f340051b1;

    /* renamed from: c1, reason: collision with root package name */
    protected String f340052c1;

    /* renamed from: d1, reason: collision with root package name */
    protected String f340053d1;

    /* renamed from: e1, reason: collision with root package name */
    protected String f340054e1;

    /* renamed from: f1, reason: collision with root package name */
    protected String f340055f1;

    /* renamed from: h1, reason: collision with root package name */
    protected String[] f340057h1;

    /* renamed from: i1, reason: collision with root package name */
    protected HttpCgiAsyncTask f340058i1;

    /* renamed from: g1, reason: collision with root package name */
    protected ProgressDialog f340056g1 = null;

    /* renamed from: j1, reason: collision with root package name */
    protected Handler f340059j1 = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends Handler {

        /* compiled from: P */
        /* renamed from: com.tencent.open.agent.SocialFriendChooser$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class C9264a implements OpenSdkFriendService.a {
            C9264a() {
            }

            @Override // com.tencent.open.agent.OpenSdkFriendService.a
            public void a() {
                ((OpenFrame) SocialFriendChooser.this.f339794h0.getCurrentView()).o();
            }
        }

        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 10001) {
                if (i3 == 10002) {
                    HttpCgiAsyncTask httpCgiAsyncTask = SocialFriendChooser.this.f340058i1;
                    if (httpCgiAsyncTask != null && !httpCgiAsyncTask.isCancelled()) {
                        SocialFriendChooser.this.f340058i1.cancel(true);
                    }
                    SocialFriendChooser.this.dismissProgressDialog();
                    Intent intent = new Intent();
                    intent.putExtra("key_error_code", -7);
                    intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341057e);
                    SocialFriendChooser.this.setResult(-1, intent);
                    SocialFriendChooser.this.finish();
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle(SocialFriendChooser.this.O0);
            bundle.putString("agentversion", com.tencent.open.adapter.a.f().b());
            bundle.putString("facetype", "mqqface");
            OpenSdkFriendService.c().a(lq3.c.c().a("https://fusion.qq.com/cgi-bin/appstage/get_image_update"), bundle, new C9264a());
        }
    }

    @Override // com.tencent.open.agent.FriendChooser
    public String F2() {
        return this.P0;
    }

    @Override // com.tencent.open.agent.FriendChooser
    public void K2() {
        String string;
        int i3 = this.K0;
        if (i3 == 0) {
            if ("action_invite".equals(this.R0)) {
                string = super.getString(R.string.f170183i9, new Object[]{Integer.valueOf(this.L0)});
            } else if ("action_ask".equals(this.R0)) {
                string = super.getString(R.string.f170187id, new Object[]{Integer.valueOf(this.L0)});
            } else if ("action_gift".equals(this.R0)) {
                string = super.getString(R.string.f170182i8, new Object[]{Integer.valueOf(this.L0)});
            } else if ("action_reactive".equals(this.R0)) {
                string = super.getString(R.string.f170183i9, new Object[]{Integer.valueOf(this.L0)});
            } else {
                string = null;
            }
        } else {
            string = super.getString(R.string.a5_, new Object[]{Integer.valueOf(i3)});
        }
        ToastUtil.a().f(string, 0);
    }

    protected void N2() {
        Intent intent = new Intent();
        intent.putExtra("key_error_code", -5);
        String str = com.tencent.open.business.base.b.f341055c;
        intent.putExtra("key_error_msg", str);
        com.tencent.open.base.f.c("SocialFriendChooser", "initParams:error code:-5; error msg:" + str);
        Bundle bundleExtra = super.getIntent().getBundleExtra("key_params");
        if (bundleExtra != null) {
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : bundleExtra.keySet()) {
                sb5.append(str2 + MsgSummary.STR_COLON + bundleExtra.get(str2).toString() + " ");
            }
            com.tencent.open.base.f.c("SocialFriendChooser", "params=" + sb5.toString());
        }
        super.setResult(-1, intent);
        super.finish();
    }

    protected void P2() {
        ProgressDialog show = ProgressDialog.show(this, "", getResources().getString(R.string.a57), true);
        this.f340056g1 = show;
        show.setCancelable(true);
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.P0);
        bundle.putString("hopenid", this.S0);
        bundle.putString("keystr", this.Q0);
        bundle.putString("keytype", this.T0);
        bundle.putString("platform", this.U0);
        bundle.putString("encrytoken", this.V0);
        String str = this.W0;
        if (str != null) {
            bundle.putString(AdParam.PF, str);
        }
        bundle.putString("appid_for_getting_config", this.P0);
        if ("action_gift".equals(this.R0) || "action_ask".equals(this.R0) || "action_reactive".equals(this.R0)) {
            bundle.putString("typeid", this.Y0);
        }
        bundle.putString("agentversion", com.tencent.open.adapter.a.f().b());
        bundle.putString("appid_for_getting_config", this.P0);
        OpenSdkFriendService.c().b(bundle, this, this.R0);
    }

    protected boolean Q2() {
        String str;
        try {
            this.O0 = super.getIntent().getBundleExtra("key_params");
            this.R0 = super.getIntent().getStringExtra("key_action");
            com.tencent.open.base.f.a("SocialFriendChooser", "-->action = " + this.R0 + " -- mParms = " + this.O0);
            Bundle bundle = this.O0;
            if (bundle != null && bundle.containsKey("appid") && this.O0.containsKey("hopenid") && this.O0.containsKey("keystr") && this.O0.containsKey("keytype") && this.O0.containsKey("platform") && this.O0.containsKey("encrytoken")) {
                this.P0 = this.O0.getString("appid");
                this.Q0 = this.O0.getString("keystr");
                this.S0 = this.O0.getString("hopenid");
                this.T0 = this.O0.getString("keytype");
                this.U0 = this.O0.getString("platform");
                this.V0 = this.O0.getString("encrytoken");
                if (!"".equals(this.P0.trim()) && !"".equals(this.S0.trim()) && !"".equals(this.Q0.trim()) && !"".equals(this.U0.trim()) && !"".equals(this.T0.trim()) && !"".equals(this.V0.trim())) {
                    if ("action_gift".equals(this.R0) || "action_ask".equals(this.R0) || "action_reactive".equals(this.R0)) {
                        this.X0 = this.O0.getString("type");
                        this.f340050a1 = com.tencent.open.base.j.g(this.O0.getString("title"), 12, true, false);
                        this.Z0 = com.tencent.open.base.j.g(this.O0.getString("msg"), 70, true, false);
                        if ("action_ask".equals(this.R0)) {
                            str = "50";
                        } else {
                            str = "1";
                        }
                        this.Y0 = str;
                        if (!"".equals(this.X0.trim()) && !"".equals(this.f340050a1.trim()) && !"".equals(this.Z0.trim())) {
                            if ("action_reactive".equals(this.R0)) {
                                this.Y0 = "51";
                                if (this.O0.containsKey("recImg") && this.O0.containsKey("recImgDec") && this.O0.containsKey("sendImg")) {
                                    this.f340053d1 = this.O0.getString("recImg");
                                    this.f340054e1 = com.tencent.open.base.j.g(this.O0.getString("recImgDec"), 20, true, false);
                                    this.f340055f1 = this.O0.getString("sendImg");
                                    if ("".equals(this.f340053d1) || "".equals(this.f340054e1) || "".equals(this.f340055f1)) {
                                        N2();
                                        return false;
                                    }
                                }
                                N2();
                                return false;
                            }
                            com.tencent.open.base.f.a("SocialFriendChooser", "-->typeid = " + this.Y0);
                        }
                        N2();
                        return false;
                    }
                    if (this.O0.containsKey(AdParam.PF)) {
                        this.W0 = this.O0.getString(AdParam.PF);
                    }
                    if (this.O0.containsKey("img")) {
                        this.f340051b1 = this.O0.getString("img");
                    }
                    if (this.O0.containsKey("source")) {
                        this.f340052c1 = this.O0.getString("source");
                    }
                    OpenSdkFriendService.c().e(this.P0, this.S0);
                    this.f340057h1 = this.O0.getStringArray("BuddiesSelected");
                    return true;
                }
                N2();
                return false;
            }
            N2();
            return false;
        } catch (Exception e16) {
            com.tencent.open.base.f.d("SocialFriendChooser", "initParams exception." + e16.getMessage(), e16);
            N2();
            return false;
        }
    }

    protected void R2(Intent intent) {
        int intExtra = intent.getIntExtra("key_error_code", -6);
        if (intExtra != 0) {
            QQToast.makeText(this, intent.getStringExtra("key_error_msg"), 0).show();
            com.tencent.open.base.f.c("SocialFriendChooser", "onSendAppInvitationComplete{KEY_ERROR_CODE:" + intExtra + "; KEY_ERROR_MSG:" + intent.getStringExtra("key_error_msg") + "}");
        }
        super.setResult(-1, intent);
        super.finish();
    }

    @Override // com.tencent.open.agent.OpenSdkFriendService.b
    public void S1(Intent intent) {
        dismissProgressDialog();
        if (intent.hasExtra("key_error_msg")) {
            QQToast.makeText(com.tencent.open.adapter.a.f().e(), intent.getStringExtra("key_error_msg"), 0).show();
        }
        int intExtra = intent.getIntExtra("key_error_code", -6);
        if (intExtra != 0) {
            com.tencent.open.base.f.c("SocialFriendChooser", "onGetBuddyListError{KEY_ERROR_CODE:" + intExtra + "; KEY_ERROR_MSG:" + intent.getStringExtra("key_error_msg") + "}");
        }
        super.setResult(-1, intent);
        super.finish();
    }

    protected void S2() {
        String a16;
        String str;
        this.f340056g1 = ProgressDialog.show(this, "", super.getString(R.string.f170764a64), true);
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.P0);
        bundle.putString("hopenid", this.S0);
        bundle.putString("keystr", this.Q0);
        bundle.putString("keytype", this.T0);
        bundle.putString("platform", this.U0);
        bundle.putString("encrytoken", this.V0);
        bundle.putString("agentversion", com.tencent.open.adapter.a.f().b());
        bundle.putString("appid_for_getting_config", this.P0);
        if (this.O0.containsKey("desc")) {
            bundle.putString("desc", com.tencent.open.base.j.g(this.O0.getString("desc"), 70, true, false));
        }
        if (this.O0.containsKey("picurl")) {
            bundle.putString("picurl", this.O0.getString("picurl"));
        }
        if (this.O0.containsKey("source")) {
            bundle.putString("source", this.O0.getString("source"));
        }
        if (this.O0.containsKey(AdParam.PF)) {
            bundle.putString(AdParam.PF, this.O0.getString(AdParam.PF));
        }
        if (this.O0.containsKey("sdkv")) {
            bundle.putString("sdkv", this.O0.getString(AdParam.PF));
        }
        if (this.O0.containsKey("sdkp")) {
            bundle.putString("sdkp", this.O0.getString("sdkp"));
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        for (String str2 : this.C0.j()) {
            Friend b16 = this.C0.b(str2);
            if (b16 != null) {
                if (b16.C == -1) {
                    sb5.append(str2);
                    sb5.append(",");
                } else {
                    sb6.append(str2);
                    sb6.append("_");
                    sb6.append(b16.C);
                    sb6.append(",");
                }
            }
        }
        int lastIndexOf = sb5.lastIndexOf(",");
        if (lastIndexOf != -1) {
            sb5.deleteCharAt(lastIndexOf);
        }
        int lastIndexOf2 = sb6.lastIndexOf(",");
        if (lastIndexOf2 != -1) {
            sb6.deleteCharAt(lastIndexOf2);
        }
        bundle.putString("app_rid", String.valueOf(this.C0.f403025d));
        bundle.putString("app_tid", String.valueOf(this.C0.f403026e));
        bundle.putString("recom_openids", sb6.toString());
        if ("action_invite".equals(this.R0)) {
            bundle.putString("invitedopenids", sb5.toString());
            a16 = lq3.c.c().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_invite.cgi");
            str = "GET";
        } else if (!"action_gift".equals(this.R0) && !"action_ask".equals(this.R0) && !"action_reactive".equals(this.R0)) {
            a16 = null;
            str = null;
        } else {
            if ("action_reactive".equals(this.R0)) {
                bundle.putString("imgurl", this.f340055f1);
            } else if (!TextUtils.isEmpty(this.f340051b1)) {
                bundle.putString("imgurl", this.f340051b1);
            }
            if (!TextUtils.isEmpty(this.f340050a1)) {
                bundle.putString("title", this.f340050a1);
            }
            if (!TextUtils.isEmpty(this.Z0)) {
                bundle.putString("sendmsg", this.Z0);
            }
            bundle.putString("receiver", sb5.toString());
            bundle.putString("typeid", this.Y0);
            a16 = lq3.c.c().a("https://appic.qq.com/cgi-bin/appstage/mapp_sendrequest.cgi");
            str = "POST";
        }
        if (a16 != null) {
            HttpCgiAsyncTask httpCgiAsyncTask = new HttpCgiAsyncTask(a16, str, this, true);
            this.f340058i1 = httpCgiAsyncTask;
            httpCgiAsyncTask.b(bundle);
            this.f340059j1.sendEmptyMessageDelayed(10002, 45000L);
        }
    }

    protected void dismissProgressDialog() {
        ProgressDialog progressDialog = this.f340056g1;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f340056g1.dismiss();
        }
    }

    @Override // com.tencent.open.agent.FriendChooser, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
    public void f(JSONObject jSONObject) {
        try {
            dismissProgressDialog();
            int i3 = jSONObject.getInt("ret");
            String string = jSONObject.getString("msg");
            if (i3 == 0) {
                boolean equals = "action_invite".equals(this.R0);
                int i16 = R.string.a5w;
                if (equals) {
                    com.tencent.open.business.base.e.g(IndividuationPlugin.Business_Pendant, "ANDROIDQQ.INVITE.ASSISTANT", this.P0, true);
                } else if ("action_ask".equals(this.R0)) {
                    com.tencent.open.business.base.e.g(IndividuationPlugin.Business_Pendant, "ANDROIDQQ.REQUEST.ASSISTANT", this.P0, true);
                    i16 = R.string.f170189ig;
                } else if ("action_gift".equals(this.R0)) {
                    com.tencent.open.business.base.e.g(IndividuationPlugin.Business_Pendant, "ANDROIDQQ.FREEGIFT.ASSISTANT", this.P0, true);
                    i16 = R.string.f170188ie;
                } else if ("action_reactive".equals(this.R0)) {
                    com.tencent.open.business.base.e.g(IndividuationPlugin.Business_Pendant, "ANDROIDQQ.REACTIVE.ASSISTANT", this.P0, true);
                    i16 = R.string.f13488if;
                }
                QQToast.makeText(this, i16, 0).show();
            }
            Intent intent = new Intent();
            intent.putExtra("key_error_code", i3);
            intent.putExtra("key_error_msg", string);
            intent.putExtra("key_response", jSONObject.toString());
            R2(intent);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("SocialFriendChooser", "SendAppInvitation exception." + e16.getMessage(), e16);
            Intent intent2 = new Intent();
            intent2.putExtra("key_error_code", -4);
            intent2.putExtra("key_error_msg", com.tencent.open.business.base.b.f341054b);
            R2(intent2);
        }
    }

    @Override // com.tencent.open.agent.FriendChooser
    protected int getLayoutId() {
        return R.layout.f168466wx;
    }

    @Override // com.tencent.open.agent.OpenSdkFriendService.b
    public void n2(gp3.d dVar) {
        try {
            dismissProgressDialog();
            if ("action_gift".equals(this.R0) || "action_ask".equals(this.R0) || "action_invite".equals(this.R0) || "action_reactive".equals(this.R0) || "action_story".equals(this.R0)) {
                int i3 = dVar.f403036e;
                this.K0 = i3;
                int i16 = dVar.f403034c;
                if (i16 != -1) {
                    int i17 = dVar.f403035d;
                    if (i16 - i17 == 0) {
                        this.K0 = 0;
                    } else if (i16 - i17 < i3) {
                        this.K0 = i16 - i17;
                    }
                    this.L0 = i16;
                }
                if (this.K0 == 0) {
                    QQToast.makeText(this, super.getString(R.string.f170183i9, new Object[]{Integer.valueOf(i16)}), 0).show();
                }
                gp3.b g16 = gp3.b.g();
                g16.l(dVar.f403037f, dVar.f403039h, dVar.f403040i);
                String[] strArr = this.f340057h1;
                if (strArr != null) {
                    for (String str : strArr) {
                        g16.m(str);
                        this.B0.add(g16.b(str));
                    }
                }
                adjustGridView(true);
                ((OpenFrame) this.f339794h0.getCurrentView()).o();
                this.f340059j1.sendEmptyMessageDelayed(10001, 5000L);
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d("SocialFriendChooser", "GetBuddyList exception." + e16.getMessage(), e16);
            Intent intent = new Intent();
            intent.putExtra("key_error_code", -6);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341056d);
            S1(intent);
        }
        if (QLog.isColorLevel()) {
            if ("action_story".equals(this.R0)) {
                QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchEnd:" + SystemClock.elapsedRealtime());
                return;
            }
            QLog.d("SDKQQAgentPref", 2, "GetInviteFriendSwitch_AGENT:" + SystemClock.elapsedRealtime());
        }
    }

    @Override // com.tencent.open.agent.FriendChooser, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.open.agent.FriendChooser, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f339794h0.i(0);
        View findViewById = findViewById(R.id.fdy);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ImmersiveUtils.setFitsSystemWindows(findViewById, true);
        }
        Q2();
        P2();
        if (this.R0.equals("action_invite")) {
            ((GroupListOpenFrame) this.f339794h0.getCurrentView()).p(super.getString(R.string.i_));
        } else if (this.R0.equals("action_reactive") || this.R0.equals("action_gift") || this.R0.equals("action_ask")) {
            ((GroupListOpenFrame) this.f339794h0.getCurrentView()).p(super.getString(R.string.f170185ib));
        }
        if ("action_invite".equals(this.R0)) {
            com.tencent.open.business.base.e.g("100", "ANDROIDQQ.INVITE.FS", this.P0, true);
            return;
        }
        if ("action_ask".equals(this.R0)) {
            com.tencent.open.business.base.e.g("100", "ANDROIDQQ.REQUEST.FS", this.P0, true);
        } else if ("action_gift".equals(this.R0)) {
            com.tencent.open.business.base.e.g("100", "ANDROIDQQ.FREEGIFT.FS", this.P0, true);
        } else if ("action_reactive".equals(this.R0)) {
            com.tencent.open.business.base.e.g("100", "ANDROIDQQ.REACTIVE.FS", this.P0, true);
        }
    }

    @Override // com.tencent.open.agent.FriendChooser, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f340059j1.removeMessages(10001);
        OpenSdkFriendService.c().f();
    }

    @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
    public void onException(Exception exc) {
        dismissProgressDialog();
        com.tencent.open.base.f.d("SocialFriendChooser", "SendAppInvitation exception." + exc.getMessage(), exc);
        Intent intent = new Intent();
        if (exc instanceof ConnectTimeoutException) {
            intent.putExtra("key_error_code", -7);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341057e);
        } else if (exc instanceof SocketTimeoutException) {
            intent.putExtra("key_error_code", -8);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341058f);
        } else if (exc instanceof MalformedURLException) {
            intent.putExtra("key_error_code", -3);
            intent.putExtra("key_error_msg", "\u8bbf\u95eeurl\u6709\u8bef!");
        } else if (exc instanceof HttpBaseUtil.HttpStatusException) {
            intent.putExtra("key_error_code", -10);
            intent.putExtra("key_error_msg", "Http\u8fd4\u56de\u7801\u5f02\u5e38!");
        } else if (exc instanceof HttpBaseUtil.NetworkUnavailableException) {
            intent.putExtra("key_error_code", -9);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341059g);
        } else if (exc instanceof IOException) {
            intent.putExtra("key_error_code", -2);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341053a);
        } else {
            intent.putExtra("key_error_code", -6);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341056d);
        }
        R2(intent);
    }

    @Override // com.tencent.open.agent.FriendChooser
    protected void startCreateOrAdd() {
        if (!"action_invite".equals(this.R0) && !"action_gift".equals(this.R0) && !"action_ask".equals(this.R0) && !"action_reactive".equals(this.R0)) {
            if ("action_story".equals(this.R0)) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                ArrayList<Friend> arrayList = this.B0;
                Friend[] friendArr = (Friend[]) arrayList.toArray(new Friend[arrayList.size()]);
                bundle.putInt("key_error_code", 0);
                bundle.putParcelableArray("RESULT_BUDDIES_SELECTED", friendArr);
                intent.putExtras(bundle);
                super.setResult(-1, intent);
                super.finish();
                return;
            }
            return;
        }
        S2();
    }
}
