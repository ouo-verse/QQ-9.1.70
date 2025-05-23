package com.tencent.mobileqq.database.corrupt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DBFixDialogUI implements DBFixLoadingDialog.b {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    private static String f203217l;

    /* renamed from: m, reason: collision with root package name */
    public static Dialog f203218m;

    /* renamed from: n, reason: collision with root package name */
    public static String f203219n;

    /* renamed from: o, reason: collision with root package name */
    public static String f203220o;

    /* renamed from: p, reason: collision with root package name */
    public static String f203221p;

    /* renamed from: q, reason: collision with root package name */
    public static String f203222q;

    /* renamed from: r, reason: collision with root package name */
    public static String f203223r;

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f203224a;

    /* renamed from: b, reason: collision with root package name */
    Context f203225b;

    /* renamed from: c, reason: collision with root package name */
    String f203226c;

    /* renamed from: d, reason: collision with root package name */
    private DBFixManager f203227d;

    /* renamed from: e, reason: collision with root package name */
    private int f203228e;

    /* renamed from: f, reason: collision with root package name */
    private String f203229f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f203230g;

    /* renamed from: h, reason: collision with root package name */
    private long f203231h;

    /* renamed from: i, reason: collision with root package name */
    private String f203232i;

    /* renamed from: j, reason: collision with root package name */
    private MMKVOptionEntity f203233j;

    /* renamed from: k, reason: collision with root package name */
    DialogInterface.OnCancelListener f203234k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.cancel();
                DBFixDialogUI.this.f203227d.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.cancel();
                DBFixDialogUI.this.f203227d.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.cancel();
                DBFixDialogUI.this.f203227d.j();
            }
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.cancel();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.cancel();
            DBFixDialogUI.this.f203225b.startActivity(new Intent("android.settings.INTERNAL_STORAGE_SETTINGS"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class h implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            if (DBFixDialogUI.this.f203229f.equals("checked corrupt") && !DBFixDialogUI.this.f203230g) {
                SharedPreferences sharedPreferences = DBFixDialogUI.this.f203224a.getApplication().getSharedPreferences(DBFixManager.f203271m, 0);
                String string = sharedPreferences.getString(DBFixDialogUI.this.f203226c + DBFixManager.V, "");
                sharedPreferences.edit().putString(DBFixDialogUI.this.f203226c + DBFixManager.V, string + "_Cancel").commit();
                QLog.d(DBFixDialogUI.f203217l, 1, "dialog cancel");
            }
            DBFixDialogUI.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f203246d;

        i(int i3) {
            this.f203246d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this, i3);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                if (this.f203246d >= DBFixManager.F) {
                    QLog.d(DBFixDialogUI.f203217l, 1, "cancel click, showSecondConfirmDialog");
                    dialogInterface.dismiss();
                    DBFixDialogUI.this.D();
                    return;
                }
                DBFixDialogUI.this.q(dialogInterface, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DBFixDialogUI.this.s(dialogInterface, false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                DBFixDialogUI.this.r();
                DBFixDialogUI.this.q(dialogInterface, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class l implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DBFixDialogUI.this.s(dialogInterface, true);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d(DBFixDialogUI.f203217l, 1, "onClick success confirm");
            dialogInterface.cancel();
            DBFixDialogUI dBFixDialogUI = DBFixDialogUI.this;
            QQAppInterface qQAppInterface = dBFixDialogUI.f203224a;
            String str = dBFixDialogUI.f203226c;
            String str2 = DBFixDialogUI.f203223r;
            ReportController.o(qQAppInterface, "CliOper", "", str, str2, str2, 0, 0, "", "", "", "");
            DBFixDialogUI.this.f203227d.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class n implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class o implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d(DBFixDialogUI.f203217l, 1, "showNTFixSuccDialog onClick success confirm");
            dialogInterface.cancel();
            DBFixDialogUI.this.f203227d.j();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71402);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f203217l = "DBFix";
        f203218m = null;
        f203219n = "0X8007960";
        f203220o = "0X8007961";
        f203221p = "0X8007962";
        f203222q = "0X8007963";
        f203223r = "0X8007964";
    }

    public DBFixDialogUI(Context context, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) qQAppInterface);
            return;
        }
        this.f203229f = "";
        this.f203232i = "";
        this.f203233j = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        this.f203234k = new h();
        this.f203224a = qQAppInterface;
        this.f203225b = context;
        this.f203226c = qQAppInterface.getCurrentAccountUin();
        this.f203227d = (DBFixManager) this.f203224a.getManager(QQManagerFactory.DB_FIX_MANAGER);
    }

    private void A() {
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this.f203225b, 230).setMessage(HardCodeUtil.qqStr(R.string.law)).setPositiveButton(HardCodeUtil.qqStr(R.string.las), new g()).setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new f());
        f203218m = negativeButton;
        negativeButton.setOnCancelListener(this.f203234k);
        w(f203218m, "memory alert");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.f203225b, 230).setMessage(HardCodeUtil.qqStr(R.string.lau)).setPositiveButton("\u91cd\u542fQQ", new c());
        f203218m = positiveButton;
        positiveButton.setOnKeyListener(new d());
        f203218m.setOnCancelListener(this.f203234k);
        w(f203218m, "fix fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        String currentAccountUin = this.f203224a.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin)) {
            QLog.d(f203217l, 1, "showNTFixSuccDialog, remove sp");
            DBFixManager.f203270j0 = false;
            this.f203233j.removeKey(currentAccountUin + DBFixManager.I);
            this.f203233j.removeKey(currentAccountUin + DBFixManager.J);
            this.f203233j.removeKey(currentAccountUin + DBFixManager.H);
        }
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.f203225b, 230).setMessage(HardCodeUtil.qqStr(R.string.lat)).setPositiveButton(HardCodeUtil.qqStr(R.string.laz), new o());
        f203218m = positiveButton;
        positiveButton.setOnKeyListener(new a());
        f203218m.setOnCancelListener(this.f203234k);
        w(f203218m, "fix succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        String qqStr = HardCodeUtil.qqStr(R.string.f212235mz);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f212255n1);
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this.f203225b, 230).setMessage(qqStr).setPositiveButton(qqStr2, new l()).setNegativeButton(HardCodeUtil.qqStr(R.string.f212245n0), new k());
        negativeButton.setOnCancelListener(this.f203234k);
        w(negativeButton, "second Confirm");
        if (this.f203230g) {
            return;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.f203264e0, true, -1L, 0L, (HashMap<String, String>) null, (String) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.f203225b, 230).setMessage(HardCodeUtil.qqStr(R.string.f212265n2)).setPositiveButton(HardCodeUtil.qqStr(R.string.f212225my), new e());
        f203218m = positiveButton;
        positiveButton.setOnCancelListener(this.f203234k);
        w(f203218m, "unable to fix");
    }

    private void p(DBFixLoadingDialog dBFixLoadingDialog) {
        if (this.f203230g && DBFixManager.f203266g0 == 100 && DBFixManager.f203267h0 != null) {
            QLog.d(f203217l, 1, "judgeFixIsFinish onNTRepairComplete");
            dBFixLoadingDialog.e0(DBFixManager.f203267h0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(DialogInterface dialogInterface, boolean z16) {
        if (this.f203230g) {
            t(dialogInterface);
            return;
        }
        dialogInterface.dismiss();
        File databasePath = this.f203225b.getDatabasePath(this.f203224a.getCurrentAccountUin() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        boolean z17 = false;
        if (databasePath.exists() && ((float) databasePath.length()) * 1.7f > FileUtils.getAvailableInnernalMemorySize()) {
            A();
            SharedPreferences sharedPreferences = this.f203224a.getApplication().getSharedPreferences(DBFixManager.f203271m, 0);
            String string = sharedPreferences.getString(this.f203226c + DBFixManager.V, "");
            sharedPreferences.edit().putString(this.f203226c + DBFixManager.V, string + "_MemoryAlert").commit();
            z17 = true;
        } else {
            x();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("isMemAlert", String.valueOf(z17));
        hashMap.put("isSecondConfirm", String.valueOf(z16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.f203261b0, true, -1L, 0L, hashMap, (String) null, false);
        QQAppInterface qQAppInterface = this.f203224a;
        String str = this.f203226c;
        String str2 = f203220o;
        ReportController.o(qQAppInterface, "CliOper", "", str, str2, str2, 0, 0, "", "", "", "");
    }

    private void t(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        if (((float) this.f203231h) * 1.7f > FileUtils.getAvailableInnernalMemorySize()) {
            A();
        } else {
            x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        DBFixManager.f203270j0 = false;
        int decodeInt = this.f203233j.decodeInt(this.f203226c + DBFixManager.H, 0);
        int i3 = decodeInt + 1;
        this.f203233j.encodeInt(this.f203226c + DBFixManager.H, i3);
        if (this.f203231h > 0) {
            this.f203233j.encodeLong(this.f203226c + DBFixManager.I, this.f203231h);
        }
        if (!TextUtils.isEmpty(this.f203232i)) {
            this.f203233j.encodeString(this.f203226c + DBFixManager.J, this.f203232i);
        }
        QLog.d(f203217l, 1, "recordNTDBFixFail finish fix write mmvk ", Integer.valueOf(i3));
    }

    private void w(Dialog dialog, String str) {
        QLog.d(f203217l, 1, "DBFixDialogUI showDialog, " + str);
        this.f203229f = str;
        this.f203224a.runOnUiThread(new Runnable(dialog) { // from class: com.tencent.mobileqq.database.corrupt.DBFixDialogUI.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Dialog f203237d;

            {
                this.f203237d = dialog;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this, (Object) dialog);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Context context = DBFixDialogUI.this.f203225b;
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    return;
                }
                this.f203237d.show();
            }
        });
    }

    private void x() {
        this.f203227d.n(true);
        DBFixLoadingDialog dBFixLoadingDialog = new DBFixLoadingDialog(this.f203224a, this.f203225b, this, this.f203230g, this.f203232i);
        f203218m = dBFixLoadingDialog;
        dBFixLoadingDialog.setOnCancelListener(this.f203234k);
        f203218m.setCanceledOnTouchOutside(false);
        w(f203218m, "fixing");
        p((DBFixLoadingDialog) f203218m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.f203225b, 230).setMessage(HardCodeUtil.qqStr(R.string.lau)).setPositiveButton("\u91cd\u542fQQ", new b());
        f203218m = positiveButton;
        positiveButton.setOnCancelListener(this.f203234k);
        w(f203218m, "fix fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.f203227d.g();
        this.f203224a.getApplication().getSharedPreferences(DBFixManager.f203271m, 0).edit().remove(this.f203226c + DBFixManager.Q).apply();
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.f203225b, 230).setMessage(HardCodeUtil.qqStr(R.string.lat)).setPositiveButton(HardCodeUtil.qqStr(R.string.laz), new m());
        f203218m = positiveButton;
        positiveButton.setOnKeyListener(new n());
        f203218m.setOnCancelListener(this.f203234k);
        w(f203218m, "fix succ");
        QQAppInterface qQAppInterface = this.f203224a;
        String str = this.f203226c;
        String str2 = f203222q;
        ReportController.o(qQAppInterface, "CliOper", "", str, str2, str2, 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.b
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f203228e = i3;
            this.f203224a.runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.database.corrupt.DBFixDialogUI.15
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f203236d;

                {
                    this.f203236d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = this.f203236d;
                    if (i16 == DBFixLoadingDialog.Y) {
                        DBFixDialogUI.this.C();
                    } else if (i16 == DBFixLoadingDialog.Z) {
                        DBFixDialogUI.this.u();
                        DBFixDialogUI.this.B();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f203228e = i3;
            this.f203224a.runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.database.corrupt.DBFixDialogUI.14
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f203235d;

                {
                    this.f203235d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DBFixDialogUI.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = this.f203235d;
                    if (i16 == DBFixLoadingDialog.Y) {
                        DBFixDialogUI.this.z();
                    } else if (i16 == DBFixLoadingDialog.Z) {
                        DBFixDialogUI.this.y();
                    } else if (i16 == DBFixLoadingDialog.f203254a0) {
                        DBFixDialogUI.this.E();
                    }
                    com.tencent.mobileqq.database.corrupt.e.j();
                }
            });
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f203218m = null;
        Context context = this.f203225b;
        if (context instanceof DBFixDialogActivity) {
            ((DBFixDialogActivity) context).finish();
        }
        if (this.f203230g) {
            return;
        }
        this.f203227d.n(false);
        if (this.f203228e != DBFixLoadingDialog.Y) {
            SharedPreferences sharedPreferences = this.f203224a.getApplication().getSharedPreferences(DBFixManager.f203271m, 0);
            String currentAccountUin = this.f203224a.getCurrentAccountUin();
            if (sharedPreferences.getInt(currentAccountUin + DBFixManager.E, 0) >= DBFixManager.F) {
                QLog.d(f203217l, 1, "DBFixDialogUI 2, max count, delete db");
                this.f203227d.h(false);
                this.f203227d.g();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(currentAccountUin + DBFixManager.D);
                edit.remove(currentAccountUin + DBFixManager.E);
                edit.commit();
            }
        }
    }

    public void q(DialogInterface dialogInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, dialogInterface, Boolean.valueOf(z16));
            return;
        }
        dialogInterface.cancel();
        if (this.f203230g) {
            return;
        }
        QLog.d(f203217l, 1, "showConfirmDialog, cancel click");
        QQAppInterface qQAppInterface = this.f203224a;
        String str = this.f203226c;
        String str2 = f203221p;
        ReportController.o(qQAppInterface, "CliOper", "", str, str2, str2, 0, 0, "", "", "", "");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("isSecondConfirm", String.valueOf(z16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.f203263d0, true, -1L, 0L, hashMap, (String) null, false);
        com.tencent.mobileqq.database.corrupt.e.i();
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f203230g && this.f203228e != DBFixLoadingDialog.Y) {
            String currentAccountUin = this.f203224a.getCurrentAccountUin();
            if (this.f203233j.decodeInt(currentAccountUin + DBFixManager.H, 0) >= DBFixManager.F) {
                QLog.d(f203217l, 1, "DBFixDialogUI onNTFinish 2, max count, delete db");
                this.f203227d.i(this.f203232i);
                DBFixManager.f203270j0 = false;
                this.f203233j.removeKey(currentAccountUin + DBFixManager.I);
                this.f203233j.removeKey(currentAccountUin + DBFixManager.J);
                this.f203233j.removeKey(currentAccountUin + DBFixManager.H);
            }
        }
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.lav);
        if (i3 >= DBFixManager.F) {
            qqStr = HardCodeUtil.qqStr(R.string.f212195mv);
        }
        String qqStr2 = HardCodeUtil.qqStr(R.string.f212215mx);
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this.f203225b, 230).setMessage(qqStr).setPositiveButton(qqStr2, new j()).setNegativeButton(HardCodeUtil.qqStr(R.string.f212205mw), new i(i3));
        f203218m = negativeButton;
        negativeButton.setOnCancelListener(this.f203234k);
        w(f203218m, "checked corrupt");
        if (this.f203230g) {
            return;
        }
        QQAppInterface qQAppInterface = this.f203224a;
        String str = this.f203226c;
        String str2 = f203219n;
        ReportController.o(qQAppInterface, "CliOper", "", str, str2, str2, 0, 0, "", "", "", "");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("corruptCount", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.f203262c0, true, -1L, 0L, hashMap, (String) null, false);
        com.tencent.mobileqq.database.corrupt.e.k();
    }

    public DBFixDialogUI(Context context, QQAppInterface qQAppInterface, long j3, String str) {
        this(context, qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, qQAppInterface, Long.valueOf(j3), str);
            return;
        }
        this.f203231h = j3;
        this.f203232i = str;
        this.f203230g = j3 > 0 && !TextUtils.isEmpty(str);
    }
}
