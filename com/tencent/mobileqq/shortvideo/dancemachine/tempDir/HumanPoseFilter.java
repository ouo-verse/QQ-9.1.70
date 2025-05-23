package com.tencent.mobileqq.shortvideo.dancemachine.tempDir;

import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.PoseDataConvert;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes18.dex */
public class HumanPoseFilter {
    public static boolean ENABLE_DEBUG_MODE = true;
    private float poseHeight;
    private float poseWidth;
    private DebugModeLine debugMode = null;
    private List<Vec3f> facePoints = new ArrayList(18);
    private List<Vec3f> cachePoints = new ArrayList(18);

    public HumanPoseFilter(float f16, float f17) {
        this.poseWidth = f16;
        this.poseHeight = f17;
    }

    public void drawFrame(RenderBuffer renderBuffer) {
        renderBuffer.bind();
        GLES20.glEnable(2884);
        GLES20.glFrontFace(2305);
        GLES20.glCullFace(1029);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        if (ENABLE_DEBUG_MODE) {
            GLES20.glFinish();
            this.debugMode.draw();
        }
        GLES20.glDisable(3042);
        GLES20.glDisable(2884);
        renderBuffer.unbind();
    }

    public List<Vec3f> getPosePoints() {
        return this.cachePoints;
    }

    public void initHumanFilter() {
        if (ENABLE_DEBUG_MODE) {
            this.debugMode = new DebugModeLine();
        }
    }

    public void updateFboSize(RenderBuffer renderBuffer) {
        int width = renderBuffer.getWidth();
        int height = renderBuffer.getHeight();
        if (ENABLE_DEBUG_MODE) {
            this.debugMode.updateFboSize(width, height);
        }
    }

    public void updateParams(RenderBuffer renderBuffer, float[] fArr) {
        float[] convertPointsToFrameCoordinate = PoseDataConvert.convertPointsToFrameCoordinate(fArr, renderBuffer.getWidth(), renderBuffer.getHeight(), this.poseWidth, this.poseHeight);
        int length = convertPointsToFrameCoordinate.length / 3;
        if (this.facePoints.size() < length) {
            this.facePoints.clear();
            for (int i3 = 0; i3 < length; i3++) {
                this.facePoints.add(new Vec3f());
            }
        }
        if (this.cachePoints.size() < length) {
            this.cachePoints.clear();
            for (int i16 = 0; i16 < length; i16++) {
                this.cachePoints.add(new Vec3f());
            }
        }
        for (int i17 = 0; i17 < length; i17++) {
            Vec3f vec3f = this.facePoints.get(i17);
            if (vec3f == null) {
                vec3f = new Vec3f();
                this.facePoints.set(i17, vec3f);
            }
            int i18 = i17 * 3;
            int i19 = i18 + 1;
            int i26 = i18 + 2;
            vec3f.set(convertPointsToFrameCoordinate[i18], convertPointsToFrameCoordinate[i19], convertPointsToFrameCoordinate[i26]);
            Vec3f vec3f2 = this.cachePoints.get(i17);
            if (vec3f2 == null) {
                vec3f2 = new Vec3f();
                this.cachePoints.set(i17, vec3f2);
            }
            vec3f2.set(convertPointsToFrameCoordinate[i18], convertPointsToFrameCoordinate[i19], convertPointsToFrameCoordinate[i26]);
        }
        if (this.facePoints.get(0).f287863z <= 0.0f && this.facePoints.get(14).f287863z > 0.0f) {
            int i27 = (this.facePoints.get(15).f287863z > 0.0f ? 1 : (this.facePoints.get(15).f287863z == 0.0f ? 0 : -1));
        }
        if (ENABLE_DEBUG_MODE) {
            this.debugMode.updateParams(this.cachePoints);
        }
    }

    public void updatePoseSize(float f16, float f17) {
        this.poseWidth = f16;
        this.poseHeight = f17;
    }
}
