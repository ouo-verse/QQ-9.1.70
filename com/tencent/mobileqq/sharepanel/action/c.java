package com.tencent.mobileqq.sharepanel.action;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.action.d;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R2\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/action/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/sharepanel/action/d;", "Lcom/tencent/mobileqq/sharepanel/action/e;", "actionItem", "", "j0", "", "", "k0", "", "dataList", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "position", "n0", "getItemCount", "holder", "l0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "Lkotlin/Function1;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "o0", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends RecyclerView.Adapter<d> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<? super e, Unit> onItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e> itemList;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.itemList = new ArrayList();
        }
    }

    private final String j0(e actionItem) {
        if (actionItem instanceof j) {
            return "em_share_item";
        }
        if (actionItem instanceof a) {
            return "em_share_controls";
        }
        return "";
    }

    private final Map<String, Object> k0(e actionItem) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (actionItem instanceof j) {
            linkedHashMap.put("share_channel_id", ((j) actionItem).h());
        } else if (actionItem instanceof a) {
            linkedHashMap.put("operation_id", actionItem.a());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(c this$0, e item, d holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Function1<? super e, Unit> function1 = this$0.onItemClickListener;
        if (function1 != null) {
            function1.invoke(item);
        }
        com.tencent.mobileqq.sharepanel.ioc.f.f287347a.d(holder.itemView, this$0.j0(item), this$0.k0(item));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.itemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final d holder, int position) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.itemList, position);
        final e eVar = (e) orNull;
        if (eVar == null) {
            return;
        }
        holder.n(eVar);
        com.tencent.mobileqq.sharepanel.ioc.f.f287347a.g(holder.itemView, j0(eVar), k0(eVar));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.action.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.m0(c.this, eVar, holder, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NotNull ViewGroup parent, int position) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, position);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        d.Companion companion = d.INSTANCE;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        View a16 = companion.a(context);
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.itemList, position);
        e eVar = (e) orNull;
        if (eVar != null) {
            com.tencent.mobileqq.sharepanel.ioc.f.k(com.tencent.mobileqq.sharepanel.ioc.f.f287347a, parent, j0(eVar), null, 4, null);
        }
        return new d(a16);
    }

    public final void o0(@Nullable Function1<? super e, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function1);
        } else {
            this.onItemClickListener = function1;
        }
    }

    public final void setData(@NotNull List<? extends e> dataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dataList);
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.itemList.clear();
        this.itemList.addAll(dataList);
        notifyDataSetChanged();
    }
}
