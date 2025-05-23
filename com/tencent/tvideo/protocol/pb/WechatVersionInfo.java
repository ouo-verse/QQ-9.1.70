package com.tencent.tvideo.protocol.pb;

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
/* loaded from: classes27.dex */
public final class WechatVersionInfo extends Message<WechatVersionInfo, a> {
    public static final ProtoAdapter<WechatVersionInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isSupportApi", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final boolean is_support_api;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "wxOpenSdkVersion", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int wx_open_sdk_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "wxSupportVersion", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int wx_support_version;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<WechatVersionInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f383810a = 0;

        /* renamed from: b, reason: collision with root package name */
        public boolean f383811b = false;

        /* renamed from: c, reason: collision with root package name */
        public int f383812c = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WechatVersionInfo build() {
            return new WechatVersionInfo(this.f383810a, this.f383811b, this.f383812c, super.buildUnknownFields());
        }

        public a b(boolean z16) {
            this.f383811b = z16;
            return this;
        }

        public a c(int i3) {
            this.f383812c = i3;
            return this;
        }

        public a d(int i3) {
            this.f383810a = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<WechatVersionInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) WechatVersionInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.WechatVersionInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WechatVersionInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                protoReader.readUnknownField(nextTag);
                            } else {
                                aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.b(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                        }
                    } else {
                        aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, WechatVersionInfo wechatVersionInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(wechatVersionInfo.wx_support_version), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(wechatVersionInfo.wx_support_version));
            }
            if (!Objects.equals(Boolean.valueOf(wechatVersionInfo.is_support_api), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, Boolean.valueOf(wechatVersionInfo.is_support_api));
            }
            if (!Objects.equals(Integer.valueOf(wechatVersionInfo.wx_open_sdk_version), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(wechatVersionInfo.wx_open_sdk_version));
            }
            protoWriter.writeBytes(wechatVersionInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(WechatVersionInfo wechatVersionInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(wechatVersionInfo.wx_support_version), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(wechatVersionInfo.wx_support_version));
            }
            if (!Objects.equals(Boolean.valueOf(wechatVersionInfo.is_support_api), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(2, Boolean.valueOf(wechatVersionInfo.is_support_api));
            }
            if (!Objects.equals(Integer.valueOf(wechatVersionInfo.wx_open_sdk_version), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(wechatVersionInfo.wx_open_sdk_version));
            }
            return i3 + wechatVersionInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public WechatVersionInfo redact(WechatVersionInfo wechatVersionInfo) {
            a newBuilder = wechatVersionInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public WechatVersionInfo(int i3, boolean z16, int i16) {
        this(i3, z16, i16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WechatVersionInfo)) {
            return false;
        }
        WechatVersionInfo wechatVersionInfo = (WechatVersionInfo) obj;
        if (unknownFields().equals(wechatVersionInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.wx_support_version), Integer.valueOf(wechatVersionInfo.wx_support_version)) && Internal.equals(Boolean.valueOf(this.is_support_api), Boolean.valueOf(wechatVersionInfo.is_support_api)) && Internal.equals(Integer.valueOf(this.wx_open_sdk_version), Integer.valueOf(wechatVersionInfo.wx_open_sdk_version))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.wx_support_version) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_support_api)) * 37) + this.wx_open_sdk_version;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", wx_support_version=");
        sb5.append(this.wx_support_version);
        sb5.append(", is_support_api=");
        sb5.append(this.is_support_api);
        sb5.append(", wx_open_sdk_version=");
        sb5.append(this.wx_open_sdk_version);
        StringBuilder replace = sb5.replace(0, 2, "WechatVersionInfo{");
        replace.append('}');
        return replace.toString();
    }

    public WechatVersionInfo(int i3, boolean z16, int i16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.wx_support_version = i3;
        this.is_support_api = z16;
        this.wx_open_sdk_version = i16;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383810a = this.wx_support_version;
        aVar.f383811b = this.is_support_api;
        aVar.f383812c = this.wx_open_sdk_version;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
