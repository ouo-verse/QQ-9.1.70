package com.tencent.biz.qqcircle.immersive.redpacket.task;

import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketPreviewBean;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import feedcloud.FeedCloudDatacard$RedPocketCoverInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0010\u0010\u0018\"\u0004\b\u001c\u0010\u001aR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010&\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001f\u001a\u0004\b\n\u0010!\"\u0004\b%\u0010#R$\u0010,\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010(\u001a\u0004\b\u0015\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "e", "()J", "startTime", "Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;", "b", "Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;", "d", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;", "previewBean", "c", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "staticCoverPath", "i", "apngCoverPath", "Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "f", "()Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "k", "(Lcom/tencent/mobileqq/winkpublish/result/ImageResult;)V", "staticCover", tl.h.F, "apngCover", "Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "()Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "j", "(Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;)V", "coverInfo", "<init>", "(JLcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/winkpublish/result/ImageResult;Lcom/tencent/mobileqq/winkpublish/result/ImageResult;Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.redpacket.task.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class AddRedPacketCoverData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final QFSRedPacketPreviewBean previewBean;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String staticCoverPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String apngCoverPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private ImageResult staticCover;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private ImageResult apngCover;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private FeedCloudDatacard$RedPocketCoverInfo coverInfo;

    public AddRedPacketCoverData(long j3, @NotNull QFSRedPacketPreviewBean previewBean, @Nullable String str, @Nullable String str2, @Nullable ImageResult imageResult, @Nullable ImageResult imageResult2, @Nullable FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo) {
        Intrinsics.checkNotNullParameter(previewBean, "previewBean");
        this.startTime = j3;
        this.previewBean = previewBean;
        this.staticCoverPath = str;
        this.apngCoverPath = str2;
        this.staticCover = imageResult;
        this.apngCover = imageResult2;
        this.coverInfo = feedCloudDatacard$RedPocketCoverInfo;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final ImageResult getApngCover() {
        return this.apngCover;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getApngCoverPath() {
        return this.apngCoverPath;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final FeedCloudDatacard$RedPocketCoverInfo getCoverInfo() {
        return this.coverInfo;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final QFSRedPacketPreviewBean getPreviewBean() {
        return this.previewBean;
    }

    /* renamed from: e, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddRedPacketCoverData)) {
            return false;
        }
        AddRedPacketCoverData addRedPacketCoverData = (AddRedPacketCoverData) other;
        if (this.startTime == addRedPacketCoverData.startTime && Intrinsics.areEqual(this.previewBean, addRedPacketCoverData.previewBean) && Intrinsics.areEqual(this.staticCoverPath, addRedPacketCoverData.staticCoverPath) && Intrinsics.areEqual(this.apngCoverPath, addRedPacketCoverData.apngCoverPath) && Intrinsics.areEqual(this.staticCover, addRedPacketCoverData.staticCover) && Intrinsics.areEqual(this.apngCover, addRedPacketCoverData.apngCover) && Intrinsics.areEqual(this.coverInfo, addRedPacketCoverData.coverInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final ImageResult getStaticCover() {
        return this.staticCover;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getStaticCoverPath() {
        return this.staticCoverPath;
    }

    public final void h(@Nullable ImageResult imageResult) {
        this.apngCover = imageResult;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int a16 = ((androidx.fragment.app.a.a(this.startTime) * 31) + this.previewBean.hashCode()) * 31;
        String str = this.staticCoverPath;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        String str2 = this.apngCoverPath;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        ImageResult imageResult = this.staticCover;
        if (imageResult == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = imageResult.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        ImageResult imageResult2 = this.apngCover;
        if (imageResult2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = imageResult2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo = this.coverInfo;
        if (feedCloudDatacard$RedPocketCoverInfo != null) {
            i3 = feedCloudDatacard$RedPocketCoverInfo.hashCode();
        }
        return i19 + i3;
    }

    public final void i(@Nullable String str) {
        this.apngCoverPath = str;
    }

    public final void j(@Nullable FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo) {
        this.coverInfo = feedCloudDatacard$RedPocketCoverInfo;
    }

    public final void k(@Nullable ImageResult imageResult) {
        this.staticCover = imageResult;
    }

    public final void l(@Nullable String str) {
        this.staticCoverPath = str;
    }

    @NotNull
    public String toString() {
        return "AddRedPacketCoverData(startTime=" + this.startTime + ", previewBean=" + this.previewBean + ", staticCoverPath=" + this.staticCoverPath + ", apngCoverPath=" + this.apngCoverPath + ", staticCover=" + this.staticCover + ", apngCover=" + this.apngCover + ", coverInfo=" + this.coverInfo + ")";
    }

    public /* synthetic */ AddRedPacketCoverData(long j3, QFSRedPacketPreviewBean qFSRedPacketPreviewBean, String str, String str2, ImageResult imageResult, ImageResult imageResult2, FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, qFSRedPacketPreviewBean, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : imageResult, (i3 & 32) != 0 ? null : imageResult2, (i3 & 64) != 0 ? null : feedCloudDatacard$RedPocketCoverInfo);
    }
}
