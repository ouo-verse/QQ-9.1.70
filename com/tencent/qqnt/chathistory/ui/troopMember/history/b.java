package com.tencent.qqnt.chathistory.ui.troopMember.history;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.avatar.a;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.avatar.f;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.troopMember.history.viewmodel.TroopMemberHistoryViewModel;
import com.tencent.qqnt.chathistory.util.MsgRecordExKt;
import com.tencent.qqnt.chathistory.x2k.j;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b#\u0010$J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0014\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/b$a;", "", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "getData", "newData", "", "setData", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "o0", "holder", "position", "m0", "getItemCount", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/viewmodel/TroopMemberHistoryViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/viewmodel/TroopMemberHistoryViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleCoroutineScope;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/c;", "D", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/c;", "listener", "", "E", "Ljava/util/List;", "data", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/troopMember/history/viewmodel/TroopMemberHistoryViewModel;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/tencent/qqnt/chathistory/ui/troopMember/history/c;)V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LifecycleCoroutineScope lifecycleScope;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c listener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> data;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopMemberHistoryViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u001c\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "historyModel", "", "l", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "tvNick", UserInfo.SEX_FEMALE, "tvSummary", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "G", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "ivIcon", "H", "tvTime", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/troopMember/history/b;Landroid/view/View;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView tvNick;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView tvSummary;

        /* renamed from: G, reason: from kotlin metadata */
        private final RoundRectImageView ivIcon;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView tvTime;
        final /* synthetic */ b I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.I = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) itemView);
                return;
            }
            this.tvNick = (TextView) itemView.findViewById(R.id.text1);
            this.tvSummary = (TextView) itemView.findViewById(R.id.text2);
            RoundRectImageView roundRectImageView = (RoundRectImageView) itemView.findViewById(R.id.icon);
            roundRectImageView.setCornerRadiusAndMode(com.tencent.qqnt.util.view.b.f362999a.b(25), 1);
            roundRectImageView.setImportantForAccessibility(2);
            this.ivIcon = roundRectImageView;
            this.tvTime = (TextView) itemView.findViewById(R.id.lastMsgTime);
        }

        public final void l(@NotNull com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a historyModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) historyModel);
                return;
            }
            Intrinsics.checkNotNullParameter(historyModel, "historyModel");
            TextView tvNick = this.tvNick;
            Intrinsics.checkNotNullExpressionValue(tvNick, "tvNick");
            int M1 = this.I.viewModel.M1();
            MsgRecord msgRecord = historyModel.e().msgRecord;
            Intrinsics.checkNotNullExpressionValue(msgRecord, "historyModel.info.msgRecord");
            MsgRecordExKt.d(tvNick, M1, msgRecord, this.I.lifecycleScope, 12);
            this.tvSummary.setText(historyModel.d());
            if (historyModel.c()) {
                this.ivIcon.setVisibility(8);
            } else {
                this.ivIcon.setVisibility(0);
                a.Companion companion = com.tencent.qqnt.avatar.a.INSTANCE;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                f b16 = companion.b(context);
                RoundRectImageView ivIcon = this.ivIcon;
                Intrinsics.checkNotNullExpressionValue(ivIcon, "ivIcon");
                e.a.b(b16.b(ivIcon), historyModel.i(), historyModel.j(), null, 4, null);
            }
            this.tvTime.setText(historyModel.b());
        }
    }

    public b(@NotNull TroopMemberHistoryViewModel viewModel, @NotNull LifecycleCoroutineScope lifecycleScope, @NotNull c listener) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, viewModel, lifecycleScope, listener);
            return;
        }
        this.viewModel = viewModel;
        this.lifecycleScope = lifecycleScope;
        this.listener = listener;
        this.data = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(b this$0, int i3, a holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.listener.a(this$0.data.get(i3));
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        HistoryDtReportHelper.n(a16, view2, "em_bas_message_entry", null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.data.size();
    }

    public final void l0(@NotNull List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        int size = this.data.size();
        this.data.addAll(newData);
        notifyItemRangeInserted(size, newData.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final a holder, final int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        HistoryDtReportHelper.t(a16, view, "em_bas_message_entry", null, false, false, null, 60, null);
        holder.l(this.data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.n0(b.this, position, holder, view2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new a(this, new j(context, null, 2, null).getMRv());
    }

    public final void setData(@NotNull List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data.clear();
        this.data.addAll(newData);
        notifyDataSetChanged();
    }
}
