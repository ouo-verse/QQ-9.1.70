package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleColdBootServiceV2Impl implements IQCircleColdBootServiceV2 {
    private static final String CLASS_NAME = "com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2";
    private static final String METHOD_NAME_DO_GET_DO_PREPARE = "doGetDoPrepare";
    private static final String METHOD_NAME_DO_GET_PRELOAD_REQ_BYTE = "doGetPreloadReqByte";
    private static final String METHOD_NAME_DO_GET_TASK = "doGetTask";
    private static final String METHOD_NAME_DO_PARSE_PRELOAD_RSP_BYTE = "doParsePreloadRspByte";
    private static final String METHOD_NAME_DO_RELEASE_INSTANCE = "releaseInstance";
    private static final String TAG = "FeedLine_QCircleColdBootServiceV2Impl";

    private boolean invokeQCircleColdBootDoPrepare(IQCircleColdBootServiceV2.a aVar) {
        try {
            QCircleColdBootPreloadFeedManagerV2.class.getDeclaredMethod(METHOD_NAME_DO_GET_DO_PREPARE, IQCircleColdBootServiceV2.a.class).invoke(null, aVar);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "invokeQCircleColdBootPrepare error:" + e16.toString());
        }
        return true;
    }

    private byte[] invokeQCircleColdBootGetPreloadReqByte(int i3) {
        try {
            return (byte[]) QCircleColdBootPreloadFeedManagerV2.class.getDeclaredMethod(METHOD_NAME_DO_GET_PRELOAD_REQ_BYTE, Integer.TYPE).invoke(null, Integer.valueOf(i3));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "invokeQCircleColdBootGetPreloadReqByte error:" + e16.toString());
            return null;
        }
    }

    private IPreloadTask invokeQCircleColdBootGetTask(int i3) {
        try {
            return (IPreloadTask) QCircleColdBootPreloadFeedManagerV2.class.getDeclaredMethod(METHOD_NAME_DO_GET_TASK, Integer.TYPE).invoke(null, Integer.valueOf(i3));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "invokeQCircleColdBootGetTask error:" + e16.toString());
            return null;
        }
    }

    private void invokeQCircleColdBootParsePreloadRspByte(String str, byte[] bArr, int i3) {
        try {
            QCircleColdBootPreloadFeedManagerV2.class.getDeclaredMethod(METHOD_NAME_DO_PARSE_PRELOAD_RSP_BYTE, String.class, byte[].class, Integer.TYPE).invoke(null, str, bArr, Integer.valueOf(i3));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "invokeQCircleColdBootParsePreloadRspByte error:" + e16.toString());
        }
    }

    private void invokeQCircleColdBootReleaseInstance() {
        try {
            QCircleColdBootPreloadFeedManagerV2.class.getDeclaredMethod(METHOD_NAME_DO_RELEASE_INSTANCE, null).invoke(null, new Object[0]);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "invokeQCircleColdBootReleaseInstance error:" + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2
    public void doPrepare(IQCircleColdBootServiceV2.a aVar) {
        invokeQCircleColdBootDoPrepare(aVar);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2
    public byte[] getPreloadReqByte(int i3) {
        return invokeQCircleColdBootGetPreloadReqByte(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2
    public IPreloadTask getTask(int i3) {
        return invokeQCircleColdBootGetTask(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2
    public void parsePreloadRspByte(String str, byte[] bArr, int i3) {
        invokeQCircleColdBootParsePreloadRspByte(str, bArr, i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2
    public void release() {
        invokeQCircleColdBootReleaseInstance();
    }
}
