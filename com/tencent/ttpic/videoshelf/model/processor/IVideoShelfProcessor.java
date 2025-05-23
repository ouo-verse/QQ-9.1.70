package com.tencent.ttpic.videoshelf.model.processor;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import java.util.List;

/* loaded from: classes27.dex */
public interface IVideoShelfProcessor {
    public static final int FILE_NOT_EXIT = 1;
    public static final String OUT_VIDEO_WIDTH_HEIGHT = "outVideoWidthHeight";
    public static final int VERSION_LOW = 2;

    void clear();

    Frame draw();

    long getCurFrameTimeStamp();

    int getProgress();

    void init(int[] iArr, List<VideoFrameItem> list, List<NodeGroup> list2);

    int isPrepareInit();

    int parseFrame();

    void setParam(String str, Object obj);

    boolean updateFrameCursor();
}
