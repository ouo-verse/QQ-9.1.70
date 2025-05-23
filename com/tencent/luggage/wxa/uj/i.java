package com.tencent.luggage.wxa.uj;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface i extends com.tencent.luggage.wxa.eo.c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z16, Map map);
    }

    boolean L();

    void a(Context context, String str, String str2, q qVar, k kVar, a aVar);

    void a(Context context, String str, String str2, Function2 function2);

    void a(Context context, String str, Function2 function2);

    void a(Context context, Function1 function1);

    void a(q qVar);

    void c(Context context);
}
