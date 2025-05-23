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
import java.util.List;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BatchGetFeedFeatureReq extends Message<BatchGetFeedFeatureReq, a> {
    public static final ProtoAdapter<BatchGetFeedFeatureReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.FeedEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<FeedEntity> feeds;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<BatchGetFeedFeatureReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<FeedEntity> f398418a = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchGetFeedFeatureReq build() {
            return new BatchGetFeedFeatureReq(this.f398418a, super.buildUnknownFields());
        }

        public a b(List<FeedEntity> list) {
            Internal.checkElementsNotNull(list);
            this.f398418a = list;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<BatchGetFeedFeatureReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) BatchGetFeedFeatureReq.class, "type.googleapis.com/trpc.feedcloud.client_debug.BatchGetFeedFeatureReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchGetFeedFeatureReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f398418a.add(FeedEntity.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, BatchGetFeedFeatureReq batchGetFeedFeatureReq) throws IOException {
            FeedEntity.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, batchGetFeedFeatureReq.feeds);
            protoWriter.writeBytes(batchGetFeedFeatureReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(BatchGetFeedFeatureReq batchGetFeedFeatureReq) {
            return FeedEntity.ADAPTER.asRepeated().encodedSizeWithTag(1, batchGetFeedFeatureReq.feeds) + 0 + batchGetFeedFeatureReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BatchGetFeedFeatureReq redact(BatchGetFeedFeatureReq batchGetFeedFeatureReq) {
            a newBuilder = batchGetFeedFeatureReq.newBuilder();
            Internal.redactElements(newBuilder.f398418a, FeedEntity.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public BatchGetFeedFeatureReq(List<FeedEntity> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchGetFeedFeatureReq)) {
            return false;
        }
        BatchGetFeedFeatureReq batchGetFeedFeatureReq = (BatchGetFeedFeatureReq) obj;
        if (unknownFields().equals(batchGetFeedFeatureReq.unknownFields()) && this.feeds.equals(batchGetFeedFeatureReq.feeds)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.feeds.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.feeds.isEmpty()) {
            sb5.append(", feeds=");
            sb5.append(this.feeds);
        }
        StringBuilder replace = sb5.replace(0, 2, "BatchGetFeedFeatureReq{");
        replace.append('}');
        return replace.toString();
    }

    public BatchGetFeedFeatureReq(List<FeedEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.feeds = Internal.immutableCopyOf("feeds", list);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398418a = Internal.copyOf(this.feeds);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
