package com.tencent.mobileqq.troop.jointroopsecuritytips;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.jointroopsecuritytips.c;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.jointroopsecuritytips.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class DialogInterfaceOnClickListenerC8757b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f297552d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f297553e;

        DialogInterfaceOnClickListenerC8757b(Context context, String str) {
            this.f297552d = context;
            this.f297553e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Intent intent = new Intent();
            intent.setClass(this.f297552d, QQBrowserActivity.class);
            intent.putExtra("url", this.f297553e);
            this.f297552d.startActivity(intent);
        }
    }

    public static void a(QQAppInterface qQAppInterface, int i3, long j3, Context context) {
        com.tencent.mobileqq.troop.jointroopsecuritytips.a aVar;
        List<c.a> list;
        String str;
        c.a aVar2;
        QQCustomDialog createCustomDialog;
        if (context == null || qQAppInterface == null || (aVar = (com.tencent.mobileqq.troop.jointroopsecuritytips.a) am.s().x(669)) == null) {
            return;
        }
        c b16 = aVar.b(i3);
        if (b16 == null) {
            b16 = aVar.a(context);
        }
        if (b16 != null && (list = b16.f297557d) != null && list.size() != 0) {
            String str2 = b16.f297555b;
            String str3 = b16.f297556c;
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            String replace = str3.replace("$M$", String.valueOf(calendar.get(3))).replace("$d$", String.valueOf(calendar.get(5)));
            boolean z16 = false;
            c.a aVar3 = b16.f297557d.get(0);
            if (aVar3 == null) {
                return;
            }
            boolean z17 = !TextUtils.isEmpty(aVar3.f297558a);
            String str4 = "";
            if (TextUtils.isEmpty(aVar3.f297559b) || TextUtils.isEmpty(aVar3.f297560c) || !aVar3.f297559b.equals("web")) {
                str = "";
            } else {
                str = aVar3.f297560c;
            }
            if (b16.f297557d.size() > 1) {
                aVar2 = b16.f297557d.get(1);
                if (aVar2 != null) {
                    z16 = !TextUtils.isEmpty(aVar2.f297558a);
                    if (!TextUtils.isEmpty(aVar2.f297559b) && !TextUtils.isEmpty(aVar2.f297560c) && aVar2.f297559b.equals("web")) {
                        str4 = aVar2.f297560c;
                    }
                }
            } else {
                aVar2 = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("JoinTroopSecurityTipsHelper", 2, "JoinTroopSecurityTipsHelper showTips tId = " + i3 + ",time = " + j3 + ",isShowFrist" + z17 + ",isShowSecond" + z16);
            }
            if (z17 && z16) {
                DialogUtil.createCustomDialog(context, 230, str2, replace, aVar3.f297558a, aVar2.f297558a, b(z16, str4, context), b(z17, str, context)).show();
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
            } else if (z17 && (createCustomDialog = DialogUtil.createCustomDialog(context, 230)) != null) {
                createCustomDialog.setTitle(str2);
                createCustomDialog.setMessage(replace);
                createCustomDialog.setNegativeButton(aVar3.f297558a, b(z17, str, context));
                createCustomDialog.show();
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
            }
        }
    }

    private static DialogInterface.OnClickListener b(boolean z16, String str, Context context) {
        if (z16 && context != null) {
            if (QLog.isColorLevel()) {
                QLog.d("JoinTroopSecurityTipsHelper", 2, "getBtnListener, isShow = " + z16 + ", jumpUrl = " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return new a();
            }
            return new DialogInterfaceOnClickListenerC8757b(context, str);
        }
        return null;
    }
}
