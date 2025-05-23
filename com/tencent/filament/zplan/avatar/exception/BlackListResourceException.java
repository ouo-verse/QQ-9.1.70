package com.tencent.filament.zplan.avatar.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/avatar/exception/BlackListResourceException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "resourceId", "", "url", "", "(JLjava/lang/String;)V", "getResourceId", "()J", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class BlackListResourceException extends IllegalArgumentException {
    private final long resourceId;

    @NotNull
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListResourceException(long j3, @NotNull String url) {
        super("resource id is in black list. resId: " + j3 + ", url: " + url);
        Intrinsics.checkNotNullParameter(url, "url");
        this.resourceId = j3;
        this.url = url;
    }

    public static /* synthetic */ BlackListResourceException copy$default(BlackListResourceException blackListResourceException, long j3, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = blackListResourceException.resourceId;
        }
        if ((i3 & 2) != 0) {
            str = blackListResourceException.url;
        }
        return blackListResourceException.copy(j3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getResourceId() {
        return this.resourceId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final BlackListResourceException copy(long resourceId, @NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new BlackListResourceException(resourceId, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof BlackListResourceException) {
                BlackListResourceException blackListResourceException = (BlackListResourceException) other;
                if (this.resourceId != blackListResourceException.resourceId || !Intrinsics.areEqual(this.url, blackListResourceException.url)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getResourceId() {
        return this.resourceId;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i3;
        long j3 = this.resourceId;
        int i16 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        String str = this.url;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return "BlackListResourceException(resourceId=" + this.resourceId + ", url=" + this.url + ")";
    }
}
