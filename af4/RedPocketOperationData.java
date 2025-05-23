package af4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn4.TimiPicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\fR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \u00a8\u0006$"}, d2 = {"Laf4/e;", "Laf4/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "activityId", "b", "I", "()I", "activityState", "Lvn4/a;", "c", "Lvn4/a;", "e", "()Lvn4/a;", "initStatePicInfo", "d", "f", "participatedPicInfo", "anchorHintTxt", "audienceHintTxt", "", "g", "J", "()J", "progressFullTime", "<init>", "(Ljava/lang/String;ILvn4/a;Lvn4/a;Ljava/lang/String;Ljava/lang/String;J)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: af4.e, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class RedPocketOperationData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String activityId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int activityState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TimiPicInfo initStatePicInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TimiPicInfo participatedPicInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String anchorHintTxt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String audienceHintTxt;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final long progressFullTime;

    public RedPocketOperationData(@NotNull String activityId, int i3, @NotNull TimiPicInfo initStatePicInfo, @NotNull TimiPicInfo participatedPicInfo, @NotNull String anchorHintTxt, @NotNull String audienceHintTxt, long j3) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(initStatePicInfo, "initStatePicInfo");
        Intrinsics.checkNotNullParameter(participatedPicInfo, "participatedPicInfo");
        Intrinsics.checkNotNullParameter(anchorHintTxt, "anchorHintTxt");
        Intrinsics.checkNotNullParameter(audienceHintTxt, "audienceHintTxt");
        this.activityId = activityId;
        this.activityState = i3;
        this.initStatePicInfo = initStatePicInfo;
        this.participatedPicInfo = participatedPicInfo;
        this.anchorHintTxt = anchorHintTxt;
        this.audienceHintTxt = audienceHintTxt;
        this.progressFullTime = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: b, reason: from getter */
    public final int getActivityState() {
        return this.activityState;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAnchorHintTxt() {
        return this.anchorHintTxt;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAudienceHintTxt() {
        return this.audienceHintTxt;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final TimiPicInfo getInitStatePicInfo() {
        return this.initStatePicInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedPocketOperationData)) {
            return false;
        }
        RedPocketOperationData redPocketOperationData = (RedPocketOperationData) other;
        if (Intrinsics.areEqual(this.activityId, redPocketOperationData.activityId) && this.activityState == redPocketOperationData.activityState && Intrinsics.areEqual(this.initStatePicInfo, redPocketOperationData.initStatePicInfo) && Intrinsics.areEqual(this.participatedPicInfo, redPocketOperationData.participatedPicInfo) && Intrinsics.areEqual(this.anchorHintTxt, redPocketOperationData.anchorHintTxt) && Intrinsics.areEqual(this.audienceHintTxt, redPocketOperationData.audienceHintTxt) && this.progressFullTime == redPocketOperationData.progressFullTime) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final TimiPicInfo getParticipatedPicInfo() {
        return this.participatedPicInfo;
    }

    /* renamed from: g, reason: from getter */
    public final long getProgressFullTime() {
        return this.progressFullTime;
    }

    public int hashCode() {
        return (((((((((((this.activityId.hashCode() * 31) + this.activityState) * 31) + this.initStatePicInfo.hashCode()) * 31) + this.participatedPicInfo.hashCode()) * 31) + this.anchorHintTxt.hashCode()) * 31) + this.audienceHintTxt.hashCode()) * 31) + androidx.fragment.app.a.a(this.progressFullTime);
    }

    @NotNull
    public String toString() {
        return "RedPocketOperationData(activityId=" + this.activityId + ", activityState=" + this.activityState + ", initStatePicInfo=" + this.initStatePicInfo + ", participatedPicInfo=" + this.participatedPicInfo + ", anchorHintTxt=" + this.anchorHintTxt + ", audienceHintTxt=" + this.audienceHintTxt + ", progressFullTime=" + this.progressFullTime + ")";
    }
}
