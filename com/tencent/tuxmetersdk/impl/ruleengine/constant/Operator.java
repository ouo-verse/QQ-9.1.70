package com.tencent.tuxmetersdk.impl.ruleengine.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class Operator {
    private static final /* synthetic */ Operator[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final Operator ALL;
    public static final Operator ALL_SORT;
    public static final Operator ALL_TIMER;
    public static final Operator ANY;
    public static final Operator ANY_SORT;
    public static final Operator EQ;
    public static final Operator GT;
    public static final Operator LT;
    private static final Map<String, Operator> MAP;
    public static final Operator STAY_TIME_EQ;
    public static final Operator STAY_TIME_GT;
    private static final String[] VERSIONS;
    private final String name;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        Operator operator = new Operator("ANY", 0, SemanticAttributes.DbCassandraConsistencyLevelValues.ANY);
        ANY = operator;
        Operator operator2 = new Operator("ALL", 1, "all");
        ALL = operator2;
        Operator operator3 = new Operator("ALL_SORT", 2, "all_sort");
        ALL_SORT = operator3;
        Operator operator4 = new Operator("ANY_SORT", 3, "any_sort");
        ANY_SORT = operator4;
        Operator operator5 = new Operator("ALL_TIMER", 4, "all_timer");
        ALL_TIMER = operator5;
        Operator operator6 = new Operator("GT", 5, "gt");
        GT = operator6;
        Operator operator7 = new Operator("LT", 6, "lt");
        LT = operator7;
        Operator operator8 = new Operator("EQ", 7, "equals");
        EQ = operator8;
        Operator operator9 = new Operator("STAY_TIME_GT", 8, "stay_time_gt");
        STAY_TIME_GT = operator9;
        Operator operator10 = new Operator("STAY_TIME_EQ", 9, "stay_time_eq");
        STAY_TIME_EQ = operator10;
        $VALUES = new Operator[]{operator, operator2, operator3, operator4, operator5, operator6, operator7, operator8, operator9, operator10};
        MAP = new HashMap();
        VERSIONS = new String[]{"", "_v2"};
        for (Operator operator11 : values()) {
            for (String str : VERSIONS) {
                MAP.put(String.format("%s%s", operator11.name, str), operator11);
            }
        }
    }

    Operator(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.name = str2;
        }
    }

    public static boolean isSortOperator(Operator operator) {
        if (operator != ALL_SORT && operator != ANY_SORT) {
            return false;
        }
        return true;
    }

    public static Operator valueOf(String str) {
        return (Operator) Enum.valueOf(Operator.class, str);
    }

    public static Operator valueOfName(String str) {
        return MAP.get(str);
    }

    public static Operator[] values() {
        return (Operator[]) $VALUES.clone();
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }
}
