package bf3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J#\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\t*\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lbf3/a;", "", "Ljava/io/Serializable;", "obj", "", "b", "objBytes", "d", "a", "T", "bytes", "c", "([B)Ljava/io/Serializable;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28357a = new a();

    a() {
    }

    public final byte[] a(Serializable obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            return b(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public final <T extends Serializable> T c(byte[] bytes) {
        Object obj;
        try {
            obj = d(bytes);
        } catch (Exception unused) {
            obj = null;
        }
        if (obj instanceof Serializable) {
            return (T) obj;
        }
        return null;
    }

    private final Object d(byte[] objBytes) {
        if (objBytes == null) {
            return null;
        }
        if (objBytes.length == 0) {
            return null;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(objBytes));
        Object readObject = objectInputStream.readObject();
        try {
            objectInputStream.close();
        } catch (Exception unused) {
        }
        return readObject;
    }

    private final byte[] b(Serializable obj) {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            objectOutputStream.close();
        } catch (Exception unused) {
        }
        return byteArray;
    }
}
