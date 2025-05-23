package com.tencent.mobileqq.qqlive.api.impl.anchor;

import bt3.b;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetAnchorPageUrlCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetPuinAndOpenidCallback;
import com.tencent.mobileqq.qqlive.config.e;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorPuinAndOpenid;
import com.tencent.mobileqq.qqlive.sso.c;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.webview.a;

/* loaded from: classes17.dex */
public class QQLiveAnchorPageServiceImpl extends f implements IQQLiveAnchorPageService {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_NOTIFY_TYPE_GET_PUIN_OPENID = 520;
    private static final String QQ_LIVE_FANS_GROUP_CMD = "trpc.qlive.anchor_fans_group_server.AnchorFansGroupServer";
    private static final String QQ_LIVE_GET_PUIN_OPENID_METHOD = "GetPuinAndOpenidByUid";
    private static final String TAG = "QQLiveFansServiceImpl";
    private IQQLiveGetPuinAndOpenidCallback mGetPUinAndOpenidCallback;
    private IQQLiveSDK sdkImpl;

    public QQLiveAnchorPageServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean onGetPuinAndOpenidFailed(h hVar) {
        if (this.mGetPUinAndOpenidCallback == null) {
            QLog.e(TAG, 4, "checkFollowCallback is null");
            return true;
        }
        if (hVar != null && hVar.e() != null) {
            if (hVar.b() != 0) {
                this.mGetPUinAndOpenidCallback.onFail(hVar.b(), hVar.c());
                return true;
            }
            return false;
        }
        this.mGetPUinAndOpenidCallback.onFail(-1, "the data is null");
        return true;
    }

    private void resetCallback() {
        this.mGetPUinAndOpenidCallback = null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "QQLiveFansServiceImpl destroy");
        }
        resetCallback();
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService
    public void getAnchorPageUrl(long j3, IQQLiveGetAnchorPageUrlCallback iQQLiveGetAnchorPageUrlCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), iQQLiveGetAnchorPageUrlCallback);
        } else {
            getPuinAndOpenidByUid(j3, new IQQLiveGetPuinAndOpenidCallback(j3, iQQLiveGetAnchorPageUrlCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveAnchorPageServiceImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$anchorUid;
                final /* synthetic */ IQQLiveGetAnchorPageUrlCallback val$callback;

                {
                    this.val$anchorUid = j3;
                    this.val$callback = iQQLiveGetAnchorPageUrlCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQLiveAnchorPageServiceImpl.this, Long.valueOf(j3), iQQLiveGetAnchorPageUrlCallback);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetPuinAndOpenidCallback
                public void onFail(int i3, String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                        return;
                    }
                    IQQLiveGetAnchorPageUrlCallback iQQLiveGetAnchorPageUrlCallback2 = this.val$callback;
                    if (iQQLiveGetAnchorPageUrlCallback2 != null) {
                        iQQLiveGetAnchorPageUrlCallback2.onFail(i3, str);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetPuinAndOpenidCallback
                public void onSuccess(QQLiveAnchorPuinAndOpenid qQLiveAnchorPuinAndOpenid) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) qQLiveAnchorPuinAndOpenid);
                        return;
                    }
                    String replace = e.a().f271179a.replace("{pUin}", qQLiveAnchorPuinAndOpenid.pgcPuin + "").replace("{anchorOpenId}", qQLiveAnchorPuinAndOpenid.pgcOpenid + "").replace("{anchorUid}", this.val$anchorUid + "");
                    IQQLiveGetAnchorPageUrlCallback iQQLiveGetAnchorPageUrlCallback2 = this.val$callback;
                    if (iQQLiveGetAnchorPageUrlCallback2 != null) {
                        iQQLiveGetAnchorPageUrlCallback2.onSuccess(a.h(replace));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(QQLiveAnchorPageServiceImpl.TAG, 2, "IQQLiveGetAnchorPageUrlCallback :" + replace);
                    }
                }
            });
        }
    }

    public void getPuinAndOpenidByUid(long j3, IQQLiveGetPuinAndOpenidCallback iQQLiveGetPuinAndOpenidCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), iQQLiveGetPuinAndOpenidCallback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "[getPuinAndOpenidByUid]");
        }
        this.mGetPUinAndOpenidCallback = iQQLiveGetPuinAndOpenidCallback;
        if (this.sdkImpl != null) {
            bt3.a aVar = new bt3.a();
            aVar.f29103a = j3;
            c cVar = (c) this.sdkImpl.getExtModule("sso_module");
            if (cVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 4, "get IQQLiveSsoModule null");
                    return;
                }
                return;
            }
            cVar.g(QQ_LIVE_FANS_GROUP_CMD, QQ_LIVE_GET_PUIN_OPENID_METHOD, MessageNano.toByteArray(aVar), 520, this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.sdkImpl = iQQLiveSDK;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sso.f
    public void onReceive(int i3, boolean z16, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
            return;
        }
        if (z16 && i3 == 520) {
            if (onGetPuinAndOpenidFailed(hVar)) {
                QLog.e(TAG, 4, "onGetPuinAndOpenidFailed fail");
                return;
            }
            try {
                b c16 = b.c(hVar.e());
                QQLiveAnchorPuinAndOpenid qQLiveAnchorPuinAndOpenid = new QQLiveAnchorPuinAndOpenid();
                qQLiveAnchorPuinAndOpenid.pgcPuin = c16.f29104a;
                qQLiveAnchorPuinAndOpenid.pgcOpenid = c16.f29105b;
                this.mGetPUinAndOpenidCallback.onSuccess(qQLiveAnchorPuinAndOpenid);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "onGetPuinAndOpenid Success");
                }
            } catch (Exception e16) {
                this.mGetPUinAndOpenidCallback.onFail(-1, "GetPUinAndOpenidByUidRsp parse fail");
                QLog.e(TAG, 4, "GetPUinAndOpenidByUidRsp error:" + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            resetCallback();
        }
    }
}
