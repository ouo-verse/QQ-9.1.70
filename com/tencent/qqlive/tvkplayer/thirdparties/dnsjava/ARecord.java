package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class ARecord extends Record {
    private int addr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ARecord() {
    }

    private static int fromArray(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    private static byte[] toArray(int i3) {
        return new byte[]{(byte) ((i3 >>> 24) & 255), (byte) ((i3 >>> 16) & 255), (byte) ((i3 >>> 8) & 255), (byte) (i3 & 255)};
    }

    public InetAddress getAddress() {
        try {
            Name name = this.name;
            if (name == null) {
                return InetAddress.getByAddress(toArray(this.addr));
            }
            return InetAddress.getByAddress(name.toString(), toArray(this.addr));
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.addr = fromArray(tokenizer.getAddressBytes(1));
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.addr = fromArray(dNSInput.readByteArray(4));
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected String rrToString() {
        return Address.toDottedQuad(toArray(this.addr));
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z16) {
        dNSOutput.writeU32(this.addr & 4294967295L);
    }

    public ARecord(Name name, int i3, long j3, InetAddress inetAddress) {
        super(name, 1, i3, j3);
        if (Address.familyOf(inetAddress) == 1) {
            this.addr = fromArray(inetAddress.getAddress());
            return;
        }
        throw new IllegalArgumentException("invalid IPv4 address");
    }
}
