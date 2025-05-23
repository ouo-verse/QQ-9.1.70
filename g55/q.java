package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public String f401378a;

    /* renamed from: b, reason: collision with root package name */
    public at f401379b;

    /* renamed from: c, reason: collision with root package name */
    public ar f401380c;

    /* renamed from: d, reason: collision with root package name */
    public int f401381d;

    /* renamed from: e, reason: collision with root package name */
    public int f401382e;

    /* renamed from: f, reason: collision with root package name */
    public int f401383f;

    public q() {
        a();
    }

    public static q c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (q) MessageNano.mergeFrom(new q(), bArr);
    }

    public q a() {
        this.f401378a = "";
        this.f401379b = null;
        this.f401380c = null;
        this.f401381d = 0;
        this.f401382e = 0;
        this.f401383f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f401383f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f401382e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f401381d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            if (this.f401380c == null) {
                                this.f401380c = new ar();
                            }
                            codedInputByteBufferNano.readMessage(this.f401380c);
                        }
                    } else {
                        if (this.f401379b == null) {
                            this.f401379b = new at();
                        }
                        codedInputByteBufferNano.readMessage(this.f401379b);
                    }
                } else {
                    this.f401378a = codedInputByteBufferNano.readString();
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
        if (!this.f401378a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f401378a);
        }
        at atVar = this.f401379b;
        if (atVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, atVar);
        }
        ar arVar = this.f401380c;
        if (arVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, arVar);
        }
        int i3 = this.f401381d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.f401382e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f401383f;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f401378a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f401378a);
        }
        at atVar = this.f401379b;
        if (atVar != null) {
            codedOutputByteBufferNano.writeMessage(2, atVar);
        }
        ar arVar = this.f401380c;
        if (arVar != null) {
            codedOutputByteBufferNano.writeMessage(3, arVar);
        }
        int i3 = this.f401381d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.f401382e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f401383f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
