package com.tencent.luggage.wxa.l0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements g {

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f132768a;

    /* renamed from: b, reason: collision with root package name */
    public final u f132769b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f132770c;

    /* renamed from: d, reason: collision with root package name */
    public AssetFileDescriptor f132771d;

    /* renamed from: e, reason: collision with root package name */
    public InputStream f132772e;

    /* renamed from: f, reason: collision with root package name */
    public long f132773f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f132774g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public e(Context context, u uVar) {
        this.f132768a = context.getContentResolver();
        this.f132769b = uVar;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public long a(j jVar) {
        try {
            Uri uri = jVar.f132782a;
            this.f132770c = uri;
            AssetFileDescriptor openAssetFileDescriptor = this.f132768a.openAssetFileDescriptor(uri, "r");
            this.f132771d = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                this.f132772e = new FileInputStream(this.f132771d.getFileDescriptor());
                long startOffset = this.f132771d.getStartOffset();
                long skip = this.f132772e.skip(jVar.f132785d + startOffset) - startOffset;
                if (skip == jVar.f132785d) {
                    long j3 = jVar.f132786e;
                    if (j3 != -1) {
                        this.f132773f = j3;
                    } else {
                        long length = this.f132771d.getLength();
                        if (length == -1) {
                            long available = this.f132772e.available();
                            this.f132773f = available;
                            if (available == 0) {
                                this.f132773f = -1L;
                            }
                        } else {
                            this.f132773f = length - skip;
                        }
                    }
                    this.f132774g = true;
                    u uVar = this.f132769b;
                    if (uVar != null) {
                        uVar.a(this, jVar);
                    }
                    return this.f132773f;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException("Could not open file descriptor for: " + this.f132770c);
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public void close() {
        this.f132770c = null;
        try {
            try {
                InputStream inputStream = this.f132772e;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f132772e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f132771d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e16) {
                        throw new a(e16);
                    }
                } finally {
                    this.f132771d = null;
                    if (this.f132774g) {
                        this.f132774g = false;
                        u uVar = this.f132769b;
                        if (uVar != null) {
                            uVar.a(this);
                        }
                    }
                }
            } catch (IOException e17) {
                throw new a(e17);
            }
        } catch (Throwable th5) {
            this.f132772e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f132771d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f132771d = null;
                    if (this.f132774g) {
                        this.f132774g = false;
                        u uVar2 = this.f132769b;
                        if (uVar2 != null) {
                            uVar2.a(this);
                        }
                    }
                    throw th5;
                } finally {
                    this.f132771d = null;
                    if (this.f132774g) {
                        this.f132774g = false;
                        u uVar3 = this.f132769b;
                        if (uVar3 != null) {
                            uVar3.a(this);
                        }
                    }
                }
            } catch (IOException e18) {
                throw new a(e18);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public Uri getUri() {
        return this.f132770c;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.f132773f;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i16 = (int) Math.min(j3, i16);
            } catch (IOException e16) {
                throw new a(e16);
            }
        }
        int read = this.f132772e.read(bArr, i3, i16);
        if (read == -1) {
            if (this.f132773f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j16 = this.f132773f;
        if (j16 != -1) {
            this.f132773f = j16 - read;
        }
        u uVar = this.f132769b;
        if (uVar != null) {
            uVar.a(this, read);
        }
        return read;
    }
}
