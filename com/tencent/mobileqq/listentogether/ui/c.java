package com.tencent.mobileqq.listentogether.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.nt.e;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends BaseListenTogetherPanel {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f241165d;

        a(QQCustomDialog qQCustomDialog) {
            this.f241165d = qQCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f241165d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f241167d;

        b(QQCustomDialog qQCustomDialog) {
            this.f241167d = qQCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f241167d.dismiss();
        }
    }

    public c(com.tencent.aio.api.runtime.a aVar, Context context) {
        super(aVar, context);
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public void C() {
        e eVar = this.f241141b;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    protected void G() {
        UiData uiData;
        ListenTogetherSession listenTogetherSession;
        if (this.f241147h) {
            UiData uiData2 = this.f241143d;
            if (uiData2.f241157d != 1 || TextUtils.isEmpty(uiData2.f241158e) || (listenTogetherSession = (uiData = this.f241143d).M) == null || !listenTogetherSession.T || uiData.f241159f == 3) {
                return;
            }
            if (uiData.f241160h) {
                try {
                    if (d72.b.l(TroopUtils.f(), "listen_together_allow_start_admin_guide", false, false)) {
                        return;
                    }
                    d72.b.v(TroopUtils.f(), "listen_together_allow_start_admin_guide", true, false);
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f241142c, 230);
                    createCustomDialog.setMessage("\u4e00\u8d77\u542c\u6b4c\u5141\u8bb8\u7fa4\u6210\u5458\u5f00\u542f\uff0c\u4f60\u53ef\u4ee5\u5728\u4e00\u8d77\u542c\u6b4c-\u8bbe\u7f6e \u4e2d\u5173\u95ed\u6b64\u6743\u9650\u3002").setTitle("\u4e00\u8d77\u542c\u6b4c\u529f\u80fd\u66f4\u65b0").setPositiveButton("\u77e5\u9053\u4e86", new a(createCustomDialog));
                    createCustomDialog.show();
                    return;
                } catch (Exception e16) {
                    d72.b.v(TroopUtils.f(), "listen_together_allow_start_admin_guide", true, false);
                    QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide, admin exception:", e16);
                    return;
                }
            }
            try {
                String m3 = d72.b.m(uiData.f241157d, uiData.f241158e);
                if (d72.b.l(TroopUtils.f(), m3, false, false)) {
                    return;
                }
                d72.b.v(TroopUtils.f(), m3, true, false);
                QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(this.f241142c, 230);
                createCustomDialog2.setMessage("\u672c\u7fa4\u652f\u6301\u7fa4\u6210\u5458\u5f00\u542f\u4e00\u8d77\u542c\u6b4c\u529f\u80fd").setTitle("\u4e00\u8d77\u542c\u6b4c\u529f\u80fd\u66f4\u65b0").setPositiveButton("\u77e5\u9053\u4e86", new b(createCustomDialog2));
                createCustomDialog2.show();
            } catch (Exception e17) {
                UiData uiData3 = this.f241143d;
                d72.b.v(TroopUtils.f(), d72.b.m(uiData3.f241157d, uiData3.f241158e), true, false);
                QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide mem exception:", e17);
            }
        }
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public boolean c() {
        QQAppInterface f16 = TroopUtils.f();
        if (f16 == null || !f16.getCurrentAccountUin().equalsIgnoreCase(this.f241143d.I)) {
            return m();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public boolean m() {
        QQAppInterface f16 = TroopUtils.f();
        if (f16 == null) {
            QLog.w("BaseListenTogetherPanel_Troop", 1, "[isAdmin] appInterface is null");
            return false;
        }
        TroopInfo B = ((TroopManager) f16.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.f241143d.f241158e);
        if (B != null) {
            return B.isOwnerOrAdmin();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public void p() {
        String currentAccountUin;
        super.p();
        UiData uiData = this.f241143d;
        uiData.f241157d = 1;
        uiData.f241158e = this.f241140a.g().r().c().j();
        QQAppInterface f16 = TroopUtils.f();
        if (f16 == null) {
            currentAccountUin = "";
        } else {
            currentAccountUin = f16.getCurrentAccountUin();
        }
        BaseListenTogetherPanel.ReportInfo reportInfo = new BaseListenTogetherPanel.ReportInfo();
        this.f241150k = reportInfo;
        reportInfo.mainAction = "Grp_AIO";
        int j3 = d72.b.j(currentAccountUin, this.f241143d.f241158e);
        BaseListenTogetherPanel.ReportInfo reportInfo2 = this.f241150k;
        reportInfo2.shenFen = j3;
        reportInfo2.reportUin = this.f241143d.f241158e;
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public void q() {
        super.q();
        this.f241148i = true;
    }
}
