package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class SingleNameBase extends Record {
    protected Name singleName;

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleNameBase() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Name getSingleName() {
        return this.singleName;
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.singleName = tokenizer.getName(name);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.singleName = new Name(dNSInput);
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected String rrToString() {
        return this.singleName.toString();
    }

    @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z16) {
        this.singleName.toWire(dNSOutput, null, z16);
    }

    protected SingleNameBase(Name name, int i3, int i16, long j3) {
        super(name, i3, i16, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleNameBase(Name name, int i3, int i16, long j3, Name name2, String str) {
        super(name, i3, i16, j3);
        this.singleName = Record.checkName(str, name2);
    }
}
