package com.tencent.mobileqq.troop.selectmember.part.list;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import com.tencent.mobileqq.troop.selectmember.event.TroopSelectMemberSingleModeItemClickEvent;
import com.tencent.mobileqq.troop.selectmember.part.list.TroopSelectMemberListPart$scrollListener$2;
import com.tencent.mobileqq.troop.selectmember.part.list.TroopSelectMemberListPart$smoothScroller$2;
import com.tencent.mobileqq.troop.selectmember.part.list.adapter.d;
import com.tencent.mobileqq.troop.troopsetting.part.i;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\b\n*\u0002$*\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/list/TroopSelectMemberListPart;", "Lcom/tencent/mobileqq/troop/selectmember/part/a;", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate$a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "O9", "L9", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "data", "P9", "", "isAdd", "I9", "onInitView", "", "action", "", "args", "handleBroadcastMessage", "", "position", "l6", "Lcom/tencent/mobileqq/troop/selectmember/bean/b;", "r3", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/d;", h.F, "Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/d;", "adapter", "com/tencent/mobileqq/troop/selectmember/part/list/TroopSelectMemberListPart$scrollListener$2$a", "i", "Lkotlin/Lazy;", "J9", "()Lcom/tencent/mobileqq/troop/selectmember/part/list/TroopSelectMemberListPart$scrollListener$2$a;", "scrollListener", "com/tencent/mobileqq/troop/selectmember/part/list/TroopSelectMemberListPart$smoothScroller$2$a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "K9", "()Lcom/tencent/mobileqq/troop/selectmember/part/list/TroopSelectMemberListPart$smoothScroller$2$a;", "smoothScroller", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberListPart extends com.tencent.mobileqq.troop.selectmember.part.a implements AbsTroopSelectMemberDelegate.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView rv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scrollListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy smoothScroller;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/list/TroopSelectMemberListPart$a;", "", "", "MSG_KEY_CLICK_SEARCH_ITEM_ON_SINGLE_MODEL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.part.list.TroopSelectMemberListPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberListPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectMemberListPart$scrollListener$2.a>() { // from class: com.tencent.mobileqq.troop.selectmember.part.list.TroopSelectMemberListPart$scrollListener$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/selectmember/part/list/TroopSelectMemberListPart$scrollListener$2$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes19.dex */
                public static final class a extends RecyclerView.OnScrollListener {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TroopSelectMemberListPart f298390d;

                    a(TroopSelectMemberListPart troopSelectMemberListPart) {
                        this.f298390d = troopSelectMemberListPart;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSelectMemberListPart);
                        }
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                            return;
                        }
                        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                        this.f298390d.z9().D2(((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition());
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberListPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopSelectMemberListPart.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.scrollListener = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectMemberListPart$smoothScroller$2.a>() { // from class: com.tencent.mobileqq.troop.selectmember.part.list.TroopSelectMemberListPart$smoothScroller$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/selectmember/part/list/TroopSelectMemberListPart$smoothScroller$2$a", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "getVerticalSnapPreference", "dx", "dy", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "action", "", "onSeekTargetStep", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes19.dex */
                public static final class a extends LinearSmoothScroller {
                    static IPatchRedirector $redirector_;

                    a(Activity activity) {
                        super(activity);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                        }
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int getVerticalSnapPreference() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                        }
                        return -1;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                    public void onSeekTargetStep(int dx5, int dy5, @NotNull RecyclerView.State state, @NotNull RecyclerView.SmoothScroller.Action action) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(dx5), Integer.valueOf(dy5), state, action);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(state, "state");
                        Intrinsics.checkNotNullParameter(action, "action");
                        action.jumpTo(getTargetPosition());
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberListPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopSelectMemberListPart.this.getActivity()) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.smoothScroller = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void I9(boolean isAdd) {
        if (!x9().k()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopSelectMemberFrag.ListPart", 2, "[configIndexScrollListener] isAdd:" + isAdd);
        }
        if (isAdd) {
            RecyclerView recyclerView = this.rv;
            if (recyclerView != null) {
                recyclerView.addOnScrollListener(J9());
                return;
            }
            return;
        }
        RecyclerView recyclerView2 = this.rv;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(J9());
        }
    }

    private final TroopSelectMemberListPart$scrollListener$2.a J9() {
        return (TroopSelectMemberListPart$scrollListener$2.a) this.scrollListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectMemberListPart$smoothScroller$2.a K9() {
        return (TroopSelectMemberListPart$smoothScroller$2.a) this.smoothScroller.getValue();
    }

    private final void L9() {
        LifecycleOwner a16 = i.a(this);
        if (a16 != null) {
            LiveData<List<com.tencent.mobileqq.troop.selectmember.bean.a>> r26 = z9().r2();
            final Function1<List<? extends com.tencent.mobileqq.troop.selectmember.bean.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.troop.selectmember.bean.a>, Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.list.TroopSelectMemberListPart$initObserver$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberListPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.troop.selectmember.bean.a> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends com.tencent.mobileqq.troop.selectmember.bean.a> list) {
                    d dVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                        return;
                    }
                    dVar = TroopSelectMemberListPart.this.adapter;
                    if (dVar != null) {
                        dVar.setItems(new ArrayList(list));
                    }
                    TroopSelectMemberListPart.this.z9().A2(false);
                }
            };
            r26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.list.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberListPart.M9(Function1.this, obj);
                }
            });
            LiveData<Integer> f26 = z9().f2();
            final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.list.TroopSelectMemberListPart$initObserver$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberListPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    TroopSelectMemberListPart$smoothScroller$2.a K9;
                    RecyclerView recyclerView;
                    RecyclerView.LayoutManager layoutManager;
                    TroopSelectMemberListPart$smoothScroller$2.a K92;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    K9 = TroopSelectMemberListPart.this.K9();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    K9.setTargetPosition(it.intValue());
                    recyclerView = TroopSelectMemberListPart.this.rv;
                    if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                        return;
                    }
                    K92 = TroopSelectMemberListPart.this.K9();
                    layoutManager.startSmoothScroll(K92);
                }
            };
            f26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.list.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberListPart.N9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O9(View rootView) {
        RecyclerView recyclerView;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f10358610);
        } else {
            recyclerView = null;
        }
        this.rv = recyclerView;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            d dVar = new d(x9(), this, z9(), null, null, 24, null);
            this.adapter = dVar;
            recyclerView.setAdapter(dVar);
            I9(true);
        }
    }

    private final void P9(c data) {
        SimpleEventBus.getInstance().dispatchEvent(new TroopSelectMemberSingleModeItemClickEvent(x9(), data));
        getActivity().finish();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) action, args);
            return;
        }
        if (Intrinsics.areEqual(action, "msg_key_click_search_item_on_single_mode")) {
            if (args == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("TroopSelectMemberFrag.ListPart", 1, "[handleBroadcastMessage] click search item on single choose mode, args:" + z16);
            if (args instanceof c) {
                P9((c) args);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate.a
    public void l6(@NotNull c data, int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data, position);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.troop.selectmember.inject.c b16 = z9().T0().b();
        boolean z17 = false;
        if (b16 != null) {
            z16 = b16.b(z9().G1(), data, position);
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (z9().G1().r()) {
            P9(data);
            return;
        }
        List<c> value = z9().P().getValue();
        if (value != null && value.contains(data)) {
            z17 = true;
        }
        if (z17) {
            z9().C2(data);
        } else {
            z9().y2(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        O9(rootView);
        L9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            I9(false);
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate.a
    public void r3(@NotNull com.tencent.mobileqq.troop.selectmember.bean.b data, int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) data, position);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.troop.selectmember.inject.c b16 = z9().T0().b();
        if (b16 != null) {
            z16 = b16.a(z9().G1(), data, position);
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        z9().a2(data);
    }
}
