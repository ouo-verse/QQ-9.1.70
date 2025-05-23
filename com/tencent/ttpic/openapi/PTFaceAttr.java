package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.YoutuPointsUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.light.bean.TTFaceOriginDataModel;

/* loaded from: classes27.dex */
public class PTFaceAttr {
    private List<Integer> ageList;
    private int[] autoBrightnessCurve;
    private int[] autoContrastCurve;
    private List<List<PointF>> bodyPoints;
    private int[] curve;
    private Map<String, Long> detectTimes;
    private List<Set<Integer>> expressions;
    private List<float[]> face3DRotationArray;
    private List<float[]> face3DVerticesArray;
    private double faceAverageL;
    private int faceDetHeight;
    private int faceDetRotation;
    private int faceDetWidth;
    private List<float[]> faceKitVerticesArray;
    private PointF facePiont2DCenter;
    private List<int[]> featureIndicesArray;
    private int gender;
    private List<Integer> genderList;
    private Pair<Integer, int[]> histogram;
    private boolean isPhoneFlatHorizontal;
    private int lastFaceDetectedPhoneRotation;
    private byte[] mData;
    private List<float[]> mFaceAngles;
    private double mFaceDetectScale;
    private Map<PTExpression, Boolean> mFaceExpression;
    private List<FaceInfo> mFaceInfoList;
    private List<List<PointF>> mFacePoint94;
    private List<List<PointF>> mFacePoints;
    private List<FaceStatus> mFaceStatusList;
    private List<List<PointF>> mIrisPoints;
    private Frame mOrigFrame;
    private List<Float[]> mPointsVis;
    private Map<String, String[]> mRecordFaceInfo;
    private int mRotation;
    private int mSrcRotation;
    private long mTimeStamp;
    private List<List<PointF>> mTransformFacePoints;
    private Set<Integer> mTriggeredExpression;
    private PTFaceAttr reusedFaceAttr;
    private float[] rgbGain;
    private Frame starMaskFrame;
    private List<PointF> starPoints;

    /* loaded from: classes27.dex */
    public static class Builder {
        private List<Integer> ageList;
        private int[] autoBrightnessCurve;
        private int[] autoContrastCurve;
        private List<List<PointF>> bodyPoints;
        private int[] curve;
        private byte[] data;
        private Map<String, Long> detectTimes;
        private List<Set<Integer>> expressions;
        private List<float[]> face3DRotationArray;
        private List<float[]> face3DVerticesArray;
        private Map<PTExpression, Boolean> faceExpression;
        private List<FaceInfo> faceInfos;
        private List<float[]> faceKitVerticesArray;
        private PointF facePiont2DCenter;
        private List<List<PointF>> facePoint94;
        private List<FaceStatus> faceStatusList;
        private List<int[]> featureIndicesArray;
        private List<Integer> genderList;
        private Pair<Integer, int[]> histogram;
        private List<List<PointF>> irisPoints;
        private boolean isPhoneFlatHorizontal;
        private Frame origFrame;
        private List<Float[]> pointsVis;
        private int rotation;
        private int srcRotation;
        private Frame starMaskFrame;
        private List<PointF> starPoints;
        private long timeStamp;
        private Map<String, String[]> recordFaceInfo = new HashMap();
        private double faceDetectScale = 1.0d;
        private float[] rgbGain = {1.0f, 1.0f, 1.0f};
        private double faceAverageL = 60.0d;
        private int lastFaceDetectedPhoneRotation = 0;
        private int faceDetWidth = 0;
        private int faceDetHeight = 0;
        private int faceDetRotation = 0;
        private List<List<PointF>> facePoints = new ArrayList();
        private List<float[]> faceAngles = new ArrayList();
        private Set<Integer> triggeredExpression = new HashSet();

        public Builder ageList(List<Integer> list) {
            this.ageList = list;
            return this;
        }

        public Builder autoBrightnessCurve(int[] iArr) {
            this.autoBrightnessCurve = iArr;
            return this;
        }

        public Builder autoContrastCurve(int[] iArr) {
            this.autoContrastCurve = iArr;
            return this;
        }

