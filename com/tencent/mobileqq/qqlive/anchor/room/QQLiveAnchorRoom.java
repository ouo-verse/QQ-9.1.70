package com.tencent.mobileqq.qqlive.anchor.room;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.anchor.room.helper.e;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataCheckPermission;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataMediaInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class QQLiveAnchorRoom extends BaseLiveRoom implements IQQLiveAnchorRoom {
    static IPatchRedirector $redirector_;
    protected com.tencent.mobileqq.qqlive.anchor.room.helper.e C;
    protected com.tencent.mobileqq.qqlive.anchor.room.helper.h D;
    protected com.tencent.mobileqq.qqlive.anchor.room.helper.i E;
    protected QQLiveAnchorHelperFastResume F;
    protected com.tencent.mobileqq.qqlive.anchor.report.a G;
    protected int H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected long L;
    protected IQQLiveAnchorRoom.LinkMicType M;
    private final Runnable N;

    /* renamed from: d, reason: collision with root package name */
    protected Context f270779d;

    /* renamed from: e, reason: collision with root package name */
    protected QQLiveAnchorRoomConfig f270780e;

    /* renamed from: f, reason: collision with root package name */
    protected QQLiveAnchorRoomInfo f270781f;

    /* renamed from: h, reason: collision with root package name */
    protected final ak f270782h;

    /* renamed from: i, reason: collision with root package name */
    protected QQLiveAnchorRoomState f270783i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f270784m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements e.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorRoom.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.e.b
        public void a(QQLiveErrorMsg qQLiveErrorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveErrorMsg);
            } else {
                QQLiveAnchorRoom.this.z(qQLiveErrorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.e.b
        public void onSuccess(LoginInfo loginInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginInfo);
                return;
            }
            QQLiveAnchorRoom qQLiveAnchorRoom = QQLiveAnchorRoom.this;
            qQLiveAnchorRoom.f270781f.uid = loginInfo.uid;
            qQLiveAnchorRoom.B();
            ((BaseLiveRoom) QQLiveAnchorRoom.this).liveSDK.getDataReportModule().setLoginInfo(loginInfo);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b extends al {
        static IPatchRedirector $redirector_;

        b(IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
            super(iQQLiveAnchorRoomThirdPushCallback);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorRoom.this, (Object) iQQLiveAnchorRoomThirdPushCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.room.al, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onPrepare(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataPrepare);
                return;
            }
            QQLiveAnchorRoom.this.f270781f.roomAttr = new QQLiveAnchorDataRoomAttr(qQLiveAnchorDataPrepare.roomAttr);
            QQLiveAnchorRoom.this.f270781f.roomData = new QQLiveAnchorDataRoomInfo(qQLiveAnchorDataPrepare.roomInfo);
            super.onPrepare(qQLiveAnchorDataPrepare);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c extends com.tencent.mobileqq.qqlive.sso.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ gr4.d f270788d;

        c(gr4.d dVar) {
            this.f270788d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorRoom.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sso.f
        public void onReceive(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                return;
            }
            if (!((BaseLiveRoom) QQLiveAnchorRoom.this).isDestroy && QQLiveAnchorRoom.this.f270783i == QQLiveAnchorRoomState.STATE_ENTER_ING) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLiveAnchor_BaseRoom", 1, "enter receive, type:" + i3 + ", success:" + z16);
                }
                try {
                    com.tencent.mobileqq.qqlive.anchor.util.a.a(i3, z16, hVar);
                    gr4.e c16 = gr4.e.c(hVar.e());
                    if (c16.f403111a == 0) {
                        QQLiveAnchorDataEnter g16 = com.tencent.mobileqq.qqlive.anchor.util.a.g(c16);
                        if (TextUtils.isEmpty(QQLiveAnchorRoom.this.f270781f.roomData.programId)) {
                            QQLiveAnchorRoom.this.f270781f.roomData.programId = this.f270788d.f403105c;
                            QLog.e("QQLiveAnchor_BaseRoom", 1, "fill roominfo programid:" + this.f270788d.f403105c);
                        }
                        QQLiveAnchorRoom.this.f270781f.userDta = new QQLiveAnchorDataUserInfo(g16.userInfo);
                        QQLiveAnchorRoom.this.f270781f.mediaData = new QQLiveAnchorDataMediaInfo(g16.mediaInfo);
                        QQLiveAnchorRoom.this.f270781f.trtcData = new QQLiveAnchorDataTrtcInfo(g16.trtcInfo);
                        QQLiveAnchorRoom.this.t(QQLiveAnchorRoomState.STATE_ENTER_READY);
                        QQLiveAnchorRoom.this.f270782h.onEnter(g16);
                        QQLiveAnchorRoom.this.onEnterRoom();
                        QLog.i("QQLiveAnchor_BaseRoom", 1, " enter liveSDK Room success");
                        QQLiveAnchorRoom qQLiveAnchorRoom = QQLiveAnchorRoom.this;
                        qQLiveAnchorRoom.K = true;
                        qQLiveAnchorRoom.f270782h.onEnterRoom();
                        return;
                    }
                    throw new QQLiveAnchorThrowable("enter rsp error", c16.f403111a, c16.f403112b);
                } catch (Throwable th5) {
                    QLog.d("QQLiveAnchor_BaseRoom", 1, "enter failed: ", th5);
                    QQLiveAnchorRoom.this.t(QQLiveAnchorRoomState.STATE_ENTER_FAILED);
                    QQLiveErrorMsg covert = QQLiveAnchorThrowable.covert(6250, th5);
                    QQLiveAnchorRoom.this.f270782h.onError(covert);
                    QQLiveAnchorRoom.this.f270782h.onEnter(new QQLiveAnchorDataEnter(false, covert));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d extends com.tencent.mobileqq.qqlive.sso.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ pt3.i f270790d;

        d(pt3.i iVar) {
            this.f270790d = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorRoom.this, (Object) iVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sso.f
        public void onReceive(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                return;
            }
            if (!((BaseLiveRoom) QQLiveAnchorRoom.this).isDestroy && QQLiveAnchorRoom.this.f270783i == QQLiveAnchorRoomState.STATE_PUBLISH_ING) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLiveAnchor_BaseRoom", 1, "push stream recieve, type:" + i3 + ", success:" + z16);
                }
                try {
                    com.tencent.mobileqq.qqlive.anchor.util.a.a(i3, z16, hVar);
                    pt3.j c16 = pt3.j.c(hVar.e());
                    if (c16.f427161a == 0) {
                        QQLiveAnchorRoom.this.t(QQLiveAnchorRoomState.STATE_PUBLISH_READY);
                        QQLiveAnchorRoom.this.f270782h.onPublishStream(new QQLiveAnchorDataPublishStream(true, null));
                        QQLiveAnchorRoom.this.t(QQLiveAnchorRoomState.STATE_LIVE_ING);
                        QQLiveAnchorRoom qQLiveAnchorRoom = QQLiveAnchorRoom.this;
                        qQLiveAnchorRoom.F.n(qQLiveAnchorRoom.f270779d, ((BaseLiveRoom) qQLiveAnchorRoom).liveSDK.getAppId(), QQLiveAnchorRoom.this);
                        QQLiveAnchorRoom qQLiveAnchorRoom2 = QQLiveAnchorRoom.this;
                        qQLiveAnchorRoom2.J(qQLiveAnchorRoom2.H);
                        return;
                    }
                    QLog.e("QQLiveAnchor_BaseRoom", 1, "StartNewReq.sceneId:" + this.f270790d.f427158k);
                    throw new QQLiveAnchorThrowable("push stream rsp error", c16.f427161a, "");
                } catch (Throwable th5) {
                    QLog.e("QQLiveAnchor_BaseRoom", 1, "push stream error:", th5);
                    QQLiveAnchorRoom.this.t(QQLiveAnchorRoomState.STATE_PUBLISH_FAILED);
                    QQLiveErrorMsg covert = QQLiveAnchorThrowable.covert(QQLiveError.ANCHOR_PUBLISH_ERR, th5);
                    QQLiveAnchorRoom.this.f270782h.onPublishStream(new QQLiveAnchorDataPublishStream(false, covert));
                    QQLiveAnchorRoom.this.f270782h.onError(covert);
                }
            }
        }
    }

    public QQLiveAnchorRoom(@NonNull Context context, @NonNull IQQLiveSDK iQQLiveSDK, @NonNull QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, iQQLiveSDK, qQLiveAnchorRoomConfig, iQQLiveAnchorRoomCallback);
            return;
        }
        this.f270781f = new QQLiveAnchorRoomInfo();
        ak akVar = new ak();
        this.f270782h = akVar;
        this.f270783i = QQLiveAnchorRoomState.STATE_NONE;
        this.f270784m = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.C = new com.tencent.mobileqq.qqlive.anchor.room.helper.e();
        this.D = new com.tencent.mobileqq.qqlive.anchor.room.helper.h();
        this.E = new com.tencent.mobileqq.qqlive.anchor.room.helper.i();
        this.F = new QQLiveAnchorHelperFastResume();
        this.G = new com.tencent.mobileqq.qqlive.anchor.report.a();
        this.H = 1000;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = 0L;
        this.M = IQQLiveAnchorRoom.LinkMicType.Others;
        this.N = new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom$1$a */
            /* loaded from: classes17.dex */
            class a extends com.tencent.mobileqq.qqlive.sso.f {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.sso.f
                public void onReceive(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) {
                    lt3.c c16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                        return;
                    }
                    try {
                        com.tencent.mobileqq.qqlive.anchor.util.a.a(i3, z16, hVar);
                        c16 = lt3.c.c(hVar.e());
                    } catch (Throwable th5) {
                        QLog.e("QQLiveAnchor_BaseRoom", 1, "heart failed: ", th5);
                        QQLiveAnchorRoom.this.E();
                    }
                    if (c16.f415549a == 0) {
                        int i16 = c16.f415550b;
                        if (i16 > 0) {
                            QQLiveAnchorRoom.this.H = i16 * 1000;
                        }
                        QQLiveAnchorRoom.this.L = 0L;
                        QQLiveAnchorRoom qQLiveAnchorRoom = QQLiveAnchorRoom.this;
                        qQLiveAnchorRoom.J(qQLiveAnchorRoom.H);
                        return;
                    }
                    throw new IllegalArgumentException("heart result error: " + c16.f415549a + ", " + c16.f415550b);
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAnchorRoom.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                BaseRoomInfo roomInfo = QQLiveAnchorRoom.this.getRoomInfo();
                lt3.b bVar = new lt3.b();
                if (roomInfo != null) {
                    bVar.f415540a = ((BaseLiveRoom) QQLiveAnchorRoom.this).liveSDK.getConfigModule().getConfigData().getLiveClientType();
                    bVar.f415543d = (int) roomInfo.getRoomId();
                    bVar.f415544e = 1;
                    bVar.f415541b = 4;
                    ArrayList arrayList = new ArrayList();
                    lt3.a aVar = new lt3.a();
                    aVar.f415538a = "liveplay";
                    aVar.f415539b = QQLiveAnchorRoom.this.M.value.getBytes();
                    arrayList.add(aVar);
                    bVar.f415548i = (lt3.a[]) arrayList.toArray(new lt3.a[0]);
                }
                com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) ((BaseLiveRoom) QQLiveAnchorRoom.this).liveSDK.getExtModule("sso_module");
                if (cVar != null) {
                    cVar.f("trpc.qlive.media_hb4opensdk.MediaLogic", "SendHB", MessageNano.toByteArray(bVar), new a());
                } else {
                    QLog.e("QQLiveAnchor_BaseRoom", 4, "heart, get Sso module null");
                }
                QQLiveAnchorRoom qQLiveAnchorRoom = QQLiveAnchorRoom.this;
                QQLiveAnchorHelperFastResume qQLiveAnchorHelperFastResume = qQLiveAnchorRoom.F;
                if (qQLiveAnchorHelperFastResume != null) {
                    qQLiveAnchorHelperFastResume.o(qQLiveAnchorRoom.f270779d, qQLiveAnchorRoom);
                }
            }
        };
        this.f270779d = context.getApplicationContext();
        this.f270780e = qQLiveAnchorRoomConfig;
        if (iQQLiveAnchorRoomCallback != null) {
            akVar.registerAnchorCallback(iQQLiveAnchorRoomCallback);
        }
        t(QQLiveAnchorRoomState.STATE_CREATE);
        u(context);
    }

    private void A() {
        if (this.isDestroy) {
            return;
        }
        this.C.d(this.liveSDK, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(int i3, String str) {
        boolean z16;
        if (this.G != null) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = i3;
            qQLiveErrorMsg.bizErrMsg = str;
            com.tencent.mobileqq.qqlive.anchor.report.a aVar = this.G;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.h(z16, qQLiveErrorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(ExitRoomCallback exitRoomCallback, int i3, String str) {
        boolean z16;
        H();
        if (exitRoomCallback != null) {
            exitRoomCallback.onComplete(i3, str);
        }
        if (this.G != null) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = i3;
            qQLiveErrorMsg.bizErrMsg = str;
            com.tencent.mobileqq.qqlive.anchor.report.a aVar = this.G;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.C(z16, qQLiveErrorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        long j3 = this.L + 1;
        this.L = j3;
        if (j3 < 5) {
            return;
        }
        if (this.f270782h != null) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6105;
            qQLiveErrorMsg.bizErrMsg = "heart failed";
            this.f270782h.onError(qQLiveErrorMsg);
            com.tencent.mobileqq.qqlive.anchor.report.a aVar = this.G;
            if (aVar != null) {
                aVar.m(qQLiveErrorMsg);
            }
        }
        this.L = 0L;
    }

    private void H() {
        if (this.liveSDK.getAppRuntime() != null) {
            QQLiveAnchorHelperFastResume.p(this.f270779d, this.liveSDK.getAppId(), this.liveSDK.getAppRuntime().getCurrentUin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3) {
        if (!this.isDestroy && !this.isExitRoom) {
            this.f270784m.postDelayed(this.N, i3);
        }
    }

    protected void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (!this.isDestroy && this.f270783i == QQLiveAnchorRoomState.STATE_INIT_ING && !this.isInited) {
            synchronized (this) {
                if (!this.isInited && this.C.f270870a) {
                    t(QQLiveAnchorRoomState.STATE_INIT_READY);
                    this.isInited = true;
                    this.f270782h.onInit(new QQLiveAnchorDataInit(true, null));
                }
            }
        }
    }

    protected void F(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
            return;
        }
        this.J = false;
        QQLiveAnchorDataCheckPermission qQLiveAnchorDataCheckPermission = new QQLiveAnchorDataCheckPermission();
        qQLiveAnchorDataCheckPermission.isSuccess = false;
        qQLiveAnchorDataCheckPermission.errorMsg = new QQLiveErrorMsg(2, 6102, "permision error", -1, "");
        qQLiveAnchorDataCheckPermission.unGrantPermissions = arrayList;
        this.f270782h.onCheckPermission(qQLiveAnchorDataCheckPermission);
    }

    protected void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.J = true;
            this.f270782h.onCheckPermission(new QQLiveAnchorDataCheckPermission(true, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK == null) {
            return;
        }
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo = this.f270781f;
        if (qQLiveAnchorRoomInfo != null && (qQLiveAnchorDataRoomInfo = qQLiveAnchorRoomInfo.roomData) != null) {
            iQQLiveSDK.removeCurRoomRecord(qQLiveAnchorDataRoomInfo.f271212id);
        } else {
            QLog.e("QQLiveAnchor_BaseRoom", 1, "clearRoomInfo, roomData null");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public QQLiveAnchorRoomState currentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (QQLiveAnchorRoomState) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.f270783i;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom destroy");
        }
        if (this.isDestroy) {
            return;
        }
        if (!this.isExitRoom) {
            exitRoom(null);
        }
        t(QQLiveAnchorRoomState.STATE_DESTROY);
        super.destroy();
        unRegisterAllAnchorCallback();
        this.G.e();
    }

    public void enterRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom enterRoom");
        }
        if (this.isDestroy) {
            return;
        }
        QQLiveAnchorRoomState qQLiveAnchorRoomState = this.f270783i;
        QQLiveAnchorRoomState qQLiveAnchorRoomState2 = QQLiveAnchorRoomState.STATE_ENTER_ING;
        if (qQLiveAnchorRoomState == qQLiveAnchorRoomState2) {
            return;
        }
        if (this.K) {
            QLog.e("QQLiveAnchor_BaseRoom", 1, "already enteredRoom curState:" + this.f270783i);
            t(QQLiveAnchorRoomState.STATE_ENTER_FAILED);
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6000;
            qQLiveErrorMsg.bizErrMsg = "already enteredRoom";
            this.f270782h.onEnter(new QQLiveAnchorDataEnter(false, qQLiveErrorMsg));
            this.f270782h.onError(qQLiveErrorMsg);
            return;
        }
        this.f270782h.onStartEnter();
        t(qQLiveAnchorRoomState2);
        gr4.d f16 = com.tencent.mobileqq.qqlive.anchor.util.a.f(this.f270781f);
        com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) this.liveSDK.getExtModule("sso_module");
        if (cVar == null) {
            QLog.e("QQLiveAnchor_BaseRoom", 4, "enter, get Sso module null");
            return;
        }
        QLog.i("QQLiveAnchor_BaseRoom", 1, "start enter livesdk Room");
        cVar.f("trpc.qlive.ilive_room_play.RoomPlay", "Enter", MessageNano.toByteArray(f16), new c(f16));
        recordRoomInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public void exitRoom(final ExitRoomCallback exitRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) exitRoomCallback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom exitRoom: " + this.isDestroy + ", " + this.isExitRoom);
        }
        if (this.isExitRoom || this.isDestroy) {
            return;
        }
        com.tencent.mobileqq.qqlive.anchor.report.a aVar = this.G;
        if (aVar != null) {
            aVar.i();
        }
        com.tencent.mobileqq.qqlive.anchor.room.helper.c.b(this.liveSDK, this.appId, com.tencent.mobileqq.qqlive.anchor.util.a.k(this.f270781f), new ExitRoomCallback() { // from class: com.tencent.mobileqq.qqlive.anchor.room.a
            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
            public final void onComplete(int i3, String str) {
                QQLiveAnchorRoom.this.C(i3, str);
            }
        });
        com.tencent.mobileqq.qqlive.anchor.report.a aVar2 = this.G;
        if (aVar2 != null) {
            aVar2.D();
        }
        QLog.i("QQLiveAnchor_BaseRoom", 1, "exitRoom curState: " + this.f270783i.ordinal());
        if (this.f270783i.ordinal() >= QQLiveAnchorRoomState.STATE_PUBLISH_ING.ordinal()) {
            IQQLiveSDK iQQLiveSDK = this.liveSDK;
            com.tencent.mobileqq.qqlive.anchor.room.helper.c.a(iQQLiveSDK, this.appId, com.tencent.mobileqq.qqlive.anchor.util.a.e(this.f270781f, iQQLiveSDK.getConfigModule().getConfigData().getLiveClientType()), new ExitRoomCallback() { // from class: com.tencent.mobileqq.qqlive.anchor.room.b
                @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
                public final void onComplete(int i3, String str) {
                    QQLiveAnchorRoom.this.D(exitRoomCallback, i3, str);
                }
            });
        } else {
            H();
            if (exitRoomCallback != null) {
                exitRoomCallback.onComplete(0, "");
            }
            if (this.G != null) {
                QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                qQLiveErrorMsg.bizModule = 2;
                qQLiveErrorMsg.bizErrCode = 0;
                qQLiveErrorMsg.bizErrMsg = "";
                this.G.C(true, qQLiveErrorMsg);
            }
        }
        t(QQLiveAnchorRoomState.STATE_LIVE_EXIT);
        this.f270782h.onExit();
        I();
        super.exitRoom(exitRoomCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void fastResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
        } else {
            this.I = true;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public BaseAnchorInfo getAnchorInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (BaseAnchorInfo) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return new QQLiveAnchorDataUserInfo(this.f270781f.userDta);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public QQLiveAnchorRoomInfo getAnchorRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (QQLiveAnchorRoomInfo) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return new QQLiveAnchorRoomInfo(this.f270781f);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public byte[] getAuthExt(String str) {
        long j3;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (byte[]) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom getAuthExt");
        }
        if (this.isDestroy) {
            return new byte[0];
        }
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null && iQQLiveSDK.getLoginModule() != null && this.liveSDK.getLoginModule().getLoginInfo() != null) {
            j3 = this.liveSDK.getLoginModule().getLoginInfo().uid;
            str2 = this.liveSDK.getLoginModule().getLoginInfo().f271214a2;
        } else {
            j3 = 0;
            str2 = "";
        }
        return com.tencent.mobileqq.qqlive.anchor.room.helper.b.a(str, j3, str2);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public QQLiveAnchorRoomConfig getRoomConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (QQLiveAnchorRoomConfig) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.f270780e;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public BaseRoomInfo getRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (BaseRoomInfo) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return new QQLiveAnchorDataRoomInfo(this.f270781f.roomData);
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        this.isExitRoom = false;
        this.isInited = false;
        t(QQLiveAnchorRoomState.STATE_INIT_ING);
        this.f270782h.onStartInit();
        super.init(iQQLiveSDK);
        if (!this.J) {
            z(new QQLiveErrorMsg(2, 6102, "permision error", -1, ""));
        } else {
            A();
        }
        this.G.n(this);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    public boolean isAnchorRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom
    public void onEnterRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            super.onEnterRoom();
        }
    }

    public void prepare(Activity activity, byte[] bArr) {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) activity, (Object) bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom prepare");
        }
        if (this.isDestroy) {
            return;
        }
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo = this.f270781f;
        if (qQLiveAnchorRoomInfo != null && (qQLiveAnchorDataRoomInfo = qQLiveAnchorRoomInfo.roomData) != null && !TextUtils.isEmpty(qQLiveAnchorDataRoomInfo.programId)) {
            this.f270782h.onStartPrepare();
            QLog.e("QQLiveAnchor_BaseRoom", 1, "already prepared");
            QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare = new QQLiveAnchorDataPrepare();
            qQLiveAnchorDataPrepare.isSuccess = true;
            QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo2 = this.f270781f;
            qQLiveAnchorDataPrepare.roomInfo = qQLiveAnchorRoomInfo2.roomData;
            qQLiveAnchorDataPrepare.roomAttr = qQLiveAnchorRoomInfo2.roomAttr;
            this.f270782h.onPrepare(qQLiveAnchorDataPrepare);
            return;
        }
        this.D.g(activity, this.liveSDK, bArr, new b(this.f270782h));
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void recordRoomInfo() {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.liveSDK == null) {
            return;
        }
        QQLiveCurRoomInfo qQLiveCurRoomInfo = new QQLiveCurRoomInfo();
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo = this.f270781f;
        if (qQLiveAnchorRoomInfo != null && (qQLiveAnchorDataRoomInfo = qQLiveAnchorRoomInfo.roomData) != null) {
            qQLiveCurRoomInfo.roomId = qQLiveAnchorDataRoomInfo.f271212id;
            qQLiveCurRoomInfo.roomType = 1;
            qQLiveCurRoomInfo.uid = qQLiveAnchorRoomInfo.uid;
            qQLiveCurRoomInfo.programId = qQLiveAnchorDataRoomInfo.programId;
            this.liveSDK.recordCurRoomInfo(qQLiveCurRoomInfo);
            return;
        }
        QLog.e("QQLiveAnchor_BaseRoom", 1, "recordRoomInfo, something null");
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister
    public void registerAnchorCallback(IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) iQQLiveAnchorRoomCallback);
        } else if (!this.isDestroy && iQQLiveAnchorRoomCallback != null) {
            this.f270782h.registerAnchorCallback(iQQLiveAnchorRoomCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.reset();
            this.f270782h.unRegisterAllAnchorCallback();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void setAnchorRoomConfig(QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) qQLiveAnchorRoomConfig);
        } else {
            this.f270780e = qQLiveAnchorRoomConfig;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void setAnchorRoomInfo(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) qQLiveAnchorRoomInfo);
        } else {
            this.f270781f = qQLiveAnchorRoomInfo;
        }
    }

    public void startPublishStream() {
        QQLiveAnchorRoomState qQLiveAnchorRoomState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom startPublish");
        }
        if (this.isDestroy) {
            return;
        }
        QQLiveAnchorRoomState qQLiveAnchorRoomState2 = this.f270783i;
        QQLiveAnchorRoomState qQLiveAnchorRoomState3 = QQLiveAnchorRoomState.STATE_PUBLISH_ING;
        if (qQLiveAnchorRoomState2 == qQLiveAnchorRoomState3) {
            return;
        }
        this.f270782h.onStartPublishStream();
        QQLiveAnchorRoomState qQLiveAnchorRoomState4 = this.f270783i;
        if (qQLiveAnchorRoomState4 != QQLiveAnchorRoomState.STATE_ENTER_READY && qQLiveAnchorRoomState4 != (qQLiveAnchorRoomState = QQLiveAnchorRoomState.STATE_PUBLISH_FAILED)) {
            t(qQLiveAnchorRoomState);
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6000;
            qQLiveErrorMsg.bizErrMsg = "check publish error, curState=" + this.f270783i.name();
            this.f270782h.onPublishStream(new QQLiveAnchorDataPublishStream(false, qQLiveErrorMsg));
            this.f270782h.onError(qQLiveErrorMsg);
            return;
        }
        t(qQLiveAnchorRoomState3);
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "uid:" + this.f270781f.userDta.f271213id + ", roomId:" + this.f270781f.roomData.f271212id + ", streamId:" + this.f270781f.trtcData.streamInfo.mainStreamId + ", sig:" + this.f270781f.trtcData.sig);
        }
        pt3.i E = com.tencent.mobileqq.qqlive.anchor.util.a.E(this.f270781f, this.liveSDK.getConfigModule().getConfigData().getLiveClientType());
        com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) this.liveSDK.getExtModule("sso_module");
        if (cVar == null) {
            QLog.e("QQLiveAnchor_BaseRoom", 4, "publish, get Sso module null");
        } else {
            cVar.f("trpc.qlive.media_logic4opensdk.MediaLogic", "StartNew", MessageNano.toByteArray(E), new d(E));
        }
    }

    public void startSet(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) qQLiveAnchorDataRoomAttr, (Object) bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom startSet");
        }
        if (this.isDestroy) {
            return;
        }
        this.f270782h.onStartSet();
        this.E.e(this.liveSDK, this.f270781f, qQLiveAnchorDataRoomAttr, bArr, this.f270782h);
    }

    public void t(QQLiveAnchorRoomState qQLiveAnchorRoomState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) qQLiveAnchorRoomState);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_BaseRoom", 1, "changeState, old:" + this.f270783i.name() + ", new:" + qQLiveAnchorRoomState.name());
        }
        if (this.isDestroy) {
            return;
        }
        this.f270782h.onStateChange(this.f270783i, qQLiveAnchorRoomState);
        this.f270783i = qQLiveAnchorRoomState;
    }

    protected void u(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.f270782h.onStartCheckPermission();
        String[] x16 = x();
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : x16) {
            if (context.checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            G();
        } else {
            F(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister
    public void unRegisterAllAnchorCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.f270782h.unRegisterAllAnchorCallback();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister
    public void unRegisterAnchorCallback(IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) iQQLiveAnchorRoomCallback);
        } else if (iQQLiveAnchorRoomCallback != null) {
            this.f270782h.unRegisterAnchorCallback(iQQLiveAnchorRoomCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
    public void updateLinkMicType(IQQLiveAnchorRoom.LinkMicType linkMicType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) linkMicType);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.M = linkMicType;
        }
    }

    public IQQLiveSDK v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IQQLiveSDK) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.liveSDK;
    }

    public QQLiveAnchorRoomInfo w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (QQLiveAnchorRoomInfo) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.f270781f;
    }

    protected abstract String[] x();

    public AppRuntime y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.liveSDK.getAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) qQLiveErrorMsg);
            return;
        }
        if (!this.isDestroy && this.f270783i == QQLiveAnchorRoomState.STATE_INIT_ING) {
            t(QQLiveAnchorRoomState.STATE_INIT_FAILED);
            this.isInited = false;
            this.f270782h.onInit(new QQLiveAnchorDataInit(false, qQLiveErrorMsg));
            this.f270782h.onError(qQLiveErrorMsg);
        }
    }
}
