package com.tencent.luggage.wxa.x5;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.luggage.wxa.fd.t;
import com.tencent.luggage.wxa.mo.h;
import com.tencent.luggage.wxa.ui.b;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.vi.a {
    public a() {
        super(b.EnableDebug.ordinal());
    }

    @Override // com.tencent.luggage.wxa.vi.a
    public void a(Context context, com.tencent.luggage.wxa.m4.b pageView, h hVar, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        if (t.a(pageView.getRuntime())) {
            CharSequence a16 = a(context, pageView);
            if (hVar != null) {
                hVar.add(b.EnableDebug.ordinal(), a16);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.vi.a
    public void a(Context context, com.tencent.luggage.wxa.m4.b pageView, String str, com.tencent.luggage.wxa.ui.a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        com.tencent.luggage.wxa.wi.a.a(pageView, str, !pageView.getRuntime().j0().F);
    }

    public final CharSequence a(Context context, com.tencent.luggage.wxa.m4.b bVar) {
        String string;
        CharSequence a16 = com.tencent.luggage.wxa.wi.a.a(context, bVar);
        Intrinsics.checkNotNullExpressionValue(a16, "getMenuItemTitle(context, pageView)");
        int i3 = bVar.getRuntime().S().f125811d;
        if (i3 == 1) {
            string = context.getResources().getString(R.string.ywp);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026d_app_debug_type_testing)");
        } else if (i3 != 2) {
            string = "";
        } else {
            string = context.getResources().getString(R.string.ywo);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026pp_debug_type_previewing)");
        }
        String str = string;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.c5v);
        int color = context.getResources().getColor(R.color.b9v);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a16);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(dimensionPixelSize, false), 0, a16.length(), 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, a16.length(), 18);
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new com.tencent.luggage.wxa.cm.b(str, a(context, 11), a(context, 11), a(context, 9), -1, Color.parseColor("#42000000"), a(context, 2)), a16.length(), spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    public final int a(Context context, int i3) {
        return Math.round(context.getResources().getDisplayMetrics().density * i3);
    }
}
