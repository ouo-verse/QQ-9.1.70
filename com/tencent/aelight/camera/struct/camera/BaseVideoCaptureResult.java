package com.tencent.aelight.camera.struct.camera;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BaseVideoCaptureResult implements Serializable {
    public static final int TYPE_MERGED = 1;
    public static final int TYPE_UNMERGED = 0;
    public String audioDataFilePath;
    public String bgmAudioDataFilePath;
    public int errorCode;
    public String mergedMp4FilePath;
    public int orientation;
    public int type;
    public int videoFrameCount = 0;
    public String videoMp4FilePath;

    public String toString() {
        return "VideoCaptureResult{type=" + this.type + ", errorCode=" + this.errorCode + ", mergedMp4FilePath='" + this.mergedMp4FilePath + "', videoMp4FilePath='" + this.videoMp4FilePath + "', audioDataFilePath='" + this.audioDataFilePath + "'}";
    }
}
