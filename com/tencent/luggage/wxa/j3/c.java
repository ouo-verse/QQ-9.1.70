package com.tencent.luggage.wxa.j3;

import android.content.Context;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.R;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f130777a = new c();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f130778a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f130779b;

        public a(Context context, String str) {
            this.f130778a = context;
            this.f130779b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.y9.a.makeText(this.f130778a, this.f130779b, 0).show();
        }
    }

    public final void a(Context context, com.tencent.luggage.wxa.bj.a e16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(e16, "e");
        int i3 = e16.f122899b;
        if (i3 == -10002) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = context.getResources().getString(R.string.yzl);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026pp_brand_open_app_failed)");
            String format = String.format(string, Arrays.copyOf(new Object[]{context.getResources().getString(R.string.yzm)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            com.tencent.luggage.wxa.y9.a.makeText(context, format, 0).show();
            return;
        }
        if (i3 != 33) {
            com.tencent.luggage.wxa.y9.a.makeText(context, context.getString(R.string.z0x, Integer.valueOf(i3), e16.f122900c), 1).show();
            return;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = context.getResources().getString(R.string.yzl);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026pp_brand_open_app_failed)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{context.getResources().getString(R.string.yzn)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        com.tencent.luggage.wxa.y9.a.makeText(context, format2, 0).show();
    }

    public final void a(Context context, int i3, Throwable ex5) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ex5, "ex");
        if ((!(ex5 instanceof com.tencent.luggage.wxa.bj.a) || ((com.tencent.luggage.wxa.bj.a) ex5).f122899b != 33) && !(ex5 instanceof TimeoutException) && !(ex5 instanceof FileNotFoundException)) {
            str = z.c().getString(R.string.z0y) + TokenParser.SP + i3 + TokenParser.SP + ex5;
        } else {
            str = z.c().getString(R.string.z0y) + TokenParser.SP + context.getResources().getString(R.string.yzn);
        }
        h.f146825d.a(new a(context, str));
    }
}
