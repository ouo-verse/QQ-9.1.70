package mu1;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static List<Class<? extends c>> f417628a;

    static {
        ArrayList arrayList = new ArrayList();
        f417628a = arrayList;
        arrayList.add(b.class);
    }

    private static <T> T a(Class<? extends T> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e16) {
            QLog.e("BeforeSendGuildMsgPbHandlerImpl", 1, e16, new Object[0]);
            return null;
        }
    }

    public static ArrayList<c> b() {
        ArrayList<c> arrayList = new ArrayList<>();
        Iterator<Class<? extends c>> it = f417628a.iterator();
        while (it.hasNext()) {
            c cVar = (c) a(it.next());
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }
}
