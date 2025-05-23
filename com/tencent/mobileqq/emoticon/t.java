package com.tencent.mobileqq.emoticon;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes12.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ProgressDialog f204881a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f204882b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, b> f204883c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f204884d;

    /* renamed from: e, reason: collision with root package name */
    int f204885e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f204886f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SogouEmojiTaskController", 2, "func onDismiss begins, mCurTaskId:" + t.this.f204885e);
            }
            t tVar = t.this;
            tVar.g(tVar.f204885e);
            if (QLog.isColorLevel()) {
                QLog.d("SogouEmojiTaskController", 2, "func onDismiss ends");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f204888a;

        /* renamed from: b, reason: collision with root package name */
        public String f204889b;

        /* renamed from: c, reason: collision with root package name */
        public String f204890c;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public t(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f204882b = null;
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func SogouEmojiTaskController begins");
        }
        this.f204886f = activity;
        c();
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func SogouEmojiTaskController ends");
        }
    }

    private void c() {
        this.f204884d = new AtomicInteger(0);
        this.f204883c = Collections.synchronizedMap(new LinkedHashMap(10, 1.1f, true));
    }

    public int a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func addTask begins, packId:" + str + ",exprId:" + str2);
        }
        b bVar = new b();
        int addAndGet = this.f204884d.addAndGet(1);
        this.f204885e = addAndGet;
        bVar.f204889b = str;
        bVar.f204890c = str2;
        bVar.f204888a = addAndGet;
        Map<Integer, b> map = this.f204883c;
        if (map != null) {
            map.put(Integer.valueOf(addAndGet), bVar);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func addTask ends, mCurTaskId:" + this.f204885e);
        }
        h(R.string.cuv);
        return this.f204885e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func cancleProgressDailog begins");
        }
        ProgressDialog progressDialog = this.f204881a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f204881a.cancel();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func cancleProgressDailog ends");
        }
    }

    public boolean d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func isTaskInMap begins, taskId:" + i3);
        }
        Map<Integer, b> map = this.f204883c;
        boolean z16 = false;
        if (map != null) {
            if (map.get(Integer.valueOf(i3)) != null) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SogouEmojiTaskController", 2, "func isTaskInMap ends, taskId:" + i3 + ",exists=" + z16);
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func isTaskInMap ends, taskId:" + i3 + " NOT exist, cause map is null.");
        }
        return false;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func onDestroy begins");
        }
        Map<Integer, b> map = this.f204883c;
        if (map != null) {
            map.clear();
            this.f204883c = null;
        }
        this.f204886f = null;
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func onDestroy ends");
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Map<Integer, b> map = this.f204883c;
        if (map != null) {
            map.clear();
        }
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func removeTask begins, taskId:" + i3 + ",mEmojiTaskHashMap:" + this.f204883c);
        }
        Map<Integer, b> map = this.f204883c;
        if (map != null) {
            map.remove(Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func removeTask ends");
        }
    }

    void h(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func showProgressDialog begins, textResId:" + i3);
        }
        try {
            if (this.f204881a != null) {
                b();
            } else {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(this.f204886f, R.style.qZoneInputDialog);
                this.f204881a = reportProgressDialog;
                reportProgressDialog.setOnDismissListener(new a());
                this.f204881a.setCancelable(true);
                this.f204881a.show();
                this.f204881a.setContentView(R.layout.f168383uh);
                this.f204882b = (TextView) this.f204881a.findViewById(R.id.photo_prievew_progress_dialog_text);
            }
            this.f204882b.setText(i3);
            if (!this.f204881a.isShowing()) {
                this.f204881a.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("SogouEmojiTaskController", 2, "func showProgressDialog ends, ERROR! msg:" + th5.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmojiTaskController", 2, "func showProgressDialog ends");
        }
    }
}
