package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B*\u0012!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016R/\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR6\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@GX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/m;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "position", "getItemViewType", "holder", "", "onBindViewHolder", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onItemClicked", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "getCountUsed", "()Z", "i0", "(Z)V", "countUsed", "", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "value", "D", "Ljava/util/List;", "getStyles", "()Ljava/util/List;", "j0", "(Ljava/util/List;)V", "styles", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean countUsed;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<MagicAvatarMaterialInfo> styles;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onItemClicked;

    /* JADX WARN: Multi-variable type inference failed */
    public m(@NotNull Function1<? super Integer, Unit> onItemClicked) {
        List<MagicAvatarMaterialInfo> emptyList;
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.styles = emptyList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.styles.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.styles.get(position).getType();
    }

    public final void i0(boolean z16) {
        this.countUsed = z16;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void j0(@NotNull List<MagicAvatarMaterialInfo> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.styles = value;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof StyleItem) {
            ((StyleItem) holder).t(this.styles.get(position), this.countUsed, this.onItemClicked);
        } else if (holder instanceof StyleLoadingItem) {
            ((StyleLoadingItem) holder).o();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType != 1) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dts, parent, false);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                return new StyleLoadingItem(view);
            }
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.dtp, parent, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new o(view2, this.onItemClicked);
        }
        View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.dtr, parent, false);
        Intrinsics.checkNotNullExpressionValue(view3, "view");
        return new StyleItem(view3);
    }
}
