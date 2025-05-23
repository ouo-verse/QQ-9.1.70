package nh0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.account.api.INVViewModelInitialization;
import com.tencent.ecommerce.richtext.utils.e;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import ik0.c;
import ik0.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lk0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\u001f\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000e\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lnh0/a;", "", "", "a", "Lik0/c;", HippyQQConstants.URL_COMPONENT_NAME, "", "skinIndex", h.F, "Lorg/json/JSONObject;", "domJSON", "e", "", "refRecordList", "f", "", NodeProps.MAX_WIDTH, "c", "Landroid/content/Context;", "context", "Landroid/view/View;", "b", "g", "Landroid/view/View;", "nvView", "Lik0/c;", "rootComponent", "", "", "Ljava/util/Map;", "componentMap", "", "d", "Z", "hadInit", "environmentEnsureByUser", "<init>", "(Z)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f420133e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View nvView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private c<?> rootComponent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, c<?>> componentMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hadInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lnh0/a$a;", "", "", NodeProps.COLORS, "", "index", "b", "BACKGROUND_COLORS", "Ljava/lang/String;", "COLORS", "SKIN_TYPE_DEFAULT", "I", "SKIN_TYPE_NIGHT", "TAG", "", "ensureNVViewModelEnvironment", "Z", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: nh0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
        
            r9 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r9, new java.lang.String[]{"|"}, false, 0, 6, (java.lang.Object) null);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(String colors, int index) {
            List split$default;
            if (colors == null || split$default == null || index >= split$default.size() || TextUtils.isEmpty((CharSequence) split$default.get(index))) {
                return null;
            }
            return (String) split$default.get(index);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a() {
        this(false, 1, null);
    }

    private final void a() {
        if (!f420133e) {
            INVViewModelInitialization nvViewModelInitialization = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNvViewModelInitialization();
            if (nvViewModelInitialization != null) {
                nvViewModelInitialization.init();
            }
            f420133e = true;
        }
    }

    public static /* synthetic */ void d(a aVar, JSONObject jSONObject, float f16, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.c(jSONObject, f16, i3);
    }

    private final void e(JSONObject domJSON, int skinIndex) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        f(domJSON, arrayList, skinIndex);
    }

    private final void f(JSONObject domJSON, List<Integer> refRecordList, int skinIndex) {
        if (domJSON != null && !refRecordList.isEmpty()) {
            if (TextUtils.isEmpty(domJSON.optString("ref"))) {
                int intValue = refRecordList.get(0).intValue();
                domJSON.put("ref", String.valueOf(intValue));
                refRecordList.set(0, Integer.valueOf(intValue + 1));
            }
            JSONObject optJSONObject = domJSON.optJSONObject("style");
            if (optJSONObject != null) {
                Companion companion = INSTANCE;
                String b16 = companion.b(optJSONObject.optString(NodeProps.COLORS), skinIndex);
                if (b16 != null) {
                    optJSONObject.put("color", b16);
                }
                String b17 = companion.b(optJSONObject.optString(NodeProps.BACKGROUND_COLORS), skinIndex);
                if (b17 != null) {
                    optJSONObject.put("backgroundColor", b17);
                }
            }
            JSONArray optJSONArray = domJSON.optJSONArray(Node.CHILDREN_ATTR);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    f(optJSONArray.optJSONObject(i3), refRecordList, skinIndex);
                }
            }
        }
    }

    private final void h(c<?> component, int skinIndex) {
        b m3;
        lk0.h g06;
        if (component != null && (m3 = component.m()) != null && (g06 = m3.g0()) != null) {
            Companion companion = INSTANCE;
            String b16 = companion.b(e.p(g06.get(NodeProps.COLORS), null), skinIndex);
            if (b16 != null) {
                g06.put("color", b16);
            }
            String b17 = companion.b(e.p(g06.get(NodeProps.BACKGROUND_COLORS), null), skinIndex);
            if (b17 != null) {
                g06.put("backgroundColor", b17);
            }
            component.m().w0(g06);
            component.P(g06);
            if (!(component instanceof d)) {
                component = null;
            }
            d dVar = (d) component;
            if (dVar != null) {
                int W = dVar.W();
                for (int i3 = 0; i3 < W; i3++) {
                    h(dVar.V(i3), skinIndex);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    @Nullable
    public final View b(@Nullable Context context) {
        View view = this.nvView;
        if (view != null) {
            return view;
        }
        c<?> cVar = this.rootComponent;
        if (cVar != null) {
            cVar.h(context);
            ?? n3 = cVar.n();
            this.nvView = n3;
            if (n3 != 0) {
                cVar.b();
                cVar.d();
            }
        }
        return this.nvView;
    }

    @WorkerThread
    public final void c(@NotNull JSONObject domJSON, float maxWidth, int skinIndex) {
        try {
            if (this.hadInit) {
                return;
            }
            this.hadInit = true;
            e(domJSON, skinIndex);
            this.rootComponent = e.b(domJSON, new fk0.c(fk0.b.a()), this.componentMap, maxWidth);
        } catch (Throwable unused) {
        }
    }

    public final void g(int skinIndex) {
        h(this.rootComponent, skinIndex);
    }

    public a(boolean z16) {
        this.componentMap = new ArrayMap();
        if (z16) {
            return;
        }
        a();
    }

    public /* synthetic */ a(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
