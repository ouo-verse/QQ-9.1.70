package com.qzone.publish.business.process.base;

import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

/* loaded from: classes39.dex */
public enum QZoneProcessType {
    PROCESS_UNKNOW(QzoneWebMusicJsPlugin.EVENT_UNKOWN),
    PROCESS_TYPE_QCIRCLE_COMPRESS("qcircle_compress"),
    PROCESS_TYPE_QCIRCLE_EXPORT("qcircle_export"),
    PROCESS_TYPE_UPLOAD(JobDbManager.TBL_UPLOAD),
    PROCESS_TYPE_BUILD_VIDEO_COVER("build_video_cover");

    private final String mDesc;

    QZoneProcessType(String str) {
        this.mDesc = str;
    }

    public String convertErrorDesc(String str) {
        return "" + this.mDesc + ":" + str;
    }
}
