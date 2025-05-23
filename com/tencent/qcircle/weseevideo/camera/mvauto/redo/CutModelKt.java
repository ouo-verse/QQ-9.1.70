package com.tencent.qcircle.weseevideo.camera.mvauto.redo;

import com.tencent.qcircle.weseevideo.model.resource.AudioConfigurationModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/CutModelKt;", "", "uuid", "", "resource", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoResourceModelKt;", "videoConfiguration", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;", "audioConfiguration", "Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;", "(Ljava/lang/String;Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoResourceModelKt;Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;)V", "getAudioConfiguration", "()Lcom/tencent/qcircle/weseevideo/model/resource/AudioConfigurationModel;", "getResource", "()Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoResourceModelKt;", "getUuid", "()Ljava/lang/String;", "getVideoConfiguration", "()Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;", "component1", "component2", "component3", "component4", "convert", "Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "copy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class CutModelKt {

    @Nullable
    private final AudioConfigurationModel audioConfiguration;

    @NotNull
    private final VideoResourceModelKt resource;

    @NotNull
    private final String uuid;

    @NotNull
    private final VideoConfigurationModelKt videoConfiguration;

    public CutModelKt(@NotNull String uuid, @NotNull VideoResourceModelKt resource, @NotNull VideoConfigurationModelKt videoConfiguration, @Nullable AudioConfigurationModel audioConfigurationModel) {
        Intrinsics.checkParameterIsNotNull(uuid, "uuid");
        Intrinsics.checkParameterIsNotNull(resource, "resource");
        Intrinsics.checkParameterIsNotNull(videoConfiguration, "videoConfiguration");
        this.uuid = uuid;
        this.resource = resource;
        this.videoConfiguration = videoConfiguration;
        this.audioConfiguration = audioConfigurationModel;
    }

    public static /* synthetic */ CutModelKt copy$default(CutModelKt cutModelKt, String str, VideoResourceModelKt videoResourceModelKt, VideoConfigurationModelKt videoConfigurationModelKt, AudioConfigurationModel audioConfigurationModel, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cutModelKt.uuid;
        }
        if ((i3 & 2) != 0) {
            videoResourceModelKt = cutModelKt.resource;
        }
        if ((i3 & 4) != 0) {
            videoConfigurationModelKt = cutModelKt.videoConfiguration;
        }
        if ((i3 & 8) != 0) {
            audioConfigurationModel = cutModelKt.audioConfiguration;
        }
        return cutModelKt.copy(str, videoResourceModelKt, videoConfigurationModelKt, audioConfigurationModel);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final VideoResourceModelKt getResource() {
        return this.resource;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final VideoConfigurationModelKt getVideoConfiguration() {
        return this.videoConfiguration;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final AudioConfigurationModel getAudioConfiguration() {
        return this.audioConfiguration;
    }

    @NotNull
    public final MediaClipModel convert() {
        return new MediaClipModel(this.resource.convert(), this.videoConfiguration.convert(), null, null, null, 0L, null, 124, null);
    }

    @NotNull
    public final CutModelKt copy(@NotNull String uuid, @NotNull VideoResourceModelKt resource, @NotNull VideoConfigurationModelKt videoConfiguration, @Nullable AudioConfigurationModel audioConfiguration) {
        Intrinsics.checkParameterIsNotNull(uuid, "uuid");
        Intrinsics.checkParameterIsNotNull(resource, "resource");
        Intrinsics.checkParameterIsNotNull(videoConfiguration, "videoConfiguration");
        return new CutModelKt(uuid, resource, videoConfiguration, audioConfiguration);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CutModelKt) {
                CutModelKt cutModelKt = (CutModelKt) other;
                if (!Intrinsics.areEqual(this.uuid, cutModelKt.uuid) || !Intrinsics.areEqual(this.resource, cutModelKt.resource) || !Intrinsics.areEqual(this.videoConfiguration, cutModelKt.videoConfiguration) || !Intrinsics.areEqual(this.audioConfiguration, cutModelKt.audioConfiguration)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final AudioConfigurationModel getAudioConfiguration() {
        return this.audioConfiguration;
    }

    @NotNull
    public final VideoResourceModelKt getResource() {
        return this.resource;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    public final VideoConfigurationModelKt getVideoConfiguration() {
        return this.videoConfiguration;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.uuid;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        VideoResourceModelKt videoResourceModelKt = this.resource;
        if (videoResourceModelKt != null) {
            i16 = videoResourceModelKt.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        VideoConfigurationModelKt videoConfigurationModelKt = this.videoConfiguration;
        if (videoConfigurationModelKt != null) {
            i17 = videoConfigurationModelKt.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        AudioConfigurationModel audioConfigurationModel = this.audioConfiguration;
        if (audioConfigurationModel != null) {
            i18 = audioConfigurationModel.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "CutModelKt(uuid=" + this.uuid + ", resource=" + this.resource + ", videoConfiguration=" + this.videoConfiguration + ", audioConfiguration=" + this.audioConfiguration + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CutModelKt(String str, VideoResourceModelKt videoResourceModelKt, VideoConfigurationModelKt videoConfigurationModelKt, AudioConfigurationModel audioConfigurationModel, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, videoResourceModelKt, videoConfigurationModelKt, (i3 & 8) != 0 ? null : audioConfigurationModel);
        if ((i3 & 1) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
        }
    }
}
