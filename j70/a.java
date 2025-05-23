package j70;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile AtomicReference<String> f409613a = new AtomicReference<>("");

    public static String a() {
        return f409613a.get();
    }

    public static boolean b() {
        return !TextUtils.isEmpty(f409613a.get());
    }

    public static void c(String str) {
        f409613a.set(str);
    }
}
