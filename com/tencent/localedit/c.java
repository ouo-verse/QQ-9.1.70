package com.tencent.localedit;

import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R%\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\f\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/localedit/c;", "", "", "", "c", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/Map;", "b", "()Ljava/util/Map;", ITVKPlayerEventListener.KEY_USER_INFO, "I", "()I", "setFileCacheMaxCount", "(I)V", "fileCacheMaxCount", "<init>", "(Ljava/util/Map;I)V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final /* data */ class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> userInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int fileCacheMaxCount;

    public c() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final int getFileCacheMaxCount() {
        return this.fileCacheMaxCount;
    }

    @NotNull
    public final Map<String, Object> b() {
        return this.userInfo;
    }

    @NotNull
    public final Map<String, Object> c() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(ITVKPlayerEventListener.KEY_USER_INFO, this.userInfo), TuplesKt.to("fileCacheMaxCount", Integer.valueOf(this.fileCacheMaxCount)));
        return mapOf;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.userInfo, cVar.userInfo) && this.fileCacheMaxCount == cVar.fileCacheMaxCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.userInfo.hashCode() * 31) + this.fileCacheMaxCount;
    }

    @NotNull
    public String toString() {
        List list;
        list = MapsKt___MapsKt.toList(c());
        return list.toString();
    }

    public c(@NotNull Map<String, Object> userInfo, int i3) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        this.userInfo = userInfo;
        this.fileCacheMaxCount = i3;
    }

    public /* synthetic */ c(Map map, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new LinkedHashMap() : map, (i16 & 2) != 0 ? 30 : i3);
    }
}
