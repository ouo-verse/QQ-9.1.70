package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicList extends ExtendableMessageNano<LinkMicList> {
    private static volatile LinkMicList[] _emptyArray;
    public LinkMicUser[] addList;
    public LinkMicUser[] currentList;
    public LinkMicUser[] delList;
    public String linkMicId;
    public Map<Long, LinkMicLocationInfo> locationInfos;
    public LinkMicLocationInfo locations;
    public long playType;

    /* renamed from: ts, reason: collision with root package name */
    public long f237284ts;

    public LinkMicList() {
        clear();
    }

    public static LinkMicList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicList[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicList) MessageNano.mergeFrom(new LinkMicList(), bArr);
    }

    public LinkMicList clear() {
        this.currentList = LinkMicUser.emptyArray();
        this.addList = LinkMicUser.emptyArray();
        this.delList = LinkMicUser.emptyArray();
        this.f237284ts = 0L;
        this.linkMicId = "";
        this.locations = null;
        this.locationInfos = null;
        this.playType = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LinkMicUser[] linkMicUserArr = this.currentList;
        int i3 = 0;
        if (linkMicUserArr != null && linkMicUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                LinkMicUser[] linkMicUserArr2 = this.currentList;
                if (i16 >= linkMicUserArr2.length) {
                    break;
                }
                LinkMicUser linkMicUser = linkMicUserArr2[i16];
                if (linkMicUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, linkMicUser);
                }
                i16++;
            }
        }
        LinkMicUser[] linkMicUserArr3 = this.addList;
        if (linkMicUserArr3 != null && linkMicUserArr3.length > 0) {
            int i17 = 0;
            while (true) {
                LinkMicUser[] linkMicUserArr4 = this.addList;
                if (i17 >= linkMicUserArr4.length) {
                    break;
                }
                LinkMicUser linkMicUser2 = linkMicUserArr4[i17];
                if (linkMicUser2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, linkMicUser2);
                }
                i17++;
            }
        }
        LinkMicUser[] linkMicUserArr5 = this.delList;
        if (linkMicUserArr5 != null && linkMicUserArr5.length > 0) {
            while (true) {
                LinkMicUser[] linkMicUserArr6 = this.delList;
                if (i3 >= linkMicUserArr6.length) {
                    break;
                }
                LinkMicUser linkMicUser3 = linkMicUserArr6[i3];
                if (linkMicUser3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, linkMicUser3);
                }
                i3++;
            }
        }
        long j3 = this.f237284ts;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j3);
        }
        if (!this.linkMicId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.linkMicId);
        }
        Map<Long, LinkMicLocationInfo> map = this.locationInfos;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 6, 4, 11);
        }
        LinkMicLocationInfo linkMicLocationInfo = this.locations;
        if (linkMicLocationInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, linkMicLocationInfo);
        }
        long j16 = this.playType;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LinkMicUser[] linkMicUserArr = this.currentList;
        int i3 = 0;
        if (linkMicUserArr != null && linkMicUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                LinkMicUser[] linkMicUserArr2 = this.currentList;
                if (i16 >= linkMicUserArr2.length) {
                    break;
                }
                LinkMicUser linkMicUser = linkMicUserArr2[i16];
                if (linkMicUser != null) {
                    codedOutputByteBufferNano.writeMessage(1, linkMicUser);
                }
                i16++;
            }
        }
        LinkMicUser[] linkMicUserArr3 = this.addList;
        if (linkMicUserArr3 != null && linkMicUserArr3.length > 0) {
            int i17 = 0;
            while (true) {
                LinkMicUser[] linkMicUserArr4 = this.addList;
                if (i17 >= linkMicUserArr4.length) {
                    break;
                }
                LinkMicUser linkMicUser2 = linkMicUserArr4[i17];
                if (linkMicUser2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, linkMicUser2);
                }
                i17++;
            }
        }
        LinkMicUser[] linkMicUserArr5 = this.delList;
        if (linkMicUserArr5 != null && linkMicUserArr5.length > 0) {
            while (true) {
                LinkMicUser[] linkMicUserArr6 = this.delList;
                if (i3 >= linkMicUserArr6.length) {
                    break;
                }
                LinkMicUser linkMicUser3 = linkMicUserArr6[i3];
                if (linkMicUser3 != null) {
                    codedOutputByteBufferNano.writeMessage(3, linkMicUser3);
                }
                i3++;
            }
        }
        long j3 = this.f237284ts;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j3);
        }
        if (!this.linkMicId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.linkMicId);
        }
        Map<Long, LinkMicLocationInfo> map = this.locationInfos;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 6, 4, 11);
        }
        LinkMicLocationInfo linkMicLocationInfo = this.locations;
        if (linkMicLocationInfo != null) {
            codedOutputByteBufferNano.writeMessage(7, linkMicLocationInfo);
        }
        long j16 = this.playType;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicList().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LinkMicUser[] linkMicUserArr = this.currentList;
                int length = linkMicUserArr == null ? 0 : linkMicUserArr.length;
                int i3 = repeatedFieldArrayLength + length;
                LinkMicUser[] linkMicUserArr2 = new LinkMicUser[i3];
                if (length != 0) {
                    System.arraycopy(linkMicUserArr, 0, linkMicUserArr2, 0, length);
                }
                while (length < i3 - 1) {
                    LinkMicUser linkMicUser = new LinkMicUser();
                    linkMicUserArr2[length] = linkMicUser;
                    codedInputByteBufferNano.readMessage(linkMicUser);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                LinkMicUser linkMicUser2 = new LinkMicUser();
                linkMicUserArr2[length] = linkMicUser2;
                codedInputByteBufferNano.readMessage(linkMicUser2);
                this.currentList = linkMicUserArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                LinkMicUser[] linkMicUserArr3 = this.addList;
                int length2 = linkMicUserArr3 == null ? 0 : linkMicUserArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                LinkMicUser[] linkMicUserArr4 = new LinkMicUser[i16];
                if (length2 != 0) {
                    System.arraycopy(linkMicUserArr3, 0, linkMicUserArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    LinkMicUser linkMicUser3 = new LinkMicUser();
                    linkMicUserArr4[length2] = linkMicUser3;
                    codedInputByteBufferNano.readMessage(linkMicUser3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                LinkMicUser linkMicUser4 = new LinkMicUser();
                linkMicUserArr4[length2] = linkMicUser4;
                codedInputByteBufferNano.readMessage(linkMicUser4);
                this.addList = linkMicUserArr4;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LinkMicUser[] linkMicUserArr5 = this.delList;
                int length3 = linkMicUserArr5 == null ? 0 : linkMicUserArr5.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                LinkMicUser[] linkMicUserArr6 = new LinkMicUser[i17];
                if (length3 != 0) {
                    System.arraycopy(linkMicUserArr5, 0, linkMicUserArr6, 0, length3);
                }
                while (length3 < i17 - 1) {
                    LinkMicUser linkMicUser5 = new LinkMicUser();
                    linkMicUserArr6[length3] = linkMicUser5;
                    codedInputByteBufferNano.readMessage(linkMicUser5);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                LinkMicUser linkMicUser6 = new LinkMicUser();
                linkMicUserArr6[length3] = linkMicUser6;
                codedInputByteBufferNano.readMessage(linkMicUser6);
                this.delList = linkMicUserArr6;
            } else if (readTag == 32) {
                this.f237284ts = codedInputByteBufferNano.readInt64();
            } else if (readTag == 42) {
                this.linkMicId = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.locationInfos = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.locationInfos, mapFactory, 4, 11, new LinkMicLocationInfo(), 8, 18);
            } else if (readTag == 58) {
                if (this.locations == null) {
                    this.locations = new LinkMicLocationInfo();
                }
                codedInputByteBufferNano.readMessage(this.locations);
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.playType = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
