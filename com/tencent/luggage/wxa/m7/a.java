package com.tencent.luggage.wxa.m7;

import android.content.Context;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.wxa.kj.t;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.mc.m;
import com.tencent.luggage.wxa.mc.n;
import com.tencent.luggage.wxa.mc.q0;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.vi.b {
    @Override // com.tencent.luggage.wxa.vi.b
    public String a(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        return "\u663e\u793a\u8c03\u8bd5\u4fe1\u606f";
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public boolean c(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        return true;
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public void b(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        String replaceFirst$default;
        String trimIndent;
        String trimIndent2;
        boolean contains$default;
        String trimIndent3;
        String joinToString$default;
        a0 e16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        q i3 = pageView.i();
        Intrinsics.checkNotNull(i3);
        com.tencent.mm.plugin.appbrand.appcache.a aVar = pageView.getRuntime().j0().f125966l;
        LinkedList linkedList = new LinkedList();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\n                [process] ");
        String i16 = z.i();
        Intrinsics.checkNotNullExpressionValue(i16, "getProcessName()");
        String h16 = z.h();
        Intrinsics.checkNotNullExpressionValue(h16, "getPackageName()");
        replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(i16, h16, "", false, 4, (Object) null);
        sb5.append(replaceFirst$default);
        sb5.append("\n                [lib.src] ");
        sb5.append(i3 instanceof com.tencent.luggage.wxa.mc.c ? "asset" : "network");
        sb5.append("\n                [lib.ver_cli] ");
        sb5.append(i3.w());
        sb5.append("\n                [lib.ver_sdk] ");
        sb5.append(i3.u());
        sb5.append("\n            ");
        trimIndent = StringsKt__IndentKt.trimIndent(sb5.toString());
        linkedList.add(trimIndent);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("\n                [app.version] ");
        sb6.append(aVar.getPkgAppVersion());
        sb6.append("  [");
        sb6.append(w0.a(aVar.f151862b));
        sb6.append("]\n                [app.page.url] ");
        sb6.append(pageView.A0());
        sb6.append("\n                [app.lazy_code_loading] ");
        sb6.append(((t) pageView.a(t.class)).a());
        sb6.append("\n                [app.separated_plugins] ");
        q0 q0Var = aVar.f151866f;
        sb6.append((q0Var == null || q0Var.b()) ? false : true);
        sb6.append("\n                [app.pkg_enc_version] ");
        n b16 = k0.b(pageView.getRuntime());
        if (!(b16 instanceof m)) {
            b16 = null;
        }
        sb6.append((b16 == null || (e16 = b16.e(pageView.A0())) == null) ? -1 : e16.r());
        sb6.append("\n            ");
        trimIndent2 = StringsKt__IndentKt.trimIndent(sb6.toString());
        linkedList.add(trimIndent2);
        StringBuilder sb7 = new StringBuilder();
        sb7.append("\n                    [v8.version] ");
        sb7.append(V8.getV8Version());
        sb7.append("\n                    [v8.lite] ");
        String flags = V8.getFlags();
        Intrinsics.checkNotNullExpressionValue(flags, "getFlags()");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) flags, (CharSequence) "--lite-mode", false, 2, (Object) null);
        sb7.append(contains$default);
        sb7.append("\n                ");
        trimIndent3 = StringsKt__IndentKt.trimIndent(sb7.toString());
        linkedList.add(trimIndent3);
        TextView textView = new TextView(context);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedList, "\n", null, null, 0, null, null, 62, null);
        textView.setText(joinToString$default);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextColor(context.getResources().getColor(R.color.c7u));
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.bkj);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        new MMAlertDialog.Builder(pageView.getContext()).setView(textView).setCancelable(false).setPositiveBtnText(R.string.f170383z25).show();
    }
}
