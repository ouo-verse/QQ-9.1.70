package com.tencent.biz.qqcircle.immersive.personal.publishguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/e;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/a;", "bannerInfos", "updateData", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;", "listener", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "D", "I", "itemWidth", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class i extends RecyclerView.Adapter<e> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<BannerInfo> bannerInfos;

    /* renamed from: D, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f listener;

    public i(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.bannerInfos = new ArrayList();
        this.itemWidth = bz.j() - e83.a.b(42);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.bannerInfos.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull e holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.o(this.bannerInfos.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168741gp1, (ViewGroup) null);
        view.setLayoutParams(new RecyclerView.LayoutParams(this.itemWidth, -1));
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new e(view, this.listener);
    }

    public final void updateData(@NotNull List<BannerInfo> bannerInfos) {
        Intrinsics.checkNotNullParameter(bannerInfos, "bannerInfos");
        this.bannerInfos.clear();
        this.bannerInfos.addAll(bannerInfos);
        notifyDataSetChanged();
    }
}
