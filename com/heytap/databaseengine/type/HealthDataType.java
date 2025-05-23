package com.heytap.databaseengine.type;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthDataType {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class AtrialFibrilType {
        public static final int ATRIAL_FIBRIL = 1;
        public static final int INVALUABLE = 3;
        public static final int NOT_ATRIAL_FIBRIL = 2;
        public static final int NOT_WARNING = 0;
        public static final int WARNING = 1;
        public static final int WARNING_SHOW = 2;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class BloodOxygenSaturationType {
        public static final int ALL = -1;
        public static final int INTERVAL = 2;
        public static final int MANUAL = 3;
        public static final int NORMAL = 0;
        public static final int SLEEP = 1;
        public static final int SNORE_SECOND_SPO2 = 4;
        public static final int WHOLE_DAY_SPO2 = 10;
        public static final int[] SLEEP_SPO2 = {0, 1, 2};
        public static final Integer[] NORMAL_SPO2 = {3};
        public static final Integer[] SPO2 = {0, 1, 2, 3, 10};

        public static boolean isNormalSpo2(int i3) {
            return Arrays.asList(NORMAL_SPO2).contains(Integer.valueOf(i3));
        }

        public static boolean isSleepSpo2(int i3) {
            for (int i16 : SLEEP_SPO2) {
                if (i16 == i3) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class BloodPressureType {
        public static final int DEFAULT = 0;
        public static final int DUSK_PRESSURE = 2;
        public static final int DUSK_PRESSURE_MAX_HOUR = 20;
        public static final int DUSK_PRESSURE_MIN_HOUR = 16;
        public static final int MORNING_PRESSURE = 1;
        public static final int MORNING_PRESSURE_MAX_HOUR = 10;
        public static final int MORNING_PRESSURE_MIN_HOUR = 6;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class HealthOriginDataType {
        public static final int SPO2 = 1;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class HeartRateType {
        public static final int DYNAMIC = 0;
        public static final int LOW_HR_WARN = 6;
        public static final int[] NOT_SHOW_IN_DETAIL = {1, 4, 5};
        public static final int PHONE_HR_MEASURE = 7;
        public static final int QUIET_HIGH = 3;
        public static final int REST = 1;
        public static final int SLEEP = 5;
        public static final int SPORT = 2;
        public static final int WALK = 4;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class HeartRateWarningType {
        public static final int HIGH_HEART_RATE = 2;
        public static final int LOW_HEART_RATE = 1;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class HrvDataType {
        public static final int MINUTE_DATA = 0;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class PhysiqueEvaluationSubType {
        public static final int PHYSIQUE_TYPE_BMI = 58;
        public static final int PHYSIQUE_TYPE_BOBBY_JUMPED = 43;
        public static final int PHYSIQUE_TYPE_JUMP_LEFT_RIGHT = 47;
        public static final int PHYSIQUE_TYPE_KNEE_PUSH_UPS = 51;
        public static final int PHYSIQUE_TYPE_LIFT_LEG = 46;
        public static final int PHYSIQUE_TYPE_LOWER_WAIST_WIDTH = 49;
        public static final int PHYSIQUE_TYPE_MAX = 60;
        public static final int PHYSIQUE_TYPE_NULL = 0;
        public static final int PHYSIQUE_TYPE_PLATE_SUPPORT = 59;
        public static final int PHYSIQUE_TYPE_PUSH_UPS = 42;
        public static final int PHYSIQUE_TYPE_ROPE_SKIPPING = 48;
        public static final int PHYSIQUE_TYPE_RUN = 57;
        public static final int PHYSIQUE_TYPE_SIT_UPS = 41;
        public static final int PHYSIQUE_TYPE_SQUAT = 40;
        public static final int PHYSIQUE_TYPE_STRADDLE = 44;
        public static final int PHYSIQUE_TYPE_TREE_BREAK = 50;
        public static final int PHYSIQUE_TYPE_TURN_JUMPING = 45;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class PhysiqueEvaluationType {
        public static final int BALANCE = 3;
        public static final int BODY_SHAPE = 7;
        public static final int CORE_POWER = 8;
        public static final int FLEXIBILITY = 5;
        public static final int HEART_LUNG_FUNCTION = 4;
        public static final int HEART_LUNG_FUNCTION_VO2 = 11;
        public static final int LOWER_BODY_POWER = 10;
        public static final int PHYSICAL_FITNESS = 6;
        public static final int POWER = 1;
        public static final int SENSITIVITY = 2;
        public static final int TOTAL = 0;
        public static final int UPPER_BODY_POWER = 9;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RelaxBreathType {
        public static final int BEEP = 2;
        public static final int CONSCIOUS = 1;
        public static final int SLEEP = 3;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RelaxMeditationType {
        public static final int BODY_SCAN = 2;
        public static final int EMOTIONAL_AWARENESS = 1;
        public static final int HYPNOTIC_MEDITATION = 5;
        public static final int MINDFULNESS_WALKING = 4;
        public static final int WORK_BREAK = 3;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RelaxPlayGamesType {
        public static final int HIT_MOUSE = 2;
        public static final int PINCH_BUBBLES = 1;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RelaxType {
        public static final int ALL = -2;
        public static final int BREATH = 1;
        public static final int MEDITATION = 2;
        public static final int PLAY_GAMES = 3;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SensorOsaDataType {
        public static final int MINUTE_DATA = 0;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SleepDataState {
        public static final int FALL_ASLEEP = 1;
        public static final String SLEEP_DATA_6_7_BIT = "sleep_data_6_7_bit";
        public static final int SLEEP_DEEP = 2;
        public static final int SLEEP_LIGHTLY = 4;
        public static final int SLEEP_OUT = 6;
        public static final int SLEEP_RAPID_EYE_MOVEMENT = 3;
        public static final int SLEEP_WAKE_UP = 5;
        public static final String USER_SLEEP_STATE = "state";
        public static final int WAKE = 0;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SleepDataType {
        public static final int MIDDAY_REST = 1;
        public static final int NIGHT_SLEEP = 0;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SnoreDbBuffDataType {
        public static final int MINUTE_DATA = 1;
        public static final int SECOND_DATA = 2;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class StressType {
        public static final int CONTINUE_TEST = 0;
        public static final int MANUAL_TEST = 1;
    }
}
