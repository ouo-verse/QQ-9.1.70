package ck0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lck0/a;", "", "", "b", "", "a", "Ljava/lang/String;", "title", "desc", "c", "pic", "d", "()Ljava/lang/String;", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String desc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String pic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String url;

    public a() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final boolean b() {
        if (this.title.length() > 0) {
            if (this.desc.length() > 0) {
                if (this.pic.length() > 0) {
                    if (this.url.length() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public a(String str, String str2, String str3, String str4) {
        this.title = str;
        this.desc = str2;
        this.pic = str3;
        this.url = str4;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
    }
}
