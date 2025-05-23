package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarStyleBanner;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B*\u0012!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016R/\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R6\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00158\u0006@GX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/p;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/magicAvatar/ui/StyleBannerItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/d;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onItemClicked", "", "value", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getStyles", "()Ljava/util/List;", "k0", "(Ljava/util/List;)V", "styles", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p extends RecyclerView.Adapter<StyleBannerItem> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<MagicAvatarStyleBanner> styles;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<MagicAvatarStyleBanner, Unit> onItemClicked;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull Function1<? super MagicAvatarStyleBanner, Unit> onItemClicked) {
        List<MagicAvatarStyleBanner> emptyList;
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.styles = emptyList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.styles.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull StyleBannerItem holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.q(this.styles.get(position), this.onItemClicked);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public StyleBannerItem onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dtq, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new StyleBannerItem(view);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void k0(@NotNull List<MagicAvatarStyleBanner> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.styles = value;
        notifyDataSetChanged();
    }
}
