package com.tencent.tab.exp.sdk.pbdata;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class AttaInfraConfig extends Message<AttaInfraConfig, a> {
    public static final ProtoAdapter<AttaInfraConfig> ADAPTER = new b();
    public static final String DEFAULT_ATTA_ID = "";
    public static final String DEFAULT_ATTA_TOKEN = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String atta_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String atta_token;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a extends Message.Builder<AttaInfraConfig, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f374185a;

        /* renamed from: b, reason: collision with root package name */
        public String f374186b;

        public a a(String str) {
            this.f374185a = str;
            return this;
        }

        public a b(String str) {
            this.f374186b = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AttaInfraConfig build() {
            return new AttaInfraConfig(this.f374185a, this.f374186b, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static final class b extends ProtoAdapter<AttaInfraConfig> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AttaInfraConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AttaInfraConfig decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            FieldEncoding nextFieldEncoding = protoReader.getNextFieldEncoding();
                            aVar.addUnknownField(nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(protoReader));
                        } else {
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.a(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AttaInfraConfig attaInfraConfig) throws IOException {
            String str = attaInfraConfig.atta_id;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            String str2 = attaInfraConfig.atta_token;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str2);
            }
            protoWriter.writeBytes(attaInfraConfig.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AttaInfraConfig attaInfraConfig) {
            int i3;
            String str = attaInfraConfig.atta_id;
            int i16 = 0;
            if (str != null) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, str);
            } else {
                i3 = 0;
            }
            String str2 = attaInfraConfig.atta_token;
            if (str2 != null) {
                i16 = ProtoAdapter.STRING.encodedSizeWithTag(2, str2);
            }
            return i3 + i16 + attaInfraConfig.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AttaInfraConfig redact(AttaInfraConfig attaInfraConfig) {
            a newBuilder = attaInfraConfig.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AttaInfraConfig(String str, String str2) {
        this(str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttaInfraConfig)) {
            return false;
        }
        AttaInfraConfig attaInfraConfig = (AttaInfraConfig) obj;
        if (unknownFields().equals(attaInfraConfig.unknownFields()) && Internal.equals(this.atta_id, attaInfraConfig.atta_id) && Internal.equals(this.atta_token, attaInfraConfig.atta_token)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.atta_id;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.atta_token;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int i19 = i18 + i17;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.atta_id != null) {
            sb5.append(", atta_id=");
            sb5.append(this.atta_id);
        }
        if (this.atta_token != null) {
            sb5.append(", atta_token=");
            sb5.append(this.atta_token);
        }
        StringBuilder replace = sb5.replace(0, 2, "AttaInfraConfig{");
        replace.append('}');
        return replace.toString();
    }

    public AttaInfraConfig(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.atta_id = str;
        this.atta_token = str2;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f374185a = this.atta_id;
        aVar.f374186b = this.atta_token;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
