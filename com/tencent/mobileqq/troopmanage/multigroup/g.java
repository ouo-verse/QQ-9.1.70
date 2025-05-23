package com.tencent.mobileqq.troopmanage.multigroup;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.TroopMultiGroupManageDataFrom;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.TroopMultiGroupManageItemType;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020 \u00a2\u0006\u0004\b0\u00101J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0016\u0010\u0015\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J-\u0010\u001c\u001a\u00020\u00102%\u0010\u001b\u001a!\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00100\u0016j\u0002`\u001aJ-\u0010\u001f\u001a\u00020\u00102%\u0010\u001b\u001a!\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00100\u0016j\u0002`\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R9\u0010(\u001a%\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0016j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R9\u0010*\u001a%\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0016j\u0004\u0018\u0001`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R&\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00130+j\b\u0012\u0004\u0012\u00020\u0013`,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/g;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troopmanage/multigroup/m;", "", "groupId", "", "n0", "", "getItemCount", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "u0", "holder", "", "o0", "", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/f;", "data", "v0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "Lcom/tencent/mobileqq/troopmanage/multigroup/TapItemCallback;", "callback", "w0", "itemModel", "Lcom/tencent/mobileqq/troopmanage/multigroup/TapItemSettingCallback;", "x0", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "tapItemCallback", "D", "tapItemSettingCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "dataList", "<init>", "(Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g extends RecyclerView.Adapter<m> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> tapItemCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f, Unit> tapItemSettingCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopManageViewModel viewModel;

    public g(@NotNull TroopManageViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewModel);
        } else {
            this.viewModel = viewModel;
            this.dataList = new ArrayList<>();
        }
    }

    private final Map<String, String> n0(String groupId) {
        HashMap hashMap = new HashMap();
        hashMap.put("target_group_id", groupId);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f itemModel, g this$0, View view) {
        String str;
        Function1<? super String, Unit> function1;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.d c16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemModel, "$itemModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b16 = itemModel.b();
        if (b16 == null || (c16 = b16.c()) == null || (str = c16.c()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && (function1 = this$0.tapItemCallback) != null) {
            function1.invoke(str);
        }
        com.tencent.mobileqq.troopmanage.report.a.b(com.tencent.mobileqq.troopmanage.report.a.f303239a, "pg_group_set_manage", "em_group_yesterday_overview", null, this$0.viewModel, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f itemModel, g this$0, View view) {
        String str;
        Function1<? super String, Unit> function1;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.d c16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemModel, "$itemModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b16 = itemModel.b();
        if (b16 == null || (c16 = b16.c()) == null || (str = c16.d()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && (function1 = this$0.tapItemCallback) != null) {
            function1.invoke(str);
        }
        com.tencent.mobileqq.troopmanage.report.a.b(com.tencent.mobileqq.troopmanage.report.a.f303239a, "pg_group_set_manage", "em_group_member_manage", null, this$0.viewModel, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f itemModel, g this$0, View view) {
        String str;
        Function1<? super String, Unit> function1;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.d c16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemModel, "$itemModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b16 = itemModel.b();
        if (b16 == null || (c16 = b16.c()) == null || (str = c16.a()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && (function1 = this$0.tapItemCallback) != null) {
            function1.invoke(str);
        }
        com.tencent.mobileqq.troopmanage.report.a.b(com.tencent.mobileqq.troopmanage.report.a.f303239a, "pg_group_set_manage", "em_group_join_manage", null, this$0.viewModel, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f itemModel, g this$0, View view) {
        String str;
        Function1<? super String, Unit> function1;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.d c16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemModel, "$itemModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b16 = itemModel.b();
        if (b16 == null || (c16 = b16.c()) == null || (str = c16.b()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && (function1 = this$0.tapItemCallback) != null) {
            function1.invoke(str);
        }
        com.tencent.mobileqq.troopmanage.report.a.b(com.tencent.mobileqq.troopmanage.report.a.f303239a, "pg_group_set_manage", "em_group_batch_publish", null, this$0.viewModel, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(g this$0, com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f itemModel, View view) {
        String a16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemModel, "$itemModel");
        Function1<? super com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f, Unit> function1 = this$0.tapItemSettingCallback;
        if (function1 != null) {
            function1.invoke(itemModel);
        }
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.c c16 = itemModel.c();
        if (c16 != null && (a16 = c16.a()) != null) {
            com.tencent.mobileqq.troopmanage.report.a.f303239a.a("pg_group_set_manage", "em_group_shortcut_manage", this$0.n0(a16), this$0.viewModel);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f fVar;
        TroopMultiGroupManageItemType d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, position)).intValue();
        }
        if (position <= this.dataList.size()) {
            fVar = this.dataList.get(position);
        } else {
            fVar = null;
        }
        if (fVar != null && (d16 = fVar.d()) != null) {
            return d16.getIndex();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull m holder, int position) {
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.c c16;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position <= this.dataList.size()) {
            com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f fVar = this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(fVar, "dataList[position]");
            final com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f fVar2 = fVar;
            holder.l(fVar2, position, getNUM_BACKGOURND_ICON());
            if (holder instanceof j) {
                if (fVar2.a() == TroopMultiGroupManageDataFrom.MULTI_GROUP_MANAGE_DATA_FROM_SERVER) {
                    com.tencent.mobileqq.troopmanage.report.a.d(com.tencent.mobileqq.troopmanage.report.a.f303239a, "pg_group_set_manage", "em_group_yesterday_overview", null, this.viewModel, 4, null);
                }
                ((j) holder).m().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.multigroup.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g.p0(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f.this, this, view);
                    }
                });
            }
            if (holder instanceof k) {
                TroopMultiGroupManageDataFrom a17 = fVar2.a();
                TroopMultiGroupManageDataFrom troopMultiGroupManageDataFrom = TroopMultiGroupManageDataFrom.MULTI_GROUP_MANAGE_DATA_FROM_SERVER;
                if (a17 == troopMultiGroupManageDataFrom) {
                    com.tencent.mobileqq.troopmanage.report.a.d(com.tencent.mobileqq.troopmanage.report.a.f303239a, "pg_group_set_manage", "em_group_member_manage", null, this.viewModel, 4, null);
                }
                k kVar = (k) holder;
                kVar.p().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.multigroup.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g.q0(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f.this, this, view);
                    }
                });
                if (fVar2.a() == troopMultiGroupManageDataFrom) {
                    com.tencent.mobileqq.troopmanage.report.a.d(com.tencent.mobileqq.troopmanage.report.a.f303239a, "pg_group_set_manage", "em_group_join_manage", null, this.viewModel, 4, null);
                }
                kVar.m().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.multigroup.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g.r0(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f.this, this, view);
                    }
                });
                if (fVar2.a() == troopMultiGroupManageDataFrom) {
                    com.tencent.mobileqq.troopmanage.report.a.d(com.tencent.mobileqq.troopmanage.report.a.f303239a, "pg_group_set_manage", "em_group_batch_publish", null, this.viewModel, 4, null);
                }
                kVar.o().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.multigroup.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g.s0(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f.this, this, view);
                    }
                });
            }
            if (holder instanceof l) {
                if (fVar2.a() == TroopMultiGroupManageDataFrom.MULTI_GROUP_MANAGE_DATA_FROM_SERVER && (c16 = fVar2.c()) != null && (a16 = c16.a()) != null) {
                    com.tencent.mobileqq.troopmanage.report.a.f303239a.c("pg_group_set_manage", "em_group_shortcut_manage", n0(a16), this.viewModel);
                }
                ((l) holder).m().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.multigroup.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g.t0(g.this, fVar2, view);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public m onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (m) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == TroopMultiGroupManageItemType.MULTI_GROUP_MANAGE_DATA.getIndex()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.g18, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new j(view);
        }
        if (viewType == TroopMultiGroupManageItemType.MULTI_GROUP_MANAGE_OPERATION.getIndex()) {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.g1_, parent, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new k(view2);
        }
        View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.g1a, parent, false);
        Intrinsics.checkNotNullExpressionValue(view3, "view");
        return new l(view3);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void v0(@NotNull List<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    public final void w0(@NotNull Function1<? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.tapItemCallback = callback;
        }
    }

    public final void x0(@NotNull Function1<? super com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.tapItemSettingCallback = callback;
        }
    }
}
