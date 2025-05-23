package com.tencent.mobileqq.qwallet.hb.panel;

import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/d;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "Lcom/tencent/mobileqq/qwallet/hb/panel/c;", "a", "Lcom/tencent/mobileqq/qwallet/hb/panel/c;", "getAdapter", "()Lcom/tencent/mobileqq/qwallet/hb/panel/c;", "adapter", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/c;)V", "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c adapter;

    public d(@NotNull c adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int position) {
        return 12 / this.adapter.i0(position);
    }
}
