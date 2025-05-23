package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class BatchGetExperienceInfoReq extends ExtendableMessageNano<BatchGetExperienceInfoReq> {
    private static volatile BatchGetExperienceInfoReq[] _emptyArray;
    public long roomId;
    public int[] scene;

    public BatchGetExperienceInfoReq() {
        clear();
    }

    public static BatchGetExperienceInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetExperienceInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetExperienceInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetExperienceInfoReq) MessageNano.mergeFrom(new BatchGetExperienceInfoReq(), bArr);
    }

    public BatchGetExperienceInfoReq clear() {
        this.scene = WireFormatNano.EMPTY_INT_ARRAY;
        this.roomId = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int[] iArr2 = this.scene;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                iArr = this.scene;
                if (i3 >= iArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (iArr.length * 1);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int[] iArr = this.scene;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.scene;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(1, iArr2[i3]);
                i3++;
            }
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetExperienceInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetExperienceInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetExperienceInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                int[] iArr = new int[repeatedFieldArrayLength];
                int i3 = 0;
                for (int i16 = 0; i16 < repeatedFieldArrayLength; i16++) {
                    if (i16 != 0) {
                        codedInputByteBufferNano.readTag();
                    }
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                        iArr[i3] = readInt32;
                        i3++;
                    }
                }
                if (i3 != 0) {
                    int[] iArr2 = this.scene;
                    int length = iArr2 == null ? 0 : iArr2.length;
                    if (length == 0 && i3 == repeatedFieldArrayLength) {
                        this.scene = iArr;
                    } else {
                        int[] iArr3 = new int[length + i3];
                        if (length != 0) {
                            System.arraycopy(iArr2, 0, iArr3, 0, length);
                        }
                        System.arraycopy(iArr, 0, iArr3, length, i3);
                        this.scene = iArr3;
                    }
                }
            } else if (readTag == 10) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i17 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                        i17++;
                    }
                }
                if (i17 != 0) {
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr4 = this.scene;
                    int length2 = iArr4 == null ? 0 : iArr4.length;
                    int[] iArr5 = new int[i17 + length2];
                    if (length2 != 0) {
                        System.arraycopy(iArr4, 0, iArr5, 0, length2);
                    }
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2) {
                            iArr5[length2] = readInt323;
                            length2++;
                        }
                    }
                    this.scene = iArr5;
                }
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomId = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
