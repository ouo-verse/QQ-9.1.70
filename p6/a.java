package p6;

import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.utils.AssertUtil;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: h, reason: collision with root package name */
    private static final Object f425411h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static a f425412i;

    /* renamed from: j, reason: collision with root package name */
    private static int f425413j;

    /* renamed from: a, reason: collision with root package name */
    public String f425414a;

    /* renamed from: b, reason: collision with root package name */
    public String f425415b;

    /* renamed from: c, reason: collision with root package name */
    public String f425416c;

    /* renamed from: d, reason: collision with root package name */
    public String f425417d;

    /* renamed from: e, reason: collision with root package name */
    public String f425418e;

    /* renamed from: f, reason: collision with root package name */
    public Downloader.DownloadListener f425419f;

    /* renamed from: g, reason: collision with root package name */
    private a f425420g;

    public a(String str, String str2) {
        AssertUtil.assertTrue(!TextUtils.isEmpty(str));
        this.f425414a = str;
        this.f425418e = str2;
    }

    public static a a(String str, String str2) {
        synchronized (f425411h) {
            a aVar = f425412i;
            if (aVar != null) {
                f425412i = aVar.f425420g;
                aVar.f425420g = null;
                aVar.f425414a = str;
                aVar.f425418e = str2;
                f425413j--;
                return aVar;
            }
            return new a(str, str2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        return this.f425414a.equals(((a) obj).f425414a);
    }
}
