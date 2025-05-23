package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/d;", "E", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "callback", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "delegateManager", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class d<E> extends AsyncListDifferDelegationAdapter<E> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull DiffUtil.ItemCallback<E> callback, @NotNull AdapterDelegatesManager<List<E>> delegateManager) {
        super(callback, delegateManager);
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(delegateManager, "delegateManager");
    }
}
