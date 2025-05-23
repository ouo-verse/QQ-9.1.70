package com.tencent.mobileqq.guild.mission.beginmission.missionlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uu1.Mission;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/g;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "", "Luu1/a;", "list", "k0", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;", "getListener", "()Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;", "listener", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "missionList", "<init>", "(Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends RecyclerView.Adapter<g> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<Mission> missionList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e listener;

    public a(@NotNull e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.missionList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.missionList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull g holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.m(this.missionList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public g onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.egr, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026list_item, parent, false)");
        return new g(inflate, this.listener);
    }

    public final void k0(@NotNull List<Mission> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.missionList.clear();
        this.missionList.addAll(list);
        notifyDataSetChanged();
    }
}
