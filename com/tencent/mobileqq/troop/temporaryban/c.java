package com.tencent.mobileqq.troop.temporaryban;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SecurityButton;
import com.tencent.qqnt.kernel.nativeinterface.SecurityInfo;
import java.util.ArrayList;
import java.util.List;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBeatRsp;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBtn;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f299209a;

    /* renamed from: b, reason: collision with root package name */
    private List<FunctionLockMsg$FunctionLockBtn> f299210b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
    /* loaded from: classes19.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f299212d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f299213e;

        b(Context context, String str) {
            this.f299212d = context;
            this.f299213e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, context, str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f299212d, RouterConstants.UI_ROUTE_BROWSER);
            activityURIRequest.extra().putString("url", this.f299213e);
            QRoute.startUri(activityURIRequest, (o) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.temporaryban.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class DialogInterfaceOnClickListenerC8783c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f299215d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f299216e;

        DialogInterfaceOnClickListenerC8783c(Context context, String str) {
            this.f299215d = context;
            this.f299216e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, context, str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.f299215d, this.f299216e, 2010, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final c f299218a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64808);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f299218a = new c();
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private DialogInterface.OnClickListener a() {
        return new a();
    }

    private DialogInterface.OnClickListener b(String str, Context context) {
        return new b(context, str);
    }

    private DialogInterface.OnClickListener c(String str, Context context) {
        return new DialogInterfaceOnClickListenerC8783c(context, str);
    }

    private DialogInterface.OnClickListener d(String str, Context context, int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return a();
            }
            return c(str, context);
        }
        return b(str, context);
    }

    public static c e() {
        return d.f299218a;
    }

    public void f(AppInterface appInterface, Context context, SecurityInfo securityInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, context, securityInfo);
            return;
        }
        if (appInterface != null && (context instanceof Activity) && securityInfo != null) {
            String wording = securityInfo.getWording();
            ArrayList<SecurityButton> buttons = securityInfo.getButtons();
            if (!TextUtils.isEmpty(wording) && buttons != null && !buttons.isEmpty()) {
                if (buttons.size() == 1) {
                    SecurityButton securityButton = buttons.get(0);
                    DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.frc), wording, (String) null, securityButton.getWording(), d(securityButton.getUrl(), context, securityButton.getJumpType().ordinal()), (DialogInterface.OnClickListener) null).show();
                } else {
                    SecurityButton securityButton2 = buttons.get(0);
                    SecurityButton securityButton3 = buttons.get(1);
                    DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.frc), wording, securityButton2.getWording(), securityButton3.getWording(), d(securityButton3.getUrl(), context, securityButton3.getJumpType().ordinal()), d(securityButton2.getUrl(), context, securityButton2.getJumpType().ordinal())).show();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("JoinTroopTemporaryBanHelper", 2, "showTips Succ");
                    return;
                }
                return;
            }
            QLog.e("JoinTroopTemporaryBanHelper", 1, "showTips Server return data error!");
            QQToast.makeText(context, HardCodeUtil.qqStr(R.string.f173052s4), 0).show();
            return;
        }
        QLog.e("JoinTroopTemporaryBanHelper", 1, "showTips arg error!");
    }

    public void g(AppInterface appInterface, Context context, FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp, String str) {
        List<FunctionLockMsg$FunctionLockBtn> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, context, functionLockMsg$FunctionLockBeatRsp, str);
            return;
        }
        if (appInterface != null && (context instanceof Activity) && functionLockMsg$FunctionLockBeatRsp != null) {
            this.f299209a = functionLockMsg$FunctionLockBeatRsp.wording.get();
            this.f299210b = functionLockMsg$FunctionLockBeatRsp.btns.get();
            if (!TextUtils.isEmpty(this.f299209a) && (list = this.f299210b) != null && !list.isEmpty()) {
                if (this.f299210b.size() == 1) {
                    FunctionLockMsg$FunctionLockBtn functionLockMsg$FunctionLockBtn = this.f299210b.get(0);
                    DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.frc), this.f299209a, (String) null, functionLockMsg$FunctionLockBtn.woding.get(), d(functionLockMsg$FunctionLockBtn.url.get(), context, functionLockMsg$FunctionLockBtn.jump_type.get()), (DialogInterface.OnClickListener) null).show();
                } else {
                    FunctionLockMsg$FunctionLockBtn functionLockMsg$FunctionLockBtn2 = this.f299210b.get(0);
                    FunctionLockMsg$FunctionLockBtn functionLockMsg$FunctionLockBtn3 = this.f299210b.get(1);
                    DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.frc), this.f299209a, functionLockMsg$FunctionLockBtn2.woding.get(), functionLockMsg$FunctionLockBtn3.woding.get(), d(functionLockMsg$FunctionLockBtn3.url.get(), context, functionLockMsg$FunctionLockBtn3.jump_type.get()), d(functionLockMsg$FunctionLockBtn2.url.get(), context, functionLockMsg$FunctionLockBtn2.jump_type.get())).show();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("JoinTroopTemporaryBanHelper", 2, "showTips Succ troopUin = " + str);
                    return;
                }
                return;
            }
            QLog.e("JoinTroopTemporaryBanHelper", 1, "showTips Server return data error!");
            QQToast.makeText(context, HardCodeUtil.qqStr(R.string.f173052s4), 0).show();
            return;
        }
        QLog.e("JoinTroopTemporaryBanHelper", 1, "showTips arg error!");
    }
}
