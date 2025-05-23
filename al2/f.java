package al2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import bl2.HbSkinInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.ActionSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u001b\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lal2/f;", "Landroidx/recyclerview/widget/ListAdapter;", "Lbl2/c;", "Lal2/c;", "Landroid/view/View;", "itemView", "hbSkinInfo", "", "n0", "", "position", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "holder", "l0", "Lkotlin/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onDeleteSkin", "<init>", "(Lkotlin/jvm/functions/Function1;)V", BdhLogUtil.LogTag.Tag_Conn, "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f extends ListAdapter<HbSkinInfo, c> {

    @NotNull
    private static final a D = new a();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<HbSkinInfo, Unit> onDeleteSkin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"al2/f$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lbl2/c;", "oldItem", "newItem", "", "b", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends DiffUtil.ItemCallback<HbSkinInfo> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull HbSkinInfo oldItem, @NotNull HbSkinInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull HbSkinInfo oldItem, @NotNull HbSkinInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getSkinId() == newItem.getSkinId() && oldItem.getSkinFrom() == newItem.getSkinFrom() && Intrinsics.areEqual(oldItem.getOuterSkinId(), newItem.getOuterSkinId())) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull Function1<? super HbSkinInfo, Unit> onDeleteSkin) {
        super(D);
        Intrinsics.checkNotNullParameter(onDeleteSkin, "onDeleteSkin");
        this.onDeleteSkin = onDeleteSkin;
    }

    private final void n0(final View itemView, final HbSkinInfo hbSkinInfo) {
        if (hbSkinInfo.getIsDefault()) {
            itemView.setOnLongClickListener(null);
        } else {
            itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: al2.d
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean o06;
                    o06 = f.o0(itemView, this, hbSkinInfo, view);
                    return o06;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o0(View itemView, final f this$0, final HbSkinInfo hbSkinInfo, View view) {
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hbSkinInfo, "$hbSkinInfo");
        final ActionSheet create = ActionSheet.create(itemView.getContext());
        create.setMainTitle("\u5c01\u9762\u5220\u9664\u540e\u4e0d\u53ef\u6062\u590d");
        create.addButton("\u5220\u9664\u8be5\u5c01\u9762", 3);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: al2.e
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view2, int i3) {
                f.p0(f.this, hbSkinInfo, create, view2, i3);
            }
        });
        create.addCancelButton("\u53d6\u6d88");
        create.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(f this$0, HbSkinInfo hbSkinInfo, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hbSkinInfo, "$hbSkinInfo");
        if (i3 == 0) {
            this$0.onDeleteSkin.invoke(hbSkinInfo);
        }
        actionSheet.dismiss();
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public HbSkinInfo getItem(int position) {
        Object item = super.getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "super.getItem(position)");
        return (HbSkinInfo) item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        HbSkinInfo item = getItem(position);
        holder.l(item);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        n0(view, item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hj6, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026skin_item, parent, false)");
        return new c(inflate);
    }
}
