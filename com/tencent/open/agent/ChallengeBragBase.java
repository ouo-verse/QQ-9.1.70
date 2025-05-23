package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class ChallengeBragBase extends QBaseActivity implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    protected String f339730a0;

    /* renamed from: b0, reason: collision with root package name */
    protected String f339731b0;

    /* renamed from: c0, reason: collision with root package name */
    protected String f339732c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f339733d0;

    /* renamed from: e0, reason: collision with root package name */
    protected String f339734e0;

    /* renamed from: f0, reason: collision with root package name */
    protected String f339735f0;

    /* renamed from: g0, reason: collision with root package name */
    protected String f339736g0;

    /* renamed from: h0, reason: collision with root package name */
    protected String f339737h0;

    /* renamed from: i0, reason: collision with root package name */
    protected String f339738i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    protected String f339739j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    protected String f339740k0;

    /* renamed from: l0, reason: collision with root package name */
    protected String f339741l0;

    /* renamed from: m0, reason: collision with root package name */
    protected String f339742m0;

    /* renamed from: n0, reason: collision with root package name */
    protected Bundle f339743n0;

    /* renamed from: o0, reason: collision with root package name */
    protected ProgressDialog f339744o0;

    /* renamed from: p0, reason: collision with root package name */
    protected TextView f339745p0;

    /* renamed from: q0, reason: collision with root package name */
    protected TextView f339746q0;

    /* renamed from: r0, reason: collision with root package name */
    protected TextView f339747r0;

    /* renamed from: s0, reason: collision with root package name */
    protected EditText f339748s0;

    /* renamed from: t0, reason: collision with root package name */
    protected String f339749t0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class a implements HttpCgiAsyncTask.a {
        protected a() {
        }

        protected void a(Intent intent) {
            int intExtra = intent.getIntExtra("key_error_code", -6);
            if (intExtra != 0) {
                QQToast.makeText(ChallengeBragBase.this, intent.getStringExtra("key_error_msg"), 0).show();
                com.tencent.open.base.f.c("qqBaseActivity", "onGetNickNameError{KEY_ERROR_CODE:" + intExtra + "; KEY_ERROR_MSG:" + intent.getStringExtra("key_error_msg") + "}");
            }
            ChallengeBragBase.this.setResult(-1, intent);
            ChallengeBragBase.this.finish();
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void f(JSONObject jSONObject) {
            try {
                ChallengeBragBase.this.dismissProgressDialog();
                int i3 = jSONObject.getInt("ret");
                String string = jSONObject.getString("msg");
                if (i3 != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("key_error_code", i3);
                    intent.putExtra("key_error_msg", string);
                    intent.putExtra("key_response", jSONObject.toString());
                    a(intent);
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                if (jSONArray.length() == 0) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_error_code", -5);
                    intent2.putExtra("key_error_msg", com.tencent.open.business.base.b.f341055c);
                    intent2.putExtra("key_error_detail", HardCodeUtil.qqStr(R.string.kay));
                    a(intent2);
                    return;
                }
                String g16 = com.tencent.open.base.j.g(com.tencent.open.base.j.a(jSONArray.getJSONObject(0).getString("nick")), 12, true, true);
                if ("action_brag".equals(ChallengeBragBase.this.f339749t0)) {
                    ChallengeBragBase challengeBragBase = ChallengeBragBase.this;
                    challengeBragBase.f339745p0.setText(challengeBragBase.getString(R.string.f170181i7, g16));
                } else if ("action_challenge".equals(ChallengeBragBase.this.f339749t0)) {
                    ChallengeBragBase challengeBragBase2 = ChallengeBragBase.this;
                    challengeBragBase2.f339745p0.setText(challengeBragBase2.getString(R.string.f170184ia, g16));
                }
            } catch (JSONException e16) {
                com.tencent.open.base.f.d("qqBaseActivity", "GetNickNameCallback exception." + e16.getMessage(), e16);
                Intent intent3 = new Intent();
                intent3.putExtra("key_error_code", -4);
                intent3.putExtra("key_error_msg", com.tencent.open.business.base.b.f341054b);
                a(intent3);
            } catch (Exception e17) {
                onException(e17);
            }
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void onException(Exception exc) {
            ChallengeBragBase.this.dismissProgressDialog();
            com.tencent.open.base.f.d("qqBaseActivity", "GetNickNameCallback exception." + exc.getMessage(), exc);
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
            a(intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class b implements HttpCgiAsyncTask.a {
        protected b() {
        }

        protected void a(Intent intent) {
            int intExtra = intent.getIntExtra("key_error_code", -6);
            if (intExtra != 0) {
                QQToast.makeText(ChallengeBragBase.this, intent.getStringExtra("key_error_msg"), 0).show();
                com.tencent.open.base.f.c("qqBaseActivity", "onSendChallengeComplete error:{KEY_ERROR_CODE:" + intExtra + "; KEY_ERROR_MSG:" + intent.getStringExtra("key_error_msg") + "}");
            }
            ChallengeBragBase.this.setResult(-1, intent);
            ChallengeBragBase.this.finish();
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void f(JSONObject jSONObject) {
            String str;
            int i3;
            try {
                ChallengeBragBase.this.dismissProgressDialog();
                int i16 = jSONObject.getInt("ret");
                String string = jSONObject.getString("msg");
                if (i16 == 0) {
                    if ("action_brag".equals(ChallengeBragBase.this.f339749t0)) {
                        str = "ANDROIDQQ.BRAG.ASSISTANT";
                        i3 = R.string.a5x;
                    } else if ("action_challenge".equals(ChallengeBragBase.this.f339749t0)) {
                        str = "ANDROIDQQ.PK.ASSISTANT";
                        i3 = R.string.a5y;
                    } else {
                        str = null;
                        i3 = 0;
                    }
                    if (str != null) {
                        com.tencent.open.business.base.e.g(IndividuationPlugin.Business_Pendant, str, ChallengeBragBase.this.f339730a0, true);
                        QQToast.makeText(ChallengeBragBase.this, i3, 0).show();
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("key_error_code", i16);
                intent.putExtra("key_error_msg", string);
                intent.putExtra("key_response", jSONObject.toString());
                a(intent);
            } catch (JSONException e16) {
                com.tencent.open.base.f.d("qqBaseActivity", "SendChallenge exception." + e16.getMessage(), e16);
                Intent intent2 = new Intent();
                intent2.putExtra("key_error_code", -4);
                intent2.putExtra("key_error_msg", com.tencent.open.business.base.b.f341054b);
                a(intent2);
            } catch (Exception e17) {
                onException(e17);
            }
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void onException(Exception exc) {
            ChallengeBragBase.this.dismissProgressDialog();
            com.tencent.open.base.f.d("qqBaseActivity", "SendChallenge exception." + exc.getMessage(), exc);
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
            a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F2() {
        Intent intent = new Intent();
        intent.putExtra("key_error_code", -5);
        String str = com.tencent.open.business.base.b.f341055c;
        intent.putExtra("key_error_msg", str);
        com.tencent.open.base.f.c("qqBaseActivity", "initParams:error code:-5; error msg:" + str);
        if (this.f339743n0 != null) {
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : this.f339743n0.keySet()) {
                sb5.append(str2 + MsgSummary.STR_COLON + this.f339743n0.get(str2).toString() + " ");
            }
            com.tencent.open.base.f.c("qqBaseActivity", "params=" + sb5.toString());
        }
        super.setResult(-1, intent);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G2(String str) {
        ProgressDialog show = ProgressDialog.show(this, "", super.getResources().getString(R.string.a5m), true);
        this.f339744o0 = show;
        show.setCancelable(true);
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f339730a0);
        bundle.putString("hopenid", this.f339731b0);
        bundle.putString("keystr", this.f339732c0);
        bundle.putString("keytype", this.f339733d0);
        bundle.putString("encrytoken", this.f339740k0);
        bundle.putString("platform", this.f339734e0);
        String[] split = TextUtils.split(str, ",");
        if (split != null && split.length != 0) {
            bundle.putString("fopenids", split[0]);
            String str2 = this.f339739j0;
            if (str2 != null) {
                bundle.putString(AdParam.PF, str2);
            }
            bundle.putString("appid_for_getting_config", this.f339730a0);
            if (this.f339741l0 != null) {
                new HttpCgiAsyncTask(this.f339741l0, "GET", new a(), true).b(bundle);
                return;
            }
            return;
        }
        F2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean H2() {
        try {
            this.f339743n0 = super.getIntent().getBundleExtra("key_params");
            this.f339749t0 = super.getIntent().getStringExtra("key_action");
            Bundle bundle = this.f339743n0;
            if (bundle != null && bundle.containsKey("appid") && this.f339743n0.containsKey("hopenid") && this.f339743n0.containsKey("keystr") && this.f339743n0.containsKey("keytype") && this.f339743n0.containsKey("platform") && this.f339743n0.containsKey("img") && this.f339743n0.containsKey("receiver") && this.f339743n0.containsKey("encrytoken")) {
                this.f339730a0 = this.f339743n0.getString("appid");
                this.f339731b0 = this.f339743n0.getString("hopenid");
                this.f339732c0 = this.f339743n0.getString("keystr");
                this.f339733d0 = this.f339743n0.getString("keytype");
                this.f339734e0 = this.f339743n0.getString("platform");
                this.f339737h0 = this.f339743n0.getString("img");
                this.f339735f0 = this.f339743n0.getString("receiver");
                this.f339736g0 = this.f339743n0.getString("msg");
                this.f339740k0 = this.f339743n0.getString("encrytoken");
                if (!"".equals(this.f339730a0.trim()) && !"".equals(this.f339731b0.trim()) && !"".equals(this.f339732c0.trim()) && !"".equals(this.f339733d0.trim()) && !"".equals(this.f339734e0.trim()) && !"".equals(this.f339737h0.trim()) && !"".equals(this.f339735f0.trim())) {
                    if (this.f339743n0.containsKey(AdParam.PF)) {
                        this.f339739j0 = this.f339743n0.getString(AdParam.PF);
                    }
                    if (this.f339743n0.containsKey("source")) {
                        this.f339738i0 = this.f339743n0.getString("source");
                    }
                    this.f339741l0 = lq3.c.c().a("https://fusion.qq.com/cgi-bin/qzapps/mapp_getuserinfo.cgi");
                    this.f339742m0 = lq3.c.c().a("https://appic.qq.com/cgi-bin/appstage/mapp_sendbragging.cgi");
                    return true;
                }
                F2();
                return false;
            }
            F2();
            return false;
        } catch (Exception e16) {
            com.tencent.open.base.f.d("qqBaseActivity", "initParams exception." + e16.getMessage(), e16);
            F2();
            return false;
        }
    }

    protected void dismissProgressDialog() {
        ProgressDialog progressDialog = this.f339744o0;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f339744o0.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d("SDKQQAgentPref", 2, "GetPKFriendInfoSwitch_AGENT:" + SystemClock.elapsedRealtime());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0099  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        int i3;
        String str;
        String str2;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f339746q0) {
            Bundle bundle = new Bundle();
            bundle.putString("appid", this.f339730a0);
            bundle.putString("hopenid", this.f339731b0);
            bundle.putString("keystr", this.f339732c0);
            bundle.putString("keytype", this.f339733d0);
            bundle.putString("encrytoken", this.f339740k0);
            bundle.putString("platform", this.f339734e0);
            bundle.putString("sendmsg", this.f339748s0.getText().toString());
            bundle.putString("imgurl", this.f339737h0);
            bundle.putString("receiver", this.f339735f0);
            if ("action_brag".equals(this.f339749t0)) {
                bundle.putString("typeid", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE);
            } else if ("action_challenge".equals(this.f339749t0)) {
                bundle.putString("typeid", "53");
                i3 = R.string.a66;
                bundle.putString("appid_for_getting_config", this.f339730a0);
                str = this.f339738i0;
                if (str != null) {
                    bundle.putString("app_custom", str);
                }
                str2 = this.f339739j0;
                if (str2 != null) {
                    bundle.putString(AdParam.PF, str2);
                }
                this.f339744o0 = ProgressDialog.show(this, "", super.getResources().getString(i3), true);
                new HttpCgiAsyncTask(this.f339742m0, "POST", new b(), true).b(bundle);
            }
            i3 = R.string.a65;
            bundle.putString("appid_for_getting_config", this.f339730a0);
            str = this.f339738i0;
            if (str != null) {
            }
            str2 = this.f339739j0;
            if (str2 != null) {
            }
            this.f339744o0 = ProgressDialog.show(this, "", super.getResources().getString(i3), true);
            new HttpCgiAsyncTask(this.f339742m0, "POST", new b(), true).b(bundle);
        } else if (view == this.f339747r0) {
            super.setResult(0);
            super.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
