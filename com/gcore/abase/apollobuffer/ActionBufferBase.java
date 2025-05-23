package com.gcore.abase.apollobuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ActionBufferBase extends ApolloBufferBase {
    public int Action;

    protected ActionBufferBase() {
        this.Action = 0;
    }

    @Override // com.gcore.abase.apollobuffer.ApolloBufferBase
    protected void BeforeDecode(ApolloBufferReader apolloBufferReader) {
        this.Action = apolloBufferReader.Read(this.Action);
    }

    @Override // com.gcore.abase.apollobuffer.ApolloBufferBase
    protected void BeforeEncode(ApolloBufferWriter apolloBufferWriter) {
        apolloBufferWriter.Write(this.Action);
    }

    public ActionBufferBase(int i3) {
        this.Action = i3;
    }
}
