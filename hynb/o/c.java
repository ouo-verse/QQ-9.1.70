package hynb.o;

import com.google.gson.Gson;
import hynb.p.g;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Gson f406793a = new Gson();

    public static String a(Object obj) {
        try {
            return f406793a.toJson(obj);
        } catch (Throwable th5) {
            g.f406799a.a("HuyaGsonUtils", "toJson : error", th5);
            return "";
        }
    }
}
