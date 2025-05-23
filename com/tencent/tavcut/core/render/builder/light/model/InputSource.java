package com.tencent.tavcut.core.render.builder.light.model;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u000b\u0010.\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u0088\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00c6\u0001\u00a2\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u00020\nH\u00d6\u0001J\t\u00107\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019\u00a8\u00068"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "", "key", "", "type", "path", "label", "timeRange", "Lorg/light/lightAssetKit/components/TimeRange;", "loopCount", "", LinkReportConstant$GlobalKey.EVENTS, "Lcom/tencent/tavcut/core/render/builder/light/model/Event;", "inputKey", "timeStretchMode", "clipRect", "Lorg/light/lightAssetKit/components/Rect;", "postEffectOptions", "Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/light/lightAssetKit/components/TimeRange;Ljava/lang/Integer;Lcom/tencent/tavcut/core/render/builder/light/model/Event;Ljava/lang/String;Ljava/lang/Integer;Lorg/light/lightAssetKit/components/Rect;Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;)V", "getClipRect", "()Lorg/light/lightAssetKit/components/Rect;", "getEvents", "()Lcom/tencent/tavcut/core/render/builder/light/model/Event;", "getInputKey", "()Ljava/lang/String;", "getKey", "getLabel", "getLoopCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPath", "getPostEffectOptions", "()Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;", "getTimeRange", "()Lorg/light/lightAssetKit/components/TimeRange;", "getTimeStretchMode", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/light/lightAssetKit/components/TimeRange;Ljava/lang/Integer;Lcom/tencent/tavcut/core/render/builder/light/model/Event;Ljava/lang/String;Ljava/lang/Integer;Lorg/light/lightAssetKit/components/Rect;Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;)Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "equals", "", "other", "hashCode", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class InputSource {

    @Nullable
    private final Rect clipRect;

    @Nullable
    private final Event events;

    @NotNull
    private final String inputKey;

    @NotNull
    private final String key;

    @NotNull
    private final String label;

    @Nullable
    private final Integer loopCount;

    @NotNull
    private final String path;

    @Nullable
    private final PostEffectOptions postEffectOptions;

    @Nullable
    private final TimeRange timeRange;

    @Nullable
    private final Integer timeStretchMode;

    @NotNull
    private final String type;

    public InputSource() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Rect getClipRect() {
        return this.clipRect;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final PostEffectOptions getPostEffectOptions() {
        return this.postEffectOptions;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final TimeRange getTimeRange() {
        return this.timeRange;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getLoopCount() {
        return this.loopCount;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Event getEvents() {
        return this.events;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getInputKey() {
        return this.inputKey;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getTimeStretchMode() {
        return this.timeStretchMode;
    }

    @NotNull
    public final InputSource copy(@NotNull String key, @NotNull String type, @NotNull String path, @NotNull String label, @Nullable TimeRange timeRange, @Nullable Integer loopCount, @Nullable Event events, @NotNull String inputKey, @Nullable Integer timeStretchMode, @Nullable Rect clipRect, @Nullable PostEffectOptions postEffectOptions) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(label, "label");
        Intrinsics.checkParameterIsNotNull(inputKey, "inputKey");
        return new InputSource(key, type, path, label, timeRange, loopCount, events, inputKey, timeStretchMode, clipRect, postEffectOptions);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof InputSource) {
                InputSource inputSource = (InputSource) other;
                if (!Intrinsics.areEqual(this.key, inputSource.key) || !Intrinsics.areEqual(this.type, inputSource.type) || !Intrinsics.areEqual(this.path, inputSource.path) || !Intrinsics.areEqual(this.label, inputSource.label) || !Intrinsics.areEqual(this.timeRange, inputSource.timeRange) || !Intrinsics.areEqual(this.loopCount, inputSource.loopCount) || !Intrinsics.areEqual(this.events, inputSource.events) || !Intrinsics.areEqual(this.inputKey, inputSource.inputKey) || !Intrinsics.areEqual(this.timeStretchMode, inputSource.timeStretchMode) || !Intrinsics.areEqual(this.clipRect, inputSource.clipRect) || !Intrinsics.areEqual(this.postEffectOptions, inputSource.postEffectOptions)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Rect getClipRect() {
        return this.clipRect;
    }

    @Nullable
    public final Event getEvents() {
        return this.events;
    }

    @NotNull
    public final String getInputKey() {
        return this.inputKey;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final Integer getLoopCount() {
        return this.loopCount;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final PostEffectOptions getPostEffectOptions() {
        return this.postEffectOptions;
    }

    @Nullable
    public final TimeRange getTimeRange() {
        return this.timeRange;
    }

    @Nullable
    public final Integer getTimeStretchMode() {
        return this.timeStretchMode;
    }

    @NotNull
    public final String getType() {
        return this.type;
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
        String str = this.key;
        int i37 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i38 = i3 * 31;
        String str2 = this.type;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i39 = (i38 + i16) * 31;
        String str3 = this.path;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i46 = (i39 + i17) * 31;
        String str4 = this.label;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i47 = (i46 + i18) * 31;
        TimeRange timeRange = this.timeRange;
        if (timeRange != null) {
            i19 = timeRange.hashCode();
        } else {
            i19 = 0;
        }
        int i48 = (i47 + i19) * 31;
        Integer num = this.loopCount;
        if (num != null) {
            i26 = num.hashCode();
        } else {
            i26 = 0;
        }
        int i49 = (i48 + i26) * 31;
        Event event = this.events;
        if (event != null) {
            i27 = event.hashCode();
        } else {
            i27 = 0;
        }
        int i56 = (i49 + i27) * 31;
        String str5 = this.inputKey;
        if (str5 != null) {
            i28 = str5.hashCode();
        } else {
            i28 = 0;
        }
        int i57 = (i56 + i28) * 31;
        Integer num2 = this.timeStretchMode;
        if (num2 != null) {
            i29 = num2.hashCode();
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
        PostEffectOptions postEffectOptions = this.postEffectOptions;
        if (postEffectOptions != null) {
            i37 = postEffectOptions.hashCode();
        }
        return i59 + i37;
    }

    @NotNull
    public String toString() {
        return "InputSource(key=" + this.key + ", type=" + this.type + ", path=" + this.path + ", label=" + this.label + ", timeRange=" + this.timeRange + ", loopCount=" + this.loopCount + ", events=" + this.events + ", inputKey=" + this.inputKey + ", timeStretchMode=" + this.timeStretchMode + ", clipRect=" + this.clipRect + ", postEffectOptions=" + this.postEffectOptions + ")";
    }

    public InputSource(@NotNull String key, @NotNull String type, @NotNull String path, @NotNull String label, @Nullable TimeRange timeRange, @Nullable Integer num, @Nullable Event event, @NotNull String inputKey, @Nullable Integer num2, @Nullable Rect rect, @Nullable PostEffectOptions postEffectOptions) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(label, "label");
        Intrinsics.checkParameterIsNotNull(inputKey, "inputKey");
        this.key = key;
        this.type = type;
        this.path = path;
        this.label = label;
        this.timeRange = timeRange;
        this.loopCount = num;
        this.events = event;
        this.inputKey = inputKey;
        this.timeStretchMode = num2;
        this.clipRect = rect;
        this.postEffectOptions = postEffectOptions;
    }

    public /* synthetic */ InputSource(String str, String str2, String str3, String str4, TimeRange timeRange, Integer num, Event event, String str5, Integer num2, Rect rect, PostEffectOptions postEffectOptions, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? null : timeRange, (i3 & 32) != 0 ? null : num, (i3 & 64) != 0 ? null : event, (i3 & 128) == 0 ? str5 : "", (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : rect, (i3 & 1024) == 0 ? postEffectOptions : null);
    }
}
