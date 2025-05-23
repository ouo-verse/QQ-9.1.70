package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.adelie.av.api.IAdelieAVActivityApi;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.api.IGroupVideoHelper;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;
        final /* synthetic */ String D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183285d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f183286e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f183287f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f183288h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f183289i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183290m;

        a(ChatActivityUtils.v vVar, int i3, long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, String str, String str2) {
            this.f183285d = vVar;
            this.f183286e = i3;
            this.f183287f = j3;
            this.f183288h = qQAppInterface;
            this.f183289i = context;
            this.f183290m = uVar;
            this.C = str;
            this.D = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, vVar, Integer.valueOf(i3), Long.valueOf(j3), qQAppInterface, context, uVar, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f183285d.f175244e) {
                int i16 = this.f183286e;
                if (i16 == 2) {
                    ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "1", "", "", "");
                } else if (i16 == 3 || i16 == 4) {
                    ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "1", "", "", "");
                }
            }
            ChatActivityUtils.v vVar = this.f183285d;
            vVar.f175246g = false;
            vVar.f175247h = false;
            vVar.f175251l = false;
            ChatActivityUtils.l0(this.f183287f, this.f183288h, this.f183289i, this.f183290m, vVar, this.C, this.D);
            if (QLog.isColorLevel()) {
                QLog.d("chenlong", 2, "" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183291d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f183292e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183293f;

        b(ChatActivityUtils.v vVar, int i3, ChatActivityUtils.u uVar) {
            this.f183291d = vVar;
            this.f183292e = i3;
            this.f183293f = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, vVar, Integer.valueOf(i3), uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (this.f183291d.f175244e) {
                int i16 = this.f183292e;
                if (i16 == 2) {
                    ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "2", "", "", "");
                } else if (i16 == 3 || i16 == 4) {
                    ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "2", "", "", "");
                }
            }
            ChatActivityUtils.u uVar = this.f183293f;
            if (uVar != null) {
                uVar.onCancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183294d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f183295e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183296f;

        c(ChatActivityUtils.v vVar, int i3, ChatActivityUtils.u uVar) {
            this.f183294d = vVar;
            this.f183295e = i3;
            this.f183296f = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, vVar, Integer.valueOf(i3), uVar);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            if (this.f183294d.f175244e) {
                int i3 = this.f183295e;
                if (i3 == 2) {
                    ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
                } else if (i3 == 3 || i3 == 4) {
                    ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
                }
            }
            ChatActivityUtils.u uVar = this.f183296f;
            if (uVar != null) {
                uVar.onCancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183297d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f183298e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f183299f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f183300h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183301i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f183302m;

        d(ChatActivityUtils.v vVar, long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, String str, String str2) {
            this.f183297d = vVar;
            this.f183298e = j3;
            this.f183299f = qQAppInterface;
            this.f183300h = context;
            this.f183301i = uVar;
            this.f183302m = str;
            this.C = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, vVar, Long.valueOf(j3), qQAppInterface, context, uVar, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatActivityUtils.v vVar = this.f183297d;
            vVar.f175250k = false;
            vVar.f175251l = false;
            ChatActivityUtils.l0(this.f183298e, this.f183299f, this.f183300h, this.f183301i, vVar, this.f183302m, this.C);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183303d;

        e(ChatActivityUtils.u uVar) {
            this.f183303d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatActivityUtils.u uVar = this.f183303d;
            if (uVar != null) {
                uVar.onCancel();
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183304d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f183305e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f183306f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f183307h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183308i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f183309m;

        f(ChatActivityUtils.v vVar, long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, String str, String str2) {
            this.f183304d = vVar;
            this.f183305e = j3;
            this.f183306f = qQAppInterface;
            this.f183307h = context;
            this.f183308i = uVar;
            this.f183309m = str;
            this.C = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, vVar, Long.valueOf(j3), qQAppInterface, context, uVar, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            int uinType2AVRelationType = com.tencent.av.utils.ba.uinType2AVRelationType(this.f183304d.f175240a);
            Map<String, String> map = this.f183304d.f175249j;
            if (map != null && uinType2AVRelationType == 1 && (str = map.get("MultiAVType")) != null) {
                i16 = Integer.valueOf(str).intValue();
            } else {
                i16 = 0;
            }
            ChatActivityUtils.U(this.f183305e, this.f183306f, this.f183307h, uinType2AVRelationType, i16);
            ChatActivityUtils.v vVar = this.f183304d;
            vVar.f175250k = false;
            vVar.f175251l = false;
            ChatActivityUtils.l0(this.f183305e, this.f183306f, this.f183307h, this.f183308i, vVar, this.f183309m, this.C);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183310d;

        g(ChatActivityUtils.u uVar) {
            this.f183310d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatActivityUtils.u uVar = this.f183310d;
            if (uVar != null) {
                uVar.onCancel();
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183311d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f183312e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f183313f;

        h(ChatActivityUtils.v vVar, QQAppInterface qQAppInterface, Context context) {
            this.f183311d = vVar;
            this.f183312e = qQAppInterface;
            this.f183313f = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, vVar, qQAppInterface, context);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ChatActivityUtils.v vVar = this.f183311d;
            vVar.f175246g = false;
            vVar.f175247h = false;
            vVar.f175251l = false;
            ChatActivityUtils.t(this.f183312e, this.f183313f, vVar.f175240a, vVar.f175241b, vVar.f175242c, vVar.f175244e, vVar.f175245f, vVar.f175248i, vVar.f175249j, false);
            if (QLog.isColorLevel()) {
                QLog.d("chenlong", 2, "" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183314d;

        i(ChatActivityUtils.u uVar) {
            this.f183314d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatActivityUtils.u uVar = this.f183314d;
            if (uVar != null) {
                uVar.onCancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183315d;

        j(ChatActivityUtils.u uVar) {
            this.f183315d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            ChatActivityUtils.u uVar = this.f183315d;
            if (uVar != null) {
                uVar.onCancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.k$k, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class DialogInterfaceOnClickListenerC7174k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183316d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183317e;

        DialogInterfaceOnClickListenerC7174k(ChatActivityUtils.u uVar, ChatActivityUtils.v vVar) {
            this.f183316d = uVar;
            this.f183317e = vVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar, (Object) vVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatActivityUtils.u uVar = this.f183316d;
            if (uVar != null) {
                uVar.onCancel();
            }
            DataReport.Y(true, false);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            DataReport.e(this.f183317e.f175244e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183318d;

        l(ChatActivityUtils.u uVar) {
            this.f183318d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatActivityUtils.u uVar = this.f183318d;
            if (uVar != null) {
                uVar.onCancel();
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183319d;

        m(ChatActivityUtils.u uVar) {
            this.f183319d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatActivityUtils.u uVar = this.f183319d;
            if (uVar != null) {
                uVar.onCancel();
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f183320d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183321e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f183322f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f183323h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183324i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f183325m;

        n(QQAppInterface qQAppInterface, ChatActivityUtils.v vVar, long j3, Context context, ChatActivityUtils.u uVar, String str, String str2) {
            this.f183320d = qQAppInterface;
            this.f183321e = vVar;
            this.f183322f = j3;
            this.f183323h = context;
            this.f183324i = uVar;
            this.f183325m = str;
            this.C = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, vVar, Long.valueOf(j3), context, uVar, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            com.tencent.mobileqq.nearby.d dVar = (com.tencent.mobileqq.nearby.d) this.f183320d.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER);
            if (dVar != null) {
                dVar.Q1((byte) 0);
            }
            com.tencent.mobileqq.nearby.h.b(this.f183320d).g(true);
            if (this.f183321e.f175244e) {
                ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
            }
            ChatActivityUtils.v vVar = this.f183321e;
            vVar.f175251l = false;
            ChatActivityUtils.l0(this.f183322f, this.f183320d, this.f183323h, this.f183324i, vVar, this.f183325m, this.C);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183326d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183327e;

        o(ChatActivityUtils.v vVar, ChatActivityUtils.u uVar) {
            this.f183326d = vVar;
            this.f183327e = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (this.f183326d.f175244e) {
                ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
            }
            ChatActivityUtils.u uVar = this.f183327e;
            if (uVar != null) {
                uVar.onCancel();
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183328d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183329e;

        p(ChatActivityUtils.v vVar, ChatActivityUtils.u uVar) {
            this.f183328d = vVar;
            this.f183329e = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            if (this.f183328d.f175244e) {
                ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
            }
            ChatActivityUtils.u uVar = this.f183329e;
            if (uVar != null) {
                uVar.onCancel();
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class q implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f183330d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183331e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f183332f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f183333h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183334i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f183335m;

        q(QQAppInterface qQAppInterface, ChatActivityUtils.v vVar, long j3, Context context, ChatActivityUtils.u uVar, String str, String str2) {
            this.f183330d = qQAppInterface;
            this.f183331e = vVar;
            this.f183332f = j3;
            this.f183333h = context;
            this.f183334i = uVar;
            this.f183335m = str;
            this.C = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, vVar, Long.valueOf(j3), context, uVar, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QQAppInterface qQAppInterface = this.f183330d;
            ChatActivityUtils.v vVar = this.f183331e;
            ChatActivityUtils.W(qQAppInterface, null, vVar.f175240a, vVar.f175241b, vVar.f175243d, true);
            if (this.f183331e.f175244e) {
                ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
            }
            ChatActivityUtils.v vVar2 = this.f183331e;
            vVar2.f175246g = false;
            vVar2.f175247h = true;
            vVar2.f175251l = false;
            ChatActivityUtils.l0(this.f183332f, this.f183330d, this.f183333h, this.f183334i, vVar2, this.f183335m, this.C);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class r implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183336d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183337e;

        r(ChatActivityUtils.v vVar, ChatActivityUtils.u uVar) {
            this.f183336d = vVar;
            this.f183337e = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (this.f183336d.f175244e) {
                ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
            }
            ChatActivityUtils.u uVar = this.f183337e;
            if (uVar != null) {
                uVar.onCancel();
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class s implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.v f183338d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatActivityUtils.u f183339e;

        s(ChatActivityUtils.v vVar, ChatActivityUtils.u uVar) {
            this.f183338d = vVar;
            this.f183339e = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            if (this.f183338d.f175244e) {
                ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
            }
            ChatActivityUtils.u uVar = this.f183339e;
            if (uVar != null) {
                uVar.onCancel();
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    public static void a(QQAppInterface qQAppInterface, int i3, BaseActivity baseActivity) {
        Intent intent = new Intent(baseActivity.getApplicationContext(), (Class<?>) AVActivity.class);
        if (qQAppInterface.getAVNotifyCenter().P() == 1011) {
            return;
        }
        if (qQAppInterface.getAVNotifyCenter().T()) {
            Intent intent2 = new Intent();
            intent2.addFlags(268435456);
            intent2.putExtra("uin", qQAppInterface.getAVNotifyCenter().F());
            intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
            intent2.putExtra("from", "4");
            ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).startActivity(baseActivity.getApplicationContext(), intent2);
            return;
        }
        boolean z16 = true;
        if (qQAppInterface.isVideoChatting() && qQAppInterface.getAVNotifyCenter().P() != 1 && qQAppInterface.getAVNotifyCenter().P() != 3000 && qQAppInterface.getAVNotifyCenter().f0() && qQAppInterface.getAVNotifyCenter().k0() && qQAppInterface.getAVNotifyCenter().P() != 1011 && qQAppInterface.getAVNotifyCenter().P() != 21) {
            Intent intent3 = new Intent(baseActivity, (Class<?>) VideoInviteActivity.class);
            intent3.addFlags(268435456);
            intent3.putExtra("uinType", qQAppInterface.getAVNotifyCenter().P());
            intent3.putExtra("peerUin", qQAppInterface.getAVNotifyCenter().F());
            intent3.putExtra("extraUin", qQAppInterface.getAVNotifyCenter().r());
            if (i3 != 1) {
                z16 = false;
            }
            intent3.putExtra("isAudioMode", z16);
            baseActivity.startActivity(intent3);
            baseActivity.overridePendingTransition(R.anim.f154832d9, 0);
            return;
        }
        intent.addFlags(262144);
        intent.addFlags(268435456);
        if (qQAppInterface.getAVNotifyCenter().Z(qQAppInterface.getAVNotifyCenter().F())) {
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
            intent.putExtra("GroupId", qQAppInterface.getAVNotifyCenter().F());
            intent.putExtra("isDoubleVideoMeeting", true);
            baseActivity.startActivity(intent);
            baseActivity.overridePendingTransition(R.anim.f154832d9, 0);
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
            return;
        }
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
        intent.putExtra("uin", qQAppInterface.getAVNotifyCenter().F());
        baseActivity.startActivity(intent);
        baseActivity.overridePendingTransition(R.anim.f154832d9, 0);
        ReportController.o(qQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
    }

    public static void b(QQAppInterface qQAppInterface, int i3, BaseActivity baseActivity) {
        Intent intent;
        int i16;
        boolean z16;
        long n3 = baseActivity.app.getAVNotifyCenter().n();
        int o16 = baseActivity.app.getAVNotifyCenter().o();
        if (n3 == 0 && baseActivity.app.getAVNotifyCenter().J() <= 0) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiVideoBar", 2, "status error");
                return;
            }
            return;
        }
        int l3 = qQAppInterface.getAVNotifyCenter().l(n3);
        if (baseActivity.app.getAVNotifyCenter().J() > 0) {
            if (qQAppInterface.getAVNotifyCenter().H() != 1 && qQAppInterface.getAVNotifyCenter().H() != 3 && QLog.isColorLevel()) {
                QLog.e("MultiVideoBar", 2, "status error");
                return;
            }
            return;
        }
        if (l3 == 2) {
            intent = new Intent();
        } else {
            intent = new Intent(baseActivity.getApplicationContext(), (Class<?>) AVActivity.class);
        }
        if (qQAppInterface.getAVNotifyCenter().y(o16, n3) > 0) {
            if (qQAppInterface.getAVNotifyCenter().W(o16, n3)) {
                i16 = 2;
            } else {
                i16 = 1;
            }
        } else {
            i16 = 0;
        }
        intent.addFlags(262144);
        intent.addFlags(268435456);
        intent.putExtra("GroupId", String.valueOf(n3));
        intent.putExtra("Type", i16);
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
        intent.putExtra("uinType", com.tencent.av.utils.ba.avRelationType2UinType(o16));
        intent.putExtra("MultiAVType", l3);
        if (l3 == 2) {
            if (qQAppInterface.getAVNotifyCenter().A(String.valueOf(n3)) == 14) {
                ((com.tencent.mobileqq.intervideo.groupvideo.h) qQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).b(baseActivity, qQAppInterface.getCurrentAccountUin(), String.valueOf(n3), "2", "openRoom");
            } else {
                TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null) {
                    if (troopManager.k(n3 + "") == null) {
                        z16 = false;
                        intent.putExtra("troopmember", z16);
                        intent.putExtra("Fromwhere", "SmallScreen");
                        ((IGroupVideoHelper) QRoute.api(IGroupVideoHelper.class)).enterTroopVideoByPlugin(qQAppInterface, baseActivity, intent, 1);
                    }
                }
                z16 = true;
                intent.putExtra("troopmember", z16);
                intent.putExtra("Fromwhere", "SmallScreen");
                ((IGroupVideoHelper) QRoute.api(IGroupVideoHelper.class)).enterTroopVideoByPlugin(qQAppInterface, baseActivity, intent, 1);
            }
        } else {
            baseActivity.startActivity(intent);
        }
        baseActivity.overridePendingTransition(R.anim.f154832d9, 0);
        if (o16 == 2) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
        } else if (o16 == 1) {
            if (qQAppInterface.getAVNotifyCenter().l(n3) == 10) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
            } else {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
            }
        }
    }

    public static Boolean c(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar, String str, String str2) {
        String str3;
        String str4;
        if (qQAppInterface.getAVNotifyCenter().L() == 1) {
            QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_AUDIO, seq[" + j3 + "]  AVNotifyCenter=" + qQAppInterface.getAVNotifyCenter() + " peerUin=" + vVar.f175241b + " uinType=" + vVar.f175240a);
            if (vVar.f175244e && (((str3 = vVar.f175241b) != null && str3.equals(qQAppInterface.getAVNotifyCenter().F())) || (vVar.f175240a == 0 && (str4 = vVar.f175241b) != null && str4.equals(qQAppInterface.getAVNotifyCenter().r())))) {
                if (uVar != null) {
                    uVar.b();
                }
                ChatActivityUtils.t(qQAppInterface, context, vVar.f175240a, vVar.f175241b, vVar.f175242c, vVar.f175244e, vVar.f175245f, vVar.f175248i, vVar.f175249j, false);
                if (uVar != null) {
                    uVar.a();
                }
                return Boolean.TRUE;
            }
            QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return Boolean.FALSE;
        }
        return null;
    }

    public static Boolean d(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar, String str, String str2) {
        String string;
        int i3;
        String string2;
        String str3;
        QLog.w("ChatActivityUtils", 1, "startAdelieVideoCheckByWIFINotice, !isWifiConnected, seq[" + j3 + "]");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.av.r.f74233b);
        sb5.append(qQAppInterface.getCurrentAccountUin());
        String sb6 = sb5.toString();
        Map<String, String> map = vVar.f175249j;
        if (map != null && (str3 = map.get("chat_type")) != null && (str3.equals("randomc2c") || str3.equals("randomgroup"))) {
            sb6 = com.tencent.av.r.f74234c + qQAppInterface.getCurrentAccountUin();
        }
        if (com.tencent.av.r.C0(sb6) > 0) {
            vVar.f175246g = false;
            vVar.f175247h = false;
            vVar.f175251l = false;
            ChatActivityUtils.t(qQAppInterface, context, vVar.f175240a, vVar.f175241b, vVar.f175242c, vVar.f175244e, vVar.f175245f, vVar.f175248i, vVar.f175249j, false);
            return Boolean.TRUE;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        if (systemNetwork == 2) {
            string = context.getString(R.string.dfp);
            string2 = context.getString(R.string.dfl);
        } else if (systemNetwork != 3 && systemNetwork != 4) {
            string = null;
            string2 = null;
        } else {
            string = context.getString(R.string.dfp);
            if (vVar.f175244e) {
                i3 = R.string.dfn;
            } else {
                i3 = R.string.dfm;
            }
            string2 = context.getString(i3);
        }
        QLog.w("ChatActivityUtils", 1, "startAdelieVideoCheckByWIFINotice, netType[" + systemNetwork + "], seq[" + j3 + "]");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            QQCustomDialog a06 = ChatActivityUtils.a0(qQAppInterface, context, 230, string, string2, R.string.d_2, R.string.d_d, new h(vVar, qQAppInterface, context), new i(uVar));
            if (a06 != null) {
                a06.setOnCancelListener(new j(uVar));
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean e(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar) {
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isDAudioEnable, seq[" + j3 + "]");
        PopupDialog.o0(context, 230, context.getString(R.string.dfp), context.getString(R.string.d96), R.string.cancel, R.string.ddx, new m(uVar), null);
        if (vVar.f175244e) {
            ReportController.o(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
            if (vVar.f175240a == 1024) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_language_false", 0, 0, "", "", "", "");
            }
        }
        return Boolean.FALSE;
    }

    public static Boolean f(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar, String str, String str2) {
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, isMsgShielded, seq[" + j3 + "]");
        if (vVar.f175244e) {
            ReportController.o(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
        }
        QQCustomDialog o06 = PopupDialog.o0(context, 230, context.getString(R.string.dfp), context.getString(R.string.djv), R.string.d_2, R.string.d_e, new q(qQAppInterface, vVar, j3, context, uVar, str, str2), new r(vVar, uVar));
        if (o06 != null) {
            o06.setOnCancelListener(new s(vVar, uVar));
        }
        return Boolean.FALSE;
    }

    public static Boolean g(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar, String str, String str2) {
        if (!com.tencent.mobileqq.nearby.h.b(qQAppInterface).h()) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatActivityUtils", 2, "startVideo don't allow date session!");
            }
            QQCustomDialog o06 = PopupDialog.o0(context, 230, null, context.getString(R.string.dju), R.string.d_2, R.string.d_e, new n(qQAppInterface, vVar, j3, context, uVar, str, str2), new o(vVar, uVar));
            if (o06 != null) {
                o06.setOnCancelListener(new p(vVar, uVar));
            }
            return Boolean.FALSE;
        }
        return null;
    }

    public static Boolean h(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar) {
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isNetSupport, seq[" + j3 + "]");
        QQToast.makeText(context, R.string.cgc, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        if (vVar.f175244e) {
            ReportController.o(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
            if (vVar.f175240a == 1024) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_network_false", 0, 0, "", "", "", "");
            }
        }
        return Boolean.TRUE;
    }

    public static Boolean i(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar) {
        DataReport.Y(true, true);
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, isPhoneCalling, seq[" + j3 + "]");
        PopupDialog.o0(context, 230, context.getString(R.string.dfp), context.getString(R.string.dg9), R.string.cancel, R.string.f171151ok, new DialogInterfaceOnClickListenerC7174k(uVar, vVar), null);
        DataReport.m(vVar.f175244e);
        if (vVar.f175240a == 1024) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_phone_calling_false", 0, 0, "", "", "", "");
        }
        return Boolean.FALSE;
    }

    public static Boolean j(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar) {
        String str;
        new com.tencent.av.core.f();
        AVCoreSystemInfo.getCpuInfo();
        int cpuArchitecture = AVCoreSystemInfo.getCpuArchitecture();
        long maxCpuFreq = AVCoreSystemInfo.getMaxCpuFreq();
        if (cpuArchitecture >= 3 && maxCpuFreq / 1000 >= 800) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
        }
        Map<String, String> map = vVar.f175249j;
        if (map != null) {
            str = map.get("chat_type");
        } else {
            str = "";
        }
        String str2 = str;
        if (vVar.f175240a == 1011) {
            PopupDialog.o0(context, 230, context.getString(R.string.dfp), context.getString(R.string.dkn), R.string.cancel, R.string.ddx, new l(uVar), null);
            if (str2.equals("randomc2c")) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80053B1", "0X80053B1", 0, 0, "", "", "", "");
            } else {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
            }
            return Boolean.FALSE;
        }
        QQToast.makeText(context, R.string.d_c, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        if (vVar.f175244e) {
            ReportController.o(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
            if (vVar.f175240a == 1024) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_tmp_address_false", 0, 0, "", "", "", "");
            }
        }
        return Boolean.TRUE;
    }

    public static Boolean k(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar, String str, String str2) {
        String string;
        String string2;
        String str3;
        String str4;
        String str5;
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isWifiConnected, seq[" + j3 + "]");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.av.r.f74233b);
        sb5.append(qQAppInterface.getCurrentAccountUin());
        String sb6 = sb5.toString();
        Map<String, String> map = vVar.f175249j;
        if (map != null && (str5 = map.get("chat_type")) != null && (str5.equals("randomc2c") || str5.equals("randomgroup"))) {
            sb6 = com.tencent.av.r.f74234c + qQAppInterface.getCurrentAccountUin();
        }
        if (com.tencent.av.r.C0(sb6) > 0) {
            vVar.f175246g = false;
            vVar.f175247h = false;
            vVar.f175251l = false;
            ChatActivityUtils.l0(j3, qQAppInterface, context, uVar, vVar, str, str2);
            return Boolean.TRUE;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        if (systemNetwork == 2) {
            string = context.getString(R.string.dfp);
            string2 = context.getString(R.string.dfl);
            if (vVar.f175244e) {
                ReportController.o(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
            }
        } else {
            if (systemNetwork != 3 && systemNetwork != 4) {
                str3 = null;
                str4 = null;
                QLog.w("ChatActivityUtils", 1, "startVideoCheck, netType[" + systemNetwork + "], seq[" + j3 + "]");
                if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    QQCustomDialog a06 = ChatActivityUtils.a0(qQAppInterface, context, 230, str3, str4, R.string.d_2, R.string.d_d, new a(vVar, systemNetwork, j3, qQAppInterface, context, uVar, str, str2), new b(vVar, systemNetwork, uVar));
                    if (a06 != null) {
                        a06.setOnCancelListener(new c(vVar, systemNetwork, uVar));
                    }
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            }
            string = context.getString(R.string.dfp);
            if (vVar.f175244e) {
                string2 = context.getString(R.string.dfn);
                ReportController.o(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
            } else {
                string2 = context.getString(R.string.dfm);
            }
        }
        str3 = string;
        str4 = string2;
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, netType[" + systemNetwork + "], seq[" + j3 + "]");
        if (TextUtils.isEmpty(str3)) {
        }
        return Boolean.TRUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Boolean l(long j3, QQAppInterface qQAppInterface, Context context, ChatActivityUtils.u uVar, ChatActivityUtils.v vVar, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        int L = qQAppInterface.getAVNotifyCenter().L();
        int J = qQAppInterface.getAVNotifyCenter().J();
        int H = qQAppInterface.getAVNotifyCenter().H();
        Map<String, String> map = vVar.f175249j;
        if (map != null) {
            str3 = map.get("chat_type");
            if (str3 != null && (str3.equals("randomgroup") || str3.equals("randomc2c"))) {
                str4 = vVar.f175249j.get("session_name");
                boolean z16 = true;
                if ((H != 1 || H == 2) && J >= 1 && J <= 5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ChatActivityUtils", 2, "startVideo is in Double Random Call!");
                    }
                    if (str4 != null || !str3.equals("randomc2c") || !str4.equals(qQAppInterface.getAVNotifyCenter().I())) {
                        QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        return Boolean.TRUE;
                    }
                    return null;
                }
                boolean z17 = vVar.f175250k;
                if (z17 && ((H == 3 || H == 4) && J >= 1 && J <= 5)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ChatActivityUtils", 2, "startVideo is Multi Random calling!");
                    }
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, qQAppInterface.getAVNotifyCenter().I())) {
                        z16 = false;
                    }
                    if (!z16) {
                        PopupDialog.o0(context, 230, null, context.getString(R.string.dbj), R.string.d_2, R.string.d_d, new d(vVar, j3, qQAppInterface, context, uVar, str, str2), new e(uVar));
                        return Boolean.FALSE;
                    }
                    return null;
                }
                if (L == 1) {
                    QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_AUDIO, seq[" + j3 + "]");
                    if (vVar.f175244e && (((str9 = vVar.f175241b) != null && str9.equals(qQAppInterface.getAVNotifyCenter().F())) || (((str10 = vVar.f175243d) != null && str10.equals(qQAppInterface.getAVNotifyCenter().F())) || (vVar.f175240a == 1006 && (((str11 = vVar.f175241b) != null && str11.equals(qQAppInterface.getAVNotifyCenter().r())) || ((str12 = vVar.f175243d) != null && str12.equals(qQAppInterface.getAVNotifyCenter().r()))))))) {
                        if (uVar != null) {
                            uVar.b();
                        }
                        if (qQAppInterface.getAVNotifyCenter().Z(qQAppInterface.getAVNotifyCenter().F())) {
                            Intent intent = new Intent(context, (Class<?>) AVActivity.class);
                            intent.addFlags(262144);
                            intent.addFlags(268435456);
                            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
                            intent.putExtra("GroupId", qQAppInterface.getAVNotifyCenter().F());
                            intent.putExtra("isDoubleVideoMeeting", true);
                            context.startActivity(intent);
                        } else {
                            ChatActivityUtils.w(qQAppInterface, context, vVar.f175240a, vVar.f175241b, vVar.f175242c, vVar.f175243d, vVar.f175244e, vVar.f175245f, vVar.f175248i, vVar.f175249j, false);
                        }
                        if (uVar != null) {
                            uVar.a();
                        }
                    } else {
                        QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                    return Boolean.TRUE;
                }
                if (L == 2) {
                    QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_VIDEO, seq[" + j3 + "]");
                    if (!vVar.f175244e && (((str5 = vVar.f175241b) != null && str5.equals(qQAppInterface.getAVNotifyCenter().F())) || (((str6 = vVar.f175243d) != null && str6.equals(qQAppInterface.getAVNotifyCenter().F())) || (vVar.f175240a == 1006 && (((str7 = vVar.f175241b) != null && str7.equals(qQAppInterface.getAVNotifyCenter().r())) || ((str8 = vVar.f175243d) != null && str8.equals(qQAppInterface.getAVNotifyCenter().r()))))))) {
                        if (uVar != null) {
                            uVar.b();
                        }
                        if (qQAppInterface.getAVNotifyCenter().Z(qQAppInterface.getAVNotifyCenter().F())) {
                            Intent intent2 = new Intent(context, (Class<?>) AVActivity.class);
                            intent2.addFlags(262144);
                            intent2.addFlags(268435456);
                            intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
                            intent2.putExtra("GroupId", qQAppInterface.getAVNotifyCenter().F());
                            intent2.putExtra("isDoubleVideoMeeting", true);
                            context.startActivity(intent2);
                        } else {
                            ChatActivityUtils.w(qQAppInterface, context, vVar.f175240a, vVar.f175241b, vVar.f175242c, vVar.f175243d, vVar.f175244e, vVar.f175245f, vVar.f175248i, vVar.f175249j, false);
                        }
                        if (uVar != null) {
                            uVar.a();
                        }
                    } else {
                        QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                    return Boolean.TRUE;
                }
                if (z17) {
                    if ((L == 3 || L == 4) && qQAppInterface.getAVNotifyCenter().n() > 0) {
                        QLog.w("ChatActivityUtils", 1, "startVideoCheck, \u5b58\u5728\u591a\u4eba\u901a\u8bdd, RelationId[" + qQAppInterface.getAVNotifyCenter().n() + "], sessionType[" + L + "], seq[" + j3 + "]");
                        PopupDialog.o0(context, 230, null, context.getString(R.string.dbj), R.string.d_2, R.string.d_d, new f(vVar, j3, qQAppInterface, context, uVar, str, str2), new g(uVar));
                        return Boolean.FALSE;
                    }
                    return null;
                }
                return null;
            }
        } else {
            str3 = null;
        }
        str4 = null;
        boolean z162 = true;
        if (H != 1) {
        }
        if (QLog.isColorLevel()) {
        }
        if (str4 != null) {
        }
        QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return Boolean.TRUE;
    }
}
