package com.tencent.biz.richframework.download;

import com.tencent.biz.richframework.download.RFWDownloader;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001a\u0010)\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001a\u0010/\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R\u001c\u00102\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001aR\u001a\u00105\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\b\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/richframework/download/RFWDownloadInfo;", "", "()V", "connectTimeout", "", "getConnectTimeout", "()I", "setConnectTimeout", "(I)V", "downListener", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "getDownListener", "()Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "setDownListener", "(Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;)V", "downloadedLength", "", "getDownloadedLength", "()J", "setDownloadedLength", "(J)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "header", "", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "isSpecifyPath", "", "()Z", "setSpecifyPath", "(Z)V", "md5", "getMd5", "setMd5", "readTimeout", "getReadTimeout", "setReadTimeout", "tmpFilePath", "getTmpFilePath", "setTmpFilePath", "totalContentLength", "getTotalContentLength", "setTotalContentLength", "url", "getUrl", "setUrl", "writeTimeout", "getWriteTimeout", "setWriteTimeout", "download_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWDownloadInfo {
    private int connectTimeout;

    @Nullable
    private RFWDownloader.RFWDownloadListener downListener;
    private long downloadedLength;

    @Nullable
    private String filePath;

    @Nullable
    private Map<String, String> header;
    private boolean isSpecifyPath;

    @Nullable
    private String md5;
    private int readTimeout;

    @Nullable
    private String tmpFilePath;
    private long totalContentLength;

    @Nullable
    private String url;
    private int writeTimeout;

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    @Nullable
    public final RFWDownloader.RFWDownloadListener getDownListener() {
        return this.downListener;
    }

    public final long getDownloadedLength() {
        return this.downloadedLength;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final Map<String, String> getHeader() {
        return this.header;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    @Nullable
    public final String getTmpFilePath() {
        return this.tmpFilePath;
    }

    public final long getTotalContentLength() {
        return this.totalContentLength;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    /* renamed from: isSpecifyPath, reason: from getter */
    public final boolean getIsSpecifyPath() {
        return this.isSpecifyPath;
    }

    public final void setConnectTimeout(int i3) {
        this.connectTimeout = i3;
    }

    public final void setDownListener(@Nullable RFWDownloader.RFWDownloadListener rFWDownloadListener) {
        this.downListener = rFWDownloadListener;
    }

    public final void setDownloadedLength(long j3) {
        this.downloadedLength = j3;
    }

    public final void setFilePath(@Nullable String str) {
        this.filePath = str;
    }

    public final void setHeader(@Nullable Map<String, String> map) {
        this.header = map;
    }

    public final void setMd5(@Nullable String str) {
        this.md5 = str;
    }

    public final void setReadTimeout(int i3) {
        this.readTimeout = i3;
    }

    public final void setSpecifyPath(boolean z16) {
        this.isSpecifyPath = z16;
    }

    public final void setTmpFilePath(@Nullable String str) {
        this.tmpFilePath = str;
    }

    public final void setTotalContentLength(long j3) {
        this.totalContentLength = j3;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    public final void setWriteTimeout(int i3) {
        this.writeTimeout = i3;
    }
}
