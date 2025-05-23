package com.tencent.tuxmetersdk.export.injector.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes27.dex */
public class RuleProcessInfo {
    static IPatchRedirector $redirector_;
    private final Double actualProbability;
    private final List<String> candidateSurveyIDs;
    private final Integer choseIndex;
    private final Boolean fatherRule;
    private final Boolean hitProbability;

    /* renamed from: id, reason: collision with root package name */
    private final String f383469id;
    private final Double probability;
    private final String rule;

    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        Double actualProbability;
        List<String> candidateSurveyIDs;
        Integer choseIndex;
        Boolean fatherRule;
        Boolean hitProbability;

        /* renamed from: id, reason: collision with root package name */
        String f383470id;
        Double probability;
        String rule;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public Builder actualProbability(Double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) d16);
            }
            this.actualProbability = d16;
            return this;
        }

        public RuleProcessInfo build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (RuleProcessInfo) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return new RuleProcessInfo(this, null);
        }

        public Builder candidateSurveyIDs(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            }
            this.candidateSurveyIDs = list;
            return this;
        }

        public Builder choseIndex(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) num);
            }
            this.choseIndex = num;
            return this;
        }

        public Builder getSelf() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this;
        }

        public Builder id(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f383470id = str;
            return this;
        }

        public Builder isFatherRule(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bool);
            }
            this.fatherRule = bool;
            return this;
        }

        public Builder isHitProbability(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bool);
            }
            this.hitProbability = bool;
            return this;
        }

        public Builder probability(Double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) d16);
            }
            this.probability = d16;
            return this;
        }

        public Builder rule(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.rule = str;
            return this;
        }
    }

    /* synthetic */ RuleProcessInfo(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    public Double getActualProbability() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Double) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.actualProbability;
    }

    public List<String> getCandidateSurveyIDs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.candidateSurveyIDs;
    }

    public Integer getChoseIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Integer) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.choseIndex;
    }

    public String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f383469id;
    }

    public Double getProbability() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Double) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.probability;
    }

    public String getRule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.rule;
    }

    public Boolean isFatherRule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Boolean) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.fatherRule;
    }

    public Boolean isHitProbability() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Boolean) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.hitProbability;
    }

    RuleProcessInfo(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.f383469id = builder.f383470id;
        this.rule = builder.rule;
        this.probability = builder.probability;
        this.actualProbability = builder.actualProbability;
        this.fatherRule = builder.fatherRule;
        this.candidateSurveyIDs = builder.candidateSurveyIDs;
        this.choseIndex = builder.choseIndex;
        this.hitProbability = builder.hitProbability;
    }
}
