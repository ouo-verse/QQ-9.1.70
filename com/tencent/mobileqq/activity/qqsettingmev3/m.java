package com.tencent.mobileqq.activity.qqsettingmev3;

import android.text.TextUtils;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.qqsettingme.q;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f185098i;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185098i = new AtomicBoolean(false);
        }
    }

    private void A(final BusinessInfoCheckUpdate.AppInfo appInfo, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingmev3.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.y(z16, appInfo);
            }
        }, 16, null, false);
    }

    private void B() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && v(this.f185016h.getValue())) {
            ((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_MYGAME_DRAWER, 31);
        }
        QLog.i("QQSettingMyGameProcessor", 2, "reportRedTouchClick,hasRedTouch:" + this.f185098i);
    }

    private JSONObject u() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMECENTER_SIDEBAR_MY_GAME_CONFIG);
    }

    private boolean v(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.iNewFlag.get() != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        String str;
        BusinessInfoCheckUpdate.AppInfo value = this.f185016h.getValue();
        String str2 = "";
        if (v(value)) {
            str2 = value.type.get() + "";
            str = "1";
        } else {
            str = "0";
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9744").setExt(1, "974401").setOperId("989688").setExt(12, "9531").setExt(4, "20").setExt(5, str).setExt(6, str2);
        wadlReportBuilder.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str;
        if (!z16 && this.f185098i.get()) {
            return;
        }
        this.f185098i.set(v(appInfo));
        String str2 = "";
        if (this.f185098i.get() && appInfo != null) {
            str2 = appInfo.type.get() + "";
            str = "1";
        } else {
            str = "0";
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9744").setExt(1, "974401").setOperId("989687").setExt(12, "9531").setExt(4, "8").setExt(5, str).setExt(6, str2);
        wadlReportBuilder.report();
    }

    private void z() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingmev3.k
            @Override // java.lang.Runnable
            public final void run() {
                m.this.x();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.d(aVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInfo, Boolean.valueOf(z16));
            return;
        }
        super.j(appInfo, z16);
        if (!this.f259745f) {
            return;
        }
        boolean v3 = v(appInfo);
        if (v3) {
            A(appInfo, false);
        }
        QLog.i("QQSettingMyGameProcessor", 2, "updateRedTouchDataForMenu,hasRedTouch:" + v3);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    public void q(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        String optString = u().optString(WadlProxyConsts.KEY_JUMP_URL);
        QLog.i("QQSettingMyGameProcessor", 2, "onBizClick:" + optString);
        if (TextUtils.isEmpty(optString)) {
            QLog.e("QQSettingMyGameProcessor", 1, "jumpUrl is empty");
            return;
        }
        GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, optString);
        z();
        B();
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_my_game";
    }
}
