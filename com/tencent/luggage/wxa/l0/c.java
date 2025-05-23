package com.tencent.luggage.wxa.l0;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements g {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f132762a;

    /* renamed from: b, reason: collision with root package name */
    public final u f132763b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f132764c;

    /* renamed from: d, reason: collision with root package name */
    public InputStream f132765d;

    /* renamed from: e, reason: collision with root package name */
    public long f132766e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f132767f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, u uVar) {
        this.f132762a = context.getAssets();
        this.f132763b = uVar;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public long a(j jVar) {
        try {
            Uri uri = jVar.f132782a;
            this.f132764c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream open = this.f132762a.open(path, 1);
            this.f132765d = open;
            if (open.skip(jVar.f132785d) >= jVar.f132785d) {
                long j3 = jVar.f132786e;
                if (j3 != -1) {
                    this.f132766e = j3;
                } else {
                    long available = this.f132765d.available();
                    this.f132766e = available;
                    if (available == TTL.MAX_VALUE) {
                        this.f132766e = -1L;
                    }
                }
                this.f132767f = true;
                u uVar = this.f132763b;
                if (uVar != null) {
                    uVar.a(this, jVar);
                }
                return this.f132766e;
            }
            throw new EOFException();
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public void close() {
        this.f132764c = null;
        try {
            try {
                InputStream inputStream = this.f132765d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e16) {
                throw new a(e16);
            }
        } finally {
            this.f132765d = null;
            if (this.f132767f) {
                this.f132767f = false;
                u uVar = this.f132763b;
                if (uVar != null) {
                    uVar.a(this);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public Uri getUri() {
        return this.f132764c;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.f132766e;
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
        int read = this.f132765d.read(bArr, i3, i16);
        if (read == -1) {
            if (this.f132766e == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j16 = this.f132766e;
        if (j16 != -1) {
            this.f132766e = j16 - read;
        }
        u uVar = this.f132763b;
        if (uVar != null) {
            uVar.a(this, read);
        }
        return read;
    }
}
