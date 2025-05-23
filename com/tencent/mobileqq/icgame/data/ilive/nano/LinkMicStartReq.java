package com.tencent.mobileqq.icgame.data.ilive.nano;

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
public final class LinkMicStartReq extends ExtendableMessageNano<LinkMicStartReq> {
    private static volatile LinkMicStartReq[] _emptyArray;
    public long linMicStartUid;
    public int linkMicMediaType;
    public int linkMicType;
    public long[] linkMicUid;
    public int mode;

    public LinkMicStartReq() {
        clear();
    }

    public static LinkMicStartReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicStartReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicStartReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicStartReq) MessageNano.mergeFrom(new LinkMicStartReq(), bArr);
    }

    public LinkMicStartReq clear() {
        this.linMicStartUid = 0L;
        this.linkMicType = 0;
        this.linkMicUid = WireFormatNano.EMPTY_LONG_ARRAY;
        this.mode = 0;
        this.linkMicMediaType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.linMicStartUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.linkMicType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long[] jArr2 = this.linkMicUid;
        if (jArr2 != null && jArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                jArr = this.linkMicUid;
                if (i16 >= jArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (jArr.length * 1);
        }
        int i18 = this.mode;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.linkMicMediaType;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.linMicStartUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.linkMicType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long[] jArr = this.linkMicUid;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.linkMicUid;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i16]);
                i16++;
            }
        }
        int i17 = this.mode;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.linkMicMediaType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicStartReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicStartReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicStartReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.linMicStartUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.linkMicType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                long[] jArr = this.linkMicUid;
                int length = jArr == null ? 0 : jArr.length;
                int i3 = repeatedFieldArrayLength + length;
                long[] jArr2 = new long[i3];
                if (length != 0) {
                    System.arraycopy(jArr, 0, jArr2, 0, length);
                }
                while (length < i3 - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.linkMicUid = jArr2;
            } else if (readTag == 26) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.linkMicUid;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                int i17 = i16 + length2;
                long[] jArr4 = new long[i17];
                if (length2 != 0) {
                    System.arraycopy(jArr3, 0, jArr4, 0, length2);
                }
                while (length2 < i17) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.linkMicUid = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 32) {
                this.mode = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.linkMicMediaType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
