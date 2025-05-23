package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet;
import com.tencent.mobileqq.intervideo.yiqikan.g;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class TogetherBusinessForWebPlugin extends WebViewPlugin implements Handler.Callback, EIPCResultCallback, View.OnClickListener, g.c {
    private TogetherBusinessServlet.RspOpenIdentify D;
    private TogetherBusinessServlet.RspOpenStart E;
    private View F;
    private Button G;
    private String H;

    /* renamed from: d, reason: collision with root package name */
    private long f238450d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f238451e = -1;

    /* renamed from: f, reason: collision with root package name */
    private String f238452f = null;

    /* renamed from: h, reason: collision with root package name */
    private String f238453h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f238454i = null;
    private boolean C = true;
    private boolean I = false;

    /* renamed from: m, reason: collision with root package name */
    private Handler f238455m = new Handler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f238456d;

        a(Bundle bundle) {
            this.f238456d = bundle;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", this.f238456d, TogetherBusinessForWebPlugin.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f238458d;

        b(QQCustomDialog qQCustomDialog) {
            this.f238458d = qQCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f238458d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        String f238460a;

        /* renamed from: b, reason: collision with root package name */
        String f238461b;

        /* renamed from: c, reason: collision with root package name */
        DialogInterface.OnClickListener f238462c;

        public c(String str, String str2, DialogInterface.OnClickListener onClickListener) {
            this.f238460a = str;
            this.f238461b = str2;
            this.f238462c = onClickListener;
        }
    }

    public TogetherBusinessForWebPlugin() {
        g.k().q(this);
        try {
            QIPCClientHelper.getInstance().register(WatchTogetherClientIPCModule.b());
        } catch (Exception e16) {
            QLog.e("TogetherBusinessForWebPlugin", 1, "register WatchTogetherClientIPCModule ipc module error.", e16.getMessage());
        }
    }

    private void A(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.a() == null) {
            return;
        }
        QQCustomDialog qQCustomDialog = new QQCustomDialog(this.mRuntime.a(), R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        if (!TextUtils.isEmpty(str)) {
            qQCustomDialog.setTitle(str);
        } else {
            qQCustomDialog.setTitle((String) null);
        }
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setNegativeButton(this.mRuntime.a().getString(R.string.f170647xd), new b(qQCustomDialog));
        qQCustomDialog.setPositiveButton(this.mRuntime.a().getString(R.string.f170648xe), onClickListener);
        qQCustomDialog.show();
    }

    private void E(int i3, String str) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, i3, str, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    private String q(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "getCloseTogetherRoomCallBack isShow=" + z16);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("close_room", z16);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TogetherBusinessForWebPlugin", 4, "getCloseTogetherRoomCallBack:", e16);
            }
        }
        return jSONObject.toString();
    }

    private Intent r() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.a() == null) {
            return null;
        }
        return this.mRuntime.a().getIntent();
    }

    private String t(boolean z16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "getShowButtonCallBack isShow=" + z16 + " text=" + str);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_show_button", z16);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, str);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void u(String str) {
        View view = this.F;
        if (view != null) {
            view.setVisibility(0);
            Button button = this.G;
            if (button != null) {
                button.setText(str);
                return;
            }
            return;
        }
        WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
        if (webViewFragment != null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mRuntime.a()).inflate(R.layout.a3q, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (webViewFragment.getUIStyleHandler().V != null) {
                webViewFragment.getUIStyleHandler().V.addView(viewGroup, layoutParams);
            }
        } else {
            View inflate = ((ViewStub) this.mRuntime.a().findViewById(R.id.fgp)).inflate();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) inflate.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.addRule(12);
            inflate.setLayoutParams(layoutParams2);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.mRuntime.a().findViewById(R.id.g3l);
        this.F = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.setBackgroundColor(viewGroup2.getResources().getColor(R.color.skin_aio_at_white));
        ViewGroup.LayoutParams layoutParams3 = this.F.getLayoutParams();
        layoutParams3.height = BaseAIOUtils.f(75.0f, this.F.getResources());
        this.F.setLayoutParams(layoutParams3);
        this.F.setVisibility(0);
        ((ImageView) this.mRuntime.a().findViewById(R.id.bmt)).setVisibility(8);
        ViewGroup viewGroup3 = (ViewGroup) this.mRuntime.a().findViewById(R.id.ach);
        int f16 = BaseAIOUtils.f(16.0f, viewGroup3.getResources());
        viewGroup3.setPadding(f16, 0, f16, 0);
        Button button2 = new Button(this.mRuntime.a());
        button2.setText(str);
        button2.setGravity(17);
        button2.setTextColor(this.mRuntime.a().getResources().getColor(R.color.skin_color_button_blue));
        button2.setBackground(this.mRuntime.a().getDrawable(R.drawable.common_btn_blue));
        button2.setTextSize(1, 17.0f);
        this.G = button2;
        button2.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(45.0f, this.F.getResources()));
        layoutParams4.addRule(15);
        viewGroup3.addView(button2, layoutParams4);
    }

    private void v(String... strArr) {
        try {
            this.H = new JSONObject(strArr[0]).optString("callback", "");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessForWebPlugin", 2, e16, new Object[0]);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessForWebPlugin", 2, th5, new Object[0]);
            }
        }
    }

    private JSONObject x(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "quitOrCloseMsg type=" + i3);
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", i3);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    private void y(long j3, int i3, String str, String str2, String str3) {
        this.f238450d = j3;
        this.f238451e = i3;
        this.f238452f = str;
        this.f238453h = str2;
        this.f238454i = str3;
    }

    private boolean z(Bundle bundle) {
        if (TextUtils.isEmpty(this.D.confirmText)) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button confirmText is empty");
            return false;
        }
        Message obtainMessage = this.f238455m.obtainMessage(2);
        obtainMessage.obj = new c(null, this.D.confirmText, new a(bundle));
        this.f238455m.sendMessage(obtainMessage);
        return true;
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.g.c
    public void e(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "closeOrQuitBusiness type=" + i3);
        }
        dispatchJsEvent("close_business", x(i3), null);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "together_business";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            E(message.arg1, (String) message.obj);
            return true;
        }
        if (i3 == 2) {
            c cVar = (c) message.obj;
            A(cVar.f238460a, cVar.f238461b, cVar.f238462c);
            return true;
        }
        if (i3 == 3) {
            u((String) message.obj);
            return true;
        }
        if (i3 != 4) {
            return false;
        }
        View view = this.F;
        if (view != null) {
            view.setVisibility(8);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.g.c
    public void m(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "playOrPauseVideo type=" + i3);
        }
        dispatchJsEvent("play_control", x(i3), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f238455m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        g.k().o(this);
        QIPCClientHelper.getInstance().getClient().unRegisterModule(WatchTogetherClientIPCModule.b());
    }

    private boolean B(TogetherBusinessServlet.ResultInfo resultInfo) {
        if (resultInfo != null && resultInfo.showErrorMsg) {
            if (TextUtils.isEmpty(resultInfo.errorMsg)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button errorMsg is empty");
                }
                return false;
            }
            Message obtainMessage = this.f238455m.obtainMessage(1);
            obtainMessage.obj = resultInfo.errorMsg;
            obtainMessage.arg1 = 0;
            this.f238455m.sendMessage(obtainMessage);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button resultInfo is empty or no need showErrorMsg");
        }
        return false;
    }

    private boolean D() {
        if (NetworkUtil.isNetSupport(null)) {
            return false;
        }
        Message obtainMessage = this.f238455m.obtainMessage(1);
        obtainMessage.obj = "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u3002";
        obtainMessage.arg1 = 1;
        this.f238455m.sendMessage(obtainMessage);
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button network not well");
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TogetherBusinessServlet.RspOpenIdentify rspOpenIdentify;
        String str;
        this.E = null;
        Intent r16 = r();
        if (r16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
                return;
            }
            return;
        }
        Bundle s16 = s(this.f238452f, this.f238453h, this.f238454i, r16);
        if (s16 != null && (rspOpenIdentify = this.D) != null) {
            s16.putInt("business_type", rspOpenIdentify.businessType);
            if (this.D.businessType == 2) {
                if (this.f238451e == 2) {
                    str = "c2c_AIO";
                } else {
                    str = "Grp_AIO";
                }
                ReportController.o(null, "dc00899", str, "", "video_tab", "clk_share_grp", 0, 0, this.f238450d + "", this.f238454i, "", "");
            }
            if (D() || B(this.D.resultInfo) || z(s16)) {
                return;
            }
            QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", s16, this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
        }
    }

    private void C(String str) {
        String str2;
        WatchTogetherFloatingData watchTogetherFloatingData;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("uin");
            String optString2 = jSONObject.optString("url");
            int optInt = jSONObject.optInt("aio_type");
            boolean optBoolean = jSONObject.optBoolean("author");
            double optDouble = jSONObject.optDouble("video_width", 0.0d);
            double optDouble2 = jSONObject.optDouble("video_height", 0.0d);
            String optString3 = jSONObject.optString("callback", "");
            String optString4 = jSONObject.optString("from", "watchroom");
            WatchTogetherFloatingData watchTogetherFloatingData2 = new WatchTogetherFloatingData();
            watchTogetherFloatingData2.setSmallUrl(optString2);
            watchTogetherFloatingData2.setCurUin(optString);
            watchTogetherFloatingData2.setCurType(optInt);
            watchTogetherFloatingData2.setIsAdm(optBoolean);
            watchTogetherFloatingData2.setFrom(optString4);
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar != null && bVar.f() != null) {
                str2 = this.mRuntime.f().getCurrentUrl();
            } else {
                WebViewPlugin.b bVar2 = this.mRuntime;
                if (bVar2 == null || bVar2.e() == null) {
                    str2 = "";
                } else {
                    str2 = this.mRuntime.e().getUrl();
                }
            }
            watchTogetherFloatingData2.setBigUrl(str2);
            if (optDouble > 0.0d && optDouble2 > 0.0d) {
                watchTogetherFloatingData2.setVideoWidth(optDouble);
                watchTogetherFloatingData2.setVideoHeight(optDouble2);
            }
            if (QLog.isColorLevel()) {
                watchTogetherFloatingData = watchTogetherFloatingData2;
                QLog.d("TogetherBusinessForWebPlugin", 2, "SHOW_FLOATING_WINDOW uin=" + optString + " roomUrl=" + optString2 + " sessionType=" + optInt + " author=" + optBoolean + " videoWidth" + optDouble + " videoHeight=" + optDouble2 + " methodName=" + optString3 + " bigUrl" + str2 + " from=" + optString4);
            } else {
                watchTogetherFloatingData = watchTogetherFloatingData2;
            }
            if ("watchroom".equals(optString4)) {
                if (this.I && !((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TogetherBusinessForWebPlugin", 2, "SHOW_FLOATING_WINDOW no permission");
                    }
                    callJs(optString3, q(true));
                    return;
                }
                int r16 = g.k().r(BaseApplication.getContext(), watchTogetherFloatingData);
                this.I = r16 == 1;
                if (r16 != 1) {
                    callJs(optString3, "");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessForWebPlugin", 2, "SHOW_FLOATING_WINDOW resultCode=" + r16);
                    return;
                }
                return;
            }
            g.k().p(watchTogetherFloatingData);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private Bundle s(String str, String str2, String str3, Intent intent) {
        String stringExtra;
        int i3;
        long j3;
        int intExtra = intent.getIntExtra("uinType", -1);
        if (intExtra == -1) {
            intExtra = intent.getIntExtra("curtype", -1);
        }
        if (intExtra == 0) {
            stringExtra = intent.getStringExtra("friend_uin");
            i3 = 2;
        } else if (intExtra != 1) {
            i3 = -1;
            stringExtra = null;
        } else {
            stringExtra = intent.getStringExtra("groupUin");
            i3 = 1;
        }
        if (!TextUtils.isEmpty(stringExtra) && i3 != -1) {
            try {
                j3 = Long.parseLong(stringExtra);
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessForWebPlugin", 2, "uin string to long error");
                }
                j3 = -1;
            }
            if (j3 == -1) {
                return null;
            }
            y(j3, i3, str, str2, str3);
            Bundle bundle = new Bundle();
            bundle.putString("req_data", str);
            bundle.putString("req_sign", str2);
            bundle.putInt("session_type", i3);
            bundle.putLong("uin", j3);
            bundle.putString("appid", str3);
            return bundle;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "curType or uin is error: uinType=" + intExtra + " chatId=" + stringExtra);
        }
        return null;
    }

    private boolean p(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                return new JSONObject(strArr[0]).optBoolean("draw_button_by_qq", true);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return true;
    }

    private Bundle w(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("req_data");
                String optString2 = jSONObject.optString("req_sign");
                if ((TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) && QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam param error data=" + optString + " sign=" + optString2);
                }
                String optString3 = new JSONObject(optString).optString("appid");
                Intent r16 = r();
                if (r16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
                    }
                    return null;
                }
                return s(optString, optString2, optString3, r16);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    @Override // eipc.EIPCResultCallback
    public void onCallback(EIPCResult eIPCResult) {
        Bundle bundle;
        String str;
        if (eIPCResult.code != 0 || (bundle = eIPCResult.data) == null) {
            return;
        }
        Serializable serializable = bundle.getSerializable("QQAIOMediaSvc.open_identify");
        if (serializable != null) {
            TogetherBusinessServlet.RspOpenIdentify rspOpenIdentify = (TogetherBusinessServlet.RspOpenIdentify) serializable;
            this.D = rspOpenIdentify;
            boolean z16 = !TextUtils.isEmpty(rspOpenIdentify.buttonText);
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessForWebPlugin", 2, "callback from CMD_OPEN_IDENTIFY isShowButton=" + z16 + " mDrawButtonByQQ=" + this.C);
            }
            if (z16 && this.D.businessType == 2) {
                if (this.f238451e == 2) {
                    str = "c2c_AIO";
                } else {
                    str = "Grp_AIO";
                }
                ReportController.o(null, "dc00899", str, "", "video_tab", "exp_share_grp", 0, 0, this.f238450d + "", this.f238454i, "", "");
            }
            String t16 = t(z16, this.D.buttonText);
            if (!TextUtils.isEmpty(this.H)) {
                callJs(this.H, t16);
            }
            if (z16 && this.C) {
                Message obtainMessage = this.f238455m.obtainMessage(3);
                obtainMessage.obj = this.D.buttonText;
                this.f238455m.sendMessage(obtainMessage);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "callback from CMD_OPEN_START ");
        }
        Serializable serializable2 = eIPCResult.data.getSerializable("QQAIOMediaSvc.open_start");
        if (serializable2 == null) {
            return;
        }
        TogetherBusinessServlet.RspOpenStart rspOpenStart = (TogetherBusinessServlet.RspOpenStart) serializable2;
        this.E = rspOpenStart;
        B(rspOpenStart.resultInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        String str2;
        if (j3 == 8589934595L && !TextUtils.isEmpty(str) && str.contains("ti.qq.com/sportslive/mini/room")) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleEvent type =");
                if (j3 == 8589934595L) {
                    str2 = "load_error";
                } else {
                    str2 = "http_error";
                }
                sb5.append(str2);
                QLog.d("TogetherBusinessForWebPlugin", 2, sb5.toString());
            }
            g.k().t(2);
            return true;
        }
        if (j3 == 8589934623L) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessForWebPlugin", 2, "handleEvent type =init_webview_complete");
            }
            g.k().l();
            return true;
        }
        if (j3 == 8589934600L && map != null) {
            if (map.get("requestCode") == null || !(map.get("requestCode") instanceof Integer)) {
                return false;
            }
            Integer num = (Integer) map.get("requestCode");
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessForWebPlugin", 2, "handleEvent type =on activityResult requestCode=" + num);
            }
            if (num.intValue() == 200) {
                g.k().p(null);
                return true;
            }
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        TogetherBusinessServlet.RspOpenIdentify rspOpenIdentify;
        String str4;
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "Call TogetherBusinessForWebPlugin handleJsRequest, url=" + str + " pkgName=" + str2 + " method=" + str3);
        }
        if (!"together_business".equals(str2)) {
            return false;
        }
        if ("show_together_button".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessForWebPlugin", 2, "call show_together_button");
            }
            y(-1L, -1, null, null, null);
            this.C = true;
            this.D = null;
            Bundle w3 = w(strArr);
            v(strArr);
            if (w3 != null) {
                this.C = p(strArr);
                QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_identify", w3, this);
            }
        } else if ("click_together_button".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button mRspOpenIdentify=" + this.D);
            }
            this.E = null;
            y(-1L, -1, null, null, null);
            Bundle w16 = w(strArr);
            if (w16 != null && (rspOpenIdentify = this.D) != null) {
                w16.putInt("business_type", rspOpenIdentify.businessType);
                if (this.D.businessType == 2) {
                    if (this.f238451e == 2) {
                        str4 = "c2c_AIO";
                    } else {
                        str4 = "Grp_AIO";
                    }
                    ReportController.o(null, "dc00899", str4, "", "video_tab", "clk_share_grp", 0, 0, this.f238450d + "", this.f238454i, "", "");
                }
                if (D() || B(this.D.resultInfo) || z(w16)) {
                    return true;
                }
                QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", w16, this);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
                }
                return true;
            }
        } else if ("dispear_together_button".equals(str3)) {
            this.f238455m.sendEmptyMessage(4);
        } else if ("show_floating_window".equals(str3)) {
            C(strArr[0]);
        } else if ("close_floating_window".equals(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("uin");
                int optInt = jSONObject.optInt("aio_type");
                WatchTogetherFloatingData watchTogetherFloatingData = new WatchTogetherFloatingData();
                watchTogetherFloatingData.setCurUin(optString);
                watchTogetherFloatingData.setCurType(optInt);
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessForWebPlugin", 2, "CLOSE_FLOATING_WINDOW uin=" + optString + " sessionType=" + optInt);
                }
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.k().e();
                    }
                }, 500L);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } else if ("loading_status_notify".equals(str3)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strArr[0]);
                int optInt2 = jSONObject2.optInt("status");
                double optDouble = jSONObject2.optDouble("video_width", 0.0d);
                double optDouble2 = jSONObject2.optDouble("video_height", 0.0d);
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessForWebPlugin", 2, "LOAD_STATUS_NOTIFY videoWidth=" + optDouble + " videoHeight=" + optDouble2 + " status=" + optInt2);
                }
                g.k().u(optDouble, optDouble2);
                g.k().t(optInt2);
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        return true;
    }
}
