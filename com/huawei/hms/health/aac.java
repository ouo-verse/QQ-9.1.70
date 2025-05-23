package com.huawei.hms.health;

import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.data.Field;
import com.huawei.hms.hihealth.data.HealthDataTypes;
import com.huawei.hms.hihealth.data.HealthFields;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aac {
    private static final ArrayList<DataType> aab;
    private static final ArrayList<DataType> aaba;
    private static final ArrayList<DataType> aabb;
    private static final List<DataType> aabc;
    private static final Map<String, Field> aabd;

    static {
        ArrayList<DataType> arrayList = new ArrayList<>();
        aab = arrayList;
        ArrayList<DataType> arrayList2 = new ArrayList<>();
        aaba = arrayList2;
        ArrayList<DataType> arrayList3 = new ArrayList<>();
        aabb = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        aabc = arrayList4;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        aabd = concurrentHashMap;
        concurrentHashMap.put(Field.AVG_GROUND_CONTACT_TIME.getName(), Field.GROUND_CONTACT_TIME);
        concurrentHashMap.put(Field.AVG_GROUND_IMPACT_ACCELERATION.getName(), Field.GROUND_IMPACT_ACCELERATION);
        concurrentHashMap.put(Field.AVG_SWING_ANGLE.getName(), Field.SWING_ANGLE);
        concurrentHashMap.put(Field.AVG_EVERSION_EXCURSION.getName(), Field.EVERSION_EXCURSION);
        concurrentHashMap.put(Field.AVG_IMPACT_PEAK.getName(), Field.IMPACT_PEAK);
        concurrentHashMap.put(Field.AVG_GC_TIME_BALANCE.getName(), Field.GC_TIME_BALANCE);
        concurrentHashMap.put(Field.AVG_VERTICAL_OSCILLATION.getName(), Field.VERTICAL_OSCILLATION);
        Field field = Field.AVG_VERTICAL_IMPACT_RATE;
        concurrentHashMap.put(field.getName(), field);
        concurrentHashMap.put(Field.AVG_VERTICAL_RATIO.getName(), Field.VERTICAL_RATIO);
        concurrentHashMap.put(Field.AVG_HANG_TIME.getName(), Field.HANG_TIME);
        concurrentHashMap.put(Field.AVG_GROUND_HANG_TIME_RATE.getName(), Field.GROUND_HANG_TIME_RATE);
        Field field2 = Field.FORE_FOOT_STRIKE_PATTERN;
        concurrentHashMap.put(field2.getName(), field2);
        Field field3 = Field.HIND_FOOT_STRIKE_PATTERN;
        concurrentHashMap.put(field3.getName(), field3);
        Field field4 = Field.WHOLE_FOOT_STRIKE_PATTERN;
        concurrentHashMap.put(field4.getName(), field4);
        String name = Field.FIELD_AVG_PASSAGE_DURATION.getName();
        Field field5 = Field.FIELD_PASSAGE_DURATION;
        concurrentHashMap.put(name, field5);
        concurrentHashMap.put(Field.FIELD_MAX_PASSAGE_DURATION.getName(), field5);
        concurrentHashMap.put(Field.FIELD_MIN_PASSAGE_DURATION.getName(), field5);
        String name2 = Field.FIELD_AVG_JUMP_HEIGHT.getName();
        Field field6 = Field.FIELD_JUMP_HEIGHT;
        concurrentHashMap.put(name2, field6);
        concurrentHashMap.put(Field.FIELD_MIN_JUMP_HEIGHT.getName(), field6);
        concurrentHashMap.put(Field.FIELD_MAX_JUMP_HEIGHT.getName(), field6);
        String name3 = HealthFields.FIELD_SYSTOLIC_PRESSURE_AVG.getName();
        Field field7 = HealthFields.FIELD_SYSTOLIC_PRESSURE;
        concurrentHashMap.put(name3, field7);
        concurrentHashMap.put(HealthFields.FIELD_SYSTOLIC_PRESSURE_MIN.getName(), field7);
        concurrentHashMap.put(HealthFields.FIELD_SYSTOLIC_PRESSURE_MAX.getName(), field7);
        concurrentHashMap.put(HealthFields.FIELD_SYSTOLIC_PRESSURE_LAST.getName(), field7);
        String name4 = HealthFields.FIELD_DIASTOLIC_PRESSURE_AVG.getName();
        Field field8 = HealthFields.FIELD_DIASTOLIC_PRESSURE;
        concurrentHashMap.put(name4, field8);
        concurrentHashMap.put(HealthFields.FIELD_DIASTOLIC_PRESSURE_MIN.getName(), field8);
        concurrentHashMap.put(HealthFields.FIELD_DIASTOLIC_PRESSURE_MAX.getName(), field8);
        concurrentHashMap.put(HealthFields.FIELD_DIASTOLIC_PRESSURE_LAST.getName(), field8);
        String name5 = HealthFields.FIELD_SPHYGMUS_AVG.getName();
        Field field9 = HealthFields.FIELD_SPHYGMUS;
        concurrentHashMap.put(name5, field9);
        concurrentHashMap.put(HealthFields.FIELD_SPHYGMUS_MIN.getName(), field9);
        concurrentHashMap.put(HealthFields.FIELD_SPHYGMUS_MAX.getName(), field9);
        concurrentHashMap.put(HealthFields.FIELD_SPHYGMUS_LAST.getName(), field9);
        String name6 = Field.FIELD_AVG_BODY_FAT_RATE.getName();
        Field field10 = Field.FIELD_BODY_FAT_RATE;
        concurrentHashMap.put(name6, field10);
        concurrentHashMap.put(Field.FIELD_MAX_BODY_FAT_RATE.getName(), field10);
        concurrentHashMap.put(Field.FIELD_MIN_BODY_FAT_RATE.getName(), field10);
        String name7 = Field.FIELD_AVG_SKELETAL_MUSCLEL_MASS.getName();
        Field field11 = Field.FIELD_SKELETAL_MUSCLEL_MASS;
        concurrentHashMap.put(name7, field11);
        concurrentHashMap.put(Field.FIELD_MAX_SKELETAL_MUSCLEL_MASS.getName(), field11);
        concurrentHashMap.put(Field.FIELD_MIN_SKELETAL_MUSCLEL_MASS.getName(), field11);
        String name8 = HealthFields.FIELD_SATURATION_AVG.getName();
        Field field12 = HealthFields.FIELD_SATURATION;
        concurrentHashMap.put(name8, field12);
        concurrentHashMap.put(HealthFields.FIELD_SATURATION_MIN.getName(), field12);
        concurrentHashMap.put(HealthFields.FIELD_SATURATION_MAX.getName(), field12);
        concurrentHashMap.put(HealthFields.FIELD_SATURATION_LAST.getName(), field12);
        arrayList2.add(DataType.DT_CONTINUOUS_STEPS_DELTA);
        arrayList2.add(DataType.DT_CONTINUOUS_ACTIVITY_SEGMENT);
        arrayList2.add(DataType.DT_CONTINUOUS_CALORIES_CONSUMED);
        arrayList2.add(DataType.DT_CONTINUOUS_CALORIES_BURNT);
        arrayList2.add(DataType.DT_CONTINUOUS_DISTANCE_DELTA);
        arrayList2.add(DataType.DT_CONTINUOUS_EXERCISE_INTENSITY);
        arrayList2.add(DataType.DT_CONTINUOUS_SLEEP);
        arrayList2.add(HealthDataTypes.DT_CONTINUOUS_MENSTRUAL_FLOW);
        arrayList2.add(DataType.DT_CONTINUOUS_EXERCISE_INTENSITY_V2);
        arrayList2.add(DataType.DT_CONTINUOUS_JUMP);
        arrayList2.add(DataType.DT_CONTINUOUS_ACTIVITY_FRAGMENT);
        arrayList2.add(DataType.DT_CONTINUOUS_RUN_POSTURE);
        arrayList2.add(DataType.DT_RESISTANCE);
        arrayList2.add(DataType.DT_VO2MAX);
        arrayList2.add(HealthDataTypes.DT_DYSMENORRHOEA);
        arrayList2.add(HealthDataTypes.DT_PHYSICAL_SYMPTOMS);
        arrayList2.add(HealthDataTypes.DT_MOOD);
        arrayList2.add(HealthDataTypes.DT_SKIN_STATUS);
        arrayList2.add(HealthDataTypes.DT_APPETITE);
        arrayList2.add(HealthDataTypes.DT_SEXUAL_ACTIVITY);
        arrayList2.add(HealthDataTypes.DT_SLEEP_RESPIRATORY_EVENT);
        arrayList2.add(HealthDataTypes.DT_CGM_BLOOD_GLUCOSE);
        arrayList3.add(DataType.DT_CONTINUOUS_WORKOUT_DURATION);
        arrayList3.add(DataType.DT_CONTINUOUS_STEPS_TOTAL);
        arrayList3.add(DataType.DT_CONTINUOUS_BIKING_PEDALING_TOTAL);
        arrayList3.add(DataType.DT_CONTINUOUS_DISTANCE_TOTAL);
        arrayList3.add(DataType.DT_CONTINUOUS_CALORIES_BURNT_TOTAL);
        arrayList3.add(DataType.DT_CONTINUOUS_BIKING_WHEEL_ROTATION_TOTAL);
        arrayList3.add(DataType.DT_STATISTICS_SLEEP);
        arrayList3.add(DataType.DT_INSTANTANEOUS_STRESS_STATISTICS);
        arrayList3.add(DataType.DT_RESTING_HEART_RATE_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_EXERCISE_HEART_RATE_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_WORKOUT_DURATION);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_ACTIVITY_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_POWER_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_EXERCISE_INTENSITY_STATISTICS);
        arrayList3.add(DataType.DT_STATISTICS_EXERCISE_INTENSITY_V2);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_HEART_RATE_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_BODY_WEIGHT_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_HEIGHT_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_CALORIES_BMR_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_BODY_FAT_RATE_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CALORIES_EXPENDED);
        arrayList3.add(DataType.POLYMERIZE_CALORIES_CONSUMED);
        arrayList3.add(DataType.POLYMERIZE_DISTANCE_DELTA);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_SPEED_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_LOCATION_BOUNDARY_RANGE);
        arrayList3.add(DataType.POLYMERIZE_CONTINUOUS_NUTRITION_FACTS_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_HYDRATION);
        arrayList3.add(DataType.POLYMERIZE_STEP_COUNT_DELTA);
        arrayList3.add(HealthDataTypes.POLYMERIZE_CONTINUOUS_BODY_BLOOD_GLUCOSE_STATISTICS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_CGM_BLOOD_GLUCOSE_STATISTICS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_CONTINUOUS_BODY_BLOOD_PRESSURE_STATISTICS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_CONTINUOUS_BODY_TEMPERATURE_STATISTICS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_CONTINUOUS_SPO2_STATISTICS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_CONTINUOUS_BODY_TEMPERATURE_REST_STATISTICS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_INSTANTANEOUS_CERVICAL_MUCUS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_INSTANTANEOUS_CERVICAL_STATUS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_CONTINUOUS_MENSTRUAL_FLOW);
        arrayList3.add(HealthDataTypes.POLYMERIZE_INSTANTANEOUS_OVULATION_DETECTION);
        arrayList3.add(HealthDataTypes.POLYMERIZE_INSTANTANEOUS_VAGINAL_SPECKLE);
        arrayList3.add(DataType.DT_CONTINUOUS_STEPS_RATE_STATISTIC);
        arrayList3.add(DataType.DT_CONTINUOUS_JUMP_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_ALTITUDE_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_SKIP_SPEED_STATISTICS);
        arrayList3.add(HealthDataTypes.POLYMERIZE_CONTINUOUS_SKIN_TEMPERATURE_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_RUN_POSTURE_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_FREEDIVING_ASCENT_SPEED_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_FREEDIVING_DESCENT_SPEED_STATISTICS);
        arrayList3.add(DataType.DT_RESISTANCE_STATISTICS);
        arrayList3.add(DataType.DT_VO2MAX_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_STROKE_RATE_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_PEDALING_RATE_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_HYDRATE_TOTAL);
        arrayList3.add(DataType.DT_CONTINUOUS_SWIMMING_STROKE_RATE_STATISTICS);
        arrayList3.add(DataType.DT_CONTINUOUS_SWIMMING_SWOLF_STATISTICS);
        arrayList3.add(DataType.DT_DIVING_DEPTH_STATISTICS);
        arrayList3.add(DataType.DT_WATER_TEMPERATURE_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_LOCATION);
        arrayList3.add(DataType.POLYMERIZE_BREATH_HOLDING_TRAIN_STATISTICS);
        arrayList3.add(DataType.POLYMERIZE_FREEDIVING_STATISTICS);
        arrayList3.add(DataType.DT_DIVING_STATISTICS);
        arrayList3.add(DataType.DT_GOLF_AREA_STATISTICS);
        arrayList.add(DataType.DT_INSTANTANEOUS_STEPS_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_CALORIES_BMR);
        arrayList.add(DataType.DT_INSTANTANEOUS_POWER_SAMPLE);
        arrayList.add(DataType.DT_INSTANTANEOUS_ACTIVITY_SAMPLE);
        arrayList.add(DataType.DT_INSTANTANEOUS_ACTIVITY_SAMPLES);
        arrayList.add(DataType.DT_INSTANTANEOUS_HEART_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_LOCATION_SAMPLE);
        arrayList.add(DataType.DT_INSTANTANEOUS_LOCATION_TRACE);
        arrayList.add(DataType.DT_INSTANTANEOUS_SPEED);
        arrayList.add(HealthDataTypes.DT_SLEEP_RESPIRATORY_DETAIL);
        arrayList.add(DataType.DT_INSTANTANEOUS_BIKING_PEDALING_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_HEIGHT);
        arrayList.add(DataType.DT_INSTANTANEOUS_BODY_WEIGHT);
        arrayList.add(DataType.DT_INSTANTANEOUS_BODY_FAT_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_NUTRITION_FACTS);
        arrayList.add(DataType.DT_INSTANTANEOUS_HYDRATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_BIKING_WHEEL_ROTATION);
        arrayList.add(DataType.DT_INSTANTANEOUS_WHEEL_ROTATION);
        arrayList.add(DataType.DT_INSTANTANEOUS_STRESS);
        arrayList.add(DataType.DT_INSTANTANEOUS_RUN_VDOT);
        arrayList.add(DataType.DT_INSTANTANEOUS_RUN_TRAINING_INDEX);
        arrayList.add(DataType.DT_INSTANTANEOUS_RUN_FATIGUE_INDEX);
        arrayList.add(DataType.DT_INSTANTANEOUS_RUN_PHYSICAL_FITNESS_INDEX);
        arrayList.add(DataType.DT_INSTANTANEOUS_RUN_STATE_INDEX);
        arrayList.add(DataType.DT_INSTANTANEOUS_RESTING_HEART_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_EXERCISE_HEART_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_ALTITUDE);
        arrayList.add(DataType.DT_INSTANTANEOUS_SKIP_SPEED);
        arrayList.add(DataType.DT_INSTANTANEOUS_FREEDIVING_ASCENT_SPEED);
        arrayList.add(DataType.DT_INSTANTANEOUS_FREEDIVING_DESCENT_SPEED);
        arrayList.add(DataType.DT_INSTANTANEOUS_STROKE_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_PEDALING_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_SWIMMING_STROKE_RATE);
        arrayList.add(DataType.DT_INSTANTANEOUS_SWIMMING_SWOLF);
        arrayList.add(DataType.DT_DIVING_DEPTH);
        arrayList.add(DataType.DT_WATER_TEMPERATURE);
        arrayList.add(DataType.DT_MARK_POINT);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_BLOOD_GLUCOSE);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_BLOOD_PRESSURE);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_BODY_TEMPERATURE);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_SPO2);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_BODY_TEMPERATURE_REST);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_CERVICAL_MUCUS);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_CERVICAL_STATUS);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_OVULATION_DETECTION);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_VAGINAL_SPECKLE);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_URIC_ACID);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_URINE_ROUTINE_NITRITE);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_URINE_ROUTINE_UROBILINOGEN);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_URINE_ROUTINE_BILIRUBIN);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_URINE_ROUTINE_GLUCOSE);
        arrayList.add(HealthDataTypes.DT_INSTANTANEOUS_SKIN_TEMPERATURE);
        arrayList.add(DataType.DT_SLEEP_ON_OFF_BED);
        arrayList4.add(HealthDataTypes.DT_HEALTH_RECORD_TACHYCARDIA);
        arrayList4.add(HealthDataTypes.DT_HEALTH_RECORD_BRADYCARDIA);
        arrayList4.add(HealthDataTypes.DT_HEALTH_RECORD_SLEEP);
        arrayList4.add(HealthDataTypes.DT_HEALTH_RECORD_VENTILATOR);
        arrayList4.add(HealthDataTypes.DT_HEALTH_RECORD_MENSTRUAL_CYCLE);
    }

    public static long aab(DataType dataType) {
        return aabb.contains(dataType) ? 31622400L : 259200L;
    }

    public static int aaba(DataType dataType) {
        if (aab.contains(dataType)) {
            return 1;
        }
        if (aaba.contains(dataType)) {
            return 2;
        }
        if (aabb.contains(dataType)) {
            return 3;
        }
        return 0;
    }

    public static boolean aab(String str) {
        Iterator<DataType> it = aabc.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
