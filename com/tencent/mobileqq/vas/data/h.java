package com.tencent.mobileqq.vas.data;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/data/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isOnline", "()Z", "b", "isCanVisit", "Lcom/tencent/mobileqq/vas/data/i;", "c", "Lcom/tencent/mobileqq/vas/data/i;", "getBubble", "()Lcom/tencent/mobileqq/vas/data/i;", "bubble", "d", "I", "()I", WidgetCacheConstellationData.INTERVAL, "e", "Ljava/lang/String;", "getScheme", "()Ljava/lang/String;", ZPlanPublishSource.FROM_SCHEME, "<init>", "(ZZLcom/tencent/mobileqq/vas/data/i;ILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isOnline;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isCanVisit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i bubble;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int interval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String scheme;

    public h(boolean z16, boolean z17, @NotNull i bubble, int i3, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        this.isOnline = z16;
        this.isCanVisit = z17;
        this.bubble = bubble;
        this.interval = i3;
        this.scheme = str;
    }

    /* renamed from: a, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsCanVisit() {
        return this.isCanVisit;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        if (this.isOnline == hVar.isOnline && this.isCanVisit == hVar.isCanVisit && Intrinsics.areEqual(this.bubble, hVar.bubble) && this.interval == hVar.interval && Intrinsics.areEqual(this.scheme, hVar.scheme)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isOnline;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.isCanVisit;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int hashCode2 = (((((i16 + i3) * 31) + this.bubble.hashCode()) * 31) + this.interval) * 31;
        String str = this.scheme;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "isOnline: " + this.isOnline + ", isCanVisit: " + this.isCanVisit + ", bubble: " + this.bubble + " , interval = " + this.interval + ", scheme = " + this.scheme;
    }
}
