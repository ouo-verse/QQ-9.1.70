package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import qd3.ZootopiaSendArkResult;
import rd3.ShareTarget;

/* loaded from: classes12.dex */
public class ForwardZPlanModShareOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    public ForwardZPlanModShareOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit A(ZootopiaSendArkResult zootopiaSendArkResult) {
        QLog.i("ForwardZPlanModShareOption", 1, "sendDressArk Result " + zootopiaSendArkResult.getResult());
        if (zootopiaSendArkResult.getResult() == 0) {
            ForwardUtils.s0(this.app, 300L);
            C();
            return null;
        }
        G(this.app, 300L);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit B(ZootopiaSendArkResult zootopiaSendArkResult) {
        QLog.i("ForwardZPlanModShareOption", 1, "sendDressArk Result " + zootopiaSendArkResult.getResult());
        if (zootopiaSendArkResult.getResult() == 0) {
            ForwardUtils.s0(this.app, 300L);
            C();
            return null;
        }
        G(this.app, 300L);
        return null;
    }

    private void C() {
        String r16 = r();
        if (TextUtils.isEmpty(r16)) {
            return;
        }
        String string = this.mExtraData.getString("uin");
        String string2 = this.mExtraData.getString("troop_uin");
        int i3 = this.mExtraData.getInt("uintype");
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = string;
        sessionInfo.f179559f = string2;
        com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, r16);
    }

    private void D(List<ShareTarget> list) {
        String r16 = r();
        if (TextUtils.isEmpty(r16)) {
            return;
        }
        for (ShareTarget shareTarget : list) {
            SessionInfo sessionInfo = new SessionInfo();
            int i3 = 1;
            if (shareTarget.getType() == 1) {
                i3 = 0;
            }
            sessionInfo.f179555d = i3;
            sessionInfo.f179557e = String.valueOf(shareTarget.getId());
            com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, r16);
        }
    }

    private void E() {
        int i3;
        final ArrayList arrayList = new ArrayList();
        List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
        if (multiTargetWithoutDataLine != null) {
            for (ResultRecord resultRecord : multiTargetWithoutDataLine) {
                if (resultRecord.getUinType() == 0) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                arrayList.add(new ShareTarget(i3, resultRecord.uin));
            }
        }
        if (v()) {
            ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendZplanArkMessage(arrayList, this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.ae
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit w3;
                    w3 = ForwardZPlanModShareOption.this.w(arrayList, (ZootopiaSendArkResult) obj);
                    return w3;
                }
            });
        } else if (s()) {
            ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendDressArkMessage(arrayList, this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.af
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit x16;
                    x16 = ForwardZPlanModShareOption.this.x(arrayList, (ZootopiaSendArkResult) obj);
                    return x16;
                }
            });
        } else if (u()) {
            ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendShotArkMessage(arrayList, this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.ag
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit y16;
                    y16 = ForwardZPlanModShareOption.this.y(arrayList, (ZootopiaSendArkResult) obj);
                    return y16;
                }
            });
        }
    }

    private void F() {
        String string;
        int i3;
        QLog.i("ForwardZPlanModShareOption", 2, "sendSingleZplanArkMessage");
        if (t()) {
            string = this.mExtraData.getString("troop_uin");
            QLog.i("ForwardZPlanModShareOption", 2, "sendSingleZplanArkMessage groupId by troop_uin = " + string);
            if (TextUtils.isEmpty(string)) {
                string = this.mExtraData.getString("uin");
                QLog.i("ForwardZPlanModShareOption", 2, "sendSingleZplanArkMessage groupId by uin = " + string);
                if (TextUtils.isEmpty(string)) {
                    G(this.app, 300L);
                    return;
                }
            }
            i3 = 2;
        } else {
            string = this.mExtraData.getString("uin");
            i3 = 1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ShareTarget(i3, string));
        QLog.i("ForwardZPlanModShareOption", 2, "sendSingleZplanArkMessage zplan");
        if (v()) {
            ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendZplanArkMessage(arrayList, this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.ab
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit z16;
                    z16 = ForwardZPlanModShareOption.this.z((ZootopiaSendArkResult) obj);
                    return z16;
                }
            });
        } else if (s()) {
            ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendDressArkMessage(arrayList, this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.ac
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = ForwardZPlanModShareOption.this.A((ZootopiaSendArkResult) obj);
                    return A;
                }
            });
        } else if (u()) {
            ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendShotArkMessage(arrayList, this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.ad
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit B;
                    B = ForwardZPlanModShareOption.this.B((ZootopiaSendArkResult) obj);
                    return B;
                }
            });
        }
    }

    private void G(QQAppInterface qQAppInterface, long j3) {
        ThreadManager.getUIHandler().postDelayed(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.forward.ForwardZPlanModShareOption.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f210952d;

            {
                this.f210952d = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardZPlanModShareOption.this, (Object) qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(this.f210952d.getApp(), 1, R.string.f173102he3, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            }
        }, j3);
    }

    private String r() {
        String inputValue = this.mConfirmDialog.getInputValue();
        boolean booleanExtra = this.mIntent.getBooleanExtra("key_zplan_ark_need_send_hint", false);
        if (TextUtils.isEmpty(inputValue) && booleanExtra) {
            return getEditHint();
        }
        return inputValue;
    }

    private boolean t() {
        if (this.mExtraData.getInt("uintype") == 1) {
            return true;
        }
        return false;
    }

    private boolean v() {
        return IZootopiaShareArkService.ZOOTOPIA_ARK_NAME.equalsIgnoreCase(this.mExtraData.getString("forward_ark_app_name"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit w(List list, ZootopiaSendArkResult zootopiaSendArkResult) {
        QLog.i("ForwardZPlanModShareOption", 1, "sendMultiArK game Result " + zootopiaSendArkResult.getResult());
        if (zootopiaSendArkResult.getResult() == 0) {
            ForwardUtils.s0(this.app, 300L);
            D(list);
            return null;
        }
        G(this.app, 300L);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit x(List list, ZootopiaSendArkResult zootopiaSendArkResult) {
        QLog.i("ForwardZPlanModShareOption", 1, "sendMultiArK dress Result " + zootopiaSendArkResult.getResult());
        if (zootopiaSendArkResult.getResult() == 0) {
            ForwardUtils.s0(this.app, 300L);
            D(list);
            return null;
        }
        G(this.app, 300L);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit y(List list, ZootopiaSendArkResult zootopiaSendArkResult) {
        QLog.i("ForwardZPlanModShareOption", 1, "sendMultiArK dress Result " + zootopiaSendArkResult.getResult());
        if (zootopiaSendArkResult.getResult() == 0) {
            ForwardUtils.s0(this.app, 300L);
            D(list);
            return null;
        }
        G(this.app, 300L);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit z(ZootopiaSendArkResult zootopiaSendArkResult) {
        QLog.i("ForwardZPlanModShareOption", 1, "sendZplanArK Result " + zootopiaSendArkResult.getResult());
        if (zootopiaSendArkResult.getResult() == 0) {
            ForwardUtils.s0(this.app, 300L);
            C();
            return null;
        }
        G(this.app, 300L);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mForwardAbilities.add(e.O3);
            this.mForwardAbilities.add(e.P3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (isMultiTarget2Send()) {
            E();
        } else {
            F();
        }
        return super.realForwardTo(true);
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_DRESS.equalsIgnoreCase(this.mExtraData.getString("forward_ark_app_name"));
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_SHOT.equalsIgnoreCase(this.mExtraData.getString("forward_ark_app_name"));
    }
}
