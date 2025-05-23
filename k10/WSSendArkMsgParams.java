package k10;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010 \u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0019\u0010$\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b\u0018\u0010#\u00a8\u0006'"}, d2 = {"Lk10/b;", "", "", "str", "", h.F, "f", "e", "toString", "", "hashCode", "other", "", "equals", "a", "I", "g", "()I", "uinType", "b", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "c", "getTroopUin", "troopUin", "d", "getMetaJson", "metaJson", "feedId", "posterId", "contentType", "Lsy/a;", "Lsy/a;", "()Lsy/a;", "listener", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILsy/a;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: k10.b, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class WSSendArkMsgParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int uinType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String troopUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String metaJson;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String feedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String posterId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int contentType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final sy.a listener;

    public WSSendArkMsgParams(int i3, String str, String str2, String str3, String feedId, String posterId, int i16, sy.a aVar) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        this.uinType = i3;
        this.uin = str;
        this.troopUin = str2;
        this.metaJson = str3;
        this.feedId = feedId;
        this.posterId = posterId;
        this.contentType = i16;
        this.listener = aVar;
    }

    /* renamed from: a, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* renamed from: b, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: c, reason: from getter */
    public final sy.a getListener() {
        return this.listener;
    }

    /* renamed from: d, reason: from getter */
    public final String getPosterId() {
        return this.posterId;
    }

    public final long e() {
        return h(this.troopUin);
    }

    public final long f() {
        return h(this.uin);
    }

    /* renamed from: g, reason: from getter */
    public final int getUinType() {
        return this.uinType;
    }

    public int hashCode() {
        int i3 = this.uinType * 31;
        String str = this.uin;
        int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.troopUin;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.metaJson;
        int hashCode3 = (((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.feedId.hashCode()) * 31) + this.posterId.hashCode()) * 31) + this.contentType) * 31;
        sy.a aVar = this.listener;
        return hashCode3 + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "WSSendArkMsgParams(uinType=" + this.uinType + ", uin=" + this.uin + ", troopUin=" + this.troopUin + ", metaJson=" + this.metaJson + ", feedId=" + this.feedId + ", posterId=" + this.posterId + ", contentType=" + this.contentType + ", listener=" + this.listener + ")";
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long h(String str) {
        Long longOrNull;
        if (str == null || longOrNull == null) {
            return 0L;
        }
        return longOrNull.longValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSSendArkMsgParams)) {
            return false;
        }
        WSSendArkMsgParams wSSendArkMsgParams = (WSSendArkMsgParams) other;
        return this.uinType == wSSendArkMsgParams.uinType && Intrinsics.areEqual(this.uin, wSSendArkMsgParams.uin) && Intrinsics.areEqual(this.troopUin, wSSendArkMsgParams.troopUin) && Intrinsics.areEqual(this.metaJson, wSSendArkMsgParams.metaJson) && Intrinsics.areEqual(this.feedId, wSSendArkMsgParams.feedId) && Intrinsics.areEqual(this.posterId, wSSendArkMsgParams.posterId) && this.contentType == wSSendArkMsgParams.contentType && Intrinsics.areEqual(this.listener, wSSendArkMsgParams.listener);
    }
}
