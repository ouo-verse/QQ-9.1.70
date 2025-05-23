package com.tencent.ecommerce.biz.util;

import android.content.Context;
import android.view.View;
import ck0.Product;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/util/ECDebugUtils;", "", "", "f", "Landroid/view/View;", "view", "e", "Landroid/content/Context;", "context", "Lck0/c;", "product", "d", "", "c", "", "a", "Z", "isDebug", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDebugUtils {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean isDebug;

    /* renamed from: b, reason: collision with root package name */
    public static final ECDebugUtils f104852b = new ECDebugUtils();

    ECDebugUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        isDebug = !isDebug;
        cg0.a.b("ECDebugUtils", "[switchDebug] isDebug = " + isDebug);
    }

    public final void e(View view) {
        ECViewUtilKt.a(view, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.util.ECDebugUtils$setupVeryLongClickListener$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                ECDebugUtils.f104852b.f();
                com.tencent.ecommerce.base.ui.i iVar = com.tencent.ecommerce.base.ui.i.f101155b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u7535\u5546\u8c03\u8bd5\u5165\u53e3\u72b6\u6001: ");
                z16 = ECDebugUtils.isDebug;
                sb5.append(z16 ? "\u5f00" : "\u5173");
                iVar.d(sb5.toString(), ECToastIcon.ICON_SUCCESS, 1);
            }
        });
    }

    public final void c(Context context, String product) {
    }

    public final void d(Context context, Product product) {
    }
}
