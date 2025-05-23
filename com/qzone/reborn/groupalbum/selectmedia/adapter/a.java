package com.qzone.reborn.groupalbum.selectmedia.adapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J!\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "viewId", "", "value", "l", "Landroid/view/View;", "T", "getView", "(I)Landroid/view/View;", "getViewOrNull", "Landroid/util/SparseArray;", "E", "Landroid/util/SparseArray;", "views", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.views = new SparseArray<>();
    }

    public final <T extends View> T getView(int viewId) {
        T t16 = (T) getViewOrNull(viewId);
        if (t16 != null) {
            return t16;
        }
        throw new IllegalStateException(("No view found with id " + viewId).toString());
    }

    public final <T extends View> T getViewOrNull(int viewId) {
        T t16;
        T t17 = (T) this.views.get(viewId);
        if (t17 == null && (t16 = (T) this.itemView.findViewById(viewId)) != null) {
            this.views.put(viewId, t16);
            return t16;
        }
        if (t17 == null) {
            return null;
        }
        return t17;
    }

    public final a l(int viewId, CharSequence value) {
        ((TextView) getView(viewId)).setText(value);
        return this;
    }
}
