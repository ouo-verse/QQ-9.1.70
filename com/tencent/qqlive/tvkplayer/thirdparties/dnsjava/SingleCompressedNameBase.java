package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

/* compiled from: P */
/* loaded from: classes23.dex */
abstract class SingleCompressedNameBase extends SingleNameBase {
    /* JADX INFO: Access modifiers changed from: protected */
    public SingleCompressedNameBase() {
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.SingleNameBase, com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z16) {
        this.singleName.toWire(dNSOutput, compression, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleCompressedNameBase(Name name, int i3, int i16, long j3, Name name2, String str) {
        super(name, i3, i16, j3, name2, str);
    }
}
