package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.NameTooLongException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.TextParseException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.WireParseException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class Name implements Comparable<Name>, Serializable {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 63;
    private static final int MAXNAME = 255;
    private static final int MAXOFFSETS = 9;
    public static final Name empty;
    public static final Name root;
    private static final long serialVersionUID = -6036624806201621219L;
    private static final Name wild;
    private transient int hashcode;
    private int labels;
    private byte[] name;
    private long offsets;
    private static final byte[] emptyLabel = {0};
    private static final byte[] wildLabel = {1, 42};
    private static final byte[] lowercase = new byte[256];

    static {
        int i3 = 0;
        while (true) {
            byte[] bArr = lowercase;
            if (i3 < bArr.length) {
                if (i3 >= 65 && i3 <= 90) {
                    bArr[i3] = (byte) ((i3 - 65) + 97);
                } else {
                    bArr[i3] = (byte) i3;
                }
                i3++;
            } else {
                Name name = new Name();
                root = name;
                name.name = emptyLabel;
                name.labels = 1;
                Name name2 = new Name();
                empty = name2;
                name2.name = new byte[0];
                Name name3 = new Name();
                wild = name3;
                name3.name = wildLabel;
                name3.labels = 1;
                return;
            }
        }
    }

    Name() {
    }

    private void append(byte[] bArr, int i3, int i16) throws NameTooLongException {
        byte[] bArr2;
        byte[] bArr3 = this.name;
        int length = bArr3 == null ? 0 : bArr3.length;
        int i17 = i3;
        int i18 = 0;
        for (int i19 = 0; i19 < i16; i19++) {
            int i26 = bArr[i17] + 1;
            i17 += i26;
            i18 += i26;
        }
        int i27 = length + i18;
        if (i27 <= 255) {
            byte[] bArr4 = this.name;
            if (bArr4 != null) {
                bArr2 = Arrays.copyOf(bArr4, i27);
            } else {
                bArr2 = new byte[i27];
            }
            System.arraycopy(bArr, i3, bArr2, length, i18);
            this.name = bArr2;
            for (int i28 = 0; i28 < i16 && i28 < 9; i28++) {
                setOffset(this.labels + i28, length);
                length += bArr2[length] + 1;
            }
            this.labels += i16;
            return;
        }
        throw new NameTooLongException();
    }

    private void appendFromString(String str, char[] cArr, int i3) throws TextParseException {
        try {
            append(cArr, i3);
        } catch (NameTooLongException e16) {
            throw new TextParseException(str, "Name too long", e16);
        }
    }

    private String byteString(byte[] bArr, int i3) {
        StringBuilder sb5 = new StringBuilder();
        int i16 = i3 + 1;
        int i17 = bArr[i3];
        for (int i18 = i16; i18 < i16 + i17; i18++) {
            int i19 = bArr[i18] & 255;
            if (i19 > 32 && i19 < 127) {
                if (i19 != 34 && i19 != 40 && i19 != 41 && i19 != 46 && i19 != 59 && i19 != 92 && i19 != 64 && i19 != 36) {
                    sb5.append((char) i19);
                } else {
                    sb5.append('\\');
                    sb5.append((char) i19);
                }
            } else {
                sb5.append('\\');
                if (i19 < 10) {
                    sb5.append("00");
                } else if (i19 < 100) {
                    sb5.append('0');
                }
                sb5.append(i19);
            }
        }
        return sb5.toString();
    }

    public static Name concatenate(Name name, Name name2) throws NameTooLongException {
        if (name.isAbsolute()) {
            return name;
        }
        Name name3 = new Name();
        name3.append(name.name, 0, name.labels);
        name3.append(name2.name, 0, name2.labels);
        return name3;
    }

    private static void copy(Name name, Name name2) {
        name2.name = name.name;
        name2.offsets = name.offsets;
        name2.labels = name.labels;
    }

    private boolean equals(byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < this.labels; i17++) {
            byte b16 = this.name[i16];
            if (b16 != bArr[i3]) {
                return false;
            }
            i16++;
            i3++;
            int i18 = 0;
            while (i18 < b16) {
                byte[] bArr2 = lowercase;
                int i19 = i16 + 1;
                int i26 = i3 + 1;
                if (bArr2[this.name[i16] & 255] != bArr2[bArr[i3] & 255]) {
                    return false;
                }
                i18++;
                i3 = i26;
                i16 = i19;
            }
        }
        return true;
    }

    public static Name fromConstantString(String str) {
        try {
            return fromString(str, null);
        } catch (TextParseException unused) {
            throw new IllegalArgumentException("Invalid name '" + str + "'");
        }
    }

    public static Name fromString(String str, Name name) throws TextParseException {
        if (str.equals("@")) {
            return name != null ? name : empty;
        }
        if (str.equals(".")) {
            return root;
        }
        return new Name(str, name);
    }

    private int offset(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 >= 1 && i3 < this.labels) {
            if (i3 < 9) {
                return ((int) (this.offsets >>> ((i3 - 1) * 8))) & 255;
            }
            int i16 = ((int) (this.offsets >>> 56)) & 255;
            for (int i17 = 8; i17 < i3; i17++) {
                i16 += this.name[i16] + 1;
            }
            return i16;
        }
        throw new IllegalArgumentException("label out of range");
    }

    private int prepareAppend(int i3) throws NameTooLongException {
        int length;
        byte[] bArr;
        byte[] bArr2 = this.name;
        if (bArr2 == null) {
            length = 0;
        } else {
            length = bArr2.length;
        }
        int i16 = length + 1;
        int i17 = i16 + i3;
        if (i17 <= 255) {
            if (bArr2 != null) {
                bArr = Arrays.copyOf(bArr2, i17);
            } else {
                bArr = new byte[i17];
            }
            bArr[length] = (byte) i3;
            this.name = bArr;
            setOffset(this.labels, length);
            this.labels++;
            return i16;
        }
        throw new NameTooLongException();
    }

    private void setOffset(int i3, int i16) {
        if (i3 != 0 && i3 < 9) {
            int i17 = (i3 - 1) * 8;
            this.offsets = (i16 << i17) | (this.offsets & (~(255 << i17)));
        }
    }

    public Name canonicalize() {
        boolean z16;
        byte[] bArr = this.name;
        int length = bArr.length;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                byte b16 = bArr[i16];
                if (lowercase[b16 & 255] != b16) {
                    z16 = false;
                    break;
                }
                i16++;
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            return this;
        }
        Name name = new Name();
        name.offsets = this.offsets;
        name.labels = this.labels;
        name.name = new byte[length()];
        while (true) {
            byte[] bArr2 = name.name;
            if (i3 < bArr2.length) {
                bArr2[i3] = lowercase[this.name[i3] & 255];
                i3++;
            } else {
                return name;
            }
        }
    }

    public Name fromDNAME(DNAMERecord dNAMERecord) throws NameTooLongException {
        Name name = dNAMERecord.getName();
        Name target = dNAMERecord.getTarget();
        if (!subdomain(name)) {
            return null;
        }
        int i3 = this.labels - name.labels;
        int length = length() - name.length();
        int i16 = target.labels;
        short length2 = target.length();
        int i17 = length + length2;
        if (i17 <= 255) {
            Name name2 = new Name();
            int i18 = i3 + i16;
            name2.labels = i18;
            byte[] copyOf = Arrays.copyOf(this.name, i17);
            name2.name = copyOf;
            System.arraycopy(target.name, 0, copyOf, length, length2);
            int i19 = 0;
            for (int i26 = 0; i26 < 9 && i26 < i18; i26++) {
                name2.setOffset(i26, i19);
                i19 += name2.name[i19] + 1;
            }
            return name2;
        }
        throw new NameTooLongException();
    }

    public byte[] getLabel(int i3) {
        int offset = offset(i3);
        byte[] bArr = this.name;
        return Arrays.copyOfRange(bArr, offset, ((byte) (bArr[offset] + 1)) + offset);
    }

    public String getLabelString(int i3) {
        return byteString(this.name, offset(i3));
    }

    public int hashCode() {
        int i3 = this.hashcode;
        if (i3 != 0) {
            return i3;
        }
        int i16 = 0;
        int offset = offset(0);
        while (true) {
            byte[] bArr = this.name;
            if (offset < bArr.length) {
                i16 += (i16 << 3) + (lowercase[bArr[offset] & 255] & 255);
                offset++;
            } else {
                this.hashcode = i16;
                return i16;
            }
        }
    }

    public boolean isAbsolute() {
        int i3 = this.labels;
        if (i3 == 0 || this.name[offset(i3 - 1)] != 0) {
            return false;
        }
        return true;
    }

    public boolean isWild() {
        if (this.labels == 0) {
            return false;
        }
        byte[] bArr = this.name;
        if (bArr[0] != 1 || bArr[1] != 42) {
            return false;
        }
        return true;
    }

    public int labels() {
        return this.labels;
    }

    public short length() {
        if (this.labels == 0) {
            return (short) 0;
        }
        return (short) this.name.length;
    }

    public Name relativize(Name name) {
        if (name != null && subdomain(name)) {
            Name name2 = new Name();
            int length = length() - name.length();
            name2.labels = this.labels - name.labels;
            name2.offsets = this.offsets;
            byte[] bArr = new byte[length];
            name2.name = bArr;
            System.arraycopy(this.name, 0, bArr, 0, length);
            return name2;
        }
        return this;
    }

    public boolean subdomain(Name name) {
        int i3 = name.labels;
        int i16 = this.labels;
        if (i3 > i16) {
            return false;
        }
        if (i3 == i16) {
            return equals(name);
        }
        return name.equals(this.name, offset(i16 - i3));
    }

    public String toString(boolean z16) {
        int i3 = this.labels;
        if (i3 == 0) {
            return "@";
        }
        int i16 = 0;
        if (i3 == 1 && this.name[0] == 0) {
            return ".";
        }
        StringBuilder sb5 = new StringBuilder();
        int i17 = 0;
        while (true) {
            if (i16 >= this.labels) {
                break;
            }
            byte b16 = this.name[i17];
            if (b16 != 0) {
                if (i16 > 0) {
                    sb5.append('.');
                }
                sb5.append(byteString(this.name, i17));
                i17 += b16 + 1;
                i16++;
            } else if (!z16) {
                sb5.append('.');
            }
        }
        return sb5.toString();
    }

    public void toWire(DNSOutput dNSOutput, Compression compression) {
        if (isAbsolute()) {
            int i3 = 0;
            while (i3 < this.labels - 1) {
                Name name = i3 == 0 ? this : new Name(this, i3);
                int i16 = compression != null ? compression.get(name) : -1;
                if (i16 >= 0) {
                    dNSOutput.writeU16(49152 | i16);
                    return;
                }
                if (compression != null) {
                    compression.add(dNSOutput.current(), name);
                }
                int offset = offset(i3);
                byte[] bArr = this.name;
                dNSOutput.writeByteArray(bArr, offset, bArr[offset] + 1);
                i3++;
            }
            dNSOutput.writeU8(0);
            return;
        }
        throw new IllegalArgumentException("toWire() called on non-absolute name");
    }

    public void toWireCanonical(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(toWireCanonical());
    }

    public Name wild(int i3) {
        if (i3 >= 1) {
            try {
                Name name = new Name();
                copy(wild, name);
                name.append(this.name, offset(i3), this.labels - i3);
                return name;
            } catch (NameTooLongException unused) {
                throw new IllegalStateException("Name.wild: concatenate failed");
            }
        }
        throw new IllegalArgumentException("must replace 1 or more labels");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Name(String str, Name name) throws TextParseException {
        char c16;
        boolean z16;
        str.hashCode();
        switch (str.hashCode()) {
            case 0:
                if (str.equals("")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 46:
                if (str.equals(".")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 64:
                if (str.equals("@")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                throw new TextParseException("empty name");
            case 1:
                copy(root, this);
                return;
            case 2:
                if (name == null) {
                    copy(empty, this);
                    return;
                } else {
                    copy(name, this);
                    return;
                }
            default:
                char[] cArr = new char[63];
                int i3 = 0;
                boolean z17 = false;
                int i16 = -1;
                int i17 = 0;
                int i18 = 0;
                for (int i19 = 0; i19 < str.length(); i19++) {
                    char charAt = str.charAt(i19);
                    if (charAt > '\u00ff') {
                        throw new TextParseException(str, "Illegal character in name");
                    }
                    if (z17) {
                        if (charAt >= '0' && charAt <= '9' && i3 < 3) {
                            i3++;
                            i18 = (i18 * 10) + (charAt - '0');
                            if (i18 > 255) {
                                throw new TextParseException(str, "bad escape");
                            }
                            if (i3 >= 3) {
                                charAt = (char) i18;
                            }
                        } else if (i3 > 0 && i3 < 3) {
                            throw new TextParseException(str, "bad escape");
                        }
                        if (i17 < 63) {
                            cArr[i17] = charAt;
                            i16 = i17;
                            z17 = false;
                            i17++;
                        } else {
                            throw new TextParseException(str, "label too long");
                        }
                    } else if (charAt == '\\') {
                        i3 = 0;
                        z17 = true;
                        i18 = 0;
                    } else if (charAt != '.') {
                        i16 = i16 == -1 ? i19 : i16;
                        if (i17 < 63) {
                            cArr[i17] = charAt;
                            i17++;
                        } else {
                            throw new TextParseException(str, "label too long");
                        }
                    } else if (i16 != -1) {
                        appendFromString(str, cArr, i17);
                        i16 = -1;
                        i17 = 0;
                    } else {
                        throw new TextParseException(str, "invalid empty label");
                    }
                }
                if ((i3 <= 0 || i3 >= 3) && !z17) {
                    if (i16 == -1) {
                        z16 = true;
                        appendFromString(str, emptyLabel, 1);
                    } else {
                        appendFromString(str, cArr, i17);
                        z16 = false;
                    }
                    if (name != null && !z16) {
                        z16 = name.isAbsolute();
                        appendFromString(str, name.name, name.labels);
                    }
                    if (!z16 && length() == 255) {
                        throw new TextParseException(str, "Name too long");
                    }
                    return;
                }
                throw new TextParseException(str, "bad escape");
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        if (this == name) {
            return 0;
        }
        int i3 = name.labels;
        int min = Math.min(this.labels, i3);
        for (int i16 = 1; i16 <= min; i16++) {
            int offset = offset(this.labels - i16);
            int offset2 = name.offset(i3 - i16);
            byte b16 = this.name[offset];
            byte b17 = name.name[offset2];
            for (int i17 = 0; i17 < b16 && i17 < b17; i17++) {
                byte[] bArr = lowercase;
                int i18 = (bArr[this.name[(i17 + offset) + 1] & 255] & 255) - (bArr[name.name[(i17 + offset2) + 1] & 255] & 255);
                if (i18 != 0) {
                    return i18;
                }
            }
            if (b16 != b17) {
                return b16 - b17;
            }
        }
        return this.labels - i3;
    }

    private void appendFromString(String str, byte[] bArr, int i3) throws TextParseException {
        try {
            append(bArr, 0, i3);
        } catch (NameTooLongException unused) {
            throw new TextParseException(str, "Name too long");
        }
    }

    public byte[] toWireCanonical() {
        if (this.labels == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.name.length];
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < this.labels; i17++) {
            byte b16 = this.name[i3];
            i3++;
            bArr[i16] = b16;
            i16++;
            int i18 = 0;
            while (i18 < b16) {
                bArr[i16] = lowercase[this.name[i3] & 255];
                i18++;
                i16++;
                i3++;
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        if (name.labels == this.labels && name.hashCode() == hashCode()) {
            return equals(name.name, 0);
        }
        return false;
    }

    public static Name fromString(String str) throws TextParseException {
        return fromString(str, null);
    }

    public String toString() {
        return toString(false);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, null);
        return dNSOutput.toByteArray();
    }

    private void append(char[] cArr, int i3) throws NameTooLongException {
        int prepareAppend = prepareAppend(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            this.name[prepareAppend + i16] = (byte) cArr[i16];
        }
    }

    public void toWire(DNSOutput dNSOutput, Compression compression, boolean z16) {
        if (z16) {
            toWireCanonical(dNSOutput);
        } else {
            toWire(dNSOutput, compression);
        }
    }

    public Name(String str) throws TextParseException {
        this(str, (Name) null);
    }

    public Name(DNSInput dNSInput) throws WireParseException {
        byte[] bArr = new byte[64];
        boolean z16 = false;
        boolean z17 = false;
        while (!z16) {
            int readU8 = dNSInput.readU8();
            int i3 = readU8 & 192;
            if (i3 != 0) {
                if (i3 == 192) {
                    int readU82 = dNSInput.readU8() + ((readU8 & (-193)) << 8);
                    if (readU82 < dNSInput.current() - 2) {
                        if (!z17) {
                            dNSInput.save();
                            z17 = true;
                        }
                        dNSInput.jump(readU82);
                    } else {
                        throw new WireParseException("bad compression");
                    }
                } else {
                    throw new WireParseException("bad label type");
                }
            } else if (readU8 == 0) {
                append(emptyLabel, 0, 1);
                z16 = true;
            } else {
                bArr[0] = (byte) readU8;
                dNSInput.readByteArray(bArr, 1, readU8);
                append(bArr, 0, 1);
            }
        }
        if (z17) {
            dNSInput.restore();
        }
    }

    public Name(byte[] bArr) throws IOException {
        this(new DNSInput(bArr));
    }

    public Name(Name name, int i3) {
        int i16 = name.labels;
        if (i3 > i16) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        if (i3 == i16) {
            copy(empty, this);
            return;
        }
        this.labels = i16 - i3;
        this.name = Arrays.copyOfRange(name.name, name.offset(i3), name.name.length);
        int offset = name.offset(i3);
        for (int i17 = 1; i17 < 9 && i17 < this.labels; i17++) {
            setOffset(i17, name.offset(i17 + i3) - offset);
        }
    }
}
