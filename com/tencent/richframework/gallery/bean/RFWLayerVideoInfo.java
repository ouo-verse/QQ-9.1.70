package com.tencent.richframework.gallery.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(\u00a8\u00062"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerVideoInfo;", "Ljava/io/Serializable;", "()V", "cookies", "", "", "getCookies", "()Ljava/util/List;", "setCookies", "(Ljava/util/List;)V", "currentVideoUrl", "getCurrentVideoUrl", "()Ljava/lang/String;", "setCurrentVideoUrl", "(Ljava/lang/String;)V", "fileId", "getFileId", "setFileId", "httpHeader", "", "getHttpHeader", "()Ljava/util/Map;", "setHttpHeader", "(Ljava/util/Map;)V", "localPath", "getLocalPath", "setLocalPath", "normalVideoUrl", "getNormalVideoUrl", "setNormalVideoUrl", "playId", "getPlayId", "vecVideoUrl", "getVecVideoUrl", "setVecVideoUrl", "videoDurationSec", "", "getVideoDurationSec", "()I", "setVideoDurationSec", "(I)V", "videoHeight", "getVideoHeight", "setVideoHeight", "videoOriginUrl", "getVideoOriginUrl", "setVideoOriginUrl", "videoWidth", "getVideoWidth", "setVideoWidth", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerVideoInfo implements Serializable {

    @Nullable
    private List<String> cookies;
    public String currentVideoUrl;

    @Nullable
    private String fileId;

    @Nullable
    private Map<String, String> httpHeader;

    @Nullable
    private String localPath;

    @Nullable
    private String normalVideoUrl;

    @Nullable
    private List<String> vecVideoUrl;
    private int videoDurationSec;
    private int videoHeight;

    @Nullable
    private String videoOriginUrl;
    private int videoWidth;

    @Nullable
    public final List<String> getCookies() {
        return this.cookies;
    }

    @NotNull
    public final String getCurrentVideoUrl() {
        String str = this.currentVideoUrl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentVideoUrl");
        }
        return str;
    }

    @Nullable
    public final String getFileId() {
        return this.fileId;
    }

    @Nullable
    public final Map<String, String> getHttpHeader() {
        return this.httpHeader;
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    public final String getNormalVideoUrl() {
        return this.normalVideoUrl;
    }

    @Nullable
    public final String getPlayId() {
        if (!TextUtils.isEmpty(this.fileId)) {
            return this.fileId;
        }
        if (!TextUtils.isEmpty(this.localPath)) {
            return this.localPath;
        }
        if (!TextUtils.isEmpty(this.videoOriginUrl)) {
            return this.videoOriginUrl;
        }
        if (!TextUtils.isEmpty(this.normalVideoUrl)) {
            return this.normalVideoUrl;
        }
        String str = this.currentVideoUrl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentVideoUrl");
            return str;
        }
        return str;
    }

    @Nullable
    public final List<String> getVecVideoUrl() {
        return this.vecVideoUrl;
    }

    public final int getVideoDurationSec() {
        return this.videoDurationSec;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    @Nullable
    public final String getVideoOriginUrl() {
        return this.videoOriginUrl;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final void setCookies(@Nullable List<String> list) {
        this.cookies = list;
    }

    public final void setCurrentVideoUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentVideoUrl = str;
    }

    public final void setFileId(@Nullable String str) {
        this.fileId = str;
    }

    public final void setHttpHeader(@Nullable Map<String, String> map) {
        this.httpHeader = map;
    }

    public final void setLocalPath(@Nullable String str) {
        this.localPath = str;
    }

    public final void setNormalVideoUrl(@Nullable String str) {
        this.normalVideoUrl = str;
    }

    public final void setVecVideoUrl(@Nullable List<String> list) {
        this.vecVideoUrl = list;
    }

    public final void setVideoDurationSec(int i3) {
        this.videoDurationSec = i3;
    }

    public final void setVideoHeight(int i3) {
        this.videoHeight = i3;
    }

    public final void setVideoOriginUrl(@Nullable String str) {
        this.videoOriginUrl = str;
    }

    public final void setVideoWidth(int i3) {
        this.videoWidth = i3;
    }
}
