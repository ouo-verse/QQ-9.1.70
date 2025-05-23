package hq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f405952a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f405953b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f405954c;

    public a() {
        a();
    }

    public a a() {
        this.f405952a = null;
        this.f405953b = WireFormatNano.EMPTY_INT_ARRAY;
        this.f405954c = WireFormatNano.EMPTY_LONG_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:80:0x00d1. Please report as an issue. */
    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        int length4;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 18) {
                            if (readTag != 24) {
                                if (readTag != 26) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                    int position = codedInputByteBufferNano.getPosition();
                                    int i3 = 0;
                                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                        codedInputByteBufferNano.readUInt64();
                                        i3++;
                                    }
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    long[] jArr = this.f405954c;
                                    if (jArr == null) {
                                        length = 0;
                                    } else {
                                        length = jArr.length;
                                    }
                                    int i16 = i3 + length;
                                    long[] jArr2 = new long[i16];
                                    if (length != 0) {
                                        System.arraycopy(jArr, 0, jArr2, 0, length);
                                    }
                                    while (length < i16) {
                                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                                        length++;
                                    }
                                    this.f405954c = jArr2;
                                    codedInputByteBufferNano.popLimit(pushLimit);
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                                long[] jArr3 = this.f405954c;
                                if (jArr3 == null) {
                                    length2 = 0;
                                } else {
                                    length2 = jArr3.length;
                                }
                                int i17 = repeatedFieldArrayLength + length2;
                                long[] jArr4 = new long[i17];
                                if (length2 != 0) {
                                    System.arraycopy(jArr3, 0, jArr4, 0, length2);
                                }
                                while (length2 < i17 - 1) {
                                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                                    codedInputByteBufferNano.readTag();
                                    length2++;
                                }
                                jArr4[length2] = codedInputByteBufferNano.readUInt64();
                                this.f405954c = jArr4;
                            }
                        } else {
                            int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position2 = codedInputByteBufferNano.getPosition();
                            int i18 = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                int readInt32 = codedInputByteBufferNano.readInt32();
                                if (readInt32 != 0 && readInt32 != 1001) {
                                    switch (readInt32) {
                                    }
                                }
                                i18++;
                            }
                            if (i18 != 0) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                int[] iArr = this.f405953b;
                                if (iArr == null) {
                                    length3 = 0;
                                } else {
                                    length3 = iArr.length;
                                }
                                int[] iArr2 = new int[i18 + length3];
                                if (length3 != 0) {
                                    System.arraycopy(iArr, 0, iArr2, 0, length3);
                                }
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    int readInt322 = codedInputByteBufferNano.readInt32();
                                    if (readInt322 != 0 && readInt322 != 1001) {
                                        switch (readInt322) {
                                        }
                                    }
                                    iArr2[length3] = readInt322;
                                    length3++;
                                }
                                this.f405953b = iArr2;
                            }
                            codedInputByteBufferNano.popLimit(pushLimit2);
                        }
                    } else {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                        int[] iArr3 = new int[repeatedFieldArrayLength2];
                        int i19 = 0;
                        for (int i26 = 0; i26 < repeatedFieldArrayLength2; i26++) {
                            if (i26 != 0) {
                                codedInputByteBufferNano.readTag();
                            }
                            int readInt323 = codedInputByteBufferNano.readInt32();
                            if (readInt323 != 0 && readInt323 != 1001) {
                                switch (readInt323) {
                                }
                            }
                            iArr3[i19] = readInt323;
                            i19++;
                        }
                        if (i19 != 0) {
                            int[] iArr4 = this.f405953b;
                            if (iArr4 == null) {
                                length4 = 0;
                            } else {
                                length4 = iArr4.length;
                            }
                            if (length4 == 0 && i19 == repeatedFieldArrayLength2) {
                                this.f405953b = iArr3;
                            } else {
                                int[] iArr5 = new int[length4 + i19];
                                if (length4 != 0) {
                                    System.arraycopy(iArr4, 0, iArr5, 0, length4);
                                }
                                System.arraycopy(iArr3, 0, iArr5, length4, i19);
                                this.f405953b = iArr5;
                            }
                        }
                    }
                } else {
                    if (this.f405952a == null) {
                        this.f405952a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f405952a);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        np4.c cVar = this.f405952a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        int[] iArr2 = this.f405953b;
        int i3 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                iArr = this.f405953b;
                if (i16 >= iArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (iArr.length * 1);
        }
        long[] jArr = this.f405954c;
        if (jArr != null && jArr.length > 0) {
            int i18 = 0;
            while (true) {
                long[] jArr2 = this.f405954c;
                if (i3 < jArr2.length) {
                    i18 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i3]);
                    i3++;
                } else {
                    return computeSerializedSize + i18 + (jArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f405952a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        int[] iArr = this.f405953b;
        int i3 = 0;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f405953b;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(2, iArr2[i16]);
                i16++;
            }
        }
        long[] jArr = this.f405954c;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.f405954c;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
