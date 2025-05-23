package nq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f420697a;

    /* renamed from: b, reason: collision with root package name */
    public e f420698b;

    /* renamed from: c, reason: collision with root package name */
    public Map<Integer, e> f420699c;

    public a() {
        a();
    }

    public a a() {
        this.f420697a = "";
        this.f420698b = null;
        this.f420699c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 34) {
                    if (readTag != 42) {
                        if (readTag != 50) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f420699c = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f420699c, mapFactory, 5, 11, new e(), 8, 18);
                        }
                    } else {
                        if (this.f420698b == null) {
                            this.f420698b = new e();
                        }
                        codedInputByteBufferNano.readMessage(this.f420698b);
                    }
                } else {
                    this.f420697a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f420697a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f420697a);
        }
        e eVar = this.f420698b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, eVar);
        }
        Map<Integer, e> map = this.f420699c;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 6, 5, 11);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f420697a.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f420697a);
        }
        e eVar = this.f420698b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(5, eVar);
        }
        Map<Integer, e> map = this.f420699c;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 6, 5, 11);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
