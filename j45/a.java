package j45;

import android.os.Process;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes29.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f409250a;

    /* renamed from: b, reason: collision with root package name */
    private final long f409251b;

    /* renamed from: c, reason: collision with root package name */
    private final long f409252c;

    /* renamed from: d, reason: collision with root package name */
    private final long f409253d;

    /* renamed from: e, reason: collision with root package name */
    private final int f409254e;

    /* renamed from: f, reason: collision with root package name */
    private final String f409255f;

    /* renamed from: g, reason: collision with root package name */
    private final String f409256g;

    /* renamed from: h, reason: collision with root package name */
    private final int f409257h;

    /* renamed from: i, reason: collision with root package name */
    private final String f409258i;

    /* renamed from: j, reason: collision with root package name */
    private final String f409259j;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f409260a;

        /* renamed from: b, reason: collision with root package name */
        private final long f409261b;

        /* renamed from: c, reason: collision with root package name */
        private final long f409262c;

        /* renamed from: d, reason: collision with root package name */
        private final int f409263d;

        /* renamed from: e, reason: collision with root package name */
        private final String f409264e;

        /* renamed from: f, reason: collision with root package name */
        private String f409265f;

        /* renamed from: g, reason: collision with root package name */
        private int f409266g;

        /* renamed from: h, reason: collision with root package name */
        private String f409267h;

        /* renamed from: i, reason: collision with root package name */
        private String f409268i;

        public b b(String str) {
            this.f409267h = str;
            return this;
        }

        public a c() {
            return new a(this);
        }

        b(int i3, String str) {
            this.f409260a = System.currentTimeMillis();
            this.f409261b = Process.myPid();
            this.f409262c = Process.myTid();
            this.f409263d = i3;
            this.f409264e = str;
            this.f409265f = "";
            this.f409266g = 0;
            this.f409268i = "";
        }
    }

    private static char a(int i3) {
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            return 'V';
                        }
                        return EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
                    }
                    return 'E';
                }
                return 'W';
            }
            return 'I';
        }
        return 'D';
    }

    public static b b(int i3, String str) {
        return new b(i3, str);
    }

    public void c(StringBuilder sb5) {
        sb5.append("[");
        sb5.append(this.f409250a.format(Long.valueOf(this.f409251b)));
        sb5.append(" ");
        sb5.append(a(this.f409254e));
        sb5.append("/");
        sb5.append(this.f409255f);
        sb5.append(" ");
        sb5.append(this.f409252c);
        sb5.append(":");
        sb5.append(this.f409253d);
        sb5.append(" ");
        sb5.append(this.f409256g);
        sb5.append(":");
        sb5.append(this.f409257h);
        sb5.append("]");
    }

    public void d(StringBuilder sb5) {
        sb5.append(this.f409258i);
    }

    public void e(StringBuilder sb5) {
        if (this.f409259j != null) {
            sb5.append('\n');
            sb5.append(this.f409259j);
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        c(sb5);
        sb5.append(" ");
        d(sb5);
        e(sb5);
        sb5.append("\n");
        return sb5.toString();
    }

    a(b bVar) {
        this.f409250a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        this.f409251b = bVar.f409260a;
        this.f409252c = bVar.f409261b;
        this.f409253d = bVar.f409262c;
        this.f409254e = bVar.f409263d;
        this.f409255f = bVar.f409264e;
        this.f409256g = bVar.f409265f;
        this.f409257h = bVar.f409266g;
        this.f409258i = bVar.f409267h;
        this.f409259j = bVar.f409268i;
    }
}
