package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import com.tencent.tavcut.composition.model.component.InputSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u0099\u0001\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/InputSource;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/InputSource$Builder;", "key", "", "type", "path", "label", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "loopCount", "", LinkReportConstant$GlobalKey.EVENTS, "Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "inputKey", "timeStretchMode", "clipRect", "Lcom/tencent/tavcut/composition/model/component/Rect;", "postEffectOptions", "Lcom/tencent/tavcut/composition/model/component/PostEffectOptions;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/InputSource$Event;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/PostEffectOptions;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/TimeRange;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/InputSource$Event;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/Rect;Lcom/tencent/tavcut/composition/model/component/PostEffectOptions;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/InputSource;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "Event", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class InputSource extends AndroidMessage<InputSource, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<InputSource> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<InputSource> CREATOR;

    @NotNull
    public static final String DEFAULT_KEY = "";
    public static final int DEFAULT_LOOPCOUNT = 0;

    @NotNull
    public static final String DEFAULT_PATH = "";
    public static final int DEFAULT_TIMESTRETCHMODE = 0;

    @NotNull
    public static final String DEFAULT_TYPE = "";

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Rect#ADAPTER", tag = 10)
    @JvmField
    @Nullable
    public final Rect clipRect;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.InputSource$Event#ADAPTER", tag = 7)
    @JvmField
    @Nullable
    public final Event events;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @Nullable
    public final String inputKey;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer loopCount;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @Nullable
    public final String path;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.PostEffectOptions#ADAPTER", tag = 11)
    @JvmField
    @Nullable
    public final PostEffectOptions postEffectOptions;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.TimeRange#ADAPTER", tag = 5)
    @JvmField
    @Nullable
    public final TimeRange timeRange;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    @Nullable
    public final Integer timeStretchMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/InputSource$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "()V", "clipRect", "Lcom/tencent/tavcut/composition/model/component/Rect;", LinkReportConstant$GlobalKey.EVENTS, "Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "inputKey", "", "key", "label", "loopCount", "", "Ljava/lang/Integer;", "path", "postEffectOptions", "Lcom/tencent/tavcut/composition/model/component/PostEffectOptions;", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "timeStretchMode", "type", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/InputSource$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<InputSource, Builder> {

        @JvmField
        @Nullable
        public Rect clipRect;

        @JvmField
        @Nullable
        public Event events;

        @JvmField
        @Nullable
        public String inputKey;

        @JvmField
        @Nullable
        public String key;

        @JvmField
        @Nullable
        public String label;

        @JvmField
        @Nullable
        public Integer loopCount;

        @JvmField
        @Nullable
        public String path;

        @JvmField
        @Nullable
        public PostEffectOptions postEffectOptions;

        @JvmField
        @Nullable
        public TimeRange timeRange;

        @JvmField
        @Nullable
        public Integer timeStretchMode;

        @JvmField
        @Nullable
        public String type;

        @NotNull
        public final Builder clipRect(@Nullable Rect clipRect) {
            this.clipRect = clipRect;
            return this;
        }

        @NotNull
        public final Builder events(@Nullable Event events) {
            this.events = events;
            return this;
        }

        @NotNull
        public final Builder inputKey(@Nullable String inputKey) {
            this.inputKey = inputKey;
            return this;
        }

        @NotNull
        public final Builder key(@Nullable String key) {
            this.key = key;
            return this;
        }

        @NotNull
        public final Builder label(@Nullable String label) {
            this.label = label;
            return this;
        }

        @NotNull
        public final Builder loopCount(@Nullable Integer loopCount) {
            this.loopCount = loopCount;
            return this;
        }

        @NotNull
        public final Builder path(@Nullable String path) {
            this.path = path;
            return this;
        }

        @NotNull
        public final Builder postEffectOptions(@Nullable PostEffectOptions postEffectOptions) {
            this.postEffectOptions = postEffectOptions;
            return this;
        }

        @NotNull
        public final Builder timeRange(@Nullable TimeRange timeRange) {
            this.timeRange = timeRange;
            return this;
        }

        @NotNull
        public final Builder timeStretchMode(@Nullable Integer timeStretchMode) {
            this.timeStretchMode = timeStretchMode;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public InputSource build() {
            return new InputSource(this.key, this.type, this.path, this.label, this.timeRange, this.loopCount, this.events, this.inputKey, this.timeStretchMode, this.clipRect, this.postEffectOptions, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018Bo\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJp\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/InputSource$Event$Builder;", TAVRhythmAutomaticTemplate.DefaultTrail, "", "", TAVRhythmAutomaticTemplate.HighlightValueTrail, TAVRhythmAutomaticTemplate.DrumTrail, TAVRhythmAutomaticTemplate.SlowRhythmTrail, TAVRhythmAutomaticTemplate.StartValueTrail, "ParagraphTrail", "unknownFields", "Lokio/ByteString;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Event extends AndroidMessage<Event, Builder> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<Event> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<Event> CREATOR;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 1)
        @JvmField
        @NotNull
        public final List<Integer> DefalutTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 3)
        @JvmField
        @NotNull
        public final List<Integer> DrumTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 2)
        @JvmField
        @NotNull
        public final List<Integer> HighlightValueTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 6)
        @JvmField
        @NotNull
        public final List<Integer> ParagraphTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 4)
        @JvmField
        @NotNull
        public final List<Integer> SlowRhythmTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 5)
        @JvmField
        @NotNull
        public final List<Integer> StartValueTrail;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\b\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\n\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/InputSource$Event$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "()V", TAVRhythmAutomaticTemplate.DefaultTrail, "", "", TAVRhythmAutomaticTemplate.DrumTrail, TAVRhythmAutomaticTemplate.HighlightValueTrail, "ParagraphTrail", TAVRhythmAutomaticTemplate.SlowRhythmTrail, TAVRhythmAutomaticTemplate.StartValueTrail, "build", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class Builder extends Message.Builder<Event, Builder> {

            @JvmField
            @NotNull
            public List<Integer> DefalutTrail;

            @JvmField
            @NotNull
            public List<Integer> DrumTrail;

            @JvmField
            @NotNull
            public List<Integer> HighlightValueTrail;

            @JvmField
            @NotNull
            public List<Integer> ParagraphTrail;

            @JvmField
            @NotNull
            public List<Integer> SlowRhythmTrail;

            @JvmField
            @NotNull
            public List<Integer> StartValueTrail;

            public Builder() {
                List<Integer> emptyList;
                List<Integer> emptyList2;
                List<Integer> emptyList3;
                List<Integer> emptyList4;
                List<Integer> emptyList5;
                List<Integer> emptyList6;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.DefalutTrail = emptyList;
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                this.HighlightValueTrail = emptyList2;
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                this.DrumTrail = emptyList3;
                emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                this.SlowRhythmTrail = emptyList4;
                emptyList5 = CollectionsKt__CollectionsKt.emptyList();
                this.StartValueTrail = emptyList5;
                emptyList6 = CollectionsKt__CollectionsKt.emptyList();
                this.ParagraphTrail = emptyList6;
            }

            @NotNull
            public final Builder DefalutTrail(@NotNull List<Integer> DefalutTrail) {
                Intrinsics.checkParameterIsNotNull(DefalutTrail, "DefalutTrail");
                Internal.checkElementsNotNull(DefalutTrail);
                this.DefalutTrail = DefalutTrail;
                return this;
            }

            @NotNull
            public final Builder DrumTrail(@NotNull List<Integer> DrumTrail) {
                Intrinsics.checkParameterIsNotNull(DrumTrail, "DrumTrail");
                Internal.checkElementsNotNull(DrumTrail);
                this.DrumTrail = DrumTrail;
                return this;
            }

            @NotNull
            public final Builder HighlightValueTrail(@NotNull List<Integer> HighlightValueTrail) {
                Intrinsics.checkParameterIsNotNull(HighlightValueTrail, "HighlightValueTrail");
                Internal.checkElementsNotNull(HighlightValueTrail);
                this.HighlightValueTrail = HighlightValueTrail;
                return this;
            }

            @NotNull
            public final Builder ParagraphTrail(@NotNull List<Integer> ParagraphTrail) {
                Intrinsics.checkParameterIsNotNull(ParagraphTrail, "ParagraphTrail");
                Internal.checkElementsNotNull(ParagraphTrail);
                this.ParagraphTrail = ParagraphTrail;
                return this;
            }

            @NotNull
            public final Builder SlowRhythmTrail(@NotNull List<Integer> SlowRhythmTrail) {
                Intrinsics.checkParameterIsNotNull(SlowRhythmTrail, "SlowRhythmTrail");
                Internal.checkElementsNotNull(SlowRhythmTrail);
                this.SlowRhythmTrail = SlowRhythmTrail;
                return this;
            }

            @NotNull
            public final Builder StartValueTrail(@NotNull List<Integer> StartValueTrail) {
                Intrinsics.checkParameterIsNotNull(StartValueTrail, "StartValueTrail");
                Internal.checkElementsNotNull(StartValueTrail);
                this.StartValueTrail = StartValueTrail;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public Event build() {
                return new Event(this.DefalutTrail, this.HighlightValueTrail, this.DrumTrail, this.SlowRhythmTrail, this.StartValueTrail, this.ParagraphTrail, buildUnknownFields());
            }
        }

        static {
            final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Event.class);
            final String str = "type.googleapis.com/publisher.InputSource.Event";
            ProtoAdapter<Event> protoAdapter = new ProtoAdapter<Event>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.InputSource$Event$Companion$ADAPTER$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public InputSource.Event decode(@NotNull ProtoReader reader) {
                    Intrinsics.checkParameterIsNotNull(reader, "reader");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    long beginMessage = reader.beginMessage();
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new InputSource.Event(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                        switch (nextTag) {
                            case 1:
                                arrayList.add(ProtoAdapter.INT32.decode(reader));
                                break;
                            case 2:
                                arrayList2.add(ProtoAdapter.INT32.decode(reader));
                                break;
                            case 3:
                                arrayList3.add(ProtoAdapter.INT32.decode(reader));
                                break;
                            case 4:
                                arrayList4.add(ProtoAdapter.INT32.decode(reader));
                                break;
                            case 5:
                                arrayList5.add(ProtoAdapter.INT32.decode(reader));
                                break;
                            case 6:
                                arrayList6.add(ProtoAdapter.INT32.decode(reader));
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull InputSource.Event value) {
                    Intrinsics.checkParameterIsNotNull(writer, "writer");
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    protoAdapter2.asRepeated().encodeWithTag(writer, 1, value.DefalutTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 2, value.HighlightValueTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 3, value.DrumTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 4, value.SlowRhythmTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 5, value.StartValueTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 6, value.ParagraphTrail);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull InputSource.Event value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    return protoAdapter2.asRepeated().encodedSizeWithTag(1, value.DefalutTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(2, value.HighlightValueTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(3, value.DrumTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(4, value.SlowRhythmTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(5, value.StartValueTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(6, value.ParagraphTrail) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public InputSource.Event redact(@NotNull InputSource.Event value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    return InputSource.Event.copy$default(value, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public Event() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ Event copy$default(Event event, List list, List list2, List list3, List list4, List list5, List list6, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = event.DefalutTrail;
            }
            if ((i3 & 2) != 0) {
                list2 = event.HighlightValueTrail;
            }
            List list7 = list2;
            if ((i3 & 4) != 0) {
                list3 = event.DrumTrail;
            }
            List list8 = list3;
            if ((i3 & 8) != 0) {
                list4 = event.SlowRhythmTrail;
            }
            List list9 = list4;
            if ((i3 & 16) != 0) {
                list5 = event.StartValueTrail;
            }
            List list10 = list5;
            if ((i3 & 32) != 0) {
                list6 = event.ParagraphTrail;
            }
            List list11 = list6;
            if ((i3 & 64) != 0) {
                byteString = event.unknownFields();
            }
            return event.copy(list, list7, list8, list9, list10, list11, byteString);
        }

        @NotNull
        public final Event copy(@NotNull List<Integer> DefalutTrail, @NotNull List<Integer> HighlightValueTrail, @NotNull List<Integer> DrumTrail, @NotNull List<Integer> SlowRhythmTrail, @NotNull List<Integer> StartValueTrail, @NotNull List<Integer> ParagraphTrail, @NotNull ByteString unknownFields) {
            Intrinsics.checkParameterIsNotNull(DefalutTrail, "DefalutTrail");
            Intrinsics.checkParameterIsNotNull(HighlightValueTrail, "HighlightValueTrail");
            Intrinsics.checkParameterIsNotNull(DrumTrail, "DrumTrail");
            Intrinsics.checkParameterIsNotNull(SlowRhythmTrail, "SlowRhythmTrail");
            Intrinsics.checkParameterIsNotNull(StartValueTrail, "StartValueTrail");
            Intrinsics.checkParameterIsNotNull(ParagraphTrail, "ParagraphTrail");
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            return new Event(DefalutTrail, HighlightValueTrail, DrumTrail, SlowRhythmTrail, StartValueTrail, ParagraphTrail, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            if (Intrinsics.areEqual(unknownFields(), event.unknownFields()) && Intrinsics.areEqual(this.DefalutTrail, event.DefalutTrail) && Intrinsics.areEqual(this.HighlightValueTrail, event.HighlightValueTrail) && Intrinsics.areEqual(this.DrumTrail, event.DrumTrail) && Intrinsics.areEqual(this.SlowRhythmTrail, event.SlowRhythmTrail) && Intrinsics.areEqual(this.StartValueTrail, event.StartValueTrail) && Intrinsics.areEqual(this.ParagraphTrail, event.ParagraphTrail)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3 = this.hashCode;
            if (i3 == 0) {
                int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.DefalutTrail.hashCode()) * 37) + this.HighlightValueTrail.hashCode()) * 37) + this.DrumTrail.hashCode()) * 37) + this.SlowRhythmTrail.hashCode()) * 37) + this.StartValueTrail.hashCode()) * 37) + this.ParagraphTrail.hashCode();
                this.hashCode = hashCode;
                return hashCode;
            }
            return i3;
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public String toString() {
            String joinToString$default;
            ArrayList arrayList = new ArrayList();
            if (!this.DefalutTrail.isEmpty()) {
                arrayList.add("DefalutTrail=" + this.DefalutTrail);
            }
            if (!this.HighlightValueTrail.isEmpty()) {
                arrayList.add("HighlightValueTrail=" + this.HighlightValueTrail);
            }
            if (!this.DrumTrail.isEmpty()) {
                arrayList.add("DrumTrail=" + this.DrumTrail);
            }
            if (!this.SlowRhythmTrail.isEmpty()) {
                arrayList.add("SlowRhythmTrail=" + this.SlowRhythmTrail);
            }
            if (!this.StartValueTrail.isEmpty()) {
                arrayList.add("StartValueTrail=" + this.StartValueTrail);
            }
            if (!this.ParagraphTrail.isEmpty()) {
                arrayList.add("ParagraphTrail=" + this.ParagraphTrail);
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Event{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ Event(List list, List list2, List list3, List list4, List list5, List list6, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list4, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list5, (i3 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list6, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.DefalutTrail = this.DefalutTrail;
            builder.HighlightValueTrail = this.HighlightValueTrail;
            builder.DrumTrail = this.DrumTrail;
            builder.SlowRhythmTrail = this.SlowRhythmTrail;
            builder.StartValueTrail = this.StartValueTrail;
            builder.ParagraphTrail = this.ParagraphTrail;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(@NotNull List<Integer> DefalutTrail, @NotNull List<Integer> HighlightValueTrail, @NotNull List<Integer> DrumTrail, @NotNull List<Integer> SlowRhythmTrail, @NotNull List<Integer> StartValueTrail, @NotNull List<Integer> ParagraphTrail, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkParameterIsNotNull(DefalutTrail, "DefalutTrail");
            Intrinsics.checkParameterIsNotNull(HighlightValueTrail, "HighlightValueTrail");
            Intrinsics.checkParameterIsNotNull(DrumTrail, "DrumTrail");
            Intrinsics.checkParameterIsNotNull(SlowRhythmTrail, "SlowRhythmTrail");
            Intrinsics.checkParameterIsNotNull(StartValueTrail, "StartValueTrail");
            Intrinsics.checkParameterIsNotNull(ParagraphTrail, "ParagraphTrail");
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            this.DefalutTrail = DefalutTrail;
            this.HighlightValueTrail = HighlightValueTrail;
            this.DrumTrail = DrumTrail;
            this.SlowRhythmTrail = SlowRhythmTrail;
            this.StartValueTrail = StartValueTrail;
            this.ParagraphTrail = ParagraphTrail;
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(InputSource.class);
        final String str = "type.googleapis.com/publisher.InputSource";
        ProtoAdapter<InputSource> protoAdapter = new ProtoAdapter<InputSource>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.InputSource$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public InputSource decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                TimeRange timeRange = null;
                Integer num = null;
                InputSource.Event event = null;
                String str6 = null;
                Integer num2 = null;
                Rect rect = null;
                PostEffectOptions postEffectOptions = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new InputSource(str2, str3, str4, str5, timeRange, num, event, str6, num2, rect, postEffectOptions, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            timeRange = TimeRange.ADAPTER.decode(reader);
                            break;
                        case 6:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 7:
                            event = InputSource.Event.ADAPTER.decode(reader);
                            break;
                        case 8:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 10:
                            rect = Rect.ADAPTER.decode(reader);
                            break;
                        case 11:
                            postEffectOptions = PostEffectOptions.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull InputSource value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.key);
                protoAdapter2.encodeWithTag(writer, 2, value.type);
                protoAdapter2.encodeWithTag(writer, 3, value.path);
                protoAdapter2.encodeWithTag(writer, 4, value.label);
                TimeRange.ADAPTER.encodeWithTag(writer, 5, value.timeRange);
                ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
                protoAdapter3.encodeWithTag(writer, 6, value.loopCount);
                InputSource.Event.ADAPTER.encodeWithTag(writer, 7, value.events);
                protoAdapter2.encodeWithTag(writer, 8, value.inputKey);
                protoAdapter3.encodeWithTag(writer, 9, value.timeStretchMode);
                Rect.ADAPTER.encodeWithTag(writer, 10, value.clipRect);
                PostEffectOptions.ADAPTER.encodeWithTag(writer, 11, value.postEffectOptions);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull InputSource value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.key) + protoAdapter2.encodedSizeWithTag(2, value.type) + protoAdapter2.encodedSizeWithTag(3, value.path) + protoAdapter2.encodedSizeWithTag(4, value.label) + TimeRange.ADAPTER.encodedSizeWithTag(5, value.timeRange);
                ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(6, value.loopCount) + InputSource.Event.ADAPTER.encodedSizeWithTag(7, value.events) + protoAdapter2.encodedSizeWithTag(8, value.inputKey) + protoAdapter3.encodedSizeWithTag(9, value.timeStretchMode) + Rect.ADAPTER.encodedSizeWithTag(10, value.clipRect) + PostEffectOptions.ADAPTER.encodedSizeWithTag(11, value.postEffectOptions) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public InputSource redact(@NotNull InputSource value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                TimeRange timeRange = value.timeRange;
                TimeRange redact = timeRange != null ? TimeRange.ADAPTER.redact(timeRange) : null;
                InputSource.Event event = value.events;
                InputSource.Event redact2 = event != null ? InputSource.Event.ADAPTER.redact(event) : null;
                Rect rect = value.clipRect;
                Rect redact3 = rect != null ? Rect.ADAPTER.redact(rect) : null;
                PostEffectOptions postEffectOptions = value.postEffectOptions;
                return InputSource.copy$default(value, null, null, null, null, redact, null, redact2, null, null, redact3, postEffectOptions != null ? PostEffectOptions.ADAPTER.redact(postEffectOptions) : null, ByteString.EMPTY, 431, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public InputSource() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ InputSource copy$default(InputSource inputSource, String str, String str2, String str3, String str4, TimeRange timeRange, Integer num, Event event, String str5, Integer num2, Rect rect, PostEffectOptions postEffectOptions, ByteString byteString, int i3, Object obj) {
        String str6;
        String str7;
        String str8;
        String str9;
        TimeRange timeRange2;
        Integer num3;
        Event event2;
        String str10;
        Integer num4;
        Rect rect2;
        PostEffectOptions postEffectOptions2;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            str6 = inputSource.key;
        } else {
            str6 = str;
        }
        if ((i3 & 2) != 0) {
            str7 = inputSource.type;
        } else {
            str7 = str2;
        }
        if ((i3 & 4) != 0) {
            str8 = inputSource.path;
        } else {
            str8 = str3;
        }
        if ((i3 & 8) != 0) {
            str9 = inputSource.label;
        } else {
            str9 = str4;
        }
        if ((i3 & 16) != 0) {
            timeRange2 = inputSource.timeRange;
        } else {
            timeRange2 = timeRange;
        }
        if ((i3 & 32) != 0) {
            num3 = inputSource.loopCount;
        } else {
            num3 = num;
        }
        if ((i3 & 64) != 0) {
            event2 = inputSource.events;
        } else {
            event2 = event;
        }
        if ((i3 & 128) != 0) {
            str10 = inputSource.inputKey;
        } else {
            str10 = str5;
        }
        if ((i3 & 256) != 0) {
            num4 = inputSource.timeStretchMode;
        } else {
            num4 = num2;
        }
        if ((i3 & 512) != 0) {
            rect2 = inputSource.clipRect;
        } else {
            rect2 = rect;
        }
        if ((i3 & 1024) != 0) {
            postEffectOptions2 = inputSource.postEffectOptions;
        } else {
            postEffectOptions2 = postEffectOptions;
        }
        if ((i3 & 2048) != 0) {
            byteString2 = inputSource.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return inputSource.copy(str6, str7, str8, str9, timeRange2, num3, event2, str10, num4, rect2, postEffectOptions2, byteString2);
    }

    @NotNull
    public final InputSource copy(@Nullable String key, @Nullable String type, @Nullable String path, @Nullable String label, @Nullable TimeRange timeRange, @Nullable Integer loopCount, @Nullable Event events, @Nullable String inputKey, @Nullable Integer timeStretchMode, @Nullable Rect clipRect, @Nullable PostEffectOptions postEffectOptions, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new InputSource(key, type, path, label, timeRange, loopCount, events, inputKey, timeStretchMode, clipRect, postEffectOptions, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof InputSource)) {
            return false;
        }
        InputSource inputSource = (InputSource) other;
        if (Intrinsics.areEqual(unknownFields(), inputSource.unknownFields()) && Intrinsics.areEqual(this.key, inputSource.key) && Intrinsics.areEqual(this.type, inputSource.type) && Intrinsics.areEqual(this.path, inputSource.path) && Intrinsics.areEqual(this.label, inputSource.label) && Intrinsics.areEqual(this.timeRange, inputSource.timeRange) && Intrinsics.areEqual(this.loopCount, inputSource.loopCount) && Intrinsics.areEqual(this.events, inputSource.events) && Intrinsics.areEqual(this.inputKey, inputSource.inputKey) && Intrinsics.areEqual(this.timeStretchMode, inputSource.timeStretchMode) && Intrinsics.areEqual(this.clipRect, inputSource.clipRect) && Intrinsics.areEqual(this.postEffectOptions, inputSource.postEffectOptions)) {
            return true;
        }
        return false;
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
        int i37 = this.hashCode;
        if (i37 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.key;
            int i38 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i39 = (hashCode + i3) * 37;
            String str2 = this.type;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i46 = (i39 + i16) * 37;
            String str3 = this.path;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i47 = (i46 + i17) * 37;
            String str4 = this.label;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i48 = (i47 + i18) * 37;
            TimeRange timeRange = this.timeRange;
            if (timeRange != null) {
                i19 = timeRange.hashCode();
            } else {
                i19 = 0;
            }
            int i49 = (i48 + i19) * 37;
            Integer num = this.loopCount;
            if (num != null) {
                i26 = num.hashCode();
            } else {
                i26 = 0;
            }
            int i56 = (i49 + i26) * 37;
            Event event = this.events;
            if (event != null) {
                i27 = event.hashCode();
            } else {
                i27 = 0;
            }
            int i57 = (i56 + i27) * 37;
            String str5 = this.inputKey;
            if (str5 != null) {
                i28 = str5.hashCode();
            } else {
                i28 = 0;
            }
            int i58 = (i57 + i28) * 37;
            Integer num2 = this.timeStretchMode;
            if (num2 != null) {
                i29 = num2.hashCode();
            } else {
                i29 = 0;
            }
            int i59 = (i58 + i29) * 37;
            Rect rect = this.clipRect;
            if (rect != null) {
                i36 = rect.hashCode();
            } else {
                i36 = 0;
            }
            int i65 = (i59 + i36) * 37;
            PostEffectOptions postEffectOptions = this.postEffectOptions;
            if (postEffectOptions != null) {
                i38 = postEffectOptions.hashCode();
            }
            int i66 = i65 + i38;
            this.hashCode = i66;
            return i66;
        }
        return i37;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.key != null) {
            arrayList.add("key=" + Internal.sanitize(this.key));
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.path != null) {
            arrayList.add("path=" + Internal.sanitize(this.path));
        }
        if (this.label != null) {
            arrayList.add("label=" + Internal.sanitize(this.label));
        }
        if (this.timeRange != null) {
            arrayList.add("timeRange=" + this.timeRange);
        }
        if (this.loopCount != null) {
            arrayList.add("loopCount=" + this.loopCount);
        }
        if (this.events != null) {
            arrayList.add("events=" + this.events);
        }
        if (this.inputKey != null) {
            arrayList.add("inputKey=" + Internal.sanitize(this.inputKey));
        }
        if (this.timeStretchMode != null) {
            arrayList.add("timeStretchMode=" + this.timeStretchMode);
        }
        if (this.clipRect != null) {
            arrayList.add("clipRect=" + this.clipRect);
        }
        if (this.postEffectOptions != null) {
            arrayList.add("postEffectOptions=" + this.postEffectOptions);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "InputSource{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ InputSource(String str, String str2, String str3, String str4, TimeRange timeRange, Integer num, Event event, String str5, Integer num2, Rect rect, PostEffectOptions postEffectOptions, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : timeRange, (i3 & 32) != 0 ? null : num, (i3 & 64) != 0 ? null : event, (i3 & 128) != 0 ? null : str5, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : rect, (i3 & 1024) == 0 ? postEffectOptions : null, (i3 & 2048) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.key = this.key;
        builder.type = this.type;
        builder.path = this.path;
        builder.label = this.label;
        builder.timeRange = this.timeRange;
        builder.loopCount = this.loopCount;
        builder.events = this.events;
        builder.inputKey = this.inputKey;
        builder.timeStretchMode = this.timeStretchMode;
        builder.clipRect = this.clipRect;
        builder.postEffectOptions = this.postEffectOptions;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputSource(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable TimeRange timeRange, @Nullable Integer num, @Nullable Event event, @Nullable String str5, @Nullable Integer num2, @Nullable Rect rect, @Nullable PostEffectOptions postEffectOptions, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.key = str;
        this.type = str2;
        this.path = str3;
        this.label = str4;
        this.timeRange = timeRange;
        this.loopCount = num;
        this.events = event;
        this.inputKey = str5;
        this.timeStretchMode = num2;
        this.clipRect = rect;
        this.postEffectOptions = postEffectOptions;
    }
}
