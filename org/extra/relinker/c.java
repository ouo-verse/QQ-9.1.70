package org.extra.relinker;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class c {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface b {
        void a(String str);

        String[] a();

        String b(String str);

        void c(String str);

        String d(String str);
    }

    /* compiled from: P */
    /* renamed from: org.extra.relinker.c$c, reason: collision with other inner class name */
    /* loaded from: classes29.dex */
    public interface InterfaceC10938c {
        void a(Throwable th5);
    }

    public static void a(Context context, String str) {
        a(context, str, null, null);
    }

    public static void a(Context context, String str, String str2, InterfaceC10938c interfaceC10938c) {
        new d().a(context, str, str2, interfaceC10938c);
    }
}
