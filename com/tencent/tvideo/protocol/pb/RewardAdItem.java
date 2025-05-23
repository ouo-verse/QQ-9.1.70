package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RewardAdItem extends Message<RewardAdItem, a> {
    public static final ProtoAdapter<RewardAdItem> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String dataKey;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.DynamicInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final DynamicInfo dynamicInfo;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdErrorType#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final RewardAdErrorType errorType;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdPoster#ADAPTER", jsonName = "rewardPoster", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RewardAdPoster reward_poster;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "unlockDuration", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final long unlock_duration;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdUnlockInfo#ADAPTER", jsonName = QAdRewardDefine$VideoParams.UNLOCK_INFO, label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final RewardAdUnlockInfo unlock_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdInsideVideoInfo#ADAPTER", jsonName = QCircleScheme.AttrDetail.VIDEO_INFO, label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AdInsideVideoInfo video_info;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdItem, a> {

        /* renamed from: a, reason: collision with root package name */
        public RewardAdPoster f383758a;

        /* renamed from: b, reason: collision with root package name */
        public AdInsideVideoInfo f383759b;

        /* renamed from: d, reason: collision with root package name */
        public RewardAdUnlockInfo f383761d;

        /* renamed from: g, reason: collision with root package name */
        public DynamicInfo f383764g;

        /* renamed from: c, reason: collision with root package name */
        public long f383760c = 0;

        /* renamed from: e, reason: collision with root package name */
        public RewardAdErrorType f383762e = RewardAdErrorType.REWARD_AD_ERROR_TYPE_UNKNOWN;

        /* renamed from: f, reason: collision with root package name */
        public String f383763f = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdItem build() {
            return new RewardAdItem(this.f383758a, this.f383759b, this.f383760c, this.f383761d, this.f383762e, this.f383763f, this.f383764g, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383763f = str;
            return this;
        }

        public a c(DynamicInfo dynamicInfo) {
            this.f383764g = dynamicInfo;
            return this;
        }

        public a d(RewardAdErrorType rewardAdErrorType) {
            this.f383762e = rewardAdErrorType;
            return this;
        }

        public a e(RewardAdPoster rewardAdPoster) {
            this.f383758a = rewardAdPoster;
            return this;
        }

        public a f(long j3) {
            this.f383760c = j3;
            return this;
        }

        public a g(RewardAdUnlockInfo rewardAdUnlockInfo) {
            this.f383761d = rewardAdUnlockInfo;
            return this;
        }

        public a h(AdInsideVideoInfo adInsideVideoInfo) {
            this.f383759b = adInsideVideoInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdItem> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdItem.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdItem", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdItem decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.e(RewardAdPoster.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            aVar.h(AdInsideVideoInfo.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            aVar.f(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 4:
                            aVar.g(RewardAdUnlockInfo.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            try {
                                aVar.d(RewardAdErrorType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 6:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.c(DynamicInfo.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, RewardAdItem rewardAdItem) throws IOException {
            if (!Objects.equals(rewardAdItem.reward_poster, null)) {
                RewardAdPoster.ADAPTER.encodeWithTag(protoWriter, 1, rewardAdItem.reward_poster);
            }
            if (!Objects.equals(rewardAdItem.video_info, null)) {
                AdInsideVideoInfo.ADAPTER.encodeWithTag(protoWriter, 2, rewardAdItem.video_info);
            }
            if (!Objects.equals(Long.valueOf(rewardAdItem.unlock_duration), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, Long.valueOf(rewardAdItem.unlock_duration));
            }
            if (!Objects.equals(rewardAdItem.unlock_info, null)) {
                RewardAdUnlockInfo.ADAPTER.encodeWithTag(protoWriter, 4, rewardAdItem.unlock_info);
            }
            if (!Objects.equals(rewardAdItem.errorType, RewardAdErrorType.REWARD_AD_ERROR_TYPE_UNKNOWN)) {
                RewardAdErrorType.ADAPTER.encodeWithTag(protoWriter, 5, rewardAdItem.errorType);
            }
            if (!Objects.equals(rewardAdItem.dataKey, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, rewardAdItem.dataKey);
            }
            if (!Objects.equals(rewardAdItem.dynamicInfo, null)) {
                DynamicInfo.ADAPTER.encodeWithTag(protoWriter, 7, rewardAdItem.dynamicInfo);
            }
            protoWriter.writeBytes(rewardAdItem.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdItem rewardAdItem) {
            int i3 = 0;
            if (!Objects.equals(rewardAdItem.reward_poster, null)) {
                i3 = 0 + RewardAdPoster.ADAPTER.encodedSizeWithTag(1, rewardAdItem.reward_poster);
            }
            if (!Objects.equals(rewardAdItem.video_info, null)) {
                i3 += AdInsideVideoInfo.ADAPTER.encodedSizeWithTag(2, rewardAdItem.video_info);
            }
            if (!Objects.equals(Long.valueOf(rewardAdItem.unlock_duration), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(rewardAdItem.unlock_duration));
            }
            if (!Objects.equals(rewardAdItem.unlock_info, null)) {
                i3 += RewardAdUnlockInfo.ADAPTER.encodedSizeWithTag(4, rewardAdItem.unlock_info);
            }
            if (!Objects.equals(rewardAdItem.errorType, RewardAdErrorType.REWARD_AD_ERROR_TYPE_UNKNOWN)) {
                i3 += RewardAdErrorType.ADAPTER.encodedSizeWithTag(5, rewardAdItem.errorType);
            }
            if (!Objects.equals(rewardAdItem.dataKey, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, rewardAdItem.dataKey);
            }
            if (!Objects.equals(rewardAdItem.dynamicInfo, null)) {
                i3 += DynamicInfo.ADAPTER.encodedSizeWithTag(7, rewardAdItem.dynamicInfo);
            }
            return i3 + rewardAdItem.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdItem redact(RewardAdItem rewardAdItem) {
            a newBuilder = rewardAdItem.newBuilder();
            RewardAdPoster rewardAdPoster = newBuilder.f383758a;
            if (rewardAdPoster != null) {
                newBuilder.f383758a = RewardAdPoster.ADAPTER.redact(rewardAdPoster);
            }
            AdInsideVideoInfo adInsideVideoInfo = newBuilder.f383759b;
            if (adInsideVideoInfo != null) {
                newBuilder.f383759b = AdInsideVideoInfo.ADAPTER.redact(adInsideVideoInfo);
            }
            RewardAdUnlockInfo rewardAdUnlockInfo = newBuilder.f383761d;
            if (rewardAdUnlockInfo != null) {
                newBuilder.f383761d = RewardAdUnlockInfo.ADAPTER.redact(rewardAdUnlockInfo);
            }
            DynamicInfo dynamicInfo = newBuilder.f383764g;
            if (dynamicInfo != null) {
                newBuilder.f383764g = DynamicInfo.ADAPTER.redact(dynamicInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdItem(RewardAdPoster rewardAdPoster, AdInsideVideoInfo adInsideVideoInfo, long j3, RewardAdUnlockInfo rewardAdUnlockInfo, RewardAdErrorType rewardAdErrorType, String str, DynamicInfo dynamicInfo) {
        this(rewardAdPoster, adInsideVideoInfo, j3, rewardAdUnlockInfo, rewardAdErrorType, str, dynamicInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdItem)) {
            return false;
        }
        RewardAdItem rewardAdItem = (RewardAdItem) obj;
        if (unknownFields().equals(rewardAdItem.unknownFields()) && Internal.equals(this.reward_poster, rewardAdItem.reward_poster) && Internal.equals(this.video_info, rewardAdItem.video_info) && Internal.equals(Long.valueOf(this.unlock_duration), Long.valueOf(rewardAdItem.unlock_duration)) && Internal.equals(this.unlock_info, rewardAdItem.unlock_info) && Internal.equals(this.errorType, rewardAdItem.errorType) && Internal.equals(this.dataKey, rewardAdItem.dataKey) && Internal.equals(this.dynamicInfo, rewardAdItem.dynamicInfo)) {
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
            RewardAdPoster rewardAdPoster = this.reward_poster;
            int i27 = 0;
            if (rewardAdPoster != null) {
                i3 = rewardAdPoster.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            AdInsideVideoInfo adInsideVideoInfo = this.video_info;
            if (adInsideVideoInfo != null) {
                i16 = adInsideVideoInfo.hashCode();
            } else {
                i16 = 0;
            }
            int a16 = (((i28 + i16) * 37) + androidx.fragment.app.a.a(this.unlock_duration)) * 37;
            RewardAdUnlockInfo rewardAdUnlockInfo = this.unlock_info;
            if (rewardAdUnlockInfo != null) {
                i17 = rewardAdUnlockInfo.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (a16 + i17) * 37;
            RewardAdErrorType rewardAdErrorType = this.errorType;
            if (rewardAdErrorType != null) {
                i18 = rewardAdErrorType.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str = this.dataKey;
            if (str != null) {
                i19 = str.hashCode();
            } else {
                i19 = 0;
            }
            int i37 = (i36 + i19) * 37;
            DynamicInfo dynamicInfo = this.dynamicInfo;
            if (dynamicInfo != null) {
                i27 = dynamicInfo.hashCode();
            }
            int i38 = i37 + i27;
            this.hashCode = i38;
            return i38;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.reward_poster != null) {
            sb5.append(", reward_poster=");
            sb5.append(this.reward_poster);
        }
        if (this.video_info != null) {
            sb5.append(", video_info=");
            sb5.append(this.video_info);
        }
        sb5.append(", unlock_duration=");
        sb5.append(this.unlock_duration);
        if (this.unlock_info != null) {
            sb5.append(", unlock_info=");
            sb5.append(this.unlock_info);
        }
        if (this.errorType != null) {
            sb5.append(", errorType=");
            sb5.append(this.errorType);
        }
        if (this.dataKey != null) {
            sb5.append(", dataKey=");
            sb5.append(Internal.sanitize(this.dataKey));
        }
        if (this.dynamicInfo != null) {
            sb5.append(", dynamicInfo=");
            sb5.append(this.dynamicInfo);
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdItem{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdItem(RewardAdPoster rewardAdPoster, AdInsideVideoInfo adInsideVideoInfo, long j3, RewardAdUnlockInfo rewardAdUnlockInfo, RewardAdErrorType rewardAdErrorType, String str, DynamicInfo dynamicInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        this.reward_poster = rewardAdPoster;
        this.video_info = adInsideVideoInfo;
        this.unlock_duration = j3;
        this.unlock_info = rewardAdUnlockInfo;
        if (rewardAdErrorType != null) {
            this.errorType = rewardAdErrorType;
            if (str != null) {
                this.dataKey = str;
                this.dynamicInfo = dynamicInfo;
                return;
            }
            throw new IllegalArgumentException("dataKey == null");
        }
        throw new IllegalArgumentException("errorType == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383758a = this.reward_poster;
        aVar.f383759b = this.video_info;
        aVar.f383760c = this.unlock_duration;
        aVar.f383761d = this.unlock_info;
        aVar.f383762e = this.errorType;
        aVar.f383763f = this.dataKey;
        aVar.f383764g = this.dynamicInfo;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
