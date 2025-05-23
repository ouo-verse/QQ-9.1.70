package com.tencent.mobileqq.troop.homework.clockin.publish.part;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.publish.vm.HWClockInPublishViewModel;
import com.tencent.mobileqq.troop.homework.clockin.publish.vm.a;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/publish/part/HWClockPubSettingPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/HWClockInPublishViewModel;", "d", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/HWClockInPublishViewModel;", "pubViewModel", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "e", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "scopeConfig", h.F, "timeConfig", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockPubSettingPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pubViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x<x.b.d, x.c.g> scopeConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x<x.b.d, x.c.g> timeConfig;

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/publish/part/HWClockPubSettingPart$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "getSpaceHeight", "()I", "spaceHeight", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spaceHeight;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.spaceHeight = ViewUtils.dip2px(12.0f);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.bottom = this.spaceHeight;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/publish/part/HWClockPubSettingPart$b", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Lazy<HWClockInPublishViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private HWClockInPublishViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f296478e;

        public b(Part part) {
            this.f296478e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.publish.vm.HWClockInPublishViewModel, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.publish.vm.HWClockInPublishViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HWClockInPublishViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HWClockInPublishViewModel hWClockInPublishViewModel = this.cached;
            Object partHost = this.f296478e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (hWClockInPublishViewModel == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(HWClockInPublishViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return hWClockInPublishViewModel;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public HWClockPubSettingPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pubViewModel = new b(this);
        this.scopeConfig = new x<>(new x.b.d("\u540c\u6b65\u5230"), new x.c.g("", false, false, 6, null));
        this.timeConfig = new x<>(new x.b.d("\u6253\u5361\u65f6\u95f4\u8bbe\u7f6e"), new x.c.g("", false, false, 6, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HWClockInPublishViewModel G9() {
        return (HWClockInPublishViewModel) this.pubViewModel.getValue();
    }

    private final void H9() {
        MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.publish.vm.a> obtainUiState = G9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.clockin.publish.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.clockin.publish.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.part.HWClockPubSettingPart$observeUiState$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockPubSettingPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.publish.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.clockin.publish.vm.a aVar) {
                x xVar;
                QUIListItemAdapter qUIListItemAdapter;
                x xVar2;
                x xVar3;
                QUIListItemAdapter qUIListItemAdapter2;
                x xVar4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar instanceof a.c) {
                    xVar3 = HWClockPubSettingPart.this.scopeConfig;
                    ((x.c.g) xVar3.O()).h(((a.c) aVar).a());
                    qUIListItemAdapter2 = HWClockPubSettingPart.this.adapter;
                    if (qUIListItemAdapter2 != null) {
                        xVar4 = HWClockPubSettingPart.this.scopeConfig;
                        qUIListItemAdapter2.l0(xVar4);
                        return;
                    }
                    return;
                }
                if (aVar instanceof a.C8714a) {
                    xVar = HWClockPubSettingPart.this.timeConfig;
                    x.c.g gVar = (x.c.g) xVar.O();
                    Context context = HWClockPubSettingPart.this.getContext();
                    String string = context != null ? context.getString(R.string.f2339578n) : null;
                    if (string == null) {
                        string = "";
                    }
                    gVar.h(string);
                    qUIListItemAdapter = HWClockPubSettingPart.this.adapter;
                    if (qUIListItemAdapter != null) {
                        xVar2 = HWClockPubSettingPart.this.timeConfig;
                        qUIListItemAdapter.l0(xVar2);
                    }
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockPubSettingPart.I9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(HWClockPubSettingPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.homework.clockin.report.a aVar = com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        h.a.f(aVar, it, "em_group_sync_btn", null, null, 12, null);
        InputMethodUtil.hide(this$0.getPartRootView());
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.troop.homework.common.b.b(this$0), null, null, new HWClockPubSettingPart$onInitView$1$1(this$0, null), 3, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(HWClockPubSettingPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.homework.clockin.report.a aVar = com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        h.a.f(aVar, it, "em_group_time_set", null, null, 12, null);
        InputMethodUtil.hide(this$0.getPartRootView());
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.troop.homework.common.b.b(this$0), null, null, new HWClockPubSettingPart$onInitView$2$1(this$0, null), 3, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(HWClockPubSettingPart this$0, CompoundButton v3, boolean z16) {
        HashMap hashMapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(v3, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.homework.clockin.report.a aVar = com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a;
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        int i3 = 1;
        Pair[] pairArr = new Pair[1];
        if (!z16) {
            i3 = 2;
        }
        pairArr[0] = TuplesKt.to("after_click_state", Integer.valueOf(i3));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        h.a.f(aVar, v3, "em_group_punch_in_switch", hashMapOf, null, 8, null);
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.troop.homework.common.b.b(this$0), null, null, new HWClockPubSettingPart$onInitView$allowReplenishmentConfig$1$1(this$0, z16, null), 3, null);
        EventCollector.getInstance().onCompoundButtonChecked(v3, z16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RecyclerView recyclerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        this.scopeConfig.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWClockPubSettingPart.J9(HWClockPubSettingPart.this, view);
            }
        });
        this.timeConfig.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWClockPubSettingPart.K9(HWClockPubSettingPart.this, view);
            }
        });
        x xVar = new x(new x.b.d("\u5141\u8bb8\u8865\u5361"), new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.part.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                HWClockPubSettingPart.L9(HWClockPubSettingPart.this, compoundButton, z16);
            }
        }));
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth, false, false, 6, null);
        qUIListItemAdapter.t0(new Group(this.scopeConfig), new Group(this.timeConfig), new Group("", "\u5f00\u542f\u540e\uff0c\u5728\u6253\u5361\u5468\u671f\u5185\uff0c\u5b66\u751f\u3001\u5bb6\u957f\u53ef\u5bf9\u672a\u6253\u5361\u7684\u4efb\u52a1\u8fdb\u884c\u8865\u5361", xVar));
        this.adapter = qUIListItemAdapter;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f28950kb);
        } else {
            recyclerView = null;
        }
        if (recyclerView == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new a());
        recyclerView.setAdapter(this.adapter);
        H9();
    }
}
