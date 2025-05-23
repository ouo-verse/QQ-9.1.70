package com.tencent.mobileqq.zplan.model;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.raft.codegenmeta.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\n\fB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/model/f$b;", "a", "Lcom/tencent/mobileqq/zplan/model/f$b;", "b", "()Lcom/tencent/mobileqq/zplan/model/f$b;", "staticAvatar", "Lcom/tencent/mobileqq/zplan/model/f$a;", "Lcom/tencent/mobileqq/zplan/model/f$a;", "()Lcom/tencent/mobileqq/zplan/model/f$a;", "dynamicAvatar", "<init>", "(Lcom/tencent/mobileqq/zplan/model/f$b;Lcom/tencent/mobileqq/zplan/model/f$a;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.model.f, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanAvatar {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ZPlanStaticAvatar staticAvatar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ZPlanDynamicAvatar dynamicAvatar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/f$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "zipUrl", "", "b", "J", "c", "()J", "timestamp", "appearanceKey", Constants.Service.PROPERTIES, "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.model.f$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ZPlanDynamicAvatar {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String zipUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long timestamp;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String appearanceKey;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String properties;

        public ZPlanDynamicAvatar(@NotNull String zipUrl, long j3, @NotNull String appearanceKey, @NotNull String properties) {
            Intrinsics.checkNotNullParameter(zipUrl, "zipUrl");
            Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
            Intrinsics.checkNotNullParameter(properties, "properties");
            this.zipUrl = zipUrl;
            this.timestamp = j3;
            this.appearanceKey = appearanceKey;
            this.properties = properties;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppearanceKey() {
            return this.appearanceKey;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getProperties() {
            return this.properties;
        }

        /* renamed from: c, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getZipUrl() {
            return this.zipUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZPlanDynamicAvatar)) {
                return false;
            }
            ZPlanDynamicAvatar zPlanDynamicAvatar = (ZPlanDynamicAvatar) other;
            if (Intrinsics.areEqual(this.zipUrl, zPlanDynamicAvatar.zipUrl) && this.timestamp == zPlanDynamicAvatar.timestamp && Intrinsics.areEqual(this.appearanceKey, zPlanDynamicAvatar.appearanceKey) && Intrinsics.areEqual(this.properties, zPlanDynamicAvatar.properties)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.zipUrl.hashCode() * 31) + androidx.fragment.app.a.a(this.timestamp)) * 31) + this.appearanceKey.hashCode()) * 31) + this.properties.hashCode();
        }

        @NotNull
        public String toString() {
            return "ZPlanDynamicAvatar(zipUrl=" + this.zipUrl + ", timestamp=" + this.timestamp + ", appearanceKey=" + this.appearanceKey + ", properties=" + this.properties + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\r\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/f$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appearanceKey", "b", "getDayUrl", "dayUrl", "c", "getNightUrl", "nightUrl", "d", "Z", "()Z", AppConstants.Key.COLUMN_IS_VALID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.model.f$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ZPlanStaticAvatar {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String appearanceKey;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String dayUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String nightUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isValid;

        public ZPlanStaticAvatar(@NotNull String appearanceKey, @Nullable String str, @Nullable String str2) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
            this.appearanceKey = appearanceKey;
            this.dayUrl = str;
            this.nightUrl = str2;
            boolean z18 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    z18 = true;
                }
            }
            this.isValid = z18;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppearanceKey() {
            return this.appearanceKey;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsValid() {
            return this.isValid;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZPlanStaticAvatar)) {
                return false;
            }
            ZPlanStaticAvatar zPlanStaticAvatar = (ZPlanStaticAvatar) other;
            if (Intrinsics.areEqual(this.appearanceKey, zPlanStaticAvatar.appearanceKey) && Intrinsics.areEqual(this.dayUrl, zPlanStaticAvatar.dayUrl) && Intrinsics.areEqual(this.nightUrl, zPlanStaticAvatar.nightUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.appearanceKey.hashCode() * 31;
            String str = this.dayUrl;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            String str2 = this.nightUrl;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "ZPlanStaticAvatar(appearanceKey=" + this.appearanceKey + ", dayUrl=" + this.dayUrl + ", nightUrl=" + this.nightUrl + ')';
        }
    }

    public ZPlanAvatar(@NotNull ZPlanStaticAvatar staticAvatar, @Nullable ZPlanDynamicAvatar zPlanDynamicAvatar) {
        Intrinsics.checkNotNullParameter(staticAvatar, "staticAvatar");
        this.staticAvatar = staticAvatar;
        this.dynamicAvatar = zPlanDynamicAvatar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final ZPlanDynamicAvatar getDynamicAvatar() {
        return this.dynamicAvatar;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ZPlanStaticAvatar getStaticAvatar() {
        return this.staticAvatar;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanAvatar)) {
            return false;
        }
        ZPlanAvatar zPlanAvatar = (ZPlanAvatar) other;
        if (Intrinsics.areEqual(this.staticAvatar, zPlanAvatar.staticAvatar) && Intrinsics.areEqual(this.dynamicAvatar, zPlanAvatar.dynamicAvatar)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.staticAvatar.hashCode() * 31;
        ZPlanDynamicAvatar zPlanDynamicAvatar = this.dynamicAvatar;
        if (zPlanDynamicAvatar == null) {
            hashCode = 0;
        } else {
            hashCode = zPlanDynamicAvatar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "ZPlanAvatar(staticAvatar=" + this.staticAvatar + ", dynamicAvatar=" + this.dynamicAvatar + ')';
    }
}
