package com.tencent.mobileqq.avatar.dynamicavatar;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.h;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.b;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.ExecSQLTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.QueryTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import na1.a;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DynamicAvatarManager implements Manager {
    static IPatchRedirector $redirector_;
    public static int R;
    private Resources C;
    public SparseArray<ArrayList<String>> D;
    public ArrayList<WeakReference<h>> E;
    public ArrayList<WeakReference<h>> F;
    public ArrayList<WeakReference<h>> G;
    public ArrayList<WeakReference<h>> H;
    public volatile boolean I;
    public long J;
    public volatile int K;
    DPCObserver L;
    private Runnable M;
    private com.tencent.mobileqq.avatar.dynamicavatar.c N;
    private DynamicAvatarDownloadManager.b P;
    public Runnable Q;

    /* renamed from: d, reason: collision with root package name */
    public String f199956d;

    /* renamed from: e, reason: collision with root package name */
    public String f199957e;

    /* renamed from: f, reason: collision with root package name */
    public DynamicAvatarDownloadManager f199958f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.avatar.dynamicavatar.a f199959h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<String, DynamicAvatar> f199960i;

    /* renamed from: m, reason: collision with root package name */
    private AppInterface f199961m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends com.tencent.mobileqq.avatar.dynamicavatar.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarManager.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.dynamicavatar.c
        protected void a(boolean z16, com.tencent.mobileqq.avatar.dynamicavatar.b bVar, Long l3, int i3, int i16, int i17, boolean z17) {
            DynamicAvatar dynamicAvatar;
            ArrayList<b.a> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bVar, l3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z17));
                return;
            }
            String j3 = DynamicAvatarManager.j(i16, i3, String.valueOf(l3), i17);
            if (!z16) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "onGetDynamicAvatarInfo not success: " + i3 + " " + l3 + " " + i16);
                }
                DynamicAvatarManager.this.A(j3, null, null);
                return;
            }
            if (bVar != null && (arrayList = bVar.f200065a) != null && !arrayList.isEmpty()) {
                dynamicAvatar = DynamicAvatar.convertFrom(bVar.f200065a.get(0));
            } else {
                dynamicAvatar = null;
            }
            if (dynamicAvatar == null) {
                DynamicAvatarManager.this.A(j3, null, null);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "onGetDynamicAvatarInfo: " + dynamicAvatar);
            }
            String r16 = DynamicAvatarManager.r(i16, i17, dynamicAvatar);
            String r17 = DynamicAvatarManager.r(i16, 640, dynamicAvatar);
            if (TextUtils.isEmpty(r16) && z17) {
                r16 = DynamicAvatarManager.r(17, i17, dynamicAvatar);
                r17 = DynamicAvatarManager.r(17, 640, dynamicAvatar);
            }
            DynamicAvatarManager.this.A(j3, r16, r17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements DynamicAvatarDownloadManager.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarManager.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.b
        public void a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
            }
        }

        @Override // com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.b
        public void b(String str, boolean z16, boolean z17) {
            WeakReference<h> weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "onDownloadFinish url: " + str + " isSuccess: " + z16 + " isFileExist: " + z17);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (DynamicAvatarManager.this.G) {
                for (int size = DynamicAvatarManager.this.G.size() - 1; size >= 0; size--) {
                    WeakReference<h> weakReference2 = DynamicAvatarManager.this.G.get(size);
                    if (weakReference2 != null && weakReference2.get() != null) {
                        if (str.equals(DynamicAvatarManager.this.G.get(size).get().f195584k)) {
                            WeakReference<h> remove = DynamicAvatarManager.this.G.remove(size);
                            if (z16) {
                                DynamicAvatarManager.this.F.add(remove);
                                if (QLog.isDevelopLevel()) {
                                    QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "onFileDownloadFinish add to wait play list.");
                                }
                            }
                        }
                    }
                    DynamicAvatarManager.this.G.remove(size);
                }
            }
            if (!h.f195572x) {
                synchronized (DynamicAvatarManager.this.H) {
                    int size2 = DynamicAvatarManager.this.H.size() - 1;
                    while (true) {
                        if (size2 >= 0) {
                            if (DynamicAvatarManager.this.H.get(size2) != null && DynamicAvatarManager.this.H.get(size2).get() != null) {
                                weakReference = DynamicAvatarManager.this.H.get(size2);
                                break;
                            } else {
                                DynamicAvatarManager.this.H.remove(size2);
                                size2--;
                            }
                        } else {
                            weakReference = null;
                            break;
                        }
                    }
                }
                if (weakReference != null && weakReference.get() != null) {
                    DynamicAvatarManager.this.G(weakReference.get(), false, false);
                }
            }
            synchronized (DynamicAvatarManager.this.E) {
                for (int size3 = DynamicAvatarManager.this.E.size() - 1; size3 >= 0; size3--) {
                    if (DynamicAvatarManager.this.E.get(size3).get() == null) {
                        DynamicAvatarManager.this.E.remove(size3);
                    }
                }
                for (int size4 = DynamicAvatarManager.this.F.size() - 1; size4 >= 0; size4--) {
                    WeakReference<h> weakReference3 = DynamicAvatarManager.this.F.get(size4);
                    if (weakReference3 != null && weakReference3.get() != null) {
                        if (DynamicAvatarManager.this.E.size() < DynamicAvatarManager.this.f199959h.f200059j) {
                            DynamicAvatarManager.this.F.remove(size4);
                            if (!DynamicAvatarManager.this.E.contains(weakReference3)) {
                                boolean D = DynamicAvatarManager.this.D(weakReference3.get());
                                if (D) {
                                    DynamicAvatarManager.this.E.add(weakReference3);
                                }
                                if (QLog.isDevelopLevel()) {
                                    QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "onFileDownloadFinish to play.02 result : " + D + " playing size: " + DynamicAvatarManager.this.E.size());
                                }
                            }
                        } else if (QLog.isDevelopLevel()) {
                            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "onFileDownloadFinish to play.02 beyond maxPlayingCount : " + DynamicAvatarManager.this.f199959h.f200059j);
                        }
                    }
                    DynamicAvatarManager.this.F.remove(size4);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class c implements DPCObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<DynamicAvatarManager> f199971d;

        public c(DynamicAvatarManager dynamicAvatarManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dynamicAvatarManager);
            } else {
                this.f199971d = new WeakReference<>(dynamicAvatarManager);
            }
        }

        @Override // com.tencent.mobileqq.dpc.DPCObserver
        public void onDpcPullFinished(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            DynamicAvatarManager dynamicAvatarManager = this.f199971d.get();
            if (dynamicAvatarManager != null) {
                dynamicAvatarManager.z(z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70933);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            R = 8;
        }
    }

    public DynamicAvatarManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        this.D = new SparseArray<>();
        this.I = true;
        this.J = 0L;
        this.L = new c(this);
        this.M = new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (DynamicAvatarManager.this.f199961m != null) {
                    boolean checkAndLoadAVCodec = VideoEnvironment.checkAndLoadAVCodec();
                    if (QLog.isDevelopLevel()) {
                        QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "loadVideoSo runnable has run and loaded is " + checkAndLoadAVCodec);
                    }
                    DynamicAvatarManager dynamicAvatarManager = DynamicAvatarManager.this;
                    if (checkAndLoadAVCodec) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    dynamicAvatarManager.K = i3;
                    if (!checkAndLoadAVCodec && (DynamicAvatarManager.this.f199961m instanceof QQAppInterface)) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "loadVideoSo download execute");
                        }
                        ShortVideoResourceManager.s((QQAppInterface) DynamicAvatarManager.this.f199961m, null);
                    }
                }
            }
        };
        this.N = new a();
        this.P = new b();
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (h.f195573y) {
                    h.f195572x = false;
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.9.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else if (!h.f195572x) {
                            AbstractVideoImage.resumeAll();
                        }
                    }
                });
                DynamicAvatarManager.this.E();
            }
        };
        if (appInterface == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "new DynamicAvatarManager param app is null.");
                return;
            }
            return;
        }
        this.f199961m = appInterface;
        appInterface.addObserver(this.N, true);
        this.H = new ArrayList<>();
        this.G = new ArrayList<>();
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.f199960i = new ConcurrentHashMap<>();
        DynamicAvatarDownloadManager dynamicAvatarDownloadManager = new DynamicAvatarDownloadManager(appInterface);
        this.f199958f = dynamicAvatarDownloadManager;
        dynamicAvatarDownloadManager.e(this.P);
        this.C = BaseApplication.getContext().getResources();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    DynamicAvatarManager.this.t();
                    DynamicAvatarManager.R = DynamicAvatarManager.this.f199959h.f200059j;
                }
            }
        }, 64, null, true);
        ((IDPCApi) QRoute.api(IDPCApi.class)).addObserver(this.L);
        this.K = ShortVideoUtils.isVideoSoLibLoaded() ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2, String str3) {
        boolean z16;
        synchronized (this.G) {
            z16 = false;
            for (int size = this.G.size() - 1; size >= 0; size--) {
                WeakReference<h> weakReference = this.G.get(size);
                if (weakReference == null) {
                    this.G.remove(size);
                } else {
                    h hVar = weakReference.get();
                    if (hVar == null) {
                        this.G.remove(size);
                    } else if (str.equals(hVar.f195590q)) {
                        if (TextUtils.isEmpty(str2)) {
                            hVar.f195575b = null;
                            hVar.d();
                            hVar.g(3, null, "do not have dynamic avatar url");
                            this.G.remove(size);
                        } else {
                            hVar.f195584k = str2;
                            hVar.f195585l = str3;
                            WeakReference<DynamicAvatarView> weakReference2 = hVar.f195592s;
                            if (weakReference2 != null && weakReference2.get() != null && str2.equals(hVar.f195592s.get().F)) {
                                this.G.remove(weakReference);
                            } else {
                                z16 = true;
                            }
                        }
                    }
                }
            }
        }
        if (z16) {
            F(str2);
        }
    }

    public static String j(int i3, int i16, String str, int i17) {
        return i3 + "_" + i16 + "_" + str;
    }

    public static String k(h hVar, boolean z16) {
        if (hVar == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(hVar.f195581h);
        sb5.append("_");
        sb5.append(hVar.f195582i);
        sb5.append("_");
        sb5.append(hVar.f195580g);
        if (z16 || (hVar.f195586m && !TextUtils.isEmpty(hVar.f195584k))) {
            sb5.append("_");
            sb5.append(hVar.f195584k);
        }
        return sb5.toString();
    }

    public static String l(int i3, int i16, String str, int i17) {
        int i18;
        int i19 = 17;
        if (i16 == 200) {
            i18 = 17;
        } else {
            i18 = 18;
        }
        if (i3 == 32) {
            i19 = 18;
        }
        return j(i19, i18, str, i17);
    }

    public static String r(int i3, int i16, DynamicAvatar dynamicAvatar) {
        if (dynamicAvatar == null) {
            return null;
        }
        if (i3 == 17) {
            if (i16 == 100) {
                return dynamicAvatar.basicSmallUrl;
            }
            if (i16 == 200) {
                return dynamicAvatar.basicMiddleUrl;
            }
            if (i16 == 640) {
                return dynamicAvatar.basicBigUrl;
            }
        } else if (i3 == 18) {
            if (i16 == 100) {
                return dynamicAvatar.nearbySmallUrl;
            }
            if (i16 == 200) {
                return dynamicAvatar.nearbyMiddleUrl;
            }
            if (i16 == 640) {
                return dynamicAvatar.nearbyBigUrl;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Setting s(int i3, String str) {
        AppInterface appInterface = this.f199961m;
        if (appInterface instanceof QQAppInterface) {
            EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            Setting setting = (Setting) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) Setting.class, str);
            createEntityManager.close();
            return setting;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(DynamicAvatar dynamicAvatar, Setting setting, int i3) {
        if (dynamicAvatar != null && setting != null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            int i16 = dynamicAvatar.getTimeStamp;
            if (currentTimeMillis - i16 >= 0 && currentTimeMillis - i16 < 86400) {
                if (i3 == 17) {
                    if (i16 + 5 < setting.headImgTimestamp && (dynamicAvatar.basicSetTimeStamp + 5) * 1000 < setting.updateTimestamp) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "isNeed2GetDynamicAvatarInfo: " + dynamicAvatar.getTimeStamp + " " + setting.headImgTimestamp + " " + dynamicAvatar.basicSetTimeStamp + " " + setting.updateTimestamp);
                        }
                        return true;
                    }
                    return false;
                }
                if (i3 == 18 && i16 + 5 < setting.headImgTimestamp && (dynamicAvatar.nearbySetTimeStamp + 5) * 1000 < setting.updateTimestamp) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "isNeed2GetDynamicAvatarInfo: " + dynamicAvatar.getTimeStamp + " " + setting.headImgTimestamp + " " + dynamicAvatar.basicSetTimeStamp + " " + setting.updateTimestamp);
                    }
                    return true;
                }
                return false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "isNeed2GetDynamicAvatarInfo beyond 24h, stamp: " + dynamicAvatar.getTimeStamp);
            }
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "isNeed2GetDynamicAvatarInfo dynamicAvatrInfo or setting info is null.");
        }
        return true;
    }

    private void y() {
        if (this.K == 0) {
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "loadVideoSo called");
            }
            ThreadManager.getSubThreadHandler().postDelayed(this.M, 10000L);
            this.K = 1;
        }
    }

    public void B(h hVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, hVar, Boolean.valueOf(z16));
            return;
        }
        if (hVar == null) {
            return;
        }
        if (z16) {
            String k3 = k(hVar, false);
            ArrayList<String> arrayList = this.D.get(hVar.f195589p);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.D.put(hVar.f195589p, arrayList);
            }
            arrayList.add(k3);
            arrayList.add(k(hVar, true));
            int i3 = hVar.f195589p;
            if (i3 == 1 || i3 == 0) {
                ThreadManagerV2.post(new Runnable(hVar, System.currentTimeMillis()) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.7
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ h f199965d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ long f199966e;

                    {
                        this.f199965d = hVar;
                        this.f199966e = r7;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, DynamicAvatarManager.this, hVar, Long.valueOf(r7));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        DynamicAvatarManager dynamicAvatarManager = DynamicAvatarManager.this;
                        h hVar2 = this.f199965d;
                        DynamicAvatar p16 = dynamicAvatarManager.p(hVar2.f195582i, hVar2.f195580g);
                        if (p16 != null) {
                            p16.playTimeStamp = this.f199966e;
                            DynamicAvatarManager.this.H(p16);
                        }
                    }
                }, 5, null, true);
            }
            if (hVar.f195592s.get() != null) {
                hVar.f195592s.get().F = "";
            }
        }
        ThreadManagerV2.postImmediately(new Runnable(hVar) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ h f199967d;

            {
                this.f199967d = hVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarManager.this, (Object) hVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (DynamicAvatarManager.this.E) {
                    if (!DynamicAvatarManager.this.E.remove(this.f199967d.f195594u)) {
                        return;
                    }
                    for (int size = DynamicAvatarManager.this.E.size() - 1; size >= 0; size--) {
                        if (DynamicAvatarManager.this.E.get(size).get() == null) {
                            DynamicAvatarManager.this.E.remove(size);
                        }
                    }
                    for (int size2 = DynamicAvatarManager.this.F.size() - 1; size2 >= 0; size2--) {
                        WeakReference<h> remove = DynamicAvatarManager.this.F.remove(size2);
                        if (remove != null && remove.get() != null && !DynamicAvatarManager.this.E.contains(remove)) {
                            boolean D = DynamicAvatarManager.this.D(remove.get());
                            if (QLog.isDevelopLevel()) {
                                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "onPlayFinished to play. result : " + D);
                            }
                            if (D) {
                                DynamicAvatarManager.this.E.add(remove);
                            }
                            return;
                        }
                    }
                }
            }
        }, null, true);
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    @TargetApi(11)
    public boolean D(h hVar) {
        int i3;
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) hVar)).booleanValue();
        }
        if (!hVar.f195587n) {
            String k3 = k(hVar, false);
            ArrayList<String> arrayList = this.D.get(hVar.f195589p);
            if (arrayList != null && arrayList.contains(k3)) {
                return false;
            }
        }
        File h16 = DynamicAvatarDownloadManager.h(hVar.f195584k);
        int i16 = hVar.f195583j;
        int i17 = 640;
        if (i16 != 640) {
            i17 = 200;
            if (i16 != 200) {
                i17 = 100;
            }
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = i17;
        obtain.mRequestHeight = i17;
        Drawable drawable = hVar.f195574a;
        if (drawable instanceof FaceDrawable) {
            drawable = ((FaceDrawable) drawable).getCurrDrawable();
        }
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        VideoDrawable.VideoDrawableParams videoDrawableParams = new VideoDrawable.VideoDrawableParams();
        videoDrawableParams.mPlayVideoFrame = true;
        videoDrawableParams.mRequestedFPS = this.f199959h.f200061l;
        videoDrawableParams.mVideoRoundCorner = i17;
        videoDrawableParams.mEnableAntiAlias = true;
        videoDrawableParams.mEnableFilter = true;
        obtain.mExtraInfo = videoDrawableParams;
        URLDrawable drawable2 = URLDrawable.getDrawable(h16, obtain);
        boolean k16 = hVar.k(drawable2);
        hVar.g(0, drawable2, null);
        if (k16 && (i3 = hVar.f195589p) >= 0) {
            int[] iArr = h.f195570v;
            if (iArr.length > i3 && (appInterface = this.f199961m) != null) {
                DynamicUtils.j(appInterface, "0X800711C", iArr[i3]);
            }
        }
        return k16;
    }

    public void E() {
        int min;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(LogTag.TAG_DYNAMIC_AVATAR, 2, "resumeAll pausedSize: " + this.H.size() + " loadinging size: " + this.G.size() + " playing size" + this.E.size() + " waiting play size: " + this.F.size());
        }
        if (h.f195572x) {
            return;
        }
        synchronized (this.H) {
            for (int size = this.H.size() - 1; size >= 0; size--) {
                WeakReference<h> weakReference = this.H.get(size);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().d();
                } else {
                    this.H.remove(size);
                }
            }
            min = Math.min(R, this.H.size());
        }
        synchronized (this.G) {
            int size2 = this.G.size();
            int i16 = R;
            if (min >= i16) {
                i3 = size2;
            } else {
                i3 = size2 - (i16 - min);
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i17 = size2 - 1; i17 >= size2 - i3; i17--) {
                WeakReference<h> remove = this.G.remove(i17);
                if (remove != null && remove.get() != null) {
                    arrayList.add(remove.get().f195584k);
                }
            }
            DynamicAvatarDownloadManager dynamicAvatarDownloadManager = this.f199958f;
            if (dynamicAvatarDownloadManager != null) {
                dynamicAvatarDownloadManager.g(arrayList);
            }
        }
        synchronized (this.H) {
            for (int min2 = Math.min(this.H.size() - 1, min - 1); min2 >= 0; min2--) {
                WeakReference<h> weakReference2 = this.H.get(min2);
                if (weakReference2 != null && weakReference2.get() != null) {
                    G(weakReference2.get(), false, false);
                } else {
                    this.H.remove(min2);
                }
            }
        }
    }

    public void F(String str) {
        DynamicAvatarDownloadManager dynamicAvatarDownloadManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && (dynamicAvatarDownloadManager = this.f199958f) != null) {
            dynamicAvatarDownloadManager.q(str);
        }
    }

    public void G(h hVar, boolean z16, boolean z17) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, hVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (this.G.size() >= R && !z16) {
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "startLoadDynamicAvatarInfo add PausedFaceDrawables " + hVar.f195584k);
            }
            synchronized (this.H) {
                this.H.add(hVar.f195594u);
            }
            return;
        }
        String str = hVar.f195590q;
        synchronized (this.G) {
            this.G.add(hVar.f195594u);
        }
        if (!z16) {
            synchronized (this.H) {
                this.H.remove(hVar.f195594u);
            }
        }
        Runnable runnable = new Runnable(hVar, str) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ h f199962d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f199963e;

            {
                this.f199962d = hVar;
                this.f199963e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DynamicAvatarManager.this, hVar, str);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:71:0x00bb, code lost:
            
                r5 = true;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean contains;
                DynamicAvatar dynamicAvatar;
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (DynamicAvatarManager.this.G) {
                    contains = DynamicAvatarManager.this.G.contains(this.f199962d.f195594u);
                }
                if (contains) {
                    if (h.f195572x) {
                        synchronized (DynamicAvatarManager.this.G) {
                            DynamicAvatarManager.this.G.remove(this.f199962d.f195594u);
                        }
                        synchronized (DynamicAvatarManager.this.H) {
                            if (!DynamicAvatarManager.this.H.contains(this.f199962d.f195594u)) {
                                ArrayList<WeakReference<h>> arrayList = DynamicAvatarManager.this.H;
                                arrayList.add(arrayList.size(), this.f199962d.f195594u);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(this.f199962d.f195584k)) {
                        h hVar2 = this.f199962d;
                        if (!hVar2.f195588o) {
                            DynamicAvatarManager.this.A(this.f199963e, hVar2.f195584k, hVar2.f195585l);
                            return;
                        }
                    }
                    boolean z18 = false;
                    try {
                        DynamicAvatarManager dynamicAvatarManager = DynamicAvatarManager.this;
                        h hVar3 = this.f199962d;
                        dynamicAvatar = dynamicAvatarManager.p(hVar3.f195582i, hVar3.f195580g);
                    } catch (NullPointerException e16) {
                        QLog.e(LogTag.TAG_DYNAMIC_AVATAR, 1, e16, new Object[0]);
                        dynamicAvatar = null;
                    }
                    if (dynamicAvatar != null && ((i3 = this.f199962d.f195589p) == 1 || i3 == 0)) {
                        boolean z19 = i3 == 0 ? false : false;
                        if (z19 && DynamicUtils.m(System.currentTimeMillis(), dynamicAvatar.playTimeStamp)) {
                            z18 = true;
                        }
                        if (z18) {
                            QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 1, "playedSameDay uin:" + this.f199963e);
                            synchronized (DynamicAvatarManager.this.G) {
                                DynamicAvatarManager.this.G.remove(this.f199962d.f195594u);
                            }
                            this.f199962d.g(2, null, "playedSameDay");
                            return;
                        }
                    }
                    DynamicAvatarManager dynamicAvatarManager2 = DynamicAvatarManager.this;
                    h hVar4 = this.f199962d;
                    boolean u16 = DynamicAvatarManager.this.u(dynamicAvatar, dynamicAvatarManager2.s(hVar4.f195582i, hVar4.f195580g), this.f199962d.f195581h);
                    if (QLog.isDevelopLevel()) {
                        QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "execute loadDynamicAvatarInfo runnable. isNeed2GetDynamicAvatarInfo: " + u16);
                    }
                    if (!u16) {
                        h hVar5 = this.f199962d;
                        if (!hVar5.f195588o) {
                            String r16 = DynamicAvatarManager.r(hVar5.f195581h, hVar5.f195583j, dynamicAvatar);
                            String r17 = DynamicAvatarManager.r(this.f199962d.f195581h, 640, dynamicAvatar);
                            if (QLog.isDevelopLevel()) {
                                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "execute loadDynamicAvatarInfo runnable. url : " + r16);
                            }
                            DynamicAvatarManager.this.A(this.f199963e, r16, r17);
                            return;
                        }
                    }
                    try {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "getDynamicAvatarInfo from net mId:" + this.f199962d.f195580g + " mIdType" + this.f199962d.f195582i + " mHeadType:" + this.f199962d.f195581h);
                        }
                        DynamicAvatarInfoHandler dynamicAvatarInfoHandler = (DynamicAvatarInfoHandler) DynamicAvatarManager.this.f199961m.getBusinessHandler(BusinessHandlerFactory.DYNAMIC_AVATAR_HANDLER);
                        if (dynamicAvatarInfoHandler != null) {
                            Long valueOf = Long.valueOf(this.f199962d.f195580g);
                            h hVar6 = this.f199962d;
                            dynamicAvatarInfoHandler.D2(valueOf, hVar6.f195582i, hVar6.f195581h, hVar6.f195583j, hVar6.f195577d);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        synchronized (DynamicAvatarManager.this.G) {
                            DynamicAvatarManager.this.G.remove(this.f199962d.f195594u);
                            return;
                        }
                    }
                }
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 1, "is not in mLoadingFaceDrawables");
            }
        };
        if (!z17) {
            j3 = 0;
        } else if (hVar.f195589p == 0) {
            j3 = 1500;
        } else {
            j3 = 400;
        }
        if (ah.n() <= 2) {
            j3 *= 2;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable(runnable) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f199964d;

            {
                this.f199964d = runnable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarManager.this, (Object) runnable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ThreadManagerV2.excute(this.f199964d, 16, null, true);
                }
            }
        }, j3);
    }

    public void H(DynamicAvatar dynamicAvatar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) dynamicAvatar);
            return;
        }
        AppInterface appInterface = this.f199961m;
        if (appInterface instanceof QQAppInterface) {
            EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            DynamicAvatar dynamicAvatar2 = (DynamicAvatar) DBMethodProxy.find(createEntityManager, DynamicAvatar.class, "uin=?", new String[]{String.valueOf(dynamicAvatar.uin)});
            if (dynamicAvatar2 != null) {
                dynamicAvatar.setStatus(dynamicAvatar2.getStatus());
                dynamicAvatar.setId(dynamicAvatar2.getId());
            }
            if (dynamicAvatar.getStatus() == 1000) {
                createEntityManager.persistOrReplace(dynamicAvatar);
            } else {
                createEntityManager.update(dynamicAvatar);
            }
            createEntityManager.close();
            if (QLog.isDevelopLevel()) {
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "updateDynamicAvatarInfo: avatarInfo is : " + dynamicAvatar2);
            }
        }
    }

    public void f(com.tencent.mobileqq.avatar.dynamicavatar.b bVar) {
        ArrayList<b.a> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        AppInterface appInterface = this.f199961m;
        if (appInterface instanceof QQAppInterface) {
            EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            ArrayList arrayList2 = new ArrayList();
            Cursor cursor = null;
            try {
                cursor = createEntityManager.doQueryCursorOperateByTransaction(new QueryTransaction(false, DynamicAvatar.class.getSimpleName(), (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null));
                if (cursor != null) {
                    int count = cursor.getCount();
                    cursor.moveToFirst();
                    if (count >= 1000) {
                        while (true) {
                            int i3 = count - 1;
                            if (count <= 333) {
                                break;
                            }
                            cursor.moveToNext();
                            count = i3;
                        }
                        arrayList2.add(new ExecSQLTransaction("delete from " + DynamicAvatar.class.getSimpleName() + " where _id < " + cursor.getInt(cursor.getColumnIndex("_id")) + ";"));
                        createEntityManager.doMultiDBOperateByTransaction(arrayList2);
                        arrayList2.clear();
                    }
                }
                if (bVar != null && (arrayList = bVar.f200065a) != null && !arrayList.isEmpty()) {
                    Iterator<b.a> it = bVar.f200065a.iterator();
                    while (it.hasNext()) {
                        DynamicAvatar convertFrom = DynamicAvatar.convertFrom(it.next());
                        if (convertFrom != null) {
                            int i16 = 0;
                            DynamicAvatar dynamicAvatar = (DynamicAvatar) DBMethodProxy.find(createEntityManager, DynamicAvatar.class, "uin=?", new String[]{String.valueOf(convertFrom.uin)});
                            if (dynamicAvatar != null) {
                                convertFrom.setStatus(dynamicAvatar.getStatus());
                                convertFrom.setId(dynamicAvatar.getId());
                            }
                            if (convertFrom.getStatus() == 1000) {
                                arrayList2.add(new PersistOrReplaceTransaction(convertFrom));
                            } else {
                                arrayList2.add(new UpdateTransaction(convertFrom));
                            }
                            synchronized (this.f199960i) {
                                if (this.f199960i.size() > 200) {
                                    Iterator<Map.Entry<String, DynamicAvatar>> it5 = this.f199960i.entrySet().iterator();
                                    while (it5.hasNext()) {
                                        it5.remove();
                                        i16++;
                                        if (i16 >= 100) {
                                            break;
                                        }
                                    }
                                }
                                long j3 = convertFrom.uin;
                                if (j3 > 0) {
                                    this.f199960i.put(String.valueOf(j3), convertFrom);
                                }
                                long j16 = convertFrom.tinyId;
                                if (j16 > 0) {
                                    this.f199960i.put(String.valueOf(j16), convertFrom);
                                }
                            }
                        }
                    }
                    createEntityManager.doMultiDBOperateByTransaction(arrayList2);
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public void g(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) bArr);
            return;
        }
        if (bArr != null && bArr.length > 0) {
            Object obj = this.f199961m;
            if (obj instanceof QQAppInterface) {
                oidb_0x74b$RspBody oidb_0x74b_rspbody = new oidb_0x74b$RspBody();
                try {
                    oidb_0x74b_rspbody.mergeFrom(bArr);
                    f(com.tencent.mobileqq.avatar.dynamicavatar.b.a(oidb_0x74b_rspbody));
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isDevelopLevel()) {
                        e16.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            if (obj instanceof INearbyAppInterface) {
                ((INearbyAppInterface) obj).getNearbyProcManager().c(bArr);
            }
        }
    }

    public void h(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) hVar);
            return;
        }
        if (hVar == null) {
            return;
        }
        synchronized (this.H) {
            this.H.remove(hVar.f195594u);
        }
        synchronized (this.E) {
            this.E.remove(hVar.f195594u);
            this.F.remove(hVar.f195594u);
        }
        synchronized (this.G) {
            this.G.remove(hVar.f195594u);
        }
    }

    public DynamicAvatar i(int i3, String str) {
        DynamicAvatar dynamicAvatar;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (DynamicAvatar) iPatchRedirector.redirect((short) 25, (Object) this, i3, (Object) str);
        }
        AppInterface appInterface = this.f199961m;
        boolean z16 = true;
        if (appInterface != null) {
            EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            if (i3 == 18) {
                str2 = "tinyId=?";
            } else {
                str2 = "uin=?";
            }
            dynamicAvatar = (DynamicAvatar) DBMethodProxy.find(createEntityManager, DynamicAvatar.class, str2, new String[]{str});
            createEntityManager.close();
        } else {
            dynamicAvatar = null;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAvatarInfoFromDb: avatarInfo is null: ");
            if (dynamicAvatar != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, sb5.toString());
        }
        return dynamicAvatar;
    }

    public com.tencent.mobileqq.avatar.dynamicavatar.a m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.avatar.dynamicavatar.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f199959h == null) {
            t();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "getConfig DynamicAvatarConfig|" + this.f199959h);
        }
        return this.f199959h;
    }

    public DynamicAvatarDownloadManager n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (DynamicAvatarDownloadManager) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f199958f;
    }

    public void o(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) hVar);
            return;
        }
        if (hVar == null) {
            return;
        }
        if (this.K != 2) {
            if (QLog.isDevelopLevel()) {
                QLog.w(LogTag.TAG_DYNAMIC_AVATAR, 2, "getDynamicAvatar isVideoSoLibLoaded false.");
            }
            y();
            hVar.g(1, null, "so not loaded");
            return;
        }
        if (!hVar.f195587n) {
            String k3 = k(hVar, false);
            ArrayList<String> arrayList = this.D.get(hVar.f195589p);
            if (arrayList != null && arrayList.contains(k3)) {
                hVar.g(2, null, "has played");
                return;
            }
        }
        if (h.f195572x) {
            synchronized (this.H) {
                this.H.add(hVar.f195594u);
            }
            return;
        }
        G(hVar, true, true);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.M);
        ((IDPCApi) QRoute.api(IDPCApi.class)).removeObserver(this.L);
        this.f199961m.removeObserver(this.N);
        this.f199958f.p();
        this.f199958f = null;
        this.N = null;
        this.f199961m = null;
    }

    public DynamicAvatar p(int i3, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (DynamicAvatar) iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) str);
        }
        Object obj = this.f199961m;
        boolean z17 = true;
        DynamicAvatar dynamicAvatar = null;
        if (obj instanceof QQAppInterface) {
            if (this.f199960i.containsKey(str)) {
                dynamicAvatar = this.f199960i.get(str);
                if (QLog.isDevelopLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getDynamicAvatarInfo cache is null: ");
                    if (dynamicAvatar == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, sb5.toString());
                }
            }
            if (dynamicAvatar == null) {
                dynamicAvatar = i(i3, str);
                synchronized (this.f199960i) {
                    if (dynamicAvatar != null) {
                        this.f199960i.put(str, dynamicAvatar);
                    }
                }
            }
        } else if (obj instanceof INearbyAppInterface) {
            dynamicAvatar = (DynamicAvatar) ((INearbyAppInterface) obj).getNearbyProcManager().e(i3, str);
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("db find dynamic avatarInfo is null: ");
            if (dynamicAvatar != null) {
                z17 = false;
            }
            sb6.append(z17);
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, sb6.toString());
        }
        return dynamicAvatar;
    }

    public DynamicAvatar q(String str) {
        DynamicAvatar dynamicAvatar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (DynamicAvatar) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if ((this.f199961m instanceof QQAppInterface) && this.f199960i.containsKey(str)) {
            dynamicAvatar = this.f199960i.get(str);
        } else {
            dynamicAvatar = null;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getDynamicAvatarInfoFromCache: ");
            if (dynamicAvatar == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, sb5.toString());
        }
        return dynamicAvatar;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f199959h = new com.tencent.mobileqq.avatar.dynamicavatar.a();
        if (QLog.isDevelopLevel()) {
            QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "DynamicAvatarConfig|init config:" + this.f199959h + ",costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean v(FaceInfo faceInfo, Setting setting, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, faceInfo, setting, Integer.valueOf(i3))).booleanValue();
        }
        if (faceInfo == null) {
            return false;
        }
        DynamicAvatar p16 = p(faceInfo.idType, faceInfo.uin);
        if (p16 == null || setting == null) {
            return true;
        }
        if (i3 == 17) {
            if (p16.getTimeStamp - 5 > setting.headImgTimestamp && (p16.basicSetTimeStamp - 5) * 1000 > setting.updateTimestamp) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "isNeed2UpdateSettingInfo basic: " + p16.getTimeStamp + " " + setting.headImgTimestamp + " " + p16.basicSetTimeStamp + " " + setting.updateTimestamp);
                }
                return true;
            }
        } else if (i3 == 18 && p16.getTimeStamp - 5 > setting.headImgTimestamp && (p16.nearbySetTimeStamp - 5) * 1000 > setting.updateTimestamp) {
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "isNeed2UpdateSettingInfo nearby: " + p16.getTimeStamp + " " + setting.headImgTimestamp + " " + p16.basicSetTimeStamp + " " + setting.updateTimestamp);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean w(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        com.tencent.mobileqq.avatar.dynamicavatar.a aVar = this.f199959h;
        if (aVar != null) {
            switch (i3) {
                case 0:
                    z16 = aVar.f200053d;
                    break;
                case 1:
                    z16 = aVar.f200054e;
                    break;
                case 2:
                    z16 = aVar.f200055f;
                    break;
                case 3:
                    z16 = aVar.f200056g;
                    break;
                case 4:
                    z16 = aVar.f200057h;
                    break;
                case 5:
                    z16 = aVar.f200058i;
                    break;
                case 6:
                case 8:
                    z16 = true;
                    break;
                case 7:
                    z16 = aVar.f200056g;
                    break;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "isPlayDynamicAvatar|source:" + i3 + ",isPlay:" + z16 + "\n" + this.f199959h);
            }
            return z16;
        }
        z16 = false;
        if (QLog.isDevelopLevel()) {
        }
        return z16;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (NetConnInfoCenter.getServerTimeMillis() - this.J < 60000) {
            if (QLog.isDevelopLevel()) {
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "isSupportDynamicAvatar: use old value, isSupportDynamicAvatar is " + this.I);
            }
            return this.I;
        }
        this.J = NetConnInfoCenter.getServerTimeMillis();
        a.b a16 = DynamicAvatarConfProcessor.INSTANCE.a().a();
        if (a16 == null) {
            QLog.e(LogTag.TAG_DYNAMIC_AVATAR, 2, "isSupportDynamicAvatar config is null");
            this.I = true;
            return this.I;
        }
        this.I = a16.getIsSupportDynamicAvatar();
        if (QLog.isDevelopLevel()) {
            QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "isSupportDynamicAvatar: use new value, isSupportDynamicAvatar is " + this.I);
        }
        return this.I;
    }

    public void z(boolean z16) {
        com.tencent.mobileqq.avatar.dynamicavatar.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        if (z16 && (aVar = this.f199959h) != null && aVar.f200051b) {
            synchronized (aVar) {
                this.f199959h.a();
                if (QLog.isDevelopLevel()) {
                    QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "---onDpcPullFinished---|mDynamicAvatarConfig:" + this.f199959h);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "---onDpcPullFinished---|isSuccess:" + z16);
        }
    }
}
