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
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class DataType extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataType> CREATOR;
    public static final String NAME_DATA_TYPE_BLOOD_OXYGEN = "com.heytap.health.blood_oxygen";
    public static final String NAME_DATA_TYPE_BLOOD_OXYGEN_COUNT = "com.heytap.health.blood_oxygen_count";
    public static final String NAME_DATA_TYPE_BLOOD_PRESSURE = "com.heytap.health.blood_pressure";
    public static final String NAME_DATA_TYPE_BLOOD_PRESSURE_COUNT = "com.heytap.health.blood_pressure_count";
    public static final String NAME_DATA_TYPE_BODY_WEIGHT = "com.heytap.health.body_weight";
    public static final String NAME_DATA_TYPE_DAILY_ACTIVITY = "com.heytap.health.daily_activity";
    public static final String NAME_DATA_TYPE_DAILY_ACTIVITY_COUNT = "com.heytap.health.daily_activity_count";
    public static final String NAME_DATA_TYPE_ECG = "com.heytap.health.ecg";
    public static final String NAME_DATA_TYPE_GYM_STRENGTH_TRAINING = "com.heytap.health.gym_strength_training";
    public static final String NAME_DATA_TYPE_HEARING_HEALTH = "com.heytap.health.hearing_health";
    public static final String NAME_DATA_TYPE_HEARING_HEALTH_COUNT = "com.heytap.health.hearing_health_count";
    public static final String NAME_DATA_TYPE_HEART_RATE = "com.heytap.health.heart_rate";
    public static final String NAME_DATA_TYPE_HEART_RATE_COUNT = "com.heytap.health.heart_rate_count";
    public static final String NAME_DATA_TYPE_LAT_LONG = "com.heytap.health.latitude_longitude";
    public static final String NAME_DATA_TYPE_PRESSURE = "com.heytap.health.pressure";
    public static final String NAME_DATA_TYPE_PRESSURE_COUNT = "com.heytap.health.pressure_count";
    public static final String NAME_DATA_TYPE_RELAX = "com.heytap.health.relax";
    public static final String NAME_DATA_TYPE_RELAX_COUNT = "com.heytap.health.relax_count";
    public static final String NAME_DATA_TYPE_SLEEP = "com.heytap.health.sleep";
    public static final String NAME_DATA_TYPE_SLEEP_COUNT = "com.heytap.health.sleep_count";
    public static final String NAME_DATA_TYPE_SPORT_METADATA = "com.heytap.health.sport_metadata";
    public static final String NAME_DATA_TYPE_TRAINING_ACTION = "com.heytap.health.training_action";
    private static final String TAG = "DataType";
    public static final DataType TYPE_BLOOD_OXYGEN;
    public static final DataType TYPE_BLOOD_OXYGEN_COUNT;
    public static final DataType TYPE_BLOOD_PRESSURE;
    public static final DataType TYPE_BLOOD_PRESSURE_COUNT;
    public static final DataType TYPE_BODY_WEIGHT;
    public static final DataType TYPE_DAILY_ACTIVITY;
    public static final DataType TYPE_DAILY_ACTIVITY_COUNT;
    public static final DataType TYPE_ECG;
    public static final DataType TYPE_GYM_STRENGTH_TRAINING;
    public static final DataType TYPE_HEARING_HEALTH;
    public static final DataType TYPE_HEARING_HEALTH_COUNT;
    public static final DataType TYPE_HEART_RATE;
    public static final DataType TYPE_HEART_RATE_COUNT;
    public static final DataType TYPE_LAT_LONG;
    public static final DataType TYPE_PRESSURE;
    public static final DataType TYPE_PRESSURE_COUNT;
    public static final DataType TYPE_RELAX;
    public static final DataType TYPE_RELAX_COUNT;
    public static final DataType TYPE_SLEEP;
    public static final DataType TYPE_SLEEP_COUNT;
    public static final DataType TYPE_SPORT_METADATA;
    public static final DataType TYPE_TRAINING_ACTION;

    @SafeParcelable.Field(2)
    private List<Element> elements;

    @SafeParcelable.Field(1)
    private String name;
    public static final String NAME_DATA_TYPE_USER_INFO = "com.heytap.health.openid";
    public static final DataType TYPE_USER_INFO = new DataType(NAME_DATA_TYPE_USER_INFO, Element.ELEMENT_OPENID);

    static {
        Element element = Element.ELEMENT_HEART_RATE;
        TYPE_HEART_RATE = new DataType(NAME_DATA_TYPE_HEART_RATE, element);
        Element element2 = Element.ELEMENT_MAX;
        Element element3 = Element.ELEMENT_MIN;
        Element element4 = Element.ELEMENT_AVERAGE;
        TYPE_HEART_RATE_COUNT = new DataType(NAME_DATA_TYPE_HEART_RATE_COUNT, element2, element3, element4, Element.ELEMENT_REST_HR, Element.ELEMENT_SLEEP_BASE_HR, Element.ELEMENT_WALK_AVG_HR);
        TYPE_LAT_LONG = new DataType(NAME_DATA_TYPE_LAT_LONG, Element.ELEMENT_LATITUDE, Element.ELEMENT_LONGITUDE);
        Element element5 = Element.ELEMENT_STEP;
        Element element6 = Element.ELEMENT_DISTANCE;
        Element element7 = Element.ELEMENT_CALORIE;
        TYPE_DAILY_ACTIVITY = new DataType(NAME_DATA_TYPE_DAILY_ACTIVITY, element5, element6, element7);
        TYPE_DAILY_ACTIVITY_COUNT = new DataType(NAME_DATA_TYPE_DAILY_ACTIVITY_COUNT, element5, Element.ELEMENT_STEP_GOAL, element6, element7, Element.ELEMENT_CALORIE_GOAL, Element.ELEMENT_MOVE_TIME, Element.ELEMENT_WORK_MINUTE);
        Element element8 = Element.ELEMENT_PRESSURE;
        Element element9 = Element.ELEMENT_TYPE;
        TYPE_PRESSURE = new DataType(NAME_DATA_TYPE_PRESSURE, element8, element9);
        TYPE_PRESSURE_COUNT = new DataType(NAME_DATA_TYPE_PRESSURE_COUNT, element2, element3, element4);
        TYPE_BLOOD_OXYGEN = new DataType(NAME_DATA_TYPE_BLOOD_OXYGEN, Element.ELEMENT_BLOOD_OXYGEN, element9);
        TYPE_BLOOD_OXYGEN_COUNT = new DataType(NAME_DATA_TYPE_BLOOD_OXYGEN_COUNT, element2, element3, element4);
        TYPE_SLEEP = new DataType(NAME_DATA_TYPE_SLEEP, Element.ELEMENT_SLEEP, Element.ELEMENT_DEVICE_TYPE);
        TYPE_SLEEP_COUNT = new DataType(NAME_DATA_TYPE_SLEEP_COUNT, Element.ELEMENT_TOTAL, Element.ELEMENT_TOTAL_DEEP_SLEEP_TIME, Element.ELEMENT_TOTAL_LIGHTLY_SLEEP_TIME, Element.ELEMENT_TOTAL_WAKE_UP_TIME, Element.ELEMENT_TOTAL_REM_TIME, Element.ELEMENT_FALL_ASLEEP, Element.ELEMENT_SLEEP_OUT, Element.ELEMENT_SLEEP_SCORE, Element.ELEMENT_SLEEP_DAY_FRAGS);
        TYPE_ECG = new DataType(NAME_DATA_TYPE_ECG, element, Element.ELEMENT_ECG_EXPERT_INTERPRETATION);
        Element element10 = Element.ELEMENT_DURATION;
        TYPE_HEARING_HEALTH = new DataType(NAME_DATA_TYPE_HEARING_HEALTH, Element.ELEMENT_HEARING_HEALTH, element10);
        TYPE_HEARING_HEALTH_COUNT = new DataType(NAME_DATA_TYPE_HEARING_HEALTH_COUNT, element4, element2, element3, element10);
        TYPE_RELAX = new DataType(NAME_DATA_TYPE_RELAX, element9, Element.ELEMENT_SUB_TYPE, element8, element10);
        TYPE_RELAX_COUNT = new DataType(NAME_DATA_TYPE_RELAX_COUNT, element10);
        TYPE_BLOOD_PRESSURE = new DataType(NAME_DATA_TYPE_BLOOD_PRESSURE, element9, Element.ELEMENT_BLOOD_PRESSURE_SYSTOLIC, Element.ELEMENT_BLOOD_PRESSURE_DIASTOLIC);
        TYPE_BLOOD_PRESSURE_COUNT = new DataType(NAME_DATA_TYPE_BLOOD_PRESSURE_COUNT, element9, Element.ELEMENT_BLOOD_PRESSURE_SYSTOLIC_MAX, Element.ELEMENT_BLOOD_PRESSURE_SYSTOLIC_MIN, Element.ELEMENT_BLOOD_PRESSURE_DIASTOLIC_MAX, Element.ELEMENT_BLOOD_PRESSURE_DIASTOLIC_MIN);
        TYPE_BODY_WEIGHT = new DataType(NAME_DATA_TYPE_BODY_WEIGHT, Element.ELEMENT_WEIGHT, Element.ELEMENT_BMI, Element.ELEMENT_BODY_STYLE_TEXT, Element.ELEMENT_BODY_ADVICE_TEXT);
        Element element11 = Element.ELEMENT_SPORT_MODE;
        Element element12 = Element.ELEMENT_START_TIMESTAMP;
        Element element13 = Element.ELEMENT_END_TIMESTAMP;
        Element element14 = Element.ELEMENT_AVG_HEART_RATE;
        TYPE_SPORT_METADATA = new DataType(NAME_DATA_TYPE_SPORT_METADATA, element11, element12, element13, element14, Element.ELEMENT_COURSE_NAME, Element.ELEMENT_COURSE_COMPLETE_COUNT, element7, element10, Element.ELEMENT_DEVICE_CATEGORY, Element.ELEMENT_AVG_PACE, Element.ELEMENT_BEST_PACE, Element.ELEMENT_AVG_STEP_FREQUENCY, Element.ELEMENT_BEST_STEP_FREQUENCY, element6, element5);
        Element element15 = Element.ELEMENT_TRAINING_ACTION;
        Element element16 = Element.ELEMENT_ACTION_ROUNDS;
        Element element17 = Element.ELEMENT_ACTION_COUNTERWEIGHT_1;
        Element element18 = Element.ELEMENT_ACTION_COUNTERWEIGHT_2;
        Element element19 = Element.ELEMENT_TIMES;
        Element element20 = Element.ELEMENT_ACTION_COMPLETION_STATUS;
        TYPE_GYM_STRENGTH_TRAINING = new DataType(NAME_DATA_TYPE_GYM_STRENGTH_TRAINING, Element.ELEMENT_TRAINING_TITLE, Element.ELEMENT_TRAINING_CAPACITY, element10, element7, Element.ELEMENT_MAX_HEART_RATE, element14, element12, element13, element11, Element.ELEMENT_DATA_CLIENT, element, element15, element16, element17, element18, element19, element20);
        TYPE_TRAINING_ACTION = new DataType(NAME_DATA_TYPE_TRAINING_ACTION, element15, element16, element17, element18, element19, element20);
        CREATOR = new Parcelable.Creator<DataType>() { // from class: com.heytap.databaseengine.apiv3.data.DataType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DataType createFromParcel(Parcel parcel) {
                return new DataType(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DataType[] newArray(int i3) {
                return new DataType[i3];
            }
        };
    }

    DataType(String str, Element... elementArr) {
        this.name = str;
        this.elements = Arrays.asList(elementArr);
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public String getName() {
        return this.name;
    }

    public int indexOf(Element element) {
        return this.elements.indexOf(element);
    }

    @NonNull
    public String toString() {
        return "DataType{name='" + this.name + "', elements=" + this.elements + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int writeObjectHeader = SafeParcelWriter.writeObjectHeader(parcel);
        try {
            SafeParcelWriter.write(parcel, 1, this.name, false);
            SafeParcelWriter.write(parcel, 2, (List) this.elements, i3, false);
        } catch (Exception e16) {
            HLog.w("Value", "Error writing field: " + e16);
        }
        SafeParcelWriter.finishObjectHeader(parcel, writeObjectHeader);
    }

    protected DataType(Parcel parcel) {
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
                this.elements = SafeParcelReader.readParcelableList(parcel, readHeader, Element.CREATOR);
            }
        }
    }
}
