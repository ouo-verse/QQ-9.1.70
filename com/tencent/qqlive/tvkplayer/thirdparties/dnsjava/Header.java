package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Header implements Cloneable {
    public static final int LENGTH = 12;
    private static final Random random = new SecureRandom();
    private int[] counts;
    private int flags;

    /* renamed from: id, reason: collision with root package name */
    private int f345848id;

    public Header(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            this.counts = new int[4];
            this.flags = 0;
            this.f345848id = i3;
        } else {
            throw new IllegalArgumentException("DNS message ID " + i3 + " is out of range");
        }
    }

    private static void checkFlag(int i3) {
        if (validFlag(i3)) {
            return;
        }
        throw new IllegalArgumentException("invalid flag bit " + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setFlag(int i3, int i16, boolean z16) {
        checkFlag(i16);
        return z16 ? i3 | (1 << (15 - i16)) : i3 & (~(1 << (15 - i16)));
    }

    private static boolean validFlag(int i3) {
        if (i3 >= 0 && i3 <= 15 && Flags.isFlag(i3)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decCount(int i3) {
        int[] iArr = this.counts;
        int i16 = iArr[i3];
        if (i16 != 0) {
            iArr[i3] = i16 - 1;
            return;
        }
        throw new IllegalStateException("DNS section count cannot be decremented");
    }

    public int getCount(int i3) {
        return this.counts[i3];
    }

    public boolean getFlag(int i3) {
        checkFlag(i3);
        if (((1 << (15 - i3)) & this.flags) != 0) {
            return true;
        }
        return false;
    }

    boolean[] getFlags() {
        boolean[] zArr = new boolean[16];
        for (int i3 = 0; i3 < 16; i3++) {
            if (validFlag(i3)) {
                zArr[i3] = getFlag(i3);
            }
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFlagsByte() {
        return this.flags;
    }

    public int getID() {
        return this.f345848id;
    }

    public int getOpcode() {
        return (this.flags >> 11) & 15;
    }

    public int getRcode() {
        return this.flags & 15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void incCount(int i3) {
        int[] iArr = this.counts;
        int i16 = iArr[i3];
        if (i16 != 65535) {
            iArr[i3] = i16 + 1;
            return;
        }
        throw new IllegalStateException("DNS section count cannot be incremented");
    }

    public String printFlags() {
        StringBuilder sb5 = new StringBuilder();
        printFlags(sb5);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCount(int i3, int i16) {
        if (i16 >= 0 && i16 <= 65535) {
            this.counts[i3] = i16;
            return;
        }
        throw new IllegalArgumentException("DNS section count " + i16 + " is out of range");
    }

    public void setID(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            this.f345848id = i3;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i3 + " is out of range");
    }

    public void setOpcode(int i3) {
        if (i3 >= 0 && i3 <= 15) {
            this.flags = (i3 << 11) | (this.flags & 34815);
        } else {
            throw new IllegalArgumentException("DNS Opcode " + i3 + "is out of range");
        }
    }

    public void setRcode(int i3) {
        if (i3 >= 0 && i3 <= 15) {
            this.flags = i3 | (this.flags & (-16));
            return;
        }
        throw new IllegalArgumentException("DNS Rcode " + i3 + " is out of range");
    }

    public String toString() {
        return toStringWithRcode(getRcode());
    }

    String toStringWithRcode(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(";; ->>HEADER<<- ");
        sb5.append("opcode: ");
        sb5.append(Opcode.string(getOpcode()));
        sb5.append(", status: ");
        sb5.append(Rcode.string(i3));
        sb5.append(", id: ");
        sb5.append(getID());
        sb5.append("\n");
        sb5.append(";; flags: ");
        printFlags(sb5);
        sb5.append("; ");
        for (int i16 = 0; i16 < 4; i16++) {
            sb5.append(Section.string(i16));
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(getCount(i16));
            sb5.append(" ");
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void toWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(getID());
        dNSOutput.writeU16(this.flags);
        for (int i3 : this.counts) {
            dNSOutput.writeU16(i3);
        }
    }

    public void unsetFlag(int i3) {
        checkFlag(i3);
        this.flags = setFlag(this.flags, i3, false);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Header m240clone() throws CloneNotSupportedException {
        Header header = (Header) super.clone();
        header.f345848id = this.f345848id;
        header.flags = this.flags;
        int[] iArr = new int[header.counts.length];
        header.counts = iArr;
        int[] iArr2 = this.counts;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        return header;
    }

    public void setFlag(int i3) {
        checkFlag(i3);
        this.flags = setFlag(this.flags, i3, true);
    }

    private void printFlags(StringBuilder sb5) {
        for (int i3 = 0; i3 < 16; i3++) {
            if (validFlag(i3) && getFlag(i3)) {
                sb5.append(Flags.string(i3));
                sb5.append(" ");
            }
        }
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public Header() {
        this(random.nextInt(65535));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Header(DNSInput dNSInput) throws IOException {
        this(dNSInput.readU16());
        this.flags = dNSInput.readU16();
        int i3 = 0;
        while (true) {
            int[] iArr = this.counts;
            if (i3 >= iArr.length) {
                return;
            }
            iArr[i3] = dNSInput.readU16();
            i3++;
        }
    }

    public Header(byte[] bArr) throws IOException {
        this(new DNSInput(bArr));
    }
}
