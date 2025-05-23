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
public final class QueryUidByQQReq extends ExtendableMessageNano<QueryUidByQQReq> {
    private static volatile QueryUidByQQReq[] _emptyArray;
    public int buzId;

    /* renamed from: qq, reason: collision with root package name */
    public long[] f237289qq;
    public int type;

    public QueryUidByQQReq() {
        clear();
    }

    public static QueryUidByQQReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryUidByQQReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryUidByQQReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryUidByQQReq) MessageNano.mergeFrom(new QueryUidByQQReq(), bArr);
    }

    public QueryUidByQQReq clear() {
        this.buzId = 0;
        this.f237289qq = WireFormatNano.EMPTY_LONG_ARRAY;
        this.type = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.buzId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long[] jArr2 = this.f237289qq;
        if (jArr2 != null && jArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                jArr = this.f237289qq;
                if (i16 >= jArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (jArr.length * 1);
        }
        int i18 = this.type;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.buzId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long[] jArr = this.f237289qq;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.f237289qq;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(2, jArr2[i16]);
                i16++;
            }
        }
        int i17 = this.type;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryUidByQQReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryUidByQQReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryUidByQQReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.buzId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                long[] jArr = this.f237289qq;
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
                this.f237289qq = jArr2;
            } else if (readTag == 18) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.f237289qq;
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
                this.f237289qq = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.type = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
