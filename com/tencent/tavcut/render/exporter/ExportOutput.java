package com.tencent.tavcut.render.exporter;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Size;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.videocut.utils.n;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0002\u001d0B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bR\u001c\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010$R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010$R\u0016\u0010'\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010&R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010*R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010*R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/tavcut/render/exporter/ExportOutput;", "", "", "width", "height", "Lcom/tencent/tav/coremedia/CGSize;", "b", "dstMinSize", "d", "", "c", "Lcom/tencent/tav/core/ExportConfig;", "e", "level", "k", "", "fixOutputSize", h.F, "j", "f", "frameRate", "i", "videoBitRate", "l", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "g", "", "path", "a", "I", "sizeLevel$annotations", "()V", "sizeLevel", "Lcom/tencent/tav/coremedia/CGSize;", "outputSize", "Z", "highProfile", "Ljava/lang/String;", "outputVideoMimeType", "", "Ljava/nio/ByteBuffer;", "Ljava/util/Map;", "videoFormatBytes", "videoFormatInt", "videoFormatString", "<init>", "(II)V", "ResolutionLevel", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ExportOutput {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int sizeLevel = 300;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private CGSize outputSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int videoBitRate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int frameRate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean highProfile;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean fixOutputSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String outputVideoMimeType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Map<String, ByteBuffer> videoFormatBytes;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Integer> videoFormatInt;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> videoFormatString;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/tavcut/render/exporter/ExportOutput$ResolutionLevel;", "", "lib_tavcut_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes26.dex */
    public @interface ResolutionLevel {
    }

    public ExportOutput(int i3, int i16) {
        CGSize cGSize = CGSize.CGSizeZero;
        Intrinsics.checkExpressionValueIsNotNull(cGSize, "CGSize.CGSizeZero");
        this.outputSize = cGSize;
        this.frameRate = 30;
        this.outputVideoMimeType = "video/avc";
        this.videoFormatBytes = new LinkedHashMap();
        this.videoFormatInt = new LinkedHashMap();
        this.videoFormatString = new LinkedHashMap();
        this.outputSize = new CGSize(i3, i16);
    }

    private final CGSize b(int width, int height) {
        int i3 = this.sizeLevel;
        if (i3 != 100) {
            if (i3 != 150) {
                if (i3 != 200) {
                    if (i3 != 300) {
                        if (i3 != 400) {
                            if (i3 != 500) {
                                return d(width, height, 1080);
                            }
                            return d(width, height, com.tencent.tavcut.core.render.exporter.ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH);
                        }
                        return d(width, height, 1440);
                    }
                    return d(width, height, 1080);
                }
                return d(width, height, 720);
            }
            return d(width, height, 540);
        }
        return d(width, height, 480);
    }

    private final void c() {
        CGSize cGSize = this.outputSize;
        int min = Math.min((int) cGSize.width, (int) cGSize.height);
        if (min <= 720) {
            this.videoBitRate = 3145728;
            return;
        }
        if (min <= 960) {
            this.videoBitRate = 4194304;
            return;
        }
        if (min <= 1080) {
            this.videoBitRate = 5242880;
            return;
        }
        if (min < 1440) {
            this.videoBitRate = 8388608;
        } else if (min < 2160) {
            this.videoBitRate = 12582912;
        } else {
            this.videoBitRate = 16777216;
        }
    }

    private final CGSize d(int width, int height, int dstMinSize) {
        if (width < height) {
            int i3 = (dstMinSize * height) / width;
            if (i3 <= 3840) {
                Size a16 = n.f384256a.a(new Size(dstMinSize, i3), 3840);
                return new CGSize(a16.getWidth(), a16.getHeight());
            }
            Size a17 = n.f384256a.a(new Size((width * 3840) / height, 3840), 3840);
            return new CGSize(a17.getWidth(), a17.getHeight());
        }
        int i16 = (dstMinSize * width) / height;
        if (i16 <= 3840) {
            Size a18 = n.f384256a.a(new Size(i16, dstMinSize), 3840);
            return new CGSize(a18.getWidth(), a18.getHeight());
        }
        Size a19 = n.f384256a.a(new Size(3840, (height * 3840) / width), 3840);
        return new CGSize(a19.getWidth(), a19.getHeight());
    }

    public final int a(@Nullable String path) {
        boolean z16;
        boolean startsWith$default;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(path);
                int trackCount = mediaExtractor.getTrackCount();
                int i3 = 30;
                for (int i16 = 0; i16 < trackCount; i16++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i16);
                    String mime = trackFormat.getString("mime");
                    Intrinsics.checkExpressionValueIsNotNull(mime, "mime");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mime, "video/", false, 2, null);
                    if (startsWith$default && trackFormat.containsKey("frame-rate")) {
                        i3 = trackFormat.getInteger("frame-rate");
                    }
                }
                return i3;
            } catch (Exception e16) {
                e16.printStackTrace();
            } finally {
                mediaExtractor.release();
            }
        }
        return 30;
    }

    @NotNull
    public final ExportConfig e() {
        CGSize cGSize = this.outputSize;
        ExportConfig exportConfig = new ExportConfig((int) cGSize.width, (int) cGSize.height);
        exportConfig.setFixOutputSize(this.fixOutputSize);
        exportConfig.enableAVSync = true;
        exportConfig.setHighProfile(this.highProfile);
        exportConfig.setVideoBitRate(this.videoBitRate);
        exportConfig.setVideoFrameRate(this.frameRate);
        exportConfig.setVideoIFrameInterval(1);
        exportConfig.setOutputVideoMimeType(this.outputVideoMimeType);
        MediaFormat videoFormat = exportConfig.getVideoFormat();
        Intrinsics.checkExpressionValueIsNotNull(videoFormat, "config.videoFormat");
        for (Map.Entry<String, ByteBuffer> entry : this.videoFormatBytes.entrySet()) {
            videoFormat.setByteBuffer(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry2 : this.videoFormatInt.entrySet()) {
            videoFormat.setInteger(entry2.getKey(), entry2.getValue().intValue());
        }
        for (Map.Entry<String, String> entry3 : this.videoFormatString.entrySet()) {
            videoFormat.setString(entry3.getKey(), entry3.getValue());
        }
        return exportConfig;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final CGSize getOutputSize() {
        return this.outputSize;
    }

    public final int g(@NotNull RenderModel renderModel) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        if (renderModel.getClipsAssets() != null && (!renderModel.getClipsAssets().isEmpty())) {
            return a(renderModel.getClipsAssets().get(0).path);
        }
        return 30;
    }

    public final void h(boolean fixOutputSize) {
        this.fixOutputSize = fixOutputSize;
    }

    public final void i(int frameRate) {
        this.frameRate = frameRate;
    }

    public final void j(int width, int height) {
        this.outputSize = b(width, height);
        c();
    }

    public final void k(int level) {
        this.sizeLevel = level;
        CGSize cGSize = this.outputSize;
        j((int) cGSize.width, (int) cGSize.height);
    }

    public final void l(int videoBitRate) {
        this.videoBitRate = videoBitRate;
    }
}
