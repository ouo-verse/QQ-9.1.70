package com.tencent.mobileqq.guild.feed.topic;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/b;", "", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "a", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lvn1/a;", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {
    @NotNull
    RecyclerView.RecycledViewPool a();

    @NotNull
    AdapterDelegatesManager<List<vn1.a>> b();
}
