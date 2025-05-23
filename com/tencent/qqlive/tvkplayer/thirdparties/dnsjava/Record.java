package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Tokenizer;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.RelativeNameException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.TextParseException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.WireParseException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.utils.base16;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.Supplier;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public abstract class Record implements Cloneable, Comparable<Record>, Serializable {
    private static final DecimalFormat byteFormat;
    protected int dclass;
    protected Name name;
    protected long ttl;
    protected int type;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class RecordSerializationProxy implements Serializable {
        private static final long serialVersionUID = 1434159920070152561L;
        private final boolean isEmpty;
        private final byte[] wireData;

        RecordSerializationProxy(Record record) {
            boolean z16 = record instanceof EmptyRecord;
            this.isEmpty = z16;
            this.wireData = record.toWire(!z16 ? 1 : 0);
        }

        protected Object readResolve() throws ObjectStreamException {
            int i3;
            try {
                byte[] bArr = this.wireData;
                if (this.isEmpty) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                return Record.fromWire(bArr, i3);
            } catch (IOException e16) {
                throw new InvalidObjectException(e16.getMessage());
            }
        }
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Record() {
    }

    protected static byte[] byteArrayFromString(String str) throws TextParseException {
        boolean z16;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (bytes[i3] == 92) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            if (bytes.length <= 255) {
                return bytes;
            }
            throw new TextParseException("text string too long");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i16 = 0;
        boolean z17 = false;
        int i17 = 0;
        for (byte b16 : bytes) {
            if (z17) {
                if (b16 >= 48 && b16 <= 57) {
                    i16++;
                    i17 = (i17 * 10) + (b16 - 48);
                    if (i17 <= 255) {
                        if (i16 >= 3) {
                            b16 = (byte) i17;
                        }
                    } else {
                        throw new TextParseException("bad escape");
                    }
                } else if (i16 > 0) {
                    throw new TextParseException("bad escape");
                }
                byteArrayOutputStream.write(b16);
                z17 = false;
            } else if (b16 == 92) {
                i16 = 0;
                i17 = 0;
                z17 = true;
            } else {
                byteArrayOutputStream.write(b16);
            }
        }
        if (i16 > 0 && i16 < 3) {
            throw new TextParseException("bad escape");
        }
        if (byteArrayOutputStream.toByteArray().length <= 255) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new TextParseException("text string too long");
    }

    protected static String byteArrayToString(byte[] bArr, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            sb5.append('\"');
        }
        for (byte b16 : bArr) {
            int i3 = b16 & 255;
            if (i3 >= 32 && i3 < 127) {
                if (i3 != 34 && i3 != 92) {
                    sb5.append((char) i3);
                } else {
                    sb5.append('\\');
                    sb5.append((char) i3);
                }
            } else {
                sb5.append('\\');
                sb5.append(byteFormat.format(i3));
            }
        }
        if (z16) {
            sb5.append('\"');
        }
        return sb5.toString();
    }

    static byte[] checkByteArrayLength(String str, byte[] bArr, int i3) {
        if (bArr.length <= 65535) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        throw new IllegalArgumentException("\"" + str + "\" array must have no more than " + i3 + " elements");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Name checkName(String str, Name name) {
        if (name.isAbsolute()) {
            return name;
        }
        throw new RelativeNameException("'" + name + "' on field " + str + " is not an absolute name");
    }

    static int checkU16(String str, int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            return i3;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i3 + " must be an unsigned 16 bit value");
    }

    static long checkU32(String str, long j3) {
        if (j3 >= 0 && j3 <= 4294967295L) {
            return j3;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + j3 + " must be an unsigned 32 bit value");
    }

    static int checkU8(String str, int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return i3;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i3 + " must be an unsigned 8 bit value");
    }

    public static Record fromString(Name name, int i3, int i16, long j3, Tokenizer tokenizer, Name name2) throws IOException {
        if (name.isAbsolute()) {
            Type.check(i3);
            DClass.check(i16);
            TTL.check(j3);
            Tokenizer.Token token = tokenizer.get();
            if (token.type() == 3 && token.value().equals("\\#")) {
                int uInt16 = tokenizer.getUInt16();
                byte[] hex = tokenizer.getHex();
                if (hex == null) {
                    hex = new byte[0];
                }
                if (uInt16 == hex.length) {
                    return newRecord(name, i3, i16, j3, uInt16, new DNSInput(hex));
                }
                throw tokenizer.exception("invalid unknown RR encoding: length mismatch");
            }
            tokenizer.unget();
            Record emptyRecord = getEmptyRecord(name, i3, i16, j3, true);
            emptyRecord.rdataFromString(tokenizer, name2);
            Tokenizer.Token token2 = tokenizer.get();
            if (token2.type() == 1 || token2.type() == 0) {
                return emptyRecord;
            }
            throw tokenizer.exception("unexpected tokens at end of record (wanted EOL/EOF, got " + token2 + ")");
        }
        throw new RelativeNameException(name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Record fromWire(DNSInput dNSInput, int i3, boolean z16) throws IOException {
        Name name = new Name(dNSInput);
        int readU16 = dNSInput.readU16();
        int readU162 = dNSInput.readU16();
        if (i3 == 0) {
            return newRecord(name, readU16, readU162);
        }
        long readU32 = dNSInput.readU32();
        int readU163 = dNSInput.readU16();
        if (readU163 == 0 && z16 && (i3 == 1 || i3 == 2)) {
            return newRecord(name, readU16, readU162, readU32);
        }
        return newRecord(name, readU16, readU162, readU32, readU163, dNSInput);
    }

    private static Record getEmptyRecord(Name name, int i3, int i16, long j3, boolean z16) {
        Record emptyRecord;
        Object obj;
        if (z16) {
            Supplier<Record> factory = Type.getFactory(i3);
            if (factory != null) {
                obj = factory.get();
                emptyRecord = (Record) obj;
            } else {
                emptyRecord = new UNKRecord();
            }
        } else {
            emptyRecord = new EmptyRecord();
        }
        emptyRecord.name = name;
        emptyRecord.type = i3;
        emptyRecord.dclass = i16;
        emptyRecord.ttl = j3;
        return emptyRecord;
    }

    private static Record newRecord(Name name, int i3, int i16, long j3, int i17, DNSInput dNSInput) throws IOException {
        Record emptyRecord = getEmptyRecord(name, i3, i16, j3, dNSInput != null);
        if (dNSInput != null) {
            if (dNSInput.remaining() >= i17) {
                dNSInput.setActive(i17);
                emptyRecord.rrFromWire(dNSInput);
                if (dNSInput.remaining() <= 0) {
                    dNSInput.clearActive();
                } else {
                    throw new WireParseException("invalid record length");
                }
            } else {
                throw new WireParseException("truncated record");
            }
        }
        return emptyRecord;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use RecordSerializationProxy");
    }

    private void toWireCanonical(DNSOutput dNSOutput, boolean z16) {
        this.name.toWireCanonical(dNSOutput);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (z16) {
            dNSOutput.writeU32(0L);
        } else {
            dNSOutput.writeU32(this.ttl);
        }
        int current = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, null, true);
        dNSOutput.writeU16At((dNSOutput.current() - current) - 2, current);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String unknownToString(byte[] bArr) {
        return "\\# " + bArr.length + " " + base16.toString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Record cloneRecord() {
        try {
            return (Record) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        if (this.type != record.type || this.dclass != record.dclass || !this.name.equals(record.name)) {
            return false;
        }
        return Arrays.equals(rdataToWireCanonical(), record.rdataToWireCanonical());
    }

    public Name getAdditionalName() {
        return null;
    }

    public int getDClass() {
        return this.dclass;
    }

    public Name getName() {
        return this.name;
    }

    public int getRRsetType() {
        return this.type;
    }

    public long getTTL() {
        return this.ttl;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i3 = 0;
        for (byte b16 : toWireCanonical(true)) {
            i3 += (i3 << 3) + (b16 & 255);
        }
        return i3;
    }

    protected abstract void rdataFromString(Tokenizer tokenizer, Name name) throws IOException;

    public String rdataToString() {
        return rrToString();
    }

    public byte[] rdataToWireCanonical() {
        DNSOutput dNSOutput = new DNSOutput();
        rrToWire(dNSOutput, null, true);
        return dNSOutput.toByteArray();
    }

    protected abstract void rrFromWire(DNSInput dNSInput) throws IOException;

    protected abstract String rrToString();

    protected abstract void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z16);

    public boolean sameRRset(Record record) {
        if (getRRsetType() == record.getRRsetType() && this.dclass == record.dclass && this.name.equals(record.name)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTTL(long j3) {
        this.ttl = j3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.name);
        if (sb5.length() < 8) {
            sb5.append("\t");
        }
        if (sb5.length() < 16) {
            sb5.append("\t");
        }
        sb5.append("\t");
        if (Options.check("BINDTTL")) {
            sb5.append(TTL.format(this.ttl));
        } else {
            sb5.append(this.ttl);
        }
        sb5.append("\t");
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            sb5.append(DClass.string(this.dclass));
            sb5.append("\t");
        }
        sb5.append(Type.string(this.type));
        String rrToString = rrToString();
        if (!rrToString.equals("")) {
            sb5.append("\t");
            sb5.append(rrToString);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void toWire(DNSOutput dNSOutput, int i3, Compression compression) {
        this.name.toWire(dNSOutput, compression);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (i3 == 0) {
            return;
        }
        dNSOutput.writeU32(this.ttl);
        int current = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, compression, false);
        dNSOutput.writeU16At((dNSOutput.current() - current) - 2, current);
    }

    Record withDClass(int i3, long j3) {
        Record cloneRecord = cloneRecord();
        cloneRecord.dclass = i3;
        cloneRecord.ttl = j3;
        return cloneRecord;
    }

    public Record withName(Name name) {
        if (name.isAbsolute()) {
            Record cloneRecord = cloneRecord();
            cloneRecord.name = name;
            return cloneRecord;
        }
        throw new RelativeNameException(name);
    }

    Object writeReplace() {
        return new RecordSerializationProxy(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Record(Name name, int i3, int i16, long j3) {
        if (name.isAbsolute()) {
            Type.check(i3);
            DClass.check(i16);
            TTL.check(j3);
            this.name = name;
            this.type = i3;
            this.dclass = i16;
            this.ttl = j3;
            return;
        }
        throw new RelativeNameException(name);
    }

    @Override // java.lang.Comparable
    public int compareTo(Record record) {
        if (this == record) {
            return 0;
        }
        int compareTo = this.name.compareTo(record.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int i3 = this.dclass - record.dclass;
        if (i3 != 0) {
            return i3;
        }
        int i16 = this.type - record.type;
        if (i16 != 0) {
            return i16;
        }
        byte[] rdataToWireCanonical = rdataToWireCanonical();
        byte[] rdataToWireCanonical2 = record.rdataToWireCanonical();
        int min = Math.min(rdataToWireCanonical.length, rdataToWireCanonical2.length);
        for (int i17 = 0; i17 < min; i17++) {
            byte b16 = rdataToWireCanonical[i17];
            byte b17 = rdataToWireCanonical2[i17];
            if (b16 != b17) {
                return (b16 & 255) - (b17 & 255);
            }
        }
        return rdataToWireCanonical.length - rdataToWireCanonical2.length;
    }

    static Record fromWire(DNSInput dNSInput, int i3) throws IOException {
        return fromWire(dNSInput, i3, false);
    }

    public static Record newRecord(Name name, int i3, int i16, long j3, int i17, byte[] bArr) {
        if (name.isAbsolute()) {
            Type.check(i3);
            DClass.check(i16);
            TTL.check(j3);
            try {
                return newRecord(name, i3, i16, j3, i17, bArr != null ? new DNSInput(bArr) : null);
            } catch (IOException unused) {
                return null;
            }
        }
        throw new RelativeNameException(name);
    }

    public static Record fromWire(byte[] bArr, int i3) throws IOException {
        return fromWire(new DNSInput(bArr), i3, false);
    }

    public byte[] toWire(int i3) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i3, null);
        return dNSOutput.toByteArray();
    }

    private byte[] toWireCanonical(boolean z16) {
        DNSOutput dNSOutput = new DNSOutput();
        toWireCanonical(dNSOutput, z16);
        return dNSOutput.toByteArray();
    }

    public byte[] toWireCanonical() {
        return toWireCanonical(false);
    }

    public static Record newRecord(Name name, int i3, int i16, long j3, byte[] bArr) {
        return newRecord(name, i3, i16, j3, bArr.length, bArr);
    }

    public static Record newRecord(Name name, int i3, int i16, long j3) {
        if (name.isAbsolute()) {
            Type.check(i3);
            DClass.check(i16);
            TTL.check(j3);
            return getEmptyRecord(name, i3, i16, j3, false);
        }
        throw new RelativeNameException(name);
    }

    public static Record fromString(Name name, int i3, int i16, long j3, String str, Name name2) throws IOException {
        return fromString(name, i3, i16, j3, new Tokenizer(str), name2);
    }

    public static Record newRecord(Name name, int i3, int i16) {
        return newRecord(name, i3, i16, 0L);
    }
}
