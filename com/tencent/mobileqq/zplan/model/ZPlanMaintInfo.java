package com.tencent.mobileqq.zplan.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0018\u001a\u00020\t\u00a2\u0006\u0004\b\u001c\u0010\u001dB\t\b\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/i;", "", "", "a", "b", "toString", "", "hashCode", "other", "", "equals", "mMainTitle", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "mSubTitle", "g", "Ljava/util/Date;", "mBeginTime", "Ljava/util/Date;", "c", "()Ljava/util/Date;", "mEndTime", "e", "mEnable", "Z", "d", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Z)V", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.model.i, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanMaintInfo {

    @SerializedName("beginTime")
    @Nullable
    private final Date mBeginTime;

    @SerializedName("enable")
    private final boolean mEnable;

    @SerializedName("endTime")
    @Nullable
    private final Date mEndTime;

    @SerializedName("mainTitle")
    @Nullable
    private final String mMainTitle;

    @SerializedName("subtitle")
    @Nullable
    private final String mSubTitle;

    public ZPlanMaintInfo(@Nullable String str, @Nullable String str2, @Nullable Date date, @Nullable Date date2, boolean z16) {
        this.mMainTitle = str;
        this.mSubTitle = str2;
        this.mBeginTime = date;
        this.mEndTime = date2;
        this.mEnable = z16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getMMainTitle() {
        return this.mMainTitle;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMSubTitle() {
        return this.mSubTitle;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Date getMBeginTime() {
        return this.mBeginTime;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getMEnable() {
        return this.mEnable;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Date getMEndTime() {
        return this.mEndTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanMaintInfo)) {
            return false;
        }
        ZPlanMaintInfo zPlanMaintInfo = (ZPlanMaintInfo) other;
        if (Intrinsics.areEqual(this.mMainTitle, zPlanMaintInfo.mMainTitle) && Intrinsics.areEqual(this.mSubTitle, zPlanMaintInfo.mSubTitle) && Intrinsics.areEqual(this.mBeginTime, zPlanMaintInfo.mBeginTime) && Intrinsics.areEqual(this.mEndTime, zPlanMaintInfo.mEndTime) && this.mEnable == zPlanMaintInfo.mEnable) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        return this.mMainTitle;
    }

    @Nullable
    public final String g() {
        return this.mSubTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.mMainTitle;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.mSubTitle;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Date date = this.mBeginTime;
        if (date == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = date.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Date date2 = this.mEndTime;
        if (date2 != null) {
            i3 = date2.hashCode();
        }
        int i19 = (i18 + i3) * 31;
        boolean z16 = this.mEnable;
        int i26 = z16;
        if (z16 != 0) {
            i26 = 1;
        }
        return i19 + i26;
    }

    @NotNull
    public String toString() {
        return "ZPlanMaintInfo(mMainTitle=" + this.mMainTitle + ", mSubTitle=" + this.mSubTitle + ", mBeginTime=" + this.mBeginTime + ", mEndTime=" + this.mEndTime + ", mEnable=" + this.mEnable + ')';
    }

    public ZPlanMaintInfo() {
        this("\u505c\u670d\u516c\u544a", "\u529f\u80fd\u7ef4\u62a4\u4e2d\uff0c\u656c\u8bf7\u671f\u5f85", null, null, true);
    }
}
