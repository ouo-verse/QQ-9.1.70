package com.tencent.mobileqq.zootopia.download.normal;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadData;", "Ljava/io/Serializable;", "category", "", "url", "", "status", "progress", "", "size", "", "filePath", "(ILjava/lang/String;IFJLjava/lang/String;)V", "getCategory", "()I", "getFilePath", "()Ljava/lang/String;", HippyQQPagView.FunctionName.GET_PROGRESS, "()F", "getSize", "()J", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class FileDownloadData implements Serializable {
    private final int category;
    private final String filePath;
    private final float progress;
    private final long size;
    private final int status;
    private final String url;

    public FileDownloadData(int i3, String url, int i16, float f16, long j3, String filePath) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.category = i3;
        this.url = url;
        this.status = i16;
        this.progress = f16;
        this.size = j3;
        this.filePath = filePath;
    }

    /* renamed from: component1, reason: from getter */
    public final int getCategory() {
        return this.category;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    public final FileDownloadData copy(int category, String url, int status, float progress, long size, String filePath) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new FileDownloadData(category, url, status, progress, size, filePath);
    }

    public final int getCategory() {
        return this.category;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((((this.category * 31) + this.url.hashCode()) * 31) + this.status) * 31) + Float.floatToIntBits(this.progress)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.size)) * 31) + this.filePath.hashCode();
    }

    public String toString() {
        return "FileDownloadData(category=" + this.category + ", url=" + this.url + ", status=" + this.status + ", progress=" + this.progress + ", size=" + this.size + ", filePath=" + this.filePath + ")";
    }

    public static /* synthetic */ FileDownloadData copy$default(FileDownloadData fileDownloadData, int i3, String str, int i16, float f16, long j3, String str2, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = fileDownloadData.category;
        }
        if ((i17 & 2) != 0) {
            str = fileDownloadData.url;
        }
        String str3 = str;
        if ((i17 & 4) != 0) {
            i16 = fileDownloadData.status;
        }
        int i18 = i16;
        if ((i17 & 8) != 0) {
            f16 = fileDownloadData.progress;
        }
        float f17 = f16;
        if ((i17 & 16) != 0) {
            j3 = fileDownloadData.size;
        }
        long j16 = j3;
        if ((i17 & 32) != 0) {
            str2 = fileDownloadData.filePath;
        }
        return fileDownloadData.copy(i3, str3, i18, f17, j16, str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileDownloadData)) {
            return false;
        }
        FileDownloadData fileDownloadData = (FileDownloadData) other;
        return this.category == fileDownloadData.category && Intrinsics.areEqual(this.url, fileDownloadData.url) && this.status == fileDownloadData.status && Float.compare(this.progress, fileDownloadData.progress) == 0 && this.size == fileDownloadData.size && Intrinsics.areEqual(this.filePath, fileDownloadData.filePath);
    }
}
