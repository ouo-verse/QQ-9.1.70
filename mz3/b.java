package mz3;

import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.rdelivery.reshub.api.k;
import com.tencent.rdelivery.reshub.core.j;
import java.io.File;
import java.util.Map;
import jz3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lmz3/b;", "Lcom/tencent/rdelivery/reshub/api/k;", "Lcom/tencent/rdelivery/reshub/api/a;", "iAppInfo", "", "c", "appInfo", "b", "", "Ljz3/e;", Constants.Configs.CONFIGS, "", "a", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class b implements k {
    private final String c(com.tencent.rdelivery.reshub.api.a iAppInfo) {
        String str;
        String localPresetPath;
        if (!(iAppInfo instanceof com.tencent.rdelivery.reshub.core.a)) {
            iAppInfo = null;
        }
        com.tencent.rdelivery.reshub.core.a aVar = (com.tencent.rdelivery.reshub.core.a) iAppInfo;
        j jVar = j.L;
        if (jVar.S()) {
            str = jVar.w().getLocalPresetPath();
        } else {
            str = "res_hub";
        }
        if (aVar != null && (localPresetPath = aVar.getLocalPresetPath()) != null) {
            return localPresetPath;
        }
        return str;
    }

    @Override // com.tencent.rdelivery.reshub.api.k
    public void a(@NotNull com.tencent.rdelivery.reshub.api.a appInfo, @NotNull Map<String, e> configs) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        Intrinsics.checkParameterIsNotNull(configs, "configs");
    }

    @Override // com.tencent.rdelivery.reshub.api.k
    @NotNull
    public String b(@NotNull com.tencent.rdelivery.reshub.api.a appInfo) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c(appInfo));
        String str = File.separator;
        sb5.append(str);
        return sb5.toString() + appInfo.getAppId() + str + appInfo.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ENV java.lang.String() + str;
    }
}
