package nk3;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u001e\u0010\r\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lnk3/i;", "", "Lcom/tencent/mobileqq/zplan/model/g;", "bgInfo", "", "onResultForSelectImage", "onResultForUpdateImage", "onResultForAddImage", "onResultForDeleteImage", "", "zPlanBgInfos", "", "smallHomeSchema", "onResultForRequestAllImage", "onResultFailed", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class i {
    public void onResultForRequestAllImage(@NotNull List<? extends com.tencent.mobileqq.zplan.model.g> zPlanBgInfos, @NotNull String smallHomeSchema) {
        Intrinsics.checkNotNullParameter(zPlanBgInfos, "zPlanBgInfos");
        Intrinsics.checkNotNullParameter(smallHomeSchema, "smallHomeSchema");
    }

    public void onResultForSelectImage(@NotNull com.tencent.mobileqq.zplan.model.g bgInfo) {
        Intrinsics.checkNotNullParameter(bgInfo, "bgInfo");
    }

    public void onResultFailed() {
    }

    public void onResultForAddImage() {
    }

    public void onResultForDeleteImage() {
    }

    public void onResultForUpdateImage() {
    }
}
