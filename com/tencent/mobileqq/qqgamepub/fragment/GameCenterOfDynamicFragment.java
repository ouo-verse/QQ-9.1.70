package com.tencent.mobileqq.qqgamepub.fragment;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.manager.PageVisitTimeReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GameCenterOfDynamicFragment extends CommonHippyFragment {
    static IPatchRedirector $redirector_;
    private boolean C;
    private PageVisitTimeReporter D;

    public GameCenterOfDynamicFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = false;
            this.D = new PageVisitTimeReporter();
        }
    }

    private static boolean vh(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("missions") || str.contains("missions=&")) {
            return false;
        }
        QLog.i("GameCenterOfDynamicFragment", 1, "It contains red point info.");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void wh(String str, boolean z16, boolean z17, long j3) {
        String str2;
        if (!vh(str)) {
            return;
        }
        if (z16) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        String str3 = str2;
        if (z16 || !z17) {
            yh("14", WadlProxyConsts.PAGE_ID_DOWNLOAD, "790", "79001", "209899", "20", str3, String.valueOf(System.currentTimeMillis() - j3));
        }
    }

    private static void xh(final boolean z16, final boolean z17, final String str, final long j3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterOfDynamicFragment.wh(str, z17, z16, j3);
            }
        }, 128, null, false);
    }

    public static void yh(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            jSONObject.put("ext12", str2);
            jSONObject.put("ext11", str);
            jSONObject.put("ext1", str4);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, str3);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, str5);
            jSONObject.put("ext4", str6);
            jSONObject.put("ext7", str7);
            jSONObject.put("ext46", str8);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e("GameCenterOfDynamicFragment", 1, "[startReport] errors:" + e16.getMessage());
        }
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String string = getParameters().getString("url");
        long j3 = getParameters().getLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START);
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            xh(this.C, hippyQQPreloadEngine.isPredraw(), string, j3);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("GameCenterOfDynamicFragment", 2, "[onDestroy]");
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippySuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.C = true;
            super.onLoadHippySuccess();
        }
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onPause();
        if (QLog.isDevelopLevel()) {
            QLog.i("GameCenterOfDynamicFragment", 2, "[onPause]");
        }
        this.D.c();
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        if (QLog.isDevelopLevel()) {
            QLog.i("GameCenterOfDynamicFragment", 2, "[onResume]");
        }
        this.D.b();
    }
}
