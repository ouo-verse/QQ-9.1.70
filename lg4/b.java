package lg4;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorObsRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataConfigInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.common.QQLiveEventMsg;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.report.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.timi.game.component.qqlive.impl.anchor.QQLiveEndLiveEventByAdmin;
import com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import jg4.e;
import jg4.f;
import jg4.g;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: p, reason: collision with root package name */
    private static volatile b f414552p;

    /* renamed from: a, reason: collision with root package name */
    public MutableLiveData<Boolean> f414553a;

    /* renamed from: b, reason: collision with root package name */
    public MutableLiveData<QQLiveAnchorDataPublishStream> f414554b;

    /* renamed from: c, reason: collision with root package name */
    private IQQLiveAnchorRoom f414555c;

    /* renamed from: d, reason: collision with root package name */
    private final cl4.a f414556d;

    /* renamed from: e, reason: collision with root package name */
    private MutableLiveData<Boolean> f414557e;

    /* renamed from: f, reason: collision with root package name */
    private MutableLiveData<QQLiveAnchorDataPrepare> f414558f;

    /* renamed from: g, reason: collision with root package name */
    private MutableLiveData<Boolean> f414559g;

    /* renamed from: h, reason: collision with root package name */
    private MutableLiveData<QQLiveAnchorDataPushInfo> f414560h;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<Boolean> f414561i;

    /* renamed from: j, reason: collision with root package name */
    private final MutableLiveData<QQLiveAnchorDataConfigInfo> f414562j;

    /* renamed from: k, reason: collision with root package name */
    private g f414563k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f414564l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f414565m;

    /* renamed from: n, reason: collision with root package name */
    private qg4.a f414566n;

    /* renamed from: o, reason: collision with root package name */
    private IQQLiveAnchorRoomCallback f414567o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: lg4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C10723b implements IResultListener<EndPageRealTimeInfo> {
        C10723b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable EndPageRealTimeInfo endPageRealTimeInfo) {
            SimpleEventBus.getInstance().dispatchEvent(new QQLiveEndLiveEventByAdmin(endPageRealTimeInfo, ""));
            b.this.V();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            SimpleEventBus.getInstance().dispatchEvent(new QQLiveEndLiveEventByAdmin(new EndPageRealTimeInfo(), ""));
            b.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements ExitRoomCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f414570a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IQQLiveAnchorRoom f414571b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IResultListener f414572c;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<EndPageRealTimeInfo> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo) {
                IResultListener iResultListener = c.this.f414572c;
                if (iResultListener != null) {
                    iResultListener.onSuccess(endPageRealTimeInfo);
                }
                c cVar = c.this;
                b.this.B(cVar.f414571b);
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                IResultListener iResultListener = c.this.f414572c;
                if (iResultListener != null) {
                    iResultListener.onError(i3, str);
                }
                c cVar = c.this;
                b.this.B(cVar.f414571b);
            }
        }

        c(long j3, IQQLiveAnchorRoom iQQLiveAnchorRoom, IResultListener iResultListener) {
            this.f414570a = j3;
            this.f414571b = iQQLiveAnchorRoom;
            this.f414572c = iResultListener;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
        public void onComplete(int i3, String str) {
            h.c(QQLiveBusinessConfig.QQLIVE_APP_ID, QQLiveReportConstants.Event.E_EXIT_LIVE, QQLiveReportConstants.Scene.SCENE_START_QQ_LIVE, i3 + "");
            l.h("TgLiveTag_TgLiveAnchorRoomManager", 1, "anchorExitRoom_" + this.f414570a + ", onComplete " + i3 + "" + str);
            pg4.b.n(this.f414571b, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorRecord f414575a;

        d(QQLiveAnchorRecord qQLiveAnchorRecord) {
            this.f414575a = qQLiveAnchorRecord;
        }

        @Override // jg4.f
        public void a() {
            l.i("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan checkPermission success");
            b.this.C(this.f414575a);
        }

        @Override // jg4.f
        public void b(String[] strArr) {
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan onCheckFail - " + strArr);
            if (b.this.f414563k != null) {
                b.this.f414563k.l(-1000, "\u9700\u8981\u786e\u8ba4\u6388\u6743\u624d\u80fd\u6b63\u5e38\u5f00\u64ad\u54e6");
                b.this.x(1, -1000, "\u9700\u8981\u786e\u8ba4\u6388\u6743\u624d\u80fd\u6b63\u5e38\u5f00\u64ad\u54e6");
            }
        }

        @Override // jg4.f
        public void onError(int i3, String str) {
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan onError errorCode = " + i3 + " - " + str);
            if (b.this.f414563k != null) {
                b.this.f414563k.l(i3, str);
                b.this.x(1, i3, str);
            }
        }
    }

    b() {
        Boolean bool = Boolean.FALSE;
        this.f414553a = new MutableLiveData<>(bool);
        this.f414554b = new MutableLiveData<>(null);
        this.f414556d = new cl4.a();
        this.f414557e = new MutableLiveData<>(bool);
        this.f414558f = new MutableLiveData<>(null);
        this.f414559g = new MutableLiveData<>(bool);
        this.f414560h = new MutableLiveData<>(null);
        this.f414562j = new MutableLiveData<>(new QQLiveAnchorDataConfigInfo());
        this.f414564l = false;
        this.f414565m = false;
        this.f414567o = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(IQQLiveAnchorRoom iQQLiveAnchorRoom) {
        if (iQQLiveAnchorRoom != null) {
            IQQLiveSDK m3 = pg4.b.l().m();
            if (m3 != null && iQQLiveAnchorRoom == m3.getAnchorModule().getCurRoom()) {
                l.h("TgLiveTag_TgLiveAnchorRoomManager", 1, "getAnchorModule().destroyRoom");
                m3.getAnchorModule().destroyRoom();
            } else {
                l.h("TgLiveTag_TgLiveAnchorRoomManager", 1, "direct destroy");
                iQQLiveAnchorRoom.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(QQLiveAnchorRecord qQLiveAnchorRecord) {
        IQQLiveSDK m3 = pg4.b.l().m();
        IQQLiveAnchorRoom createFastResumeRoom = m3.getAnchorModule().createFastResumeRoom(qQLiveAnchorRecord, this.f414567o);
        this.f414555c = createFastResumeRoom;
        createFastResumeRoom.registerAnchorCallback(this.f414567o);
        pg4.c.e(this.f414555c);
        U(true);
        pg4.d.b().g(u());
        this.f414555c.init(m3);
        this.f414555c.fastResume();
        l.i("TgLiveTag_TgLiveAnchorRoomManager", "finallyResumeLiveRoom END - " + qQLiveAnchorRecord.roomId + "_" + qQLiveAnchorRecord.streamType);
    }

    public static b E() {
        if (f414552p == null) {
            synchronized (b.class) {
                if (f414552p == null) {
                    f414552p = new b();
                }
            }
        }
        return f414552p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
        Object obj;
        long j3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleOnEnterResult, enterResult.isSuccess = ");
        sb5.append(qQLiveAnchorDataEnter.isSuccess);
        sb5.append(", anchorRoomId = ");
        Object obj2 = 0;
        if (qQLiveAnchorDataEnter.roomInfo != null) {
            obj = qQLiveAnchorDataEnter.roomInfo.getRoomId() + "_" + qQLiveAnchorDataEnter.roomInfo.name;
        } else {
            obj = obj2;
        }
        sb5.append(obj);
        sb5.append(", anchorUid = ");
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo = qQLiveAnchorDataEnter.userInfo;
        if (qQLiveAnchorDataUserInfo != null) {
            j3 = qQLiveAnchorDataUserInfo.f271213id;
        } else {
            j3 = 0;
        }
        sb5.append(LogUtil.wrapLogUin(String.valueOf(j3)));
        sb5.append(", bizId = ");
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo2 = qQLiveAnchorDataEnter.userInfo;
        if (qQLiveAnchorDataUserInfo2 != null) {
            obj2 = qQLiveAnchorDataUserInfo2.businessUid;
        }
        sb5.append(obj2);
        sb5.append(", errorMsg = ");
        sb5.append(qQLiveAnchorDataEnter.errorMsg);
        l.i("TgLiveTag_TgLiveAnchorRoomManager", sb5.toString());
        g gVar = this.f414563k;
        if (gVar != null) {
            gVar.e(qQLiveAnchorDataEnter.isSuccess, qQLiveAnchorDataEnter);
            if (!qQLiveAnchorDataEnter.isSuccess) {
                g gVar2 = this.f414563k;
                QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataEnter.errorMsg;
                gVar2.c(5, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
            }
        }
        if (qQLiveAnchorDataEnter.isSuccess) {
            pg4.d b16 = pg4.d.b();
            b16.f(Boolean.TRUE);
            QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = qQLiveAnchorDataEnter.roomInfo;
            if (qQLiveAnchorDataRoomInfo != null && TextUtils.isEmpty(qQLiveAnchorDataRoomInfo.coverUrl16v9)) {
                QLog.i("TgLiveTag_TgLiveAnchorRoomManager", 1, "update roomInfo.");
                b16.i(qQLiveAnchorDataEnter.roomInfo.coverUrl16v9);
            }
            IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f414555c;
            if (iQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom) {
                this.f414566n = new qg4.a((IQQLiveAnchorTRTCRoom) iQQLiveAnchorRoom);
            }
            if (this.f414555c != null) {
                g gVar3 = this.f414563k;
                if (gVar3 != null) {
                    gVar3.f();
                }
                this.f414555c.startPublishStream();
            }
            QQLiveAnchorDataConfigInfo qQLiveAnchorDataConfigInfo = qQLiveAnchorDataEnter.configInfo;
            if (qQLiveAnchorDataConfigInfo != null) {
                this.f414562j.setValue(qQLiveAnchorDataConfigInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(QQLiveAnchorDataFastResume qQLiveAnchorDataFastResume) {
        MutableLiveData<Boolean> mutableLiveData;
        if (this.f414555c != null) {
            if (qQLiveAnchorDataFastResume.isSuccess) {
                pg4.d b16 = pg4.d.b();
                Boolean bool = Boolean.TRUE;
                b16.f(bool);
                b16.j(bool);
            } else {
                com.tencent.timi.game.ui.widget.f.c("\u6062\u590d\u76f4\u64ad\u5931\u8d25");
                R();
                qg4.g.c(true);
            }
        }
        if (this.f414555c != null && (mutableLiveData = this.f414561i) != null) {
            mutableLiveData.setValue(Boolean.valueOf(qQLiveAnchorDataFastResume.isSuccess));
        }
        g gVar = this.f414563k;
        if (gVar != null) {
            if (!qQLiveAnchorDataFastResume.isSuccess) {
                QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataFastResume.errorMsg;
                gVar.c(11, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
            } else {
                y(qQLiveAnchorDataFastResume, u());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        TGLiveFloatManager.f377649d.l();
        E().t(new C10723b());
    }

    private void L() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f414555c;
        if (iQQLiveAnchorRoom == null) {
            l.c("TgLiveTag_TgLiveAnchorRoomManager", 1, "initTimiPushService failed, liveRoom is null!");
        } else {
            this.f414556d.e(iQQLiveAnchorRoom);
        }
    }

    private boolean M(IQQLiveAnchorRoom iQQLiveAnchorRoom) {
        if (iQQLiveAnchorRoom != null && (iQQLiveAnchorRoom.currentState() == QQLiveAnchorRoomState.STATE_CREATE || iQQLiveAnchorRoom.currentState() == QQLiveAnchorRoomState.STATE_INIT_READY)) {
            return true;
        }
        return false;
    }

    private void Q() {
        this.f414556d.d();
    }

    private void R() {
        boolean p16 = pg4.b.l().p();
        IQQLiveSDK m3 = pg4.b.l().m();
        if (p16 && m3 != null) {
            m3.getAnchorModule().removeAnchorRecord(m3.getAppRuntime().getCurrentUin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        int i3;
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "showScreenCapturePauseDialog fail! MobileQQ.context is null...");
            return;
        }
        int i16 = Build.VERSION.SDK_INT;
        if (!((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(context)) {
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "showScreenCapturePauseDialog fail! permission miss ...");
            com.tencent.timi.game.ui.widget.f.c("\u5f55\u5c4f\u6743\u9650\u88ab\u5360\u7528\uff0c\u8bf7\u91cd\u65b0\u5f00\u64ad");
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, "\u5f00\u64ad\u63d0\u793a", "\u4f60\u5f53\u524d\u7684\u5f55\u5c4f\u6743\u9650\u5df2\u88ab\u5360\u7528\uff0c\u76f4\u64ad\u753b\u9762\u5c06\u88ab\u5361\u4f4f\uff0c\u8bf7\u5173\u95ed\u5176\u4ed6\u5360\u7528\u6743\u9650\u7684app\u6216\u76f8\u5173\u8bbe\u7f6e\u540e\u91cd\u65b0\u5f00\u64ad\u3002\u5982\u679c\u5f00\u64ad\u738b\u8005\u8363\u8000\uff0c\u8bf7\u5173\u95ed\u6e38\u620f\u5185\u738b\u8005\u65f6\u523b\u3001\u638c\u4e0a\u738b\u8005\u8363\u8000\u7b49", (String) null, "\u91cd\u65b0\u5f00\u64ad", new DialogInterface.OnClickListener() { // from class: lg4.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i17) {
                dialogInterface.dismiss();
            }
        }, (DialogInterface.OnClickListener) null);
        Window window = createCustomDialog.getWindow();
        if (i16 >= 26) {
            i3 = 2038;
        } else {
            i3 = 2003;
        }
        window.setType(i3);
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
        l.e("TgLiveTag_TgLiveAnchorRoomManager", "showScreenCapturePauseDialog success, show screenCapture pause dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3, int i16, String str) {
        g gVar = this.f414563k;
        if (gVar != null) {
            gVar.c(i3, i16, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(QQLiveAnchorDataBase qQLiveAnchorDataBase, View view) {
        l.i("TgLiveTag_TgLiveAnchorRoomManager", "callFinalLiveStreamResultSuccess - " + this.f414563k);
        g gVar = this.f414563k;
        if (gVar != null) {
            gVar.i(qQLiveAnchorDataBase.isSuccess, qQLiveAnchorDataBase, view);
            this.f414563k = null;
        }
    }

    private boolean z(IQQLiveSDK iQQLiveSDK) {
        if (iQQLiveSDK != null && pg4.b.l().p()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TgLiveTag_TgLiveAnchorRoomManager", 1, "anchorCreateRoom, live sdk not init suc.");
        }
        g gVar = this.f414563k;
        if (gVar != null) {
            gVar.j(false, null);
            this.f414563k.c(3, -1, "SDK\u5c1a\u672a\u521d\u59cb\u5316");
        }
        return true;
    }

    public void A(g gVar) {
        if (gVar != null) {
            if (this.f414563k != null) {
                l.e("TgLiveTag_TgLiveAnchorRoomManager", "anchorCreateRoom but already has mAnchorStartListener!! old = " + this.f414563k + ", new = " + gVar);
            }
            this.f414563k = gVar;
            gVar.b();
        }
    }

    public void D(long j3, String str) {
        IQQLiveSDK m3;
        l.i("TgLiveTag_TgLiveAnchorRoomManager", "forceExitLiveRoom - " + j3 + " - " + str);
        if (j3 > 0 && (m3 = pg4.b.l().m()) != null) {
            int tryCloseIsolatedRoom = m3.getAnchorModule().tryCloseIsolatedRoom(j3, str);
            QLog.i("TgLiveTag_TgLiveAnchorRoomManager", 1, "forceExitLiveRoom. resultCode=" + tryCloseIsolatedRoom);
            if (tryCloseIsolatedRoom == 0) {
                com.tencent.timi.game.ui.widget.f.c("\u5f3a\u9000\u623f\u95f4\u6210\u529f");
            }
        }
    }

    public MutableLiveData<QQLiveAnchorDataConfigInfo> F() {
        return this.f414562j;
    }

    public IQQLiveAnchorRoom G() {
        return this.f414555c;
    }

    @NotNull
    public al4.a H() {
        return this.f414556d;
    }

    public void O(int i3, int i16) {
        IQQLiveAnchorRoom iQQLiveAnchorRoom;
        l.i("TgLiveTag_TgLiveAnchorRoomManager", "notifyOnVideoSizeChanged width_" + i3 + " height_" + i16 + ", mHasThirdPushChecked = " + this.f414565m);
        if (!this.f414565m) {
            if ((i3 > 0 || i16 > 0) && (iQQLiveAnchorRoom = this.f414555c) != null) {
                if (iQQLiveAnchorRoom.getRoomConfig().streamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH || this.f414555c.getRoomConfig().streamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST) {
                    this.f414565m = true;
                    l.e("TgLiveTag_TgLiveAnchorRoomManager", "notifyOnVideoSizeChanged tmp code");
                    g gVar = this.f414563k;
                    if (gVar != null) {
                        gVar.h();
                    }
                    this.f414555c.enterRoom();
                }
            }
        }
    }

    public void P() {
        l.h("TgLiveTag_TgLiveAnchorRoomManager", 1, "onAnchorEnterRoom");
        L();
    }

    public LiveData<Boolean> S(long j3, String str, e eVar) {
        l.i("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan resumeRoomId = " + j3 + ", programId = " + str);
        if (eVar != null) {
            if (this.f414563k != null) {
                l.e("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan but already has mAnchorStartListener!! old = " + this.f414563k + ", new = " + eVar);
            }
            this.f414563k = eVar;
        }
        if (this.f414555c != null) {
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan but mAnchorRoom has been create --- " + this.f414555c);
        }
        this.f414561i = new ko4.a();
        if (!pg4.b.l().p()) {
            QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "resumeRoomIfCan, sdk not init suc.");
            this.f414561i.setValue(Boolean.FALSE);
            x(11, -1, "SDK\u5c1a\u672a\u521d\u59cb\u5316");
            return this.f414561i;
        }
        IQQLiveSDK m3 = pg4.b.l().m();
        QQLiveAnchorRecord validAnchorRecord = m3.getAnchorModule().getValidAnchorRecord(m3.getAppRuntime().getCurrentUin());
        if (validAnchorRecord == null) {
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan no anchor record");
            D(j3, str);
            this.f414561i.setValue(Boolean.FALSE);
            x(11, -2, "\u6ca1\u6709\u53ef\u590d\u64ad\u7684\u623f\u95f4");
        } else {
            l.i("TgLiveTag_TgLiveAnchorRoomManager", "record roomId:" + validAnchorRecord.roomId + " uid:" + validAnchorRecord.uid);
            if (j3 > 0 && j3 != validAnchorRecord.roomId) {
                l.e("TgLiveTag_TgLiveAnchorRoomManager", "record.roomId != resumeRoomId\uff0c don't resume.");
                D(validAnchorRecord.roomId, validAnchorRecord.programId);
                this.f414561i.setValue(Boolean.FALSE);
                x(11, -3, "\u590d\u64ad\u5931\u8d25, \u623f\u95f4\u4fe1\u606f\u4e0d\u4e00\u81f4");
            } else if (!qg4.g.h(true)) {
                l.e("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan requestAVFocus failure.");
                this.f414561i.setValue(Boolean.FALSE);
                x(1, -4, "\u5f53\u524d\u97f3\u89c6\u9891\u88ab\u5360\u7528");
            } else {
                qg4.g.g(validAnchorRecord.streamType, new d(validAnchorRecord));
            }
        }
        return this.f414561i;
    }

    public void T(boolean z16) {
        qg4.a aVar = this.f414566n;
        if (aVar != null) {
            aVar.f(z16);
        }
    }

    public void U(boolean z16) {
        l.i("TgLiveTag_TgLiveAnchorRoomManager", "setVideoScaleFullScreen " + z16 + ", " + this.f414555c);
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f414555c;
        if (iQQLiveAnchorRoom != null) {
            if (iQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom) {
                ((IQQLiveAnchorTRTCRoom) iQQLiveAnchorRoom).getDisplayView();
            } else if (iQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom) {
                ((IQQLiveAnchorThirdPushRoom) iQQLiveAnchorRoom).getDisplayView().setXYAxis(0);
            }
        }
    }

    public LiveData<Boolean> s(QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType, boolean z16, g gVar) {
        l.i("TgLiveTag_TgLiveAnchorRoomManager", "anchorCreateRoom - " + qQLiveAnchorStreamRecordType);
        A(gVar);
        if (this.f414555c != null) {
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "anchorCreateRoom but mAnchorRoom has been create --- " + this.f414555c);
        }
        IQQLiveSDK m3 = pg4.b.l().m();
        if (z(m3)) {
            return this.f414557e;
        }
        IQQLiveAnchorRoom curRoom = m3.getAnchorModule().getCurRoom();
        if (curRoom != null && this.f414555c == null) {
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "anchorCreateRoom  but already has sdk cache --- " + curRoom + ", state = " + curRoom.currentState());
        }
        this.f414564l = z16;
        if (z16 && M(curRoom)) {
            QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "use prepared room");
            this.f414555c = curRoom;
            curRoom.registerAnchorCallback(this.f414567o);
        } else {
            QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "create new room");
            QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig = new QQLiveAnchorRoomConfig();
            qQLiveAnchorRoomConfig.streamRecordType = qQLiveAnchorStreamRecordType;
            this.f414555c = m3.getAnchorModule().createRoom(vf4.a.b(), qQLiveAnchorRoomConfig, this.f414567o);
        }
        this.f414555c.init(m3);
        return this.f414557e;
    }

    public LiveData<Boolean> t(IResultListener<EndPageRealTimeInfo> iResultListener) {
        QLog.i("TgLiveTag_TgLiveAnchorRoomManager", 1, "anchorExitRoom.");
        this.f414564l = false;
        this.f414565m = false;
        this.f414563k = null;
        Q();
        if (this.f414555c != null) {
            pg4.c.f();
            long roomId = this.f414555c.getRoomInfo().getRoomId();
            IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f414555c;
            iQQLiveAnchorRoom.exitRoom(new c(roomId, iQQLiveAnchorRoom, iResultListener));
            MutableLiveData<Boolean> mutableLiveData = this.f414557e;
            Boolean bool = Boolean.FALSE;
            mutableLiveData.setValue(bool);
            this.f414558f.setValue(null);
            this.f414560h.setValue(null);
            this.f414553a.setValue(bool);
            this.f414554b.setValue(null);
            this.f414555c = null;
            this.f414561i = null;
            pg4.d.b().a();
        } else if (iResultListener != null) {
            iResultListener.onError(-1000, "\u6570\u636e\u5f02\u5e38");
        }
        qg4.g.c(true);
        qg4.a aVar = this.f414566n;
        if (aVar != null) {
            aVar.b();
        }
        return this.f414559g;
    }

    public View u() {
        ITPPlayerVideoView displayView;
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f414555c;
        if (iQQLiveAnchorRoom == null) {
            return null;
        }
        if (iQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom) {
            return ((IQQLiveAnchorTRTCRoom) iQQLiveAnchorRoom).getDisplayView();
        }
        if (!(iQQLiveAnchorRoom instanceof ILiveTPPlayerRoom) || (displayView = ((ILiveTPPlayerRoom) iQQLiveAnchorRoom).getDisplayView()) == null) {
            return null;
        }
        return displayView.getCurrentDisplayView();
    }

    public LiveData<QQLiveAnchorDataPrepare> v(Activity activity) {
        g gVar = this.f414563k;
        if (gVar != null) {
            gVar.a();
        }
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f414555c;
        iQQLiveAnchorRoom.prepare(activity, iQQLiveAnchorRoom.getAuthExt(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID));
        pg4.c.e(this.f414555c);
        U(false);
        return this.f414558f;
    }

    public void w(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f414555c;
        if (iQQLiveAnchorRoom == null) {
            l.i("TgLiveTag_TgLiveAnchorRoomManager", "ensureInitAnchorRoom room is null");
            return;
        }
        if (iQQLiveAnchorRoom instanceof IQQLiveAnchorObsRoom) {
            iQQLiveAnchorRoom.setAnchorRoomInfo(qQLiveAnchorRoomInfo);
            this.f414555c.recordRoomInfo();
            ((IQQLiveAnchorObsRoom) this.f414555c).reconnectObsRoom();
            y(new QQLiveAnchorDataPublishStream(true, null), u());
            return;
        }
        l.i("TgLiveTag_TgLiveAnchorRoomManager", "ensureInitAnchorRoom invalid room");
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a extends QQLiveAnchorRoomThirdPushBaseCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
        public void onEnter(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
            b.this.I(qQLiveAnchorDataEnter);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
        public void onEnterRoom() {
            b.this.P();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onError(QQLiveErrorMsg qQLiveErrorMsg) {
            super.onError(qQLiveErrorMsg);
            QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 2, "onError bizErrMsg: " + qQLiveErrorMsg.bizErrMsg + " originErrMsg:" + qQLiveErrorMsg.bizErrMsg + " bizErrCode:" + qQLiveErrorMsg.bizErrCode + " bizModule:" + qQLiveErrorMsg.bizModule);
            if (qQLiveErrorMsg.bizErrCode == 6270) {
                com.tencent.timi.game.ui.widget.f.c("\u7b2c\u4e09\u65b9\u63a8\u6d41\u5931\u8d25");
            }
            if (qQLiveErrorMsg.bizErrCode == 6107) {
                b.this.K();
            }
            if (b.this.f414563k != null) {
                b.this.f414563k.c(9, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomExit
        public void onExit() {
            b.this.f414559g.setValue(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomFastResume
        public void onFastResumeResult(QQLiveAnchorDataFastResume qQLiveAnchorDataFastResume) {
            QLog.i("TgLiveTag_TgLiveAnchorRoomManager", 1, "onFastResumeResult result:" + qQLiveAnchorDataFastResume.isSuccess + " msg:" + qQLiveAnchorDataFastResume.errorMsg);
            b.this.J(qQLiveAnchorDataFastResume);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
            super.onGetPullInfo(qQLiveAnchorDataPullInfo);
            l.i("TgLiveTag_TgLiveAnchorRoomManager", "onGetPullInfo: " + qQLiveAnchorDataPullInfo.isSuccess + " errorMsg:" + qQLiveAnchorDataPullInfo.errorMsg + " - " + qQLiveAnchorDataPullInfo.defaultPlayUrl);
            if (b.this.f414563k != null) {
                b.this.f414563k.onGetPullInfo(qQLiveAnchorDataPullInfo);
            }
            if (qQLiveAnchorDataPullInfo.isSuccess) {
                TextUtils.isEmpty(qQLiveAnchorDataPullInfo.defaultPlayUrl);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPushUrl
        public void onGetPushInfo(QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
            super.onGetPushInfo(qQLiveAnchorDataPushInfo);
            l.i("TgLiveTag_TgLiveAnchorRoomManager", "onGetPushInfo: " + qQLiveAnchorDataPushInfo.isSuccess + " errorMsg:" + qQLiveAnchorDataPushInfo.errorMsg);
            b.this.f414560h.setValue(qQLiveAnchorDataPushInfo);
            if (b.this.f414563k != null) {
                b.this.f414563k.d(qQLiveAnchorDataPushInfo.isSuccess, qQLiveAnchorDataPushInfo, qQLiveAnchorDataPushInfo.serverPart, qQLiveAnchorDataPushInfo.streamParam);
                if (!qQLiveAnchorDataPushInfo.isSuccess) {
                    g gVar = b.this.f414563k;
                    QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataPushInfo.errorMsg;
                    gVar.c(6, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
                }
            }
            if (qQLiveAnchorDataPushInfo.isSuccess) {
                l.i("TgLiveTag_TgLiveAnchorRoomManager", "onGetPushInfo: rtmpUrl= " + qQLiveAnchorDataPushInfo.serverPart + ", rtmpKey = " + qQLiveAnchorDataPushInfo.streamParam + ", expireTs = " + qQLiveAnchorDataPushInfo.expireTs);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomInit
        public void onInit(QQLiveAnchorDataInit qQLiveAnchorDataInit) {
            super.onInit(qQLiveAnchorDataInit);
            QLog.d("TgLiveTag_TgLiveAnchorRoomManager", 2, "onInit suc: " + qQLiveAnchorDataInit.isSuccess + " errorMsg:" + qQLiveAnchorDataInit.errorMsg);
            b.this.f414557e.setValue(Boolean.valueOf(qQLiveAnchorDataInit.isSuccess));
            if (b.this.f414563k != null) {
                b.this.f414563k.j(qQLiveAnchorDataInit.isSuccess, qQLiveAnchorDataInit);
                if (!qQLiveAnchorDataInit.isSuccess) {
                    g gVar = b.this.f414563k;
                    QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataInit.errorMsg;
                    gVar.c(3, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomLive
        public void onLiveError(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
            QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "onLiveError isSuccess:" + qQLiveAnchorDataBase.isSuccess + " msg:" + qQLiveAnchorDataBase.errorMsg);
            if (b.this.f414563k != null) {
                g gVar = b.this.f414563k;
                QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataBase.errorMsg;
                gVar.c(10, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onPrepare(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            super.onPrepare(qQLiveAnchorDataPrepare);
            b.this.f414558f.setValue(qQLiveAnchorDataPrepare);
            if (b.this.f414563k != null) {
                b.this.f414563k.g(qQLiveAnchorDataPrepare.isSuccess, qQLiveAnchorDataPrepare);
                if (!qQLiveAnchorDataPrepare.isSuccess) {
                    g gVar = b.this.f414563k;
                    QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataPrepare.errorMsg;
                    gVar.c(4, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
                }
            }
            if (qQLiveAnchorDataPrepare.isSuccess) {
                l.i("TgLiveTag_TgLiveAnchorRoomManager", "onPrepare success, roomId = " + qQLiveAnchorDataPrepare.roomAttr.roomId + " " + qQLiveAnchorDataPrepare.roomAttr.roomName);
                if (b.this.f414555c != null) {
                    pg4.d.b().i(qQLiveAnchorDataPrepare.roomAttr.poster16v9);
                    QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType = b.this.f414555c.getRoomConfig().streamRecordType;
                    if (qQLiveAnchorStreamRecordType != QQLiveAnchorStreamRecordType.SCREEN && (!b.this.f414564l || qQLiveAnchorStreamRecordType != QQLiveAnchorStreamRecordType.THIRD_PUSH)) {
                        if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH) {
                            QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams = new QQLiveAnchorAutoCheckPullPlayParams();
                            qQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay = true;
                            ((IQQLiveAnchorThirdPushRoom) b.this.f414555c).getRtmpPushUrl(qQLiveAnchorAutoCheckPullPlayParams);
                            return;
                        } else {
                            if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST) {
                                l.i("TgLiveTag_TgLiveAnchorRoomManager", "onPrepare success, onEnterRoomStart");
                                if (b.this.f414563k != null) {
                                    b.this.f414563k.h();
                                }
                                b.this.f414555c.enterRoom();
                                return;
                            }
                            return;
                        }
                    }
                    l.i("TgLiveTag_TgLiveAnchorRoomManager", "onPrepare success, onEnterRoomStart");
                    if (b.this.f414563k != null) {
                        b.this.f414563k.h();
                    }
                    b.this.f414555c.enterRoom();
                    return;
                }
                return;
            }
            l.e("TgLiveTag_TgLiveAnchorRoomManager", "onPrepare failed - " + qQLiveAnchorDataPrepare.errorMsg);
            com.tencent.timi.game.ui.widget.f.c(qQLiveAnchorDataPrepare.errorMsg.bizErrMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPublish
        public void onPublishStream(QQLiveAnchorDataPublishStream qQLiveAnchorDataPublishStream) {
            b.this.f414554b.setValue(qQLiveAnchorDataPublishStream);
            QLog.d("TgLiveTag_TgLiveAnchorRoomManager", 2, "onPublishStream suc: " + qQLiveAnchorDataPublishStream.isSuccess + "errMsg: " + qQLiveAnchorDataPublishStream.errorMsg);
            pg4.d.b().j(Boolean.TRUE);
            View u16 = b.this.u();
            pg4.d.b().g(u16);
            if (b.this.f414563k != null) {
                if (!qQLiveAnchorDataPublishStream.isSuccess) {
                    g gVar = b.this.f414563k;
                    QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataPublishStream.errorMsg;
                    gVar.c(8, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
                    return;
                }
                b.this.y(qQLiveAnchorDataPublishStream, u16);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomRemote
        public void onRemoteUserEnterRoom(String str) {
            QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "onRemoteUserEnterRoom" + str);
            if (b.this.f414555c != null && (b.this.f414555c instanceof IQQLiveAnchorTRTCRoom) && b.this.f414566n != null) {
                b.this.f414566n.a(b.this.f414555c.getRoomInfo().getRoomId(), str);
                boolean b16 = ((jg4.b) mm4.b.b(jg4.b.class)).s().b();
                boolean muteAllUser = b.this.f414555c.getRoomConfig().bizData.getMuteAllUser();
                if (b16 && muteAllUser) {
                    ((IQQLiveAnchorTRTCRoom) b.this.f414555c).muteAllRemoteAudio(true);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomRemote
        public void onRemoteUserLeaveRoom(String str, int i3) {
            QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "onRemoteUserLeaveRoom" + str + " " + i3);
            if (b.this.f414555c != null && (b.this.f414555c instanceof IQQLiveAnchorTRTCRoom) && b.this.f414566n != null) {
                b.this.f414566n.e(b.this.f414555c.getRoomInfo().getRoomId(), str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onSet(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
            super.onSet(qQLiveAnchorDataSet);
            l.i("TgLiveTag_TgLiveAnchorRoomManager", "onSetRoomInfo suc: " + qQLiveAnchorDataSet.isSuccess + "errMsg: " + qQLiveAnchorDataSet.errorMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
            super.onThirdPushChecked(qQLiveAnchorDataThirdPushCheck);
            QLog.d("TgLiveTag_TgLiveAnchorRoomManager", 2, "onThirdPushChecked isSuccess:" + qQLiveAnchorDataThirdPushCheck.isSuccess + " errorMsg: " + qQLiveAnchorDataThirdPushCheck.errorMsg);
            b.this.f414553a.setValue(Boolean.valueOf(qQLiveAnchorDataThirdPushCheck.isSuccess));
            b.this.f414565m = true;
            if (b.this.f414563k != null) {
                b.this.f414563k.onThirdPushChecked(qQLiveAnchorDataThirdPushCheck);
                if (!qQLiveAnchorDataThirdPushCheck.isSuccess) {
                    g gVar = b.this.f414563k;
                    QQLiveErrorMsg qQLiveErrorMsg = qQLiveAnchorDataThirdPushCheck.errorMsg;
                    gVar.c(7, qQLiveErrorMsg.bizErrCode, qQLiveErrorMsg.bizErrMsg);
                }
            }
            if (qQLiveAnchorDataThirdPushCheck.isSuccess && b.this.f414555c != null && b.this.f414555c.getRoomConfig().streamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH) {
                if (b.this.f414563k != null) {
                    b.this.f414563k.h();
                }
                b.this.f414555c.enterRoom();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorLiveStatusCallBack
        public void onAnchorLiveNetStatus(AnchorLiveSystemInfo anchorLiveSystemInfo) {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
        public void onEvent(QQLiveEventMsg qQLiveEventMsg) {
        }
    }
}
