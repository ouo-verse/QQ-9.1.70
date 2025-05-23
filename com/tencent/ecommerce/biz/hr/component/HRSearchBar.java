package com.tencent.ecommerce.biz.hr.component;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.ecommerce.base.searchbar.IECSearchBarCreator;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001%\u0018\u0000 \u00062\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JI\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0004\u0018\u0001`\u0011H\u0016R;\u0010\u0017\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R4\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rj\u0002`\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006."}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRSearchBar;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "", "propValue", "N", "", "M", "", "propKey", "", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Lcom/tencent/ecommerce/biz/hr/component/KtvCallback;", "H", "Lkotlin/jvm/functions/Function1;", "ktvCallback", "", "Lcom/tencent/ecommerce/biz/hr/component/PropCallStyle;", "I", "Ljava/util/Map;", "ktvPropMap", "", "J", "Ljava/util/List;", "ktvMethodList", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBar;", "K", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBar;", "searchBar", "com/tencent/ecommerce/biz/hr/component/HRSearchBar$b", "L", "Lcom/tencent/ecommerce/biz/hr/component/HRSearchBar$b;", "qCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRSearchBar extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private Function1<Object, Unit> ktvCallback;

    /* renamed from: I, reason: from kotlin metadata */
    private final Map<String, Function1<Object, Object>> ktvPropMap;

    /* renamed from: J, reason: from kotlin metadata */
    private final List<String> ktvMethodList;

    /* renamed from: K, reason: from kotlin metadata */
    private IECSearchBar searchBar;

    /* renamed from: L, reason: from kotlin metadata */
    private final b qCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/hr/component/HRSearchBar$b", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBar$Callback;", "", "method", "", "param", "call", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECSearchBar.Callback {
        b() {
        }

        @Override // com.tencent.ecommerce.base.searchbar.IECSearchBar.Callback
        public Object call(String method, Object param) {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("methodName", method);
                if (param == null || (str = param.toString()) == null) {
                    str = "";
                }
                jSONObject.put("methodParam", str);
                Function1 function1 = HRSearchBar.this.ktvCallback;
                if (function1 == null) {
                    return null;
                }
                return null;
            } catch (JSONException e16) {
                String message = e16.getMessage();
                cg0.a.f("HRSearchBar", message != null ? message : "");
                return null;
            }
        }
    }

    public HRSearchBar(Context context) {
        super(context);
        Map<String, Function1<Object, Object>> mapOf;
        List<String> listOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IECSearchBar.METHOD_SET_CALLBACK, new HRSearchBar$ktvPropMap$1(this)));
        this.ktvPropMap = mapOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{IECSearchBar.METHOD_UPDATE_STYLE, IECSearchBar.METHOD_SET_HINT, IECSearchBar.METHOD_SET_TEXT, IECSearchBar.METHOD_ON_CANCEL_RESULT, "showKeyboard", "hideKeyboard"});
        this.ktvMethodList = listOf;
        IECSearchBarCreator searchBarCreator = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getSearchBarCreator();
        this.searchBar = searchBarCreator != null ? searchBarCreator.create(context) : null;
        b bVar = new b();
        this.qCallback = bVar;
        IECSearchBar iECSearchBar = this.searchBar;
        if (iECSearchBar != null) {
            View view = iECSearchBar.getView();
            if (view != null) {
                addView(view, -1, -1);
            }
            iECSearchBar.call(IECSearchBar.METHOD_SET_CALLBACK, bVar);
        }
    }

    private final void M() {
        Activity activity;
        IBinder windowToken;
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager != null) {
            if (getContext() instanceof Activity) {
                Context context2 = getContext();
                if (context2 != null) {
                    activity = (Activity) context2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
            } else {
                if (!(getContext() instanceof ContextWrapper)) {
                    return;
                }
                Context context3 = getContext();
                if (context3 != null) {
                    Context baseContext = ((ContextWrapper) context3).getBaseContext();
                    activity = (Activity) (baseContext instanceof Activity ? baseContext : null);
                    if (activity == null) {
                        return;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.content.ContextWrapper");
                }
            }
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null || (windowToken = currentFocus.getWindowToken()) == null) {
                return;
            }
            View currentFocus2 = activity.getCurrentFocus();
            if (currentFocus2 != null) {
                currentFocus2.clearFocus();
            }
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(String propKey, Object propValue) {
        Function1<Object, Object> function1 = this.ktvPropMap.get(propKey);
        Object invoke = function1 != null ? function1.invoke(propValue) : null;
        Boolean bool = (Boolean) (invoke instanceof Boolean ? invoke : null);
        if (bool != null) {
            return bool.booleanValue();
        }
        return super.b(propKey, propValue);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        if (Intrinsics.areEqual("hideKeyboard", method)) {
            M();
            return Unit.INSTANCE;
        }
        if (this.ktvMethodList.contains(method)) {
            IECSearchBar iECSearchBar = this.searchBar;
            if (iECSearchBar != null) {
                iECSearchBar.call(method, params);
            }
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N(Object propValue) {
        if (propValue != null) {
            this.ktvCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return Boolean.TRUE;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.hr.component.KtvCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }
}
