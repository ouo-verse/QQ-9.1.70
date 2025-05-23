package j34;

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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lj34/c;", "T", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "Landroid/view/View;", "d", "Landroid/view/View;", "mItemView", "e", "Landroid/view/ViewGroup;", "mParentView", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class c<T> extends AbsItemAdapterDelegate<T, T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mItemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mParentView;

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
