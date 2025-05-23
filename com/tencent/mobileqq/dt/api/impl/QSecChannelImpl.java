package com.tencent.mobileqq.dt.api.impl;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.dt.app.O3MainProcessChannel;
import com.tencent.mobileqq.dt.model.TuringWrapper;
import com.tencent.mobileqq.dt.model.i;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QSecChannelImpl implements IQSecChannel {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FEKitMainQSec_Channel";
    private static boolean startRegFlag;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends com.tencent.mobileqq.dt.web.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.dt.api.a f203690f;

        a(com.tencent.mobileqq.dt.api.a aVar) {
            this.f203690f = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QSecChannelImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int i3, @NonNull byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            com.tencent.mobileqq.dt.api.a aVar = this.f203690f;
            if (aVar != null) {
                aVar.onResult(i3, bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends com.tencent.mobileqq.dt.web.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.dt.api.a f203692f;

        b(com.tencent.mobileqq.dt.api.a aVar) {
            this.f203692f = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QSecChannelImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int i3, @NonNull byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            com.tencent.mobileqq.dt.api.a aVar = this.f203692f;
            if (aVar != null) {
                aVar.onResult(i3, bArr);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203694d;

        c(String str) {
            this.f203694d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QSecChannelImpl.this, (Object) str);
            }
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            QSecChannelImpl.this.regReport(null, this.f203694d, motionEvent);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f203696d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f203697e;

        d(AppInterface appInterface, String str) {
            this.f203696d = appInterface;
            this.f203697e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QSecChannelImpl.this, appInterface, str);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QSecChannelImpl.this.uiReport(this.f203696d, com.tencent.mobileqq.dt.api.c.f203639b, this.f203697e, motionEvent);
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f203699d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f203700e;

        e(AppInterface appInterface, String str) {
            this.f203699d = appInterface;
            this.f203700e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QSecChannelImpl.this, appInterface, str);
            }
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QSecChannelImpl.this.uiReport(this.f203699d, com.tencent.mobileqq.dt.api.c.F, this.f203700e, motionEvent);
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            startRegFlag = false;
        }
    }

    public QSecChannelImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean filter(String str, Object obj) {
        if (com.tencent.mobileqq.dt.api.c.f203640c.equals(str)) {
            startRegFlag = true;
            O3MainProcessChannel.e();
        }
        if (isSmsPage(str) && !startRegFlag) {
            return true;
        }
        return false;
    }

    private static boolean isSmsPage(String str) {
        if (!com.tencent.mobileqq.dt.api.c.f203658u.equals(str) && !com.tencent.mobileqq.dt.api.c.f203656s.equals(str) && !com.tencent.mobileqq.dt.api.c.f203657t.equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realReport(AppInterface appInterface, String str, JSONObject jSONObject, com.tencent.mobileqq.dt.api.a aVar) {
        if (appInterface == null && (appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        O3BusinessHandler o3BusinessHandler = (O3BusinessHandler) appInterface.getBusinessHandler(O3BusinessHandler.class.getName());
        if (o3BusinessHandler != null && str != null && jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("cmd", str);
                jSONObject2.put("data", jSONObject);
                o3BusinessHandler.D2("notify", jSONObject2.toString(), new b(aVar));
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "json exception:" + e16.getMessage());
                return;
            }
        }
        QLog.e(TAG, 1, "sendRequest but handler is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uiReport(AppInterface appInterface, String str, String str2, Object obj) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            if (filter(str2, obj)) {
                return;
            }
            String d16 = com.tencent.mobileqq.dt.report.d.d(obj);
            if (!"-1".equals(d16)) {
                ThreadManagerV2.excute(new Runnable(str, str2, d16, appInterface) { // from class: com.tencent.mobileqq.dt.api.impl.QSecChannelImpl.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f203682d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f203683e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f203684f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ AppInterface f203685h;

                    {
                        this.f203682d = str;
                        this.f203683e = str2;
                        this.f203684f = d16;
                        this.f203685h = appInterface;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QSecChannelImpl.this, str, str2, d16, appInterface);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("scene", this.f203682d);
                            if (QLog.isColorLevel()) {
                                QLog.d(QSecChannelImpl.TAG, 1, "reg,event:[" + this.f203683e + "]");
                            }
                            jSONObject.put("event", this.f203683e);
                            String str3 = this.f203684f;
                            if (com.tencent.mobileqq.dt.report.d.f() && TextUtils.equals(this.f203683e, com.tencent.mobileqq.dt.api.c.f203655r)) {
                                str3 = com.tencent.mobileqq.dt.app.b.i().f();
                            }
                            jSONObject.put("params", str3);
                            if (TextUtils.equals(this.f203682d, com.tencent.mobileqq.dt.api.c.f203639b)) {
                                QLog.i(QSecChannelImpl.TAG, 1, "r,event:[" + this.f203683e + "],params:[value:" + this.f203684f);
                            }
                            QSecChannelImpl.this.realReport(this.f203685h, "ui_report", jSONObject, null);
                            if (this.f203683e.equals(com.tencent.mobileqq.dt.api.c.A)) {
                                boolean unused = QSecChannelImpl.startRegFlag = false;
                                jSONObject.put("event", com.tencent.mobileqq.dt.api.c.D);
                                jSONObject.put("params", "");
                                QSecChannelImpl.this.realReport(this.f203685h, "ui_report", jSONObject, null);
                            }
                        } catch (Throwable th5) {
                            QLog.e(QSecChannelImpl.TAG, 1, "reg Report json exception:" + th5.getMessage());
                        }
                    }
                }, 16, null, false);
            }
            if (TextUtils.equals(str2, com.tencent.mobileqq.dt.api.c.f203648k) || TextUtils.equals(str2, com.tencent.mobileqq.dt.api.c.f203663z)) {
                ThreadManagerV2.excute(new Runnable(appInterface) { // from class: com.tencent.mobileqq.dt.api.impl.QSecChannelImpl.5
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AppInterface f203686d;

                    {
                        this.f203686d = appInterface;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QSecChannelImpl.this, (Object) appInterface);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("scene", com.tencent.mobileqq.dt.api.c.f203639b);
                            String b16 = i.c().b(com.tencent.mobileqq.dt.api.c.f203649l);
                            jSONObject.put("event", com.tencent.mobileqq.dt.api.c.f203653p);
                            jSONObject.put("params", b16);
                            if (b16.length() > 10) {
                                QSecChannelImpl.this.realReport(this.f203686d, "ui_report", jSONObject, null);
                            }
                            String b17 = i.c().b(com.tencent.mobileqq.dt.api.c.f203661x);
                            jSONObject.put("event", com.tencent.mobileqq.dt.api.c.B);
                            jSONObject.put("params", b17);
                            if (b17.length() > 10) {
                                QSecChannelImpl.this.realReport(this.f203686d, "ui_report", jSONObject, null);
                            }
                            String b18 = i.c().b(com.tencent.mobileqq.dt.api.c.f203662y);
                            jSONObject.put("event", com.tencent.mobileqq.dt.api.c.C);
                            jSONObject.put("params", b18);
                            if (b18.length() > 10) {
                                QSecChannelImpl.this.realReport(this.f203686d, "ui_report", jSONObject, null);
                            }
                        } catch (Throwable th5) {
                            QLog.e(QSecChannelImpl.TAG, 1, "et exception:" + th5);
                        }
                    }
                }, 16, null, false);
            }
            if (!com.tencent.mobileqq.dt.report.d.f()) {
                QLog.e(TAG, 1, "newSensorEnable close!");
                return;
            }
            if (TextUtils.equals(str, com.tencent.mobileqq.dt.api.c.f203639b) && com.tencent.mobileqq.dt.app.b.i().e(str2, obj)) {
                ThreadManagerV2.executeDelay(new Runnable(str2, str, appInterface) { // from class: com.tencent.mobileqq.dt.api.impl.QSecChannelImpl.6
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f203687d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f203688e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ AppInterface f203689f;

                    {
                        this.f203687d = str2;
                        this.f203688e = str;
                        this.f203689f = appInterface;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QSecChannelImpl.this, str2, str, appInterface);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (com.tencent.mobileqq.dt.report.d.e(this.f203687d)) {
                                jSONObject.put("scene", this.f203688e);
                                String g16 = com.tencent.mobileqq.dt.app.b.i().g();
                                if (TextUtils.equals(this.f203688e, com.tencent.mobileqq.dt.api.c.f203639b)) {
                                    QLog.i(QSecChannelImpl.TAG, 1, "r,event:[" + this.f203687d + "],len:" + g16.length() + ",params:[value:" + g16);
                                }
                                jSONObject.put("params", g16);
                                jSONObject.put("event", com.tencent.mobileqq.dt.report.d.a(this.f203687d));
                                QSecChannelImpl.this.realReport(this.f203689f, "ui_report", jSONObject, null);
                            }
                        } catch (Throwable th5) {
                            QLog.e(QSecChannelImpl.TAG, 1, "reg Report json exception:" + th5.getMessage());
                        }
                    }
                }, 16, null, false, 10000L);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "config exception:" + th5);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void collectReport(AppInterface appInterface, String str, String str2, com.tencent.mobileqq.dt.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, str, str2, aVar);
        } else {
            ThreadManagerV2.excute(new Runnable(str, str2) { // from class: com.tencent.mobileqq.dt.api.impl.QSecChannelImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f203680d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f203681e;

                {
                    this.f203680d = str;
                    this.f203681e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QSecChannelImpl.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!QSecChannelImpl.this.reportEnable()) {
                            QLog.d(QSecChannelImpl.TAG, 1, "ui report switch close! ");
                            return;
                        }
                        AppInterface appInterface2 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                        jSONObject.put("scene", this.f203680d);
                        jSONObject.put("event", "0");
                        jSONObject.put("params", this.f203681e);
                        QSecChannelImpl.this.realReport(appInterface2, "ui_report", jSONObject, null);
                    } catch (Throwable th5) {
                        QLog.e(QSecChannelImpl.TAG, 1, "collectReport json exception:" + th5.getMessage());
                    }
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void feCameraActionReport(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, com.tencent.mobileqq.dt.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInterface, str, str2, str3, str4, str5, str6, aVar);
            return;
        }
        if (str != null && str5 != null && str6 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AudienceReportConst.ROOM_ID, str);
                jSONObject.put("camera_id", str3);
                jSONObject.put("camera_type", str4);
                jSONObject.put("camera_business", str2);
                jSONObject.put("camera_fromuin", str5);
                jSONObject.put("camera_touin", str6);
                QLog.e(TAG, 1, "cameraid:" + str3 + ",cameratype:" + str4 + ",roomid:" + str + ",business:" + str2 + ",fromuin:" + str5 + ",touin:" + str6);
                realReport(appInterface, "camera_detect", jSONObject, aVar);
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "face EnvReport json exception:" + e16.getMessage());
                return;
            }
        }
        QLog.e(TAG, 1, "camera rt, but params is null");
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void feEnvReport(AppInterface appInterface, String str, String str2, com.tencent.mobileqq.dt.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInterface, str, str2, aVar);
            return;
        }
        if (str != null && str2 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", str);
                jSONObject.put("content", str2);
                realReport(appInterface, "face_detect", jSONObject, aVar);
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "face EnvReport json exception:" + e16.getMessage());
                return;
            }
        }
        QLog.e(TAG, 1, "face EnvReport, but params is null");
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void loginReport(AppInterface appInterface, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appInterface, str, obj);
        } else if (!reportEnable()) {
            QLog.d(TAG, 1, "loginReport switch close! ");
        } else {
            TuringWrapper.e();
            uiReport(appInterface, com.tencent.mobileqq.dt.api.c.F, str, obj);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void loginTouchEvent(AppInterface appInterface, String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appInterface, str, view);
            return;
        }
        try {
            if (!com.tencent.mobileqq.dt.app.a.c().d().c()) {
                QLog.d(TAG, 1, "loginTouchEvent disable ");
                return;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "loginTouchEvent exception:" + th5);
        }
        com.tencent.mobileqq.dt.report.d.h(appInterface, com.tencent.mobileqq.dt.api.c.F, str, view, new e(appInterface, str));
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void mainPageReport(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, obj);
            return;
        }
        try {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103168", false)) {
                return;
            }
            uiReport((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), "TabAndNavBar", str, obj);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "mainPageReport exception:" + th5);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void regReport(AppInterface appInterface, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appInterface, str, obj);
        } else if (!com.tencent.mobileqq.dt.report.d.b()) {
            QLog.d(TAG, 1, "regReport switch close! ");
        } else {
            TuringWrapper.e();
            uiReport(appInterface, com.tencent.mobileqq.dt.api.c.f203639b, str, obj);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void regTouchEvent(AppInterface appInterface, String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, appInterface, str, view);
            return;
        }
        if (!com.tencent.mobileqq.dt.report.d.c()) {
            QLog.d(TAG, 1, "regTouchEvent disable ");
            return;
        }
        com.tencent.mobileqq.dt.report.d.h(appInterface, com.tencent.mobileqq.dt.api.c.f203639b, str, view, new d(appInterface, str));
        if (view instanceof EditText) {
            com.tencent.mobileqq.dt.report.d.g(str, view);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public boolean reportEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if (com.tencent.mobileqq.dt.report.d.b()) {
                return true;
            }
            QLog.d(TAG, 1, "ui report switch close! ");
            return false;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "shiply exception:" + th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void sendRequest(AppInterface appInterface, String str, byte[] bArr, com.tencent.mobileqq.dt.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, str, bArr, aVar);
            return;
        }
        O3BusinessHandler o3BusinessHandler = (O3BusinessHandler) appInterface.getBusinessHandler(O3BusinessHandler.class.getName());
        if (o3BusinessHandler != null && bArr != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                String str2 = new String(Base64.encode(bArr, 0));
                jSONObject.put("cmd", str.replace(".", ""));
                jSONObject.put("data", str2);
                o3BusinessHandler.D2("sendRequestPB", jSONObject.toString(), new a(aVar));
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "json exception:" + e16.getMessage());
                return;
            }
        }
        QLog.e(TAG, 1, "sendRequest but handler is null");
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void setTouchEvent(String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) view);
            return;
        }
        try {
            if (!com.tencent.mobileqq.dt.report.d.c()) {
                QLog.d(TAG, 1, "reg touch switch close! ");
            } else {
                view.setOnTouchListener(new c(str));
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "setTouchEvent exception:" + th5);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void uiEndSensor(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        QLog.d(TAG, 1, "stop sensor! " + str);
        com.tencent.mobileqq.dt.app.b.i().l(str);
    }

    @Override // com.tencent.mobileqq.dt.api.IQSecChannel
    public void uiStartSensor(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        try {
            if (!TextUtils.equals(str, com.tencent.mobileqq.dt.api.c.f203639b)) {
                return;
            }
            if (!reportEnable()) {
                QLog.d(TAG, 1, "ui report switch close! ");
            } else {
                if (appInterface == null && (appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                    return;
                }
                com.tencent.mobileqq.dt.app.b.i().k(str, appInterface);
            }
        } catch (Throwable unused) {
        }
    }
}
