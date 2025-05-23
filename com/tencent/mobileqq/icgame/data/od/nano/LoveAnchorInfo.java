package com.tencent.mobileqq.icgame.data.od.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LoveAnchorInfo extends ExtendableMessageNano<LoveAnchorInfo> {
    private static volatile LoveAnchorInfo[] _emptyArray;
    public long anchorUid;
    public byte[] announcement;
    public byte[] announcementTitle;
    public byte[] city;
    public byte[] coverUrl;
    public byte[] lat;
    public byte[] lng;
    public byte[] roomTag;
    public byte[] topic;

    public LoveAnchorInfo() {
        clear();
    }

    public static LoveAnchorInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LoveAnchorInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LoveAnchorInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LoveAnchorInfo) MessageNano.mergeFrom(new LoveAnchorInfo(), bArr);
    }

    public LoveAnchorInfo clear() {
        this.anchorUid = 0L;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.coverUrl = bArr;
        this.roomTag = bArr;
        this.topic = bArr;
        this.lng = bArr;
        this.lat = bArr;
        this.city = bArr;
        this.announcement = bArr;
        this.announcementTitle = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        byte[] bArr = this.coverUrl;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.coverUrl);
        }
        if (!Arrays.equals(this.roomTag, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.roomTag);
        }
        if (!Arrays.equals(this.topic, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.topic);
        }
        if (!Arrays.equals(this.lng, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.lng);
        }
        if (!Arrays.equals(this.lat, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.lat);
        }
        if (!Arrays.equals(this.city, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.city);
        }
        if (!Arrays.equals(this.announcement, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.announcement);
        }
        if (!Arrays.equals(this.announcementTitle, bArr2)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(9, this.announcementTitle);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        byte[] bArr = this.coverUrl;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.coverUrl);
        }
        if (!Arrays.equals(this.roomTag, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.roomTag);
        }
        if (!Arrays.equals(this.topic, bArr2)) {
            codedOutputByteBufferNano.writeBytes(4, this.topic);
        }
        if (!Arrays.equals(this.lng, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.lng);
        }
        if (!Arrays.equals(this.lat, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.lat);
        }
        if (!Arrays.equals(this.city, bArr2)) {
            codedOutputByteBufferNano.writeBytes(7, this.city);
        }
        if (!Arrays.equals(this.announcement, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.announcement);
        }
        if (!Arrays.equals(this.announcementTitle, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.announcementTitle);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LoveAnchorInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LoveAnchorInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LoveAnchorInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.coverUrl = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                this.roomTag = codedInputByteBufferNano.readBytes();
            } else if (readTag == 34) {
                this.topic = codedInputByteBufferNano.readBytes();
            } else if (readTag == 42) {
                this.lng = codedInputByteBufferNano.readBytes();
            } else if (readTag == 50) {
                this.lat = codedInputByteBufferNano.readBytes();
            } else if (readTag == 58) {
                this.city = codedInputByteBufferNano.readBytes();
            } else if (readTag == 66) {
                this.announcement = codedInputByteBufferNano.readBytes();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.announcementTitle = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
