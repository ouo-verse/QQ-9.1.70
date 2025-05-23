package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.TestClass;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RuleMemberValidator {
    public static final RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR;
    public static final RuleMemberValidator CLASS_RULE_VALIDATOR;
    public static final RuleMemberValidator RULE_METHOD_VALIDATOR;
    public static final RuleMemberValidator RULE_VALIDATOR;
    private final Class<? extends Annotation> annotation;
    private final boolean methods;
    private final List<RuleValidator> validatorStrategies;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private final Class<? extends Annotation> annotation;
        private boolean methods;
        private final List<RuleValidator> validators;

        RuleMemberValidator build() {
            return new RuleMemberValidator(this);
        }

        Builder forMethods() {
            this.methods = true;
            return this;
        }

        Builder withValidator(RuleValidator ruleValidator) {
            this.validators.add(ruleValidator);
            return this;
        }

        Builder(Class<? extends Annotation> cls) {
            this.annotation = cls;
            this.methods = false;
            this.validators = new ArrayList();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class DeclaringClassMustBePublic implements RuleValidator {
        DeclaringClassMustBePublic() {
        }

        private boolean isDeclaringClassPublic(FrameworkMember<?> frameworkMember) {
            return Modifier.isPublic(frameworkMember.getDeclaringClass().getModifiers());
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!isDeclaringClassPublic(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must be declared in a public class."));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class FieldMustBeARule implements RuleValidator {
        FieldMustBeARule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.isRuleType(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must implement MethodRule or TestRule."));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class FieldMustBeATestRule implements RuleValidator {
        FieldMustBeATestRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.isTestRule(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must implement TestRule."));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class MemberMustBeNonStaticOrAlsoClassRule implements RuleValidator {
        MemberMustBeNonStaticOrAlsoClassRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            boolean z16;
            String str;
            boolean isMethodRule = RuleMemberValidator.isMethodRule(frameworkMember);
            if (frameworkMember.getAnnotation(ClassRule.class) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (frameworkMember.isStatic()) {
                if (isMethodRule || !z16) {
                    if (RuleMemberValidator.isMethodRule(frameworkMember)) {
                        str = "must not be static.";
                    } else {
                        str = "must not be static or it must be annotated with @ClassRule.";
                    }
                    list.add(new ValidationError(frameworkMember, cls, str));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class MemberMustBePublic implements RuleValidator {
        MemberMustBePublic() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!frameworkMember.isPublic()) {
                list.add(new ValidationError(frameworkMember, cls, "must be public."));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class MemberMustBeStatic implements RuleValidator {
        MemberMustBeStatic() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!frameworkMember.isStatic()) {
                list.add(new ValidationError(frameworkMember, cls, "must be static."));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class MethodMustBeARule implements RuleValidator {
        MethodMustBeARule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.isRuleType(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must return an implementation of MethodRule or TestRule."));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class MethodMustBeATestRule implements RuleValidator {
        MethodMustBeATestRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.isTestRule(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must return an implementation of TestRule."));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface RuleValidator {
        void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list);
    }

    static {
        CLASS_RULE_VALIDATOR = classRuleValidatorBuilder().withValidator(new DeclaringClassMustBePublic()).withValidator(new MemberMustBeStatic()).withValidator(new MemberMustBePublic()).withValidator(new FieldMustBeATestRule()).build();
        RULE_VALIDATOR = testRuleValidatorBuilder().withValidator(new MemberMustBeNonStaticOrAlsoClassRule()).withValidator(new MemberMustBePublic()).withValidator(new FieldMustBeARule()).build();
        CLASS_RULE_METHOD_VALIDATOR = classRuleValidatorBuilder().forMethods().withValidator(new DeclaringClassMustBePublic()).withValidator(new MemberMustBeStatic()).withValidator(new MemberMustBePublic()).withValidator(new MethodMustBeATestRule()).build();
        RULE_METHOD_VALIDATOR = testRuleValidatorBuilder().forMethods().withValidator(new MemberMustBeNonStaticOrAlsoClassRule()).withValidator(new MemberMustBePublic()).withValidator(new MethodMustBeARule()).build();
    }

    RuleMemberValidator(Builder builder) {
        this.annotation = builder.annotation;
        this.methods = builder.methods;
        this.validatorStrategies = builder.validators;
    }

    private static Builder classRuleValidatorBuilder() {
        return new Builder(ClassRule.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMethodRule(FrameworkMember<?> frameworkMember) {
        return MethodRule.class.isAssignableFrom(frameworkMember.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRuleType(FrameworkMember<?> frameworkMember) {
        if (!isMethodRule(frameworkMember) && !isTestRule(frameworkMember)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTestRule(FrameworkMember<?> frameworkMember) {
        return TestRule.class.isAssignableFrom(frameworkMember.getType());
    }

    private static Builder testRuleValidatorBuilder() {
        return new Builder(Rule.class);
    }

    private void validateMember(FrameworkMember<?> frameworkMember, List<Throwable> list) {
        Iterator<RuleValidator> it = this.validatorStrategies.iterator();
        while (it.hasNext()) {
            it.next().validate(frameworkMember, this.annotation, list);
        }
    }

    public void validate(TestClass testClass, List<Throwable> list) {
        List annotatedFields;
        if (this.methods) {
            annotatedFields = testClass.getAnnotatedMethods(this.annotation);
        } else {
            annotatedFields = testClass.getAnnotatedFields(this.annotation);
        }
        Iterator it = annotatedFields.iterator();
        while (it.hasNext()) {
            validateMember((FrameworkMember) it.next(), list);
        }
    }
}
