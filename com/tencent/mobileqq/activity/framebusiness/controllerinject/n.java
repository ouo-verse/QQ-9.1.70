package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f182356a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f182357b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f182358c;

    /* renamed from: d, reason: collision with root package name */
    private static com.tencent.mobileqq.activity.framebusiness.controllerinject.e f182359d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends DialogUtil.DialogOnClickAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f182360d;

        a(String str) {
            this.f182360d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            TabControlReporter.j(this.f182360d, true);
            n.f182359d.d();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends DialogUtil.DialogOnClickAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f182361d;

        b(String str) {
            this.f182361d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                TabControlReporter.j(this.f182361d, false);
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends DialogUtil.DialogOnClickAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f182362d;

        c(String str) {
            this.f182362d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            TabControlReporter.l(true, this.f182362d.contains("\u201c\u9891\u9053\u201d"));
            n.f182359d.d();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends DialogUtil.DialogOnClickAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f182363d;

        d(String str) {
            this.f182363d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                TabControlReporter.l(false, this.f182363d.contains("\u201c\u9891\u9053\u201d"));
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends DialogUtil.DialogOnClickAdapter {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            TabControlReporter.n(true);
            n.f182359d.d();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f extends DialogUtil.DialogOnClickAdapter {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                TabControlReporter.n(false);
                dialogInterface.dismiss();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35330);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tab");
        String str = File.separator;
        sb5.append(str);
        sb5.append("default_day");
        f182356a = sb5.toString();
        f182357b = "tab" + str + "default_night";
        f182358c = "tab" + str + "default_immerse";
        try {
            f182359d = l.f182354a.get(0).newInstance();
        } catch (Exception e16) {
            QLog.e("TabUIHelper", 1, "TabUIHelper static statement: ", e16);
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        HashMap hashMap = new HashMap();
        hashMap.put(TabDataHelper.TAB_NEW_WORLD, c());
        hashMap.put("GUILD", "\u201c\u9891\u9053\u201d");
        int i3 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (str.contains(str2)) {
                if (i3 == 0) {
                    sb5.append(str3);
                } else {
                    sb5.append("\u548c");
                    sb5.append(str3);
                }
                i3++;
            }
        }
        return sb5.toString();
    }

    public static String c() {
        return com.dataline.util.j.d("\u201c\u5c0f\u4e16\u754c\u201d");
    }

    public static void d(Context context, String str) {
        if (TabDataHelper.getTabFirstNewWorldWithRIJOn(context, str)) {
            String tabFirstShow = TabDataHelper.getTabFirstShow(context, str);
            if (!TextUtils.isEmpty(tabFirstShow)) {
                String b16 = b(tabFirstShow);
                TabControlReporter.m(b16.contains("\u201c\u9891\u9053\u201d"));
                if (f(context, str)) {
                    i(context, b16);
                }
                TabDataHelper.updateTabFirstNewWorldWithRIJOn(context, str, false);
                TabDataHelper.cleanTabFirstShow(context, str);
            }
        }
        String tabFirstShow2 = TabDataHelper.getTabFirstShow(context, str);
        if (!TextUtils.isEmpty(tabFirstShow2)) {
            TabControlReporter.k(tabFirstShow2);
            String b17 = b(tabFirstShow2);
            if (f(context, str)) {
                j(context, b17);
            }
            TabDataHelper.cleanTabFirstShow(context, str);
        }
        if (TabDataHelper.getTabFixNewWorldWithRIJOn(context, str)) {
            TabControlReporter.o();
            if (f(context, str)) {
                k(context);
            }
            TabDataHelper.updateTabFixNewWorldWithRIJOn(context, str, false);
        }
    }

    public static boolean e() {
        boolean z16;
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_TAB_SETTING_ENTRANCE);
        if (expEntity != null && expEntity.isExpOnline() && expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QQ_TAB_SETTING_ENTRANCE_B)) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("TabUIHelper", 1, "tab setting abtest exp_qq_tab_new_B is " + z16);
        return z16;
    }

    public static boolean f(Context context, String str) {
        com.tencent.mobileqq.activity.framebusiness.controllerinject.e eVar;
        if (!TextUtils.isEmpty(TabDataHelper.getTabRuleList(context, str, TabDataHelper.getModelType())) && (eVar = f182359d) != null && !eVar.a()) {
            return true;
        }
        return false;
    }

    public static void g() {
        f182359d.d();
    }

    public static void h(int i3) {
        f182359d.b(i3);
    }

    public static void i(Context context, String str) {
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(context, 230).setMessage("QQ\u9080\u8bf7\u4f60\u4f53\u9a8c" + str + "\uff0c\u5982\u9700\u5173\u95ed\uff0c\u53ef\u5728\u201c\u8bbe\u7f6e-\u8f85\u52a9\u529f\u80fd\u201d\u4e2d\u8fdb\u884c\u8bbe\u7f6e\u3002").setNegativeButton("\u597d\u7684", new d(str)).setPositiveButton("\u53bb\u8bbe\u7f6e", new c(str));
        positiveButton.setCancelable(false);
        positiveButton.show();
    }

    public static void j(Context context, String str) {
        String str2 = "\uff0c\u5982\u9700\u5173\u95ed\uff0c\u53ef\u5728\u201c\u8bbe\u7f6e-\u8f85\u52a9\u529f\u80fd\u201d\u4e2d\u8fdb\u884c\u8bbe\u7f6e\u3002";
        if (!str.contains("\u201c\u9891\u9053\u201d") || !str.contains(c())) {
            if (str.contains("\u201c\u9891\u9053\u201d")) {
                str2 = "\uff0c\u805a\u9996\u7545\u8c08\u559c\u7231\u4e8b\u7269\uff0c\u53ef\u5728\u201c\u8bbe\u7f6e-\u8f85\u52a9\u529f\u80fd\u201d\u4e2d\u8fdb\u884c\u8bbe\u7f6e\u3002";
            } else if (str.contains(c())) {
                str2 = "\uff0c\u7cbe\u5f69\u89c6\u9891\u5237\u4e0d\u505c\uff0c\u53ef\u5728\u201c\u8bbe\u7f6e-\u8f85\u52a9\u529f\u80fd\u201d\u4e2d\u8fdb\u884c\u8bbe\u7f6e\u3002";
            }
        }
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(context, 230).setTitle("\u65b0\u529f\u80fd\u4e0a\u7ebf").setMessage("QQ\u9080\u8bf7\u4f60\u4f53\u9a8c" + str + str2).setNegativeButton("\u597d\u7684", new b(str)).setPositiveButton("\u53bb\u8bbe\u7f6e", new a(str));
        positiveButton.setCancelable(false);
        positiveButton.show();
    }

    public static void k(Context context) {
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(context, 230).setMessage(com.dataline.util.j.d("QQ\u9080\u8bf7\u4f60\u4f53\u9a8c\u201c\u5c0f\u4e16\u754c\u201d\uff0c\u5982\u9700\u5173\u95ed\uff0c\u53ef\u5728\u201c\u8bbe\u7f6e-\u8f85\u52a9\u529f\u80fd\u201d\u4e2d\u8fdb\u884c\u8bbe\u7f6e\u3002")).setNegativeButton("\u597d\u7684", new f()).setPositiveButton("\u53bb\u8bbe\u7f6e", new e());
        positiveButton.setCancelable(false);
        positiveButton.show();
    }
}
