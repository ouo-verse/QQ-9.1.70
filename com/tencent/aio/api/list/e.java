package com.tencent.aio.api.list;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aio/api/list/e;", "Lcom/tencent/aio/api/list/d;", "", "position", "Lcom/tencent/aio/data/msglist/a;", HippyTKDListViewAdapter.X, "w", "startPosition", "endPosition", "Lkotlin/Pair;", "Lcom/tencent/aio/api/vo/a;", "J", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface e extends d {
    @NotNull
    Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J(int startPosition, int endPosition);

    int w(int position);

    @Nullable
    com.tencent.aio.data.msglist.a x(int position);
}
