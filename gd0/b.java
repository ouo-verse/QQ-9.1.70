package gd0;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadLocal<StringBuilder> f401934a = new a();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends ThreadLocal<StringBuilder> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            StringBuilder sb5 = new StringBuilder(512);
            sb5.setLength(0);
            return sb5;
        }
    }

    public static String a(Object... objArr) {
        StringBuilder sb5 = f401934a.get();
        if (objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj != null) {
                    sb5.append(obj.toString());
                }
            }
            String sb6 = sb5.toString();
            if (sb5.length() > 512) {
                f401934a.set(new StringBuilder(512));
            }
            sb5.setLength(0);
            return sb6;
        }
        return "";
    }
}
