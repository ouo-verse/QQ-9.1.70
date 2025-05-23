package az2;

import az2.c;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Laz2/b;", "Laz2/c;", "", "appId", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Laz2/c$a;", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements c {
    @Override // az2.c
    @NotNull
    public c.a a(@NotNull String appId, @NotNull String expName) {
        String str;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(expName, "expName");
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(appId, expName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(appId, expName)");
        expEntity.reportExpExposure();
        c.a aVar = new c.a();
        String grayId = expEntity.getGrayId();
        Intrinsics.checkNotNullExpressionValue(grayId, "info.getGrayId()");
        aVar.c(grayId);
        Map<String, String> tabParams = expEntity.getTabParams();
        if (tabParams == null || (str = tabParams.get("flag")) == null) {
            str = "0";
        }
        aVar.b().put("flag", str);
        return aVar;
    }
}
