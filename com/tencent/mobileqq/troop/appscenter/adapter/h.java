package com.tencent.mobileqq.troop.appscenter.adapter;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002HIB\u0019\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\u0010)\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\bE\u0010FJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000bJ\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000bR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u00100\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00104\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\"\u00106\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010+\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R&\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u00050@j\b\u0012\u0004\u0012\u00020\u0005`A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/appscenter/mvi/a;", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "appDetail", "", "s0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "A0", "position", "", "getItemId", "getItemCount", "holder", "t0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "D0", "fromPosition", "toPosition", "B0", "Lcom/tencent/mobileqq/troop/appscenter/data/g;", "data", "r0", "Lcom/tencent/mobileqq/troop/appscenter/data/f;", "C0", "", "o0", "", "q0", "Lds2/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lds2/a;", "delegateListener", "Lcom/tencent/mobileqq/troop/appscenter/helper/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/appscenter/helper/b;", "dragStartListener", "D", "Z", "p0", "()Z", "setCanShowDeleteBtn", "(Z)V", "canShowDeleteBtn", "E", "getCanShowAddBtn", "setCanShowAddBtn", "canShowAddBtn", UserInfo.SEX_FEMALE, "isRecommendFlag", "setRecommendFlag", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "G", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getTroopInfo", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "setTroopInfo", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "troopInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "appDatas", "<init>", "(Lds2/a;Lcom/tencent/mobileqq/troop/appscenter/helper/b;)V", "I", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h extends RecyclerView.Adapter<com.tencent.mobileqq.troop.appscenter.mvi.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.troop.appscenter.helper.b dragStartListener;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean canShowDeleteBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean canShowAddBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isRecommendFlag;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TroopInfo troopInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ArrayList<AppDetail> appDatas;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ds2.a delegateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.adapter.h$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/h$b;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "oldItem", "newItem", "", "a", "", "getNewListSize", "getOldListSize", "oldItemPosition", "newItemPosition", "areContentsTheSame", "areItemsTheSame", "", "Ljava/util/List;", "oldList", "b", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends DiffUtil.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<AppDetail> oldList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<AppDetail> newList;

        public b(@NotNull List<AppDetail> oldList, @NotNull List<AppDetail> newList) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oldList, (Object) newList);
            } else {
                this.oldList = oldList;
                this.newList = newList;
            }
        }

        private final boolean a(AppDetail oldItem, AppDetail newItem) {
            if (Intrinsics.areEqual(oldItem.name, newItem.name) && Intrinsics.areEqual(oldItem.icon, newItem.icon) && oldItem.type == newItem.type && oldItem.removable == newItem.removable && Intrinsics.areEqual(oldItem.desc, newItem.desc) && oldItem.added == newItem.added && oldItem.addTs == newItem.addTs) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            return a(this.oldList.get(oldItemPosition), this.newList.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            AppDetail appDetail = this.oldList.get(oldItemPosition);
            AppDetail appDetail2 = this.newList.get(newItemPosition);
            if (Intrinsics.areEqual(appDetail.appId, appDetail2.appId) && appDetail.added == appDetail2.added) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.newList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.oldList.size();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h(@NotNull ds2.a delegateListener, @Nullable com.tencent.mobileqq.troop.appscenter.helper.b bVar) {
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) delegateListener, (Object) bVar);
            return;
        }
        this.delegateListener = delegateListener;
        this.dragStartListener = bVar;
        this.appDatas = new ArrayList<>();
    }

    private final void s0(View view, AppDetail appDetail) {
        int i3;
        HashMap hashMapOf;
        if (this.isRecommendFlag) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("appid", appDetail.appId), TuplesKt.to("tab_name", Integer.valueOf(i3)));
        VideoReport.setElementId(view, "em_group_icon");
        VideoReport.setElementParams(view, hashMapOf);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(h this$0, AppDetail bindAppsInfo, com.tencent.mobileqq.troop.appscenter.mvi.a holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bindAppsInfo, "$bindAppsInfo");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (!com.tencent.mobileqq.utils.u.a().b()) {
            this$0.delegateListener.a(bindAppsInfo);
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            this$0.D0(view2, bindAppsInfo, 1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v0(h this$0, com.tencent.mobileqq.troop.appscenter.mvi.a holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        com.tencent.mobileqq.troop.appscenter.helper.b bVar = this$0.dragStartListener;
        if (bVar != null) {
            bVar.e(holder);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(final h this$0, com.tencent.mobileqq.troop.appscenter.mvi.a holder, final AppDetail bindAppsInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(bindAppsInfo, "$bindAppsInfo");
        TroopInfo troopInfo = this$0.troopInfo;
        boolean z16 = false;
        if (troopInfo != null && troopInfo.isOwner()) {
            z16 = true;
        }
        if (z16) {
            String str = bindAppsInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str, "bindAppsInfo.appId");
            if (holder.r(str, bindAppsInfo.type)) {
                DialogUtil.createCustomDialog(holder.itemView.getContext(), null, "\u53d6\u6d88\u9891\u9053\u5c55\u793a\u9700\u8981\u5728\u7ba1\u7406\u7fa4\u4e2d\u8fdb\u884c\u8bbe\u7f6e\uff0c\u662f\u5426\u7ee7\u7eed\uff1f", holder.itemView.getContext().getResources().getString(R.string.kgm), "\u53bb\u8bbe\u7f6e", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        h.x0(h.this, bindAppsInfo, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        h.y0(dialogInterface, i3);
                    }
                }).show();
                EventCollector.getInstance().onViewClicked(view);
            }
        }
        bg bgVar = bg.f302144a;
        ArrayList<AppDetail> arrayList = this$0.appDatas;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!Intrinsics.areEqual((AppDetail) obj, bindAppsInfo)) {
                arrayList2.add(obj);
            }
        }
        this$0.delegateListener.g(bindAppsInfo, bgVar.n(arrayList2));
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        this$0.D0(view2, bindAppsInfo, 2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(h this$0, AppDetail bindAppsInfo, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bindAppsInfo, "$bindAppsInfo");
        this$0.delegateListener.e(bindAppsInfo);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(h this$0, AppDetail bindAppsInfo, com.tencent.mobileqq.troop.appscenter.mvi.a holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bindAppsInfo, "$bindAppsInfo");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.delegateListener.f(bindAppsInfo, 1);
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        this$0.D0(view2, bindAppsInfo, 2);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.appscenter.mvi.a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.troop.appscenter.mvi.a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fzd, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026rent, false\n            )");
        return new com.tencent.mobileqq.troop.appscenter.mvi.a(inflate);
    }

    public final void B0(int fromPosition, int toPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
            return;
        }
        this.delegateListener.h(fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        ArrayList<AppDetail> arrayList = this.appDatas;
        arrayList.add(toPosition, arrayList.remove(fromPosition));
    }

    public final void C0(@NotNull com.tencent.mobileqq.troop.appscenter.data.f data) {
        List list;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.canShowDeleteBtn = false;
        if (this.canShowAddBtn != data.a()) {
            notifyDataSetChanged();
        }
        this.canShowAddBtn = data.a();
        this.troopInfo = data.e();
        this.isRecommendFlag = true;
        ArrayList<AppDetail> d16 = data.d();
        ArrayList arrayList = new ArrayList();
        for (Object obj : d16) {
            if (((AppDetail) obj).added == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        list = CollectionsKt___CollectionsKt.toList(this.appDatas);
        this.appDatas.clear();
        this.appDatas.addAll(arrayList);
        DiffUtil.calculateDiff(new b(list, arrayList)).dispatchUpdatesTo(this);
    }

    public final void D0(@NotNull View view, @NotNull AppDetail appDetail, int clickType) {
        int i3;
        HashMap hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, view, appDetail, Integer.valueOf(clickType));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(appDetail, "appDetail");
        if (this.isRecommendFlag) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("appid", appDetail.appId), TuplesKt.to("tab_name", Integer.valueOf(i3)), TuplesKt.to("click_status", Integer.valueOf(clickType)));
        VideoReport.setElementId(view, "em_group_icon");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, hashMapOf);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.appDatas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this, position)).longValue();
        }
        return position;
    }

    public final boolean o0(int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, position)).booleanValue();
        }
        if (position > getNUM_BACKGOURND_ICON()) {
            return false;
        }
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null && troopInfo.isHomeworkTroop()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((z16 && !this.appDatas.get(position).removable) || this.appDatas.get(position).type == 4) {
            return false;
        }
        return true;
    }

    public final boolean p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.canShowDeleteBtn;
    }

    @NotNull
    public final String q0(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, position);
        }
        String str = this.appDatas.get(position).name;
        Intrinsics.checkNotNullExpressionValue(str, "appDatas[position].name");
        return str;
    }

    public final void r0(@NotNull com.tencent.mobileqq.troop.appscenter.data.g data) {
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.canShowDeleteBtn != data.a()) {
            notifyDataSetChanged();
        }
        this.canShowDeleteBtn = data.a();
        this.canShowAddBtn = false;
        this.troopInfo = data.e();
        this.isRecommendFlag = false;
        list = CollectionsKt___CollectionsKt.toList(this.appDatas);
        this.appDatas.clear();
        this.appDatas.addAll(data.d());
        DiffUtil.calculateDiff(new b(list, data.d())).dispatchUpdatesTo(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final com.tencent.mobileqq.troop.appscenter.mvi.a holder, int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        AppDetail appDetail = this.appDatas.get(position);
        Intrinsics.checkNotNullExpressionValue(appDetail, "appDatas[position]");
        final AppDetail appDetail2 = appDetail;
        new com.tencent.mobileqq.troop.appscenter.utils.a().b(holder.itemView.getContext(), holder.o(), appDetail2.icon, 28.0f, false);
        boolean z17 = this.canShowDeleteBtn;
        TroopInfo troopInfo = this.troopInfo;
        boolean z18 = true;
        if (troopInfo != null && troopInfo.isOwner()) {
            z16 = true;
        } else {
            z16 = false;
        }
        holder.l(appDetail2, z17, z16, this.canShowAddBtn, this.isRecommendFlag);
        holder.p().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.u0(h.this, appDetail2, holder, view);
            }
        });
        if (this.canShowDeleteBtn) {
            TroopInfo troopInfo2 = this.troopInfo;
            if (troopInfo2 == null || !troopInfo2.isOwnerOrAdmin()) {
                z18 = false;
            }
            if (z18) {
                holder.p().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.c
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean v06;
                        v06 = h.v0(h.this, holder, view);
                        return v06;
                    }
                });
            }
        }
        holder.q().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.w0(h.this, holder, appDetail2, view);
            }
        });
        holder.m().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.z0(h.this, appDetail2, holder, view);
            }
        });
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        s0(view, appDetail2);
    }
}
