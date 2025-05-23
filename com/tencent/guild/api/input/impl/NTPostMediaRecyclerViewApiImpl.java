package com.tencent.guild.api.input.impl;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.api.input.INTPostMediaRecyclerViewApi;
import com.tencent.guild.api.input.impl.widget.PostMediaPreviewList;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lr0.f;
import lr0.g;
import org.jetbrains.annotations.NotNull;
import ts.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\u0014\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000e\u001a\u00020\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/api/input/impl/NTPostMediaRecyclerViewApiImpl;", "Lcom/tencent/guild/api/input/INTPostMediaRecyclerViewApi;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "getPostMediaRecyclerView", "getPostMediaAdapter", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "repository", "Lts/a;", "launcher", "", "initPostMediaAdapter", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class NTPostMediaRecyclerViewApiImpl implements INTPostMediaRecyclerViewApi {

    @NotNull
    private static final String TAG = "PostMediaRecyclerViewApiImpl";

    @Override // com.tencent.guild.api.input.INTPostMediaRecyclerViewApi
    @NotNull
    public RecyclerView.Adapter<?> getPostMediaAdapter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new f(context);
    }

    @Override // com.tencent.guild.api.input.INTPostMediaRecyclerViewApi
    @NotNull
    public RecyclerView getPostMediaRecyclerView(@NotNull Context context, @NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        PostMediaPreviewList postMediaPreviewList = new PostMediaPreviewList(context);
        postMediaPreviewList.setContentDescription(postMediaPreviewList.getResources().getString(R.string.f139450ba));
        postMediaPreviewList.setLayoutManager(new LinearLayoutManager(postMediaPreviewList.getContext(), 0, false));
        postMediaPreviewList.setAdapter(adapter);
        postMediaPreviewList.setBackgroundColor(postMediaPreviewList.getResources().getColor(R.color.guild_media_preview_bg));
        g gVar = new g((f) adapter, null);
        gVar.e(1.0f, 0.8f, 1.22f, 1.12f);
        gVar.c(1.0f);
        gVar.d(new b(adapter));
        new ItemTouchHelper(gVar).attachToRecyclerView(postMediaPreviewList);
        return postMediaPreviewList;
    }

    @Override // com.tencent.guild.api.input.INTPostMediaRecyclerViewApi
    public void initPostMediaAdapter(@NotNull RecyclerView.Adapter<?> adapter, @NotNull GuildAIOMediasRepository repository, @NotNull a launcher) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        ((f) adapter).r0(repository, launcher);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guild/api/input/impl/NTPostMediaRecyclerViewApiImpl$b", "Llr0/g$a;", "", "a", "", "isInside", "b", "isIdle", "c", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements g.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.Adapter<?> f112575a;

        b(RecyclerView.Adapter<?> adapter) {
            this.f112575a = adapter;
        }

        @Override // lr0.g.a
        public void b(boolean isInside) {
            ((f) this.f112575a).E0();
        }

        @Override // lr0.g.a
        public void a() {
        }

        @Override // lr0.g.a
        public void c(boolean isInside, boolean isIdle) {
        }
    }
}
