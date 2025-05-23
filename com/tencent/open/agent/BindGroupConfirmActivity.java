package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto$MsgIconsurl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import gp3.e;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import mqq.app.NewIntent;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BindGroupConfirmActivity extends BaseActivity implements View.OnClickListener, HttpCgiAsyncTask.a, e.b, DialogInterface.OnClickListener {
    String A0;
    private final HttpCgiAsyncTask.a B0 = new a();
    protected final Handler C0 = new Handler() { // from class: com.tencent.open.agent.BindGroupConfirmActivity.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3;
            if (message == null) {
                return;
            }
            int i16 = message.what;
            if (i16 != 3) {
                if (i16 == 4) {
                    Bitmap bitmap = (Bitmap) message.obj;
                    Bitmap s16 = com.tencent.open.agent.util.g.s(BindGroupConfirmActivity.this, bitmap, 50, 50);
                    bitmap.recycle();
                    if (s16 != null) {
                        BindGroupConfirmActivity.this.f339657g0.setImageBitmap(s16);
                        return;
                    }
                    return;
                }
                return;
            }
            GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = (GetAppInfoProto$GetAppinfoResponse) message.obj;
            if (getAppInfoProto$GetAppinfoResponse.iconsURL.has()) {
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    if (i17 < getAppInfoProto$GetAppinfoResponse.iconsURL.get().size()) {
                        try {
                            i3 = Integer.parseInt(getAppInfoProto$GetAppinfoResponse.iconsURL.get(i17).size.get());
                        } catch (NumberFormatException unused) {
                            i3 = 0;
                        }
                        if (i3 >= 100) {
                            break;
                        }
                        if (i3 > i18) {
                            i19 = i17;
                            i18 = i3;
                        }
                        i17++;
                    } else {
                        i17 = i19;
                        break;
                    }
                }
                final GetAppInfoProto$MsgIconsurl getAppInfoProto$MsgIconsurl = getAppInfoProto$GetAppinfoResponse.iconsURL.get(i17);
                if (getAppInfoProto$MsgIconsurl != null) {
                    ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.open.agent.BindGroupConfirmActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap q16 = com.tencent.open.agent.util.g.q(getAppInfoProto$MsgIconsurl.url.get());
                            if (q16 != null) {
                                Message message2 = new Message();
                                message2.obj = q16;
                                message2.what = 4;
                                BindGroupConfirmActivity.this.C0.sendMessage(message2);
                            }
                        }
                    });
                }
            }
        }
    };
    protected Runnable D0 = new Runnable() { // from class: com.tencent.open.agent.BindGroupConfirmActivity.5
        @Override // java.lang.Runnable
        public void run() {
            QQProgressDialog qQProgressDialog = BindGroupConfirmActivity.this.f339669s0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                BindGroupConfirmActivity.this.f339669s0.dismiss();
            }
        }
    };
    e.a E0 = new d();

    /* renamed from: a0, reason: collision with root package name */
    protected TextView f339651a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TextView f339652b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f339653c0;

    /* renamed from: d0, reason: collision with root package name */
    protected TextView f339654d0;

    /* renamed from: e0, reason: collision with root package name */
    protected TextView f339655e0;

    /* renamed from: f0, reason: collision with root package name */
    protected ImageView f339656f0;

    /* renamed from: g0, reason: collision with root package name */
    protected ImageView f339657g0;

    /* renamed from: h0, reason: collision with root package name */
    protected TextView f339658h0;

    /* renamed from: i0, reason: collision with root package name */
    protected TextView f339659i0;

    /* renamed from: j0, reason: collision with root package name */
    protected Button f339660j0;

    /* renamed from: k0, reason: collision with root package name */
    protected Bundle f339661k0;

    /* renamed from: l0, reason: collision with root package name */
    protected String f339662l0;

    /* renamed from: m0, reason: collision with root package name */
    protected String f339663m0;

    /* renamed from: n0, reason: collision with root package name */
    protected String f339664n0;

    /* renamed from: o0, reason: collision with root package name */
    protected String f339665o0;

    /* renamed from: p0, reason: collision with root package name */
    protected Resources f339666p0;

    /* renamed from: q0, reason: collision with root package name */
    protected String f339667q0;

    /* renamed from: r0, reason: collision with root package name */
    protected String f339668r0;

    /* renamed from: s0, reason: collision with root package name */
    protected QQProgressDialog f339669s0;

    /* renamed from: t0, reason: collision with root package name */
    protected com.tencent.biz.widgets.e f339670t0;

    /* renamed from: u0, reason: collision with root package name */
    protected QQCustomDialog f339671u0;

    /* renamed from: v0, reason: collision with root package name */
    String f339672v0;

    /* renamed from: w0, reason: collision with root package name */
    String f339673w0;

    /* renamed from: x0, reason: collision with root package name */
    String f339674x0;

    /* renamed from: y0, reason: collision with root package name */
    String f339675y0;

    /* renamed from: z0, reason: collision with root package name */
    String f339676z0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements HttpCgiAsyncTask.a {
        a() {
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void f(JSONObject jSONObject) {
            QQProgressDialog qQProgressDialog = BindGroupConfirmActivity.this.f339669s0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                BindGroupConfirmActivity.this.f339669s0.dismiss();
            }
            try {
                if (jSONObject.getInt("ret") == 0) {
                    BindGroupConfirmActivity bindGroupConfirmActivity = BindGroupConfirmActivity.this;
                    if (bindGroupConfirmActivity.f339670t0 == null) {
                        bindGroupConfirmActivity.f339670t0 = new com.tencent.biz.widgets.e(BindGroupConfirmActivity.this);
                        BindGroupConfirmActivity bindGroupConfirmActivity2 = BindGroupConfirmActivity.this;
                        bindGroupConfirmActivity2.f339670t0.Q(bindGroupConfirmActivity2.f339666p0.getString(R.string.f170586uy));
                        BindGroupConfirmActivity bindGroupConfirmActivity3 = BindGroupConfirmActivity.this;
                        bindGroupConfirmActivity3.f339670t0.O(bindGroupConfirmActivity3.f339666p0.getString(R.string.f170585ux, bindGroupConfirmActivity3.f339667q0), BindGroupConfirmActivity.this);
                        BindGroupConfirmActivity bindGroupConfirmActivity4 = BindGroupConfirmActivity.this;
                        bindGroupConfirmActivity4.f339670t0.P(bindGroupConfirmActivity4);
                    }
                    if (!BindGroupConfirmActivity.this.f339670t0.isShowing()) {
                        BindGroupConfirmActivity.this.f339670t0.show();
                        return;
                    }
                    return;
                }
                if (jSONObject.getInt("ret") != 10071 && jSONObject.getInt("ret") != 10000) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
                    }
                    QQToast.makeText(com.tencent.open.adapter.a.f().e(), jSONObject.getString("msg"), 0).create(BindGroupConfirmActivity.this.getTitleBarHeight()).show();
                    return;
                }
                BindGroupConfirmActivity bindGroupConfirmActivity5 = BindGroupConfirmActivity.this;
                if (bindGroupConfirmActivity5.f339671u0 == null) {
                    bindGroupConfirmActivity5.f339671u0 = DialogUtil.createCustomDialog(bindGroupConfirmActivity5, 230, bindGroupConfirmActivity5.f339666p0.getString(R.string.f170589v1), BindGroupConfirmActivity.this.f339666p0.getString(R.string.f170590v2), R.string.close, R.string.f171151ok, BindGroupConfirmActivity.this, (DialogInterface.OnClickListener) null);
                }
                String string = jSONObject.getString("msg");
                if (!TextUtils.isEmpty(string)) {
                    BindGroupConfirmActivity.this.f339671u0.setMessage(string);
                }
                if (!BindGroupConfirmActivity.this.f339671u0.isShowing()) {
                    BindGroupConfirmActivity.this.f339671u0.show();
                }
            } catch (Exception e16) {
                onException(e16);
            }
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void onException(Exception exc) {
            QQProgressDialog qQProgressDialog = BindGroupConfirmActivity.this.f339669s0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                BindGroupConfirmActivity.this.f339669s0.dismiss();
            }
            BindGroupConfirmActivity.this.M2(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements com.tencent.open.appcommon.d {
        b() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (!BindGroupConfirmActivity.this.app.getCurrentAccountUin().equals(bundle.getString("ssoAccount"))) {
                return;
            }
            BindGroupConfirmActivity bindGroupConfirmActivity = BindGroupConfirmActivity.this;
            bindGroupConfirmActivity.C0.removeCallbacks(bindGroupConfirmActivity.D0);
            if (z16) {
                GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                        if (getAppInfoProto$GetAppinfoResponse.has() && getAppInfoProto$GetAppinfoResponse.ret.get() == 0) {
                            Message obtainMessage = BindGroupConfirmActivity.this.C0.obtainMessage();
                            obtainMessage.what = 3;
                            obtainMessage.obj = getAppInfoProto$GetAppinfoResponse;
                            BindGroupConfirmActivity.this.C0.sendMessage(obtainMessage);
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f339687a;

        c(String str) {
            this.f339687a = str;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.e("BindGroupConfirmActivity", 1, "fail to get pskey, domain = " + this.f339687a + " errMsg: " + str);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            QLog.d("BindGroupConfirmActivity", 1, "get pskey onSuccess");
            BindGroupConfirmActivity.this.K2(map.get(this.f339687a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class d implements e.a {
        d() {
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            JSONObject jSONObject2;
            if (i3 == 0 && jSONObject != null) {
                try {
                    JSONObject jSONObject3 = (JSONObject) jSONObject.get("data");
                    if (jSONObject3 != null && (jSONObject2 = (JSONObject) jSONObject3.get("key")) != null) {
                        int intValue = ((Integer) jSONObject2.get("retCode")).intValue();
                        String str = (String) jSONObject2.get("retMsg");
                        if (intValue == 0) {
                            BindGroupConfirmActivity bindGroupConfirmActivity = BindGroupConfirmActivity.this;
                            if (bindGroupConfirmActivity.f339670t0 == null) {
                                bindGroupConfirmActivity.f339670t0 = new com.tencent.biz.widgets.e(BindGroupConfirmActivity.this);
                                BindGroupConfirmActivity bindGroupConfirmActivity2 = BindGroupConfirmActivity.this;
                                bindGroupConfirmActivity2.f339670t0.Q(bindGroupConfirmActivity2.f339666p0.getString(R.string.f170586uy));
                                BindGroupConfirmActivity bindGroupConfirmActivity3 = BindGroupConfirmActivity.this;
                                bindGroupConfirmActivity3.f339670t0.O(bindGroupConfirmActivity3.f339666p0.getString(R.string.f170585ux, bindGroupConfirmActivity3.f339667q0), BindGroupConfirmActivity.this);
                                BindGroupConfirmActivity bindGroupConfirmActivity4 = BindGroupConfirmActivity.this;
                                bindGroupConfirmActivity4.f339670t0.P(bindGroupConfirmActivity4);
                            }
                            if (!BindGroupConfirmActivity.this.f339670t0.isShowing()) {
                                BindGroupConfirmActivity.this.f339670t0.show();
                            }
                            ReportController.o(BindGroupConfirmActivity.this.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
                        } else {
                            String string = BindGroupConfirmActivity.this.getActivity().getResources().getString(R.string.i6u);
                            switch (intValue) {
                                case 221001:
                                    string = BindGroupConfirmActivity.this.getActivity().getResources().getString(R.string.i6x);
                                    break;
                                case 221019:
                                    string = BindGroupConfirmActivity.this.getActivity().getResources().getString(R.string.i6w);
                                    break;
                                case 221020:
                                    string = BindGroupConfirmActivity.this.getActivity().getResources().getString(R.string.i6s);
                                    break;
                            }
                            BindGroupConfirmActivity.this.N2(string);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("BindGroupConfirmActivity", 2, "bindGroup onResult retCode = " + intValue + " retMsg = " + str);
                        }
                    }
                } catch (Exception e16) {
                    BindGroupConfirmActivity bindGroupConfirmActivity5 = BindGroupConfirmActivity.this;
                    bindGroupConfirmActivity5.N2(bindGroupConfirmActivity5.getActivity().getResources().getString(R.string.i6u));
                    if (QLog.isColorLevel()) {
                        QLog.d("BindGroupConfirmActivity", 2, "bindGroup onResult " + e16.toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(String str) {
        Bundle bundle = new Bundle();
        String currentAccountUin = this.app.getCurrentAccountUin();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("o");
        if (currentAccountUin.length() < 10) {
            for (int i3 = 0; i3 < 10 - currentAccountUin.length(); i3++) {
                sb5.append("0");
            }
            sb5.append(currentAccountUin);
        } else {
            sb5.append("0");
            sb5.append(currentAccountUin);
        }
        bundle.putString("Cookie", "uin=" + ((Object) sb5) + "; p_skey=" + str);
        bundle.putString("Host", "info.gamecenter.qq.com");
        Bundle bundle2 = new Bundle();
        bundle2.putString("appid", this.f339664n0);
        bundle2.putString("guild_id", this.f339673w0);
        bundle2.putString("zone_id", this.f339674x0);
        bundle2.putString("guild_name", this.A0);
        bundle2.putString("gc", this.f339676z0);
        bundle2.putString("platid", "2");
        bundle2.putString("roleid", this.f339675y0);
        Bundle bundle3 = new Bundle();
        bundle3.putString("module", "gc_bind_group_svr");
        bundle3.putString("method", "bind_existing_group");
        String constructParams = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).constructParams(bundle2, bundle3);
        bundle.putString("param", constructParams);
        bundle.putString("signature", ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).encrypt(constructParams + "ea779693bfa42c986ad85cda9bdfce45").toUpperCase());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", getApplicationContext());
        if (QLog.isColorLevel()) {
            QLog.i("BindGroupConfirmActivity", 2, "bindGroup params = " + bundle);
        }
        new com.tencent.mobileqq.troop.utils.f("https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi", "GET", this.E0, 0, null).b(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2(final String str) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.BindGroupConfirmActivity.9

            /* compiled from: P */
            /* renamed from: com.tencent.open.agent.BindGroupConfirmActivity$9$a */
            /* loaded from: classes22.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    if (i3 == 1) {
                        BindGroupConfirmActivity.this.f339671u0.cancel();
                        BindGroupConfirmActivity.this.finish();
                        return;
                    }
                    try {
                        BindGroupConfirmActivity bindGroupConfirmActivity = BindGroupConfirmActivity.this;
                        ForwardSdkBaseOption.E(bindGroupConfirmActivity, true, "action_game_bind_group", Long.valueOf(bindGroupConfirmActivity.f339664n0).longValue(), -1, str);
                    } catch (Exception e16) {
                        QLog.e("BindGroupConfirmActivity", 1, "showAlertDlg error = " + e16);
                    }
                    BindGroupConfirmActivity.this.f339671u0.cancel();
                    BindGroupConfirmActivity.super.setResult(-1);
                    BindGroupConfirmActivity.super.finish();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                BindGroupConfirmActivity bindGroupConfirmActivity = BindGroupConfirmActivity.this;
                if (bindGroupConfirmActivity.f339671u0 == null) {
                    bindGroupConfirmActivity.f339671u0 = DialogUtil.createCustomDialog(bindGroupConfirmActivity, 230);
                }
                if (!TextUtils.isEmpty(str)) {
                    BindGroupConfirmActivity.this.f339671u0.setMessage(str);
                }
                a aVar = new a();
                BindGroupConfirmActivity.this.f339671u0.setTitle(R.string.i6v);
                BindGroupConfirmActivity.this.f339671u0.setPositiveButton(R.string.a8j, aVar);
                BindGroupConfirmActivity.this.f339671u0.setNegativeButton(R.string.cancel, aVar);
                if (!BindGroupConfirmActivity.this.f339671u0.isShowing()) {
                    BindGroupConfirmActivity.this.f339671u0.show();
                }
            }
        });
    }

    private void initUI() {
        View findViewById = findViewById(R.id.if5);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ImmersiveUtils.setFitsSystemWindows(findViewById, true);
        }
        this.f339651a0 = (TextView) super.findViewById(R.id.ivTitleBtnLeft);
        this.f339652b0 = (TextView) super.findViewById(R.id.ivTitleBtnLeftButton);
        this.f339653c0 = (TextView) super.findViewById(R.id.ivTitleBtnRightText);
        this.f339654d0 = (TextView) super.findViewById(R.id.ivTitleName);
        Button button = (Button) super.findViewById(R.id.b7o);
        this.f339660j0 = button;
        button.setOnClickListener(this);
        this.f339655e0 = (TextView) super.findViewById(R.id.j9d);
        this.f339656f0 = (ImageView) super.findViewById(R.id.jyu);
        if (!TextUtils.isEmpty(this.f339663m0)) {
            Bitmap b16 = gp3.e.a().b(this.f339663m0);
            if (b16 != null) {
                this.f339656f0.setImageBitmap(b16);
            } else {
                gp3.e.a().c(this.f339663m0, this);
            }
        }
        this.f339659i0 = (TextView) super.findViewById(R.id.k0i);
        if (TextUtils.isEmpty(this.f339662l0)) {
            this.f339659i0.setText("QQ\u7fa4");
        } else {
            this.f339659i0.setText(this.f339662l0);
        }
        this.f339657g0 = (ImageView) super.findViewById(R.id.f164379vi);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.agent.BindGroupConfirmActivity.3
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                final Bitmap s16;
                Resources resources = BindGroupConfirmActivity.this.f339666p0;
                if (resources == null) {
                    return;
                }
                try {
                    bitmap = BitmapFactory.decodeResource(resources, R.drawable.qb_opensdk_app);
                } catch (OutOfMemoryError unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BindGroupConfirmActivity", 2, "initUI decodeResource has OutOfMemoryError!");
                    }
                    bitmap = null;
                }
                if (bitmap == null || (s16 = com.tencent.open.agent.util.g.s(BindGroupConfirmActivity.this, bitmap, 50, 50)) == null) {
                    return;
                }
                BindGroupConfirmActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.BindGroupConfirmActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BindGroupConfirmActivity.this.f339657g0.setImageBitmap(s16);
                    }
                });
            }
        });
        TextView textView = (TextView) super.findViewById(R.id.f164389w0);
        this.f339658h0 = textView;
        textView.setText(this.f339668r0);
        if (!TextUtils.isEmpty(this.f339664n0)) {
            L2(Long.valueOf(this.f339664n0).longValue());
        }
    }

    public void J2() {
        ((IPskeyManager) this.app.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{"connect.qq.com"}, new c("connect.qq.com"));
    }

    protected void L2(long j3) {
        GetAppInfoProto$GetAppinfoRequest getAppInfoProto$GetAppinfoRequest = new GetAppInfoProto$GetAppinfoRequest();
        getAppInfoProto$GetAppinfoRequest.client_id.set(j3);
        getAppInfoProto$GetAppinfoRequest.sdkp.set("android");
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        getAppInfoProto$GetAppinfoRequest.f342196os.set(str);
        getAppInfoProto$GetAppinfoRequest.qqv.set(com.tencent.open.adapter.a.f().n());
        getAppInfoProto$GetAppinfoRequest.setHasFlag(true);
        if (!TextUtils.isEmpty(this.f339665o0)) {
            getAppInfoProto$GetAppinfoRequest.appUniqueIdentifier.set(this.f339665o0);
        }
        getAppInfoProto$GetAppinfoRequest.referer.set(6);
        NewIntent newIntent = new NewIntent(this, OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", this.app.getCurrentAccountUin());
        newIntent.putExtra("data", getAppInfoProto$GetAppinfoRequest.toByteArray());
        newIntent.putExtra("cmd", "ConnAuthSvr.get_app_info");
        newIntent.setObserver(new b());
        super.getAppRuntime().startServlet(newIntent);
        this.C0.removeCallbacks(this.D0);
        this.C0.postDelayed(this.D0, 30000L);
    }

    public void M2(Exception exc) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("BindGroupConfirmActivity", 2, "HttpAsyncTaskCallback exception." + exc.getMessage());
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
        QQToast.makeText(this, str, 0).create(getTitleBarHeight()).show();
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
        try {
            if (jSONObject.getInt("ret") == 0) {
                JSONArray jSONArray = jSONObject.getJSONArray("list");
                int length = jSONArray.length();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < length; i3++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (!jSONObject2.getString("id").equals("0")) {
                            stringBuffer.append(jSONObject2.getString("id") + "\u3001");
                        }
                        stringBuffer.append(jSONObject2.getString("desc") + "\n");
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!" + e16.getMessage());
                        }
                    }
                }
                if (stringBuffer.length() != 0) {
                    this.f339655e0.setText(stringBuffer);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
            }
            TextView textView = this.f339655e0;
            if (textView != null) {
                textView.setText(this.f339666p0.getString(R.string.f170591v4));
            }
            QQToast.makeText(this, jSONObject.getString("msg"), 0).create(getTitleBarHeight()).show();
        } catch (Exception e17) {
            TextView textView2 = this.f339655e0;
            if (textView2 != null) {
                textView2.setText(this.f339666p0.getString(R.string.f170591v4));
            }
            onException(e17);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.b7o) {
                if ("true".equals(this.f339672v0)) {
                    J2();
                } else {
                    new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_bind_qqgroup", "POST", this.B0, true).b(this.f339661k0);
                    this.f339669s0.show();
                }
            } else if (id5 == R.id.ivTitleBtnLeft) {
                finish();
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
        super.onCreate(bundle);
        super.setTheme(R.style.f173428d2);
        super.setContentView(R.layout.a3l);
        this.f339666p0 = super.getResources();
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.f339669s0 = qQProgressDialog;
        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.k1f));
        Bundle bundleExtra = super.getIntent().getBundleExtra("key_params");
        this.f339661k0 = bundleExtra;
        if (bundleExtra == null) {
            com.tencent.open.base.f.c("BindGroupConfirmActivity", "initParams() mParams is null!");
            return;
        }
        this.f339668r0 = bundleExtra.getString("union_name");
        this.f339667q0 = this.f339661k0.getString("app_name");
        this.f339662l0 = this.f339661k0.getString("group_name");
        this.f339663m0 = this.f339661k0.getString("group_avatar_url");
        this.f339665o0 = this.f339661k0.getString("pkg_name");
        this.f339664n0 = this.f339661k0.getString("appid");
        String string = this.f339661k0.getString("is_from_game");
        this.f339672v0 = string;
        if ("true".equals(string)) {
            this.f339673w0 = this.f339661k0.getString("unionid");
            this.f339674x0 = this.f339661k0.getString("zoneid");
            this.f339675y0 = this.f339661k0.getString("role_id");
            this.f339676z0 = this.f339661k0.getString("group_code");
            this.A0 = this.f339668r0;
            if (QLog.isColorLevel()) {
                QLog.d("BindGroupConfirmActivity", 2, "bindGroup appid =  guild id = " + this.f339673w0 + "zone_id = " + this.f339674x0 + " role id = " + this.f339675y0 + "  group code= " + this.f339676z0 + " guild name = " + this.A0);
            }
            ReportController.o(this.app, "CliOper", "", "", "0x80084B0", "0x80084B0", 0, 0, "", "", "", "");
        } else if (QLog.isColorLevel()) {
            QLog.d("BindGroupConfirmActivity", 2, " bindGroup is from game = false");
        }
        new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_qqgroup_description", "POST", this, true).b(this.f339661k0);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BindGroupActivity.A0 = true;
    }

    @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
    public void onException(Exception exc) {
        M2(exc);
    }

    @Override // gp3.e.b
    public void onImageLoaded(String str, final Bitmap bitmap, String str2) {
        com.tencent.open.base.f.a("BindGroupConfirmActivity", "-->onImageLoaded() url = " + str);
        this.C0.post(new Runnable() { // from class: com.tencent.open.agent.BindGroupConfirmActivity.4
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    BindGroupConfirmActivity.this.f339656f0.setImageBitmap(bitmap2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f339651a0.setVisibility(0);
        this.f339651a0.setText(this.f339666p0.getString(R.string.a4x));
        this.f339651a0.setOnClickListener(this);
        this.f339652b0.setVisibility(4);
        this.f339653c0.setVisibility(4);
        this.f339654d0.setText(this.f339666p0.getString(R.string.f170588v0));
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        if (this.f339670t0 != dialogInterface) {
            if (this.f339671u0 == dialogInterface) {
                dialogInterface.dismiss();
                return;
            }
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                Intent aliasIntent = SplashActivity.getAliasIntent(this);
                aliasIntent.addFlags(67108864);
                aliasIntent.addFlags(268435456);
                super.startActivity(aliasIntent);
                super.finish();
                return;
            }
            return;
        }
        try {
            ForwardSdkBaseOption.E(this, true, "action_game_bind_group", Long.valueOf(this.f339664n0).longValue(), 0, "");
        } catch (Exception e16) {
            QLog.e("BindGroupConfirmActivity", 1, "showAlertDlg error = " + e16);
        }
        super.setResult(-1);
        super.finish();
    }
}
