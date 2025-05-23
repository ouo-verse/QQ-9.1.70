package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class AAAARecord extends Record {
    private byte[] address;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AAAARecord() {
    }

    public InetAddress getAddress() {
        try {
            Name name = this.name;
            if (name == null) {
                return InetAddress.getByAddress(this.address);
            }
            return InetAddress.getByAddress(name.toString(), this.address);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.address = tokenizer.getAddressBytes(2);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.address = dNSInput.readByteArray(16);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected String rrToString() {
        try {
            InetAddress byAddress = InetAddress.getByAddress(null, this.address);
            if (byAddress.getAddress().length == 4) {
                return "::ffff:" + byAddress.getHostAddress();
            }
            return byAddress.getHostAddress();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z16) {
        dNSOutput.writeByteArray(this.address);
    }

    public AAAARecord(Name name, int i3, long j3, InetAddress inetAddress) {
        super(name, 28, i3, j3);
        if (Address.familyOf(inetAddress) != 1 && Address.familyOf(inetAddress) != 2) {
            throw new IllegalArgumentException("invalid IPv4/IPv6 address");
        }
        this.address = inetAddress.getAddress();
    }
}
