package o11;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.util.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements g {

    /* renamed from: h, reason: collision with root package name */
    private List<a> f421726h = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private List<b> f421727a;

        public List<b> a() {
            return this.f421727a;
        }

        public void b(List<b> list) {
            this.f421727a = list;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f421728a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f421729b;

        public b(String str, boolean z16) {
            this.f421728a = str;
            this.f421729b = z16;
        }

        public String a() {
            return this.f421728a;
        }

        public boolean b() {
            return this.f421729b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return this.f421728a.equals(((b) obj).f421728a);
        }

        public String toString() {
            return this.f421728a;
        }
    }

    @NonNull
    public static String c(@NonNull List<b> list) {
        StringBuilder sb5 = new StringBuilder("");
        if (list.isEmpty()) {
            sb5.append("/");
        }
        for (b bVar : list) {
            sb5.append("/");
            sb5.append(bVar.a());
        }
        return sb5.toString();
    }

    @NonNull
    public static List<b> d(@NonNull String str) {
        int i3;
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            while (str.startsWith("/")) {
                str = str.substring(1);
            }
            while (true) {
                if (!str.endsWith("/")) {
                    break;
                }
                str = str.substring(0, str.length() - 1);
            }
            for (String str2 : str.split("/")) {
                linkedList.add(new b(str2, str2.contains("{")));
            }
        }
        return Collections.unmodifiableList(linkedList);
    }

    public void a(@NonNull String str) {
        a aVar = new a();
        aVar.b(d(str));
        this.f421726h.add(aVar);
    }

    @NonNull
    public List<a> b() {
        return this.f421726h;
    }
}
