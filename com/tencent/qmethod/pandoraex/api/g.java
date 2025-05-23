package com.tencent.qmethod.pandoraex.api;

import android.content.Context;
import android.os.Parcelable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface g {
    String a(Context context, String str);

    Integer b(Context context, String str);

    boolean c(Context context, String str, Long l3);

    boolean d(Context context, String str, String str2);

    boolean e(Context context, String str, Integer num);

    Long f(Context context, String str);

    Boolean g(Context context, String str);

    <T extends Parcelable> T h(Context context, String str, Class<T> cls);

    boolean i(Context context, String str, Parcelable parcelable);

    void j(Context context, String str);

    void k(Context context);

    <T> List<T> l(Context context, String str, Class<T> cls);

    Boolean m(Context context, String str);

    boolean n(Context context, String str, Boolean bool);

    <T> boolean o(Context context, String str, List<T> list);
}