        public Builder bodyPoints(List<List<PointF>> list) {
            this.bodyPoints = list;
            return this;
        }

        public PTFaceAttr build() {
            return new PTFaceAttr(this);
        }

        public Builder curve(int[] iArr) {
            this.curve = iArr;
            return this;
        }

        public Builder data(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Builder detectTimes(Map map) {
            this.detectTimes = map;
            return this;
        }

        public Builder expressions(List<Set<Integer>> list) {
            this.expressions = list;
            return this;
        }

        public Builder face3DRotationArray(List<float[]> list) {
            this.face3DRotationArray = list;
            return this;
        }

        public Builder face3DVerticesArray(List<float[]> list) {
            this.face3DVerticesArray = list;
            return this;
        }

        public Builder faceAngles(List<float[]> list) {
            this.faceAngles = list;
            return this;
        }

        public Builder faceAverageL(double d16) {
            this.faceAverageL = d16;
            return this;
        }

        public Builder faceDetHeight(int i3) {
            this.faceDetHeight = i3;
            return this;
        }

        public Builder faceDetRotation(int i3) {
            this.faceDetRotation = i3;
            return this;
        }

        public Builder faceDetWidth(int i3) {
            this.faceDetWidth = i3;
            return this;
        }

        public Builder faceDetectScale(double d16) {
            this.faceDetectScale = d16;
            return this;
        }

        public Builder faceExpression(Map<PTExpression, Boolean> map) {
            this.faceExpression = map;
            return this;
        }

        public Builder faceInfoList(List<FaceInfo> list) {
            this.faceInfos = list;
            return this;
        }

        public Builder faceKitVerticesArray(List<float[]> list) {
            this.faceKitVerticesArray = list;
            return this;
        }

        public Builder facePiont2DCenter(PointF pointF) {
            this.facePiont2DCenter = pointF;
            return this;
        }

        public Builder facePoint94(List<List<PointF>> list) {
            this.facePoint94 = list;
            return this;
        }

        public Builder facePoints(List<List<PointF>> list) {
            this.facePoints = list;
            return this;
        }

        public Builder faceStatusList(List<FaceStatus> list) {
            this.faceStatusList = list;
            return this;
        }

        public Builder featureIndicesArray(List<int[]> list) {
            this.featureIndicesArray = list;
            return this;
        }

        public Builder genderList(List<Integer> list) {
            this.genderList = list;
            return this;
        }

        public Builder histogram(Pair<Integer, int[]> pair) {
            this.histogram = pair;
            return this;
        }

        public Builder irisPoints(List<List<PointF>> list) {
            this.irisPoints = list;
            return this;
        }

        public Builder isPhoneFlatHorizontal(boolean z16) {
            this.isPhoneFlatHorizontal = z16;
            return this;
        }

        public Builder lastFaceDetectedPhoneRotation(int i3) {
            this.lastFaceDetectedPhoneRotation = i3;
            return this;
        }

        public Builder origFrame(Frame frame) {
            this.origFrame = frame;
            return this;
        }

        public Builder pointsVis(List<Float[]> list) {
            this.pointsVis = list;
            return this;
        }

        public Builder recordFaceInfo(Map<String, String[]> map) {
            this.recordFaceInfo = map;
            return this;
        }

        public Builder rgbGain(float[] fArr) {
            this.rgbGain = fArr;
            return this;
        }

        public Builder rotation(int i3) {
            this.rotation = i3;
            return this;
        }

        public Builder srcRotation(int i3) {
            this.srcRotation = i3;
            return this;
        }

        public Builder starMaskFrame(Frame frame) {
            this.starMaskFrame = frame;
            return this;
        }

        public Builder starPoints(List<PointF> list) {
            this.starPoints = list;
            return this;
        }

        public Builder timeStamp(long j3) {
            this.timeStamp = j3;
            return this;
        }

        public Builder triggeredExpression(Set<Integer> set) {
            this.triggeredExpression = set;
            return this;
        }
    }

