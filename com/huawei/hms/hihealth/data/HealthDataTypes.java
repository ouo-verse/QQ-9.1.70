package com.huawei.hms.hihealth.data;

import java.util.Arrays;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HealthDataTypes {
    public static final DataType DT_APPETITE;
    public static final DataType DT_CGM_BLOOD_GLUCOSE;
    public static final DataType DT_CONTINUOUS_MENSTRUAL_FLOW;
    public static final DataType DT_DYSMENORRHOEA;
    public static final DataType DT_HEALTH_RECORD_BRADYCARDIA;
    public static final DataType DT_HEALTH_RECORD_MENSTRUAL_CYCLE;
    public static final DataType DT_HEALTH_RECORD_SLEEP;
    public static final DataType DT_HEALTH_RECORD_TACHYCARDIA;
    public static final DataType DT_HEALTH_RECORD_VENTILATOR;
    public static final DataType DT_INSTANTANEOUS_BLOOD_GLUCOSE;
    public static final DataType DT_INSTANTANEOUS_BLOOD_PRESSURE = new DataType("com.huawei.instantaneous.blood_pressure", Scopes.HEALTHKIT_BLOODPRESSURE_READ, Scopes.HEALTHKIT_BLOODPRESSURE_WRITE, Scopes.HEALTHKIT_BLOODPRESSURE_BOTH, Arrays.asList(HealthFields.FIELD_SYSTOLIC_PRESSURE, HealthFields.FIELD_DIASTOLIC_PRESSURE, HealthFields.FIELD_BODY_POSTURE, HealthFields.FIELD_MEASURE_BODY_PART_OF_BLOOD_PRESSURE, HealthFields.FIELD_SPHYGMUS, HealthFields.FIELD_MEASUREMENT_ANOMALY_FLAG, HealthFields.FIELD_MEASUREMENT_REMINDER, HealthFields.FIELD_BEFORE_MEASURE_ACTIVITY));
    public static final DataType DT_INSTANTANEOUS_BODY_TEMPERATURE;
    public static final DataType DT_INSTANTANEOUS_BODY_TEMPERATURE_REST;
    public static final DataType DT_INSTANTANEOUS_CERVICAL_MUCUS;
    public static final DataType DT_INSTANTANEOUS_CERVICAL_STATUS;
    public static final DataType DT_INSTANTANEOUS_OVULATION_DETECTION;
    public static final DataType DT_INSTANTANEOUS_SKIN_TEMPERATURE;
    public static final DataType DT_INSTANTANEOUS_SPO2;
    public static final DataType DT_INSTANTANEOUS_URIC_ACID;
    public static final DataType DT_INSTANTANEOUS_URINE_ROUTINE_BILIRUBIN;
    public static final DataType DT_INSTANTANEOUS_URINE_ROUTINE_GLUCOSE;
    public static final DataType DT_INSTANTANEOUS_URINE_ROUTINE_NITRITE;
    public static final DataType DT_INSTANTANEOUS_URINE_ROUTINE_UROBILINOGEN;
    public static final DataType DT_INSTANTANEOUS_VAGINAL_SPECKLE;
    public static final DataType DT_MOOD;
    public static final DataType DT_PHYSICAL_SYMPTOMS;
    public static final DataType DT_SEXUAL_ACTIVITY;
    public static final DataType DT_SKIN_STATUS;
    public static final DataType DT_SLEEP_RESPIRATORY_DETAIL;
    public static final DataType DT_SLEEP_RESPIRATORY_EVENT;
    public static final DataType POLYMERIZE_CGM_BLOOD_GLUCOSE_STATISTICS;
    public static final DataType POLYMERIZE_CONTINUOUS_BODY_BLOOD_GLUCOSE_STATISTICS;
    public static final DataType POLYMERIZE_CONTINUOUS_BODY_BLOOD_PRESSURE_STATISTICS;
    public static final DataType POLYMERIZE_CONTINUOUS_BODY_TEMPERATURE_REST_STATISTICS;
    public static final DataType POLYMERIZE_CONTINUOUS_BODY_TEMPERATURE_STATISTICS;
    public static final DataType POLYMERIZE_CONTINUOUS_MENSTRUAL_FLOW;
    public static final DataType POLYMERIZE_CONTINUOUS_SKIN_TEMPERATURE_STATISTICS;
    public static final DataType POLYMERIZE_CONTINUOUS_SPO2_STATISTICS;
    public static final DataType POLYMERIZE_INSTANTANEOUS_CERVICAL_MUCUS;
    public static final DataType POLYMERIZE_INSTANTANEOUS_CERVICAL_STATUS;
    public static final DataType POLYMERIZE_INSTANTANEOUS_OVULATION_DETECTION;
    public static final DataType POLYMERIZE_INSTANTANEOUS_VAGINAL_SPECKLE;

    static {
        Field field = HealthFields.FIELD_LEVEL;
        Field field2 = HealthFields.FIELD_SAMPLE_SOURCE;
        DT_INSTANTANEOUS_BLOOD_GLUCOSE = new DataType("com.huawei.instantaneous.blood_glucose", Scopes.HEALTHKIT_BLOODGLUCOSE_READ, Scopes.HEALTHKIT_BLOODGLUCOSE_WRITE, Scopes.HEALTHKIT_BLOODGLUCOSE_BOTH, Arrays.asList(field, HealthFields.FIELD_MEASURE_TIME, field2));
        DT_CGM_BLOOD_GLUCOSE = new DataType("com.huawei.cgm_blood_glucose", Scopes.HEALTHKIT_BLOODGLUCOSE_READ, Scopes.HEALTHKIT_BLOODGLUCOSE_WRITE, Scopes.HEALTHKIT_BLOODGLUCOSE_BOTH, Collections.singletonList(field));
        DT_INSTANTANEOUS_SPO2 = new DataType("com.huawei.instantaneous.spo2", "https://www.huawei.com/healthkit/oxygensaturation.read", "https://www.huawei.com/healthkit/oxygensaturation.write", "https://www.huawei.com/healthkit/oxygensaturation.both", Arrays.asList(HealthFields.FIELD_SATURATION, HealthFields.FIELD_OXYGEN_SUPPLY_FLOW_RATE, HealthFields.FIELD_OXYGEN_THERAPY, HealthFields.FIELD_SPO2_MEASUREMENT_MECHANISM, HealthFields.FIELD_SPO2_MEASUREMENT_APPROACH));
        Field field3 = HealthFields.FIELD_TEMPERATURE;
        Field field4 = HealthFields.FIELD_MEASURE_BODY_PART_OF_TEMPERATURE;
        DT_INSTANTANEOUS_BODY_TEMPERATURE = new DataType("com.huawei.instantaneous.body.temperature", Scopes.HEALTHKIT_BODYTEMPERATURE_READ, Scopes.HEALTHKIT_BODYTEMPERATURE_WRITE, Scopes.HEALTHKIT_BODYTEMPERATURE_BOTH, Arrays.asList(field3, field4));
        DT_INSTANTANEOUS_SKIN_TEMPERATURE = new DataType("com.huawei.instantaneous.skin.temperature", Scopes.HEALTHKIT_BODYTEMPERATURE_READ, Scopes.HEALTHKIT_BODYTEMPERATURE_WRITE, Scopes.HEALTHKIT_BODYTEMPERATURE_BOTH, Arrays.asList(field3, field4));
        DT_SLEEP_RESPIRATORY_DETAIL = new DataType("com.huawei.sleep_respiratory_detail", Scopes.HEALTHKIT_PULMONARY_READ, Scopes.HEALTHKIT_PULMONARY_WRITE, Scopes.HEALTHKIT_PULMONARY_BOTH, Arrays.asList(Field.SLEEP_RESPIRATORY_TYPE, Field.SLEEP_RESPIRATORY_VALUE));
        DT_SLEEP_RESPIRATORY_EVENT = new DataType("com.huawei.sleep_respiratory_event", Scopes.HEALTHKIT_PULMONARY_READ, Scopes.HEALTHKIT_PULMONARY_WRITE, Scopes.HEALTHKIT_PULMONARY_BOTH, Collections.singletonList(Field.EVENT_NAME));
        DT_INSTANTANEOUS_BODY_TEMPERATURE_REST = new DataType("com.huawei.instantaneous.body.temperature.rest", Scopes.HEALTHKIT_BODYTEMPERATURE_READ, Scopes.HEALTHKIT_BODYTEMPERATURE_WRITE, Scopes.HEALTHKIT_BODYTEMPERATURE_BOTH, Arrays.asList(field3, field4));
        Field field5 = HealthFields.FIELD_TEXTURE;
        Field field6 = HealthFields.FIELD_AMOUNT;
        DT_INSTANTANEOUS_CERVICAL_MUCUS = new DataType("com.huawei.instantaneous.cervical_mucus", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Arrays.asList(field5, field6));
        Field field7 = HealthFields.FIELD_POSITION;
        Field field8 = HealthFields.FIELD_DILATION_STATUS;
        Field field9 = HealthFields.FIELD_FIRMNESS_LEVEL;
        DT_INSTANTANEOUS_CERVICAL_STATUS = new DataType("com.huawei.instantaneous.cervical_status", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Arrays.asList(field7, field8, field9));
        Field field10 = HealthFields.FIELD_VOLUME;
        DT_CONTINUOUS_MENSTRUAL_FLOW = new DataType("com.huawei.continuous.menstrual_flow", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(field10));
        Field field11 = HealthFields.FIELD_DETECTION_RESULT;
        DT_INSTANTANEOUS_OVULATION_DETECTION = new DataType("com.huawei.instantaneous.ovulation_detection", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(field11));
        Field field12 = Field.FIELD_APPEARANCE;
        DT_INSTANTANEOUS_VAGINAL_SPECKLE = new DataType("com.huawei.instantaneous.vaginal_speckle", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(field12));
        DT_INSTANTANEOUS_URIC_ACID = new DataType("com.huawei.instantaneous.uric_acid", "https://www.huawei.com/healthkit/uricacid.read", "https://www.huawei.com/healthkit/uricacid.write", "https://www.huawei.com/healthkit/uricacid.both", Collections.singletonList(HealthFields.FIELD_URIC_ACID));
        DT_INSTANTANEOUS_URINE_ROUTINE_NITRITE = new DataType("com.huawei.instantaneous.urine_routine.nitrite", "https://www.huawei.com/healthkit/urineroutine.read", "https://www.huawei.com/healthkit/urineroutine.write", "https://www.huawei.com/healthkit/urineroutine.both", Collections.singletonList(HealthFields.FIELD_NITRITE));
        DT_INSTANTANEOUS_URINE_ROUTINE_UROBILINOGEN = new DataType("com.huawei.instantaneous.urine_routine.urobilinogen", "https://www.huawei.com/healthkit/urineroutine.read", "https://www.huawei.com/healthkit/urineroutine.write", "https://www.huawei.com/healthkit/urineroutine.both", Collections.singletonList(HealthFields.FIELD_UROBILINOGEN));
        DT_INSTANTANEOUS_URINE_ROUTINE_BILIRUBIN = new DataType("com.huawei.instantaneous.urine_routine.bilirubin", "https://www.huawei.com/healthkit/urineroutine.read", "https://www.huawei.com/healthkit/urineroutine.write", "https://www.huawei.com/healthkit/urineroutine.both", Collections.singletonList(HealthFields.FIELD_BILIRUBIN));
        DT_INSTANTANEOUS_URINE_ROUTINE_GLUCOSE = new DataType("com.huawei.instantaneous.urine_routine.glucose", "https://www.huawei.com/healthkit/urineroutine.read", "https://www.huawei.com/healthkit/urineroutine.write", "https://www.huawei.com/healthkit/urineroutine.both", Collections.singletonList(HealthFields.FIELD_GLUCOSE));
        Field field13 = HealthFields.FIELD_THRESHOLD;
        Field field14 = HealthFields.FIELD_AVG_HEART_RATE;
        Field field15 = HealthFields.FIELD_MAX_HEART_RATE;
        Field field16 = HealthFields.FIELD_MIN_HEART_RATE;
        DT_HEALTH_RECORD_TACHYCARDIA = new DataType("com.huawei.health.record.tachycardia", Scopes.HEALTHKIT_HEARTHEALTH_READ, Scopes.HEALTHKIT_HEARTHEALTH_WRITE, Scopes.HEALTHKIT_HEARTHEALTH_BOTH, Arrays.asList(field13, field14, field15, field16));
        DT_HEALTH_RECORD_BRADYCARDIA = new DataType("com.huawei.health.record.bradycardia", Scopes.HEALTHKIT_HEARTHEALTH_READ, Scopes.HEALTHKIT_HEARTHEALTH_WRITE, Scopes.HEALTHKIT_HEARTHEALTH_BOTH, Arrays.asList(field13, field14, field15, field16));
        DT_HEALTH_RECORD_SLEEP = new DataType("com.huawei.health.record.sleep", Scopes.HEALTHKIT_SLEEP_READ, Scopes.HEALTHKIT_SLEEP_WRITE, Scopes.HEALTHKIT_SLEEP_BOTH, Arrays.asList(Field.FALL_ASLEEP_TIME, Field.WAKE_UP_TIME, Field.LIGHT_SLEEP_TIME, Field.DEEP_SLEEP_TIME, Field.DREAM_TIME, Field.AWAKE_TIME, Field.ALL_SLEEP_TIME, Field.WAKE_UP_CNT, Field.DEEP_SLEEP_PART, Field.SLEEP_SCORE, Field.SLEEP_LATENCY, Field.SLEEP_EFFICIENCY, Field.GO_BED_TIME_NEW, Field.SLEEP_TYPE, Field.PREPARE_SLEEP_TIME, Field.OFF_BED_TIME));
        DT_HEALTH_RECORD_VENTILATOR = new DataType("com.huawei.health.record.ventilator", Scopes.HEALTHKIT_PULMONARY_READ, Scopes.HEALTHKIT_PULMONARY_WRITE, Scopes.HEALTHKIT_PULMONARY_BOTH, Arrays.asList(HealthFields.SYS_MODE, HealthFields.SYS_SESSION_DATE, HealthFields.EVENT_AHI, HealthFields.SYS_DURATION, HealthFields.LUMIS_TIDVOL_MEDIAN, HealthFields.LUMIS_TIDVOL, HealthFields.LUMIS_TIDVOL_MAX, HealthFields.CLINICAL_RESPRATE_MEDIAN, HealthFields.CLINICAL_RESP_RATE, HealthFields.CLINICAL_RESP_RATE_MAX, HealthFields.LUMIS_IERATIO_MEDIAN, HealthFields.LUMIS_IERATIO_QUANTILE, HealthFields.LUMIS_IERATIO_MAX, HealthFields.MASK_OFF, HealthFields.HYPOVENTILATION_INDEX, HealthFields.OBSTRUCTIVE_APNEA_INDEX, HealthFields.PRESSURE_BELOW, HealthFields.HYPOVENTILATION_EVENT_TIMES, HealthFields.SNORING_EVENT_TIMES, HealthFields.OBSTRUCTIVE_APNEA_EVENT_TIMES, HealthFields.CENTER_APNEA_EVENT_TIMES, HealthFields.AIR_FLOW_LIMIT_EVENT_TIMES, HealthFields.MASSIVE_LEAK_EVENT_TIMES, HealthFields.UNKNOW_EVENT_TIMES, HealthFields.ALL_EVENT_TIMES));
        DT_HEALTH_RECORD_MENSTRUAL_CYCLE = new DataType("com.huawei.health.record.menstrual_cycle", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Arrays.asList(HealthFields.FIELD_RECORD_DAY, HealthFields.FIELD_STATUS, HealthFields.FIELD_SUB_STATUS, HealthFields.FIELD_REMARKS, HealthFields.FIELD_TIME_ZONE));
        POLYMERIZE_CONTINUOUS_BODY_BLOOD_PRESSURE_STATISTICS = new DataType("com.huawei.continuous.body.blood_pressure.statistics", Scopes.HEALTHKIT_BLOODPRESSURE_READ, Scopes.HEALTHKIT_BLOODPRESSURE_WRITE, Scopes.HEALTHKIT_BLOODPRESSURE_BOTH, Arrays.asList(HealthFields.FIELD_SYSTOLIC_PRESSURE_AVG, HealthFields.FIELD_SYSTOLIC_PRESSURE_MAX, HealthFields.FIELD_SYSTOLIC_PRESSURE_MIN, HealthFields.FIELD_SYSTOLIC_PRESSURE_LAST, HealthFields.FIELD_DIASTOLIC_PRESSURE_AVG, HealthFields.FIELD_DIASTOLIC_PRESSURE_MAX, HealthFields.FIELD_DIASTOLIC_PRESSURE_MIN, HealthFields.FIELD_DIASTOLIC_PRESSURE_LAST, HealthFields.FIELD_SPHYGMUS_AVG, HealthFields.FIELD_SPHYGMUS_MAX, HealthFields.FIELD_SPHYGMUS_MIN, HealthFields.FIELD_SPHYGMUS_LAST)).setPolymerized();
        Field field17 = Field.FIELD_AVG;
        Field field18 = Field.FIELD_MAX;
        Field field19 = Field.FIELD_MIN;
        POLYMERIZE_CONTINUOUS_BODY_BLOOD_GLUCOSE_STATISTICS = new DataType("com.huawei.continuous.blood_glucose.statistics", Scopes.HEALTHKIT_BLOODGLUCOSE_READ, Scopes.HEALTHKIT_BLOODGLUCOSE_WRITE, Scopes.HEALTHKIT_BLOODGLUCOSE_BOTH, Arrays.asList(field17, field18, field19, HealthFields.FIELD_CORRELATION_WITH_MEALTIME, Field.FIELD_MEAL, HealthFields.FIELD_CORRELATION_WITH_SLEEP_STATE, field2)).setPolymerized();
        Field field20 = Field.FIELD_LAST;
        POLYMERIZE_CGM_BLOOD_GLUCOSE_STATISTICS = new DataType("com.huawei.cgm_blood_glucose.statistics", Scopes.HEALTHKIT_BLOODGLUCOSE_READ, Scopes.HEALTHKIT_BLOODGLUCOSE_WRITE, Scopes.HEALTHKIT_BLOODGLUCOSE_BOTH, Arrays.asList(field17, field18, field19, field20)).setPolymerized();
        POLYMERIZE_CONTINUOUS_SPO2_STATISTICS = new DataType("com.huawei.continuous.spo2.statistics", "https://www.huawei.com/healthkit/oxygensaturation.read", "https://www.huawei.com/healthkit/oxygensaturation.write", "https://www.huawei.com/healthkit/oxygensaturation.both", Arrays.asList(HealthFields.FIELD_SATURATION_AVG, HealthFields.FIELD_SATURATION_MAX, HealthFields.FIELD_SATURATION_MIN, HealthFields.FIELD_SATURATION_LAST)).setPolymerized();
        POLYMERIZE_CONTINUOUS_BODY_TEMPERATURE_STATISTICS = new DataType("com.huawei.continuous.body.temperature.statistics", Scopes.HEALTHKIT_BODYTEMPERATURE_READ, Scopes.HEALTHKIT_BODYTEMPERATURE_WRITE, Scopes.HEALTHKIT_BODYTEMPERATURE_BOTH, Arrays.asList(field17, field18, field19, field20)).setPolymerized();
        POLYMERIZE_CONTINUOUS_SKIN_TEMPERATURE_STATISTICS = new DataType("com.huawei.continuous.skin.temperature.statistics", Scopes.HEALTHKIT_BODYTEMPERATURE_READ, Scopes.HEALTHKIT_BODYTEMPERATURE_WRITE, Scopes.HEALTHKIT_BODYTEMPERATURE_BOTH, Arrays.asList(field17, field18, field19)).setPolymerized();
        POLYMERIZE_CONTINUOUS_BODY_TEMPERATURE_REST_STATISTICS = new DataType("com.huawei.continuous.body.temperature.rest.statistics", Scopes.HEALTHKIT_BODYTEMPERATURE_READ, Scopes.HEALTHKIT_BODYTEMPERATURE_WRITE, Scopes.HEALTHKIT_BODYTEMPERATURE_BOTH, Arrays.asList(field17, field18, field19)).setPolymerized();
        POLYMERIZE_INSTANTANEOUS_CERVICAL_MUCUS = new DataType("com.huawei.instantaneous.cervical_mucus", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Arrays.asList(field5, field6)).setPolymerized();
        POLYMERIZE_INSTANTANEOUS_CERVICAL_STATUS = new DataType("com.huawei.instantaneous.cervical_status", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Arrays.asList(field7, field8, field9)).setPolymerized();
        POLYMERIZE_CONTINUOUS_MENSTRUAL_FLOW = new DataType("com.huawei.continuous.menstrual_flow", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(field10)).setPolymerized();
        POLYMERIZE_INSTANTANEOUS_OVULATION_DETECTION = new DataType("com.huawei.instantaneous.ovulation_detection", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(field11)).setPolymerized();
        POLYMERIZE_INSTANTANEOUS_VAGINAL_SPECKLE = new DataType("com.huawei.instantaneous.vaginal_speckle", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(field12)).setPolymerized();
        DT_DYSMENORRHOEA = new DataType("com.huawei.dysmenorrhoea", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(HealthFields.FIELD_DYSMENORRHOEA_LEVEL));
        DT_PHYSICAL_SYMPTOMS = new DataType("com.huawei.physical_symptoms", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(HealthFields.FIELD_PHYSICAL_SYMPTOMS));
        DT_MOOD = new DataType("com.huawei.mood", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(HealthFields.FIELD_MOOD));
        DT_SKIN_STATUS = new DataType("com.huawei.skin_status", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(HealthFields.FIELD_SKIN_STATUS));
        DT_APPETITE = new DataType("com.huawei.appetite", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(HealthFields.FIELD_APPETITE));
        DT_SEXUAL_ACTIVITY = new DataType("com.huawei.sexual_activity", Scopes.HEALTHKIT_REPRODUCTIVE_READ, Scopes.HEALTHKIT_REPRODUCTIVE_WRITE, Scopes.HEALTHKIT_REPRODUCTIVE_BOTH, Collections.singletonList(HealthFields.FIELD_CONTRACEPTIVE_MEASURES));
    }

    HealthDataTypes() {
    }
}
