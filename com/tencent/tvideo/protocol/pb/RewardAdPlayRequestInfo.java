package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes27.dex */
public final class RewardAdPlayRequestInfo extends Message<RewardAdPlayRequestInfo, a> {
    public static final ProtoAdapter<RewardAdPlayRequestInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdExtraInfo#ADAPTER", jsonName = "adExtraInfo", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdExtraInfo ad_extra_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String dataKey;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdReportInfo#ADAPTER", jsonName = CacheTable.TABLE_NAME, label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final RewardAdReportInfo report_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "requestTime", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String request_time;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdPlayRequestInfo, a> {

        /* renamed from: b, reason: collision with root package name */
        public RewardAdReportInfo f383786b;

        /* renamed from: c, reason: collision with root package name */
        public AdExtraInfo f383787c;

        /* renamed from: a, reason: collision with root package name */
        public String f383785a = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383788d = "";

        public a a(AdExtraInfo adExtraInfo) {
            this.f383787c = adExtraInfo;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RewardAdPlayRequestInfo build() {
            return new RewardAdPlayRequestInfo(this.f383785a, this.f383786b, this.f383787c, this.f383788d, super.buildUnknownFields());
        }

        public a c(String str) {
            this.f383785a = str;
            return this;
        }

        public a d(RewardAdReportInfo rewardAdReportInfo) {
            this.f383786b = rewardAdReportInfo;
            return this;
        }

        public a e(String str) {
            this.f383788d = str;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdPlayRequestInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdPlayRequestInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdPlayRequestInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdPlayRequestInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    protoReader.readUnknownField(nextTag);
                                } else {
                                    aVar.e(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.a(AdExtraInfo.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.d(RewardAdReportInfo.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, RewardAdPlayRequestInfo rewardAdPlayRequestInfo) throws IOException {
            if (!Objects.equals(rewardAdPlayRequestInfo.dataKey, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, rewardAdPlayRequestInfo.dataKey);
            }
            if (!Objects.equals(rewardAdPlayRequestInfo.report_info, null)) {
                RewardAdReportInfo.ADAPTER.encodeWithTag(protoWriter, 2, rewardAdPlayRequestInfo.report_info);
            }
            if (!Objects.equals(rewardAdPlayRequestInfo.ad_extra_info, null)) {
                AdExtraInfo.ADAPTER.encodeWithTag(protoWriter, 3, rewardAdPlayRequestInfo.ad_extra_info);
            }
            if (!Objects.equals(rewardAdPlayRequestInfo.request_time, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, rewardAdPlayRequestInfo.request_time);
            }
            protoWriter.writeBytes(rewardAdPlayRequestInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdPlayRequestInfo rewardAdPlayRequestInfo) {
            int i3 = 0;
            if (!Objects.equals(rewardAdPlayRequestInfo.dataKey, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, rewardAdPlayRequestInfo.dataKey);
            }
            if (!Objects.equals(rewardAdPlayRequestInfo.report_info, null)) {
                i3 += RewardAdReportInfo.ADAPTER.encodedSizeWithTag(2, rewardAdPlayRequestInfo.report_info);
            }
            if (!Objects.equals(rewardAdPlayRequestInfo.ad_extra_info, null)) {
                i3 += AdExtraInfo.ADAPTER.encodedSizeWithTag(3, rewardAdPlayRequestInfo.ad_extra_info);
            }
            if (!Objects.equals(rewardAdPlayRequestInfo.request_time, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, rewardAdPlayRequestInfo.request_time);
            }
            return i3 + rewardAdPlayRequestInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdPlayRequestInfo redact(RewardAdPlayRequestInfo rewardAdPlayRequestInfo) {
            a newBuilder = rewardAdPlayRequestInfo.newBuilder();
            RewardAdReportInfo rewardAdReportInfo = newBuilder.f383786b;
            if (rewardAdReportInfo != null) {
                newBuilder.f383786b = RewardAdReportInfo.ADAPTER.redact(rewardAdReportInfo);
            }
            AdExtraInfo adExtraInfo = newBuilder.f383787c;
            if (adExtraInfo != null) {
                newBuilder.f383787c = AdExtraInfo.ADAPTER.redact(adExtraInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdPlayRequestInfo(String str, RewardAdReportInfo rewardAdReportInfo, AdExtraInfo adExtraInfo, String str2) {
        this(str, rewardAdReportInfo, adExtraInfo, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdPlayRequestInfo)) {
            return false;
        }
        RewardAdPlayRequestInfo rewardAdPlayRequestInfo = (RewardAdPlayRequestInfo) obj;
        if (unknownFields().equals(rewardAdPlayRequestInfo.unknownFields()) && Internal.equals(this.dataKey, rewardAdPlayRequestInfo.dataKey) && Internal.equals(this.report_info, rewardAdPlayRequestInfo.report_info) && Internal.equals(this.ad_extra_info, rewardAdPlayRequestInfo.ad_extra_info) && Internal.equals(this.request_time, rewardAdPlayRequestInfo.request_time)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18 = this.hashCode;
        if (i18 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.dataKey;
            int i19 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            RewardAdReportInfo rewardAdReportInfo = this.report_info;
            if (rewardAdReportInfo != null) {
                i16 = rewardAdReportInfo.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 37;
            AdExtraInfo adExtraInfo = this.ad_extra_info;
            if (adExtraInfo != null) {
                i17 = adExtraInfo.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 37;
            String str2 = this.request_time;
            if (str2 != null) {
                i19 = str2.hashCode();
            }
            int i29 = i28 + i19;
            this.hashCode = i29;
            return i29;
        }
        return i18;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.dataKey != null) {
            sb5.append(", dataKey=");
            sb5.append(Internal.sanitize(this.dataKey));
        }
        if (this.report_info != null) {
            sb5.append(", report_info=");
            sb5.append(this.report_info);
        }
        if (this.ad_extra_info != null) {
            sb5.append(", ad_extra_info=");
            sb5.append(this.ad_extra_info);
        }
        if (this.request_time != null) {
            sb5.append(", request_time=");
            sb5.append(Internal.sanitize(this.request_time));
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdPlayRequestInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdPlayRequestInfo(String str, RewardAdReportInfo rewardAdReportInfo, AdExtraInfo adExtraInfo, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.dataKey = str;
            this.report_info = rewardAdReportInfo;
            this.ad_extra_info = adExtraInfo;
            if (str2 != null) {
                this.request_time = str2;
                return;
            }
            throw new IllegalArgumentException("request_time == null");
        }
        throw new IllegalArgumentException("dataKey == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383785a = this.dataKey;
        aVar.f383786b = this.report_info;
        aVar.f383787c = this.ad_extra_info;
        aVar.f383788d = this.request_time;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
