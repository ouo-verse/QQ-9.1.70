package ij;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR2\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lij/f;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "spaceId", "", "b", "I", "()I", "e", "(I)V", "spaceType", "Ljava/util/ArrayList;", "Lqzone/QZoneBaseMeta$StUser;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setUserList", "(Ljava/util/ArrayList;)V", "userList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int spaceType = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ArrayList<QZoneBaseMeta$StUser> userList = new ArrayList<>();

    /* renamed from: a, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: b, reason: from getter */
    public final int getSpaceType() {
        return this.spaceType;
    }

    public final ArrayList<QZoneBaseMeta$StUser> c() {
        return this.userList;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void e(int i3) {
        this.spaceType = i3;
    }
}
