package com.tencent.qcircle.weseevideo.model.resource;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.model.extra.ExtraInfoModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tBW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u00a2\u0006\u0002\u0010\u0016J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0006H\u00c6\u0003J\t\u00102\u001a\u00020\bH\u00c6\u0003J\t\u00103\u001a\u00020\rH\u00c6\u0003J\t\u00104\u001a\u00020\u000fH\u00c6\u0003J\t\u00105\u001a\u00020\u0011H\u00c6\u0003J\u0015\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u00c6\u0003J[\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u00c6\u0001J\u0006\u00108\u001a\u00020\u0000J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010<\u001a\u00020=H\u00d6\u0001J\t\u0010>\u001a\u00020\u0014H\u00d6\u0001R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u0006?"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "Ljava/io/Serializable;", "resource", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "(Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;)V", "videoConfiguration", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;", "audioConfiguration", "Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;", "(Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;)V", "videoConfigurationModel", "audioConfigurationModel", "extraInfoModel", "Lcom/tencent/qcircle/weseevideo/model/extra/ExtraInfoModel;", DownloadInfo.spKey_Config, "Lcom/tencent/qcircle/tavcut/bean/CropConfig;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", QQBrowserActivity.APP_PARAM, "", "", "", "(Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;Lcom/tencent/qcircle/weseevideo/model/extra/ExtraInfoModel;Lcom/tencent/qcircle/tavcut/bean/CropConfig;JLjava/util/Map;)V", "getAudioConfigurationModel", "()Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;", "setAudioConfigurationModel", "(Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;)V", "getConfig", "()Lcom/tencent/qcircle/tavcut/bean/CropConfig;", "setConfig", "(Lcom/tencent/qcircle/tavcut/bean/CropConfig;)V", "getExtraInfoModel", "()Lcom/tencent/qcircle/weseevideo/model/extra/ExtraInfoModel;", "extraParams$annotations", "()V", "getExtraParams", "()Ljava/util/Map;", "getResource", "()Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "setResource", "getUniqueId", "()J", "setUniqueId", "(J)V", "getVideoConfigurationModel", "()Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;", "setVideoConfigurationModel", "(Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "deepCopy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class MediaClipModel implements Serializable {

    @NotNull
    private AudioConfigurationModel audioConfigurationModel;

    @NotNull
    private CropConfig config;

    @NotNull
    private final ExtraInfoModel extraInfoModel;

    @NotNull
    private final transient Map<String, Object> extraParams;

    @NotNull
    private VideoResourceModel resource;
    private long uniqueId;

    @NotNull
    private VideoConfigurationModel videoConfigurationModel;

    public MediaClipModel() {
        this(null, null, null, null, null, 0L, null, 127, null);
    }

    public static /* synthetic */ MediaClipModel copy$default(MediaClipModel mediaClipModel, VideoResourceModel videoResourceModel, VideoConfigurationModel videoConfigurationModel, AudioConfigurationModel audioConfigurationModel, ExtraInfoModel extraInfoModel, CropConfig cropConfig, long j3, Map map, int i3, Object obj) {
        VideoResourceModel videoResourceModel2;
        VideoConfigurationModel videoConfigurationModel2;
        AudioConfigurationModel audioConfigurationModel2;
        ExtraInfoModel extraInfoModel2;
        CropConfig cropConfig2;
        long j16;
        Map map2;
        if ((i3 & 1) != 0) {
            videoResourceModel2 = mediaClipModel.resource;
        } else {
            videoResourceModel2 = videoResourceModel;
        }
        if ((i3 & 2) != 0) {
            videoConfigurationModel2 = mediaClipModel.videoConfigurationModel;
        } else {
            videoConfigurationModel2 = videoConfigurationModel;
        }
        if ((i3 & 4) != 0) {
            audioConfigurationModel2 = mediaClipModel.audioConfigurationModel;
        } else {
            audioConfigurationModel2 = audioConfigurationModel;
        }
        if ((i3 & 8) != 0) {
            extraInfoModel2 = mediaClipModel.extraInfoModel;
        } else {
            extraInfoModel2 = extraInfoModel;
        }
        if ((i3 & 16) != 0) {
            cropConfig2 = mediaClipModel.config;
        } else {
            cropConfig2 = cropConfig;
        }
        if ((i3 & 32) != 0) {
            j16 = mediaClipModel.uniqueId;
        } else {
            j16 = j3;
        }
        if ((i3 & 64) != 0) {
            map2 = mediaClipModel.extraParams;
        } else {
            map2 = map;
        }
        return mediaClipModel.copy(videoResourceModel2, videoConfigurationModel2, audioConfigurationModel2, extraInfoModel2, cropConfig2, j16, map2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final VideoResourceModel getResource() {
        return this.resource;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final VideoConfigurationModel getVideoConfigurationModel() {
        return this.videoConfigurationModel;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final AudioConfigurationModel getAudioConfigurationModel() {
        return this.audioConfigurationModel;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final ExtraInfoModel getExtraInfoModel() {
        return this.extraInfoModel;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final CropConfig getConfig() {
        return this.config;
    }

    /* renamed from: component6, reason: from getter */
    public final long getUniqueId() {
        return this.uniqueId;
    }

    @NotNull
    public final Map<String, Object> component7() {
        return this.extraParams;
    }

    @NotNull
    public final MediaClipModel copy(@NotNull VideoResourceModel resource, @NotNull VideoConfigurationModel videoConfigurationModel, @NotNull AudioConfigurationModel audioConfigurationModel, @NotNull ExtraInfoModel extraInfoModel, @NotNull CropConfig config, long uniqueId, @NotNull Map<String, ? extends Object> extraParams) {
        Intrinsics.checkParameterIsNotNull(resource, "resource");
        Intrinsics.checkParameterIsNotNull(videoConfigurationModel, "videoConfigurationModel");
        Intrinsics.checkParameterIsNotNull(audioConfigurationModel, "audioConfigurationModel");
        Intrinsics.checkParameterIsNotNull(extraInfoModel, "extraInfoModel");
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(extraParams, "extraParams");
        return new MediaClipModel(resource, videoConfigurationModel, audioConfigurationModel, extraInfoModel, config, uniqueId, extraParams);
    }

    @NotNull
    public final MediaClipModel deepCopy() {
        return new MediaClipModel(VideoResourceModel.copy$default(this.resource, null, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, InitSkin.DRAWABLE_COUNT, null), this.videoConfigurationModel.deepClone(), AudioConfigurationModel.copy$default(this.audioConfigurationModel, 0.0f, null, null, 7, null), ExtraInfoModel.copy$default(this.extraInfoModel, null, null, 3, null), null, this.uniqueId, null, 80, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MediaClipModel) {
                MediaClipModel mediaClipModel = (MediaClipModel) other;
                if (!Intrinsics.areEqual(this.resource, mediaClipModel.resource) || !Intrinsics.areEqual(this.videoConfigurationModel, mediaClipModel.videoConfigurationModel) || !Intrinsics.areEqual(this.audioConfigurationModel, mediaClipModel.audioConfigurationModel) || !Intrinsics.areEqual(this.extraInfoModel, mediaClipModel.extraInfoModel) || !Intrinsics.areEqual(this.config, mediaClipModel.config) || this.uniqueId != mediaClipModel.uniqueId || !Intrinsics.areEqual(this.extraParams, mediaClipModel.extraParams)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final AudioConfigurationModel getAudioConfigurationModel() {
        return this.audioConfigurationModel;
    }

    @NotNull
    public final CropConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final ExtraInfoModel getExtraInfoModel() {
        return this.extraInfoModel;
    }

    @NotNull
    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final VideoResourceModel getResource() {
        return this.resource;
    }

    public final long getUniqueId() {
        return this.uniqueId;
    }

    @NotNull
    public final VideoConfigurationModel getVideoConfigurationModel() {
        return this.videoConfigurationModel;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        VideoResourceModel videoResourceModel = this.resource;
        int i26 = 0;
        if (videoResourceModel != null) {
            i3 = videoResourceModel.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        VideoConfigurationModel videoConfigurationModel = this.videoConfigurationModel;
        if (videoConfigurationModel != null) {
            i16 = videoConfigurationModel.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        AudioConfigurationModel audioConfigurationModel = this.audioConfigurationModel;
        if (audioConfigurationModel != null) {
            i17 = audioConfigurationModel.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        ExtraInfoModel extraInfoModel = this.extraInfoModel;
        if (extraInfoModel != null) {
            i18 = extraInfoModel.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        CropConfig cropConfig = this.config;
        if (cropConfig != null) {
            i19 = cropConfig.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        long j3 = this.uniqueId;
        int i38 = (i37 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        Map<String, Object> map = this.extraParams;
        if (map != null) {
            i26 = map.hashCode();
        }
        return i38 + i26;
    }

    public final void setAudioConfigurationModel(@NotNull AudioConfigurationModel audioConfigurationModel) {
        Intrinsics.checkParameterIsNotNull(audioConfigurationModel, "<set-?>");
        this.audioConfigurationModel = audioConfigurationModel;
    }

    public final void setConfig(@NotNull CropConfig cropConfig) {
        Intrinsics.checkParameterIsNotNull(cropConfig, "<set-?>");
        this.config = cropConfig;
    }

    public final void setResource(@NotNull VideoResourceModel videoResourceModel) {
        Intrinsics.checkParameterIsNotNull(videoResourceModel, "<set-?>");
        this.resource = videoResourceModel;
    }

    public final void setUniqueId(long j3) {
        this.uniqueId = j3;
    }

    public final void setVideoConfigurationModel(@NotNull VideoConfigurationModel videoConfigurationModel) {
        Intrinsics.checkParameterIsNotNull(videoConfigurationModel, "<set-?>");
        this.videoConfigurationModel = videoConfigurationModel;
    }

    @NotNull
    public String toString() {
        return "MediaClipModel(resource=" + this.resource + ", videoConfigurationModel=" + this.videoConfigurationModel + ", audioConfigurationModel=" + this.audioConfigurationModel + ", extraInfoModel=" + this.extraInfoModel + ", config=" + this.config + ", uniqueId=" + this.uniqueId + ", extraParams=" + this.extraParams + ")";
    }

    public MediaClipModel(@NotNull VideoResourceModel resource, @NotNull VideoConfigurationModel videoConfigurationModel, @NotNull AudioConfigurationModel audioConfigurationModel, @NotNull ExtraInfoModel extraInfoModel, @NotNull CropConfig config, long j3, @NotNull Map<String, ? extends Object> extraParams) {
        Intrinsics.checkParameterIsNotNull(resource, "resource");
        Intrinsics.checkParameterIsNotNull(videoConfigurationModel, "videoConfigurationModel");
        Intrinsics.checkParameterIsNotNull(audioConfigurationModel, "audioConfigurationModel");
        Intrinsics.checkParameterIsNotNull(extraInfoModel, "extraInfoModel");
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(extraParams, "extraParams");
        this.resource = resource;
        this.videoConfigurationModel = videoConfigurationModel;
        this.audioConfigurationModel = audioConfigurationModel;
        this.extraInfoModel = extraInfoModel;
        this.config = config;
        this.uniqueId = j3;
        this.extraParams = extraParams;
    }

    public /* synthetic */ MediaClipModel(VideoResourceModel videoResourceModel, VideoConfigurationModel videoConfigurationModel, AudioConfigurationModel audioConfigurationModel, ExtraInfoModel extraInfoModel, CropConfig cropConfig, long j3, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new VideoResourceModel(null, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, InitSkin.DRAWABLE_COUNT, null) : videoResourceModel, (i3 & 2) != 0 ? new VideoConfigurationModel(0, null, 0.0f, 0.0f, null, null, 0, 127, null) : videoConfigurationModel, (i3 & 4) != 0 ? new AudioConfigurationModel(0.0f, null, null, 7, null) : audioConfigurationModel, (i3 & 8) != 0 ? new ExtraInfoModel(null, null, 3, null) : extraInfoModel, (i3 & 16) != 0 ? new CropConfig(0.0f, 0.0f, 1.0f, 1.0f) : cropConfig, (i3 & 32) != 0 ? System.currentTimeMillis() : j3, (i3 & 64) != 0 ? new HashMap() : map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaClipModel(@NotNull VideoResourceModel resource) {
        this(resource, new VideoConfigurationModel(0, null, 0.0f, 0.0f, null, null, 0, 127, null), new AudioConfigurationModel(0.0f, null, null, 7, null), new ExtraInfoModel(null, null, 3, null), null, 0L, 0 == true ? 1 : 0, 112, null);
        Intrinsics.checkParameterIsNotNull(resource, "resource");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaClipModel(@NotNull VideoResourceModel resource, @NotNull VideoConfigurationModel videoConfiguration, @NotNull AudioConfigurationModel audioConfiguration) {
        this(resource, videoConfiguration, audioConfiguration, new ExtraInfoModel(null, null, 3, null), null, 0L, null, 112, null);
        Intrinsics.checkParameterIsNotNull(resource, "resource");
        Intrinsics.checkParameterIsNotNull(videoConfiguration, "videoConfiguration");
        Intrinsics.checkParameterIsNotNull(audioConfiguration, "audioConfiguration");
    }

    @Deprecated(message = "you should add property directly")
    public static /* synthetic */ void extraParams$annotations() {
    }
}
