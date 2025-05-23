package com.tencent.aio.api.list;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\u0005H'\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aio/api/list/d;", "Lcom/tencent/aio/api/list/c;", "", "positionStart", "itemCount", "", "d", "", "payload", "u", tl.h.F, "e", "fromPosition", "toPosition", "v", "notifyDataSetChanged", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface d extends c {
    void d(int positionStart, int itemCount);

    void e(int positionStart, int itemCount);

    void h(int positionStart, int itemCount);

    @SuppressLint({"NotifyDataSetChanged"})
    void notifyDataSetChanged();

    void u(int positionStart, int itemCount, @Nullable Object payload);

    void v(int fromPosition, int toPosition);
}
