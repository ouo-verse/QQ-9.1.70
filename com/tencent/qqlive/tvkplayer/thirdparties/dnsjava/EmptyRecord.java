package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class EmptyRecord extends Record {
    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected String rrToString() {
        return "";
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrFromWire(DNSInput dNSInput) {
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z16) {
    }
}
