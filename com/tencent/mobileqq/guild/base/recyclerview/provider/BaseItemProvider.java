package com.tencent.mobileqq.guild.base.recyclerview.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.base.recyclerview.adapter.BaseProviderMultiAdapter;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bC\u0010DJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\tH\u0016J/\u0010!\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b!\u0010\"J/\u0010$\u001a\u00020#2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b$\u0010%J/\u0010&\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b&\u0010\"J/\u0010'\u001a\u00020#2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b'\u0010%J\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00140(j\b\u0012\u0004\u0012\u00020\u0014`)J\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00140(j\b\u0012\u0004\u0012\u00020\u0014`)J\u0014\u0010-\u001a\u00020\u001d*\u00020\u00122\b\b\u0001\u0010,\u001a\u00020\u0014R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00107\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00106R+\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u00140(j\b\u0012\u0004\u0012\u00020\u0014`)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u00108\u001a\u0004\b9\u0010:R+\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u00140(j\b\u0012\u0004\u0012\u00020\u0014`)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u00108\u001a\u0004\b<\u0010:R\u0014\u0010@\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u00148gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/base/recyclerview/provider/BaseItemProvider;", "T", "", "Lcom/tencent/mobileqq/guild/base/recyclerview/adapter/BaseProviderMultiAdapter;", "adapter", "", "u", "(Lcom/tencent/mobileqq/guild/base/recyclerview/adapter/BaseProviderMultiAdapter;)V", "c", "Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "helper", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "payloads", "b", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "o", "viewHolder", ReportConstant.COSTREPORT_PREFIX, "holder", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "t", "Landroid/view/View;", "view", "data", "position", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)V", "", "p", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;Landroid/view/View;Ljava/lang/Object;I)Z", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "e", "layoutResId", h.F, "Landroid/content/Context;", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "v", "(Landroid/content/Context;)V", "context", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakAdapter", "Lkotlin/Lazy;", "f", "()Ljava/util/ArrayList;", "clickViewIds", "k", "longClickViewIds", "i", "()I", "itemViewType", "j", "layoutId", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class BaseItemProvider<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<BaseProviderMultiAdapter<T>> weakAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy clickViewIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy longClickViewIds;

    public BaseItemProvider() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ArrayList<Integer>>() { // from class: com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider$clickViewIds$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
        this.clickViewIds = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ArrayList<Integer>>() { // from class: com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider$longClickViewIds$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
        this.longClickViewIds = lazy2;
    }

    private final ArrayList<Integer> f() {
        return (ArrayList) this.clickViewIds.getValue();
    }

    private final ArrayList<Integer> k() {
        return (ArrayList) this.longClickViewIds.getValue();
    }

    public abstract void a(@NotNull BaseViewHolder helper, T item);

    public void b(@NotNull BaseViewHolder helper, T item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    @Nullable
    public BaseProviderMultiAdapter<T> c() {
        WeakReference<BaseProviderMultiAdapter<T>> weakReference = this.weakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final ArrayList<Integer> d() {
        return f();
    }

    @NotNull
    public final ArrayList<Integer> e() {
        return k();
    }

    @NotNull
    public final Context g() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @NotNull
    public final View h(@NotNull ViewGroup viewGroup, @LayoutRes int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(this.context).infla\u2026layoutResId, this, false)");
        return inflate;
    }

    public abstract int i();

    @LayoutRes
    public abstract int j();

    public void l(@NotNull BaseViewHolder helper, @NotNull View view, T data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public boolean m(@NotNull BaseViewHolder helper, @NotNull View view, T data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    public void n(@NotNull BaseViewHolder helper, @NotNull View view, T data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @NotNull
    public BaseViewHolder o(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new BaseViewHolder(h(parent, j()));
    }

    public boolean p(@NotNull BaseViewHolder helper, @NotNull View view, T data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    public void q(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public void r(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public void s(@NotNull BaseViewHolder viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public void t(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public final void u(@NotNull BaseProviderMultiAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.weakAdapter = new WeakReference<>(adapter);
    }

    public final void v(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }
}
