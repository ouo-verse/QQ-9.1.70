package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b+\u0010,J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J&\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016R\u0014\u0010 \u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/aa;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/o;", "", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "infos", "", "setData", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "listener", "n0", "", "id", "i0", "info", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "type", "m0", "getItemCount", "viewHolder", "position", "k0", "holder", "", "", "payloads", "l0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "initialPosition", "Landroid/graphics/drawable/Drawable;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/drawable/Drawable;", "transitionDrawable", "D", "Ljava/util/List;", "data", "E", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/b;", "onOpListener", "<init>", "(ILandroid/graphics/drawable/Drawable;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class aa extends RecyclerView.Adapter<o> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final Drawable transitionDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<QFSCommentImageInfo> data = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b onOpListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int initialPosition;

    public aa(int i3, @Nullable Drawable drawable) {
        this.initialPosition = i3;
        this.transitionDrawable = drawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Nullable
    public final QFSCommentImageInfo i0(@NotNull String id5) {
        Object obj;
        Intrinsics.checkNotNullParameter(id5, "id");
        Iterator<T> it = this.data.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((QFSCommentImageInfo) obj).l(), id5)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (QFSCommentImageInfo) obj;
    }

    public final void j0(@NotNull QFSCommentImageInfo info) {
        List listOf;
        Intrinsics.checkNotNullParameter(info, "info");
        int indexOf = this.data.indexOf(info);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(1);
        notifyItemChanged(indexOf, listOf);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull o viewHolder, int position) {
        Drawable colorDrawable;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.I(this.onOpListener);
        if (this.initialPosition == position) {
            colorDrawable = this.transitionDrawable;
            if (colorDrawable == null) {
                colorDrawable = new ColorDrawable(SupportMenu.CATEGORY_MASK);
            }
        } else {
            colorDrawable = new ColorDrawable(-16777216);
        }
        viewHolder.s(this.data.get(position), colorDrawable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull o holder, int position, @NotNull List<Object> payloads) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        if (Intrinsics.areEqual(firstOrNull, (Object) 1)) {
            holder.J();
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public o onCreateViewHolder(@NotNull ViewGroup parent, int type) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.g9h, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new o(itemView);
    }

    public final void n0(@Nullable b listener) {
        this.onOpListener = listener;
    }

    public final void setData(@NotNull List<QFSCommentImageInfo> infos) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        this.data.clear();
        this.data.addAll(infos);
        notifyDataSetChanged();
    }
}
