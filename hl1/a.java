package hl1;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00028\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J#\u0010\u000b\u001a\u00028\u0002\"\u0004\b\u0002\u0010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lhl1/a;", "I", "T", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "E", "Ljava/lang/Class;", "iocClass", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "Landroid/view/View;", "d", "Landroid/view/View;", "getMItemView", "()Landroid/view/View;", "setMItemView", "(Landroid/view/View;)V", "mItemView", "e", "Landroid/view/ViewGroup;", "mParentView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a<I extends T, T> extends AbsItemAdapterDelegate<I, T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mItemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mParentView;

    public final <E> E b(@Nullable Class<E> iocClass) {
        return (E) RFWIocAbilityProvider.g().getIocInterface(iocClass, this.mItemView, this.mParentView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SectionViewHolder<?> onCreateViewHolder = super.onCreateViewHolder(parent);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent)");
        this.mItemView = onCreateViewHolder.itemView;
        this.mParentView = parent;
        RFWIocAbilityProvider.g().setLogicParentView(this.mItemView, this.mParentView);
        return onCreateViewHolder;
    }
}
