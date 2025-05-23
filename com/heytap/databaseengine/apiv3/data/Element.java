package com.heytap.databaseengine.apiv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.safeparcel.AbstractSafeParcelable;
import com.heytap.databaseengine.safeparcel.SafeParcelReader;
import com.heytap.databaseengine.safeparcel.SafeParcelWriter;
import com.heytap.databaseengine.safeparcel.SafeParcelable;
import com.heytap.databaseengine.utils.HLog;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class Element extends AbstractSafeParcelable {
    public static final String ELEMENT_NAME_AVERAGE = "average";
    public static final String ELEMENT_NAME_DEVICE_TYPE = "device_type";
    public static final String ELEMENT_NAME_DURATION = "duration";
    public static final String ELEMENT_NAME_LATITUDE = "latitude";
    public static final String ELEMENT_NAME_LONGITUDE = "longitude";
    public static final String ELEMENT_NAME_MAX = "max";
    public static final String ELEMENT_NAME_OPENID = "openid";
    public static final String ELEMENT_NAME_PRESSURE = "pressure";
    public static final String ELEMENT_NAME_SLEEP = "sleep";
    public static final String ELEMENT_NAME_STEP = "step";
    public static final String ELEMENT_NAME_SUB_TYPE = "sub_type";
    public static final String ELEMENT_NAME_TOTAL = "total";
    public static final String ELEMENT_NAME_TYPE = "type";
    public static final String ELEMENT_NAME_WEIGHT = "weight";
    public static final int FLOAT = 3;
    public static final int INTEGER = 1;
    public static final int STRING = 2;
    private static final String TAG = "Element";

    @SafeParcelable.Field(2)
    private int format;

    @SafeParcelable.Field(1)
    private String name;
    public static final Element ELEMENT_OPENID = createElement("openid", 2);
    public static final Element ELEMENT_LONGITUDE = createElement("longitude", 3);
    public static final Element ELEMENT_LATITUDE = createElement("latitude", 3);
    public static final Element ELEMENT_STEP = createElement("step", 1);
    public static final String ELEMENT_NAME_STEP_GOAL = "step_goal";
    public static final Element ELEMENT_STEP_GOAL = createElement(ELEMENT_NAME_STEP_GOAL, 1);
    public static final String ELEMENT_NAME_DISTANCE = "distance";
    public static final Element ELEMENT_DISTANCE = createElement(ELEMENT_NAME_DISTANCE, 1);
    public static final String ELEMENT_NAME_CALORIE = "calorie";
    public static final Element ELEMENT_CALORIE = createElement(ELEMENT_NAME_CALORIE, 1);
    public static final String ELEMENT_NAME_CALORIE_GOAL = "calorie_goal";
    public static final Element ELEMENT_CALORIE_GOAL = createElement(ELEMENT_NAME_CALORIE_GOAL, 1);
    public static final String ELEMENT_NAME_MOVE_TIME = "move_time";
    public static final Element ELEMENT_MOVE_TIME = createElement(ELEMENT_NAME_MOVE_TIME, 1);
    public static final String ELEMENT_NAME_WORK_MINUTE = "work_minute";
    public static final Element ELEMENT_WORK_MINUTE = createElement(ELEMENT_NAME_WORK_MINUTE, 1);
    public static final String ELEMENT_NAME_START_TIMESTAMP = "start_timestamp";
    public static final Element ELEMENT_START_TIMESTAMP = createElement(ELEMENT_NAME_START_TIMESTAMP, 1);
    public static final String ELEMENT_NAME_END_TIMESTAMP = "end_timestamp";
    public static final Element ELEMENT_END_TIMESTAMP = createElement(ELEMENT_NAME_END_TIMESTAMP, 1);
    public static final String ELEMENT_NAME_SPORT_MODE = "sport_mode";
    public static final Element ELEMENT_SPORT_MODE = createElement(ELEMENT_NAME_SPORT_MODE, 1);
    public static final String ELEMENT_NAME_AVG_HEART_RATE = "avg_heart_rate";
    public static final Element ELEMENT_AVG_HEART_RATE = createElement(ELEMENT_NAME_AVG_HEART_RATE, 1);
    public static final String ELEMENT_NAME_MAX_HEART_RATE = "max_heart_rate";
    public static final Element ELEMENT_MAX_HEART_RATE = createElement(ELEMENT_NAME_MAX_HEART_RATE, 1);
    public static final String ELEMENT_NAME_COURSE_NAME = "course_name";
    public static final Element ELEMENT_COURSE_NAME = createElement(ELEMENT_NAME_COURSE_NAME, 2);
    public static final String ELEMENT_NAME_COURSE_COMPLETE_COUNT = "course_complete_count";
    public static final Element ELEMENT_COURSE_COMPLETE_COUNT = createElement(ELEMENT_NAME_COURSE_COMPLETE_COUNT, 1);
    public static final String ELEMENT_NAME_AVG_PACE = "avg_pace";
    public static final Element ELEMENT_AVG_PACE = createElement(ELEMENT_NAME_AVG_PACE, 1);
    public static final String ELEMENT_NAME_BEST_PACE = "best_pace";
    public static final Element ELEMENT_BEST_PACE = createElement(ELEMENT_NAME_BEST_PACE, 1);
    public static final String ELEMENT_NAME_AVG_STEP_FREQUENCY = "avg_step_frequency";
    public static final Element ELEMENT_AVG_STEP_FREQUENCY = createElement(ELEMENT_NAME_AVG_STEP_FREQUENCY, 1);
    public static final String ELEMENT_NAME_BEST_STEP_FREQUENCY = "best_step_frequency";
    public static final Element ELEMENT_BEST_STEP_FREQUENCY = createElement(ELEMENT_NAME_BEST_STEP_FREQUENCY, 1);
    public static final String ELEMENT_NAME_DEVICE_CATEGORY = "device_category";
    public static final Element ELEMENT_DEVICE_CATEGORY = createElement(ELEMENT_NAME_DEVICE_CATEGORY, 2);
    public static final String ELEMENT_NAME_DATA_CLIENT = "data_client";
    public static final Element ELEMENT_DATA_CLIENT = createElement(ELEMENT_NAME_DATA_CLIENT, 2);
    public static final String ELEMENT_NAME_TRAINING_TITLE = "training_title";
    public static final Element ELEMENT_TRAINING_TITLE = createElement(ELEMENT_NAME_TRAINING_TITLE, 2);
    public static final String ELEMENT_NAME_TRAINING_CAPACITY = "training_capacity";
    public static final Element ELEMENT_TRAINING_CAPACITY = createElement(ELEMENT_NAME_TRAINING_CAPACITY, 1);
    public static final String ELEMENT_NAME_TRAINING_ACTION = "training_action";
    public static final Element ELEMENT_TRAINING_ACTION = createElement(ELEMENT_NAME_TRAINING_ACTION, 2);
    public static final String ELEMENT_NAME_ACTION_ROUNDS = "action_rounds";
    public static final Element ELEMENT_ACTION_ROUNDS = createElement(ELEMENT_NAME_ACTION_ROUNDS, 2);
    public static final String ELEMENT_NAME_ACTION_COUNTERWEIGHT_1 = "action_counterweight_1";
    public static final Element ELEMENT_ACTION_COUNTERWEIGHT_1 = createElement(ELEMENT_NAME_ACTION_COUNTERWEIGHT_1, 1);
    public static final String ELEMENT_NAME_ACTION_COUNTERWEIGHT_2 = "action_counterweight_2";
    public static final Element ELEMENT_ACTION_COUNTERWEIGHT_2 = createElement(ELEMENT_NAME_ACTION_COUNTERWEIGHT_2, 1);
    public static final String ELEMENT_NAME_TIMES = "times";
    public static final Element ELEMENT_TIMES = createElement(ELEMENT_NAME_TIMES, 1);
    public static final String ELEMENT_NAME_ACTION_COMPLETION_STATUS = "action_completion_status";
    public static final Element ELEMENT_ACTION_COMPLETION_STATUS = createElement(ELEMENT_NAME_ACTION_COMPLETION_STATUS, 1);
    public static final String ELEMENT_NAME_HEART_RATE = "heart_rate";
    public static final Element ELEMENT_HEART_RATE = createElement(ELEMENT_NAME_HEART_RATE, 1);
    public static final Element ELEMENT_PRESSURE = createElement("pressure", 1);
    public static final String ELEMENT_NAME_BLOOD_OXYGEN = "blood_oxygen";
    public static final Element ELEMENT_BLOOD_OXYGEN = createElement(ELEMENT_NAME_BLOOD_OXYGEN, 1);
    public static final Element ELEMENT_SLEEP = createElement("sleep", 1);
    public static final String ELEMENT_NAME_ECG_EXPERT_INTERPRETATION = "ecg_expert_interpretation";
    public static final Element ELEMENT_ECG_EXPERT_INTERPRETATION = createElement(ELEMENT_NAME_ECG_EXPERT_INTERPRETATION, 2);
    public static final String ELEMENT_NAME_HEARING_HEALTH = "hearing_health";
    public static final Element ELEMENT_HEARING_HEALTH = createElement(ELEMENT_NAME_HEARING_HEALTH, 1);
    public static final String ELEMENT_NAME_BLOOD_PRESSURE_SYSTOLIC = "blood_pressure_systolic";
    public static final Element ELEMENT_BLOOD_PRESSURE_SYSTOLIC = createElement(ELEMENT_NAME_BLOOD_PRESSURE_SYSTOLIC, 1);
    public static final String ELEMENT_NAME_BLOOD_PRESSURE_DIASTOLIC = "blood_pressure_diastolic";
    public static final Element ELEMENT_BLOOD_PRESSURE_DIASTOLIC = createElement(ELEMENT_NAME_BLOOD_PRESSURE_DIASTOLIC, 1);
    public static final String ELEMENT_NAME_BLOOD_PRESSURE_DIASTOLIC_MIN = "blood_pressure_diastolic_min";
    public static final Element ELEMENT_BLOOD_PRESSURE_DIASTOLIC_MIN = createElement(ELEMENT_NAME_BLOOD_PRESSURE_DIASTOLIC_MIN, 1);
    public static final String ELEMENT_NAME_BLOOD_PRESSURE_DIASTOLIC_MAX = "blood_pressure_diastolic_max";
    public static final Element ELEMENT_BLOOD_PRESSURE_DIASTOLIC_MAX = createElement(ELEMENT_NAME_BLOOD_PRESSURE_DIASTOLIC_MAX, 1);
    public static final String ELEMENT_NAME_BLOOD_PRESSURE_SYSTOLIC_MIN = "blood_pressure_systolic_min";
    public static final Element ELEMENT_BLOOD_PRESSURE_SYSTOLIC_MIN = createElement(ELEMENT_NAME_BLOOD_PRESSURE_SYSTOLIC_MIN, 1);
    public static final String ELEMENT_NAME_BLOOD_PRESSURE_SYSTOLIC_MAX = "blood_pressure_systolic_max";
    public static final Element ELEMENT_BLOOD_PRESSURE_SYSTOLIC_MAX = createElement(ELEMENT_NAME_BLOOD_PRESSURE_SYSTOLIC_MAX, 1);
    public static final Element ELEMENT_WEIGHT = createElement("weight", 2);
    public static final String ELEMENT_NAME_BMI = "bmi";
    public static final Element ELEMENT_BMI = createElement(ELEMENT_NAME_BMI, 2);
    public static final String ELEMENT_NAME_BODY_STYLE_TEXT = "body_style_text";
    public static final Element ELEMENT_BODY_STYLE_TEXT = createElement(ELEMENT_NAME_BODY_STYLE_TEXT, 2);
    public static final String ELEMENT_NAME_BODY_ADVICE_TEXT = "body_advice_text";
    public static final Element ELEMENT_BODY_ADVICE_TEXT = createElement(ELEMENT_NAME_BODY_ADVICE_TEXT, 2);
    public static final Element ELEMENT_TOTAL = createElement("total", 3);
    public static final Element ELEMENT_MAX = createElement("max", 3);
    public static final String ELEMENT_NAME_MIN = "min";
    public static final Element ELEMENT_MIN = createElement(ELEMENT_NAME_MIN, 3);
    public static final Element ELEMENT_AVERAGE = createElement("average", 3);
    public static final Element ELEMENT_TYPE = createElement("type", 1);
    public static final Element ELEMENT_SUB_TYPE = createElement("sub_type", 1);
    public static final Element ELEMENT_DURATION = createElement("duration", 1);
    public static final String ELEMENT_NAME_REST_HR = "rest_hr";
    public static final Element ELEMENT_REST_HR = createElement(ELEMENT_NAME_REST_HR, 1);
    public static final String ELEMENT_NAME_SLEEP_BASE_HR = "sleep_base_hr";
    public static final Element ELEMENT_SLEEP_BASE_HR = createElement(ELEMENT_NAME_SLEEP_BASE_HR, 1);
    public static final String ELEMENT_NAME_WALK_AVG_HR = "walk_avg_hr";
    public static final Element ELEMENT_WALK_AVG_HR = createElement(ELEMENT_NAME_WALK_AVG_HR, 1);
    public static final String ELEMENT_NAME_SLEEP_SCORE = "sleep_score";
    public static final Element ELEMENT_SLEEP_SCORE = createElement(ELEMENT_NAME_SLEEP_SCORE, 1);
    public static final String ELEMENT_NAME_FALL_ASLEEP = "fall_asleep";
    public static final Element ELEMENT_FALL_ASLEEP = createElement(ELEMENT_NAME_FALL_ASLEEP, 1);
    public static final String ELEMENT_NAME_SLEEP_OUT = "sleep_out";
    public static final Element ELEMENT_SLEEP_OUT = createElement(ELEMENT_NAME_SLEEP_OUT, 1);
    public static final String ELEMENT_NAME_TOTAL_DEEP_SLEEP_TIME = "total_deep_sleep_time";
    public static final Element ELEMENT_TOTAL_DEEP_SLEEP_TIME = createElement(ELEMENT_NAME_TOTAL_DEEP_SLEEP_TIME, 1);
    public static final String ELEMENT_NAME_TOTAL_LIGHTLY_SLEEP_TIME = "total_lightly_sleep_time";
    public static final Element ELEMENT_TOTAL_LIGHTLY_SLEEP_TIME = createElement(ELEMENT_NAME_TOTAL_LIGHTLY_SLEEP_TIME, 1);
    public static final String ELEMENT_NAME_TOTAL_WAKE_UP_TIME = "total_wake_up_time";
    public static final Element ELEMENT_TOTAL_WAKE_UP_TIME = createElement(ELEMENT_NAME_TOTAL_WAKE_UP_TIME, 1);
    public static final String ELEMENT_NAME_TOTAL_REM_TIME = "total_rem_time";
    public static final Element ELEMENT_TOTAL_REM_TIME = createElement(ELEMENT_NAME_TOTAL_REM_TIME, 1);
    public static final String ELEMENT_NAME_SLEEP_DAY_FRAGS = "sleep_day_frags";
    public static final Element ELEMENT_SLEEP_DAY_FRAGS = createElement(ELEMENT_NAME_SLEEP_DAY_FRAGS, 2);
    public static final Element ELEMENT_DEVICE_TYPE = createElement("device_type", 1);
    public static final Parcelable.Creator<Element> CREATOR = new Parcelable.Creator<Element>() { // from class: com.heytap.databaseengine.apiv3.data.Element.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Element createFromParcel(Parcel parcel) {
            return new Element(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Element[] newArray(int i3) {
            return new Element[i3];
        }
    };

    public Element(String str, int i3) {
        this.name = str;
        this.format = i3;
    }

    public static Element createElement(String str, int i3) {
        return new Element(str, i3);
    }

    public int getFormat() {
        return this.format;
    }

    public String getName() {
        return this.name;
    }

    public void setFormat(int i3) {
        this.format = i3;
    }

    public void setName(String str) {
        this.name = str;
    }

    @NonNull
    public String toString() {
        return "Element{name='" + this.name + "', format=" + this.format + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int writeObjectHeader = SafeParcelWriter.writeObjectHeader(parcel);
        try {
            SafeParcelWriter.write(parcel, 1, this.name, false);
            SafeParcelWriter.write(parcel, 2, Integer.valueOf(this.format));
        } catch (Exception e16) {
            HLog.w("Value", "Error writing field: " + e16);
        }
        SafeParcelWriter.finishObjectHeader(parcel, writeObjectHeader);
    }

    protected Element(Parcel parcel) {
        int readObjectHeader = SafeParcelReader.readObjectHeader(parcel);
        while (parcel.dataPosition() < readObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                this.name = SafeParcelReader.readString(parcel, readHeader);
            } else if (fieldId != 2) {
                HLog.e(TAG, "unknown field id:" + fieldId);
                SafeParcelReader.skip(parcel, readHeader);
            } else {
                this.format = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
    }
}
