package f45;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import pbandk.InvalidProtocolBufferException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f397842a;

    /* renamed from: b, reason: collision with root package name */
    public final int f397843b;

    /* renamed from: c, reason: collision with root package name */
    public int f397844c = 0;

    public a(byte[] bArr, int i3) {
        this.f397842a = bArr;
        this.f397843b = i3 + 0;
    }

    @Override // f45.e
    public final boolean isAtEnd() {
        return this.f397844c == this.f397843b;
    }

    @Override // f45.e
    public final void a(int i3) {
        if (i3 >= 0 && i3 <= this.f397843b - this.f397844c) {
            this.f397844c += i3;
        } else {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.Companion.b();
            }
            throw InvalidProtocolBufferException.Companion.c();
        }
    }

    @Override // f45.e
    public final byte[] b(int i3) {
        byte[] copyOfRange;
        if (1 <= i3 && i3 <= this.f397843b - this.f397844c) {
            int i16 = this.f397844c;
            int i17 = i3 + i16;
            this.f397844c = i17;
            copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(this.f397842a, i16, i17);
            return copyOfRange;
        }
        if (i3 < 0) {
            throw InvalidProtocolBufferException.Companion.b();
        }
        if (i3 == 0) {
            return new byte[0];
        }
        throw InvalidProtocolBufferException.Companion.c();
    }
}
