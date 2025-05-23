package com.tencent.mobileqq.wink.picker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/e;", "", "", "useVideoTemplate", "isVideoTemplatePreLoad", "", "templateJsAsset", "a", "toString", "", "hashCode", "other", "equals", "Z", "d", "()Z", "b", "e", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "<init>", "(ZZLjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.picker.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class VideoTemplateData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean useVideoTemplate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isVideoTemplatePreLoad;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String templateJsAsset;

    public VideoTemplateData(boolean z16, boolean z17, @Nullable String str) {
        this.useVideoTemplate = z16;
        this.isVideoTemplatePreLoad = z17;
        this.templateJsAsset = str;
    }

    public static /* synthetic */ VideoTemplateData b(VideoTemplateData videoTemplateData, boolean z16, boolean z17, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = videoTemplateData.useVideoTemplate;
        }
        if ((i3 & 2) != 0) {
            z17 = videoTemplateData.isVideoTemplatePreLoad;
        }
        if ((i3 & 4) != 0) {
            str = videoTemplateData.templateJsAsset;
        }
        return videoTemplateData.a(z16, z17, str);
    }

    @NotNull
    public final VideoTemplateData a(boolean useVideoTemplate, boolean isVideoTemplatePreLoad, @Nullable String templateJsAsset) {
        return new VideoTemplateData(useVideoTemplate, isVideoTemplatePreLoad, templateJsAsset);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getTemplateJsAsset() {
        return this.templateJsAsset;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getUseVideoTemplate() {
        return this.useVideoTemplate;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsVideoTemplatePreLoad() {
        return this.isVideoTemplatePreLoad;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoTemplateData)) {
            return false;
        }
        VideoTemplateData videoTemplateData = (VideoTemplateData) other;
        if (this.useVideoTemplate == videoTemplateData.useVideoTemplate && this.isVideoTemplatePreLoad == videoTemplateData.isVideoTemplatePreLoad && Intrinsics.areEqual(this.templateJsAsset, videoTemplateData.templateJsAsset)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.useVideoTemplate;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.isVideoTemplatePreLoad;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i17 = (i16 + i3) * 31;
        String str = this.templateJsAsset;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return i17 + hashCode;
    }

    @NotNull
    public String toString() {
        return "VideoTemplateData(useVideoTemplate=" + this.useVideoTemplate + ", isVideoTemplatePreLoad=" + this.isVideoTemplatePreLoad + ", templateJsAsset=" + this.templateJsAsset + ")";
    }

    public /* synthetic */ VideoTemplateData(boolean z16, boolean z17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? null : str);
    }
}
