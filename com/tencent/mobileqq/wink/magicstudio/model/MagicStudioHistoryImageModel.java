package com.tencent.mobileqq.wink.magicstudio.model;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001(B=\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u00c6\u0003JK\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioHistoryImageModel;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "", "component5", "", "component6", "imagePath", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IMAGE_MD_5, "compressedUrl", "cropFaceUrl", "latestUpdateTimeMs", "aigcOutputMediaPath", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getImagePath", "()Ljava/lang/String;", "getImageMd5", "getCompressedUrl", "getCropFaceUrl", "J", "getLatestUpdateTimeMs", "()J", "Ljava/util/List;", "getAigcOutputMediaPath", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "Companion", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MagicStudioHistoryImageModel implements Serializable {
    private static final long serialVersionUID = 123;

    @NotNull
    private final List<String> aigcOutputMediaPath;

    @NotNull
    private final String compressedUrl;

    @NotNull
    private final String cropFaceUrl;

    @NotNull
    private final String imageMd5;

    @NotNull
    private final String imagePath;
    private final long latestUpdateTimeMs;

    public MagicStudioHistoryImageModel(@NotNull String imagePath, @NotNull String imageMd5, @NotNull String compressedUrl, @NotNull String cropFaceUrl, long j3, @NotNull List<String> aigcOutputMediaPath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(imageMd5, "imageMd5");
        Intrinsics.checkNotNullParameter(compressedUrl, "compressedUrl");
        Intrinsics.checkNotNullParameter(cropFaceUrl, "cropFaceUrl");
        Intrinsics.checkNotNullParameter(aigcOutputMediaPath, "aigcOutputMediaPath");
        this.imagePath = imagePath;
        this.imageMd5 = imageMd5;
        this.compressedUrl = compressedUrl;
        this.cropFaceUrl = cropFaceUrl;
        this.latestUpdateTimeMs = j3;
        this.aigcOutputMediaPath = aigcOutputMediaPath;
    }

    public static /* synthetic */ MagicStudioHistoryImageModel copy$default(MagicStudioHistoryImageModel magicStudioHistoryImageModel, String str, String str2, String str3, String str4, long j3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = magicStudioHistoryImageModel.imagePath;
        }
        if ((i3 & 2) != 0) {
            str2 = magicStudioHistoryImageModel.imageMd5;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = magicStudioHistoryImageModel.compressedUrl;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = magicStudioHistoryImageModel.cropFaceUrl;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            j3 = magicStudioHistoryImageModel.latestUpdateTimeMs;
        }
        long j16 = j3;
        if ((i3 & 32) != 0) {
            list = magicStudioHistoryImageModel.aigcOutputMediaPath;
        }
        return magicStudioHistoryImageModel.copy(str, str5, str6, str7, j16, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getImageMd5() {
        return this.imageMd5;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCompressedUrl() {
        return this.compressedUrl;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getCropFaceUrl() {
        return this.cropFaceUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLatestUpdateTimeMs() {
        return this.latestUpdateTimeMs;
    }

    @NotNull
    public final List<String> component6() {
        return this.aigcOutputMediaPath;
    }

    @NotNull
    public final MagicStudioHistoryImageModel copy(@NotNull String imagePath, @NotNull String imageMd5, @NotNull String compressedUrl, @NotNull String cropFaceUrl, long latestUpdateTimeMs, @NotNull List<String> aigcOutputMediaPath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(imageMd5, "imageMd5");
        Intrinsics.checkNotNullParameter(compressedUrl, "compressedUrl");
        Intrinsics.checkNotNullParameter(cropFaceUrl, "cropFaceUrl");
        Intrinsics.checkNotNullParameter(aigcOutputMediaPath, "aigcOutputMediaPath");
        return new MagicStudioHistoryImageModel(imagePath, imageMd5, compressedUrl, cropFaceUrl, latestUpdateTimeMs, aigcOutputMediaPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MagicStudioHistoryImageModel)) {
            return false;
        }
        MagicStudioHistoryImageModel magicStudioHistoryImageModel = (MagicStudioHistoryImageModel) other;
        if (Intrinsics.areEqual(this.imagePath, magicStudioHistoryImageModel.imagePath) && Intrinsics.areEqual(this.imageMd5, magicStudioHistoryImageModel.imageMd5) && Intrinsics.areEqual(this.compressedUrl, magicStudioHistoryImageModel.compressedUrl) && Intrinsics.areEqual(this.cropFaceUrl, magicStudioHistoryImageModel.cropFaceUrl) && this.latestUpdateTimeMs == magicStudioHistoryImageModel.latestUpdateTimeMs && Intrinsics.areEqual(this.aigcOutputMediaPath, magicStudioHistoryImageModel.aigcOutputMediaPath)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> getAigcOutputMediaPath() {
        return this.aigcOutputMediaPath;
    }

    @NotNull
    public final String getCompressedUrl() {
        return this.compressedUrl;
    }

    @NotNull
    public final String getCropFaceUrl() {
        return this.cropFaceUrl;
    }

    @NotNull
    public final String getImageMd5() {
        return this.imageMd5;
    }

    @NotNull
    public final String getImagePath() {
        return this.imagePath;
    }

    public final long getLatestUpdateTimeMs() {
        return this.latestUpdateTimeMs;
    }

    public int hashCode() {
        return (((((((((this.imagePath.hashCode() * 31) + this.imageMd5.hashCode()) * 31) + this.compressedUrl.hashCode()) * 31) + this.cropFaceUrl.hashCode()) * 31) + androidx.fragment.app.a.a(this.latestUpdateTimeMs)) * 31) + this.aigcOutputMediaPath.hashCode();
    }

    @NotNull
    public String toString() {
        return "MagicStudioHistoryImageModel(imagePath=" + this.imagePath + ", imageMd5=" + this.imageMd5 + ", compressedUrl=" + this.compressedUrl + ", cropFaceUrl=" + this.cropFaceUrl + ", latestUpdateTimeMs=" + this.latestUpdateTimeMs + ", aigcOutputMediaPath=" + this.aigcOutputMediaPath + ")";
    }
}
