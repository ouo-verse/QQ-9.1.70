package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.InstrumentSelector;
import com.tencent.opentelemetry.sdk.metrics.View;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregationUtil;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class ViewRegistry {
    static IPatchRedirector $redirector_ = null;
    static final RegisteredView DEFAULT_REGISTERED_VIEW;
    static final View DEFAULT_VIEW;
    static final String TAG = "ViewRegistry";
    private final List<RegisteredView> reverseRegistration;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22911);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        View build = View.builder().build();
        DEFAULT_VIEW = build;
        DEFAULT_REGISTERED_VIEW = RegisteredView.create(InstrumentSelector.builder().setName("*").build(), build, AttributesProcessor.NOOP, com.tencent.opentelemetry.sdk.metrics.internal.debug.a.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewRegistry(List<RegisteredView> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.reverseRegistration = list;
        }
    }

    public static ViewRegistryBuilder builder() {
        return new ViewRegistryBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toGlobPatternPredicate$0(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toGlobPatternPredicate$1(Pattern pattern, String str) {
        return pattern.matcher(str).matches();
    }

    private static boolean matchesMeter(InstrumentSelector instrumentSelector, InstrumentationScopeInfo instrumentationScopeInfo) {
        if (instrumentSelector.getMeterName() != null && !instrumentSelector.getMeterName().equals(instrumentationScopeInfo.getName())) {
            return false;
        }
        if (instrumentSelector.getMeterVersion() != null && !instrumentSelector.getMeterVersion().equals(instrumentationScopeInfo.getVersion())) {
            return false;
        }
        if (instrumentSelector.getMeterSchemaUrl() != null && !instrumentSelector.getMeterSchemaUrl().equals(instrumentationScopeInfo.getSchemaUrl())) {
            return false;
        }
        return true;
    }

    private static boolean matchesSelector(InstrumentSelector instrumentSelector, InstrumentDescriptor instrumentDescriptor, InstrumentationScopeInfo instrumentationScopeInfo) {
        boolean test;
        if (instrumentSelector.getInstrumentType() != null && instrumentSelector.getInstrumentType() != instrumentDescriptor.getType()) {
            return false;
        }
        if (instrumentSelector.getInstrumentName() != null) {
            test = toGlobPatternPredicate(instrumentSelector.getInstrumentName()).test(instrumentDescriptor.getName());
            if (!test) {
                return false;
            }
        }
        return matchesMeter(instrumentSelector, instrumentationScopeInfo);
    }

    static Predicate<String> toGlobPatternPredicate(final String str) {
        if (str.equals("*")) {
            return new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.q
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$toGlobPatternPredicate$0;
                    lambda$toGlobPatternPredicate$0 = ViewRegistry.lambda$toGlobPatternPredicate$0((String) obj);
                    return lambda$toGlobPatternPredicate$0;
                }
            };
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '*' || charAt == '?') {
                final Pattern regexPattern = toRegexPattern(str);
                return new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.r
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean lambda$toGlobPatternPredicate$1;
                        lambda$toGlobPatternPredicate$1 = ViewRegistry.lambda$toGlobPatternPredicate$1(regexPattern, (String) obj);
                        return lambda$toGlobPatternPredicate$1;
                    }
                };
            }
        }
        return new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.view.s
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equalsIgnoreCase((String) obj);
            }
        };
    }

    private static Pattern toRegexPattern(String str) {
        StringBuilder sb5 = new StringBuilder();
        int i3 = -1;
        for (int i16 = 0; i16 < str.length(); i16++) {
            char charAt = str.charAt(i16);
            if (charAt != '*' && charAt != '?') {
                if (i3 == -1) {
                    i3 = i16;
                }
            } else {
                if (i3 != -1) {
                    sb5.append(Pattern.quote(str.substring(i3, i16)));
                    i3 = -1;
                }
                if (charAt == '*') {
                    sb5.append(".*");
                } else {
                    sb5.append(".");
                }
            }
        }
        if (i3 != -1) {
            sb5.append(Pattern.quote(str.substring(i3)));
        }
        return Pattern.compile(sb5.toString());
    }

    public List<RegisteredView> findViews(InstrumentDescriptor instrumentDescriptor, InstrumentationScopeInfo instrumentationScopeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentDescriptor, (Object) instrumentationScopeInfo);
        }
        ArrayList arrayList = new ArrayList();
        for (RegisteredView registeredView : this.reverseRegistration) {
            if (matchesSelector(registeredView.getInstrumentSelector(), instrumentDescriptor, instrumentationScopeInfo)) {
                if (((AggregatorFactory) registeredView.getView().getAggregation()).isCompatibleWithInstrument(instrumentDescriptor)) {
                    arrayList.add(registeredView);
                } else {
                    DefaultPrintLogger.w(TAG, "View aggregation " + AggregationUtil.aggregationName(registeredView.getView().getAggregation()) + " is incompatible with instrument " + instrumentDescriptor.getName() + " of type " + instrumentDescriptor.getType());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.singletonList(DEFAULT_REGISTERED_VIEW);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
