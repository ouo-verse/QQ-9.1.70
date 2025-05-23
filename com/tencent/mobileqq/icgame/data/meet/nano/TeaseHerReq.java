package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class TeaseHerReq extends ExtendableMessageNano<TeaseHerReq> {
    private static volatile TeaseHerReq[] _emptyArray;
    public String encryptUid;

    public TeaseHerReq() {
        clear();
    }

    public static TeaseHerReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TeaseHerReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static TeaseHerReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (TeaseHerReq) MessageNano.mergeFrom(new TeaseHerReq(), bArr);
    }

    public TeaseHerReq clear() {
        this.encryptUid = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.encryptUid.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.encryptUid);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.encryptUid.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.encryptUid);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static TeaseHerReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new TeaseHerReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public TeaseHerReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.encryptUid = codedInputByteBufferNano.readString();
            }
        }
    }
}
