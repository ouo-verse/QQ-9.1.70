package j11;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f409078b;

    /* renamed from: a, reason: collision with root package name */
    private Context f409079a;

    static {
        ArrayList arrayList = new ArrayList();
        f409078b = arrayList;
        arrayList.add("AdapterRegister");
        arrayList.add("ConfigRegister");
        arrayList.add("ConverterRegister");
        arrayList.add("InterceptorRegister");
        arrayList.add("ResolverRegister");
    }

    public b(Context context) {
        this.f409079a = context;
    }

    private void b(s11.b bVar, String str, String str2) throws InstantiationException, IllegalAccessException {
        try {
            Class<?> cls = Class.forName(str2);
            if (s11.a.class.isAssignableFrom(cls)) {
                ((s11.a) cls.newInstance()).onRegister(this.f409079a, str, bVar);
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    public void a(s11.b bVar, String str) throws InstantiationException, IllegalAccessException {
        String[] strArr;
        try {
            strArr = this.f409079a.getAssets().list("");
        } catch (IOException e16) {
            e16.printStackTrace();
            strArr = null;
        }
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (str2.endsWith(".andserver")) {
                    String substring = str2.substring(0, str2.lastIndexOf(".andserver"));
                    Iterator<String> it = f409078b.iterator();
                    while (it.hasNext()) {
                        b(bVar, str, String.format("%s%s%s", substring, ".andserver.processor.generator.", it.next()));
                    }
                }
            }
        }
    }
}
