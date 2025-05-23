package com.tencent.tab.exp.sdk.pbdata;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class FilterOptions extends Message<FilterOptions, a> {
    public static final ProtoAdapter<FilterOptions> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 3)
    public final List<String> exp_group_keys;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> module_codes;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> scene_ids;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a extends Message.Builder<FilterOptions, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f374205a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public List<String> f374206b = Internal.newMutableList();

        /* renamed from: c, reason: collision with root package name */
        public List<String> f374207c = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FilterOptions build() {
            return new FilterOptions(this.f374205a, this.f374206b, this.f374207c, super.buildUnknownFields());
        }

        public a b(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f374207c = list;
            return this;
        }

        public a c(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f374206b = list;
            return this;
        }

        public a d(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f374205a = list;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static final class b extends ProtoAdapter<FilterOptions> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) FilterOptions.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FilterOptions decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                FieldEncoding nextFieldEncoding = protoReader.getNextFieldEncoding();
                                aVar.addUnknownField(nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(protoReader));
                            } else {
                                aVar.f374207c.add(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.f374206b.add(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.f374205a.add(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, FilterOptions filterOptions) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 1, filterOptions.scene_ids);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 2, filterOptions.module_codes);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 3, filterOptions.exp_group_keys);
            protoWriter.writeBytes(filterOptions.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(FilterOptions filterOptions) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.asRepeated().encodedSizeWithTag(1, filterOptions.scene_ids) + protoAdapter.asRepeated().encodedSizeWithTag(2, filterOptions.module_codes) + protoAdapter.asRepeated().encodedSizeWithTag(3, filterOptions.exp_group_keys) + filterOptions.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public FilterOptions redact(FilterOptions filterOptions) {
            a newBuilder = filterOptions.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public FilterOptions(List<String> list, List<String> list2, List<String> list3) {
        this(list, list2, list3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FilterOptions)) {
            return false;
        }
        FilterOptions filterOptions = (FilterOptions) obj;
        if (unknownFields().equals(filterOptions.unknownFields()) && this.scene_ids.equals(filterOptions.scene_ids) && this.module_codes.equals(filterOptions.module_codes) && this.exp_group_keys.equals(filterOptions.exp_group_keys)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.scene_ids.hashCode()) * 37) + this.module_codes.hashCode()) * 37) + this.exp_group_keys.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.scene_ids.isEmpty()) {
            sb5.append(", scene_ids=");
            sb5.append(this.scene_ids);
        }
        if (!this.module_codes.isEmpty()) {
            sb5.append(", module_codes=");
            sb5.append(this.module_codes);
        }
        if (!this.exp_group_keys.isEmpty()) {
            sb5.append(", exp_group_keys=");
            sb5.append(this.exp_group_keys);
        }
        StringBuilder replace = sb5.replace(0, 2, "FilterOptions{");
        replace.append('}');
        return replace.toString();
    }

    public FilterOptions(List<String> list, List<String> list2, List<String> list3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.scene_ids = Internal.immutableCopyOf("scene_ids", list);
        this.module_codes = Internal.immutableCopyOf("module_codes", list2);
        this.exp_group_keys = Internal.immutableCopyOf("exp_group_keys", list3);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f374205a = Internal.copyOf("scene_ids", this.scene_ids);
        aVar.f374206b = Internal.copyOf("module_codes", this.module_codes);
        aVar.f374207c = Internal.copyOf("exp_group_keys", this.exp_group_keys);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
