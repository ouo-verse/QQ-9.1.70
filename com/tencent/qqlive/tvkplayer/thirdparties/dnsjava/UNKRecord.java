package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class UNKRecord extends Record {
    private byte[] data;

    public byte[] getData() {
        return this.data;
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        throw tokenizer.exception("invalid unknown RR encoding");
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected String rrToString() {
        return Record.unknownToString(this.data);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z16) {
        dNSOutput.writeByteArray(this.data);
    }
}
