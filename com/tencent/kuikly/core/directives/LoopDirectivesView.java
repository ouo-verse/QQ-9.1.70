package com.tencent.kuikly.core.directives;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0097\u0001\u0012\u001c\u0010\u001e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u001aj\b\u0012\u0004\u0012\u00028\u0000`\u001b\u0012f\u0010'\u001ab\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00050\u001fj\b\u0012\u0004\u0012\u00028\u0000`#\u00a2\u0006\u0002\b$\u0012\b\b\u0002\u0010\u000f\u001a\u00020(\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J/\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u001d\u0010\u0012\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0005H\u0016J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u001aj\b\u0012\u0004\u0012\u00028\u0000`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dRt\u0010'\u001ab\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00050\u001fj\b\u0012\u0004\u0012\u00028\u0000`#\u00a2\u0006\u0002\b$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u000f\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R(\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\u0013R9\u00108\u001a\u0019\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u000101\u00a2\u0006\u0002\b$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010>\u001a\u00020(8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010*\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/kuikly/core/directives/LoopDirectivesView;", "T", "Lcom/tencent/kuikly/core/directives/a;", "Lcom/tencent/kuikly/core/reactive/collection/a;", QCircleDaTongConstant.ElementParamValue.OPERATION, "", "w", HippyTKDListViewAdapter.X, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "index", "size", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "p", "(Ljava/lang/Object;II)Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "didInit", "Lcom/tencent/kuikly/core/reactive/collection/c;", "list", "v", "(Lcom/tencent/kuikly/core/reactive/collection/c;)V", "didRemoveFromParentView", "", "u", "(Lcom/tencent/kuikly/core/reactive/collection/a;Ljava/util/List;)V", "r", "()V", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/directives/VItemList;", "a", "Lkotlin/jvm/functions/Function0;", VideoTemplateParser.ITEM_LIST, "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "count", "Lcom/tencent/kuikly/core/directives/VItemIndexCreator;", "Lkotlin/ExtensionFunctionType;", "b", "Lkotlin/jvm/functions/Function4;", "itemCreator", "", "c", "Z", "d", "Lcom/tencent/kuikly/core/reactive/collection/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/kuikly/core/reactive/collection/c;", ReportConstant.COSTREPORT_PREFIX, "curList", "Lkotlin/Function1;", "e", "Lkotlin/jvm/functions/Function1;", "getLazySyncOperation$core_release", "()Lkotlin/jvm/functions/Function1;", "t", "(Lkotlin/jvm/functions/Function1;)V", "lazySyncOperation", "f", "getDidRemove$core_release", "()Z", "setDidRemove$core_release", "(Z)V", "didRemove", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;Z)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class LoopDirectivesView<T> extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function0<c<T>> itemList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function4<LoopDirectivesView<T>, T, Integer, Integer, Unit> itemCreator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean didInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public c<T> curList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1<? super LoopDirectivesView<?>, Unit> lazySyncOperation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean didRemove;

    public /* synthetic */ LoopDirectivesView(Function0 function0, Function4 function4, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function4, (i3 & 4) != 0 ? false : z16);
    }

    private final DeclarativeBaseView<?, ?> p(T item, int index, int size) {
        Object last;
        int size2 = getChildren().size();
        this.itemCreator.invoke(this, item, Integer.valueOf(index), Integer.valueOf(size));
        if (getChildren().size() - size2 != 1) {
            PagerNotFoundExceptionKt.a("vfor creator\u95ed\u5305\u5185\u5fc5\u987b\u9700\u8981\u4e14\u4ec5\u4e00\u4e2a\u5b69\u5b50\u8282\u70b9\u7684\u751f\u6210");
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) getChildren());
        DeclarativeBaseView<?, ?> declarativeBaseView = (DeclarativeBaseView) last;
        if (VirtualViewKt.b(declarativeBaseView)) {
            PagerNotFoundExceptionKt.a("vfor creator\u95ed\u5305\u5185\u5b50\u5b69\u5b50\u5fc5\u987b\u4e3a\u975e\u6761\u4ef6\u6307\u4ee4\uff0c\u5982vif , vfor");
        }
        getChildren().remove(declarativeBaseView);
        return declarativeBaseView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(com.tencent.kuikly.core.reactive.collection.a operation) {
        if (h() == null) {
            return;
        }
        if (operation.c()) {
            u(operation, this.itemList.invoke());
        } else if (operation.d()) {
            x(operation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(com.tencent.kuikly.core.reactive.collection.a operation) {
        ArrayList<DeclarativeBaseView<?, ?>> arrayList = new ArrayList();
        for (int index = operation.getIndex(); index < operation.getIndex() + operation.getCount(); index++) {
            if (index < getChildren().size() && index >= 0) {
                DeclarativeBaseView<?, ?> declarativeBaseView = getChildren().get(index);
                Intrinsics.checkNotNullExpressionValue(declarativeBaseView, "children[index]");
                arrayList.add(declarativeBaseView);
            } else {
                KLog.INSTANCE.e("KuiklyError", "sync remove operation out index with index:" + index + " listSize:" + getChildren().size() + " oIndex:" + operation.getIndex() + " oSize:" + operation.getCount() + TokenParser.SP);
                break;
            }
        }
        ViewContainer<?, ?> h16 = h();
        if (h16 != null) {
            for (DeclarativeBaseView<?, ?> declarativeBaseView2 : arrayList) {
                h16.removeDomSubView(declarativeBaseView2);
                removeChild(declarativeBaseView2);
            }
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        this.didInit = true;
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        this.didRemove = true;
        this.lazySyncOperation = null;
    }

    public final c<T> q() {
        c<T> cVar = this.curList;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("curList");
        return null;
    }

    public final void r() {
        Function1<? super LoopDirectivesView<?>, Unit> function1;
        if (this.didRemove || (function1 = this.lazySyncOperation) == null) {
            return;
        }
        if (function1 != null) {
            function1.invoke(this);
        }
        this.lazySyncOperation = null;
    }

    public final void s(c<T> cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.curList = cVar;
    }

    public final void t(Function1<? super LoopDirectivesView<?>, Unit> function1) {
        this.lazySyncOperation = function1;
    }

    public final void u(com.tencent.kuikly.core.reactive.collection.a operation, List<? extends T> list) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList<DeclarativeBaseView<?, ?>> arrayList = new ArrayList();
        int size = list.size();
        for (int index = operation.getIndex(); index < operation.getIndex() + operation.getCount(); index++) {
            if (index < list.size() && index >= 0) {
                DeclarativeBaseView<?, ?> p16 = p(list.get(index), index, size);
                getChildren().add(index, p16);
                arrayList.add(p16);
            } else {
                KLog.INSTANCE.e("KuiklyError", "sync add operation out index with index:" + index + " listSize:" + list.size() + " oIndex:" + operation.getIndex() + " oSize:" + operation.getCount() + TokenParser.SP);
                break;
            }
        }
        ViewContainer<?, ?> h16 = h();
        if (h16 != null) {
            List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(h16);
            for (DeclarativeBaseView<?, ?> declarativeBaseView : arrayList) {
                h16.insertDomSubView(declarativeBaseView, a16.lastIndexOf(declarativeBaseView));
            }
        }
    }

    public final void v(final c<T> list) {
        final List list2;
        Intrinsics.checkNotNullParameter(list, "list");
        if (this.didInit) {
            r();
            if (Intrinsics.areEqual(list, q())) {
                list2 = CollectionsKt___CollectionsKt.toList(list.g());
                ReactiveObserver.INSTANCE.a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.directives.LoopDirectivesView$syncListElementChange$2
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
                        if (!list2.isEmpty()) {
                            List<com.tencent.kuikly.core.reactive.collection.a> list3 = list2;
                            LoopDirectivesView<T> loopDirectivesView = this;
                            Iterator<T> it = list3.iterator();
                            while (it.hasNext()) {
                                loopDirectivesView.w((com.tencent.kuikly.core.reactive.collection.a) it.next());
                            }
                        }
                    }
                });
            } else {
                ReactiveObserver.INSTANCE.a(new Function0<Unit>(this) { // from class: com.tencent.kuikly.core.directives.LoopDirectivesView$syncListElementChange$1
                    final /* synthetic */ LoopDirectivesView<T> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0 function0;
                        this.this$0.x(new com.tencent.kuikly.core.reactive.collection.a(2, 0, this.this$0.q().size()));
                        this.this$0.s(list);
                        com.tencent.kuikly.core.reactive.collection.a aVar = new com.tencent.kuikly.core.reactive.collection.a(1, 0, this.this$0.q().size());
                        LoopDirectivesView<T> loopDirectivesView = this.this$0;
                        function0 = ((LoopDirectivesView) loopDirectivesView).itemList;
                        loopDirectivesView.u(aVar, (List) function0.invoke());
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoopDirectivesView(Function0<c<T>> itemList, Function4<? super LoopDirectivesView<T>, ? super T, ? super Integer, ? super Integer, Unit> itemCreator, boolean z16) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(itemCreator, "itemCreator");
        this.itemList = itemList;
        this.itemCreator = itemCreator;
        this.didInit = z16;
    }
}
