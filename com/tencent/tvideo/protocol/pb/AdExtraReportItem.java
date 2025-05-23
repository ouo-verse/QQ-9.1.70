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
public final class AdExtraReportItem extends Message<AdExtraReportItem, a> {
    public static final ProtoAdapter<AdExtraReportItem> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final boolean inserted;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "needFunnelReport", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final boolean need_funnel_report;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "needOperationReport", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final boolean need_operation_report;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "needRetryReport", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final boolean need_retry_report;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "needWisdomReport", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final boolean need_wisdom_report;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdExtraReportItem, a> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f383563a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f383564b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f383565c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f383566d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f383567e = false;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdExtraReportItem build() {
            return new AdExtraReportItem(this.f383563a, this.f383564b, this.f383565c, this.f383566d, this.f383567e, super.buildUnknownFields());
        }

        public a b(boolean z16) {
            this.f383567e = z16;
            return this;
        }

        public a c(boolean z16) {
            this.f383566d = z16;
            return this;
        }

        public a d(boolean z16) {
            this.f383563a = z16;
            return this;
        }

        public a e(boolean z16) {
            this.f383565c = z16;
            return this;
        }

        public a f(boolean z16) {
            this.f383564b = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdExtraReportItem> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdExtraReportItem.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdExtraReportItem", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdExtraReportItem decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    if (nextTag != 5) {
                                        protoReader.readUnknownField(nextTag);
                                    } else {
                                        aVar.b(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                    }
                                } else {
                                    aVar.c(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                }
                            } else {
                                aVar.e(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            }
                        } else {
                            aVar.f(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                        }
                    } else {
                        aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdExtraReportItem adExtraReportItem) throws IOException {
            Boolean valueOf = Boolean.valueOf(adExtraReportItem.need_operation_report);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, Boolean.valueOf(adExtraReportItem.need_operation_report));
            }
            if (!Objects.equals(Boolean.valueOf(adExtraReportItem.need_wisdom_report), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, Boolean.valueOf(adExtraReportItem.need_wisdom_report));
            }
            if (!Objects.equals(Boolean.valueOf(adExtraReportItem.need_retry_report), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, Boolean.valueOf(adExtraReportItem.need_retry_report));
            }
            if (!Objects.equals(Boolean.valueOf(adExtraReportItem.need_funnel_report), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, Boolean.valueOf(adExtraReportItem.need_funnel_report));
            }
            if (!Objects.equals(Boolean.valueOf(adExtraReportItem.inserted), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 5, Boolean.valueOf(adExtraReportItem.inserted));
            }
            protoWriter.writeBytes(adExtraReportItem.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdExtraReportItem adExtraReportItem) {
            Boolean valueOf = Boolean.valueOf(adExtraReportItem.need_operation_report);
            Boolean bool = Boolean.FALSE;
            int i3 = 0;
            if (!Objects.equals(valueOf, bool)) {
                i3 = 0 + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(adExtraReportItem.need_operation_report));
            }
            if (!Objects.equals(Boolean.valueOf(adExtraReportItem.need_wisdom_report), bool)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(2, Boolean.valueOf(adExtraReportItem.need_wisdom_report));
            }
            if (!Objects.equals(Boolean.valueOf(adExtraReportItem.need_retry_report), bool)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(adExtraReportItem.need_retry_report));
            }
            if (!Objects.equals(Boolean.valueOf(adExtraReportItem.need_funnel_report), bool)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(4, Boolean.valueOf(adExtraReportItem.need_funnel_report));
            }
            if (!Objects.equals(Boolean.valueOf(adExtraReportItem.inserted), bool)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(5, Boolean.valueOf(adExtraReportItem.inserted));
            }
            return i3 + adExtraReportItem.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdExtraReportItem redact(AdExtraReportItem adExtraReportItem) {
            a newBuilder = adExtraReportItem.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdExtraReportItem(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        this(z16, z17, z18, z19, z26, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdExtraReportItem)) {
            return false;
        }
        AdExtraReportItem adExtraReportItem = (AdExtraReportItem) obj;
        if (unknownFields().equals(adExtraReportItem.unknownFields()) && Internal.equals(Boolean.valueOf(this.need_operation_report), Boolean.valueOf(adExtraReportItem.need_operation_report)) && Internal.equals(Boolean.valueOf(this.need_wisdom_report), Boolean.valueOf(adExtraReportItem.need_wisdom_report)) && Internal.equals(Boolean.valueOf(this.need_retry_report), Boolean.valueOf(adExtraReportItem.need_retry_report)) && Internal.equals(Boolean.valueOf(this.need_funnel_report), Boolean.valueOf(adExtraReportItem.need_funnel_report)) && Internal.equals(Boolean.valueOf(this.inserted), Boolean.valueOf(adExtraReportItem.inserted))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((((unknownFields().hashCode() * 37) + com.tencent.aio.widget.textView.param.a.a(this.need_operation_report)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.need_wisdom_report)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.need_retry_report)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.need_funnel_report)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.inserted);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", need_operation_report=");
        sb5.append(this.need_operation_report);
        sb5.append(", need_wisdom_report=");
        sb5.append(this.need_wisdom_report);
        sb5.append(", need_retry_report=");
        sb5.append(this.need_retry_report);
        sb5.append(", need_funnel_report=");
        sb5.append(this.need_funnel_report);
        sb5.append(", inserted=");
        sb5.append(this.inserted);
        StringBuilder replace = sb5.replace(0, 2, "AdExtraReportItem{");
        replace.append('}');
        return replace.toString();
    }

    public AdExtraReportItem(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, ByteString byteString) {
        super(ADAPTER, byteString);
        this.need_operation_report = z16;
        this.need_wisdom_report = z17;
        this.need_retry_report = z18;
        this.need_funnel_report = z19;
        this.inserted = z26;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383563a = this.need_operation_report;
        aVar.f383564b = this.need_wisdom_report;
        aVar.f383565c = this.need_retry_report;
        aVar.f383566d = this.need_funnel_report;
        aVar.f383567e = this.inserted;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
