package com.squareup.wire.internal;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 =*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001=B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020!H\u0016\u00a2\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010(J\u0015\u0010)\u001a\u00020\u00102\u0006\u0010'\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010.\u001a\u00020\u0010H\u0016J\u000b\u0010/\u001a\u00028\u0001\u00a2\u0006\u0002\u00100J\u0015\u00101\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\u00152\u0006\u0010'\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00104JU\u00105\u001a\u00020$\"\u0004\b\u0002\u001062\b\u00107\u001a\u0004\u0018\u00018\u00002\f\u00108\u001a\b\u0012\u0004\u0012\u0002H60\u00142\b\u00109\u001a\u0004\u0018\u0001H62 \u0010:\u001a\u001c\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u00020$0;\u00a2\u0006\u0002\u0010<R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR)\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u00020\u0015*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006>"}, d2 = {"Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "M", "", "B", "Lcom/squareup/wire/ProtoAdapter;", "binding", "Lcom/squareup/wire/internal/MessageBinding;", "(Lcom/squareup/wire/internal/MessageBinding;)V", "fieldBindingsArray", "", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "getFieldBindingsArray", "()[Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "[Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "fields", "", "", "getFields", "()Ljava/util/Map;", "jsonAlternateNames", "", "", "getJsonAlternateNames", "()Ljava/util/List;", "jsonNames", "getJsonNames", "messageType", "Lkotlin/reflect/KClass;", "jsonName", "getJsonName", "(Lcom/squareup/wire/internal/FieldOrOneOfBinding;)Ljava/lang/String;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Object;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Ljava/lang/Object;)V", "encodedSize", "(Ljava/lang/Object;)I", "equals", "", "other", "hashCode", "newBuilder", "()Ljava/lang/Object;", "redact", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "(Ljava/lang/Object;)Ljava/lang/String;", "writeAllFields", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "message", "jsonAdapters", "redactedFieldsAdapter", "encodeValue", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class RuntimeMessageAdapter<M, B> extends ProtoAdapter<M> {
    private static final String REDACTED = "\u2588\u2588";
    private final MessageBinding<M, B> binding;

    @NotNull
    private final FieldOrOneOfBinding<M, B>[] fieldBindingsArray;

    @NotNull
    private final Map<Integer, FieldOrOneOfBinding<M, B>> fields;

    @NotNull
    private final List<String> jsonAlternateNames;

    @NotNull
    private final List<String> jsonNames;
    private final KClass<? super M> messageType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeMessageAdapter(@NotNull MessageBinding<M, B> binding) {
        super(FieldEncoding.LENGTH_DELIMITED, binding.getMessageType(), binding.getTypeUrl(), binding.getSyntax());
        String str;
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.messageType = binding.getMessageType();
        Map<Integer, FieldOrOneOfBinding<M, B>> fields = binding.getFields();
        this.fields = fields;
        Object[] array = fields.values().toArray(new FieldOrOneOfBinding[0]);
        if (array != null) {
            FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr = (FieldOrOneOfBinding[]) array;
            this.fieldBindingsArray = fieldOrOneOfBindingArr;
            ArrayList arrayList = new ArrayList(fieldOrOneOfBindingArr.length);
            for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : fieldOrOneOfBindingArr) {
                arrayList.add(getJsonName(fieldOrOneOfBinding));
            }
            this.jsonNames = arrayList;
            FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr2 = this.fieldBindingsArray;
            ArrayList arrayList2 = new ArrayList(fieldOrOneOfBindingArr2.length);
            for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding2 : fieldOrOneOfBindingArr2) {
                if (!Intrinsics.areEqual(getJsonName(fieldOrOneOfBinding2), fieldOrOneOfBinding2.getDeclaredName())) {
                    str = fieldOrOneOfBinding2.getDeclaredName();
                } else if (!Intrinsics.areEqual(getJsonName(fieldOrOneOfBinding2), fieldOrOneOfBinding2.getName())) {
                    str = fieldOrOneOfBinding2.getName();
                } else {
                    str = null;
                }
                arrayList2.add(str);
            }
            this.jsonAlternateNames = arrayList2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public M decode(@NotNull ProtoReader reader) {
        ProtoAdapter<?> singleAdapter;
        Intrinsics.checkNotNullParameter(reader, "reader");
        B newBuilder = newBuilder();
        long beginMessage = reader.beginMessage();
        while (true) {
            int nextTag = reader.nextTag();
            if (nextTag == -1) {
                reader.endMessageAndGetUnknownFields(beginMessage);
                return this.binding.build(newBuilder);
            }
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fields.get(Integer.valueOf(nextTag));
            if (fieldOrOneOfBinding != null) {
                try {
                    if (fieldOrOneOfBinding.isMap()) {
                        singleAdapter = fieldOrOneOfBinding.getAdapter();
                    } else {
                        singleAdapter = fieldOrOneOfBinding.getSingleAdapter();
                    }
                    Object decode = singleAdapter.decode(reader);
                    Intrinsics.checkNotNull(decode);
                    fieldOrOneOfBinding.value(newBuilder, decode);
                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                    this.binding.addUnknownField(newBuilder, nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                }
            } else {
                FieldEncoding nextFieldEncoding = reader.getNextFieldEncoding();
                Intrinsics.checkNotNull(nextFieldEncoding);
                this.binding.addUnknownField(newBuilder, nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(reader));
            }
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(@NotNull ProtoWriter writer, @NotNull M value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            Object obj = fieldOrOneOfBinding.get(value);
            if (obj != null) {
                fieldOrOneOfBinding.getAdapter().encodeWithTag(writer, fieldOrOneOfBinding.getTag(), obj);
            }
        }
        writer.writeBytes(this.binding.unknownFields(value));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(@NotNull M value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int cachedSerializedSize = this.binding.getCachedSerializedSize(value);
        if (cachedSerializedSize != 0) {
            return cachedSerializedSize;
        }
        int i3 = 0;
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            Object obj = fieldOrOneOfBinding.get(value);
            if (obj != null) {
                i3 += fieldOrOneOfBinding.getAdapter().encodedSizeWithTag(fieldOrOneOfBinding.getTag(), obj);
            }
        }
        int size = i3 + this.binding.unknownFields(value).size();
        this.binding.setCachedSerializedSize(value, size);
        return size;
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof RuntimeMessageAdapter) && Intrinsics.areEqual(((RuntimeMessageAdapter) other).messageType, this.messageType)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final FieldOrOneOfBinding<M, B>[] getFieldBindingsArray() {
        return this.fieldBindingsArray;
    }

    @NotNull
    public final Map<Integer, FieldOrOneOfBinding<M, B>> getFields() {
        return this.fields;
    }

    @NotNull
    public final List<String> getJsonAlternateNames() {
        return this.jsonAlternateNames;
    }

    @NotNull
    public final String getJsonName(@NotNull FieldOrOneOfBinding<?, ?> jsonName) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jsonName, "$this$jsonName");
        if (jsonName.getWireFieldJsonName().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return jsonName.getDeclaredName();
        }
        return jsonName.getWireFieldJsonName();
    }

    @NotNull
    public final List<String> getJsonNames() {
        return this.jsonNames;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    @NotNull
    public final B newBuilder() {
        return this.binding.newBuilder();
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public M redact(@NotNull M value) {
        Intrinsics.checkNotNullParameter(value, "value");
        B newBuilder = this.binding.newBuilder();
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            if (fieldOrOneOfBinding.getRedacted() && fieldOrOneOfBinding.getLabel() == WireField.Label.REQUIRED) {
                throw new UnsupportedOperationException("Field '" + fieldOrOneOfBinding.getName() + "' in " + getType() + " is required and cannot be redacted.");
            }
            boolean isMessage = fieldOrOneOfBinding.isMessage();
            if (!fieldOrOneOfBinding.getRedacted() && (!isMessage || fieldOrOneOfBinding.getLabel().isRepeated())) {
                if (isMessage && fieldOrOneOfBinding.getLabel().isRepeated()) {
                    Object fromBuilder = fieldOrOneOfBinding.getFromBuilder(newBuilder);
                    if (fromBuilder != null) {
                        List list = (List) fromBuilder;
                        ProtoAdapter<?> singleAdapter = fieldOrOneOfBinding.getSingleAdapter();
                        if (singleAdapter != null) {
                            fieldOrOneOfBinding.set(newBuilder, Internal.m87redactElements(list, singleAdapter));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                    }
                }
            } else {
                Object fromBuilder2 = fieldOrOneOfBinding.getFromBuilder(newBuilder);
                if (fromBuilder2 != null) {
                    fieldOrOneOfBinding.set(newBuilder, fieldOrOneOfBinding.getAdapter().redact(fromBuilder2));
                }
            }
        }
        this.binding.clearUnknownFields(newBuilder);
        return this.binding.build(newBuilder);
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public String toString(@NotNull M value) {
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.messageType.getSimpleName());
        sb5.append('{');
        boolean z16 = true;
        for (FieldOrOneOfBinding<M, B> fieldOrOneOfBinding : this.fields.values()) {
            Object obj = fieldOrOneOfBinding.get(value);
            if (obj != null) {
                if (!z16) {
                    sb5.append(", ");
                }
                sb5.append(fieldOrOneOfBinding.getName());
                sb5.append('=');
                if (fieldOrOneOfBinding.getRedacted()) {
                    obj = REDACTED;
                }
                sb5.append(obj);
                z16 = false;
            }
        }
        sb5.append('}');
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    public final <A> void writeAllFields(@Nullable M message, @NotNull List<? extends A> jsonAdapters, @Nullable A redactedFieldsAdapter, @NotNull Function3<? super String, Object, ? super A, Unit> encodeValue) {
        Intrinsics.checkNotNullParameter(jsonAdapters, "jsonAdapters");
        Intrinsics.checkNotNullParameter(encodeValue, "encodeValue");
        int length = this.fieldBindingsArray.length;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < length; i3++) {
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fieldBindingsArray[i3];
            Intrinsics.checkNotNull(message);
            Object obj = fieldOrOneOfBinding.get(message);
            if (!fieldOrOneOfBinding.omitFromJson(getSyntax(), obj)) {
                if (fieldOrOneOfBinding.getRedacted() && redactedFieldsAdapter != null && obj != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(this.jsonNames.get(i3));
                } else {
                    encodeValue.invoke(this.jsonNames.get(i3), obj, jsonAdapters.get(i3));
                }
            }
        }
        if (arrayList != null && (!arrayList.isEmpty())) {
            Intrinsics.checkNotNull(redactedFieldsAdapter);
            encodeValue.invoke("__redacted_fields", arrayList, redactedFieldsAdapter);
        }
    }
}
