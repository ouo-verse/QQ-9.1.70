package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ContributorInfo extends ExtendableMessageNano<ContributorInfo> {
    private static volatile ContributorInfo[] _emptyArray;
    public String data;
    public int rank;
    public int score;
    public long uid;

    public ContributorInfo() {
        clear();
    }

    public static ContributorInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ContributorInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ContributorInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ContributorInfo) MessageNano.mergeFrom(new ContributorInfo(), bArr);
    }

    public ContributorInfo clear() {
        this.uid = 0L;
        this.score = 0;
        this.rank = 0;
        this.data = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.score;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.rank;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        if (!this.data.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.data);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.score;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.rank;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!this.data.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ContributorInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ContributorInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ContributorInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.score = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.rank = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.data = codedInputByteBufferNano.readString();
            }
        }
    }
}
