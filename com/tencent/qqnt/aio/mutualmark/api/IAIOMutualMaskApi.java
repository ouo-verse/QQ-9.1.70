package com.tencent.qqnt.aio.mutualmark.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/mutualmark/api/IAIOMutualMaskApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "uin", "honorStr", "", "richFlag", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "getDrawable", "memberUin", "Lcom/tencent/qqnt/aio/mutualmark/api/a;", "getMutualMarkInfo", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOMutualMaskApi extends QRouteApi {
    @NotNull
    ArrayList<Drawable> getDrawable(@NotNull String troopUin, @NotNull String uin, @NotNull String honorStr, byte richFlag);

    @Nullable
    a getMutualMarkInfo(@NotNull String troopUin, @NotNull String memberUin);
}
