package com.tencent.videocut.model;

import android.os.Parcelable;
import androidx.fragment.app.a;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u00c3\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010\u001dJ\u00df\u0001\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016R\u0012\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/videocut/model/ResourceModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/ResourceModel$Builder;", "id", "", "path", "scaleDuration", "", WebAudioPlugin.API_SOURCE_START, "sourceDuration", "selectStart", "selectDuration", "type", "Lcom/tencent/videocut/model/MediaType;", "size", "Lcom/tencent/videocut/model/SizeF;", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "extras", "", "picClipRect", "Lcom/tencent/videocut/model/RectF;", "reversePath", "normalPath", "isReverseMode", "", "deblurScore", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;JJJJJLcom/tencent/videocut/model/MediaType;Lcom/tencent/videocut/model/SizeF;FLjava/util/Map;Lcom/tencent/videocut/model/RectF;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;FLokio/ByteString;)V", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/videocut/model/MediaType;Lcom/tencent/videocut/model/SizeF;Ljava/lang/Float;Ljava/util/Map;Lcom/tencent/videocut/model/RectF;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/videocut/model/ResourceModel;", "equals", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ResourceModel extends AndroidMessage<ResourceModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<ResourceModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ResourceModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 17)
    @JvmField
    public float deblurScore;

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

    @WireField(adapter = "com.tencent.videocut.model.RectF#ADAPTER", tag = 13)
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

    @WireField(adapter = "com.tencent.videocut.model.SizeF#ADAPTER", tag = 9)
    @JvmField
    @Nullable
    public final SizeF size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @JvmField
    public final long sourceDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    public final long sourceStart;

    @WireField(adapter = "com.tencent.videocut.model.MediaType#ADAPTER", tag = 8)
    @JvmField
    @Nullable
    public final MediaType type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 11)
    @JvmField
    public float volume;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001fJ\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010 J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0014J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006!"}, d2 = {"Lcom/tencent/videocut/model/ResourceModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/ResourceModel;", "()V", "deblurScore", "", "Ljava/lang/Float;", "extras", "", "", "id", "isReverseMode", "", "Ljava/lang/Boolean;", "normalPath", "path", "picClipRect", "Lcom/tencent/videocut/model/RectF;", "reversePath", "scaleDuration", "", "selectDuration", "selectStart", "size", "Lcom/tencent/videocut/model/SizeF;", "sourceDuration", WebAudioPlugin.API_SOURCE_START, "type", "Lcom/tencent/videocut/model/MediaType;", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/ResourceModel$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/videocut/model/ResourceModel$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<ResourceModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public Float deblurScore;

        @JvmField
        @NotNull
        public Map<String, String> extras;

        @JvmField
        @NotNull
        public String id;

        @JvmField
        @Nullable
        public Boolean isReverseMode;

        @JvmField
        @NotNull
        public String normalPath;

        @JvmField
        @NotNull
        public String path;

        @JvmField
        @Nullable
        public RectF picClipRect;

        @JvmField
        @NotNull
        public String reversePath;

        @JvmField
        public long scaleDuration;

        @JvmField
        public long selectDuration;

        @JvmField
        public long selectStart;

        @JvmField
        @Nullable
        public SizeF size;

        @JvmField
        public long sourceDuration;

        @JvmField
        public long sourceStart;

        @JvmField
        @Nullable
        public MediaType type;

        @JvmField
        @Nullable
        public Float volume;

        public Builder() {
            Map<String, String> emptyMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.id = "";
            this.path = "";
            emptyMap = MapsKt__MapsKt.emptyMap();
            this.extras = emptyMap;
            this.reversePath = "";
            this.normalPath = "";
        }

        @NotNull
        public final Builder deblurScore(@Nullable Float deblurScore) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) deblurScore);
            }
            this.deblurScore = deblurScore;
            return this;
        }

        @NotNull
        public final Builder extras(@NotNull Map<String, String> extras) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) extras);
            }
            Intrinsics.checkNotNullParameter(extras, "extras");
            this.extras = extras;
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
        public final Builder isReverseMode(@Nullable Boolean isReverseMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) isReverseMode);
            }
            this.isReverseMode = isReverseMode;
            return this;
        }

        @NotNull
        public final Builder normalPath(@Nullable String normalPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) normalPath);
            }
            if (normalPath == null) {
                normalPath = "";
            }
            this.normalPath = normalPath;
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
        public final Builder picClipRect(@Nullable RectF picClipRect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) picClipRect);
            }
            this.picClipRect = picClipRect;
            return this;
        }

        @NotNull
        public final Builder reversePath(@Nullable String reversePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) reversePath);
            }
            if (reversePath == null) {
                reversePath = "";
            }
            this.reversePath = reversePath;
            return this;
        }

        @NotNull
        public final Builder scaleDuration(long scaleDuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, scaleDuration);
            }
            this.scaleDuration = scaleDuration;
            return this;
        }

        @NotNull
        public final Builder selectDuration(long selectDuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, selectDuration);
            }
            this.selectDuration = selectDuration;
            return this;
        }

        @NotNull
        public final Builder selectStart(long selectStart) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, selectStart);
            }
            this.selectStart = selectStart;
            return this;
        }

        @NotNull
        public final Builder size(@Nullable SizeF size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) size);
            }
            this.size = size;
            return this;
        }

        @NotNull
        public final Builder sourceDuration(long sourceDuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, sourceDuration);
            }
            this.sourceDuration = sourceDuration;
            return this;
        }

        @NotNull
        public final Builder sourceStart(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
            this.sourceStart = j3;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable MediaType type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) type);
            }
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder volume(@Nullable Float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) f16);
            }
            this.volume = f16;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public ResourceModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (ResourceModel) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            String str = this.id;
            String str2 = this.path;
            long j3 = this.scaleDuration;
            long j16 = this.sourceStart;
            long j17 = this.sourceDuration;
            long j18 = this.selectStart;
            long j19 = this.selectDuration;
            MediaType mediaType = this.type;
            SizeF sizeF = this.size;
            Float f16 = this.volume;
            float floatValue = f16 != null ? f16.floatValue() : 0.0f;
            Map<String, String> map = this.extras;
            RectF rectF = this.picClipRect;
            String str3 = this.reversePath;
            String str4 = this.normalPath;
            Boolean bool = this.isReverseMode;
            Float f17 = this.deblurScore;
            return new ResourceModel(str, str2, j3, j16, j17, j18, j19, mediaType, sizeF, floatValue, map, rectF, str3, str4, bool, f17 != null ? f17.floatValue() : 0.0f, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/ResourceModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/ResourceModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58955);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        ProtoAdapter<ResourceModel> protoAdapter = new ProtoAdapter<ResourceModel>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceModel.class)) { // from class: com.tencent.videocut.model.ResourceModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            @NotNull
            private final ProtoAdapter<Map<String, String>> extrasAdapter;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(r4, r5, "type.googleapis.com/publisher.ResourceModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, (Object) r5);
                    return;
                }
                ProtoAdapter.Companion companion = ProtoAdapter.INSTANCE;
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                this.extrasAdapter = companion.newMapAdapter(protoAdapter2, protoAdapter2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ResourceModel decode(@NotNull ProtoReader reader) {
                ResourceModel$Companion$ADAPTER$1 resourceModel$Companion$ADAPTER$1 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (ResourceModel) iPatchRedirector.redirect((short) 4, (Object) resourceModel$Companion$ADAPTER$1, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                long beginMessage = reader.beginMessage();
                String str = "";
                long j3 = 0;
                long j16 = 0;
                long j17 = 0;
                long j18 = 0;
                long j19 = 0;
                MediaType mediaType = null;
                SizeF sizeF = null;
                Float f16 = null;
                RectF rectF = null;
                Boolean bool = null;
                Float f17 = null;
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                j3 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 4:
                                j19 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 5:
                                j16 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 6:
                                j17 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 7:
                                j18 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 8:
                                try {
                                    mediaType = MediaType.ADAPTER.decode(reader);
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                    break;
                                }
                            case 9:
                                sizeF = SizeF.ADAPTER.decode(reader);
                                break;
                            case 10:
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                            case 11:
                                f16 = ProtoAdapter.FLOAT.decode(reader);
                                break;
                            case 12:
                                linkedHashMap.putAll(resourceModel$Companion$ADAPTER$1.extrasAdapter.decode(reader));
                                break;
                            case 13:
                                rectF = RectF.ADAPTER.decode(reader);
                                break;
                            case 14:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 15:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 16:
                                bool = ProtoAdapter.BOOL.decode(reader);
                                break;
                            case 17:
                                f17 = ProtoAdapter.FLOAT.decode(reader);
                                break;
                        }
                        resourceModel$Companion$ADAPTER$1 = this;
                    } else {
                        Float f18 = f16;
                        Float f19 = f17;
                        return new ResourceModel(str2, str3, j3, j19, j16, j17, j18, mediaType, sizeF, f18 != null ? f18.floatValue() : 0.0f, linkedHashMap, rectF, str4, str, bool, f19 != null ? f19.floatValue() : 0.0f, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull ResourceModel value) {
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
                protoAdapter3.encodeWithTag(writer, 3, Long.valueOf(value.scaleDuration));
                protoAdapter3.encodeWithTag(writer, 4, Long.valueOf(value.sourceStart));
                protoAdapter3.encodeWithTag(writer, 5, Long.valueOf(value.sourceDuration));
                protoAdapter3.encodeWithTag(writer, 6, Long.valueOf(value.selectStart));
                protoAdapter3.encodeWithTag(writer, 7, Long.valueOf(value.selectDuration));
                MediaType.ADAPTER.encodeWithTag(writer, 8, value.type);
                SizeF.ADAPTER.encodeWithTag(writer, 9, value.size);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                protoAdapter4.encodeWithTag(writer, 11, Float.valueOf(value.volume));
                this.extrasAdapter.encodeWithTag(writer, 12, value.extras);
                RectF.ADAPTER.encodeWithTag(writer, 13, value.picClipRect);
                protoAdapter2.encodeWithTag(writer, 14, value.reversePath);
                protoAdapter2.encodeWithTag(writer, 15, value.normalPath);
                ProtoAdapter.BOOL.encodeWithTag(writer, 16, value.isReverseMode);
                protoAdapter4.encodeWithTag(writer, 17, Float.valueOf(value.deblurScore));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull ResourceModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.id) + protoAdapter2.encodedSizeWithTag(2, value.path);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(3, Long.valueOf(value.scaleDuration)) + protoAdapter3.encodedSizeWithTag(4, Long.valueOf(value.sourceStart)) + protoAdapter3.encodedSizeWithTag(5, Long.valueOf(value.sourceDuration)) + protoAdapter3.encodedSizeWithTag(6, Long.valueOf(value.selectStart)) + protoAdapter3.encodedSizeWithTag(7, Long.valueOf(value.selectDuration)) + MediaType.ADAPTER.encodedSizeWithTag(8, value.type) + SizeF.ADAPTER.encodedSizeWithTag(9, value.size);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(11, Float.valueOf(value.volume)) + this.extrasAdapter.encodedSizeWithTag(12, value.extras) + RectF.ADAPTER.encodedSizeWithTag(13, value.picClipRect) + protoAdapter2.encodedSizeWithTag(14, value.reversePath) + protoAdapter2.encodedSizeWithTag(15, value.normalPath) + ProtoAdapter.BOOL.encodedSizeWithTag(16, value.isReverseMode) + protoAdapter4.encodedSizeWithTag(17, Float.valueOf(value.deblurScore)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ResourceModel redact(@NotNull ResourceModel value) {
                ResourceModel copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (ResourceModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                SizeF sizeF = value.size;
                SizeF redact = sizeF != null ? SizeF.ADAPTER.redact(sizeF) : null;
                RectF rectF = value.picClipRect;
                copy = value.copy((r35 & 1) != 0 ? value.id : null, (r35 & 2) != 0 ? value.path : null, (r35 & 4) != 0 ? Long.valueOf(value.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(value.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(value.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(value.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(value.selectDuration) : null, (r35 & 128) != 0 ? value.type : null, (r35 & 256) != 0 ? value.size : redact, (r35 & 512) != 0 ? Float.valueOf(value.volume) : null, (r35 & 1024) != 0 ? value.extras : null, (r35 & 2048) != 0 ? value.picClipRect : rectF != null ? RectF.ADAPTER.redact(rectF) : null, (r35 & 4096) != 0 ? value.reversePath : null, (r35 & 8192) != 0 ? value.normalPath : null, (r35 & 16384) != 0 ? value.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(value.deblurScore) : null, (r35 & 65536) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public ResourceModel() {
        this(null, null, 0L, 0L, 0L, 0L, 0L, null, null, 0.0f, null, null, null, null, null, 0.0f, null, 131071, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ ResourceModel copy$default(ResourceModel resourceModel, String str, String str2, Long l3, Long l16, Long l17, Long l18, Long l19, MediaType mediaType, SizeF sizeF, Float f16, Map map, RectF rectF, String str3, String str4, Boolean bool, Float f17, ByteString byteString, int i3, Object obj) {
        return resourceModel.copy((i3 & 1) != 0 ? resourceModel.id : str, (i3 & 2) != 0 ? resourceModel.path : str2, (i3 & 4) != 0 ? Long.valueOf(resourceModel.scaleDuration) : l3, (i3 & 8) != 0 ? Long.valueOf(resourceModel.sourceStart) : l16, (i3 & 16) != 0 ? Long.valueOf(resourceModel.sourceDuration) : l17, (i3 & 32) != 0 ? Long.valueOf(resourceModel.selectStart) : l18, (i3 & 64) != 0 ? Long.valueOf(resourceModel.selectDuration) : l19, (i3 & 128) != 0 ? resourceModel.type : mediaType, (i3 & 256) != 0 ? resourceModel.size : sizeF, (i3 & 512) != 0 ? Float.valueOf(resourceModel.volume) : f16, (i3 & 1024) != 0 ? resourceModel.extras : map, (i3 & 2048) != 0 ? resourceModel.picClipRect : rectF, (i3 & 4096) != 0 ? resourceModel.reversePath : str3, (i3 & 8192) != 0 ? resourceModel.normalPath : str4, (i3 & 16384) != 0 ? resourceModel.isReverseMode : bool, (i3 & 32768) != 0 ? Float.valueOf(resourceModel.deblurScore) : f17, (i3 & 65536) != 0 ? resourceModel.unknownFields() : byteString);
    }

    @NotNull
    public final ResourceModel copy(@Nullable String id5, @Nullable String path, @Nullable Long scaleDuration, @Nullable Long r28, @Nullable Long sourceDuration, @Nullable Long selectStart, @Nullable Long selectDuration, @Nullable MediaType type, @Nullable SizeF size, @Nullable Float r342, @NotNull Map<String, String> extras, @Nullable RectF picClipRect, @Nullable String reversePath, @Nullable String normalPath, @Nullable Boolean isReverseMode, @Nullable Float deblurScore, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ResourceModel) iPatchRedirector.redirect((short) 7, this, id5, path, scaleDuration, r28, sourceDuration, selectStart, selectDuration, type, size, r342, extras, picClipRect, reversePath, normalPath, isReverseMode, deblurScore, unknownFields);
        }
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new ResourceModel(id5 == null ? "" : id5, path == null ? "" : path, scaleDuration != null ? scaleDuration.longValue() : 0L, r28 != null ? r28.longValue() : 0L, sourceDuration != null ? sourceDuration.longValue() : 0L, selectStart != null ? selectStart.longValue() : 0L, selectDuration != null ? selectDuration.longValue() : 0L, type, size, r342 != null ? r342.floatValue() : 0.0f, extras, picClipRect, reversePath == null ? "" : reversePath, normalPath == null ? "" : normalPath, isReverseMode, deblurScore != null ? deblurScore.floatValue() : 0.0f, unknownFields);
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
                if (this.deblurScore == resourceModel.deblurScore) {
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
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i18 = this.hashCode;
        if (i18 == 0) {
            int hashCode = ((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.path.hashCode()) * 37) + a.a(this.scaleDuration)) * 37) + a.a(this.sourceStart)) * 37) + a.a(this.sourceDuration)) * 37) + a.a(this.selectStart)) * 37) + a.a(this.selectDuration)) * 37;
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
            int floatToIntBits2 = ((hashCode2 + i19) * 37) + Float.floatToIntBits(this.deblurScore);
            this.hashCode = floatToIntBits2;
            return floatToIntBits2;
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
        arrayList.add("deblurScore=" + this.deblurScore);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ResourceModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ResourceModel(String str, String str2, long j3, long j16, long j17, long j18, long j19, MediaType mediaType, SizeF sizeF, float f16, Map map, RectF rectF, String str3, String str4, Boolean bool, float f17, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r8, r10, r12, r14, r16, r1, r18, r19, r20, (i3 & 2048) != 0 ? null : rectF, (i3 & 4096) != 0 ? "" : str3, (i3 & 8192) == 0 ? str4 : "", (i3 & 16384) != 0 ? null : bool, (32768 & i3) != 0 ? 0.0f : f17, (65536 & i3) != 0 ? ByteString.EMPTY : byteString);
        Map map2;
        Map emptyMap;
        String str5 = (i3 & 1) != 0 ? "" : str;
        String str6 = (i3 & 2) != 0 ? "" : str2;
        long j26 = (i3 & 4) != 0 ? 0L : j3;
        long j27 = (i3 & 8) != 0 ? 0L : j16;
        long j28 = (i3 & 16) != 0 ? 0L : j17;
        long j29 = (i3 & 32) != 0 ? 0L : j18;
        long j36 = (i3 & 64) != 0 ? 0L : j19;
        MediaType mediaType2 = (i3 & 128) != 0 ? null : mediaType;
        SizeF sizeF2 = (i3 & 256) != 0 ? null : sizeF;
        float f18 = (i3 & 512) != 0 ? 0.0f : f16;
        if ((i3 & 1024) != 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map2 = emptyMap;
        } else {
            map2 = map;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), mediaType, sizeF, Float.valueOf(f16), map, rectF, str3, str4, bool, Float.valueOf(f17), byteString, Integer.valueOf(i3), defaultConstructorMarker);
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
        builder.scaleDuration = this.scaleDuration;
        builder.sourceStart = this.sourceStart;
        builder.sourceDuration = this.sourceDuration;
        builder.selectStart = this.selectStart;
        builder.selectDuration = this.selectDuration;
        builder.type = this.type;
        builder.size = this.size;
        builder.volume = Float.valueOf(this.volume);
        builder.extras = this.extras;
        builder.picClipRect = this.picClipRect;
        builder.reversePath = this.reversePath;
        builder.normalPath = this.normalPath;
        builder.isReverseMode = this.isReverseMode;
        builder.deblurScore = Float.valueOf(this.deblurScore);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceModel(@NotNull String id5, @NotNull String path, long j3, long j16, long j17, long j18, long j19, @Nullable MediaType mediaType, @Nullable SizeF sizeF, float f16, @NotNull Map<String, String> extras, @Nullable RectF rectF, @NotNull String reversePath, @NotNull String normalPath, @Nullable Boolean bool, float f17, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(reversePath, "reversePath");
        Intrinsics.checkNotNullParameter(normalPath, "normalPath");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, path, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), mediaType, sizeF, Float.valueOf(f16), extras, rectF, reversePath, normalPath, bool, Float.valueOf(f17), unknownFields);
            return;
        }
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
        this.deblurScore = f17;
    }
}
