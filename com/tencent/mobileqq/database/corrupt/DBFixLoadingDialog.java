package com.tencent.mobileqq.database.corrupt;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.dbfix.DBFix;
import com.tencent.dbfix.DBFixResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$DBFix;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.msg.f;
import com.tencent.util.LoadingUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DBFixLoadingDialog extends ReportDialog implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static String U;
    public static int V;
    public static int W;
    public static int X;
    public static int Y;
    public static int Z;

    /* renamed from: a0, reason: collision with root package name */
    public static int f203254a0;

    /* renamed from: b0, reason: collision with root package name */
    public static int f203255b0;

    /* renamed from: c0, reason: collision with root package name */
    public static int f203256c0;

    /* renamed from: d0, reason: collision with root package name */
    public static int f203257d0;
    private QQAppInterface C;
    private Context D;
    private b E;
    private TextView F;
    private boolean G;
    private String H;
    private String I;
    private File J;
    private File K;
    private File L;
    private long M;
    private float N;
    private long P;
    private MqqWeakReferenceHandler Q;
    private int R;
    private int S;
    private Runnable T;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixLoadingDialog.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 != 84 && i3 != 4) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void a(int i3);

        void b(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71410);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        U = "DBFix";
        V = 1;
        W = 0;
        X = 1;
        Y = 2;
        Z = 3;
        f203254a0 = 4;
        f203255b0 = 1;
        f203256c0 = 2;
        f203257d0 = 3;
    }

    DBFixLoadingDialog(QQAppInterface qQAppInterface, Context context, b bVar) {
        super(context, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, bVar);
            return;
        }
        this.H = "";
        this.Q = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
        this.R = W;
        this.S = 0;
        this.T = new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DBFixLoadingDialog.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean doDBFixRepair;
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DBFixManager dBFixManager = (DBFixManager) DBFixLoadingDialog.this.C.getManager(QQManagerFactory.DB_FIX_MANAGER);
                dBFixManager.k();
                e.m(DBFixLoadingDialog.V);
                if (DBFixLoadingDialog.this.K.exists()) {
                    DBFixLoadingDialog.this.K.delete();
                }
                long currentTimeMillis = System.currentTimeMillis();
                DBFixResult dBFixResult = new DBFixResult();
                boolean z16 = false;
                QLog.d(DBFixLoadingDialog.U, 1, "repair start, ", Integer.valueOf(DBFixLoadingDialog.V));
                if (DBFixLoadingDialog.V == 1) {
                    doDBFixRepair = DBFix.getInstance().doDumpRepair(DBFixLoadingDialog.this.J.getAbsolutePath(), DBFixLoadingDialog.this.K.getAbsolutePath(), dBFixResult);
                } else {
                    doDBFixRepair = DBFix.getInstance().doDBFixRepair(DBFixLoadingDialog.this.J.getAbsolutePath(), DBFixLoadingDialog.this.K.getAbsolutePath(), DBFixLoadingDialog.this.L.getAbsolutePath(), dBFixResult);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                QLog.d(DBFixLoadingDialog.U, 1, "repair result, dur:", Double.valueOf(dBFixResult.duration), ", row:", Long.valueOf(dBFixResult.rowCount), ", table:", Long.valueOf(dBFixResult.tableCount), ", sucPage:", Long.valueOf(dBFixResult.sucPageCount), ", failPage:", Long.valueOf(dBFixResult.failPageCount), ", masterCorrupted:", Integer.valueOf(dBFixResult.masterCorrupted));
                DBFixLoadingDialog.this.S = dBFixResult.masterCorrupted;
                long length = DBFixLoadingDialog.this.J.length();
                long length2 = DBFixLoadingDialog.this.K.length();
                long length3 = DBFixLoadingDialog.this.L.length();
                if (doDBFixRepair) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("fixType", String.valueOf(DBFixLoadingDialog.V));
                    hashMap.put("duration_1", String.valueOf((int) (dBFixResult.duration * 1000.0d)));
                    long j3 = currentTimeMillis2 - currentTimeMillis;
                    hashMap.put("duration_2", String.valueOf(j3));
                    hashMap.put("rowCount", String.valueOf(dBFixResult.rowCount));
                    hashMap.put("tableCount", String.valueOf(dBFixResult.tableCount));
                    hashMap.put("sucPage", String.valueOf(dBFixResult.sucPageCount));
                    hashMap.put("failPage", String.valueOf(dBFixResult.failPageCount));
                    long j16 = length / 1024;
                    hashMap.put("oldSize", String.valueOf(j16));
                    long j17 = length2 / 1024;
                    hashMap.put("fixSize", String.valueOf(j17));
                    hashMap.put("fixSpeed", String.valueOf(((float) j16) / ((float) j3)));
                    hashMap.put("masterCorrupted", String.valueOf(dBFixResult.masterCorrupted));
                    String str = "dump";
                    if (length2 != 0) {
                        String str2 = DBFixLoadingDialog.U;
                        Object[] objArr = new Object[5];
                        if (DBFixLoadingDialog.V != 1) {
                            str = "dbRepair";
                        }
                        objArr[0] = str;
                        objArr[1] = Long.valueOf(j3);
                        objArr[2] = Long.valueOf(j16);
                        objArr[3] = Long.valueOf(j17);
                        objArr[4] = Long.valueOf(length3 / 1024);
                        QLog.d(str2, 1, String.format("\u4fee\u590d\u65b9\u5f0f\uff1a%s \u4fee\u590d\u6210\u529f\uff0c\u8017\u65f6%dms\uff0c\u6e90\u6587\u4ef6\uff1a%dkB\uff0c\u4fee\u590d\u540e\uff1a%dkB\uff0cmaster\u5907\u4efd\uff1a%dkB", objArr));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.S, true, -1L, 0L, hashMap, (String) null, true);
                        z16 = false;
                    } else {
                        String str3 = DBFixLoadingDialog.U;
                        Object[] objArr2 = new Object[5];
                        if (DBFixLoadingDialog.V != 1) {
                            str = "dbRepair";
                        }
                        objArr2[0] = str;
                        objArr2[1] = Long.valueOf(j3);
                        objArr2[2] = Long.valueOf(j16);
                        objArr2[3] = 0;
                        objArr2[4] = Long.valueOf(length3 / 1024);
                        QLog.d(str3, 1, String.format("\u4fee\u590d\u65b9\u5f0f\uff1a%s \u4fee\u590d\u7ed3\u679c\u4e3a0\uff0c\u8017\u65f6%dms\uff0c\u6e90\u6587\u4ef6\uff1a%dkB\uff0c\u4fee\u590d\u540e\uff1a%dkB\uff0cmaster\u5907\u4efd\uff1a%dkB", objArr2));
                        DBFixLoadingDialog.this.c0();
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.R, true, -1L, 0L, hashMap, (String) null, true);
                        z16 = true;
                    }
                } else {
                    dBFixManager.n(false);
                    QLog.d(DBFixLoadingDialog.U, 1, "db fix failed");
                }
                DBFixLoadingDialog dBFixLoadingDialog = DBFixLoadingDialog.this;
                if (doDBFixRepair) {
                    if (z16) {
                        i3 = DBFixLoadingDialog.f203254a0;
                    } else {
                        i3 = DBFixLoadingDialog.Y;
                    }
                } else {
                    i3 = DBFixLoadingDialog.Z;
                }
                dBFixLoadingDialog.R = i3;
                DBFixLoadingDialog.this.Q.removeMessages(DBFixLoadingDialog.f203255b0);
                DBFixLoadingDialog.this.Q.sendEmptyMessageDelayed(DBFixLoadingDialog.f203255b0, 100L);
            }
        };
        this.C = qQAppInterface;
        this.D = context;
        this.E = bVar;
    }

    private void d0() {
        QLog.d(U, 1, "onFixComplete");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixLoadingDialog.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                e.l(DBFixLoadingDialog.V, DBFixLoadingDialog.this.S);
                QLog.d(DBFixLoadingDialog.U, 1, "onFixComplete doIntegrityCheck complete");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.5.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QLog.d(DBFixLoadingDialog.U, 1, "onFixComplete update UI, ready to dismiss dialog");
                        DBFixLoadingDialog.this.F.setText(HardCodeUtil.qqStr(R.string.f171836lb1));
                        DBFixLoadingDialog.this.Q.sendEmptyMessageDelayed(DBFixLoadingDialog.f203256c0, 100L);
                    }
                });
            }
        }, 64, null, true);
    }

    public void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        File databasePath = this.C.getApplication().getDatabasePath("chat_ex.trace");
        if (this.J.exists() && (!databasePath.exists() || databasePath.length() == 0)) {
            QLog.d(U, 1, "copy fix_result_zero temp db");
            FileUtils.copyFile(this.J, databasePath);
        }
        File databasePath2 = this.C.getApplication().getDatabasePath(this.C.getAccount() + ".db-wal");
        File databasePath3 = this.C.getApplication().getDatabasePath("chat_ex.trace-wal");
        if (!databasePath3.exists() && databasePath2.exists() && databasePath2.length() > 0) {
            QLog.d(U, 1, "copy fix_result_zero temp db-wal");
            FileUtils.copyFile(databasePath2, databasePath3);
        }
        File databasePath4 = this.C.getApplication().getDatabasePath(this.C.getAccount() + ".db-shm");
        File databasePath5 = this.C.getApplication().getDatabasePath("chat_ex.trace-shm");
        if (!databasePath5.exists() && databasePath4.exists() && databasePath4.length() > 0) {
            QLog.d(U, 1, "copy fix_result_zero temp db-shm");
            FileUtils.copyFile(databasePath4, databasePath5);
        }
    }

    public void e0(FrequencyControlField$DBFix frequencyControlField$DBFix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frequencyControlField$DBFix);
            return;
        }
        QLog.d(U, 1, "onNTRepairComplete isFirstFix: " + DBFixManager.f203269i0);
        if (!DBFixManager.f203269i0) {
            return;
        }
        DBFixManager.f203269i0 = false;
        if (!frequencyControlField$DBFix.status.has()) {
            QLog.d(U, 1, "onFixComplete has not status info");
            return;
        }
        int i3 = frequencyControlField$DBFix.status.get();
        QLog.d(U, 1, "onFixComplete status value: " + i3);
        if (i3 == 222301) {
            QLog.d(U, 1, "onFixComplete update UI, ready to dismiss dialog");
            this.F.setText(HardCodeUtil.qqStr(R.string.f171836lb1));
            this.Q.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DBFixLoadingDialog.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if ((DBFixLoadingDialog.this.D instanceof Activity) && !((Activity) DBFixLoadingDialog.this.D).isFinishing()) {
                        DBFixLoadingDialog.this.dismiss();
                    }
                    DBFixLoadingDialog.this.E.a(DBFixLoadingDialog.Y);
                }
            }, 100L);
        } else {
            dismiss();
            this.E.a(Z);
        }
    }

    public void f0(FrequencyControlField$DBFix frequencyControlField$DBFix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) frequencyControlField$DBFix);
        } else {
            if (!frequencyControlField$DBFix.progress.has()) {
                return;
            }
            this.F.setText(String.format(HardCodeUtil.qqStr(R.string.f171835lb0), Integer.valueOf(Math.min(99, frequencyControlField$DBFix.progress.get()))));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == f203255b0) {
            int i16 = this.R;
            if (i16 == X) {
                int currentTimeMillis = (int) (((float) (System.currentTimeMillis() - this.P)) / (this.N * 10.0f));
                if (currentTimeMillis > 90) {
                    currentTimeMillis = ((currentTimeMillis - 90) / 10) + 90;
                }
                this.F.setText(String.format(HardCodeUtil.qqStr(R.string.f171835lb0), Integer.valueOf(Math.min(currentTimeMillis, 99))));
                this.Q.sendEmptyMessageDelayed(f203255b0, 500L);
            } else if (i16 == Y) {
                ((DBFixManager) this.C.getManager(QQManagerFactory.DB_FIX_MANAGER)).h(true);
                if (!this.K.renameTo(this.J)) {
                    QLog.d(U, 1, "db fix succ but copy fail");
                    boolean copyFile = FileUtils.copyFile(this.K, this.J);
                    FileUtils.deleteFile(this.K.getPath());
                    if (!copyFile) {
                        QLog.d(U, 1, "db fix succ but copy fail final");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.f203260a0, true, -1L, 0L, new HashMap<>(), (String) null, false);
                    }
                }
                d0();
            } else if (i16 == Z || i16 == f203254a0) {
                dismiss();
                e.l(V, this.S);
                this.E.b(this.R);
            }
        } else if (i3 == f203256c0) {
            Context context = this.D;
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                dismiss();
            }
            this.E.b(this.R);
        }
        return false;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.setContentView(R.layout.f168265qr);
        ((ImageView) super.findViewById(R.id.ysu)).setImageDrawable(LoadingUtil.getLoadingDrawable(this.D, 1));
        this.F = (TextView) super.findViewById(R.id.f164953be4);
        super.setOnKeyListener(new a());
        QLog.d(U, 1, "isNT: " + this.G + " ,dbFixNTStatus: " + DBFixManager.f203266g0);
        if (this.G) {
            if (DBFixManager.f203266g0 != 1 && DBFixManager.f203266g0 != 100) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DBFixLoadingDialog.this);
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
                        frequencyControlField$DBFix.event.set(222202);
                        frequencyControlField$DBFix.db_path.set(DBFixLoadingDialog.this.H);
                        IQQNTWrapperSession k3 = f.k();
                        if (k3 != null) {
                            k3.onDispatchPush(221012, frequencyControlField$DBFix.toByteArray());
                        }
                    }
                }, 64, null, true);
                return;
            }
            return;
        }
        this.I = this.C.getCurrentAccountUin();
        this.J = this.D.getDatabasePath(this.I + DBBackupServiceImpl.DB_FILE_SUFFIX);
        this.K = this.D.getDatabasePath(this.I + "_dump.db");
        this.L = this.D.getDatabasePath(this.I + ".db-mbu");
        long length = this.J.length();
        this.M = length;
        this.N = ((float) length) / 1216348.1f;
        this.P = System.currentTimeMillis();
        String account = this.C.getAccount();
        SharedPreferences sharedPreferences = this.C.getApplication().getSharedPreferences(DBFixManager.f203271m, 0);
        int i3 = 2;
        V = sharedPreferences.getInt(account + DBFixManager.C, 2);
        if (sharedPreferences.getInt(account + DBFixManager.E, 0) > 2) {
            if (V == 2) {
                i3 = 1;
            }
            V = i3;
            sharedPreferences.edit().putInt(account + DBFixManager.C, V).commit();
        }
        String string = sharedPreferences.getString(account + DBFixManager.V, "");
        sharedPreferences.edit().putString(account + DBFixManager.V, string + "_" + V).commit();
        ThreadManagerV2.post(this.T, 10, null, true);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onStart();
        this.R = X;
        if (!this.G) {
            this.Q.sendEmptyMessage(f203255b0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DBFixLoadingDialog(QQAppInterface qQAppInterface, Context context, b bVar, boolean z16, String str) {
        this(qQAppInterface, context, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, context, bVar, Boolean.valueOf(z16), str);
        } else {
            this.G = z16;
            this.H = str;
        }
    }
}
