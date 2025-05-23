package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.DownloadProgressInfo;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.v2.V2TIMElem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMSoundElem extends V2TIMElem {
    public void downloadSound(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getElement() == null) {
            return;
        }
        SoundElement soundElement = (SoundElement) getElement();
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.setDownloadFlag(soundElement.getSoundDownloadFlag());
        downloadParam.setDownloadUrl(soundElement.getSoundDownloadUrl());
        downloadParam.setUuid(getUUID());
        downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_AUDIO);
        downloadParam.setBusinessID(soundElement.getSoundBusinessID());
        downloadParam.setFileSavePath(str);
        MessageCenter.getInstance().downloadMessageElement(downloadParam, new IMCallback<DownloadProgressInfo>(new V2TIMValueCallback<DownloadProgressInfo>() { // from class: com.tencent.imsdk.v2.V2TIMSoundElem.1
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
        }) { // from class: com.tencent.imsdk.v2.V2TIMSoundElem.3
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(DownloadProgressInfo downloadProgressInfo) {
                super.success((AnonymousClass3) downloadProgressInfo);
            }
        }, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMSoundElem.2
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
        }) { // from class: com.tencent.imsdk.v2.V2TIMSoundElem.4
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

    public int getDataSize() {
        if (getElement() == null) {
            return 0;
        }
        return ((SoundElement) getElement()).getSoundFileSize();
    }

    public int getDuration() {
        if (getElement() == null) {
            return 0;
        }
        return ((SoundElement) getElement()).getSoundDuration();
    }

    public String getPath() {
        if (getElement() == null) {
            return null;
        }
        return ((SoundElement) getElement()).getSoundFilePath();
    }

    public String getUUID() {
        if (getElement() == null) {
            return null;
        }
        return ((SoundElement) getElement()).getSoundUUID();
    }

    public void getUrl(V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMValueCallback == null) {
            return;
        }
        if (getElement() == null) {
            v2TIMValueCallback.onError(6017, "elem is null");
            return;
        }
        SoundElement soundElement = (SoundElement) getElement();
        if (soundElement.getSoundDownloadFlag() == 2) {
            v2TIMValueCallback.onSuccess(soundElement.getSoundDownloadUrl());
            return;
        }
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.setDownloadFlag(soundElement.getSoundDownloadFlag());
        downloadParam.setUuid(getUUID());
        downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
        downloadParam.setBusinessID(soundElement.getSoundBusinessID());
        MessageCenter.getInstance().getDownloadUrl(downloadParam, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMSoundElem.5
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
        return "V2TIMSoundElem--->uuid:" + getUUID() + ", sender local path:" + getPath() + ", duration:" + getDuration() + ", dataSize:" + getDataSize();
    }
}
