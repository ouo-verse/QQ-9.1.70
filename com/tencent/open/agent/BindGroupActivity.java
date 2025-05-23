package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.al;
import com.tencent.mobileqq.config.business.aw;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.widget.AdapterView;
import com.tencent.widget.immersive.ImmersiveUtils;
import gp3.e;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BindGroupActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, HttpCgiAsyncTask.a, e.b, DialogInterface.OnClickListener {
    public static boolean A0 = false;

    /* renamed from: a0, reason: collision with root package name */
    protected TextView f339609a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TextView f339610b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f339611c0;

    /* renamed from: d0, reason: collision with root package name */
    protected TextView f339612d0;

    /* renamed from: e0, reason: collision with root package name */
    protected TextView f339613e0;

    /* renamed from: f0, reason: collision with root package name */
    protected View f339614f0;

    /* renamed from: g0, reason: collision with root package name */
    protected View f339615g0;

    /* renamed from: h0, reason: collision with root package name */
    protected SlideDetectListView f339616h0;

    /* renamed from: i0, reason: collision with root package name */
    protected LayoutInflater f339617i0;

    /* renamed from: j0, reason: collision with root package name */
    protected Resources f339618j0;

    /* renamed from: k0, reason: collision with root package name */
    protected c f339619k0;

    /* renamed from: l0, reason: collision with root package name */
    protected Bundle f339620l0;

    /* renamed from: m0, reason: collision with root package name */
    protected List<b> f339621m0;

    /* renamed from: n0, reason: collision with root package name */
    protected String f339622n0;

    /* renamed from: o0, reason: collision with root package name */
    protected String f339623o0;

    /* renamed from: p0, reason: collision with root package name */
    protected String f339624p0;

    /* renamed from: q0, reason: collision with root package name */
    protected String f339625q0;

    /* renamed from: s0, reason: collision with root package name */
    protected QQProgressDialog f339627s0;

    /* renamed from: t0, reason: collision with root package name */
    protected String f339628t0;

    /* renamed from: u0, reason: collision with root package name */
    protected QQProgressDialog f339629u0;

    /* renamed from: v0, reason: collision with root package name */
    protected Handler f339630v0;

    /* renamed from: w0, reason: collision with root package name */
    protected boolean f339631w0;

    /* renamed from: x0, reason: collision with root package name */
    protected QQCustomDialog f339632x0;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f339626r0 = false;

    /* renamed from: y0, reason: collision with root package name */
    protected com.tencent.biz.common.util.i f339633y0 = new a();

    /* renamed from: z0, reason: collision with root package name */
    e.a f339634z0 = new AnonymousClass4();

    /* compiled from: P */
    /* renamed from: com.tencent.open.agent.BindGroupActivity$4, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass4 implements e.a {
        AnonymousClass4() {
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            String str;
            String str2;
            JSONArray jSONArray;
            JSONArray jSONArray2;
            String str3;
            if (i3 == 1001 && jSONObject != null) {
                try {
                    int intValue = ((Integer) jSONObject.get("retcode")).intValue();
                    JSONObject jSONObject2 = (JSONObject) jSONObject.get("result");
                    if (intValue == 0 && jSONObject2 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("BindGroupActivity", 2, "checkApiState onResult. retCode = " + intValue + "\n");
                        }
                        JSONObject jSONObject3 = (JSONObject) jSONObject2.get(Constants.Configs.BASICS);
                        String str4 = "msg";
                        String str5 = DTConstants.TAG.API;
                        String str6 = "state";
                        if (jSONObject3 != null && (jSONArray2 = (JSONArray) jSONObject3.get("datas")) != null) {
                            int i16 = 0;
                            while (i16 < jSONArray2.length()) {
                                JSONObject jSONObject4 = (JSONObject) jSONArray2.get(i16);
                                String str7 = (String) jSONObject4.get("name");
                                int intValue2 = ((Integer) jSONObject4.get("state")).intValue();
                                JSONArray jSONArray3 = jSONArray2;
                                String str8 = (String) jSONObject4.get(DTConstants.TAG.API);
                                String str9 = (String) jSONObject4.get(str4);
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    str3 = str4;
                                    sb5.append("checkApiState onResult, basics name = ");
                                    sb5.append(str7);
                                    sb5.append(" state = ");
                                    sb5.append(intValue2);
                                    sb5.append(" api = ");
                                    sb5.append(str8);
                                    sb5.append(" msg = ");
                                    sb5.append(str9);
                                    sb5.append("\n");
                                    QLog.i("BindGroupActivity", 2, sb5.toString());
                                } else {
                                    str3 = str4;
                                }
                                i16++;
                                jSONArray2 = jSONArray3;
                                str4 = str3;
                            }
                        }
                        String str10 = str4;
                        JSONObject jSONObject5 = (JSONObject) jSONObject2.get("friendlink");
                        if (jSONObject5 != null) {
                            try {
                                JSONArray jSONArray4 = (JSONArray) jSONObject5.get("datas");
                                if (jSONArray4 != null) {
                                    int i17 = 0;
                                    while (i17 < jSONArray4.length()) {
                                        JSONObject jSONObject6 = (JSONObject) jSONArray4.get(i17);
                                        String str11 = (String) jSONObject6.get("name");
                                        int intValue3 = ((Integer) jSONObject6.get(str6)).intValue();
                                        String str12 = (String) jSONObject6.get(str5);
                                        JSONArray jSONArray5 = jSONArray4;
                                        String str13 = str10;
                                        String str14 = (String) jSONObject6.get(str13);
                                        str10 = str13;
                                        if ("bind_group".equals(str12) && intValue3 != 1) {
                                            str = str5;
                                            str2 = str6;
                                            BindGroupActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.BindGroupActivity.4.1

                                                /* compiled from: P */
                                                /* renamed from: com.tencent.open.agent.BindGroupActivity$4$1$a */
                                                /* loaded from: classes22.dex */
                                                class a implements DialogInterface.OnClickListener {
                                                    a() {
                                                    }

                                                    @Override // android.content.DialogInterface.OnClickListener
                                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                                        if (i3 == 1) {
                                                            BindGroupActivity.this.f339632x0.cancel();
                                                            BindGroupActivity.this.finish();
                                                        }
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    BindGroupActivity bindGroupActivity = BindGroupActivity.this;
                                                    QQCustomDialog qQCustomDialog = bindGroupActivity.f339632x0;
                                                    if (qQCustomDialog != null) {
                                                        if (!qQCustomDialog.isShowing()) {
                                                            BindGroupActivity.this.f339632x0.show();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    bindGroupActivity.f339632x0 = DialogUtil.createCustomDialog(bindGroupActivity, 230);
                                                    BindGroupActivity bindGroupActivity2 = BindGroupActivity.this;
                                                    bindGroupActivity2.f339632x0.setMessage(bindGroupActivity2.getActivity().getResources().getString(R.string.f173229i71));
                                                    BindGroupActivity.this.f339632x0.setPositiveButton(R.string.a8j, new a());
                                                    if (!BindGroupActivity.this.f339632x0.isShowing()) {
                                                        BindGroupActivity.this.f339632x0.show();
                                                    }
                                                }
                                            });
                                        } else {
                                            str = str5;
                                            str2 = str6;
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.i("BindGroupActivity", 2, "checkApiState onResult, friendlink name = " + str11 + " state = " + intValue3 + " api = " + str12 + " msg= " + str14 + "\n");
                                        }
                                        i17++;
                                        jSONArray4 = jSONArray5;
                                        str5 = str;
                                        str6 = str2;
                                    }
                                }
                            } catch (Exception e16) {
                                e = e16;
                                if (QLog.isColorLevel()) {
                                    QLog.d("BindGroupActivity", 2, "checkApiState onResult " + e.toString());
                                    return;
                                }
                                return;
                            }
                        }
                        String str15 = str5;
                        String str16 = str6;
                        int intValue4 = ((Integer) jSONObject2.get("appid")).intValue();
                        if (QLog.isColorLevel()) {
                            QLog.i("BindGroupActivity", 2, "checkApiState onResult, appid =" + intValue4 + "\n");
                        }
                        JSONObject jSONObject7 = (JSONObject) jSONObject2.get(PreDownloadConstants.DEPARTMENT_QQPAY);
                        if (jSONObject7 != null && (jSONArray = (JSONArray) jSONObject7.get("datas")) != null) {
                            int i18 = 0;
                            while (i18 < jSONArray.length()) {
                                JSONObject jSONObject8 = (JSONObject) jSONArray.get(i18);
                                String str17 = (String) jSONObject8.get("name");
                                String str18 = str16;
                                int intValue5 = ((Integer) jSONObject8.get(str18)).intValue();
                                String str19 = str15;
                                String str20 = (String) jSONObject8.get(str19);
                                String str21 = str10;
                                String str22 = (String) jSONObject8.get(str21);
                                JSONArray jSONArray6 = jSONArray;
                                if (QLog.isColorLevel()) {
                                    QLog.i("BindGroupActivity", 2, "checkApiState onResult, qqpay name = " + str17 + " state = " + intValue5 + " api = " + str20 + " msg= " + str22 + "\n");
                                }
                                i18++;
                                jSONArray = jSONArray6;
                                str16 = str18;
                                str15 = str19;
                                str10 = str21;
                            }
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.biz.common.util.i {
        a() {
        }

        @Override // com.tencent.biz.common.util.i
        protected void a(boolean z16, OpenID openID) {
            if (QLog.isColorLevel()) {
                QLog.d("BindGroupActivity", 2, "-->onGetOpenId, isSuccess: " + z16 + " data: " + openID);
            }
            if (!BindGroupActivity.this.isFinishing()) {
                BindGroupActivity bindGroupActivity = BindGroupActivity.this;
                if (!bindGroupActivity.f339631w0) {
                    bindGroupActivity.f339629u0.hide();
                    Handler handler = BindGroupActivity.this.f339630v0;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    if (z16 && openID != null && openID.openID != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BindGroupActivity", 2, "openIdObserver success");
                        }
                        BindGroupActivity bindGroupActivity2 = BindGroupActivity.this;
                        String str = openID.openID;
                        bindGroupActivity2.f339624p0 = str;
                        if (!str.equals(bindGroupActivity2.f339623o0)) {
                            BindGroupActivity.this.H2();
                            return;
                        } else {
                            BindGroupActivity.this.F2();
                            return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("BindGroupActivity", 2, "openIdObserver fail");
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f339641a;

        /* renamed from: b, reason: collision with root package name */
        public String f339642b;

        /* renamed from: c, reason: collision with root package name */
        public String f339643c;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class c extends gp3.a {
        protected c() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return BindGroupActivity.this.f339621m0.size();
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            d dVar;
            if (view != null && view.getTag() != null) {
                dVar = (d) view.getTag();
            } else {
                view = BindGroupActivity.this.f339617i0.inflate(R.layout.byc, viewGroup, false);
                dVar = new d();
                dVar.f339645a = (ImageView) view.findViewById(R.id.c0o);
                dVar.f339646b = (TextView) view.findViewById(R.id.k0i);
                view.setTag(dVar);
            }
            b bVar = BindGroupActivity.this.f339621m0.get(i3);
            dVar.f339646b.setText(bVar.f339642b);
            dVar.f339647c = bVar.f339643c;
            Bitmap b16 = gp3.e.a().b(bVar.f339643c);
            if (b16 != null) {
                dVar.f339645a.setImageBitmap(b16);
            } else {
                dVar.f339645a.setImageResource(R.drawable.bqc);
                gp3.e.a().c(bVar.f339643c, BindGroupActivity.this);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f339645a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f339646b;

        /* renamed from: c, reason: collision with root package name */
        public String f339647c;
    }

    protected void F2() {
        Bundle bundle;
        String str = this.f339624p0;
        if (str != null && (bundle = this.f339620l0) != null) {
            bundle.putString("openid", str);
        }
        this.f339627s0.show();
        new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this, true).b(this.f339620l0);
        this.f339626r0 = true;
    }

    protected void G2() {
        if (this.f339629u0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
            this.f339629u0 = qQProgressDialog;
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.k1d));
        }
        OpenID b36 = this.app.getMsgHandler().b3(this.f339625q0);
        if (b36 != null && !TextUtils.isEmpty(b36.openID)) {
            this.f339624p0 = b36.openID;
        }
        this.f339620l0.putString("uin", this.app.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
            QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, mOpenid: " + this.f339623o0);
        }
        if (!TextUtils.isEmpty(this.f339623o0)) {
            if (b36 != null && !TextUtils.isEmpty(b36.openID)) {
                if (!this.f339623o0.equals(b36.openID)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
                    }
                    H2();
                    return;
                }
                this.f339626r0 = true;
                return;
            }
            this.f339629u0.setMessage(R.string.bj_);
            this.f339629u0.show();
            Handler handler = new Handler();
            this.f339630v0 = handler;
            handler.postDelayed(new Runnable() { // from class: com.tencent.open.agent.BindGroupActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("BindGroupActivity", 2, "-->onGetOpenId timeout.");
                    }
                    if (BindGroupActivity.this.isFinishing()) {
                        return;
                    }
                    BindGroupActivity bindGroupActivity = BindGroupActivity.this;
                    bindGroupActivity.f339631w0 = true;
                    bindGroupActivity.f339629u0.hide();
                    BindGroupActivity.this.F2();
                }
            }, 3000L);
            this.app.addObserver(this.f339633y0);
            com.tencent.mobileqq.app.handler.a.a(this.app.getMsgHandler(), this.f339625q0);
            return;
        }
        if (b36 != null && !TextUtils.isEmpty(b36.openID)) {
            String str = b36.openID;
            this.f339624p0 = str;
            this.f339620l0.putString("openid", str);
        }
        this.f339626r0 = true;
    }

    protected void H2() {
        QQCustomDialog qQCustomDialog = this.f339632x0;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
            this.f339632x0.show();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        this.f339632x0 = createCustomDialog;
        createCustomDialog.setMessage(R.string.d65);
        this.f339632x0.setTitle(R.string.b1v);
        this.f339632x0.setNegativeButton(R.string.cancel, this);
        this.f339632x0.setPositiveButton(R.string.d5b, this);
        this.f339632x0.show();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
    public void f(JSONObject jSONObject) {
        QQProgressDialog qQProgressDialog = this.f339627s0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f339627s0.dismiss();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BindGroupActivity", 2, "-->onResult, result: " + jSONObject);
        }
        try {
            if (jSONObject.getInt("ret") == 0) {
                JSONArray jSONArray = jSONObject.getJSONArray("list");
                int length = jSONArray.length();
                this.f339621m0.clear();
                for (int i3 = 0; i3 < length; i3++) {
                    b bVar = new b();
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        bVar.f339641a = jSONObject2.getString("group_code");
                        bVar.f339642b = jSONObject2.getString("name");
                        bVar.f339643c = jSONObject2.getString(PreDetect.FACE_DETECT) + "640";
                        this.f339621m0.add(bVar);
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BindGroupActivity", 2, "The JSONObject has error!" + e16.getMessage());
                        }
                    }
                }
                if (this.f339621m0.size() > 0) {
                    this.f339619k0.notifyDataSetChanged();
                    return;
                } else {
                    this.f339614f0.setVisibility(8);
                    this.f339615g0.setVisibility(0);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("BindGroupActivity", 2, "The JSONObject has error!");
            }
            QQToast.makeText(this, jSONObject.getString("msg"), 0).create(super.getTitleBarHeight()).show();
        } catch (Exception e17) {
            onException(e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1000 && i16 == -1) {
            super.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.bbp) {
                ITroopCreateService iTroopCreateService = (ITroopCreateService) this.app.getRuntimeService(ITroopCreateService.class, "");
                if (iTroopCreateService != null) {
                    iTroopCreateService.startCreateTroopSession(this, 0);
                }
            } else if (id5 == R.id.ivTitleBtnLeft) {
                super.finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.requestWindowFeature(1);
        super.setTheme(R.style.f173428d2);
        super.onCreate(bundle);
        super.setContentView(R.layout.a3k);
        View findViewById = findViewById(R.id.root);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ImmersiveUtils.setFitsSystemWindows(findViewById, true);
        }
        this.f339618j0 = super.getResources();
        this.f339617i0 = super.getLayoutInflater();
        Bundle bundleExtra = super.getIntent().getBundleExtra("key_params");
        this.f339620l0 = bundleExtra;
        if (bundleExtra == null) {
            return;
        }
        String string = bundleExtra.getString("openid");
        this.f339623o0 = string;
        if (string == null && QLog.isColorLevel()) {
            QLog.d("BindGroupActivity", 2, "mOpenId is null");
        }
        String string2 = this.f339620l0.getString("appid");
        this.f339625q0 = string2;
        if (string2 == null && QLog.isColorLevel()) {
            QLog.d("BindGroupActivity", 2, "mAppId is null");
        }
        if (this.f339625q0 != null && this.f339623o0 != null) {
            this.f339620l0.putString("encrytoken", super.getSharedPreferences("openid_encrytoken", 4).getString(this.f339623o0, ""));
            this.f339628t0 = this.f339620l0.getString("is_from_game");
            try {
                aw d16 = al.d(BaseApplicationImpl.getApplication());
                if (("true".equals(this.f339628t0) || d16.a()) && !TextUtils.isEmpty(this.f339625q0)) {
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), this.f339625q0, this.f339634z0, 1001, null);
                    if (QLog.isColorLevel()) {
                        QLog.d("BindGroupActivity", 2, "bindGroup enableCheckPermission = " + d16.a());
                    }
                }
            } catch (Exception e16) {
                if ("true".equals(this.f339628t0) && !TextUtils.isEmpty(this.f339625q0)) {
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), this.f339625q0, this.f339634z0, 1001, null);
                }
                QLog.d("BindGroupActivity", 1, "bindGroup loadConfig exception = " + e16);
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
            this.f339627s0 = qQProgressDialog;
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.k19));
            this.f339621m0 = new ArrayList();
            this.f339622n0 = this.f339620l0.getString("app_name");
            this.f339620l0.putString("uin", super.getIntent().getStringExtra("uin"));
            G2();
            this.f339609a0 = (TextView) super.findViewById(R.id.ivTitleBtnLeft);
            this.f339610b0 = (TextView) super.findViewById(R.id.ivTitleBtnLeftButton);
            this.f339611c0 = (TextView) super.findViewById(R.id.ivTitleBtnRightText);
            this.f339612d0 = (TextView) super.findViewById(R.id.ivTitleName);
            this.f339614f0 = super.findViewById(R.id.fas);
            SlideDetectListView slideDetectListView = (SlideDetectListView) super.findViewById(R.id.f167137l64);
            this.f339616h0 = slideDetectListView;
            slideDetectListView.setOnItemClickListener(this);
            if (this.f339619k0 == null) {
                this.f339619k0 = new c();
            }
            this.f339616h0.setAdapter((ListAdapter) this.f339619k0);
            View findViewById2 = super.findViewById(R.id.f_q);
            this.f339615g0 = findViewById2;
            findViewById2.setVisibility(8);
            TextView textView = (TextView) super.findViewById(R.id.bbp);
            this.f339613e0 = textView;
            textView.setOnClickListener(this);
            return;
        }
        super.setResult(0);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        A0 = false;
    }

    @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
    public void onException(Exception exc) {
        String str;
        QQProgressDialog qQProgressDialog = this.f339627s0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f339627s0.dismiss();
        }
        if (QLog.isColorLevel()) {
            QLog.e("BindGroupActivity", 2, "-->onException", exc);
        }
        if (exc instanceof ConnectTimeoutException) {
            str = com.tencent.open.business.base.b.f341057e;
        } else if (exc instanceof SocketTimeoutException) {
            str = com.tencent.open.business.base.b.f341058f;
        } else if (exc instanceof MalformedURLException) {
            str = "\u8bbf\u95eeurl\u6709\u8bef!";
        } else if (exc instanceof HttpBaseUtil.HttpStatusException) {
            str = "Http\u8fd4\u56de\u7801\u5f02\u5e38!";
        } else if (exc instanceof HttpBaseUtil.NetworkUnavailableException) {
            str = com.tencent.open.business.base.b.f341059g;
        } else if (exc instanceof JSONException) {
            str = com.tencent.open.business.base.b.f341054b;
        } else if (exc instanceof IOException) {
            str = com.tencent.open.business.base.b.f341053a;
        } else {
            str = com.tencent.open.business.base.b.f341056d;
        }
        QQToast.makeText(this, str, 0).create(super.getTitleBarHeight()).show();
    }

    @Override // gp3.e.b
    public void onImageLoaded(final String str, final Bitmap bitmap, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("BindGroupActivity", 2, "-->onImageLoaded() url = " + str);
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.BindGroupActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int childCount = BindGroupActivity.this.f339616h0.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    d dVar = (d) BindGroupActivity.this.f339616h0.getChildAt(i3).getTag();
                    if (dVar != null && str.equals(dVar.f339647c)) {
                        dVar.f339645a.setImageBitmap(bitmap);
                        return;
                    }
                }
            }
        });
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        b bVar = this.f339621m0.get(i3);
        if (bVar != null) {
            Intent intent = new Intent(this, (Class<?>) BindGroupConfirmActivity.class);
            Bundle bundle = this.f339620l0;
            if (bundle != null) {
                bundle.putString("group_code", bVar.f339641a);
                this.f339620l0.putString("group_name", bVar.f339642b);
                this.f339620l0.putString("group_avatar_url", bVar.f339643c);
            }
            intent.putExtra("key_params", this.f339620l0);
            super.startActivityForResult(intent, 1000);
            overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f339609a0.setVisibility(0);
        this.f339609a0.setText(this.f339622n0);
        this.f339609a0.setOnClickListener(this);
        this.f339610b0.setVisibility(4);
        this.f339611c0.setVisibility(4);
        this.f339612d0.setText(this.f339618j0.getString(R.string.f170587uz));
        if (this.f339620l0 != null && this.f339626r0) {
            if (!A0) {
                this.f339627s0.show();
            }
            new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this, true).b(this.f339620l0);
            if (QLog.isColorLevel()) {
                QLog.d("BindGroupActivity", 2, "-->onStart, start load group list.");
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        if (this.f339632x0 == dialogInterface) {
            if (i3 != 1) {
                if (i3 == 0) {
                    super.setResult(0);
                    super.finish();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("is_change_account", true);
            intent.putExtra("if_check_account_same", true);
            intent.putExtras(this.f339620l0);
            intent.putExtra("key_action", BindGroupActivity.class.getSimpleName());
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_LOGIN);
            super.finish();
        }
    }
}
