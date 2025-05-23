package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.internal.ImmutableKeyValuePairs;
import com.tencent.opentelemetry.api.internal.StringUtils;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.Scope;
import com.tencent.opentelemetry.context.h;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class ImmutableBaggage extends ImmutableKeyValuePairs<String, BaggageEntry> implements Baggage {
    static IPatchRedirector $redirector_;
    private static final Baggage EMPTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder implements BaggageBuilder {
        static IPatchRedirector $redirector_;
        private final List<Object> data;

        Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.data = new ArrayList();
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.opentelemetry.api.baggage.BaggageBuilder
        public Baggage build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return ImmutableBaggage.sortAndFilterToBaggage(this.data.toArray());
            }
            return (Baggage) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.baggage.BaggageBuilder
        public /* synthetic */ BaggageBuilder put(String str, String str2) {
            return b.a(this, str, str2);
        }

        @Override // com.tencent.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder remove(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (BaggageBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            if (str == null) {
                return this;
            }
            this.data.add(str);
            this.data.add(null);
            return this;
        }

        @Override // com.tencent.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BaggageBuilder) iPatchRedirector.redirect((short) 3, this, str, str2, baggageEntryMetadata);
            }
            if (ImmutableBaggage.isKeyValid(str) && ImmutableBaggage.isValueValid(str2) && baggageEntryMetadata != null) {
                this.data.add(str);
                this.data.add(ImmutableEntry.create(str2, baggageEntryMetadata));
            }
            return this;
        }

        Builder(List<Object> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.data = list;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15923);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            EMPTY = new Builder().build();
        }
    }

    ImmutableBaggage(Object[] objArr) {
        super(objArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BaggageBuilder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Baggage empty() {
        return EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isKeyValid(String str) {
        if (str != null && !str.isEmpty() && StringUtils.isPrintableString(str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValueValid(String str) {
        if (str != null && StringUtils.isPrintableString(str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Baggage sortAndFilterToBaggage(Object[] objArr) {
        return new ImmutableBaggage(objArr);
    }

    @Override // com.tencent.opentelemetry.api.baggage.Baggage
    @Nullable
    public String getEntryValue(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        BaggageEntry baggageEntry = get(str);
        if (baggageEntry != null) {
            return baggageEntry.getValue();
        }
        return null;
    }

    @Override // com.tencent.opentelemetry.context.ImplicitContextKeyed
    public /* synthetic */ Scope makeCurrent() {
        return h.a(this);
    }

    @Override // com.tencent.opentelemetry.api.baggage.Baggage, com.tencent.opentelemetry.context.ImplicitContextKeyed
    public /* synthetic */ Context storeInContext(Context context) {
        return a.b(this, context);
    }

    @Override // com.tencent.opentelemetry.api.baggage.Baggage
    public BaggageBuilder toBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaggageBuilder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new Builder(new ArrayList(data()));
    }
}
