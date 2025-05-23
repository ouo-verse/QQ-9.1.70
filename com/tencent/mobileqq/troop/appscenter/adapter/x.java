package com.tencent.mobileqq.troop.appscenter.adapter;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u0017\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/x;", "Lcom/tencent/mobileqq/troop/appscenter/helper/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/troop/appscenter/data/g;", "shortcutAppsData", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/appscenter/mvi/a;", "vh", "e", "Lds2/a;", "E", "Lds2/a;", "delegateListener", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "appTitle", "G", "appManage", "H", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "", "I", "J", "debugLasClickTime", "", "debugClickCount", "Landroidx/recyclerview/widget/ItemTouchHelper;", "K", "Landroidx/recyclerview/widget/ItemTouchHelper;", ReportConstant.COSTREPORT_PREFIX, "()Landroidx/recyclerview/widget/ItemTouchHelper;", "v", "(Landroidx/recyclerview/widget/ItemTouchHelper;)V", "itemTouchHelper", "Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "L", "Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "r", "()Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "u", "(Lcom/tencent/mobileqq/troop/appscenter/adapter/h;)V", "appsListAdapter", "M", "getColumnsSize", "()I", "setColumnsSize", "(I)V", "columnsSize", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lds2/a;)V", "N", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class x extends RecyclerView.ViewHolder implements com.tencent.mobileqq.troop.appscenter.helper.b {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ds2.a delegateListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private TextView appTitle;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private TextView appManage;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private RecyclerView recyclerview;

    /* renamed from: I, reason: from kotlin metadata */
    private long debugLasClickTime;

    /* renamed from: J, reason: from kotlin metadata */
    private int debugClickCount;

    /* renamed from: K, reason: from kotlin metadata */
    public ItemTouchHelper itemTouchHelper;

    /* renamed from: L, reason: from kotlin metadata */
    public h appsListAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    private int columnsSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/appscenter/adapter/x$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
            outRect.right = cVar.b(4);
            outRect.top = cVar.b(4);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/x$b;", "", "", "EM_GROUP_APPLICATION_MANAGE", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.adapter.x$b, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25339);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@NotNull View itemView, @NotNull ds2.a delegateListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) delegateListener);
            return;
        }
        this.delegateListener = delegateListener;
        View findViewById = itemView.findViewById(R.id.f101175uh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.troop_app_title)");
        this.appTitle = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f101095u_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.troop_app_manage)");
        this.appManage = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f101125uc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.troop_app_recyclerview)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.recyclerview = recyclerView;
        t(recyclerView);
        RecyclerView recyclerView2 = this.recyclerview;
        recyclerView2.setAdapter(r());
        recyclerView2.setItemAnimator(null);
        recyclerView2.setNestedScrollingEnabled(false);
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        recyclerView2.setPadding(cVar.b(16), 0, cVar.b(8), 0);
        this.recyclerview.addItemDecoration(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.appManage.getText(), "\u5b8c\u6210")) {
            this$0.delegateListener.c(false);
        } else if (Intrinsics.areEqual(this$0.appManage.getText(), "\u7ba1\u7406")) {
            this$0.delegateListener.c(true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q() {
        if (System.currentTimeMillis() - this.debugLasClickTime < 1000) {
            int i3 = this.debugClickCount + 1;
            this.debugClickCount = i3;
            if (i3 >= 8) {
                QQToastUtil.showQQToastInUiThread(-1, "\u5373\u5c06\u89e6\u53d1\u8c03\u8bd5\u529f\u80fd\uff0c\u8fde\u7eed\u70b9\u51fb15\u6b21\u5c06ANR");
            }
            if (this.debugClickCount > 14) {
                QLog.w("ArkApp.Debug", 1, "debugClick will anr");
                try {
                    LockMethodProxy.sleep(20000L);
                } catch (Exception unused) {
                }
            }
        } else {
            this.debugClickCount = 1;
        }
        this.debugLasClickTime = System.currentTimeMillis();
    }

    private final void t(RecyclerView recyclerView) {
        u(new h(this.delegateListener, this));
        v(new ItemTouchHelper(new com.tencent.mobileqq.troop.appscenter.helper.a(r())));
        s().attachToRecyclerView(recyclerView);
    }

    @Override // com.tencent.mobileqq.troop.appscenter.helper.b
    public void e(@NotNull com.tencent.mobileqq.troop.appscenter.mvi.a vh5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) vh5);
            return;
        }
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (this.itemTouchHelper != null) {
            s().startDrag(vh5);
        }
    }

    public final void n(@NotNull com.tencent.mobileqq.troop.appscenter.data.g shortcutAppsData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) shortcutAppsData);
            return;
        }
        Intrinsics.checkNotNullParameter(shortcutAppsData, "shortcutAppsData");
        if (shortcutAppsData.f()) {
            this.appManage.setVisibility(0);
            VideoReport.setElementId(this.appManage, "em_group_application_manage");
        }
        if (this.columnsSize != shortcutAppsData.c()) {
            this.recyclerview.setLayoutManager(new GridLayoutManager(this.itemView.getContext(), shortcutAppsData.c()));
            this.columnsSize = shortcutAppsData.c();
        }
        if (shortcutAppsData.a()) {
            this.appManage.setText("\u5b8c\u6210");
            this.appTitle.setText("\u957f\u6309\u62d6\u52a8\u8c03\u6574\u987a\u5e8f");
        } else {
            this.appManage.setText("\u7ba1\u7406");
            this.appTitle.setText("\u7fa4\u5e94\u7528\u5feb\u6377\u680f");
        }
        this.appManage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.o(x.this, view);
            }
        });
        r().r0(shortcutAppsData);
        this.appTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.p(x.this, view);
            }
        });
    }

    @NotNull
    public final h r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        h hVar = this.appsListAdapter;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appsListAdapter");
        return null;
    }

    @NotNull
    public final ItemTouchHelper s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ItemTouchHelper) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper != null) {
            return itemTouchHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        return null;
    }

    public final void u(@NotNull h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hVar);
        } else {
            Intrinsics.checkNotNullParameter(hVar, "<set-?>");
            this.appsListAdapter = hVar;
        }
    }

    public final void v(@NotNull ItemTouchHelper itemTouchHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) itemTouchHelper);
        } else {
            Intrinsics.checkNotNullParameter(itemTouchHelper, "<set-?>");
            this.itemTouchHelper = itemTouchHelper;
        }
    }
}
