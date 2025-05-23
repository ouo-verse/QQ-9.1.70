package com.tencent.mobileqq.qqlive.anchor.prepare;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.room.al;
import com.tencent.mobileqq.qqlive.anchor.room.helper.q;
import com.tencent.mobileqq.qqlive.anchor.room.helper.t;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush;
import com.tencent.mobileqq.qqlive.api.impl.room.ThirdpushRetryStrategy;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements IQQLiveAnchorPrepareThirdPush {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IQQLiveSDK f270745a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f270746b;

    /* renamed from: c, reason: collision with root package name */
    private q f270747c;

    /* renamed from: d, reason: collision with root package name */
    private t f270748d;

    /* renamed from: e, reason: collision with root package name */
    private View f270749e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f270750f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f270751g;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends al {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorAutoCheckPullPlayParams f270752e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams) {
            super(iQQLiveAnchorRoomThirdPushCallback);
            this.f270752e = qQLiveAnchorAutoCheckPullPlayParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, iQQLiveAnchorRoomThirdPushCallback, qQLiveAnchorAutoCheckPullPlayParams);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataPullInfo);
                return;
            }
            super.onGetPullInfo(qQLiveAnchorDataPullInfo);
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_PT", 1, "onGetPullInfo, isDestory:" + c.this.f270750f);
            }
            if (c.this.f270750f) {
                return;
            }
            QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams = this.f270752e;
            if (qQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay) {
                c.this.startCheck(qQLiveAnchorDataPullInfo.defaultPlayUrl, qQLiveAnchorAutoCheckPullPlayParams, this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataThirdPushCheck);
                return;
            }
            super.onThirdPushChecked(qQLiveAnchorDataThirdPushCheck);
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_PT", 1, "onThirdPushChecked, isDestory:" + c.this.f270750f);
            }
            if (!c.this.f270750f && c.this.f270748d != null) {
                c.this.f270748d.b(true, false);
                c.this.f270748d = null;
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270747c = new q();
        this.f270750f = false;
        this.f270751g = false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareSubModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_PT", 1, "destroy, isDestroy:" + this.f270750f);
        }
        this.f270750f = true;
        stopCheck();
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush
    public void getPullInfo(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, qQLiveAnchorRoomInfo, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPushCallback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_PT", 1, "getPullInfo, isDestory:" + this.f270750f);
        }
        if (this.f270750f) {
            return;
        }
        this.f270747c.c(this.f270745a, qQLiveAnchorRoomInfo, qQLiveAnchorAutoCheckPullPlayParams, new a(iQQLiveAnchorRoomThirdPushCallback, qQLiveAnchorAutoCheckPullPlayParams));
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush
    public void getPushInfo(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qQLiveAnchorRoomInfo, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPushCallback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_PT", 1, "getPushInfo, isDestroy:" + this.f270750f);
        }
        if (this.f270750f) {
            return;
        }
        this.f270747c.d(this.f270745a, qQLiveAnchorRoomInfo, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPushCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareSubModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.f270745a = iQQLiveSDK;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareSubModule
    public void onSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_PT", 1, "onSelected: " + z16 + ", isDestroy:" + this.f270750f);
        }
        if (!z16) {
            stopCheck();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush
    public void setNeedCallbackPlayerError(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f270751g = z16;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush
    public void setPreViewContainer(ViewGroup viewGroup) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup);
            return;
        }
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_PT", 1, "setPreViewContainer, isDestroy:" + this.f270750f);
        }
        if (this.f270750f) {
            return;
        }
        ViewGroup viewGroup2 = this.f270746b;
        boolean z17 = false;
        if (viewGroup2 != null && (view = this.f270749e) != null) {
            if (viewGroup2.indexOfChild(view) == -1) {
                z16 = false;
            }
            this.f270746b.removeView(this.f270749e);
            z17 = z16;
        }
        this.f270746b = viewGroup;
        if (z17) {
            viewGroup.addView(this.f270749e, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush
    public void startCheck(String str, QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPushCallback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_PT", 1, "startCheck, isDestroy:" + this.f270750f + ", url:" + str);
        }
        if (this.f270750f) {
            return;
        }
        if (this.f270748d != null) {
            stopCheck();
        }
        IQQLiveSDK iQQLiveSDK = this.f270745a;
        if (iQQLiveSDK != null) {
            str2 = iQQLiveSDK.getAppId();
        } else {
            str2 = "-1";
        }
        t tVar = new t(str2, str, null, qQLiveAnchorAutoCheckPullPlayParams, iQQLiveAnchorRoomThirdPushCallback);
        this.f270748d = tVar;
        View c16 = tVar.c();
        this.f270749e = c16;
        ViewGroup viewGroup = this.f270746b;
        if (viewGroup != null && c16 != null) {
            viewGroup.addView(c16, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.f270751g) {
            tVar.d(qQLiveAnchorAutoCheckPullPlayParams.playerRetryInterval, qQLiveAnchorAutoCheckPullPlayParams.playerRetryCount, new ThirdpushRetryStrategy());
        }
        tVar.e(qQLiveAnchorAutoCheckPullPlayParams.isMute);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush
    public void stopCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_PT", 1, "stopCheck, isDestroy:" + this.f270750f);
        }
        ViewGroup viewGroup = this.f270746b;
        if (viewGroup != null) {
            viewGroup.removeView(this.f270749e);
        }
        this.f270749e = null;
        t tVar = this.f270748d;
        if (tVar != null) {
            tVar.b(true, false);
        }
        this.f270748d = null;
    }
}
