package com.tencent.mobileqq.tvideo.danmaku.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class VideoDmSwitchData extends Message<VideoDmSwitchData, a> {
    public static final ProtoAdapter<VideoDmSwitchData> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdRewardDefine$SecurityData.DATA_KEY, label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String dataKey;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int opened;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class a extends Message.Builder<VideoDmSwitchData, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f304415a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f304416b = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchData build() {
            return new VideoDmSwitchData(this.f304415a, this.f304416b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f304415a = str;
            return this;
        }

        public a c(int i3) {
            this.f304416b = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static final class b extends ProtoAdapter<VideoDmSwitchData> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoDmSwitchData.class, "type.googleapis.com/tvideo.VideoDmSwitchData", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchData decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.b(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, VideoDmSwitchData videoDmSwitchData) throws IOException {
            if (!Objects.equals(videoDmSwitchData.dataKey, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, videoDmSwitchData.dataKey);
            }
            if (!Objects.equals(Integer.valueOf(videoDmSwitchData.opened), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(videoDmSwitchData.opened));
            }
            protoWriter.writeBytes(videoDmSwitchData.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoDmSwitchData videoDmSwitchData) {
            int i3;
            if (!Objects.equals(videoDmSwitchData.dataKey, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, videoDmSwitchData.dataKey) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(videoDmSwitchData.opened), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(videoDmSwitchData.opened));
            }
            return i3 + videoDmSwitchData.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchData redact(VideoDmSwitchData videoDmSwitchData) {
            a newBuilder = videoDmSwitchData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoDmSwitchData(String str, int i3) {
        this(str, i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoDmSwitchData)) {
            return false;
        }
        VideoDmSwitchData videoDmSwitchData = (VideoDmSwitchData) obj;
        if (unknownFields().equals(videoDmSwitchData.unknownFields()) && Internal.equals(this.dataKey, videoDmSwitchData.dataKey) && Internal.equals(Integer.valueOf(this.opened), Integer.valueOf(videoDmSwitchData.opened))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.dataKey;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = ((hashCode + i3) * 37) + this.opened;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.dataKey != null) {
            sb5.append(", data_key=");
            sb5.append(Internal.sanitize(this.dataKey));
        }
        sb5.append(", opened=");
        sb5.append(this.opened);
        StringBuilder replace = sb5.replace(0, 2, "VideoDmSwitchData{");
        replace.append('}');
        return replace.toString();
    }

    public VideoDmSwitchData(String str, int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.dataKey = str;
            this.opened = i3;
            return;
        }
        throw new IllegalArgumentException("data_key == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f304415a = this.dataKey;
        aVar.f304416b = this.opened;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
