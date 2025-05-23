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
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetRightInfoRsp extends Message<GetRightInfoRsp, a> {
    public static final ProtoAdapter<GetRightInfoRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isProtectionOn", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final boolean is_protection_on;

    @WireField(adapter = "feedcloud.RightInfo#ADAPTER", jsonName = "rightInfo", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RightInfo right_info;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<GetRightInfoRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public RightInfo f398497a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f398498b = false;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetRightInfoRsp build() {
            return new GetRightInfoRsp(this.f398497a, this.f398498b, super.buildUnknownFields());
        }

        public a b(boolean z16) {
            this.f398498b = z16;
            return this;
        }

        public a c(RightInfo rightInfo) {
            this.f398497a = rightInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<GetRightInfoRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetRightInfoRsp.class, "type.googleapis.com/trpc.feedcloud.comment_right.GetRightInfoRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetRightInfoRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.b(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                        }
                    } else {
                        aVar.c(RightInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetRightInfoRsp getRightInfoRsp) throws IOException {
            if (!Objects.equals(getRightInfoRsp.right_info, null)) {
                RightInfo.ADAPTER.encodeWithTag(protoWriter, 1, getRightInfoRsp.right_info);
            }
            if (!Objects.equals(Boolean.valueOf(getRightInfoRsp.is_protection_on), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, Boolean.valueOf(getRightInfoRsp.is_protection_on));
            }
            protoWriter.writeBytes(getRightInfoRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetRightInfoRsp getRightInfoRsp) {
            int i3 = 0;
            if (!Objects.equals(getRightInfoRsp.right_info, null)) {
                i3 = 0 + RightInfo.ADAPTER.encodedSizeWithTag(1, getRightInfoRsp.right_info);
            }
            if (!Objects.equals(Boolean.valueOf(getRightInfoRsp.is_protection_on), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(2, Boolean.valueOf(getRightInfoRsp.is_protection_on));
            }
            return i3 + getRightInfoRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public GetRightInfoRsp redact(GetRightInfoRsp getRightInfoRsp) {
            a newBuilder = getRightInfoRsp.newBuilder();
            RightInfo rightInfo = newBuilder.f398497a;
            if (rightInfo != null) {
                newBuilder.f398497a = RightInfo.ADAPTER.redact(rightInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetRightInfoRsp(RightInfo rightInfo, boolean z16) {
        this(rightInfo, z16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetRightInfoRsp)) {
            return false;
        }
        GetRightInfoRsp getRightInfoRsp = (GetRightInfoRsp) obj;
        if (unknownFields().equals(getRightInfoRsp.unknownFields()) && Internal.equals(this.right_info, getRightInfoRsp.right_info) && Internal.equals(Boolean.valueOf(this.is_protection_on), Boolean.valueOf(getRightInfoRsp.is_protection_on))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RightInfo rightInfo = this.right_info;
            if (rightInfo != null) {
                i3 = rightInfo.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = ((hashCode + i3) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_protection_on);
            this.hashCode = a16;
            return a16;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.right_info != null) {
            sb5.append(", right_info=");
            sb5.append(this.right_info);
        }
        sb5.append(", is_protection_on=");
        sb5.append(this.is_protection_on);
        StringBuilder replace = sb5.replace(0, 2, "GetRightInfoRsp{");
        replace.append('}');
        return replace.toString();
    }

    public GetRightInfoRsp(RightInfo rightInfo, boolean z16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.right_info = rightInfo;
        this.is_protection_on = z16;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398497a = this.right_info;
        aVar.f398498b = this.is_protection_on;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
