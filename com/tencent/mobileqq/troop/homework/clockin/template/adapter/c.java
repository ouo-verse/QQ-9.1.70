package com.tencent.mobileqq.troop.homework.clockin.template.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.homework.clockin.publish.HWClockInPublishFragment;
import com.tencent.mobileqq.troop.homework.clockin.template.adapter.c;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0014\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0014J2\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0014R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/template/adapter/c;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/template/adapter/c$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "e", "holder", "", "payloads", "", "d", "", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "troopUin", "<init>", "(Ljava/lang/String;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends AbsListItemAdapterDelegate<com.tencent.mobileqq.troop.homework.clockin.template.model.a, com.tencent.mobileqq.troop.homework.clockin.template.model.a, a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/template/adapter/c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/a;", "model", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleTv", "G", "contentTv", "H", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/a;", "curModel", "<init>", "(Lcom/tencent/mobileqq/troop/homework/clockin/template/adapter/c;Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView titleTv;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView contentTv;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.troop.homework.clockin.template.model.a curModel;
        final /* synthetic */ c I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull final c cVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.I = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) itemView);
                return;
            }
            this.itemView = itemView;
            View findViewById = this.itemView.findViewById(R.id.xxt);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.item_template_title)");
            this.titleTv = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.xxs);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.item_template_content)");
            this.contentTv = (TextView) findViewById2;
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            TriggerRunnerKt.c(itemView2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.template.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.a.m(c.a.this, cVar, view);
                }
            }, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(a this$0, c this$1, View it) {
            HashMap hashMapOf;
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            com.tencent.mobileqq.troop.homework.clockin.template.model.a aVar = this$0.curModel;
            if (aVar != null) {
                com.tencent.mobileqq.troop.homework.clockin.report.a aVar2 = com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("template_num", aVar.c()));
                h.a.f(aVar2, it, "em_group_clock_in_template", hashMapOf, null, 8, null);
                HWClockInPublishFragment.INSTANCE.a(this$1.b(), aVar.d(), aVar.b(), aVar.c());
            }
            EventCollector.getInstance().onViewClicked(it);
        }

        public final void n(@NotNull com.tencent.mobileqq.troop.homework.clockin.template.model.a model) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) model);
                return;
            }
            Intrinsics.checkNotNullParameter(model, "model");
            this.curModel = model;
            this.titleTv.setText(model.d());
            this.contentTv.setText(model.b());
        }
    }

    public c(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
        } else {
            this.troopUin = troopUin;
        }
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.troop.homework.clockin.template.model.a item, @NotNull List<com.tencent.mobileqq.troop.homework.clockin.template.model.a> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.troop.homework.clockin.template.model.a item, @NotNull a holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, item, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.n(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = View.inflate(parent.getContext(), R.layout.g07, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(parent.context, \u2026mplate_item_layout, null)");
        return new a(this, inflate);
    }
}
