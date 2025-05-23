package c.t.m.g;

import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes.dex */
public class r3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f29969a;

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f29970b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f29971c;

    static {
        Pattern compile = Pattern.compile("[0-9a-zA-Z+-]*");
        f29969a = compile;
        f29970b = compile;
        f29971c = Pattern.compile("[A-Z0-9]{12}");
    }

    public static String a(String str, Pattern pattern) {
        if (str == null || !pattern.matcher(str).matches()) {
            return "";
        }
        return str;
    }
}
