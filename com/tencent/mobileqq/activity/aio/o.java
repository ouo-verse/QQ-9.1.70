package com.tencent.mobileqq.activity.aio;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import com.tencent.mobileqq.activity.aio.v;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class o extends v {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f179546a;

    /* renamed from: b, reason: collision with root package name */
    public static ColorFilter f179547b;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static abstract class a extends v.a {

        /* renamed from: b, reason: collision with root package name */
        public BaseChatItemLayout f179548b;

        /* renamed from: c, reason: collision with root package name */
        public int f179549c;

        /* renamed from: d, reason: collision with root package name */
        public int f179550d;

        /* renamed from: e, reason: collision with root package name */
        public int f179551e = -1;
    }

    static {
        "MNC".equals(Build.VERSION.CODENAME);
        f179546a = true;
        f179547b = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
    }
}
