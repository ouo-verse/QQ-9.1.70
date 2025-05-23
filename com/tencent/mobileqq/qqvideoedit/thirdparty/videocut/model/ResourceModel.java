package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000201B\u00bb\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u00d5\u0001\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$R\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010%R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010%R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010&R\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010&R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010&R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010&R\u0014\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010(R\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010)R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010*R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010+R\u0014\u0010\u001e\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010%R\u0014\u0010\u001f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010%R\u0016\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "path", "", "scaleDuration", WebAudioPlugin.API_SOURCE_START, "sourceDuration", "selectStart", "selectDuration", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaType;", "type", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "size", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "extras", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "picClipRect", "reversePath", "normalPath", "isReverseMode", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaType;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;Ljava/lang/Float;Ljava/util/Map;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "Ljava/lang/String;", "J", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaType;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJJJJLcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaType;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;FLjava/util/Map;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ResourceModel extends AndroidMessage<ResourceModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<ResourceModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ResourceModel> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    @JvmField
    @NotNull
    public final Map<String, String> extras;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 16)
    @JvmField
    @Nullable
    public final Boolean isReverseMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    @JvmField
    @NotNull
    public final String normalPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String path;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RectF#ADAPTER", tag = 13)
    @JvmField
    @Nullable
    public final RectF picClipRect;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    @JvmField
    @NotNull
    public final String reversePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    @JvmField
    public final long scaleDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    @JvmField
    public final long selectDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    @JvmField
    public final long selectStart;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF#ADAPTER", tag = 9)
    @JvmField
    @Nullable
    public final SizeF size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @JvmField
    public final long sourceDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    public final long sourceStart;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType#ADAPTER", tag = 8)
    @JvmField
    @Nullable
    public final MediaType type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 11)
    @JvmField
    public final float volume;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0005R\u0016\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0005R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "a", "", "Ljava/lang/String;", "id", "b", "path", "", "c", "J", "scaleDuration", "d", WebAudioPlugin.API_SOURCE_START, "e", "sourceDuration", "f", "selectStart", "g", "selectDuration", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaType;", h.F, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaType;", "type", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "i", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "size", "", "j", "Ljava/lang/Float;", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "k", "Ljava/util/Map;", "extras", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "l", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RectF;", "picClipRect", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "reversePath", DomainData.DOMAIN_NAME, "normalPath", "", "o", "Ljava/lang/Boolean;", "isReverseMode", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<ResourceModel, a> {

        /* renamed from: a, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String id = "";

        /* renamed from: b, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public String path = "";

        /* renamed from: c, reason: from kotlin metadata */
        @JvmField
        public long scaleDuration;

        /* renamed from: d, reason: from kotlin metadata */
        @JvmField
        public long com.tencent.mobileqq.tritonaudio.WebAudioPlugin.API_SOURCE_START java.lang.String;

        /* renamed from: e, reason: from kotlin metadata */
        @JvmField
        public long sourceDuration;

        /* renamed from: f, reason: from kotlin metadata */
        @JvmField
        public long selectStart;

        /* renamed from: g, reason: from kotlin metadata */
        @JvmField
        public long selectDuration;

        /* renamed from: h */
        @JvmField
        @Nullable
        public MediaType type;

        /* renamed from: i, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public SizeF size;

        /* renamed from: j, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public Float com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.AUDIO_PROPERTY_VOLUME java.lang.String;

        /* renamed from: k, reason: from kotlin metadata */
        @JvmField
        @NotNull
        public Map<String, String> extras;

        /* renamed from: l, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public RectF picClipRect;

        /* renamed from: m */
        @JvmField
        @NotNull
        public String reversePath;

        /* renamed from: n */
        @JvmField
        @NotNull
        public String normalPath;

        /* renamed from: o, reason: from kotlin metadata */
        @JvmField
        @Nullable
        public Boolean isReverseMode;

        public a() {
            Map<String, String> emptyMap;
            emptyMap = MapsKt__MapsKt.emptyMap();
            this.extras = emptyMap;
            this.reversePath = "";
            this.normalPath = "";
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a */
        public ResourceModel build() {
            float f16;
            String str = this.id;
            String str2 = this.path;
            long j3 = this.scaleDuration;
            long j16 = this.com.tencent.mobileqq.tritonaudio.WebAudioPlugin.API_SOURCE_START java.lang.String;
            long j17 = this.sourceDuration;
            long j18 = this.selectStart;
            long j19 = this.selectDuration;
            MediaType mediaType = this.type;
            SizeF sizeF = this.size;
            Float f17 = this.com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.AUDIO_PROPERTY_VOLUME java.lang.String;
            if (f17 != null) {
                f16 = f17.floatValue();
            } else {
                f16 = 0.0f;
            }
            return new ResourceModel(str, str2, j3, j16, j17, j18, j19, mediaType, sizeF, f16, this.extras, this.picClipRect, this.reversePath, this.normalPath, this.isReverseMode, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R&\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e0\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "", "", "Lcom/squareup/wire/ProtoAdapter;", "extrasAdapter", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<ResourceModel> {

        /* renamed from: a, reason: from kotlin metadata */
        @NotNull
        private final ProtoAdapter<Map<String, String>> extrasAdapter;

        b(FieldEncoding fieldEncoding, KClass<ResourceModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.ResourceModel");
            ProtoAdapter.Companion companion = ProtoAdapter.INSTANCE;
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.extrasAdapter = companion.newMapAdapter(protoAdapter, protoAdapter);
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a */
        public ResourceModel decode(@NotNull ProtoReader reader) {
            float f16;
            long j3;
            Intrinsics.checkNotNullParameter(reader, "reader");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long beginMessage = reader.beginMessage();
            String str = "";
            long j16 = 0;
            long j17 = 0;
            long j18 = 0;
            long j19 = 0;
            long j26 = 0;
            MediaType mediaType = null;
            SizeF sizeF = null;
            Float f17 = null;
            RectF rectF = null;
            Boolean bool = null;
            String str2 = str;
            String str3 = str2;
            String str4 = str3;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 2:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 3:
                            j16 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 4:
                            j26 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 5:
                            j17 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 6:
                            j18 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 7:
                            j19 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 8:
                            try {
                                mediaType = MediaType.ADAPTER.decode(reader);
                                continue;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                j3 = j16;
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 9:
                            sizeF = SizeF.ADAPTER.decode(reader);
                            continue;
                        case 10:
                        default:
                            j3 = j16;
                            reader.readUnknownField(nextTag);
                            break;
                        case 11:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            continue;
                        case 12:
                            linkedHashMap.putAll(this.extrasAdapter.decode(reader));
                            j3 = j16;
                            break;
                        case 13:
                            rectF = RectF.ADAPTER.decode(reader);
                            continue;
                        case 14:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 15:
                            str = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 16:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            continue;
                    }
                    j16 = j3;
                } else {
                    long j27 = j16;
                    ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                    String str5 = str2;
                    String str6 = str3;
                    MediaType mediaType2 = mediaType;
                    SizeF sizeF2 = sizeF;
                    Float f18 = f17;
                    if (f18 != null) {
                        f16 = f18.floatValue();
                    } else {
                        f16 = 0.0f;
                    }
                    return new ResourceModel(str5, str6, j27, j26, j17, j18, j19, mediaType2, sizeF2, f16, linkedHashMap, rectF, str4, str, bool, endMessageAndGetUnknownFields);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(@NotNull ProtoWriter writer, @NotNull ResourceModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.id);
            protoAdapter.encodeWithTag(writer, 2, value.path);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
            protoAdapter2.encodeWithTag(writer, 3, Long.valueOf(value.scaleDuration));
            protoAdapter2.encodeWithTag(writer, 4, Long.valueOf(value.sourceStart));
            protoAdapter2.encodeWithTag(writer, 5, Long.valueOf(value.sourceDuration));
            protoAdapter2.encodeWithTag(writer, 6, Long.valueOf(value.selectStart));
            protoAdapter2.encodeWithTag(writer, 7, Long.valueOf(value.selectDuration));
            MediaType.ADAPTER.encodeWithTag(writer, 8, value.type);
            SizeF.ADAPTER.encodeWithTag(writer, 9, value.size);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 11, Float.valueOf(value.volume));
            this.extrasAdapter.encodeWithTag(writer, 12, value.extras);
            RectF.ADAPTER.encodeWithTag(writer, 13, value.picClipRect);
            protoAdapter.encodeWithTag(writer, 14, value.reversePath);
            protoAdapter.encodeWithTag(writer, 15, value.normalPath);
            ProtoAdapter.BOOL.encodeWithTag(writer, 16, value.isReverseMode);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(@NotNull ResourceModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, value.id) + protoAdapter.encodedSizeWithTag(2, value.path);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(3, Long.valueOf(value.scaleDuration)) + protoAdapter2.encodedSizeWithTag(4, Long.valueOf(value.sourceStart)) + protoAdapter2.encodedSizeWithTag(5, Long.valueOf(value.sourceDuration)) + protoAdapter2.encodedSizeWithTag(6, Long.valueOf(value.selectStart)) + protoAdapter2.encodedSizeWithTag(7, Long.valueOf(value.selectDuration)) + MediaType.ADAPTER.encodedSizeWithTag(8, value.type) + SizeF.ADAPTER.encodedSizeWithTag(9, value.size) + ProtoAdapter.FLOAT.encodedSizeWithTag(11, Float.valueOf(value.volume)) + this.extrasAdapter.encodedSizeWithTag(12, value.extras) + RectF.ADAPTER.encodedSizeWithTag(13, value.picClipRect) + protoAdapter.encodedSizeWithTag(14, value.reversePath) + protoAdapter.encodedSizeWithTag(15, value.normalPath) + ProtoAdapter.BOOL.encodedSizeWithTag(16, value.isReverseMode) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d */
        public ResourceModel redact(@NotNull ResourceModel value) {
            SizeF sizeF;
            Intrinsics.checkNotNullParameter(value, "value");
            SizeF sizeF2 = value.size;
            RectF rectF = null;
            if (sizeF2 != null) {
                sizeF = SizeF.ADAPTER.redact(sizeF2);
            } else {
                sizeF = null;
            }
            RectF rectF2 = value.picClipRect;
            if (rectF2 != null) {
                rectF = RectF.ADAPTER.redact(rectF2);
            }
            return ResourceModel.copy$default(value, null, null, null, null, null, null, null, null, sizeF, null, null, rectF, null, null, null, ByteString.EMPTY, 30463, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public ResourceModel() {
        this(null, null, 0L, 0L, 0L, 0L, 0L, null, null, 0.0f, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ ResourceModel copy$default(ResourceModel resourceModel, String str, String str2, Long l3, Long l16, Long l17, Long l18, Long l19, MediaType mediaType, SizeF sizeF, Float f16, Map map, RectF rectF, String str3, String str4, Boolean bool, ByteString byteString, int i3, Object obj) {
        return resourceModel.copy((i3 & 1) != 0 ? resourceModel.id : str, (i3 & 2) != 0 ? resourceModel.path : str2, (i3 & 4) != 0 ? Long.valueOf(resourceModel.scaleDuration) : l3, (i3 & 8) != 0 ? Long.valueOf(resourceModel.sourceStart) : l16, (i3 & 16) != 0 ? Long.valueOf(resourceModel.sourceDuration) : l17, (i3 & 32) != 0 ? Long.valueOf(resourceModel.selectStart) : l18, (i3 & 64) != 0 ? Long.valueOf(resourceModel.selectDuration) : l19, (i3 & 128) != 0 ? resourceModel.type : mediaType, (i3 & 256) != 0 ? resourceModel.size : sizeF, (i3 & 512) != 0 ? Float.valueOf(resourceModel.volume) : f16, (i3 & 1024) != 0 ? resourceModel.extras : map, (i3 & 2048) != 0 ? resourceModel.picClipRect : rectF, (i3 & 4096) != 0 ? resourceModel.reversePath : str3, (i3 & 8192) != 0 ? resourceModel.normalPath : str4, (i3 & 16384) != 0 ? resourceModel.isReverseMode : bool, (i3 & 32768) != 0 ? resourceModel.unknownFields() : byteString);
    }

    @NotNull
    public final ResourceModel copy(@Nullable String id5, @Nullable String path, @Nullable Long scaleDuration, @Nullable Long r27, @Nullable Long sourceDuration, @Nullable Long selectStart, @Nullable Long selectDuration, @Nullable MediaType type, @Nullable SizeF size, @Nullable Float r332, @NotNull Map<String, String> extras, @Nullable RectF picClipRect, @Nullable String reversePath, @Nullable String normalPath, @Nullable Boolean isReverseMode, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new ResourceModel(id5 == null ? "" : id5, path == null ? "" : path, scaleDuration != null ? scaleDuration.longValue() : 0L, r27 != null ? r27.longValue() : 0L, sourceDuration != null ? sourceDuration.longValue() : 0L, selectStart != null ? selectStart.longValue() : 0L, selectDuration != null ? selectDuration.longValue() : 0L, type, size, r332 != null ? r332.floatValue() : 0.0f, extras, picClipRect, reversePath == null ? "" : reversePath, normalPath == null ? "" : normalPath, isReverseMode, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (other == this) {
            return true;
        }
        if (!(other instanceof ResourceModel)) {
            return false;
        }
        ResourceModel resourceModel = (ResourceModel) other;
        if (Intrinsics.areEqual(unknownFields(), resourceModel.unknownFields()) && Intrinsics.areEqual(this.id, resourceModel.id) && Intrinsics.areEqual(this.path, resourceModel.path) && this.scaleDuration == resourceModel.scaleDuration && this.sourceStart == resourceModel.sourceStart && this.sourceDuration == resourceModel.sourceDuration && this.selectStart == resourceModel.selectStart && this.selectDuration == resourceModel.selectDuration && this.type == resourceModel.type && Intrinsics.areEqual(this.size, resourceModel.size)) {
            if (this.volume == resourceModel.volume) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && Intrinsics.areEqual(this.extras, resourceModel.extras) && Intrinsics.areEqual(this.picClipRect, resourceModel.picClipRect) && Intrinsics.areEqual(this.reversePath, resourceModel.reversePath) && Intrinsics.areEqual(this.normalPath, resourceModel.normalPath) && Intrinsics.areEqual(this.isReverseMode, resourceModel.isReverseMode)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18 = this.hashCode;
        if (i18 == 0) {
            int hashCode = ((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.path.hashCode()) * 37) + androidx.fragment.app.a.a(this.scaleDuration)) * 37) + androidx.fragment.app.a.a(this.sourceStart)) * 37) + androidx.fragment.app.a.a(this.sourceDuration)) * 37) + androidx.fragment.app.a.a(this.selectStart)) * 37) + androidx.fragment.app.a.a(this.selectDuration)) * 37;
            MediaType mediaType = this.type;
            int i19 = 0;
            if (mediaType != null) {
                i3 = mediaType.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            SizeF sizeF = this.size;
            if (sizeF != null) {
                i16 = sizeF.hashCode();
            } else {
                i16 = 0;
            }
            int floatToIntBits = (((((i26 + i16) * 37) + Float.floatToIntBits(this.volume)) * 37) + this.extras.hashCode()) * 37;
            RectF rectF = this.picClipRect;
            if (rectF != null) {
                i17 = rectF.hashCode();
            } else {
                i17 = 0;
            }
            int hashCode2 = (((((floatToIntBits + i17) * 37) + this.reversePath.hashCode()) * 37) + this.normalPath.hashCode()) * 37;
            Boolean bool = this.isReverseMode;
            if (bool != null) {
                i19 = bool.hashCode();
            }
            int i27 = hashCode2 + i19;
            this.hashCode = i27;
            return i27;
        }
        return i18;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        String str = this.id;
        if (str != null) {
            arrayList.add("id=" + Internal.sanitize(str));
        }
        String str2 = this.path;
        if (str2 != null) {
            arrayList.add("path=" + Internal.sanitize(str2));
        }
        arrayList.add("scaleDuration=" + this.scaleDuration);
        arrayList.add("sourceStart=" + this.sourceStart);
        arrayList.add("sourceDuration=" + this.sourceDuration);
        arrayList.add("selectStart=" + this.selectStart);
        arrayList.add("selectDuration=" + this.selectDuration);
        MediaType mediaType = this.type;
        if (mediaType != null) {
            arrayList.add("type=" + mediaType);
        }
        SizeF sizeF = this.size;
        if (sizeF != null) {
            arrayList.add("size=" + sizeF);
        }
        arrayList.add("volume=" + this.volume);
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        RectF rectF = this.picClipRect;
        if (rectF != null) {
            arrayList.add("picClipRect=" + rectF);
        }
        String str3 = this.reversePath;
        if (str3 != null) {
            arrayList.add("reversePath=" + Internal.sanitize(str3));
        }
        String str4 = this.normalPath;
        if (str4 != null) {
            arrayList.add("normalPath=" + Internal.sanitize(str4));
        }
        Boolean bool = this.isReverseMode;
        if (bool != null) {
            arrayList.add("isReverseMode=" + bool);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ResourceModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ ResourceModel(String str, String str2, long j3, long j16, long j17, long j18, long j19, MediaType mediaType, SizeF sizeF, float f16, Map map, RectF rectF, String str3, String str4, Boolean bool, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j16, (i3 & 16) != 0 ? 0L : j17, (i3 & 32) != 0 ? 0L : j18, (i3 & 64) == 0 ? j19 : 0L, (i3 & 128) != 0 ? null : mediaType, (i3 & 256) != 0 ? null : sizeF, (i3 & 512) != 0 ? 0.0f : f16, (i3 & 1024) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i3 & 2048) != 0 ? null : rectF, (i3 & 4096) != 0 ? "" : str3, (i3 & 8192) != 0 ? "" : str4, (i3 & 16384) != 0 ? null : bool, (i3 & 32768) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.path = this.path;
        aVar.scaleDuration = this.scaleDuration;
        aVar.com.tencent.mobileqq.tritonaudio.WebAudioPlugin.API_SOURCE_START java.lang.String = this.sourceStart;
        aVar.sourceDuration = this.sourceDuration;
        aVar.selectStart = this.selectStart;
        aVar.selectDuration = this.selectDuration;
        aVar.type = this.type;
        aVar.size = this.size;
        aVar.com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.AUDIO_PROPERTY_VOLUME java.lang.String = Float.valueOf(this.volume);
        aVar.extras = this.extras;
        aVar.picClipRect = this.picClipRect;
        aVar.reversePath = this.reversePath;
        aVar.normalPath = this.normalPath;
        aVar.isReverseMode = this.isReverseMode;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceModel(@NotNull String id5, @NotNull String path, long j3, long j16, long j17, long j18, long j19, @Nullable MediaType mediaType, @Nullable SizeF sizeF, float f16, @NotNull Map<String, String> extras, @Nullable RectF rectF, @NotNull String reversePath, @NotNull String normalPath, @Nullable Boolean bool, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(reversePath, "reversePath");
        Intrinsics.checkNotNullParameter(normalPath, "normalPath");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.id = id5;
        this.path = path;
        this.scaleDuration = j3;
        this.sourceStart = j16;
        this.sourceDuration = j17;
        this.selectStart = j18;
        this.selectDuration = j19;
        this.type = mediaType;
        this.size = sizeF;
        this.volume = f16;
        this.extras = extras;
        this.picClipRect = rectF;
        this.reversePath = reversePath;
        this.normalPath = normalPath;
        this.isReverseMode = bool;
    }
}
