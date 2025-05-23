package feedcloud;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedEntity extends Message<FeedEntity, a> {
    public static final ProtoAdapter<FeedEntity> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QFSEdgeItem.KEY_AUTHOR_ID, label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String author_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", jsonName = WadlProxyConsts.CREATE_TIME, label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final long create_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "feedId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String feed_id;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<FeedEntity, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f398484a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f398485b = "";

        /* renamed from: c, reason: collision with root package name */
        public long f398486c = 0;

        public a a(String str) {
            this.f398485b = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FeedEntity build() {
            return new FeedEntity(this.f398484a, this.f398485b, this.f398486c, super.buildUnknownFields());
        }

        public a c(long j3) {
            this.f398486c = j3;
            return this;
        }

        public a d(String str) {
            this.f398484a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<FeedEntity> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) FeedEntity.class, "type.googleapis.com/trpc.feedcloud.client_debug.FeedEntity", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedEntity decode(ProtoReader protoReader) throws IOException {
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
                                aVar.c(ProtoAdapter.UINT64.decode(protoReader).longValue());
                            }
                        } else {
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.d(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, FeedEntity feedEntity) throws IOException {
            if (!Objects.equals(feedEntity.feed_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, feedEntity.feed_id);
            }
            if (!Objects.equals(feedEntity.author_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, feedEntity.author_id);
            }
            if (!Objects.equals(Long.valueOf(feedEntity.create_time), 0L)) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 3, Long.valueOf(feedEntity.create_time));
            }
            protoWriter.writeBytes(feedEntity.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(FeedEntity feedEntity) {
            int i3 = 0;
            if (!Objects.equals(feedEntity.feed_id, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, feedEntity.feed_id);
            }
            if (!Objects.equals(feedEntity.author_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, feedEntity.author_id);
            }
            if (!Objects.equals(Long.valueOf(feedEntity.create_time), 0L)) {
                i3 += ProtoAdapter.UINT64.encodedSizeWithTag(3, Long.valueOf(feedEntity.create_time));
            }
            return i3 + feedEntity.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public FeedEntity redact(FeedEntity feedEntity) {
            a newBuilder = feedEntity.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public FeedEntity(String str, String str2, long j3) {
        this(str, str2, j3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedEntity)) {
            return false;
        }
        FeedEntity feedEntity = (FeedEntity) obj;
        if (unknownFields().equals(feedEntity.unknownFields()) && Internal.equals(this.feed_id, feedEntity.feed_id) && Internal.equals(this.author_id, feedEntity.author_id) && Internal.equals(Long.valueOf(this.create_time), Long.valueOf(feedEntity.create_time))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.feed_id;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.author_id;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int a16 = ((i18 + i17) * 37) + androidx.fragment.app.a.a(this.create_time);
            this.hashCode = a16;
            return a16;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.feed_id != null) {
            sb5.append(", feed_id=");
            sb5.append(Internal.sanitize(this.feed_id));
        }
        if (this.author_id != null) {
            sb5.append(", author_id=");
            sb5.append(Internal.sanitize(this.author_id));
        }
        sb5.append(", create_time=");
        sb5.append(this.create_time);
        StringBuilder replace = sb5.replace(0, 2, "FeedEntity{");
        replace.append('}');
        return replace.toString();
    }

    public FeedEntity(String str, String str2, long j3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.feed_id = str;
            if (str2 != null) {
                this.author_id = str2;
                this.create_time = j3;
                return;
            }
            throw new IllegalArgumentException("author_id == null");
        }
        throw new IllegalArgumentException("feed_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398484a = this.feed_id;
        aVar.f398485b = this.author_id;
        aVar.f398486c = this.create_time;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
