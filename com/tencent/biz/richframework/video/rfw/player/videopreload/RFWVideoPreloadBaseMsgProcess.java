package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;

/* loaded from: classes5.dex */
abstract class RFWVideoPreloadBaseMsgProcess {
    protected final int mSceneId;

    public RFWVideoPreloadBaseMsgProcess(int i3) {
        this.mSceneId = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RFWVideoPreloadBean getRecordFormMsg(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length != 0) {
            Object obj2 = objArr[0];
            if (obj2 instanceof RFWVideoPreloadBean) {
                return (RFWVideoPreloadBean) obj2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTaskIdFromMsg(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Object[])) {
            return -1;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length != 0) {
            Object obj2 = objArr[0];
            if (obj2 instanceof Integer) {
                return ((Integer) obj2).intValue();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean handlerMsg(Message message);
}
