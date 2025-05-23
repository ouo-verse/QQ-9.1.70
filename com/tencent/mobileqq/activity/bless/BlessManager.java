package com.tencent.mobileqq.activity.bless;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.bless.o;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.eb;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.util.VersionUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BlessManager implements Manager {
    static IPatchRedirector $redirector_;
    public static final String U;
    private static int V;
    private volatile boolean C;
    private p D;
    private p E;
    private ArrayList<String> F;
    private boolean G;
    private volatile boolean H;
    private AtomicBoolean I;
    private String J;
    public String K;
    public String L;
    private MessageForShortVideo M;
    private Drawable N;
    private Drawable P;
    private long Q;
    private boolean R;
    private boolean S;
    protected Runnable T;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f180523d;

    /* renamed from: e, reason: collision with root package name */
    private BlessTask f180524e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<BlessPtvModule> f180525f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<BlessWording> f180526h;

    /* renamed from: i, reason: collision with root package name */
    private BlessTask f180527i;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.mobileqq.vip.g> f180528m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.bless.BlessManager$6, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ BlessManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.this$0.f180524e == null) {
                this.this$0.l0(false);
                return;
            }
            if (!this.this$0.H) {
                BlessManager blessManager = this.this$0;
                blessManager.H = blessManager.p(blessManager.f180524e, false);
                BlessManager blessManager2 = this.this$0;
                blessManager2.l0(blessManager2.H);
                BlessManager blessManager3 = this.this$0;
                blessManager3.p(blessManager3.f180524e, true);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.bless.BlessManager$7, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f180529d;
        final /* synthetic */ BlessManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "checkAndDownloadJson begin");
            }
            VasUpdateUtil.getJSONFromLocal(this.f180529d, VasUpdateConstants.SCID_BLESS_VOICECHANGE, true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements o.a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.bless.BlessManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C7141a implements IOperateCallback {
            static IPatchRedirector $redirector_;

            C7141a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public void onResult(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                    return;
                }
                QLog.i("BlessManager", 1, "deleteSendBlessEntryFromRu result: " + i3 + " errMsg: " + str);
                BlessManager.this.n();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessManager.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.bless.o.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i("BlessManager", 1, "initEntrance onNoneEntrance");
            BlessManager.this.n();
            BlessManager.this.f180524e.isNew = false;
        }

        @Override // com.tencent.mobileqq.activity.bless.o.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("BlessManager", 1, "initEntrance onHasEntrance task.isNew: " + BlessManager.this.f180524e.isNew);
            if (BlessManager.this.f180524e.isNew) {
                BlessManager.this.x(new C7141a());
            }
            BlessManager.this.f180524e.isNew = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f180532a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f180533b;

        b(String str, String str2) {
            this.f180532a = str;
            this.f180533b = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BlessManager.this, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onCancel(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            } else {
                BlessManager.this.f180528m.remove(this.f180532a);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            BlessManager.this.f180528m.remove(this.f180532a);
            if (gVar.i() == 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("BlessManager", 2, "download finished " + this.f180533b);
                }
                if (this.f180533b == null || BlessManager.this.f180524e == null || !this.f180533b.equals(BlessManager.this.f180524e.starVideo)) {
                    BlessManager.this.o();
                    return;
                } else {
                    BlessManager.this.u();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "downloadFile failed: " + gVar.f313007e + " code=" + gVar.f313006d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67756);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 81)) {
            redirector.redirect((short) 81);
            return;
        }
        U = "bless" + File.separator;
    }

    public BlessManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f180528m = new ConcurrentHashMap<>();
        this.C = false;
        this.G = false;
        this.H = false;
        this.I = new AtomicBoolean(false);
        this.N = null;
        this.P = null;
        this.Q = 0L;
        this.R = false;
        this.S = false;
        this.T = new Runnable() { // from class: com.tencent.mobileqq.activity.bless.BlessManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BlessManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    BlessManager.this.S = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("BlessManager", 2, "mCheckMultiConfigRunnable");
                    }
                    Set<String> D = BlessManager.this.D();
                    if (D != null && D.size() > 0) {
                        BlessManager.this.A0(D);
                    }
                    BlessManager.this.S = false;
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.f180523d = qQAppInterface;
        String sandBoxPath = VFSAssistantUtils.getSandBoxPath(AppConstants.SDCARD_PATH + U);
        this.K = sandBoxPath;
        BlessPtvModule.path = sandBoxPath;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.K);
        String str = File.separator;
        sb5.append(str);
        sb5.append("history");
        sb5.append(str);
        sb5.append("ptvHistory");
        this.L = sb5.toString();
        m0();
        n0();
        ThreadManager.getSubThreadHandler().post(this.T);
    }

    public static String C() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("bless_config", 4).getString("config_content", "");
    }

    private void C0(String str, BlessTask blessTask, ArrayList<BlessPtvModule> arrayList, ArrayList<BlessWording> arrayList2) {
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "processReceivedConfig newTask=" + blessTask);
        }
        ArrayList<BlessPtvModule> arrayList3 = this.f180525f;
        if (arrayList3 != null) {
            Iterator<BlessPtvModule> it = arrayList3.iterator();
            while (it.hasNext()) {
                BlessPtvModule next = it.next();
                Iterator<BlessPtvModule> it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        BlessPtvModule next2 = it5.next();
                        if (next.f180535id.equals(next2.f180535id)) {
                            if (next.data.equals(next2.data)) {
                                next2.broken = next.broken;
                            } else {
                                next2.broken = true;
                            }
                        }
                    }
                }
            }
        }
        BlessTask blessTask2 = this.f180524e;
        if (blessTask2 != null) {
            String J = J(blessTask2.starVideo);
            String J2 = J(blessTask.starVideo);
            if (J != null && J.equals(J2)) {
                blessTask.videoPlayed = this.f180524e.videoPlayed;
            }
        }
        if (this.N != null && this.f180524e != null && !TextUtils.isEmpty(blessTask.starAvator) && !blessTask.starAvator.equals(this.f180524e.starAvator)) {
            this.N = null;
        }
        BlessTask blessTask3 = this.f180524e;
        if (blessTask3 != null && blessTask.festival_id == blessTask3.festival_id && blessTask.task_id == blessTask3.task_id) {
            blessTask.isNew = blessTask3.isNew;
            blessTask.isDeleted = blessTask3.isDeleted;
        }
        this.f180524e = blessTask;
        this.f180525f = arrayList;
        this.f180526h = arrayList2;
        v(blessTask);
        w(this.f180525f);
        this.H = p(this.f180524e, false);
        l0(this.H);
        p(this.f180524e, true);
        this.D.c();
        SharedPreferences preferences = this.f180523d.getPreferences();
        p.h(preferences, this.D, 1);
        I0(blessTask, arrayList, arrayList2);
        preferences.edit().remove("bless_send_wording").commit();
        this.J = null;
        F0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<String> D() {
        return this.f180523d.getApp().getSharedPreferences("bless_config", 4).getStringSet("config_list", null);
    }

    private void E0(Set<String> set) {
        SharedPreferences.Editor edit = this.f180523d.getApp().getSharedPreferences("bless_config", 4).edit();
        if (set == null) {
            edit.remove("config_list");
        } else {
            edit.putStringSet("config_list", set);
        }
        edit.commit();
    }

    public static Date F(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e16) {
            e16.printStackTrace();
            return null;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    private void F0(String str) {
        SharedPreferences.Editor edit = this.f180523d.getApp().getSharedPreferences("bless_config", 4).edit();
        edit.putString("config_content", str);
        edit.commit();
    }

    private void I0(BlessTask blessTask, ArrayList<BlessPtvModule> arrayList, ArrayList<BlessWording> arrayList2) {
        EntityManager createEntityManager = this.f180523d.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = createEntityManager.getTransaction();
        try {
            try {
                transaction.begin();
                createEntityManager.drop(BlessTask.class);
                if (blessTask != null) {
                    createEntityManager.persistOrReplace(blessTask);
                }
                createEntityManager.drop(BlessPtvModule.class);
                if (arrayList != null) {
                    Iterator<BlessPtvModule> it = arrayList.iterator();
                    while (it.hasNext()) {
                        createEntityManager.persistOrReplace(it.next());
                    }
                }
                createEntityManager.drop(BlessWording.class);
                if (arrayList2 != null) {
                    Iterator<BlessWording> it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        createEntityManager.persistOrReplace(it5.next());
                    }
                }
                transaction.commit();
                if (QLog.isDevelopLevel()) {
                    QLog.d("BlessManager", 4, "save task and modules to db");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            transaction.end();
            createEntityManager.close();
        } catch (Throwable th5) {
            transaction.end();
            throw th5;
        }
    }

    public static int S() {
        if (V <= 0) {
            if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
                V = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
            } else {
                V = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
            }
        }
        return V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(boolean z16) {
        boolean z17;
        Object valueOf;
        ArrayList<BlessWording> arrayList;
        boolean z18 = true;
        if (this.f180524e != null && (arrayList = this.f180526h) != null && arrayList.size() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 || !p0() || !z16 || this.f180524e.isDeleted) {
            z18 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initEntrance show=");
        sb5.append(z18);
        sb5.append(" hasConfig=");
        sb5.append(z16);
        sb5.append(" task=");
        sb5.append(this.f180524e);
        sb5.append(" isDeleted=");
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            valueOf = "";
        } else {
            valueOf = Boolean.valueOf(blessTask.isDeleted);
        }
        sb5.append(valueOf);
        QLog.i("BlessManager", 2, sb5.toString());
        if (z18) {
            k0(new a());
        } else {
            x(null);
        }
    }

    private void m0() {
        EntityManager createEntityManager = this.f180523d.getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = (ArrayList) createEntityManager.query(BlessTask.class, new BlessTask().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        if (arrayList != null && arrayList.size() > 0) {
            this.f180524e = (BlessTask) arrayList.get(0);
        }
        this.f180525f = (ArrayList) createEntityManager.query(BlessPtvModule.class, new BlessPtvModule().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        this.f180526h = (ArrayList) createEntityManager.query(BlessWording.class, new BlessWording().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        createEntityManager.close();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initTaskAndModuleFromDB task=");
            BlessTask blessTask = this.f180524e;
            String str = blessTask;
            if (blessTask != null) {
                str = blessTask.toString();
            }
            sb5.append((Object) str);
            sb5.append(" blessWordings=");
            sb5.append(this.f180526h);
            sb5.append(" module=");
            ArrayList<BlessPtvModule> arrayList2 = this.f180525f;
            Object obj = arrayList2;
            if (arrayList2 != null) {
                obj = Integer.valueOf(arrayList2.size());
            }
            sb5.append(obj);
            QLog.d("BlessManager", 2, sb5.toString());
        }
        BlessTask blessTask2 = this.f180524e;
        if (blessTask2 != null) {
            this.H = p(blessTask2, false);
            l0(this.H);
            p(this.f180524e, true);
            return;
        }
        l0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        o.f180597a.v(this.f180523d.getApplicationContext(), this);
    }

    private void n0() {
        Integer valueOf;
        SharedPreferences preferences = this.f180523d.getPreferences();
        this.D = p.g(preferences, 1);
        this.E = p.g(preferences, 2);
        Integer num = null;
        Set<String> a16 = eb.a(preferences, "bless_uin_to_send", null);
        if (a16 != null) {
            this.F = new ArrayList<>(a16);
        } else {
            this.F = new ArrayList<>();
        }
        this.J = preferences.getString("bless_send_wording", null);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initUinSendRecordFromSp sendWording=");
            sb5.append(this.J);
            sb5.append(" uinListToSend=");
            ArrayList<String> arrayList = this.F;
            Object obj = arrayList;
            if (arrayList != null) {
                obj = Integer.valueOf(arrayList.size());
            }
            sb5.append(obj);
            sb5.append(" blessUinList=");
            p pVar = this.D;
            if (pVar == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(pVar.i());
            }
            sb5.append(valueOf);
            sb5.append(" webUinList=");
            p pVar2 = this.E;
            if (pVar2 != null) {
                num = Integer.valueOf(pVar2.i());
            }
            sb5.append(num);
            QLog.d("BlessManager", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0113, code lost:
    
        if (r4 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0119, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011b, code lost:
    
        com.tencent.qphone.base.util.QLog.d("BlessManager", 2, "check Modules and banners all ready");
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0121, code lost:
    
        r0 = r9.f180526h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0123, code lost:
    
        if (r0 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0129, code lost:
    
        if (r0.size() <= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012b, code lost:
    
        r9.H = true;
        l0(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0130, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o() {
        boolean z16;
        if (this.f180524e != null && this.f180525f != null) {
            BlessTask blessTask = this.f180524e;
            boolean z17 = false;
            ArrayList arrayList = new ArrayList(Arrays.asList(blessTask.mainBanner, blessTask.mainCenter, blessTask.typeBanner, blessTask.succeededBanner, blessTask.defaultVoice));
            String str = this.f180524e.recentHeadImgUrl;
            if (str != null) {
                arrayList.add(str);
            }
            String str2 = this.f180524e.recentHeadImgUrlSimple;
            if (str2 != null) {
                arrayList.add(str2);
            }
            String str3 = this.f180524e.ptvAnimationUrl;
            if (str3 != null) {
                arrayList.add(str3);
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    String str4 = (String) it.next();
                    String J = J(str4);
                    if (!TextUtils.isEmpty(str4) && str4.equals(this.f180524e.starVideo)) {
                        J = MD5Utils.encodeHexStr(str4);
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (J == null) {
                        l0(false);
                        return;
                    }
                    if (!TextUtils.isEmpty(J)) {
                        String str5 = this.K + J;
                        if (TextUtils.isEmpty(str5)) {
                            continue;
                        } else if (!new File(str5).exists()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("BlessManager", 2, "checkAllDownloaded no banner: " + str5);
                            }
                        } else if (z16) {
                            String str6 = this.K + this.f180524e.starVideoCoverFolderName + File.separator + this.f180524e.starVideoCoverFileName;
                            if (VersionUtils.isIceScreamSandwich() && !new File(str6).exists()) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("BlessManager", 2, "checkAllDownloaded no cover: " + str5);
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    z17 = true;
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(BlessTask blessTask, boolean z16) {
        ArrayList arrayList;
        boolean z17;
        if (blessTask == null) {
            return false;
        }
        if (z16) {
            arrayList = new ArrayList(Arrays.asList(blessTask.starAvator, blessTask.starVideo));
            if (!TextUtils.isEmpty(blessTask.starAvatorSimple)) {
                arrayList.add(blessTask.starAvatorSimple);
            }
        } else {
            arrayList = new ArrayList(Arrays.asList(blessTask.mainBanner, blessTask.mainCenter, blessTask.typeBanner, blessTask.succeededBanner, blessTask.defaultVoice));
            if (!TextUtils.isEmpty(blessTask.recentHeadImgUrl)) {
                arrayList.add(blessTask.recentHeadImgUrl);
            }
            if (!TextUtils.isEmpty(blessTask.recentHeadImgUrlSimple)) {
                arrayList.add(blessTask.recentHeadImgUrlSimple);
            }
            if (!TextUtils.isEmpty(blessTask.ptvAnimationUrl)) {
                arrayList.add(blessTask.ptvAnimationUrl);
            }
        }
        Iterator it = arrayList.iterator();
        boolean z18 = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            String J = J(str);
            if (!TextUtils.isEmpty(str) && str.equals(blessTask.starVideo)) {
                J = MD5Utils.encodeHexStr(str);
                blessTask.f180570ex1 = J;
                z17 = true;
            } else {
                z17 = false;
            }
            if (J == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("BlessManager", 2, "checkBannersReady error banner: " + str);
                }
                return false;
            }
            String str2 = this.K + J;
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "checkBannersReady: " + str + " urlPath=" + str2 + "  fileName=" + J);
            }
            if (!new File(str2).exists()) {
                y(str, str2);
                if (QLog.isColorLevel()) {
                    QLog.d("BlessManager", 2, "checkBannersReady no banner: " + str2);
                }
            } else if (z17) {
                String str3 = this.K + blessTask.starVideoCoverFolderName + File.separator + blessTask.starVideoCoverFileName;
                if (VersionUtils.isIceScreamSandwich() && !new File(str3).exists()) {
                    u();
                    if (QLog.isColorLevel()) {
                        QLog.d("BlessManager", 2, "checkAllDownloaded no cover: " + str2);
                    }
                }
            }
            z18 = false;
        }
        return z18;
    }

    private boolean q0(String str, String str2) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        Date F = F(str);
        Date F2 = F(str2);
        if (F != null && F2 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "isInTime now=" + serverTimeMillis + "  beginDate.getTime():" + F.getTime() + "  endDate.getTime():" + F2.getTime());
            }
            if (serverTimeMillis > F.getTime() && serverTimeMillis < F2.getTime()) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "not in time" + str + " " + str2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(10)
    public void u() {
        if (VersionUtils.isIceScreamSandwich() && !this.C) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.BlessManager.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessManager.this);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:73:0x0151  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    StringBuilder sb5;
                    Exception e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        BlessManager.this.C = true;
                        String V2 = BlessManager.this.V();
                        if (V2 == null) {
                            BlessManager.this.C = false;
                            return;
                        }
                        if (new File(V2).exists()) {
                            String str = BlessManager.this.K + BlessManager.this.f180524e.starVideoCoverFolderName + File.separator;
                            String str2 = str + BlessManager.this.f180524e.starVideoCoverFileName;
                            File file = new File(str);
                            if (file.exists()) {
                                file.delete();
                            }
                            file.mkdirs();
                            File file2 = new File(str2);
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            BufferedOutputStream bufferedOutputStream = null;
                            try {
                                try {
                                    mediaMetadataRetriever.setDataSource(V2);
                                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                                    if (frameAtTime != null) {
                                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                                        try {
                                            frameAtTime.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream2);
                                            bufferedOutputStream2.flush();
                                            bufferedOutputStream = bufferedOutputStream2;
                                        } catch (Exception e17) {
                                            e = e17;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("BlessManager", 2, "get star video ERROR, e=" + e.getMessage());
                                            }
                                            if (file2.exists()) {
                                                file2.delete();
                                            }
                                            BlessManager.this.o();
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (Exception e18) {
                                                    e16 = e18;
                                                    if (QLog.isColorLevel()) {
                                                        sb5 = new StringBuilder();
                                                        sb5.append("get star video out.close() ERROR, e=");
                                                        sb5.append(e16.getMessage());
                                                        QLog.d("BlessManager", 2, sb5.toString());
                                                    }
                                                }
                                            }
                                            mediaMetadataRetriever.release();
                                            if (QLog.isColorLevel()) {
                                            }
                                            BlessManager.this.C = false;
                                            return;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            BlessManager.this.o();
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (Exception e19) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("BlessManager", 2, "get star video out.close() ERROR, e=" + e19.getMessage());
                                                    }
                                                }
                                            }
                                            mediaMetadataRetriever.release();
                                            throw th;
                                        }
                                    }
                                    BlessManager.this.o();
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (Exception e26) {
                                            e16 = e26;
                                            if (QLog.isColorLevel()) {
                                                sb5 = new StringBuilder();
                                                sb5.append("get star video out.close() ERROR, e=");
                                                sb5.append(e16.getMessage());
                                                QLog.d("BlessManager", 2, sb5.toString());
                                            }
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } catch (Exception e27) {
                                e = e27;
                            }
                            mediaMetadataRetriever.release();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("BlessManager", 2, "get star video finish");
                        }
                        BlessManager.this.C = false;
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }, 5, null, false);
        }
    }

    private void v(BlessTask blessTask) {
        boolean z16;
        if (blessTask == null) {
            return;
        }
        String[] strArr = {blessTask.mainBanner, blessTask.mainCenter, blessTask.typeBanner, blessTask.succeededBanner, blessTask.defaultVoice, blessTask.starAvator, blessTask.starVideo, blessTask.recentHeadImgUrl, blessTask.ptvAnimationUrl, blessTask.starAvatorSimple, blessTask.recentHeadImgUrlSimple};
        File[] listFiles = new File(this.K).listFiles();
        if (listFiles == null) {
            return;
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (!listFiles[i3].getName().endsWith(".zip") && !listFiles[i3].isDirectory()) {
                int i16 = 0;
                boolean z17 = false;
                boolean z18 = false;
                while (true) {
                    if (i16 < 11) {
                        if (!TextUtils.isEmpty(strArr[i16])) {
                            String J = J(strArr[i16]);
                            if (strArr[i16].equals(blessTask.starVideo)) {
                                J = MD5Utils.encodeHexStr(strArr[i16]);
                                z17 = true;
                            } else if (strArr[i16].equals(blessTask.ptvAnimationUrl)) {
                                z18 = true;
                            }
                            if (listFiles[i3].getName().equals(J)) {
                                z16 = false;
                                break;
                            }
                        }
                        i16++;
                    } else {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    listFiles[i3].delete();
                    if (QLog.isColorLevel()) {
                        QLog.d("BlessManager", 2, "deleteOldBanner=" + listFiles[i3].getName());
                    }
                    if (z17) {
                        File file = new File((this.K + blessTask.starVideoCoverFolderName + File.separator) + blessTask.starVideoCoverFileName);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                            if (QLog.isColorLevel()) {
                                QLog.d("BlessManager", 2, "deleteOldCover=" + file.getName());
                            }
                        }
                    }
                    if (z18) {
                        File file2 = new File(P());
                        if (file2.exists() && file2.isDirectory()) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    private boolean v0() {
        String W = W();
        String V2 = V();
        if (W != null && V2 != null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "isStarVideoFileReady() videoCoverPath=" + W + ", videoPath=" + V2);
            return false;
        }
        return false;
    }

    private void w(ArrayList<BlessPtvModule> arrayList) {
        File[] listFiles;
        boolean z16;
        if (arrayList == null || (listFiles = new File(this.K).listFiles()) == null) {
            return;
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (listFiles[i3].getName().endsWith(".zip") && !listFiles[i3].isDirectory()) {
                Iterator<BlessPtvModule> it = arrayList.iterator();
                String str = null;
                while (true) {
                    z16 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    BlessPtvModule next = it.next();
                    String str2 = next.f180535id;
                    if (listFiles[i3].getName().equals(next.f180535id + ".zip")) {
                        if (next.broken) {
                            next.broken = false;
                        } else {
                            z16 = false;
                        }
                        str = str2;
                    } else {
                        str = str2;
                    }
                }
                if (z16) {
                    listFiles[i3].delete();
                    FileUtils.deleteDirectory(this.K + str);
                    if (QLog.isColorLevel()) {
                        QLog.d("BlessManager", 2, "deleteOldModules=" + listFiles[i3].getName());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(IOperateCallback iOperateCallback) {
        o.f180597a.q(iOperateCallback);
    }

    private void y(String str, String str2) {
        if (NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication()) == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "download 2g give up " + str2);
                return;
            }
            return;
        }
        com.tencent.mobileqq.vip.g gVar = this.f180528m.get(str2);
        if (gVar != null) {
            if (gVar.i() != 2 && gVar.i() != 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("BlessManager", 2, "download task status error, cancel it " + str2);
                }
                gVar.c(true);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("BlessManager", 2, "download duplicated " + str2);
                    return;
                }
                return;
            }
        }
        com.tencent.mobileqq.vip.g gVar2 = new com.tencent.mobileqq.vip.g(str, new File(str2));
        gVar2.Q = true;
        com.tencent.mobileqq.vip.h u16 = ((DownloaderFactory) this.f180523d.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "startDownload: " + str + " path=" + str2);
        }
        this.f180528m.put(str2, gVar2);
        u16.startDownload(gVar2, new b(str2, str), null);
    }

    public int A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        this.D.b();
        return a0() - this.D.i();
    }

    public void A0(Set<String> set) {
        BlessTask blessTask;
        Date F;
        Iterator<String> it;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) set);
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it5 = set.iterator();
        String str2 = null;
        BlessTask blessTask2 = null;
        ArrayList<BlessPtvModule> arrayList2 = null;
        ArrayList<BlessWording> arrayList3 = null;
        Date date = null;
        while (it5.hasNext()) {
            String next = it5.next();
            BlessTask blessTask3 = new BlessTask();
            ArrayList<BlessPtvModule> arrayList4 = new ArrayList<>();
            ArrayList<BlessWording> arrayList5 = new ArrayList<>();
            boolean parse = BlessTask.parse(next, blessTask3, arrayList4, arrayList5);
            if (QLog.isColorLevel()) {
                it = it5;
                StringBuilder sb5 = new StringBuilder();
                str = next;
                sb5.append("onNewConfigReceived tmpNewTask=");
                sb5.append(blessTask3);
                sb5.append(" tmpNewBlessWordings=");
                sb5.append(arrayList5.size());
                sb5.append(" tmpNewPtvModules=");
                sb5.append(arrayList4.size());
                sb5.append(" result=");
                sb5.append(parse);
                QLog.d("BlessManager", 2, sb5.toString());
            } else {
                it = it5;
                str = next;
            }
            if (parse) {
                Date F2 = F(blessTask3.entranceBegin);
                Date F3 = F(blessTask3.entranceEnd);
                if (F2 != null && F3 != null && F3.getTime() >= serverTimeMillis && blessTask3.entranceEnabled == 1) {
                    arrayList.add(blessTask3);
                    if (blessTask2 == null || date == null || ((F2.getTime() <= date.getTime() || F2.getTime() <= serverTimeMillis) && (F2.getTime() >= date.getTime() || date.getTime() >= serverTimeMillis))) {
                        date = F2;
                        blessTask2 = blessTask3;
                        arrayList2 = arrayList4;
                        arrayList3 = arrayList5;
                        str2 = str;
                    }
                }
            }
            it5 = it;
        }
        if (str2 != null && blessTask2 != null) {
            C0(str2, blessTask2, arrayList2, arrayList3);
        } else {
            r();
        }
        if (arrayList.size() > 1) {
            if (blessTask2 != null) {
                Date F4 = F(blessTask2.entranceBegin);
                Iterator it6 = arrayList.iterator();
                long j3 = Long.MAX_VALUE;
                BlessTask blessTask4 = null;
                while (it6.hasNext()) {
                    BlessTask blessTask5 = (BlessTask) it6.next();
                    if (blessTask5 != blessTask2 && (F = F(blessTask5.entranceBegin)) != null && F4 != null) {
                        long time = F.getTime() - F4.getTime();
                        if (time > 0 && time < j3) {
                            blessTask4 = blessTask5;
                            j3 = time;
                        }
                    }
                }
                blessTask = blessTask4;
            } else {
                blessTask = null;
            }
            E0(set);
        } else {
            blessTask = null;
        }
        this.f180527i = blessTask;
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "onNewConfigReceived validCount=" + arrayList.size() + "  nextTask:" + this.f180527i);
        }
    }

    public String B(int i3) {
        String J;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                J = null;
            } else {
                J = J(blessTask.succeededBanner);
            }
        } else {
            J = J(blessTask.mainBanner);
        }
        if (J == null) {
            return null;
        }
        return this.K + File.separator + J;
    }

    public void B0(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) context);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Q < 3000) {
            return;
        }
        this.Q = currentTimeMillis;
        String g06 = g0();
        Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
        intent.putExtra("param_force_internal_browser", true);
        intent.putExtra("url", g06);
        WebAccelerator.s(context, intent, g06);
    }

    public void D0(ArrayList<String> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) arrayList, i3);
            return;
        }
        SharedPreferences preferences = this.f180523d.getPreferences();
        if (i3 == 1) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.D.a(it.next());
            }
            p.h(preferences, this.D, 1);
            return;
        }
        if (i3 == 2) {
            Iterator<String> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                this.E.a(it5.next());
            }
            p.h(preferences, this.E, 2);
        }
    }

    public ChatActivityFacade.a E(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return (ChatActivityFacade.a) iPatchRedirector.redirect((short) 77, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        ChatActivityFacade.a aVar = new ChatActivityFacade.a();
        aVar.f175130e = 0;
        if (i3 == 2) {
            aVar.f175131f = 1;
        } else if (i3 == 3) {
            aVar.f175131f = 4;
        } else {
            aVar.f175131f = 0;
        }
        aVar.f175127b = i16;
        return aVar;
    }

    public String G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return "";
        }
        return blessTask.entranceHint;
    }

    public void G0(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        ArrayList<BlessWording> arrayList = this.f180526h;
        if (arrayList == null) {
            return;
        }
        if (i16 == arrayList.size() + 1) {
            i3--;
        }
        if (i3 >= 0 && i3 < this.f180526h.size()) {
            this.f180526h.get(i3).setEditingWording(str);
        }
    }

    public Drawable H() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (Drawable) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.ca5);
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        BlessTask blessTask = this.f180524e;
        if (blessTask != null && (str = blessTask.recentHeadImgUrl) != null) {
            if (this.P == null || this.R != isNowSimpleUI) {
                if (isNowSimpleUI && !TextUtils.isEmpty(blessTask.recentHeadImgUrlSimple)) {
                    str = this.f180524e.recentHeadImgUrlSimple;
                }
                String J = J(str);
                if (!TextUtils.isEmpty(J)) {
                    String str2 = this.K + J;
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    int f16 = BaseAIOUtils.f(50.0f, BaseApplication.getContext().getResources());
                    obtain.mRequestHeight = f16;
                    obtain.mRequestWidth = f16;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    this.P = URLDrawable.getDrawable(new File(str2), obtain);
                }
            }
            Drawable drawable2 = this.P;
            if (drawable2 != null) {
                this.R = isNowSimpleUI;
                drawable = drawable2;
            }
        }
        if (this.f180524e != null && y0()) {
            if (this.N == null || this.R != isNowSimpleUI) {
                BlessTask blessTask2 = this.f180524e;
                String str3 = blessTask2.starAvator;
                if (isNowSimpleUI && !TextUtils.isEmpty(blessTask2.starAvatorSimple)) {
                    str3 = this.f180524e.starAvatorSimple;
                }
                String J2 = J(str3);
                if (!TextUtils.isEmpty(J2)) {
                    String str4 = this.K + J2;
                    URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                    int f17 = BaseAIOUtils.f(50.0f, BaseApplication.getContext().getResources());
                    obtain2.mRequestHeight = f17;
                    obtain2.mRequestWidth = f17;
                    obtain2.mLoadingDrawable = drawable;
                    obtain2.mFailedDrawable = drawable;
                    this.N = URLDrawable.getDrawable(new File(str4), obtain2);
                }
            }
            Drawable drawable3 = this.N;
            if (drawable3 != null) {
                this.R = isNowSimpleUI;
                return drawable3;
            }
            return drawable;
        }
        return drawable;
    }

    public void H0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        ArrayList<BlessWording> arrayList = this.f180526h;
        if (arrayList != null && arrayList.size() > 0 && str.equals(this.f180526h.get(0).wording)) {
            str = "";
        }
        String str2 = this.J;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.J = str;
        SharedPreferences.Editor edit = this.f180523d.getPreferences().edit();
        edit.putString("bless_send_wording", str);
        edit.commit();
    }

    public String I() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (String) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        BlessTask blessTask = this.f180524e;
        if (blessTask != null && (str = blessTask.recentHeadImgUrl) != null && (this.P == null || this.R != isNowSimpleUI)) {
            if (isNowSimpleUI && !TextUtils.isEmpty(blessTask.recentHeadImgUrlSimple)) {
                str = this.f180524e.recentHeadImgUrlSimple;
            }
            String J = J(str);
            if (!TextUtils.isEmpty(J)) {
                return this.K + J;
            }
        }
        return "";
    }

    public String J(String str) {
        String substring;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
        }
        try {
            if (str.startsWith("http://")) {
                substring = str.substring(7, str.length());
            } else if (str.startsWith("https://")) {
                substring = str.substring(8, str.length());
            } else {
                return str;
            }
            int lastIndexOf = substring.lastIndexOf(47);
            if (lastIndexOf == -1) {
                return null;
            }
            int lastIndexOf2 = substring.substring(0, lastIndexOf).lastIndexOf(47);
            if (lastIndexOf2 != -1) {
                lastIndexOf = lastIndexOf2;
            }
            int lastIndexOf3 = substring.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (lastIndexOf3 > lastIndexOf) {
                return substring.substring(lastIndexOf + 1, lastIndexOf3);
            }
            return substring.substring(lastIndexOf + 1);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "getFileNameFromUrl failed: " + str, th5);
            }
            return null;
        }
    }

    public void J0(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
            return;
        }
        this.F.clear();
        this.F.addAll(list);
        eb.c(this.f180523d.getPreferences().edit(), "bless_uin_to_send", list.toArray()).commit();
    }

    public String K() {
        String J;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null || (J = J(blessTask.mainCenter)) == null) {
            return null;
        }
        return this.K + File.separator + J;
    }

    public void K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask != null && !blessTask.isDeleted) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BlessManager", 4, "update task to db isDeleted");
            }
            this.f180524e.isDeleted = true;
            EntityManager createEntityManager = this.f180523d.getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = createEntityManager.getTransaction();
            try {
                try {
                    transaction.begin();
                    createEntityManager.update(this.f180524e);
                    transaction.commit();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                transaction.end();
                createEntityManager.close();
                l0(false);
            } catch (Throwable th5) {
                transaction.end();
                throw th5;
            }
        }
    }

    public int L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Integer) iPatchRedirector.redirect((short) 76, (Object) this)).intValue();
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return 2000;
        }
        return blessTask.ptvAnimationCost;
    }

    public void L0(MessageForShortVideo messageForShortVideo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) messageForShortVideo);
            return;
        }
        this.M = messageForShortVideo;
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "setPtvMessage: " + messageForShortVideo);
        }
    }

    public int M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Integer) iPatchRedirector.redirect((short) 75, (Object) this)).intValue();
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return 1;
        }
        return blessTask.ptvAnimationCount;
    }

    public void M0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
            return;
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return;
        }
        if (z16) {
            if (blessTask.unread == 0) {
                return;
            }
        } else {
            blessTask.videoPlayed = true;
        }
        if (blessTask.unread != -1 || blessTask.videoPlayed) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BlessManager", 4, "update task to db read=" + this.f180524e.unread + " videoPlayed=" + this.f180524e.videoPlayed);
            }
            this.f180524e.unread = -1;
            o.f180597a.t();
            EntityManager createEntityManager = this.f180523d.getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = createEntityManager.getTransaction();
            try {
                try {
                    transaction.begin();
                    createEntityManager.update(this.f180524e);
                    transaction.commit();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                transaction.end();
                createEntityManager.close();
            } catch (Throwable th5) {
                transaction.end();
                throw th5;
            }
        }
    }

    public String N() {
        String J;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (String) iPatchRedirector.redirect((short) 73, (Object) this);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null || TextUtils.isEmpty(blessTask.ptvAnimationUrl) || (J = J(this.f180524e.ptvAnimationUrl)) == null) {
            return "";
        }
        return this.K + File.separator + J;
    }

    public void N0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    public Boolean O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (Boolean) iPatchRedirector.redirect((short) 72, (Object) this);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(blessTask.ptvAnimationSwtich);
    }

    public String P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (String) iPatchRedirector.redirect((short) 74, (Object) this);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null || TextUtils.isEmpty(blessTask.ptvAnimationUrl)) {
            return "";
        }
        String N = N();
        if (!N.endsWith(".zip")) {
            return "";
        }
        return N.substring(0, N.length() - 4) + File.separator;
    }

    public MessageForShortVideo Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (MessageForShortVideo) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        MessageForShortVideo messageForShortVideo = this.M;
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "getPtvMessage: " + messageForShortVideo);
        }
        return messageForShortVideo;
    }

    public String R(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (String) iPatchRedirector.redirect((short) 79, (Object) this, (Object) str, (Object) str2);
        }
        return (U() + "&uuid=" + str + "&md5=" + str2 + "&nick=") + PluginBaseInfoHelper.Base64Helper.encodeToString(this.f180523d.getCurrentNickname().getBytes(), 2);
    }

    public String T(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (String) iPatchRedirector.redirect((short) 71, (Object) this, z16);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return "";
        }
        if (z16) {
            return blessTask.shareQzoneTitle;
        }
        return blessTask.shareWeixinTitle;
    }

    public String U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask != null && !TextUtils.isEmpty(blessTask.shareUrl)) {
            return this.f180524e.shareUrl;
        }
        return "https://wa.qq.com/qfzf/index.html?_wv=16777217&adtag=main";
    }

    public String V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        if (this.f180524e == null) {
            return null;
        }
        String str = this.K + J(this.f180524e.f180570ex1);
        File file = new File(str);
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "getStarVideoPath: " + str);
        }
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "getStarVideoPath: " + str + " not exist");
            }
            return null;
        }
        return str;
    }

    public String W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (String) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        if (this.f180524e == null) {
            return null;
        }
        String str = this.K + this.f180524e.starVideoCoverFolderName + File.separator + this.f180524e.starVideoCoverFileName;
        if (!new File(str).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessManager", 2, "getStartVideoCoverPath: " + str + " not exist");
            }
            return null;
        }
        return str;
    }

    public BlessTask X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (BlessTask) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.f180524e;
    }

    public int Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return 100;
        }
        return blessTask.sendTotalLimit;
    }

    public int a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return 100;
        }
        return blessTask.uinTotalLimit;
    }

    public ArrayList<String> b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ArrayList) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.F;
    }

    public int c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null) {
            return -1;
        }
        int i3 = blessTask.unread;
        if (i3 > 1) {
            return 1;
        }
        return i3;
    }

    public int d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null || blessTask.unread < 1) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "getUnreadNum=1");
        }
        return 1;
    }

    public int e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }
        this.E.b();
        int h06 = h0();
        if (h06 > 0) {
            return h06 - this.E.e();
        }
        return h06;
    }

    public int f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this)).intValue();
        }
        this.E.b();
        return i0() - this.E.i();
    }

    public String g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (String) iPatchRedirector.redirect((short) 78, (Object) this);
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask != null && !TextUtils.isEmpty(blessTask.webBlessUrl)) {
            return this.f180524e.webBlessUrl;
        }
        return "https://ti.qq.com/mass-blessing/index.html?_wv=16777223";
    }

    public int h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this)).intValue();
        }
        return 100;
    }

    public int i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this)).intValue();
        }
        return 30;
    }

    public ArrayList<String> j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (ArrayList) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(this.J)) {
            arrayList.add(this.J);
        }
        ArrayList<BlessWording> arrayList2 = this.f180526h;
        if (arrayList2 != null) {
            Iterator<BlessWording> it = arrayList2.iterator();
            while (it.hasNext()) {
                BlessWording next = it.next();
                if (next.hasEditingWording()) {
                    arrayList.add(next.getEditingWording());
                } else {
                    arrayList.add(next.wording);
                }
            }
        }
        return arrayList;
    }

    public void k0(o.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            o.f180597a.k(aVar);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        com.tencent.mobileqq.vip.h u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        DownloaderFactory downloaderFactory = (DownloaderFactory) this.f180523d.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        if (downloaderFactory != null && (u16 = downloaderFactory.u(1)) != null) {
            u16.cancelTask(true, null);
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.T);
    }

    public boolean p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f180524e == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "isEntranceTime");
        }
        BlessTask blessTask = this.f180524e;
        if (!q0(blessTask.entranceBegin, blessTask.entranceEnd) || this.f180524e.entranceEnabled != 1) {
            return false;
        }
        return true;
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "check entrance.  nextTask:" + this.f180527i);
        }
        if (!p0()) {
            x(null);
        }
        BlessTask blessTask = this.f180527i;
        if (blessTask != null && q0(blessTask.entranceBegin, blessTask.entranceEnd) && this.f180527i.entranceEnabled == 1 && !this.S) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.T);
            ThreadManager.getSubThreadHandler().post(this.T);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "clearBlessConfigs");
        }
        E0(null);
        I0(null, null, null);
        l0(false);
    }

    public boolean r0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        BlessTask blessTask = this.f180524e;
        if (blessTask == null || blessTask.ptvEnabled != 1) {
            return true;
        }
        return false;
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        ArrayList<BlessWording> arrayList = this.f180526h;
        if (arrayList != null) {
            Iterator<BlessWording> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setEditingWording(null);
            }
        }
    }

    public boolean s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f180524e == null) {
            return false;
        }
        boolean equals = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.BlessPTVEnable.name()).equals("1");
        boolean supportShortVideoRecordAndPlay = VideoEnvironment.supportShortVideoRecordAndPlay();
        boolean isX86Platform = VideoEnvironment.isX86Platform();
        boolean isBeautySupported = AVCoreSystemInfo.isBeautySupported();
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "isPTVEnabled task=" + this.f180524e.ptvEnabled + " ptvRecord=" + supportShortVideoRecordAndPlay + " isX86=" + isX86Platform + " frontCamera=true");
        }
        if (this.f180524e.ptvEnabled != 1 || !supportShortVideoRecordAndPlay || isX86Platform || !isBeautySupported || equals) {
            return false;
        }
        return true;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.F.clear();
            eb.c(this.f180523d.getPreferences().edit(), "bless_uin_to_send", new String[0]).commit();
        }
    }

    public boolean t0() {
        boolean z16;
        ArrayList<BlessPtvModule> arrayList;
        ArrayList<BlessWording> arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f180524e != null && (arrayList = this.f180525f) != null && arrayList.size() > 0 && (arrayList2 = this.f180526h) != null && arrayList2.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && p0() && this.H) {
            return true;
        }
        return false;
    }

    public boolean u0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f180524e == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "isStarTime");
        }
        BlessTask blessTask = this.f180524e;
        return q0(blessTask.starBegin, blessTask.starEnd);
    }

    public boolean w0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str)).booleanValue();
        }
        this.D.b();
        return this.D.d(str);
    }

    public boolean x0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.G;
    }

    public boolean y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        if (this.f180524e == null || !VersionUtils.isIceScreamSandwich() || this.f180524e.videoPlayed || !u0() || !v0()) {
            return false;
        }
        return true;
    }

    public int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        this.D.b();
        int Y = Y();
        if (Y > 0) {
            return Y - this.D.e();
        }
        return Y;
    }

    public boolean z0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this, (Object) str)).booleanValue();
        }
        this.E.b();
        return this.E.d(str);
    }
}
