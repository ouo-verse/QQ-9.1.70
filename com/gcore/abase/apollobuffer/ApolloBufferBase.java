package com.gcore.abase.apollobuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ApolloBufferBase {
    public boolean Decode(byte[] bArr) {
        if (bArr != null) {
            try {
                ApolloBufferReader apolloBufferReader = new ApolloBufferReader(bArr);
                BeforeDecode(apolloBufferReader);
                ReadFrom(apolloBufferReader);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public byte[] Encode() {
        try {
            ApolloBufferWriter apolloBufferWriter = new ApolloBufferWriter();
            BeforeEncode(apolloBufferWriter);
            WriteTo(apolloBufferWriter);
            return apolloBufferWriter.GetBufferData();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public abstract void ReadFrom(ApolloBufferReader apolloBufferReader);

    public abstract void WriteTo(ApolloBufferWriter apolloBufferWriter);

    public boolean Decode(ApolloBufferReader apolloBufferReader) {
        if (apolloBufferReader != null) {
            try {
                BeforeDecode(apolloBufferReader);
                ReadFrom(apolloBufferReader);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public boolean Encode(ApolloBufferWriter apolloBufferWriter) {
        if (apolloBufferWriter == null) {
            return false;
        }
        try {
            BeforeEncode(apolloBufferWriter);
            WriteTo(apolloBufferWriter);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    protected void BeforeDecode(ApolloBufferReader apolloBufferReader) {
    }

    protected void BeforeEncode(ApolloBufferWriter apolloBufferWriter) {
    }
}
