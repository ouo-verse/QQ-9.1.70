package com.tencent.mobileqq.zplan.cc.util;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\bR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/e;", "", "", tl.h.F, "f", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "b", "", "agentType", "c", "", "renderEngine", "d", "g", "resId", "a", "Z", "isFilamentFaceResReady", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f332557a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isFilamentFaceResReady;

    e() {
    }

    private final boolean b(AEResInfo aeResInfo) {
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(aeResInfo) == 1;
    }

    private final boolean c(String agentType) {
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(agentType);
    }

    private final boolean h() {
        boolean z16;
        AEResInfo LIGHT_RES_BASE_PACKAGE = AEResInfo.LIGHT_RES_BASE_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BASE_PACKAGE, "LIGHT_RES_BASE_PACKAGE");
        if (b(LIGHT_RES_BASE_PACKAGE)) {
            AEResInfo LIGHT_RES_FILAMENT = AEResInfo.LIGHT_RES_FILAMENT;
            Intrinsics.checkNotNullExpressionValue(LIGHT_RES_FILAMENT, "LIGHT_RES_FILAMENT");
            if (b(LIGHT_RES_FILAMENT)) {
                AEResInfo LIGHT_RES_PAG = AEResInfo.LIGHT_RES_PAG;
                Intrinsics.checkNotNullExpressionValue(LIGHT_RES_PAG, "LIGHT_RES_PAG");
                if (b(LIGHT_RES_PAG)) {
                    z16 = true;
                    String str = AEResInfo.LIGHT_RES_BUNDLE_FACE.agentType;
                    Intrinsics.checkNotNullExpressionValue(str, "LIGHT_RES_BUNDLE_FACE.agentType");
                    boolean c16 = c(str);
                    String str2 = AEResInfo.LIGHT_RES_BUNDLE_3DMM.agentType;
                    Intrinsics.checkNotNullExpressionValue(str2, "LIGHT_RES_BUNDLE_3DMM.agentType");
                    boolean c17 = c(str2);
                    QLog.i("ZPlanCamera", 1, "soReady = " + z16 + ", faceBundleReady = " + c16);
                    return !z16 ? false : false;
                }
            }
        }
        z16 = false;
        String str3 = AEResInfo.LIGHT_RES_BUNDLE_FACE.agentType;
        Intrinsics.checkNotNullExpressionValue(str3, "LIGHT_RES_BUNDLE_FACE.agentType");
        boolean c162 = c(str3);
        String str22 = AEResInfo.LIGHT_RES_BUNDLE_3DMM.agentType;
        Intrinsics.checkNotNullExpressionValue(str22, "LIGHT_RES_BUNDLE_3DMM.agentType");
        boolean c172 = c(str22);
        QLog.i("ZPlanCamera", 1, "soReady = " + z16 + ", faceBundleReady = " + c162);
        return !z16 ? false : false;
    }

    public final String a(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        return ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).getFilamentFaceTemplatePath(resId);
    }

    public final boolean g() {
        if (!isFilamentFaceResReady) {
            isFilamentFaceResReady = ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).isFilamentFaceResReady();
        }
        return isFilamentFaceResReady;
    }

    private final boolean f() {
        boolean z16;
        if (e(this, 0, 1, null)) {
            AEResInfo LIGHT_RES_BUNDLE_ACE3D = AEResInfo.LIGHT_RES_BUNDLE_ACE3D;
            Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_ACE3D, "LIGHT_RES_BUNDLE_ACE3D");
            if (b(LIGHT_RES_BUNDLE_ACE3D)) {
                z16 = true;
                return z16 && g();
            }
        }
        z16 = false;
        if (z16) {
            return false;
        }
    }

    public static /* synthetic */ boolean e(e eVar, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 1;
        }
        return eVar.d(i3);
    }

    public final boolean d(int renderEngine) {
        if (renderEngine == 1) {
            return h();
        }
        if (renderEngine != 2) {
            return false;
        }
        return f();
    }
}
