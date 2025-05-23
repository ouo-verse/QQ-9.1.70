package com.tencent.qqnt.ntrelation.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a2\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0004j\b\u0012\u0004\u0012\u00020\u0007`\u00060\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/ntrelation/api/IMutualMarkDrawableApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getMutualMarkDrawableAndData", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/NTMutualMarkEntity;", "friendUid", "", "tag", "relation-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IMutualMarkDrawableApi extends QRouteApi {
    @NotNull
    Pair<ArrayList<Drawable>, ArrayList<NTMutualMarkEntity>> getMutualMarkDrawableAndData(@NotNull String friendUid, @NotNull String tag);
}
