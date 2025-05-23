package com.tencent.mobileqq.qqlive.api.xsj.impl;

import com.tencent.mobileqq.ilive.pb.LiveRoomList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.api.xsj.IQFSFeedRequest;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetQLiveInfoRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QFSFeedRequestImpl implements IQFSFeedRequest {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QFSFeedRequestImpl";

    public QFSFeedRequestImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestFeed$0(IQFSFeedRequest.RequestResultCallback requestResultCallback, QQLiveResponse qQLiveResponse) {
        LiveRoomList.GetQLiveInfoRsp getQLiveInfoRsp = (LiveRoomList.GetQLiveInfoRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && getQLiveInfoRsp != null) {
            requestResultCallback.success(getQLiveInfoRsp.toByteArray());
            return;
        }
        QLog.i(TAG, 1, "[requestFeed] failed, " + qQLiveResponse);
        requestResultCallback.fail((int) qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg());
    }

    @Override // com.tencent.mobileqq.qqlive.api.xsj.IQFSFeedRequest
    public void requestFeed(long j3, final IQFSFeedRequest.RequestResultCallback requestResultCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), requestResultCallback);
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetQLiveInfoRequest(j3), new ILiveNetRequest.Callback() { // from class: com.tencent.mobileqq.qqlive.api.xsj.impl.a
                @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    QFSFeedRequestImpl.lambda$requestFeed$0(IQFSFeedRequest.RequestResultCallback.this, qQLiveResponse);
                }
            });
        }
    }
}
