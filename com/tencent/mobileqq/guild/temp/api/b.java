package com.tencent.mobileqq.guild.temp.api;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R7\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "mediaList", "Z", "c", "()Z", "isQuality", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "editMap", "<init>", "(Ljava/util/List;ZLjava/util/HashMap;)V", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Object> mediaList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isQuality;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final HashMap<String, String> editMap;

    public b(@NotNull List<? extends Object> mediaList, boolean z16, @Nullable HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this.mediaList = mediaList;
        this.isQuality = z16;
        this.editMap = hashMap;
    }

    @Nullable
    public final HashMap<String, String> a() {
        return this.editMap;
    }

    @NotNull
    public final List<Object> b() {
        return this.mediaList;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsQuality() {
        return this.isQuality;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.mediaList, bVar.mediaList) && this.isQuality == bVar.isQuality && Intrinsics.areEqual(this.editMap, bVar.editMap)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.mediaList.hashCode() * 31;
        boolean z16 = this.isQuality;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        HashMap<String, String> hashMap = this.editMap;
        if (hashMap == null) {
            hashCode = 0;
        } else {
            hashCode = hashMap.hashCode();
        }
        return i16 + hashCode;
    }

    @NotNull
    public String toString() {
        Integer num;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mediaListSize:");
        sb5.append(this.mediaList.size());
        sb5.append(",isQuality:");
        sb5.append(this.isQuality);
        sb5.append(",editMapSize:");
        HashMap<String, String> hashMap = this.editMap;
        if (hashMap != null) {
            num = Integer.valueOf(hashMap.size());
        } else {
            num = null;
        }
        sb5.append(num);
        return sb5.toString();
    }
}
