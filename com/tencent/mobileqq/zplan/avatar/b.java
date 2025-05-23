package com.tencent.mobileqq.zplan.avatar;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/b;", "", "a", "b", "c", "d", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0015\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "entranceType", "b", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "loadedCnt", "f", "localCacheCnt", "d", "cloudCacheCnt", "g", "localRecordCnt", "dressUpKey", "Ljava/lang/Boolean;", h.F, "()Ljava/lang/Boolean;", "isDefaultAppearance", "firstEntryType", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.b$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class AvatarEditLeaveParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String entranceType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer loadedCnt;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer localCacheCnt;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer cloudCacheCnt;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer localRecordCnt;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String dressUpKey;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Boolean isDefaultAppearance;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String firstEntryType;

        public AvatarEditLeaveParam() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Integer getCloudCacheCnt() {
            return this.cloudCacheCnt;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getDressUpKey() {
            return this.dressUpKey;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getEntranceType() {
            return this.entranceType;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getFirstEntryType() {
            return this.firstEntryType;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final Integer getLoadedCnt() {
            return this.loadedCnt;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarEditLeaveParam)) {
                return false;
            }
            AvatarEditLeaveParam avatarEditLeaveParam = (AvatarEditLeaveParam) other;
            if (Intrinsics.areEqual(this.entranceType, avatarEditLeaveParam.entranceType) && Intrinsics.areEqual(this.loadedCnt, avatarEditLeaveParam.loadedCnt) && Intrinsics.areEqual(this.localCacheCnt, avatarEditLeaveParam.localCacheCnt) && Intrinsics.areEqual(this.cloudCacheCnt, avatarEditLeaveParam.cloudCacheCnt) && Intrinsics.areEqual(this.localRecordCnt, avatarEditLeaveParam.localRecordCnt) && Intrinsics.areEqual(this.dressUpKey, avatarEditLeaveParam.dressUpKey) && Intrinsics.areEqual(this.isDefaultAppearance, avatarEditLeaveParam.isDefaultAppearance) && Intrinsics.areEqual(this.firstEntryType, avatarEditLeaveParam.firstEntryType)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final Integer getLocalCacheCnt() {
            return this.localCacheCnt;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final Integer getLocalRecordCnt() {
            return this.localRecordCnt;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final Boolean getIsDefaultAppearance() {
            return this.isDefaultAppearance;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            String str = this.entranceType;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            Integer num = this.loadedCnt;
            if (num == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Integer num2 = this.localCacheCnt;
            if (num2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = num2.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Integer num3 = this.cloudCacheCnt;
            if (num3 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = num3.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            Integer num4 = this.localRecordCnt;
            if (num4 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = num4.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str2 = this.dressUpKey;
            if (str2 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str2.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            Boolean bool = this.isDefaultAppearance;
            if (bool == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = bool.hashCode();
            }
            int i28 = (i27 + hashCode7) * 31;
            String str3 = this.firstEntryType;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i28 + i3;
        }

        @NotNull
        public String toString() {
            return "AvatarEditLeaveParam(entranceType=" + this.entranceType + ", loadedCnt=" + this.loadedCnt + ", localCacheCnt=" + this.localCacheCnt + ", cloudCacheCnt=" + this.cloudCacheCnt + ", localRecordCnt=" + this.localRecordCnt + ", dressUpKey=" + this.dressUpKey + ", isDefaultAppearance=" + this.isDefaultAppearance + ", firstEntryType=" + this.firstEntryType + ')';
        }

        public AvatarEditLeaveParam(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3) {
            this.entranceType = str;
            this.loadedCnt = num;
            this.localCacheCnt = num2;
            this.cloudCacheCnt = num3;
            this.localRecordCnt = num4;
            this.dressUpKey = str2;
            this.isDefaultAppearance = bool;
            this.firstEntryType = str3;
        }

        public /* synthetic */ AvatarEditLeaveParam(String str, Integer num, Integer num2, Integer num3, Integer num4, String str2, Boolean bool, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? ZPlanEditAvatarEntranceScene.UNKNOWN.getSourceString() : str, (i3 & 2) != 0 ? 0 : num, (i3 & 4) != 0 ? 0 : num2, (i3 & 8) != 0 ? 0 : num3, (i3 & 16) != 0 ? 0 : num4, (i3 & 32) != 0 ? "" : str2, (i3 & 64) != 0 ? Boolean.FALSE : bool, (i3 & 128) != 0 ? "-1" : str3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\t\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u0015\u0010\f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "loadingLvtm", "b", "c", "entranceType", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", "localCacheCnt", "d", "cloudCacheCnt", "e", h.F, "localRecordCnt", "dressUpKey", "Ljava/lang/Boolean;", "i", "()Ljava/lang/Boolean;", "isDefaultAppearance", "firstEntryType", "failReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class AvatarLoadingReportParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String loadingLvtm;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String entranceType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer localCacheCnt;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer cloudCacheCnt;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer localRecordCnt;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String dressUpKey;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Boolean isDefaultAppearance;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String firstEntryType;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String failReason;

        public AvatarLoadingReportParam() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Integer getCloudCacheCnt() {
            return this.cloudCacheCnt;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getDressUpKey() {
            return this.dressUpKey;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getEntranceType() {
            return this.entranceType;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getFailReason() {
            return this.failReason;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getFirstEntryType() {
            return this.firstEntryType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarLoadingReportParam)) {
                return false;
            }
            AvatarLoadingReportParam avatarLoadingReportParam = (AvatarLoadingReportParam) other;
            if (Intrinsics.areEqual(this.loadingLvtm, avatarLoadingReportParam.loadingLvtm) && Intrinsics.areEqual(this.entranceType, avatarLoadingReportParam.entranceType) && Intrinsics.areEqual(this.localCacheCnt, avatarLoadingReportParam.localCacheCnt) && Intrinsics.areEqual(this.cloudCacheCnt, avatarLoadingReportParam.cloudCacheCnt) && Intrinsics.areEqual(this.localRecordCnt, avatarLoadingReportParam.localRecordCnt) && Intrinsics.areEqual(this.dressUpKey, avatarLoadingReportParam.dressUpKey) && Intrinsics.areEqual(this.isDefaultAppearance, avatarLoadingReportParam.isDefaultAppearance) && Intrinsics.areEqual(this.firstEntryType, avatarLoadingReportParam.firstEntryType) && Intrinsics.areEqual(this.failReason, avatarLoadingReportParam.failReason)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getLoadingLvtm() {
            return this.loadingLvtm;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final Integer getLocalCacheCnt() {
            return this.localCacheCnt;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final Integer getLocalRecordCnt() {
            return this.localRecordCnt;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            int hashCode8;
            String str = this.loadingLvtm;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.entranceType;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Integer num = this.localCacheCnt;
            if (num == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = num.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Integer num2 = this.cloudCacheCnt;
            if (num2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = num2.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            Integer num3 = this.localRecordCnt;
            if (num3 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = num3.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str3 = this.dressUpKey;
            if (str3 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str3.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            Boolean bool = this.isDefaultAppearance;
            if (bool == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = bool.hashCode();
            }
            int i28 = (i27 + hashCode7) * 31;
            String str4 = this.firstEntryType;
            if (str4 == null) {
                hashCode8 = 0;
            } else {
                hashCode8 = str4.hashCode();
            }
            int i29 = (i28 + hashCode8) * 31;
            String str5 = this.failReason;
            if (str5 != null) {
                i3 = str5.hashCode();
            }
            return i29 + i3;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final Boolean getIsDefaultAppearance() {
            return this.isDefaultAppearance;
        }

        @NotNull
        public String toString() {
            return "AvatarLoadingReportParam(loadingLvtm=" + this.loadingLvtm + ", entranceType=" + this.entranceType + ", localCacheCnt=" + this.localCacheCnt + ", cloudCacheCnt=" + this.cloudCacheCnt + ", localRecordCnt=" + this.localRecordCnt + ", dressUpKey=" + this.dressUpKey + ", isDefaultAppearance=" + this.isDefaultAppearance + ", firstEntryType=" + this.firstEntryType + ", failReason=" + this.failReason + ')';
        }

        public AvatarLoadingReportParam(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str3, @Nullable Boolean bool, @Nullable String str4, @Nullable String str5) {
            this.loadingLvtm = str;
            this.entranceType = str2;
            this.localCacheCnt = num;
            this.cloudCacheCnt = num2;
            this.localRecordCnt = num3;
            this.dressUpKey = str3;
            this.isDefaultAppearance = bool;
            this.firstEntryType = str4;
            this.failReason = str5;
        }

        public /* synthetic */ AvatarLoadingReportParam(String str, String str2, Integer num, Integer num2, Integer num3, String str3, Boolean bool, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? ZPlanEditAvatarEntranceScene.UNKNOWN.getSourceString() : str2, (i3 & 4) != 0 ? 0 : num, (i3 & 8) != 0 ? 0 : num2, (i3 & 16) != 0 ? 0 : num3, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? Boolean.FALSE : bool, (i3 & 128) != 0 ? "-1" : str4, (i3 & 256) == 0 ? str5 : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "actionId", "b", "c", "backgroundUrl", "avatarMark", "d", "changeSource", "e", "f", "followDressElapse", "failReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.b$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class AvatarRenewReportParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String actionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String backgroundUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String avatarMark;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String changeSource;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String followDressElapse;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String failReason;

        public AvatarRenewReportParam() {
            this(null, null, null, null, null, null, 63, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getActionId() {
            return this.actionId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getAvatarMark() {
            return this.avatarMark;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getChangeSource() {
            return this.changeSource;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getFailReason() {
            return this.failReason;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarRenewReportParam)) {
                return false;
            }
            AvatarRenewReportParam avatarRenewReportParam = (AvatarRenewReportParam) other;
            if (Intrinsics.areEqual(this.actionId, avatarRenewReportParam.actionId) && Intrinsics.areEqual(this.backgroundUrl, avatarRenewReportParam.backgroundUrl) && Intrinsics.areEqual(this.avatarMark, avatarRenewReportParam.avatarMark) && Intrinsics.areEqual(this.changeSource, avatarRenewReportParam.changeSource) && Intrinsics.areEqual(this.followDressElapse, avatarRenewReportParam.followDressElapse) && Intrinsics.areEqual(this.failReason, avatarRenewReportParam.failReason)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getFollowDressElapse() {
            return this.followDressElapse;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            String str = this.actionId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.backgroundUrl;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.avatarMark;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.changeSource;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.followDressElapse;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str6 = this.failReason;
            if (str6 != null) {
                i3 = str6.hashCode();
            }
            return i26 + i3;
        }

        @NotNull
        public String toString() {
            return "AvatarRenewReportParam(actionId=" + this.actionId + ", backgroundUrl=" + this.backgroundUrl + ", avatarMark=" + this.avatarMark + ", changeSource=" + this.changeSource + ", followDressElapse=" + this.followDressElapse + ", failReason=" + this.failReason + ')';
        }

        public AvatarRenewReportParam(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            this.actionId = str;
            this.backgroundUrl = str2;
            this.avatarMark = str3;
            this.changeSource = str4;
            this.followDressElapse = str5;
            this.failReason = str6;
        }

        public /* synthetic */ AvatarRenewReportParam(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? "0" : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : str6);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/b$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "actionId", "b", "c", "backgroundUrl", "d", "entranceType", "avatarMark", "e", "failReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.b$d, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class AvatarSaveReportParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String actionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String backgroundUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String entranceType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String avatarMark;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String failReason;

        public AvatarSaveReportParam() {
            this(null, null, null, null, null, 31, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getActionId() {
            return this.actionId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getAvatarMark() {
            return this.avatarMark;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getEntranceType() {
            return this.entranceType;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getFailReason() {
            return this.failReason;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarSaveReportParam)) {
                return false;
            }
            AvatarSaveReportParam avatarSaveReportParam = (AvatarSaveReportParam) other;
            if (Intrinsics.areEqual(this.actionId, avatarSaveReportParam.actionId) && Intrinsics.areEqual(this.backgroundUrl, avatarSaveReportParam.backgroundUrl) && Intrinsics.areEqual(this.entranceType, avatarSaveReportParam.entranceType) && Intrinsics.areEqual(this.avatarMark, avatarSaveReportParam.avatarMark) && Intrinsics.areEqual(this.failReason, avatarSaveReportParam.failReason)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            String str = this.actionId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.backgroundUrl;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.entranceType;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.avatarMark;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.failReason;
            if (str5 != null) {
                i3 = str5.hashCode();
            }
            return i19 + i3;
        }

        @NotNull
        public String toString() {
            return "AvatarSaveReportParam(actionId=" + this.actionId + ", backgroundUrl=" + this.backgroundUrl + ", entranceType=" + this.entranceType + ", avatarMark=" + this.avatarMark + ", failReason=" + this.failReason + ')';
        }

        public AvatarSaveReportParam(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            this.actionId = str;
            this.backgroundUrl = str2;
            this.entranceType = str3;
            this.avatarMark = str4;
            this.failReason = str5;
        }

        public /* synthetic */ AvatarSaveReportParam(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? ZPlanEditAvatarEntranceScene.UNKNOWN.getSourceString() : str3, (i3 & 8) != 0 ? "0" : str4, (i3 & 16) != 0 ? null : str5);
        }
    }
}
