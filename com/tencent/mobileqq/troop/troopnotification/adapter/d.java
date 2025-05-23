package com.tencent.mobileqq.troop.troopnotification.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.render.TroopNotificationRender;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019RT\u0010(\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/adapter/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "", "Lcom/tencent/qqnt/notification/f;", "getDataList", "", "position", "k0", "getItemCount", "", "getItemId", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "viewHolder", "", "l0", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "vm", BdhLogUtil.LogTag.Tag_Conn, "I", "category", "D", "type", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "vh", com.tencent.luggage.wxa.c8.c.G, "E", "Lkotlin/jvm/functions/Function2;", "getOnBindViewListener", "()Lkotlin/jvm/functions/Function2;", "p0", "(Lkotlin/jvm/functions/Function2;)V", "onBindViewListener", "<init>", "(Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;II)V", UserInfo.SEX_FEMALE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends RecyclerView.Adapter<com.tencent.mobileqq.troop.troopnotification.render.vh.list.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int category;

    /* renamed from: D, reason: from kotlin metadata */
    private final int type;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function2<? super com.tencent.mobileqq.troop.troopnotification.render.vh.list.a, ? super Integer, Unit> onBindViewListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopNotificationListVM vm;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/adapter/d$a;", "", "", "TAG", "Ljava/lang/String;", "", "TYPE_ALL", "I", "TYPE_HISTORY", "TYPE_RECENT", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.adapter.d$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58595);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull TroopNotificationListVM vm5, int i3, int i16) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, vm5, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.vm = vm5;
        this.category = i3;
        this.type = i16;
    }

    private final List<com.tencent.qqnt.notification.f> getDataList() {
        int i3 = this.type;
        if (i3 != 1) {
            if (i3 != 2) {
                Map<Integer, List<com.tencent.qqnt.notification.f>> value = this.vm.j2().getValue();
                if (value == null) {
                    return null;
                }
                return value.get(Integer.valueOf(this.category));
            }
            Map<Integer, List<com.tencent.qqnt.notification.f>> value2 = this.vm.g2().getValue();
            if (value2 == null) {
                return null;
            }
            return value2.get(Integer.valueOf(this.category));
        }
        Map<Integer, List<com.tencent.qqnt.notification.f>> value3 = this.vm.l2().getValue();
        if (value3 == null) {
            return null;
        }
        return value3.get(Integer.valueOf(this.category));
    }

    private final com.tencent.qqnt.notification.f k0(int position) {
        List<com.tencent.qqnt.notification.f> dataList = getDataList();
        if (dataList == null) {
            return null;
        }
        if (position >= 0 && position < dataList.size()) {
            return dataList.get(position);
        }
        QLog.e("TroopNotificationListAdapter", 1, "getItem: ", new IndexOutOfBoundsException("category=" + this.category + ", type=" + this.type + ", position=" + position + ", length=" + dataList.size()));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(com.tencent.qqnt.notification.f fVar, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListAdapter", 2, "onBindViewHolder: jump detail, seq=" + fVar.j().seq);
        }
        TroopNotificationListVM troopNotificationListVM = this$0.vm;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        troopNotificationListVM.C2(context, fVar);
        com.tencent.mobileqq.troop.troopnotification.report.d.f300921a.l(fVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder, d this$0, com.tencent.qqnt.notification.f fVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        viewHolder.m().h();
        this$0.vm.c2(fVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        List<com.tencent.qqnt.notification.f> dataList = getDataList();
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        GroupNotifyMsg j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, position)).longValue();
        }
        com.tencent.qqnt.notification.f k06 = k0(position);
        if (k06 != null && (j3 = k06.j()) != null) {
            return j3.seq;
        }
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, position)).intValue();
        }
        com.tencent.qqnt.notification.f k06 = k0(position);
        if (k06 != null) {
            return com.tencent.mobileqq.troop.troopnotification.render.b.f300733a.c(k06);
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final com.tencent.qqnt.notification.f k06 = k0(position);
        if (k06 != null) {
            TroopNotificationRender.f300720a.y(viewHolder, k06);
            viewHolder.s().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.m0(com.tencent.qqnt.notification.f.this, this, view);
                }
            });
            viewHolder.o().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.n0(com.tencent.mobileqq.troop.troopnotification.render.vh.list.a.this, this, k06, view);
                }
            });
            com.tencent.mobileqq.troop.troopnotification.report.d dVar = com.tencent.mobileqq.troop.troopnotification.report.d.f300921a;
            dVar.d(viewHolder.s(), k06);
            dVar.m(this.category, k06);
        }
        Function2<? super com.tencent.mobileqq.troop.troopnotification.render.vh.list.a, ? super Integer, Unit> function2 = this.onBindViewListener;
        if (function2 != null) {
            function2.invoke(viewHolder, Integer.valueOf(position));
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListAdapter", 2, "onBindViewHolder: ");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.troopnotification.render.vh.list.a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.troop.troopnotification.render.vh.list.a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        com.tencent.mobileqq.troop.troopnotification.render.b bVar = com.tencent.mobileqq.troop.troopnotification.render.b.f300733a;
        int b16 = bVar.b(viewType);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return bVar.a(b16, context, this.vm);
    }

    public final void p0(@Nullable Function2<? super com.tencent.mobileqq.troop.troopnotification.render.vh.list.a, ? super Integer, Unit> function2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function2);
        } else {
            this.onBindViewListener = function2;
        }
    }
}
