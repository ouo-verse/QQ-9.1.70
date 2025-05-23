package feedcloud;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SwitchInfos extends Message<SwitchInfos, a> {
    public static final ProtoAdapter<SwitchInfos> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, Boolean> switchInfo;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<SwitchInfos, a> {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, Boolean> f398534a = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SwitchInfos build() {
            return new SwitchInfos(this.f398534a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<SwitchInfos> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, Boolean>> f398535a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SwitchInfos.class, "type.googleapis.com/trpc.feedcloud.userswitch.SwitchInfos", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, Boolean>> e() {
            ProtoAdapter<Map<String, Boolean>> protoAdapter = this.f398535a;
            if (protoAdapter == null) {
                ProtoAdapter<Map<String, Boolean>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
                this.f398535a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SwitchInfos decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f398534a.putAll(e().decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SwitchInfos switchInfos) throws IOException {
            e().encodeWithTag(protoWriter, 1, switchInfos.switchInfo);
            protoWriter.writeBytes(switchInfos.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SwitchInfos switchInfos) {
            return e().encodedSizeWithTag(1, switchInfos.switchInfo) + 0 + switchInfos.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SwitchInfos redact(SwitchInfos switchInfos) {
            a newBuilder = switchInfos.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SwitchInfos(Map<String, Boolean> map) {
        this(map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwitchInfos)) {
            return false;
        }
        SwitchInfos switchInfos = (SwitchInfos) obj;
        if (unknownFields().equals(switchInfos.unknownFields()) && this.switchInfo.equals(switchInfos.switchInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.switchInfo.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.switchInfo.isEmpty()) {
            sb5.append(", switchInfo=");
            sb5.append(this.switchInfo);
        }
        StringBuilder replace = sb5.replace(0, 2, "SwitchInfos{");
        replace.append('}');
        return replace.toString();
    }

    public SwitchInfos(Map<String, Boolean> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.switchInfo = Internal.immutableCopyOf("switchInfo", map);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398534a = Internal.copyOf(this.switchInfo);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
