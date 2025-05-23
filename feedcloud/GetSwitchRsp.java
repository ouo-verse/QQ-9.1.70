package feedcloud;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetSwitchRsp extends Message<GetSwitchRsp, a> {
    public static final ProtoAdapter<GetSwitchRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.SwitchInfos#ADAPTER", declaredName = TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, SwitchInfos> switch_;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<GetSwitchRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, SwitchInfos> f398501a = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetSwitchRsp build() {
            return new GetSwitchRsp(this.f398501a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<GetSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, SwitchInfos>> f398502a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetSwitchRsp.class, "type.googleapis.com/trpc.feedcloud.userswitch.GetSwitchRsp", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, SwitchInfos>> e() {
            ProtoAdapter<Map<String, SwitchInfos>> protoAdapter = this.f398502a;
            if (protoAdapter == null) {
                ProtoAdapter<Map<String, SwitchInfos>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SwitchInfos.ADAPTER);
                this.f398502a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetSwitchRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f398501a.putAll(e().decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetSwitchRsp getSwitchRsp) throws IOException {
            e().encodeWithTag(protoWriter, 1, getSwitchRsp.switch_);
            protoWriter.writeBytes(getSwitchRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetSwitchRsp getSwitchRsp) {
            return e().encodedSizeWithTag(1, getSwitchRsp.switch_) + 0 + getSwitchRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public GetSwitchRsp redact(GetSwitchRsp getSwitchRsp) {
            a newBuilder = getSwitchRsp.newBuilder();
            Internal.redactElements(newBuilder.f398501a, SwitchInfos.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetSwitchRsp(Map<String, SwitchInfos> map) {
        this(map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSwitchRsp)) {
            return false;
        }
        GetSwitchRsp getSwitchRsp = (GetSwitchRsp) obj;
        if (unknownFields().equals(getSwitchRsp.unknownFields()) && this.switch_.equals(getSwitchRsp.switch_)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.switch_.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.switch_.isEmpty()) {
            sb5.append(", switch=");
            sb5.append(this.switch_);
        }
        StringBuilder replace = sb5.replace(0, 2, "GetSwitchRsp{");
        replace.append('}');
        return replace.toString();
    }

    public GetSwitchRsp(Map<String, SwitchInfos> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.switch_ = Internal.immutableCopyOf("switch_", map);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398501a = Internal.copyOf(this.switch_);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
