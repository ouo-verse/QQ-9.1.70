package com.huawei.hms.hihealth.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Size;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aacu;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Field implements Parcelable {
    public static final int FORMAT_DOUBLE = 2;

    @Deprecated
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_LONG = 5;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int FORMAT_UNDEFINED = 0;

    @Deprecated
    public static final int MEAL_BREAKFAST = 1;

    @Deprecated
    public static final int MEAL_DINNER = 3;

    @Deprecated
    public static final int MEAL_LUNCH = 2;

    @Deprecated
    public static final int MEAL_SNACK = 4;

    @Deprecated
    public static final int MEAL_UNKNOWN = 0;

    @Deprecated
    public static final String NUTRIENTS_FACTS_CALCIUM = "calcium";

    @Deprecated
    public static final String NUTRIENTS_FACTS_CHOLESTEROL = "cholesterol";

    @Deprecated
    public static final String NUTRIENTS_FACTS_DIETARY_FIBER = "dietary_fiber";

    @Deprecated
    public static final String NUTRIENTS_FACTS_IRON = "iron";

    @Deprecated
    public static final String NUTRIENTS_FACTS_MONOUNSATURATED_FAT = "fat.monounsaturated";

    @Deprecated
    public static final String NUTRIENTS_FACTS_POLYUNSATURATED_FAT = "fat.polyunsaturated";

    @Deprecated
    public static final String NUTRIENTS_FACTS_POTASSIUM = "potassium";

    @Deprecated
    public static final String NUTRIENTS_FACTS_PROTEIN = "protein";

    @Deprecated
    public static final String NUTRIENTS_FACTS_SATURATED_FAT = "fat.saturated";

    @Deprecated
    public static final String NUTRIENTS_FACTS_SODIUM = "sodium";

    @Deprecated
    public static final String NUTRIENTS_FACTS_SUGAR = "sugar";

    @Deprecated
    public static final String NUTRIENTS_FACTS_TOTAL_CARBS = "carbs.total";

    @Deprecated
    public static final String NUTRIENTS_FACTS_TOTAL_FAT = "fat.total";

    @Deprecated
    public static final String NUTRIENTS_FACTS_TRANS_FAT = "fat.trans";

    @Deprecated
    public static final String NUTRIENTS_FACTS_UNSATURATED_FAT = "fat.unsaturated";

    @Deprecated
    public static final String NUTRIENTS_FACTS_VITAMIN_A = "vitamin_a";

    @Deprecated
    public static final String NUTRIENTS_FACTS_VITAMIN_C = "vitamin_c";
    private static final String TAG = "Field";

    @Deprecated
    public static final int TYPE_OF_RESISTANCE_BARBELL = 1;

    @Deprecated
    public static final int TYPE_OF_RESISTANCE_BODY = 6;

    @Deprecated
    public static final int TYPE_OF_RESISTANCE_CABLE = 2;

    @Deprecated
    public static final int TYPE_OF_RESISTANCE_DUMBBELL = 3;

    @Deprecated
    public static final int TYPE_OF_RESISTANCE_KETTLEBELL = 4;

    @Deprecated
    public static final int TYPE_OF_RESISTANCE_MACHINE = 5;

    @Deprecated
    public static final int TYPE_OF_RESISTANCE_UNKNOWN = 0;
    private final int format;

    @Size(max = 1000, min = 1)
    private final String name;
    public static final Parcelable.Creator<Field> CREATOR = new aab();
    public static final Field FIELD_PRECISION = newDoubleField("precision");

    @Deprecated
    public static final Field FIELD_ALTITUDE = newDoubleField("altitude");
    public static final Field FIELD_TYPE_OF_ACTIVITY = newIntField("type_of_activity");
    public static final Field FIELD_POSSIBILITY_OF_ACTIVITY = newDoubleField("possibility_of_activity");
    public static final Field FIELD_BPM = newDoubleField("bpm");
    public static final Field FIELD_POSSIBILITY = newDoubleField("possibility");
    public static final Field FIELD_SPAN = newIntField(TtmlNode.TAG_SPAN);
    public static final Field FIELD_DISTANCE = newDoubleField(Element.ELEMENT_NAME_DISTANCE);
    public static final Field FIELD_DISTANCE_DELTA = newDoubleField("distance_delta");
    public static final Field FIELD_HEIGHT = newDoubleField("height");
    public static final Field FIELD_STEPS_DELTA = newIntField("steps_delta");
    public static final Field FIELD_STEPS = newIntField("steps");
    public static final Field FIELD_DURATION = newIntField("duration");
    public static final Field FIELD_STEP_LENGTH = newDoubleField("step_length");
    public static final Field FIELD_LATITUDE = newDoubleField("latitude");
    public static final Field FIELD_LONGITUDE = newDoubleField("longitude");
    public static final Field FIELD_COORDINATE = newIntField("coordinate");
    public static final Field FIELD_BODY_WEIGHT = newDoubleField("body_weight");
    public static final Field FIELD_BMI = newDoubleField(Element.ELEMENT_NAME_BMI);
    public static final Field FIELD_BODY_FAT = newDoubleField("body_fat");
    public static final Field FIELD_BODY_FAT_RATE = newDoubleField("body_fat_rate");
    public static final Field FIELD_MUSCLE_MASS = newDoubleField("muscle_mass");
    public static final Field FIELD_BASAL_METABOLISM = newDoubleField("basal_metabolism");
    public static final Field FIELD_MOISTURE = newDoubleField("moisture");
    public static final Field FIELD_MOISTURE_RATE = newDoubleField("moisture_rate");
    public static final Field FIELD_VISCERAL_FAT_LEVEL = newDoubleField("visceral_fat_level");
    public static final Field FIELD_BONE_SALT = newDoubleField("bone_salt");
    public static final Field FIELD_PROTEIN_RATE = newDoubleField("protein_rate");
    public static final Field FIELD_BODY_AGE = newIntField("body_age");
    public static final Field FIELD_BODY_SCORE = newDoubleField("body_score");
    public static final Field FIELD_SKELETAL_MUSCLEL_MASS = newDoubleField("skeletal_musclel_mass");
    public static final Field FIELD_IMPEDANCE = newDoubleField("impedance");
    public static final Field FIELD_CIRCUMFERENCE = newDoubleField("circumference");
    public static final Field FIELD_SPEED = newDoubleField("speed");
    public static final Field FIELD_RPM = newDoubleField("rpm");
    public static final Field FIELD_STEP_RATE = newDoubleField("step_rate");
    public static final Field FIELD_ROTATION = newIntField(BasicAnimation.KeyPath.ROTATION);

    @Deprecated
    public static final String NUTRIENTS_FACTS_CALORIES = "calories";
    public static final Field FIELD_CALORIES = newDoubleField(NUTRIENTS_FACTS_CALORIES);
    public static final Field FIELD_CALORIES_TOTAL = newDoubleField("calories_total");
    public static final Field FIELD_POWER = newDoubleField("power");
    public static final Field FIELD_HYDRATE = newDoubleField("hydrate");
    public static final Field FIELD_HYDRATE_TOTAL = newDoubleField("totalHydrate");
    public static final Field FIELD_MEAL = newIntField("meal");
    public static final Field FIELD_FOOD = newStringField("food");
    public static final Field FIELD_NUTRIENTS = newMapField("nutrients");
    public static final Field FIELD_NUTRIENTS_FACTS = newMapField("nutrients_facts");
    public static final Field FIELD_FRAGMENTS = newIntField("fragments");
    public static final Field FIELD_AVG = newDoubleField("avg");
    public static final Field FIELD_MAX = newDoubleField("max");
    public static final Field FIELD_LAST = newDoubleField("last");
    public static final Field FIELD_AVG_BODY_FAT_RATE = newDoubleField("avg_body_fat_rate");
    public static final Field FIELD_MAX_BODY_FAT_RATE = newDoubleField("max_body_fat_rate");
    public static final Field FIELD_MIN_BODY_FAT_RATE = newDoubleField("min_body_fat_rate");
    public static final Field FIELD_AVG_SKELETAL_MUSCLEL_MASS = newDoubleField("avg_skeletal_musclel_mass");
    public static final Field FIELD_MAX_SKELETAL_MUSCLEL_MASS = newDoubleField("max_skeletal_musclel_mass");
    public static final Field FIELD_MIN_SKELETAL_MUSCLEL_MASS = newDoubleField("min_skeletal_musclel_mass");
    public static final Field FIELD_JUMP_HEIGHT = newDoubleField("jump_height");
    public static final Field FIELD_PASSAGE_DURATION = newIntField("passage_duration");
    public static final Field FIELD_JUMP_TIMES = newIntField("jump_times");
    public static final Field FIELD_MIN_JUMP_HEIGHT = newDoubleField("min_jump_height");
    public static final Field FIELD_AVG_JUMP_HEIGHT = newDoubleField("avg_jump_height");
    public static final Field FIELD_MAX_JUMP_HEIGHT = newDoubleField("max_jump_height");
    public static final Field FIELD_MIN_PASSAGE_DURATION = newIntField("min_passage_duration");
    public static final Field FIELD_AVG_PASSAGE_DURATION = newIntField("avg_passage_duration");
    public static final Field FIELD_MAX_PASSAGE_DURATION = newIntField("max_passage_duration");
    public static final Field FIELD_MIN = newDoubleField(Element.ELEMENT_NAME_MIN);
    public static final Field FIELD_ASCENT_TOTAL = newDoubleField("ascent_total");
    public static final Field FIELD_DESCENT_TOTAL = newDoubleField("descent_total");
    public static final Field FIELD_MIN_LATITUDE = newDoubleField("min_latitude");
    public static final Field FIELD_MIN_LONGITUDE = newDoubleField("min_longitude");
    public static final Field FIELD_MAX_LATITUDE = newDoubleField("max_latitude");
    public static final Field FIELD_MAX_LONGITUDE = newDoubleField("max_longitude");
    public static final Field FIELD_APPEARANCE = newIntField("appearance");
    public static final Field FIELD_INTENSITY = newDoubleField("intensity");
    public static final Field EXERCISE_TYPE = newIntField("exercise_type");
    public static final Field INTENSITY_MAP = newMapField("intensity_map");
    public static final Field FALL_ASLEEP_TIME = newLongField("fall_asleep_time");
    public static final Field WAKE_UP_TIME = newLongField("wakeup_time");
    public static final Field SLEEP_SCORE = newIntField(Element.ELEMENT_NAME_SLEEP_SCORE);

    @Deprecated
    public static final Field SLEEP_LATENCY = newIntField("sleep_latency");

    @Deprecated
    public static final Field GO_BED_TIME = newLongField("go_bedTime");
    public static final Field PREPARE_SLEEP_TIME = newLongField("prepare_sleep_time");
    public static final Field OFF_BED_TIME = newLongField("off_bed_time");
    public static final Field GO_BED_TIME_NEW = newLongField("go_bed_time");
    public static final Field SLEEP_EFFICIENCY = newIntField("sleep_efficiency");
    public static final Field LIGHT_SLEEP_TIME = newIntField("light_sleep_time");
    public static final Field DEEP_SLEEP_TIME = newIntField("deep_sleep_time");
    public static final Field DREAM_TIME = newIntField("dream_time");
    public static final Field AWAKE_TIME = newIntField("awake_time");
    public static final Field ALL_SLEEP_TIME = newIntField("all_sleep_time");
    public static final Field WAKE_UP_CNT = newIntField("wakeup_count");
    public static final Field DEEP_SLEEP_PART = newIntField("deep_sleep_part");
    public static final Field SLEEP_TYPE = newIntField("sleep_type");
    public static final Field SLEEP_STATE = newIntField("sleep_state");
    public static final Field SLEEP_ON_OFF_BED_STATE = newIntField("onOffBedState");
    public static final Field SCORE = newIntField(LocalPhotoFaceInfo.SCORE);
    public static final Field GRADE = newIntField("grade");
    public static final Field MEASURE_TYPE = newIntField("measure_type");
    public static final Field STRESS_AVG = newIntField("avg");
    public static final Field STRESS_MAX = newIntField("max");
    public static final Field STRESS_MIN = newIntField(Element.ELEMENT_NAME_MIN);
    public static final Field STRESS_LAST = newIntField("last");
    public static final Field MEASURE_COUNT = newIntField("measure_count");
    public static final Field SLEEP_RESPIRATORY_TYPE = newIntField("type");
    public static final Field SLEEP_RESPIRATORY_VALUE = newDoubleField("value");
    public static final Field EVENT_NAME = newIntField(AdMetricTag.EVENT_NAME);
    public static final Field VDOT = newIntField("vdot");
    public static final Field TRAINING_INDEX = newDoubleField("index");
    public static final Field FATIGUE_INDEX = newDoubleField("index");
    public static final Field PHYSICAL_FITNESS_INDEX = newDoubleField("index");
    public static final Field STATE_INDEX = newDoubleField("index");
    public static final Field ALTITUDE = newDoubleField("altitude");
    public static final Field SKIP_SPEED = newIntField("skip_speed");
    public static final Field AVG = newIntField("avg");
    public static final Field MAX = newIntField("max");
    public static final Field MIN = newIntField(Element.ELEMENT_NAME_MIN);
    public static final Field LAST = newIntField("last");
    public static final Field SKIP_NUM = newIntField("skip_num");
    public static final Field STUMBLING_ROPE = newIntField("stumbling_rope");
    public static final Field MAX_SKIPPING_TIMES = newIntField("max_skipping_times");
    public static final Field DOUBLE_SHAKE = newIntField("double_shake");
    public static final Field TRIPLE_SHAKE = newIntField("triple_shake");
    public static final Field OVERALL_SCORE = newIntField("overall_score");
    public static final Field BURST_SCORE = newIntField("burst_score");
    public static final Field JUMP_SCORE = newIntField("jump_score");
    public static final Field RUN_SCORE = newIntField("run_score");
    public static final Field BREAKTHROUGH_SCORE = newIntField("breakthrough_score");
    public static final Field SPORT_INTENSITY_SCORE = newIntField("sport_intensity_score");
    public static final Field DIVING_TIME = newIntField("divingTime");
    public static final Field DIVING_COUNT = newIntField("divingCount");
    public static final Field MAX_DEPTH = newDoubleField("maxDepth");
    public static final Field AVG_DEPTH = newDoubleField("avgDepth");
    public static final Field DEPTH = newDoubleField("depth");
    public static final Field DIVING_MODE = newIntField("divingMode");
    public static final Field MAX_UNDERWATER_TIME = newIntField("maxUnderwaterTime");
    public static final Field UNDERWATER_TIME = newIntField("underwaterTime");
    public static final Field NO_FLY_TIME = newIntField("noFlyTime");
    public static final Field CNS = newIntField("cns");
    public static final Field OTU = newIntField("otu");
    public static final Field WATER_TYPE = newIntField("waterType");
    public static final Field WATER_DENSITY = newDoubleField("waterDensity");
    public static final Field MAX_ASCENT_SPEED = newDoubleField("maxAscentSpeed");
    public static final Field MAX_DESCENT_SPEED = newDoubleField("maxDescentSpeed");
    public static final Field TEMPERATURE = newDoubleField("temperature");
    public static final Field START_LAT = newDoubleField("startLat");
    public static final Field START_LON = newDoubleField("startLon");
    public static final Field END_LAT = newDoubleField("endLat");
    public static final Field END_LON = newDoubleField("endLon");
    public static final Field SURFACE_TIME = newIntField("surfaceTime");
    public static final Field BREATH_TIME = newIntField("breathTime");
    public static final Field BREATH_HOLDING_TIME = newIntField("breathHoldingTime");
    public static final Field BREATH_HOLDING_TRAIN_RHYTHM = newIntField("breathHoldingTrainRhythm");
    public static final Field DIAPHRAGM_TIME = newIntField("diaphragmTime");
    public static final Field ASCENT_RATE = newDoubleField("ascent_rate");
    public static final Field DESCENT_RATE = newDoubleField("descent_rate");
    public static final Field GROUND_CONTACT_TIME = newIntField("ground_contact_time");
    public static final Field GROUND_IMPACT_ACCELERATION = newIntField("ground_impact_acceleration");
    public static final Field SWING_ANGLE = newIntField("swing_angle");
    public static final Field EVERSION_EXCURSION = newIntField("eversion_excursion");
    public static final Field HANG_TIME = newIntField("hang_time");
    public static final Field GROUND_HANG_TIME_RATE = newDoubleField("ground_hang_time_rate");
    public static final Field FORE_FOOT_STRIKE_PATTERN = newIntField("fore_foot_strike_pattern");
    public static final Field HIND_FOOT_STRIKE_PATTERN = newIntField("hind_foot_strike_pattern");
    public static final Field WHOLE_FOOT_STRIKE_PATTERN = newIntField("whole_foot_strike_pattern");
    public static final Field IMPACT_PEAK = newDoubleField("impact_peak");
    public static final Field VERTICAL_OSCILLATION = newDoubleField("vertical_oscillation");
    public static final Field VERTICAL_RATIO = newDoubleField("vertical_ratio");
    public static final Field GC_TIME_BALANCE = newDoubleField("gc_time_balance");
    public static final Field AVG_VERTICAL_IMPACT_RATE = newDoubleField("avg_vertical_impact_rate");
    public static final Field AVG_GROUND_CONTACT_TIME = newIntField("avg_ground_contact_time");
    public static final Field AVG_GROUND_IMPACT_ACCELERATION = newIntField("avg_ground_impact_acceleration");
    public static final Field AVG_SWING_ANGLE = newIntField("avg_swing_angle");
    public static final Field AVG_EVERSION_EXCURSION = newIntField("avg_eversion_excursion");
    public static final Field AVG_HANG_TIME = newIntField("avg_hang_time");
    public static final Field AVG_IMPACT_PEAK = newDoubleField("avg_impact_peak");
    public static final Field AVG_GC_TIME_BALANCE = newDoubleField("avg_gc_time_balance");
    public static final Field AVG_VERTICAL_OSCILLATION = newDoubleField("avg_vertical_oscillation");
    public static final Field AVG_VERTICAL_RATIO = newDoubleField("avg_vertical_ratio");
    public static final Field AVG_GROUND_HANG_TIME_RATE = newDoubleField("avg_ground_hang_time_rate");
    public static final Field RESISTANCE_LEVEL = newIntField("resistanceLevel");
    public static final Field MAX_RES = newIntField("maxRes");
    public static final Field MIN_RES = newIntField("minRes");
    public static final Field RESISTANCE_LEVEL_ONE_LOWER_LIMIT = newIntField("resistanceLevelOneLowerLimit");
    public static final Field RESISTANCE_LEVEL_TWO_LOWER_LIMIT = newIntField("resistanceLevelTwoLowerLimit");
    public static final Field RESISTANCE_LEVEL_THREE_LOWER_LIMIT = newIntField("resistanceLevelThreeLowerLimit");
    public static final Field RESISTANCE_LEVEL_FOUR_LOWER_LIMIT = newIntField("resistanceLevelFourLowerLimit");
    public static final Field RESISTANCE_LEVEL_FIVE_LOWER_LIMIT = newIntField("resistanceLevelFiveLowerLimit");
    public static final Field RESISTANCE_LEVEL_FIVE_UPPER_LIMIT = newIntField("resistanceLevelFiveUpperLimit");
    public static final Field RESISTANCE_LEVEL_ONE_TIME = newIntField("resistanceLevelOneTime");
    public static final Field RESISTANCE_LEVEL_TWO_TIME = newIntField("resistanceLevelTwoTime");
    public static final Field RESISTANCE_LEVEL_THREE_TIME = newIntField("resistanceLevelThreeTime");
    public static final Field RESISTANCE_LEVEL_FOUR_TIME = newIntField("resistanceLevelFourTime");
    public static final Field RESISTANCE_LEVEL_FIVE_TIME = newIntField("resistanceLevelFiveTime");
    public static final Field VO2MAX = newIntField("vo2max");
    public static final Field STROKES_NUM = newIntField("strokes_num");
    public static final Field SPM = newDoubleField("spm");
    public static final Field RPM = newDoubleField("rpm");
    public static final Field SWOLF = newDoubleField("swolf");
    public static final Field PULL_TIMES = newIntField("pull_times");
    public static final Field SWIMMING_STROKE = newIntField("swimming_stroke");
    public static final Field POOL_LENGTH = newIntField("pool_length");
    public static final Field TRIP_TIMES = newIntField("trip_times");
    public static final Field MAX_SLOPE_PERCENT = newDoubleField("max_slope_percent");
    public static final Field MAX_SLOPE_DEGREE = newDoubleField("max_slope_degree");
    public static final Field GOLF_SWING_COUNT = newIntField("golf_swing_count");
    public static final Field GOLF_SWING_SPEED = newIntField("golf_swing_speed");
    public static final Field GOLF_MAX_SWING_SPEED = newIntField("golf_max_swing_speed");
    public static final Field GOLF_SWING_TEMPO = newDoubleField("golf_swing_tempo");
    public static final Field GOLF_DOWN_SWING_TIME = newIntField("golf_down_swing_time");
    public static final Field GOLF_BACK_SWING_TIME = newIntField("golf_back_swing_time");
    public static final Field FIELD_GOLF_SWING_COUNT = newIntField("golfSwingCount");
    public static final Field COURSE_ID = newIntField("courseId");
    public static final Field BRANCH_ID1 = newIntField("branchId1");
    public static final Field BRANCH_ID2 = newIntField("branchId2");
    public static final Field HOLES = newIntField("holes");
    public static final Field GIR = newIntField("GIR");
    public static final Field DOUBLE_EAGLE = newIntField("doubleEagle");
    public static final Field EAGLE = newIntField("eagle");
    public static final Field BRIDIE = newIntField("birdie");
    public static final Field PAR = newIntField("par");
    public static final Field BOGEY = newIntField("bogey");
    public static final Field DOUBLE_BOGEY = newIntField("doubleBogey");
    public static final Field PUTTS = newIntField("putts");
    public static final Field AVG_PUTTS = newDoubleField("avgPutts");
    public static final Field PAR3 = newDoubleField("par3");
    public static final Field PAR4 = newDoubleField("par4");
    public static final Field PAR5 = newDoubleField("par5");
    public static final Field FAIRWAY_HITS = newIntField("fairwayHits");
    public static final Field FAIRWAY_LEFT = newIntField("fairwayLeft");
    public static final Field FAIRWAY_RIGHT = newIntField("fairwayRight");
    public static final Field AVG_HANDICAP = newDoubleField("avgHandicap");
    public static final Field BEST_HANDICAP = newIntField("bestHandicap");
    public static final Field HOLE = newIntField("hole");
    public static final Field SWING_COUNT = newIntField("swingCount");
    public static final Field HANDICAP = newIntField("handicap");
    public static final Field PUTTER = newIntField("putter");
    public static final Field PENALTY = newIntField("penalty");
    public static final Field FAIRWAY_HIT = newIntField("fairwayHit");
    public static final Field SKIING_TOTAL_TIME = newLongField("total_time");
    public static final Field SKIING_TOTAL_DISTANCE = newIntField("total_distance");
    public static final Field SN = newIntField(ReportConstant.COSTREPORT_SN);
    public static final Field TYPE = newIntField("type");
    public static final Field LONGITUDE = newDoubleField("longitude");
    public static final Field LATITUDE = newDoubleField("latitude");
    public static final Field COLOR = newIntField("color");
    public static final Field MODE = newIntField("mode");

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aab implements Parcelable.Creator<Field> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public Field createFromParcel(Parcel parcel) {
            return new Field(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Field[] newArray(int i3) {
            return new Field[i3];
        }
    }

    protected Field(Parcel parcel) {
        this.name = parcel.readString();
        this.format = parcel.readInt();
    }

    public static String getFieldString(String str, int i3) {
        String str2;
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (i3 == 1) {
            str2 = "i";
        } else {
            str2 = "f";
        }
        objArr[1] = str2;
        return String.format(locale, "%s(%s)", objArr);
    }

    public static Field newDoubleField(String str) {
        return new Field(str, 2);
    }

    @Deprecated
    public static Field newFloatField(String str) {
        return new Field(str, 2);
    }

    public static Field newIntField(String str) {
        return new Field(str, 1);
    }

    public static Field newLongField(String str) {
        return new Field(str, 5);
    }

    public static Field newMapField(String str) {
        return new Field(str, 4);
    }

    public static Field newStringField(String str) {
        return new Field(str, 3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        if (this.name.equals(field.name) && this.format == field.format) {
            return true;
        }
        return false;
    }

    public int getFormat() {
        return this.format;
    }

    public String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final Boolean isOptional() {
        return Boolean.FALSE;
    }

    public String toString() {
        String str;
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[2];
        objArr[0] = this.name;
        if (this.format == 1) {
            str = "i";
        } else {
            str = "f";
        }
        objArr[1] = str;
        return String.format(locale, "%s(%s)", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.name);
        parcel.writeInt(this.format);
    }

    public Field(String str, int i3) {
        Preconditions.checkArgument(aacu.aabc(str), "Field Name Length Is Illegal!");
        boolean z16 = true;
        if (i3 != 2 && i3 != 1 && i3 != 4 && i3 != 3 && i3 != 5) {
            z16 = false;
        }
        Preconditions.checkArgument(z16, "Field Format Value Is Illegal!");
        this.name = str;
        this.format = i3;
    }
}
