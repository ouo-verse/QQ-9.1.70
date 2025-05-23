package com.tencent.mobileqq.qqlive.anchor.prepare;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.room.al;
import com.tencent.mobileqq.qqlive.anchor.room.helper.h;
import com.tencent.mobileqq.qqlive.anchor.room.helper.i;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareObs;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d implements IQQLiveAnchorPrepareWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IQQLiveSDK f270754a;

    /* renamed from: b, reason: collision with root package name */
    private QQLiveAnchorRoomInfo f270755b;

    /* renamed from: c, reason: collision with root package name */
    private h f270756c;

    /* renamed from: d, reason: collision with root package name */
    private i f270757d;

    /* renamed from: e, reason: collision with root package name */
    private c f270758e;

    /* renamed from: f, reason: collision with root package name */
    private b f270759f;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends al {
        static IPatchRedirector $redirector_;

        a(IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
            super(iQQLiveAnchorRoomThirdPushCallback);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) iQQLiveAnchorRoomThirdPushCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onPrepare(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataPrepare);
                return;
            }
            if (qQLiveAnchorDataPrepare.isSuccess) {
                d.this.f270755b.roomData = qQLiveAnchorDataPrepare.roomInfo;
                d.this.f270755b.roomAttr = qQLiveAnchorDataPrepare.roomAttr;
            }
            super.onPrepare(qQLiveAnchorDataPrepare);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270755b = new QQLiveAnchorRoomInfo();
        this.f270756c = new h();
        this.f270757d = new i();
        this.f270758e = new c();
        this.f270759f = new b();
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f270758e.destroy();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
    public byte[] getAuthExt(String str) {
        long j3;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        IQQLiveSDK iQQLiveSDK = this.f270754a;
        if (iQQLiveSDK != null && iQQLiveSDK.getLoginModule() != null && this.f270754a.getLoginModule().getLoginInfo() != null) {
            j3 = this.f270754a.getLoginModule().getLoginInfo().uid;
            str2 = this.f270754a.getLoginModule().getLoginInfo().f271214a2;
        } else {
            j3 = 0;
            str2 = "";
        }
        return com.tencent.mobileqq.qqlive.anchor.room.helper.b.a(str, j3, str2);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
    public IQQLiveAnchorPrepareObs getObsModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IQQLiveAnchorPrepareObs) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f270759f;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
    public QQLiveAnchorRoomInfo getRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QQLiveAnchorRoomInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f270755b;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
    public IQQLiveAnchorPrepareThirdPush getThirdPushModule(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IQQLiveAnchorPrepareThirdPush) iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup);
        }
        this.f270758e.setPreViewContainer(viewGroup);
        return this.f270758e;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
    public void init(IQQLiveSDK iQQLiveSDK, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iQQLiveSDK, Long.valueOf(j3), str);
            return;
        }
        this.f270754a = iQQLiveSDK;
        this.f270758e.init(iQQLiveSDK);
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo = this.f270755b;
        qQLiveAnchorRoomInfo.uid = j3;
        qQLiveAnchorRoomInfo.source = str;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
    public void prepare(Activity activity, byte[] bArr, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, bArr, iQQLiveAnchorRoomThirdPushCallback);
        } else {
            this.f270756c.g(activity, this.f270754a, bArr, new a(iQQLiveAnchorRoomThirdPushCallback));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
    public void set(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr, byte[] bArr, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQLiveAnchorDataRoomAttr, bArr, iQQLiveAnchorRoomThirdPushCallback);
        } else {
            this.f270757d.e(this.f270754a, this.f270755b, qQLiveAnchorDataRoomAttr, bArr, iQQLiveAnchorRoomThirdPushCallback);
        }
    }
}
