package com.tencent.ttpic.openapi.gles;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes27.dex */
public class SegmentDataPipe {
    public static final int BUFFER_BUSY = 1;
    public static final int BUFFER_FREE = 0;
    public static final int BUFFER_READY = 2;
    public static final String FACE_DETECT_TIME = "sdk_face_detect_time";
    public static final String SEGMENT_TIME = "sdk_background_detect_time";
    public static final String TAG = "SegmentDataPipe";
    private static float[] sMtxIdentity = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public List<float[]> allFaceAngles;
    public List<List<PointF>> allFacePoints;
    public List<List<PointF>> allIrisPoints;
    public List<Float[]> allPointsVis;
    public int[] autoBrightnessCurve;
    public int[] autoContrastCurve;
    public int[] curve;
    public List<FaceStatus> faceStatus;
    public Pair<Integer, int[]> histogram;
    public byte[] mData;
    public long mTimestamp;
    public Frame starMaskFrame;
    public List<PointF> starPoints;
    public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
    public Set<Integer> mTriggeredExpressionType = new HashSet();
    public List<Set<Integer>> expressions = new ArrayList();
    public Map<String, String[]> recordFaceInfo = new HashMap();
    public float[] rgbGain = {1.0f, 1.0f, 1.0f};
    public double faceAverageL = 60.0d;
    public List<float[]> faceKitVerticesArray = new ArrayList();
    public List<int[]> featureIndicesArray = new ArrayList();
    public PointF facePiont2DCenter = new PointF(0.0f, 0.0f);
    public List<float[]> face3DVerticesArray = new ArrayList();
    public List<float[]> face3DRotationArray = new ArrayList();
    public Frame mTexFrame = new Frame();
    public Frame mMaskFrame = new Frame();
    public Map<String, Long> detectTimes = new HashMap();

    /* loaded from: classes27.dex */
    public interface OnFrameAvailableListener {
        void onFrameAvailable();
    }

    public int getTexureCurrentStatus() {
        return this.mTextureDataFlag.getAndAdd(0);
    }

    public void getTransformMatrix(float[] fArr) {
        if (fArr.length == 16) {
            float[] fArr2 = sMtxIdentity;
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isBusy() {
        if (this.mTextureDataFlag.get() == 1) {
            return true;
        }
        return false;
    }

    public boolean isReady() {
        if (this.mTextureDataFlag.get() == 2) {
            return true;
        }
        return false;
    }

    public void makeBusy() {
        this.mTextureDataFlag.getAndSet(1);
    }

    public void makeDataReady() {
        this.mTextureDataFlag.getAndSet(2);
    }

    public void makeFree() {
        this.mTextureDataFlag.getAndSet(0);
    }

    public void release() {
        this.mTexFrame.clear();
        this.mMaskFrame.clear();
    }
}
