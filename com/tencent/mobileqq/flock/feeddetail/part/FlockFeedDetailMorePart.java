package com.tencent.mobileqq.flock.feeddetail.part;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.flock.base.FlockBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0006\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J(\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u00120\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001c\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R#\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/part/FlockFeedDetailMorePart;", "Lcom/tencent/mobileqq/flock/base/b;", "", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "it", "Q9", "R9", "V9", "I9", "Ly45/b;", "feed", "J9", "M9", "", "itemName", "N9", "", "Lkotlin/Pair;", "Lkotlin/Function0;", "O9", "showConfirmDialog", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "P9", "()Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "vm", "<init>", "()V", "e", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedDetailMorePart extends com.tencent.mobileqq.flock.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/part/FlockFeedDetailMorePart$a;", "", "", "ACTION_MSG_MORE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailMorePart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29968);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedDetailMorePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feeddetail.viewmodel.a>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailMorePart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedDetailMorePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.flock.feeddetail.viewmodel.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) FlockFeedDetailMorePart.this.getViewModel(com.tencent.mobileqq.flock.feeddetail.viewmodel.a.class) : (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void I9() {
        broadcastMessage("ACTION_MSG_HIDE_LOADING", null);
    }

    private final void J9(y45.b feed) {
        final ActionSheet create = ActionSheet.create(getContext());
        final List<Pair<String, Function0<Unit>>> O9 = O9(feed);
        Iterator<T> it = O9.iterator();
        while (it.hasNext()) {
            create.addButton((CharSequence) ((Pair) it.next()).getFirst(), 5);
        }
        final String str = "\u53d6\u6d88";
        create.addCancelButton("\u53d6\u6d88");
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.flock.feeddetail.part.e
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FlockFeedDetailMorePart.K9(ActionSheet.this, this, str, dialogInterface);
            }
        });
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.flock.feeddetail.part.f
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                FlockFeedDetailMorePart.L9(O9, create, this, view, i3);
            }
        });
        create.show();
        M9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(ActionSheet actionSheet, FlockFeedDetailMorePart this$0, String cancelText, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cancelText, "$cancelText");
        actionSheet.superDismiss();
        this$0.N9(cancelText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(List actionSheetBtnList, ActionSheet actionSheet, FlockFeedDetailMorePart this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheetBtnList, "$actionSheetBtnList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Function0) ((Pair) actionSheetBtnList.get(i3)).getSecond()).invoke();
        actionSheet.superDismiss();
        this$0.N9((String) ((Pair) actionSheetBtnList.get(i3)).getFirst());
    }

    private final void M9() {
        FlockBaseFragment flockBaseFragment;
        Map<String, Object> mutableMapOf;
        View view = new View(getContext());
        com.tencent.mobileqq.flock.datong.c.b(view, getPartRootView());
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("qq_eid", "em_bas_more_panels");
        IPartHost partHost = getPartHost();
        String str = null;
        if (partHost instanceof FlockBaseFragment) {
            flockBaseFragment = (FlockBaseFragment) partHost;
        } else {
            flockBaseFragment = null;
        }
        if (flockBaseFragment != null) {
            str = flockBaseFragment.getPageId();
        }
        pairArr[1] = TuplesKt.to("qq_pgid", String.valueOf(str));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        com.tencent.mobileqq.flock.datong.c.a("qq_imp", view, "em_bas_more_panels", new com.tencent.mobileqq.flock.datong.b().g(mutableMapOf));
    }

    private final void N9(String itemName) {
        FlockBaseFragment flockBaseFragment;
        Map<String, Object> mutableMapOf;
        View view = new View(getContext());
        com.tencent.mobileqq.flock.datong.c.b(view, getPartRootView());
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("qq_eid", "em_bas_more_buttons_report");
        pairArr[1] = TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, itemName);
        IPartHost partHost = getPartHost();
        String str = null;
        if (partHost instanceof FlockBaseFragment) {
            flockBaseFragment = (FlockBaseFragment) partHost;
        } else {
            flockBaseFragment = null;
        }
        if (flockBaseFragment != null) {
            str = flockBaseFragment.getPageId();
        }
        pairArr[2] = TuplesKt.to("qq_pgid", String.valueOf(str));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        com.tencent.mobileqq.flock.datong.c.a("qq_clck", view, "em_bas_more_buttons_report", new com.tencent.mobileqq.flock.datong.b().g(mutableMapOf));
    }

    private final List<Pair<String, Function0<Unit>>> O9(final y45.b feed) {
        com.tencent.mobileqq.flock.utils.b bVar = com.tencent.mobileqq.flock.utils.b.f210481a;
        String str = feed.f449369d.f449449a;
        Intrinsics.checkNotNullExpressionValue(str, "feed.publisher.id");
        boolean b16 = bVar.b(str);
        ArrayList arrayList = new ArrayList();
        if (b16) {
            arrayList.add(new Pair("\u7f16\u8f91\u5185\u5bb9", new Function0<Unit>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailMorePart$getActionSheetBtnList$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailMorePart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.mobileqq.flock.feeddetail.viewmodel.a P9;
                    com.tencent.mobileqq.flock.feeddetail.viewmodel.a P92;
                    com.tencent.mobileqq.flock.feeddetail.bean.a data;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
                    Context context = FlockFeedDetailMorePart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    P9 = FlockFeedDetailMorePart.this.P9();
                    Long valueOf = Long.valueOf(P9.S1().getGroupId());
                    P92 = FlockFeedDetailMorePart.this.P9();
                    UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> value = P92.R1().getValue();
                    com.tencent.mobileqq.flock.a.e(aVar, context, 0, valueOf, (value == null || (data = value.getData()) == null) ? null : data.a(), null, 18, null);
                }
            }));
            arrayList.add(new Pair("\u5220\u9664\u5185\u5bb9", new Function0<Unit>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailMorePart$getActionSheetBtnList$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailMorePart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        FlockFeedDetailMorePart.this.showConfirmDialog();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }));
        } else {
            arrayList.add(new Pair("\u4e3e\u62a5\u5185\u5bb9", new Function0<Unit>(feed) { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailMorePart$getActionSheetBtnList$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ y45.b $feed;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$feed = feed;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailMorePart.this, (Object) feed);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.flock.utils.f fVar = com.tencent.mobileqq.flock.utils.f.f210485a;
                    Context context = FlockFeedDetailMorePart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    com.tencent.mobileqq.dt.api.b a16 = fVar.a(this.$feed);
                    a16.i(String.valueOf(this.$feed.f449380o.f449439a));
                    Unit unit = Unit.INSTANCE;
                    fVar.b(context, a16);
                }
            }));
            arrayList.add(new Pair("\u4e3e\u62a5\u53d1\u8d77\u4eba", new Function0<Unit>(feed) { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailMorePart$getActionSheetBtnList$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ y45.b $feed;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$feed = feed;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailMorePart.this, (Object) feed);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.flock.utils.f fVar = com.tencent.mobileqq.flock.utils.f.f210485a;
                    Context context = FlockFeedDetailMorePart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    com.tencent.mobileqq.dt.api.b a16 = fVar.a(this.$feed);
                    a16.i(String.valueOf(this.$feed.f449380o.f449440b));
                    Unit unit = Unit.INSTANCE;
                    fVar.b(context, a16);
                }
            }));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.flock.feeddetail.viewmodel.a P9() {
        return (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(UIStateData<Unit> it) {
        I9();
        QQToastUtil.showQQToast(1, it.getMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        I9();
        QQToastUtil.showQQToast(2, "\u5220\u9664\u6210\u529f");
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(FlockFeedDetailMorePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9().O1();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        broadcastMessage("ACTION_MSG_SHOW_LOADING", null);
    }

    private final void initData() {
        LiveData<UIStateData<Unit>> Q1 = P9().Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<Unit>, Unit> function1 = new Function1<UIStateData<Unit>, Unit>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailMorePart$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailMorePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<Unit> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<Unit> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                int state = it.getState();
                if (state == 1) {
                    FlockFeedDetailMorePart.this.V9();
                    return;
                }
                if (state == 3) {
                    FlockFeedDetailMorePart.this.R9();
                } else {
                    if (state != 4) {
                        return;
                    }
                    FlockFeedDetailMorePart flockFeedDetailMorePart = FlockFeedDetailMorePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    flockFeedDetailMorePart.Q9(it);
                }
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.feeddetail.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockFeedDetailMorePart.S9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConfirmDialog() {
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u5220\u9664\u540e\uff0c\u8be5\u5185\u5bb9\u65e0\u6cd5\u6062\u590d\uff0c\u786e\u5b9a\u8981\u5220\u9664\u5417\uff1f", "\u53d6\u6d88", "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flock.feeddetail.part.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FlockFeedDetailMorePart.T9(FlockFeedDetailMorePart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flock.feeddetail.part.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FlockFeedDetailMorePart.U9(dialogInterface, i3);
            }
        }).show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> value;
        com.tencent.mobileqq.flock.feeddetail.bean.a data;
        y45.b a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) action, args);
        } else if (Intrinsics.areEqual(action, "ACTION_MSG_MORE") && (value = P9().R1().getValue()) != null && (data = value.getData()) != null && (a16 = data.a()) != null) {
            J9(a16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            initData();
        }
    }
}
