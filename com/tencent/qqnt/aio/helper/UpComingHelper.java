package com.tencent.qqnt.aio.helper;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/aio/helper/UpComingHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Landroid/os/Handler$Callback;", "Lcom/tencent/aio/api/help/b;", "", "uin", "", "p", ReportConstant.COSTREPORT_PREFIX, "", "getId", "getTag", "state", "onMoveToState", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", tl.h.F, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "i", "Landroid/os/Message;", "msg", "", "handleMessage", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/app/QQAppInterface;", "e", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "f", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "mSessionInfo", "", "J", "scrollToSeq", "Lmqq/os/MqqHandler;", "Lmqq/os/MqqHandler;", "mUIHandler", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "scrollToMsg", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mProgressDialog", "<init>", "()V", "D", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class UpComingHelper implements com.tencent.aio.main.businesshelper.h, Handler.Callback, com.tencent.aio.api.help.b {

    /* renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Boolean> E;

    /* renamed from: C, reason: from kotlin metadata */
    private QQProgressDialog mProgressDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQAppInterface app;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SessionInfo mSessionInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long scrollToSeq = -1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MqqHandler mUIHandler = new MqqHandler(Looper.getMainLooper(), this);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MsgRecord scrollToMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/helper/UpComingHelper$a;", "", "", "createAsyncSwitch$delegate", "Lkotlin/Lazy;", "a", "()Z", "createAsyncSwitch", "", "INVALID_SEQ", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.UpComingHelper$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((Boolean) UpComingHelper.E.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.helper.UpComingHelper$Companion$createAsyncSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("upcoming_create_async_9065", true));
            }
        });
        E = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Contact peer, long j3, final UpComingHelper this$0) {
        Intrinsics.checkNotNullParameter(peer, "$peer");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IMsgService) QRoute.api(IMsgService.class)).getSingleMsg(peer, j3, new IMsgOperateCallback() { // from class: com.tencent.qqnt.aio.helper.fm
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                UpComingHelper.o(UpComingHelper.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(UpComingHelper this$0, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isDevelopLevel()) {
            QLog.d("UpComingHelper", 4, String.valueOf(i3));
        }
        if (i3 == 0 && !arrayList.isEmpty()) {
            Message obtainMessage = this$0.mUIHandler.obtainMessage();
            if (obtainMessage != null) {
                obtainMessage.what = 1;
            }
            if (obtainMessage != null) {
                obtainMessage.obj = arrayList.get(0);
            }
            this$0.mUIHandler.sendMessage(obtainMessage);
            SessionInfo sessionInfo = this$0.mSessionInfo;
            this$0.p(sessionInfo != null ? sessionInfo.f179557e : null);
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AE94", "0X800AE94", 0, 0, "", "", "", "");
    }

    private final void p(String uin) {
        MqqHandler mqqHandler;
        Fragment c16;
        FragmentActivity activity;
        Resources resources;
        Fragment c17;
        FragmentActivity activity2;
        Resources resources2;
        Fragment c18;
        FragmentActivity activity3;
        Resources resources3;
        SessionInfo sessionInfo = this.mSessionInfo;
        boolean z16 = false;
        if (sessionInfo != null && sessionInfo.f179555d == 1) {
            z16 = true;
        }
        if (z16) {
            MqqHandler mqqHandler2 = this.mUIHandler;
            Message obtainMessage = mqqHandler2 != null ? mqqHandler2.obtainMessage() : null;
            if (obtainMessage != null) {
                obtainMessage.what = 2;
            }
            QQAppInterface qQAppInterface = this.app;
            Intrinsics.checkNotNull(qQAppInterface);
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null) {
                TroopInfo l3 = troopManager.l(uin, true);
                if (l3 != null) {
                    if (l3.isExited()) {
                        if (obtainMessage != null) {
                            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
                            obtainMessage.obj = (aVar == null || (c18 = aVar.c()) == null || (activity3 = c18.getActivity()) == null || (resources3 = activity3.getResources()) == null) ? null : resources3.getString(R.string.f170310lw);
                        }
                    } else if (l3.isDisband() && obtainMessage != null) {
                        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
                        obtainMessage.obj = (aVar2 == null || (c17 = aVar2.c()) == null || (activity2 = c17.getActivity()) == null || (resources2 = activity2.getResources()) == null) ? null : resources2.getString(R.string.f170316m2);
                    }
                } else if (obtainMessage != null) {
                    com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
                    obtainMessage.obj = (aVar3 == null || (c16 = aVar3.c()) == null || (activity = c16.getActivity()) == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.f170310lw);
                }
            }
            if ((obtainMessage != null ? obtainMessage.obj : null) == null || (mqqHandler = this.mUIHandler) == null) {
                return;
            }
            mqqHandler.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(UpComingHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQAppInterface qQAppInterface = this$0.app;
        Manager manager = qQAppInterface != null ? qQAppInterface.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER) : null;
        z61.d dVar = manager instanceof z61.d ? (z61.d) manager : null;
        if (dVar != null) {
            dVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        Manager manager = appInterface != null ? appInterface.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER) : null;
        z61.d dVar = manager instanceof z61.d ? (z61.d) manager : null;
        if (dVar != null) {
            dVar.y();
        }
    }

    private final void s() {
        com.tencent.mvi.base.route.j e16;
        if (this.scrollToMsg != null) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                MsgRecord msgRecord = this.scrollToMsg;
                Intrinsics.checkNotNull(msgRecord);
                e16.h(new MsgNavigationEvent.NavigateBySeqEvent("reply_msg", msgRecord.msgSeq, 0L, false, null, false, false, null, 252, null));
            }
            this.scrollToMsg = null;
            return;
        }
        QLog.d("UpComingHelper", 4, "scrollToSpecialMsg is null");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350682w;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "UpComingHelper";
    }

    @Override // com.tencent.aio.api.help.b
    public void h(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (INSTANCE.a()) {
            this.mUIHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.fj
                @Override // java.lang.Runnable
                public final void run() {
                    UpComingHelper.q(UpComingHelper.this);
                }
            });
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Fragment c16;
        Fragment c17;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        FragmentActivity fragmentActivity = null;
        if (i3 == 1) {
            MsgRecord msgRecord = (MsgRecord) msg2.obj;
            this.scrollToMsg = msgRecord;
            if (msgRecord == null) {
                com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
                if (aVar != null && (c16 = aVar.c()) != null) {
                    fragmentActivity = c16.getActivity();
                }
                QQToast.makeText(fragmentActivity, 0, R.string.etu, 0).show();
            } else {
                s();
            }
        } else if (i3 == 2) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 != null && (c17 = aVar2.c()) != null) {
                fragmentActivity = c17.getActivity();
            }
            Object obj = msg2.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            QQToast.makeText(fragmentActivity, 0, (String) obj, 0).show();
        }
        return true;
    }

    @Override // com.tencent.aio.api.help.b
    public void i() {
        if (INSTANCE.a()) {
            this.mUIHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.fl
                @Override // java.lang.Runnable
                public final void run() {
                    UpComingHelper.r();
                }
            });
        }
    }

    public final void j() {
        if (INSTANCE.a()) {
            QQAppInterface qQAppInterface = this.app;
            Intrinsics.checkNotNull(qQAppInterface);
            Manager manager = qQAppInterface.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager");
            ((z61.d) manager).h();
        }
    }

    public final void k() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (!INSTANCE.a()) {
            Manager manager = appInterface != null ? appInterface.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER) : null;
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager");
            ((z61.d) manager).y();
        }
        this.app = null;
        this.mSessionInfo = null;
        this.scrollToSeq = -1L;
        this.scrollToMsg = null;
        this.mProgressDialog = null;
    }

    public final void m() {
        com.tencent.mvi.base.route.j e16;
        Fragment c16;
        FragmentActivity activity;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Intent intent = (aVar == null || (c16 = aVar.c()) == null || (activity = c16.getActivity()) == null) ? null : activity.getIntent();
        if (intent != null) {
            this.scrollToSeq = intent.getLongExtra("key_uniseq", -1L);
            intent.removeExtra("key_uniseq");
        }
        if (this.scrollToSeq != -1) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 != null && (e16 = aVar2.e()) != null) {
                e16.h(MsgForwardEvent.ExitMultiForward.f188621d);
            }
            final long j3 = this.scrollToSeq;
            this.scrollToSeq = -1L;
            com.tencent.guild.api.msg.service.l lVar = com.tencent.guild.api.msg.service.l.f112634a;
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            AIOParam g16 = aVar3 != null ? aVar3.g() : null;
            Intrinsics.checkNotNull(g16);
            final Contact c17 = lVar.c(g16.r());
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.fk
                @Override // java.lang.Runnable
                public final void run() {
                    UpComingHelper.n(Contact.this, j3, this);
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        AIOParam g16;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        this.mSessionInfo = (a16 == null || (g16 = a16.g()) == null) ? null : su3.b.a(g16);
        this.app = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12, 3};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            j();
        } else if (state == 3) {
            m();
        } else {
            if (state != 12) {
                return;
            }
            k();
        }
    }
}
