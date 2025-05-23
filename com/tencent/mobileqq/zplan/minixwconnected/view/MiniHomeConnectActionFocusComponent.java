package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.aio.panel.page.ActionPage;
import com.tencent.mobileqq.zplan.aio.panel.page.ActionPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mobileqq.zplan.aio.panel.panel.DataSource;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapter;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.SpacePanelLayout;
import com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt;
import com.tencent.mobileqq.zplan.minixwconnected.c;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import le3.ApiPanelEventHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020&\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010\u0010\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J!\u0010\u0011\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\tR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectActionFocusComponent;", "Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/SpacePanelLayout;", "e", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/a;", "builders", "", "forceRefresh", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "g", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/view/View;", "j", "destroy", "k", "", "id", "needLoad", "l", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "c", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", tl.h.F, "()Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "controller", "Lle3/a;", "Lkotlin/Lazy;", "i", "()Lle3/a;", "panelHandler", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "panelLayout", "f", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/SpacePanelLayout;", "spacePanelLayout", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectActionFocusComponent implements com.tencent.mobileqq.zplan.minixwconnected.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectedController controller;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy panelHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout panelLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SpacePanelLayout spacePanelLayout;

    public MiniHomeConnectActionFocusComponent(Context context, CoroutineScope scope, MiniHomeConnectedController controller) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.context = context;
        this.scope = scope;
        this.controller = controller;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ApiPanelEventHandler>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$panelHandler$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\b\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$panelHandler$2$3", f = "MiniHomeConnectActionFocusComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$panelHandler$2$3, reason: invalid class name */
            /* loaded from: classes34.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
                int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass3(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxInt(0);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                    super(1, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Integer> continuation) {
                    return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ApiPanelEventHandler invoke() {
                final MiniHomeConnectActionFocusComponent miniHomeConnectActionFocusComponent = MiniHomeConnectActionFocusComponent.this;
                return new ApiPanelEventHandler(new Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$panelHandler$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Deferred<Boolean> invoke(CoroutineScope scope2, le3.b config) {
                        Intrinsics.checkNotNullParameter(scope2, "scope");
                        Intrinsics.checkNotNullParameter(config, "config");
                        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "panelHandler.onSelectAction");
                        return MiniHomeConnectActionFocusComponent.this.getController().Z(scope2, config);
                    }
                }, new Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$panelHandler$2.2
                    @Override // kotlin.jvm.functions.Function2
                    public final Deferred<Boolean> invoke(CoroutineScope coroutineScope, le3.b bVar) {
                        Intrinsics.checkNotNullParameter(coroutineScope, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(bVar, "<anonymous parameter 1>");
                        return CompletableDeferredKt.CompletableDeferred(Boolean.FALSE);
                    }
                }, new AnonymousClass3(null), new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$panelHandler$2.4
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, new Function1<View.OnClickListener, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$panelHandler$2.5
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View.OnClickListener it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View.OnClickListener onClickListener) {
                        invoke2(onClickListener);
                        return Unit.INSTANCE;
                    }
                }, "", new Function1<View.OnClickListener, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$panelHandler$2.6
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View.OnClickListener it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View.OnClickListener onClickListener) {
                        invoke2(onClickListener);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        this.panelHandler = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MiniHomeConnectActionFocusComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.controller.r();
    }

    private final StateFlow<Panel> g(CoroutineScope scope, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> builders, boolean forceRefresh) {
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "generateMiniConnectActionSource");
        DataSource dataSource = DataSource.PlaceHolder;
        Page[] pageArr = new Page[1];
        ArrayList arrayList = new ArrayList(9);
        for (int i3 = 0; i3 < 9; i3++) {
            arrayList.add(com.tencent.mobileqq.zplan.aio.panel.item.d.f331180d);
        }
        pageArr[0] = new ActionPage(arrayList);
        MutableStateFlow<Panel> MutableStateFlow = StateFlowKt.MutableStateFlow(new Panel(dataSource, pageArr));
        d(MutableStateFlow, scope, builders, forceRefresh);
        return MutableStateFlow;
    }

    private final ApiPanelEventHandler i() {
        return (ApiPanelEventHandler) this.panelHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00b2 -> B:12:0x00d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00cb -> B:11:0x00ce). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list, Continuation<? super Panel> continuation) {
        MiniHomeConnectActionFocusComponent$requestPanel$1 miniHomeConnectActionFocusComponent$requestPanel$1;
        Object coroutine_suspended;
        int i3;
        List listOf;
        List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list2;
        Iterator it;
        DataSource dataSource;
        Collection collection;
        Object obj;
        if (continuation instanceof MiniHomeConnectActionFocusComponent$requestPanel$1) {
            miniHomeConnectActionFocusComponent$requestPanel$1 = (MiniHomeConnectActionFocusComponent$requestPanel$1) continuation;
            int i16 = miniHomeConnectActionFocusComponent$requestPanel$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeConnectActionFocusComponent$requestPanel$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = miniHomeConnectActionFocusComponent$requestPanel$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeConnectActionFocusComponent$requestPanel$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    QLog.i("MiniHomeConnectFriendFocusComponent", 1, "requestPanel.");
                    miniHomeConnectActionFocusComponent$requestPanel$1.L$0 = list;
                    miniHomeConnectActionFocusComponent$requestPanel$1.label = 1;
                    obj2 = MiniHomeNetworkKt.b(miniHomeConnectActionFocusComponent$requestPanel$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    list = (List) miniHomeConnectActionFocusComponent$requestPanel$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                } else if (i3 == 2) {
                    it = (Iterator) miniHomeConnectActionFocusComponent$requestPanel$1.L$3;
                    collection = (Collection) miniHomeConnectActionFocusComponent$requestPanel$1.L$2;
                    dataSource = (DataSource) miniHomeConnectActionFocusComponent$requestPanel$1.L$1;
                    list2 = (List) miniHomeConnectActionFocusComponent$requestPanel$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    Page page = (Page) obj2;
                    if (page != null) {
                        collection.add(page);
                    }
                    if (!it.hasNext()) {
                        ku4.c data = (ku4.c) it.next();
                        Iterator<T> it5 = list2.iterator();
                        while (true) {
                            page = null;
                            if (!it5.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it5.next();
                            if (Intrinsics.areEqual(data.getClass(), ((com.tencent.mobileqq.zplan.aio.panel.panel.a) obj).a())) {
                                break;
                            }
                        }
                        com.tencent.mobileqq.zplan.aio.panel.panel.a aVar = (com.tencent.mobileqq.zplan.aio.panel.panel.a) obj;
                        if (aVar != null) {
                            Intrinsics.checkNotNullExpressionValue(data, "data");
                            miniHomeConnectActionFocusComponent$requestPanel$1.L$0 = list2;
                            miniHomeConnectActionFocusComponent$requestPanel$1.L$1 = dataSource;
                            miniHomeConnectActionFocusComponent$requestPanel$1.L$2 = collection;
                            miniHomeConnectActionFocusComponent$requestPanel$1.L$3 = it;
                            miniHomeConnectActionFocusComponent$requestPanel$1.label = 2;
                            obj2 = aVar.b(data, "MINI_HOME_CONNECT", miniHomeConnectActionFocusComponent$requestPanel$1);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Page page2 = (Page) obj2;
                        }
                        if (page2 != null) {
                        }
                        if (!it.hasNext()) {
                            return new Panel(dataSource, (List<? extends Page>) collection);
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                DataSource dataSource2 = DataSource.Backend;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(((wu4.b) obj2).f446550a);
                ArrayList arrayList = new ArrayList();
                list2 = list;
                it = listOf.iterator();
                dataSource = dataSource2;
                collection = arrayList;
                if (!it.hasNext()) {
                }
            }
        }
        miniHomeConnectActionFocusComponent$requestPanel$1 = new MiniHomeConnectActionFocusComponent$requestPanel$1(this, continuation);
        Object obj22 = miniHomeConnectActionFocusComponent$requestPanel$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeConnectActionFocusComponent$requestPanel$1.label;
        if (i3 != 0) {
        }
        DataSource dataSource22 = DataSource.Backend;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(((wu4.b) obj22).f446550a);
        ArrayList arrayList2 = new ArrayList();
        list2 = list;
        it = listOf.iterator();
        dataSource = dataSource22;
        collection = arrayList2;
        if (!it.hasNext()) {
        }
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void create(Object obj) {
        c.a.a(this, obj);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void createView() {
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        if (this.panelLayout != null) {
            QLog.i("MiniHomeConnectFriendFocusComponent", 1, "createView, panelLayout exists.");
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        int i3 = layoutParams != null ? layoutParams.height : 0;
        if (relativeLayout.getLayoutParams() != null) {
            relativeLayout.getLayoutParams().width = -1;
            relativeLayout.getLayoutParams().height = i3;
        } else {
            relativeLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, i3));
        }
        ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
        int i16 = layoutParams2 != null ? layoutParams2.width : 0;
        if (relativeLayout.getLayoutParams() != null) {
            relativeLayout.getLayoutParams().width = i16;
            relativeLayout.getLayoutParams().height = -2;
        } else {
            relativeLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(i16, -2));
        }
        relativeLayout.setGravity(80);
        RelativeLayout relativeLayout2 = new RelativeLayout(relativeLayout.getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        int applyDimension = (int) TypedValue.applyDimension(1, 17.0f, relativeLayout2.getContext().getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 38.0f, relativeLayout2.getContext().getResources().getDisplayMetrics());
        relativeLayout2.setPadding(applyDimension, applyDimension2, applyDimension, applyDimension2);
        relativeLayout2.setLayoutParams(layoutParams3);
        SpacePanelLayout e16 = e();
        e16.setVisibility(0);
        e16.getViewPager().setCurrentItem(0, false);
        this.spacePanelLayout = e16;
        relativeLayout2.addView(e16);
        relativeLayout.addView(relativeLayout2);
        this.panelLayout = relativeLayout;
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void destroy() {
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "destroy, panelLayout: " + this.panelLayout);
        RelativeLayout relativeLayout = this.panelLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        this.panelLayout = null;
        this.spacePanelLayout = null;
    }

    /* renamed from: h, reason: from getter */
    public final MiniHomeConnectedController getController() {
        return this.controller;
    }

    public View j() {
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "getView, panelLayout: " + this.panelLayout);
        return this.panelLayout;
    }

    public final View k() {
        StateFlow<Panel> a16;
        Panel value;
        List<Page> b16;
        SpacePanelLayout spacePanelLayout = this.spacePanelLayout;
        if (spacePanelLayout != null && (a16 = spacePanelLayout.a()) != null && (value = a16.getValue()) != null && (b16 = value.b()) != null) {
            for (Page page : b16) {
                page.t(true);
                Iterator<T> it = page.c().iterator();
                while (it.hasNext()) {
                    ((com.tencent.mobileqq.zplan.aio.panel.item.b) it.next()).p(true);
                }
            }
        }
        View j3 = j();
        if (j3 != null) {
            j3.setVisibility(0);
        }
        return j3;
    }

    public final void l(final int id5, final boolean needLoad) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent$refreshLoadingStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SpacePanelLayout spacePanelLayout;
                StateFlow<Panel> a16;
                Panel value;
                List<Page> b16;
                spacePanelLayout = MiniHomeConnectActionFocusComponent.this.spacePanelLayout;
                if (spacePanelLayout == null || (a16 = spacePanelLayout.a()) == null || (value = a16.getValue()) == null || (b16 = value.b()) == null) {
                    return;
                }
                int i3 = id5;
                boolean z16 = needLoad;
                for (Page page : b16) {
                    int i16 = 0;
                    for (Object obj : page.c()) {
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        com.tencent.mobileqq.zplan.aio.panel.item.b bVar = (com.tencent.mobileqq.zplan.aio.panel.item.b) obj;
                        if (bVar.getId() == i3) {
                            bVar.r(z16);
                            Page.b selectFunction = page.getSelectFunction();
                            if (selectFunction != null) {
                                selectFunction.T(i16);
                            }
                        }
                        i16 = i17;
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void pause() {
        c.a.d(this);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void resume() {
        c.a.e(this);
    }

    private final void d(MutableStateFlow<Panel> mutableStateFlow, CoroutineScope coroutineScope, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> list, boolean z16) {
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "configSource, try requestPanel.");
        CorountineFunKt.e(coroutineScope, "zplan_MiniHomeConnectFriendFocusComponent_wowo\u76f8\u8fde_\u62c9\u53d6\u9762\u677f", null, null, null, new MiniHomeConnectActionFocusComponent$configSource$1(this, list, mutableStateFlow, null), 14, null);
    }

    private final SpacePanelLayout e() {
        List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> listOf;
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "createPanelLayout");
        SpacePanelLayout spacePanelLayout = new SpacePanelLayout(this.context, null, 0, 6, null);
        CoroutineScope coroutineScope = this.scope;
        Context context = spacePanelLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ActionPageBuilder(coroutineScope, context, PageView.Theme.INSTANCE.b(), i().d(), null, 16, null));
        StateFlow<Panel> g16 = g(this.scope, listOf, false);
        PanelAdapter panelAdapter = new PanelAdapter(this.scope, g16, listOf);
        spacePanelLayout.setDataSource(g16);
        spacePanelLayout.getViewPager().setAdapter(panelAdapter);
        TextView textView = new TextView(spacePanelLayout.getContext());
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(ViewUtils.dpToPx(16.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(16.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(16.0f);
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_primary));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("\u9009\u62e9\u52a8\u4f5c");
        spacePanelLayout.addView(textView);
        spacePanelLayout.getSpaceCloseBtn().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniHomeConnectActionFocusComponent.f(MiniHomeConnectActionFocusComponent.this, view);
            }
        });
        CorountineFunKt.e(this.scope, "zplan_AbstractPanelLayout_wowo\u76f8\u8fde_\u76d1\u542c\u9762\u677f\u66f4\u65b0", null, null, null, new MiniHomeConnectActionFocusComponent$createPanelLayout$1$3(g16, panelAdapter, null), 14, null);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 300.0f, spacePanelLayout.getContext().getResources().getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        spacePanelLayout.setLayoutParams(layoutParams2);
        return spacePanelLayout;
    }
}
