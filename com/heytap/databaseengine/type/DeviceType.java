package com.heytap.databaseengine.type;

import com.heytap.databaseengine.utils.AlertNullOrEmptyUtil;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DeviceType {
    public static final int BAND_PRODUCT_ID = 2;
    public static final int BODY_FAT_SCALE = 100;
    public static final int MANUAL_PRODUCT_ID = -1;
    public static final int PHONE_PRODUCT_ID = 0;
    public static final int RS_WATCH = 3;
    public static final int SPHYGMOMANOMETER = 5;
    public static final int TREADMILL = 6;
    public static final int UNKNOWN_DEVICE_ID = -10;
    public static final String UNKNOWN_DEVICE_NAME = "UNKNOWN";
    public static final int WATCH3 = 102;
    public static final int WATCH_PRODUCT_ID = 1;
    public static final int XIAO_TIAN_CAI_WATCH = 101;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DeviceCategory {
        public static final String MERGER = "merge";
        public static final String NOT_SET = "";
        public static final String PHONE = "Phone";
        private static final String[] CAN_CHANGE_WORK_OUT_GOAL_MODEL = {"OWW221"};
        public static final String MOBILE = "mobile";
        public static final String[] PHONE_DEVICE = {"Phone", MOBILE, ""};
        public static final String BAND = "Band";
        public static final String WATCH = "Watch";
        public static final String WATCH2 = "WATCH2";
        public static final String WATCH3 = "WATCH3";
        public static final String WATCH3PRO = "WATCH3PRO";
        public static final String WATCH_GT = "WATCH_GT";
        public static final String BAND2 = "BAND2";
        public static final String REALME_GT = "REALME_GT";
        public static final String BANDHSB = "BANDHSB";
        public static final String WATCH3SE = "WATCH3SE";
        public static final String WATCH4PRO = "WATCH4PRO";
        public static final String WATCH4 = "WATCH4";
        public static final String WATCH_STAR = "WATCH_STAR";
        public static final String[] WATCH_OR_BAND_DEVICE = {BAND, WATCH, WATCH2, WATCH3, WATCH3PRO, WATCH_GT, BAND2, REALME_GT, BANDHSB, WATCH3SE, WATCH4PRO, WATCH4, WATCH_STAR};
        public static final String[] WATCHES = {WATCH, WATCH2, WATCH3, WATCH3PRO, WATCH3SE, WATCH4PRO, WATCH4, WATCH_STAR};
        public static final String[] BANDS = {BAND, BAND2, BANDHSB};
        public static final String[] WATCHES_RX = {WATCH_GT, REALME_GT};
        public static final String[] NEED_ADD_WORKOUT_DEVICE = {"Phone", BAND, WATCH, WATCH_GT};

        public static boolean belongBands(String str) {
            if (!AlertNullOrEmptyUtil.isNullOrEmpty(str)) {
                return Arrays.asList(BANDS).contains(str);
            }
            return false;
        }

        public static boolean belongWatches(String str) {
            if (!AlertNullOrEmptyUtil.isNullOrEmpty(str)) {
                return Arrays.asList(WATCHES).contains(str);
            }
            return false;
        }

        public static boolean belongWatchesRX(String str) {
            if (!AlertNullOrEmptyUtil.isNullOrEmpty(str)) {
                return Arrays.asList(WATCHES_RX).contains(str);
            }
            return false;
        }

        public static boolean isWatchOrBandDeviceCategory(String str) {
            if (!AlertNullOrEmptyUtil.isNullOrEmpty(str)) {
                return Arrays.asList(WATCH_OR_BAND_DEVICE).contains(str);
            }
            return false;
        }

        public static boolean shouldAddWorkoutDeviceCategory(String str) {
            if (!AlertNullOrEmptyUtil.isNullOrEmpty(str)) {
                return Arrays.asList(NEED_ADD_WORKOUT_DEVICE).contains(str);
            }
            return false;
        }

        public static boolean supportChangeWorkoutGoalByModel(String str) {
            if (!AlertNullOrEmptyUtil.isNullOrEmpty(str)) {
                return Arrays.asList(CAN_CHANGE_WORK_OUT_GOAL_MODEL).contains(str);
            }
            return false;
        }
    }
}
