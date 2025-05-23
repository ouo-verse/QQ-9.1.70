package dn0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f394286a;

    /* renamed from: b, reason: collision with root package name */
    public long f394287b;

    /* renamed from: c, reason: collision with root package name */
    public long f394288c;

    /* renamed from: d, reason: collision with root package name */
    public int f394289d;

    /* renamed from: e, reason: collision with root package name */
    public int f394290e;

    /* renamed from: f, reason: collision with root package name */
    public long f394291f;

    /* renamed from: g, reason: collision with root package name */
    public int f394292g;

    /* renamed from: h, reason: collision with root package name */
    public int f394293h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f394294i = false;

    /* renamed from: j, reason: collision with root package name */
    public cn0.a[] f394295j;

    public a() {
        a();
    }

    public a a() {
        this.f394286a = 0;
        this.f394287b = 0L;
        this.f394288c = 0L;
        this.f394289d = 0;
        this.f394290e = 0;
        this.f394291f = 0L;
        this.f394292g = 0;
        this.f394293h = 0;
        this.f394295j = cn0.a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (readTag != 64) {
                                                if (readTag != 74) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                                                    cn0.a[] aVarArr = this.f394295j;
                                                    if (aVarArr == null) {
                                                        length = 0;
                                                    } else {
                                                        length = aVarArr.length;
                                                    }
                                                    int i3 = repeatedFieldArrayLength + length;
                                                    cn0.a[] aVarArr2 = new cn0.a[i3];
                                                    if (length != 0) {
                                                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                                                    }
                                                    while (length < i3 - 1) {
                                                        cn0.a aVar = new cn0.a();
                                                        aVarArr2[length] = aVar;
                                                        codedInputByteBufferNano.readMessage(aVar);
                                                        codedInputByteBufferNano.readTag();
                                                        length++;
                                                    }
                                                    cn0.a aVar2 = new cn0.a();
                                                    aVarArr2[length] = aVar2;
                                                    codedInputByteBufferNano.readMessage(aVar2);
                                                    this.f394295j = aVarArr2;
                                                }
                                            } else {
                                                this.f394293h = codedInputByteBufferNano.readUInt32();
                                            }
                                        } else {
                                            this.f394292g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f394291f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f394290e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f394289d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f394288c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f394287b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f394286a = codedInputByteBufferNano.readUInt32();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f394286a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.f394287b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f394288c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        int i16 = this.f394289d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f394290e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        long j17 = this.f394291f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        int i18 = this.f394292g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        int i19 = this.f394293h;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i19);
        }
        cn0.a[] aVarArr = this.f394295j;
        if (aVarArr != null && aVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                cn0.a[] aVarArr2 = this.f394295j;
                if (i26 >= aVarArr2.length) {
                    break;
                }
                cn0.a aVar = aVarArr2[i26];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, aVar);
                }
                i26++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f394286a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.f394287b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f394288c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        int i16 = this.f394289d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f394290e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        long j17 = this.f394291f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        int i18 = this.f394292g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        int i19 = this.f394293h;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i19);
        }
        cn0.a[] aVarArr = this.f394295j;
        if (aVarArr != null && aVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                cn0.a[] aVarArr2 = this.f394295j;
                if (i26 >= aVarArr2.length) {
                    break;
                }
                cn0.a aVar = aVarArr2[i26];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, aVar);
                }
                i26++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
