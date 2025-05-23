package com.tencent.state.square.bubblesetting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/bubblesetting/SkinUrls;", "", "statusBubbleUrl", "", "speakingBubbleUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getSpeakingBubbleUrl", "()Ljava/lang/String;", "getStatusBubbleUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SkinUrls {

    @SerializedName("speaking_bubble_url")
    private final String speakingBubbleUrl;

    @SerializedName("status_bubble_url")
    private final String statusBubbleUrl;

    public SkinUrls(String statusBubbleUrl, String speakingBubbleUrl) {
        Intrinsics.checkNotNullParameter(statusBubbleUrl, "statusBubbleUrl");
        Intrinsics.checkNotNullParameter(speakingBubbleUrl, "speakingBubbleUrl");
        this.statusBubbleUrl = statusBubbleUrl;
        this.speakingBubbleUrl = speakingBubbleUrl;
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatusBubbleUrl() {
        return this.statusBubbleUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSpeakingBubbleUrl() {
        return this.speakingBubbleUrl;
    }

    public final SkinUrls copy(String statusBubbleUrl, String speakingBubbleUrl) {
        Intrinsics.checkNotNullParameter(statusBubbleUrl, "statusBubbleUrl");
        Intrinsics.checkNotNullParameter(speakingBubbleUrl, "speakingBubbleUrl");
        return new SkinUrls(statusBubbleUrl, speakingBubbleUrl);
    }

    public final String getSpeakingBubbleUrl() {
        return this.speakingBubbleUrl;
    }

    public final String getStatusBubbleUrl() {
        return this.statusBubbleUrl;
    }

    public int hashCode() {
        String str = this.statusBubbleUrl;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.speakingBubbleUrl;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SkinUrls(statusBubbleUrl=" + this.statusBubbleUrl + ", speakingBubbleUrl=" + this.speakingBubbleUrl + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkinUrls)) {
            return false;
        }
        SkinUrls skinUrls = (SkinUrls) other;
        return Intrinsics.areEqual(this.statusBubbleUrl, skinUrls.statusBubbleUrl) && Intrinsics.areEqual(this.speakingBubbleUrl, skinUrls.speakingBubbleUrl);
    }

    public static /* synthetic */ SkinUrls copy$default(SkinUrls skinUrls, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = skinUrls.statusBubbleUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = skinUrls.speakingBubbleUrl;
        }
        return skinUrls.copy(str, str2);
    }
}
