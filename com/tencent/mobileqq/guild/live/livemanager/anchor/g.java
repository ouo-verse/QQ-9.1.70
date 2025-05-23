package com.tencent.mobileqq.guild.live.livemanager.anchor;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.m;
import com.tencent.mobileqq.guild.media.core.i;
import com.tencent.mobileqq.guild.performance.report.GuildLiveStartReportTask;
import com.tencent.mobileqq.guild.performance.report.l;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.h;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.common.QQLiveEventMsg;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g implements com.tencent.mobileqq.guild.live.livemanager.anchor.d, m {

    /* renamed from: b, reason: collision with root package name */
    private final GLiveChannelCore f226764b;

    /* renamed from: f, reason: collision with root package name */
    private MutableLiveData<QQLiveAnchorDataPrepare> f226768f;

    /* renamed from: g, reason: collision with root package name */
    private MutableLiveData<Boolean> f226769g;

    /* renamed from: h, reason: collision with root package name */
    private IQQLiveAnchorRoom f226770h;

    /* renamed from: i, reason: collision with root package name */
    private long f226771i;

    /* renamed from: j, reason: collision with root package name */
    private long f226772j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.mobileqq.guild.live.livemanager.c f226773k;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<Boolean> f226775m;

    /* renamed from: n, reason: collision with root package name */
    private long f226776n;

    /* renamed from: o, reason: collision with root package name */
    private long f226777o;

    /* renamed from: a, reason: collision with root package name */
    private final String f226763a = "QGL.QQGuildLiveAnchorRoomMgr";

    /* renamed from: c, reason: collision with root package name */
    public MutableLiveData<Boolean> f226765c = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: d, reason: collision with root package name */
    public MutableLiveData<Integer> f226766d = new MutableLiveData<>(0);

    /* renamed from: e, reason: collision with root package name */
    public MutableLiveData<QQLiveAnchorDataPrepare> f226767e = new MutableLiveData<>(null);

    /* renamed from: l, reason: collision with root package name */
    private MutableLiveData<QQLiveAnchorDataPushInfo> f226774l = new MutableLiveData<>(null);

    /* renamed from: p, reason: collision with root package name */
    private IQQLiveAnchorRoomCallback f226778p = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f226780a;

        b(Activity activity) {
            this.f226780a = activity;
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int i3, @NonNull String str) {
            if (i3 == 0) {
                g.this.f226770h.prepare(this.f226780a, str.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f226782a;

        c(i iVar) {
            this.f226782a = iVar;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "get login ticket fail errorCode=" + i3 + ", errorMsg=" + str);
            this.f226782a.onResult(i3, str);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "get login ticket suc");
            this.f226782a.onResult(0, mainTicketInfo.getA2());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorDataPrepare f226784a;

        d(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            this.f226784a = qQLiveAnchorDataPrepare;
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int i3, @NonNull String str) {
            QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
            if (i3 == 0) {
                IQQLiveAnchorRoom iQQLiveAnchorRoom = g.this.f226770h;
                QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare = this.f226784a;
                if (qQLiveAnchorDataPrepare == null) {
                    qQLiveAnchorDataRoomAttr = null;
                } else {
                    qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr;
                }
                iQQLiveAnchorRoom.startSet(qQLiveAnchorDataRoomAttr, str.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements ExitRoomCallback {
        e() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
        public void onComplete(int i3, String str) {
            l.g("anchor_exit_room_result", new HashMap(), i3, str);
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "anchorExitRoom onComplete code:" + i3 + " msg:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements m {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
        public boolean disableViewCallback() {
            return g.this.disableViewCallback();
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
        public boolean enableViewCallback() {
            return g.this.enableViewCallback();
        }
    }

    public g(GLiveChannelCore gLiveChannelCore) {
        this.f226764b = gLiveChannelCore;
    }

    private void B() {
        com.tencent.mobileqq.guild.live.livemanager.c cVar = this.f226773k;
        if (cVar != null) {
            cVar.o();
            this.f226773k = null;
        }
    }

    private void D(i iVar) {
        TicketManager ticketManager = (TicketManager) F().getManager(2);
        if (ticketManager.useAsyncTicketInterface()) {
            ticketManager.getA2(com.tencent.guild.aio.input.at.utils.g.a(F().getCurrentUin(), 0L), 16, new c(iVar));
            return;
        }
        String a26 = ticketManager.getA2(F().getCurrentUin());
        QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "get login ticket suc use old");
        iVar.onResult(0, a26);
    }

    private AppRuntime F() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
        String qQLiveErrorMsg;
        int i3;
        QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "handleOnEnterResult, isSuccess = " + qQLiveAnchorDataEnter.isSuccess + ", errorMsg = " + qQLiveAnchorDataEnter.errorMsg + ", roomInfo=" + qQLiveAnchorDataEnter.roomInfo);
        QQLiveErrorMsg qQLiveErrorMsg2 = qQLiveAnchorDataEnter.errorMsg;
        if (qQLiveErrorMsg2 == null) {
            qQLiveErrorMsg = "";
        } else {
            qQLiveErrorMsg = qQLiveErrorMsg2.toString();
        }
        HashMap hashMap = new HashMap();
        int i16 = 8002;
        if (qQLiveAnchorDataEnter.isSuccess) {
            i3 = 0;
        } else {
            i3 = 8002;
        }
        l.g("anchor_enter_room_result", hashMap, i3, qQLiveErrorMsg);
        if (qQLiveAnchorDataEnter.isSuccess) {
            if (this.f226770h != null) {
                l.c("anchor_room_publish_stream_start");
                this.f226777o = System.currentTimeMillis();
                this.f226770h.startPublishStream();
            }
            this.f226764b.t().c0(Boolean.TRUE);
            if (qQLiveAnchorDataEnter.roomInfo != null && QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 2, "update roomInfo.");
                return;
            }
            return;
        }
        if (vq1.c.b(this.f226776n)) {
            i16 = 8007;
        }
        N(i16, qQLiveErrorMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z16) {
        MutableLiveData<Boolean> mutableLiveData;
        if (this.f226770h != null) {
            if (z16) {
                tq1.b t16 = this.f226764b.t();
                Boolean bool = Boolean.TRUE;
                t16.r0(bool);
                t16.c0(bool);
            } else {
                aa.a(R.string.f147930y8);
                M();
                h.b(Constants.Business.QQ_GUILD_LIVE_AUTHOR);
            }
        }
        if (this.f226770h != null && (mutableLiveData = this.f226775m) != null) {
            mutableLiveData.setValue(Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(ILiveRoom iLiveRoom) {
        if (iLiveRoom == null) {
            QLog.e("QGL.QQGuildLiveAnchorRoomMgr", 1, "initLiveRoomListeners, liveRoom == null, please check it!!!");
            return;
        }
        com.tencent.mobileqq.guild.live.livemanager.c cVar = new com.tencent.mobileqq.guild.live.livemanager.c(iLiveRoom);
        this.f226773k = cVar;
        cVar.r();
    }

    private void M() {
        boolean h16 = this.f226764b.p().h();
        IQQLiveSDK f16 = this.f226764b.p().f();
        if (h16 && f16 != null) {
            f16.getAnchorModule().removeAnchorRecord(f16.getAppRuntime().getCurrentUin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("live_room_type", String.valueOf(0));
        l.g("live_room_anchor_start_live_result", hashMap, i3, str);
        GuildLiveStartReportTask.j(0, i3, str);
        this.f226766d.setValue(0);
    }

    private void Q(IQQLiveSDK iQQLiveSDK, QQLiveAnchorRecord qQLiveAnchorRecord) {
        if (!h.m(F(), Constants.Business.QQ_GUILD_LIVE_AUTHOR, this.f226764b.g())) {
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "resumeRoomIfCan requestAVFocus failure.");
            MutableLiveData<Boolean> mutableLiveData = this.f226775m;
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.FALSE);
                return;
            }
            return;
        }
        l.c("anchor_fast_resume_room");
        IQQLiveAnchorRoom createFastResumeRoom = iQQLiveSDK.getAnchorModule().createFastResumeRoom(qQLiveAnchorRecord, this.f226778p);
        this.f226770h = createFastResumeRoom;
        createFastResumeRoom.registerAnchorCallback(this.f226778p);
        L(this.f226770h);
        P(true);
        this.f226764b.t().l0(x(), new f());
        this.f226770h.init(iQQLiveSDK);
        this.f226770h.fastResume();
        QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "fastResume end.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        LiveUserInfo userInfo;
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f226770h;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getRoomInfo() != null) {
            this.f226771i = this.f226770h.getRoomInfo().getRoomId();
        }
        IQQLiveSDK f16 = this.f226764b.p().f();
        if (f16 != null && f16.isInited() && (userInfo = f16.getLoginModule().getUserInfo()) != null) {
            this.f226772j = userInfo.uid;
        }
    }

    private void v() {
        QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "anchorCreateRoom start.");
        IQQLiveSDK f16 = this.f226764b.p().f();
        if (f16 != null && this.f226764b.p().h()) {
            IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f226770h;
            if (iQQLiveAnchorRoom != null && !iQQLiveAnchorRoom.isDestroyed()) {
                QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "mAnchorRoom has been create");
                if (!this.f226770h.isInited()) {
                    this.f226770h.init(f16);
                    return;
                }
                MutableLiveData<Boolean> mutableLiveData = this.f226769g;
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(Boolean.TRUE);
                    return;
                }
                return;
            }
            QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig = new QQLiveAnchorRoomConfig();
            qQLiveAnchorRoomConfig.streamRecordType = QQLiveAnchorStreamRecordType.THIRD_PUSH;
            qQLiveAnchorRoomConfig.playerConfig = com.tencent.mobileqq.guild.live.livemanager.b.a(false);
            l.c("anchor_create_room");
            IQQLiveAnchorRoom createRoom = f16.getAnchorModule().createRoom(BaseApplication.getContext(), qQLiveAnchorRoomConfig, this.f226778p);
            this.f226770h = createRoom;
            createRoom.init(f16);
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "anchorCreateRoom end.");
            return;
        }
        QLog.w("QGL.QQGuildLiveAnchorRoomMgr", 1, "anchorEnterRoom, live sdk not init suc.");
        this.f226769g.setValue(Boolean.FALSE);
    }

    public void A() {
        if (this.f226770h != null) {
            this.f226766d.setValue(1);
            if (this.f226770h.currentState().ordinal() >= QQLiveAnchorRoomState.STATE_ENTER_READY.ordinal()) {
                l.c("anchor_room_publish_stream_start");
                this.f226777o = System.currentTimeMillis();
                this.f226770h.startPublishStream();
                return;
            } else {
                QQLiveAnchorDataPrepare value = this.f226767e.getValue();
                if (value == null) {
                    QLog.e("QGL.QQGuildLiveAnchorRoomMgr", 1, "dataPrepare is null!!!");
                }
                D(new d(value));
                return;
            }
        }
        N(8001, "anchor room is null");
        QLog.e("QGL.QQGuildLiveAnchorRoomMgr", 1, "mAnchorRoom is null!!!");
    }

    public void C(long j3, String str, String str2) {
        IQQLiveSDK f16 = this.f226764b.p().f();
        if (f16 != null) {
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "forceExitLiveRoom. roomId=" + j3 + " pro:" + str);
            int tryCloseIsolatedRoom = f16.getAnchorModule().tryCloseIsolatedRoom(j3, str);
            l.g("anchor_fast_close_room", new HashMap(), tryCloseIsolatedRoom, str2);
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "forceExitLiveRoom. resultCode=" + tryCloseIsolatedRoom);
            if (tryCloseIsolatedRoom == 0) {
                aa.a(R.string.f147780xt);
            }
        }
    }

    public LiveData<Boolean> E() {
        this.f226769g = new MutableLiveData<>();
        v();
        return this.f226769g;
    }

    public String G() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f226770h;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getRoomInfo() != null) {
            return this.f226770h.getRoomInfo().getProgramId();
        }
        return null;
    }

    public long H() {
        return this.f226771i;
    }

    public long I() {
        return this.f226772j;
    }

    public LiveData<Boolean> O(long j3, String str) {
        this.f226775m = new e12.a();
        if (!this.f226764b.p().h()) {
            QLog.e("QGL.QQGuildLiveAnchorRoomMgr", 1, "resumeRoomIfCan, sdk not init suc.");
            this.f226775m.setValue(Boolean.FALSE);
            return this.f226775m;
        }
        IQQLiveSDK f16 = this.f226764b.p().f();
        QQLiveAnchorRecord validAnchorRecord = f16.getAnchorModule().getValidAnchorRecord(f16.getAppRuntime().getCurrentUin());
        if (validAnchorRecord == null) {
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "not anchor record.");
            C(j3, str, "not anchor record.");
            this.f226775m.setValue(Boolean.FALSE);
            return this.f226775m;
        }
        QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "record roomId:" + validAnchorRecord.roomId + " uid:" + validAnchorRecord.uid);
        if (validAnchorRecord.roomId == j3) {
            Q(f16, validAnchorRecord);
        } else {
            QLog.e("QGL.QQGuildLiveAnchorRoomMgr", 1, "record.roomId != resumeRoomId\uff0c don't resume.");
            C(validAnchorRecord.roomId, validAnchorRecord.programId, "record.roomId != resumeRoomId\uff0c don't resume.");
            this.f226775m.setValue(Boolean.FALSE);
        }
        return this.f226775m;
    }

    public void P(boolean z16) {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f226770h;
        if (iQQLiveAnchorRoom != null && (iQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom)) {
            ((IQQLiveAnchorThirdPushRoom) iQQLiveAnchorRoom).getDisplayView().setXYAxis(0);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.d
    public /* synthetic */ void d() {
        com.tencent.mobileqq.guild.live.livemanager.anchor.c.a(this);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
    public boolean disableViewCallback() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f226770h;
        if (iQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom) {
            return ((IQQLiveAnchorThirdPushRoom) iQQLiveAnchorRoom).disableViewCallback();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.d
    public /* synthetic */ void e(int i3, GLiveRoomInfo gLiveRoomInfo, int i16, com.tencent.mobileqq.guild.live.livemanager.anchor.f fVar) {
        com.tencent.mobileqq.guild.live.livemanager.anchor.c.c(this, i3, gLiveRoomInfo, i16, fVar);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
    public boolean enableViewCallback() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f226770h;
        if (iQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom) {
            return ((IQQLiveAnchorThirdPushRoom) iQQLiveAnchorRoom).enableViewCallback();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.d
    public /* synthetic */ void g(int i3) {
        com.tencent.mobileqq.guild.live.livemanager.anchor.c.b(this, i3);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.d
    public IGPSService getService() {
        return (IGPSService) ch.R0(IGPSService.class);
    }

    public void w() {
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 2, "anchorExitRoom.");
        }
        if (this.f226770h != null) {
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "anchorExitRoom start.");
            B();
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "mAnchorRoom.currentState()=" + this.f226770h.currentState());
            l.c("anchor_exit_room_start");
            this.f226770h.exitRoom(new e());
            this.f226767e.setValue(null);
            this.f226774l.setValue(null);
            this.f226765c.setValue(Boolean.FALSE);
            this.f226766d.setValue(0);
            this.f226770h.unRegisterAllAnchorCallback();
            this.f226770h.destroy();
            this.f226770h = null;
            this.f226775m = null;
            this.f226771i = 0L;
            this.f226772j = 0L;
            this.f226764b.t().c();
        }
        h.b(Constants.Business.QQ_GUILD_LIVE_AUTHOR);
    }

    public View x() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f226770h;
        if (iQQLiveAnchorRoom != null) {
            if (iQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom) {
                return ((IQQLiveAnchorThirdPushRoom) iQQLiveAnchorRoom).getDisplayView().getCurrentDisplayView();
            }
            if (iQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom) {
                return ((IQQLiveAnchorTRTCRoom) iQQLiveAnchorRoom).getDisplayView();
            }
            return null;
        }
        return null;
    }

    public LiveData<QQLiveAnchorDataPushInfo> y() {
        if (this.f226770h != null) {
            l.c("anchor_get_room_push_info");
            QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams = new QQLiveAnchorAutoCheckPullPlayParams();
            qQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay = true;
            qQLiveAnchorAutoCheckPullPlayParams.playerRetryCount = 500;
            qQLiveAnchorAutoCheckPullPlayParams.playerRetryInterval = 500L;
            qQLiveAnchorAutoCheckPullPlayParams.definition = EnterRoomInfo.VideoDefinition.FHD;
            IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f226770h;
            if (iQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom) {
                ((IQQLiveAnchorThirdPushRoom) iQQLiveAnchorRoom).getRtmpPushUrl(qQLiveAnchorAutoCheckPullPlayParams);
            }
        }
        return this.f226774l;
    }

    public LiveData<QQLiveAnchorDataPrepare> z(Activity activity) {
        this.f226768f = new MutableLiveData<>();
        D(new b(activity));
        return this.f226768f;
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends QQLiveAnchorRoomThirdPushBaseCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
        public void onEnter(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
            g.this.J(qQLiveAnchorDataEnter);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onError(QQLiveErrorMsg qQLiveErrorMsg) {
            super.onError(qQLiveErrorMsg);
            QLog.e("QGL.QQGuildLiveAnchorRoomMgr", 1, "onError bizErrMsg: " + qQLiveErrorMsg.bizErrMsg + " originErrMsg:" + qQLiveErrorMsg.originErrMsg + " bizErrCode:" + qQLiveErrorMsg.bizErrCode + " bizModule:" + qQLiveErrorMsg.bizModule);
            l.g("anchor_room_error", new HashMap(), qQLiveErrorMsg.originErrCode, qQLiveErrorMsg.toString());
            if (qQLiveErrorMsg.bizErrCode == 6270) {
                aa.a(R.string.f148530zu);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomFastResume
        public void onFastResumeResult(QQLiveAnchorDataFastResume qQLiveAnchorDataFastResume) {
            int i3;
            String qQLiveErrorMsg;
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "onFastResumeResult result:" + qQLiveAnchorDataFastResume.isSuccess + " msg:" + qQLiveAnchorDataFastResume.errorMsg);
            HashMap hashMap = new HashMap();
            if (qQLiveAnchorDataFastResume.isSuccess) {
                i3 = 0;
            } else {
                i3 = 8005;
            }
            QQLiveErrorMsg qQLiveErrorMsg2 = qQLiveAnchorDataFastResume.errorMsg;
            if (qQLiveErrorMsg2 == null) {
                qQLiveErrorMsg = "";
            } else {
                qQLiveErrorMsg = qQLiveErrorMsg2.toString();
            }
            l.g("anchor_fast_resume_room_result", hashMap, i3, qQLiveErrorMsg);
            g.this.K(qQLiveAnchorDataFastResume.isSuccess);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
            super.onGetPullInfo(qQLiveAnchorDataPullInfo);
            if (QLog.isColorLevel()) {
                QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 2, "onGetPullInfo: " + qQLiveAnchorDataPullInfo.isSuccess + " errorMsg:" + qQLiveAnchorDataPullInfo.errorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPushUrl
        public void onGetPushInfo(QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
            super.onGetPushInfo(qQLiveAnchorDataPushInfo);
            if (QLog.isColorLevel()) {
                QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 2, "onGetPushInfo: " + qQLiveAnchorDataPushInfo.isSuccess + " errorMsg:" + qQLiveAnchorDataPushInfo.errorMsg);
            }
            g.this.f226774l.setValue(qQLiveAnchorDataPushInfo);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomInit
        public void onInit(QQLiveAnchorDataInit qQLiveAnchorDataInit) {
            super.onInit(qQLiveAnchorDataInit);
            if (QLog.isColorLevel()) {
                QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 2, "onInit suc: " + qQLiveAnchorDataInit.isSuccess + " errorMsg:" + qQLiveAnchorDataInit.errorMsg);
            }
            if (g.this.f226769g != null) {
                g.this.f226769g.setValue(Boolean.valueOf(qQLiveAnchorDataInit.isSuccess));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomLive
        public void onLiveError(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
            int i3;
            String qQLiveErrorMsg;
            QLog.e("QGL.QQGuildLiveAnchorRoomMgr", 1, "onLiveError isSuccess:" + qQLiveAnchorDataBase.isSuccess + " msg:" + qQLiveAnchorDataBase.errorMsg);
            HashMap hashMap = new HashMap();
            if (qQLiveAnchorDataBase.isSuccess) {
                i3 = 0;
            } else {
                i3 = 8004;
            }
            QQLiveErrorMsg qQLiveErrorMsg2 = qQLiveAnchorDataBase.errorMsg;
            if (qQLiveErrorMsg2 == null) {
                qQLiveErrorMsg = "";
            } else {
                qQLiveErrorMsg = qQLiveErrorMsg2.toString();
            }
            l.g("anchor_room_on_live_error", hashMap, i3, qQLiveErrorMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onPrepare(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            super.onPrepare(qQLiveAnchorDataPrepare);
            g.this.R();
            g.this.f226767e.setValue(qQLiveAnchorDataPrepare);
            if (g.this.f226768f != null) {
                g.this.f226768f.setValue(qQLiveAnchorDataPrepare);
            }
            if (qQLiveAnchorDataPrepare.isSuccess) {
                if (QLog.isColorLevel()) {
                    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 2, "onPrepare suc");
                }
                g gVar = g.this;
                gVar.L(gVar.f226770h);
                g.this.P(false);
                return;
            }
            QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, "onPrepare failed" + qQLiveAnchorDataPrepare.errorMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPublish
        public void onPublishStream(QQLiveAnchorDataPublishStream qQLiveAnchorDataPublishStream) {
            int i3;
            String qQLiveErrorMsg;
            if (qQLiveAnchorDataPublishStream.isSuccess) {
                g.this.f226766d.setValue(2);
            }
            QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, "onPublishStream suc: " + qQLiveAnchorDataPublishStream.isSuccess + "errMsg: " + qQLiveAnchorDataPublishStream.errorMsg);
            if (qQLiveAnchorDataPublishStream.isSuccess) {
                i3 = 0;
            } else {
                i3 = 8003;
            }
            QQLiveErrorMsg qQLiveErrorMsg2 = qQLiveAnchorDataPublishStream.errorMsg;
            if (qQLiveErrorMsg2 == null) {
                qQLiveErrorMsg = "";
            } else {
                qQLiveErrorMsg = qQLiveErrorMsg2.toString();
            }
            l.g("anchor_room_publish_stream_result", new HashMap(), i3, qQLiveErrorMsg);
            if (!qQLiveAnchorDataPublishStream.isSuccess) {
                if (vq1.c.b(g.this.f226777o)) {
                    i3 = MessageHandlerConstants.NOTIFY_TYPE_PC_QQ_SEARCH_MSG_SEND_ERROR_RSP;
                }
                g.this.N(i3, qQLiveErrorMsg);
                g.this.f226777o = 0L;
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onSet(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
            int i3;
            String qQLiveErrorMsg;
            super.onSet(qQLiveAnchorDataSet);
            QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 2, "onSet suc: " + qQLiveAnchorDataSet.isSuccess + "errMsg: " + qQLiveAnchorDataSet.errorMsg);
            if (qQLiveAnchorDataSet.isSuccess) {
                i3 = 0;
            } else {
                i3 = MessageHandlerConstants.NOTIFY_TYPE_SAME_STATE_MSG_SEND_ERROR_RSP;
            }
            QQLiveErrorMsg qQLiveErrorMsg2 = qQLiveAnchorDataSet.errorMsg;
            if (qQLiveErrorMsg2 == null) {
                qQLiveErrorMsg = "";
            } else {
                qQLiveErrorMsg = qQLiveErrorMsg2.toString();
            }
            l.g("anchor_sdk_set_room_info_result", new HashMap(), i3, qQLiveErrorMsg);
            l.c("anchor_enter_room_start");
            g.this.f226776n = System.currentTimeMillis();
            g.this.f226770h.enterRoom();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onStateChange(QQLiveAnchorRoomState qQLiveAnchorRoomState, QQLiveAnchorRoomState qQLiveAnchorRoomState2) {
            super.onStateChange(qQLiveAnchorRoomState, qQLiveAnchorRoomState2);
            if (QLog.isColorLevel()) {
                QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 2, "onStateChange oldState: " + qQLiveAnchorRoomState + " newState: " + qQLiveAnchorRoomState2);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
            super.onThirdPushChecked(qQLiveAnchorDataThirdPushCheck);
            if (QLog.isColorLevel()) {
                QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 2, "onThirdPushChecked isSuccess:" + qQLiveAnchorDataThirdPushCheck.isSuccess + " errorMsg: " + qQLiveAnchorDataThirdPushCheck.errorMsg);
            }
            g.this.f226765c.setValue(Boolean.valueOf(qQLiveAnchorDataThirdPushCheck.isSuccess));
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomExit
        public void onExit() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorLiveStatusCallBack
        public void onAnchorLiveNetStatus(AnchorLiveSystemInfo anchorLiveSystemInfo) {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onEvent(QQLiveEventMsg qQLiveEventMsg) {
        }
    }
}
