package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000512345B\u00cd\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0015\u0012\b\b\u0002\u0010$\u001a\u00020#\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u00eb\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\b\b\u0002\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&R\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010'R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010'R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010(R\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010(R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0014\u0010\u0014\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010)R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010*R\u0014\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010'R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010+R\u0014\u0010\u001a\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010(R\u0014\u0010\u001b\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010(R\u0014\u0010\u001c\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(R\u0014\u0010\u001d\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010,R\u0016\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010-R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010*\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "path", "", "sourceStartTime", "sourceDuration", "startTimeInTimeline", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "speed", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect;", JsonUtils.KEY_VOLUME_EFFECTS, "name", "timelineTrackIndex", "selectStartTime", "selectDuration", "fadeInDuration", "fadeOutDuration", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;", "lyricInfo", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;", "type", "waveSampleData", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;Ljava/util/List;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "Ljava/lang/String;", "J", UserInfo.SEX_FEMALE, "Ljava/util/List;", "Ljava/lang/Integer;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJJFFLjava/util/List;Ljava/lang/String;Ljava/lang/Integer;JJJJLcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;Ljava/util/List;Lokio/ByteString;)V", "Companion", "a", "c", "LyricInfo", "Type", "VolumeEffect", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AudioModel extends AndroidMessage<AudioModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<AudioModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AudioModel> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 13)
    @JvmField
    public final long fadeInDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 14)
    @JvmField
    public final long fadeOutDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String id;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel$LyricInfo#ADAPTER", tag = 15)
    @JvmField
    @Nullable
    public final LyricInfo lyricInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @JvmField
    @NotNull
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 12)
    @JvmField
    public final long selectDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 11)
    @JvmField
    public final long selectStartTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    public final long sourceDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    @JvmField
    public final long sourceStartTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
    @JvmField
    public final float speed;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @JvmField
    public final long startTimeInTimeline;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @JvmField
    @Nullable
    public final Integer timelineTrackIndex;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel$Type#ADAPTER", tag = 16)
    @JvmField
    @Nullable
    public final Type type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    public final float volume;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel$VolumeEffect#ADAPTER", label = WireField.Label.REPEATED, tag = 8)
    @JvmField
    @NotNull
    public final List<VolumeEffect> volumeEffects;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 17)
    @JvmField
    @NotNull
    public final List<Integer> waveSampleData;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B/\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J4\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "strFormat", "strLyric", "strMatchLyric", "Lokio/ByteString;", "unknownFields", "copy", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class LyricInfo extends AndroidMessage<LyricInfo, a> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<LyricInfo> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<LyricInfo> CREATOR;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        @JvmField
        @NotNull
        public final String strFormat;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
        @JvmField
        @NotNull
        public final String strLyric;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
        @JvmField
        @NotNull
        public final String strMatchLyric;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;", "a", "", "Ljava/lang/String;", "strFormat", "b", "strLyric", "c", "strMatchLyric", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends Message.Builder<LyricInfo, a> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @JvmField
            @NotNull
            public String strFormat = "";

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @JvmField
            @NotNull
            public String strLyric = "";

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @JvmField
            @NotNull
            public String strMatchLyric = "";

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LyricInfo build() {
                return new LyricInfo(this.strFormat, this.strLyric, this.strMatchLyric, buildUnknownFields());
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class b extends ProtoAdapter<LyricInfo> {
            b(FieldEncoding fieldEncoding, KClass<LyricInfo> kClass) {
                super(fieldEncoding, kClass, "type.googleapis.com/publisher.AudioModel.LyricInfo");
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LyricInfo decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = "";
                String str2 = "";
                String str3 = str2;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        if (nextTag != 1) {
                            if (nextTag != 2) {
                                if (nextTag != 3) {
                                    reader.readUnknownField(nextTag);
                                } else {
                                    str3 = ProtoAdapter.STRING.decode(reader);
                                }
                            } else {
                                str2 = ProtoAdapter.STRING.decode(reader);
                            }
                        } else {
                            str = ProtoAdapter.STRING.decode(reader);
                        }
                    } else {
                        return new LyricInfo(str, str2, str3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void encode(@NotNull ProtoWriter writer, @NotNull LyricInfo value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
                protoAdapter.encodeWithTag(writer, 1, value.strFormat);
                protoAdapter.encodeWithTag(writer, 2, value.strLyric);
                protoAdapter.encodeWithTag(writer, 3, value.strMatchLyric);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public int encodedSize(@NotNull LyricInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
                return protoAdapter.encodedSizeWithTag(1, value.strFormat) + protoAdapter.encodedSizeWithTag(2, value.strLyric) + protoAdapter.encodedSizeWithTag(3, value.strMatchLyric) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public LyricInfo redact(@NotNull LyricInfo value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return LyricInfo.copy$default(value, null, null, null, ByteString.EMPTY, 7, null);
            }
        }

        static {
            b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LyricInfo.class));
            ADAPTER = bVar;
            CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
        }

        public LyricInfo() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ LyricInfo copy$default(LyricInfo lyricInfo, String str, String str2, String str3, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = lyricInfo.strFormat;
            }
            if ((i3 & 2) != 0) {
                str2 = lyricInfo.strLyric;
            }
            if ((i3 & 4) != 0) {
                str3 = lyricInfo.strMatchLyric;
            }
            if ((i3 & 8) != 0) {
                byteString = lyricInfo.unknownFields();
            }
            return lyricInfo.copy(str, str2, str3, byteString);
        }

        @NotNull
        public final LyricInfo copy(@Nullable String strFormat, @Nullable String strLyric, @Nullable String strMatchLyric, @NotNull ByteString unknownFields) {
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            if (strFormat == null) {
                strFormat = "";
            }
            if (strLyric == null) {
                strLyric = "";
            }
            if (strMatchLyric == null) {
                strMatchLyric = "";
            }
            return new LyricInfo(strFormat, strLyric, strMatchLyric, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof LyricInfo)) {
                return false;
            }
            LyricInfo lyricInfo = (LyricInfo) other;
            if (Intrinsics.areEqual(unknownFields(), lyricInfo.unknownFields()) && Intrinsics.areEqual(this.strFormat, lyricInfo.strFormat) && Intrinsics.areEqual(this.strLyric, lyricInfo.strLyric) && Intrinsics.areEqual(this.strMatchLyric, lyricInfo.strMatchLyric)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3 = this.hashCode;
            if (i3 == 0) {
                int hashCode = (((((unknownFields().hashCode() * 37) + this.strFormat.hashCode()) * 37) + this.strLyric.hashCode()) * 37) + this.strMatchLyric.hashCode();
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
            String str = this.strFormat;
            if (str != null) {
                arrayList.add("strFormat=" + Internal.sanitize(str));
            }
            String str2 = this.strLyric;
            if (str2 != null) {
                arrayList.add("strLyric=" + Internal.sanitize(str2));
            }
            String str3 = this.strMatchLyric;
            if (str3 != null) {
                arrayList.add("strMatchLyric=" + Internal.sanitize(str3));
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "LyricInfo{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ LyricInfo(String str, String str2, String str3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? ByteString.EMPTY : byteString);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public a newBuilder() {
            a aVar = new a();
            aVar.strFormat = this.strFormat;
            aVar.strLyric = this.strLyric;
            aVar.strMatchLyric = this.strMatchLyric;
            aVar.addUnknownFields(unknownFields());
            return aVar;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LyricInfo(@NotNull String strFormat, @NotNull String strLyric, @NotNull String strMatchLyric, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(strFormat, "strFormat");
            Intrinsics.checkNotNullParameter(strLyric, "strLyric");
            Intrinsics.checkNotNullParameter(strMatchLyric, "strMatchLyric");
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            this.strFormat = strFormat;
            this.strLyric = strLyric;
            this.strMatchLyric = strMatchLyric;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;", "", "Lcom/squareup/wire/WireEnum;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "b", "MUSIC", "RECORD", "SOUND", "EXTRACT", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public enum Type implements WireEnum {
        MUSIC(0),
        RECORD(1),
        SOUND(2),
        EXTRACT(3);

        private final int value;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        @NotNull
        public static final ProtoAdapter<Type> ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class));

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type$a", "Lcom/squareup/wire/EnumAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;", "", "value", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends EnumAdapter<Type> {
            a(KClass<Type> kClass) {
                super(kClass);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.squareup.wire.EnumAdapter
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Type fromValue(int value) {
                return Type.INSTANCE.a(value);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type$b;", "", "", "value", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;", "a", "Lcom/squareup/wire/ProtoAdapter;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel$Type$b, reason: from kotlin metadata */
        /* loaded from: classes17.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final Type a(int value) {
                if (value != 0) {
                    if (value != 1) {
                        if (value != 2) {
                            if (value != 3) {
                                return null;
                            }
                            return Type.EXTRACT;
                        }
                        return Type.SOUND;
                    }
                    return Type.RECORD;
                }
                return Type.MUSIC;
            }

            Companion() {
            }
        }

        Type(int i3) {
            this.value = i3;
        }

        @JvmStatic
        @Nullable
        public static final Type fromValue(int i3) {
            return INSTANCE.a(i3);
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dBC\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016JS\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "", "durationUs", "startOffsetUs", "endOffsetUs", "", "startVolume", "endVolume", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect;", "J", UserInfo.SEX_FEMALE, "<init>", "(JJJFFLokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class VolumeEffect extends AndroidMessage<VolumeEffect, a> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<VolumeEffect> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<VolumeEffect> CREATOR;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
        @JvmField
        public final long durationUs;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
        @JvmField
        public final long endOffsetUs;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
        @JvmField
        public final float endVolume;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
        @JvmField
        public final long startOffsetUs;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        @JvmField
        public final float startVolume;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect;", "a", "", "J", "durationUs", "b", "startOffsetUs", "c", "endOffsetUs", "", "d", UserInfo.SEX_FEMALE, "startVolume", "e", "endVolume", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class a extends Message.Builder<VolumeEffect, a> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @JvmField
            public long durationUs;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @JvmField
            public long startOffsetUs;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @JvmField
            public long endOffsetUs;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @JvmField
            public float startVolume;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @JvmField
            public float endVolume;

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public VolumeEffect build() {
                return new VolumeEffect(this.durationUs, this.startOffsetUs, this.endOffsetUs, this.startVolume, this.endVolume, buildUnknownFields());
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class b extends ProtoAdapter<VolumeEffect> {
            b(FieldEncoding fieldEncoding, KClass<VolumeEffect> kClass) {
                super(fieldEncoding, kClass, "type.googleapis.com/publisher.AudioModel.VolumeEffect");
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public VolumeEffect decode(@NotNull ProtoReader reader) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                long j3 = 0;
                long j16 = 0;
                long j17 = 0;
                float f16 = 0.0f;
                float f17 = 0.0f;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        if (nextTag != 1) {
                            if (nextTag != 2) {
                                if (nextTag != 3) {
                                    if (nextTag != 4) {
                                        if (nextTag != 5) {
                                            reader.readUnknownField(nextTag);
                                        } else {
                                            f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                        }
                                    } else {
                                        f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                    }
                                } else {
                                    j17 = ProtoAdapter.INT64.decode(reader).longValue();
                                }
                            } else {
                                j16 = ProtoAdapter.INT64.decode(reader).longValue();
                            }
                        } else {
                            j3 = ProtoAdapter.INT64.decode(reader).longValue();
                        }
                    } else {
                        return new VolumeEffect(j3, j16, j17, f16, f17, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void encode(@NotNull ProtoWriter writer, @NotNull VolumeEffect value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<Long> protoAdapter = ProtoAdapter.INT64;
                protoAdapter.encodeWithTag(writer, 1, Long.valueOf(value.durationUs));
                protoAdapter.encodeWithTag(writer, 2, Long.valueOf(value.startOffsetUs));
                protoAdapter.encodeWithTag(writer, 3, Long.valueOf(value.endOffsetUs));
                ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
                protoAdapter2.encodeWithTag(writer, 4, Float.valueOf(value.startVolume));
                protoAdapter2.encodeWithTag(writer, 5, Float.valueOf(value.endVolume));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public int encodedSize(@NotNull VolumeEffect value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<Long> protoAdapter = ProtoAdapter.INT64;
                int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, Long.valueOf(value.durationUs)) + protoAdapter.encodedSizeWithTag(2, Long.valueOf(value.startOffsetUs)) + protoAdapter.encodedSizeWithTag(3, Long.valueOf(value.endOffsetUs));
                ProtoAdapter<Float> protoAdapter2 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(4, Float.valueOf(value.startVolume)) + protoAdapter2.encodedSizeWithTag(5, Float.valueOf(value.endVolume)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public VolumeEffect redact(@NotNull VolumeEffect value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return VolumeEffect.copy$default(value, null, null, null, null, null, ByteString.EMPTY, 31, null);
            }
        }

        static {
            b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VolumeEffect.class));
            ADAPTER = bVar;
            CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
        }

        public VolumeEffect() {
            this(0L, 0L, 0L, 0.0f, 0.0f, null, 63, null);
        }

        public static /* synthetic */ VolumeEffect copy$default(VolumeEffect volumeEffect, Long l3, Long l16, Long l17, Float f16, Float f17, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                l3 = Long.valueOf(volumeEffect.durationUs);
            }
            if ((i3 & 2) != 0) {
                l16 = Long.valueOf(volumeEffect.startOffsetUs);
            }
            Long l18 = l16;
            if ((i3 & 4) != 0) {
                l17 = Long.valueOf(volumeEffect.endOffsetUs);
            }
            Long l19 = l17;
            if ((i3 & 8) != 0) {
                f16 = Float.valueOf(volumeEffect.startVolume);
            }
            Float f18 = f16;
            if ((i3 & 16) != 0) {
                f17 = Float.valueOf(volumeEffect.endVolume);
            }
            Float f19 = f17;
            if ((i3 & 32) != 0) {
                byteString = volumeEffect.unknownFields();
            }
            return volumeEffect.copy(l3, l18, l19, f18, f19, byteString);
        }

        @NotNull
        public final VolumeEffect copy(@Nullable Long durationUs, @Nullable Long startOffsetUs, @Nullable Long endOffsetUs, @Nullable Float startVolume, @Nullable Float endVolume, @NotNull ByteString unknownFields) {
            long j3;
            long j16;
            float f16;
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            long j17 = 0;
            if (durationUs != null) {
                j3 = durationUs.longValue();
            } else {
                j3 = 0;
            }
            if (startOffsetUs != null) {
                j16 = startOffsetUs.longValue();
            } else {
                j16 = 0;
            }
            if (endOffsetUs != null) {
                j17 = endOffsetUs.longValue();
            }
            long j18 = j17;
            float f17 = 0.0f;
            if (startVolume != null) {
                f16 = startVolume.floatValue();
            } else {
                f16 = 0.0f;
            }
            if (endVolume != null) {
                f17 = endVolume.floatValue();
            }
            return new VolumeEffect(j3, j16, j18, f16, f17, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            boolean z16;
            boolean z17;
            if (other == this) {
                return true;
            }
            if (!(other instanceof VolumeEffect)) {
                return false;
            }
            VolumeEffect volumeEffect = (VolumeEffect) other;
            if (Intrinsics.areEqual(unknownFields(), volumeEffect.unknownFields()) && this.durationUs == volumeEffect.durationUs && this.startOffsetUs == volumeEffect.startOffsetUs && this.endOffsetUs == volumeEffect.endOffsetUs) {
                if (this.startVolume == volumeEffect.startVolume) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (this.endVolume == volumeEffect.endVolume) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int i3 = this.hashCode;
            if (i3 == 0) {
                int hashCode = (((((((((unknownFields().hashCode() * 37) + androidx.fragment.app.a.a(this.durationUs)) * 37) + androidx.fragment.app.a.a(this.startOffsetUs)) * 37) + androidx.fragment.app.a.a(this.endOffsetUs)) * 37) + Float.floatToIntBits(this.startVolume)) * 37) + Float.floatToIntBits(this.endVolume);
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
            arrayList.add("durationUs=" + this.durationUs);
            arrayList.add("startOffsetUs=" + this.startOffsetUs);
            arrayList.add("endOffsetUs=" + this.endOffsetUs);
            arrayList.add("startVolume=" + this.startVolume);
            arrayList.add("endVolume=" + this.endVolume);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "VolumeEffect{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ VolumeEffect(long j3, long j16, long j17, float f16, float f17, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) == 0 ? j17 : 0L, (i3 & 8) != 0 ? 0.0f : f16, (i3 & 16) == 0 ? f17 : 0.0f, (i3 & 32) != 0 ? ByteString.EMPTY : byteString);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public a newBuilder() {
            a aVar = new a();
            aVar.durationUs = this.durationUs;
            aVar.startOffsetUs = this.startOffsetUs;
            aVar.endOffsetUs = this.endOffsetUs;
            aVar.startVolume = this.startVolume;
            aVar.endVolume = this.endVolume;
            aVar.addUnknownFields(unknownFields());
            return aVar;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VolumeEffect(long j3, long j16, long j17, float f16, float f17, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            this.durationUs = j3;
            this.startOffsetUs = j16;
            this.endOffsetUs = j17;
            this.startVolume = f16;
            this.endVolume = f17;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0005R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u000bR\u0016\u0010%\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u000bR\u0016\u0010'\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u000bR\u0016\u0010)\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u000bR\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001a\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "a", "", "Ljava/lang/String;", "id", "b", "path", "", "c", "J", "sourceStartTime", "d", "sourceDuration", "e", "startTimeInTimeline", "", "f", UserInfo.SEX_FEMALE, InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "g", "speed", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$VolumeEffect;", h.F, "Ljava/util/List;", JsonUtils.KEY_VOLUME_EFFECTS, "i", "name", "", "j", "Ljava/lang/Integer;", "timelineTrackIndex", "k", "selectStartTime", "l", "selectDuration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "fadeInDuration", DomainData.DOMAIN_NAME, "fadeOutDuration", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;", "o", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$LyricInfo;", "lyricInfo", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;", "p", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$Type;", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "waveSampleData", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<AudioModel, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String id = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String path = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long sourceStartTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long sourceDuration;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long startTimeInTimeline;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float volume;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float speed;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public List<VolumeEffect> volumeEffects;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String name;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer timelineTrackIndex;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long selectStartTime;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long selectDuration;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long fadeInDuration;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long fadeOutDuration;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public LyricInfo lyricInfo;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Type type;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public List<Integer> waveSampleData;

        public a() {
            List<VolumeEffect> emptyList;
            List<Integer> emptyList2;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.volumeEffects = emptyList;
            this.name = "";
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.waveSampleData = emptyList2;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AudioModel build() {
            return new AudioModel(this.id, this.path, this.sourceStartTime, this.sourceDuration, this.startTimeInTimeline, this.volume, this.speed, this.volumeEffects, this.name, this.timelineTrackIndex, this.selectStartTime, this.selectDuration, this.fadeInDuration, this.fadeOutDuration, this.lyricInfo, this.type, this.waveSampleData, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<AudioModel> {
        b(FieldEncoding fieldEncoding, KClass<AudioModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.AudioModel");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AudioModel decode(@NotNull ProtoReader reader) {
            long j3;
            Intrinsics.checkNotNullParameter(reader, "reader");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            long beginMessage = reader.beginMessage();
            long j16 = 0;
            long j17 = 0;
            long j18 = 0;
            long j19 = 0;
            long j26 = 0;
            long j27 = 0;
            float f16 = 0.0f;
            float f17 = 0.0f;
            Integer num = null;
            LyricInfo lyricInfo = null;
            Type type = null;
            String str = "";
            String str2 = str;
            String str3 = str2;
            long j28 = 0;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 3:
                            j28 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 4:
                            j16 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 5:
                            j17 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 6:
                            f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            continue;
                        case 7:
                            f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            continue;
                        case 8:
                            j3 = j16;
                            arrayList.add(VolumeEffect.ADAPTER.decode(reader));
                            break;
                        case 9:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 10:
                            num = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 11:
                            j18 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 12:
                            j19 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 13:
                            j26 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 14:
                            j27 = ProtoAdapter.INT64.decode(reader).longValue();
                            continue;
                        case 15:
                            lyricInfo = LyricInfo.ADAPTER.decode(reader);
                            continue;
                        case 16:
                            try {
                                type = Type.ADAPTER.decode(reader);
                                continue;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                j3 = j16;
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 17:
                            arrayList2.add(ProtoAdapter.INT32.decode(reader));
                            j3 = j16;
                            break;
                        default:
                            j3 = j16;
                            reader.readUnknownField(nextTag);
                            break;
                    }
                    j16 = j3;
                } else {
                    return new AudioModel(str, str2, j28, j16, j17, f16, f17, arrayList, str3, num, j18, j19, j26, j27, lyricInfo, type, arrayList2, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull AudioModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.id);
            protoAdapter.encodeWithTag(writer, 2, value.path);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
            protoAdapter2.encodeWithTag(writer, 3, Long.valueOf(value.sourceStartTime));
            protoAdapter2.encodeWithTag(writer, 4, Long.valueOf(value.sourceDuration));
            protoAdapter2.encodeWithTag(writer, 5, Long.valueOf(value.startTimeInTimeline));
            ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
            protoAdapter3.encodeWithTag(writer, 6, Float.valueOf(value.volume));
            protoAdapter3.encodeWithTag(writer, 7, Float.valueOf(value.speed));
            VolumeEffect.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.volumeEffects);
            protoAdapter.encodeWithTag(writer, 9, value.name);
            ProtoAdapter<Integer> protoAdapter4 = ProtoAdapter.INT32;
            protoAdapter4.encodeWithTag(writer, 10, value.timelineTrackIndex);
            protoAdapter2.encodeWithTag(writer, 11, Long.valueOf(value.selectStartTime));
            protoAdapter2.encodeWithTag(writer, 12, Long.valueOf(value.selectDuration));
            protoAdapter2.encodeWithTag(writer, 13, Long.valueOf(value.fadeInDuration));
            protoAdapter2.encodeWithTag(writer, 14, Long.valueOf(value.fadeOutDuration));
            LyricInfo.ADAPTER.encodeWithTag(writer, 15, value.lyricInfo);
            Type.ADAPTER.encodeWithTag(writer, 16, value.type);
            protoAdapter4.asRepeated().encodeWithTag(writer, 17, value.waveSampleData);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull AudioModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, value.id) + protoAdapter.encodedSizeWithTag(2, value.path);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(3, Long.valueOf(value.sourceStartTime)) + protoAdapter2.encodedSizeWithTag(4, Long.valueOf(value.sourceDuration)) + protoAdapter2.encodedSizeWithTag(5, Long.valueOf(value.startTimeInTimeline));
            ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter3.encodedSizeWithTag(6, Float.valueOf(value.volume)) + protoAdapter3.encodedSizeWithTag(7, Float.valueOf(value.speed)) + VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(8, value.volumeEffects) + protoAdapter.encodedSizeWithTag(9, value.name);
            ProtoAdapter<Integer> protoAdapter4 = ProtoAdapter.INT32;
            return encodedSizeWithTag3 + protoAdapter4.encodedSizeWithTag(10, value.timelineTrackIndex) + protoAdapter2.encodedSizeWithTag(11, Long.valueOf(value.selectStartTime)) + protoAdapter2.encodedSizeWithTag(12, Long.valueOf(value.selectDuration)) + protoAdapter2.encodedSizeWithTag(13, Long.valueOf(value.fadeInDuration)) + protoAdapter2.encodedSizeWithTag(14, Long.valueOf(value.fadeOutDuration)) + LyricInfo.ADAPTER.encodedSizeWithTag(15, value.lyricInfo) + Type.ADAPTER.encodedSizeWithTag(16, value.type) + protoAdapter4.asRepeated().encodedSizeWithTag(17, value.waveSampleData) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AudioModel redact(@NotNull AudioModel value) {
            LyricInfo lyricInfo;
            Intrinsics.checkNotNullParameter(value, "value");
            List m87redactElements = Internal.m87redactElements(value.volumeEffects, VolumeEffect.ADAPTER);
            LyricInfo lyricInfo2 = value.lyricInfo;
            if (lyricInfo2 != null) {
                lyricInfo = LyricInfo.ADAPTER.redact(lyricInfo2);
            } else {
                lyricInfo = null;
            }
            return AudioModel.copy$default(value, null, null, null, null, null, null, null, m87redactElements, null, null, null, null, null, null, lyricInfo, null, null, ByteString.EMPTY, 114559, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AudioModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public AudioModel() {
        this(null, null, 0L, 0L, 0L, 0.0f, 0.0f, null, null, null, 0L, 0L, 0L, 0L, null, null, null, null, 262143, null);
    }

    public static /* synthetic */ AudioModel copy$default(AudioModel audioModel, String str, String str2, Long l3, Long l16, Long l17, Float f16, Float f17, List list, String str3, Integer num, Long l18, Long l19, Long l26, Long l27, LyricInfo lyricInfo, Type type, List list2, ByteString byteString, int i3, Object obj) {
        return audioModel.copy((i3 & 1) != 0 ? audioModel.id : str, (i3 & 2) != 0 ? audioModel.path : str2, (i3 & 4) != 0 ? Long.valueOf(audioModel.sourceStartTime) : l3, (i3 & 8) != 0 ? Long.valueOf(audioModel.sourceDuration) : l16, (i3 & 16) != 0 ? Long.valueOf(audioModel.startTimeInTimeline) : l17, (i3 & 32) != 0 ? Float.valueOf(audioModel.volume) : f16, (i3 & 64) != 0 ? Float.valueOf(audioModel.speed) : f17, (i3 & 128) != 0 ? audioModel.volumeEffects : list, (i3 & 256) != 0 ? audioModel.name : str3, (i3 & 512) != 0 ? audioModel.timelineTrackIndex : num, (i3 & 1024) != 0 ? Long.valueOf(audioModel.selectStartTime) : l18, (i3 & 2048) != 0 ? Long.valueOf(audioModel.selectDuration) : l19, (i3 & 4096) != 0 ? Long.valueOf(audioModel.fadeInDuration) : l26, (i3 & 8192) != 0 ? Long.valueOf(audioModel.fadeOutDuration) : l27, (i3 & 16384) != 0 ? audioModel.lyricInfo : lyricInfo, (i3 & 32768) != 0 ? audioModel.type : type, (i3 & 65536) != 0 ? audioModel.waveSampleData : list2, (i3 & 131072) != 0 ? audioModel.unknownFields() : byteString);
    }

    @NotNull
    public final AudioModel copy(@Nullable String id5, @Nullable String path, @Nullable Long sourceStartTime, @Nullable Long sourceDuration, @Nullable Long startTimeInTimeline, @Nullable Float volume, @Nullable Float speed, @NotNull List<VolumeEffect> volumeEffects, @Nullable String name, @Nullable Integer timelineTrackIndex, @Nullable Long selectStartTime, @Nullable Long selectDuration, @Nullable Long fadeInDuration, @Nullable Long fadeOutDuration, @Nullable LyricInfo lyricInfo, @Nullable Type type, @NotNull List<Integer> waveSampleData, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(volumeEffects, "volumeEffects");
        Intrinsics.checkNotNullParameter(waveSampleData, "waveSampleData");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new AudioModel(id5 == null ? "" : id5, path == null ? "" : path, sourceStartTime != null ? sourceStartTime.longValue() : 0L, sourceDuration != null ? sourceDuration.longValue() : 0L, startTimeInTimeline != null ? startTimeInTimeline.longValue() : 0L, volume != null ? volume.floatValue() : 0.0f, speed != null ? speed.floatValue() : 0.0f, volumeEffects, name == null ? "" : name, timelineTrackIndex, selectStartTime != null ? selectStartTime.longValue() : 0L, selectDuration != null ? selectDuration.longValue() : 0L, fadeInDuration != null ? fadeInDuration.longValue() : 0L, fadeOutDuration != null ? fadeOutDuration.longValue() : 0L, lyricInfo, type, waveSampleData, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        if (other == this) {
            return true;
        }
        if (!(other instanceof AudioModel)) {
            return false;
        }
        AudioModel audioModel = (AudioModel) other;
        if (Intrinsics.areEqual(unknownFields(), audioModel.unknownFields()) && Intrinsics.areEqual(this.id, audioModel.id) && Intrinsics.areEqual(this.path, audioModel.path) && this.sourceStartTime == audioModel.sourceStartTime && this.sourceDuration == audioModel.sourceDuration && this.startTimeInTimeline == audioModel.startTimeInTimeline) {
            if (this.volume == audioModel.volume) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.speed == audioModel.speed) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && Intrinsics.areEqual(this.volumeEffects, audioModel.volumeEffects) && Intrinsics.areEqual(this.name, audioModel.name) && Intrinsics.areEqual(this.timelineTrackIndex, audioModel.timelineTrackIndex) && this.selectStartTime == audioModel.selectStartTime && this.selectDuration == audioModel.selectDuration && this.fadeInDuration == audioModel.fadeInDuration && this.fadeOutDuration == audioModel.fadeOutDuration && Intrinsics.areEqual(this.lyricInfo, audioModel.lyricInfo) && this.type == audioModel.type && Intrinsics.areEqual(this.waveSampleData, audioModel.waveSampleData)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = ((((((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.path.hashCode()) * 37) + androidx.fragment.app.a.a(this.sourceStartTime)) * 37) + androidx.fragment.app.a.a(this.sourceDuration)) * 37) + androidx.fragment.app.a.a(this.startTimeInTimeline)) * 37) + Float.floatToIntBits(this.volume)) * 37) + Float.floatToIntBits(this.speed)) * 37) + this.volumeEffects.hashCode()) * 37) + this.name.hashCode()) * 37;
            Integer num = this.timelineTrackIndex;
            int i18 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = (((((((((hashCode + i3) * 37) + androidx.fragment.app.a.a(this.selectStartTime)) * 37) + androidx.fragment.app.a.a(this.selectDuration)) * 37) + androidx.fragment.app.a.a(this.fadeInDuration)) * 37) + androidx.fragment.app.a.a(this.fadeOutDuration)) * 37;
            LyricInfo lyricInfo = this.lyricInfo;
            if (lyricInfo != null) {
                i16 = lyricInfo.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (a16 + i16) * 37;
            Type type = this.type;
            if (type != null) {
                i18 = type.hashCode();
            }
            int hashCode2 = ((i19 + i18) * 37) + this.waveSampleData.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i17;
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
        arrayList.add("sourceStartTime=" + this.sourceStartTime);
        arrayList.add("sourceDuration=" + this.sourceDuration);
        arrayList.add("startTimeInTimeline=" + this.startTimeInTimeline);
        arrayList.add("volume=" + this.volume);
        arrayList.add("speed=" + this.speed);
        if (!this.volumeEffects.isEmpty()) {
            arrayList.add("volumeEffects=" + this.volumeEffects);
        }
        String str3 = this.name;
        if (str3 != null) {
            arrayList.add("name=" + Internal.sanitize(str3));
        }
        Integer num = this.timelineTrackIndex;
        if (num != null) {
            arrayList.add("timelineTrackIndex=" + num);
        }
        arrayList.add("selectStartTime=" + this.selectStartTime);
        arrayList.add("selectDuration=" + this.selectDuration);
        arrayList.add("fadeInDuration=" + this.fadeInDuration);
        arrayList.add("fadeOutDuration=" + this.fadeOutDuration);
        LyricInfo lyricInfo = this.lyricInfo;
        if (lyricInfo != null) {
            arrayList.add("lyricInfo=" + lyricInfo);
        }
        Type type = this.type;
        if (type != null) {
            arrayList.add("type=" + type);
        }
        if (!this.waveSampleData.isEmpty()) {
            arrayList.add("waveSampleData=" + this.waveSampleData);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "AudioModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ AudioModel(String str, String str2, long j3, long j16, long j17, float f16, float f17, List list, String str3, Integer num, long j18, long j19, long j26, long j27, LyricInfo lyricInfo, Type type, List list2, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j16, (i3 & 16) != 0 ? 0L : j17, (i3 & 32) != 0 ? 0.0f : f16, (i3 & 64) == 0 ? f17 : 0.0f, (i3 & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 256) == 0 ? str3 : "", (i3 & 512) != 0 ? null : num, (i3 & 1024) != 0 ? 0L : j18, (i3 & 2048) != 0 ? 0L : j19, (i3 & 4096) != 0 ? 0L : j26, (i3 & 8192) != 0 ? 0L : j27, (i3 & 16384) != 0 ? null : lyricInfo, (32768 & i3) == 0 ? type : null, (65536 & i3) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 131072) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.path = this.path;
        aVar.sourceStartTime = this.sourceStartTime;
        aVar.sourceDuration = this.sourceDuration;
        aVar.startTimeInTimeline = this.startTimeInTimeline;
        aVar.volume = this.volume;
        aVar.speed = this.speed;
        aVar.volumeEffects = this.volumeEffects;
        aVar.name = this.name;
        aVar.timelineTrackIndex = this.timelineTrackIndex;
        aVar.selectStartTime = this.selectStartTime;
        aVar.selectDuration = this.selectDuration;
        aVar.fadeInDuration = this.fadeInDuration;
        aVar.fadeOutDuration = this.fadeOutDuration;
        aVar.lyricInfo = this.lyricInfo;
        aVar.type = this.type;
        aVar.waveSampleData = this.waveSampleData;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioModel(@NotNull String id5, @NotNull String path, long j3, long j16, long j17, float f16, float f17, @NotNull List<VolumeEffect> volumeEffects, @NotNull String name, @Nullable Integer num, long j18, long j19, long j26, long j27, @Nullable LyricInfo lyricInfo, @Nullable Type type, @NotNull List<Integer> waveSampleData, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(volumeEffects, "volumeEffects");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(waveSampleData, "waveSampleData");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.id = id5;
        this.path = path;
        this.sourceStartTime = j3;
        this.sourceDuration = j16;
        this.startTimeInTimeline = j17;
        this.volume = f16;
        this.speed = f17;
        this.volumeEffects = volumeEffects;
        this.name = name;
        this.timelineTrackIndex = num;
        this.selectStartTime = j18;
        this.selectDuration = j19;
        this.fadeInDuration = j26;
        this.fadeOutDuration = j27;
        this.lyricInfo = lyricInfo;
        this.type = type;
        this.waveSampleData = waveSampleData;
    }
}
