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
public final class FeedFeature extends Message<FeedFeature, a> {
    public static final ProtoAdapter<FeedFeature> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.AuthorInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AuthorInfo author;

    @WireField(adapter = "feedcloud.FeedInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final FeedInfo feed;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<FeedFeature, a> {

        /* renamed from: a, reason: collision with root package name */
        public FeedInfo f398487a;

        /* renamed from: b, reason: collision with root package name */
        public AuthorInfo f398488b;

        public a a(AuthorInfo authorInfo) {
            this.f398488b = authorInfo;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FeedFeature build() {
            return new FeedFeature(this.f398487a, this.f398488b, super.buildUnknownFields());
        }

        public a c(FeedInfo feedInfo) {
            this.f398487a = feedInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<FeedFeature> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) FeedFeature.class, "type.googleapis.com/trpc.feedcloud.client_debug.FeedFeature", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedFeature decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.a(AuthorInfo.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.c(FeedInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, FeedFeature feedFeature) throws IOException {
            if (!Objects.equals(feedFeature.feed, null)) {
                FeedInfo.ADAPTER.encodeWithTag(protoWriter, 1, feedFeature.feed);
            }
            if (!Objects.equals(feedFeature.author, null)) {
                AuthorInfo.ADAPTER.encodeWithTag(protoWriter, 2, feedFeature.author);
            }
            protoWriter.writeBytes(feedFeature.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(FeedFeature feedFeature) {
            int i3 = 0;
            if (!Objects.equals(feedFeature.feed, null)) {
                i3 = 0 + FeedInfo.ADAPTER.encodedSizeWithTag(1, feedFeature.feed);
            }
            if (!Objects.equals(feedFeature.author, null)) {
                i3 += AuthorInfo.ADAPTER.encodedSizeWithTag(2, feedFeature.author);
            }
            return i3 + feedFeature.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public FeedFeature redact(FeedFeature feedFeature) {
            a newBuilder = feedFeature.newBuilder();
            FeedInfo feedInfo = newBuilder.f398487a;
            if (feedInfo != null) {
                newBuilder.f398487a = FeedInfo.ADAPTER.redact(feedInfo);
            }
            AuthorInfo authorInfo = newBuilder.f398488b;
            if (authorInfo != null) {
                newBuilder.f398488b = AuthorInfo.ADAPTER.redact(authorInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public FeedFeature(FeedInfo feedInfo, AuthorInfo authorInfo) {
        this(feedInfo, authorInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedFeature)) {
            return false;
        }
        FeedFeature feedFeature = (FeedFeature) obj;
        if (unknownFields().equals(feedFeature.unknownFields()) && Internal.equals(this.feed, feedFeature.feed) && Internal.equals(this.author, feedFeature.author)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            FeedInfo feedInfo = this.feed;
            int i17 = 0;
            if (feedInfo != null) {
                i3 = feedInfo.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            AuthorInfo authorInfo = this.author;
            if (authorInfo != null) {
                i17 = authorInfo.hashCode();
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
        if (this.feed != null) {
            sb5.append(", feed=");
            sb5.append(this.feed);
        }
        if (this.author != null) {
            sb5.append(", author=");
            sb5.append(this.author);
        }
        StringBuilder replace = sb5.replace(0, 2, "FeedFeature{");
        replace.append('}');
        return replace.toString();
    }

    public FeedFeature(FeedInfo feedInfo, AuthorInfo authorInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        this.feed = feedInfo;
        this.author = authorInfo;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398487a = this.feed;
        aVar.f398488b = this.author;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
