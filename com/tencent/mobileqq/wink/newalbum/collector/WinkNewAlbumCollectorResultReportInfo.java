package com.tencent.mobileqq.wink.newalbum.collector;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u0014\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u001a\u0012\b\b\u0002\u0010%\u001a\u00020\u001a\u0012\b\b\u0002\u0010)\u001a\u00020\u001a\u0012\b\b\u0002\u0010,\u001a\u00020\u001a\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\b\b\u0002\u00104\u001a\u00020\u0004\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\b\b\u0002\u00108\u001a\u00020\u0002\u0012\b\b\u0002\u0010>\u001a\u000209\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u00a2\u0006\u0004\bD\u0010EJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010)\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010,\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\n\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b5\u0010\u000eR\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0010\u0010\u0016\"\u0004\b7\u0010\u0018R\"\u0010>\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010:\u001a\u0004\b-\u0010;\"\u0004\b<\u0010=R\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b1\u0010\u0016\"\u0004\b?\u0010\u0018R\u0011\u0010A\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0016R\u0011\u0010B\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0016R\u0011\u0010C\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "k", "(I)V", "imageCount", "b", "j", ReportConstant.COSTREPORT_PREFIX, MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT, "Ljava/lang/String;", "g", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "storyID", "", "d", UserInfo.SEX_FEMALE, "getMinTextSimilarity", "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(F)V", "minTextSimilarity", "e", "getMaxTextSimilarity", "l", "maxTextSimilarity", "f", "getMinAestheticsSimilarity", "setMinAestheticsSimilarity", "minAestheticsSimilarity", "getMaxAestheticsSimilarity", "setMaxAestheticsSimilarity", "maxAestheticsSimilarity", tl.h.F, "getTotalAlbumCount", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "totalAlbumCount", "i", "getRepeatAlbumCount", DomainData.DOMAIN_NAME, "repeatAlbumCount", "setErrorCode", "errorCode", "setErrorDesc", "errorDesc", "", "[F", "()[F", "p", "([F)V", "textSimilaritys", "r", QCircleWeakNetReporter.KEY_TRACE_ID, "reportMediaCount", "reportSimilaritysDesc", "reportCollectorDesc", "<init>", "(IILjava/lang/String;FFFFIIILjava/lang/String;[FLjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.newalbum.collector.k, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumCollectorResultReportInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int imageCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int videoCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String storyID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private float minTextSimilarity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private float maxTextSimilarity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private float minAestheticsSimilarity;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private float maxAestheticsSimilarity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int totalAlbumCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int repeatAlbumCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int errorCode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String errorDesc;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private float[] textSimilaritys;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String traceID;

    public WinkNewAlbumCollectorResultReportInfo() {
        this(0, 0, null, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, null, null, null, InitSkin.DRAWABLE_COUNT, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getErrorDesc() {
        return this.errorDesc;
    }

    /* renamed from: c, reason: from getter */
    public final int getImageCount() {
        return this.imageCount;
    }

    @NotNull
    public final String d() {
        return this.minTextSimilarity + "|" + this.maxTextSimilarity + "|" + this.minAestheticsSimilarity + "|" + this.maxAestheticsSimilarity + "|" + this.totalAlbumCount + "|" + this.repeatAlbumCount;
    }

    @NotNull
    public final String e() {
        return this.imageCount + "|" + this.videoCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumCollectorResultReportInfo)) {
            return false;
        }
        WinkNewAlbumCollectorResultReportInfo winkNewAlbumCollectorResultReportInfo = (WinkNewAlbumCollectorResultReportInfo) other;
        if (this.imageCount == winkNewAlbumCollectorResultReportInfo.imageCount && this.videoCount == winkNewAlbumCollectorResultReportInfo.videoCount && Intrinsics.areEqual(this.storyID, winkNewAlbumCollectorResultReportInfo.storyID) && Float.compare(this.minTextSimilarity, winkNewAlbumCollectorResultReportInfo.minTextSimilarity) == 0 && Float.compare(this.maxTextSimilarity, winkNewAlbumCollectorResultReportInfo.maxTextSimilarity) == 0 && Float.compare(this.minAestheticsSimilarity, winkNewAlbumCollectorResultReportInfo.minAestheticsSimilarity) == 0 && Float.compare(this.maxAestheticsSimilarity, winkNewAlbumCollectorResultReportInfo.maxAestheticsSimilarity) == 0 && this.totalAlbumCount == winkNewAlbumCollectorResultReportInfo.totalAlbumCount && this.repeatAlbumCount == winkNewAlbumCollectorResultReportInfo.repeatAlbumCount && this.errorCode == winkNewAlbumCollectorResultReportInfo.errorCode && Intrinsics.areEqual(this.errorDesc, winkNewAlbumCollectorResultReportInfo.errorDesc) && Intrinsics.areEqual(this.textSimilaritys, winkNewAlbumCollectorResultReportInfo.textSimilaritys) && Intrinsics.areEqual(this.traceID, winkNewAlbumCollectorResultReportInfo.traceID)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        String joinToString$default;
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(this.textSimilaritys, (CharSequence) "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return joinToString$default;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getStoryID() {
        return this.storyID;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final float[] getTextSimilaritys() {
        return this.textSimilaritys;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.imageCount * 31) + this.videoCount) * 31) + this.storyID.hashCode()) * 31) + Float.floatToIntBits(this.minTextSimilarity)) * 31) + Float.floatToIntBits(this.maxTextSimilarity)) * 31) + Float.floatToIntBits(this.minAestheticsSimilarity)) * 31) + Float.floatToIntBits(this.maxAestheticsSimilarity)) * 31) + this.totalAlbumCount) * 31) + this.repeatAlbumCount) * 31) + this.errorCode) * 31) + this.errorDesc.hashCode()) * 31) + Arrays.hashCode(this.textSimilaritys)) * 31) + this.traceID.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getTraceID() {
        return this.traceID;
    }

    /* renamed from: j, reason: from getter */
    public final int getVideoCount() {
        return this.videoCount;
    }

    public final void k(int i3) {
        this.imageCount = i3;
    }

    public final void l(float f16) {
        this.maxTextSimilarity = f16;
    }

    public final void m(float f16) {
        this.minTextSimilarity = f16;
    }

    public final void n(int i3) {
        this.repeatAlbumCount = i3;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.storyID = str;
    }

    public final void p(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.textSimilaritys = fArr;
    }

    public final void q(int i3) {
        this.totalAlbumCount = i3;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceID = str;
    }

    public final void s(int i3) {
        this.videoCount = i3;
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumCollectorResultReportInfo(imageCount=" + this.imageCount + ", videoCount=" + this.videoCount + ", storyID=" + this.storyID + ", minTextSimilarity=" + this.minTextSimilarity + ", maxTextSimilarity=" + this.maxTextSimilarity + ", minAestheticsSimilarity=" + this.minAestheticsSimilarity + ", maxAestheticsSimilarity=" + this.maxAestheticsSimilarity + ", totalAlbumCount=" + this.totalAlbumCount + ", repeatAlbumCount=" + this.repeatAlbumCount + ", errorCode=" + this.errorCode + ", errorDesc=" + this.errorDesc + ", textSimilaritys=" + Arrays.toString(this.textSimilaritys) + ", traceID=" + this.traceID + ")";
    }

    public WinkNewAlbumCollectorResultReportInfo(int i3, int i16, @NotNull String storyID, float f16, float f17, float f18, float f19, int i17, int i18, int i19, @NotNull String errorDesc, @NotNull float[] textSimilaritys, @NotNull String traceID) {
        Intrinsics.checkNotNullParameter(storyID, "storyID");
        Intrinsics.checkNotNullParameter(errorDesc, "errorDesc");
        Intrinsics.checkNotNullParameter(textSimilaritys, "textSimilaritys");
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        this.imageCount = i3;
        this.videoCount = i16;
        this.storyID = storyID;
        this.minTextSimilarity = f16;
        this.maxTextSimilarity = f17;
        this.minAestheticsSimilarity = f18;
        this.maxAestheticsSimilarity = f19;
        this.totalAlbumCount = i17;
        this.repeatAlbumCount = i18;
        this.errorCode = i19;
        this.errorDesc = errorDesc;
        this.textSimilaritys = textSimilaritys;
        this.traceID = traceID;
    }

    public /* synthetic */ WinkNewAlbumCollectorResultReportInfo(int i3, int i16, String str, float f16, float f17, float f18, float f19, int i17, int i18, int i19, String str2, float[] fArr, String str3, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 0 : i3, (i26 & 2) != 0 ? 0 : i16, (i26 & 4) != 0 ? "" : str, (i26 & 8) != 0 ? 0.0f : f16, (i26 & 16) != 0 ? 0.0f : f17, (i26 & 32) != 0 ? 0.0f : f18, (i26 & 64) == 0 ? f19 : 0.0f, (i26 & 128) != 0 ? 0 : i17, (i26 & 256) != 0 ? 0 : i18, (i26 & 512) != 0 ? 0 : i19, (i26 & 1024) != 0 ? "" : str2, (i26 & 2048) != 0 ? new float[0] : fArr, (i26 & 4096) == 0 ? str3 : "");
    }
}
