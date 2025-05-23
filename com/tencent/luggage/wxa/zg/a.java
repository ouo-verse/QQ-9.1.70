package com.tencent.luggage.wxa.zg;

import com.tencent.luggage.wxa.l0.q;
import com.tencent.luggage.wxa.l0.u;
import com.tencent.luggage.wxa.tn.w;
import java.io.EOFException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.l0.n {

    /* renamed from: u, reason: collision with root package name */
    public static final C6987a f146617u = new C6987a(null);

    /* renamed from: v, reason: collision with root package name */
    public static final AtomicReference f146618v = new AtomicReference();

    /* renamed from: r, reason: collision with root package name */
    public final String f146619r;

    /* renamed from: s, reason: collision with root package name */
    public long f146620s;

    /* renamed from: t, reason: collision with root package name */
    public long f146621t;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zg.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6987a {
        public C6987a() {
        }

        public /* synthetic */ C6987a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String str, com.tencent.luggage.wxa.n0.n nVar, u uVar, int i3, int i16, boolean z16, q.e eVar) {
        super(str, nVar, uVar, i3, i16, z16, eVar);
        this.f146619r = "MicroMsg.AppBrand.ByteRangeFixHttpDataSource#" + hashCode();
    }

    private final void d() {
        InputStream inputStream;
        long coerceAtMost;
        w.a(this.f146619r, "skipInternal, bytesToSkip: " + this.f146620s + ", bytesSkipped: " + this.f146621t);
        HttpURLConnection c16 = c();
        if (c16 != null) {
            inputStream = c16.getInputStream();
        } else {
            inputStream = null;
        }
        if (inputStream == null) {
            w.f(this.f146619r, "skipInternal, inputStream is null");
            return;
        }
        if (this.f146621t == this.f146620s) {
            return;
        }
        byte[] bArr = (byte[]) f146618v.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j3 = this.f146621t;
            long j16 = this.f146620s;
            if (j3 != j16) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(j16 - j3, bArr.length);
                int read = inputStream.read(bArr, 0, (int) coerceAtMost);
                if (!Thread.interrupted()) {
                    if (-1 != read) {
                        this.f146621t += read;
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new InterruptedIOException();
                }
            } else {
                f146618v.set(bArr);
                w.d(this.f146619r, "skipInternal, skip done");
                return;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.l0.n, com.tencent.luggage.wxa.l0.g
    public long a(com.tencent.luggage.wxa.l0.j jVar) {
        long a16 = super.a(jVar);
        a(jVar != null ? jVar.f132785d : 0L);
        return a16;
    }

    @Override // com.tencent.luggage.wxa.l0.n, com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        d();
        return super.read(bArr, i3, i16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x008c, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(long j3) {
        Long longOrNull;
        Long longOrNull2;
        Long longOrNull3;
        w.d(this.f146619r, "calculateBytesToSkip, startReadPos: " + j3);
        HttpURLConnection c16 = c();
        if (c16 == null) {
            w.f(this.f146619r, "calculateBytesToSkip, connection is null");
            return;
        }
        int responseCode = c16.getResponseCode();
        w.d(this.f146619r, "calculateBytesToSkip, responseCode: " + responseCode);
        if (206 == responseCode) {
            String headerField = c16.getHeaderField("Content-Range");
            if (headerField == null) {
                w.d(this.f146619r, "calculateBytesToSkip, contentRange is null");
                return;
            }
            w.d(this.f146619r, "calculateBytesToSkip, contentRange: " + headerField);
            Matcher matcher = c.a().matcher(headerField);
            if (matcher.matches() && 3 == matcher.groupCount()) {
                String group = matcher.group(1);
                long j16 = 0;
                long longValue = (group == null || longOrNull3 == null) ? 0L : longOrNull3.longValue();
                String group2 = matcher.group(2);
                long longValue2 = (group2 == null || longOrNull2 == null) ? 0L : longOrNull2.longValue();
                String group3 = matcher.group(3);
                if (group3 != null && longOrNull != null) {
                    j16 = longOrNull.longValue();
                }
                w.d(this.f146619r, "calculateBytesToSkip, startPos: " + longValue + ", endPos: " + longValue2 + ", totalCount: " + j16);
                if (longValue <= j3 && j3 <= longValue2) {
                    this.f146620s = j3 - longValue;
                    w.d(this.f146619r, "calculateBytesToSkip, bytesToSkip: " + this.f146620s);
                }
            }
        }
    }
}
