package dl0;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.feature.model.FilamentMiniHomeSceneUrlTemplate;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J5\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\u000eH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0014"}, d2 = {"Ldl0/g;", "", "", VipFunCallConstants.KEY_GROUP, "", AdMetricTag.FALLBACK, "isSwitchOn", "T", "groupId", "Ljava/lang/Class;", "configClass", "getConfig", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "b", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "Lcl0/a;", "d", "Lcom/tencent/filament/zplanservice/feature/model/FilamentMiniHomeSceneUrlTemplate;", "c", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface g {
    @NotNull
    FilamentUrlTemplate a();

    @NotNull
    String b(@NotNull String groupId, @NotNull String fallback);

    @Nullable
    FilamentMiniHomeSceneUrlTemplate c();

    @Nullable
    cl0.a d();

    @Nullable
    <T> T getConfig(@NotNull String groupId, @NotNull Class<T> configClass, @NotNull String fallback);

    boolean isSwitchOn(@NotNull String group, boolean fallback);
}
