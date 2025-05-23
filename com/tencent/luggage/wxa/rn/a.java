package com.tencent.luggage.wxa.rn;

import android.os.Looper;
import com.tencent.luggage.wxa.jq.e;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.zp.h;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rn.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6695a implements g, e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f139895a;

        public C6695a(Function0 function0) {
            this.f139895a = function0;
        }

        @Override // com.tencent.luggage.wxa.jq.e
        public boolean a() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "";
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f139895a.invoke();
        }
    }

    public static final void a(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            block.invoke();
        } else {
            h.f146825d.a(new C6695a(block));
        }
    }

    public static final Class a(KClass clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return a(JvmClassMappingKt.getJavaClass(clazz), 0);
    }

    public static final Class a(Class clazz, int i3) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Type genericSuperclass = clazz.getGenericSuperclass();
        Intrinsics.checkNotNullExpressionValue(genericSuperclass, "clazz.genericSuperclass");
        while (!(genericSuperclass instanceof ParameterizedType)) {
            genericSuperclass = clazz.getSuperclass().getGenericSuperclass();
            Intrinsics.checkNotNullExpressionValue(genericSuperclass, "clazz.superclass.genericSuperclass");
        }
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[i3];
        if (type instanceof Class) {
            return (Class) type;
        }
        return null;
    }
}
