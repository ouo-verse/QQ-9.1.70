package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.util.ByteBufferUtils;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class FramedataImpl1 implements Framedata {
    private Opcode optcode;
    private ByteBuffer unmaskedpayload = ByteBufferUtils.getEmptyByteBuffer();
    private boolean fin = true;
    private boolean transferemasked = false;
    private boolean rsv1 = false;
    private boolean rsv2 = false;
    private boolean rsv3 = false;

    /* compiled from: P */
    /* renamed from: org.java_websocket.framing.FramedataImpl1$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$java_websocket$enums$Opcode;

        static {
            int[] iArr = new int[Opcode.values().length];
            $SwitchMap$org$java_websocket$enums$Opcode = iArr;
            try {
                iArr[Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$java_websocket$enums$Opcode[Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$java_websocket$enums$Opcode[Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$java_websocket$enums$Opcode[Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$java_websocket$enums$Opcode[Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$java_websocket$enums$Opcode[Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public FramedataImpl1(Opcode opcode) {
        this.optcode = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public void append(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        if (this.unmaskedpayload == null) {
            this.unmaskedpayload = ByteBuffer.allocate(payloadData.remaining());
            payloadData.mark();
            this.unmaskedpayload.put(payloadData);
            payloadData.reset();
        } else {
            payloadData.mark();
            ByteBuffer byteBuffer = this.unmaskedpayload;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.unmaskedpayload;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (payloadData.remaining() > this.unmaskedpayload.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(payloadData.remaining() + this.unmaskedpayload.capacity());
                this.unmaskedpayload.flip();
                allocate.put(this.unmaskedpayload);
                allocate.put(payloadData);
                this.unmaskedpayload = allocate;
            } else {
                this.unmaskedpayload.put(payloadData);
            }
            this.unmaskedpayload.rewind();
            payloadData.reset();
        }
        this.fin = framedata.isFin();
    }

    @Override // org.java_websocket.framing.Framedata
    public Opcode getOpcode() {
        return this.optcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer getPayloadData() {
        return this.unmaskedpayload;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean getTransfereMasked() {
        return this.transferemasked;
    }

    public int hashCode() {
        int hashCode = (((this.fin ? 1 : 0) * 31) + this.optcode.hashCode()) * 31;
        ByteBuffer byteBuffer = this.unmaskedpayload;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.transferemasked ? 1 : 0)) * 31) + (this.rsv1 ? 1 : 0)) * 31) + (this.rsv2 ? 1 : 0)) * 31) + (this.rsv3 ? 1 : 0);
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean isFin() {
        return this.fin;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean isRSV1() {
        return this.rsv1;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean isRSV2() {
        return this.rsv2;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean isRSV3() {
        return this.rsv3;
    }

    public abstract void isValid() throws InvalidDataException;

    public void setFin(boolean z16) {
        this.fin = z16;
    }

    public void setPayload(ByteBuffer byteBuffer) {
        this.unmaskedpayload = byteBuffer;
    }

    public void setRSV1(boolean z16) {
        this.rsv1 = z16;
    }

    public void setRSV2(boolean z16) {
        this.rsv2 = z16;
    }

    public void setRSV3(boolean z16) {
        this.rsv3 = z16;
    }

    public void setTransferemasked(boolean z16) {
        this.transferemasked = z16;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Framedata{ optcode:");
        sb5.append(getOpcode());
        sb5.append(", fin:");
        sb5.append(isFin());
        sb5.append(", rsv1:");
        sb5.append(isRSV1());
        sb5.append(", rsv2:");
        sb5.append(isRSV2());
        sb5.append(", rsv3:");
        sb5.append(isRSV3());
        sb5.append(", payloadlength:[pos:");
        sb5.append(this.unmaskedpayload.position());
        sb5.append(", len:");
        sb5.append(this.unmaskedpayload.remaining());
        sb5.append("], payload:");
        if (this.unmaskedpayload.remaining() > 1000) {
            str = "(too big to display)";
        } else {
            str = new String(this.unmaskedpayload.array());
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }

    public static FramedataImpl1 get(Opcode opcode) {
        if (opcode != null) {
            switch (AnonymousClass1.$SwitchMap$org$java_websocket$enums$Opcode[opcode.ordinal()]) {
                case 1:
                    return new PingFrame();
                case 2:
                    return new PongFrame();
                case 3:
                    return new TextFrame();
                case 4:
                    return new BinaryFrame();
                case 5:
                    return new CloseFrame();
                case 6:
                    return new ContinuousFrame();
                default:
                    throw new IllegalArgumentException("Supplied opcode is invalid");
            }
        }
        throw new IllegalArgumentException("Supplied opcode cannot be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FramedataImpl1 framedataImpl1 = (FramedataImpl1) obj;
        if (this.fin != framedataImpl1.fin || this.transferemasked != framedataImpl1.transferemasked || this.rsv1 != framedataImpl1.rsv1 || this.rsv2 != framedataImpl1.rsv2 || this.rsv3 != framedataImpl1.rsv3 || this.optcode != framedataImpl1.optcode) {
            return false;
        }
        ByteBuffer byteBuffer = this.unmaskedpayload;
        ByteBuffer byteBuffer2 = framedataImpl1.unmaskedpayload;
        if (byteBuffer != null) {
            return byteBuffer.equals(byteBuffer2);
        }
        return byteBuffer2 == null;
    }
}
