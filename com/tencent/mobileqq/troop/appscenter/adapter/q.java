package com.tencent.mobileqq.troop.appscenter.adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b5\u00106J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016J,\u0010\u001a\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/q;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/appscenter/mvi/m;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "apps", "Lcom/tencent/mobileqq/troop/appscenter/adapter/a;", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "position", "", "getItemId", "getItemCount", "holder", "", "m0", "Ljava/util/ArrayList;", "", "tabName", "", "ownerOrAdmin", "editManage", "r0", "Lds2/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lds2/a;", "delegateListener", BdhLogUtil.LogTag.Tag_Conn, "Z", "isOwnerOrAdmin", "()Z", "setOwnerOrAdmin", "(Z)V", "D", "isEditManage", "setEditManage", "E", "Ljava/lang/String;", "l0", "()Ljava/lang/String;", "q0", "(Ljava/lang/String;)V", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "appDatas", "Landroid/graphics/Typeface;", "G", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "<init>", "(Lds2/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class q extends RecyclerView.Adapter<com.tencent.mobileqq.troop.appscenter.mvi.m> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isOwnerOrAdmin;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isEditManage;

    /* renamed from: E, reason: from kotlin metadata */
    public String tabName;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ArrayList<AppDetail> appDatas;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Typeface typeface;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ds2.a delegateListener;

    public q(@NotNull ds2.a delegateListener) {
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) delegateListener);
        } else {
            this.delegateListener = delegateListener;
            this.appDatas = new ArrayList<>();
        }
    }

    private final List<a> k0(List<AppDetail> apps) {
        ArrayList arrayList = new ArrayList();
        Iterator<AppDetail> it = apps.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            arrayList.add(new a(i3, it.next()));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(com.tencent.mobileqq.troop.appscenter.mvi.m viewHolder, q this$0, View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = viewHolder.itemView.getTag();
        if (tag instanceof a) {
            aVar = (a) tag;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            this$0.delegateListener.a(aVar.a());
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
            int b16 = aVar.b();
            String str = aVar.a().appId;
            Intrinsics.checkNotNullExpressionValue(str, "it.appsInfo.appId");
            viewHolder.s(view2, b16, str, this$0.l0());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(q this$0, com.tencent.mobileqq.troop.appscenter.mvi.m viewHolder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        a aVar = null;
        if (this$0.isOwnerOrAdmin && this$0.isEditManage) {
            Object tag = viewHolder.itemView.getTag();
            if (tag instanceof a) {
                aVar = (a) tag;
            }
            if (aVar != null) {
                this$0.delegateListener.f(aVar.a(), 2);
            }
        } else {
            Object tag2 = viewHolder.itemView.getTag();
            if (tag2 instanceof a) {
                aVar = (a) tag2;
            }
            if (aVar != null) {
                this$0.delegateListener.a(aVar.a());
                QUIButton o16 = viewHolder.o();
                int b16 = aVar.b();
                String str = aVar.a().appId;
                Intrinsics.checkNotNullExpressionValue(str, "it.appsInfo.appId");
                viewHolder.s(o16, b16, str, this$0.l0());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.appDatas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, position)).longValue();
        }
        return position;
    }

    @NotNull
    public final String l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String str = this.tabName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabName");
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.mobileqq.troop.appscenter.mvi.m holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        AppDetail appDetail = this.appDatas.get(position);
        Intrinsics.checkNotNullExpressionValue(appDetail, "appDatas[position]");
        AppDetail appDetail2 = appDetail;
        String str = appDetail2.appId;
        Intrinsics.checkNotNullExpressionValue(str, "bindAppsInfo.appId");
        holder.t(position, str, l0());
        new com.tencent.mobileqq.troop.appscenter.utils.a().b(holder.itemView.getContext(), holder.p(), appDetail2.icon, 40.0f, false);
        holder.r().setText(String.valueOf(position + 1));
        holder.r().setTypeface(this.typeface);
        if (position != 0) {
            if (position != 1) {
                if (position != 2) {
                    holder.r().setTextColor(holder.itemView.getContext().getResources().getColorStateList(PositionColor.DEFAULT.getColorResId(), null));
                } else {
                    holder.r().setTextColor(holder.itemView.getContext().getResources().getColorStateList(PositionColor.POSITION_2.getColorResId(), null));
                }
            } else {
                holder.r().setTextColor(holder.itemView.getContext().getResources().getColorStateList(PositionColor.POSITION_1.getColorResId(), null));
            }
        } else {
            holder.r().setTextColor(holder.itemView.getContext().getResources().getColorStateList(PositionColor.POSITION_0.getColorResId(), null));
        }
        if (position == 0) {
            holder.q().setVisibility(4);
        } else {
            holder.q().setVisibility(0);
        }
        holder.m(appDetail2, this.isOwnerOrAdmin, this.isEditManage);
        holder.itemView.setTag(new a(position, appDetail2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.appscenter.mvi.m onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.troop.appscenter.mvi.m) iPatchRedirector.redirect((short) 8, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.g1g, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026list_item, parent, false)");
        final com.tencent.mobileqq.troop.appscenter.mvi.m mVar = new com.tencent.mobileqq.troop.appscenter.mvi.m(inflate);
        this.typeface = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf");
        mVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.o0(com.tencent.mobileqq.troop.appscenter.mvi.m.this, this, view);
            }
        });
        mVar.o().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.p0(q.this, mVar, view);
            }
        });
        return mVar;
    }

    public final void q0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tabName = str;
        }
    }

    public final void r0(@NotNull ArrayList<AppDetail> apps, @NotNull String tabName, boolean ownerOrAdmin, boolean editManage) {
        List<AppDetail> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, apps, tabName, Boolean.valueOf(ownerOrAdmin), Boolean.valueOf(editManage));
            return;
        }
        Intrinsics.checkNotNullParameter(apps, "apps");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        this.isOwnerOrAdmin = ownerOrAdmin;
        if (this.isEditManage != editManage) {
            notifyDataSetChanged();
        }
        this.isEditManage = editManage;
        q0(tabName);
        list = CollectionsKt___CollectionsKt.toList(this.appDatas);
        this.appDatas.clear();
        this.appDatas.addAll(apps);
        DiffUtil.calculateDiff(new r(k0(list), k0(apps))).dispatchUpdatesTo(this);
    }
}
