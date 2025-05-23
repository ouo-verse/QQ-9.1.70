package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.facedetect.FaceActionCounterListener;
import com.tencent.ttpic.facedetect.FaceStatus;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes27.dex */
public class PTDetectInfo {
    public AIAttr aiAttr;
    public double audioScaleFactor;
    public List<PointF> bodyPoints;
    public float[] catFaceAngles;
    public List<PointF> catFacePoints;
    public Frame displacementMaskFrame;
    public float[] face3DNormalRotationArray;
    public float[] face3DRotationArray;
    public float[] face3DVerticesArray;
    public float[] faceAngles;
    public FaceActionCounterListener faceDetector;
    public float[] faceKitFaceRotation;
    public float[] faceKitFaceVertices;
    public List<PointF> facePoints;
    public FaceStatus faceStatus;
    public int[] featureIndices;
    public int frameIndex;
    public int gestureTrigger;
    public Map<Integer, Integer> handActionCounter;
    public List<PointF> handPoints;
    public boolean isFreezeInfo;
    public boolean needRender;
    public List<PointF> noCropFaceoffPoints;
    public List<PointF> normalFaceoffPoints;
    public Frame noseOcclusionFrame;
    public float phoneAngle;
    public float[] pointsVis;
    public int randomGroupValue;
    public float realPhoneAngle;
    public List<PointF> starPoints;
    public long timestamp;
    public List<PointF> transformPoints;
    public Set<Integer> triggeredExpression;

    /* loaded from: classes27.dex */
    public static class Builder {
        private AIAttr aiAttr;
        private double audioScaleFactor;
        private List<PointF> bodyPoints;
        private float[] catFaceAngles;
        private List<PointF> catFacePoints;
        private Frame displacementMaskFrame;
        private float[] face3DNormalRotationArray;
        private float[] face3DRotationArray;
        private float[] face3DVerticesArray;
        private float[] faceAngles;
        private FaceActionCounterListener faceDetector;
        private float[] faceKitFaceRotation;
        private float[] faceKitFaceVertices;
        private List<PointF> facePoints;
        private FaceStatus faceStatus;
        private int[] featureIndices;
        private int frameIndex;
        private Map<Integer, Integer> handActionCounter;
        private List<PointF> handPoints;
        private boolean needRender;
        public List<PointF> noCropFaceoffPoints;
        public List<PointF> normalFaceoffPoints;
        private Frame noseOcclusionFrame;
        private float phoneAngle;
        private float[] pointsVis;
        private int randomGroupValue;
        private float realPhoneAngle;
        private List<PointF> starPoints;
        private long timestamp;
        public List<PointF> transformPoints;
        private Set<Integer> triggeredExpression;
        private int gestureTrigger = -1;
        private boolean isFreezeInfo = false;

        public Builder aiAttr(AIAttr aIAttr) {
            this.aiAttr = aIAttr;
            return this;
        }

        public Builder audioScaleFactor(double d16) {
            this.audioScaleFactor = d16;
            return this;
        }

        public Builder bodyPoints(List<PointF> list) {
            this.bodyPoints = list;
            return this;
        }

        public PTDetectInfo build() {
            return new PTDetectInfo(this);
        }

        public Builder catFaceAngles(float[] fArr) {
            this.catFaceAngles = fArr;
            return this;
        }

        public Builder catFacePoints(List<PointF> list) {
            this.catFacePoints = list;
            return this;
        }

        public Builder displacementMaskFrame(Frame frame) {
            this.displacementMaskFrame = frame;
            return this;
        }

        public Builder face3DNormalRotationArray(float[] fArr) {
            this.face3DNormalRotationArray = fArr;
            return this;
        }

        public Builder face3DRotationArray(float[] fArr) {
            this.face3DRotationArray = fArr;
            return this;
        }

        public Builder face3DVerticesArray(float[] fArr) {
            this.face3DVerticesArray = fArr;
            return this;
        }

        public Builder faceAngles(float[] fArr) {
            this.faceAngles = fArr;
            return this;
        }

        public Builder faceDetector(FaceActionCounterListener faceActionCounterListener) {
            this.faceDetector = faceActionCounterListener;
            return this;
        }

        public Builder faceKitFaceRotation(float[] fArr) {
            this.faceKitFaceRotation = fArr;
            return this;
        }

        public Builder faceKitFaceVertices(float[] fArr) {
            this.faceKitFaceVertices = fArr;
            return this;
        }

        public Builder facePoints(List<PointF> list) {
            this.facePoints = list;
            return this;
        }

