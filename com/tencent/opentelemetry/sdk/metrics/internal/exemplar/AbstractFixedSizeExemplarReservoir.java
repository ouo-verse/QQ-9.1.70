package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.e;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.internal.data.ImmutableDoubleExemplarData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class AbstractFixedSizeExemplarReservoir implements ExemplarReservoir {
    static IPatchRedirector $redirector_;
    private final Clock clock;
    private final ReservoirCell[] storage;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ReservoirCell {
        static IPatchRedirector $redirector_;

        @Nullable
        private Attributes attributes;
        private long recordTime;
        private SpanContext spanContext;
        private double value;

        public ReservoirCell() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbstractFixedSizeExemplarReservoir.this);
            } else {
                this.spanContext = e.g();
            }
        }

        private void updateFromContext(Context context) {
            Span q16 = com.tencent.opentelemetry.api.trace.b.q(context);
            if (q16.getSpanContext().isValid()) {
                this.spanContext = q16.getSpanContext();
            }
        }

        @Nullable
        synchronized ExemplarData getAndReset(Attributes attributes) {
            Attributes attributes2 = this.attributes;
            if (attributes2 == null) {
                return null;
            }
            DoubleExemplarData create = ImmutableDoubleExemplarData.create(AbstractFixedSizeExemplarReservoir.filtered(attributes2, attributes), this.recordTime, this.spanContext, this.value);
            this.attributes = null;
            this.value = 0.0d;
            this.spanContext = e.g();
            this.recordTime = 0L;
            return create;
        }

        synchronized void offerMeasurement(double d16, Attributes attributes, Context context) {
            this.value = d16;
            this.attributes = attributes;
            this.recordTime = AbstractFixedSizeExemplarReservoir.this.clock.now();
            updateFromContext(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractFixedSizeExemplarReservoir(Clock clock, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) clock, i3);
            return;
        }
        this.clock = clock;
        this.storage = new ReservoirCell[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            this.storage[i16] = new ReservoirCell();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Attributes filtered(Attributes attributes, Attributes attributes2) {
        if (attributes2.isEmpty()) {
            return attributes;
        }
        final Set<AttributeKey<?>> keySet = attributes2.asMap().keySet();
        AttributesBuilder builder = attributes.toBuilder();
        Objects.requireNonNull(keySet);
        return builder.removeIf(new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.exemplar.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return keySet.contains((AttributeKey) obj);
            }
        }).build();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public final List<ExemplarData> collectAndReset(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) attributes);
        }
        ArrayList arrayList = new ArrayList();
        for (ReservoirCell reservoirCell : this.storage) {
            ExemplarData andReset = reservoirCell.getAndReset(attributes);
            if (andReset != null) {
                arrayList.add(andReset);
            }
        }
        reset();
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int maxSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.storage.length;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public final void offerMeasurement(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            offerMeasurement(j3, attributes, context);
        } else {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), attributes, context);
        }
    }

    protected abstract int reservoirIndexFor(double d16, Attributes attributes, Context context);

    protected void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public final void offerMeasurement(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Double.valueOf(d16), attributes, context);
            return;
        }
        int reservoirIndexFor = reservoirIndexFor(d16, attributes, context);
        if (reservoirIndexFor != -1) {
            this.storage[reservoirIndexFor].offerMeasurement(d16, attributes, context);
        }
    }
}
