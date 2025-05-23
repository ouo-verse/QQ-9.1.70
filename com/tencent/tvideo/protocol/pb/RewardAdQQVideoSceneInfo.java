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
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RewardAdQQVideoSceneInfo extends Message<RewardAdQQVideoSceneInfo, a> {
    public static final ProtoAdapter<RewardAdQQVideoSceneInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "adNum", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int ad_num;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "adPostIndex", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int ad_post_index;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.ADVideoInfo#ADAPTER", jsonName = QCircleScheme.AttrDetail.VIDEO_INFO, label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final ADVideoInfo video_info;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdQQVideoSceneInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public ADVideoInfo f383797a;

        /* renamed from: b, reason: collision with root package name */
        public int f383798b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f383799c = 0;

        public a a(int i3) {
            this.f383798b = i3;
            return this;
        }

        public a b(int i3) {
            this.f383799c = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public RewardAdQQVideoSceneInfo build() {
            return new RewardAdQQVideoSceneInfo(this.f383797a, this.f383798b, this.f383799c, super.buildUnknownFields());
        }

        public a d(ADVideoInfo aDVideoInfo) {
            this.f383797a = aDVideoInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdQQVideoSceneInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdQQVideoSceneInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdQQVideoSceneInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdQQVideoSceneInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.a(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.d(ADVideoInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RewardAdQQVideoSceneInfo rewardAdQQVideoSceneInfo) throws IOException {
            if (!Objects.equals(rewardAdQQVideoSceneInfo.video_info, null)) {
                ADVideoInfo.ADAPTER.encodeWithTag(protoWriter, 1, rewardAdQQVideoSceneInfo.video_info);
            }
            if (!Objects.equals(Integer.valueOf(rewardAdQQVideoSceneInfo.ad_num), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(rewardAdQQVideoSceneInfo.ad_num));
            }
            if (!Objects.equals(Integer.valueOf(rewardAdQQVideoSceneInfo.ad_post_index), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(rewardAdQQVideoSceneInfo.ad_post_index));
            }
            protoWriter.writeBytes(rewardAdQQVideoSceneInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdQQVideoSceneInfo rewardAdQQVideoSceneInfo) {
            int i3 = 0;
            if (!Objects.equals(rewardAdQQVideoSceneInfo.video_info, null)) {
                i3 = 0 + ADVideoInfo.ADAPTER.encodedSizeWithTag(1, rewardAdQQVideoSceneInfo.video_info);
            }
            if (!Objects.equals(Integer.valueOf(rewardAdQQVideoSceneInfo.ad_num), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(rewardAdQQVideoSceneInfo.ad_num));
            }
            if (!Objects.equals(Integer.valueOf(rewardAdQQVideoSceneInfo.ad_post_index), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(rewardAdQQVideoSceneInfo.ad_post_index));
            }
            return i3 + rewardAdQQVideoSceneInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdQQVideoSceneInfo redact(RewardAdQQVideoSceneInfo rewardAdQQVideoSceneInfo) {
            a newBuilder = rewardAdQQVideoSceneInfo.newBuilder();
            ADVideoInfo aDVideoInfo = newBuilder.f383797a;
            if (aDVideoInfo != null) {
                newBuilder.f383797a = ADVideoInfo.ADAPTER.redact(aDVideoInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdQQVideoSceneInfo(ADVideoInfo aDVideoInfo, int i3, int i16) {
        this(aDVideoInfo, i3, i16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdQQVideoSceneInfo)) {
            return false;
        }
        RewardAdQQVideoSceneInfo rewardAdQQVideoSceneInfo = (RewardAdQQVideoSceneInfo) obj;
        if (unknownFields().equals(rewardAdQQVideoSceneInfo.unknownFields()) && Internal.equals(this.video_info, rewardAdQQVideoSceneInfo.video_info) && Internal.equals(Integer.valueOf(this.ad_num), Integer.valueOf(rewardAdQQVideoSceneInfo.ad_num)) && Internal.equals(Integer.valueOf(this.ad_post_index), Integer.valueOf(rewardAdQQVideoSceneInfo.ad_post_index))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            ADVideoInfo aDVideoInfo = this.video_info;
            if (aDVideoInfo != null) {
                i3 = aDVideoInfo.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = ((((hashCode + i3) * 37) + this.ad_num) * 37) + this.ad_post_index;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.video_info != null) {
            sb5.append(", video_info=");
            sb5.append(this.video_info);
        }
        sb5.append(", ad_num=");
        sb5.append(this.ad_num);
        sb5.append(", ad_post_index=");
        sb5.append(this.ad_post_index);
        StringBuilder replace = sb5.replace(0, 2, "RewardAdQQVideoSceneInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdQQVideoSceneInfo(ADVideoInfo aDVideoInfo, int i3, int i16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.video_info = aDVideoInfo;
        this.ad_num = i3;
        this.ad_post_index = i16;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383797a = this.video_info;
        aVar.f383798b = this.ad_num;
        aVar.f383799c = this.ad_post_index;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
