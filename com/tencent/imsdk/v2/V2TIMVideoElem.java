package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.DownloadProgressInfo;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.VideoElement;
import com.tencent.imsdk.v2.V2TIMElem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMVideoElem extends V2TIMElem {
    public void downloadSnapshot(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getElement() == null) {
            return;
        }
        VideoElement videoElement = (VideoElement) getElement();
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.setDownloadFlag(videoElement.getSnapshotDownloadFlag());
        downloadParam.setDownloadUrl(videoElement.getSnapshotDownloadUrl());
        downloadParam.setUuid(videoElement.getSnapshotUUID());
        downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_VIDEO_THUMB);
        downloadParam.setBusinessID(videoElement.getVideoBusinessID());
        downloadParam.setFileSavePath(str);
        MessageCenter.getInstance().downloadMessageElement(downloadParam, new IMCallback<DownloadProgressInfo>(new V2TIMValueCallback<DownloadProgressInfo>() { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.6
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                if (v2TIMDownloadCallback2 != null) {
                    v2TIMDownloadCallback2.onError(i3, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(DownloadProgressInfo downloadProgressInfo) {
                V2TIMElem.V2ProgressInfo v2ProgressInfo = new V2TIMElem.V2ProgressInfo(downloadProgressInfo.getCurrentSize(), downloadProgressInfo.getTotalSize());
                V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                if (v2TIMDownloadCallback2 != null) {
                    v2TIMDownloadCallback2.onProgress(v2ProgressInfo);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.8
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(DownloadProgressInfo downloadProgressInfo) {
                super.success((AnonymousClass8) downloadProgressInfo);
            }
        }, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.7
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i3, String str2) {
                V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                if (v2TIMDownloadCallback2 != null) {
                    v2TIMDownloadCallback2.onError(i3, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                if (v2TIMDownloadCallback2 != null) {
                    v2TIMDownloadCallback2.onSuccess();
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.9
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void downloadVideo(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getElement() == null) {
            if (v2TIMDownloadCallback != null) {
                v2TIMDownloadCallback.onError(6017, "getTIMElem is null");
                return;
            }
            return;
        }
        VideoElement videoElement = (VideoElement) getElement();
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.setDownloadFlag(videoElement.getVideoDownloadFlag());
        downloadParam.setDownloadUrl(videoElement.getVideoDownloadUrl());
        downloadParam.setUuid(videoElement.getVideoUUID());
        downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_VIDEO);
        downloadParam.setBusinessID(videoElement.getVideoBusinessID());
        downloadParam.setFileSavePath(str);
        MessageCenter.getInstance().downloadMessageElement(downloadParam, new IMCallback<DownloadProgressInfo>(new V2TIMValueCallback<DownloadProgressInfo>() { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                if (v2TIMDownloadCallback2 != null) {
                    v2TIMDownloadCallback2.onError(i3, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(DownloadProgressInfo downloadProgressInfo) {
                V2TIMElem.V2ProgressInfo v2ProgressInfo = new V2TIMElem.V2ProgressInfo(downloadProgressInfo.getCurrentSize(), downloadProgressInfo.getTotalSize());
                V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                if (v2TIMDownloadCallback2 != null) {
                    v2TIMDownloadCallback2.onProgress(v2ProgressInfo);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.3
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(DownloadProgressInfo downloadProgressInfo) {
                super.success((AnonymousClass3) downloadProgressInfo);
            }
        }, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.2
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i3, String str2) {
                V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                if (v2TIMDownloadCallback2 != null) {
                    v2TIMDownloadCallback2.onError(i3, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                if (v2TIMDownloadCallback2 != null) {
                    v2TIMDownloadCallback2.onSuccess();
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.4
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public int getDuration() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getVideoDuration();
    }

    public int getSnapshotHeight() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getSnapshotHeight();
    }

    public String getSnapshotPath() {
        if (getElement() == null) {
            return null;
        }
        return ((VideoElement) getElement()).getSnapshotFilePath();
    }

    public int getSnapshotSize() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getSnapshotFileSize();
    }

    public String getSnapshotUUID() {
        if (getElement() == null) {
            return null;
        }
        return ((VideoElement) getElement()).getSnapshotUUID();
    }

    public void getSnapshotUrl(V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMValueCallback == null) {
            return;
        }
        if (getElement() == null) {
            v2TIMValueCallback.onError(6017, "elem is null");
            return;
        }
        VideoElement videoElement = (VideoElement) getElement();
        if (videoElement.getSnapshotDownloadFlag() == 2) {
            v2TIMValueCallback.onSuccess(videoElement.getSnapshotDownloadUrl());
            return;
        }
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.setDownloadFlag(videoElement.getSnapshotDownloadFlag());
        downloadParam.setUuid(getSnapshotUUID());
        downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
        downloadParam.setBusinessID(videoElement.getVideoBusinessID());
        MessageCenter.getInstance().getDownloadUrl(downloadParam, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.10
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str) {
                super.fail(i3, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(String str) {
                super.success((AnonymousClass10) str);
            }
        });
    }

    public int getSnapshotWidth() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getSnapshotWidth();
    }

    public String getVideoPath() {
        if (getElement() == null) {
            return null;
        }
        return ((VideoElement) getElement()).getVideoFilePath();
    }

    public int getVideoSize() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getVideoFileSize();
    }

    public String getVideoUUID() {
        if (getElement() == null) {
            return null;
        }
        return ((VideoElement) getElement()).getVideoUUID();
    }

    public void getVideoUrl(V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMValueCallback == null) {
            return;
        }
        if (getElement() == null) {
            v2TIMValueCallback.onError(6017, "elem is null");
            return;
        }
        VideoElement videoElement = (VideoElement) getElement();
        if (videoElement.getSnapshotDownloadFlag() == 2) {
            v2TIMValueCallback.onSuccess(videoElement.getVideoDownloadUrl());
            return;
        }
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.setDownloadFlag(videoElement.getVideoDownloadFlag());
        downloadParam.setUuid(getVideoUUID());
        downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
        downloadParam.setBusinessID(videoElement.getVideoBusinessID());
        MessageCenter.getInstance().getDownloadUrl(downloadParam, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMVideoElem.5
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str) {
                super.fail(i3, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(String str) {
                super.success((AnonymousClass5) str);
            }
        });
    }

    public String toString() {
        return "V2TIMVideoElem--->video uuid:" + getVideoUUID() + ", snapshot uuid:" + getSnapshotUUID() + ", duration:" + getDuration() + ", sender local video path:" + getVideoPath() + ", video size:" + getVideoSize() + ", sender local snapshot path" + getSnapshotPath() + ", snapshot height:" + getSnapshotHeight() + ", snapshot width:" + getSnapshotWidth() + ", snapshot size:" + getSnapshotSize();
    }
}
