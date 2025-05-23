package com.huawei.hms.hihealth.data;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HealthFields {

    @Deprecated
    public static final int AMOUNT_HEAVY = 3;

    @Deprecated
    public static final int AMOUNT_LIGHT = 1;

    @Deprecated
    public static final int AMOUNT_MEDIUM = 2;

    @Deprecated
    public static final int BODY_POSTURE_LYING_DOWN = 3;

    @Deprecated
    public static final int BODY_POSTURE_SEMI_RECUMBENT = 4;

    @Deprecated
    public static final int BODY_POSTURE_SITTING = 2;

    @Deprecated
    public static final int BODY_POSTURE_STANDING = 1;

    @Deprecated
    public static final int CORRELATION_WITH_SLEEP_STATE_BEFORE_SLEEP = 2;

    @Deprecated
    public static final int CORRELATION_WITH_SLEEP_STATE_DURING_SLEEP = 4;

    @Deprecated
    public static final int CORRELATION_WITH_SLEEP_STATE_FULLY_AWAKE = 1;

    @Deprecated
    public static final int CORRELATION_WITH_SLEEP_STATE_ON_WAKING = 3;

    @Deprecated
    public static final int DETECTION_RESULT_NEGATIVE = 1;

    @Deprecated
    public static final int DETECTION_RESULT_POSITIVE = 2;

    @Deprecated
    public static final int DILATION_STATUS_CLOSED = 1;

    @Deprecated
    public static final int DILATION_STATUS_MEDIUM = 2;

    @Deprecated
    public static final int DILATION_STATUS_OPEN = 3;

    @Deprecated
    public static final int FIELD_CORRELATION_WITH_MEALTIME_AFTER_MEAL = 4;

    @Deprecated
    public static final int FIELD_CORRELATION_WITH_MEALTIME_BEFORE_MEAL = 3;

    @Deprecated
    public static final int FIELD_CORRELATION_WITH_MEALTIME_FASTING = 2;

    @Deprecated
    public static final int FIELD_CORRELATION_WITH_MEALTIME_GENERAL = 1;

    @Deprecated
    public static final int FIRMNESS_LEVEL_FIRM = 3;

    @Deprecated
    public static final int FIRMNESS_LEVEL_MEDIUM = 2;

    @Deprecated
    public static final int FIRMNESS_LEVEL_SOFT = 1;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_BLOOD_PRESSURE_LEFT_UPPER_ARM = 3;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_BLOOD_PRESSURE_LEFT_WRIST = 1;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_BLOOD_PRESSURE_RIGHT_UPPER_ARM = 4;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_BLOOD_PRESSURE_RIGHT_WRIST = 2;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_AXILLARY = 1;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_FINGER = 2;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_FOREHEAD = 3;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_ORAL = 4;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_RECTAL = 5;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_TEMPORAL_ARTERY = 6;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_TOE = 7;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_TYMPANIC = 8;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_VAGINAL = 10;

    @Deprecated
    public static final int MEASURE_BODY_PART_OF_TEMPERATURE_WRIST = 9;

    @Deprecated
    public static final int MEASURE_TIME_AFTER_BREAKFAST = 2;

    @Deprecated
    public static final int MEASURE_TIME_AFTER_DINNER = 6;

    @Deprecated
    public static final int MEASURE_TIME_AFTER_LUNCH = 4;

    @Deprecated
    public static final int MEASURE_TIME_BEFORE_BREAKFAST = 1;

    @Deprecated
    public static final int MEASURE_TIME_BEFORE_DAWN = 8;

    @Deprecated
    public static final int MEASURE_TIME_BEFORE_DINNER = 5;

    @Deprecated
    public static final int MEASURE_TIME_BEFORE_LUNCH = 3;

    @Deprecated
    public static final int MEASURE_TIME_BEFORE_SLEEP = 7;

    @Deprecated
    public static final int MEASURE_TIME_RANDOM_TIME = 9;

    @Deprecated
    public static final int OXYGEN_THERAPY_NASAL_CANULA = 1;

    @Deprecated
    public static final int POSITION_HIGH = 3;

    @Deprecated
    public static final int POSITION_LOW = 1;

    @Deprecated
    public static final int POSITION_MEDIUM = 2;

    @Deprecated
    public static final int SAMPLE_SOURCE_CAPILLARY_BLOOD = 2;

    @Deprecated
    public static final int SAMPLE_SOURCE_INTERSTITIAL_FLUID = 1;

    @Deprecated
    public static final int SAMPLE_SOURCE_PLASMA = 3;

    @Deprecated
    public static final int SAMPLE_SOURCE_SERUM = 4;

    @Deprecated
    public static final int SAMPLE_SOURCE_TEARS = 5;

    @Deprecated
    public static final int SAMPLE_SOURCE_WHOLE_BLOOD = 6;

    @Deprecated
    public static final int SPO2_MEASUREMENT_APPROACH_PULSE_OXIMETRY = 1;

    @Deprecated
    public static final int SPO2_MEASUREMENT_MECHANISM_PERIPHERAL_CAPILLARY = 1;

    @Deprecated
    public static final int TEXTURE_CREAMY = 3;

    @Deprecated
    public static final int TEXTURE_DRY = 1;

    @Deprecated
    public static final int TEXTURE_EGG_WHITE = 5;

    @Deprecated
    public static final int TEXTURE_STICKY = 2;

    @Deprecated
    public static final int TEXTURE_WATERY = 4;

    @Deprecated
    public static final int VOLUME_HEAVY = 4;

    @Deprecated
    public static final int VOLUME_LIGHT = 2;

    @Deprecated
    public static final int VOLUME_MEDIUM = 3;

    @Deprecated
    public static final int VOLUME_SPOTTING = 1;
    public static final Field FIELD_SYSTOLIC_PRESSURE = Field.newDoubleField("systolic_pressure");
    public static final Field FIELD_SYSTOLIC_PRESSURE_AVG = Field.newDoubleField("systolic_pressure_avg");
    public static final Field FIELD_SYSTOLIC_PRESSURE_MIN = Field.newDoubleField("systolic_pressure_min");
    public static final Field SYS_MODE = Field.newIntField("sysMode");
    public static final Field SYS_SESSION_DATE = Field.newLongField("sysSessionDate");
    public static final Field EVENT_AHI = Field.newDoubleField("eventAhi");
    public static final Field SYS_DURATION = Field.newIntField("sysDuration");
    public static final Field LUMIS_TIDVOL_MEDIAN = Field.newDoubleField("lumisTidvolMedian");
    public static final Field LUMIS_TIDVOL = Field.newDoubleField("lumisTidvol95");
    public static final Field LUMIS_TIDVOL_MAX = Field.newDoubleField("lumisTidvolMax");
    public static final Field CLINICAL_RESPRATE_MEDIAN = Field.newDoubleField("clinicalRespRateMedian");
    public static final Field CLINICAL_RESP_RATE = Field.newDoubleField("clinicalRespRate95");
    public static final Field CLINICAL_RESP_RATE_MAX = Field.newDoubleField("clinicalRespRateMax");
    public static final Field LUMIS_IERATIO_MEDIAN = Field.newDoubleField("lumisIeratioMedian");
    public static final Field LUMIS_IERATIO_QUANTILE = Field.newDoubleField("lumisIeratioQuantile95");
    public static final Field MASK_OFF = Field.newIntField("maskOff");
    public static final Field HYPOVENTILATION_INDEX = Field.newDoubleField("hypoventilationIndex");
    public static final Field OBSTRUCTIVE_APNEA_INDEX = Field.newDoubleField("obstructiveApneaIndex");
    public static final Field PRESSURE_BELOW = Field.newDoubleField("pressureBelow95");
    public static final Field HYPOVENTILATION_EVENT_TIMES = Field.newIntField("hypoventilationEventTimes");
    public static final Field LUMIS_IERATIO_MAX = Field.newDoubleField("lumisIeratioMax");
    public static final Field SNORING_EVENT_TIMES = Field.newIntField("snoringEventTimes");
    public static final Field CENTER_APNEA_EVENT_TIMES = Field.newIntField("obstructiveApneaEventTimes");
    public static final Field OBSTRUCTIVE_APNEA_EVENT_TIMES = Field.newIntField("centerApneaEventTimes");
    public static final Field AIR_FLOW_LIMIT_EVENT_TIMES = Field.newIntField("airflowLimitEventTimes");
    public static final Field MASSIVE_LEAK_EVENT_TIMES = Field.newIntField("massiveLeakEventTimes");
    public static final Field UNKNOW_EVENT_TIMES = Field.newIntField("unknowEventTimes");
    public static final Field ALL_EVENT_TIMES = Field.newIntField("allEventTimes");
    public static final Field FIELD_SYSTOLIC_PRESSURE_MAX = Field.newDoubleField("systolic_pressure_max");
    public static final Field FIELD_SYSTOLIC_PRESSURE_LAST = Field.newDoubleField("systolic_pressure_last");
    public static final Field FIELD_DIASTOLIC_PRESSURE = Field.newDoubleField("diastolic_pressure");
    public static final Field FIELD_DIASTOLIC_PRESSURE_AVG = Field.newDoubleField("diastolic_pressure_avg");
    public static final Field FIELD_DIASTOLIC_PRESSURE_MIN = Field.newDoubleField("diastolic_pressure_min");
    public static final Field FIELD_DIASTOLIC_PRESSURE_MAX = Field.newDoubleField("diastolic_pressure_max");
    public static final Field FIELD_DIASTOLIC_PRESSURE_LAST = Field.newDoubleField("diastolic_pressure_last");
    public static final Field FIELD_SPHYGMUS = Field.newDoubleField("sphygmus");
    public static final Field FIELD_SPHYGMUS_AVG = Field.newDoubleField("sphygmus_avg");
    public static final Field FIELD_SPHYGMUS_MIN = Field.newDoubleField("sphygmus_min");
    public static final Field FIELD_SPHYGMUS_MAX = Field.newDoubleField("sphygmus_max");
    public static final Field FIELD_SPHYGMUS_LAST = Field.newDoubleField("sphygmus_last");
    public static final Field FIELD_BODY_POSTURE = Field.newIntField("body_posture");
    public static final Field FIELD_MEASURE_BODY_PART_OF_BLOOD_PRESSURE = Field.newIntField("measure_body_part_of_blood_pressure");
    public static final Field FIELD_MEASUREMENT_ANOMALY_FLAG = Field.newIntField("measurement_anomaly_flag");
    public static final Field FIELD_MEASUREMENT_REMINDER = Field.newIntField("measurement_reminder");
    public static final Field FIELD_BEFORE_MEASURE_ACTIVITY = Field.newIntField("before_measure_activity");
    public static final Field FIELD_LEVEL = Field.newDoubleField("level");
    public static final Field FIELD_MEASURE_TIME = Field.newIntField("measure_time");
    public static final Field FIELD_CORRELATION_WITH_MEALTIME = Field.newIntField("correlation_with_mealtime");
    public static final Field FIELD_CORRELATION_WITH_SLEEP_STATE = Field.newIntField("correlation_with_sleep_state");
    public static final Field FIELD_SAMPLE_SOURCE = Field.newIntField("sample_source");
    public static final Field FIELD_SATURATION = Field.newDoubleField("saturation");
    public static final Field FIELD_SATURATION_AVG = Field.newDoubleField("saturation_avg");
    public static final Field FIELD_SATURATION_MIN = Field.newDoubleField("saturation_min");
    public static final Field FIELD_SATURATION_MAX = Field.newDoubleField("saturation_max");
    public static final Field FIELD_SATURATION_LAST = Field.newDoubleField("saturation_last");
    public static final Field FIELD_OXYGEN_SUPPLY_FLOW_RATE = Field.newDoubleField("oxygen_supply_flow_rate");
    public static final Field FIELD_OXYGEN_SUPPLY_FLOW_RATE_AVG = Field.newDoubleField("oxygen_supply_flow_rate_avg");
    public static final Field FIELD_OXYGEN_SUPPLY_FLOW_RATE_MIN = Field.newDoubleField("oxygen_supply_flow_rate_min");
    public static final Field FIELD_OXYGEN_SUPPLY_FLOW_RATE_MAX = Field.newDoubleField("oxygen_supply_flow_rate_max");
    public static final Field FIELD_OXYGEN_THERAPY = Field.newIntField("oxygen_therapy");
    public static final Field FIELD_SPO2_MEASUREMENT_MECHANISM = Field.newIntField("spo2_measurement_mechanism");
    public static final Field FIELD_SPO2_MEASUREMENT_APPROACH = Field.newIntField("spo2_measurement_approach");
    public static final Field FIELD_TEMPERATURE = Field.newDoubleField("temperature");
    public static final Field FIELD_MEASURE_BODY_PART_OF_TEMPERATURE = Field.newIntField("measure_body_part_of_temperature");
    public static final Field FIELD_TEXTURE = Field.newIntField("texture");
    public static final Field FIELD_AMOUNT = Field.newIntField("amount");
    public static final Field FIELD_POSITION = Field.newIntField("position");
    public static final Field FIELD_DILATION_STATUS = Field.newIntField("dilation_status");
    public static final Field FIELD_FIRMNESS_LEVEL = Field.newIntField("firmness_level");
    public static final Field FIELD_VOLUME = Field.newIntField(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
    public static final Field FIELD_DETECTION_RESULT = Field.newIntField("detection_result");
    public static final Field FIELD_URIC_ACID = Field.newIntField("uric_acid");
    public static final Field FIELD_NITRITE = Field.newIntField("nitrite");
    public static final Field FIELD_UROBILINOGEN = Field.newIntField("urobilinogen");
    public static final Field FIELD_BILIRUBIN = Field.newIntField("bilirubin");
    public static final Field FIELD_GLUCOSE = Field.newIntField("glucose");
    public static final Field FIELD_THRESHOLD = Field.newDoubleField("threshold");
    public static final Field FIELD_AVG_HEART_RATE = Field.newDoubleField(Element.ELEMENT_NAME_AVG_HEART_RATE);
    public static final Field FIELD_MAX_HEART_RATE = Field.newDoubleField(Element.ELEMENT_NAME_MAX_HEART_RATE);
    public static final Field FIELD_MIN_HEART_RATE = Field.newDoubleField("min_heart_rate");
    public static final Field FIELD_RECORD_DAY = Field.newIntField("recordDay");
    public static final Field FIELD_STATUS = Field.newIntField("status");
    public static final Field FIELD_SUB_STATUS = Field.newIntField("subStatus");
    public static final Field FIELD_REMARKS = Field.newStringField("remarks");
    public static final Field FIELD_TIME_ZONE = Field.newStringField("timeZone");

    @Deprecated
    public static final Field FIELD_START_FLAG = Field.newIntField("startFlag");

    @Deprecated
    public static final Field FIELD_END_FLAG = Field.newIntField("endFlag");
    public static final Field FIELD_DYSMENORRHOEA_LEVEL = Field.newIntField("level");
    public static final Field FIELD_PHYSICAL_SYMPTOMS = Field.newStringField("physicalSymptoms");
    public static final Field FIELD_MOOD = Field.newIntField("mood");
    public static final Field FIELD_SKIN_STATUS = Field.newIntField("skinStatus");
    public static final Field FIELD_APPETITE = Field.newIntField("appetite");
    public static final Field FIELD_CONTRACEPTIVE_MEASURES = Field.newIntField("contraceptiveMeasures");

    HealthFields() {
    }
}
