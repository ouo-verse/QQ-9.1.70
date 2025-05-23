package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SearchBar extends DeclarativeBaseView<SearchBarAttr, SearchBarEvent> {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0021. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$call(SearchBar searchBar, Object obj) {
        searchBar.getClass();
        e eVar = obj instanceof e ? (e) obj : null;
        if (eVar == null) {
            return;
        }
        String p16 = eVar.p("methodName");
        String p17 = eVar.p("methodParam");
        switch (p16.hashCode()) {
            case -1327478766:
                if (p16.equals(IECSearchBar.METHOD_DO_BACK)) {
                    Function1<Object, ? extends Object> function1 = ((SearchBarEvent) searchBar.getEvent()).onClickBack;
                    if (function1 != null) {
                        function1.invoke(p17);
                        return;
                    }
                    return;
                }
                Utils.INSTANCE.logToNative("unknown method:" + p16);
                return;
            case -560341188:
                if (p16.equals(IECSearchBar.METHOD_DO_TEXT_CHANGED)) {
                    Function1<Object, ? extends Object> function12 = ((SearchBarEvent) searchBar.getEvent()).onTextChanged;
                    if (function12 != null) {
                        function12.invoke(p17);
                        return;
                    }
                    return;
                }
                Utils.INSTANCE.logToNative("unknown method:" + p16);
                return;
            case -72854811:
                if (p16.equals(IECSearchBar.METHOD_DO_CANCEL)) {
                    Function1<Object, ? extends Object> function13 = ((SearchBarEvent) searchBar.getEvent()).onClickCancel;
                    if (function13 != null) {
                        function13.invoke(p17);
                        return;
                    }
                    return;
                }
                Utils.INSTANCE.logToNative("unknown method:" + p16);
                return;
            case 388532755:
                if (p16.equals(IECSearchBar.METHOD_DO_SEARCH)) {
                    Function1<Object, ? extends Object> function14 = ((SearchBarEvent) searchBar.getEvent()).onClickSearch;
                    if (function14 != null) {
                        function14.invoke(p17);
                        return;
                    }
                    return;
                }
                Utils.INSTANCE.logToNative("unknown method:" + p16);
                return;
            case 1799084162:
                if (p16.equals(IECSearchBar.METHOD_DO_CLEAR)) {
                    ((SearchBarEvent) searchBar.getEvent()).getClass();
                    return;
                }
                Utils.INSTANCE.logToNative("unknown method:" + p16);
                return;
            default:
                Utils.INSTANCE.logToNative("unknown method:" + p16);
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ SearchBarAttr access$getAttr(SearchBar searchBar) {
        return (SearchBarAttr) searchBar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new SearchBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new SearchBarEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.SearchBar$didInit$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SearchBarAttr access$getAttr = SearchBar.access$getAttr(SearchBar.this);
                return (c) access$getAttr.hint$delegate.getValue(access$getAttr, SearchBarAttr.$$delegatedProperties[0]);
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.SearchBar$didInit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                SearchBar searchBar = SearchBar.this;
                SearchBarAttr access$getAttr = SearchBar.access$getAttr(searchBar);
                Object[] array = ((c) access$getAttr.hint$delegate.getValue(access$getAttr, SearchBarAttr.$$delegatedProperties[0])).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
                try {
                    b bVar = new b();
                    for (String str : strArr2) {
                        bVar.t(str);
                    }
                    AbstractBaseView.callRenderViewMethod$default(searchBar, IECSearchBar.METHOD_SET_HINT, bVar.toString(), null, 4, null);
                } catch (JSONException e16) {
                    Utils utils = Utils.INSTANCE;
                    String message = e16.getMessage();
                    if (message == null) {
                        message = "json parse error";
                    }
                    utils.logToNative(message);
                }
                return Unit.INSTANCE;
            }
        });
        AbstractBaseView.callRenderViewMethod$default(this, IECSearchBar.METHOD_UPDATE_STYLE, String.valueOf(((SearchBarAttr) getAttr()).style), null, 4, null);
        ((SearchBarEvent) getEvent()).register(IECSearchBar.METHOD_SET_CALLBACK, new SearchBar$didInit$3(this));
    }

    public final void setText(String str) {
        AbstractBaseView.callRenderViewMethod$default(this, IECSearchBar.METHOD_SET_TEXT, str, null, 4, null);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "HRSearchBar";
    }
}
