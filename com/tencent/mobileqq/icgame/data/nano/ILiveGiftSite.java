package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ILiveGiftSite extends ExtendableMessageNano<ILiveGiftSite> {
    private static volatile ILiveGiftSite[] _emptyArray;

    /* renamed from: x, reason: collision with root package name */
    public int f237282x;

    /* renamed from: y, reason: collision with root package name */
    public int f237283y;

    public ILiveGiftSite() {
        clear();
    }

    public static ILiveGiftSite[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ILiveGiftSite[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ILiveGiftSite parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ILiveGiftSite) MessageNano.mergeFrom(new ILiveGiftSite(), bArr);
    }

    public ILiveGiftSite clear() {
        this.f237282x = 0;
        this.f237283y = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.f237282x) + CodedOutputByteBufferNano.computeUInt32Size(2, this.f237283y);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.f237282x);
        codedOutputByteBufferNano.writeUInt32(2, this.f237283y);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ILiveGiftSite parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ILiveGiftSite().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ILiveGiftSite mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f237282x = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f237283y = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
