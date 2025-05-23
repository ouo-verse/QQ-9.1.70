package com.tencent.mobileqq.troop.logic;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.groupclass.b;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.utils.m;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HomeworkTroopController extends com.tencent.mobileqq.troop.groupclass.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static long f297768e;

    /* renamed from: d, reason: collision with root package name */
    public boolean f297769d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.logic.HomeworkTroopController$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ HomeworkTroopController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (((BaseActivity) ((com.tencent.mobileqq.troop.groupclass.a) this.this$0).f296175b.get()) != null && QLog.isColorLevel()) {
                QLog.d("HomeworkTroopController", 2, "showAIOPanelTip anchorView null.");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76489);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f297768e = -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00f7 A[Catch: JSONException -> 0x0112, TryCatch #0 {JSONException -> 0x0112, blocks: (B:13:0x0095, B:15:0x00a0, B:17:0x00aa, B:18:0x00b4, B:20:0x00ba, B:21:0x00d3, B:23:0x00da, B:26:0x00de, B:27:0x00e9, B:29:0x00f7, B:30:0x0103, B:38:0x00e6), top: B:12:0x0095 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        long j3;
        com.tencent.mobileqq.troop.groupclass.a aVar;
        int i3 = configurationService$Config.version.get();
        int i16 = qQAppInterface.getPreferences().getInt(AppConstants.Preferences.HOMEWORK_TROOP_CONFIG_VERSION_CODE, 0);
        if (QLog.isColorLevel()) {
            QLog.i("HomeworkTroopController", 2, "handleHomeworkTroopConfig: ,version: " + configurationService$Config.version.get() + "| localVersion: " + i16);
        }
        if (i3 != i16) {
            List<String> X0 = ConfigServlet.X0(configurationService$Config);
            SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(AppConstants.Preferences.HOMEWORK_TROOP_CONFIG + qQAppInterface.getCurrentUin(), 0).edit();
            if (X0 != null && X0.size() > 0) {
                String str = X0.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("HomeworkTroopController", 2, "parse handleHomeworkTroopConfig: ", str);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("HWTroopAIOTip")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("HWTroopAIOTip");
                        if (jSONObject2.has("show")) {
                            edit.putInt("homework_troop_aio_tip_show", jSONObject2.getInt("show"));
                        }
                    }
                    if (jSONObject.has("keywordConfigs")) {
                        String jSONArray = jSONObject.getJSONArray("keywordConfigs").toString();
                        edit.putString("troop_school_keyword_config", jSONArray);
                        ((m) qQAppInterface.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER)).b(jSONArray);
                    }
                    try {
                        j3 = Long.parseLong(jSONObject.optString("grayTroopUin"));
                        try {
                            edit.putLong("homework_troop_ent", j3);
                        } catch (NumberFormatException unused) {
                            edit.putLong("homework_troop_ent", Long.MIN_VALUE);
                            b bVar = (b) qQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER);
                            aVar = bVar.f296177d;
                            if (aVar instanceof HomeworkTroopController) {
                            }
                            ((ITroopAppService) qQAppInterface.getRuntimeService(ITroopAppService.class, "all")).tryParseAppConfig(jSONObject);
                            edit.apply();
                            qQAppInterface.getPreferences().edit().putInt(AppConstants.Preferences.HOMEWORK_TROOP_CONFIG_VERSION_CODE, i3).apply();
                            return;
                        }
                    } catch (NumberFormatException unused2) {
                        j3 = 0;
                    }
                    b bVar2 = (b) qQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER);
                    aVar = bVar2.f296177d;
                    if (aVar instanceof HomeworkTroopController) {
                        ((HomeworkTroopController) aVar).h(j3);
                        ((HomeworkTroopController) bVar2.f296177d).i();
                    }
                    ((ITroopAppService) qQAppInterface.getRuntimeService(ITroopAppService.class, "all")).tryParseAppConfig(jSONObject);
                } catch (JSONException unused3) {
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[2];
                        objArr[0] = "handleHomeworkTroopConfig json fail. content: ";
                        if (str == null) {
                            str = "";
                        }
                        objArr[1] = str;
                        QLog.e("HomeworkTroopController", 2, objArr);
                    }
                    edit.clear();
                }
            } else {
                edit.clear();
            }
            edit.apply();
            qQAppInterface.getPreferences().edit().putInt(AppConstants.Preferences.HOMEWORK_TROOP_CONFIG_VERSION_CODE, i3).apply();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("HomeworkTroopController", 2, "handleHomeworkTroopConfig:localVersion == version = " + i3);
        }
    }

    private void h(long j3) {
        boolean z16 = false;
        boolean z17 = true;
        try {
            long parseLong = Long.parseLong(this.f296176c.f179557e);
            if (j3 == Long.MIN_VALUE || (j3 >= 0 && parseLong < j3)) {
                z16 = true;
            }
            z17 = z16;
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.e("HomeworkTroopController", 2, "parse troopUin error. troopUin=", this.f296176c.f179557e);
            }
        }
        this.f297769d = z17;
        if (QLog.isColorLevel() && this.f296176c != null) {
            QLog.e("HomeworkTroopController", 2, "updateEnt troopUin = " + this.f296176c.f179557e + ", = enableEnt" + this.f297769d);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkTroopController", 2, "handleHomeworkListIcon start. isHomeworkTroop=", Boolean.valueOf(z16));
        }
        if (this.f297769d && z16) {
            if (QLog.isColorLevel()) {
                QLog.d("HomeworkTroopController", 2, "handleHomeworkListIcon start. isHomeworkTroop=" + z16);
            }
            QQAppInterface qQAppInterface = this.f296174a;
            String str = this.f296176c.f179557e;
            eu.h(qQAppInterface, str, "homework", "AioSee_Show", 0, 0, str, "", "", eu.d(qQAppInterface, str));
            ((IWebProcessManagerService) this.f296174a.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcessUnderStrategy(20, null);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("HomeworkTroopController", 2, "updateHomeworkListEntry");
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.logic.HomeworkTroopController.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HomeworkTroopController.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                TroopInfo B;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopManager troopManager = (TroopManager) ((com.tencent.mobileqq.troop.groupclass.a) HomeworkTroopController.this).f296174a.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null && ((com.tencent.mobileqq.troop.groupclass.a) HomeworkTroopController.this).f296176c != null && (B = troopManager.B(((com.tencent.mobileqq.troop.groupclass.a) HomeworkTroopController.this).f296176c.f179557e)) != null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("HomeworkTroopController", 2, "updateHomeworkListEntry-handleHomeworkListIcon");
                    }
                    HomeworkTroopController.this.f(B.isHomeworkTroop());
                    HomeworkTroopController.this.e();
                }
            }
        });
    }
}
