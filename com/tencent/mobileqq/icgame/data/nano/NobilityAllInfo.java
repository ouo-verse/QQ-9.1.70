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
public final class NobilityAllInfo extends ExtendableMessageNano<NobilityAllInfo> {
    private static volatile NobilityAllInfo[] _emptyArray;
    public long contribution;
    public long expireTime;
    public int isEffective;
    public int jacketFlag;
    public long[] jacketTime;
    public int level;
    public String name;
    public NobilityResources resources;
    public int score;
    public int type;
    public long uid;
    public int yellowJacketCount;

    public NobilityAllInfo() {
        clear();
    }

    public static NobilityAllInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new NobilityAllInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static NobilityAllInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (NobilityAllInfo) MessageNano.mergeFrom(new NobilityAllInfo(), bArr);
    }

    public NobilityAllInfo clear() {
        this.level = 0;
        this.uid = 0L;
        this.expireTime = 0L;
        this.type = 0;
        this.name = "";
        this.score = 0;
        this.resources = null;
        this.yellowJacketCount = 0;
        this.isEffective = 0;
        this.jacketTime = WireFormatNano.EMPTY_LONG_ARRAY;
        this.contribution = 0L;
        this.jacketFlag = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.level) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid);
        long j3 = this.expireTime;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.name);
        }
        int i16 = this.score;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        NobilityResources nobilityResources = this.resources;
        if (nobilityResources != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, nobilityResources);
        }
        int i17 = this.yellowJacketCount;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        int i18 = this.isEffective;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i18);
        }
        long[] jArr2 = this.jacketTime;
        if (jArr2 != null && jArr2.length > 0) {
            int i19 = 0;
            int i26 = 0;
            while (true) {
                jArr = this.jacketTime;
                if (i19 >= jArr.length) {
                    break;
                }
                i26 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i19]);
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (jArr.length * 1);
        }
        long j16 = this.contribution;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j16);
        }
        int i27 = this.jacketFlag;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(12, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.level);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        long j3 = this.expireTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.name);
        }
        int i16 = this.score;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        NobilityResources nobilityResources = this.resources;
        if (nobilityResources != null) {
            codedOutputByteBufferNano.writeMessage(7, nobilityResources);
        }
        int i17 = this.yellowJacketCount;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        int i18 = this.isEffective;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i18);
        }
        long[] jArr = this.jacketTime;
        if (jArr != null && jArr.length > 0) {
            int i19 = 0;
            while (true) {
                long[] jArr2 = this.jacketTime;
                if (i19 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(10, jArr2[i19]);
                i19++;
            }
        }
        long j16 = this.contribution;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j16);
        }
        int i26 = this.jacketFlag;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static NobilityAllInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new NobilityAllInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public NobilityAllInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.level = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.expireTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.type = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.name = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.score = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    if (this.resources == null) {
                        this.resources = new NobilityResources();
                    }
                    codedInputByteBufferNano.readMessage(this.resources);
                    break;
                case 64:
                    this.yellowJacketCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.isEffective = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                    long[] jArr = this.jacketTime;
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
                    this.jacketTime = jArr2;
                    break;
                case 82:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.jacketTime;
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
                    this.jacketTime = jArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 88:
                    this.contribution = codedInputByteBufferNano.readUInt64();
                    break;
                case 96:
                    this.jacketFlag = codedInputByteBufferNano.readUInt32();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
