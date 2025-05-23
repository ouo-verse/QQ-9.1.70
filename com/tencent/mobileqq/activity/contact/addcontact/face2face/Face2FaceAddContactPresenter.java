package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.guild.album.GuildFeedPreviewCustomization;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import tencent.im.nearfield_friend.nearfield_friend$GPS;

/* loaded from: classes10.dex */
public class Face2FaceAddContactPresenter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.contact.addcontact.face2face.e f181031a;

    /* renamed from: b, reason: collision with root package name */
    private Face2FaceAddContactHandler f181032b;

    /* renamed from: c, reason: collision with root package name */
    private QQAppInterface f181033c;

    /* renamed from: d, reason: collision with root package name */
    private String f181034d;

    /* renamed from: e, reason: collision with root package name */
    private nearfield_friend$GPS f181035e;

    /* renamed from: f, reason: collision with root package name */
    private int f181036f;

    /* renamed from: g, reason: collision with root package name */
    private int f181037g;

    /* renamed from: h, reason: collision with root package name */
    private Timer f181038h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.activity.contact.addcontact.face2face.b f181039i;

    /* renamed from: j, reason: collision with root package name */
    private ar f181040j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseActivity f181044d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f181045e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f181046f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f181047h;

        a(BaseActivity baseActivity, boolean z16, String str, String str2) {
            this.f181044d = baseActivity;
            this.f181045e = z16;
            this.f181046f = str;
            this.f181047h = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Face2FaceAddContactPresenter.this, baseActivity, Boolean.valueOf(z16), str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Face2FaceAddContactPresenter.this.m(this.f181044d, this.f181045e, this.f181046f, this.f181047h);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactPresenter.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                Face2FaceAddContactPresenter.this.f181031a.Ge();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f181050a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f181051b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f181052c;

        c(boolean z16, String str, String str2) {
            this.f181050a = z16;
            this.f181051b = str;
            this.f181052c = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Face2FaceAddContactPresenter.this, Boolean.valueOf(z16), str, str2);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            if (this.f181050a) {
                Face2FaceAddContactPresenter.this.p(this.f181051b, this.f181052c);
            }
        }
    }

    /* loaded from: classes10.dex */
    class d extends com.tencent.mobileqq.activity.contact.addcontact.face2face.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactPresenter.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.b
        public void e(boolean z16, String str, int i3, String str2, int i16, String str3, int i17, int i18, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), str3, Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("Face2FaceAddContactPresenter", 2, "onEnterFace2FaceAddContact isSuccess:" + z16 + " mSessionId:" + Face2FaceAddContactPresenter.this.f181034d + " sessionId:" + str + " errorCode:" + i3 + " errorMsg:" + str2 + " securityLevel:" + i16 + " verifyUrl:" + str3 + " heartbeatTime:" + i17 + " expireTime:" + i18 + " isEnterAfterVerify:" + z17);
            }
            Face2FaceAddContactPresenter.this.s(z16, str, i3, str2, i16, str3, i17, i18, z17);
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.b
        public void f(boolean z16, String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceAddContactPresenter", 2, "onExitFace2FaceAddContact isSuccess:" + z16 + " mSessionId:" + Face2FaceAddContactPresenter.this.f181034d + " sessionId:" + str + " errorCode:" + i3 + " errorMsg:" + str2);
            }
            Face2FaceAddContactPresenter.this.z();
            if (Face2FaceAddContactPresenter.this.f181031a != null) {
                Face2FaceAddContactPresenter.this.f181031a.a9();
            }
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.b
        public void g(boolean z16, String str, int i3, String str2, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactHeartBeat isSuccess:" + z16 + " mSessionId:" + Face2FaceAddContactPresenter.this.f181034d + " sessionId:" + str + " errorCode:" + i3 + " errorMsg:" + str2 + " missingList:" + list);
            }
            Face2FaceAddContactPresenter.this.t(z16, str, i3, str2, list);
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.face2face.b
        public void h(String str, String str2, List<com.tencent.mobileqq.activity.contact.addcontact.face2face.d> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, str2, list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactPush mSessionId:" + Face2FaceAddContactPresenter.this.f181034d + " sessionId:" + str2 + " faceFriends:" + list + " currentUin:" + str);
            }
            if (TextUtils.equals(str2, Face2FaceAddContactPresenter.this.f181034d) && Face2FaceAddContactPresenter.this.f181033c != null && TextUtils.equals(str, Face2FaceAddContactPresenter.this.f181033c.getCurrentAccountUin()) && list != null && list.size() > 0) {
                Face2FaceAddContactPresenter.this.z();
                if (Face2FaceAddContactPresenter.this.f181031a != null) {
                    Face2FaceAddContactPresenter.this.f181031a.F3(str, list);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    class e extends ar {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactPresenter.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else if (z16 && Face2FaceAddContactPresenter.this.f181031a != null) {
                Face2FaceAddContactPresenter.this.f181031a.deleteFriend(String.valueOf(obj));
            }
        }
    }

    public Face2FaceAddContactPresenter(Face2FaceAddContactFragment face2FaceAddContactFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) face2FaceAddContactFragment);
            return;
        }
        this.f181036f = 60000;
        this.f181037g = GuildFeedPreviewCustomization.DEFAULT_CHOOSE_VIDEO_DURATION;
        this.f181039i = new d();
        this.f181040j = new e();
        this.f181031a = face2FaceAddContactFragment;
        QQAppInterface qQAppInterface = face2FaceAddContactFragment.getBaseActivity().app;
        this.f181033c = qQAppInterface;
        qQAppInterface.addObserver(this.f181039i);
        this.f181033c.addObserver(this.f181040j);
        this.f181032b = (Face2FaceAddContactHandler) this.f181033c.getBusinessHandler(BusinessHandlerFactory.FACE2FACE_ADD_FRIEND_HANDLER);
    }

    private void j(BaseActivity baseActivity, boolean z16, String str, String str2) {
        if (!q(baseActivity)) {
            QQCustomDialog.showPermissionRequestDialog(baseActivity, HardCodeUtil.qqStr(R.string.zxf), HardCodeUtil.qqStr(R.string.zxc), HardCodeUtil.qqStr(R.string.zxe), HardCodeUtil.qqStr(R.string.zxd), new a(baseActivity, z16, str, str2), new b());
        } else if (z16) {
            p(str, str2);
        }
    }

    private void l(BaseActivity baseActivity, boolean z16, String str, String str2) {
        j(baseActivity, z16, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(BaseActivity baseActivity, boolean z16, String str, String str2) {
        QQPermissionFactory.getQQPermission(baseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_FACE_2_FACE_ADD_CONTACT_LOCATION, QQPermissionConstants.Business.SCENE.FACE_2_FACE_ADD_CONTACT)).requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new c(z16, str, str2));
    }

    private nearfield_friend$GPS n(SosoLbsInfo sosoLbsInfo) {
        if (sosoLbsInfo != null) {
            StringBuffer stringBuffer = new StringBuffer();
            nearfield_friend$GPS nearfield_friend_gps = new nearfield_friend$GPS();
            nearfield_friend_gps.lat.set((int) (sosoLbsInfo.mLocation.mLat02 * 1000000.0d));
            nearfield_friend_gps.lng.set((int) (sosoLbsInfo.mLocation.mLon02 * 1000000.0d));
            nearfield_friend_gps.type.set(1);
            stringBuffer.append("generateGPSInfo GPS: ");
            stringBuffer.append(sosoLbsInfo.mLocation.mLat02 * 1000000.0d);
            stringBuffer.append(",");
            stringBuffer.append(sosoLbsInfo.mLocation.mLon02 * 1000000.0d);
            this.f181035e = nearfield_friend_gps;
            if (QLog.isColorLevel()) {
                QLog.i("Face2FaceAddContactPresenter", 2, stringBuffer.toString());
            }
        }
        return this.f181035e;
    }

    private String o() {
        if (this.f181033c != null) {
            return this.f181033c.getCurrentAccountUin() + "_" + System.currentTimeMillis() + "_" + (((int) Math.floor(Math.random() * 100000.0d)) % 100000);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2) {
        ThreadManagerV2.post(new Runnable(str, str2) { // from class: com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f181041d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f181042e;

            /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter$5$a */
            /* loaded from: classes10.dex */
            class a extends SosoInterfaceOnLocationListener {
                static IPatchRedirector $redirector_;

                a(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
                    super(i3, z16, z17, j3, z18, z19, str);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AnonymousClass5.this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), str);
                    }
                }

                @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
                public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Face2FaceAddContactPresenter", 2, "onLocationFinish errCode = " + i3 + " info = " + sosoLbsInfo);
                    }
                    if (i3 == 0 && sosoLbsInfo != null) {
                        if (!TextUtils.isEmpty(AnonymousClass5.this.f181041d) && AnonymousClass5.this.f181041d.length() == 4) {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            Face2FaceAddContactPresenter.this.u(sosoLbsInfo, anonymousClass5.f181041d, anonymousClass5.f181042e);
                            return;
                        }
                        return;
                    }
                    if (Face2FaceAddContactPresenter.this.f181031a != null) {
                        Face2FaceAddContactPresenter.this.f181031a.rc();
                    }
                }
            }

            {
                this.f181041d = str;
                this.f181042e = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Face2FaceAddContactPresenter.this, str, str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new a(0, true, false, 60000L, false, false, "Face2FaceAddContactPresenter"));
                }
            }
        }, 8, null, false);
    }

    private boolean q(BaseActivity baseActivity) {
        if (baseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z16, String str, int i3, String str2, int i16, String str3, int i17, int i18, boolean z17) {
        if (z16 && TextUtils.equals(this.f181034d, str) && this.f181033c != null) {
            if (i16 == 2) {
                com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar = this.f181031a;
                if (eVar != null) {
                    eVar.ea();
                    return;
                }
                return;
            }
            if (i16 == 3) {
                com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar2 = this.f181031a;
                if (eVar2 != null) {
                    eVar2.Cd(str3);
                    return;
                }
                return;
            }
            if (i3 != 0) {
                switch (i3) {
                    case 10004:
                        com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar3 = this.f181031a;
                        if (eVar3 != null) {
                            eVar3.Yg();
                            return;
                        }
                        return;
                    case 10005:
                        com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar4 = this.f181031a;
                        if (eVar4 != null) {
                            eVar4.je();
                            return;
                        }
                        return;
                    case 10006:
                        com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar5 = this.f181031a;
                        if (eVar5 != null) {
                            eVar5.A5();
                            return;
                        }
                        return;
                    case 10007:
                        com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar6 = this.f181031a;
                        if (eVar6 != null) {
                            eVar6.w5();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.f181036f = Math.max(i17 * 1000, 10000);
            int max = Math.max(i18 * 1000, 10000);
            this.f181037g = max;
            com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar7 = this.f181031a;
            if (eVar7 != null) {
                eVar7.G5(max);
                this.f181031a.ig(this.f181036f);
            }
            y();
            return;
        }
        com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar8 = this.f181031a;
        if (eVar8 != null) {
            eVar8.Yg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z16, String str, int i3, String str2, List<String> list) {
        com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar;
        if (z16 && TextUtils.equals(str, this.f181034d)) {
            if (i3 != 0) {
                if (i3 != 10005) {
                    if (i3 == 10006 && (eVar = this.f181031a) != null) {
                        eVar.A5();
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.activity.contact.addcontact.face2face.e eVar2 = this.f181031a;
                if (eVar2 != null) {
                    eVar2.je();
                    return;
                }
                return;
            }
            if (this.f181031a != null) {
                if (list != null && list.size() > 0) {
                    this.f181031a.E5(list);
                }
                this.f181031a.ig(this.f181036f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(SosoLbsInfo sosoLbsInfo, String str, String str2) {
        byte[] bArr;
        this.f181034d = o();
        nearfield_friend$GPS n3 = n(sosoLbsInfo);
        if (!TextUtils.isEmpty(str2)) {
            bArr = str2.getBytes();
        } else {
            bArr = null;
        }
        this.f181032b.E2(this.f181034d, str, n3, bArr);
    }

    private void y() {
        z();
        BaseTimer baseTimer = new BaseTimer();
        this.f181038h = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddContactPresenter.this);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (Face2FaceAddContactPresenter.this.f181031a != null) {
                    Face2FaceAddContactPresenter.this.f181031a.onTimeout();
                }
            }
        }, MiniBoxNoticeInfo.MIN_5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Timer timer = this.f181038h;
        if (timer != null) {
            timer.cancel();
            this.f181038h = null;
        }
    }

    public void k(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseActivity);
        } else {
            l(baseActivity, false, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        if (!TextUtils.isEmpty(this.f181034d)) {
            w();
        }
        z();
        this.f181031a = null;
        QQAppInterface qQAppInterface = this.f181033c;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f181039i);
            this.f181033c.removeObserver(this.f181040j);
        }
    }

    public void v(BaseActivity baseActivity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, baseActivity, str, str2);
        } else {
            l(baseActivity, true, str, str2);
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactPresenter", 2, "sendExitFace2FaceAddContactReq mSessionId:" + this.f181034d);
        }
        if (!TextUtils.isEmpty(this.f181034d)) {
            this.f181032b.F2(this.f181034d);
            this.f181034d = null;
        }
    }

    public void x(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactPresenter", 2, "sendFace2FaceAddContactHeartBeatReq mSessionId:" + this.f181034d + " faceFriends:" + list);
        }
        if (!TextUtils.isEmpty(this.f181034d)) {
            this.f181032b.G2(this.f181034d, list);
        }
    }
}
