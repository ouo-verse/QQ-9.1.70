package com.tencent.luggage.wxa.h6;

import android.os.Looper;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.tn.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f126874a;

        public a(Function0 function0) {
            this.f126874a = function0;
        }

        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.f126874a.invoke();
        }
    }

    public static final boolean a(Object obj) {
        return obj != null;
    }

    public static final boolean b(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    public static final boolean a(String str, String prefix, boolean z16) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        isBlank = StringsKt__StringsJVMKt.isBlank(prefix);
        if (isBlank) {
            return false;
        }
        if (!z16) {
            if (URLUtil.isHttpUrl(str)) {
                str = str.substring(7);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
            } else if (URLUtil.isHttpsUrl(str)) {
                str = str.substring(8);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
            }
        }
        return o.a(str, prefix);
    }

    public static final String a(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return a(jSONObject, name, "");
    }

    public static final String a(JSONObject jSONObject, String name, String fallback) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Object opt = jSONObject.opt(name);
        return opt instanceof String ? (String) opt : fallback;
    }

    public static final void a(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            block.invoke();
        } else {
            c0.a(new a(block));
        }
    }

    public static final void a(long j3, Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        c0.a(new a(block), j3);
    }
}
