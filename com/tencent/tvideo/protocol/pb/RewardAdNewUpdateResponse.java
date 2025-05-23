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
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RewardAdNewUpdateResponse extends Message<RewardAdNewUpdateResponse, a> {
    public static final ProtoAdapter<RewardAdNewUpdateResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdResponseCommonInfo#ADAPTER", jsonName = "commonInfo", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final AdResponseCommonInfo common_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdRewardDefine$SecurityData.DATA_KEY, label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String data_key;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdErrorType#ADAPTER", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final RewardAdErrorType error_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "penetrateInfo", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String penetrate_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdReportInfo#ADAPTER", jsonName = "reportInfoList", label = WireField.Label.REPEATED, tag = 2)
    public final List<RewardAdReportInfo> report_info_list;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdInfo#ADAPTER", jsonName = "rewardInfoList", label = WireField.Label.REPEATED, tag = 1)
    public final List<RewardAdInfo> reward_info_list;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo#ADAPTER", jsonName = "unlockedInfo", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final RewardAdNewUnlockInfo unlocked_info;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdNewUpdateResponse, a> {

        /* renamed from: c, reason: collision with root package name */
        public RewardAdNewUnlockInfo f383780c;

        /* renamed from: g, reason: collision with root package name */
        public AdResponseCommonInfo f383784g;

        /* renamed from: a, reason: collision with root package name */
        public List<RewardAdInfo> f383778a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public List<RewardAdReportInfo> f383779b = Internal.newMutableList();

        /* renamed from: d, reason: collision with root package name */
        public String f383781d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f383782e = "";

        /* renamed from: f, reason: collision with root package name */
        public RewardAdErrorType f383783f = RewardAdErrorType.REWARD_AD_ERROR_TYPE_UNKNOWN;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUpdateResponse build() {
            return new RewardAdNewUpdateResponse(this.f383778a, this.f383779b, this.f383780c, this.f383781d, this.f383782e, this.f383783f, this.f383784g, super.buildUnknownFields());
        }

        public a b(AdResponseCommonInfo adResponseCommonInfo) {
            this.f383784g = adResponseCommonInfo;
            return this;
        }

        public a c(String str) {
            this.f383781d = str;
            return this;
        }

        public a d(RewardAdErrorType rewardAdErrorType) {
            this.f383783f = rewardAdErrorType;
            return this;
        }

        public a e(String str) {
            this.f383782e = str;
            return this;
        }

        public a f(RewardAdNewUnlockInfo rewardAdNewUnlockInfo) {
            this.f383780c = rewardAdNewUnlockInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdNewUpdateResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdNewUpdateResponse.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdNewUpdateResponse", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUpdateResponse decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.f383778a.add(RewardAdInfo.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            aVar.f383779b.add(RewardAdReportInfo.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            aVar.f(RewardAdNewUnlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            try {
                                aVar.d(RewardAdErrorType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 7:
                            aVar.b(AdResponseCommonInfo.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, RewardAdNewUpdateResponse rewardAdNewUpdateResponse) throws IOException {
            RewardAdInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, rewardAdNewUpdateResponse.reward_info_list);
            RewardAdReportInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, rewardAdNewUpdateResponse.report_info_list);
            if (!Objects.equals(rewardAdNewUpdateResponse.unlocked_info, null)) {
                RewardAdNewUnlockInfo.ADAPTER.encodeWithTag(protoWriter, 3, rewardAdNewUpdateResponse.unlocked_info);
            }
            if (!Objects.equals(rewardAdNewUpdateResponse.data_key, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, rewardAdNewUpdateResponse.data_key);
            }
            if (!Objects.equals(rewardAdNewUpdateResponse.penetrate_info, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, rewardAdNewUpdateResponse.penetrate_info);
            }
            if (!Objects.equals(rewardAdNewUpdateResponse.error_type, RewardAdErrorType.REWARD_AD_ERROR_TYPE_UNKNOWN)) {
                RewardAdErrorType.ADAPTER.encodeWithTag(protoWriter, 6, rewardAdNewUpdateResponse.error_type);
            }
            if (!Objects.equals(rewardAdNewUpdateResponse.common_info, null)) {
                AdResponseCommonInfo.ADAPTER.encodeWithTag(protoWriter, 7, rewardAdNewUpdateResponse.common_info);
            }
            protoWriter.writeBytes(rewardAdNewUpdateResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdNewUpdateResponse rewardAdNewUpdateResponse) {
            int encodedSizeWithTag = RewardAdInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, rewardAdNewUpdateResponse.reward_info_list) + 0 + RewardAdReportInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, rewardAdNewUpdateResponse.report_info_list);
            if (!Objects.equals(rewardAdNewUpdateResponse.unlocked_info, null)) {
                encodedSizeWithTag += RewardAdNewUnlockInfo.ADAPTER.encodedSizeWithTag(3, rewardAdNewUpdateResponse.unlocked_info);
            }
            if (!Objects.equals(rewardAdNewUpdateResponse.data_key, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(4, rewardAdNewUpdateResponse.data_key);
            }
            if (!Objects.equals(rewardAdNewUpdateResponse.penetrate_info, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(5, rewardAdNewUpdateResponse.penetrate_info);
            }
            if (!Objects.equals(rewardAdNewUpdateResponse.error_type, RewardAdErrorType.REWARD_AD_ERROR_TYPE_UNKNOWN)) {
                encodedSizeWithTag += RewardAdErrorType.ADAPTER.encodedSizeWithTag(6, rewardAdNewUpdateResponse.error_type);
            }
            if (!Objects.equals(rewardAdNewUpdateResponse.common_info, null)) {
                encodedSizeWithTag += AdResponseCommonInfo.ADAPTER.encodedSizeWithTag(7, rewardAdNewUpdateResponse.common_info);
            }
            return encodedSizeWithTag + rewardAdNewUpdateResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUpdateResponse redact(RewardAdNewUpdateResponse rewardAdNewUpdateResponse) {
            a newBuilder = rewardAdNewUpdateResponse.newBuilder();
            Internal.redactElements(newBuilder.f383778a, RewardAdInfo.ADAPTER);
            Internal.redactElements(newBuilder.f383779b, RewardAdReportInfo.ADAPTER);
            RewardAdNewUnlockInfo rewardAdNewUnlockInfo = newBuilder.f383780c;
            if (rewardAdNewUnlockInfo != null) {
                newBuilder.f383780c = RewardAdNewUnlockInfo.ADAPTER.redact(rewardAdNewUnlockInfo);
            }
            AdResponseCommonInfo adResponseCommonInfo = newBuilder.f383784g;
            if (adResponseCommonInfo != null) {
                newBuilder.f383784g = AdResponseCommonInfo.ADAPTER.redact(adResponseCommonInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdNewUpdateResponse(List<RewardAdInfo> list, List<RewardAdReportInfo> list2, RewardAdNewUnlockInfo rewardAdNewUnlockInfo, String str, String str2, RewardAdErrorType rewardAdErrorType, AdResponseCommonInfo adResponseCommonInfo) {
        this(list, list2, rewardAdNewUnlockInfo, str, str2, rewardAdErrorType, adResponseCommonInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdNewUpdateResponse)) {
            return false;
        }
        RewardAdNewUpdateResponse rewardAdNewUpdateResponse = (RewardAdNewUpdateResponse) obj;
        if (unknownFields().equals(rewardAdNewUpdateResponse.unknownFields()) && this.reward_info_list.equals(rewardAdNewUpdateResponse.reward_info_list) && this.report_info_list.equals(rewardAdNewUpdateResponse.report_info_list) && Internal.equals(this.unlocked_info, rewardAdNewUpdateResponse.unlocked_info) && Internal.equals(this.data_key, rewardAdNewUpdateResponse.data_key) && Internal.equals(this.penetrate_info, rewardAdNewUpdateResponse.penetrate_info) && Internal.equals(this.error_type, rewardAdNewUpdateResponse.error_type) && Internal.equals(this.common_info, rewardAdNewUpdateResponse.common_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.reward_info_list.hashCode()) * 37) + this.report_info_list.hashCode()) * 37;
            RewardAdNewUnlockInfo rewardAdNewUnlockInfo = this.unlocked_info;
            int i26 = 0;
            if (rewardAdNewUnlockInfo != null) {
                i3 = rewardAdNewUnlockInfo.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            String str = this.data_key;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            String str2 = this.penetrate_info;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            RewardAdErrorType rewardAdErrorType = this.error_type;
            if (rewardAdErrorType != null) {
                i18 = rewardAdErrorType.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            AdResponseCommonInfo adResponseCommonInfo = this.common_info;
            if (adResponseCommonInfo != null) {
                i26 = adResponseCommonInfo.hashCode();
            }
            int i37 = i36 + i26;
            this.hashCode = i37;
            return i37;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.reward_info_list.isEmpty()) {
            sb5.append(", reward_info_list=");
            sb5.append(this.reward_info_list);
        }
        if (!this.report_info_list.isEmpty()) {
            sb5.append(", report_info_list=");
            sb5.append(this.report_info_list);
        }
        if (this.unlocked_info != null) {
            sb5.append(", unlocked_info=");
            sb5.append(this.unlocked_info);
        }
        if (this.data_key != null) {
            sb5.append(", data_key=");
            sb5.append(Internal.sanitize(this.data_key));
        }
        if (this.penetrate_info != null) {
            sb5.append(", penetrate_info=");
            sb5.append(Internal.sanitize(this.penetrate_info));
        }
        if (this.error_type != null) {
            sb5.append(", error_type=");
            sb5.append(this.error_type);
        }
        if (this.common_info != null) {
            sb5.append(", common_info=");
            sb5.append(this.common_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdNewUpdateResponse{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdNewUpdateResponse(List<RewardAdInfo> list, List<RewardAdReportInfo> list2, RewardAdNewUnlockInfo rewardAdNewUnlockInfo, String str, String str2, RewardAdErrorType rewardAdErrorType, AdResponseCommonInfo adResponseCommonInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        this.reward_info_list = Internal.immutableCopyOf("reward_info_list", list);
        this.report_info_list = Internal.immutableCopyOf("report_info_list", list2);
        this.unlocked_info = rewardAdNewUnlockInfo;
        if (str != null) {
            this.data_key = str;
            if (str2 != null) {
                this.penetrate_info = str2;
                if (rewardAdErrorType != null) {
                    this.error_type = rewardAdErrorType;
                    this.common_info = adResponseCommonInfo;
                    return;
                }
                throw new IllegalArgumentException("error_type == null");
            }
            throw new IllegalArgumentException("penetrate_info == null");
        }
        throw new IllegalArgumentException("data_key == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383778a = Internal.copyOf(this.reward_info_list);
        aVar.f383779b = Internal.copyOf(this.report_info_list);
        aVar.f383780c = this.unlocked_info;
        aVar.f383781d = this.data_key;
        aVar.f383782e = this.penetrate_info;
        aVar.f383783f = this.error_type;
        aVar.f383784g = this.common_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
