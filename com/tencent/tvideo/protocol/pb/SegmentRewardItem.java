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
public final class SegmentRewardItem extends Message<SegmentRewardItem, a> {
    public static final ProtoAdapter<SegmentRewardItem> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int adNum;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdOpenType#ADAPTER", jsonName = "adOpenType", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final RewardAdOpenType ad_open_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "countdownTime", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final long countdown_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "countdownTitle", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String countdown_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "showPanel", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final boolean show_panel;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<SegmentRewardItem, a> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f383805a = false;

        /* renamed from: b, reason: collision with root package name */
        public long f383806b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f383807c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f383808d = "";

        /* renamed from: e, reason: collision with root package name */
        public RewardAdOpenType f383809e = RewardAdOpenType.REWARD_AD_OPEN_TYPE_UNKNOWN;

        public a a(int i3) {
            this.f383807c = i3;
            return this;
        }

        public a b(RewardAdOpenType rewardAdOpenType) {
            this.f383809e = rewardAdOpenType;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SegmentRewardItem build() {
            return new SegmentRewardItem(this.f383805a, this.f383806b, this.f383807c, this.f383808d, this.f383809e, super.buildUnknownFields());
        }

        public a d(long j3) {
            this.f383806b = j3;
            return this;
        }

        public a e(String str) {
            this.f383808d = str;
            return this;
        }

        public a f(boolean z16) {
            this.f383805a = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<SegmentRewardItem> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SegmentRewardItem.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.SegmentRewardItem", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SegmentRewardItem decode(ProtoReader protoReader) throws IOException {
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
                                        try {
                                            aVar.b(RewardAdOpenType.ADAPTER.decode(protoReader));
                                        } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                        }
                                    }
                                } else {
                                    aVar.e(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.a(ProtoAdapter.INT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.d(ProtoAdapter.INT64.decode(protoReader).longValue());
                        }
                    } else {
                        aVar.f(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SegmentRewardItem segmentRewardItem) throws IOException {
            if (!Objects.equals(Boolean.valueOf(segmentRewardItem.show_panel), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, Boolean.valueOf(segmentRewardItem.show_panel));
            }
            if (!Objects.equals(Long.valueOf(segmentRewardItem.countdown_time), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 2, Long.valueOf(segmentRewardItem.countdown_time));
            }
            if (!Objects.equals(Integer.valueOf(segmentRewardItem.adNum), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(segmentRewardItem.adNum));
            }
            if (!Objects.equals(segmentRewardItem.countdown_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, segmentRewardItem.countdown_title);
            }
            if (!Objects.equals(segmentRewardItem.ad_open_type, RewardAdOpenType.REWARD_AD_OPEN_TYPE_UNKNOWN)) {
                RewardAdOpenType.ADAPTER.encodeWithTag(protoWriter, 5, segmentRewardItem.ad_open_type);
            }
            protoWriter.writeBytes(segmentRewardItem.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SegmentRewardItem segmentRewardItem) {
            int i3;
            if (!Objects.equals(Boolean.valueOf(segmentRewardItem.show_panel), Boolean.FALSE)) {
                i3 = ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(segmentRewardItem.show_panel)) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Long.valueOf(segmentRewardItem.countdown_time), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(segmentRewardItem.countdown_time));
            }
            if (!Objects.equals(Integer.valueOf(segmentRewardItem.adNum), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(segmentRewardItem.adNum));
            }
            if (!Objects.equals(segmentRewardItem.countdown_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, segmentRewardItem.countdown_title);
            }
            if (!Objects.equals(segmentRewardItem.ad_open_type, RewardAdOpenType.REWARD_AD_OPEN_TYPE_UNKNOWN)) {
                i3 += RewardAdOpenType.ADAPTER.encodedSizeWithTag(5, segmentRewardItem.ad_open_type);
            }
            return i3 + segmentRewardItem.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SegmentRewardItem redact(SegmentRewardItem segmentRewardItem) {
            a newBuilder = segmentRewardItem.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SegmentRewardItem(boolean z16, long j3, int i3, String str, RewardAdOpenType rewardAdOpenType) {
        this(z16, j3, i3, str, rewardAdOpenType, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SegmentRewardItem)) {
            return false;
        }
        SegmentRewardItem segmentRewardItem = (SegmentRewardItem) obj;
        if (unknownFields().equals(segmentRewardItem.unknownFields()) && Internal.equals(Boolean.valueOf(this.show_panel), Boolean.valueOf(segmentRewardItem.show_panel)) && Internal.equals(Long.valueOf(this.countdown_time), Long.valueOf(segmentRewardItem.countdown_time)) && Internal.equals(Integer.valueOf(this.adNum), Integer.valueOf(segmentRewardItem.adNum)) && Internal.equals(this.countdown_title, segmentRewardItem.countdown_title) && Internal.equals(this.ad_open_type, segmentRewardItem.ad_open_type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + com.tencent.aio.widget.textView.param.a.a(this.show_panel)) * 37) + androidx.fragment.app.a.a(this.countdown_time)) * 37) + this.adNum) * 37;
            String str = this.countdown_title;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            RewardAdOpenType rewardAdOpenType = this.ad_open_type;
            if (rewardAdOpenType != null) {
                i17 = rewardAdOpenType.hashCode();
            }
            int i19 = i18 + i17;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", show_panel=");
        sb5.append(this.show_panel);
        sb5.append(", countdown_time=");
        sb5.append(this.countdown_time);
        sb5.append(", adNum=");
        sb5.append(this.adNum);
        if (this.countdown_title != null) {
            sb5.append(", countdown_title=");
            sb5.append(Internal.sanitize(this.countdown_title));
        }
        if (this.ad_open_type != null) {
            sb5.append(", ad_open_type=");
            sb5.append(this.ad_open_type);
        }
        StringBuilder replace = sb5.replace(0, 2, "SegmentRewardItem{");
        replace.append('}');
        return replace.toString();
    }

    public SegmentRewardItem(boolean z16, long j3, int i3, String str, RewardAdOpenType rewardAdOpenType, ByteString byteString) {
        super(ADAPTER, byteString);
        this.show_panel = z16;
        this.countdown_time = j3;
        this.adNum = i3;
        if (str != null) {
            this.countdown_title = str;
            if (rewardAdOpenType != null) {
                this.ad_open_type = rewardAdOpenType;
                return;
            }
            throw new IllegalArgumentException("ad_open_type == null");
        }
        throw new IllegalArgumentException("countdown_title == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383805a = this.show_panel;
        aVar.f383806b = this.countdown_time;
        aVar.f383807c = this.adNum;
        aVar.f383808d = this.countdown_title;
        aVar.f383809e = this.ad_open_type;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
