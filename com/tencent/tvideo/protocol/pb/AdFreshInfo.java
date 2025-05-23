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
import java.util.List;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdFreshInfo extends Message<AdFreshInfo, a> {
    public static final ProtoAdapter<AdFreshInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adFreshInsideList", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> ad_fresh_inside_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adFreshList", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> ad_fresh_list;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFreshInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f383616a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public List<String> f383617b = Internal.newMutableList();

        public a a(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f383617b = list;
            return this;
        }

        public a b(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f383616a = list;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AdFreshInfo build() {
            return new AdFreshInfo(this.f383616a, this.f383617b, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFreshInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFreshInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFreshInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFreshInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.f383617b.add(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.f383616a.add(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdFreshInfo adFreshInfo) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 1, adFreshInfo.ad_fresh_list);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 2, adFreshInfo.ad_fresh_inside_list);
            protoWriter.writeBytes(adFreshInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFreshInfo adFreshInfo) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.asRepeated().encodedSizeWithTag(1, adFreshInfo.ad_fresh_list) + 0 + protoAdapter.asRepeated().encodedSizeWithTag(2, adFreshInfo.ad_fresh_inside_list) + adFreshInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdFreshInfo redact(AdFreshInfo adFreshInfo) {
            a newBuilder = adFreshInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFreshInfo(List<String> list, List<String> list2) {
        this(list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFreshInfo)) {
            return false;
        }
        AdFreshInfo adFreshInfo = (AdFreshInfo) obj;
        if (unknownFields().equals(adFreshInfo.unknownFields()) && this.ad_fresh_list.equals(adFreshInfo.ad_fresh_list) && this.ad_fresh_inside_list.equals(adFreshInfo.ad_fresh_inside_list)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.ad_fresh_list.hashCode()) * 37) + this.ad_fresh_inside_list.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.ad_fresh_list.isEmpty()) {
            sb5.append(", ad_fresh_list=");
            sb5.append(Internal.sanitize(this.ad_fresh_list));
        }
        if (!this.ad_fresh_inside_list.isEmpty()) {
            sb5.append(", ad_fresh_inside_list=");
            sb5.append(Internal.sanitize(this.ad_fresh_inside_list));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdFreshInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdFreshInfo(List<String> list, List<String> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_fresh_list = Internal.immutableCopyOf("ad_fresh_list", list);
        this.ad_fresh_inside_list = Internal.immutableCopyOf("ad_fresh_inside_list", list2);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383616a = Internal.copyOf(this.ad_fresh_list);
        aVar.f383617b = Internal.copyOf(this.ad_fresh_inside_list);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
