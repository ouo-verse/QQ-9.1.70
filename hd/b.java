package hd;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0003B%\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lhd/b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name", "b", "getDesc", "setDesc", "desc", "", "c", "I", "()I", "setType", "(I)V", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String desc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int type;

    public b() {
        this(null, null, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public b(String name, String desc, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.name = name;
        this.desc = desc;
        this.type = i3;
    }

    public /* synthetic */ b(String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0 : i3);
    }
}
