package com.tencent.videocut.model;

import android.os.Parcelable;
import androidx.fragment.app.a;
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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.videocut.model.AudioModel;
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
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006+,-./0B\u00d7\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\u0002\u0010 J\u00f5\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010!R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/videocut/model/AudioModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/AudioModel$Builder;", "id", "", "path", "sourceStartTime", "", "sourceDuration", "startTimeInTimeline", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "speed", JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "name", "timelineTrackIndex", "", "selectStartTime", "selectDuration", "fadeInDuration", "fadeOutDuration", "lyricInfo", "Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "type", "Lcom/tencent/videocut/model/AudioModel$Type;", "waveSampleData", "event", "Lcom/tencent/videocut/model/AudioModel$Event;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;JJJFFLjava/util/List;Ljava/lang/String;Ljava/lang/Integer;JJJJLcom/tencent/videocut/model/AudioModel$LyricInfo;Lcom/tencent/videocut/model/AudioModel$Type;Ljava/util/List;Lcom/tencent/videocut/model/AudioModel$Event;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/videocut/model/AudioModel$LyricInfo;Lcom/tencent/videocut/model/AudioModel$Type;Ljava/util/List;Lcom/tencent/videocut/model/AudioModel$Event;Lokio/ByteString;)Lcom/tencent/videocut/model/AudioModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "Event", "LyricInfo", "Type", "VolumeEffect", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class AudioModel extends AndroidMessage<AudioModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<AudioModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AudioModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.tencent.videocut.model.AudioModel$Event#ADAPTER", tag = 18)
    @JvmField
    @Nullable
    public final Event event;

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

    @WireField(adapter = "com.tencent.videocut.model.AudioModel$LyricInfo#ADAPTER", tag = 15)
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

    @WireField(adapter = "com.tencent.videocut.model.AudioModel$Type#ADAPTER", tag = 16)
    @JvmField
    @Nullable
    public final Type type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    public final float volume;

    @WireField(adapter = "com.tencent.videocut.model.AudioModel$VolumeEffect#ADAPTER", label = WireField.Label.REPEATED, tag = 8)
    @JvmField
    @NotNull
    public final List<VolumeEffect> volumeEffects;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 17)
    @JvmField
    @NotNull
    public final List<Integer> waveSampleData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010!J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010!J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\"J\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010!J\u0015\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010#J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\"J\u0014\u0010\u001c\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0014\u0010\u001f\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/AudioModel;", "()V", "event", "Lcom/tencent/videocut/model/AudioModel$Event;", "fadeInDuration", "", "fadeOutDuration", "id", "", "lyricInfo", "Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "name", "path", "selectDuration", "selectStartTime", "sourceDuration", "sourceStartTime", "speed", "", "startTimeInTimeline", "timelineTrackIndex", "", "Ljava/lang/Integer;", "type", "Lcom/tencent/videocut/model/AudioModel$Type;", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "waveSampleData", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/AudioModel$Builder;", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/AudioModel$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/AudioModel$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<AudioModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public Event event;

        @JvmField
        public long fadeInDuration;

        @JvmField
        public long fadeOutDuration;

        @JvmField
        @NotNull
        public String id;

        @JvmField
        @Nullable
        public LyricInfo lyricInfo;

        @JvmField
        @NotNull
        public String name;

        @JvmField
        @NotNull
        public String path;

        @JvmField
        public long selectDuration;

        @JvmField
        public long selectStartTime;

        @JvmField
        public long sourceDuration;

        @JvmField
        public long sourceStartTime;

        @JvmField
        public float speed;

        @JvmField
        public long startTimeInTimeline;

        @JvmField
        @Nullable
        public Integer timelineTrackIndex;

        @JvmField
        @Nullable
        public Type type;

        @JvmField
        public float volume;

        @JvmField
        @NotNull
        public List<VolumeEffect> volumeEffects;

        @JvmField
        @NotNull
        public List<Integer> waveSampleData;

        public Builder() {
            List<VolumeEffect> emptyList;
            List<Integer> emptyList2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.id = "";
            this.path = "";
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.volumeEffects = emptyList;
            this.name = "";
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.waveSampleData = emptyList2;
        }

        @NotNull
        public final Builder event(@Nullable Event event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, (Object) event);
            }
            this.event = event;
            return this;
        }

        @NotNull
        public final Builder fadeInDuration(@Nullable Long fadeInDuration) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) fadeInDuration);
            }
            if (fadeInDuration != null) {
                j3 = fadeInDuration.longValue();
            } else {
                j3 = 0;
            }
            this.fadeInDuration = j3;
            return this;
        }

        @NotNull
        public final Builder fadeOutDuration(@Nullable Long fadeOutDuration) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) fadeOutDuration);
            }
            if (fadeOutDuration != null) {
                j3 = fadeOutDuration.longValue();
            } else {
                j3 = 0;
            }
            this.fadeOutDuration = j3;
            return this;
        }

        @NotNull
        public final Builder id(@Nullable String id5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5);
            }
            if (id5 == null) {
                id5 = "";
            }
            this.id = id5;
            return this;
        }

        @NotNull
        public final Builder lyricInfo(@Nullable LyricInfo lyricInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) lyricInfo);
            }
            this.lyricInfo = lyricInfo;
            return this;
        }

        @NotNull
        public final Builder name(@Nullable String name) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) name);
            }
            if (name == null) {
                name = "";
            }
            this.name = name;
            return this;
        }

        @NotNull
        public final Builder path(@Nullable String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
            }
            if (path == null) {
                path = "";
            }
            this.path = path;
            return this;
        }

        @NotNull
        public final Builder selectDuration(@Nullable Long selectDuration) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) selectDuration);
            }
            if (selectDuration != null) {
                j3 = selectDuration.longValue();
            } else {
                j3 = 0;
            }
            this.selectDuration = j3;
            return this;
        }

        @NotNull
        public final Builder selectStartTime(@Nullable Long selectStartTime) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) selectStartTime);
            }
            if (selectStartTime != null) {
                j3 = selectStartTime.longValue();
            } else {
                j3 = 0;
            }
            this.selectStartTime = j3;
            return this;
        }

        @NotNull
        public final Builder sourceDuration(@Nullable Long sourceDuration) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) sourceDuration);
            }
            if (sourceDuration != null) {
                j3 = sourceDuration.longValue();
            } else {
                j3 = 0;
            }
            this.sourceDuration = j3;
            return this;
        }

        @NotNull
        public final Builder sourceStartTime(@Nullable Long sourceStartTime) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) sourceStartTime);
            }
            if (sourceStartTime != null) {
                j3 = sourceStartTime.longValue();
            } else {
                j3 = 0;
            }
            this.sourceStartTime = j3;
            return this;
        }

        @NotNull
        public final Builder speed(@Nullable Float speed) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) speed);
            }
            if (speed != null) {
                f16 = speed.floatValue();
            } else {
                f16 = 0.0f;
            }
            this.speed = f16;
            return this;
        }

        @NotNull
        public final Builder startTimeInTimeline(@Nullable Long startTimeInTimeline) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) startTimeInTimeline);
            }
            if (startTimeInTimeline != null) {
                j3 = startTimeInTimeline.longValue();
            } else {
                j3 = 0;
            }
            this.startTimeInTimeline = j3;
            return this;
        }

        @NotNull
        public final Builder timelineTrackIndex(@Nullable Integer timelineTrackIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) timelineTrackIndex);
            }
            this.timelineTrackIndex = timelineTrackIndex;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable Type type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) type);
            }
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder volume(@Nullable Float f16) {
            float f17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) f16);
            }
            if (f16 != null) {
                f17 = f16.floatValue();
            } else {
                f17 = 0.0f;
            }
            this.volume = f17;
            return this;
        }

        @NotNull
        public final Builder volumeEffects(@NotNull List<VolumeEffect> volumeEffects) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) volumeEffects);
            }
            Intrinsics.checkNotNullParameter(volumeEffects, "volumeEffects");
            Internal.checkElementsNotNull(volumeEffects);
            this.volumeEffects = volumeEffects;
            return this;
        }

        @NotNull
        public final Builder waveSampleData(@NotNull List<Integer> waveSampleData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, (Object) waveSampleData);
            }
            Intrinsics.checkNotNullParameter(waveSampleData, "waveSampleData");
            Internal.checkElementsNotNull(waveSampleData);
            this.waveSampleData = waveSampleData;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public AudioModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? new AudioModel(this.id, this.path, this.sourceStartTime, this.sourceDuration, this.startTimeInTimeline, this.volume, this.speed, this.volumeEffects, this.name, this.timelineTrackIndex, this.selectStartTime, this.selectDuration, this.fadeInDuration, this.fadeOutDuration, this.lyricInfo, this.type, this.waveSampleData, this.event, buildUnknownFields()) : (AudioModel) iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aBo\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJp\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$Event;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/AudioModel$Event$Builder;", "defaultTrail", "", "", "highlightValueTrail", "drumTrail", "slowRhythmTrail", "startValueTrail", "paragraphTrail", "unknownFields", "Lokio/ByteString;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toCutEvent", "Lcom/tencent/tavcut/core/render/builder/light/model/Event;", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Event extends AndroidMessage<Event, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<Event> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<Event> CREATOR;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 1)
        @JvmField
        @NotNull
        public final List<Integer> defaultTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 3)
        @JvmField
        @NotNull
        public final List<Integer> drumTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 2)
        @JvmField
        @NotNull
        public final List<Integer> highlightValueTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 6)
        @JvmField
        @NotNull
        public final List<Integer> paragraphTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 4)
        @JvmField
        @NotNull
        public final List<Integer> slowRhythmTrail;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 5)
        @JvmField
        @NotNull
        public final List<Integer> startValueTrail;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\b\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\n\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$Event$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/AudioModel$Event;", "()V", "defaultTrail", "", "", "drumTrail", "highlightValueTrail", "paragraphTrail", "slowRhythmTrail", "startValueTrail", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Builder extends Message.Builder<Event, Builder> {
            static IPatchRedirector $redirector_;

            @JvmField
            @NotNull
            public List<Integer> defaultTrail;

            @JvmField
            @NotNull
            public List<Integer> drumTrail;

            @JvmField
            @NotNull
            public List<Integer> highlightValueTrail;

            @JvmField
            @NotNull
            public List<Integer> paragraphTrail;

            @JvmField
            @NotNull
            public List<Integer> slowRhythmTrail;

            @JvmField
            @NotNull
            public List<Integer> startValueTrail;

            public Builder() {
                List<Integer> emptyList;
                List<Integer> emptyList2;
                List<Integer> emptyList3;
                List<Integer> emptyList4;
                List<Integer> emptyList5;
                List<Integer> emptyList6;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    this.defaultTrail = emptyList;
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    this.highlightValueTrail = emptyList2;
                    emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                    this.drumTrail = emptyList3;
                    emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                    this.slowRhythmTrail = emptyList4;
                    emptyList5 = CollectionsKt__CollectionsKt.emptyList();
                    this.startValueTrail = emptyList5;
                    emptyList6 = CollectionsKt__CollectionsKt.emptyList();
                    this.paragraphTrail = emptyList6;
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }

            @NotNull
            public final Builder defaultTrail(@NotNull List<Integer> defaultTrail) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultTrail);
                }
                Intrinsics.checkNotNullParameter(defaultTrail, "defaultTrail");
                Internal.checkElementsNotNull(defaultTrail);
                this.defaultTrail = defaultTrail;
                return this;
            }

            @NotNull
            public final Builder drumTrail(@NotNull List<Integer> drumTrail) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) drumTrail);
                }
                Intrinsics.checkNotNullParameter(drumTrail, "drumTrail");
                Internal.checkElementsNotNull(drumTrail);
                this.drumTrail = drumTrail;
                return this;
            }

            @NotNull
            public final Builder highlightValueTrail(@NotNull List<Integer> highlightValueTrail) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) highlightValueTrail);
                }
                Intrinsics.checkNotNullParameter(highlightValueTrail, "highlightValueTrail");
                Internal.checkElementsNotNull(highlightValueTrail);
                this.highlightValueTrail = highlightValueTrail;
                return this;
            }

            @NotNull
            public final Builder paragraphTrail(@NotNull List<Integer> paragraphTrail) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) paragraphTrail);
                }
                Intrinsics.checkNotNullParameter(paragraphTrail, "paragraphTrail");
                Internal.checkElementsNotNull(paragraphTrail);
                this.paragraphTrail = paragraphTrail;
                return this;
            }

            @NotNull
            public final Builder slowRhythmTrail(@NotNull List<Integer> slowRhythmTrail) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) slowRhythmTrail);
                }
                Intrinsics.checkNotNullParameter(slowRhythmTrail, "slowRhythmTrail");
                Internal.checkElementsNotNull(slowRhythmTrail);
                this.slowRhythmTrail = slowRhythmTrail;
                return this;
            }

            @NotNull
            public final Builder startValueTrail(@NotNull List<Integer> startValueTrail) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) startValueTrail);
                }
                Intrinsics.checkNotNullParameter(startValueTrail, "startValueTrail");
                Internal.checkElementsNotNull(startValueTrail);
                this.startValueTrail = startValueTrail;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public Event build() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? new Event(this.defaultTrail, this.highlightValueTrail, this.drumTrail, this.slowRhythmTrail, this.startValueTrail, this.paragraphTrail, buildUnknownFields()) : (Event) iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$Event$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel$Event;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58357);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 10)) {
                redirector.redirect((short) 10);
                return;
            }
            INSTANCE = new Companion(null);
            ProtoAdapter<Event> protoAdapter = new ProtoAdapter<Event>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Event.class)) { // from class: com.tencent.videocut.model.AudioModel$Event$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(r4, r5, "type.googleapis.com/publisher.AudioModel.Event");
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, (Object) r5);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public AudioModel.Event decode(@NotNull ProtoReader reader) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return (AudioModel.Event) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                    }
                    Intrinsics.checkNotNullParameter(reader, "reader");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    long beginMessage = reader.beginMessage();
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag != -1) {
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
                        } else {
                            return new AudioModel.Event(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull AudioModel.Event value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(writer, "writer");
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    protoAdapter2.asRepeated().encodeWithTag(writer, 1, value.defaultTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 2, value.highlightValueTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 3, value.drumTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 4, value.slowRhythmTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 5, value.startValueTrail);
                    protoAdapter2.asRepeated().encodeWithTag(writer, 6, value.paragraphTrail);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull AudioModel.Event value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    return protoAdapter2.asRepeated().encodedSizeWithTag(1, value.defaultTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(2, value.highlightValueTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(3, value.drumTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(4, value.slowRhythmTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(5, value.startValueTrail) + protoAdapter2.asRepeated().encodedSizeWithTag(6, value.paragraphTrail) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public AudioModel.Event redact(@NotNull AudioModel.Event value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return (AudioModel.Event) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    return AudioModel.Event.copy$default(value, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public Event() {
            this(null, null, null, null, null, null, null, 127, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        public static /* synthetic */ Event copy$default(Event event, List list, List list2, List list3, List list4, List list5, List list6, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = event.defaultTrail;
            }
            if ((i3 & 2) != 0) {
                list2 = event.highlightValueTrail;
            }
            List list7 = list2;
            if ((i3 & 4) != 0) {
                list3 = event.drumTrail;
            }
            List list8 = list3;
            if ((i3 & 8) != 0) {
                list4 = event.slowRhythmTrail;
            }
            List list9 = list4;
            if ((i3 & 16) != 0) {
                list5 = event.startValueTrail;
            }
            List list10 = list5;
            if ((i3 & 32) != 0) {
                list6 = event.paragraphTrail;
            }
            List list11 = list6;
            if ((i3 & 64) != 0) {
                byteString = event.unknownFields();
            }
            return event.copy(list, list7, list8, list9, list10, list11, byteString);
        }

        @NotNull
        public final Event copy(@NotNull List<Integer> defaultTrail, @NotNull List<Integer> highlightValueTrail, @NotNull List<Integer> drumTrail, @NotNull List<Integer> slowRhythmTrail, @NotNull List<Integer> startValueTrail, @NotNull List<Integer> paragraphTrail, @NotNull ByteString unknownFields) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Event) iPatchRedirector.redirect((short) 7, this, defaultTrail, highlightValueTrail, drumTrail, slowRhythmTrail, startValueTrail, paragraphTrail, unknownFields);
            }
            Intrinsics.checkNotNullParameter(defaultTrail, "defaultTrail");
            Intrinsics.checkNotNullParameter(highlightValueTrail, "highlightValueTrail");
            Intrinsics.checkNotNullParameter(drumTrail, "drumTrail");
            Intrinsics.checkNotNullParameter(slowRhythmTrail, "slowRhythmTrail");
            Intrinsics.checkNotNullParameter(startValueTrail, "startValueTrail");
            Intrinsics.checkNotNullParameter(paragraphTrail, "paragraphTrail");
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            return new Event(defaultTrail, highlightValueTrail, drumTrail, slowRhythmTrail, startValueTrail, paragraphTrail, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
            }
            if (other == this) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            if (Intrinsics.areEqual(unknownFields(), event.unknownFields()) && Intrinsics.areEqual(this.defaultTrail, event.defaultTrail) && Intrinsics.areEqual(this.highlightValueTrail, event.highlightValueTrail) && Intrinsics.areEqual(this.drumTrail, event.drumTrail) && Intrinsics.areEqual(this.slowRhythmTrail, event.slowRhythmTrail) && Intrinsics.areEqual(this.startValueTrail, event.startValueTrail) && Intrinsics.areEqual(this.paragraphTrail, event.paragraphTrail)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            int i3 = this.hashCode;
            if (i3 == 0) {
                int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.defaultTrail.hashCode()) * 37) + this.highlightValueTrail.hashCode()) * 37) + this.drumTrail.hashCode()) * 37) + this.slowRhythmTrail.hashCode()) * 37) + this.startValueTrail.hashCode()) * 37) + this.paragraphTrail.hashCode();
                this.hashCode = hashCode;
                return hashCode;
            }
            return i3;
        }

        @NotNull
        public final com.tencent.tavcut.core.render.builder.light.model.Event toCutEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.tavcut.core.render.builder.light.model.Event) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return new com.tencent.tavcut.core.render.builder.light.model.Event(this.defaultTrail, this.highlightValueTrail, this.drumTrail, this.slowRhythmTrail, this.startValueTrail, this.paragraphTrail);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public String toString() {
            String joinToString$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            if (!this.defaultTrail.isEmpty()) {
                arrayList.add("defaultTrail=" + this.defaultTrail);
            }
            if (!this.highlightValueTrail.isEmpty()) {
                arrayList.add("highlightValueTrail=" + this.highlightValueTrail);
            }
            if (!this.drumTrail.isEmpty()) {
                arrayList.add("drumTrail=" + this.drumTrail);
            }
            if (!this.slowRhythmTrail.isEmpty()) {
                arrayList.add("slowRhythmTrail=" + this.slowRhythmTrail);
            }
            if (!this.startValueTrail.isEmpty()) {
                arrayList.add("startValueTrail=" + this.startValueTrail);
            }
            if (!this.paragraphTrail.isEmpty()) {
                arrayList.add("paragraphTrail=" + this.paragraphTrail);
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Event{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Event(List list, List list2, List list3, List list4, List list5, List list6, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(r2, r3, r4, r5, r6, r7, (i3 & 64) != 0 ? ByteString.EMPTY : byteString);
            List list7;
            List list8;
            List list9;
            List list10;
            List list11;
            List list12;
            List emptyList;
            List emptyList2;
            List emptyList3;
            List emptyList4;
            List emptyList5;
            List emptyList6;
            if ((i3 & 1) != 0) {
                emptyList6 = CollectionsKt__CollectionsKt.emptyList();
                list7 = emptyList6;
            } else {
                list7 = list;
            }
            if ((i3 & 2) != 0) {
                emptyList5 = CollectionsKt__CollectionsKt.emptyList();
                list8 = emptyList5;
            } else {
                list8 = list2;
            }
            if ((i3 & 4) != 0) {
                emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                list9 = emptyList4;
            } else {
                list9 = list3;
            }
            if ((i3 & 8) != 0) {
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                list10 = emptyList3;
            } else {
                list10 = list4;
            }
            if ((i3 & 16) != 0) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                list11 = emptyList2;
            } else {
                list11 = list5;
            }
            if ((i3 & 32) != 0) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                list12 = emptyList;
            } else {
                list12 = list6;
            }
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, list, list2, list3, list4, list5, list6, byteString, Integer.valueOf(i3), defaultConstructorMarker);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Builder builder = new Builder();
            builder.defaultTrail = this.defaultTrail;
            builder.highlightValueTrail = this.highlightValueTrail;
            builder.drumTrail = this.drumTrail;
            builder.slowRhythmTrail = this.slowRhythmTrail;
            builder.startValueTrail = this.startValueTrail;
            builder.paragraphTrail = this.paragraphTrail;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(@NotNull List<Integer> defaultTrail, @NotNull List<Integer> highlightValueTrail, @NotNull List<Integer> drumTrail, @NotNull List<Integer> slowRhythmTrail, @NotNull List<Integer> startValueTrail, @NotNull List<Integer> paragraphTrail, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(defaultTrail, "defaultTrail");
            Intrinsics.checkNotNullParameter(highlightValueTrail, "highlightValueTrail");
            Intrinsics.checkNotNullParameter(drumTrail, "drumTrail");
            Intrinsics.checkNotNullParameter(slowRhythmTrail, "slowRhythmTrail");
            Intrinsics.checkNotNullParameter(startValueTrail, "startValueTrail");
            Intrinsics.checkNotNullParameter(paragraphTrail, "paragraphTrail");
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, defaultTrail, highlightValueTrail, drumTrail, slowRhythmTrail, startValueTrail, paragraphTrail, unknownFields);
                return;
            }
            this.defaultTrail = defaultTrail;
            this.highlightValueTrail = highlightValueTrail;
            this.drumTrail = drumTrail;
            this.slowRhythmTrail = slowRhythmTrail;
            this.startValueTrail = startValueTrail;
            this.paragraphTrail = paragraphTrail;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/AudioModel$LyricInfo$Builder;", "strFormat", "", "strLyric", "strMatchLyric", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class LyricInfo extends AndroidMessage<LyricInfo, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<LyricInfo> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<LyricInfo> CREATOR;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

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
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$LyricInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "()V", "strFormat", "", "strLyric", "strMatchLyric", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Builder extends Message.Builder<LyricInfo, Builder> {
            static IPatchRedirector $redirector_;

            @JvmField
            @NotNull
            public String strFormat;

            @JvmField
            @NotNull
            public String strLyric;

            @JvmField
            @NotNull
            public String strMatchLyric;

            public Builder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.strFormat = "";
                this.strLyric = "";
                this.strMatchLyric = "";
            }

            @NotNull
            public final Builder strFormat(@Nullable String strFormat) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) strFormat);
                }
                if (strFormat == null) {
                    strFormat = "";
                }
                this.strFormat = strFormat;
                return this;
            }

            @NotNull
            public final Builder strLyric(@Nullable String strLyric) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) strLyric);
                }
                if (strLyric == null) {
                    strLyric = "";
                }
                this.strLyric = strLyric;
                return this;
            }

            @NotNull
            public final Builder strMatchLyric(@Nullable String strMatchLyric) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) strMatchLyric);
                }
                if (strMatchLyric == null) {
                    strMatchLyric = "";
                }
                this.strMatchLyric = strMatchLyric;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public LyricInfo build() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new LyricInfo(this.strFormat, this.strLyric, this.strMatchLyric, buildUnknownFields()) : (LyricInfo) iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$LyricInfo$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel$LyricInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58389);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
                return;
            }
            INSTANCE = new Companion(null);
            ProtoAdapter<LyricInfo> protoAdapter = new ProtoAdapter<LyricInfo>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LyricInfo.class)) { // from class: com.tencent.videocut.model.AudioModel$LyricInfo$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(r4, r5, "type.googleapis.com/publisher.AudioModel.LyricInfo");
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, (Object) r5);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public AudioModel.LyricInfo decode(@NotNull ProtoReader reader) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return (AudioModel.LyricInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                    }
                    Intrinsics.checkNotNullParameter(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    String str = "";
                    String str2 = "";
                    String str3 = str2;
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new AudioModel.LyricInfo(str, str2, str3, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                        if (nextTag == 1) {
                            str = ProtoAdapter.STRING.decode(reader);
                        } else if (nextTag == 2) {
                            str2 = ProtoAdapter.STRING.decode(reader);
                        } else if (nextTag != 3) {
                            reader.readUnknownField(nextTag);
                        } else {
                            str3 = ProtoAdapter.STRING.decode(reader);
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull AudioModel.LyricInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(writer, "writer");
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    protoAdapter2.encodeWithTag(writer, 1, value.strFormat);
                    protoAdapter2.encodeWithTag(writer, 2, value.strLyric);
                    protoAdapter2.encodeWithTag(writer, 3, value.strMatchLyric);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull AudioModel.LyricInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    return protoAdapter2.encodedSizeWithTag(1, value.strFormat) + protoAdapter2.encodedSizeWithTag(2, value.strLyric) + protoAdapter2.encodedSizeWithTag(3, value.strMatchLyric) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public AudioModel.LyricInfo redact(@NotNull AudioModel.LyricInfo value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return (AudioModel.LyricInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    return AudioModel.LyricInfo.copy$default(value, null, null, null, ByteString.EMPTY, 7, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public LyricInfo() {
            this(null, null, null, null, 15, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (LyricInfo) iPatchRedirector.redirect((short) 7, this, strFormat, strLyric, strMatchLyric, unknownFields);
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
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
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) == 0 ? str3 : "", (i3 & 8) != 0 ? ByteString.EMPTY : byteString);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, byteString, Integer.valueOf(i3), defaultConstructorMarker);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Builder builder = new Builder();
            builder.strFormat = this.strFormat;
            builder.strLyric = this.strLyric;
            builder.strMatchLyric = this.strMatchLyric;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LyricInfo(@NotNull String strFormat, @NotNull String strLyric, @NotNull String strMatchLyric, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(strFormat, "strFormat");
            Intrinsics.checkNotNullParameter(strLyric, "strLyric");
            Intrinsics.checkNotNullParameter(strMatchLyric, "strMatchLyric");
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, strFormat, strLyric, strMatchLyric, unknownFields);
                return;
            }
            this.strFormat = strFormat;
            this.strLyric = strLyric;
            this.strMatchLyric = strMatchLyric;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$Type;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "MUSIC", "RECORD", "SOUND", "EXTRACT", "TTS", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES;
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<Type> ADAPTER;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final Type EXTRACT;
        public static final Type MUSIC;
        public static final Type RECORD;
        public static final Type SOUND;
        public static final Type TTS;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$Type$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel$Type;", "fromValue", "value", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @JvmStatic
            @Nullable
            public final Type fromValue(int value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Type) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
                if (value != 0) {
                    if (value != 1) {
                        if (value != 2) {
                            if (value != 3) {
                                if (value != 4) {
                                    return null;
                                }
                                return Type.TTS;
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
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{MUSIC, RECORD, SOUND, EXTRACT, TTS};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58399);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            MUSIC = new Type("MUSIC", 0, 0);
            RECORD = new Type("RECORD", 1, 1);
            SOUND = new Type("SOUND", 2, 2);
            EXTRACT = new Type("EXTRACT", 3, 3);
            TTS = new Type("TTS", 4, 4);
            $VALUES = $values();
            INSTANCE = new Companion(null);
            ADAPTER = new EnumAdapter<Type>(Reflection.getOrCreateKotlinClass(Type.class)) { // from class: com.tencent.videocut.model.AudioModel$Type$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(r4);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.squareup.wire.EnumAdapter
                @Nullable
                public AudioModel.Type fromValue(int value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? AudioModel.Type.INSTANCE.fromValue(value) : (AudioModel.Type) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
            };
        }

        Type(String str, int i3, int i16) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        @JvmStatic
        @Nullable
        public static final Type fromValue(int i3) {
            return INSTANCE.fromValue(i3);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJQ\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Builder;", "durationUs", "", "startOffsetUs", "endOffsetUs", "startVolume", "", "endVolume", "unknownFields", "Lokio/ByteString;", "(JJJFFLokio/ByteString;)V", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class VolumeEffect extends AndroidMessage<VolumeEffect, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<VolumeEffect> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<VolumeEffect> CREATOR;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

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
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\rJ\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\rR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "()V", "durationUs", "", "endOffsetUs", "endVolume", "", "startOffsetUs", "startVolume", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Builder;", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Builder extends Message.Builder<VolumeEffect, Builder> {
            static IPatchRedirector $redirector_;

            @JvmField
            public long durationUs;

            @JvmField
            public long endOffsetUs;

            @JvmField
            public float endVolume;

            @JvmField
            public long startOffsetUs;

            @JvmField
            public float startVolume;

            public Builder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @NotNull
            public final Builder durationUs(@Nullable Long durationUs) {
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) durationUs);
                }
                if (durationUs != null) {
                    j3 = durationUs.longValue();
                } else {
                    j3 = 0;
                }
                this.durationUs = j3;
                return this;
            }

            @NotNull
            public final Builder endOffsetUs(@Nullable Long endOffsetUs) {
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) endOffsetUs);
                }
                if (endOffsetUs != null) {
                    j3 = endOffsetUs.longValue();
                } else {
                    j3 = 0;
                }
                this.endOffsetUs = j3;
                return this;
            }

            @NotNull
            public final Builder endVolume(@Nullable Float endVolume) {
                float f16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) endVolume);
                }
                if (endVolume != null) {
                    f16 = endVolume.floatValue();
                } else {
                    f16 = 0.0f;
                }
                this.endVolume = f16;
                return this;
            }

            @NotNull
            public final Builder startOffsetUs(@Nullable Long startOffsetUs) {
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) startOffsetUs);
                }
                if (startOffsetUs != null) {
                    j3 = startOffsetUs.longValue();
                } else {
                    j3 = 0;
                }
                this.startOffsetUs = j3;
                return this;
            }

            @NotNull
            public final Builder startVolume(@Nullable Float startVolume) {
                float f16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) startVolume);
                }
                if (startVolume != null) {
                    f16 = startVolume.floatValue();
                } else {
                    f16 = 0.0f;
                }
                this.startVolume = f16;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public VolumeEffect build() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? new VolumeEffect(this.durationUs, this.startOffsetUs, this.endOffsetUs, this.startVolume, this.endVolume, buildUnknownFields()) : (VolumeEffect) iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/AudioModel$VolumeEffect$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58420);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
                return;
            }
            INSTANCE = new Companion(null);
            ProtoAdapter<VolumeEffect> protoAdapter = new ProtoAdapter<VolumeEffect>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VolumeEffect.class)) { // from class: com.tencent.videocut.model.AudioModel$VolumeEffect$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(r4, r5, "type.googleapis.com/publisher.AudioModel.VolumeEffect");
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, (Object) r5);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public AudioModel.VolumeEffect decode(@NotNull ProtoReader reader) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return (AudioModel.VolumeEffect) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                    }
                    Intrinsics.checkNotNullParameter(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    float f16 = 0.0f;
                    float f17 = 0.0f;
                    long j3 = 0;
                    long j16 = 0;
                    long j17 = 0;
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new AudioModel.VolumeEffect(j3, j16, j17, f16, f17, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                        if (nextTag == 1) {
                            j3 = ProtoAdapter.INT64.decode(reader).longValue();
                        } else if (nextTag == 2) {
                            j16 = ProtoAdapter.INT64.decode(reader).longValue();
                        } else if (nextTag == 3) {
                            j17 = ProtoAdapter.INT64.decode(reader).longValue();
                        } else if (nextTag == 4) {
                            f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                        } else if (nextTag != 5) {
                            reader.readUnknownField(nextTag);
                        } else {
                            f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull AudioModel.VolumeEffect value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(writer, "writer");
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                    protoAdapter2.encodeWithTag(writer, 1, Long.valueOf(value.durationUs));
                    protoAdapter2.encodeWithTag(writer, 2, Long.valueOf(value.startOffsetUs));
                    protoAdapter2.encodeWithTag(writer, 3, Long.valueOf(value.endOffsetUs));
                    ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                    protoAdapter3.encodeWithTag(writer, 4, Float.valueOf(value.startVolume));
                    protoAdapter3.encodeWithTag(writer, 5, Float.valueOf(value.endVolume));
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull AudioModel.VolumeEffect value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                    int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, Long.valueOf(value.durationUs)) + protoAdapter2.encodedSizeWithTag(2, Long.valueOf(value.startOffsetUs)) + protoAdapter2.encodedSizeWithTag(3, Long.valueOf(value.endOffsetUs));
                    ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                    return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, Float.valueOf(value.startVolume)) + protoAdapter3.encodedSizeWithTag(5, Float.valueOf(value.endVolume)) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public AudioModel.VolumeEffect redact(@NotNull AudioModel.VolumeEffect value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return (AudioModel.VolumeEffect) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                    }
                    Intrinsics.checkNotNullParameter(value, "value");
                    return AudioModel.VolumeEffect.copy$default(value, null, null, null, null, null, ByteString.EMPTY, 31, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public VolumeEffect() {
            this(0L, 0L, 0L, 0.0f, 0.0f, null, 63, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (VolumeEffect) iPatchRedirector.redirect((short) 7, this, durationUs, startOffsetUs, endOffsetUs, startVolume, endVolume, unknownFields);
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            int i3 = this.hashCode;
            if (i3 == 0) {
                int hashCode = (((((((((unknownFields().hashCode() * 37) + a.a(this.durationUs)) * 37) + a.a(this.startOffsetUs)) * 37) + a.a(this.endOffsetUs)) * 37) + Float.floatToIntBits(this.startVolume)) * 37) + Float.floatToIntBits(this.endVolume);
                this.hashCode = hashCode;
                return hashCode;
            }
            return i3;
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public String toString() {
            String joinToString$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
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
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 0L : j17, (i3 & 8) != 0 ? 0.0f : f16, (i3 & 16) != 0 ? 0.0f : f17, (i3 & 32) != 0 ? ByteString.EMPTY : byteString);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Float.valueOf(f16), Float.valueOf(f17), byteString, Integer.valueOf(i3), defaultConstructorMarker);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Builder builder = new Builder();
            builder.durationUs = this.durationUs;
            builder.startOffsetUs = this.startOffsetUs;
            builder.endOffsetUs = this.endOffsetUs;
            builder.startVolume = this.startVolume;
            builder.endVolume = this.endVolume;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VolumeEffect(long j3, long j16, long j17, float f16, float f17, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Float.valueOf(f16), Float.valueOf(f17), unknownFields);
                return;
            }
            this.durationUs = j3;
            this.startOffsetUs = j16;
            this.endOffsetUs = j17;
            this.startVolume = f16;
            this.endVolume = f17;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58435);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        ProtoAdapter<AudioModel> protoAdapter = new ProtoAdapter<AudioModel>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AudioModel.class)) { // from class: com.tencent.videocut.model.AudioModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(r4, r5, "type.googleapis.com/publisher.AudioModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, (Object) r5);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0052. Please report as an issue. */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public AudioModel decode(@NotNull ProtoReader reader) {
                ArrayList arrayList;
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (AudioModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                long beginMessage = reader.beginMessage();
                String str = "";
                float f16 = 0.0f;
                float f17 = 0.0f;
                Integer num = null;
                AudioModel.LyricInfo lyricInfo = null;
                AudioModel.Type type = null;
                AudioModel.Event event = null;
                long j16 = 0;
                long j17 = 0;
                long j18 = 0;
                long j19 = 0;
                long j26 = 0;
                long j27 = 0;
                String str2 = "";
                long j28 = 0;
                String str3 = str2;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                arrayList = arrayList3;
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                arrayList = arrayList3;
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                arrayList = arrayList3;
                                j28 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 4:
                                arrayList = arrayList3;
                                j16 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 5:
                                arrayList = arrayList3;
                                j17 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 6:
                                arrayList = arrayList3;
                                f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            case 7:
                                arrayList = arrayList3;
                                f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            case 8:
                                arrayList = arrayList3;
                                j3 = j28;
                                arrayList2.add(AudioModel.VolumeEffect.ADAPTER.decode(reader));
                                j28 = j3;
                                break;
                            case 9:
                                arrayList = arrayList3;
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 10:
                                arrayList = arrayList3;
                                num = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 11:
                                arrayList = arrayList3;
                                j18 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 12:
                                arrayList = arrayList3;
                                j19 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 13:
                                arrayList = arrayList3;
                                j26 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 14:
                                arrayList = arrayList3;
                                j27 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 15:
                                arrayList = arrayList3;
                                lyricInfo = AudioModel.LyricInfo.ADAPTER.decode(reader);
                                break;
                            case 16:
                                try {
                                    type = AudioModel.Type.ADAPTER.decode(reader);
                                    arrayList = arrayList3;
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    arrayList = arrayList3;
                                    j3 = j28;
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                    break;
                                }
                            case 17:
                                arrayList3.add(ProtoAdapter.INT32.decode(reader));
                                arrayList = arrayList3;
                                j3 = j28;
                                j28 = j3;
                                break;
                            case 18:
                                event = AudioModel.Event.ADAPTER.decode(reader);
                                arrayList = arrayList3;
                                break;
                            default:
                                arrayList = arrayList3;
                                j3 = j28;
                                reader.readUnknownField(nextTag);
                                j28 = j3;
                                break;
                        }
                        arrayList3 = arrayList;
                    } else {
                        return new AudioModel(str, str2, j28, j16, j17, f16, f17, arrayList2, str3, num, j18, j19, j26, j27, lyricInfo, type, arrayList3, event, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull AudioModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.id);
                protoAdapter2.encodeWithTag(writer, 2, value.path);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                protoAdapter3.encodeWithTag(writer, 3, Long.valueOf(value.sourceStartTime));
                protoAdapter3.encodeWithTag(writer, 4, Long.valueOf(value.sourceDuration));
                protoAdapter3.encodeWithTag(writer, 5, Long.valueOf(value.startTimeInTimeline));
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                protoAdapter4.encodeWithTag(writer, 6, Float.valueOf(value.volume));
                protoAdapter4.encodeWithTag(writer, 7, Float.valueOf(value.speed));
                AudioModel.VolumeEffect.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.volumeEffects);
                protoAdapter2.encodeWithTag(writer, 9, value.name);
                ProtoAdapter<Integer> protoAdapter5 = ProtoAdapter.INT32;
                protoAdapter5.encodeWithTag(writer, 10, value.timelineTrackIndex);
                protoAdapter3.encodeWithTag(writer, 11, Long.valueOf(value.selectStartTime));
                protoAdapter3.encodeWithTag(writer, 12, Long.valueOf(value.selectDuration));
                protoAdapter3.encodeWithTag(writer, 13, Long.valueOf(value.fadeInDuration));
                protoAdapter3.encodeWithTag(writer, 14, Long.valueOf(value.fadeOutDuration));
                AudioModel.LyricInfo.ADAPTER.encodeWithTag(writer, 15, value.lyricInfo);
                AudioModel.Type.ADAPTER.encodeWithTag(writer, 16, value.type);
                protoAdapter5.asRepeated().encodeWithTag(writer, 17, value.waveSampleData);
                AudioModel.Event.ADAPTER.encodeWithTag(writer, 18, value.event);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull AudioModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.id) + protoAdapter2.encodedSizeWithTag(2, value.path);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(3, Long.valueOf(value.sourceStartTime)) + protoAdapter3.encodedSizeWithTag(4, Long.valueOf(value.sourceDuration)) + protoAdapter3.encodedSizeWithTag(5, Long.valueOf(value.startTimeInTimeline));
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(6, Float.valueOf(value.volume)) + protoAdapter4.encodedSizeWithTag(7, Float.valueOf(value.speed)) + AudioModel.VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(8, value.volumeEffects) + protoAdapter2.encodedSizeWithTag(9, value.name);
                ProtoAdapter<Integer> protoAdapter5 = ProtoAdapter.INT32;
                return encodedSizeWithTag3 + protoAdapter5.encodedSizeWithTag(10, value.timelineTrackIndex) + protoAdapter3.encodedSizeWithTag(11, Long.valueOf(value.selectStartTime)) + protoAdapter3.encodedSizeWithTag(12, Long.valueOf(value.selectDuration)) + protoAdapter3.encodedSizeWithTag(13, Long.valueOf(value.fadeInDuration)) + protoAdapter3.encodedSizeWithTag(14, Long.valueOf(value.fadeOutDuration)) + AudioModel.LyricInfo.ADAPTER.encodedSizeWithTag(15, value.lyricInfo) + AudioModel.Type.ADAPTER.encodedSizeWithTag(16, value.type) + protoAdapter5.asRepeated().encodedSizeWithTag(17, value.waveSampleData) + AudioModel.Event.ADAPTER.encodedSizeWithTag(18, value.event) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public AudioModel redact(@NotNull AudioModel value) {
                AudioModel copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (AudioModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                List m87redactElements = Internal.m87redactElements(value.volumeEffects, AudioModel.VolumeEffect.ADAPTER);
                AudioModel.LyricInfo lyricInfo = value.lyricInfo;
                AudioModel.LyricInfo redact = lyricInfo != null ? AudioModel.LyricInfo.ADAPTER.redact(lyricInfo) : null;
                AudioModel.Event event = value.event;
                copy = value.copy((r37 & 1) != 0 ? value.id : null, (r37 & 2) != 0 ? value.path : null, (r37 & 4) != 0 ? Long.valueOf(value.sourceStartTime) : null, (r37 & 8) != 0 ? Long.valueOf(value.sourceDuration) : null, (r37 & 16) != 0 ? Long.valueOf(value.startTimeInTimeline) : null, (r37 & 32) != 0 ? Float.valueOf(value.volume) : null, (r37 & 64) != 0 ? Float.valueOf(value.speed) : null, (r37 & 128) != 0 ? value.volumeEffects : m87redactElements, (r37 & 256) != 0 ? value.name : null, (r37 & 512) != 0 ? value.timelineTrackIndex : null, (r37 & 1024) != 0 ? Long.valueOf(value.selectStartTime) : null, (r37 & 2048) != 0 ? Long.valueOf(value.selectDuration) : null, (r37 & 4096) != 0 ? Long.valueOf(value.fadeInDuration) : null, (r37 & 8192) != 0 ? Long.valueOf(value.fadeOutDuration) : null, (r37 & 16384) != 0 ? value.lyricInfo : redact, (r37 & 32768) != 0 ? value.type : null, (r37 & 65536) != 0 ? value.waveSampleData : null, (r37 & 131072) != 0 ? value.event : event != null ? AudioModel.Event.ADAPTER.redact(event) : null, (r37 & 262144) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public AudioModel() {
        this(null, null, 0L, 0L, 0L, 0.0f, 0.0f, null, null, null, 0L, 0L, 0L, 0L, null, null, null, null, null, 524287, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ AudioModel copy$default(AudioModel audioModel, String str, String str2, Long l3, Long l16, Long l17, Float f16, Float f17, List list, String str3, Integer num, Long l18, Long l19, Long l26, Long l27, LyricInfo lyricInfo, Type type, List list2, Event event, ByteString byteString, int i3, Object obj) {
        return audioModel.copy((i3 & 1) != 0 ? audioModel.id : str, (i3 & 2) != 0 ? audioModel.path : str2, (i3 & 4) != 0 ? Long.valueOf(audioModel.sourceStartTime) : l3, (i3 & 8) != 0 ? Long.valueOf(audioModel.sourceDuration) : l16, (i3 & 16) != 0 ? Long.valueOf(audioModel.startTimeInTimeline) : l17, (i3 & 32) != 0 ? Float.valueOf(audioModel.volume) : f16, (i3 & 64) != 0 ? Float.valueOf(audioModel.speed) : f17, (i3 & 128) != 0 ? audioModel.volumeEffects : list, (i3 & 256) != 0 ? audioModel.name : str3, (i3 & 512) != 0 ? audioModel.timelineTrackIndex : num, (i3 & 1024) != 0 ? Long.valueOf(audioModel.selectStartTime) : l18, (i3 & 2048) != 0 ? Long.valueOf(audioModel.selectDuration) : l19, (i3 & 4096) != 0 ? Long.valueOf(audioModel.fadeInDuration) : l26, (i3 & 8192) != 0 ? Long.valueOf(audioModel.fadeOutDuration) : l27, (i3 & 16384) != 0 ? audioModel.lyricInfo : lyricInfo, (i3 & 32768) != 0 ? audioModel.type : type, (i3 & 65536) != 0 ? audioModel.waveSampleData : list2, (i3 & 131072) != 0 ? audioModel.event : event, (i3 & 262144) != 0 ? audioModel.unknownFields() : byteString);
    }

    @NotNull
    public final AudioModel copy(@Nullable String id5, @Nullable String path, @Nullable Long sourceStartTime, @Nullable Long sourceDuration, @Nullable Long startTimeInTimeline, @Nullable Float r342, @Nullable Float speed, @NotNull List<VolumeEffect> r36, @Nullable String name, @Nullable Integer timelineTrackIndex, @Nullable Long selectStartTime, @Nullable Long selectDuration, @Nullable Long fadeInDuration, @Nullable Long fadeOutDuration, @Nullable LyricInfo lyricInfo, @Nullable Type type, @NotNull List<Integer> waveSampleData, @Nullable Event event, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AudioModel) iPatchRedirector.redirect((short) 7, this, id5, path, sourceStartTime, sourceDuration, startTimeInTimeline, r342, speed, r36, name, timelineTrackIndex, selectStartTime, selectDuration, fadeInDuration, fadeOutDuration, lyricInfo, type, waveSampleData, event, unknownFields);
        }
        Intrinsics.checkNotNullParameter(r36, "volumeEffects");
        Intrinsics.checkNotNullParameter(waveSampleData, "waveSampleData");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new AudioModel(id5 == null ? "" : id5, path == null ? "" : path, sourceStartTime != null ? sourceStartTime.longValue() : 0L, sourceDuration != null ? sourceDuration.longValue() : 0L, startTimeInTimeline != null ? startTimeInTimeline.longValue() : 0L, r342 != null ? r342.floatValue() : 0.0f, speed != null ? speed.floatValue() : 0.0f, r36, name == null ? "" : name, timelineTrackIndex, selectStartTime != null ? selectStartTime.longValue() : 0L, selectDuration != null ? selectDuration.longValue() : 0L, fadeInDuration != null ? fadeInDuration.longValue() : 0L, fadeOutDuration != null ? fadeOutDuration.longValue() : 0L, lyricInfo, type, waveSampleData, event, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
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
                if (z17 && Intrinsics.areEqual(this.volumeEffects, audioModel.volumeEffects) && Intrinsics.areEqual(this.name, audioModel.name) && Intrinsics.areEqual(this.timelineTrackIndex, audioModel.timelineTrackIndex) && this.selectStartTime == audioModel.selectStartTime && this.selectDuration == audioModel.selectDuration && this.fadeInDuration == audioModel.fadeInDuration && this.fadeOutDuration == audioModel.fadeOutDuration && Intrinsics.areEqual(this.lyricInfo, audioModel.lyricInfo) && this.type == audioModel.type && Intrinsics.areEqual(this.waveSampleData, audioModel.waveSampleData) && Intrinsics.areEqual(this.event, audioModel.event)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i18 = this.hashCode;
        if (i18 == 0) {
            int hashCode = ((((((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.path.hashCode()) * 37) + a.a(this.sourceStartTime)) * 37) + a.a(this.sourceDuration)) * 37) + a.a(this.startTimeInTimeline)) * 37) + Float.floatToIntBits(this.volume)) * 37) + Float.floatToIntBits(this.speed)) * 37) + this.volumeEffects.hashCode()) * 37) + this.name.hashCode()) * 37;
            Integer num = this.timelineTrackIndex;
            int i19 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = (((((((((hashCode + i3) * 37) + a.a(this.selectStartTime)) * 37) + a.a(this.selectDuration)) * 37) + a.a(this.fadeInDuration)) * 37) + a.a(this.fadeOutDuration)) * 37;
            LyricInfo lyricInfo = this.lyricInfo;
            if (lyricInfo != null) {
                i16 = lyricInfo.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (a16 + i16) * 37;
            Type type = this.type;
            if (type != null) {
                i17 = type.hashCode();
            } else {
                i17 = 0;
            }
            int hashCode2 = (((i26 + i17) * 37) + this.waveSampleData.hashCode()) * 37;
            Event event = this.event;
            if (event != null) {
                i19 = event.hashCode();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
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
        Event event = this.event;
        if (event != null) {
            arrayList.add("event=" + event);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "AudioModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AudioModel(String str, String str2, long j3, long j16, long j17, float f16, float f17, List list, String str3, Integer num, long j18, long j19, long j26, long j27, LyricInfo lyricInfo, Type type, List list2, Event event, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r8, r10, r12, r1, r14, r15, r2, r17, r18, r20, r22, r24, r26, r27, r28, (131072 & i3) != 0 ? null : event, (262144 & i3) != 0 ? ByteString.EMPTY : byteString);
        List list3;
        List list4;
        List emptyList;
        List emptyList2;
        String str4 = (i3 & 1) != 0 ? "" : str;
        String str5 = (i3 & 2) != 0 ? "" : str2;
        long j28 = (i3 & 4) != 0 ? 0L : j3;
        long j29 = (i3 & 8) != 0 ? 0L : j16;
        long j36 = (i3 & 16) != 0 ? 0L : j17;
        float f18 = (i3 & 32) != 0 ? 0.0f : f16;
        float f19 = (i3 & 64) != 0 ? 0.0f : f17;
        if ((i3 & 128) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list3 = emptyList2;
        } else {
            list3 = list;
        }
        String str6 = (i3 & 256) == 0 ? str3 : "";
        Integer num2 = (i3 & 512) != 0 ? null : num;
        long j37 = (i3 & 1024) != 0 ? 0L : j18;
        long j38 = (i3 & 2048) != 0 ? 0L : j19;
        long j39 = (i3 & 4096) != 0 ? 0L : j26;
        long j46 = (i3 & 8192) != 0 ? 0L : j27;
        LyricInfo lyricInfo2 = (i3 & 16384) != 0 ? null : lyricInfo;
        Type type2 = (32768 & i3) != 0 ? null : type;
        if ((65536 & i3) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Float.valueOf(f16), Float.valueOf(f17), list, str3, num, Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), lyricInfo, type, list2, event, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.id = this.id;
        builder.path = this.path;
        builder.sourceStartTime = this.sourceStartTime;
        builder.sourceDuration = this.sourceDuration;
        builder.startTimeInTimeline = this.startTimeInTimeline;
        builder.volume = this.volume;
        builder.speed = this.speed;
        builder.volumeEffects = this.volumeEffects;
        builder.name = this.name;
        builder.timelineTrackIndex = this.timelineTrackIndex;
        builder.selectStartTime = this.selectStartTime;
        builder.selectDuration = this.selectDuration;
        builder.fadeInDuration = this.fadeInDuration;
        builder.fadeOutDuration = this.fadeOutDuration;
        builder.lyricInfo = this.lyricInfo;
        builder.type = this.type;
        builder.waveSampleData = this.waveSampleData;
        builder.event = this.event;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioModel(@NotNull String id5, @NotNull String path, long j3, long j16, long j17, float f16, float f17, @NotNull List<VolumeEffect> volumeEffects, @NotNull String name, @Nullable Integer num, long j18, long j19, long j26, long j27, @Nullable LyricInfo lyricInfo, @Nullable Type type, @NotNull List<Integer> waveSampleData, @Nullable Event event, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(volumeEffects, "volumeEffects");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(waveSampleData, "waveSampleData");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, path, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Float.valueOf(f16), Float.valueOf(f17), volumeEffects, name, num, Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), lyricInfo, type, waveSampleData, event, unknownFields);
            return;
        }
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
        this.event = event;
    }
}
