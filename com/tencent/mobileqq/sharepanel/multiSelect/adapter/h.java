package com.tencent.mobileqq.sharepanel.multiSelect.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0010\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/h;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/j;", "", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "newList", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "position", "l0", "viewHolder", "j0", "getItemCount", "Lkotlin/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onContactShowListener", BdhLogUtil.LogTag.Tag_Conn, "onContactClickListener", "", "D", "Ljava/util/List;", "selectedList", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h extends RecyclerView.Adapter<j> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<SharePanelContactItem, Unit> onContactClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<SharePanelContactItem> selectedList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<SharePanelContactItem, Unit> onContactShowListener;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull Function1<? super SharePanelContactItem, Unit> onContactShowListener, @NotNull Function1<? super SharePanelContactItem, Unit> onContactClickListener) {
        Intrinsics.checkNotNullParameter(onContactShowListener, "onContactShowListener");
        Intrinsics.checkNotNullParameter(onContactClickListener, "onContactClickListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onContactShowListener, (Object) onContactClickListener);
            return;
        }
        this.onContactShowListener = onContactShowListener;
        this.onContactClickListener = onContactClickListener;
        this.selectedList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(h this$0, SharePanelContactItem data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.onContactClickListener.invoke(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.selectedList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull j viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final SharePanelContactItem sharePanelContactItem = this.selectedList.get(position);
        viewHolder.m(sharePanelContactItem, position);
        this.onContactShowListener.invoke(sharePanelContactItem);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.k0(h.this, sharePanelContactItem, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public j onCreateViewHolder(@NotNull ViewGroup parent, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (j) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, position);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        wq2.c g16 = wq2.c.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026rent, false\n            )");
        return new j(g16);
    }

    public final void setData(@NotNull List<SharePanelContactItem> newList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) newList);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.selectedList.clear();
        this.selectedList.addAll(newList);
        notifyDataSetChanged();
    }
}
