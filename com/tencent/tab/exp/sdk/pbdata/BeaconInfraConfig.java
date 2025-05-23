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
public final class BeaconInfraConfig extends Message<BeaconInfraConfig, a> {
    public static final ProtoAdapter<BeaconInfraConfig> ADAPTER = new b();
    public static final String DEFAULT_APP_KEY = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String app_key;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a extends Message.Builder<BeaconInfraConfig, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f374187a;

        public a a(String str) {
            this.f374187a = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BeaconInfraConfig build() {
            return new BeaconInfraConfig(this.f374187a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static final class b extends ProtoAdapter<BeaconInfraConfig> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) BeaconInfraConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BeaconInfraConfig decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        FieldEncoding nextFieldEncoding = protoReader.getNextFieldEncoding();
                        aVar.addUnknownField(nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, BeaconInfraConfig beaconInfraConfig) throws IOException {
            String str = beaconInfraConfig.app_key;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            protoWriter.writeBytes(beaconInfraConfig.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(BeaconInfraConfig beaconInfraConfig) {
            int i3;
            String str = beaconInfraConfig.app_key;
            if (str != null) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, str);
            } else {
                i3 = 0;
            }
            return i3 + beaconInfraConfig.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BeaconInfraConfig redact(BeaconInfraConfig beaconInfraConfig) {
            a newBuilder = beaconInfraConfig.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public BeaconInfraConfig(String str) {
        this(str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BeaconInfraConfig)) {
            return false;
        }
        BeaconInfraConfig beaconInfraConfig = (BeaconInfraConfig) obj;
        if (unknownFields().equals(beaconInfraConfig.unknownFields()) && Internal.equals(this.app_key, beaconInfraConfig.app_key)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.app_key;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.app_key != null) {
            sb5.append(", app_key=");
            sb5.append(this.app_key);
        }
        StringBuilder replace = sb5.replace(0, 2, "BeaconInfraConfig{");
        replace.append('}');
        return replace.toString();
    }

    public BeaconInfraConfig(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.app_key = str;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f374187a = this.app_key;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
