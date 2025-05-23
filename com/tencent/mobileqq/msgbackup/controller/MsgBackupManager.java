package com.tencent.mobileqq.msgbackup.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthHandler;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKickApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationAvailableContact;
import com.tencent.qqnt.kernel.nativeinterface.IDataMigrationGetAvailableContactListCallback;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupManager implements com.tencent.mobileqq.msgbackup.controller.c {
    static IPatchRedirector $redirector_;
    private static final String B;
    public static boolean C;
    public static String D;
    public static String E;
    public static String F;
    public static ConcurrentHashMap<String, String> G;
    public static boolean H;
    public static int I;
    private static volatile MsgBackupManager J;
    public static int K;
    public static String L;
    public static int M;
    public static boolean N;
    public static volatile boolean O;
    public static boolean P;
    public static boolean Q;
    public static boolean R;
    private com.tencent.mobileqq.msgbackup.controller.b A;

    /* renamed from: a, reason: collision with root package name */
    public HashSet<com.tencent.mobileqq.msgbackup.data.j> f251037a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, com.tencent.mobileqq.msgbackup.data.h> f251038b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap<String, com.tencent.mobileqq.msgbackup.data.h> f251039c;

    /* renamed from: d, reason: collision with root package name */
    public CopyOnWriteArraySet<Long> f251040d;

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap<Long, c.b> f251041e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<Long, c.b> f251042f;

    /* renamed from: g, reason: collision with root package name */
    public ConcurrentHashMap<Long, com.tencent.mobileqq.msgbackup.data.i> f251043g;

    /* renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap<Long, com.tencent.mobileqq.msgbackup.data.i> f251044h;

    /* renamed from: i, reason: collision with root package name */
    private BaseQQAppInterface f251045i;

    /* renamed from: j, reason: collision with root package name */
    private MsgBackupController f251046j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f251047k;

    /* renamed from: l, reason: collision with root package name */
    private IKickApi.a f251048l;

    /* renamed from: m, reason: collision with root package name */
    private KickedInfo f251049m;

    /* renamed from: n, reason: collision with root package name */
    private MsgBackupTransportProcessor f251050n;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.mobileqq.msgbackup.authentication.a f251051o;

    /* renamed from: p, reason: collision with root package name */
    private String f251052p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.mobileqq.msgbackup.data.d f251053q;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f251054r;

    /* renamed from: s, reason: collision with root package name */
    protected com.tencent.mobileqq.msgbackup.authentication.b f251055s;

    /* renamed from: t, reason: collision with root package name */
    private e f251056t;

    /* renamed from: u, reason: collision with root package name */
    private long f251057u;

    /* renamed from: v, reason: collision with root package name */
    private int f251058v;

    /* renamed from: w, reason: collision with root package name */
    private int f251059w;

    /* renamed from: x, reason: collision with root package name */
    private int f251060x;

    /* renamed from: y, reason: collision with root package name */
    private com.tencent.mobileqq.msgbackup.controller.a f251061y;

    /* renamed from: z, reason: collision with root package name */
    public e f251062z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends com.tencent.mobileqq.msgbackup.authentication.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupManager.this);
            }
        }

        @Override // com.tencent.mobileqq.msgbackup.authentication.b
        public void c(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            super.c(z16, obj);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onGetQrResponse: " + obj + ", isSuccess: " + z16);
            }
            if (z16 && (obj instanceof com.tencent.mobileqq.msgbackup.data.d)) {
                MsgBackupManager.this.f251053q = (com.tencent.mobileqq.msgbackup.data.d) obj;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements IKickApi.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupManager.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.IKickApi.a
        public boolean a(@Nullable KickedInfo kickedInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) kickedInfo)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "mInterceptKickListener#onInterceptKicked mInMsgBackupState:" + MsgBackupManager.this.f251047k.get());
            }
            if (MsgBackupManager.this.f251047k.get()) {
                MsgBackupManager.this.f251049m = kickedInfo;
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupManager.this);
            }
        }

        @Override // com.tencent.mobileqq.msgbackup.controller.e
        public void C8(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
        }

        @Override // com.tencent.mobileqq.msgbackup.controller.e
        public void K8(long j3) {
            String string;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "speedState!!! increment = " + j3);
            }
            MsgBackupManager.this.f251057u = j3;
            int i3 = MsgBackupManager.this.f251059w;
            if (i3 != MsgBackupManager.K) {
                i3++;
            }
            if (MsgBackupManager.this.f251060x == 1) {
                string = BaseApplication.getContext().getString(R.string.ik_);
                str = i3 + "/" + MsgBackupManager.K;
            } else if (MsgBackupManager.this.f251060x == 3) {
                string = BaseApplication.getContext().getResources().getString(R.string.ikb);
                str = i3 + "/" + MsgBackupManager.K;
            } else {
                string = BaseApplication.getContext().getResources().getString(R.string.ikb);
                str = i3 + "/" + MsgBackupManager.K;
            }
            MsgBackupManager.this.c0(com.tencent.mobileqq.msgbackup.authentication.a.d().b(), String.format(string, str, com.tencent.mobileqq.msgbackup.util.f.p(MsgBackupManager.this.f251057u) + "B/S"));
        }

        @Override // com.tencent.mobileqq.msgbackup.controller.e
        public void cb(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
                return;
            }
            com.tencent.mobileqq.msgbackup.util.f.B("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", Boolean.valueOf(z16));
            com.tencent.mobileqq.msgbackup.util.e.f();
            com.tencent.mobileqq.msgbackup.util.e.j(null, "total_transport_cost");
        }

        @Override // com.tencent.mobileqq.msgbackup.controller.e
        public void hd(int i3, int i16) {
            int i17;
            String string;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == i16) {
                com.tencent.mobileqq.msgbackup.util.e.j("total_transport_cost", null);
                com.tencent.mobileqq.msgbackup.util.e.k();
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + i3 + ", totalSession" + i16);
            }
            MsgBackupManager.this.f251058v = i16;
            MsgBackupManager.this.f251059w = i3;
            if (i3 != i16) {
                i17 = i3 + 1;
            } else {
                i17 = i3;
            }
            if (MsgBackupManager.this.f251060x == 1) {
                string = BaseApplication.getContext().getResources().getString(R.string.ik_);
                str = i17 + "/" + MsgBackupManager.K;
            } else if (MsgBackupManager.this.f251060x == 3) {
                string = BaseApplication.getContext().getResources().getString(R.string.ikb);
                str = i17 + "/" + MsgBackupManager.K;
            } else {
                string = BaseApplication.getContext().getResources().getString(R.string.ikb);
                str = i17 + "/" + MsgBackupManager.K;
            }
            String format = String.format(string, str, com.tencent.mobileqq.msgbackup.util.f.p(MsgBackupManager.this.f251057u) + "B/s");
            int b16 = com.tencent.mobileqq.msgbackup.authentication.a.d().b();
            if (i3 == i16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
                }
                MsgBackupManager.t();
                MsgBackupManager.this.B(QBaseActivity.sTopActivity, b16);
                return;
            }
            MsgBackupManager.this.c0(b16, format);
        }

        @Override // com.tencent.mobileqq.msgbackup.controller.e
        public void qc(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }

        @Override // com.tencent.mobileqq.msgbackup.controller.e
        public void qd(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements IDataMigrationGetAvailableContactListCallback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupManager.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IDataMigrationGetAvailableContactListCallback
        public void onResult(int i3, String str, ArrayList<DataMigrationAvailableContact> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList);
                return;
            }
            if (MsgBackupManager.this.A != null) {
                QLog.e("MsgBackup.BackupAndMigrateManager", 1, "contactList " + arrayList.isEmpty() + " num: " + arrayList.size());
                ArrayList arrayList2 = new ArrayList();
                Iterator<DataMigrationAvailableContact> it = arrayList.iterator();
                while (it.hasNext()) {
                    DataMigrationAvailableContact next = it.next();
                    com.tencent.mobileqq.msgbackup.data.j jVar = new com.tencent.mobileqq.msgbackup.data.j();
                    jVar.j(next.getPeerUid());
                    jVar.h(next.getChatType());
                    jVar.i(next.getPeerName());
                    jVar.g(next.getAvatarPath());
                    jVar.l(next.getRemark());
                    String p16 = MsgBackupManager.this.f251046j.p(next.getPeerUid());
                    if (next.getChatType() == 2) {
                        jVar.k(next.getPeerUid());
                    } else {
                        jVar.k(p16);
                    }
                    if (jVar.d() != null && !Objects.equals(jVar.d(), "") && com.tencent.relation.common.utils.j.b("MsgBackup.BackupAndMigrateManager", jVar.d()) > 0) {
                        jVar.m(MsgBackupManager.this.f251046j.q(next.getChatType()));
                        arrayList2.add(jVar);
                    } else {
                        QLog.d("MsgBackup.BackupAndMigrateManager", 1, "delItem peerName: " + next.getPeerName() + ",uid: " + next.getPeerUid() + ",uin: " + jVar.d() + ",chatType: " + next.getChatType());
                    }
                }
                MsgBackupManager.this.A.a(arrayList2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22100);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
            return;
        }
        B = MsgBackupAuthHandler.class.getName();
        C = false;
        G = new ConcurrentHashMap<>();
        H = false;
        I = 0;
        J = null;
        K = 0;
        N = false;
        O = false;
        P = false;
        Q = true;
    }

    MsgBackupManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251037a = new HashSet<>();
        this.f251038b = com.tencent.mobileqq.msgbackup.util.b.a();
        this.f251039c = com.tencent.mobileqq.msgbackup.util.b.a();
        this.f251040d = new CopyOnWriteArraySet<>();
        this.f251041e = new ConcurrentHashMap<>();
        this.f251042f = new ConcurrentHashMap<>();
        this.f251043g = com.tencent.mobileqq.msgbackup.util.b.a();
        this.f251044h = com.tencent.mobileqq.msgbackup.util.b.a();
        this.f251047k = new AtomicBoolean();
        this.f251054r = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.f251055s = new a();
        this.f251056t = new c();
        this.f251057u = 0L;
        this.f251059w = 0;
        this.f251060x = 3;
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.f251045i = baseQQAppInterface;
        this.f251052p = baseQQAppInterface.getCurrentUin();
        this.f251046j = new MsgBackupController(this.f251045i);
        this.f251050n = MsgBackupTransportProcessor.u();
        R = true;
    }

    private boolean C() {
        if (this.f251049m != null) {
            return true;
        }
        return false;
    }

    private void L(int i3) {
        com.tencent.mobileqq.msgbackup.controller.a aVar;
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aFailed: " + i3);
        }
        if (i3 == 6 && (aVar = this.f251061y) != null) {
            aVar.a();
        }
    }

    private void M(com.tencent.mobileqq.msgbackup.data.a aVar) {
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: data is null!");
                return;
            }
            return;
        }
        String b16 = aVar.b();
        String c16 = aVar.c();
        int a16 = aVar.a();
        List<Integer> f16 = aVar.d().f();
        if (f16.size() == 2) {
            String b17 = aVar.d().b();
            int intValue = f16.get(0).intValue();
            int intValue2 = f16.get(1).intValue();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "pc\u7aef\u5df2\u7ecf\u786e\u8ba4\u4e86\uff0c\u5ba2\u6237\u7aef\u6536\u5230\u4e860x11a\u7684push\u4e86--------> bizType= " + a16);
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: client ip = " + b17 + ", udpport = " + intValue2 + ", tcpport = " + intValue);
            }
            MsgBackupTransportProcessor z16 = z();
            z16.P0(b16);
            y().j(c16);
            y().h(a16);
            z16.L0(b17);
            z16.M0(intValue);
            z16.N0(intValue2);
            if (a16 == 1) {
                z16.O0(2);
                z16.R0(2);
            } else if (a16 == 2) {
                z16.O0(1);
                z16.R0(1);
            }
            Intent intent = new Intent();
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup.BackupAndMigrateManager", "activity is null! please check whether is assigned!", new Object[0]);
            } else {
                QPublicFragmentActivity.startForResult(qBaseActivity, intent, (Class<? extends QPublicBaseFragment>) MsgBackupPCConfirmFragment.class, 1000);
            }
        }
    }

    public static void t() {
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar <=======");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            MqqHandler u16 = u((BaseQQAppInterface) peekAppRuntime);
            if (u16 != null) {
                u16.sendMessage(u16.obtainMessage(Conversation.MSG_MSG_MEMROY_BAR_HIDE));
                MsgBackupTransportProcessor.u().Q0(null);
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar: send msg MSG_MUSIC_PLAYER_HIDE");
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar app = null!");
        }
    }

    public static MqqHandler u(BaseQQAppInterface baseQQAppInterface) {
        return ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).getConversationHandler(baseQQAppInterface);
    }

    public static MsgBackupManager x() {
        if (J == null) {
            synchronized (MsgBackupManager.class) {
                if (J == null) {
                    J = new MsgBackupManager();
                }
            }
        }
        return J;
    }

    public com.tencent.mobileqq.msgbackup.data.d A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.mobileqq.msgbackup.data.d) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f251053q;
    }

    public void B(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) context, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar----------> bizType = " + i3 + ", hasFinishedCount = " + this.f251059w + ", sessionCount = " + K);
        }
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "gotoSpecialPage------------------");
            }
            int i16 = this.f251058v;
            int i17 = this.f251059w;
            if (i16 == i17) {
                MsgBackupCompleteFragment.Fh(context, i16, i17);
                return;
            } else {
                MsgBackupPcBaseFragment.Hh(context, i3);
                return;
            }
        }
        if (i3 == 3) {
            Intent intent = new Intent();
            if (this.f251058v == this.f251059w) {
                if (MsgBackupTransportProcessor.u().x() == 2) {
                    MsgBackupCompleteFragment.Bh(context, this.f251058v, this.f251059w);
                    return;
                } else {
                    MsgBackupCompleteFragment.xh(context, this.f251058v, this.f251059w);
                    return;
                }
            }
            intent.putExtra("param_start", 5);
            QPublicFragmentActivity.start(context, intent, MsgBackupTransportFragment.class);
            return;
        }
        int i18 = this.f251058v;
        int i19 = this.f251059w;
        if (i18 == i19) {
            MsgBackupCompleteFragment.zh(context, i18, i19);
        } else {
            MsgBackupPcBaseFragment.Hh(context, i3);
        }
    }

    public void D(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) activity);
            return;
        }
        try {
            activity.getWindow().addFlags(128);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgBackup.BackupAndMigrateManager", 2, "acquireBrightWakeLock:" + e16.toString());
            }
        }
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e("MsgBackup.BackupAndMigrateManager", 1, "kernelMsgService is null!");
        } else {
            QLog.d("MsgBackup.BackupAndMigrateManager", 1, "ntLoadAllMsgTableData");
            e16.dataMigrationGetDataAvaiableContactList(new d());
        }
    }

    public void F(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        com.tencent.mobileqq.msgbackup.util.d.a();
        I();
        synchronized (MsgBackupManager.class) {
            N();
        }
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onBackupEnd: msg backup is end, hasPendingKickMsg:" + C());
        }
        this.f251047k.set(false);
        if (C()) {
            ((IKickApi) QRoute.api(IKickApi.class)).setKickInterceptor(null);
            ((IKickApi) QRoute.api(IKickApi.class)).kick(this.f251049m);
            this.f251049m = null;
        }
        ((IKickApi) QRoute.api(IKickApi.class)).setKickInterceptor(null);
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onBackupStart: msg backup is start");
        }
        this.f251047k.set(true);
        this.f251049m = null;
        if (this.f251048l == null) {
            this.f251048l = new b();
        }
        ((IKickApi) QRoute.api(IKickApi.class)).setKickInterceptor(this.f251048l);
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup.BackupAndMigrateManager", "onDestory ......", new Object[0]);
        this.f251050n.O();
        p();
        H = false;
        this.f251046j.w();
        com.tencent.mobileqq.msgbackup.util.d.d();
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.msgbackup.util.f.D("MsgBackup.BackupAndMigrateManager", "onDestory .....deleteMsgBackupFiles.", new Object[0]);
                    MsgBackupManager.this.s();
                }
            }
        });
    }

    public void J(com.tencent.mobileqq.msgbackup.data.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) fVar);
            return;
        }
        if (H) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11b: now is phone to phone transfer, so please wait the transfer done!");
            }
        } else if (fVar != null) {
            N = true;
            Intent intent = new Intent();
            int a16 = fVar.a();
            y().h(a16);
            String b16 = fVar.b();
            y().i(b16);
            intent.putExtra("0x11bpush_extra", b16);
            intent.putExtra("BIZ_TYPE", a16);
            intent.addFlags(268435456);
            QPublicFragmentActivity.start(BaseApplication.getContext(), intent, MsgBackupPCConfirmFragment.class);
        }
    }

    public void K(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, obj);
            return;
        }
        if (obj instanceof com.tencent.mobileqq.msgbackup.data.a) {
            com.tencent.mobileqq.msgbackup.data.a aVar = (com.tencent.mobileqq.msgbackup.data.a) obj;
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11a: " + aVar);
            }
            M(aVar);
            return;
        }
        if (obj instanceof Integer) {
            L(((Integer) obj).intValue());
        }
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f251046j.C();
        R = false;
        J = null;
    }

    public void O(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) activity);
            return;
        }
        try {
            activity.getWindow().clearFlags(128);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgBackup.BackupAndMigrateManager", 2, "acquireBrightWakeLock:" + e16.toString());
            }
        }
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.f251045i.removeObserver(this.f251055s);
        }
    }

    public void Q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else if (str != null) {
            ((MsgBackupAuthHandler) this.f251045i.getBusinessHandler(B)).N2(str);
        }
    }

    public void R(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iVar);
        } else {
            if (iVar == null) {
                return;
            }
            iVar.f251080h = this;
            this.f251046j.I(iVar, -1);
        }
    }

    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.mobileqq.msgbackup.util.f.B("MsgBackup.BackupAndMigrateManager", "sFileMeta = %s", D);
        TextUtils.isEmpty(D);
        ((MsgBackupAuthHandler) this.f251045i.getBusinessHandler(B)).O2(D);
    }

    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            ((MsgBackupAuthHandler) this.f251045i.getBusinessHandler(B)).P2();
        }
    }

    public void U(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iVar);
        } else {
            if (iVar == null) {
                return;
            }
            iVar.f251080h = this;
            this.f251046j.I(iVar, 10000);
        }
    }

    public void V(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iVar);
        } else {
            if (iVar == null) {
                return;
            }
            iVar.f251080h = this;
            this.f251046j.I(iVar, 10001);
        }
    }

    public void W(com.tencent.mobileqq.msgbackup.controller.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) aVar);
        } else {
            this.f251061y = aVar;
        }
    }

    public void X(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) eVar);
        } else {
            this.f251062z = eVar;
        }
    }

    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        }
    }

    public void Z(com.tencent.mobileqq.msgbackup.controller.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) bVar);
        } else {
            this.A = bVar;
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.c
    public void a(i iVar, Object obj) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) iVar, obj);
            return;
        }
        int i3 = iVar.f251074b;
        if (i3 == 0) {
            if (obj != null && (obj instanceof com.tencent.mobileqq.msgbackup.data.h)) {
                com.tencent.mobileqq.msgbackup.data.h hVar = (com.tencent.mobileqq.msgbackup.data.h) obj;
                File file = new File(com.tencent.mobileqq.msgbackup.util.f.s(hVar.f251142a, com.tencent.mobileqq.msgbackup.util.f.q(hVar.f251143b), hVar.f251144c));
                if (!file.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! file is not exist!");
                        return;
                    }
                    return;
                }
                hVar.f251145d = file.length();
                this.f251038b.put(com.tencent.mobileqq.msgbackup.util.f.t(hVar.f251142a, com.tencent.mobileqq.msgbackup.util.f.q(hVar.f251143b)), hVar);
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! result = 0, sessionInfo.uin = " + hVar.f251142a);
                }
                z().J0(257);
                return;
            }
            return;
        }
        if (i3 == 2 && (eVar = this.f251062z) != null) {
            eVar.qd(iVar.f251079g + 1, iVar.f251078f);
        }
    }

    public void a0(long j3, int i3, int i16, QBaseActivity qBaseActivity) {
        String string;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), qBaseActivity);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar----------> bizType = " + i16 + ", finishedCount" + i3 + ", sessionCount = " + K);
        }
        int i17 = K;
        this.f251058v = i17;
        this.f251060x = i16;
        this.f251057u = j3;
        this.f251059w = i3;
        if (i3 != i17) {
            i3++;
        }
        MqqHandler u16 = u(this.f251045i);
        if (u16 != null) {
            Message obtainMessage = u16.obtainMessage(Conversation.MSG_MSG_MEMROY_BAR_SHOW);
            if (i16 == 1) {
                string = BaseApplication.getContext().getString(R.string.ik_);
                str = i3 + "/" + K;
            } else if (i16 == 3) {
                string = BaseApplication.getContext().getResources().getString(R.string.ikb);
                str = i3 + "/" + K;
            } else {
                string = BaseApplication.getContext().getResources().getString(R.string.ikb);
                str = i3 + "/" + K;
            }
            obtainMessage.obj = String.format(string, str, com.tencent.mobileqq.msgbackup.util.f.p(j3) + "B/s");
            obtainMessage.arg1 = i16;
            com.tencent.mobileqq.msgbackup.authentication.a.d().h(i16);
            u16.sendMessage(obtainMessage);
            MsgBackupTransportProcessor.u().Q0(null);
            MsgBackupTransportProcessor.u().Q0(this.f251056t);
            ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).gotoConversation(qBaseActivity);
            qBaseActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.c
    public void b(int i3, i iVar, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), iVar, obj);
        } else {
            int i16 = iVar.f251074b;
        }
    }

    public void b0(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = 1;
        } else {
            this.f251053q = null;
            this.f251045i.addObserver(this.f251055s);
            i3 = 3;
        }
        y().h(i3);
        this.f251050n.W0(this.f251052p, z16);
    }

    public void c0(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory update msgtab bar----------> content = " + str + "., bizType = " + i3);
        }
        MqqHandler u16 = u(this.f251045i);
        if (u16 != null) {
            Message obtainMessage = u16.obtainMessage(Conversation.MSG_MSG_MEMROY_BAR_SHOW);
            obtainMessage.obj = str;
            obtainMessage.arg1 = i3;
            u16.sendMessage(obtainMessage);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f251037a.clear();
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        D = null;
        E = null;
        F = null;
        G.clear();
        I = 0;
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "clearSessionData ->>>>>>>>>>");
        }
        K = 0;
        L = null;
        M = 0;
        this.f251038b.clear();
        this.f251040d.clear();
        this.f251041e.clear();
        this.f251042f.clear();
        this.f251043g.clear();
        this.f251044h.clear();
        N = false;
        this.f251053q = null;
        P();
        P = false;
    }

    public void q(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) str);
        } else {
            this.f251050n.i(this.f251052p, i3, str);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.f251050n.V0(this.f251052p);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            com.tencent.mobileqq.msgbackup.util.f.h();
        }
    }

    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Long) iPatchRedirector.redirect((short) 33, (Object) this)).longValue();
        }
        return this.f251057u;
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.f251059w;
    }

    public com.tencent.mobileqq.msgbackup.authentication.a y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.msgbackup.authentication.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f251051o == null) {
            this.f251051o = com.tencent.mobileqq.msgbackup.authentication.a.d();
        }
        return this.f251051o;
    }

    public MsgBackupTransportProcessor z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsgBackupTransportProcessor) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f251050n == null) {
            this.f251050n = MsgBackupTransportProcessor.u();
        }
        return this.f251050n;
    }
}
