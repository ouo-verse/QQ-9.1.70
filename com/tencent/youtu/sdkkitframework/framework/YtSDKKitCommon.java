package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtSDKKitCommon {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ProcessHelper {
        static IPatchRedirector $redirector_;

        public ProcessHelper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static float[] calcEyeScore(float[] fArr) {
            float f16 = fArr[32] - fArr[40];
            float f17 = fArr[33] - fArr[41];
            float sqrt = (float) Math.sqrt((f16 * f16) + (f17 * f17));
            float f18 = fArr[44];
            float f19 = fArr[40];
            float f26 = fArr[45];
            float f27 = fArr[41];
            float abs = (Math.abs(crossProduct(f16, f17, f18 - f19, f26 - f27)) + Math.abs(crossProduct(f16, f17, fArr[36] - f19, fArr[37] - f27))) / (sqrt * sqrt);
            float f28 = fArr[56] - fArr[48];
            float f29 = fArr[57] - fArr[49];
            float sqrt2 = (float) Math.sqrt((f28 * f28) + (f29 * f29));
            float f36 = fArr[60];
            float f37 = fArr[48];
            float f38 = fArr[61];
            float f39 = fArr[49];
            return new float[]{abs, (Math.abs(crossProduct(f28, f29, f36 - f37, f38 - f39)) + Math.abs(crossProduct(f28, f29, fArr[52] - f37, fArr[53] - f39))) / (sqrt2 * sqrt2)};
        }

        public static float calcMouthScore(float[] fArr) {
            return Math.abs(((fArr[129] + fArr[109]) / 2.0f) - ((fArr[119] + fArr[97]) / 2.0f)) / Math.abs(fArr[90] - fArr[102]);
        }

        public static float[] convert90PTo5P(float[] fArr) {
            YtLogger.d("ProcessHelper", "90 to 5 convert size:" + fArr.length);
            return new float[]{fArr[176], fArr[177], fArr[178], fArr[179], fArr[64], fArr[65], fArr[90], fArr[91], fArr[102], fArr[103]};
        }

        private static float crossProduct(float f16, float f17, float f18, float f19) {
            return (f16 * f19) - (f18 * f17);
        }

        public static float preCheckCloseEyeScore(float[] fArr) {
            float f16 = fArr[32] - fArr[40];
            float f17 = fArr[33] - fArr[41];
            float sqrt = (float) Math.sqrt((f16 * f16) + (f17 * f17));
            float f18 = fArr[44];
            float f19 = fArr[40];
            float f26 = fArr[45];
            float f27 = fArr[41];
            float abs = (Math.abs(crossProduct(f16, f17, f18 - f19, f26 - f27)) + Math.abs(crossProduct(f16, f17, fArr[36] - f19, fArr[37] - f27))) / (sqrt * sqrt);
            float f28 = fArr[56] - fArr[48];
            float f29 = fArr[57] - fArr[49];
            float sqrt2 = (float) Math.sqrt((f28 * f28) + (f29 * f29));
            float f36 = fArr[60];
            float f37 = fArr[48];
            float f38 = fArr[61];
            float f39 = fArr[49];
            float abs2 = (Math.abs(crossProduct(f28, f29, f36 - f37, f38 - f39)) + Math.abs(crossProduct(f28, f29, fArr[52] - f37, fArr[53] - f39))) / (sqrt2 * sqrt2);
            if (abs > abs2) {
                return abs2;
            }
            return abs;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class StateNameHelper {
        static IPatchRedirector $redirector_;
        private static HashMap<StateClassName, String> _stateNameMap;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class StateClassName {
            private static final /* synthetic */ StateClassName[] $VALUES;
            static IPatchRedirector $redirector_;
            public static final StateClassName ACTION_STATE;
            public static final StateClassName DETECTONLY_STATE;
            public static final StateClassName IDLE_STATE;
            public static final StateClassName NET_FETCH_STATE;
            public static final StateClassName NET_LIVENESS_REQ_RESULT_STATE;
            public static final StateClassName NET_OCR_REQ_RESULT_STATE;
            public static final StateClassName NET_VIID_REQ_RESULT_STATE;
            public static final StateClassName OCR_AUTO_DETECT_STATE;
            public static final StateClassName OCR_MANUAL_DETECT_STATE;
            public static final StateClassName OCR_VIID_STATE;
            public static final StateClassName QUALITY_STATE;
            public static final StateClassName REFLECT_STATE;
            public static final StateClassName SILENT_STATE;
            public static final StateClassName STATE_COUNT;
            public static final StateClassName TIMEOUT_STATE;
            public static final StateClassName UNKNOWN_STATE;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10527);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                StateClassName stateClassName = new StateClassName("UNKNOWN_STATE", 0);
                UNKNOWN_STATE = stateClassName;
                StateClassName stateClassName2 = new StateClassName("TIMEOUT_STATE", 1);
                TIMEOUT_STATE = stateClassName2;
                StateClassName stateClassName3 = new StateClassName("IDLE_STATE", 2);
                IDLE_STATE = stateClassName3;
                StateClassName stateClassName4 = new StateClassName("SILENT_STATE", 3);
                SILENT_STATE = stateClassName4;
                StateClassName stateClassName5 = new StateClassName("QUALITY_STATE", 4);
                QUALITY_STATE = stateClassName5;
                StateClassName stateClassName6 = new StateClassName("ACTION_STATE", 5);
                ACTION_STATE = stateClassName6;
                StateClassName stateClassName7 = new StateClassName("REFLECT_STATE", 6);
                REFLECT_STATE = stateClassName7;
                StateClassName stateClassName8 = new StateClassName("OCR_AUTO_DETECT_STATE", 7);
                OCR_AUTO_DETECT_STATE = stateClassName8;
                StateClassName stateClassName9 = new StateClassName("OCR_MANUAL_DETECT_STATE", 8);
                OCR_MANUAL_DETECT_STATE = stateClassName9;
                StateClassName stateClassName10 = new StateClassName("NET_FETCH_STATE", 9);
                NET_FETCH_STATE = stateClassName10;
                StateClassName stateClassName11 = new StateClassName("NET_LIVENESS_REQ_RESULT_STATE", 10);
                NET_LIVENESS_REQ_RESULT_STATE = stateClassName11;
                StateClassName stateClassName12 = new StateClassName("NET_OCR_REQ_RESULT_STATE", 11);
                NET_OCR_REQ_RESULT_STATE = stateClassName12;
                StateClassName stateClassName13 = new StateClassName("NET_VIID_REQ_RESULT_STATE", 12);
                NET_VIID_REQ_RESULT_STATE = stateClassName13;
                StateClassName stateClassName14 = new StateClassName("DETECTONLY_STATE", 13);
                DETECTONLY_STATE = stateClassName14;
                StateClassName stateClassName15 = new StateClassName("OCR_VIID_STATE", 14);
                OCR_VIID_STATE = stateClassName15;
                StateClassName stateClassName16 = new StateClassName("STATE_COUNT", 15);
                STATE_COUNT = stateClassName16;
                $VALUES = new StateClassName[]{stateClassName, stateClassName2, stateClassName3, stateClassName4, stateClassName5, stateClassName6, stateClassName7, stateClassName8, stateClassName9, stateClassName10, stateClassName11, stateClassName12, stateClassName13, stateClassName14, stateClassName15, stateClassName16};
            }

            StateClassName(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            public static StateClassName valueOf(String str) {
                return (StateClassName) Enum.valueOf(StateClassName.class, str);
            }

            public static StateClassName[] values() {
                return (StateClassName[]) $VALUES.clone();
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12231);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                _stateNameMap = new HashMap<StateClassName, String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        put(StateClassName.UNKNOWN_STATE, "com.tencent.youtu.sdkkitframework.liveness.Unknown");
                        put(StateClassName.TIMEOUT_STATE, "com.tencent.youtu.sdkkitframework.framework.TimeoutState");
                        put(StateClassName.IDLE_STATE, "com.tencent.youtu.sdkkitframework.framework.IdleState");
                        put(StateClassName.SILENT_STATE, "com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState");
                        put(StateClassName.QUALITY_STATE, "com.tencent.youtu.sdkkitframework.liveness.FaceQualityState");
                        put(StateClassName.ACTION_STATE, "com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState");
                        put(StateClassName.REFLECT_STATE, "com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState");
                        put(StateClassName.OCR_AUTO_DETECT_STATE, "com.tencent.youtu.sdkkitframework.ocr.OcrCardAutoDetectState");
                        put(StateClassName.OCR_MANUAL_DETECT_STATE, "com.tencent.youtu.sdkkitframework.ocr.OcrCardManualDetectState");
                        put(StateClassName.NET_FETCH_STATE, "com.tencent.youtu.sdkkitframework.liveness.NetFetchState");
                        put(StateClassName.NET_LIVENESS_REQ_RESULT_STATE, "com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState");
                        put(StateClassName.NET_OCR_REQ_RESULT_STATE, "com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState");
                        put(StateClassName.DETECTONLY_STATE, "com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState");
                        put(StateClassName.OCR_VIID_STATE, "com.tencent.youtu.sdkkitframework.viid.OcrVideoIdentState");
                        put(StateClassName.NET_VIID_REQ_RESULT_STATE, "com.tencent.youtu.sdkkitframework.viid.NetOcrReqResultState");
                    }
                };
            }
        }

        public StateNameHelper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static String classNameOfState(StateClassName stateClassName) {
            return _stateNameMap.get(stateClassName);
        }

        public static StateClassName typeOfClassName(String str) {
            for (Map.Entry<StateClassName, String> entry : _stateNameMap.entrySet()) {
                if (entry.getValue().equals(str)) {
                    return entry.getKey();
                }
            }
            return StateClassName.UNKNOWN_STATE;
        }
    }

    public YtSDKKitCommon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