        public Builder faceStatus(FaceStatus faceStatus) {
            this.faceStatus = faceStatus;
            return this;
        }

        public Builder featureIndices(int[] iArr) {
            this.featureIndices = iArr;
            return this;
        }

        public Builder frameIndex(int i3) {
            this.frameIndex = i3;
            return this;
        }

        public Builder gestureTrigger(int i3) {
            this.gestureTrigger = i3;
            return this;
        }

        public Builder handActionCounter(Map<Integer, Integer> map) {
            this.handActionCounter = map;
            return this;
        }

        public Builder handPoints(List<PointF> list) {
            this.handPoints = list;
            return this;
        }

        public Builder isFreezeInfo(boolean z16) {
            this.isFreezeInfo = z16;
            return this;
        }

        public Builder needRender(boolean z16) {
            this.needRender = z16;
            return this;
        }

        public Builder noCropFaceoffPoints(List<PointF> list) {
            this.noCropFaceoffPoints = list;
            return this;
        }

        public Builder normalFaceoffPoints(List<PointF> list) {
            this.normalFaceoffPoints = list;
            return this;
        }

        public Builder noseOcclusionFrame(Frame frame) {
            this.noseOcclusionFrame = frame;
            return this;
        }

        public Builder phoneAngle(float f16) {
            this.phoneAngle = f16;
            return this;
        }

        public Builder pointsVis(Float[] fArr) {
            if (fArr != null && fArr.length != 0) {
                float[] fArr2 = new float[fArr.length];
                for (int i3 = 0; i3 < fArr.length; i3++) {
                    fArr2[i3] = fArr[i3].floatValue();
                }
                this.pointsVis = fArr2;
            }
            return this;
        }

        public Builder randomGroupValue(int i3) {
            this.randomGroupValue = i3;
            return this;
        }

        public Builder realPhoneAngle(float f16) {
            this.realPhoneAngle = f16;
            return this;
        }

        public Builder starPoints(List<PointF> list) {
            this.starPoints = list;
            return this;
        }

        public Builder timestamp(long j3) {
            this.timestamp = j3;
            return this;
        }

        public Builder transformPoints(List<PointF> list) {
            this.transformPoints = list;
            return this;
        }

        public Builder triggeredExpression(Set<Integer> set) {
            this.triggeredExpression = set;
            return this;
        }
    }

    PTDetectInfo() {
        this.gestureTrigger = -1;
        this.isFreezeInfo = false;
    }

    public PTDetectInfo(Builder builder) {
        this.gestureTrigger = -1;
        this.isFreezeInfo = false;
        this.facePoints = builder.facePoints;
        this.faceAngles = builder.faceAngles;
        this.pointsVis = builder.pointsVis;
        this.handPoints = builder.handPoints;
        this.handActionCounter = builder.handActionCounter;
        this.triggeredExpression = builder.triggeredExpression;
        this.bodyPoints = builder.bodyPoints;
        this.catFacePoints = builder.catFacePoints;
        this.catFaceAngles = builder.catFaceAngles;
        this.phoneAngle = builder.phoneAngle;
        this.realPhoneAngle = builder.realPhoneAngle;
        this.timestamp = builder.timestamp;
        this.faceDetector = builder.faceDetector;
        this.starPoints = builder.starPoints;
        this.faceStatus = builder.faceStatus;
        this.gestureTrigger = builder.gestureTrigger;
        this.isFreezeInfo = builder.isFreezeInfo;
        this.faceKitFaceVertices = builder.faceKitFaceVertices;
        this.faceKitFaceRotation = builder.faceKitFaceRotation;
        this.face3DVerticesArray = builder.face3DVerticesArray;
        this.face3DRotationArray = builder.face3DRotationArray;
        this.face3DNormalRotationArray = builder.face3DNormalRotationArray;
        this.featureIndices = builder.featureIndices;
        this.aiAttr = builder.aiAttr;
        this.noseOcclusionFrame = builder.noseOcclusionFrame;
        this.displacementMaskFrame = builder.displacementMaskFrame;
        this.randomGroupValue = builder.randomGroupValue;
        this.frameIndex = builder.frameIndex;
        this.audioScaleFactor = builder.audioScaleFactor;
        this.needRender = builder.needRender;
        this.transformPoints = builder.transformPoints;
        this.noCropFaceoffPoints = builder.noCropFaceoffPoints;
        this.normalFaceoffPoints = builder.normalFaceoffPoints;
    }
}