    public PTFaceAttr(Builder builder) {
        this.faceDetWidth = 0;
        this.faceDetHeight = 0;
        this.faceDetRotation = 0;
        this.mRecordFaceInfo = new HashMap();
        initValues(builder);
        this.mFacePoint94 = builder.facePoint94;
        this.mFacePoints = builder.facePoints;
        this.mIrisPoints = builder.irisPoints;
        this.mPointsVis = builder.pointsVis;
        this.mRecordFaceInfo = builder.recordFaceInfo;
        this.mFaceAngles = builder.faceAngles;
        this.mData = builder.data;
        this.genderList = builder.genderList;
        this.ageList = builder.ageList;
        this.mFaceExpression = builder.faceExpression;
        this.mFaceStatusList = builder.faceStatusList;
        this.mFaceInfoList = builder.faceInfos;
        this.mOrigFrame = builder.origFrame;
        this.mTimeStamp = builder.timeStamp;
        this.mRotation = builder.rotation;
        this.mSrcRotation = builder.srcRotation;
        this.mTriggeredExpression = builder.triggeredExpression;
        this.mFaceDetectScale = builder.faceDetectScale;
        this.histogram = builder.histogram;
        this.bodyPoints = builder.bodyPoints;
        this.starPoints = builder.starPoints;
        this.starMaskFrame = builder.starMaskFrame;
        this.rgbGain = builder.rgbGain;
        this.curve = builder.curve;
        this.autoContrastCurve = builder.autoContrastCurve;
        this.autoBrightnessCurve = builder.autoBrightnessCurve;
        this.faceAverageL = builder.faceAverageL;
        this.faceKitVerticesArray = builder.faceKitVerticesArray;
        this.face3DVerticesArray = builder.face3DVerticesArray;
        this.face3DRotationArray = builder.face3DRotationArray;
        this.featureIndicesArray = builder.featureIndicesArray;
        this.facePiont2DCenter = builder.facePiont2DCenter;
        this.lastFaceDetectedPhoneRotation = builder.lastFaceDetectedPhoneRotation;
        this.isPhoneFlatHorizontal = builder.isPhoneFlatHorizontal;
        this.detectTimes = builder.detectTimes;
        this.faceDetWidth = builder.faceDetWidth;
        this.faceDetHeight = builder.faceDetHeight;
        this.faceDetRotation = builder.faceDetRotation;
        this.expressions = builder.expressions;
    }

