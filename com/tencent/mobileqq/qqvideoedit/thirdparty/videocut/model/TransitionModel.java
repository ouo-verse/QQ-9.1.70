package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#Bu\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u008f\u0001\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0014\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0014\u0010\u0016\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "path", "position", "", "duration", "landscapePagPath", "pagPath", MiniChatConstants.MINI_APP_LANDSCAPE, "resId", "relatedClipId", "categoryId", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", "Ljava/lang/String;", "I", "J", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TransitionModel extends AndroidMessage<TransitionModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<TransitionModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TransitionModel> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @JvmField
    @NotNull
    public final String categoryId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    public final long duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    @JvmField
    public final boolean isLandscape;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @NotNull
    public final String landscapePagPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @NotNull
    public final String pagPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    public final int position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @JvmField
    @NotNull
    public final String relatedClipId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @NotNull
    public final String resId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0016\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0005R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0005R\u0016\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0005R\u0016\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0005\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", "a", "", "Ljava/lang/String;", "id", "b", "path", "", "c", "I", "position", "", "d", "J", "duration", "e", "landscapePagPath", "f", "pagPath", "", "g", "Ljava/lang/Boolean;", MiniChatConstants.MINI_APP_LANDSCAPE, h.F, "resId", "i", "relatedClipId", "j", "categoryId", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<TransitionModel, a> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public int position;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long duration;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Boolean isLandscape;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String id = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String path = "";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String landscapePagPath = "";

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String pagPath = "";

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String resId = "";

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String relatedClipId = "";

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public String categoryId = "";

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitionModel build() {
            boolean z16;
            String str = this.id;
            String str2 = this.path;
            int i3 = this.position;
            long j3 = this.duration;
            String str3 = this.landscapePagPath;
            String str4 = this.pagPath;
            Boolean bool = this.isLandscape;
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            return new TransitionModel(str, str2, i3, j3, str3, str4, z16, this.resId, this.relatedClipId, this.categoryId, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<TransitionModel> {
        b(FieldEncoding fieldEncoding, KClass<TransitionModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.TransitionModel");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitionModel decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            String str = "";
            boolean z16 = false;
            String str2 = "";
            String str3 = str2;
            String str4 = str3;
            int i3 = 0;
            long j3 = 0;
            Boolean bool = null;
            String str5 = str4;
            String str6 = str5;
            String str7 = str6;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            i3 = ProtoAdapter.INT32.decode(reader).intValue();
                            break;
                        case 4:
                            j3 = ProtoAdapter.INT64.decode(reader).longValue();
                            break;
                        case 5:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 8:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 10:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                    String str8 = str;
                    String str9 = str5;
                    String str10 = str6;
                    String str11 = str7;
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        z16 = bool2.booleanValue();
                    }
                    return new TransitionModel(str8, str9, i3, j3, str10, str11, z16, str2, str3, str4, endMessageAndGetUnknownFields);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull TransitionModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.id);
            protoAdapter.encodeWithTag(writer, 2, value.path);
            ProtoAdapter.INT32.encodeWithTag(writer, 3, Integer.valueOf(value.position));
            ProtoAdapter.INT64.encodeWithTag(writer, 4, Long.valueOf(value.duration));
            protoAdapter.encodeWithTag(writer, 5, value.landscapePagPath);
            protoAdapter.encodeWithTag(writer, 6, value.pagPath);
            ProtoAdapter.BOOL.encodeWithTag(writer, 7, Boolean.valueOf(value.isLandscape));
            protoAdapter.encodeWithTag(writer, 8, value.resId);
            protoAdapter.encodeWithTag(writer, 9, value.relatedClipId);
            protoAdapter.encodeWithTag(writer, 10, value.categoryId);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull TransitionModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, value.id) + protoAdapter.encodedSizeWithTag(2, value.path) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(value.position)) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(value.duration)) + protoAdapter.encodedSizeWithTag(5, value.landscapePagPath) + protoAdapter.encodedSizeWithTag(6, value.pagPath) + ProtoAdapter.BOOL.encodedSizeWithTag(7, Boolean.valueOf(value.isLandscape)) + protoAdapter.encodedSizeWithTag(8, value.resId) + protoAdapter.encodedSizeWithTag(9, value.relatedClipId) + protoAdapter.encodedSizeWithTag(10, value.categoryId) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public TransitionModel redact(@NotNull TransitionModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return TransitionModel.copy$default(value, null, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 1023, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TransitionModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public TransitionModel() {
        this(null, null, 0, 0L, null, null, false, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ TransitionModel copy$default(TransitionModel transitionModel, String str, String str2, Integer num, Long l3, String str3, String str4, Boolean bool, String str5, String str6, String str7, ByteString byteString, int i3, Object obj) {
        return transitionModel.copy((i3 & 1) != 0 ? transitionModel.id : str, (i3 & 2) != 0 ? transitionModel.path : str2, (i3 & 4) != 0 ? Integer.valueOf(transitionModel.position) : num, (i3 & 8) != 0 ? Long.valueOf(transitionModel.duration) : l3, (i3 & 16) != 0 ? transitionModel.landscapePagPath : str3, (i3 & 32) != 0 ? transitionModel.pagPath : str4, (i3 & 64) != 0 ? Boolean.valueOf(transitionModel.isLandscape) : bool, (i3 & 128) != 0 ? transitionModel.resId : str5, (i3 & 256) != 0 ? transitionModel.relatedClipId : str6, (i3 & 512) != 0 ? transitionModel.categoryId : str7, (i3 & 1024) != 0 ? transitionModel.unknownFields() : byteString);
    }

    @NotNull
    public final TransitionModel copy(@Nullable String id5, @Nullable String path, @Nullable Integer position, @Nullable Long duration, @Nullable String landscapePagPath, @Nullable String pagPath, @Nullable Boolean isLandscape, @Nullable String resId, @Nullable String relatedClipId, @Nullable String categoryId, @NotNull ByteString unknownFields) {
        String str;
        String str2;
        int i3;
        long j3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (id5 == null) {
            str = "";
        } else {
            str = id5;
        }
        if (path == null) {
            str2 = "";
        } else {
            str2 = path;
        }
        boolean z16 = false;
        if (position != null) {
            i3 = position.intValue();
        } else {
            i3 = 0;
        }
        if (duration != null) {
            j3 = duration.longValue();
        } else {
            j3 = 0;
        }
        if (landscapePagPath == null) {
            str3 = "";
        } else {
            str3 = landscapePagPath;
        }
        if (pagPath == null) {
            str4 = "";
        } else {
            str4 = pagPath;
        }
        if (isLandscape != null) {
            z16 = isLandscape.booleanValue();
        }
        boolean z17 = z16;
        if (resId == null) {
            str5 = "";
        } else {
            str5 = resId;
        }
        if (relatedClipId == null) {
            str6 = "";
        } else {
            str6 = relatedClipId;
        }
        if (categoryId == null) {
            str7 = "";
        } else {
            str7 = categoryId;
        }
        return new TransitionModel(str, str2, i3, j3, str3, str4, z17, str5, str6, str7, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TransitionModel)) {
            return false;
        }
        TransitionModel transitionModel = (TransitionModel) other;
        if (Intrinsics.areEqual(unknownFields(), transitionModel.unknownFields()) && Intrinsics.areEqual(this.id, transitionModel.id) && Intrinsics.areEqual(this.path, transitionModel.path) && this.position == transitionModel.position && this.duration == transitionModel.duration && Intrinsics.areEqual(this.landscapePagPath, transitionModel.landscapePagPath) && Intrinsics.areEqual(this.pagPath, transitionModel.pagPath) && this.isLandscape == transitionModel.isLandscape && Intrinsics.areEqual(this.resId, transitionModel.resId) && Intrinsics.areEqual(this.relatedClipId, transitionModel.relatedClipId) && Intrinsics.areEqual(this.categoryId, transitionModel.categoryId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.path.hashCode()) * 37) + this.position) * 37) + androidx.fragment.app.a.a(this.duration)) * 37) + this.landscapePagPath.hashCode()) * 37) + this.pagPath.hashCode()) * 37) + com.tencent.aio.widget.textView.param.a.a(this.isLandscape)) * 37) + this.resId.hashCode()) * 37) + this.relatedClipId.hashCode()) * 37) + this.categoryId.hashCode();
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
        String str = this.id;
        if (str != null) {
            arrayList.add("id=" + Internal.sanitize(str));
        }
        String str2 = this.path;
        if (str2 != null) {
            arrayList.add("path=" + Internal.sanitize(str2));
        }
        arrayList.add("position=" + this.position);
        arrayList.add("duration=" + this.duration);
        String str3 = this.landscapePagPath;
        if (str3 != null) {
            arrayList.add("landscapePagPath=" + Internal.sanitize(str3));
        }
        String str4 = this.pagPath;
        if (str4 != null) {
            arrayList.add("pagPath=" + Internal.sanitize(str4));
        }
        arrayList.add("isLandscape=" + this.isLandscape);
        String str5 = this.resId;
        if (str5 != null) {
            arrayList.add("resId=" + Internal.sanitize(str5));
        }
        String str6 = this.relatedClipId;
        if (str6 != null) {
            arrayList.add("relatedClipId=" + Internal.sanitize(str6));
        }
        String str7 = this.categoryId;
        if (str7 != null) {
            arrayList.add("categoryId=" + Internal.sanitize(str7));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TransitionModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ TransitionModel(String str, String str2, int i3, long j3, String str3, String str4, boolean z16, String str5, String str6, String str7, ByteString byteString, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? 0L : j3, (i16 & 16) != 0 ? "" : str3, (i16 & 32) != 0 ? "" : str4, (i16 & 64) == 0 ? z16 : false, (i16 & 128) != 0 ? "" : str5, (i16 & 256) != 0 ? "" : str6, (i16 & 512) == 0 ? str7 : "", (i16 & 1024) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.path = this.path;
        aVar.position = this.position;
        aVar.duration = this.duration;
        aVar.landscapePagPath = this.landscapePagPath;
        aVar.pagPath = this.pagPath;
        aVar.isLandscape = Boolean.valueOf(this.isLandscape);
        aVar.resId = this.resId;
        aVar.relatedClipId = this.relatedClipId;
        aVar.categoryId = this.categoryId;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransitionModel(@NotNull String id5, @NotNull String path, int i3, long j3, @NotNull String landscapePagPath, @NotNull String pagPath, boolean z16, @NotNull String resId, @NotNull String relatedClipId, @NotNull String categoryId, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(landscapePagPath, "landscapePagPath");
        Intrinsics.checkNotNullParameter(pagPath, "pagPath");
        Intrinsics.checkNotNullParameter(resId, "resId");
        Intrinsics.checkNotNullParameter(relatedClipId, "relatedClipId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.id = id5;
        this.path = path;
        this.position = i3;
        this.duration = j3;
        this.landscapePagPath = landscapePagPath;
        this.pagPath = pagPath;
        this.isLandscape = z16;
        this.resId = resId;
        this.relatedClipId = relatedClipId;
        this.categoryId = categoryId;
    }
}
