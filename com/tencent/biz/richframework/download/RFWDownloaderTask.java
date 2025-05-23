package com.tencent.biz.richframework.download;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\u0006H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0004R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0004R\u001a\u0010!\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\n\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/richframework/download/RFWDownloaderTask;", "", "url", "", "(Ljava/lang/String;)V", "connectTimeout", "", "getConnectTimeout", "()I", "setConnectTimeout", "(I)V", "downloadListener", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "getDownloadListener", "()Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "setDownloadListener", "(Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;)V", "value", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "header", "", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "readTimeout", "getReadTimeout", "setReadTimeout", "getUrl", "setUrl", "writeTimeout", "getWriteTimeout", "setWriteTimeout", "component1", "copy", "equals", "", "other", "hashCode", "toString", "download_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final /* data */ class RFWDownloaderTask {
    private int connectTimeout;

    @Nullable
    private RFWDownloader.RFWDownloadListener downloadListener;

    @Nullable
    private String filePath;

    @Nullable
    private Map<String, String> header;
    private int readTimeout;

    @NotNull
    private String url;
    private int writeTimeout;

    public RFWDownloaderTask(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public static /* synthetic */ RFWDownloaderTask copy$default(RFWDownloaderTask rFWDownloaderTask, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = rFWDownloaderTask.url;
        }
        return rFWDownloaderTask.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final RFWDownloaderTask copy(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new RFWDownloaderTask(url);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof RFWDownloaderTask) || !Intrinsics.areEqual(this.url, ((RFWDownloaderTask) other).url)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    @Nullable
    public final RFWDownloader.RFWDownloadListener getDownloadListener() {
        return this.downloadListener;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final Map<String, String> getHeader() {
        return this.header;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public int hashCode() {
        String str = this.url;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final void setConnectTimeout(int i3) {
        this.connectTimeout = i3;
    }

    public final void setDownloadListener(@Nullable RFWDownloader.RFWDownloadListener rFWDownloadListener) {
        this.downloadListener = rFWDownloadListener;
    }

    public final void setFilePath(@Nullable String str) {
        if (new File(str).isDirectory()) {
            RFWLog.fatal("RFWDownloaderTask", RFWLog.USR, new Exception("cannot be a directory"));
        } else {
            this.filePath = str;
        }
    }

    public final void setHeader(@Nullable Map<String, String> map) {
        this.header = map;
    }

    public final void setReadTimeout(int i3) {
        this.readTimeout = i3;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void setWriteTimeout(int i3) {
        this.writeTimeout = i3;
    }

    @NotNull
    public String toString() {
        return "RFWDownloaderTask(url=" + this.url + ")";
    }
}
