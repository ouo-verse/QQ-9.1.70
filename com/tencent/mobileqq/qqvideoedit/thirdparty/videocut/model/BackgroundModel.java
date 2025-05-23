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
import com.tencent.luggage.wxa.xd.d1;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'By\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016Jz\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001aR\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundFillMode;", "bgFillMode", "bgColor", "bgPagPath", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "ratioType", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack;", "resPack", "categoryId", "", "fillScale", "Lokio/ByteString;", "unknownFields", "copy", "Ljava/lang/String;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundFillMode;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack;", UserInfo.SEX_FEMALE, "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundFillMode;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack;Ljava/lang/String;FLokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class BackgroundModel extends AndroidMessage<BackgroundModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<BackgroundModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<BackgroundModel> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @NotNull
    public final String bgColor;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundFillMode#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final BackgroundFillMode bgFillMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String bgPagPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @Nullable
    public final String categoryId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
    @JvmField
    public final float fillScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String id;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RatioType#ADAPTER", tag = 6)
    @JvmField
    @Nullable
    public final RatioType ratioType;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final SizeF renderSize;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundResPack#ADAPTER", tag = 7)
    @JvmField
    @Nullable
    public final BackgroundResPack resPack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0005R\u0016\u0010 \u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "a", "", "Ljava/lang/String;", "id", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "b", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundFillMode;", "c", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundFillMode;", "bgFillMode", "d", "bgColor", "e", "bgPagPath", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "f", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "ratioType", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack;", "g", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundResPack;", "resPack", h.F, "categoryId", "", "i", UserInfo.SEX_FEMALE, "fillScale", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<BackgroundModel, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public SizeF renderSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public BackgroundFillMode bgFillMode;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String bgColor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String bgPagPath;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public RatioType ratioType;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public BackgroundResPack resPack;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String categoryId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public float fillScale;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackgroundModel build() {
            String str = this.id;
            SizeF sizeF = this.renderSize;
            BackgroundFillMode backgroundFillMode = this.bgFillMode;
            String str2 = this.bgColor;
            if (str2 == null) {
                str2 = "";
            }
            return new BackgroundModel(str, sizeF, backgroundFillMode, str2, this.bgPagPath, this.ratioType, this.resPack, this.categoryId, this.fillScale, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<BackgroundModel> {
        b(FieldEncoding fieldEncoding, KClass<BackgroundModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.BackgroundModel");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackgroundModel decode(@NotNull ProtoReader reader) {
            String str;
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            SizeF sizeF = null;
            BackgroundFillMode backgroundFillMode = null;
            String str2 = null;
            String str3 = null;
            RatioType ratioType = null;
            BackgroundResPack backgroundResPack = null;
            String str4 = null;
            float f16 = 0.0f;
            String str5 = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            sizeF = SizeF.ADAPTER.decode(reader);
                            break;
                        case 3:
                            try {
                                backgroundFillMode = BackgroundFillMode.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            try {
                                ratioType = RatioType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                                break;
                            }
                        case 7:
                            backgroundResPack = BackgroundResPack.ADAPTER.decode(reader);
                            break;
                        case 8:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                    String str6 = str5;
                    SizeF sizeF2 = sizeF;
                    BackgroundFillMode backgroundFillMode2 = backgroundFillMode;
                    String str7 = str2;
                    if (str7 == null) {
                        str = "";
                    } else {
                        str = str7;
                    }
                    return new BackgroundModel(str6, sizeF2, backgroundFillMode2, str, str3, ratioType, backgroundResPack, str4, f16, endMessageAndGetUnknownFields);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull BackgroundModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.id);
            SizeF.ADAPTER.encodeWithTag(writer, 2, value.renderSize);
            BackgroundFillMode.ADAPTER.encodeWithTag(writer, 3, value.bgFillMode);
            protoAdapter.encodeWithTag(writer, 4, value.bgColor);
            protoAdapter.encodeWithTag(writer, 5, value.bgPagPath);
            RatioType.ADAPTER.encodeWithTag(writer, 6, value.ratioType);
            BackgroundResPack.ADAPTER.encodeWithTag(writer, 7, value.resPack);
            protoAdapter.encodeWithTag(writer, 8, value.categoryId);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 9, Float.valueOf(value.fillScale));
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull BackgroundModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, value.id) + SizeF.ADAPTER.encodedSizeWithTag(2, value.renderSize) + BackgroundFillMode.ADAPTER.encodedSizeWithTag(3, value.bgFillMode) + protoAdapter.encodedSizeWithTag(4, value.bgColor) + protoAdapter.encodedSizeWithTag(5, value.bgPagPath) + RatioType.ADAPTER.encodedSizeWithTag(6, value.ratioType) + BackgroundResPack.ADAPTER.encodedSizeWithTag(7, value.resPack) + protoAdapter.encodedSizeWithTag(8, value.categoryId) + ProtoAdapter.FLOAT.encodedSizeWithTag(9, Float.valueOf(value.fillScale)) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BackgroundModel redact(@NotNull BackgroundModel value) {
            SizeF sizeF;
            BackgroundResPack backgroundResPack;
            Intrinsics.checkNotNullParameter(value, "value");
            SizeF sizeF2 = value.renderSize;
            if (sizeF2 != null) {
                sizeF = SizeF.ADAPTER.redact(sizeF2);
            } else {
                sizeF = null;
            }
            BackgroundResPack backgroundResPack2 = value.resPack;
            if (backgroundResPack2 != null) {
                backgroundResPack = BackgroundResPack.ADAPTER.redact(backgroundResPack2);
            } else {
                backgroundResPack = null;
            }
            return BackgroundModel.copy$default(value, null, sizeF, null, null, null, null, backgroundResPack, null, 0.0f, ByteString.EMPTY, d1.CTRL_INDEX, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BackgroundModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public BackgroundModel() {
        this(null, null, null, null, null, null, null, null, 0.0f, null, 1023, null);
    }

    public static /* synthetic */ BackgroundModel copy$default(BackgroundModel backgroundModel, String str, SizeF sizeF, BackgroundFillMode backgroundFillMode, String str2, String str3, RatioType ratioType, BackgroundResPack backgroundResPack, String str4, float f16, ByteString byteString, int i3, Object obj) {
        return backgroundModel.copy((i3 & 1) != 0 ? backgroundModel.id : str, (i3 & 2) != 0 ? backgroundModel.renderSize : sizeF, (i3 & 4) != 0 ? backgroundModel.bgFillMode : backgroundFillMode, (i3 & 8) != 0 ? backgroundModel.bgColor : str2, (i3 & 16) != 0 ? backgroundModel.bgPagPath : str3, (i3 & 32) != 0 ? backgroundModel.ratioType : ratioType, (i3 & 64) != 0 ? backgroundModel.resPack : backgroundResPack, (i3 & 128) != 0 ? backgroundModel.categoryId : str4, (i3 & 256) != 0 ? backgroundModel.fillScale : f16, (i3 & 512) != 0 ? backgroundModel.unknownFields() : byteString);
    }

    @NotNull
    public final BackgroundModel copy(@Nullable String id5, @Nullable SizeF renderSize, @Nullable BackgroundFillMode bgFillMode, @Nullable String bgColor, @Nullable String bgPagPath, @Nullable RatioType ratioType, @Nullable BackgroundResPack resPack, @Nullable String categoryId, float fillScale, @NotNull ByteString unknownFields) {
        String str;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (bgColor == null) {
            str = "";
        } else {
            str = bgColor;
        }
        return new BackgroundModel(id5, renderSize, bgFillMode, str, bgPagPath, ratioType, resPack, categoryId, fillScale, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (other == this) {
            return true;
        }
        if (!(other instanceof BackgroundModel)) {
            return false;
        }
        BackgroundModel backgroundModel = (BackgroundModel) other;
        if (Intrinsics.areEqual(unknownFields(), backgroundModel.unknownFields()) && Intrinsics.areEqual(this.id, backgroundModel.id) && Intrinsics.areEqual(this.renderSize, backgroundModel.renderSize) && this.bgFillMode == backgroundModel.bgFillMode && Intrinsics.areEqual(this.bgColor, backgroundModel.bgColor) && Intrinsics.areEqual(this.bgPagPath, backgroundModel.bgPagPath) && this.ratioType == backgroundModel.ratioType && Intrinsics.areEqual(this.resPack, backgroundModel.resPack) && Intrinsics.areEqual(this.categoryId, backgroundModel.categoryId)) {
            if (this.fillScale == backgroundModel.fillScale) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
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
        int i27 = this.hashCode;
        if (i27 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.id;
            int i28 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (hashCode + i3) * 37;
            SizeF sizeF = this.renderSize;
            if (sizeF != null) {
                i16 = sizeF.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 37;
            BackgroundFillMode backgroundFillMode = this.bgFillMode;
            if (backgroundFillMode != null) {
                i17 = backgroundFillMode.hashCode();
            } else {
                i17 = 0;
            }
            int hashCode2 = (((i36 + i17) * 37) + this.bgColor.hashCode()) * 37;
            String str2 = this.bgPagPath;
            if (str2 != null) {
                i18 = str2.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (hashCode2 + i18) * 37;
            RatioType ratioType = this.ratioType;
            if (ratioType != null) {
                i19 = ratioType.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            BackgroundResPack backgroundResPack = this.resPack;
            if (backgroundResPack != null) {
                i26 = backgroundResPack.hashCode();
            } else {
                i26 = 0;
            }
            int i39 = (i38 + i26) * 37;
            String str3 = this.categoryId;
            if (str3 != null) {
                i28 = str3.hashCode();
            }
            int floatToIntBits = ((i39 + i28) * 37) + Float.floatToIntBits(this.fillScale);
            this.hashCode = floatToIntBits;
            return floatToIntBits;
        }
        return i27;
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
        SizeF sizeF = this.renderSize;
        if (sizeF != null) {
            arrayList.add("renderSize=" + sizeF);
        }
        BackgroundFillMode backgroundFillMode = this.bgFillMode;
        if (backgroundFillMode != null) {
            arrayList.add("bgFillMode=" + backgroundFillMode);
        }
        String str2 = this.bgColor;
        if (str2 != null) {
            arrayList.add("bgColor=" + Internal.sanitize(str2));
        }
        String str3 = this.bgPagPath;
        if (str3 != null) {
            arrayList.add("bgPagPath=" + Internal.sanitize(str3));
        }
        RatioType ratioType = this.ratioType;
        if (ratioType != null) {
            arrayList.add("ratioType=" + ratioType);
        }
        BackgroundResPack backgroundResPack = this.resPack;
        if (backgroundResPack != null) {
            arrayList.add("resPack=" + backgroundResPack);
        }
        String str4 = this.categoryId;
        if (str4 != null) {
            arrayList.add("categoryId=" + Internal.sanitize(str4));
        }
        arrayList.add("fillScale=" + this.fillScale);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "BackgroundModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ BackgroundModel(String str, SizeF sizeF, BackgroundFillMode backgroundFillMode, String str2, String str3, RatioType ratioType, BackgroundResPack backgroundResPack, String str4, float f16, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : sizeF, (i3 & 4) != 0 ? null : backgroundFillMode, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : ratioType, (i3 & 64) != 0 ? null : backgroundResPack, (i3 & 128) == 0 ? str4 : null, (i3 & 256) != 0 ? 0.0f : f16, (i3 & 512) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.renderSize = this.renderSize;
        aVar.bgFillMode = this.bgFillMode;
        aVar.bgColor = this.bgColor;
        aVar.bgPagPath = this.bgPagPath;
        aVar.ratioType = this.ratioType;
        aVar.resPack = this.resPack;
        aVar.categoryId = this.categoryId;
        aVar.fillScale = this.fillScale;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundModel(@Nullable String str, @Nullable SizeF sizeF, @Nullable BackgroundFillMode backgroundFillMode, @NotNull String bgColor, @Nullable String str2, @Nullable RatioType ratioType, @Nullable BackgroundResPack backgroundResPack, @Nullable String str3, float f16, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.id = str;
        this.renderSize = sizeF;
        this.bgFillMode = backgroundFillMode;
        this.bgColor = bgColor;
        this.bgPagPath = str2;
        this.ratioType = ratioType;
        this.resPack = backgroundResPack;
        this.categoryId = str3;
        this.fillScale = f16;
    }
}
