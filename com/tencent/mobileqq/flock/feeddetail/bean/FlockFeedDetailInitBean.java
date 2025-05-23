package com.tencent.mobileqq.flock.feeddetail.bean;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.flock.base.FlockInitBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00014BY\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\u0004\b1\u00102J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\f\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\r\u001a\u00020\u000bH\u00c6\u0003J_\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000bH\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0011\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b$\u0010#R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b(\u0010\u001fR\u0017\u0010\u0014\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0015\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b,\u0010+R\u0013\u00100\u001a\u0004\u0018\u00010-8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/bean/FlockFeedDetailInitBean;", "Lcom/tencent/mobileqq/flock/base/FlockInitBean;", "", "component1", "component2", "", "component3", "component4", "", "component5", "component6", "", "component7", "component8", "userId", "feedId", WadlProxyConsts.CREATE_TIME, "groupId", "feedBytes", "eUid", "sourceEntranceType", "subSourceId", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "getFeedId", "J", "getCreateTime", "()J", "getGroupId", "[B", "getFeedBytes", "()[B", "getEUid", "I", "getSourceEntranceType", "()I", "getSubSourceId", "Ly45/b;", "getFeed", "()Ly45/b;", "feed", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ[BLjava/lang/String;II)V", "Companion", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class FlockFeedDetailInitBean extends FlockInitBean {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final long createTime;

    @Nullable
    private final String eUid;

    @Nullable
    private final byte[] feedBytes;

    @NotNull
    private final String feedId;
    private final long groupId;
    private final int sourceEntranceType;
    private final int subSourceId;

    @Nullable
    private final String userId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/bean/FlockFeedDetailInitBean$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feeddetail.bean.FlockFeedDetailInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ FlockFeedDetailInitBean(String str, String str2, long j3, long j16, byte[] bArr, String str3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : str, str2, j3, (i17 & 8) != 0 ? 0L : j16, (i17 & 16) != 0 ? null : bArr, (i17 & 32) != 0 ? null : str3, (i17 & 64) != 0 ? 0 : i3, (i17 & 128) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3), Long.valueOf(j16), bArr, str3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    public static /* synthetic */ FlockFeedDetailInitBean copy$default(FlockFeedDetailInitBean flockFeedDetailInitBean, String str, String str2, long j3, long j16, byte[] bArr, String str3, int i3, int i16, int i17, Object obj) {
        String str4;
        String str5;
        long j17;
        long j18;
        byte[] bArr2;
        String str6;
        int i18;
        int i19;
        if ((i17 & 1) != 0) {
            str4 = flockFeedDetailInitBean.userId;
        } else {
            str4 = str;
        }
        if ((i17 & 2) != 0) {
            str5 = flockFeedDetailInitBean.feedId;
        } else {
            str5 = str2;
        }
        if ((i17 & 4) != 0) {
            j17 = flockFeedDetailInitBean.createTime;
        } else {
            j17 = j3;
        }
        if ((i17 & 8) != 0) {
            j18 = flockFeedDetailInitBean.groupId;
        } else {
            j18 = j16;
        }
        if ((i17 & 16) != 0) {
            bArr2 = flockFeedDetailInitBean.feedBytes;
        } else {
            bArr2 = bArr;
        }
        if ((i17 & 32) != 0) {
            str6 = flockFeedDetailInitBean.eUid;
        } else {
            str6 = str3;
        }
        if ((i17 & 64) != 0) {
            i18 = flockFeedDetailInitBean.sourceEntranceType;
        } else {
            i18 = i3;
        }
        if ((i17 & 128) != 0) {
            i19 = flockFeedDetailInitBean.subSourceId;
        } else {
            i19 = i16;
        }
        return flockFeedDetailInitBean.copy(str4, str5, j17, j18, bArr2, str6, i18, i19);
    }

    @Nullable
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.userId;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.feedId;
    }

    public final long component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.createTime;
    }

    public final long component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.groupId;
    }

    @Nullable
    public final byte[] component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (byte[]) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.feedBytes;
    }

    @Nullable
    public final String component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.eUid;
    }

    public final int component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.sourceEntranceType;
    }

    public final int component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.subSourceId;
    }

    @NotNull
    public final FlockFeedDetailInitBean copy(@Nullable String userId, @NotNull String feedId, long createTime, long groupId, @Nullable byte[] feedBytes, @Nullable String eUid, int sourceEntranceType, int subSourceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (FlockFeedDetailInitBean) iPatchRedirector.redirect((short) 20, this, userId, feedId, Long.valueOf(createTime), Long.valueOf(groupId), feedBytes, eUid, Integer.valueOf(sourceEntranceType), Integer.valueOf(subSourceId));
        }
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return new FlockFeedDetailInitBean(userId, feedId, createTime, groupId, feedBytes, eUid, sourceEntranceType, subSourceId);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlockFeedDetailInitBean)) {
            return false;
        }
        FlockFeedDetailInitBean flockFeedDetailInitBean = (FlockFeedDetailInitBean) other;
        if (Intrinsics.areEqual(this.userId, flockFeedDetailInitBean.userId) && Intrinsics.areEqual(this.feedId, flockFeedDetailInitBean.feedId) && this.createTime == flockFeedDetailInitBean.createTime && this.groupId == flockFeedDetailInitBean.groupId && Intrinsics.areEqual(this.feedBytes, flockFeedDetailInitBean.feedBytes) && Intrinsics.areEqual(this.eUid, flockFeedDetailInitBean.eUid) && this.sourceEntranceType == flockFeedDetailInitBean.sourceEntranceType && this.subSourceId == flockFeedDetailInitBean.subSourceId) {
            return true;
        }
        return false;
    }

    public final long getCreateTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.createTime;
    }

    @Nullable
    public final String getEUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.eUid;
    }

    @Nullable
    public final y45.b getFeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (y45.b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        try {
            byte[] bArr = this.feedBytes;
            if (bArr == null) {
                return null;
            }
            return y45.b.d(bArr);
        } catch (Exception e16) {
            RFWLog.fatal("FlockFeedDetailInitBean", RFWLog.USR, e16);
            return null;
        }
    }

    @Nullable
    public final byte[] getFeedBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.feedBytes;
    }

    @NotNull
    public final String getFeedId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.feedId;
    }

    public final long getGroupId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.groupId;
    }

    public final int getSourceEntranceType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.sourceEntranceType;
    }

    public final int getSubSourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.subSourceId;
    }

    @Nullable
    public final String getUserId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.userId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        String str = this.userId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = ((((((hashCode * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTime)) * 31) + androidx.fragment.app.a.a(this.groupId)) * 31;
        byte[] bArr = this.feedBytes;
        if (bArr == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = Arrays.hashCode(bArr);
        }
        int i16 = (hashCode3 + hashCode2) * 31;
        String str2 = this.eUid;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((((i16 + i3) * 31) + this.sourceEntranceType) * 31) + this.subSourceId;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "FlockFeedDetailInitBean(userId=" + this.userId + ", feedId=" + this.feedId + ", createTime=" + this.createTime + ", groupId=" + this.groupId + ", feedBytes=" + Arrays.toString(this.feedBytes) + ", eUid=" + this.eUid + ", sourceEntranceType=" + this.sourceEntranceType + ", subSourceId=" + this.subSourceId + ")";
    }

    public FlockFeedDetailInitBean(@Nullable String str, @NotNull String feedId, long j3, long j16, @Nullable byte[] bArr, @Nullable String str2, int i3, int i16) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, feedId, Long.valueOf(j3), Long.valueOf(j16), bArr, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.userId = str;
        this.feedId = feedId;
        this.createTime = j3;
        this.groupId = j16;
        this.feedBytes = bArr;
        this.eUid = str2;
        this.sourceEntranceType = i3;
        this.subSourceId = i16;
    }
}
