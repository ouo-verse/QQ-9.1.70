package feedcloud;

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
/* loaded from: classes28.dex */
public final class FeedInfo extends Message<FeedInfo, a> {
    public static final ProtoAdapter<FeedInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cateInfo", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String cate_info;

    @WireField(adapter = "feedcloud.FeedEntity#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final FeedEntity feed;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String grade;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String labels;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", jsonName = "qualityScore", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final double quality_score;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "recomStatus", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String recom_status;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String source;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<FeedInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public FeedEntity f398489a;

        /* renamed from: b, reason: collision with root package name */
        public String f398490b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f398491c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f398492d = "";

        /* renamed from: e, reason: collision with root package name */
        public double f398493e = 0.0d;

        /* renamed from: f, reason: collision with root package name */
        public String f398494f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f398495g = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedInfo build() {
            return new FeedInfo(this.f398489a, this.f398490b, this.f398491c, this.f398492d, this.f398493e, this.f398494f, this.f398495g, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f398494f = str;
            return this;
        }

        public a c(FeedEntity feedEntity) {
            this.f398489a = feedEntity;
            return this;
        }

        public a d(String str) {
            this.f398495g = str;
            return this;
        }

        public a e(String str) {
            this.f398492d = str;
            return this;
        }

        public a f(double d16) {
            this.f398493e = d16;
            return this;
        }

        public a g(String str) {
            this.f398491c = str;
            return this;
        }

        public a h(String str) {
            this.f398490b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<FeedInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) FeedInfo.class, "type.googleapis.com/trpc.feedcloud.client_debug.FeedInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.c(FeedEntity.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.f(ProtoAdapter.DOUBLE.decode(protoReader).doubleValue());
                            break;
                        case 6:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
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
        public void encode(ProtoWriter protoWriter, FeedInfo feedInfo) throws IOException {
            if (!Objects.equals(feedInfo.feed, null)) {
                FeedEntity.ADAPTER.encodeWithTag(protoWriter, 1, feedInfo.feed);
            }
            if (!Objects.equals(feedInfo.source, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, feedInfo.source);
            }
            if (!Objects.equals(feedInfo.recom_status, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, feedInfo.recom_status);
            }
            if (!Objects.equals(feedInfo.labels, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, feedInfo.labels);
            }
            if (!Objects.equals(Double.valueOf(feedInfo.quality_score), Double.valueOf(0.0d))) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 5, Double.valueOf(feedInfo.quality_score));
            }
            if (!Objects.equals(feedInfo.cate_info, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, feedInfo.cate_info);
            }
            if (!Objects.equals(feedInfo.grade, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, feedInfo.grade);
            }
            protoWriter.writeBytes(feedInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(FeedInfo feedInfo) {
            int i3 = 0;
            if (!Objects.equals(feedInfo.feed, null)) {
                i3 = 0 + FeedEntity.ADAPTER.encodedSizeWithTag(1, feedInfo.feed);
            }
            if (!Objects.equals(feedInfo.source, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, feedInfo.source);
            }
            if (!Objects.equals(feedInfo.recom_status, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, feedInfo.recom_status);
            }
            if (!Objects.equals(feedInfo.labels, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, feedInfo.labels);
            }
            if (!Objects.equals(Double.valueOf(feedInfo.quality_score), Double.valueOf(0.0d))) {
                i3 += ProtoAdapter.DOUBLE.encodedSizeWithTag(5, Double.valueOf(feedInfo.quality_score));
            }
            if (!Objects.equals(feedInfo.cate_info, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, feedInfo.cate_info);
            }
            if (!Objects.equals(feedInfo.grade, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, feedInfo.grade);
            }
            return i3 + feedInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public FeedInfo redact(FeedInfo feedInfo) {
            a newBuilder = feedInfo.newBuilder();
            FeedEntity feedEntity = newBuilder.f398489a;
            if (feedEntity != null) {
                newBuilder.f398489a = FeedEntity.ADAPTER.redact(feedEntity);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public FeedInfo(FeedEntity feedEntity, String str, String str2, String str3, double d16, String str4, String str5) {
        this(feedEntity, str, str2, str3, d16, str4, str5, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedInfo)) {
            return false;
        }
        FeedInfo feedInfo = (FeedInfo) obj;
        if (unknownFields().equals(feedInfo.unknownFields()) && Internal.equals(this.feed, feedInfo.feed) && Internal.equals(this.source, feedInfo.source) && Internal.equals(this.recom_status, feedInfo.recom_status) && Internal.equals(this.labels, feedInfo.labels) && Internal.equals(Double.valueOf(this.quality_score), Double.valueOf(feedInfo.quality_score)) && Internal.equals(this.cate_info, feedInfo.cate_info) && Internal.equals(this.grade, feedInfo.grade)) {
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
            FeedEntity feedEntity = this.feed;
            int i27 = 0;
            if (feedEntity != null) {
                i3 = feedEntity.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str = this.source;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            String str2 = this.recom_status;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str3 = this.labels;
            if (str3 != null) {
                i18 = str3.hashCode();
            } else {
                i18 = 0;
            }
            int a16 = (((i36 + i18) * 37) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.quality_score)) * 37;
            String str4 = this.cate_info;
            if (str4 != null) {
                i19 = str4.hashCode();
            } else {
                i19 = 0;
            }
            int i37 = (a16 + i19) * 37;
            String str5 = this.grade;
            if (str5 != null) {
                i27 = str5.hashCode();
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
        if (this.feed != null) {
            sb5.append(", feed=");
            sb5.append(this.feed);
        }
        if (this.source != null) {
            sb5.append(", source=");
            sb5.append(Internal.sanitize(this.source));
        }
        if (this.recom_status != null) {
            sb5.append(", recom_status=");
            sb5.append(Internal.sanitize(this.recom_status));
        }
        if (this.labels != null) {
            sb5.append(", labels=");
            sb5.append(Internal.sanitize(this.labels));
        }
        sb5.append(", quality_score=");
        sb5.append(this.quality_score);
        if (this.cate_info != null) {
            sb5.append(", cate_info=");
            sb5.append(Internal.sanitize(this.cate_info));
        }
        if (this.grade != null) {
            sb5.append(", grade=");
            sb5.append(Internal.sanitize(this.grade));
        }
        StringBuilder replace = sb5.replace(0, 2, "FeedInfo{");
        replace.append('}');
        return replace.toString();
    }

    public FeedInfo(FeedEntity feedEntity, String str, String str2, String str3, double d16, String str4, String str5, ByteString byteString) {
        super(ADAPTER, byteString);
        this.feed = feedEntity;
        if (str != null) {
            this.source = str;
            if (str2 != null) {
                this.recom_status = str2;
                if (str3 != null) {
                    this.labels = str3;
                    this.quality_score = d16;
                    if (str4 != null) {
                        this.cate_info = str4;
                        if (str5 != null) {
                            this.grade = str5;
                            return;
                        }
                        throw new IllegalArgumentException("grade == null");
                    }
                    throw new IllegalArgumentException("cate_info == null");
                }
                throw new IllegalArgumentException("labels == null");
            }
            throw new IllegalArgumentException("recom_status == null");
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398489a = this.feed;
        aVar.f398490b = this.source;
        aVar.f398491c = this.recom_status;
        aVar.f398492d = this.labels;
        aVar.f398493e = this.quality_score;
        aVar.f398494f = this.cate_info;
        aVar.f398495g = this.grade;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
