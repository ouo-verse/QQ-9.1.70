package com.tencent.mobileqq.zplan.easteregg;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/u;", "", "Lcom/tencent/mobileqq/zplan/easteregg/u$a;", "reportParam", "", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface u {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\t\u0010\fR\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/u$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "b", "I", "()I", "portraitId", "c", "portraitName", "e", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "friendUin", "", "f", "J", "()J", "i", "(J)V", "timeCost", "g", "Z", "()Z", tl.h.F, "(Z)V", "isRecorded", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JZ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.easteregg.u$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class EasterEggReportParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String senderUin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int portraitId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String portraitName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int sessionType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String friendUin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private long timeCost;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isRecorded;

        public EasterEggReportParam() {
            this(null, 0, null, 0, null, 0L, false, 127, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getFriendUin() {
            return this.friendUin;
        }

        /* renamed from: b, reason: from getter */
        public final int getPortraitId() {
            return this.portraitId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getPortraitName() {
            return this.portraitName;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getSenderUin() {
            return this.senderUin;
        }

        /* renamed from: e, reason: from getter */
        public final int getSessionType() {
            return this.sessionType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EasterEggReportParam)) {
                return false;
            }
            EasterEggReportParam easterEggReportParam = (EasterEggReportParam) other;
            if (Intrinsics.areEqual(this.senderUin, easterEggReportParam.senderUin) && this.portraitId == easterEggReportParam.portraitId && Intrinsics.areEqual(this.portraitName, easterEggReportParam.portraitName) && this.sessionType == easterEggReportParam.sessionType && Intrinsics.areEqual(this.friendUin, easterEggReportParam.friendUin) && this.timeCost == easterEggReportParam.timeCost && this.isRecorded == easterEggReportParam.isRecorded) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final long getTimeCost() {
            return this.timeCost;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsRecorded() {
            return this.isRecorded;
        }

        public final void h(boolean z16) {
            this.isRecorded = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            String str = this.senderUin;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int hashCode2 = ((((((((((hashCode * 31) + this.portraitId) * 31) + this.portraitName.hashCode()) * 31) + this.sessionType) * 31) + this.friendUin.hashCode()) * 31) + androidx.fragment.app.a.a(this.timeCost)) * 31;
            boolean z16 = this.isRecorded;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode2 + i3;
        }

        public final void i(long j3) {
            this.timeCost = j3;
        }

        @NotNull
        public String toString() {
            return "EasterEggReportParam(senderUin=" + this.senderUin + ", portraitId=" + this.portraitId + ", portraitName=" + this.portraitName + ", sessionType=" + this.sessionType + ", friendUin=" + this.friendUin + ", timeCost=" + this.timeCost + ", isRecorded=" + this.isRecorded + ')';
        }

        public EasterEggReportParam(@Nullable String str, int i3, @NotNull String portraitName, int i16, @NotNull String friendUin, long j3, boolean z16) {
            Intrinsics.checkNotNullParameter(portraitName, "portraitName");
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
            this.senderUin = str;
            this.portraitId = i3;
            this.portraitName = portraitName;
            this.sessionType = i16;
            this.friendUin = friendUin;
            this.timeCost = j3;
            this.isRecorded = z16;
        }

        public /* synthetic */ EasterEggReportParam(String str, int i3, String str2, int i16, String str3, long j3, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? -1 : i3, (i17 & 4) != 0 ? "" : str2, (i17 & 8) == 0 ? i16 : -1, (i17 & 16) == 0 ? str3 : "", (i17 & 32) != 0 ? 0L : j3, (i17 & 64) != 0 ? false : z16);
        }
    }

    void a(@NotNull EasterEggReportParam reportParam);
}
