package com.tencent.hippykotlin.demo.pages.router_page.views;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.module.r;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.d;
import com.tencent.kuikly.core.views.e;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HistorySelectorView extends ComposeView<HistorySelectorViewAttr, HistorySelectorViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HistorySelectorView.class, "historyVisible", "getHistoryVisible()Z", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(HistorySelectorView.class, "historys", "getHistorys()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public static final Companion Companion = new Companion();
    public static final Lazy<r> cacheModule$delegate;
    public final ReadWriteProperty historyVisible$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty historys$delegate = c.b();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ HistorySelectorViewEvent access$getEvent(HistorySelectorView historySelectorView) {
        return (HistorySelectorViewEvent) historySelectorView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                        return Unit.INSTANCE;
                    }
                });
                final HistorySelectorView historySelectorView = HistorySelectorView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final HistorySelectorView historySelectorView2 = HistorySelectorView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                HistorySelectorView historySelectorView3 = HistorySelectorView.this;
                                HistorySelectorView.Companion companion = HistorySelectorView.Companion;
                                if (!historySelectorView3.getHistorys().isEmpty()) {
                                    r2.historyVisible$delegate.setValue(HistorySelectorView.this, HistorySelectorView.$$delegatedProperties[0], Boolean.valueOf(true));
                                    Function0<Unit> function0 = HistorySelectorView.access$getEvent(HistorySelectorView.this).openHistoryHandler;
                                    if (function0 != null) {
                                        function0.invoke();
                                    }
                                } else {
                                    Mqq.INSTANCE.getUi().showInfoTips("\u5f53\u524d\u65e0\u5386\u53f2\u8bb0\u5f55\uff5e");
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        cg.a(vVar, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u5386\u53f2\u8bb0\u5f55");
                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4283533037L), 0.0f), new j(new h(4283533037L), 1.0f));
                                        ceVar2.textDecorationUnderLine();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final HistorySelectorView historySelectorView2 = HistorySelectorView.this;
                e.a(viewContainer2, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ActionSheetView actionSheetView) {
                        ActionSheetView actionSheetView2 = actionSheetView;
                        final HistorySelectorView historySelectorView3 = HistorySelectorView.this;
                        actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                HistorySelectorView historySelectorView4 = HistorySelectorView.this;
                                actionSheetAttr2.w(((Boolean) historySelectorView4.historyVisible$delegate.getValue(historySelectorView4, HistorySelectorView.$$delegatedProperties[0])).booleanValue());
                                String[] array = HistorySelectorView.this.getHistorys().toArray(new String[0]);
                                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                String[] strArr = array;
                                actionSheetAttr2.h("\u53d6\u6d88", (String[]) Arrays.copyOf(strArr, strArr.length));
                                return Unit.INSTANCE;
                            }
                        });
                        final HistorySelectorView historySelectorView4 = HistorySelectorView.this;
                        actionSheetView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                d dVar2 = dVar;
                                final HistorySelectorView historySelectorView5 = HistorySelectorView.this;
                                dVar2.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        r2.historyVisible$delegate.setValue(HistorySelectorView.this, HistorySelectorView.$$delegatedProperties[0], Boolean.valueOf(false));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HistorySelectorView historySelectorView6 = HistorySelectorView.this;
                                dVar2.i(new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Integer num) {
                                        Function1<? super String, Unit> function1;
                                        int intValue = num.intValue();
                                        if (intValue > 0 && (function1 = HistorySelectorView.access$getEvent(HistorySelectorView.this).selectedHandler) != null) {
                                            function1.invoke(HistorySelectorView.this.getHistorys().get(intValue - 1));
                                        }
                                        r3.historyVisible$delegate.setValue(HistorySelectorView.this, HistorySelectorView.$$delegatedProperties[0], Boolean.valueOf(false));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new HistorySelectorViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new HistorySelectorViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        sync();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<String> getHistorys() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.historys$delegate.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{";"}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void sync() {
        List emptyList;
        getHistorys().clear();
        com.tencent.kuikly.core.reactive.collection.c<String> historys = getHistorys();
        Companion.getClass();
        String string = cacheModule$delegate.getValue().getString("router_history");
        if (!(string.length() > 0)) {
            string = null;
        }
        String str = string;
        if (str == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        historys.addAll(emptyList);
    }

    static {
        Lazy<r> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<r>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView$Companion$cacheModule$2
            @Override // kotlin.jvm.functions.Function0
            public final r invoke() {
                return (r) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRSharedPreferencesModule");
            }
        });
        cacheModule$delegate = lazy;
    }
}
