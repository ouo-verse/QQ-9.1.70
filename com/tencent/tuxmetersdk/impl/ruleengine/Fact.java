package com.tencent.tuxmetersdk.impl.ruleengine;

import com.google.gson.JsonObject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import java.util.Date;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Fact {
    static IPatchRedirector $redirector_;
    private final CalcRuleFunc calcRuleFunc;
    private String filter;
    private final String identifier;
    private String key;
    private final TuxEvent resetTuxEvent;
    private Date startTime;
    private final TuxEvent tuxEvent;
    private Object value;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        private CalcRuleFunc calcRuleFunc;
        private String filter;
        private String key;
        private JsonObject params;
        private TuxEvent resetTuxEvent;
        private TuxEvent tuxEvent;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public Fact build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Fact) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return new Fact(this, null);
        }

        public Builder calcRuleFunc(CalcRuleFunc calcRuleFunc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) calcRuleFunc);
            }
            this.calcRuleFunc = calcRuleFunc;
            return this;
        }

        public Builder event(TuxEvent tuxEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) tuxEvent);
            }
            this.tuxEvent = tuxEvent;
            return this;
        }

        public Builder filter(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.filter = str;
            return this;
        }

        public Builder key(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.key = str;
            return this;
        }

        public Builder resetEvent(TuxEvent tuxEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tuxEvent);
            }
            this.resetTuxEvent = tuxEvent;
            return this;
        }
    }

    /* synthetic */ Fact(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    public void calculate(TuxEvent tuxEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tuxEvent);
            return;
        }
        CalcRuleFunc calcRuleFunc = this.calcRuleFunc;
        if (calcRuleFunc == CalcRuleFunc.COUNT) {
            TuxEvent tuxEvent2 = this.resetTuxEvent;
            if (tuxEvent2 != null && tuxEvent != null && tuxEvent.contain(tuxEvent2, this.filter)) {
                this.startTime = tuxEvent.getEventTime();
                this.value = 0;
            }
            if (tuxEvent != null && tuxEvent.contain(this.tuxEvent, this.filter)) {
                this.value = String.valueOf(Long.parseLong(this.value.toString()) + 1);
                return;
            }
            return;
        }
        if (calcRuleFunc == CalcRuleFunc.CURRENT_TIME_DIFF) {
            TuxEvent tuxEvent3 = this.resetTuxEvent;
            if (tuxEvent3 != null && tuxEvent != null && tuxEvent.contain(tuxEvent3, this.filter)) {
                this.startTime = tuxEvent.getEventTime();
                this.value = 0;
            }
            if (this.startTime == null) {
                return;
            }
            this.value = Long.valueOf(new Date().getTime() - this.startTime.getTime());
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fact)) {
            return false;
        }
        return getIdentifier().equals(((Fact) obj).getIdentifier());
    }

    public String getIdentifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.identifier;
    }

    public Object getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return Objects.hash(getIdentifier());
    }

    Fact(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.key = builder.key;
        CalcRuleFunc calcRuleFunc = builder.calcRuleFunc;
        this.calcRuleFunc = calcRuleFunc;
        this.filter = builder.filter;
        this.tuxEvent = builder.tuxEvent;
        TuxEvent tuxEvent = builder.resetTuxEvent;
        this.resetTuxEvent = tuxEvent;
        this.identifier = String.format("%s_%s_%s_%s", this.key, this.filter, calcRuleFunc, tuxEvent);
        if (calcRuleFunc == CalcRuleFunc.COUNT || calcRuleFunc == CalcRuleFunc.CURRENT_TIME_DIFF) {
            this.value = 0;
        }
    }
}
