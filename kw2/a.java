package kw2;

import com.qq.taf.jce.JceStruct;
import com.squareup.wire.Message;
import lw2.f;
import lw2.g;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f413329a = new a();

    a() {
    }

    public static a b() {
        return f413329a;
    }

    public <ToT extends JceStruct, FromT extends Message> ToT a(FromT fromt) {
        if (fromt == null) {
            return null;
        }
        g a16 = f.a(fromt);
        if (a16 == f.f415695a && qv2.b.e()) {
            throw new UnsupportedOperationException("can't not convert class, class name=" + fromt.getClass().getName());
        }
        return (ToT) a16.a(fromt);
    }
}
