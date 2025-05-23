package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RewardAdReportInfo extends Message<RewardAdReportInfo, a> {
    public static final ProtoAdapter<RewardAdReportInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "reportTime", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final long report_time;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdReportType#ADAPTER", jsonName = AdMetricTag.Report.TYPE, label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final RewardAdReportType report_type;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdReportInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public long f383800a = 0;

        /* renamed from: b, reason: collision with root package name */
        public RewardAdReportType f383801b = RewardAdReportType.REWARD_AD_REPORT_TYPE_UNKNOWN;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdReportInfo build() {
            return new RewardAdReportInfo(this.f383800a, this.f383801b, super.buildUnknownFields());
        }

        public a b(long j3) {
            this.f383800a = j3;
            return this;
        }

        public a c(RewardAdReportType rewardAdReportType) {
            this.f383801b = rewardAdReportType;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdReportInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdReportInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdReportInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdReportInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            try {
                                aVar.c(RewardAdReportType.ADAPTER.decode(protoReader));
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                            }
                        }
                    } else {
                        aVar.b(ProtoAdapter.INT64.decode(protoReader).longValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RewardAdReportInfo rewardAdReportInfo) throws IOException {
            if (!Objects.equals(Long.valueOf(rewardAdReportInfo.report_time), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(rewardAdReportInfo.report_time));
            }
            if (!Objects.equals(rewardAdReportInfo.report_type, RewardAdReportType.REWARD_AD_REPORT_TYPE_UNKNOWN)) {
                RewardAdReportType.ADAPTER.encodeWithTag(protoWriter, 2, rewardAdReportInfo.report_type);
            }
            protoWriter.writeBytes(rewardAdReportInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdReportInfo rewardAdReportInfo) {
            int i3 = 0;
            if (!Objects.equals(Long.valueOf(rewardAdReportInfo.report_time), 0L)) {
                i3 = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(rewardAdReportInfo.report_time));
            }
            if (!Objects.equals(rewardAdReportInfo.report_type, RewardAdReportType.REWARD_AD_REPORT_TYPE_UNKNOWN)) {
                i3 += RewardAdReportType.ADAPTER.encodedSizeWithTag(2, rewardAdReportInfo.report_type);
            }
            return i3 + rewardAdReportInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdReportInfo redact(RewardAdReportInfo rewardAdReportInfo) {
            a newBuilder = rewardAdReportInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdReportInfo(long j3, RewardAdReportType rewardAdReportType) {
        this(j3, rewardAdReportType, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdReportInfo)) {
            return false;
        }
        RewardAdReportInfo rewardAdReportInfo = (RewardAdReportInfo) obj;
        if (unknownFields().equals(rewardAdReportInfo.unknownFields()) && Internal.equals(Long.valueOf(this.report_time), Long.valueOf(rewardAdReportInfo.report_time)) && Internal.equals(this.report_type, rewardAdReportInfo.report_type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + androidx.fragment.app.a.a(this.report_time)) * 37;
            RewardAdReportType rewardAdReportType = this.report_type;
            if (rewardAdReportType != null) {
                i3 = rewardAdReportType.hashCode();
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
        sb5.append(", report_time=");
        sb5.append(this.report_time);
        if (this.report_type != null) {
            sb5.append(", report_type=");
            sb5.append(this.report_type);
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdReportInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdReportInfo(long j3, RewardAdReportType rewardAdReportType, ByteString byteString) {
        super(ADAPTER, byteString);
        this.report_time = j3;
        if (rewardAdReportType != null) {
            this.report_type = rewardAdReportType;
            return;
        }
        throw new IllegalArgumentException("report_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383800a = this.report_time;
        aVar.f383801b = this.report_type;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
