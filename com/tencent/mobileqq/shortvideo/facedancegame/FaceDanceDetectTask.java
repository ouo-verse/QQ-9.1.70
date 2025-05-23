package com.tencent.mobileqq.shortvideo.facedancegame;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.SystemClock;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.facedancegame.utils.ActUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class FaceDanceDetectTask implements IGestureDetectCallBack, IFaceDetectCallBack {
    private static final String TAG = "FaceDanceDetectTask";
    static final int TASKSTATUS_EXPRESSIONDETECT = 3;
    static final int TASKSTATUS_FACEDETECT = 2;
    static final int TASKSTATUS_INITING = 1;
    static final int TASKSTATUS_READY = 0;
    private static final String TIMETAG = "FaceDanceDetectTaskTime";
    private static FaceDanceDetectTask instance = new FaceDanceDetectTask();
    private List<WeakReference<GLLittleBoy>> littleBoyReferenceList = new ArrayList();
    volatile WeakReference<GLLittleBoy> matchedlittleBoyReference = null;
    private volatile GestureDetectTaskResult mGestureDetectResult = null;
    private volatile FaceDetectTaskResult mFaceDetectResult = null;
    private volatile int mTaskStatus = 0;
    private volatile long mTaskBeginTime = -1;
    QQFilterRenderManager mqqFilterRenderManager = null;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class FaceDetectTaskResult {
        public float[] angles;
        public List<PointF> pointFs;
        public boolean vaild = false;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class GestureDetectTaskResult {
        public String type;
        public boolean vaild = false;
    }

    private void ResetTask() {
        this.littleBoyReferenceList.clear();
        this.mGestureDetectResult = null;
        this.mFaceDetectResult = null;
    }

    private void firstDetectFaild() {
        notifyTaskEnd();
    }

    public static FaceDanceDetectTask getInstance() {
        return instance;
    }

    public static void logBoyWithMessage(GLLittleBoy gLLittleBoy, String str) {
        String str2 = "" + str + " ";
        if (gLLittleBoy != null) {
            str2 = str2 + "boyinfo id=" + gLLittleBoy.getDanceData().f287854id + " needMatched=" + gLLittleBoy.needDoMatch() + " isMatched=" + gLLittleBoy.isMatched() + " appearTime=" + gLLittleBoy.getDanceData().appearTime;
        }
        loginfo(str2);
    }

    public static void logFaceInfo(List<PointF> list, float[] fArr, String str) {
        String str2;
        String str3 = "" + str + " ";
        if (list != null && list.size() > 0) {
            String str4 = str3 + "expressionFeat [";
            for (PointF pointF : list) {
                if (pointF != null) {
                    str4 = (((((str4 + "\n") + pointF.x) + ",") + "\n") + pointF.y) + ",";
                }
            }
            str2 = (str4 + "\n") + "]\n";
        } else {
            str2 = str3 + "expressionFeat is null";
        }
        if (fArr != null && fArr.length > 0) {
            String str5 = str2 + "expressionAngle [";
            for (float f16 : fArr) {
                str5 = ((str5 + "\n") + f16) + ",";
            }
            str2 = (str5 + "\n") + "]\n";
        }
        loginfo(str2);
    }

    public static void logTimeInfo(String str, long j3, long j16) {
        String str2 = ("" + str) + " Time cost:" + ((j16 - j3) / 1000000.0d);
        if (SLog.isEnable()) {
            SLog.d(TIMETAG, str2);
        }
    }

    public static void loginfo(String str) {
        if (SLog.isEnable()) {
            SLog.d(TAG, str);
        }
    }

    static void reportHighScoreLittelBoy(String str, float f16, List<PointF> list, float[] fArr, double[] dArr) {
        String str2;
        String str3;
        String str4;
        HashMap<String, String> hashMap = new HashMap<>();
        if (str != null) {
            hashMap.put("boyType", str);
        }
        hashMap.put(LocalPhotoFaceInfo.SCORE, String.valueOf(f16));
        if (list != null && list.size() > 0) {
            String str5 = "expressionFeat [";
            for (PointF pointF : list) {
                if (pointF != null) {
                    str5 = (((((str5 + "\n") + pointF.x) + ",") + "\n") + pointF.y) + ",";
                }
            }
            str2 = (str5 + "\n") + "]\n";
        } else {
            str2 = "expressionFeat is null";
        }
        hashMap.put("expressionFeat", str2);
        if (dArr != null && dArr.length > 0) {
            String str6 = "expressionAngle [";
            for (double d16 : dArr) {
                str6 = ((str6 + "\n") + d16) + ",";
            }
            str3 = (str6 + "\n") + "]\n";
        } else {
            str3 = "expressionWeight is null";
        }
        hashMap.put("expressionWeight", str3);
        if (fArr != null && fArr.length > 0) {
            String str7 = "expressionAngle [";
            for (float f17 : fArr) {
                str7 = ((str7 + "\n") + f17) + ",";
            }
            str4 = (str7 + "\n") + "]\n";
        } else {
            str4 = "expressionAngle is null";
        }
        hashMap.put("expressionAngle", str4);
        SdkContext.getInstance().getReporter().reportToBeacon("FaceDanceExpressionInfo", true, 0L, 0L, hashMap);
    }

    private void startExpressionDetect() {
        GLLittleBoy gLLittleBoy;
        if (this.mTaskStatus != 2) {
            return;
        }
        FaceDetectTaskResult faceDetectTaskResult = this.mFaceDetectResult;
        GestureDetectTaskResult gestureDetectTaskResult = this.mGestureDetectResult;
        if (faceDetectTaskResult != null && gestureDetectTaskResult != null) {
            this.mTaskStatus = 3;
            if (this.littleBoyReferenceList.size() == 1 && (gLLittleBoy = this.littleBoyReferenceList.get(0).get()) != null && gLLittleBoy.isReadyMatch && !gLLittleBoy.isMatched()) {
                if (faceDetectTaskResult.vaild) {
                    this.matchedlittleBoyReference = new WeakReference<>(gLLittleBoy);
                }
                loginfo("mFaceDetectResult.vaild =" + faceDetectTaskResult.vaild + " and tempboy.isReadyMatch=" + gLLittleBoy.isReadyMatch);
                notifyTaskEnd();
                return;
            }
            if (faceDetectTaskResult.vaild && gestureDetectTaskResult.vaild) {
                loginfo("mFaceDetectResult.vaild and mGestureDetectResult.vaild mGestureDetectResult.type=" + gestureDetectTaskResult.type);
                ArrayList arrayList = new ArrayList();
                Iterator<WeakReference<GLLittleBoy>> it = this.littleBoyReferenceList.iterator();
                while (it.hasNext()) {
                    GLLittleBoy gLLittleBoy2 = it.next().get();
                    if (gLLittleBoy2 != null && gLLittleBoy2.needDoMatch()) {
                        ResourceManager.Posture postureById = ResourceManager.getInstance().getPostureById(gLLittleBoy2.getDanceData().f287854id);
                        if (postureById != null && postureById.faceDanceConfig.mGestureType.equals(gestureDetectTaskResult.type)) {
                            logBoyWithMessage(gLLittleBoy2, "startExpressionDetect has boy equals");
                            arrayList.add(gLLittleBoy2);
                        }
                    }
                }
                loginfo("tempBoyList.size() ==" + arrayList.size() + " mGestureDetectResult.type=" + gestureDetectTaskResult.type);
                if (arrayList.size() == 0) {
                    notifyTaskEnd();
                } else {
                    float f16 = 0.0f;
                    GLLittleBoy gLLittleBoy3 = null;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                        GLLittleBoy gLLittleBoy4 = (GLLittleBoy) arrayList.get(i3);
                        ResourceManager.Posture postureById2 = ResourceManager.getInstance().getPostureById(gLLittleBoy4.getDanceData().f287854id);
                        if (postureById2 != null) {
                            FaceDanceTemplateConfig faceDanceTemplateConfig = postureById2.faceDanceConfig;
                            ExpressionTemplateConfig expressionTemplateConfig = faceDanceTemplateConfig.mExpressionConfig;
                            float expressionSimilarity = ActUtil.getExpressionSimilarity(expressionTemplateConfig.expressionFeat, faceDetectTaskResult.pointFs, expressionTemplateConfig.expressionAngle, faceDetectTaskResult.angles, expressionTemplateConfig.expressionWeight);
                            logBoyWithMessage(gLLittleBoy4, "match expression score=" + expressionSimilarity);
                            logTimeInfo("ActUtil.getExpressionSimilarity No:" + i3 + " boy", elapsedRealtimeNanos, SystemClock.elapsedRealtimeNanos());
                            if (expressionSimilarity > 95.0f) {
                                ExpressionTemplateConfig expressionTemplateConfig2 = faceDanceTemplateConfig.mExpressionConfig;
                                reportHighScoreLittelBoy(expressionTemplateConfig2.expressionID, expressionSimilarity, faceDetectTaskResult.pointFs, faceDetectTaskResult.angles, expressionTemplateConfig2.expressionWeight);
                            }
                            if (!checkIsNeedMatchExpression(faceDanceTemplateConfig.mExpressionConfig.expressionWeight)) {
                                logBoyWithMessage(gLLittleBoy4, " not NeedMatchExpression");
                                expressionSimilarity = 100.0f;
                            }
                            if (expressionSimilarity >= faceDanceTemplateConfig.threshold && expressionSimilarity > f16) {
                                gLLittleBoy3 = gLLittleBoy4;
                                f16 = expressionSimilarity;
                            }
                        }
                    }
                    if (gLLittleBoy3 != null) {
                        this.matchedlittleBoyReference = new WeakReference<>(gLLittleBoy3);
                        logBoyWithMessage(gLLittleBoy3, "set matchedlittleBoyReference");
                    }
                }
                notifyTaskEnd();
                return;
            }
            loginfo("mFaceDetectResult.vaild =" + faceDetectTaskResult.vaild + " and mGestureDetectResult.vaild=" + gestureDetectTaskResult.vaild);
            notifyTaskEnd();
        }
    }

    boolean checkIsNeedMatchExpression(double[] dArr) {
        if (dArr == null || dArr.length != 7) {
            return false;
        }
        for (double d16 : dArr) {
            if (Math.abs(d16 - 0.0d) > 1.0E-4d) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIsRunning() {
        if (this.mTaskStatus != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.shortvideo.facedancegame.IFaceDetectCallBack
    public void faceDetectEnd(FaceDetectTaskResult faceDetectTaskResult) {
        if (faceDetectTaskResult == null) {
            firstDetectFaild();
        } else {
            this.mFaceDetectResult = faceDetectTaskResult;
            startExpressionDetect();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.facedancegame.IGestureDetectCallBack
    public void gestureDetectEnd(GestureDetectTaskResult gestureDetectTaskResult) {
        if (gestureDetectTaskResult == null) {
            firstDetectFaild();
        } else {
            this.mGestureDetectResult = gestureDetectTaskResult;
            startExpressionDetect();
        }
    }

    public void notifyTaskEnd() {
        ResetTask();
        long j3 = this.mTaskBeginTime;
        this.mTaskBeginTime = -1L;
        if (j3 > 0) {
            logTimeInfo("FaceDanceDetectTask End", j3, SystemClock.elapsedRealtimeNanos());
        }
        this.mTaskStatus = 0;
    }

    public void setQQFilterRenderManager(QQFilterRenderManager qQFilterRenderManager) {
        this.mqqFilterRenderManager = qQFilterRenderManager;
    }

    public void updateDetectResult() {
        if (this.matchedlittleBoyReference != null) {
            GLLittleBoy gLLittleBoy = this.matchedlittleBoyReference.get();
            if (gLLittleBoy != null) {
                if (gLLittleBoy.needDoMatch()) {
                    gLLittleBoy.setMatch(true);
                }
                logBoyWithMessage(gLLittleBoy, "updateDetectResult");
            }
            this.matchedlittleBoyReference = null;
        }
    }

    public void DestoryTask() {
    }
}
