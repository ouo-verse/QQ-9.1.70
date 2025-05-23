package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.tf;
import java.io.File;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface td extends tf.a {
    Class a(String str);

    <T> Class<? extends T> a(String str, Class<T> cls);

    Object a(Class cls, String str, Class[] clsArr, Object[] objArr);

    <T> T a(Class<T> cls, Object... objArr);

    Object a(Object obj, String str, Class[] clsArr, Object[] objArr);

    Object a(Object obj, String str, Object... objArr);

    ClassLoader b();

    Object b(String str);

    int c();

    File d();
}
