package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.Constants;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import com.tencent.util.QQCustomArkDialogUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import org.light.utils.GsonUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomArkDialog extends QQCustomDialogWtihEmoticonInput {

    /* renamed from: d0, reason: collision with root package name */
    ArkAppView f307085d0;

    /* renamed from: e0, reason: collision with root package name */
    ArkAppContainer f307086e0;

    /* renamed from: f0, reason: collision with root package name */
    ArkAppLoadLayout f307087f0;

    /* renamed from: g0, reason: collision with root package name */
    int f307088g0;

    /* renamed from: h0, reason: collision with root package name */
    int f307089h0;

    /* renamed from: i0, reason: collision with root package name */
    int f307090i0;

    /* renamed from: j0, reason: collision with root package name */
    int f307091j0;

    /* renamed from: k0, reason: collision with root package name */
    int f307092k0;

    /* renamed from: l0, reason: collision with root package name */
    int f307093l0;

    /* renamed from: m0, reason: collision with root package name */
    int f307094m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f307095n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f307096o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f307097p0;

    /* renamed from: q0, reason: collision with root package name */
    private WeakReference<Activity> f307098q0;

    /* renamed from: r0, reason: collision with root package name */
    private ArkAppContainer.b f307099r0;

    /* renamed from: s0, reason: collision with root package name */
    private ArkViewImplement.LoadCallback f307100s0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ArkAppContainer.b {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
        public boolean Fb(ArkAppContainer arkAppContainer) {
            if (QQCustomArkDialog.this.isShowing()) {
                QQCustomArkDialog.this.dismiss();
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
        public boolean U1(ArkAppContainer arkAppContainer, String str, String str2) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f307108a;

        /* renamed from: b, reason: collision with root package name */
        public String f307109b;

        /* renamed from: c, reason: collision with root package name */
        public String f307110c;

        /* renamed from: d, reason: collision with root package name */
        public String f307111d;

        /* renamed from: e, reason: collision with root package name */
        public String f307112e;

        /* renamed from: f, reason: collision with root package name */
        public float f307113f;

        /* renamed from: h, reason: collision with root package name */
        public BaseArkAppContainer f307115h = null;

        /* renamed from: i, reason: collision with root package name */
        public String f307116i = "";

        /* renamed from: j, reason: collision with root package name */
        public boolean f307117j = false;

        /* renamed from: g, reason: collision with root package name */
        public SessionInfo f307114g = new SessionInfo();

        public b(Bundle bundle) {
            this.f307108a = bundle.getString("appName");
            this.f307109b = bundle.getString(QQCustomArkDialogUtil.APP_VIEW);
            this.f307110c = bundle.getString(QQCustomArkDialogUtil.BIZ_SRC);
            this.f307111d = bundle.getString(QQCustomArkDialogUtil.APP_MIN_VERSION);
            this.f307112e = bundle.getString(QQCustomArkDialogUtil.META_DATA);
            this.f307113f = bundle.getFloat("scale", 1.0f);
            String string = bundle.getString("troop_uin");
            if (string != null) {
                SessionInfo sessionInfo = this.f307114g;
                sessionInfo.f179555d = 1;
                sessionInfo.f179557e = string;
            }
        }

        public static Bundle a(String str, String str2, String str3, String str4, String str5, float f16, String str6, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("appName", str);
            bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, str4);
            bundle.putString(QQCustomArkDialogUtil.APP_VIEW, str2);
            bundle.putString(QQCustomArkDialogUtil.BIZ_SRC, str3);
            bundle.putString(QQCustomArkDialogUtil.META_DATA, str5);
            bundle.putFloat("scale", f16);
            bundle.putString("troop_uin", str6);
            return bundle;
        }
    }

    public QQCustomArkDialog(Context context, int i3) {
        super(context, i3);
        this.f307088g0 = 0;
        this.f307089h0 = 0;
        this.f307090i0 = 0;
        this.f307091j0 = 0;
        this.f307092k0 = 0;
        this.f307093l0 = 0;
        this.f307094m0 = -1;
        this.f307095n0 = false;
        this.f307096o0 = false;
        this.f307097p0 = false;
        this.f307098q0 = null;
        this.f307099r0 = new a();
        this.f307100s0 = new ArkViewImplement.LoadCallback() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialog.2
            @Override // com.tencent.ark.ArkViewImplement.LoadCallback
            public void onLoadFailed(int i16, int i17, String str, boolean z16) {
                onLoadState(i16);
            }

            @Override // com.tencent.ark.ArkViewImplement.LoadCallback
            public void onLoadState(final int i16) {
                final WeakReference weakReference = new WeakReference(QQCustomArkDialog.this);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQCustomArkDialog qQCustomArkDialog = (QQCustomArkDialog) weakReference.get();
                        if (qQCustomArkDialog != null) {
                            qQCustomArkDialog.P0(i16);
                        }
                    }
                });
                if (i16 != 0) {
                    QQCustomArkDialog.this.f307096o0 = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("QQCustomArkDialog", 2, "arkView init finish,load state = ", Integer.valueOf(i16), ";outsideShowDialog = ", Boolean.valueOf(QQCustomArkDialog.this.f307095n0), ";alreadyShowDialog:", Boolean.valueOf(QQCustomArkDialog.this.f307097p0));
                    }
                    if (QQCustomArkDialog.this.f307095n0) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialog.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Activity activity;
                                if (QQCustomArkDialog.this.f307098q0 != null) {
                                    activity = (Activity) QQCustomArkDialog.this.f307098q0.get();
                                } else {
                                    activity = null;
                                }
                                if (activity != null && !activity.isFinishing()) {
                                    QQCustomArkDialog.this.show();
                                } else {
                                    QLog.d("QQCustomArkDialog", 1, "overtime,show dialog onloadcallback activity is null or finished");
                                }
                            }
                        });
                    }
                }
            }
        };
    }

    private ArkAppContainer D0(b bVar, Bundle bundle) {
        int i3;
        int i16;
        this.f307086e0 = new ArkAppContainer();
        int width = this.f307085d0.getWidth();
        int height = this.f307085d0.getHeight();
        if (QLog.isDebugVersion()) {
            QLog.d("QQCustomArkDialog", 4, "w=" + width + ",h=" + height + ", appName:" + bVar.f307108a);
        }
        int i17 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        if (ArkFullScreenAppActivity.T2(bundle)) {
            this.f307086e0.h(bVar.f307108a, bVar.f307109b, bVar.f307110c, bVar.f307111d, bVar.f307112e, bVar.f307113f, bVar.f307114g);
        } else {
            String F0 = F0(bundle, "com.tencent.structmsg");
            if (QLog.isColorLevel()) {
                QLog.d("QQCustomArkDialog", 2, ",metaData=" + F0);
            }
            this.f307086e0.h("com.tencent.structmsg", i.b(i17), "", Constants.DEFAULT_MIN_APP_VERSION, F0, com.tencent.mobileqq.ark.f.c(), bVar.f307114g);
        }
        int i18 = this.f307092k0;
        if (i18 != 0 && (i16 = this.f307091j0) != 0 && i18 > i16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQCustomArkDialog", 2, "arkapp_width_fromsdk -> mWidth :" + this.f307092k0 + " -> " + this.f307091j0);
            }
            this.f307092k0 = this.f307091j0;
        }
        int i19 = this.f307092k0;
        if (i19 != 0 && (i3 = this.f307093l0) != 0) {
            this.f307086e0.setFixSize(i19, i3);
        } else {
            this.f307086e0.setFixSize(this.f307091j0, this.f307094m0);
            this.f307086e0.setMaxSize(this.f307091j0, this.f307088g0);
            this.f307086e0.setMinSize(this.f307089h0, this.f307090i0);
        }
        com.tencent.mobileqq.ark.module.b.f199564k = false;
        return this.f307086e0;
    }

    public static String E0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static String F0(Bundle bundle, String str) {
        String str2;
        String str3;
        int i3 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        long j3 = bundle.getLong("req_share_id");
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        String string3 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
        String string4 = bundle.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        String string5 = bundle.getString("image_url");
        bundle.getString(AppConstants.Key.SHARE_RES_PKG_NAME);
        String string6 = bundle.getString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        String string7 = bundle.getString("app_name");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("title", string);
            if (i3 == 2) {
                string6 = H0(string6);
                jSONObject2.put("musicUrl", string6);
                str2 = "music";
            } else if (i3 == 4) {
                str2 = "video";
            } else {
                str2 = "news";
            }
            if (!TextUtils.isEmpty(string2) && string2.contains(HardCodeUtil.qqStr(R.string.qnz))) {
                string2 = string2.replace(HardCodeUtil.qqStr(R.string.f172427qo3), "");
            }
            jSONObject2.put("desc", string2);
            if (TextUtils.isEmpty(string4)) {
                if (TextUtils.isEmpty(string5)) {
                    string4 = "";
                } else {
                    String E0 = E0(string5);
                    FileUtils.copyFile(string5, ArkEnvironmentManager.getInstance().getAppResPath(str) + File.separator + E0);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("res:");
                    sb5.append(E0);
                    string4 = sb5.toString();
                }
            }
            jSONObject2.put("preview", string4);
            jSONObject2.put("tag", string7);
            if (i3 == 2) {
                jSONObject2.put("musicUrl", string6);
                str3 = "music";
            } else if (i3 == 4) {
                str3 = "video";
            } else {
                str3 = str2;
            }
            jSONObject2.put(WadlProxyConsts.KEY_JUMP_URL, H0(string3));
            jSONObject2.put("appid", j3);
            jSONObject2.put("app_type", 1);
            jSONObject.put(str3, jSONObject2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQCustomArkDialog", 2, e16.toString());
            }
        }
        String jSONObject3 = jSONObject.toString();
        if (!TextUtils.isEmpty(jSONObject3)) {
            return jSONObject3.replace("\\/", "/");
        }
        return jSONObject3;
    }

    public static String H0(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("http://")) {
            str = str.replace("http://", "");
        }
        if (str.contains("https://")) {
            return str.replace("https://", "");
        }
        return str;
    }

    private void I0(b bVar, Bundle bundle) {
        cb1.a aVar;
        Intent intent;
        if (!ArkMsgUtils.isMultiMsg(bVar.f307108a, bVar.f307109b)) {
            return;
        }
        hideSoftInputFromWindow();
        cb1.c cVar = (cb1.c) GsonUtils.json2Obj(bVar.f307112e, cb1.c.class);
        if (cVar != null && (aVar = cVar.detail) != null && !aVar.news.isEmpty()) {
            Activity resumeActivity = MobileQQ.sMobileQQ.getResumeActivity();
            if (resumeActivity == null || (intent = resumeActivity.getIntent()) == null) {
                return;
            }
            String str = cVar.detail.source;
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE, str);
            }
            intent.putExtra(AppConstants.Key.FORWARD_ACTIVITY_BG, X());
            NtMsgForwardUtils.q(resumeActivity, resumeActivity.getIntent());
            NTChatHistoryMsgForwardSingleton.INSTANCE.previewForwardMsg(resumeActivity, resumeActivity.getIntent());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQCustomArkDialog", 1, "handleMultiMsgPreview fail, meta err: " + bVar.f307112e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(Bundle bundle) {
        b bVar = new b(bundle);
        bVar.f307113f = com.tencent.mobileqq.ark.f.c();
        ArkAppContainer D0 = D0(bVar, bundle);
        D0.a(this.f307099r0);
        if (QLog.isColorLevel()) {
            QLog.w("QQCustomArkDialog", 2, "init");
        }
        this.f307085d0.a(D0, this.f307087f0);
        Q0(bVar, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean N0(b bVar, Bundle bundle, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            I0(bVar, bundle);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(int i3) {
        Activity activity;
        WeakReference<Activity> weakReference = this.f307098q0;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity != null && !activity.isFinishing()) {
            if (i3 != 1) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f307087f0.getLayoutParams();
                layoutParams.addRule(14);
                int i16 = this.f307091j0;
                layoutParams.width = i16;
                layoutParams.height = i16;
                layoutParams.setMargins(0, 0, 0, 0);
                this.rBtn.setEnabled(false);
                return;
            }
            this.rBtn.setEnabled(true);
            return;
        }
        QLog.d("QQCustomArkDialog", 1, "onLoadFinish.right now activity is null or finished");
    }

    private void Q0(final b bVar, final Bundle bundle) {
        if (bVar != null && bundle != null && ArkMsgUtils.isMultiMsg(bVar.f307108a, bVar.f307109b)) {
            this.f307085d0.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.utils.cs
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean N0;
                    N0 = QQCustomArkDialog.this.N0(bVar, bundle, view, motionEvent);
                    return N0;
                }
            });
        }
    }

    public void J0(String str) {
        this.C.setVisibility(0);
        this.title.setVisibility(8);
        this.F.setVisibility(8);
        this.E.setVisibility(8);
        ((TextView) this.C.findViewById(R.id.kfr)).setText(str);
    }

    public void K0() {
        ((LinearLayout) findViewById(R.id.dmo)).setVisibility(8);
    }

    public void M0(Context context, final Bundle bundle) {
        RelativeLayout.LayoutParams layoutParams;
        int i3;
        Activity activity;
        boolean z16;
        boolean z17;
        boolean z18;
        try {
            getWindow().setFlags(16777216, 16777216);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("QQCustomArkDialog", 2, e16.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQCustomArkDialog", 2, "initArkView:" + bundle);
        }
        p0(7);
        setContentView(R.layout.f167864jw);
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167726f7, (ViewGroup) null);
        inflate.setPadding(0, 0, 0, 0);
        this.f307085d0 = (ArkAppView) inflate.findViewById(R.id.y_);
        this.f307087f0 = (ArkAppLoadLayout) inflate.findViewById(R.id.eet);
        View findViewById = inflate.findViewById(R.id.f164471yu);
        ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).addRule(14);
        findViewById.setPadding(0, 0, 0, 0);
        ((LinearLayout) inflate.findViewById(R.id.f164456yf)).setVisibility(8);
        this.f307085d0.setBorderType(0);
        this.f307085d0.setLoadCallback(this.f307100s0);
        boolean z19 = bundle.getBoolean("is_ark_display_share", false);
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomArkDialog", 2, "from Forward:" + z19);
        }
        ArkAppMessage.Config config = new ArkAppMessage.Config();
        String string = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
        if (!TextUtils.isEmpty(string)) {
            config.fromString(string);
        }
        if (ArkFullScreenAppActivity.T2(bundle) && IndividuationUrlHelper.UrlId.CARD_HOME.equals(config.type)) {
            this.f307094m0 = com.tencent.mobileqq.ark.f.f199481a;
        }
        String string2 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_ADDTIONAL_MESSAGE);
        if (!TextUtils.isEmpty(string2)) {
            q0(string2);
            this.L.requestFocus();
            EditText editText = this.L;
            editText.setSelection(editText.getText().length());
            if (QLog.isColorLevel()) {
                QLog.d("QQCustomArkDialog", 2, "setInitInputValue == " + string2 + ", length=" + this.L.getText().length());
            }
        }
        boolean isSetSizeByConfig = MessageForArkApp.isSetSizeByConfig(config);
        if (isSetSizeByConfig) {
            MessageForArkApp.Size limitToSizeRange = MessageForArkApp.limitToSizeRange(com.tencent.mobileqq.ark.f.c(), config.width.intValue(), config.height.intValue());
            this.f307092k0 = limitToSizeRange.width;
            Integer num = config.autoSize;
            if (num != null && num.intValue() == 1) {
                this.f307092k0 = com.tencent.mobileqq.ark.f.f199481a;
            }
            this.f307093l0 = limitToSizeRange.height;
            if (QLog.isColorLevel()) {
                float c16 = com.tencent.mobileqq.ark.f.c();
                QLog.d("QQCustomArkDialog", 2, "width_from_sdk:" + config.width + ", height_from_sdk:" + config.height + ", scale:" + c16 + ", realwidth:" + ((int) (limitToSizeRange.width / c16)) + ", realheight:" + ((int) (limitToSizeRange.height / c16)));
            }
        }
        LinearLayout linearLayout = this.bodyLayout;
        if (linearLayout != null) {
            layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = (int) context.getResources().getDimension(R.dimen.f158693mi);
            layoutParams.leftMargin = (int) context.getResources().getDimension(R.dimen.f158666lq);
            layoutParams.rightMargin = (int) context.getResources().getDimension(R.dimen.f158667lr);
            layoutParams.bottomMargin = (int) context.getResources().getDimension(R.dimen.f158689me);
        } else {
            layoutParams = null;
        }
        if (!z19) {
            View findViewById2 = findViewById(R.id.aew);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            ArkAppView arkAppView = this.f307085d0;
            arkAppView.setOnTouchListener(arkAppView);
            View findViewById3 = findViewById(R.id.bif);
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            View findViewById4 = findViewById(R.id.biw);
            if (findViewById4 != null) {
                findViewById4.setVisibility(8);
            }
            if (layoutParams != null && this.bodyLayout != null) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bodyLayout.setLayoutParams(layoutParams);
            }
        } else if (layoutParams != null) {
            int i16 = layoutParams.leftMargin + layoutParams.rightMargin;
            if (QLog.isColorLevel()) {
                QLog.d("QQCustomArkDialog", 2, "margin=" + i16);
            }
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(1, 1, 1, 1);
        if (this.bodyLayout != null) {
            String string3 = bundle.getString("appName");
            String string4 = bundle.getString(QQCustomArkDialogUtil.APP_VIEW);
            d91.b arkAIKeyWordConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkAIKeyWordConfig();
            if (arkAIKeyWordConfig != null) {
                z16 = arkAIKeyWordConfig.c().d(string3);
            } else {
                z16 = false;
            }
            if (z16 && !ArkMsgUtils.isMultiMsg(string3, string4)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (isSetSizeByConfig && z17 && ArkMsgUtils.shouldShowBorderInSetSize(string3, string4)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 || (!isSetSizeByConfig && z17)) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setStroke(1, 436207616);
                this.bodyLayout.setBackground(gradientDrawable);
            }
            addCenterView(inflate, layoutParams2);
        }
        this.f307088g0 = MessageForArkApp.dp2px(390.0f);
        this.f307089h0 = MessageForArkApp.dp2px(30.0f);
        this.f307090i0 = MessageForArkApp.dp2px(30.0f);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f158688md);
        if (layoutParams != null) {
            i3 = layoutParams.leftMargin + layoutParams.rightMargin;
        } else {
            i3 = 0;
        }
        this.f307091j0 = dimensionPixelSize - i3;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f307087f0.getLayoutParams();
        layoutParams3.addRule(14);
        int i17 = this.f307091j0;
        layoutParams3.width = i17;
        layoutParams3.height = i17;
        layoutParams3.setMargins(0, 0, 0, 0);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialog.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                if (QQCustomArkDialog.this.f307098q0 != null) {
                    activity2 = (Activity) QQCustomArkDialog.this.f307098q0.get();
                } else {
                    activity2 = null;
                }
                if (activity2 != null && !activity2.isFinishing()) {
                    QQCustomArkDialog.this.L0(bundle);
                } else {
                    QLog.e("QQCustomArkDialog", 1, "init bundle activity is null or finished");
                }
            }
        });
        ArkAppView arkAppView2 = this.f307085d0;
        arkAppView2.setInputHolderAnchor((ViewGroup) arkAppView2.getRootView());
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            com.tencent.mobileqq.ark.o.b(activity, this.f307085d0);
            this.f307098q0 = new WeakReference<>(activity);
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialog.4
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                if (!QQCustomArkDialog.this.f307097p0) {
                    QQCustomArkDialog.this.f307096o0 = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("QQCustomArkDialog", 2, "overtime,show dialog right now");
                    }
                    if (QQCustomArkDialog.this.f307098q0 != null) {
                        activity2 = (Activity) QQCustomArkDialog.this.f307098q0.get();
                    } else {
                        activity2 = null;
                    }
                    if (activity2 != null && !activity2.isFinishing()) {
                        QQCustomArkDialog.this.show();
                    } else {
                        QLog.d("QQCustomArkDialog", 1, "overtime,show dialog right now activity is null or finished");
                    }
                }
            }
        }, 200L);
    }

    public void O0(int i3) {
        ArkAppContainer arkAppContainer = this.f307086e0;
        if (arkAppContainer == null) {
            return;
        }
        arkAppContainer.doOnEvent(i3);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput, com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ArkAppContainer arkAppContainer = this.f307086e0;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(2);
        }
        com.tencent.mobileqq.ark.module.b.f199564k = true;
        super.dismiss();
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput, android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f307085d0 != null && motionEvent.getAction() == 0 && (motionEvent.getX() < this.f307085d0.getX() - 10.0f || motionEvent.getX() > this.f307085d0.getX() + this.f307085d0.getWidth() + 10.0f || motionEvent.getY() < this.f307085d0.getY() - 10.0f || motionEvent.getY() > this.f307085d0.getY() + this.f307085d0.getHeight() + 10.0f)) {
            this.f307085d0.mViewImpl.resetInputState();
            InputMethodManager inputMethodManager = (InputMethodManager) this.f307085d0.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f307085d0.getWindowToken(), 0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    @Override // com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        this.f307095n0 = true;
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomArkDialog", 2, "dialog show,arkViewLoadFinish = ", Boolean.valueOf(this.f307096o0), ";alreadyShowDialog:", Boolean.valueOf(this.f307097p0));
        }
        if (this.f307096o0 && !this.f307097p0) {
            this.f307097p0 = true;
            QLog.d("QQCustomArkDialog", 1, "real show, arkViewLoadFinish = " + this.f307096o0);
            super.show();
        }
    }
}
