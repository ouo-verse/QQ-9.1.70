package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.vivo.push.PushClientConstants;
import java.security.MessageDigest;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SDKAvatarSettingManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Activity f184084a;

    /* renamed from: b, reason: collision with root package name */
    private String f184085b;

    /* renamed from: c, reason: collision with root package name */
    private String f184086c;

    /* renamed from: d, reason: collision with root package name */
    private String f184087d;

    /* renamed from: e, reason: collision with root package name */
    private String f184088e;

    /* renamed from: f, reason: collision with root package name */
    private String f184089f;

    /* renamed from: g, reason: collision with root package name */
    private String f184090g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f184091h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f184092i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f184093j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f184094k;

    /* renamed from: l, reason: collision with root package name */
    private Handler f184095l;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f184096m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f184097n;

    /* renamed from: o, reason: collision with root package name */
    protected QQProgressDialog f184098o;

    /* renamed from: p, reason: collision with root package name */
    QQCustomDialog f184099p;

    /* renamed from: q, reason: collision with root package name */
    protected QQCustomDialog f184100q;

    /* renamed from: r, reason: collision with root package name */
    protected QQCustomDialog f184101r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 0) {
                SDKAvatarSettingManager.this.l();
                SDKAvatarSettingManager.this.f184084a.moveTaskToBack(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements com.tencent.mobileqq.Doraemon.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f184103a;

        b(String str) {
            this.f184103a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.d("SDKAvatarSettingManager", 2, "check api, onComplete");
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SDKAvatarSettingManager", 2, "check api, onFailure, code=", Integer.valueOf(i3), ", msg=", str);
            }
            if (!SDKAvatarSettingManager.this.f184084a.isFinishing()) {
                SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                if (!sDKAvatarSettingManager.f184092i) {
                    sDKAvatarSettingManager.n();
                    if (SDKAvatarSettingManager.this.f184095l != null) {
                        SDKAvatarSettingManager.this.f184095l.removeCallbacks(SDKAvatarSettingManager.this.f184096m);
                    }
                    SDKAvatarSettingManager.this.u(HardCodeUtil.qqStr(R.string.t5o), this.f184103a);
                }
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SDKAvatarSettingManager", 2, "check api, onPermission, code=", Integer.valueOf(i3));
            }
            if (!SDKAvatarSettingManager.this.f184084a.isFinishing()) {
                SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                if (!sDKAvatarSettingManager.f184092i) {
                    sDKAvatarSettingManager.n();
                    if (SDKAvatarSettingManager.this.f184095l != null) {
                        SDKAvatarSettingManager.this.f184095l.removeCallbacks(SDKAvatarSettingManager.this.f184096m);
                    }
                    SDKAvatarSettingManager.this.u(HardCodeUtil.qqStr(R.string.t5s), this.f184103a);
                }
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
            }
            if (!SDKAvatarSettingManager.this.f184084a.isFinishing()) {
                SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                if (!sDKAvatarSettingManager.f184092i) {
                    if (sDKAvatarSettingManager.f184095l != null) {
                        SDKAvatarSettingManager.this.f184095l.removeCallbacks(SDKAvatarSettingManager.this.f184096m);
                    }
                    SDKAvatarSettingManager.this.k();
                }
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject);
            } else if (QLog.isColorLevel()) {
                QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (!SDKAvatarSettingManager.this.f184084a.isFinishing()) {
                SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                if (!sDKAvatarSettingManager.f184091h) {
                    sDKAvatarSettingManager.n();
                    if (SDKAvatarSettingManager.this.f184095l != null) {
                        SDKAvatarSettingManager.this.f184095l.removeCallbacks(SDKAvatarSettingManager.this.f184097n);
                    }
                    if (i3 == 16) {
                        SDKAvatarSettingManager.this.t();
                    } else {
                        SDKAvatarSettingManager sDKAvatarSettingManager2 = SDKAvatarSettingManager.this;
                        sDKAvatarSettingManager2.s(sDKAvatarSettingManager2.f184085b);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f184106d;

        d(QQAppInterface qQAppInterface) {
            this.f184106d = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this, (Object) qQAppInterface);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    ReportController.o(this.f184106d, "dc00898", "", "", "0X8009B6D", "0X8009B6D", 0, 0, "", "", "", "");
                    SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                    sDKAvatarSettingManager.y(sDKAvatarSettingManager.f184084a, true, Long.valueOf(SDKAvatarSettingManager.this.f184088e).longValue(), true);
                }
            } else {
                ReportController.o(this.f184106d, "dc00898", "", "", "0X8009B6C", "0X8009B6C", 0, 0, "", "", "", "");
                SDKAvatarSettingManager.this.l();
                SDKAvatarSettingManager sDKAvatarSettingManager2 = SDKAvatarSettingManager.this;
                sDKAvatarSettingManager2.y(sDKAvatarSettingManager2.f184084a, true, Long.valueOf(SDKAvatarSettingManager.this.f184088e).longValue(), false);
            }
            SDKAvatarSettingManager.this.f184099p.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4 && keyEvent.getRepeatCount() == 0) {
                SDKAvatarSettingManager.this.f184099p.dismiss();
                SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                sDKAvatarSettingManager.y(sDKAvatarSettingManager.f184084a, true, Long.valueOf(SDKAvatarSettingManager.this.f184088e).longValue(), true);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                sDKAvatarSettingManager.s(sDKAvatarSettingManager.f184085b);
            } else if (i3 == 0) {
                SDKAvatarSettingManager.this.l();
                SDKAvatarSettingManager.this.f184084a.moveTaskToBack(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 0) {
                SDKAvatarSettingManager.this.l();
                SDKAvatarSettingManager.this.f184084a.moveTaskToBack(true);
            }
        }
    }

    public SDKAvatarSettingManager(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f184085b = null;
        this.f184086c = null;
        this.f184087d = null;
        this.f184091h = false;
        this.f184092i = false;
        this.f184093j = false;
        this.f184094k = false;
        this.f184096m = new Runnable() { // from class: com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (SDKAvatarSettingManager.this.f184084a.isFinishing()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w("SDKAvatarSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
                }
                SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                sDKAvatarSettingManager.f184092i = true;
                sDKAvatarSettingManager.k();
            }
        };
        this.f184097n = new Runnable() { // from class: com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SDKAvatarSettingManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (SDKAvatarSettingManager.this.f184084a.isFinishing()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w("SDKAvatarSettingManager", 2, "-->preForward--fetch openid timeout");
                }
                SDKAvatarSettingManager sDKAvatarSettingManager = SDKAvatarSettingManager.this;
                sDKAvatarSettingManager.f184091h = true;
                sDKAvatarSettingManager.n();
                SDKAvatarSettingManager sDKAvatarSettingManager2 = SDKAvatarSettingManager.this;
                sDKAvatarSettingManager2.s(sDKAvatarSettingManager2.f184085b);
            }
        };
        this.f184099p = null;
        this.f184100q = null;
        this.f184101r = null;
        if (QLog.isColorLevel()) {
            QLog.w("SDKAvatarSettingManager", 2, " onCreate ");
        }
        this.f184084a = activity;
        this.f184095l = new Handler();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        String bytes2HexStr;
        String str = this.f184084a.getString(R.string.hih) + this.f184086c;
        try {
            if (!TextUtils.isEmpty(this.f184087d)) {
                try {
                    packageInfo = InstalledAppListMonitor.getPackageInfo(this.f184084a.getPackageManager(), this.f184087d, 64);
                } catch (Exception e16) {
                    QLog.e("SDKAvatarSettingManager", 1, "check, get signature exception=", e16);
                }
                if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(signatureArr[0].toByteArray());
                    bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
                    if (QLog.isColorLevel()) {
                        QLog.d("SDKAvatarSettingManager", 2, "checkApiPermission api, mShareAppId=" + this.f184088e + ", mPkgName=" + this.f184087d + ",signature=" + bytes2HexStr + ",mSdkVerdion=" + this.f184090g);
                    }
                    if (TextUtils.isEmpty(this.f184088e) && !TextUtils.isEmpty(this.f184087d) && !TextUtils.isEmpty(bytes2HexStr)) {
                        ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
                        Bundle bundle = new Bundle();
                        bundle.putString("sdkVersion", this.f184090g);
                        bundle.putString(PushClientConstants.TAG_PKG_NAME, this.f184087d);
                        bundle.putString("signature", bytes2HexStr);
                        v(R.string.hjn);
                        this.f184095l.postDelayed(this.f184096m, 5000L);
                        ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(this.f184084a, 1, this.f184088e, bundle).d("sdk_avatar_edit", null, new b(str));
                        return;
                    }
                    QLog.e("SDKAvatarSettingManager", 1, "check, invalid param, mShareAppId=", this.f184088e, ", pkgName=", this.f184087d, ", signature=", bytes2HexStr);
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f184084a, 230);
                    createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.t5p));
                    createCustomDialog.setNegativeButton(R.string.cancel, new a());
                    createCustomDialog.setCancelable(false);
                    createCustomDialog.show();
                    return;
                }
            } else {
                QLog.e("SDKAvatarSettingManager", 1, "check, pkgName null");
            }
            QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(this.f184084a, 230);
            createCustomDialog2.setMessage(HardCodeUtil.qqStr(R.string.t5p));
            createCustomDialog2.setNegativeButton(R.string.cancel, new a());
            createCustomDialog2.setCancelable(false);
            createCustomDialog2.show();
            return;
        } catch (Exception e17) {
            QLog.e("SDKAvatarSettingManager", 1, "show invalid param dialog, exception=", e17);
            return;
        }
        bytes2HexStr = null;
        if (QLog.isColorLevel()) {
        }
        if (TextUtils.isEmpty(this.f184088e)) {
        }
        QLog.e("SDKAvatarSettingManager", 1, "check, invalid param, mShareAppId=", this.f184088e, ", pkgName=", this.f184087d, ", signature=", bytes2HexStr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (QLog.isColorLevel()) {
            QLog.w("SDKAvatarSettingManager", 2, " checkJumpAction mShareAppId = " + this.f184088e + "\uff0c mShareOpenId =" + this.f184089f);
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            y(this.f184084a, false, Long.valueOf(this.f184088e).longValue(), false);
            l();
            this.f184084a.moveTaskToBack(true);
            return;
        }
        if (!TextUtils.isEmpty(this.f184088e) && !TextUtils.isEmpty(this.f184089f)) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            OpenID b36 = qQAppInterface.getMsgHandler().b3(this.f184088e);
            if (b36 == null) {
                v(R.string.hjn);
                this.f184095l.postDelayed(this.f184097n, 8000L);
                try {
                    qQAppInterface.getMsgHandler().O2(Long.parseLong(qQAppInterface.getCurrentAccountUin()), this.f184089f, Long.valueOf(this.f184088e).longValue(), new c());
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (!this.f184089f.equals(b36.openID)) {
                if (QLog.isColorLevel()) {
                    QLog.w("SDKAvatarSettingManager", 2, "-->preForward--openid doesn't equal current local openid");
                }
                t();
                return;
            } else {
                n();
                s(this.f184085b);
                return;
            }
        }
        n();
        s(this.f184085b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        if (QLog.isColorLevel()) {
            QLog.w("SDKAvatarSettingManager", 2, "-->openPhotoEdit--path = " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            int x16 = ProfileCardUtil.x(this.f184084a);
            Intent intent = new Intent();
            intent.setFlags(603979776);
            intent.putExtra("Business_Origin", 100);
            intent.putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
            PhotoUtils.startPhotoEditForResult(intent, this.f184084a, ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass().getName(), x16, x16, 1080, 1080, str, FaceUtil.getUploadAvatarTempPath(), 1035);
            this.f184094k = true;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SDKAvatarSettingManager", 2, "set from sdk path null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Activity activity, boolean z16, long j3, boolean z17) {
        if (activity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SDKAvatarSettingManager", 2, "sdk_share:sdk callback=" + z16 + " appid=" + j3);
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        if (z17) {
            intent.putExtra("stay_back_stack", true);
        }
        if (z16) {
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(j3), "sdkSetAvatar")));
        } else {
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", Long.valueOf(j3), "sdkSetAvatar")));
        }
        if (activity.getIntent() != null) {
            intent.setPackage(this.f184087d);
        }
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SDKAvatarSettingManager", 2, e16.getMessage());
            }
        }
    }

    protected void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f184084a.setResult(-1, new Intent());
        this.f184084a.finish();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("SDKAvatarSettingManager", 2, " gotoConversation isSuccess = " + this.f184093j);
        }
        if (this.f184093j) {
            Intent intent = new Intent();
            intent.setComponent(SplashActivity.getAliasComponent(this.f184084a));
            intent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
            intent.setFlags(67108864);
            intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            this.f184084a.startActivity(intent);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f184098o;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f184098o.dismiss();
        }
    }

    public void o(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        if (intent == null) {
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra(IProfileCardConst.KEY_PROFILE_EXTRA);
        if (bundleExtra != null) {
            this.f184085b = bundleExtra.getString("key_from_sdk_set_avatar_path", null);
            this.f184086c = bundleExtra.getString("key_from_sdk_set_avatar_appname", null);
            this.f184088e = bundleExtra.getString("key_from_sdk_set_avatar_share_id", null);
            this.f184089f = bundleExtra.getString("key_from_sdk_set_avatar_open_id", null);
            this.f184087d = bundleExtra.getString("pkg_name", null);
            this.f184090g = bundleExtra.getString("sdk_version");
        }
        if (QLog.isColorLevel()) {
            QLog.w("SDKAvatarSettingManager", 2, " initParam ");
        }
    }

    public void p(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("SDKAvatarSettingManager", 2, " onActivityResult resultCode = " + i3);
        }
        if (i3 == -1) {
            if (intent.getBooleanExtra(IProfileCardConst.KEY_FROM_SET_AVATAR_RESULT, false)) {
                this.f184093j = true;
                w(this.f184086c);
            } else {
                this.f184093j = false;
                y(this.f184084a, false, Long.valueOf(this.f184088e).longValue(), false);
                l();
                this.f184084a.moveTaskToBack(true);
            }
        } else if (i3 == 0) {
            this.f184084a.setResult(0, new Intent());
            this.f184084a.finish();
            this.f184084a.moveTaskToBack(true);
        } else {
            this.f184084a.finish();
        }
        this.f184094k = false;
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f184099p;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.f184093j = false;
        this.f184094k = false;
    }

    public void r(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (!this.f184094k) {
            q();
            o(intent);
            x();
        } else {
            y(this.f184084a, false, Long.valueOf(this.f184088e).longValue(), false);
            l();
            this.f184084a.moveTaskToBack(true);
        }
    }

    protected void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f184100q;
        if (qQCustomDialog != null) {
            if (!qQCustomDialog.isShowing()) {
                this.f184100q.show();
                return;
            }
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f184084a, 230);
        this.f184100q = createCustomDialog;
        createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.t5q));
        this.f184100q.setTitle(R.string.b1v);
        f fVar = new f();
        this.f184100q.setNegativeButton(R.string.cancel, fVar);
        this.f184100q.setPositiveButton(R.string.hin, fVar);
        this.f184100q.show();
    }

    protected void u(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f184101r;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f184084a, 230);
        this.f184100q = createCustomDialog;
        createCustomDialog.setMessage(str);
        this.f184100q.setNegativeButton(str2, new g());
        this.f184100q.show();
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (this.f184098o == null) {
            Activity activity = this.f184084a;
            this.f184098o = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        this.f184098o.setMessage(i3);
        if (!this.f184084a.isFinishing()) {
            this.f184098o.show();
        }
    }

    void w(String str) {
        if (this.f184084a.isFinishing()) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.f184099p;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
            this.f184099p.show();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f184084a, 230);
        this.f184099p = createCustomDialog;
        createCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.t5r));
        String string = this.f184084a.getString(R.string.hih);
        String string2 = this.f184084a.getString(R.string.hii);
        if (str != null) {
            string = string + str;
        }
        d dVar = new d((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        this.f184099p.setPositiveButton(string2, dVar);
        this.f184099p.setNegativeButton(string, dVar);
        this.f184099p.setOnKeyListener(new e());
        this.f184099p.show();
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            j();
        }
    }
}
