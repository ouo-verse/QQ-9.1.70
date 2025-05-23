package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsReqBody {
    public int clientHasPeopleAndQun;
    public int fromAction;
    public int fromTabbarIndex;
    public int locateResultCount;
    public int source;
    public int useReqMaskOnly;
    public byte[] keyWord = new byte[0];
    public byte[] version = new byte[0];
    public UfsRootSearcherRequest reqEntity = new UfsRootSearcherRequest();
    public UfsRootSearcherRequest reqTopic = new UfsRootSearcherRequest();
    public UfsExtensionRequestInfo extensionRequestInfo = new UfsExtensionRequestInfo();
    public byte[] bytesExtension = new byte[0];

    public byte[] getBytesExtension() {
        return this.bytesExtension;
    }

    public int getClientHasPeopleAndQun() {
        return this.clientHasPeopleAndQun;
    }

    public UfsExtensionRequestInfo getExtensionRequestInfo() {
        return this.extensionRequestInfo;
    }

    public int getFromAction() {
        return this.fromAction;
    }

    public int getFromTabbarIndex() {
        return this.fromTabbarIndex;
    }

    public byte[] getKeyWord() {
        return this.keyWord;
    }

    public int getLocateResultCount() {
        return this.locateResultCount;
    }

    public UfsRootSearcherRequest getReqEntity() {
        return this.reqEntity;
    }

    public UfsRootSearcherRequest getReqTopic() {
        return this.reqTopic;
    }

    public int getSource() {
        return this.source;
    }

    public int getUseReqMaskOnly() {
        return this.useReqMaskOnly;
    }

    public byte[] getVersion() {
        return this.version;
    }

    public String toString() {
        return "UfsReqBody{keyWord=" + this.keyWord + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",reqEntity=" + this.reqEntity + ",reqTopic=" + this.reqTopic + ",fromAction=" + this.fromAction + ",clientHasPeopleAndQun=" + this.clientHasPeopleAndQun + ",fromTabbarIndex=" + this.fromTabbarIndex + ",source=" + this.source + ",locateResultCount=" + this.locateResultCount + ",useReqMaskOnly=" + this.useReqMaskOnly + ",extensionRequestInfo=" + this.extensionRequestInfo + ",bytesExtension=" + this.bytesExtension + ",}";
    }
}
