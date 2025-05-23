package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public ag[] f400790a;

    public m() {
        a();
    }

    public m a() {
        this.f400790a = ag.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    ag[] agVarArr = this.f400790a;
                    if (agVarArr == null) {
                        length = 0;
                    } else {
                        length = agVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    ag[] agVarArr2 = new ag[i3];
                    if (length != 0) {
                        System.arraycopy(agVarArr, 0, agVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        ag agVar = new ag();
                        agVarArr2[length] = agVar;
                        codedInputByteBufferNano.readMessage(agVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ag agVar2 = new ag();
                    agVarArr2[length] = agVar2;
                    codedInputByteBufferNano.readMessage(agVar2);
                    this.f400790a = agVarArr2;
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
        ag[] agVarArr = this.f400790a;
        if (agVarArr != null && agVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ag[] agVarArr2 = this.f400790a;
                if (i3 >= agVarArr2.length) {
                    break;
                }
                ag agVar = agVarArr2[i3];
                if (agVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, agVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ag[] agVarArr = this.f400790a;
        if (agVarArr != null && agVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ag[] agVarArr2 = this.f400790a;
                if (i3 >= agVarArr2.length) {
                    break;
                }
                ag agVar = agVarArr2[i3];
                if (agVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, agVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
