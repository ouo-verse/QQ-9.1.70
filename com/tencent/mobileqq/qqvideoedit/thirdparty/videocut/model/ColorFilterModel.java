package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dBa\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016Jw\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "sharpness", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;", "I", "<init>", "(IIIIIIIILokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ColorFilterModel extends AndroidMessage<ColorFilterModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<ColorFilterModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ColorFilterModel> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    public final int brightness;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    public final int contrast;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    public final int highlights;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @JvmField
    public final int hue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    @JvmField
    public final int saturation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    public final int shadows;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    public final int sharpness;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    @JvmField
    public final int temperature;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0005\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;", "a", "", "Ljava/lang/Integer;", "sharpness", "b", "brightness", "c", "contrast", "d", "hue", "e", "highlights", "f", "shadows", "g", "saturation", h.F, "temperature", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<ColorFilterModel, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer sharpness;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer brightness;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer contrast;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer hue;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer highlights;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer shadows;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer saturation;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer temperature;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorFilterModel build() {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            int i26;
            int i27;
            int i28;
            Integer num = this.sharpness;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            Integer num2 = this.brightness;
            if (num2 != null) {
                i16 = num2.intValue();
            } else {
                i16 = 0;
            }
            Integer num3 = this.contrast;
            if (num3 != null) {
                i17 = num3.intValue();
            } else {
                i17 = 0;
            }
            Integer num4 = this.hue;
            if (num4 != null) {
                i18 = num4.intValue();
            } else {
                i18 = 0;
            }
            Integer num5 = this.highlights;
            if (num5 != null) {
                i19 = num5.intValue();
            } else {
                i19 = 0;
            }
            Integer num6 = this.shadows;
            if (num6 != null) {
                i26 = num6.intValue();
            } else {
                i26 = 0;
            }
            Integer num7 = this.saturation;
            if (num7 != null) {
                i27 = num7.intValue();
            } else {
                i27 = 0;
            }
            Integer num8 = this.temperature;
            if (num8 != null) {
                i28 = num8.intValue();
            } else {
                i28 = 0;
            }
            return new ColorFilterModel(i3, i16, i17, i18, i19, i26, i27, i28, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ColorFilterModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<ColorFilterModel> {
        b(FieldEncoding fieldEncoding, KClass<ColorFilterModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.ColorFilterModel");
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorFilterModel decode(@NotNull ProtoReader reader) {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            int i26;
            int i27;
            Intrinsics.checkNotNullParameter(reader, "reader");
            long beginMessage = reader.beginMessage();
            Integer num = null;
            Integer num2 = null;
            Integer num3 = null;
            Integer num4 = null;
            Integer num5 = null;
            Integer num6 = null;
            Integer num7 = null;
            Integer num8 = null;
            while (true) {
                int nextTag = reader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 2:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 3:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 4:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 5:
                            num5 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 6:
                            num6 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 7:
                            num7 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 8:
                            num8 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                    Integer num9 = num;
                    int i28 = 0;
                    if (num9 != null) {
                        i3 = num9.intValue();
                    } else {
                        i3 = 0;
                    }
                    Integer num10 = num2;
                    if (num10 != null) {
                        i16 = num10.intValue();
                    } else {
                        i16 = 0;
                    }
                    Integer num11 = num3;
                    if (num11 != null) {
                        i17 = num11.intValue();
                    } else {
                        i17 = 0;
                    }
                    Integer num12 = num4;
                    if (num12 != null) {
                        i18 = num12.intValue();
                    } else {
                        i18 = 0;
                    }
                    Integer num13 = num5;
                    if (num13 != null) {
                        i19 = num13.intValue();
                    } else {
                        i19 = 0;
                    }
                    Integer num14 = num6;
                    if (num14 != null) {
                        i26 = num14.intValue();
                    } else {
                        i26 = 0;
                    }
                    Integer num15 = num7;
                    if (num15 != null) {
                        i27 = num15.intValue();
                    } else {
                        i27 = 0;
                    }
                    Integer num16 = num8;
                    if (num16 != null) {
                        i28 = num16.intValue();
                    }
                    return new ColorFilterModel(i3, i16, i17, i18, i19, i26, i27, i28, endMessageAndGetUnknownFields);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull ColorFilterModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
            protoAdapter.encodeWithTag(writer, 1, Integer.valueOf(value.sharpness));
            protoAdapter.encodeWithTag(writer, 2, Integer.valueOf(value.brightness));
            protoAdapter.encodeWithTag(writer, 3, Integer.valueOf(value.contrast));
            protoAdapter.encodeWithTag(writer, 4, Integer.valueOf(value.hue));
            protoAdapter.encodeWithTag(writer, 5, Integer.valueOf(value.highlights));
            protoAdapter.encodeWithTag(writer, 6, Integer.valueOf(value.shadows));
            protoAdapter.encodeWithTag(writer, 7, Integer.valueOf(value.saturation));
            protoAdapter.encodeWithTag(writer, 8, Integer.valueOf(value.temperature));
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull ColorFilterModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
            return protoAdapter.encodedSizeWithTag(1, Integer.valueOf(value.sharpness)) + protoAdapter.encodedSizeWithTag(2, Integer.valueOf(value.brightness)) + protoAdapter.encodedSizeWithTag(3, Integer.valueOf(value.contrast)) + protoAdapter.encodedSizeWithTag(4, Integer.valueOf(value.hue)) + protoAdapter.encodedSizeWithTag(5, Integer.valueOf(value.highlights)) + protoAdapter.encodedSizeWithTag(6, Integer.valueOf(value.shadows)) + protoAdapter.encodedSizeWithTag(7, Integer.valueOf(value.saturation)) + protoAdapter.encodedSizeWithTag(8, Integer.valueOf(value.temperature)) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ColorFilterModel redact(@NotNull ColorFilterModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return ColorFilterModel.copy$default(value, null, null, null, null, null, null, null, null, ByteString.EMPTY, 255, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ColorFilterModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public ColorFilterModel() {
        this(0, 0, 0, 0, 0, 0, 0, 0, null, 511, null);
    }

    public static /* synthetic */ ColorFilterModel copy$default(ColorFilterModel colorFilterModel, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, ByteString byteString, int i3, Object obj) {
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        Integer num15;
        Integer num16;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            num9 = Integer.valueOf(colorFilterModel.sharpness);
        } else {
            num9 = num;
        }
        if ((i3 & 2) != 0) {
            num10 = Integer.valueOf(colorFilterModel.brightness);
        } else {
            num10 = num2;
        }
        if ((i3 & 4) != 0) {
            num11 = Integer.valueOf(colorFilterModel.contrast);
        } else {
            num11 = num3;
        }
        if ((i3 & 8) != 0) {
            num12 = Integer.valueOf(colorFilterModel.hue);
        } else {
            num12 = num4;
        }
        if ((i3 & 16) != 0) {
            num13 = Integer.valueOf(colorFilterModel.highlights);
        } else {
            num13 = num5;
        }
        if ((i3 & 32) != 0) {
            num14 = Integer.valueOf(colorFilterModel.shadows);
        } else {
            num14 = num6;
        }
        if ((i3 & 64) != 0) {
            num15 = Integer.valueOf(colorFilterModel.saturation);
        } else {
            num15 = num7;
        }
        if ((i3 & 128) != 0) {
            num16 = Integer.valueOf(colorFilterModel.temperature);
        } else {
            num16 = num8;
        }
        if ((i3 & 256) != 0) {
            byteString2 = colorFilterModel.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return colorFilterModel.copy(num9, num10, num11, num12, num13, num14, num15, num16, byteString2);
    }

    @NotNull
    public final ColorFilterModel copy(@Nullable Integer sharpness, @Nullable Integer brightness, @Nullable Integer contrast, @Nullable Integer hue, @Nullable Integer highlights, @Nullable Integer shadows, @Nullable Integer saturation, @Nullable Integer temperature, @NotNull ByteString unknownFields) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        int i28 = 0;
        if (sharpness != null) {
            i3 = sharpness.intValue();
        } else {
            i3 = 0;
        }
        if (brightness != null) {
            i16 = brightness.intValue();
        } else {
            i16 = 0;
        }
        if (contrast != null) {
            i17 = contrast.intValue();
        } else {
            i17 = 0;
        }
        if (hue != null) {
            i18 = hue.intValue();
        } else {
            i18 = 0;
        }
        if (highlights != null) {
            i19 = highlights.intValue();
        } else {
            i19 = 0;
        }
        if (shadows != null) {
            i26 = shadows.intValue();
        } else {
            i26 = 0;
        }
        if (saturation != null) {
            i27 = saturation.intValue();
        } else {
            i27 = 0;
        }
        if (temperature != null) {
            i28 = temperature.intValue();
        }
        return new ColorFilterModel(i3, i16, i17, i18, i19, i26, i27, i28, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ColorFilterModel)) {
            return false;
        }
        ColorFilterModel colorFilterModel = (ColorFilterModel) other;
        if (Intrinsics.areEqual(unknownFields(), colorFilterModel.unknownFields()) && this.sharpness == colorFilterModel.sharpness && this.brightness == colorFilterModel.brightness && this.contrast == colorFilterModel.contrast && this.hue == colorFilterModel.hue && this.highlights == colorFilterModel.highlights && this.shadows == colorFilterModel.shadows && this.saturation == colorFilterModel.saturation && this.temperature == colorFilterModel.temperature) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((((((((((unknownFields().hashCode() * 37) + this.sharpness) * 37) + this.brightness) * 37) + this.contrast) * 37) + this.hue) * 37) + this.highlights) * 37) + this.shadows) * 37) + this.saturation) * 37) + this.temperature;
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
        arrayList.add("sharpness=" + this.sharpness);
        arrayList.add("brightness=" + this.brightness);
        arrayList.add("contrast=" + this.contrast);
        arrayList.add("hue=" + this.hue);
        arrayList.add("highlights=" + this.highlights);
        arrayList.add("shadows=" + this.shadows);
        arrayList.add("saturation=" + this.saturation);
        arrayList.add("temperature=" + this.temperature);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ColorFilterModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ ColorFilterModel(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, ByteString byteString, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this((i29 & 1) != 0 ? 0 : i3, (i29 & 2) != 0 ? 0 : i16, (i29 & 4) != 0 ? 0 : i17, (i29 & 8) != 0 ? 0 : i18, (i29 & 16) != 0 ? 0 : i19, (i29 & 32) != 0 ? 0 : i26, (i29 & 64) != 0 ? 0 : i27, (i29 & 128) == 0 ? i28 : 0, (i29 & 256) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.sharpness = Integer.valueOf(this.sharpness);
        aVar.brightness = Integer.valueOf(this.brightness);
        aVar.contrast = Integer.valueOf(this.contrast);
        aVar.hue = Integer.valueOf(this.hue);
        aVar.highlights = Integer.valueOf(this.highlights);
        aVar.shadows = Integer.valueOf(this.shadows);
        aVar.saturation = Integer.valueOf(this.saturation);
        aVar.temperature = Integer.valueOf(this.temperature);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorFilterModel(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.sharpness = i3;
        this.brightness = i16;
        this.contrast = i17;
        this.hue = i18;
        this.highlights = i19;
        this.shadows = i26;
        this.saturation = i27;
        this.temperature = i28;
    }
}
