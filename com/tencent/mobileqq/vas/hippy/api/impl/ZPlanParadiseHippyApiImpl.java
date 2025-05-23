package com.tencent.mobileqq.vas.hippy.api.impl;

import cl3.a;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.mobileqq.vas.hippy.api.IZPlanParadiseHippyApi;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import k13.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import qv4.ak;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/impl/ZPlanParadiseHippyApiImpl;", "Lcom/tencent/mobileqq/vas/hippy/api/IZPlanParadiseHippyApi;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getHippyAPIProvider", "", "moduleName", "", "isZplanParadiseModule", "Lqv4/ak;", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "", "preloadHippyRes", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanParadiseHippyApiImpl implements IZPlanParadiseHippyApi {
    private static final String BUSINESS_NAME_HEAD_SMALL_HOME = "QQSmallHouse";
    private static final String BUSINESS_NAME_HEAD_SUPER_QQSHOW = "superqqshow";
    public static final String TAG = "ZPlanParadiseHippyApiImpl";

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    @Override // com.tencent.mobileqq.vas.hippy.api.IZPlanParadiseHippyApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isZplanParadiseModule(String moduleName) {
        boolean z16;
        boolean z17;
        boolean startsWith;
        boolean startsWith2;
        QLog.i(TAG, 1, "isZPlanParadiseModule moduleName:" + moduleName);
        if (moduleName != null) {
            startsWith2 = StringsKt__StringsJVMKt.startsWith(moduleName, BUSINESS_NAME_HEAD_SUPER_QQSHOW, true);
            if (startsWith2) {
                z16 = true;
                if (!z16) {
                    return true;
                }
                if (moduleName != null) {
                    startsWith = StringsKt__StringsJVMKt.startsWith(moduleName, "QQSmallHouse", true);
                    if (startsWith) {
                        z17 = true;
                        return !z17;
                    }
                }
                z17 = false;
                if (!z17) {
                }
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.vas.hippy.api.IZPlanParadiseHippyApi
    public void preloadHippyRes(ak hippyInfo) {
        Intrinsics.checkNotNullParameter(hippyInfo, "hippyInfo");
        ((a) vb3.a.f441346a.b(a.class)).preloadHippyRes(hippyInfo);
    }

    @Override // com.tencent.mobileqq.vas.hippy.api.IZPlanParadiseHippyApi
    public HippyAPIProvider getHippyAPIProvider() {
        QLog.i(TAG, 1, "getHippyAPIProvider");
        return new b();
    }
}
