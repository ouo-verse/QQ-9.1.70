package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder;
import java.util.Random;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
final class FixedSizeExemplarReservoir extends AbstractFixedSizeExemplarReservoir {
    static IPatchRedirector $redirector_;
    private final LongAdder numMeasurements;
    private final Supplier<Random> randomSupplier;

    public FixedSizeExemplarReservoir(Clock clock, int i3, Supplier<Random> supplier) {
        super(clock, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, clock, Integer.valueOf(i3), supplier);
        } else {
            this.numMeasurements = AdderUtil.createLongAdder();
            this.randomSupplier = supplier;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.AbstractFixedSizeExemplarReservoir
    protected int reservoirIndexFor(double d16, Attributes attributes, Context context) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), attributes, context)).intValue();
        }
        int sum = ((int) this.numMeasurements.sum()) + 1;
        obj = this.randomSupplier.get();
        Random random = (Random) obj;
        if (sum > 0) {
            i3 = sum;
        }
        int nextInt = random.nextInt(i3);
        this.numMeasurements.increment();
        if (nextInt < maxSize()) {
            return nextInt;
        }
        return -1;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.AbstractFixedSizeExemplarReservoir
    protected void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.numMeasurements.reset();
        }
    }
}
