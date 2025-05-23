package com.qzone.proxy.feedcomponent.model;

import com.tencent.ark.ark;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "sealTransfer", "b", "xsjFeedType1", "c", "xsjFeedType2", "d", "xsjFeedType3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.proxy.feedcomponent.model.d, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CircleReportData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String sealTransfer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String xsjFeedType1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String xsjFeedType2;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String xsjFeedType3;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/d$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/qzone/proxy/feedcomponent/model/d;", "a", "", "FEED_TYPE_1", "Ljava/lang/String;", "FEED_TYPE_2", "FEED_TYPE_3", "SEAL_TRANSFER", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.proxy.feedcomponent.model.d$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CircleReportData a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String sealTransfer = json.optString(QCircleLpReportDc05507.KEY_SEAL_TRANSFER);
            String feedType1 = json.optString("feed_type_1");
            String feedType2 = json.optString("feed_type_2");
            String feedType3 = json.optString("feed_type_3");
            Intrinsics.checkNotNullExpressionValue(sealTransfer, "sealTransfer");
            Intrinsics.checkNotNullExpressionValue(feedType1, "feedType1");
            Intrinsics.checkNotNullExpressionValue(feedType2, "feedType2");
            Intrinsics.checkNotNullExpressionValue(feedType3, "feedType3");
            return new CircleReportData(sealTransfer, feedType1, feedType2, feedType3);
        }

        Companion() {
        }
    }

    public CircleReportData(String sealTransfer, String xsjFeedType1, String xsjFeedType2, String xsjFeedType3) {
        Intrinsics.checkNotNullParameter(sealTransfer, "sealTransfer");
        Intrinsics.checkNotNullParameter(xsjFeedType1, "xsjFeedType1");
        Intrinsics.checkNotNullParameter(xsjFeedType2, "xsjFeedType2");
        Intrinsics.checkNotNullParameter(xsjFeedType3, "xsjFeedType3");
        this.sealTransfer = sealTransfer;
        this.xsjFeedType1 = xsjFeedType1;
        this.xsjFeedType2 = xsjFeedType2;
        this.xsjFeedType3 = xsjFeedType3;
    }

    /* renamed from: a, reason: from getter */
    public final String getSealTransfer() {
        return this.sealTransfer;
    }

    /* renamed from: b, reason: from getter */
    public final String getXsjFeedType1() {
        return this.xsjFeedType1;
    }

    /* renamed from: c, reason: from getter */
    public final String getXsjFeedType2() {
        return this.xsjFeedType2;
    }

    /* renamed from: d, reason: from getter */
    public final String getXsjFeedType3() {
        return this.xsjFeedType3;
    }

    public int hashCode() {
        return (((((this.sealTransfer.hashCode() * 31) + this.xsjFeedType1.hashCode()) * 31) + this.xsjFeedType2.hashCode()) * 31) + this.xsjFeedType3.hashCode();
    }

    public String toString() {
        return "CircleReportData(sealTransfer=" + this.sealTransfer + ", xsjFeedType1=" + this.xsjFeedType1 + ", xsjFeedType2=" + this.xsjFeedType2 + ", xsjFeedType3=" + this.xsjFeedType3 + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CircleReportData)) {
            return false;
        }
        CircleReportData circleReportData = (CircleReportData) other;
        return Intrinsics.areEqual(this.sealTransfer, circleReportData.sealTransfer) && Intrinsics.areEqual(this.xsjFeedType1, circleReportData.xsjFeedType1) && Intrinsics.areEqual(this.xsjFeedType2, circleReportData.xsjFeedType2) && Intrinsics.areEqual(this.xsjFeedType3, circleReportData.xsjFeedType3);
    }
}
