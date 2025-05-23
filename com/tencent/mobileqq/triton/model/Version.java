package com.tencent.mobileqq.triton.model;

import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\fH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/triton/model/Version;", "", "version", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "(Ljava/lang/String;J)V", "getTimeStamp", "()J", "getVersion", "()Ljava/lang/String;", "compareTo", "", "other", "compareVersion", "lhs", "rhs", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class Version implements Comparable<Version> {
    private final long timeStamp;

    @NotNull
    private final String version;

    public Version(@NotNull String version, long j3) {
        Intrinsics.checkParameterIsNotNull(version, "version");
        this.version = version;
        this.timeStamp = j3;
    }

    private final int compareVersion(String lhs, String rhs) {
        List split$default;
        List split$default2;
        split$default = StringsKt__StringsKt.split$default((CharSequence) lhs, new char[]{'.'}, false, 0, 6, (Object) null);
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) rhs, new char[]{'.'}, false, 0, 6, (Object) null);
        Ref.IntRef intRef = new Ref.IntRef();
        int min = Math.min(split$default.size(), split$default2.size());
        for (int i3 = 0; i3 < min; i3++) {
            try {
                int parseInt = Integer.parseInt((String) split$default.get(i3)) - Integer.parseInt((String) split$default2.get(i3));
                intRef.element = parseInt;
                if (parseInt != 0) {
                    return parseInt;
                }
            } catch (Exception unused) {
                return 0;
            }
        }
        return split$default.size() - split$default2.size();
    }

    public static /* synthetic */ Version copy$default(Version version, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = version.version;
        }
        if ((i3 & 2) != 0) {
            j3 = version.timeStamp;
        }
        return version.copy(str, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    @NotNull
    public final Version copy(@NotNull String version, long timeStamp) {
        Intrinsics.checkParameterIsNotNull(version, "version");
        return new Version(version, timeStamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Version) {
                Version version = (Version) other;
                if (!Intrinsics.areEqual(this.version, version.version) || this.timeStamp != version.timeStamp) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int i3;
        String str = this.version;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        long j3 = this.timeStamp;
        return (i3 * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "Version(version=" + this.version + ", timeStamp=" + this.timeStamp + ")";
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Version other) {
        Intrinsics.checkParameterIsNotNull(other, "other");
        int compareVersion = compareVersion(this.version, other.version);
        return compareVersion == 0 ? (this.timeStamp > other.timeStamp ? 1 : (this.timeStamp == other.timeStamp ? 0 : -1)) : compareVersion;
    }
}
