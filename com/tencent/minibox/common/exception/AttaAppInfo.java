package com.tencent.minibox.common.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/minibox/common/exception/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appVersion", "b", "model", "c", "osVersion", "d", "uin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.minibox.common.exception.a, reason: from toString */
/* loaded from: classes9.dex */
public final /* data */ class AttaAppInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String appVersion;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String model;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String osVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String uin;

    public AttaAppInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.appVersion = str;
        this.model = str2;
        this.osVersion = str3;
        this.uin = str4;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AttaAppInfo) {
                AttaAppInfo attaAppInfo = (AttaAppInfo) other;
                if (!Intrinsics.areEqual(this.appVersion, attaAppInfo.appVersion) || !Intrinsics.areEqual(this.model, attaAppInfo.model) || !Intrinsics.areEqual(this.osVersion, attaAppInfo.osVersion) || !Intrinsics.areEqual(this.uin, attaAppInfo.uin)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.appVersion;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.model;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.osVersion;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.uin;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "AttaAppInfo(appVersion=" + this.appVersion + ", model=" + this.model + ", osVersion=" + this.osVersion + ", uin=" + this.uin + ")";
    }
}
