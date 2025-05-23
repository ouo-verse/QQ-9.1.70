package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ContributionInfo extends ExtendableMessageNano<ContributionInfo> {
    private static volatile ContributionInfo[] _emptyArray;
    public String avatar;
    public int gender;
    public String name;
    public long uid;
    public long value;

    public ContributionInfo() {
        clear();
    }

    public static ContributionInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ContributionInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ContributionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ContributionInfo) MessageNano.mergeFrom(new ContributionInfo(), bArr);
    }

    public ContributionInfo clear() {
        this.uid = 0L;
        this.value = 0L;
        this.name = "";
        this.gender = 0;
        this.avatar = "";
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
        long j16 = this.value;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        if (!this.avatar.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.avatar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.value;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.avatar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ContributionInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ContributionInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ContributionInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.value = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.gender = readInt32;
                }
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.avatar = codedInputByteBufferNano.readString();
            }
        }
    }
}
