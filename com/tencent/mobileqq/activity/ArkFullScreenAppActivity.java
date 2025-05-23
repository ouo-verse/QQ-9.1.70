package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ark.Constants;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.ark.ArkTopGestureLayout;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ArkFullScreenAppActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: l0, reason: collision with root package name */
    private static ArrayList<Bundle> f174879l0;

    /* renamed from: m0, reason: collision with root package name */
    private static int f174880m0;

    /* renamed from: a0, reason: collision with root package name */
    ArkAppView f174881a0;

    /* renamed from: b0, reason: collision with root package name */
    private Stack<QQCustomArkDialog.b> f174882b0;

    /* renamed from: c0, reason: collision with root package name */
    private QQCustomArkDialog.b f174883c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f174884d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f174885e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f174886f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f174887g0;

    /* renamed from: h0, reason: collision with root package name */
    protected ArkTopGestureLayout f174888h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f174889i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f174890j0;

    /* renamed from: k0, reason: collision with root package name */
    private final ArkAppContainer.b f174891k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ArkFullScreenAppActivity$8, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass8 implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f174893d;

        AnonymousClass8(ActionSheet actionSheet) {
            this.f174893d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ArkFullScreenAppActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (ArkFullScreenAppActivity.this.f174883c0 == null) {
                QLog.e("ArkFullScreenAppActivity", 2, "share click: mCurrentInfo == null");
                return;
            }
            ArkFullScreenAppActivity arkFullScreenAppActivity = ArkFullScreenAppActivity.this;
            com.tencent.mobileqq.ark.g.c(arkFullScreenAppActivity.app, "FullScreenClickOper", arkFullScreenAppActivity.f174883c0.f307108a, null, com.tencent.mobileqq.ark.g.f199493d, 0, 0);
            ArkFullScreenAppActivity arkFullScreenAppActivity2 = ArkFullScreenAppActivity.this;
            com.tencent.mobileqq.ark.g.b(arkFullScreenAppActivity2.app, arkFullScreenAppActivity2.f174883c0.f307108a, "FullScreenShareOper", 0, 0, 0L, 0L, 0L, "", "");
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkFullScreenAppActivity.this.f174883c0.f307108a, new Runnable() { // from class: com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (ArkFullScreenAppActivity.this.f174883c0 == null) {
                            return;
                        }
                        ArkFullScreenAppActivity arkFullScreenAppActivity3 = ArkFullScreenAppActivity.this;
                        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable(arkFullScreenAppActivity3.R2(arkFullScreenAppActivity3.f174883c0.f307115h)) { // from class: com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Intent f174896d;

                            /* compiled from: P */
                            /* renamed from: com.tencent.mobileqq.activity.ArkFullScreenAppActivity$8$1$1$a */
                            /* loaded from: classes9.dex */
                            class a implements DialogInterface.OnClickListener {
                                static IPatchRedirector $redirector_;

                                a() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RunnableC70951.this);
                                    }
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i3) {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                    } else {
                                        dialogInterface.dismiss();
                                    }
                                }
                            }

                            {
                                this.f174896d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                try {
                                    Intent intent = this.f174896d;
                                    if (intent != null) {
                                        ForwardBaseOption.startForwardActivityForResult(ArkFullScreenAppActivity.this, intent, 100);
                                        return;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.i("ArkFullScreenAppActivity", 2, "showActionSheet share: intent == null");
                                    }
                                    DialogUtil.createCustomDialog(ArkFullScreenAppActivity.this, 230, HardCodeUtil.qqStr(R.string.jpo), HardCodeUtil.qqStr(R.string.jpk), new a(), null).show();
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("ArkFullScreenAppActivity", 1, "getShareMsg showActionSheet error: " + e16.getMessage());
                                    }
                                }
                            }
                        });
                    }
                }
            });
            this.f174893d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements ArkAppContainer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ArkFullScreenAppActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
        public boolean Fb(ArkAppContainer arkAppContainer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) arkAppContainer)).booleanValue();
            }
            ArkFullScreenAppActivity.this.finish();
            if (ArkFullScreenAppActivity.this.f174886f0) {
                ArkFullScreenAppActivity.this.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
                return false;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
        public boolean U1(ArkAppContainer arkAppContainer, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, arkAppContainer, str, str2)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ArkFullScreenAppActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (ArkFullScreenAppActivity.this.f174883c0 != null) {
                    ArkFullScreenAppActivity arkFullScreenAppActivity = ArkFullScreenAppActivity.this;
                    com.tencent.mobileqq.ark.g.c(arkFullScreenAppActivity.app, "FullScreenClickOper", arkFullScreenAppActivity.f174883c0.f307108a, null, com.tencent.mobileqq.ark.g.f199491b, 0, 0);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ArkFullScreenAppActivity", 2, "click to close");
                }
                ArkFullScreenAppActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ArkFullScreenAppActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (ArkFullScreenAppActivity.this.f174883c0 != null) {
                    ArkFullScreenAppActivity arkFullScreenAppActivity = ArkFullScreenAppActivity.this;
                    com.tencent.mobileqq.ark.g.c(arkFullScreenAppActivity.app, "FullScreenClickOper", arkFullScreenAppActivity.f174883c0.f307108a, null, com.tencent.mobileqq.ark.g.f199492c, 0, 0);
                }
                ArkFullScreenAppActivity.this.showActionSheet();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements ArkAppView.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ArkFullScreenAppActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppView.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppView.b
        public void b() {
            BaseArkAppContainer baseArkAppContainer;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ArkFullScreenAppActivity", 2, "arkview loadSucc: " + ArkFullScreenAppActivity.this.f174883c0);
            }
            if (ArkFullScreenAppActivity.this.f174883c0 != null && (baseArkAppContainer = ArkFullScreenAppActivity.this.f174883c0.f307115h) != null) {
                int i3 = 0;
                if (baseArkAppContainer.checkShare() && ArkFullScreenAppActivity.this.f174883c0.f307117j) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("ArkFullScreenAppActivity", 2, "supportShare: " + z16);
                }
                ImageView imageView = ArkFullScreenAppActivity.this.rightViewImg;
                if (!z16) {
                    i3 = 4;
                }
                imageView.setVisibility(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ArkFullScreenAppActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ArkFullScreenAppActivity.this.finish();
                ArkFullScreenAppActivity.this.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f174879l0 = new ArrayList<>();
            f174880m0 = 0;
        }
    }

    public ArkFullScreenAppActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f174882b0 = new Stack<>();
        this.f174883c0 = null;
        this.f174885e0 = 0;
        this.f174889i0 = 0;
        this.f174890j0 = 0;
        this.f174891k0 = new a();
    }

    private static String J2(String str, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forward", 1);
            jSONObject.put("autosize", 1);
            if (map != null && "normal".equals(map.get("type"))) {
                jSONObject.put("type", "normal");
            } else {
                jSONObject.put("type", IndividuationUrlHelper.UrlId.CARD_HOME);
            }
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    jSONObject.put(str2, jSONObject2.getString(str2));
                }
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static Intent K2(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, float f16, String str8, String str9) {
        String str10;
        l91.a.c(true);
        if (TextUtils.isEmpty(str9)) {
            str10 = Constants.DEFAULT_MIN_APP_VERSION;
        } else {
            str10 = str9;
        }
        return N2(context, str, str2, str3, str4, str5, str6, str7, f16, str8, str10);
    }

    public static Intent L2(Context context, String str, String str2, String str3, String str4, String str5, float f16) {
        return M2(context, str, str2, str3, str4, str5, f16, ArkAppCacheMgr.getApplicationFromManifest(str2, str3, Constants.DEFAULT_MIN_APP_VERSION));
    }

    public static Intent M2(Context context, String str, String str2, String str3, String str4, String str5, float f16, Map<String, String> map) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String str6 = "";
            String str7 = Constants.DEFAULT_MIN_APP_VERSION;
            if (map != null) {
                if (map.containsKey("desc")) {
                    str6 = map.get("desc");
                }
                if (map.containsKey("version")) {
                    str7 = map.get("version");
                }
            }
            String str8 = str7;
            String format = String.format(HardCodeUtil.qqStr(R.string.jpn), str6);
            String J2 = J2(str5, map);
            Bundle a16 = QQCustomArkDialog.b.a(str2, str, str3, str8, str4, f16, null, null);
            a16.putBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT, false);
            a16.putString("forward_ark_app_name", str2);
            a16.putString("forward_ark_app_view", str);
            a16.putString("forward_ark_biz_src", str3);
            a16.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, str6);
            a16.putString("forward_ark_app_ver", str8);
            a16.putString("forward_ark_app_meta", str4);
            a16.putString("forward_ark_app_prompt", format);
            a16.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, J2);
            Intent intent = new Intent();
            intent.setClass(context, ForwardRecentActivity.class);
            intent.putExtra("forward_type", 27);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtras(a16);
            if (QLog.isColorLevel()) {
                QLog.i("ArkFullScreenAppActivity", 2, "buildForwardIntent: " + a16);
            }
            return intent;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkFullScreenAppActivity", 1, "buildForwardIntent send message parameter error: " + e16.getMessage());
            }
            return null;
        }
    }

    public static Intent N2(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, float f16, String str8, String str9) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String Q2 = Q2(str5);
            Bundle a16 = QQCustomArkDialog.b.a(str2, str, str3, str9, str4, f16, null, null);
            a16.putBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT, false);
            a16.putString("forward_ark_app_name", str2);
            a16.putString("forward_ark_app_view", str);
            a16.putString("forward_ark_biz_src", str3);
            a16.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, str8);
            a16.putString("forward_ark_app_ver", str9);
            a16.putString("forward_ark_app_meta", str4);
            a16.putString("forward_ark_app_prompt", str6);
            a16.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, Q2);
            a16.putBoolean(AppConstants.Key.FORWARD_ARK_FROM_SDK, true);
            a16.putString(AppConstants.Key.FORWARD_APPID_ARK_FROM_SDK, str7);
            Intent intent = new Intent();
            intent.setClass(context, ForwardRecentActivity.class);
            intent.putExtra("forward_type", 11);
            intent.putExtras(a16);
            if (QLog.isColorLevel()) {
                QLog.i("ArkFullScreenAppActivity", 2, "buildForwardIntent: " + a16);
            }
            return intent;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkFullScreenAppActivity", 1, "buildForwardIntent send message parameter error: " + e16.getMessage());
            }
            return null;
        }
    }

    private ArkAppContainer P2(QQCustomArkDialog.b bVar) {
        ArkAppContainer arkAppContainer = new ArkAppContainer();
        bVar.f307115h = arkAppContainer;
        int width = this.f174881a0.getWidth();
        int height = this.f174881a0.getHeight();
        if (QLog.isColorLevel()) {
            QLog.d("ArkFullScreenAppActivity", 2, "create App: w=" + width + ",h=" + height);
        }
        arkAppContainer.h(bVar.f307108a, bVar.f307109b, bVar.f307110c, bVar.f307111d, bVar.f307112e, com.tencent.mobileqq.ark.f.c(), bVar.f307114g);
        arkAppContainer.setFixSize(width, height);
        arkAppContainer.setMaxSize(width, height);
        arkAppContainer.setMinSize(width, height);
        arkAppContainer.a(this.f174891k0);
        return arkAppContainer;
    }

    public static String Q2(String str) throws JSONException {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            jSONObject = new JSONObject(str);
            jSONObject.put("forward", 1);
            if (!jSONObject.has("type")) {
                jSONObject.put("type", IndividuationUrlHelper.UrlId.CARD_HOME);
            }
        } else {
            jSONObject = new JSONObject();
            jSONObject.put("forward", 1);
            jSONObject.put("autosize", 1);
            jSONObject.put("type", IndividuationUrlHelper.UrlId.CARD_HOME);
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2(Bundle bundle) {
        QQCustomArkDialog.b bVar = new QQCustomArkDialog.b(bundle);
        this.f174885e0 = bundle.getInt("sourceType", 0);
        ArkAppContainer P2 = P2(bVar);
        this.f174882b0.push(bVar);
        this.f174883c0 = bVar;
        this.f174881a0.initArkView(P2, false);
        setTitle(bVar.f307116i);
        if (1 == this.f174885e0) {
            com.tencent.mobileqq.ark.g.b(this.app, bVar.f307108a, "ArkFullEnterFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
        }
        if (this.f174882b0.size() > 1) {
            this.f174884d0.setVisibility(0);
        } else {
            this.f174884d0.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArkFullScreenAppActivity", 2, "init: " + bVar.f307108a + ", " + this.f174882b0.size());
        }
    }

    public static boolean T2(Bundle bundle) {
        String string = bundle.getString("forward_ark_app_name");
        String string2 = bundle.getString("forward_ark_app_view");
        String string3 = bundle.getString("forward_ark_app_ver");
        String string4 = bundle.getString("forward_ark_app_meta");
        String string5 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
        if (QLog.isColorLevel()) {
            QLog.e("ArkFullScreenAppActivity", 4, "richMsgBody displayArk appName =" + string + ", appView =" + string2 + ", config =" + string5 + ", appVer" + string3);
        }
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string4)) {
            return true;
        }
        return false;
    }

    public static void V2(Activity activity, String str, String str2, String str3, String str4) {
        if (activity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4)) {
            Bundle a16 = QQCustomArkDialog.b.a(str, str2, str3, Constants.DEFAULT_MIN_APP_VERSION, str4, com.tencent.mobileqq.ark.f.c(), null, null);
            a16.putInt("sourceType", 0);
            Intent intent = new Intent(activity, (Class<?>) ArkFullScreenAppActivity.class);
            intent.putExtras(a16);
            intent.putExtra("card_height", MessageForArkApp.dp2px(297.0f));
            intent.putExtra("show_as_card", true);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
        }
    }

    public static void W2(Context context, String str, String str2, String str3, String str4, String str5, float f16, String str6, int i3) {
        Bundle a16 = QQCustomArkDialog.b.a(str, str2, str3, str4, str5, com.tencent.mobileqq.ark.f.c(), str6, null);
        a16.putInt("sourceType", i3);
        if (QLog.isColorLevel()) {
            QLog.d("ArkFullScreenAppActivity", 2, "startFullScreenApp:" + a16);
        }
        Intent intent = new Intent(context, (Class<?>) ArkFullScreenAppActivity.class);
        intent.putExtras(a16);
        context.startActivity(intent);
    }

    private void clear() {
        Iterator<QQCustomArkDialog.b> it = this.f174882b0.iterator();
        while (it.hasNext()) {
            BaseArkAppContainer baseArkAppContainer = it.next().f307115h;
            if (baseArkAppContainer != null) {
                baseArkAppContainer.doOnEvent(2);
            }
        }
        this.f174882b0.clear();
    }

    public Intent R2(BaseArkAppContainer baseArkAppContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Intent) iPatchRedirector.redirect((short) 11, (Object) this, (Object) baseArkAppContainer);
        }
        try {
            String viewShare = baseArkAppContainer.getViewShare();
            if (TextUtils.isEmpty(viewShare)) {
                return null;
            }
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(viewShare.getBytes()));
            Node item = parse.getElementsByTagName("View").item(0);
            if (item != null && item.getChildNodes().getLength() > 0 && (item.getFirstChild() instanceof Text)) {
                String nodeValue = item.getFirstChild().getNodeValue();
                if (TextUtils.isEmpty(nodeValue)) {
                    return null;
                }
                Node item2 = parse.getElementsByTagName("Metadata").item(0);
                JSONObject jSONObject = new JSONObject();
                if (item2 != null && item2.getChildNodes().getLength() > 0 && !com.tencent.mobileqq.ark.l.a(item2.getFirstChild(), jSONObject)) {
                    jSONObject = new JSONObject();
                }
                String appName = baseArkAppContainer.getAppName();
                String bizSrc = baseArkAppContainer.getBizSrc();
                String jSONObject2 = jSONObject.toString();
                float c16 = com.tencent.mobileqq.ark.f.c();
                String configFromXml = MessageForArkApp.getConfigFromXml(parse);
                if (QLog.isColorLevel()) {
                    QLog.i("ArkApp", 2, "ArkFullScreenApp config getShareMsg:" + configFromXml);
                }
                return L2(this, nodeValue, appName, bizSrc, jSONObject2, configFromXml, c16);
            }
            return null;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkFullScreenAppActivity", 1, "getShareMsg send message parameter error: " + e16.getMessage());
            }
            return null;
        }
    }

    public void U2(BaseArkAppContainer baseArkAppContainer, boolean z16) {
        BaseArkAppContainer baseArkAppContainer2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, baseArkAppContainer, Boolean.valueOf(z16));
            return;
        }
        Iterator<QQCustomArkDialog.b> it = this.f174882b0.iterator();
        while (it.hasNext()) {
            QQCustomArkDialog.b next = it.next();
            if (next != null && (baseArkAppContainer2 = next.f307115h) == baseArkAppContainer) {
                next.f307117j = z16;
                if (this.f174883c0 == next) {
                    if (!baseArkAppContainer2.checkShare() || !next.f307117j) {
                        z17 = false;
                    }
                    ImageView imageView = this.rightViewImg;
                    if (!z17) {
                        i3 = 4;
                    }
                    imageView.setVisibility(i3);
                    return;
                }
                return;
            }
        }
    }

    public void Y2(BaseArkAppContainer baseArkAppContainer, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) baseArkAppContainer, (Object) str);
            return;
        }
        QQCustomArkDialog.b bVar = this.f174883c0;
        if (bVar != null && bVar.f307115h == baseArkAppContainer) {
            bVar.f307116i = str;
            setTitle(str);
            return;
        }
        Iterator<QQCustomArkDialog.b> it = this.f174882b0.iterator();
        while (it.hasNext()) {
            QQCustomArkDialog.b next = it.next();
            if (next != null && next.f307115h == baseArkAppContainer) {
                next.f307116i = str;
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        QQCustomArkDialog.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && i3 == 100 && (bVar = this.f174883c0) != null) {
            com.tencent.mobileqq.ark.g.c(this.app, "FullScreenClickOper", bVar.f307108a, null, com.tencent.mobileqq.ark.g.f199494e, 0, 0);
            com.tencent.mobileqq.ark.g.b(this.app, this.f174883c0.f307108a, "FullScreenShareSuccess", 0, 0, 0L, 0L, 0L, "", "");
            if (1 == this.f174885e0) {
                com.tencent.mobileqq.ark.g.b(this.app, this.f174883c0.f307108a, "ArkFullShareFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
            }
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return false;
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        if (defaultDisplay != null) {
            this.f174889i0 = defaultDisplay.getWidth();
            this.f174890j0 = defaultDisplay.getHeight();
        }
        setContentView(R.layout.f167662dl);
        RelativeLayout relativeLayout = this.titleRoot;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.f156895ek));
        }
        ((NavBarCommon) this.f194786vg).changeBg(true);
        this.leftView.setText("");
        this.leftView.setMinWidth(MessageForArkApp.dp2px(35.0f));
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rlCommenTitle);
        ImageView imageView = new ImageView(this);
        this.f174884d0 = imageView;
        imageView.setImageResource(R.drawable.f160837nq);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(1, R.id.ivTitleBtnLeft);
        relativeLayout2.addView(this.f174884d0, layoutParams);
        this.f174884d0.setOnClickListener(new b());
        int dp2px = MessageForArkApp.dp2px(6.0f);
        this.f174884d0.setPadding(dp2px, 0, dp2px, 0);
        ImageView imageView2 = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.rightViewImg = imageView2;
        imageView2.setBackgroundDrawable(null);
        IphoneTitleBarActivity.setLayerType(this.rightViewImg);
        this.rightViewImg.setVisibility(4);
        this.rightViewImg.setImageResource(R.drawable.f160838ns);
        this.rightViewImg.setContentDescription(HardCodeUtil.qqStr(R.string.jpl));
        this.rightViewImg.setOnClickListener(new c());
        ArkAppView arkAppView = (ArkAppView) findViewById(R.id.f164465yo);
        this.f174881a0 = arkAppView;
        arkAppView.setBorderType(0);
        ArkAppView arkAppView2 = this.f174881a0;
        arkAppView2.setOnTouchListener(arkAppView2);
        this.f174881a0.setCallback(new d());
        this.f174881a0.post(new Runnable(extras) { // from class: com.tencent.mobileqq.activity.ArkFullScreenAppActivity.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f174892d;

            {
                this.f174892d = extras;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ArkFullScreenAppActivity.this, (Object) extras);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ArkFullScreenAppActivity.this.S2(this.f174892d);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d("ArkFullScreenAppActivity", 2, "doOnCreate:" + extras);
        }
        findViewById(R.id.rlCommenTitle);
        com.tencent.mobileqq.ark.g.c(this.app, "ShowView", extras.getString("appName"), null, com.tencent.mobileqq.ark.g.f199495f, 0, 0);
        com.tencent.mobileqq.ark.o.b(this, this.f174881a0);
        FlingHandler flingHandler = GestureActivityModule.getFlingHandler(this);
        if (flingHandler != null && (flingHandler instanceof FlingGestureHandler)) {
            ArkTopGestureLayout arkTopGestureLayout = new ArkTopGestureLayout(this);
            this.f174888h0 = arkTopGestureLayout;
            ((FlingGestureHandler) flingHandler).setTopLayout(arkTopGestureLayout);
        }
        if (ThemeUtil.isInNightMode(this.app)) {
            LayoutInflater.from(this).inflate(R.layout.a9t, (RelativeLayout) findViewById(R.id.jqh));
        }
        this.f174886f0 = getIntent().getBooleanExtra("show_as_card", false);
        int intExtra = getIntent().getIntExtra("card_height", 0);
        this.f174887g0 = intExtra;
        if (this.f174886f0 && intExtra > 0) {
            findViewById(R.id.rlCommenTitle).setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f174881a0.getLayoutParams();
            layoutParams2.addRule(12);
            layoutParams2.height = this.f174887g0;
            RelativeLayout relativeLayout3 = this.titleRoot;
            if (relativeLayout3 != null) {
                relativeLayout3.setBackgroundResource(0);
                this.titleRoot.setOnClickListener(new e());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        clear();
        super.doOnDestroy();
        if (QLog.isColorLevel()) {
            QLog.i("ArkFullScreenAppActivity", 2, "doOnDestroy: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        Bundle extras = intent.getExtras();
        S2(extras);
        if (QLog.isColorLevel()) {
            QLog.d("ArkFullScreenAppActivity", 2, "doOnNewIntent" + extras);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp != null) {
            systemBarComp.setStatusBarDrawable(null);
            if (this.f174886f0) {
                i3 = 0;
            } else {
                i3 = -16777216;
            }
            systemBarComp.setStatusBarColor(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            clear();
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        QQCustomArkDialog.b bVar = this.f174883c0;
        if (bVar != null) {
            com.tencent.mobileqq.ark.g.c(this.app, "FullScreenClickOper", bVar.f307108a, null, com.tencent.mobileqq.ark.g.f199490a, 0, 0);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArkFullScreenAppActivity", 2, "onBackEvent: " + this.f174882b0.size());
        }
        if (this.f174882b0.size() <= 1) {
            this.f174884d0.setVisibility(8);
            if (this.f174886f0) {
                finish();
                overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
                return true;
            }
            return super.onBackEvent();
        }
        BaseArkAppContainer baseArkAppContainer = this.f174882b0.pop().f307115h;
        if (baseArkAppContainer != null) {
            baseArkAppContainer.doOnEvent(2);
        }
        QQCustomArkDialog.b peek = this.f174882b0.peek();
        this.f174883c0 = peek;
        if (peek != null) {
            this.f174881a0.initArkView(peek.f307115h);
            setTitle(this.f174883c0.f307116i);
        }
        if (this.f174882b0.size() > 1) {
            this.f174884d0.setVisibility(0);
        } else {
            this.f174884d0.setVisibility(8);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            if (defaultDisplay == null) {
                QLog.d("ArkFullScreenAppActivity", 2, "onConfigurationChanged:get display null");
            } else {
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
                if (QLog.isColorLevel()) {
                    QLog.d("ArkFullScreenAppActivity", 2, "onConfigurationChanged:width=", Integer.valueOf(width), ", height=", Integer.valueOf(height), ", mScreenWidth=", Integer.valueOf(this.f174889i0), ", mScreenheight=", Integer.valueOf(this.f174890j0));
                }
                int i16 = this.f174889i0;
                if (i16 != 0 && (i3 = this.f174890j0) != 0 && (i16 != width || i3 != height)) {
                    this.f174881a0.setFixSize(width, height);
                    this.f174881a0.setMinSize(width, height);
                    this.f174881a0.setMaxSize(width, height);
                    this.f174881a0.setViewRect(width, height);
                }
                this.f174889i0 = width;
                this.f174890j0 = height;
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void showActionSheet() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.addButton(getString(R.string.hjr), 0);
        actionSheet.setOnButtonClickListener(new AnonymousClass8(actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }
}
