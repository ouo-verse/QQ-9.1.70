package com.tencent.aelight.camera.ae.download;

import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.light.CheckResult;
import org.light.LightResourceChecker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a*\u0010\t\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0018\u0010\f\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aelight/camera/ae/download/AEResBeanWrapper;", "aeResInfo", "", "soRootPath", "Lorg/light/CheckResult;", "checkResult", "", "isFirst", "", "c", "", "code", "e", "aelight_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class k {
    public static final void c(final AEResBeanWrapper aEResBeanWrapper, final String soRootPath, final CheckResult checkResult, final boolean z16) {
        Intrinsics.checkNotNullParameter(soRootPath, "soRootPath");
        if (aEResBeanWrapper == null || TextUtils.isEmpty(soRootPath) || Intrinsics.areEqual(AEResInfo.PAG_BASIC64, aEResBeanWrapper.agentType) || Intrinsics.areEqual(AEResInfo.PAG_BASIC32, aEResBeanWrapper.agentType) || Intrinsics.areEqual(AEResInfo.FILAMENT_BASIC64, aEResBeanWrapper.agentType) || Intrinsics.areEqual(AEResInfo.FILAMENT_BASIC32, aEResBeanWrapper.agentType) || Intrinsics.areEqual(AEResInfo.AGENT_TYPE_AE_BASE_RES, aEResBeanWrapper.agentType) || !QzoneConfig.enableCheckAEResMd5(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount())) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.i
            @Override // java.lang.Runnable
            public final void run() {
                k.d(soRootPath, aEResBeanWrapper, checkResult, z16);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String soRootPath, AEResBeanWrapper aEResBeanWrapper, CheckResult checkResult, boolean z16) {
        String substring;
        Intrinsics.checkNotNullParameter(soRootPath, "$soRootPath");
        try {
            if (!Intrinsics.areEqual(AEResInfo.LIGHT_SDK_BASIC64, aEResBeanWrapper.agentType) && !Intrinsics.areEqual(AEResInfo.LIGHT_SDK_BASIC32, aEResBeanWrapper.agentType)) {
                substring = soRootPath + aEResBeanWrapper.bundleName + AECameraConstants.BUNDLE;
            } else {
                substring = soRootPath.substring(0, soRootPath.length() - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            if (checkResult == null) {
                checkResult = LightResourceChecker.checkLightResourcesError(substring);
            }
            if (checkResult.checkPass) {
                return;
            }
            ms.a.f("AEResUtil", "aeResInfo" + aEResBeanWrapper.agentType + "check md5 " + checkResult.errorCode);
            HashMap<String, String> hashMap = new HashMap<>();
            String str = aEResBeanWrapper.agentType;
            Intrinsics.checkNotNullExpressionValue(str, "aeResInfo.agentType");
            hashMap.put("light_bundle_name", str);
            hashMap.put("light_bundle_check_error_info", String.valueOf(checkResult.errorCode));
            hashMap.put("light_bundle_check_error_path", checkResult.errorPath.toString());
            hashMap.put("light_bundle_check_error_path_length", String.valueOf(checkResult.errorLength));
            hashMap.put("light_bundle_check_right_path_length", String.valueOf(checkResult.recordLength));
            hashMap.put("light_bundle_check_first_report", String.valueOf(z16));
            com.tencent.aelight.camera.ae.report.b.b().o(hashMap);
        } catch (Exception e16) {
            String message = e16.getMessage();
            if (message == null) {
                message = "";
            }
            ms.a.c("AEResUtil", message);
        }
    }

    public static final void e(final AEResBeanWrapper aEResBeanWrapper, final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.j
            @Override // java.lang.Runnable
            public final void run() {
                k.f(AEResBeanWrapper.this, i3);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AEResBeanWrapper aEResBeanWrapper, int i3) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (aEResBeanWrapper == null || (str = aEResBeanWrapper.agentType) == null) {
            str = "";
        }
        hashMap.put("light_bundle_name", str);
        hashMap.put("light_bundle_gzip_status", String.valueOf(i3));
        com.tencent.aelight.camera.ae.report.b.b().d1(hashMap);
    }
}
