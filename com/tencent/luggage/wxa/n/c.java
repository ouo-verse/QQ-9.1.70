package com.tencent.luggage.wxa.n;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f134909c = new c(new int[]{2}, 2);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f134910a;

    /* renamed from: b, reason: collision with root package name */
    public final int f134911b;

    public c(int[] iArr, int i3) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f134910a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f134910a = new int[0];
        }
        this.f134911b = i3;
    }

    public static c a(Context context) {
        return a(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Arrays.equals(this.f134910a, cVar.f134910a) && this.f134911b == cVar.f134911b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f134911b + (Arrays.hashCode(this.f134910a) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f134911b + ", supportedEncodings=" + Arrays.toString(this.f134910a) + "]";
    }

    public static c a(Intent intent) {
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
        }
        return f134909c;
    }

    public boolean a(int i3) {
        return Arrays.binarySearch(this.f134910a, i3) >= 0;
    }
}
