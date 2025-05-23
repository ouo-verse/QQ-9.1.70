package nu3;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tav.ResourceLoadUtil;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAG;
import org.libpag.PAGFile;
import org.light.LightEngine;
import qd4.DynamicSoConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lnu3/e;", "", "", "resPath", "", "e", "b", "", "a", "d", "c", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f421339a = new e();

    e() {
    }

    @JvmStatic
    public static final boolean e(String resPath) {
        List listOf;
        Intrinsics.checkNotNullParameter(resPath, "resPath");
        System.loadLibrary(AECameraConstants.LIB_V8);
        String unzipAEResPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_BASE_PACKAGE);
        Intrinsics.checkNotNullExpressionValue(unzipAEResPath, "api(IAEResUtil::class.ja\u2026ASE_PACKAGE\n            )");
        DynamicSoConfig dynamicSoConfig = new DynamicSoConfig(unzipAEResPath, AECameraConstants.LIB_LIGHT, true);
        String unzipAEResPath2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_FILAMENT);
        Intrinsics.checkNotNullExpressionValue(unzipAEResPath2, "api(IAEResUtil::class.ja\u2026ES_FILAMENT\n            )");
        DynamicSoConfig dynamicSoConfig2 = new DynamicSoConfig(unzipAEResPath2, AECameraConstants.FILAMENT_NAME, true);
        String unzipAEResPath3 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_PAG);
        Intrinsics.checkNotNullExpressionValue(unzipAEResPath3, "api(IAEResUtil::class.ja\u2026GHT_RES_PAG\n            )");
        DynamicSoConfig dynamicSoConfig3 = new DynamicSoConfig(unzipAEResPath3, AECameraConstants.LIB_PAG, true);
        String lightAssetsDir = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightAssetsDir();
        Intrinsics.checkNotNullExpressionValue(lightAssetsDir, "api(IAEResUtil::class.java).lightAssetsDir");
        od4.b.t(lightAssetsDir);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new DynamicSoConfig[]{dynamicSoConfig3, dynamicSoConfig2, dynamicSoConfig});
        if (od4.b.y(listOf)) {
            if (ResourceLoadUtil.loadSoSync(resPath + File.separator + "libtav.so")) {
                return true;
            }
        }
        return false;
    }

    public final int a() {
        return LightEngine.componentLevel();
    }

    public final String b() {
        String version = LightEngine.version();
        return version == null ? "" : version;
    }

    public final int c() {
        return PAGFile.MaxSupportedTagLevel();
    }

    public final String d() {
        String SDKVersion = PAG.SDKVersion();
        return SDKVersion == null ? "" : SDKVersion;
    }
}
