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
public final class RewardAdPoster extends Message<RewardAdPoster, a> {
    public static final ProtoAdapter<RewardAdPoster> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "closeAdTips", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String close_ad_tips;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "countdownTips", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String countdown_tips;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdPlayFinishMaskInfo#ADAPTER", jsonName = "finishMaskInfo", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final AdPlayFinishMaskInfo finish_mask_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isPortrait", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final boolean is_portrait;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String posterUrl;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "unlockTips", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String unlock_tips;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdPoster, a> {

        /* renamed from: e, reason: collision with root package name */
        public AdPlayFinishMaskInfo f383795e;

        /* renamed from: a, reason: collision with root package name */
        public String f383791a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383792b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383793c = "";

        /* renamed from: d, reason: collision with root package name */
        public boolean f383794d = false;

        /* renamed from: f, reason: collision with root package name */
        public String f383796f = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdPoster build() {
            return new RewardAdPoster(this.f383791a, this.f383792b, this.f383793c, this.f383794d, this.f383795e, this.f383796f, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383791a = str;
            return this;
        }

        public a c(String str) {
            this.f383792b = str;
            return this;
        }

        public a d(AdPlayFinishMaskInfo adPlayFinishMaskInfo) {
            this.f383795e = adPlayFinishMaskInfo;
            return this;
        }

        public a e(boolean z16) {
            this.f383794d = z16;
            return this;
        }

        public a f(String str) {
            this.f383796f = str;
            return this;
        }

        public a g(String str) {
            this.f383793c = str;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdPoster> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdPoster.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdPoster", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdPoster decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.e(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            break;
                        case 5:
                            aVar.d(AdPlayFinishMaskInfo.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, RewardAdPoster rewardAdPoster) throws IOException {
            if (!Objects.equals(rewardAdPoster.close_ad_tips, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, rewardAdPoster.close_ad_tips);
            }
            if (!Objects.equals(rewardAdPoster.countdown_tips, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, rewardAdPoster.countdown_tips);
            }
            if (!Objects.equals(rewardAdPoster.unlock_tips, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, rewardAdPoster.unlock_tips);
            }
            if (!Objects.equals(Boolean.valueOf(rewardAdPoster.is_portrait), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, Boolean.valueOf(rewardAdPoster.is_portrait));
            }
            if (!Objects.equals(rewardAdPoster.finish_mask_info, null)) {
                AdPlayFinishMaskInfo.ADAPTER.encodeWithTag(protoWriter, 5, rewardAdPoster.finish_mask_info);
            }
            if (!Objects.equals(rewardAdPoster.posterUrl, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, rewardAdPoster.posterUrl);
            }
            protoWriter.writeBytes(rewardAdPoster.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdPoster rewardAdPoster) {
            int i3 = 0;
            if (!Objects.equals(rewardAdPoster.close_ad_tips, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, rewardAdPoster.close_ad_tips);
            }
            if (!Objects.equals(rewardAdPoster.countdown_tips, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, rewardAdPoster.countdown_tips);
            }
            if (!Objects.equals(rewardAdPoster.unlock_tips, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, rewardAdPoster.unlock_tips);
            }
            if (!Objects.equals(Boolean.valueOf(rewardAdPoster.is_portrait), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(4, Boolean.valueOf(rewardAdPoster.is_portrait));
            }
            if (!Objects.equals(rewardAdPoster.finish_mask_info, null)) {
                i3 += AdPlayFinishMaskInfo.ADAPTER.encodedSizeWithTag(5, rewardAdPoster.finish_mask_info);
            }
            if (!Objects.equals(rewardAdPoster.posterUrl, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, rewardAdPoster.posterUrl);
            }
            return i3 + rewardAdPoster.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdPoster redact(RewardAdPoster rewardAdPoster) {
            a newBuilder = rewardAdPoster.newBuilder();
            AdPlayFinishMaskInfo adPlayFinishMaskInfo = newBuilder.f383795e;
            if (adPlayFinishMaskInfo != null) {
                newBuilder.f383795e = AdPlayFinishMaskInfo.ADAPTER.redact(adPlayFinishMaskInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdPoster(String str, String str2, String str3, boolean z16, AdPlayFinishMaskInfo adPlayFinishMaskInfo, String str4) {
        this(str, str2, str3, z16, adPlayFinishMaskInfo, str4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdPoster)) {
            return false;
        }
        RewardAdPoster rewardAdPoster = (RewardAdPoster) obj;
        if (unknownFields().equals(rewardAdPoster.unknownFields()) && Internal.equals(this.close_ad_tips, rewardAdPoster.close_ad_tips) && Internal.equals(this.countdown_tips, rewardAdPoster.countdown_tips) && Internal.equals(this.unlock_tips, rewardAdPoster.unlock_tips) && Internal.equals(Boolean.valueOf(this.is_portrait), Boolean.valueOf(rewardAdPoster.is_portrait)) && Internal.equals(this.finish_mask_info, rewardAdPoster.finish_mask_info) && Internal.equals(this.posterUrl, rewardAdPoster.posterUrl)) {
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
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.close_ad_tips;
            int i26 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            String str2 = this.countdown_tips;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            String str3 = this.unlock_tips;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int a16 = (((i28 + i17) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_portrait)) * 37;
            AdPlayFinishMaskInfo adPlayFinishMaskInfo = this.finish_mask_info;
            if (adPlayFinishMaskInfo != null) {
                i18 = adPlayFinishMaskInfo.hashCode();
            } else {
                i18 = 0;
            }
            int i29 = (a16 + i18) * 37;
            String str4 = this.posterUrl;
            if (str4 != null) {
                i26 = str4.hashCode();
            }
            int i36 = i29 + i26;
            this.hashCode = i36;
            return i36;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.close_ad_tips != null) {
            sb5.append(", close_ad_tips=");
            sb5.append(Internal.sanitize(this.close_ad_tips));
        }
        if (this.countdown_tips != null) {
            sb5.append(", countdown_tips=");
            sb5.append(Internal.sanitize(this.countdown_tips));
        }
        if (this.unlock_tips != null) {
            sb5.append(", unlock_tips=");
            sb5.append(Internal.sanitize(this.unlock_tips));
        }
        sb5.append(", is_portrait=");
        sb5.append(this.is_portrait);
        if (this.finish_mask_info != null) {
            sb5.append(", finish_mask_info=");
            sb5.append(this.finish_mask_info);
        }
        if (this.posterUrl != null) {
            sb5.append(", posterUrl=");
            sb5.append(Internal.sanitize(this.posterUrl));
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdPoster{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdPoster(String str, String str2, String str3, boolean z16, AdPlayFinishMaskInfo adPlayFinishMaskInfo, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.close_ad_tips = str;
            if (str2 != null) {
                this.countdown_tips = str2;
                if (str3 != null) {
                    this.unlock_tips = str3;
                    this.is_portrait = z16;
                    this.finish_mask_info = adPlayFinishMaskInfo;
                    if (str4 != null) {
                        this.posterUrl = str4;
                        return;
                    }
                    throw new IllegalArgumentException("posterUrl == null");
                }
                throw new IllegalArgumentException("unlock_tips == null");
            }
            throw new IllegalArgumentException("countdown_tips == null");
        }
        throw new IllegalArgumentException("close_ad_tips == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383791a = this.close_ad_tips;
        aVar.f383792b = this.countdown_tips;
        aVar.f383793c = this.unlock_tips;
        aVar.f383794d = this.is_portrait;
        aVar.f383795e = this.finish_mask_info;
        aVar.f383796f = this.posterUrl;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
