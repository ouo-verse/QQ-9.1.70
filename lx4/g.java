package lx4;

import com.tencent.zplan.common.model.UploadConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\\\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u000528\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007H&\u00a8\u0006\u0010"}, d2 = {"Llx4/g;", "", "", "localPath", "uuid", "Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;", "uploadTarget", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "remoteUrl", "", "callback", "a", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface g {
    void a(@NotNull String localPath, @NotNull String uuid, @NotNull UploadConfig.UploadTarget uploadTarget, @NotNull Function2<? super Boolean, ? super String, Unit> callback);
}
