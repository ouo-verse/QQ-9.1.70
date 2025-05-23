package feedcloud;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.rmonitor.base.config.data.k;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BatchGetFeedFeatureRsp extends Message<BatchGetFeedFeatureRsp, a> {
    public static final ProtoAdapter<BatchGetFeedFeatureRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.FeedFeature#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<FeedFeature> features;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<BatchGetFeedFeatureRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<FeedFeature> f398419a = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchGetFeedFeatureRsp build() {
            return new BatchGetFeedFeatureRsp(this.f398419a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<BatchGetFeedFeatureRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) BatchGetFeedFeatureRsp.class, "type.googleapis.com/trpc.feedcloud.client_debug.BatchGetFeedFeatureRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchGetFeedFeatureRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f398419a.add(FeedFeature.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, BatchGetFeedFeatureRsp batchGetFeedFeatureRsp) throws IOException {
            FeedFeature.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, batchGetFeedFeatureRsp.features);
            protoWriter.writeBytes(batchGetFeedFeatureRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(BatchGetFeedFeatureRsp batchGetFeedFeatureRsp) {
            return FeedFeature.ADAPTER.asRepeated().encodedSizeWithTag(1, batchGetFeedFeatureRsp.features) + 0 + batchGetFeedFeatureRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BatchGetFeedFeatureRsp redact(BatchGetFeedFeatureRsp batchGetFeedFeatureRsp) {
            a newBuilder = batchGetFeedFeatureRsp.newBuilder();
            Internal.redactElements(newBuilder.f398419a, FeedFeature.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public BatchGetFeedFeatureRsp(List<FeedFeature> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchGetFeedFeatureRsp)) {
            return false;
        }
        BatchGetFeedFeatureRsp batchGetFeedFeatureRsp = (BatchGetFeedFeatureRsp) obj;
        if (unknownFields().equals(batchGetFeedFeatureRsp.unknownFields()) && this.features.equals(batchGetFeedFeatureRsp.features)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.features.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.features.isEmpty()) {
            sb5.append(", features=");
            sb5.append(this.features);
        }
        StringBuilder replace = sb5.replace(0, 2, "BatchGetFeedFeatureRsp{");
        replace.append('}');
        return replace.toString();
    }

    public BatchGetFeedFeatureRsp(List<FeedFeature> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.features = Internal.immutableCopyOf(k.FEATURES_KEY, list);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398419a = Internal.copyOf(this.features);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