    private static boolean checkFaceFeatureOutScreen(List<PointF> list, int i3, int i16, double d16) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) (i3 * d16), (float) (i16 * d16));
        if (!rectF.contains(list.get(65).x, list.get(65).y) || !rectF.contains(list.get(66).x, list.get(66).y)) {
            return false;
        }
        PointF pointF = new PointF((list.get(69).x + list.get(9).x) / 2.0f, (list.get(69).y + list.get(9).y) / 2.0f);
        return rectF.contains(pointF.x, pointF.y);
    }

    public static boolean checkFaceFeatureOutScreenUKYO(List<PointF> list, int i3, int i16, double d16) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) (i3 * d16), (float) (i16 * d16));
        if (!rectF.contains(list.get(61).x, list.get(61).y) || !rectF.contains(list.get(57).x, list.get(57).y)) {
            return false;
        }
        PointF pointF = new PointF((list.get(69).x + list.get(9).x) / 2.0f, (list.get(69).y + list.get(9).y) / 2.0f);
        return rectF.contains(pointF.x, pointF.y);
    }

    private void initValues(Builder builder) {
        builder.faceExpression = new HashMap();
        if (builder.triggeredExpression == null) {
            builder.triggeredExpression = new HashSet();
            builder.triggeredExpression.add(1);
        }
        for (PTExpression pTExpression : PTExpression.values()) {
            if (builder.triggeredExpression.contains(Integer.valueOf(pTExpression.value))) {
                builder.faceExpression.put(pTExpression, Boolean.TRUE);
            } else {
                builder.faceExpression.put(pTExpression, Boolean.FALSE);
            }
        }
        builder.bodyPoints = new ArrayList();
    }

    public static boolean isPositiveFace(float[] fArr, List<PointF> list, int i3, int i16, double d16) {
        double min = Math.min(Math.abs(Math.cos(fArr[0])), Math.abs(Math.cos(fArr[1])));
        if (!checkFaceFeatureOutScreen(list, i3, i16, d16) || min < 0.94d) {
            return false;
        }
        return true;
    }

    public List<Integer> getAgeList() {
        return this.ageList;
    }

    public List<float[]> getAllFaceAngles() {
        return this.mFaceAngles;
    }

    public List<List<PointF>> getAllFacePoints() {
        return this.mFacePoints;
    }

    public List<List<PointF>> getAllFacePoints94() {
        return this.mFacePoint94;
    }

    public List<List<PointF>> getAllIrisPoints() {
        return this.mIrisPoints;
    }

    public int[] getAutoBrightnessCurve() {
        return this.autoBrightnessCurve;
    }

    public int[] getAutoContrastCurve() {
        return this.autoContrastCurve;
    }

    public List<List<PointF>> getBodyPoints() {
        return this.bodyPoints;
    }

    public int[] getCurve() {
        return this.curve;
    }

    public byte[] getData() {
        return this.mData;
    }

    public List<Set<Integer>> getExpressions() {
        return this.expressions;
    }

    public List<float[]> getFace3DRotationArray() {
        return this.face3DRotationArray;
    }

    public List<float[]> getFace3DVerticesArray() {
        return this.face3DVerticesArray;
    }

    public double getFaceAverageL() {
        return this.faceAverageL;
    }

    public int getFaceCount() {
        return this.mFacePoints.size();
    }

    public int getFaceDetHeight() {
        return this.faceDetHeight;
    }

    public int getFaceDetRotation() {
        return this.faceDetRotation;
    }

    public int getFaceDetWidth() {
        return this.faceDetWidth;
    }

    public double getFaceDetectScale() {
        return this.mFaceDetectScale;
    }

    public long getFaceDetectTime() {
        Map<String, Long> map = this.detectTimes;
        if (map != null && map.get(SegmentDataPipe.FACE_DETECT_TIME) != null) {
            return this.detectTimes.get(SegmentDataPipe.FACE_DETECT_TIME).longValue();
        }
        return 0L;
    }

    public Map<PTExpression, Boolean> getFaceExpression() {
        return this.mFaceExpression;
    }

    public List<FaceInfo> getFaceInfoList() {
        return this.mFaceInfoList;
    }

    public List<float[]> getFaceKitVerticesArray() {
        return this.faceKitVerticesArray;
    }

    public PointF getFacePiont2DCenter() {
        return this.facePiont2DCenter;
    }

    public List<FaceStatus> getFaceStatusList() {
        return this.mFaceStatusList;
    }

    public List<int[]> getFeatureIndicesArray() {
        return this.featureIndicesArray;
    }

    public List<Integer> getGenderList() {
        return this.genderList;
    }

    public Pair<Integer, int[]> getHistogram() {
        return this.histogram;
    }

    public int getLastFaceDetectedPhoneRotation() {
        return this.lastFaceDetectedPhoneRotation;
    }

    public Frame getOrigFrame() {
        return this.mOrigFrame;
    }

    public List<Float[]> getPointsVis() {
        return this.mPointsVis;
    }

    public float[] getRGBGain() {
        return this.rgbGain;
    }

    public Map<String, String[]> getRecordFaceInfo() {
        return this.mRecordFaceInfo;
    }

    public PTFaceAttr getReusedFaceAttr() {
        return this.reusedFaceAttr;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getSrcRotation() {
        return this.mSrcRotation;
    }

    public Frame getStarMaskFrame() {
        return this.starMaskFrame;
    }

    public List<PointF> getStarPoints() {
        return this.starPoints;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public List<List<PointF>> getTransformFacePoints() {
        return this.mTransformFacePoints;
    }

    public Set<Integer> getTriggeredExpression() {
        return this.mTriggeredExpression;
    }

    public void initTransformFacePoints() {
        if (this.mTransformFacePoints == null) {
            this.mTransformFacePoints = new ArrayList();
        }
        this.mTransformFacePoints.clear();
        List<List<PointF>> list = this.mFacePoints;
        if (list != null) {
            Iterator<List<PointF>> it = list.iterator();
            while (it.hasNext()) {
                this.mTransformFacePoints.add(VideoMaterial.copyList(it.next()));
            }
        }
    }

    public boolean isLandscape() {
        int i3 = this.mRotation;
        if (i3 != 90 && i3 != 270) {
            return false;
        }
        return true;
    }

    public boolean isPhoneFlatHorizontal() {
        return this.isPhoneFlatHorizontal;
    }

    public void mergeOrigFaceData(List<TTFaceOriginDataModel> list) {
        int i3;
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TTFaceOriginDataModel> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TTFaceOriginDataModel next = it.next();
            FaceInfo faceInfo = new FaceInfo();
            float[] fArr = next.facePoint;
            faceInfo.points = YoutuPointsUtil.transformYTPointsToPtuPoints(fArr);
            faceInfo.irisPoints = YoutuPointsUtil.getIrisPoints(fArr);
            Float[] transformYTPointsVisToPtuPoints = YoutuPointsUtil.transformYTPointsVisToPtuPoints(next.facePointVisible);
            faceInfo.pointsVis = transformYTPointsVisToPtuPoints;
            faceInfo.pointsVis = YoutuPointsUtil.smoothYTPointsVisPoints(transformYTPointsVisToPtuPoints);
            float[] fArr2 = faceInfo.angles;
            float f16 = next.pitch;
            fArr2[0] = ((float) ((f16 * 3.141592653589793d) / 180.0d)) * (-1.0f);
            float f17 = next.yaw;
            fArr2[1] = ((float) ((f17 * 3.141592653589793d) / 180.0d)) * (-1.0f);
            float f18 = next.roll;
            fArr2[2] = ((float) ((f18 * 3.141592653589793d) / 180.0d)) * (-1.0f);
            faceInfo.pitch = f16;
            faceInfo.yaw = f17;
            faceInfo.roll = f18;
            faceInfo.scale = 0.0f;
            faceInfo.f381699tx = 0.0f;
            faceInfo.f381700ty = 0.0f;
            faceInfo.denseFaceModel = null;
            faceInfo.transform = null;
            faceInfo.expressionWeights = null;
            faceInfo.gender = GenderType.FEMALE.value;
            arrayList.add(faceInfo);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        new HashSet().add(1);
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            arrayList2.add(((FaceInfo) arrayList.get(i16)).points);
        }
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            arrayList3.add(((FaceInfo) arrayList.get(i17)).irisPoints);
        }
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            arrayList4.add(((FaceInfo) arrayList.get(i18)).pointsVis);
        }
        for (i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList5.add(((FaceInfo) arrayList.get(i3)).angles);
        }
        List<List<PointF>> rotatePointsForList = AlgoUtils.rotatePointsForList(arrayList2, this.faceDetWidth, this.faceDetHeight, this.faceDetRotation);
        List<List<PointF>> rotatePointsForList2 = AlgoUtils.rotatePointsForList(arrayList3, this.faceDetWidth, this.faceDetHeight, this.faceDetRotation);
        List<float[]> rotateAngles = AlgoUtils.rotateAngles(arrayList5, -this.faceDetRotation);
        this.mFacePoints.addAll(rotatePointsForList);
        this.mIrisPoints.addAll(rotatePointsForList2);
        this.mPointsVis.addAll(arrayList4);
        this.mFaceAngles.addAll(rotateAngles);
        this.mFaceInfoList.addAll(arrayList);
    }

    public void setAutoBrightnessCurve(int[] iArr) {
        this.autoBrightnessCurve = iArr;
    }

    public void setAutoContrastCurve(int[] iArr) {
        this.autoContrastCurve = iArr;
    }

    public void setBodyPoints(List<List<PointF>> list) {
        this.bodyPoints = list;
    }

    public void setCurve(int[] iArr) {
        this.curve = iArr;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setFaceAngles(List<float[]> list) {
        this.mFaceAngles = list;
    }

    public void setFaceAverageL(double d16) {
        this.faceAverageL = d16;
    }

    public void setFaceDetectScale(double d16) {
        this.mFaceDetectScale = d16;
    }

    public void setFaceExpression(Map<PTExpression, Boolean> map) {
        this.mFaceExpression = map;
    }

    public void setFacePoints(List<List<PointF>> list) {
        this.mFacePoints = list;
    }

    public void setFaceStatusList(List<FaceStatus> list) {
        this.mFaceStatusList = list;
    }

    public void setHistogram(Pair<Integer, int[]> pair) {
        this.histogram = pair;
    }

    public void setIrisPoints(List<List<PointF>> list) {
        this.mIrisPoints = list;
    }

    public void setIsPhoneFlatHorizontal(boolean z16) {
        this.isPhoneFlatHorizontal = z16;
    }

    public void setLastFaceDetectedPhoneRotation(int i3) {
        this.lastFaceDetectedPhoneRotation = i3;
    }

    public void setOrigFrame(Frame frame) {
        this.mOrigFrame = frame;
    }

    public void setPointsVis(List<Float[]> list) {
        this.mPointsVis = list;
    }

    public void setRGBGain(float[] fArr) {
        this.rgbGain = fArr;
    }

    public void setReusedFaceAttr(PTFaceAttr pTFaceAttr) {
        this.reusedFaceAttr = pTFaceAttr;
    }

    public void setRotation(int i3) {
        this.mRotation = i3;
    }

    public void setSrcRotation(int i3) {
        this.mSrcRotation = i3;
    }

    public void setStarMaskFrame(Frame frame) {
        this.starMaskFrame = frame;
    }

    public void setStarPoints(List<PointF> list) {
        this.starPoints = list;
    }

    public void setTimeStamp(long j3) {
        this.mTimeStamp = j3;
    }

    public void setTransformFacePoints(int i3, List<PointF> list) {
        this.mTransformFacePoints.set(i3, list);
    }

    public void setTriggeredExpression(Set<Integer> set) {
        this.mTriggeredExpression = set;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FACE_NO_NOUTH' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes27.dex */
    public static final class PTExpression {
        private static final /* synthetic */ PTExpression[] $VALUES;
        public static final PTExpression[] ACTION_TRIGGER_TYPE;
        public static final PTExpression ALL_VIEWER_ITEM_FRAME_FROZEN;
        public static final PTExpression ALWAYS;
        public static final PTExpression BLINK;
        public static final PTExpression BLINK_LEFT_EYE;
        public static final PTExpression BLINK_RIGHT_EYE;
        public static final PTExpression DOUBLE_EYE_OCCLUDED;
        public static final PTExpression EXTERNAL_WORDS;
        public static final PTExpression EYEBROWS_RAISE;
        public static final PTExpression FACE_DETECT;
        public static final PTExpression FACE_NO_BLINK;
        public static final PTExpression FACE_NO_EYEBROWS;
        public static final PTExpression FACE_NO_HEAD;
        public static final PTExpression FACE_NO_KISS;
        public static final PTExpression FACE_NO_NOUTH;
        public static final PTExpression HAND_LABEL_EIGHT;
        public static final PTExpression HAND_LABEL_FIST;
        public static final PTExpression HAND_LABEL_HAND;
        public static final PTExpression HAND_LABEL_HEART;
        public static final PTExpression HAND_LABEL_LIKE;
        public static final PTExpression HAND_LABEL_LOVE;
        public static final PTExpression HAND_LABEL_OK;
        public static final PTExpression HAND_LABEL_ONE;
        public static final PTExpression HAND_LABEL_PAPER;
        public static final PTExpression HAND_LABEL_ROCK;
        public static final PTExpression HAND_LABEL_SCISSOR;
        public static final PTExpression HAND_LABEL_SIX;
        public static final PTExpression HEAD_NOD;
        public static final PTExpression HEAD_SHAKE;
        public static final PTExpression HEAD_SHAKE_NEW;
        public static final PTExpression KISS;
        public static final PTExpression LEFT_EYE_OCCLUDED;
        public static final PTExpression MOUTH_OCCLUDED;
        public static final PTExpression MOUTH_OPEN;
        public static final PTExpression MV_PART_INDEX;
        public static final PTExpression RIGHT_EYE_OCCLUDED;
        public static final PTExpression SMILE;
        public static final PTExpression TAP_SCREEN;
        public static final PTExpression TIME_TRIGGER;
        public static final PTExpression TRY_CLICK_SCREEN;
        public static final PTExpression UNKNOW;
        public PTExpression opposite;
        public final int value;

        static {
            PTExpression pTExpression = new PTExpression("UNKNOW", 0, 0);
            UNKNOW = pTExpression;
            PTExpression pTExpression2 = new PTExpression("ALWAYS", 1, 1);
            ALWAYS = pTExpression2;
            PTExpression pTExpression3 = new PTExpression("FACE_DETECT", 2, 2);
            FACE_DETECT = pTExpression3;
            PTExpression pTExpression4 = new PTExpression("MOUTH_OPEN", 3, 3);
            MOUTH_OPEN = pTExpression4;
            PTExpression pTExpression5 = new PTExpression("EYEBROWS_RAISE", 4, 4);
            EYEBROWS_RAISE = pTExpression5;
            PTExpression pTExpression6 = new PTExpression("BLINK", 5, 5);
            BLINK = pTExpression6;
            PTExpression pTExpression7 = new PTExpression("HEAD_SHAKE", 6, 6);
            HEAD_SHAKE = pTExpression7;
            PTExpression pTExpression8 = new PTExpression("KISS", 7, 7);
            KISS = pTExpression8;
            PTExpression pTExpression9 = new PTExpression("BLINK_LEFT_EYE", 8, 8);
            BLINK_LEFT_EYE = pTExpression9;
            PTExpression pTExpression10 = new PTExpression("BLINK_RIGHT_EYE", 9, 9);
            BLINK_RIGHT_EYE = pTExpression10;
            PTExpression pTExpression11 = new PTExpression("HEAD_NOD", 10, 10);
            HEAD_NOD = pTExpression11;
            PTExpression pTExpression12 = new PTExpression("HEAD_SHAKE_NEW", 11, 11);
            HEAD_SHAKE_NEW = pTExpression12;
            PTExpression pTExpression13 = new PTExpression("TRY_CLICK_SCREEN", 12, 12);
            TRY_CLICK_SCREEN = pTExpression13;
            PTExpression pTExpression14 = new PTExpression("MV_PART_INDEX", 13, 13);
            MV_PART_INDEX = pTExpression14;
            PTExpression pTExpression15 = new PTExpression("SMILE", 14, 14);
            SMILE = pTExpression15;
            PTExpression pTExpression16 = new PTExpression("MOUTH_OCCLUDED", 15, 15);
            MOUTH_OCCLUDED = pTExpression16;
            PTExpression pTExpression17 = new PTExpression("LEFT_EYE_OCCLUDED", 16, 16);
            LEFT_EYE_OCCLUDED = pTExpression17;
            PTExpression pTExpression18 = new PTExpression("RIGHT_EYE_OCCLUDED", 17, 17);
            RIGHT_EYE_OCCLUDED = pTExpression18;
            PTExpression pTExpression19 = new PTExpression("DOUBLE_EYE_OCCLUDED", 18, 18);
            DOUBLE_EYE_OCCLUDED = pTExpression19;
            PTExpression pTExpression20 = new PTExpression("FACE_NO_NOUTH", 19, 103, pTExpression4);
            FACE_NO_NOUTH = pTExpression20;
            PTExpression pTExpression21 = new PTExpression("FACE_NO_EYEBROWS", 20, 104, pTExpression5);
            FACE_NO_EYEBROWS = pTExpression21;
            PTExpression pTExpression22 = new PTExpression("FACE_NO_BLINK", 21, 105, pTExpression6);
            FACE_NO_BLINK = pTExpression22;
            PTExpression pTExpression23 = new PTExpression("FACE_NO_HEAD", 22, 106, pTExpression7);
            FACE_NO_HEAD = pTExpression23;
            PTExpression pTExpression24 = new PTExpression("FACE_NO_KISS", 23, 107, pTExpression8);
            FACE_NO_KISS = pTExpression24;
            PTExpression pTExpression25 = new PTExpression("HAND_LABEL_HAND", 24, 200);
            HAND_LABEL_HAND = pTExpression25;
            PTExpression pTExpression26 = new PTExpression("HAND_LABEL_HEART", 25, 201);
            HAND_LABEL_HEART = pTExpression26;
            PTExpression pTExpression27 = new PTExpression("HAND_LABEL_PAPER", 26, 202);
            HAND_LABEL_PAPER = pTExpression27;
            PTExpression pTExpression28 = new PTExpression("HAND_LABEL_SCISSOR", 27, 203);
            HAND_LABEL_SCISSOR = pTExpression28;
            PTExpression pTExpression29 = new PTExpression("HAND_LABEL_FIST", 28, 204);
            HAND_LABEL_FIST = pTExpression29;
            PTExpression pTExpression30 = new PTExpression("HAND_LABEL_ONE", 29, 205);
            HAND_LABEL_ONE = pTExpression30;
            PTExpression pTExpression31 = new PTExpression("HAND_LABEL_LOVE", 30, 206);
            HAND_LABEL_LOVE = pTExpression31;
            PTExpression pTExpression32 = new PTExpression("HAND_LABEL_LIKE", 31, 207);
            HAND_LABEL_LIKE = pTExpression32;
            PTExpression pTExpression33 = new PTExpression("HAND_LABEL_OK", 32, 208);
            HAND_LABEL_OK = pTExpression33;
            PTExpression pTExpression34 = new PTExpression("HAND_LABEL_ROCK", 33, 209);
            HAND_LABEL_ROCK = pTExpression34;
            PTExpression pTExpression35 = new PTExpression("HAND_LABEL_SIX", 34, 210);
            HAND_LABEL_SIX = pTExpression35;
            PTExpression pTExpression36 = new PTExpression("HAND_LABEL_EIGHT", 35, 211);
            HAND_LABEL_EIGHT = pTExpression36;
            PTExpression pTExpression37 = new PTExpression("ALL_VIEWER_ITEM_FRAME_FROZEN", 36, 501);
            ALL_VIEWER_ITEM_FRAME_FROZEN = pTExpression37;
            PTExpression pTExpression38 = new PTExpression("TIME_TRIGGER", 37, 601);
            TIME_TRIGGER = pTExpression38;
            PTExpression pTExpression39 = new PTExpression("EXTERNAL_WORDS", 38, 701);
            EXTERNAL_WORDS = pTExpression39;
            PTExpression pTExpression40 = new PTExpression("TAP_SCREEN", 39, 801);
            TAP_SCREEN = pTExpression40;
            $VALUES = new PTExpression[]{pTExpression, pTExpression2, pTExpression3, pTExpression4, pTExpression5, pTExpression6, pTExpression7, pTExpression8, pTExpression9, pTExpression10, pTExpression11, pTExpression12, pTExpression13, pTExpression14, pTExpression15, pTExpression16, pTExpression17, pTExpression18, pTExpression19, pTExpression20, pTExpression21, pTExpression22, pTExpression23, pTExpression24, pTExpression25, pTExpression26, pTExpression27, pTExpression28, pTExpression29, pTExpression30, pTExpression31, pTExpression32, pTExpression33, pTExpression34, pTExpression35, pTExpression36, pTExpression37, pTExpression38, pTExpression39, pTExpression40};
            ACTION_TRIGGER_TYPE = new PTExpression[]{pTExpression4, pTExpression5, pTExpression6, pTExpression7, pTExpression8, pTExpression9, pTExpression10, pTExpression11, pTExpression12, pTExpression13};
        }

        PTExpression(String str, int i3, int i16) {
            this.value = i16;
        }

        public static PTExpression valueOf(String str) {
            return (PTExpression) Enum.valueOf(PTExpression.class, str);
        }

        public static PTExpression[] values() {
            return (PTExpression[]) $VALUES.clone();
        }

        PTExpression(String str, int i3, int i16, PTExpression pTExpression) {
            this.value = i16;
            this.opposite = pTExpression;
        }
    }
}
