package com.tencent.mobileqq.activity.qqsettingme;

import android.text.TextUtils;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bn extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f184977i;

    public bn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184977i = new AtomicBoolean(false);
        }
    }

    private boolean A(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.iNewFlag.get() != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(final boolean z16) {
        final boolean f16 = f();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bm
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.B(z16, f16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        String str;
        BusinessInfoCheckUpdate.AppInfo value = this.f185016h.getValue();
        String str2 = "";
        if (A(value)) {
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
    public /* synthetic */ void E(boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str;
        if (!z16 && this.f184977i.get()) {
            return;
        }
        this.f184977i.set(A(appInfo));
        String str2 = "";
        if (this.f184977i.get() && appInfo != null) {
            str2 = appInfo.type.get() + "";
            str = "1";
        } else {
            str = "0";
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9744").setExt(1, "974401").setOperId("989687").setExt(12, "9531").setExt(4, "8").setExt(5, str).setExt(6, str2);
        wadlReportBuilder.report();
    }

    private void F() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bj
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.D();
            }
        }, 16, null, false);
    }

    private void G(final BusinessInfoCheckUpdate.AppInfo appInfo, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bk
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.E(z16, appInfo);
            }
        }, 16, null, false);
    }

    private void H() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && A(this.f185016h.getValue())) {
            ((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_MYGAME_DRAWER, 31);
        }
        QLog.i("QQSettingMyGameProcessor", 2, "reportRedTouchClick,hasRedTouch:" + this.f184977i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0022  */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(boolean z16, boolean z17) {
        boolean z18;
        int i3;
        try {
            View i16 = com.tencent.mobileqq.qqsettingme.a.i("d_my_game", Boolean.FALSE);
            if (i16 != null) {
                if (!z17 && !com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_my_game"))) {
                    z18 = false;
                    if (!z18) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                    i16.setVisibility(i3);
                    if (z18 && z16) {
                        G(this.f185016h.getValue(), true);
                        return;
                    }
                }
                z18 = true;
                if (!z18) {
                }
                i16.setVisibility(i3);
                if (z18) {
                }
            }
        } catch (Throwable th5) {
            QLog.e("QQSettingMeBaseProcessor", 1, th5, new Object[0]);
        }
    }

    private void y(final boolean z16, boolean z17) {
        if (z17) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bl
                @Override // java.lang.Runnable
                public final void run() {
                    bn.this.C(z16);
                }
            }, 16, null, false);
        } else {
            B(z16, f());
        }
    }

    private JSONObject z() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMECENTER_SIDEBAR_MY_GAME_CONFIG);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.d(aVar);
            y(false, true);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public boolean f() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (z().optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QQSettingMyGameProcessor", 2, "needHide:" + z16 + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, appInfo, Boolean.valueOf(z16));
            return;
        }
        super.j(appInfo, z16);
        if (!this.f259745f) {
            return;
        }
        boolean A = A(appInfo);
        if (A) {
            G(appInfo, false);
        }
        QLog.i("QQSettingMyGameProcessor", 2, "updateRedTouchDataForMenu,hasRedTouch:" + A);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            y(true, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    public void q(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        String optString = z().optString(WadlProxyConsts.KEY_JUMP_URL);
        QLog.i("QQSettingMyGameProcessor", 2, "onBizClick:" + optString);
        if (TextUtils.isEmpty(optString)) {
            QLog.e("QQSettingMyGameProcessor", 1, "jumpUrl is empty");
            return;
        }
        GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, optString);
        F();
        H();
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
