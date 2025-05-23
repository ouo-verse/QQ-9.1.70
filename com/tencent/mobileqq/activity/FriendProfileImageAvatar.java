package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.cf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes9.dex */
public class FriendProfileImageAvatar extends cf implements HttpDownloadUtil.b, Handler.Callback {
    static IPatchRedirector $redirector_;
    MqqHandler C;
    boolean D;
    String E;
    int F;
    boolean G;
    boolean H;
    private boolean I;
    private com.tencent.mobileqq.avatar.observer.a J;
    private GPServiceObserver K;

    /* renamed from: m, reason: collision with root package name */
    URL f175951m;

    /* loaded from: classes9.dex */
    class b extends GPServiceObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageAvatar.this);
            }
        }
    }

    public FriendProfileImageAvatar(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = new a();
        this.K = new b();
        this.f175951m = null;
        this.D = false;
        this.C = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
    }

    static /* bridge */ /* synthetic */ boolean q() {
        return u();
    }

    private static boolean u() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("Q.profilecard.Avatar", 1, "enableUseSettingUrl appRuntime is null");
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(FaceConstant.TOGGLE_QQ_AVATAR_ENABLE_SETTING_HD_URL, true);
        QLog.e("Q.profilecard.Avatar", 1, "enableUseSettingUrl: " + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Setting v(EntityManager entityManager, String str) {
        try {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("proavatar_profilecard_find_setting_fix", true)) {
                Setting avatarInfoSetting = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getAvatarInfoSetting(1, str);
                if (avatarInfoSetting != null) {
                    return avatarInfoSetting;
                }
            } else {
                QLog.e("Q.profilecard.Avatar", 1, "findSetting switch: false");
            }
            return (Setting) DBMethodProxy.find(entityManager, (Class<? extends Entity>) Setting.class, str);
        } catch (Exception e16) {
            QLog.e("Q.profilecard.Avatar", 1, "findSetting exception", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        if (this.I) {
            y(str);
        } else if (u()) {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.activity.FriendProfileImageAvatar.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f175953d;

                {
                    this.f175953d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageAvatar.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    EntityManager createEntityManager = FriendProfileImageAvatar.this.f180638i.getEntityManagerFactory().createEntityManager();
                    boolean z16 = false;
                    if (createEntityManager != null) {
                        try {
                            try {
                                Setting v3 = FriendProfileImageAvatar.v(createEntityManager, this.f175953d);
                                if (v3 != null && !TextUtils.isEmpty(v3.url)) {
                                    z16 = true;
                                } else {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("getFaceUrl setting error: ");
                                    if (v3 == null) {
                                        str2 = "null";
                                    } else {
                                        str2 = v3.url;
                                    }
                                    sb5.append(str2);
                                    QLog.i("Q.profilecard.Avatar", 1, sb5.toString());
                                }
                            } catch (Exception e16) {
                                QLog.e("Q.profilecard.Avatar", 1, "getFaceUrl exception", e16);
                            }
                        } finally {
                            createEntityManager.close();
                        }
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(z16) { // from class: com.tencent.mobileqq.activity.FriendProfileImageAvatar.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f175954d;

                        {
                            this.f175954d = z16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass2.this, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            QLog.i("Q.profilecard.Avatar", 1, "getFaceUrl result: " + this.f175954d);
                            FriendProfileImageAvatar friendProfileImageAvatar = FriendProfileImageAvatar.this;
                            friendProfileImageAvatar.z(friendProfileImageAvatar.f180637h);
                            if (this.f175954d) {
                                FriendProfileImageAvatar friendProfileImageAvatar2 = FriendProfileImageAvatar.this;
                                friendProfileImageAvatar2.x(friendProfileImageAvatar2.f180637h, false);
                                FriendProfileImageAvatar friendProfileImageAvatar3 = FriendProfileImageAvatar.this;
                                friendProfileImageAvatar3.o(friendProfileImageAvatar3.f180637h);
                                return;
                            }
                            FriendProfileImageAvatar friendProfileImageAvatar4 = FriendProfileImageAvatar.this;
                            cf.b bVar = friendProfileImageAvatar4.f180637h;
                            bVar.f180642d = 2;
                            friendProfileImageAvatar4.o(bVar);
                        }
                    });
                }
            }, 32, null, false);
        } else {
            this.f180638i.refreshFace(str);
        }
    }

    private void y(String str) {
        if (!this.f180634d.equals(str)) {
            return;
        }
        String fullGuildUserUserAvatarUrl = ((IGPSService) this.f180638i.getRuntimeService(IGPSService.class, "")).getFullGuildUserUserAvatarUrl("0", str, 2);
        if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Avatar", 2, "onGetHeadInfo: tinyId=", str, ",uin:", str);
        }
        if (this.D && !TextUtils.isEmpty(fullGuildUserUserAvatarUrl)) {
            t(str, RegisterType.UNINIT_REF, fullGuildUserUserAvatarUrl);
        }
    }

    @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.Avatar", 2, "onHttpStart() url = " + str);
        }
        URL url = this.f175951m;
        if (url != null && url.toString().equals(str)) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = i3;
            MqqHandler mqqHandler = this.C;
            if (mqqHandler != null) {
                mqqHandler.sendMessage(obtain);
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
    public void b(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        URL url = this.f175951m;
        if (url != null && url.toString().equals(str)) {
            MqqHandler mqqHandler = this.C;
            if (mqqHandler != null && mqqHandler.hasMessages(1)) {
                this.C.removeMessages(1);
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = (int) ((((float) j16) / ((float) j3)) * 100.0f);
            MqqHandler mqqHandler2 = this.C;
            if (mqqHandler2 != null) {
                mqqHandler2.sendMessage(obtain);
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
    public void c(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.cf
    public void d(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseActivity);
            return;
        }
        if (this.I) {
            ((IGPSService) this.f180638i.getRuntimeService(IGPSService.class, "")).addObserver(this.K);
        } else {
            baseActivity.removeObserver(this.J);
        }
        MqqHandler mqqHandler = this.C;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
        this.C = null;
    }

    @Override // com.tencent.mobileqq.activity.cf
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.activity.cf
    public cf.b h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (cf.b) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return this.f180637h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                Setting setting = null;
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            if (QLog.isColorLevel()) {
                                QLog.i("Q.profilecard.Avatar", 2, "MSG_DOWNLOAD_HD_AVATAR " + message.obj);
                            }
                            Object obj = message.obj;
                            if (obj instanceof Setting) {
                                setting = (Setting) obj;
                            }
                            if (setting != null && !setting.url.equals(this.E)) {
                                String str = setting.url;
                                this.E = str;
                                t(setting.uin, setting.bFaceFlags, str);
                            } else if (QLog.isColorLevel()) {
                                QLog.i("Q.profilecard.Avatar", 2, "MSG_DOWNLOAD_HD_AVATAR | has download path = " + this.E);
                            }
                        }
                    } else {
                        s(this.f180634d);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.profilecard.Avatar", 2, "end result : " + message.arg1);
                    }
                    cf.b bVar = this.f180637h;
                    bVar.f180643e = 100;
                    bVar.f180644f = false;
                    z(bVar);
                    if (message.arg1 == 1) {
                        o(this.f180637h);
                    } else {
                        cf.b bVar2 = this.f180637h;
                        bVar2.f180642d = 5;
                        o(bVar2);
                        int i16 = this.F;
                        if (i16 < 3) {
                            this.F = i16 + 1;
                            this.E = null;
                        }
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.profilecard.Avatar", 2, "start progress : " + message.arg1);
                }
                cf.b bVar3 = this.f180637h;
                bVar3.f180643e = 0;
                o(bVar3);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.Avatar", 2, "refresh progress : " + message.arg1);
            }
            cf.b bVar4 = this.f180637h;
            bVar4.f180643e = message.arg1;
            o(bVar4);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.cf
    public Drawable i() {
        cf.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.f180638i != null && (bVar = this.f180637h) != null && !TextUtils.isEmpty(bVar.f180645g)) {
            return FaceDrawable.getFaceDrawable(this.f180638i, 1, this.f180637h.f180645g);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.cf
    public void j(cf.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.f180637h = bVar;
        }
    }

    @Override // com.tencent.mobileqq.activity.cf
    public void k(BaseActivity baseActivity, cf.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseActivity, (Object) bVar);
            return;
        }
        bVar.f180639a = null;
        bVar.f180640b = this.f180638i.getCustomFaceFilePath(false, this.f180634d);
        bVar.f180641c = FaceUtil.getFHDAvatarPath(this.f180634d);
        z(bVar);
        this.f180637h = bVar;
    }

    @Override // com.tencent.mobileqq.activity.cf
    public void l(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseActivity);
        } else if (this.I) {
            ((IGPSService) this.f180638i.getRuntimeService(IGPSService.class, "")).addObserver(this.K);
        } else {
            baseActivity.addObserver(this.J);
        }
    }

    @Override // com.tencent.mobileqq.activity.cf
    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            i3 = 0;
        }
        this.f180636f = i3;
        cf.b h16 = h(i3);
        this.f180637h = h16;
        if (h16 != null) {
            x(h16, true);
            o(this.f180637h);
        }
    }

    void s(String str) {
        if (QLog.isColorLevel()) {
            com.tencent.mobileqq.nearby.l.c("Q.profilecard.Avatar", "downloadHDAvatar", str);
        }
        if (this.H) {
            if (QLog.isDevelopLevel()) {
                com.tencent.mobileqq.nearby.l.c("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 1", new Object[0]);
                return;
            }
            return;
        }
        ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.activity.FriendProfileImageAvatar.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f175956d;

            {
                this.f175956d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageAvatar.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (com.tencent.mobileqq.filemanager.util.q.p(FaceUtil.getFHDAvatarPath(String.valueOf(this.f175956d)))) {
                    if (QLog.isDevelopLevel()) {
                        com.tencent.mobileqq.nearby.l.c("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 1", new Object[0]);
                        return;
                    }
                    return;
                }
                FriendProfileImageAvatar friendProfileImageAvatar = FriendProfileImageAvatar.this;
                if (friendProfileImageAvatar.H) {
                    if (QLog.isDevelopLevel()) {
                        com.tencent.mobileqq.nearby.l.c("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 2", new Object[0]);
                        return;
                    }
                    return;
                }
                friendProfileImageAvatar.H = true;
                Setting v3 = FriendProfileImageAvatar.v(friendProfileImageAvatar.f180638i.getEntityManagerFactory().createEntityManager(), this.f175956d);
                if (v3 != null && !TextUtils.isEmpty(v3.url)) {
                    Message obtain = Message.obtain();
                    obtain.what = 5;
                    obtain.obj = v3;
                    MqqHandler mqqHandler = FriendProfileImageAvatar.this.C;
                    if (mqqHandler != null) {
                        mqqHandler.sendMessage(obtain);
                    }
                } else {
                    FriendProfileImageAvatar friendProfileImageAvatar2 = FriendProfileImageAvatar.this;
                    friendProfileImageAvatar2.D = true;
                    friendProfileImageAvatar2.w(this.f175956d);
                }
                FriendProfileImageAvatar.this.H = false;
                if (QLog.isDevelopLevel()) {
                    com.tencent.mobileqq.nearby.l.c("Q.profilecard.Avatar", "downloadHDAvatar end of makingHDUrl", new Object[0]);
                }
            }
        }, 5, null, true);
    }

    void t(String str, byte b16, String str2) {
        this.D = false;
        cf.b bVar = this.f180637h;
        bVar.f180644f = true;
        o(bVar);
        if (this.G) {
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.profilecard.Avatar", 1, "downloadHDAvatar is downloading and return 1");
                return;
            }
            return;
        }
        ThreadManagerV2.post(new Runnable(str, b16, str2) { // from class: com.tencent.mobileqq.activity.FriendProfileImageAvatar.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f175957d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ byte f175958e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f175959f;

            {
                this.f175957d = str;
                this.f175958e = b16;
                this.f175959f = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, FriendProfileImageAvatar.this, str, Byte.valueOf(b16), str2);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2 */
            /* JADX WARN: Type inference failed for: r5v3, types: [int] */
            /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
            /* JADX WARN: Type inference failed for: r5v5 */
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String fHDAvatarPath = FaceUtil.getFHDAvatarPath(String.valueOf(this.f175957d));
                if (com.tencent.mobileqq.filemanager.util.q.p(fHDAvatarPath)) {
                    if (QLog.isDevelopLevel()) {
                        com.tencent.mobileqq.nearby.l.c("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 2", new Object[0]);
                        return;
                    }
                    return;
                }
                FriendProfileImageAvatar friendProfileImageAvatar = FriendProfileImageAvatar.this;
                if (friendProfileImageAvatar.G) {
                    if (QLog.isDevelopLevel()) {
                        com.tencent.mobileqq.nearby.l.c("Q.profilecard.Avatar", "downloadHDAvatar is downloading and return 2", new Object[0]);
                        return;
                    }
                    return;
                }
                ?? r56 = 1;
                friendProfileImageAvatar.G = true;
                byte b17 = this.f175958e;
                if ((b17 & 32) != 0) {
                    i3 = 0;
                } else if ((b17 & RegisterType.UNINIT_REF) != 0) {
                    i3 = 640;
                } else if ((b17 & 8) != 0) {
                    i3 = 140;
                } else if ((b17 & 4) != 0) {
                    i3 = 100;
                } else {
                    i3 = 40;
                }
                String str3 = this.f175959f + i3;
                try {
                    FriendProfileImageAvatar.this.f175951m = new URL(str3);
                } catch (MalformedURLException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.profilecard.Avatar", 2, e16.toString());
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Q.profilecard.Avatar", 2, "downloadHDAvatar()  uin=" + this.f175957d + ", mgSize=" + i3 + ", url = " + str3);
                }
                File file = new File(fHDAvatarPath);
                File file2 = new File(file.getPath() + Long.toString(System.currentTimeMillis()));
                if (HttpDownloadUtil.downloadData(FriendProfileImageAvatar.this.f180638i, new DownloadInfo(MsfSdkUtils.insertMtype("friendlist", str3), file2, 0), FriendProfileImageAvatar.this) != 0) {
                    r56 = 0;
                }
                if (r56 != 0) {
                    r56 = file2.renameTo(file);
                }
                if (FriendProfileImageAvatar.this.C != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 3;
                    obtain.arg1 = r56;
                    FriendProfileImageAvatar.this.C.sendMessage(obtain);
                }
                FriendProfileImageAvatar.this.G = false;
                if (QLog.isDevelopLevel()) {
                    com.tencent.mobileqq.nearby.l.c("Q.profilecard.Avatar", "downloadHDAvatar end of downloading", new Object[0]);
                }
            }
        }, 5, null, true);
    }

    void x(cf.b bVar, boolean z16) {
        int i3 = bVar.f180642d;
        if (z16 && !this.D && (i3 == 0 || i3 == 3)) {
            this.D = true;
            ThreadManagerV2.postImmediately(new Runnable(bVar) { // from class: com.tencent.mobileqq.activity.FriendProfileImageAvatar.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ cf.b f175952d;

                {
                    this.f175952d = bVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageAvatar.this, (Object) bVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    EntityManager createEntityManager;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!FriendProfileImageAvatar.q() && (createEntityManager = FriendProfileImageAvatar.this.f180638i.getEntityManagerFactory().createEntityManager()) != null) {
                        try {
                            Setting v3 = FriendProfileImageAvatar.v(createEntityManager, this.f175952d.f180645g);
                            if (v3 != null && (v3.headImgTimestamp != 0 || v3.updateTimestamp != 0)) {
                                v3.headImgTimestamp = 0L;
                                v3.updateTimestamp = 0L;
                                createEntityManager.update(v3);
                                FriendProfileImageAvatar.this.f180638i.updateSettingTableCache(v3);
                            }
                        } catch (Exception unused) {
                        } catch (Throwable th5) {
                            createEntityManager.close();
                            throw th5;
                        }
                        createEntityManager.close();
                    }
                    FriendProfileImageAvatar friendProfileImageAvatar = FriendProfileImageAvatar.this;
                    friendProfileImageAvatar.w(friendProfileImageAvatar.f180634d);
                }
            }, null, false);
        }
        int i16 = bVar.f180642d;
        if (i16 == 0) {
            bVar.f180642d = 1;
        } else if (!z16 && i16 == 3) {
            bVar.f180642d = 4;
            MqqHandler mqqHandler = this.C;
            if (mqqHandler != null) {
                mqqHandler.sendEmptyMessageDelayed(4, 400L);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.Avatar", 2, "load: uin=" + bVar.f180645g + ",state=" + bVar.f180642d + ", bState=" + i3 + ", bGetHeadInfo=" + this.D + ", isFromClickEvent=" + z16);
        }
    }

    synchronized void z(cf.b bVar) {
        int i3 = bVar.f180642d;
        if (com.tencent.mobileqq.filemanager.util.q.p(bVar.f180641c)) {
            bVar.f180642d = 6;
            bVar.f180644f = false;
            MqqHandler mqqHandler = this.C;
            if (mqqHandler != null) {
                mqqHandler.removeMessages(4);
            }
        } else if (com.tencent.mobileqq.filemanager.util.q.p(bVar.f180640b)) {
            bVar.f180642d = 3;
        } else {
            bVar.f180642d = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Avatar", 2, "updateState: uin=" + bVar.f180645g + ",state=" + bVar.f180642d + ", beforeState=" + i3);
        }
    }

    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageAvatar.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onGetHeadInfo(boolean z16, Setting setting) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), setting);
                return;
            }
            if (setting != null && FriendProfileImageAvatar.this.f180634d.equals(setting.uin)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.profilecard.Avatar", 2, "onGetHeadInfo: uin=" + setting.uin);
                }
                if (FriendProfileImageAvatar.this.D && (str = setting.url) != null && str.length() > 0) {
                    FriendProfileImageAvatar.this.t(setting.uin, setting.bFaceFlags, setting.url);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (FriendProfileImageAvatar.this.f180634d.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.profilecard.Avatar", 2, "onUpdateCustomHead: uin=" + str);
                }
                FriendProfileImageAvatar friendProfileImageAvatar = FriendProfileImageAvatar.this;
                friendProfileImageAvatar.z(friendProfileImageAvatar.f180637h);
                if (z16) {
                    FriendProfileImageAvatar friendProfileImageAvatar2 = FriendProfileImageAvatar.this;
                    friendProfileImageAvatar2.x(friendProfileImageAvatar2.f180637h, false);
                    FriendProfileImageAvatar friendProfileImageAvatar3 = FriendProfileImageAvatar.this;
                    friendProfileImageAvatar3.o(friendProfileImageAvatar3.f180637h);
                    return;
                }
                FriendProfileImageAvatar friendProfileImageAvatar4 = FriendProfileImageAvatar.this;
                cf.b bVar = friendProfileImageAvatar4.f180637h;
                bVar.f180642d = 2;
                friendProfileImageAvatar4.o(bVar);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected boolean onUpdateCustomHead(boolean z16, String str, FaceInfo faceInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? FriendProfileImageAvatar.q() && faceInfo != null && faceInfo.isEnableZplanOutbound() : ((Boolean) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, faceInfo)).booleanValue();
        }
    }

    public FriendProfileImageAvatar(QQAppInterface qQAppInterface, boolean z16) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, Boolean.valueOf(z16));
            return;
        }
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = new a();
        this.K = new b();
        this.I = z16;
        this.f175951m = null;
        this.D = false;
        this.C = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
    }
}
