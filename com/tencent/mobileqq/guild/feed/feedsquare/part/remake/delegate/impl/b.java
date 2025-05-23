package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import bk1.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/b;", "Lbk1/a$d;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "a", "", "d", "I", "recyclerViewID", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements a.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int recyclerViewID;

    public b(int i3) {
        this.recyclerViewID = i3;
    }

    @Override // bk1.a.d
    @NotNull
    public RecyclerView a(@Nullable RecyclerView recyclerView, @NotNull View rootView, @NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(config, "config");
        if (recyclerView == null) {
            View findViewById = rootView.findViewById(this.recyclerViewID);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(recyclerViewID)");
            recyclerView = (RecyclerView) findViewById;
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(null);
        com.tencent.mobileqq.guild.media.widget.audiofaceview.e eVar = new com.tencent.mobileqq.guild.media.widget.audiofaceview.e(rootView.getContext());
        eVar.setOrientation(1);
        recyclerView.setLayoutManager(eVar);
        RecyclerView.RecycledViewPool a16 = config.a();
        if (a16 instanceof com.tencent.mobileqq.guild.feed.feedsquare.widget.a) {
            ((com.tencent.mobileqq.guild.feed.feedsquare.widget.a) a16).a();
        }
        recyclerView.setRecycledViewPool(a16);
        return recyclerView;
    }

    public /* synthetic */ b(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? R.id.wen : i3);
    }
}
