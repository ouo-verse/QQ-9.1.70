package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.baggage.Baggage;
import com.tencent.opentelemetry.api.baggage.BaggageEntry;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes22.dex */
public abstract class AttributesProcessor {
    static IPatchRedirector $redirector_;
    static final AttributesProcessor NOOP;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Immutable
    /* loaded from: classes22.dex */
    public static final class JoinedAttributesProcessor extends AttributesProcessor {
        static IPatchRedirector $redirector_;
        private final Collection<AttributesProcessor> processors;
        private final boolean usesContextCache;

        JoinedAttributesProcessor(Collection<AttributesProcessor> collection) {
            super(null);
            Stream stream;
            Stream map;
            Object reduce;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) collection);
                return;
            }
            this.processors = collection;
            stream = collection.stream();
            map = stream.map(new Function() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((AttributesProcessor) obj).usesContext());
                }
            });
            reduce = map.reduce(Boolean.FALSE, new BinaryOperator() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.j
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Boolean lambda$new$0;
                    lambda$new$0 = AttributesProcessor.JoinedAttributesProcessor.lambda$new$0((Boolean) obj, (Boolean) obj2);
                    return lambda$new$0;
                }
            });
            this.usesContextCache = ((Boolean) reduce).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$new$0(Boolean bool, Boolean bool2) {
            boolean z16;
            if (!bool.booleanValue() && !bool2.booleanValue()) {
                z16 = false;
            } else {
                z16 = true;
            }
            return Boolean.valueOf(z16);
        }

        AttributesProcessor prepend(AttributesProcessor attributesProcessor) {
            ArrayList arrayList = new ArrayList(this.processors.size() + 1);
            arrayList.add(attributesProcessor);
            arrayList.addAll(this.processors);
            return new JoinedAttributesProcessor(arrayList);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public Attributes process(Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Attributes) iPatchRedirector.redirect((short) 2, (Object) this, (Object) attributes, (Object) context);
            }
            Iterator<AttributesProcessor> it = this.processors.iterator();
            while (it.hasNext()) {
                attributes = it.next().process(attributes, context);
            }
            return attributes;
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public AttributesProcessor then(AttributesProcessor attributesProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AttributesProcessor) iPatchRedirector.redirect((short) 4, (Object) this, (Object) attributesProcessor);
            }
            ArrayList arrayList = new ArrayList(this.processors);
            if (attributesProcessor instanceof JoinedAttributesProcessor) {
                arrayList.addAll(((JoinedAttributesProcessor) attributesProcessor).processors);
            } else {
                arrayList.add(attributesProcessor);
            }
            return new JoinedAttributesProcessor(arrayList);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public boolean usesContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.usesContextCache;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22917);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            NOOP = simple(new UnaryOperator() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Attributes lambda$static$5;
                    lambda$static$5 = AttributesProcessor.lambda$static$5((Attributes) obj);
                    return lambda$static$5;
                }
            });
        }
    }

    /* synthetic */ AttributesProcessor(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
    }

    public static AttributesProcessor append(final Attributes attributes) {
        return simple(new UnaryOperator() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Attributes lambda$append$4;
                lambda$append$4 = AttributesProcessor.lambda$append$4(Attributes.this, (Attributes) obj);
                return lambda$append$4;
            }
        });
    }

    public static AttributesProcessor appendBaggageByKeyName(final Predicate<String> predicate) {
        return onBaggage(new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.d
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Attributes lambda$appendBaggageByKeyName$3;
                lambda$appendBaggageByKeyName$3 = AttributesProcessor.lambda$appendBaggageByKeyName$3(predicate, (Attributes) obj, (Baggage) obj2);
                return lambda$appendBaggageByKeyName$3;
            }
        });
    }

    public static AttributesProcessor filterByKeyName(final Predicate<String> predicate) {
        return simple(new UnaryOperator() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Attributes lambda$filterByKeyName$1;
                lambda$filterByKeyName$1 = AttributesProcessor.lambda$filterByKeyName$1(predicate, (Attributes) obj);
                return lambda$filterByKeyName$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Attributes lambda$append$4(Attributes attributes, Attributes attributes2) {
        return attributes.toBuilder().putAll(attributes2).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$appendBaggageByKeyName$2(Predicate predicate, AttributesBuilder attributesBuilder, String str, BaggageEntry baggageEntry) {
        boolean test;
        test = predicate.test(str);
        if (test) {
            attributesBuilder.put(str, baggageEntry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Attributes lambda$appendBaggageByKeyName$3(final Predicate predicate, Attributes attributes, Baggage baggage) {
        final AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
        baggage.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                AttributesProcessor.lambda$appendBaggageByKeyName$2(predicate, a16, (String) obj, (BaggageEntry) obj2);
            }
        });
        a16.putAll(attributes);
        return a16.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$filterByKeyName$0(Predicate predicate, AttributesBuilder attributesBuilder, AttributeKey attributeKey, Object obj) {
        boolean test;
        test = predicate.test(attributeKey.getKey());
        if (test) {
            attributesBuilder.put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Attributes lambda$filterByKeyName$1(final Predicate predicate, Attributes attributes) {
        final AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
        attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.b
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                AttributesProcessor.lambda$filterByKeyName$0(predicate, a16, (AttributeKey) obj, obj2);
            }
        });
        return a16.build();
    }

    public static AttributesProcessor noop() {
        return NOOP;
    }

    static AttributesProcessor onBaggage(BiFunction<Attributes, Baggage, Attributes> biFunction) {
        return new AttributesProcessor(biFunction) { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ BiFunction val$processor;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
                this.val$processor = biFunction;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) biFunction);
                }
            }

            @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public Attributes process(Attributes attributes, Context context) {
                Object apply;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    apply = this.val$processor.apply(attributes, com.tencent.opentelemetry.api.baggage.a.f(context));
                    return (Attributes) apply;
                }
                return (Attributes) iPatchRedirector.redirect((short) 2, (Object) this, (Object) attributes, (Object) context);
            }

            @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public boolean usesContext() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return true;
            }
        };
    }

    static AttributesProcessor simple(UnaryOperator<Attributes> unaryOperator) {
        return new AttributesProcessor(unaryOperator) { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ UnaryOperator val$processor;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
                this.val$processor = unaryOperator;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) unaryOperator);
                }
            }

            @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public Attributes process(Attributes attributes, Context context) {
                Object apply;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    apply = this.val$processor.apply(attributes);
                    return (Attributes) apply;
                }
                return (Attributes) iPatchRedirector.redirect((short) 2, (Object) this, (Object) attributes, (Object) context);
            }

            @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public boolean usesContext() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return false;
            }
        };
    }

    public abstract Attributes process(Attributes attributes, Context context);

    public AttributesProcessor then(AttributesProcessor attributesProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AttributesProcessor) iPatchRedirector.redirect((short) 2, (Object) this, (Object) attributesProcessor);
        }
        AttributesProcessor attributesProcessor2 = NOOP;
        if (attributesProcessor == attributesProcessor2) {
            return this;
        }
        if (this == attributesProcessor2) {
            return attributesProcessor;
        }
        if (attributesProcessor instanceof JoinedAttributesProcessor) {
            return ((JoinedAttributesProcessor) attributesProcessor).prepend(this);
        }
        return new JoinedAttributesProcessor(Arrays.asList(this, attributesProcessor));
    }

    public abstract boolean usesContext();

    AttributesProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Attributes lambda$static$5(Attributes attributes) {
        return attributes;
    }
}
