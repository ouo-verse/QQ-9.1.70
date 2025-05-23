package com.tencent.mobileqq.guild.feed.api;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IFeedScrollMangerFactoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/api/e;", "feedAdapterCenter", "Lcom/tencent/mobileqq/guild/api/d;", "createFeedScrollManager", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IFeedScrollMangerFactoryApi extends QRouteApi {
    @NotNull
    com.tencent.mobileqq.guild.api.d createFeedScrollManager(@NotNull Context context, @NotNull RecyclerView recyclerView, @NotNull com.tencent.mobileqq.guild.api.e feedAdapterCenter);
}
