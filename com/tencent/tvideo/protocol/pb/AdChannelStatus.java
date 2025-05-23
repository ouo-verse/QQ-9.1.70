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
public final class AdChannelStatus extends Message<AdChannelStatus, a> {
    public static final ProtoAdapter<AdChannelStatus> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "ad3sSkipCount", label = WireField.Label.OMIT_IDENTITY, tag = 15)
    public final int ad_3s_skip_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "adCount", label = WireField.Label.OMIT_IDENTITY, tag = 11)
    public final int ad_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "adExpCount", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int ad_exp_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adLatestPlayEventList", label = WireField.Label.OMIT_IDENTITY, tag = 17)
    public final String ad_latest_play_event_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "adOriginalExpCount", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final int ad_original_exp_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "adPlayTimeMax", label = WireField.Label.OMIT_IDENTITY, tag = 13)
    public final long ad_play_time_max;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "adPlayTimeMin", label = WireField.Label.OMIT_IDENTITY, tag = 14)
    public final long ad_play_time_min;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "adPlayTimeSum", label = WireField.Label.OMIT_IDENTITY, tag = 12)
    public final long ad_play_time_sum;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "content3sSkipCount", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final int content_3s_skip_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "contentCount", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final int content_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "contentExpCount", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int content_exp_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "contentLatestPlayEventList", label = WireField.Label.OMIT_IDENTITY, tag = 16)
    public final String content_latest_play_event_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "contentPlayTimeMax", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final long content_play_time_max;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "contentPlayTimeMin", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final long content_play_time_min;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "contentPlayTimeSum", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final long content_play_time_sum;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "refreshCount", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int refresh_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "refreshType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int refresh_type;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdChannelStatus, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f383526a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f383527b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f383528c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f383529d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f383530e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f383531f = 0;

        /* renamed from: g, reason: collision with root package name */
        public long f383532g = 0;

        /* renamed from: h, reason: collision with root package name */
        public long f383533h = 0;

        /* renamed from: i, reason: collision with root package name */
        public long f383534i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f383535j = 0;

        /* renamed from: k, reason: collision with root package name */
        public int f383536k = 0;

        /* renamed from: l, reason: collision with root package name */
        public long f383537l = 0;

        /* renamed from: m, reason: collision with root package name */
        public long f383538m = 0;

        /* renamed from: n, reason: collision with root package name */
        public long f383539n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f383540o = 0;

        /* renamed from: p, reason: collision with root package name */
        public String f383541p = "";

        /* renamed from: q, reason: collision with root package name */
        public String f383542q = "";

        public a a(int i3) {
            this.f383540o = i3;
            return this;
        }

        public a b(int i3) {
            this.f383536k = i3;
            return this;
        }

        public a c(int i3) {
            this.f383528c = i3;
            return this;
        }

        public a d(String str) {
            this.f383542q = str;
            return this;
        }

        public a e(int i3) {
            this.f383530e = i3;
            return this;
        }

        public a f(long j3) {
            this.f383538m = j3;
            return this;
        }

        public a g(long j3) {
            this.f383539n = j3;
            return this;
        }

        public a h(long j3) {
            this.f383537l = j3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public AdChannelStatus build() {
            return new AdChannelStatus(this, super.buildUnknownFields());
        }

        public a j(int i3) {
            this.f383535j = i3;
            return this;
        }

        public a k(int i3) {
            this.f383531f = i3;
            return this;
        }

        public a l(int i3) {
            this.f383529d = i3;
            return this;
        }

        public a m(String str) {
            this.f383541p = str;
            return this;
        }

        public a n(long j3) {
            this.f383533h = j3;
            return this;
        }

        public a o(long j3) {
            this.f383534i = j3;
            return this;
        }

        public a p(long j3) {
            this.f383532g = j3;
            return this;
        }

        public a q(int i3) {
            this.f383527b = i3;
            return this;
        }

        public a r(int i3) {
            this.f383526a = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdChannelStatus> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdChannelStatus.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdChannelStatus", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdChannelStatus decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.r(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.q(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 3:
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 4:
                            aVar.l(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 5:
                            aVar.e(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 6:
                            aVar.k(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 7:
                            aVar.p(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 8:
                            aVar.n(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 9:
                            aVar.o(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 10:
                            aVar.j(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 11:
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 12:
                            aVar.h(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 13:
                            aVar.f(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 14:
                            aVar.g(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 15:
                            aVar.a(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 16:
                            aVar.m(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdChannelStatus adChannelStatus) throws IOException {
            if (!Objects.equals(Integer.valueOf(adChannelStatus.refresh_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(adChannelStatus.refresh_type));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.refresh_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(adChannelStatus.refresh_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.ad_exp_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(adChannelStatus.ad_exp_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.content_exp_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, Integer.valueOf(adChannelStatus.content_exp_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.ad_original_exp_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, Integer.valueOf(adChannelStatus.ad_original_exp_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.content_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 6, Integer.valueOf(adChannelStatus.content_count));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.content_play_time_sum), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 7, Long.valueOf(adChannelStatus.content_play_time_sum));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.content_play_time_max), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 8, Long.valueOf(adChannelStatus.content_play_time_max));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.content_play_time_min), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 9, Long.valueOf(adChannelStatus.content_play_time_min));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.content_3s_skip_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 10, Integer.valueOf(adChannelStatus.content_3s_skip_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.ad_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 11, Integer.valueOf(adChannelStatus.ad_count));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.ad_play_time_sum), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 12, Long.valueOf(adChannelStatus.ad_play_time_sum));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.ad_play_time_max), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 13, Long.valueOf(adChannelStatus.ad_play_time_max));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.ad_play_time_min), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 14, Long.valueOf(adChannelStatus.ad_play_time_min));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.ad_3s_skip_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 15, Integer.valueOf(adChannelStatus.ad_3s_skip_count));
            }
            if (!Objects.equals(adChannelStatus.content_latest_play_event_list, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, adChannelStatus.content_latest_play_event_list);
            }
            if (!Objects.equals(adChannelStatus.ad_latest_play_event_list, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 17, adChannelStatus.ad_latest_play_event_list);
            }
            protoWriter.writeBytes(adChannelStatus.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdChannelStatus adChannelStatus) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(adChannelStatus.refresh_type), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(adChannelStatus.refresh_type));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.refresh_count), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(adChannelStatus.refresh_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.ad_exp_count), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(adChannelStatus.ad_exp_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.content_exp_count), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(adChannelStatus.content_exp_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.ad_original_exp_count), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(adChannelStatus.ad_original_exp_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.content_count), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(6, Integer.valueOf(adChannelStatus.content_count));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.content_play_time_sum), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(7, Long.valueOf(adChannelStatus.content_play_time_sum));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.content_play_time_max), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(8, Long.valueOf(adChannelStatus.content_play_time_max));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.content_play_time_min), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(9, Long.valueOf(adChannelStatus.content_play_time_min));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.content_3s_skip_count), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(10, Integer.valueOf(adChannelStatus.content_3s_skip_count));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.ad_count), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(11, Integer.valueOf(adChannelStatus.ad_count));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.ad_play_time_sum), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(12, Long.valueOf(adChannelStatus.ad_play_time_sum));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.ad_play_time_max), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(13, Long.valueOf(adChannelStatus.ad_play_time_max));
            }
            if (!Objects.equals(Long.valueOf(adChannelStatus.ad_play_time_min), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(14, Long.valueOf(adChannelStatus.ad_play_time_min));
            }
            if (!Objects.equals(Integer.valueOf(adChannelStatus.ad_3s_skip_count), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(15, Integer.valueOf(adChannelStatus.ad_3s_skip_count));
            }
            if (!Objects.equals(adChannelStatus.content_latest_play_event_list, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(16, adChannelStatus.content_latest_play_event_list);
            }
            if (!Objects.equals(adChannelStatus.ad_latest_play_event_list, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(17, adChannelStatus.ad_latest_play_event_list);
            }
            return i3 + adChannelStatus.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdChannelStatus redact(AdChannelStatus adChannelStatus) {
            a newBuilder = adChannelStatus.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdChannelStatus(a aVar, ByteString byteString) {
        super(ADAPTER, byteString);
        this.refresh_type = aVar.f383526a;
        this.refresh_count = aVar.f383527b;
        this.ad_exp_count = aVar.f383528c;
        this.content_exp_count = aVar.f383529d;
        this.ad_original_exp_count = aVar.f383530e;
        this.content_count = aVar.f383531f;
        this.content_play_time_sum = aVar.f383532g;
        this.content_play_time_max = aVar.f383533h;
        this.content_play_time_min = aVar.f383534i;
        this.content_3s_skip_count = aVar.f383535j;
        this.ad_count = aVar.f383536k;
        this.ad_play_time_sum = aVar.f383537l;
        this.ad_play_time_max = aVar.f383538m;
        this.ad_play_time_min = aVar.f383539n;
        this.ad_3s_skip_count = aVar.f383540o;
        String str = aVar.f383541p;
        if (str != null) {
            this.content_latest_play_event_list = str;
            String str2 = aVar.f383542q;
            if (str2 != null) {
                this.ad_latest_play_event_list = str2;
                return;
            }
            throw new IllegalArgumentException("builder.ad_latest_play_event_list == null");
        }
        throw new IllegalArgumentException("builder.content_latest_play_event_list == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdChannelStatus)) {
            return false;
        }
        AdChannelStatus adChannelStatus = (AdChannelStatus) obj;
        if (unknownFields().equals(adChannelStatus.unknownFields()) && Internal.equals(Integer.valueOf(this.refresh_type), Integer.valueOf(adChannelStatus.refresh_type)) && Internal.equals(Integer.valueOf(this.refresh_count), Integer.valueOf(adChannelStatus.refresh_count)) && Internal.equals(Integer.valueOf(this.ad_exp_count), Integer.valueOf(adChannelStatus.ad_exp_count)) && Internal.equals(Integer.valueOf(this.content_exp_count), Integer.valueOf(adChannelStatus.content_exp_count)) && Internal.equals(Integer.valueOf(this.ad_original_exp_count), Integer.valueOf(adChannelStatus.ad_original_exp_count)) && Internal.equals(Integer.valueOf(this.content_count), Integer.valueOf(adChannelStatus.content_count)) && Internal.equals(Long.valueOf(this.content_play_time_sum), Long.valueOf(adChannelStatus.content_play_time_sum)) && Internal.equals(Long.valueOf(this.content_play_time_max), Long.valueOf(adChannelStatus.content_play_time_max)) && Internal.equals(Long.valueOf(this.content_play_time_min), Long.valueOf(adChannelStatus.content_play_time_min)) && Internal.equals(Integer.valueOf(this.content_3s_skip_count), Integer.valueOf(adChannelStatus.content_3s_skip_count)) && Internal.equals(Integer.valueOf(this.ad_count), Integer.valueOf(adChannelStatus.ad_count)) && Internal.equals(Long.valueOf(this.ad_play_time_sum), Long.valueOf(adChannelStatus.ad_play_time_sum)) && Internal.equals(Long.valueOf(this.ad_play_time_max), Long.valueOf(adChannelStatus.ad_play_time_max)) && Internal.equals(Long.valueOf(this.ad_play_time_min), Long.valueOf(adChannelStatus.ad_play_time_min)) && Internal.equals(Integer.valueOf(this.ad_3s_skip_count), Integer.valueOf(adChannelStatus.ad_3s_skip_count)) && Internal.equals(this.content_latest_play_event_list, adChannelStatus.content_latest_play_event_list) && Internal.equals(this.ad_latest_play_event_list, adChannelStatus.ad_latest_play_event_list)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((((((((((((((((((((((((((((unknownFields().hashCode() * 37) + this.refresh_type) * 37) + this.refresh_count) * 37) + this.ad_exp_count) * 37) + this.content_exp_count) * 37) + this.ad_original_exp_count) * 37) + this.content_count) * 37) + androidx.fragment.app.a.a(this.content_play_time_sum)) * 37) + androidx.fragment.app.a.a(this.content_play_time_max)) * 37) + androidx.fragment.app.a.a(this.content_play_time_min)) * 37) + this.content_3s_skip_count) * 37) + this.ad_count) * 37) + androidx.fragment.app.a.a(this.ad_play_time_sum)) * 37) + androidx.fragment.app.a.a(this.ad_play_time_max)) * 37) + androidx.fragment.app.a.a(this.ad_play_time_min)) * 37) + this.ad_3s_skip_count) * 37;
            String str = this.content_latest_play_event_list;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.ad_latest_play_event_list;
            if (str2 != null) {
                i17 = str2.hashCode();
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
        sb5.append(", refresh_type=");
        sb5.append(this.refresh_type);
        sb5.append(", refresh_count=");
        sb5.append(this.refresh_count);
        sb5.append(", ad_exp_count=");
        sb5.append(this.ad_exp_count);
        sb5.append(", content_exp_count=");
        sb5.append(this.content_exp_count);
        sb5.append(", ad_original_exp_count=");
        sb5.append(this.ad_original_exp_count);
        sb5.append(", content_count=");
        sb5.append(this.content_count);
        sb5.append(", content_play_time_sum=");
        sb5.append(this.content_play_time_sum);
        sb5.append(", content_play_time_max=");
        sb5.append(this.content_play_time_max);
        sb5.append(", content_play_time_min=");
        sb5.append(this.content_play_time_min);
        sb5.append(", content_3s_skip_count=");
        sb5.append(this.content_3s_skip_count);
        sb5.append(", ad_count=");
        sb5.append(this.ad_count);
        sb5.append(", ad_play_time_sum=");
        sb5.append(this.ad_play_time_sum);
        sb5.append(", ad_play_time_max=");
        sb5.append(this.ad_play_time_max);
        sb5.append(", ad_play_time_min=");
        sb5.append(this.ad_play_time_min);
        sb5.append(", ad_3s_skip_count=");
        sb5.append(this.ad_3s_skip_count);
        if (this.content_latest_play_event_list != null) {
            sb5.append(", content_latest_play_event_list=");
            sb5.append(Internal.sanitize(this.content_latest_play_event_list));
        }
        if (this.ad_latest_play_event_list != null) {
            sb5.append(", ad_latest_play_event_list=");
            sb5.append(Internal.sanitize(this.ad_latest_play_event_list));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdChannelStatus{");
        replace.append('}');
        return replace.toString();
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383526a = this.refresh_type;
        aVar.f383527b = this.refresh_count;
        aVar.f383528c = this.ad_exp_count;
        aVar.f383529d = this.content_exp_count;
        aVar.f383530e = this.ad_original_exp_count;
        aVar.f383531f = this.content_count;
        aVar.f383532g = this.content_play_time_sum;
        aVar.f383533h = this.content_play_time_max;
        aVar.f383534i = this.content_play_time_min;
        aVar.f383535j = this.content_3s_skip_count;
        aVar.f383536k = this.ad_count;
        aVar.f383537l = this.ad_play_time_sum;
        aVar.f383538m = this.ad_play_time_max;
        aVar.f383539n = this.ad_play_time_min;
        aVar.f383540o = this.ad_3s_skip_count;
        aVar.f383541p = this.content_latest_play_event_list;
        aVar.f383542q = this.ad_latest_play_event_list;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
