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
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MultiInferTextReq extends Message<MultiInferTextReq, a> {
    public static final ProtoAdapter<MultiInferTextReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "modelId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int model_id;

    @WireField(adapter = "feedcloud.TextPipeline#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<TextPipeline> pipelines;

    @WireField(adapter = "feedcloud.BusinessScene#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final BusinessScene scene;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String text;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<MultiInferTextReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f398513a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f398514b = "";

        /* renamed from: c, reason: collision with root package name */
        public BusinessScene f398515c = BusinessScene.BUSINESS_SCENE_CUSTOM;

        /* renamed from: d, reason: collision with root package name */
        public List<TextPipeline> f398516d = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MultiInferTextReq build() {
            return new MultiInferTextReq(this.f398513a, this.f398514b, this.f398515c, this.f398516d, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f398513a = i3;
            return this;
        }

        public a c(BusinessScene businessScene) {
            this.f398515c = businessScene;
            return this;
        }

        public a d(String str) {
            this.f398514b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<MultiInferTextReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MultiInferTextReq.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.MultiInferTextReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MultiInferTextReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    protoReader.readUnknownField(nextTag);
                                } else {
                                    aVar.f398516d.add(TextPipeline.ADAPTER.decode(protoReader));
                                }
                            } else {
                                try {
                                    aVar.c(BusinessScene.ADAPTER.decode(protoReader));
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                }
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.b(ProtoAdapter.UINT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, MultiInferTextReq multiInferTextReq) throws IOException {
            if (!Objects.equals(Integer.valueOf(multiInferTextReq.model_id), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, Integer.valueOf(multiInferTextReq.model_id));
            }
            if (!Objects.equals(multiInferTextReq.text, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, multiInferTextReq.text);
            }
            if (!Objects.equals(multiInferTextReq.scene, BusinessScene.BUSINESS_SCENE_CUSTOM)) {
                BusinessScene.ADAPTER.encodeWithTag(protoWriter, 3, multiInferTextReq.scene);
            }
            TextPipeline.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, multiInferTextReq.pipelines);
            protoWriter.writeBytes(multiInferTextReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(MultiInferTextReq multiInferTextReq) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(multiInferTextReq.model_id), 0)) {
                i3 = 0 + ProtoAdapter.UINT32.encodedSizeWithTag(1, Integer.valueOf(multiInferTextReq.model_id));
            }
            if (!Objects.equals(multiInferTextReq.text, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, multiInferTextReq.text);
            }
            if (!Objects.equals(multiInferTextReq.scene, BusinessScene.BUSINESS_SCENE_CUSTOM)) {
                i3 += BusinessScene.ADAPTER.encodedSizeWithTag(3, multiInferTextReq.scene);
            }
            return i3 + TextPipeline.ADAPTER.asRepeated().encodedSizeWithTag(4, multiInferTextReq.pipelines) + multiInferTextReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MultiInferTextReq redact(MultiInferTextReq multiInferTextReq) {
            a newBuilder = multiInferTextReq.newBuilder();
            Internal.redactElements(newBuilder.f398516d, TextPipeline.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MultiInferTextReq(int i3, String str, BusinessScene businessScene, List<TextPipeline> list) {
        this(i3, str, businessScene, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiInferTextReq)) {
            return false;
        }
        MultiInferTextReq multiInferTextReq = (MultiInferTextReq) obj;
        if (unknownFields().equals(multiInferTextReq.unknownFields()) && Internal.equals(Integer.valueOf(this.model_id), Integer.valueOf(multiInferTextReq.model_id)) && Internal.equals(this.text, multiInferTextReq.text) && Internal.equals(this.scene, multiInferTextReq.scene) && this.pipelines.equals(multiInferTextReq.pipelines)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.model_id) * 37;
            String str = this.text;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            BusinessScene businessScene = this.scene;
            if (businessScene != null) {
                i17 = businessScene.hashCode();
            }
            int hashCode2 = ((i18 + i17) * 37) + this.pipelines.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", model_id=");
        sb5.append(this.model_id);
        if (this.text != null) {
            sb5.append(", text=");
            sb5.append(Internal.sanitize(this.text));
        }
        if (this.scene != null) {
            sb5.append(", scene=");
            sb5.append(this.scene);
        }
        if (!this.pipelines.isEmpty()) {
            sb5.append(", pipelines=");
            sb5.append(this.pipelines);
        }
        StringBuilder replace = sb5.replace(0, 2, "MultiInferTextReq{");
        replace.append('}');
        return replace.toString();
    }

    public MultiInferTextReq(int i3, String str, BusinessScene businessScene, List<TextPipeline> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.model_id = i3;
        if (str != null) {
            this.text = str;
            if (businessScene != null) {
                this.scene = businessScene;
                this.pipelines = Internal.immutableCopyOf("pipelines", list);
                return;
            }
            throw new IllegalArgumentException("scene == null");
        }
        throw new IllegalArgumentException("text == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398513a = this.model_id;
        aVar.f398514b = this.text;
        aVar.f398515c = this.scene;
        aVar.f398516d = Internal.copyOf(this.pipelines);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
