package com.huawei.hms.hihealth;

import com.huawei.hms.health.aabz;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class aabs {
    private static final Map<Scope, Scope> aab;

    static {
        HashMap hashMap = new HashMap();
        Scope scope = HuaweiHiHealth.SCOPE_HEALTHKIT_HEIGHTWEIGHT_READ;
        Scope scope2 = HuaweiHiHealth.SCOPE_HEALTHKIT_HEIGHTWEIGHT_BOTH;
        hashMap.put(scope, scope2);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_HEIGHTWEIGHT_WRITE, scope2);
        hashMap.put(scope2, scope2);
        Scope scope3 = HuaweiHiHealth.SCOPE_HEALTHKIT_STEP_READ;
        Scope scope4 = HuaweiHiHealth.SCOPE_HEALTHKIT_STEP_BOTH;
        hashMap.put(scope3, scope4);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_STEP_WRITE, scope4);
        hashMap.put(scope4, scope4);
        Scope scope5 = HuaweiHiHealth.SCOPE_HEALTHKIT_LOCATION_READ;
        Scope scope6 = HuaweiHiHealth.SCOPE_HEALTHKIT_LOCATION_BOTH;
        hashMap.put(scope5, scope6);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_LOCATION_WRITE, scope6);
        hashMap.put(scope6, scope6);
        Scope scope7 = HuaweiHiHealth.SCOPE_HEALTHKIT_HEARTRATE_READ;
        Scope scope8 = HuaweiHiHealth.SCOPE_HEALTHKIT_HEARTRATE_BOTH;
        hashMap.put(scope7, scope8);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_HEARTRATE_WRITE, scope8);
        hashMap.put(scope8, scope8);
        Scope scope9 = HuaweiHiHealth.SCOPE_HEALTHKIT_BLOODGLUCOSE_READ;
        Scope scope10 = HuaweiHiHealth.SCOPE_HEALTHKIT_BLOODGLUCOSE_BOTH;
        hashMap.put(scope9, scope10);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_BLOODGLUCOSE_WRITE, scope10);
        hashMap.put(scope10, scope10);
        Scope scope11 = HuaweiHiHealth.SCOPE_HEALTHKIT_DISTANCE_READ;
        Scope scope12 = HuaweiHiHealth.SCOPE_HEALTHKIT_DISTANCE_BOTH;
        hashMap.put(scope11, scope12);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_DISTANCE_WRITE, scope12);
        hashMap.put(scope12, scope12);
        Scope scope13 = HuaweiHiHealth.SCOPE_HEALTHKIT_SPEED_READ;
        Scope scope14 = HuaweiHiHealth.SCOPE_HEALTHKIT_SPEED_BOTH;
        hashMap.put(scope13, scope14);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_SPEED_WRITE, scope14);
        hashMap.put(scope14, scope14);
        Scope scope15 = HuaweiHiHealth.SCOPE_HEALTHKIT_CALORIES_READ;
        Scope scope16 = HuaweiHiHealth.SCOPE_HEALTHKIT_CALORIES_BOTH;
        hashMap.put(scope15, scope16);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_CALORIES_WRITE, scope16);
        hashMap.put(scope16, scope16);
        Scope scope17 = HuaweiHiHealth.SCOPE_HEALTHKIT_PULMONARY_READ;
        Scope scope18 = HuaweiHiHealth.SCOPE_HEALTHKIT_PULMONARY_BOTH;
        hashMap.put(scope17, scope18);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_PULMONARY_WRITE, scope18);
        hashMap.put(scope18, scope18);
        Scope scope19 = HuaweiHiHealth.SCOPE_HEALTHKIT_STRENGTH_READ;
        Scope scope20 = HuaweiHiHealth.SCOPE_HEALTHKIT_STRENGTH_BOTH;
        hashMap.put(scope19, scope20);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_STRENGTH_WRITE, scope20);
        hashMap.put(scope20, scope20);
        Scope scope21 = HuaweiHiHealth.SCOPE_HEALTHKIT_ACTIVITY_READ;
        Scope scope22 = HuaweiHiHealth.SCOPE_HEALTHKIT_ACTIVITY_BOTH;
        hashMap.put(scope21, scope22);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_ACTIVITY_WRITE, scope22);
        hashMap.put(scope22, scope22);
        Scope scope23 = HuaweiHiHealth.SCOPE_HEALTHKIT_BODYFAT_READ;
        Scope scope24 = HuaweiHiHealth.SCOPE_HEALTHKIT_BODYFAT_BOTH;
        hashMap.put(scope23, scope24);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_BODYFAT_WRITE, scope24);
        hashMap.put(scope24, scope24);
        Scope scope25 = HuaweiHiHealth.SCOPE_HEALTHKIT_SLEEP_READ;
        Scope scope26 = HuaweiHiHealth.SCOPE_HEALTHKIT_SLEEP_BOTH;
        hashMap.put(scope25, scope26);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_SLEEP_WRITE, scope26);
        hashMap.put(scope26, scope26);
        Scope scope27 = HuaweiHiHealth.SCOPE_HEALTHKIT_NUTRITION_READ;
        Scope scope28 = HuaweiHiHealth.SCOPE_HEALTHKIT_NUTRITION_BOTH;
        hashMap.put(scope27, scope28);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_NUTRITION_WRITE, scope28);
        hashMap.put(scope28, scope28);
        Scope scope29 = HuaweiHiHealth.SCOPE_HEALTHKIT_BLOODPRESSURE_READ;
        Scope scope30 = HuaweiHiHealth.SCOPE_HEALTHKIT_BLOODPRESSURE_BOTH;
        hashMap.put(scope29, scope30);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_BLOODPRESSURE_WRITE, scope30);
        hashMap.put(scope30, scope30);
        Scope scope31 = HuaweiHiHealth.SCOPE_HEALTHKIT_OXYGENSTATURATION_READ;
        Scope scope32 = HuaweiHiHealth.SCOPE_HEALTHKIT_OXYGENSTATURATION_BOTH;
        hashMap.put(scope31, scope32);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_OXYGENSTATURATION_WRITE, scope32);
        hashMap.put(scope32, scope32);
        Scope scope33 = HuaweiHiHealth.SCOPE_HEALTHKIT_OXYGEN_SATURATION_READ;
        Scope scope34 = HuaweiHiHealth.SCOPE_HEALTHKIT_OXYGEN_SATURATION_BOTH;
        hashMap.put(scope33, scope34);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_OXYGEN_SATURATION_WRITE, scope34);
        hashMap.put(scope34, scope34);
        Scope scope35 = HuaweiHiHealth.SCOPE_HEALTHKIT_BODYTEMPERATURE_READ;
        Scope scope36 = HuaweiHiHealth.SCOPE_HEALTHKIT_BODYTEMPERATURE_BOTH;
        hashMap.put(scope35, scope36);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_BODYTEMPERATURE_WRITE, scope36);
        hashMap.put(scope36, scope36);
        Scope scope37 = HuaweiHiHealth.SCOPE_HEALTHKIT_REPRODUCTIVE_WRITE;
        Scope scope38 = HuaweiHiHealth.SCOPE_HEALTHKIT_REPRODUCTIVE_BOTH;
        hashMap.put(scope37, scope38);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_REPRODUCTIVE_READ, scope38);
        hashMap.put(scope38, scope38);
        Scope scope39 = HuaweiHiHealth.SCOPE_HEALTHKIT_ACTIVITY_RECORD_READ;
        Scope scope40 = HuaweiHiHealth.SCOPE_HEALTHKIT_ACTIVITY_RECORD_BOTH;
        hashMap.put(scope39, scope40);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_ACTIVITY_RECORD_WRITE, scope40);
        hashMap.put(scope40, scope40);
        Scope scope41 = HuaweiHiHealth.SCOPE_HEALTHKIT_STRESS_READ;
        Scope scope42 = HuaweiHiHealth.SCOPE_HEALTHKIT_STRESS_BOTH;
        hashMap.put(scope41, scope42);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_STRESS_WRITE, scope42);
        hashMap.put(scope42, scope42);
        Scope scope43 = HuaweiHiHealth.SCOPE_HEALTHKIT_HEARTHEALTH_READ;
        Scope scope44 = HuaweiHiHealth.SCOPE_HEALTHKIT_HEARTHEALTH_BOTH;
        hashMap.put(scope43, scope44);
        hashMap.put(HuaweiHiHealth.SCOPE_HEALTHKIT_HEARTHEALTH_WRITE, scope44);
        hashMap.put(scope44, scope44);
        aab = Collections.unmodifiableMap(hashMap);
    }

    public static Set<Scope> aab(List<Scope> list) {
        if (list == null) {
            aabz.aab("ScopeWrapper", "scopeList is null.");
            return Collections.emptySet();
        }
        com.huawei.hms.health.aab.aab("input scopeList: ").append(list.toString());
        HashSet hashSet = new HashSet();
        for (Scope scope : list) {
            Scope scope2 = aab.get(scope);
            if (scope2 == null) {
                aabz.aabc("ScopeWrapper", "input scope is invalid");
                scope2 = new Scope("invalid scope");
            }
            if (scope2.equals(scope) || !list.contains(scope2)) {
                hashSet.add(scope);
            }
        }
        com.huawei.hms.health.aab.aab("scopeHashSet: ").append(hashSet.toString());
        return hashSet;
    }
}
