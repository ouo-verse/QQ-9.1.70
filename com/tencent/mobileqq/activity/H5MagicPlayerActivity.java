package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class H5MagicPlayerActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    WebViewClient f176180a0;

    /* renamed from: b0, reason: collision with root package name */
    WebView f176181b0;

    /* renamed from: c0, reason: collision with root package name */
    SessionInfo f176182c0;

    /* renamed from: d0, reason: collision with root package name */
    Emoticon f176183d0;

    /* renamed from: e0, reason: collision with root package name */
    Emoticon f176184e0;

    /* renamed from: f0, reason: collision with root package name */
    String f176185f0;

    /* renamed from: g0, reason: collision with root package name */
    boolean f176186g0;

    /* renamed from: h0, reason: collision with root package name */
    Vibrator f176187h0;

    /* renamed from: i0, reason: collision with root package name */
    protected SoundPool f176188i0;

    /* renamed from: j0, reason: collision with root package name */
    String f176189j0;

    /* renamed from: k0, reason: collision with root package name */
    int f176190k0;

    /* renamed from: l0, reason: collision with root package name */
    int f176191l0;

    /* renamed from: m0, reason: collision with root package name */
    String f176192m0;

    /* renamed from: n0, reason: collision with root package name */
    String f176193n0;

    /* renamed from: o0, reason: collision with root package name */
    float f176194o0;

    /* renamed from: p0, reason: collision with root package name */
    float f176195p0;

    /* renamed from: q0, reason: collision with root package name */
    float f176196q0;

    /* renamed from: r0, reason: collision with root package name */
    ShakeListener f176197r0;

    /* renamed from: com.tencent.mobileqq.activity.H5MagicPlayerActivity$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass5 extends TimerTask {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f176198d;
        final /* synthetic */ H5MagicPlayerActivity this$0;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            H5MagicPlayerActivity h5MagicPlayerActivity = this.this$0;
            SoundPool soundPool = h5MagicPlayerActivity.f176188i0;
            if (soundPool != null && soundPool.play(h5MagicPlayerActivity.f176191l0, 1.0f, 1.0f, 0, h5MagicPlayerActivity.f176190k0 - 1, 1.0f) == 0 && QLog.isColorLevel()) {
                QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.f176198d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) H5MagicPlayerActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Emoticon emoticon;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                H5MagicPlayerActivity.this.close();
                H5MagicPlayerActivity h5MagicPlayerActivity = H5MagicPlayerActivity.this;
                if (h5MagicPlayerActivity.f176193n0.equals(h5MagicPlayerActivity.f176192m0) && (emoticon = H5MagicPlayerActivity.this.f176183d0) != null) {
                    ReportController.o(null, "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, emoticon.epId, "", "", "");
                } else {
                    Emoticon emoticon2 = H5MagicPlayerActivity.this.f176183d0;
                    if (emoticon2 != null) {
                        ReportController.o(null, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, emoticon2.epId, "", "", "");
                    } else {
                        ReportController.o(null, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, "", "", "", "");
                    }
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends WebViewClient {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) H5MagicPlayerActivity.this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) str)).booleanValue();
            }
            H5MagicPlayerActivity.this.I2(str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements com.tencent.mobileqq.qroute.route.o {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) H5MagicPlayerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                QLog.i("H5MagicPlayerActivity", 2, "start SendHbActivity onError");
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("H5MagicPlayerActivity", 2, "start SendHbActivity onSuccess");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements SoundPool.OnLoadCompleteListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f176202a;

        d(String str) {
            this.f176202a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) H5MagicPlayerActivity.this, (Object) str);
            }
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, soundPool, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (H5MagicPlayerActivity.this.f176188i0.play(i3, 1.0f, 1.0f, 0, r11.f176190k0 - 1, 1.0f) == 0 && QLog.isColorLevel()) {
                QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.f176202a);
            }
        }
    }

    /* loaded from: classes9.dex */
    class e extends ShakeListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) H5MagicPlayerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ShakeListener
        public void shake() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            H5MagicPlayerActivity h5MagicPlayerActivity = H5MagicPlayerActivity.this;
            if (h5MagicPlayerActivity.f176186g0) {
                h5MagicPlayerActivity.M2(h5MagicPlayerActivity.f176185f0, "{code:0}");
            }
        }
    }

    public H5MagicPlayerActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176189j0 = null;
        this.f176190k0 = -1;
        this.f176191l0 = 0;
        this.f176197r0 = new e();
    }

    private void H2(String str) {
        this.f176185f0 = str;
        this.f176186g0 = true;
        SensorManager sensorManager = (SensorManager) getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        SensorMonitor.registerListener(sensorManager, this.f176197r0, SensorMonitor.getDefaultSensor(sensorManager, 1), 0);
    }

    private void J2(JSONObject jSONObject) {
        String str;
        int i3;
        if (jSONObject == null) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "getAudioFilePath json = null ");
                return;
            }
            return;
        }
        String str2 = null;
        try {
            if (jSONObject.has("file")) {
                str = jSONObject.getString("file");
            } else {
                str = null;
            }
            if (jSONObject.has("loop")) {
                i3 = jSONObject.getInt("loop");
            } else {
                i3 = -1;
            }
            this.f176190k0 = i3;
            str2 = str;
        } catch (Exception e16) {
            this.f176190k0 = -1;
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "playAudio json error ");
            }
        }
        if (str2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "playAudio fileName = null ");
            }
        } else if (this.f176190k0 == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "playAudio loop = -1 ");
            }
        } else {
            this.f176189j0 = MarketFaceConstants.H5MagicRootPath.replace("[epId]", this.f176183d0.epId) + str2;
        }
    }

    private JSONObject K2(String str) {
        String str2;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str) || !str.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
            return null;
        }
        String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (split != null && split.length >= 2) {
            String[] split2 = split[1].split("#");
            if (split2 != null && split2.length >= 2) {
                String str3 = split2[0];
                if (str3 == null) {
                    return null;
                }
                try {
                    str2 = URLDecoder.decode(str3, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("H5MagicPlayerActivity", 2, "Failed to decode json str, josn=" + str3);
                    }
                    str2 = null;
                }
                if (str2 == null) {
                    return null;
                }
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("H5MagicPlayerActivity", 2, "Failed to parse json str,json=");
                    }
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    return null;
                }
                return jSONObject;
            }
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "jsons # error ");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "jsons = error ");
        }
        return null;
    }

    private void L2(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("message")) {
                str = jSONObject.getString("message");
            } else {
                str = "";
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "json parse erro";
        }
        if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "log " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "magicCalljs sn is empty");
                return;
            }
            return;
        }
        String replace = "javascript:execGlobalCallback(((0)),((1)))".replace("((0))", str).replace("((1))", str2);
        this.f176181b0.loadUrl(replace);
        if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "magicCalljs calljs = " + replace);
        }
    }

    private void N2() {
        int i3;
        SessionInfo sessionInfo = this.f176182c0;
        if (sessionInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "openRedPacket:sessionInfo = null ");
                return;
            }
            return;
        }
        int i16 = sessionInfo.f179555d;
        if (i16 == 0) {
            i3 = 1;
        } else if (i16 == 3000) {
            i3 = 2;
        } else if (i16 == 1) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recv_uin", this.f176182c0.f179557e);
            jSONObject.put("recv_type", i3);
            if (!TextUtils.isEmpty("")) {
                jSONObject.put("session_token", "");
            }
            jSONObject.put(WadlProxyConsts.CHANNEL, 1);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "click HongBao:params=" + jSONObject.toString());
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(BaseApplication.getContext(), "/qwallet/redpacket/sendhb");
        activityURIRequest.extra().putInt("come_from", 2);
        activityURIRequest.extra().putString("extra_data", jSONObject.toString());
        activityURIRequest.extra().putString("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#mobiao");
        QRoute.startUri(activityURIRequest, new c());
        ReportController.o(null, "CliOper", "", "", "ep_mall", "0X8005FE5", 0, 0, "", "", "", "");
    }

    private void P2(String str) {
        File file = new File(str);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "playAudio file dont exist ");
                return;
            }
            return;
        }
        if (this.f176190k0 == -1) {
            return;
        }
        QQAudioUtils.i(BaseApplication.getContext(), true);
        if (this.f176188i0 == null) {
            this.f176188i0 = new SoundPool(5, 3, 0);
        }
        int load = this.f176188i0.load(file.getAbsolutePath(), 1);
        this.f176191l0 = load;
        if (load == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "load failure filepath=" + str);
                return;
            }
            return;
        }
        this.f176188i0.setOnLoadCompleteListener(new d(str));
    }

    private void Q2(JSONObject jSONObject) {
        J2(jSONObject);
        if (TextUtils.isEmpty(this.f176189j0)) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "audioFilePath = null ");
                return;
            }
            return;
        }
        P2(this.f176189j0);
    }

    private void R2() {
        if (this.f176188i0 != null) {
            QQAudioUtils.i(BaseApplication.getContext(), false);
            this.f176188i0.stop(this.f176191l0);
            this.f176188i0.release();
        }
    }

    private void S2() {
        this.f176186g0 = false;
        ((SensorManager) getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(this.f176197r0);
    }

    private void T2() {
        Emoticon emoticon = this.f176184e0;
        if (emoticon != null) {
            String replace = MarketFaceConstants.H5MagicIndexHtmlPath.replace("[epId]", emoticon.epId);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("file://" + replace);
            sb5.append("?sender_uin=" + this.f176192m0);
            sb5.append("&self_uin=" + this.f176193n0);
            sb5.append("&auto_play=0");
            sb5.append("&platform=android");
            sb5.append("&version=" + AppSetting.f99551k);
            sb5.append("&start_time=" + System.currentTimeMillis());
            sb5.append("&width=" + this.f176195p0);
            sb5.append("&height=" + this.f176196q0);
            sb5.append("&pixel_ratio=" + this.f176194o0);
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "reply url = " + sb6);
            }
            this.f176181b0.loadUrl(sb6);
            if (((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("emoticon", this.f176184e0);
                bundle.putParcelable("sessionInfo", this.f176182c0);
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_h5magic_sendmsg", "", -1, bundle));
                if (QLog.isColorLevel()) {
                    QLog.d("H5MagicPlayerActivity", 2, "send childEmoticon: childEmotcionEpid = " + this.f176184e0.epId);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("H5MagicPlayerActivity", 2, "send childEmoticon: service not bind");
                }
                close();
            }
            this.f176183d0 = this.f176184e0;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "reply childemoticon doesnt exit ");
            }
            close();
        }
        ReportController.o(null, "CliOper", "", "", "ep_mall", "0X8005FE6", 0, 0, "", "", "", "");
    }

    private void U2(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int i3 = -1;
        try {
            if (jSONObject.has("click")) {
                i3 = jSONObject.getInt("click");
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "reportClick json error");
            }
            e16.printStackTrace();
        }
        ReportController.o(null, "CliOper", "", "", "ep_mall", "itemclick", 0, 0, this.f176183d0.epId, i3 + "", "", "");
    }

    private void V2(JSONObject jSONObject) {
        long j3 = 1000;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("duration")) {
                    j3 = jSONObject.getInt("duration");
                }
            } catch (Exception unused) {
            }
        }
        if (this.f176187h0 == null) {
            this.f176187h0 = (Vibrator) getSystemService("vibrator");
        }
        Vibrator vibrator = this.f176187h0;
        if (vibrator != null) {
            vibrator.vibrate(j3);
        }
    }

    private void clear() {
        this.f176181b0.removeAllViews();
        this.f176181b0.destroy();
        R2();
        S2();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doUnbindService(getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        super.finish();
    }

    private void initUI() {
        this.f176181b0 = new QmX5Webview(this);
        FrameLayout frameLayout = (FrameLayout) super.findViewById(R.id.root);
        frameLayout.addView(this.f176181b0, 0, new FrameLayout.LayoutParams(-1, -1));
        View button = new Button(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.mobileqq.util.x.c(this, 24.0f), com.tencent.mobileqq.util.x.c(this, 24.0f));
        layoutParams.setMargins(0, com.tencent.mobileqq.util.x.c(this, 9.0f), com.tencent.mobileqq.util.x.c(this, 10.0f), 0);
        layoutParams.gravity = 53;
        button.setLayoutParams(layoutParams);
        button.setBackgroundDrawable(getResources().getDrawable(R.drawable.bty));
        button.setOnClickListener(new a());
        frameLayout.addView(button);
        this.f176181b0.setBackgroundColor(0);
        if (this.f176181b0.getBackground() != null) {
            this.f176181b0.getBackground().setAlpha(0);
        }
        this.f176181b0.setScrollBarStyle(33554432);
    }

    private void initWebView() {
        WebSettings settings = this.f176181b0.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        b bVar = new b();
        this.f176180a0 = bVar;
        this.f176181b0.setWebViewClient(bVar);
        if (!"Meizu_M040".equals(Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel())) {
            getWindow().addFlags(16777216);
        }
        this.f176181b0.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f176181b0.removeJavascriptInterface("accessibility");
        this.f176181b0.removeJavascriptInterface("accessibilityTraversal");
    }

    public boolean I2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (str != null && str.startsWith("jsbridge://")) {
            String[] split = str.split("/");
            if (split != null && split.length >= 4) {
                if (!"magicEmotion".equals(split[2])) {
                    if (QLog.isColorLevel()) {
                        QLog.d("H5MagicPlayerActivity", 2, "objectName is error ");
                    }
                    return false;
                }
                String str2 = "#";
                String[] split2 = str.split("#");
                if (split2 != null && split2.length >= 2) {
                    String str3 = split2[1];
                    JSONObject K2 = K2(str);
                    String str4 = split[3];
                    if (TextUtils.isEmpty(str4)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("H5MagicPlayerActivity", 2, "method error ");
                        }
                        return false;
                    }
                    if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str2 = "\\?";
                    }
                    String[] split3 = str4.split(str2);
                    if (split3 != null && split3.length >= 2) {
                        String str5 = split3[0];
                        if ("close".equals(str5)) {
                            close();
                        } else if ("openRedPacket".equals(str5)) {
                            N2();
                        } else if ("reply".equals(str5)) {
                            T2();
                        } else if ("reportClick".equals(str5)) {
                            U2(K2);
                        } else if ("vibrate".equals(str5)) {
                            V2(K2);
                        } else if ("playAudio".equals(str5)) {
                            Q2(K2);
                        } else if ("addShakeEventListener".equals(str5)) {
                            H2(str3);
                        } else if ("removeShakeEventListener".equals(str5)) {
                            S2();
                        } else if ("log".equals(str5)) {
                            L2(K2);
                        }
                        return true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("H5MagicPlayerActivity", 2, "methods error ");
                    }
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("H5MagicPlayerActivity", 2, "sn error ");
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("H5MagicPlayerActivity", 2, "url js error : length < 4 js = " + str);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "modular_web";
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        this.mActNeedImmersive = false;
        super.onCreate(bundle);
        super.setContentView(R.layout.bc6);
        initUI();
        initWebView();
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(getApplicationContext());
        }
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(EmojiManagerServiceConstant.H5MAGIC_SP_NAME, 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(EmojiManagerServiceConstant.H5MAGIC_SP_ISPLAY_KEY, true).commit();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f16 = displayMetrics.density;
        this.f176194o0 = f16;
        this.f176195p0 = displayMetrics.widthPixels / f16;
        this.f176196q0 = displayMetrics.heightPixels / f16;
        Intent intent = super.getIntent();
        long longExtra = intent.getLongExtra("clickTime", 0L);
        this.f176182c0 = (SessionInfo) intent.getParcelableExtra("sessionInfo");
        this.f176183d0 = (Emoticon) intent.getSerializableExtra("emoticon");
        String stringExtra = intent.getStringExtra("autoPlay");
        this.f176192m0 = intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
        if (intent.hasExtra("childEmoticon")) {
            this.f176184e0 = (Emoticon) intent.getSerializableExtra("childEmoticon");
        }
        this.f176193n0 = intent.getStringExtra("selfUin");
        String replace = MarketFaceConstants.H5MagicIndexHtmlPath.replace("[epId]", this.f176183d0.epId);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("file://" + replace);
        sb5.append("?sender_uin=" + this.f176192m0);
        sb5.append("&self_uin=" + this.f176193n0);
        sb5.append("&auto_play=" + stringExtra);
        sb5.append("&platform=android");
        sb5.append("&version=" + AppSetting.f99551k);
        sb5.append("&start_time=" + longExtra);
        sb5.append("&width=" + this.f176195p0);
        sb5.append("&height=" + this.f176196q0);
        sb5.append("&pixel_ratio=" + this.f176194o0);
        this.f176181b0.loadUrl(sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(EmojiManagerServiceConstant.H5MAGIC_SP_NAME, 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(EmojiManagerServiceConstant.H5MAGIC_SP_ISPLAY_KEY, false).commit();
        }
        clear();
    }
}
