package com.tencent.mobileqq.search.business.net.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002:\u0001%B5\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012$\u0010\u001c\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001e\u0010\u0010\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0017\u0010\u0015\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R5\u0010\u001c\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/search/business/net/view/a;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/search/business/net/view/a$a;", "", "data", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "getItemCount", "holder", "position", "j0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "getLayoutId", "()I", "layoutId", "Lkotlin/Function3;", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function3;", "getBindFun", "()Lkotlin/jvm/functions/Function3;", "bindFun", "", "D", "Ljava/util/List;", "getDataList", "()Ljava/util/List;", "dataList", "<init>", "(ILkotlin/jvm/functions/Function3;)V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a<T> extends RecyclerView.Adapter<C8529a<T>> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function3<C8529a<T>, T, View, Unit> bindFun;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<T> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int layoutId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B5\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012$\u0010\u0012\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR5\u0010\u0012\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/business/net/view/a$a;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "(Ljava/lang/Object;)V", "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lkotlin/Function3;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function3;", "getBindFun", "()Lkotlin/jvm/functions/Function3;", "bindFun", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function3;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.net.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8529a<T> extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Function3<C8529a<T>, T, View, Unit> bindFun;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C8529a(@NotNull View itemView, @NotNull Function3<? super C8529a<T>, ? super T, ? super View, Unit> bindFun) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(bindFun, "bindFun");
            this.itemView = itemView;
            this.bindFun = bindFun;
        }

        public final void l(T item) {
            Function3<C8529a<T>, T, View, Unit> function3 = this.bindFun;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            function3.invoke(this, item, itemView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int i3, @NotNull Function3<? super C8529a<T>, ? super T, ? super View, Unit> bindFun) {
        Intrinsics.checkNotNullParameter(bindFun, "bindFun");
        this.layoutId = i3;
        this.bindFun = bindFun;
        this.dataList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public final void i0(@NotNull List<? extends T> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C8529a<T> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(this.dataList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public C8529a<T> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(this.layoutId, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new C8529a<>(view, this.bindFun);
    }
}
