package com.tencent.qqnt.chathistory.ui.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/n;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Landroid/view/View;", "view", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "holder", "", "i", tl.h.F, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "c", "helper", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", "Ljava/lang/String;", "curPageId", "", "f", "()I", "itemViewType", "<init>", "()V", "d", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class n extends com.tencent.qqnt.expandRecyclerView.adapter.provider.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curPageId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/n$a;", "", "", "TYPE_LOAD_MORE", "I", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.base.n$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.curPageId = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(n this$0, View it) {
        View.OnClickListener p06;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b m3 = this$0.m();
        if (m3 != null && (p06 = m3.p0()) != null) {
            p06.onClick(it);
        }
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        HistoryDtReportHelper.n(a16, it, "em_bas_load_more", null, 4, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final String q(View view) {
        boolean z16;
        String str;
        if (this.curPageId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            PageInfo pageInfo = VideoReport.getPageInfo((View) parent);
            if (pageInfo != null) {
                str = pageInfo.getPageId();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            this.curPageId = str;
        }
        return this.curPageId;
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    @NotNull
    public View c(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        FrameLayout root = dw3.a.g(LayoutInflater.from(parent.getContext())).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(LayoutInflater.from(parent.context)).root");
        return root;
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 10;
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    public void h(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a holder) {
        Map mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        Map<String, Object> c16 = companion.a().c();
        if (c16 == null) {
            c16 = new LinkedHashMap<>();
        }
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        c16.put("pgid", q(view));
        HistoryDtReportHelper a16 = companion.a();
        View view2 = holder.itemView;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", c16));
        HistoryDtReportHelper.p(a16, view2, "em_bas_load_more", mutableMapOf, null, 8, null);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    public void i(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a holder) {
        Map mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        Map<String, Object> c16 = companion.a().c();
        if (c16 == null) {
            c16 = new LinkedHashMap<>();
        }
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        c16.put("pgid", q(view));
        HistoryDtReportHelper a16 = companion.a();
        View view2 = holder.itemView;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", c16));
        HistoryDtReportHelper.r(a16, view2, "em_bas_load_more", mutableMapOf, null, 8, null);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a helper, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) helper, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        QUIButton qUIButton = (QUIButton) helper.itemView.findViewById(R.id.eew);
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.base.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.p(n.this, view);
                }
            });
        }
        ViewGroup.LayoutParams layoutParams = helper.itemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        View view = helper.itemView;
        layoutParams.width = -1;
        view.setLayoutParams(layoutParams);
    }
}
