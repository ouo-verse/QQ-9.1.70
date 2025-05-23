package i13;

import com.tencent.oskplayer.util.SecretUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Li13/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", SecretUtils.DES, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: i13.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class GuideData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String des;

    public GuideData(String url, String des) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(des, "des");
        this.url = url;
        this.des = des;
    }

    /* renamed from: a, reason: from getter */
    public final String getDes() {
        return this.des;
    }

    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.des.hashCode();
    }

    public String toString() {
        return "GuideData(url=" + this.url + ", des=" + this.des + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuideData)) {
            return false;
        }
        GuideData guideData = (GuideData) other;
        return Intrinsics.areEqual(this.url, guideData.url) && Intrinsics.areEqual(this.des, guideData.des);
    }
}
