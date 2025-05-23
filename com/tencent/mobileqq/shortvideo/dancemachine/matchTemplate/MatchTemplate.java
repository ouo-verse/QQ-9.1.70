package com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MatchTemplate {
    public static final int CHECK_ANGLE = 1;
    public static final int CHECK_DISTANCE = 0;
    public static final String CONFIG_NAME = "pose.cfg";
    public static final int MSG_INDICATOR = 2;
    public static final int MSG_LOG = 1;
    public static final String TAG = "POS_MATCH_TEMPLATE";
    public static MatchTemplate instance;
    public Handler uiHandler;

    MatchTemplate() {
    }

    public static void MLog(String str) {
        Log.d(TAG, str);
    }

    private double calDegree(float f16, float f17, float f18, float f19) {
        float calDis = calDis(0.0f, 0.0f, f16, f17);
        float calDis2 = calDis(0.0f, 0.0f, f18, f19);
        if (calDis != 0.0f && calDis2 != 0.0f) {
            return Math.toDegrees(Math.acos(((f16 * f18) + (f17 * f19)) / (calDis * calDis2)));
        }
        return Double.NaN;
    }

    private IVec3f findIVec(List<IVec3f> list, int i3) {
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (list.get(i16).index == i3) {
                return list.get(i16);
            }
        }
        return null;
    }

    private MatchTemplateConfig.KeyPoint findKeyPoint(List<MatchTemplateConfig.KeyPoint> list, int i3) {
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (list.get(i16).index == i3) {
                return list.get(i16);
            }
        }
        return null;
    }

    public static MatchTemplate getInstance() {
        if (instance == null) {
            synchronized (MatchTemplate.class) {
                if (instance == null) {
                    instance = new MatchTemplate();
                }
            }
        }
        return instance;
    }

    private void logLocalPoints(String str, List<IVec3f> list) {
        StringBuilder sb5 = new StringBuilder(str);
        for (int i3 = 0; i3 < list.size(); i3++) {
            sb5.append(list.get(i3).toString() + "        ");
        }
        MLog(sb5.toString());
    }

    private boolean match(List<Vec3f> list, MatchTemplateConfig matchTemplateConfig, int i3) {
        if (matchTemplateConfig == null) {
            return false;
        }
        try {
            List<MatchTemplateConfig.KeyPoint> list2 = matchTemplateConfig.keyPoints;
            MatchTemplateConfig.KeyPoint findKeyPoint = findKeyPoint(list2, matchTemplateConfig.datumIndex0);
            MatchTemplateConfig.KeyPoint findKeyPoint2 = findKeyPoint(list2, matchTemplateConfig.datumIndex1);
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < list2.size(); i16++) {
                int i17 = list2.get(i16).index;
                arrayList.add(new IVec3f(i17, list.get(i17)));
            }
            int i18 = matchTemplateConfig.datumIndex0;
            int i19 = matchTemplateConfig.datumIndex1;
            float[] fArr = findKeyPoint.coords;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float[] fArr2 = findKeyPoint2.coords;
            List<IVec3f> convertPoints = convertPoints(arrayList, i18, i19, Float.valueOf(calDis(f16, f17, fArr2[0], fArr2[1])));
            if (convertPoints == null) {
                return false;
            }
            int i26 = matchTemplateConfig.checkMethod;
            if (i26 == 1) {
                return matchAng(convertPoints, matchTemplateConfig);
            }
            if (i26 != 0) {
                return false;
            }
            return matchDis(convertPoints, matchTemplateConfig);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean matchAng(List<IVec3f> list, MatchTemplateConfig matchTemplateConfig) {
        List<IVec3f> list2 = list;
        char c16 = 0;
        if (list2 == null || matchTemplateConfig == null || matchTemplateConfig.keyPoints.size() == 0) {
            return false;
        }
        List<MatchTemplateConfig.KeyVector> list3 = matchTemplateConfig.keyVectors;
        List<MatchTemplateConfig.KeyPoint> list4 = matchTemplateConfig.keyPoints;
        StringBuilder sb5 = new StringBuilder();
        char c17 = 1;
        double d16 = 0.0d;
        int i3 = 0;
        int i16 = 1;
        while (i3 < list3.size()) {
            MatchTemplateConfig.KeyVector keyVector = list3.get(i3);
            MatchTemplateConfig.KeyPoint findKeyPoint = findKeyPoint(list4, keyVector.vectors[c16]);
            MatchTemplateConfig.KeyPoint findKeyPoint2 = findKeyPoint(list4, keyVector.vectors[c17]);
            IVec3f findIVec = findIVec(list2, keyVector.vectors[c16]);
            IVec3f findIVec2 = findIVec(list2, keyVector.vectors[c17]);
            float[] fArr = findKeyPoint2.coords;
            float f16 = fArr[0];
            float[] fArr2 = findKeyPoint.coords;
            double calDegree = calDegree(f16 - fArr2[0], fArr[c17] - fArr2[c17], findIVec2.f287861x - findIVec.f287861x, findIVec2.f287862y - findIVec.f287862y);
            if (Double.isNaN(calDegree)) {
                i16 = 0;
            }
            List<MatchTemplateConfig.KeyVector> list5 = list3;
            double d17 = calDegree * keyVector.weight;
            int i17 = keyVector.threshold;
            if (i17 != 0 && d17 > i17) {
                i16 = 0;
            }
            sb5.append("[" + keyVector.vectors[0] + " , " + keyVector.vectors[1] + " ] : " + d17 + "\n");
            d16 += d17;
            i3++;
            list2 = list;
            list3 = list5;
            c16 = 0;
            c17 = 1;
        }
        sb5.append("total : " + d16);
        float f17 = matchTemplateConfig.degreeThreshold;
        if (f17 != 0.0f && d16 > f17) {
            i16 = 0;
        }
        Handler handler = this.uiHandler;
        if (handler == null) {
            if (i16 == 1) {
                return true;
            }
            return false;
        }
        handler.removeMessages(0, null);
        Message obtainMessage = this.uiHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = sb5.toString();
        this.uiHandler.sendMessage(obtainMessage);
        Message obtainMessage2 = this.uiHandler.obtainMessage();
        obtainMessage2.what = 2;
        obtainMessage2.arg1 = i16;
        this.uiHandler.sendMessage(obtainMessage2);
        if (i16 == 1) {
            return true;
        }
        return false;
    }

    private boolean matchDis(List<IVec3f> list, MatchTemplateConfig matchTemplateConfig) {
        if (list == null || matchTemplateConfig == null || matchTemplateConfig.keyPoints.size() == 0) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        float f16 = 0.0f;
        int i3 = 1;
        for (int i16 = 0; i16 < matchTemplateConfig.keyPoints.size(); i16++) {
            MatchTemplateConfig.KeyPoint keyPoint = matchTemplateConfig.keyPoints.get(i16);
            float calDis = calDis(list.get(i16).f287861x, list.get(i16).f287862y, matchTemplateConfig.keyPoints.get(i16).coords[0], matchTemplateConfig.keyPoints.get(i16).coords[1]) * keyPoint.weight;
            float f17 = keyPoint.threshold;
            if (f17 != 0.0f && calDis > f17) {
                i3 = 0;
            }
            f16 += calDis;
            if (calDis >= 1.0f) {
                sb5.append(matchTemplateConfig.keyPoints.get(i16).index + ProgressTracer.SEPARATOR + calDis);
                sb5.append(System.getProperty("line.separator").toString());
            }
        }
        sb5.append("total : " + f16);
        MLog(sb5.toString());
        float f18 = matchTemplateConfig.distanceThreshold;
        if (f18 != 0.0f && f16 > f18) {
            i3 = 0;
        }
        Handler handler = this.uiHandler;
        if (handler == null) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        handler.removeMessages(0, null);
        Message obtainMessage = this.uiHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = sb5.toString();
        this.uiHandler.sendMessage(obtainMessage);
        Message obtainMessage2 = this.uiHandler.obtainMessage();
        obtainMessage2.what = 2;
        obtainMessage2.arg1 = i3;
        this.uiHandler.sendMessage(obtainMessage2);
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public float calDis(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f18;
        float f27 = f17 - f19;
        return (float) Math.sqrt((f26 * f26) + (f27 * f27));
    }

    public List<IVec3f> convertPoints(List<IVec3f> list, int i3, int i16, Float f16) {
        IVec3f iVec3f = null;
        IVec3f iVec3f2 = null;
        for (int i17 = 0; i17 < list.size(); i17++) {
            try {
                IVec3f iVec3f3 = list.get(i17);
                int i18 = iVec3f3.index;
                if (i18 == i3) {
                    iVec3f = iVec3f3;
                }
                if (i18 == i16) {
                    iVec3f2 = iVec3f3;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        if (iVec3f != null && iVec3f2 != null) {
            float calDis = calDis(iVec3f.f287861x, iVec3f.f287862y, iVec3f2.f287861x, iVec3f2.f287862y);
            if (f16 != null && f16.floatValue() > 0.0f) {
                calDis = f16.floatValue();
            }
            float calDis2 = calDis(iVec3f.f287861x, iVec3f.f287862y, iVec3f2.f287861x, iVec3f2.f287862y);
            if (calDis2 <= 0.0f) {
                return null;
            }
            float f17 = calDis / calDis2;
            Matrix matrix = new Matrix();
            matrix.setTranslate(-iVec3f.f287861x, -iVec3f.f287862y);
            double degrees = Math.toDegrees(Math.acos((iVec3f2.f287861x - iVec3f.f287861x) / calDis2));
            if (iVec3f2.f287862y - iVec3f.f287862y > 0.0f) {
                degrees = -degrees;
            }
            matrix.postRotate((float) degrees);
            matrix.postScale(f17, f17);
            float[] fArr = new float[list.size() * 2];
            for (int i19 = 0; i19 < list.size(); i19++) {
                int i26 = i19 * 2;
                fArr[i26] = list.get(i19).f287861x;
                fArr[i26 + 1] = list.get(i19).f287862y;
            }
            matrix.mapPoints(fArr);
            ArrayList arrayList = new ArrayList();
            for (int i27 = 0; i27 < list.size(); i27++) {
                int i28 = i27 * 2;
                arrayList.add(new IVec3f(list.get(i27).index, fArr[i28], fArr[i28 + 1], 0.0f));
            }
            return arrayList;
        }
        return null;
    }

    public MatchTemplateConfig generateConfig(List<IVec3f> list, int i3, int i16) {
        float f16;
        float f17;
        try {
            MatchTemplateConfig matchTemplateConfig = new MatchTemplateConfig();
            matchTemplateConfig.datumIndex0 = i3;
            matchTemplateConfig.datumIndex1 = i16;
            matchTemplateConfig.distanceThreshold = 100.0f;
            char c16 = 0;
            matchTemplateConfig.checkMethod = 0;
            List<IVec3f> convertPoints = convertPoints(list, i3, i16, Float.valueOf(100.0f));
            if (convertPoints != null && convertPoints.size() != 0) {
                ArrayList arrayList = new ArrayList();
                int i17 = 0;
                while (i17 < list.size()) {
                    IVec3f iVec3f = convertPoints.get(i17);
                    int i18 = iVec3f.index;
                    float[] fArr = new float[2];
                    if (Math.abs(iVec3f.f287861x) < 0.1d) {
                        f16 = 0.0f;
                    } else {
                        f16 = iVec3f.f287861x;
                    }
                    fArr[c16] = f16;
                    if (Math.abs(iVec3f.f287862y) < 0.1d) {
                        f17 = 0.0f;
                    } else {
                        f17 = iVec3f.f287862y;
                    }
                    fArr[1] = f17;
                    arrayList.add(new MatchTemplateConfig.KeyPoint(i18, 1.0f, 0.0f, fArr));
                    i17++;
                    c16 = 0;
                }
                matchTemplateConfig.keyPoints = arrayList;
            }
            return matchTemplateConfig;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public boolean multiMatch(List<Vec3f> list, List<MatchTemplateConfig> list2, int i3) {
        for (int i16 = 0; i16 < list2.size(); i16++) {
            MatchTemplateConfig matchTemplateConfig = list2.get(i16);
            if (matchTemplateConfig != null && match(list, matchTemplateConfig, i3)) {
                return true;
            }
        }
        return false;
    }
}
