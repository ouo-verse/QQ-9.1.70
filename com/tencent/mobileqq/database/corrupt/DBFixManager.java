package com.tencent.mobileqq.database.corrupt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$DBFix;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.msg.f;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DBFixManager implements Manager {
    static IPatchRedirector $redirector_;
    public static String C;
    public static String D;
    public static String E;
    public static int F;
    public static String G;
    public static String H;
    public static String I;
    public static String J;
    public static long K;
    public static boolean L;
    public static int M;
    public static int N;
    public static String P;
    public static String Q;
    public static String R;
    public static String S;
    public static String T;
    public static String U;
    public static String V;
    public static int W;
    public static int X;
    public static int Y;
    public static String Z;

    /* renamed from: a0, reason: collision with root package name */
    public static String f203260a0;

    /* renamed from: b0, reason: collision with root package name */
    public static String f203261b0;

    /* renamed from: c0, reason: collision with root package name */
    public static String f203262c0;

    /* renamed from: d0, reason: collision with root package name */
    public static String f203263d0;

    /* renamed from: e0, reason: collision with root package name */
    public static String f203264e0;

    /* renamed from: f0, reason: collision with root package name */
    public static String f203265f0;

    /* renamed from: g0, reason: collision with root package name */
    public static volatile int f203266g0;

    /* renamed from: h0, reason: collision with root package name */
    public static volatile FrequencyControlField$DBFix f203267h0;

    /* renamed from: i, reason: collision with root package name */
    private static String f203268i;

    /* renamed from: i0, reason: collision with root package name */
    public static volatile boolean f203269i0;

    /* renamed from: j0, reason: collision with root package name */
    public static volatile boolean f203270j0;

    /* renamed from: m, reason: collision with root package name */
    public static String f203271m;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f203272d;

    /* renamed from: e, reason: collision with root package name */
    Context f203273e;

    /* renamed from: f, reason: collision with root package name */
    String f203274f;

    /* renamed from: h, reason: collision with root package name */
    private MMKVOptionEntity f203275h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71415);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        f203268i = "DBFix";
        f203271m = "dbfix";
        C = "dbfix_config";
        D = "dbfix_flag";
        E = "dbfix_count";
        F = 5;
        G = "dbfix_nt_flag";
        H = "dbfix_nt_count";
        I = "dbfix_nt_db_size";
        J = "dbfix_nt_db_path";
        K = -1L;
        L = false;
        M = 0;
        N = 5;
        P = "key_dbfixso_load_count";
        Q = "dbcorrupt_flag";
        R = "dbcorrupt_report_fix_zero";
        S = "dbcorrupt_report_fix_succ";
        T = "dbcorrupt_report_fix_fail";
        U = "dbcorrupt_report_fix_other";
        V = "fix_fail_reason";
        W = 1;
        X = 2;
        Y = 3;
        Z = "dbcorrupt_report_nodb";
        f203260a0 = "dbcorrupt_report_copy_fail";
        f203261b0 = "dbcorrupt_report_fix";
        f203262c0 = "dbcorrupt_report_corrupt";
        f203263d0 = "dbcorrupt_report_cancel_fix";
        f203264e0 = "dbcorrupt_report_second_confirm";
        f203265f0 = "db_backup_master_result_report";
        f203266g0 = 0;
        f203267h0 = null;
        f203269i0 = true;
        f203270j0 = false;
    }

    public DBFixManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f203275h = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        this.f203272d = qQAppInterface;
        this.f203273e = qQAppInterface.getApp();
        this.f203274f = this.f203272d.getCurrentAccountUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String currentAccountUin = this.f203272d.getCurrentAccountUin();
        QLog.d(f203268i, 1, "checkNTCorruptInfo dbFixNTIsNeed: " + f203270j0);
        if (f203270j0) {
            long decodeLong = this.f203275h.decodeLong(currentAccountUin + I, 0L);
            String decodeString = this.f203275h.decodeString(currentAccountUin + J, "");
            if (decodeLong > 0 && !TextUtils.isEmpty(decodeString)) {
                this.f203272d.runOnUiThread(new Runnable(decodeLong, decodeString) { // from class: com.tencent.mobileqq.database.corrupt.DBFixManager.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f203277d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f203278e;

                    {
                        this.f203277d = decodeLong;
                        this.f203278e = decodeString;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, DBFixManager.this, Long.valueOf(decodeLong), decodeString);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (BaseActivity.sTopActivity != null) {
                            QLog.d(DBFixManager.f203268i, 1, "checkNTCorruptInfo into onNTCorruptionInstant");
                            DBFixManager.this.m(BaseActivity.sTopActivity, false, this.f203277d, this.f203278e);
                        }
                    }
                });
            } else {
                QLog.d(f203268i, 1, "NT db info is corrupt");
            }
        }
    }

    public static void f() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(AppConstants.Preferences.GET_MSG_V2_SYNC_COOKIE);
            edit.remove(AppConstants.Preferences.GET_LAST_MESSAGE_TIME);
            edit.remove(AppConstants.Preferences.GET_PUB_ACCOUNT_MSG_COOKIE);
            edit.remove(AppConstants.Preferences.GET_TROOP_DISC_MSG_LAST_TIME);
            Iterator<Map.Entry<String, ?>> it = sharedPreferences.getAll().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key) && (key.startsWith(AppConstants.Preferences.GET_TROOP_LAST_MESSAGE_TIME) || key.startsWith(AppConstants.Preferences.GET_DISCUSSION_LAST_MESSAGE_TIME))) {
                    edit.remove(key);
                }
            }
            edit.commit();
            QLog.e(f203268i, 1, "clearAllMsgSyncFlags");
        }
    }

    public void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.DBFixManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DBFixManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SharedPreferences sharedPreferences = DBFixManager.this.f203272d.getApplication().getSharedPreferences(DBFixManager.f203271m, 0);
                    String currentAccountUin = DBFixManager.this.f203272d.getCurrentAccountUin();
                    if (sharedPreferences.getBoolean(currentAccountUin + DBFixManager.D, false)) {
                        DBFixManager.this.k();
                        if (sharedPreferences.getInt(currentAccountUin + DBFixManager.E, 0) < DBFixManager.F && DBFixManager.L) {
                            DBFixManager.this.f203272d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.DBFixManager.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    BaseActivity baseActivity = BaseActivity.sTopActivity;
                                    if (baseActivity != null) {
                                        DBFixManager.this.l(baseActivity, false);
                                    }
                                }
                            });
                        } else {
                            QLog.d(DBFixManager.f203268i, 1, "DBFixDialogUI 1, max count, delete db");
                            DBFixManager.this.h(false);
                            DBFixManager.this.g();
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.remove(currentAccountUin + DBFixManager.D);
                            edit.remove(currentAccountUin + DBFixManager.E);
                            edit.apply();
                        }
                    }
                    DBFixManager.this.e();
                }
            }, null, true);
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (DBFixDialogUI.f203218m != null) {
            return true;
        }
        return false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        String currentAccountUin = this.f203272d.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin)) {
            QLog.d(f203268i, 1, "clearLocalSPFlag, remove sp");
            SharedPreferences.Editor edit = this.f203272d.getApplication().getSharedPreferences(f203271m, 0).edit();
            edit.remove(currentAccountUin + D);
            edit.remove(currentAccountUin + E);
            edit.commit();
        }
        f();
        this.f203272d.getApp().getSharedPreferences("acc_info" + this.f203272d.getAccount(), 0);
        com.tencent.mobileqq.friend.utils.b.d().i(false);
        QLog.d(f203268i, 1, "cleared friendlist flag");
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        File databasePath = this.f203273e.getDatabasePath(this.f203274f + DBBackupServiceImpl.DB_FILE_SUFFIX);
        long length = databasePath.length();
        FileUtils.deleteFile(databasePath.getPath());
        FileUtils.deleteFile(this.f203273e.getDatabasePath(this.f203274f + ".db-journal").getPath());
        File databasePath2 = this.f203273e.getDatabasePath(this.f203274f + ".db-wal");
        String absolutePath = databasePath2.getAbsolutePath();
        QLog.d(f203268i, 1, "deleteDbFile walDeleteResult:", Boolean.valueOf(FileUtils.deleteFile(absolutePath)), ", file exist: ", Boolean.valueOf(databasePath2.exists()), ", walPath: ", absolutePath);
        File databasePath3 = this.f203273e.getDatabasePath(this.f203274f + ".db-shm");
        String absolutePath2 = databasePath3.getAbsolutePath();
        QLog.d(f203268i, 1, "deleteDbFile shmDeleteResult:", Boolean.valueOf(FileUtils.deleteFile(absolutePath2)), ", file exist: ", Boolean.valueOf(databasePath3.exists()), ", shmPath: ", absolutePath2);
        if (!z16) {
            SharedPreferences sharedPreferences = this.f203272d.getApplication().getSharedPreferences(f203271m, 0);
            sharedPreferences.edit().remove(this.f203274f + Q).commit();
            String string = sharedPreferences.getString(this.f203274f + V, "");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("failReason", string);
            hashMap.put("dblen", String.valueOf(length));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, T, true, -1L, 0L, hashMap, (String) null, false);
            QLog.d(f203268i, 1, "onCorruptionInstant, deleteDbFile, isSuc: ", Boolean.valueOf(z16), " failReason: ", string);
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.database.corrupt.DBFixManager.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f203279d;

                {
                    this.f203279d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DBFixManager.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    FrequencyControlField$DBFix frequencyControlField$DBFix = new FrequencyControlField$DBFix();
                    frequencyControlField$DBFix.event.set(222207);
                    frequencyControlField$DBFix.db_path.set(this.f203279d);
                    IQQNTWrapperSession k3 = f.k();
                    if (k3 != null) {
                        k3.onDispatchPush(221012, frequencyControlField$DBFix.toByteArray());
                    }
                }
            }, 64, null, true);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.d(f203268i, 1, "exitQQMainProcess");
        n(false);
        QLog.flushLog();
        if (QQPlayerService.s0()) {
            Intent intent = new Intent();
            intent.setAction("qqplayer_exit_action");
            this.f203273e.sendBroadcast(intent);
        }
        QQMusicPlayService.L(f203268i);
        this.f203272d.exit(false);
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!L && M == 0) {
            M = this.f203272d.getApplication().getSharedPreferences(f203271m, 0).getInt(this.f203274f + P, 0);
        }
        if (!L && M <= N) {
            boolean loadSoByName = SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), "DBFix");
            L = loadSoByName;
            if (!loadSoByName) {
                int i3 = M + 1;
                M = i3;
                QLog.e(f203268i, 1, "db fix so load failed, ", Integer.valueOf(i3));
            } else {
                M = 0;
            }
            SharedPreferences.Editor edit = this.f203272d.getApplication().getSharedPreferences(f203271m, 0).edit();
            edit.putInt(this.f203274f + P, M);
            edit.commit();
        }
        return L;
    }

    public void l(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences sharedPreferences = this.f203272d.getApplication().getSharedPreferences(f203271m, 0);
        String currentAccountUin = this.f203272d.getCurrentAccountUin();
        boolean z17 = sharedPreferences.getBoolean(currentAccountUin + D, false);
        if (z16 && z17) {
            return;
        }
        if (d()) {
            if (QLog.isColorLevel()) {
                QLog.d(f203268i, 2, "onCorruptionInstant, db fixing");
                return;
            }
            return;
        }
        File databasePath = this.f203273e.getDatabasePath(this.f203274f + DBBackupServiceImpl.DB_FILE_SUFFIX);
        if (databasePath.exists() && databasePath.length() != 0) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (!TextUtils.isEmpty(currentAccountUin) && !z17) {
                edit.putBoolean(currentAccountUin + D, true);
            }
            int i3 = sharedPreferences.getInt(currentAccountUin + E, 0) + 1;
            edit.putInt(currentAccountUin + E, i3);
            edit.commit();
            QLog.d(f203268i, 1, "onCorruptionInstant, start activity and write sp ", Integer.valueOf(i3), " onCorrupt: ", Boolean.valueOf(z16));
            if (z16) {
                o(i3);
                return;
            } else {
                new DBFixDialogUI(context, this.f203272d).v(i3);
                return;
            }
        }
        QLog.d(f203268i, 1, "onCorruptionInstant, db not exists, ", Boolean.valueOf(databasePath.exists()));
        sharedPreferences.edit().remove(currentAccountUin + Q).commit();
        if (z17) {
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.remove(currentAccountUin + D);
            edit2.remove(currentAccountUin + E);
            edit2.commit();
        }
    }

    public void m(Context context, boolean z16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, Boolean.valueOf(z16), Long.valueOf(j3), str);
            return;
        }
        String currentAccountUin = this.f203272d.getCurrentAccountUin();
        boolean z18 = f203270j0;
        if (z16 && z18) {
            return;
        }
        if (d()) {
            QLog.d(f203268i, 2, "onCorruptionInstant, db fixing");
            return;
        }
        int decodeInt = this.f203275h.decodeInt(currentAccountUin + H, 0);
        QLog.d(f203268i, 1, "onNTCorruptionInstant, start activity and write sp ", Integer.valueOf(decodeInt), " onCorrupt: ", Boolean.valueOf(z16), " dbFixNTIsNeed: ", Boolean.valueOf(f203270j0));
        if (z16) {
            this.f203275h.encodeLong(currentAccountUin + I, j3);
            this.f203275h.encodeString(currentAccountUin + J, str);
            if (j3 > 0 && !TextUtils.isEmpty(str)) {
                z17 = true;
            }
            if (z17 && !TextUtils.isEmpty(currentAccountUin) && !f203270j0) {
                f203270j0 = true;
            }
            QLog.d(f203268i, 1, "DBFixDialogActivity onCreate dbFixNTIsNeed is " + f203270j0);
            p(decodeInt, j3, str);
            return;
        }
        new DBFixDialogUI(context, this.f203272d, j3, str).v(decodeInt);
    }

    public void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        if (z16) {
            ((IOnlineStatusService) this.f203272d.getRuntimeService(IOnlineStatusService.class)).sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
            this.f203273e.sendBroadcast(new Intent(NewIntent.ACTION_EXIT + this.f203273e.getPackageName()));
            return;
        }
        this.f203272d.sendRegisterPush();
        this.f203272d.ntOnline();
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        Intent intent = new Intent(this.f203273e, (Class<?>) DBFixDialogActivity.class);
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.addFlags(131072);
        intent.putExtra(E, i3);
        this.f203273e.startActivity(intent);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void p(int i3, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3), str);
            return;
        }
        Intent intent = new Intent(this.f203273e, (Class<?>) DBFixDialogActivity.class);
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.addFlags(131072);
        intent.putExtra(H, i3);
        intent.putExtra(I, j3);
        intent.putExtra(J, str);
        this.f203273e.startActivity(intent);
    }
}
