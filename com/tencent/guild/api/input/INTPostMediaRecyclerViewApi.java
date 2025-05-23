package com.tencent.guild.api.input;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ts.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&J\u0014\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\u000e\u001a\u00020\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/api/input/INTPostMediaRecyclerViewApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "getPostMediaRecyclerView", "getPostMediaAdapter", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "repository", "Lts/a;", "launcher", "", "initPostMediaAdapter", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface INTPostMediaRecyclerViewApi extends QRouteApi {
    @NotNull
    RecyclerView.Adapter<?> getPostMediaAdapter(@NotNull Context context);

    @NotNull
    RecyclerView getPostMediaRecyclerView(@NotNull Context context, @NotNull RecyclerView.Adapter<?> adapter);

    void initPostMediaAdapter(@NotNull RecyclerView.Adapter<?> adapter, @NotNull GuildAIOMediasRepository repository, @NotNull a launcher);
}
