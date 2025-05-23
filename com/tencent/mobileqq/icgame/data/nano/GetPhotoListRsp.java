package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetPhotoListRsp extends ExtendableMessageNano<GetPhotoListRsp> {
    private static volatile GetPhotoListRsp[] _emptyArray;
    public Album[] albums;

    public GetPhotoListRsp() {
        clear();
    }

    public static GetPhotoListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetPhotoListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetPhotoListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetPhotoListRsp) MessageNano.mergeFrom(new GetPhotoListRsp(), bArr);
    }

    public GetPhotoListRsp clear() {
        this.albums = Album.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Album[] albumArr = this.albums;
        if (albumArr != null && albumArr.length > 0) {
            int i3 = 0;
            while (true) {
                Album[] albumArr2 = this.albums;
                if (i3 >= albumArr2.length) {
                    break;
                }
                Album album = albumArr2[i3];
                if (album != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, album);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Album[] albumArr = this.albums;
        if (albumArr != null && albumArr.length > 0) {
            int i3 = 0;
            while (true) {
                Album[] albumArr2 = this.albums;
                if (i3 >= albumArr2.length) {
                    break;
                }
                Album album = albumArr2[i3];
                if (album != null) {
                    codedOutputByteBufferNano.writeMessage(1, album);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetPhotoListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetPhotoListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetPhotoListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Album[] albumArr = this.albums;
                int length = albumArr == null ? 0 : albumArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Album[] albumArr2 = new Album[i3];
                if (length != 0) {
                    System.arraycopy(albumArr, 0, albumArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Album album = new Album();
                    albumArr2[length] = album;
                    codedInputByteBufferNano.readMessage(album);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Album album2 = new Album();
                albumArr2[length] = album2;
                codedInputByteBufferNano.readMessage(album2);
                this.albums = albumArr2;
            }
        }
    }
}
