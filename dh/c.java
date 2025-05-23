package dh;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR>\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e`\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010 \u001a\u0004\b\u000e\u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010&\u001a\u0004\b\n\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Ldh/c;", "", "", "a", "I", "d", "()I", h.F, "(I)V", "id", "b", "f", "count", "", "c", "Ljava/lang/String;", "getRedCountText", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "redCountText", "", "Ldh/e;", "Ljava/util/List;", "e", "()Ljava/util/List;", "j", "(Ljava/util/List;)V", "userList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setExtraInfoEntry", "(Ljava/util/HashMap;)V", "extraInfoEntry", "", "J", "()J", "g", "(J)V", WadlProxyConsts.CREATE_TIME, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int count;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String redCountText = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<e> userList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, byte[]> extraInfoEntry = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long createTime;

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    public final HashMap<String, byte[]> c() {
        return this.extraInfoEntry;
    }

    /* renamed from: d, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final List<e> e() {
        return this.userList;
    }

    public final void f(int i3) {
        this.count = i3;
    }

    public final void g(long j3) {
        this.createTime = j3;
    }

    public final void h(int i3) {
        this.id = i3;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.redCountText = str;
    }

    public final void j(List<e> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.userList = list;
    }
}
