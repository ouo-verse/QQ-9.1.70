package com.tencent.timi.game.api.remoteres;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/api/remoteres/IZipResDownloadApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/timi/game/api/remoteres/BizId;", "bizId", "Lcom/tencent/timi/game/api/remoteres/b;", "zipInfo", "Lcom/tencent/timi/game/api/remoteres/a;", "callback", "", "download", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IZipResDownloadApi extends QRouteApi {
    void download(@NotNull Context context, @NotNull BizId bizId, @NotNull ZipInfo zipInfo, @NotNull a callback);
}
