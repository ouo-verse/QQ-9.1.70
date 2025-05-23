package com.tencent.mobileqq.vas;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class VasCommonIPCModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static VasCommonIPCModule f307868d;

    VasCommonIPCModule(String str) {
        super(str);
    }

    public static synchronized VasCommonIPCModule b() {
        VasCommonIPCModule vasCommonIPCModule;
        synchronized (VasCommonIPCModule.class) {
            if (f307868d == null) {
                synchronized (VasCommonIPCModule.class) {
                    if (f307868d == null) {
                        f307868d = new VasCommonIPCModule("VasCommonIPCModule");
                    }
                }
            }
            vasCommonIPCModule = f307868d;
        }
        return vasCommonIPCModule;
    }

    private void c(final int i3) {
        final JSONObject jSONObject = new JSONObject();
        ThemeSwitcher.startSwitch(getThemeId(), ThemeReporter.FROM_SIMPLE, new ThemeSwitchCallback() { // from class: com.tencent.mobileqq.vas.VasCommonIPCModule.1
            @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public boolean postSwitch(int i16) {
                int i17;
                if (i16 == 0) {
                    i17 = 1;
                } else {
                    i17 = 0;
                }
                try {
                    jSONObject.put("result", i17);
                    jSONObject.put("mode", SimpleUIUtil.getCurrentMode(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()));
                    Bundle bundle = new Bundle();
                    bundle.putString("key_theme_switch_json_result", jSONObject.toString());
                    VasCommonIPCModule.this.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
                    return false;
                } catch (JSONException e16) {
                    VasCommonIPCModule.this.callbackResult(i3, EIPCResult.createExceptionResult(e16));
                    return false;
                }
            }
        });
    }

    private String getThemeId() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(qQAppInterface, true, null);
        String string = ThemeSwitchUtil.getPreviousThemeIdVersion(qQAppInterface).getString("themeID");
        if (TextUtils.isEmpty(string)) {
            string = "1000";
        }
        if (isNowThemeIsNight) {
            return "1103";
        }
        return string;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        EIPCResult createResult;
        if ("is_white_name".equals(str)) {
            int i16 = bundle.getInt("managerId", -1);
            if (i16 == 490) {
                boolean n3 = com.tencent.mobileqq.mutualmark.alienation.f.i().n();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("isWhiteName", n3);
                createResult = EIPCResult.createSuccessResult(bundle2);
            } else if (i16 == 491) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("isWhiteName", true);
                createResult = EIPCResult.createSuccessResult(bundle3);
            } else {
                createResult = EIPCResult.createResult(-1, new Bundle());
            }
            callbackResult(i3, createResult);
        } else if ("paySuccess".equals(str)) {
            ((VipInfoHandler) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).notifyUI(5, true, bundle);
            callbackResult(i3, EIPCResult.createResult(0, null));
        } else if ("switch_to_common_theme".equals(str)) {
            c(i3);
        }
        return null;
    }
}
