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

/* loaded from: classes28.dex */
public final class PromptOpt extends Message<PromptOpt, a> {
    public static final ProtoAdapter<PromptOpt> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.PromptBusiness#ADAPTER", jsonName = "businessId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final PromptBusiness business_id;

    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<PromptOpt, a> {

        /* renamed from: a, reason: collision with root package name */
        public PromptBusiness f398518a = PromptBusiness.PROMPT_BUSINESS_UNKNOWN;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PromptOpt build() {
            return new PromptOpt(this.f398518a, super.buildUnknownFields());
        }

        public a b(PromptBusiness promptBusiness) {
            this.f398518a = promptBusiness;
            return this;
        }
    }

    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<PromptOpt> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) PromptOpt.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.PromptOpt", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PromptOpt decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        try {
                            aVar.b(PromptBusiness.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                        }
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, PromptOpt promptOpt) throws IOException {
            if (!Objects.equals(promptOpt.business_id, PromptBusiness.PROMPT_BUSINESS_UNKNOWN)) {
                PromptBusiness.ADAPTER.encodeWithTag(protoWriter, 1, promptOpt.business_id);
            }
            protoWriter.writeBytes(promptOpt.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(PromptOpt promptOpt) {
            int i3 = 0;
            if (!Objects.equals(promptOpt.business_id, PromptBusiness.PROMPT_BUSINESS_UNKNOWN)) {
                i3 = 0 + PromptBusiness.ADAPTER.encodedSizeWithTag(1, promptOpt.business_id);
            }
            return i3 + promptOpt.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public PromptOpt redact(PromptOpt promptOpt) {
            a newBuilder = promptOpt.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public PromptOpt(PromptBusiness promptBusiness) {
        this(promptBusiness, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PromptOpt)) {
            return false;
        }
        PromptOpt promptOpt = (PromptOpt) obj;
        if (unknownFields().equals(promptOpt.unknownFields()) && Internal.equals(this.business_id, promptOpt.business_id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            PromptBusiness promptBusiness = this.business_id;
            if (promptBusiness != null) {
                i3 = promptBusiness.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.business_id != null) {
            sb5.append(", business_id=");
            sb5.append(this.business_id);
        }
        StringBuilder replace = sb5.replace(0, 2, "PromptOpt{");
        replace.append('}');
        return replace.toString();
    }

    public PromptOpt(PromptBusiness promptBusiness, ByteString byteString) {
        super(ADAPTER, byteString);
        if (promptBusiness != null) {
            this.business_id = promptBusiness;
            return;
        }
        throw new IllegalArgumentException("business_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398518a = this.business_id;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
