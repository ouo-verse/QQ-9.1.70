package com.tencent.mobileqq.tbstool.fileview;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.util.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tbstool.TBSToolClientUtils;
import com.tencent.mobileqq.tbstool.TBSToolInjector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.tbs.reader.tool.TbsToolEntrance;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private TbsReaderView f291438a;

    /* renamed from: b, reason: collision with root package name */
    private LocalTbsViewManager.e f291439b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements TbsReaderView.ReaderCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocalTbsViewManager.e f291440a;

        a(LocalTbsViewManager.e eVar) {
            this.f291440a = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, (Object) eVar);
            }
        }

        @Override // com.tencent.tbs.reader.TbsReaderView.ReaderCallback
        public void onCallBackAction(Integer num, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, num, obj, obj2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TBSViewRecord", 1, "recv actionType[" + num + "]");
            }
            if (num.intValue() == 5012) {
                int intValue = ((Integer) obj).intValue();
                if (QLog.isColorLevel()) {
                    QLog.i("TBSViewRecord", 1, "err Code[" + intValue + "]");
                }
                if (intValue == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("zivonchen", 2, "canOpenFile return ok 1-------");
                    }
                    LocalTbsViewManager.e eVar = this.f291440a;
                    if (eVar != null) {
                        eVar.c(true);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("zivonchen", 2, "canOpenFile return ok 2-------");
                }
                LocalTbsViewManager.e eVar2 = this.f291440a;
                if (eVar2 != null) {
                    eVar2.c(false);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31414);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            TbsToolEntrance.getInstance().setToolHost(TBSToolInjector.INSTANCE.a());
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f291438a = null;
        }
    }

    public void a(Activity activity, String str, LocalTbsViewManager.e eVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, str, eVar, Boolean.valueOf(z16));
            return;
        }
        if (!TBSToolLocalTbsViewManager.l().n(true)) {
            this.f291439b = eVar;
            QQToast.makeText(activity, R.string.f187693uo, 0).show();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (eVar != null) {
                eVar.c(false);
                return;
            }
            return;
        }
        TbsReaderView tbsReaderView = new TbsReaderView(activity, new a(eVar));
        String j3 = q.j(str);
        if (j3.startsWith(".")) {
            j3 = j3.replaceFirst(".", "");
        }
        if (!tbsReaderView.preOpen(j3, !z16)) {
            tbsReaderView.onStop();
            if (eVar != null) {
                eVar.c(false);
            }
            if (QLog.isColorLevel()) {
                QLog.i("TBSViewRecord", 1, "pre open file false!");
                return;
            }
            return;
        }
        if (z16 && eVar != null) {
            eVar.c(true);
        }
        if (QLog.isColorLevel()) {
            QLog.i("TBSViewRecord", 1, "pre open file true! wait callback!");
        }
    }

    public void b(int i3) {
        boolean z16;
        TbsReaderView tbsReaderView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("dispatchLifecycleToTBS actionType");
        sb5.append(i3);
        sb5.append(", view null:");
        if (this.f291438a == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("TBSViewRecord", 1, sb5.toString());
        TbsReaderView tbsReaderView2 = this.f291438a;
        if (tbsReaderView2 != null) {
            tbsReaderView2.doCommand(Integer.valueOf(i3), null, null);
        }
        if (i3 == 30006 && (tbsReaderView = this.f291438a) != null) {
            tbsReaderView.onStop();
            this.f291438a = null;
        }
    }

    public void c(Integer num, Object obj, Object obj2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, num, obj, obj2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doCommand actionType:");
        sb5.append(num);
        sb5.append(", view null:");
        if (this.f291438a == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("TBSViewRecord", 1, sb5.toString());
        TbsReaderView tbsReaderView = this.f291438a;
        if (tbsReaderView != null) {
            tbsReaderView.doCommand(num, obj, obj2);
        }
    }

    public boolean d(Activity activity) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity)).booleanValue();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onBackPress , view null:");
        if (this.f291438a == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("TBSViewRecord", 1, sb5.toString());
        return TBSToolClientUtils.f291401a.x(activity, this.f291438a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i3) {
        boolean z16;
        LocalTbsViewManager.e eVar = this.f291439b;
        if (eVar != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            eVar.c(z16);
        }
    }

    public TbsReaderView f(Activity activity, String str, long j3, LocalTbsViewManager.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TbsReaderView) iPatchRedirector.redirect((short) 2, this, activity, str, Long.valueOf(j3), eVar);
        }
        if (this.f291438a != null) {
            FilePreviewDataReporter.f209177a.d(str);
            return this.f291438a;
        }
        if (!q.f(str)) {
            return null;
        }
        QLog.w("TBSViewRecord", 4, "initVarView: new TbsReaderView");
        this.f291438a = new TbsReaderView(activity, new TbsFileReaderEventCallback(eVar, activity, str, j3, this.f291438a));
        QLog.w("TBSViewRecord", 4, "initVarView: TbsReaderView openFile");
        this.f291438a.setBackgroundColor(-1);
        String j16 = q.j(str);
        if (j16.startsWith(".")) {
            j16 = j16.replaceFirst(".", "");
        }
        if (this.f291438a.preOpen(j16, false)) {
            int openFile = this.f291438a.openFile(i.c(activity, str, j3));
            if (openFile == 0) {
                z16 = true;
            }
            i.f(true, z16);
            if (openFile == 0) {
                FilePreviewDataReporter.f209177a.d(str);
            }
            QLog.w("TBSViewRecord", 1, "openFile openResult: " + openFile);
            return this.f291438a;
        }
        this.f291438a.onStop();
        this.f291438a = null;
        return null;
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            i.e(str, this.f291438a);
        }
    }

    public void h() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showMenuButton , view null:");
        if (this.f291438a == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("TBSViewRecord", 1, sb5.toString());
        c(3017, null, null);
    }
}
