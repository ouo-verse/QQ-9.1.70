package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.filter.BaseFilter;
import com.tencent.qqmini.sdk.report.MiniReportManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class m {
    public static double b(PointF pointF, PointF pointF2) {
        float f16 = pointF.x;
        float f17 = pointF2.x;
        float f18 = pointF.y;
        float f19 = pointF2.y;
        return Math.sqrt(((f16 - f17) * (f16 - f17)) + ((f18 - f19) * (f18 - f19)));
    }

    public static void d(BaseFilter baseFilter, Frame frame, Frame frame2, int i3, int i16, int i17) {
        Frame frame3 = new Frame(frame.getFBO(), frame.getTextureId(), i16, i17);
        GlUtil.setBlendMode(true);
        GLES20.glBlendEquation(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE);
        GLES20.glBindFramebuffer(36160, frame.getFBO());
        GLES20.glViewport(0, 0, i16, i17);
        frame2.bindFrame(i3, i16, i17, 1.0d);
        baseFilter.RenderProcess(frame2.getTextureId(), i16, i17, frame.getTextureId(), 1.0d, frame3);
        GlUtil.setBlendMode(false);
    }

    public static void a() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        GLES20.glFlush();
    }

    public static void c(Frame frame, int i3, int i16, int i17, boolean z16) {
        frame.bindFrame(i3, i16, i17, 1.0d);
        GLES20.glBindFramebuffer(36160, frame.getFBO());
        GLES20.glViewport(0, 0, i16, i17);
        if (z16) {
            a();
        }
    }

    public static void e(int i3) {
        if (i3 == 0) {
            GLES20.glDisable(3042);
            return;
        }
        if (i3 == 1) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBlendEquation(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE);
        } else if (i3 == 2) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            GLES20.glBlendEquation(TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS);
        } else {
            if (i3 != 3) {
                return;
            }
            GLES20.glEnable(3042);
            GLES20.glBlendFuncSeparate(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, 1);
            GLES20.glBlendEquation(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE);
        }
    }
}
