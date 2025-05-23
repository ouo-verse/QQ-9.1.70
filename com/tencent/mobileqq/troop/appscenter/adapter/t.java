package com.tencent.mobileqq.troop.appscenter.adapter;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/t;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/appscenter/data/f;", "recommendData", "", "l", "Lds2/a;", "E", "Lds2/a;", "delegateListener", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "appTitle", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "Landroidx/constraintlayout/widget/ConstraintLayout;", "H", "Landroidx/constraintlayout/widget/ConstraintLayout;", "troopAppsItem", "I", "troopTitleCly", "Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "J", "Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "getAppsListAdapter", "()Lcom/tencent/mobileqq/troop/appscenter/adapter/h;", "setAppsListAdapter", "(Lcom/tencent/mobileqq/troop/appscenter/adapter/h;)V", "appsListAdapter", "", "K", "getColumnsSize", "()I", "setColumnsSize", "(I)V", "columnsSize", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lds2/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class t extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ds2.a delegateListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private TextView appTitle;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private RecyclerView recyclerview;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ConstraintLayout troopAppsItem;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private ConstraintLayout troopTitleCly;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private h appsListAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private int columnsSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/appscenter/adapter/t$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@NotNull View itemView, @NotNull ds2.a delegateListener) {
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
        View findViewById2 = itemView.findViewById(R.id.f101125uc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.troop_app_recyclerview)");
        this.recyclerview = (RecyclerView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f101205uk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.troop_apps_item)");
        this.troopAppsItem = (ConstraintLayout) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.f101185ui);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.troop_app_title_cly)");
        this.troopTitleCly = (ConstraintLayout) findViewById4;
        this.recyclerview.addItemDecoration(new a());
        h hVar = new h(delegateListener, null);
        this.appsListAdapter = hVar;
        RecyclerView recyclerView = this.recyclerview;
        recyclerView.setAdapter(hVar);
        recyclerView.setItemAnimator(null);
        recyclerView.setNestedScrollingEnabled(false);
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        recyclerView.setPadding(cVar.b(16), 0, cVar.b(8), 0);
    }

    public final void l(@NotNull com.tencent.mobileqq.troop.appscenter.data.f recommendData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) recommendData);
            return;
        }
        Intrinsics.checkNotNullParameter(recommendData, "recommendData");
        this.appTitle.setText("\u7fa4\u5e94\u7528\u63a8\u8350");
        if (this.columnsSize != recommendData.c()) {
            this.recyclerview.setLayoutManager(new GridLayoutManager(this.itemView.getContext(), recommendData.c()));
            this.columnsSize = recommendData.c();
        }
        ArrayList<AppDetail> d16 = recommendData.d();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = d16.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((AppDetail) next).added != 0) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            this.troopAppsItem.setVisibility(0);
            this.troopTitleCly.setVisibility(0);
        } else {
            this.troopAppsItem.setVisibility(8);
            this.troopTitleCly.setVisibility(8);
        }
        this.appsListAdapter.C0(recommendData);
    }
}
