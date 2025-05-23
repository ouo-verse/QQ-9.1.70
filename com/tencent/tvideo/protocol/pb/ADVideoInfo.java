package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ADVideoInfo extends Message<ADVideoInfo, a> {
    public static final ProtoAdapter<ADVideoInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String cid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID, label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String flow_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String lid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String pid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "preVid", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String pre_vid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String vid;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<ADVideoInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383498a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383499b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383500c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383501d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f383502e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383503f = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ADVideoInfo build() {
            return new ADVideoInfo(this.f383498a, this.f383499b, this.f383500c, this.f383501d, this.f383502e, this.f383503f, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383499b = str;
            return this;
        }

        public a c(String str) {
            this.f383503f = str;
            return this;
        }

        public a d(String str) {
            this.f383500c = str;
            return this;
        }

        public a e(String str) {
            this.f383502e = str;
            return this;
        }

        public a f(String str) {
            this.f383501d = str;
            return this;
        }

        public a g(String str) {
            this.f383498a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<ADVideoInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ADVideoInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.ADVideoInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ADVideoInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            protoReader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, ADVideoInfo aDVideoInfo) throws IOException {
            if (!Objects.equals(aDVideoInfo.vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, aDVideoInfo.vid);
            }
            if (!Objects.equals(aDVideoInfo.cid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, aDVideoInfo.cid);
            }
            if (!Objects.equals(aDVideoInfo.lid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, aDVideoInfo.lid);
            }
            if (!Objects.equals(aDVideoInfo.pre_vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, aDVideoInfo.pre_vid);
            }
            if (!Objects.equals(aDVideoInfo.pid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, aDVideoInfo.pid);
            }
            if (!Objects.equals(aDVideoInfo.flow_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, aDVideoInfo.flow_id);
            }
            protoWriter.writeBytes(aDVideoInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ADVideoInfo aDVideoInfo) {
            int i3 = 0;
            if (!Objects.equals(aDVideoInfo.vid, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, aDVideoInfo.vid);
            }
            if (!Objects.equals(aDVideoInfo.cid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, aDVideoInfo.cid);
            }
            if (!Objects.equals(aDVideoInfo.lid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, aDVideoInfo.lid);
            }
            if (!Objects.equals(aDVideoInfo.pre_vid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, aDVideoInfo.pre_vid);
            }
            if (!Objects.equals(aDVideoInfo.pid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, aDVideoInfo.pid);
            }
            if (!Objects.equals(aDVideoInfo.flow_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, aDVideoInfo.flow_id);
            }
            return i3 + aDVideoInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ADVideoInfo redact(ADVideoInfo aDVideoInfo) {
            a newBuilder = aDVideoInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ADVideoInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5, str6, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ADVideoInfo)) {
            return false;
        }
        ADVideoInfo aDVideoInfo = (ADVideoInfo) obj;
        if (unknownFields().equals(aDVideoInfo.unknownFields()) && Internal.equals(this.vid, aDVideoInfo.vid) && Internal.equals(this.cid, aDVideoInfo.cid) && Internal.equals(this.lid, aDVideoInfo.lid) && Internal.equals(this.pre_vid, aDVideoInfo.pre_vid) && Internal.equals(this.pid, aDVideoInfo.pid) && Internal.equals(this.flow_id, aDVideoInfo.flow_id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = this.hashCode;
        if (i26 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.vid;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str2 = this.cid;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            String str3 = this.lid;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str4 = this.pre_vid;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            String str5 = this.pid;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            String str6 = this.flow_id;
            if (str6 != null) {
                i27 = str6.hashCode();
            }
            int i39 = i38 + i27;
            this.hashCode = i39;
            return i39;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.vid != null) {
            sb5.append(", vid=");
            sb5.append(Internal.sanitize(this.vid));
        }
        if (this.cid != null) {
            sb5.append(", cid=");
            sb5.append(Internal.sanitize(this.cid));
        }
        if (this.lid != null) {
            sb5.append(", lid=");
            sb5.append(Internal.sanitize(this.lid));
        }
        if (this.pre_vid != null) {
            sb5.append(", pre_vid=");
            sb5.append(Internal.sanitize(this.pre_vid));
        }
        if (this.pid != null) {
            sb5.append(", pid=");
            sb5.append(Internal.sanitize(this.pid));
        }
        if (this.flow_id != null) {
            sb5.append(", flow_id=");
            sb5.append(Internal.sanitize(this.flow_id));
        }
        StringBuilder replace = sb5.replace(0, 2, "ADVideoInfo{");
        replace.append('}');
        return replace.toString();
    }

    public ADVideoInfo(String str, String str2, String str3, String str4, String str5, String str6, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.vid = str;
            if (str2 != null) {
                this.cid = str2;
                if (str3 != null) {
                    this.lid = str3;
                    if (str4 != null) {
                        this.pre_vid = str4;
                        if (str5 != null) {
                            this.pid = str5;
                            if (str6 != null) {
                                this.flow_id = str6;
                                return;
                            }
                            throw new IllegalArgumentException("flow_id == null");
                        }
                        throw new IllegalArgumentException("pid == null");
                    }
                    throw new IllegalArgumentException("pre_vid == null");
                }
                throw new IllegalArgumentException("lid == null");
            }
            throw new IllegalArgumentException("cid == null");
        }
        throw new IllegalArgumentException("vid == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383498a = this.vid;
        aVar.f383499b = this.cid;
        aVar.f383500c = this.lid;
        aVar.f383501d = this.pre_vid;
        aVar.f383502e = this.pid;
        aVar.f383503f = this.flow_id;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
