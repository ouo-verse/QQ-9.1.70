package com.tencent.mobileqq.multishare.part;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.multishare.action.ShareActionLine;
import com.tencent.mobileqq.multishare.fragment.MultiShareBottomDialogFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0002J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Li92/a;", "", "z9", "Landroid/view/View;", "parentView", "", "Lcom/tencent/mobileqq/multishare/action/b;", "actions", "", "index", "Landroidx/recyclerview/widget/RecyclerView;", "x9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "U2", "A9", "", "Lcom/tencent/mobileqq/multishare/adapter/a;", "d", "Ljava/util/List;", "adapterList", "<init>", "()V", "e", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends Part implements i92.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.multishare.adapter.a> adapterList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/a$a;", "", "", "ITEM_BOTTOM_MARGIN", UserInfo.SEX_FEMALE, "ITEM_GAP_MARGIN", "ITEM_ICON_HEIGHT", "ITEM_LABEL_LINE_SPACE", "ITEM_LABEL_LINE_SPACE_MULT", "", "ITEM_LABEL_MAX_LINES", "I", "ITEM_LABEL_TEXT_SIZE", "ITEM_WIDTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.part.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes15.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/multishare/part/a$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
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
            outRect.right = ViewUtils.dip2px(8.0f);
            outRect.left = ViewUtils.dip2px(8.0f);
            outRect.bottom = ViewUtils.dip2px(16.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/multishare/part/a$c", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends LinearLayoutManager {
        static IPatchRedirector $redirector_;

        c(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42152);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.adapterList = new ArrayList();
        }
    }

    private final RecyclerView x9(View parentView, List<? extends com.tencent.mobileqq.multishare.action.b> actions, int index) {
        RecyclerView recyclerView = new RecyclerView(parentView.getContext());
        if (index != 0) {
            if (index == 1) {
                recyclerView.setId(R.id.zik);
            }
        } else {
            recyclerView.setId(R.id.zip);
        }
        recyclerView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        recyclerView.setPadding(ViewUtils.dip2px(8.0f), 0, 0, 0);
        recyclerView.setClipToPadding(false);
        c cVar = new c(getContext());
        cVar.setOrientation(0);
        recyclerView.setLayoutManager(cVar);
        com.tencent.mobileqq.multishare.adapter.a aVar = new com.tencent.mobileqq.multishare.adapter.a();
        aVar.setItems(actions);
        this.adapterList.add(index, aVar);
        recyclerView.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{aVar}));
        recyclerView.addItemDecoration(new b());
        return recyclerView;
    }

    private final void z9() {
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        List<com.tencent.mobileqq.multishare.action.b> vh5;
        View findViewById = getPartRootView().findViewById(R.id.ziq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lti_share_actions_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        ArrayList<com.tencent.mobileqq.multishare.action.b> arrayList = new ArrayList();
        IPartHost partHost = getPartHost();
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null && (vh5 = multiShareBottomDialogFragment.vh()) != null) {
            arrayList.addAll(vh5);
        }
        if (arrayList.isEmpty()) {
            linearLayout.setVisibility(8);
            QLog.d("MultiShareActionsPart", 1, "actionsList is empty.");
            return;
        }
        linearLayout.setVisibility(0);
        ArrayList arrayList2 = new ArrayList();
        for (com.tencent.mobileqq.multishare.action.b bVar : arrayList) {
            if (bVar.getLine() != ShareActionLine.NONE) {
                int ordinal = bVar.getLine().ordinal();
                int size = ordinal - arrayList2.size();
                if (size > 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        arrayList2.add(new ArrayList());
                    }
                }
                ((List) arrayList2.get(ordinal - 1)).add(bVar);
            }
        }
        int size2 = arrayList2.size();
        for (int i16 = 0; i16 < size2; i16++) {
            RecyclerView x95 = x9(linearLayout, (List) arrayList2.get(i16), i16);
            com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            cVar.i(context, x95);
            linearLayout.addView(x95);
        }
        RFWIocAbilityProvider.g().registerIoc(linearLayout, this, i92.a.class);
    }

    public final void A9(int index, @NotNull List<? extends com.tencent.mobileqq.multishare.action.b> actions) {
        Object orNull;
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, index, (Object) actions);
            return;
        }
        Intrinsics.checkNotNullParameter(actions, "actions");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.adapterList, index);
        com.tencent.mobileqq.multishare.adapter.a aVar = (com.tencent.mobileqq.multishare.adapter.a) orNull;
        if (aVar != null) {
            aVar.setItems(actions);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.d("MultiShareActionsPart", 1, "[updateActionSheet] adapter is null, index:" + index);
        }
    }

    @Override // i92.a
    public void U2(@NotNull com.tencent.mobileqq.multishare.action.b item) {
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        j92.b sh5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        IPartHost partHost = getPartHost();
        MultiShareBottomDialogFragment multiShareBottomDialogFragment2 = null;
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null && (sh5 = multiShareBottomDialogFragment.sh()) != null) {
            sh5.f(item);
        }
        IPartHost partHost2 = getPartHost();
        if (partHost2 instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment2 = (MultiShareBottomDialogFragment) partHost2;
        }
        if (multiShareBottomDialogFragment2 != null) {
            multiShareBottomDialogFragment2.dismissAllowingStateLoss();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        z9();
    }
}
