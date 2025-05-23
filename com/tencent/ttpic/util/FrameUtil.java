package com.tencent.ttpic.util;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FrameUtil {
    private static final Frame EMPTY_FRAME = new Frame();
    private static final String TAG = "FrameUtil";

    public static void clearFrame(Frame frame, float f16, float f17, float f18, float f19, int i3, int i16) {
        if (frame == null) {
            return;
        }
        frame.bindFrame(-1, i3, i16, 0.0d);
        GLES20.glClearColor(f16, f17, f18, f19);
        GLES20.glClear(16384);
    }

    public static void clearTailFrame(BaseFilter baseFilter, Frame frame) {
        int length = getLength(baseFilter);
        while (true) {
            int i3 = length - 1;
            if (length <= 0 || frame == null) {
                break;
            }
            frame = frame.nextFrame;
            length = i3;
        }
        if (frame != null) {
            frame.clear();
        }
    }

    public static List<BaseFilter> filterChain2List(BaseFilter baseFilter) {
        ArrayList arrayList = new ArrayList();
        while (baseFilter != null) {
            BaseFilter baseFilter2 = baseFilter.getmNextFilter();
            baseFilter.setNextFilter(null, null);
            arrayList.add(baseFilter);
            baseFilter = baseFilter2;
        }
        return arrayList;
    }

    public static void filterList2Chain(List<BaseFilter> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        BaseFilter baseFilter = list.get(0);
        for (int i3 = 1; i3 < list.size(); i3++) {
            baseFilter.setNextFilter(list.get(i3), null);
            baseFilter = list.get(i3);
        }
    }

    public static Frame getLastRenderFrame(Frame frame) {
        if (!isValid(frame)) {
            return EMPTY_FRAME;
        }
        Frame frame2 = frame;
        while (isValid(frame)) {
            frame2 = frame;
            frame = frame.nextFrame;
        }
        return frame2;
    }

    public static int getLength(Frame frame) {
        int i3 = 0;
        while (frame != null && frame.getTextureId() > 0) {
            i3++;
            frame = frame.nextFrame;
        }
        return i3;
    }

    public static Frame getSecondLastRenderFrame(Frame frame) {
        if (isValid(frame) && isValid(frame.nextFrame)) {
            Frame frame2 = frame;
            while (isValid(frame) && isValid(frame.nextFrame)) {
                frame2 = frame;
                frame = frame.nextFrame;
            }
            return frame2;
        }
        return EMPTY_FRAME;
    }

    public static boolean isValid(Frame frame) {
        if (frame != null && frame.getTextureId() != 0) {
            return true;
        }
        return false;
    }

    public static void printFilterList(BaseFilter baseFilter) {
        Log.d(TAG, "[FILTER] BEGIN");
        int i3 = 0;
        while (baseFilter != null) {
            Log.d(TAG, "[FILTER] " + i3 + " " + baseFilter);
            baseFilter = baseFilter.getmNextFilter();
            i3++;
        }
        Log.d(TAG, "[FILTER] END");
    }

    public static Frame renderProcessBySwitchFbo(int i3, int i16, int i17, BaseFilter baseFilter, Frame frame, Frame frame2) {
        if (frame.getTextureId() == i3) {
            frame = frame2;
        }
        baseFilter.RenderProcess(i3, i16, i17, -1, 0.0d, frame);
        return frame;
    }

    public static Frame rotateCorrect(Frame frame, int i3, int i16, int i17, BaseFilter baseFilter, Frame frame2) {
        int i18;
        int i19;
        if (i17 == 0) {
            return frame;
        }
        int i26 = (i17 + 360) % 360;
        if (i26 == 90 || i26 == 270) {
            i18 = i3;
            i19 = i16;
        } else {
            i19 = i3;
            i18 = i16;
        }
        baseFilter.setRotationAndFlip(i26, 0, 0);
        baseFilter.RenderProcess(frame.getTextureId(), i19, i18, -1, 0.0d, frame2);
        return frame2;
    }

    public static int getLength(BaseFilter baseFilter) {
        int i3 = 0;
        while (baseFilter != null) {
            i3++;
            baseFilter = baseFilter.getmNextFilter();
        }
        return i3;
    }

    public static Frame rotateCorrect(Frame frame, int i3, int i16, int i17, BaseFilter baseFilter) {
        if (i17 == 0) {
            return frame;
        }
        int i18 = (i17 + 360) % 360;
        if (i18 == 90 || i18 == 270) {
            i16 = i3;
            i3 = i16;
        }
        baseFilter.setRotationAndFlip(i18, 0, 0);
        Frame RenderProcess = baseFilter.RenderProcess(frame.getTextureId(), i3, i16);
        frame.unlock();
        return RenderProcess;
    }
}
