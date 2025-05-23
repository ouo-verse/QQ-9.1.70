package com.tencent.sqshow.zootopia.nativeui.dialog.views;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uv4.bd;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \r2\u00020\u0001:\u0001\u0017B/\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u0016\u001a\u00020\u0004R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010%\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010,R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010.R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/k;", "", "", "isLand", "", "e", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", tl.h.F, "isOpened", "i", "g", "k", "", "gender", "", "Luv4/bd;", "list", "j", "f", "a", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "b", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "", "", "c", "Ljava/util/Map;", "getReportParam", "()Ljava/util/Map;", "reportParam", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/ShoppingCartDialogView;", "d", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/ShoppingCartDialogView;", "mCartDialogView", "Z", "mIsLand", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "I", "mGender", "Ljava/util/List;", "mList", "<init>", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Ljava/util/Map;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> reportParam;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ShoppingCartDialogView mCartDialogView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLand;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mGender;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<bd> mList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/views/k$b", "Lga4/h;", "Lga4/g;", "panelDialog", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ga4.h {
        b() {
        }

        @Override // ga4.h
        public void a(ga4.g panelDialog) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar;
            y94.a reporter;
            Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
            QLog.d("ShoppingCartViewHelper", 1, "close ==> ");
            ShoppingCartDialogView shoppingCartDialogView = k.this.mCartDialogView;
            if (shoppingCartDialogView != null && (jVar = k.this.mChannel) != null && (reporter = jVar.getReporter()) != null) {
                reporter.k(shoppingCartDialogView, true);
            }
            k.this.i(false);
            k.this.mCartDialogView = null;
        }

        @Override // ga4.h
        public void b(ga4.g panelDialog) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar;
            y94.a reporter;
            Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
            QLog.d("ShoppingCartViewHelper", 1, "onShow ==>");
            ShoppingCartDialogView shoppingCartDialogView = k.this.mCartDialogView;
            if (shoppingCartDialogView != null && (jVar = k.this.mChannel) != null && (reporter = jVar.getReporter()) != null) {
                reporter.i(shoppingCartDialogView, true);
            }
            k.this.i(true);
        }
    }

    public k(ViewGroup container, LifecycleOwner lifecycleOwner, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.container = container;
        this.lifecycleOwner = lifecycleOwner;
        this.reportParam = map;
    }

    private final com.tencent.sqshow.zootopia.nativeui.data.j h(ViewGroup container, LifecycleOwner lifecycleOwner) {
        Object obj;
        com.tencent.sqshow.zootopia.nativeui.data.repo.i iVar = new com.tencent.sqshow.zootopia.nativeui.data.repo.i();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(null, new ga4.i(container));
        jVar.T(iVar);
        jVar.Z(lifecycleOwner);
        jVar.getReporter().m(this.reportParam);
        jVar.getReporter().a(container, "pg_zplan_cart_purchase");
        JSONObject jSONObject = new JSONObject();
        Map<String, Object> map = this.reportParam;
        if (map == null || (obj = map.get("zplan_map_id")) == null) {
            obj = "";
        }
        jSONObject.put("modid", obj);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026 \"\")\n        }.toString()");
        jVar.f0(jSONObject2);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean isOpened) {
        String str;
        com.tencent.zplan.luabridge.a aVar;
        JSONObject jSONObject = new JSONObject();
        if (isOpened) {
            str = "opened";
        } else {
            str = AudioContext.State.CLOSED;
        }
        jSONObject.put("status", str);
        QLog.i("ShoppingCartViewHelper", 1, "notify dialog status => " + jSONObject);
        if (t74.h.b()) {
            aVar = ZPlanServiceHelper.I.S();
        } else {
            aVar = ZPlanLuaBridge.INSTANCE;
        }
        com.tencent.zplan.luabridge.a aVar2 = aVar;
        if (aVar2 != null) {
            a.C10063a.d(aVar2, "N2L_UpdateShoppingCartStatus", jSONObject, null, false, 12, null);
        }
    }

    public final void f() {
        ShoppingCartDialogView shoppingCartDialogView = this.mCartDialogView;
        if (shoppingCartDialogView != null) {
            shoppingCartDialogView.o();
        }
        this.mCartDialogView = null;
    }

    public final void g(boolean isLand) {
        if (this.mCartDialogView == null || isLand != this.mIsLand) {
            e(isLand);
            this.mIsLand = isLand;
        }
    }

    public final void j(int gender, List<bd> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ShoppingCartDialogView shoppingCartDialogView = this.mCartDialogView;
        if (shoppingCartDialogView != null) {
            shoppingCartDialogView.L0(gender, list);
        }
        this.mList = list;
        this.mGender = gender;
        ShoppingCartDialogView shoppingCartDialogView2 = this.mCartDialogView;
        if (shoppingCartDialogView2 != null) {
            shoppingCartDialogView2.show();
        }
    }

    public final void k(boolean isLand) {
        ShoppingCartDialogView shoppingCartDialogView;
        ShoppingCartDialogView shoppingCartDialogView2;
        QLog.d("ShoppingCartViewHelper", 1, "switch ==> origin " + this.mIsLand + " current: " + isLand);
        if (this.mIsLand == isLand || (shoppingCartDialogView = this.mCartDialogView) == null) {
            return;
        }
        if (shoppingCartDialogView != null) {
            shoppingCartDialogView.n();
        }
        e(isLand);
        List<bd> list = this.mList;
        if (list != null && (shoppingCartDialogView2 = this.mCartDialogView) != null) {
            shoppingCartDialogView2.L0(this.mGender, list);
        }
        ShoppingCartDialogView shoppingCartDialogView3 = this.mCartDialogView;
        if (shoppingCartDialogView3 != null) {
            shoppingCartDialogView3.show();
        }
        this.mIsLand = isLand;
    }

    private final void e(boolean isLand) {
        ShoppingCartDialogView shoppingCartDialogViewPortrait;
        if (this.mChannel == null) {
            this.mChannel = h(this.container, this.lifecycleOwner);
        }
        if (this.mChannel == null) {
            return;
        }
        if (isLand) {
            Context context = this.container.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "container.context");
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            Intrinsics.checkNotNull(jVar);
            shoppingCartDialogViewPortrait = new ShoppingCartDialogViewLand(context, null, 0, jVar, 6, null);
        } else {
            Context context2 = this.container.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "container.context");
            com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
            Intrinsics.checkNotNull(jVar2);
            shoppingCartDialogViewPortrait = new ShoppingCartDialogViewPortrait(context2, null, 0, jVar2, 6, null);
        }
        this.mCartDialogView = shoppingCartDialogViewPortrait;
        shoppingCartDialogViewPortrait.setOnDismissListener(new b());
    }
}
