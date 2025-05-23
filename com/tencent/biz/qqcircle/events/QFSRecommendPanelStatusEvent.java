package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSRecommendPanelStatusEvent extends SimpleBaseEvent {
    public static final int DISMISS = 4;
    public static final int HEIGHT_CHANGE = 3;
    public static final int SCENE_HALF_WEB_VIEW = 1;
    public static final int SHOW_MAX_HEIGHT = 2;
    public static final int START_SHOW_DEFAULT_HEIGHT = 1;
    public int defaultHeight;
    public boolean enableCropVideoCover = true;
    public final String feedId;
    public int height;
    public int scene;
    public final int status;
    public int topSpaceHeight;

    public QFSRecommendPanelStatusEvent(String str, int i3) {
        this.feedId = str;
        this.status = i3;
    }
}
