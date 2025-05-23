package com.tencent.qqnt.chathistory.ui.dialog.retrieval;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.dialog.retrieval.g;
import com.tencent.qqnt.chathistory.ui.dialog.retrieval.h;
import com.tencent.qqnt.chathistory.ui.dialog.retrieval.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "getItemViewType", "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/i;", "repo", "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/a;", "clickInvoker", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/i;Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/a;)V", "D", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a D;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chathistory.ui.dialog.retrieval.a clickInvoker;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i repo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/f$a;", "", "", "ITEM_TYPE_CLEAR", "I", "ITEM_TYPE_HISTORY", "ITEM_TYPE_TITLE", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            D = new a(null);
        }
    }

    public f(@NotNull i repo, @NotNull com.tencent.qqnt.chathistory.ui.dialog.retrieval.a clickInvoker) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(clickInvoker, "clickInvoker");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repo, (Object) clickInvoker);
        } else {
            this.repo = repo;
            this.clickInvoker = clickInvoker;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(f this$0, String item, View itemView) {
        Map<String, Object> mutableMapOf;
        EventCollector.getInstance().onViewClickedBefore(itemView);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.clickInvoker.a(item);
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("number_search_history_displays", Integer.valueOf(this$0.repo.c())));
        a16.m(itemView, "em_bas_search_history", mutableMapOf);
        EventCollector.getInstance().onViewClicked(itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(f this$0, String item, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.clickInvoker.clearHistory(item, i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clickInvoker.b();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.repo.c() > 0) {
            return this.repo.c() + 2;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, position)).intValue();
        }
        if (position == 0) {
            return 1;
        }
        if (position == getNUM_BACKGOURND_ICON() - 1) {
            return 3;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        h hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof h) {
            hVar = (h) holder;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            final String b16 = this.repo.b(position - 1);
            hVar.l(b16);
            hVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.dialog.retrieval.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.l0(f.this, b16, view);
                }
            });
            hVar.m().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.dialog.retrieval.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.m0(f.this, b16, position, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            j.Companion companion = j.INSTANCE;
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return companion.a(context);
        }
        if (viewType == 2) {
            h.Companion companion2 = h.INSTANCE;
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            return companion2.a(context2);
        }
        if (viewType == 3) {
            g.Companion companion3 = g.INSTANCE;
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
            RecyclerView.ViewHolder a16 = companion3.a(context3);
            a16.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.dialog.retrieval.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.n0(f.this, view);
                }
            });
            return a16;
        }
        throw new RuntimeException("can not impl " + viewType + " !!");
    }
}
