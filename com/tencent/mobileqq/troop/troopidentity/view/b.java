package com.tencent.mobileqq.troop.troopidentity.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconVM;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtilKt;
import com.tencent.mobileqq.troop.troopidentity.view.b;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityTitleInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR*\u0010$\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070 j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R*\u0010&\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050 j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopidentity/view/b$a;", "", "position", "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "i0", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityTitleInfo;", "j0", "", "titleList", "", "m0", "Landroid/view/ViewGroup;", "p0", "p1", "l0", "getItemCount", "viewHolder", "k0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", "getVm", "()Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", "vm", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "originTitleInfoList", "E", "memberRankItemList", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TroopIdentityIconVM vm;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<GroupIdentityTitleInfo> originTitleInfoList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.troop.troopmemberlevel.a> memberRankItemList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", "vm", "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "rankItem", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityTitleInfo;", "titleInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "E", "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "memberLevelView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TroopMemberNewLevelView memberLevelView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.f102255xe);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026roop_identity_title_item)");
            this.memberLevelView = (TroopMemberNewLevelView) findViewById;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(TroopIdentityIconVM vm5, GroupIdentityTitleInfo groupIdentityTitleInfo, View view) {
            Map<String, ? extends Object> mapOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(vm5, "$vm");
            vm5.p2(groupIdentityTitleInfo);
            com.tencent.mobileqq.troop.troopidentity.util.a X1 = vm5.X1();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_title_type", groupIdentityTitleInfo.titleId));
            X1.b("em_group_title", mapOf);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final TroopIdentityIconVM vm5, @Nullable com.tencent.mobileqq.troop.troopmemberlevel.a rankItem, @Nullable final GroupIdentityTitleInfo titleInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, vm5, rankItem, titleInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(vm5, "vm");
            TroopIdentityIconItemView troopIdentityIconItemView = null;
            if (rankItem != null && titleInfo != null) {
                boolean z16 = false;
                this.memberLevelView.setVisibility(0);
                View view = this.itemView;
                if (view instanceof TroopIdentityIconItemView) {
                    troopIdentityIconItemView = (TroopIdentityIconItemView) view;
                }
                if (troopIdentityIconItemView != null) {
                    troopIdentityIconItemView.a(titleInfo.isSet);
                }
                String str = rankItem.f300599j;
                if (str == null || str.length() == 0) {
                    z16 = true;
                }
                if (!z16) {
                    this.memberLevelView.a();
                }
                this.memberLevelView.setTroopMemberNewLevel(rankItem);
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.view.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        b.a.n(TroopIdentityIconVM.this, titleInfo, view2);
                    }
                });
                return;
            }
            this.memberLevelView.setVisibility(8);
            View view2 = this.itemView;
            if (view2 instanceof TroopIdentityIconItemView) {
                troopIdentityIconItemView = (TroopIdentityIconItemView) view2;
            }
            if (troopIdentityIconItemView != null) {
                troopIdentityIconItemView.b();
            }
        }
    }

    public b(@NotNull Context context, @NotNull TroopIdentityIconVM vm5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) vm5);
            return;
        }
        this.context = context;
        this.vm = vm5;
        this.originTitleInfoList = new ArrayList<>();
        this.memberRankItemList = new ArrayList<>();
    }

    private final com.tencent.mobileqq.troop.troopmemberlevel.a i0(int position) {
        boolean z16 = false;
        if (position >= 0 && position < this.memberRankItemList.size()) {
            z16 = true;
        }
        if (z16) {
            return this.memberRankItemList.get(position);
        }
        return null;
    }

    private final GroupIdentityTitleInfo j0(int position) {
        boolean z16 = false;
        if (position >= 0 && position < this.originTitleInfoList.size()) {
            z16 = true;
        }
        if (z16) {
            return this.originTitleInfoList.get(position);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.memberRankItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.m(this.vm, i0(position), j0(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup p06, int p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) p06, p16);
        }
        Intrinsics.checkNotNullParameter(p06, "p0");
        View contentView = View.inflate(this.context, R.layout.hzj, null);
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        return new a(new TroopIdentityIconItemView(context, null, 0, contentView, 6, null));
    }

    public final void m0(@Nullable List<GroupIdentityTitleInfo> titleList) {
        List<GroupIdentityTitleInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) titleList);
            return;
        }
        if (titleList != null) {
            arrayList = titleList;
        } else {
            arrayList = new ArrayList();
        }
        this.originTitleInfoList = new ArrayList<>(arrayList);
        ArrayList<com.tencent.mobileqq.troop.troopmemberlevel.a> arrayList2 = new ArrayList<>();
        for (GroupIdentityTitleInfo groupIdentityTitleInfo : this.originTitleInfoList) {
            if (groupIdentityTitleInfo != null) {
                com.tencent.mobileqq.troop.troopmemberlevel.a a26 = this.vm.a2();
                int e26 = this.vm.e2(groupIdentityTitleInfo.titleId);
                String str = groupIdentityTitleInfo.name;
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "titleInfo.name ?: \"\"");
                }
                com.tencent.mobileqq.troop.troopmemberlevel.a a16 = TroopIdentityHonorUtilKt.a(a26, e26, str);
                this.vm.i2(a16);
                arrayList2.add(a16);
            }
        }
        this.memberRankItemList = arrayList2;
        if (arrayList2.size() == 1) {
            this.memberRankItemList.add(0, null);
            this.originTitleInfoList.add(0, null);
        }
        notifyDataSetChanged();
    }
}
