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
public final class LinkMicUser extends ExtendableMessageNano<LinkMicUser> {
    private static volatile LinkMicUser[] _emptyArray;
    public long linkMicStartTs;
    public long linkMicTs;
    public long mediaType;
    public long muteType;
    public long[] muteUids;
    public long roomid;
    public long uid;
    public long userType;

    public LinkMicUser() {
        clear();
    }

    public static LinkMicUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicUser parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicUser) MessageNano.mergeFrom(new LinkMicUser(), bArr);
    }

    public LinkMicUser clear() {
        this.uid = 0L;
        this.roomid = 0L;
        this.mediaType = 0L;
        this.muteType = 0L;
        this.userType = 0L;
        this.linkMicTs = 0L;
        this.muteUids = WireFormatNano.EMPTY_LONG_ARRAY;
        this.linkMicStartTs = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.roomid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.mediaType;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.muteType;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j18);
        }
        long j19 = this.userType;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j19);
        }
        long j26 = this.linkMicTs;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j26);
        }
        long[] jArr2 = this.muteUids;
        if (jArr2 != null && jArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                jArr = this.muteUids;
                if (i3 >= jArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (jArr.length * 1);
        }
        long j27 = this.linkMicStartTs;
        if (j27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, j27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.roomid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.mediaType;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.muteType;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j18);
        }
        long j19 = this.userType;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j19);
        }
        long j26 = this.linkMicTs;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j26);
        }
        long[] jArr = this.muteUids;
        if (jArr != null && jArr.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr2 = this.muteUids;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(7, jArr2[i3]);
                i3++;
            }
        }
        long j27 = this.linkMicStartTs;
        if (j27 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicUser().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.roomid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.mediaType = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.muteType = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.userType = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.linkMicTs = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 56) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 56);
                long[] jArr = this.muteUids;
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
                this.muteUids = jArr2;
            } else if (readTag == 58) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.muteUids;
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
                this.muteUids = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.linkMicStartTs = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
