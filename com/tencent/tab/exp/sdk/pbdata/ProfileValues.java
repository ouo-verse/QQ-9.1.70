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

/* loaded from: classes26.dex */
public final class ProfileValues extends Message<ProfileValues, a> {
    public static final ProtoAdapter<ProfileValues> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> user_attrs;

    /* loaded from: classes26.dex */
    public static final class a extends Message.Builder<ProfileValues, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f374228a = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProfileValues build() {
            return new ProfileValues(this.f374228a, super.buildUnknownFields());
        }

        public a b(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f374228a = list;
            return this;
        }
    }

    /* loaded from: classes26.dex */
    private static final class b extends ProtoAdapter<ProfileValues> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ProfileValues.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProfileValues decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        FieldEncoding nextFieldEncoding = protoReader.getNextFieldEncoding();
                        aVar.addUnknownField(nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        aVar.f374228a.add(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, ProfileValues profileValues) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 1, profileValues.user_attrs);
            protoWriter.writeBytes(profileValues.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ProfileValues profileValues) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, profileValues.user_attrs) + profileValues.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ProfileValues redact(ProfileValues profileValues) {
            a newBuilder = profileValues.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ProfileValues(List<String> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProfileValues)) {
            return false;
        }
        ProfileValues profileValues = (ProfileValues) obj;
        if (unknownFields().equals(profileValues.unknownFields()) && this.user_attrs.equals(profileValues.user_attrs)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.user_attrs.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.user_attrs.isEmpty()) {
            sb5.append(", user_attrs=");
            sb5.append(this.user_attrs);
        }
        StringBuilder replace = sb5.replace(0, 2, "ProfileValues{");
        replace.append('}');
        return replace.toString();
    }

    public ProfileValues(List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.user_attrs = Internal.immutableCopyOf("user_attrs", list);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f374228a = Internal.copyOf("user_attrs", this.user_attrs);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
