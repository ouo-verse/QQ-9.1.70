package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004BR\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00010\u000f\u0012'\b\u0002\u0010\u001d\u001a!\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015\u00a2\u0006\u0002\b\u0016\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\u00a2\u0006\u0004\b \u0010!J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\u000e\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\f\u001a\u00020\bH\u0016R#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013RA\u0010\u001d\u001a!\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015\u00a2\u0006\u0002\b\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/g;", "T", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/m;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "Lkotlin/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "getCreateBindingFun", "()Lkotlin/jvm/functions/Function1;", "createBindingFun", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function3;", "getBindDataFun", "()Lkotlin/jvm/functions/Function3;", "k0", "(Lkotlin/jvm/functions/Function3;)V", "bindDataFun", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class g<T, VB extends ViewBinding> extends ListAdapter<T, m<VB>> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function3<? super VB, ? super T, ? super Integer, Unit> bindDataFun;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<ViewGroup, VB> createBindingFun;

    public /* synthetic */ g(Function1 function1, Function3 function3, DiffUtil.ItemCallback itemCallback, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i3 & 2) != 0 ? null : function3, itemCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull m<VB> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Function3<? super VB, ? super T, ? super Integer, Unit> function3 = this.bindDataFun;
        if (function3 != null) {
            function3.invoke(holder.l(), getItem(position), Integer.valueOf(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public m<VB> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new m<>(this.createBindingFun.invoke(parent));
    }

    public final void k0(@Nullable Function3<? super VB, ? super T, ? super Integer, Unit> function3) {
        this.bindDataFun = function3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull Function1<? super ViewGroup, ? extends VB> createBindingFun, @Nullable Function3<? super VB, ? super T, ? super Integer, Unit> function3, @NotNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
        Intrinsics.checkNotNullParameter(createBindingFun, "createBindingFun");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        this.createBindingFun = createBindingFun;
        this.bindDataFun = function3;
    }
}
