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

/* loaded from: classes27.dex */
public final class RewardAdPointItem extends Message<RewardAdPointItem, a> {
    public static final ProtoAdapter<RewardAdPointItem> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int lockStatus;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "pointId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String point_id;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdPointItem, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383789a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f383790b = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdPointItem build() {
            return new RewardAdPointItem(this.f383789a, this.f383790b, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f383790b = i3;
            return this;
        }

        public a c(String str) {
            this.f383789a = str;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdPointItem> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdPointItem.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdPointItem", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdPointItem decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.c(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RewardAdPointItem rewardAdPointItem) throws IOException {
            if (!Objects.equals(rewardAdPointItem.point_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, rewardAdPointItem.point_id);
            }
            if (!Objects.equals(Integer.valueOf(rewardAdPointItem.lockStatus), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(rewardAdPointItem.lockStatus));
            }
            protoWriter.writeBytes(rewardAdPointItem.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdPointItem rewardAdPointItem) {
            int i3;
            if (!Objects.equals(rewardAdPointItem.point_id, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, rewardAdPointItem.point_id) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(rewardAdPointItem.lockStatus), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(rewardAdPointItem.lockStatus));
            }
            return i3 + rewardAdPointItem.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdPointItem redact(RewardAdPointItem rewardAdPointItem) {
            a newBuilder = rewardAdPointItem.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdPointItem(String str, int i3) {
        this(str, i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdPointItem)) {
            return false;
        }
        RewardAdPointItem rewardAdPointItem = (RewardAdPointItem) obj;
        if (unknownFields().equals(rewardAdPointItem.unknownFields()) && Internal.equals(this.point_id, rewardAdPointItem.point_id) && Internal.equals(Integer.valueOf(this.lockStatus), Integer.valueOf(rewardAdPointItem.lockStatus))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.point_id;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = ((hashCode + i3) * 37) + this.lockStatus;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.point_id != null) {
            sb5.append(", point_id=");
            sb5.append(Internal.sanitize(this.point_id));
        }
        sb5.append(", lockStatus=");
        sb5.append(this.lockStatus);
        StringBuilder replace = sb5.replace(0, 2, "RewardAdPointItem{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdPointItem(String str, int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.point_id = str;
            this.lockStatus = i3;
            return;
        }
        throw new IllegalArgumentException("point_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383789a = this.point_id;
        aVar.f383790b = this.lockStatus;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
