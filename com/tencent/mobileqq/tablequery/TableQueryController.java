package com.tencent.mobileqq.tablequery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TableQueryController {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f291347g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f291348h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile TableQueryController f291349i;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f291350j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f291351k;

    /* renamed from: a, reason: collision with root package name */
    private WindowManager f291352a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<QQAppInterface> f291353b;

    /* renamed from: c, reason: collision with root package name */
    private TableQueryViewer f291354c;

    /* renamed from: d, reason: collision with root package name */
    private b f291355d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f291356e;

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f291357f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tablequery.TableQueryController$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TableQueryController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TableQueryController.f291351k = false;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f291347g = false;
        f291348h = true;
        f291350j = false;
        f291351k = false;
    }

    TableQueryController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f291356e = false;
        this.f291357f = new BroadcastReceiver() { // from class: com.tencent.mobileqq.tablequery.TableQueryController.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TableQueryController.this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                String action = intent.getAction();
                if ("action.query.data.viewer" == action) {
                    TReportData tReportData = (TReportData) intent.getSerializableExtra("queryData");
                    if (tReportData == null) {
                        return;
                    }
                    a aVar = new a();
                    aVar.f291385k = "";
                    aVar.f291376b = tReportData.actionName + "\n" + tReportData.subAction + "\n" + tReportData.mainAction + "\n";
                    if (tReportData.actionName == null) {
                        str = tReportData.mainAction;
                    } else {
                        str = tReportData.subAction;
                    }
                    aVar.f291375a = str;
                    if (TableQueryController.f291347g && !TableQueryController.f291348h && TableQueryController.this.f291354c != null) {
                        TableQueryController.this.f291354c.h(aVar);
                    }
                    if (TableQueryController.f291347g && (TableQueryController.f291350j || TableQueryController.f291351k)) {
                        TableQueryController.this.f291355d.b((QQAppInterface) TableQueryController.this.f291353b.get(), tReportData.table, 2, tReportData.mainAction, tReportData.actionName, tReportData.subAction);
                    }
                    QLog.d("TableQueryController", 1, tReportData.actionName + "\n" + tReportData.mainAction + "\n" + tReportData.subAction + "\n" + tReportData.table + "\n");
                    return;
                }
                if (GuardManager.ACTION_PLUGIN_STATE_CHANGE == action) {
                    int intExtra = intent.getIntExtra(GuardManager.KEY_PLUGIN_STATE, -1);
                    if (1 == intExtra) {
                        TableQueryController.this.i();
                        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.tablequery.TableQueryController.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    TableQueryController.f291347g = true;
                                }
                            }
                        }, 2000L);
                    } else if (intExtra == 0) {
                        TableQueryController.this.h();
                        TableQueryController.f291347g = false;
                    }
                }
            }
        };
        this.f291355d = new b();
    }

    public static TableQueryController g() {
        if (f291349i == null) {
            synchronized (TableQueryController.class) {
                if (f291349i == null) {
                    f291349i = new TableQueryController();
                }
            }
        }
        return f291349i;
    }

    public void f(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else if (f291347g) {
            this.f291354c.h(aVar);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f291356e) {
            this.f291352a.removeViewImmediate(this.f291354c);
        }
        this.f291356e = false;
    }

    public void i() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (this.f291354c == null) {
            this.f291352a = (WindowManager) context.getSystemService("window");
            this.f291354c = new TableQueryViewer(context);
        }
        if (!this.f291356e) {
            try {
                this.f291352a.removeViewImmediate(this.f291354c);
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 26) {
                i3 = 2038;
            } else {
                i3 = 2003;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, i3, 776, -2);
            layoutParams.gravity = 51;
            layoutParams.x = 0;
            layoutParams.y = x.c(context, 72.0f);
            try {
                this.f291352a.addView(this.f291354c, layoutParams);
            } catch (Exception unused2) {
                QQToast.makeText(context, 1, context.getString(R.string.ilv), 0).show();
            }
            this.f291356e = true;
        }
    }

    public int j(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).intValue();
        }
        TableQueryViewer tableQueryViewer = this.f291354c;
        if (tableQueryViewer == null) {
            return 0;
        }
        return tableQueryViewer.j(aVar);
    }
}
