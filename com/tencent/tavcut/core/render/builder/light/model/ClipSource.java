package com.tencent.tavcut.core.render.builder.light.model;

import androidx.fragment.app.a;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.ScreenTransform;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u0018J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\t\u00106\u001a\u00020\u0015H\u00c6\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010:\u001a\u00020\bH\u00c6\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010<\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010=\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00aa\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00c6\u0001\u00a2\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010D\u001a\u00020EH\u00d6\u0001J\t\u0010F\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b2\u0010)\u00a8\u0006G"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "", "sourceId", "", "path", "type", "Lcom/tencent/tavcut/core/render/builder/light/model/type/ClipType;", "duration", "", "speed", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "startOffset", "matrix", "", "photoEffectPath", "transform", "Lorg/light/lightAssetKit/components/ScreenTransform;", "clipRect", "Lorg/light/lightAssetKit/components/Rect;", "byteArray", "Lokio/ByteString;", "autoLoop", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/core/render/builder/light/model/type/ClipType;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Lorg/light/lightAssetKit/components/ScreenTransform;Lorg/light/lightAssetKit/components/Rect;Lokio/ByteString;Ljava/lang/Boolean;)V", "getAutoLoop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getByteArray", "()Lokio/ByteString;", "getClipRect", "()Lorg/light/lightAssetKit/components/Rect;", "getDuration", "()J", "getMatrix", "()Ljava/util/List;", "getPath", "()Ljava/lang/String;", "getPhotoEffectPath", "getSourceId", "getSpeed", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getStartOffset", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTransform", "()Lorg/light/lightAssetKit/components/ScreenTransform;", "getType", "()Lcom/tencent/tavcut/core/render/builder/light/model/type/ClipType;", "getVolume", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/core/render/builder/light/model/type/ClipType;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Lorg/light/lightAssetKit/components/ScreenTransform;Lorg/light/lightAssetKit/components/Rect;Lokio/ByteString;Ljava/lang/Boolean;)Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "equals", "other", "hashCode", "", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class ClipSource {

    @Nullable
    private final Boolean autoLoop;

    @NotNull
    private final ByteString byteArray;

    @Nullable
    private final Rect clipRect;
    private final long duration;

    @NotNull
    private final List<Float> matrix;

    @Nullable
    private final String path;

    @Nullable
    private final String photoEffectPath;

    @Nullable
    private final String sourceId;

    @Nullable
    private final Float speed;

    @Nullable
    private final Long startOffset;

    @Nullable
    private final ScreenTransform transform;

    @Nullable
    private final ClipType type;

    @Nullable
    private final Float volume;

    public ClipSource(@Nullable String str, @Nullable String str2, @Nullable ClipType clipType, long j3, @Nullable Float f16, @Nullable Float f17, @Nullable Long l3, @NotNull List<Float> matrix, @Nullable String str3, @Nullable ScreenTransform screenTransform, @Nullable Rect rect, @NotNull ByteString byteArray, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        Intrinsics.checkParameterIsNotNull(byteArray, "byteArray");
        this.sourceId = str;
        this.path = str2;
        this.type = clipType;
        this.duration = j3;
        this.speed = f16;
        this.volume = f17;
        this.startOffset = l3;
        this.matrix = matrix;
        this.photoEffectPath = str3;
        this.transform = screenTransform;
        this.clipRect = rect;
        this.byteArray = byteArray;
        this.autoLoop = bool;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final ScreenTransform getTransform() {
        return this.transform;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Rect getClipRect() {
        return this.clipRect;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final ByteString getByteArray() {
        return this.byteArray;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Boolean getAutoLoop() {
        return this.autoLoop;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final ClipType getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Float getSpeed() {
        return this.speed;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Float getVolume() {
        return this.volume;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getStartOffset() {
        return this.startOffset;
    }

    @NotNull
    public final List<Float> component8() {
        return this.matrix;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getPhotoEffectPath() {
        return this.photoEffectPath;
    }

    @NotNull
    public final ClipSource copy(@Nullable String sourceId, @Nullable String path, @Nullable ClipType type, long duration, @Nullable Float speed, @Nullable Float volume, @Nullable Long startOffset, @NotNull List<Float> matrix, @Nullable String photoEffectPath, @Nullable ScreenTransform transform, @Nullable Rect clipRect, @NotNull ByteString byteArray, @Nullable Boolean autoLoop) {
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        Intrinsics.checkParameterIsNotNull(byteArray, "byteArray");
        return new ClipSource(sourceId, path, type, duration, speed, volume, startOffset, matrix, photoEffectPath, transform, clipRect, byteArray, autoLoop);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ClipSource) {
                ClipSource clipSource = (ClipSource) other;
                if (!Intrinsics.areEqual(this.sourceId, clipSource.sourceId) || !Intrinsics.areEqual(this.path, clipSource.path) || !Intrinsics.areEqual(this.type, clipSource.type) || this.duration != clipSource.duration || !Intrinsics.areEqual((Object) this.speed, (Object) clipSource.speed) || !Intrinsics.areEqual((Object) this.volume, (Object) clipSource.volume) || !Intrinsics.areEqual(this.startOffset, clipSource.startOffset) || !Intrinsics.areEqual(this.matrix, clipSource.matrix) || !Intrinsics.areEqual(this.photoEffectPath, clipSource.photoEffectPath) || !Intrinsics.areEqual(this.transform, clipSource.transform) || !Intrinsics.areEqual(this.clipRect, clipSource.clipRect) || !Intrinsics.areEqual(this.byteArray, clipSource.byteArray) || !Intrinsics.areEqual(this.autoLoop, clipSource.autoLoop)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Boolean getAutoLoop() {
        return this.autoLoop;
    }

    @NotNull
    public final ByteString getByteArray() {
        return this.byteArray;
    }

    @Nullable
    public final Rect getClipRect() {
        return this.clipRect;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final List<Float> getMatrix() {
        return this.matrix;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getPhotoEffectPath() {
        return this.photoEffectPath;
    }

    @Nullable
    public final String getSourceId() {
        return this.sourceId;
    }

    @Nullable
    public final Float getSpeed() {
        return this.speed;
    }

    @Nullable
    public final Long getStartOffset() {
        return this.startOffset;
    }

    @Nullable
    public final ScreenTransform getTransform() {
        return this.transform;
    }

    @Nullable
    public final ClipType getType() {
        return this.type;
    }

    @Nullable
    public final Float getVolume() {
        return this.volume;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        String str = this.sourceId;
        int i38 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i39 = i3 * 31;
        String str2 = this.path;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i46 = (i39 + i16) * 31;
        ClipType clipType = this.type;
        if (clipType != null) {
            i17 = clipType.hashCode();
        } else {
            i17 = 0;
        }
        int a16 = (((i46 + i17) * 31) + a.a(this.duration)) * 31;
        Float f16 = this.speed;
        if (f16 != null) {
            i18 = f16.hashCode();
        } else {
            i18 = 0;
        }
        int i47 = (a16 + i18) * 31;
        Float f17 = this.volume;
        if (f17 != null) {
            i19 = f17.hashCode();
        } else {
            i19 = 0;
        }
        int i48 = (i47 + i19) * 31;
        Long l3 = this.startOffset;
        if (l3 != null) {
            i26 = l3.hashCode();
        } else {
            i26 = 0;
        }
        int i49 = (i48 + i26) * 31;
        List<Float> list = this.matrix;
        if (list != null) {
            i27 = list.hashCode();
        } else {
            i27 = 0;
        }
        int i56 = (i49 + i27) * 31;
        String str3 = this.photoEffectPath;
        if (str3 != null) {
            i28 = str3.hashCode();
        } else {
            i28 = 0;
        }
        int i57 = (i56 + i28) * 31;
        ScreenTransform screenTransform = this.transform;
        if (screenTransform != null) {
            i29 = screenTransform.hashCode();
        } else {
            i29 = 0;
        }
        int i58 = (i57 + i29) * 31;
        Rect rect = this.clipRect;
        if (rect != null) {
            i36 = rect.hashCode();
        } else {
            i36 = 0;
        }
        int i59 = (i58 + i36) * 31;
        ByteString byteString = this.byteArray;
        if (byteString != null) {
            i37 = byteString.hashCode();
        } else {
            i37 = 0;
        }
        int i65 = (i59 + i37) * 31;
        Boolean bool = this.autoLoop;
        if (bool != null) {
            i38 = bool.hashCode();
        }
        return i65 + i38;
    }

    @NotNull
    public String toString() {
        return "ClipSource(sourceId=" + this.sourceId + ", path=" + this.path + ", type=" + this.type + ", duration=" + this.duration + ", speed=" + this.speed + ", volume=" + this.volume + ", startOffset=" + this.startOffset + ", matrix=" + this.matrix + ", photoEffectPath=" + this.photoEffectPath + ", transform=" + this.transform + ", clipRect=" + this.clipRect + ", byteArray=" + this.byteArray + ", autoLoop=" + this.autoLoop + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ClipSource(String str, String str2, ClipType clipType, long j3, Float f16, Float f17, Long l3, List list, String str3, ScreenTransform screenTransform, Rect rect, ByteString byteString, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r6, j3, r9, r10, r11, r12, (i3 & 256) != 0 ? null : str3, (i3 & 512) != 0 ? null : screenTransform, (i3 & 1024) != 0 ? null : rect, (i3 & 2048) != 0 ? ByteString.EMPTY : byteString, (i3 & 4096) != 0 ? null : bool);
        List list2;
        List emptyList;
        String str4 = (i3 & 1) != 0 ? null : str;
        String str5 = (i3 & 2) != 0 ? null : str2;
        ClipType clipType2 = (i3 & 4) != 0 ? null : clipType;
        Float f18 = (i3 & 16) != 0 ? null : f16;
        Float f19 = (i3 & 32) != 0 ? null : f17;
        Long l16 = (i3 & 64) != 0 ? null : l3;
        if ((i3 & 128) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }
}
