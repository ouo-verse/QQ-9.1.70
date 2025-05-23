package com.tencent.mobileqq.qqecommerce.base.video;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010$\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\"\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`0\u0012\b\b\u0002\u00108\u001a\u00020\u0007\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0019\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u000f\u0010\fR\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b\u001d\u0010&\"\u0004\b'\u0010(R\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010*\u001a\u0004\b\u001a\u0010+\"\u0004\b,\u0010-R>\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`08\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b\u0017\u00103\"\u0004\b4\u00105R\u0017\u00108\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b7\u0010\u001e\u001a\u0004\b\t\u0010 R\u0017\u00109\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b7\u0010\fR\u0017\u0010:\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b1\u0010 \u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/video/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "url", "", "b", "J", h.F, "()J", "startPosMs", "c", "f", "feedPb", "d", "getDurationMs", "durationMs", "e", "coverPicUrl", "coverLayerUrl", "g", "Z", "l", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "isPreload", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "()Lcom/tencent/mobileqq/pb/MessageMicro;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "stFeed", "I", "()I", "setFeedIndex", "(I)V", "feedIndex", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "j", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setDtReportInfo", "(Ljava/util/HashMap;)V", "dtReportInfo", "k", "adaptHeight", "vid", "useUrlAsId", "<init>", "(Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/pb/MessageMicro;ILjava/util/HashMap;ZLjava/lang/String;Z)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.base.video.c, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class ECVideoInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startPosMs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String feedPb;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long durationMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String coverPicUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String coverLayerUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isPreload;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private MessageMicro<?> stFeed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int feedIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> dtReportInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean adaptHeight;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final String vid;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean useUrlAsId;

    public ECVideoInfo(String url, long j3, String feedPb, long j16, String coverPicUrl, String coverLayerUrl, boolean z16, MessageMicro<?> messageMicro, int i3, HashMap<String, String> dtReportInfo, boolean z17, String vid, boolean z18) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        Intrinsics.checkNotNullParameter(coverPicUrl, "coverPicUrl");
        Intrinsics.checkNotNullParameter(coverLayerUrl, "coverLayerUrl");
        Intrinsics.checkNotNullParameter(dtReportInfo, "dtReportInfo");
        Intrinsics.checkNotNullParameter(vid, "vid");
        this.url = url;
        this.startPosMs = j3;
        this.feedPb = feedPb;
        this.durationMs = j16;
        this.coverPicUrl = coverPicUrl;
        this.coverLayerUrl = coverLayerUrl;
        this.isPreload = z16;
        this.stFeed = messageMicro;
        this.feedIndex = i3;
        this.dtReportInfo = dtReportInfo;
        this.adaptHeight = z17;
        this.vid = vid;
        this.useUrlAsId = z18;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAdaptHeight() {
        return this.adaptHeight;
    }

    /* renamed from: b, reason: from getter */
    public final String getCoverLayerUrl() {
        return this.coverLayerUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getCoverPicUrl() {
        return this.coverPicUrl;
    }

    public final HashMap<String, String> d() {
        return this.dtReportInfo;
    }

    /* renamed from: e, reason: from getter */
    public final int getFeedIndex() {
        return this.feedIndex;
    }

    /* renamed from: f, reason: from getter */
    public final String getFeedPb() {
        return this.feedPb;
    }

    public final MessageMicro<?> g() {
        return this.stFeed;
    }

    /* renamed from: h, reason: from getter */
    public final long getStartPosMs() {
        return this.startPosMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.url.hashCode() * 31) + com.tencent.aegiskmm.d.a(this.startPosMs)) * 31) + this.feedPb.hashCode()) * 31) + com.tencent.aegiskmm.d.a(this.durationMs)) * 31) + this.coverPicUrl.hashCode()) * 31) + this.coverLayerUrl.hashCode()) * 31;
        boolean z16 = this.isPreload;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        MessageMicro<?> messageMicro = this.stFeed;
        int hashCode2 = (((((i16 + (messageMicro == null ? 0 : messageMicro.hashCode())) * 31) + this.feedIndex) * 31) + this.dtReportInfo.hashCode()) * 31;
        boolean z17 = this.adaptHeight;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int hashCode3 = (((hashCode2 + i17) * 31) + this.vid.hashCode()) * 31;
        boolean z18 = this.useUrlAsId;
        return hashCode3 + (z18 ? 1 : z18 ? 1 : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getUseUrlAsId() {
        return this.useUrlAsId;
    }

    /* renamed from: k, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsPreload() {
        return this.isPreload;
    }

    public final void m(boolean z16) {
        this.isPreload = z16;
    }

    public final void n(MessageMicro<?> messageMicro) {
        this.stFeed = messageMicro;
    }

    public String toString() {
        return "ECVideoInfo(url='" + this.url + "', startPosMs=" + this.startPosMs + ", isPreload=" + this.isPreload + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECVideoInfo)) {
            return false;
        }
        ECVideoInfo eCVideoInfo = (ECVideoInfo) other;
        return Intrinsics.areEqual(this.url, eCVideoInfo.url) && this.startPosMs == eCVideoInfo.startPosMs && Intrinsics.areEqual(this.feedPb, eCVideoInfo.feedPb) && this.durationMs == eCVideoInfo.durationMs && Intrinsics.areEqual(this.coverPicUrl, eCVideoInfo.coverPicUrl) && Intrinsics.areEqual(this.coverLayerUrl, eCVideoInfo.coverLayerUrl) && this.isPreload == eCVideoInfo.isPreload && Intrinsics.areEqual(this.stFeed, eCVideoInfo.stFeed) && this.feedIndex == eCVideoInfo.feedIndex && Intrinsics.areEqual(this.dtReportInfo, eCVideoInfo.dtReportInfo) && this.adaptHeight == eCVideoInfo.adaptHeight && Intrinsics.areEqual(this.vid, eCVideoInfo.vid) && this.useUrlAsId == eCVideoInfo.useUrlAsId;
    }

    public /* synthetic */ ECVideoInfo(String str, long j3, String str2, long j16, String str3, String str4, boolean z16, MessageMicro messageMicro, int i3, HashMap hashMap, boolean z17, String str5, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, str2, j16, str3, str4, (i16 & 64) != 0 ? false : z16, (i16 & 128) != 0 ? null : messageMicro, i3, hashMap, (i16 & 1024) != 0 ? false : z17, (i16 & 2048) != 0 ? "" : str5, (i16 & 4096) != 0 ? false : z18);
    }
}
