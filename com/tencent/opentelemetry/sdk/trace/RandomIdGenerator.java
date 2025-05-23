package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.trace.SpanId;
import com.tencent.opentelemetry.api.trace.TraceId;
import java.util.Random;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
final class RandomIdGenerator implements IdGenerator {
    private static final /* synthetic */ RandomIdGenerator[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RandomIdGenerator INSTANCE;
    private static final long INVALID_ID = 0;
    private static final Random random;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator("INSTANCE", 0);
        INSTANCE = randomIdGenerator;
        $VALUES = new RandomIdGenerator[]{randomIdGenerator};
        random = new Random();
    }

    RandomIdGenerator(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    private static long getSpeed() {
        return Math.abs(mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime()));
    }

    private static long mix64(long j3) {
        long j16 = (j3 ^ (j3 >>> 33)) * (-49064778989728563L);
        long j17 = (j16 ^ (j16 >>> 33)) * (-4265267296055464877L);
        return j17 ^ (j17 >>> 33);
    }

    public static RandomIdGenerator valueOf(String str) {
        return (RandomIdGenerator) Enum.valueOf(RandomIdGenerator.class, str);
    }

    public static RandomIdGenerator[] values() {
        return (RandomIdGenerator[]) $VALUES.clone();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.IdGenerator
    public String generateSpanId() {
        long nextLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        do {
            nextLong = random.nextLong();
        } while (nextLong == 0);
        return SpanId.fromLong(nextLong);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.IdGenerator
    public String generateTraceId() {
        long nextLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        long nextLong2 = random.nextLong();
        do {
            nextLong = random.nextLong();
        } while (nextLong == 0);
        return TraceId.fromLongs(nextLong2, nextLong);
    }
}
