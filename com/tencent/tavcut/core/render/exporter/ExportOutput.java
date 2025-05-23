package com.tencent.tavcut.core.render.exporter;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Size;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.core.render.builder.light.LightRenderChainManager;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.videocut.utils.n;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 32\u00020\u0001:\u000234B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020\u0003J\u000e\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0015J\u0016\u0010+\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0003J\u0016\u0010,\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u0003J\u0016\u0010.\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010/\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0003J\u000e\u00102\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tencent/tavcut/core/render/exporter/ExportOutput;", "", "width", "", "height", "(II)V", "enableAudioEncodeAsync", "", "fixOutputSize", "frameRate", "highProfile", "outputSize", "Lcom/tencent/tav/coremedia/CGSize;", "outputVideoMimeType", "", "sizeLevel", "sizeLevel$annotations", "()V", "videoBitRate", "videoFormatBytes", "", "Ljava/nio/ByteBuffer;", "videoFormatInt", "videoFormatString", "calVideoFrameRate", "path", "calculateSize", "calculateVideoBitRate", "", "convertOutputSize", "dstMinSize", "convertToExportConfig", "Lcom/tencent/tav/core/ExportConfig;", "getOutputSize", "getVideoBitRate", "getVideoFrameRate", "renderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "setAudioEncodeAsync", "setFixOutputSize", "setFormatByteBuffer", "name", "value", "setFormatInteger", "setFormatString", "setFrameRate", "setOutputSize", "setOutputVideoMimeType", "setResolutionLevel", "level", "setVideoBitRate", "Companion", "ResolutionLevel", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class ExportOutput {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int FPS_24 = 24;
    public static final int FPS_25 = 25;
    public static final int FPS_30 = 30;
    public static final int FPS_50 = 50;
    public static final int FPS_60 = 60;

    @NotNull
    public static final String KEY_LEVEL_1080P = "1080P";

    @NotNull
    public static final String KEY_LEVEL_2K = "2K";

    @NotNull
    public static final String KEY_LEVEL_480P = "480P";

    @NotNull
    public static final String KEY_LEVEL_4K = "4K";

    @NotNull
    public static final String KEY_LEVEL_540P = "540P";

    @NotNull
    public static final String KEY_LEVEL_720P = "720P";
    public static final int LEVEL_1080P = 300;
    public static final int LEVEL_2K = 400;
    public static final int LEVEL_480P = 100;
    public static final int LEVEL_4K = 500;
    public static final int LEVEL_540P = 150;
    public static final int LEVEL_720P = 200;
    private static final int VALUE_LEVEL_1080P = 1080;
    private static final int VALUE_LEVEL_1440P = 1440;
    public static final int VALUE_LEVEL_1440P_MAX_LENGTH = 2560;
    private static final int VALUE_LEVEL_2560P = 2560;
    public static final int VALUE_LEVEL_2560P_MAX_LENGTH = 3840;
    private static final int VALUE_LEVEL_480P = 480;
    private static final int VALUE_LEVEL_540P = 540;
    private static final int VALUE_LEVEL_720P = 720;
    private static final int VALUE_MAX_VALUE = 3840;

    @NotNull
    public static final String VIDEO_MIME = "video/avc";
    private boolean enableAudioEncodeAsync;
    private boolean fixOutputSize;
    private int frameRate;
    private boolean highProfile;
    private CGSize outputSize;
    private String outputVideoMimeType;
    private int sizeLevel = 300;
    private int videoBitRate;
    private final Map<String, ByteBuffer> videoFormatBytes;
    private final Map<String, Integer> videoFormatInt;
    private final Map<String, String> videoFormatString;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/tavcut/core/render/exporter/ExportOutput$Companion;", "", "()V", "FPS_24", "", "FPS_25", "FPS_30", "FPS_50", "FPS_60", "KEY_LEVEL_1080P", "", "KEY_LEVEL_2K", "KEY_LEVEL_480P", "KEY_LEVEL_4K", "KEY_LEVEL_540P", "KEY_LEVEL_720P", "LEVEL_1080P", "LEVEL_2K", "LEVEL_480P", "LEVEL_4K", "LEVEL_540P", "LEVEL_720P", "VALUE_LEVEL_1080P", "VALUE_LEVEL_1440P", "VALUE_LEVEL_1440P_MAX_LENGTH", "VALUE_LEVEL_2560P", "VALUE_LEVEL_2560P_MAX_LENGTH", "VALUE_LEVEL_480P", "VALUE_LEVEL_540P", "VALUE_LEVEL_720P", "VALUE_MAX_VALUE", "VIDEO_MIME", "getResolutionLevelDescription", "level", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String getResolutionLevelDescription(int level) {
            if (level != 100) {
                if (level != 150) {
                    if (level != 200) {
                        if (level == 300) {
                            return ExportOutput.KEY_LEVEL_1080P;
                        }
                        if (level != 400) {
                            if (level != 500) {
                                return ExportOutput.KEY_LEVEL_1080P;
                            }
                            return ExportOutput.KEY_LEVEL_4K;
                        }
                        return ExportOutput.KEY_LEVEL_2K;
                    }
                    return ExportOutput.KEY_LEVEL_720P;
                }
                return ExportOutput.KEY_LEVEL_540P;
            }
            return ExportOutput.KEY_LEVEL_480P;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/tavcut/core/render/exporter/ExportOutput$ResolutionLevel;", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
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

    private final CGSize calculateSize(int width, int height) {
        int i3 = this.sizeLevel;
        if (i3 != 100) {
            if (i3 != 150) {
                if (i3 != 200) {
                    if (i3 != 300) {
                        if (i3 != 400) {
                            if (i3 != 500) {
                                return convertOutputSize(width, height, 1080);
                            }
                            return convertOutputSize(width, height, 2560);
                        }
                        return convertOutputSize(width, height, 1440);
                    }
                    return convertOutputSize(width, height, 1080);
                }
                return convertOutputSize(width, height, 720);
            }
            return convertOutputSize(width, height, VALUE_LEVEL_540P);
        }
        return convertOutputSize(width, height, 480);
    }

    private final void calculateVideoBitRate() {
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

    private final CGSize convertOutputSize(int width, int height, int dstMinSize) {
        if (height != 0 && width != 0) {
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
        CGSize cGSize = CGSize.CGSizeZero;
        Intrinsics.checkExpressionValueIsNotNull(cGSize, "CGSize.CGSizeZero");
        return cGSize;
    }

    public final int calVideoFrameRate(@Nullable String path) {
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
    public final ExportConfig convertToExportConfig() {
        CGSize cGSize = this.outputSize;
        ExportConfig exportConfig = new ExportConfig((int) cGSize.width, (int) cGSize.height);
        exportConfig.setFixOutputSize(this.fixOutputSize);
        exportConfig.enableAVSync = true;
        exportConfig.setHighProfile(this.highProfile);
        exportConfig.setVideoBitRate(this.videoBitRate);
        exportConfig.setVideoFrameRate(this.frameRate);
        exportConfig.setVideoIFrameInterval(1);
        exportConfig.setOutputVideoMimeType(this.outputVideoMimeType);
        exportConfig.setAudioChannelCount(1);
        exportConfig.setAudioSampleCount(LightRenderChainManager.AUDIO_SAMPLE_COUNT);
        exportConfig.setAudioEncodeAsync(Boolean.valueOf(this.enableAudioEncodeAsync));
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
    public final CGSize getOutputSize() {
        return this.outputSize;
    }

    public final int getVideoBitRate() {
        return this.videoBitRate;
    }

    public final int getVideoFrameRate(@NotNull LAKRenderModel renderModel) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        if (!renderModel.getClipsAssets().isEmpty()) {
            return calVideoFrameRate(renderModel.getClipsAssets().get(0).getPath());
        }
        return 30;
    }

    public final void setAudioEncodeAsync(boolean enableAudioEncodeAsync) {
        this.enableAudioEncodeAsync = enableAudioEncodeAsync;
    }

    public final void setFixOutputSize(boolean fixOutputSize) {
        this.fixOutputSize = fixOutputSize;
    }

    public final void setFormatByteBuffer(@NotNull String name, @NotNull ByteBuffer value) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.videoFormatBytes.put(name, value);
    }

    public final void setFormatInteger(@NotNull String name, int value) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.videoFormatInt.put(name, Integer.valueOf(value));
    }

    public final void setFormatString(@NotNull String name, @NotNull String value) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.videoFormatString.put(name, value);
    }

    public final void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    public final void setOutputSize(int width, int height) {
        this.outputSize = calculateSize(width, height);
        calculateVideoBitRate();
    }

    public final void setOutputVideoMimeType(@NotNull String outputVideoMimeType) {
        Intrinsics.checkParameterIsNotNull(outputVideoMimeType, "outputVideoMimeType");
        this.outputVideoMimeType = outputVideoMimeType;
    }

    public final void setResolutionLevel(int level) {
        this.sizeLevel = level;
        CGSize cGSize = this.outputSize;
        setOutputSize((int) cGSize.width, (int) cGSize.height);
    }

    public final void setVideoBitRate(int videoBitRate) {
        this.videoBitRate = videoBitRate;
    }

    private static /* synthetic */ void sizeLevel$annotations() {
    }
}
