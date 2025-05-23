package com.tencent.luggage.wxa.aa;

import java.util.zip.Inflater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends Inflater {

    /* renamed from: a, reason: collision with root package name */
    public static final a f121006a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static boolean f121007b = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // java.util.zip.Inflater
    public boolean finished() {
        if (f121007b && getRemaining() <= 0) {
            return true;
        }
        return super.finished();
    }

    @Override // java.util.zip.Inflater
    public int inflate(byte[] bArr, int i3, int i16) {
        int inflate = super.inflate(bArr, i3, i16);
        if (f121007b && inflate <= 0) {
            throw new IllegalStateException("InflateNothing: needsInput=" + needsInput() + ", needsDictionary=" + needsDictionary() + ", remaining=" + getRemaining() + ", totalIn=" + getTotalIn() + ", totalOut=" + getTotalOut() + "");
        }
        return inflate;
    }
}
