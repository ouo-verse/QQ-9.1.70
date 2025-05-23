package com.tencent.qqnt.aio.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent;
import com.tencent.mobileqq.troop.gag.TroopGagMsgIntent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopGagUtils;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001/\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000fR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u00100R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/aio/helper/TroopGagHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isFirst", "Lcom/tencent/mobileqq/troop/troopgag/data/d;", DomainData.DOMAIN_NAME, "k", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "o", "isGagMode", "", "gapWording", "p", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "selfGagInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "troopUin", "r", "d", "Z", "mHasDestroy", "e", "Ljava/lang/String;", "mTroopUin", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/os/Handler;", tl.h.F, "Landroid/os/Handler;", "mTimerHandler", "com/tencent/qqnt/aio/helper/TroopGagHelper$b", "Lcom/tencent/qqnt/aio/helper/TroopGagHelper$b;", "mAction", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "getMTroopGagObserver", "()Lcom/tencent/mobileqq/troop/troopgag/api/b;", "setMTroopGagObserver", "(Lcom/tencent/mobileqq/troop/troopgag/api/b;)V", "mTroopGagObserver", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class TroopGagHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mHasDestroy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Handler mTimerHandler = new c(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final b mAction = new b();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopgag.api.b mTroopGagObserver = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/TroopGagHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            TroopGagHelper.this.o(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/TroopGagHelper$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 != 1) {
                if (i3 == 2 && (msg2.obj instanceof com.tencent.mobileqq.troop.troopgag.data.d)) {
                    QLog.i("TroopGagHelper", 1, "updateGagUI");
                    TroopGagHelper troopGagHelper = TroopGagHelper.this;
                    Object obj = msg2.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo");
                    troopGagHelper.s((com.tencent.mobileqq.troop.troopgag.data.d) obj);
                    return;
                }
                return;
            }
            QLog.i("TroopGagHelper", 1, "updateGagStatus");
            TroopGagHelper.this.q(null, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/TroopGagHelper$d", "Lcom/tencent/mobileqq/troop/troopgag/api/b;", "Lcom/tencent/mobileqq/troop/troopgag/data/a;", "gagStatusInfo", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends com.tencent.mobileqq.troop.troopgag.api.b {
        d() {
        }

        @Override // com.tencent.mobileqq.troop.troopgag.api.b
        protected void a(com.tencent.mobileqq.troop.troopgag.data.a gagStatusInfo) {
            com.tencent.mobileqq.troop.troopgag.data.d dVar;
            Intrinsics.checkNotNullParameter(gagStatusInfo, "gagStatusInfo");
            String str = TroopGagHelper.this.mTroopUin;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                str = null;
            }
            if (Intrinsics.areEqual(str, gagStatusInfo.f300221a) && gagStatusInfo.f300223c == 2 && (dVar = gagStatusInfo.f300225e) != null) {
                QLog.i("TroopGagHelper", 1, "onTroopGagStatusChange gagStatusInfo  = " + dVar.f300235b + " " + dVar.f300236c);
                TroopGagHelper.this.q(gagStatusInfo.f300225e, true);
                ITroopGuildPermissionService iTroopGuildPermissionService = (ITroopGuildPermissionService) com.tencent.mobileqq.troop.utils.bg.l(ITroopGuildPermissionService.class);
                if (iTroopGuildPermissionService != null) {
                    String str3 = TroopGagHelper.this.mTroopUin;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                    } else {
                        str2 = str3;
                    }
                    iTroopGuildPermissionService.onMuteStateChanged(str2);
                }
            }
        }
    }

    private final void i() {
        String str = this.mTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        QLog.i("TroopGagHelper", 1, "onCreate mTroopUin = " + str);
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null) {
            e16.addObserver(this.mTroopGagObserver);
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().f(this, this.mAction);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.eb
            @Override // java.lang.Runnable
            public final void run() {
                TroopGagHelper.j(TroopGagHelper.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TroopGagHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.troopgag.data.d n(boolean isFirst) {
        ITroopGagUtils iTroopGagUtils = (ITroopGagUtils) QRoute.api(ITroopGagUtils.class);
        String str = this.mTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        return iTroopGagUtils.getSelfGagInfo(str, isFirst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(MsgIntent msgIntent) {
        if (msgIntent instanceof TroopGagMsgIntent.UpdateGagStatusMsgIntent) {
            r(((TroopGagMsgIntent.UpdateGagStatusMsgIntent) msgIntent).a());
        }
    }

    private final void p(boolean isGagMode, String gapWording) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new TroopUiStateManageMsgIntent.UpdateInputMode(2, !isGagMode, gapWording));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.U;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.troop.gag.TroopGagMsgIntent.UpdateGagStatusMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopGagHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mTroopUin = a16.g().r().c().j();
        this.mHasDestroy = false;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    public final void r(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String str = this.mTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        if (Intrinsics.areEqual(troopUin, str)) {
            this.mTimerHandler.removeMessages(1);
            if (this.mHasDestroy) {
                return;
            }
            this.mTimerHandler.sendEmptyMessage(1);
        }
    }

    public final void s(com.tencent.mobileqq.troop.troopgag.data.d selfGagInfo) {
        Intrinsics.checkNotNullParameter(selfGagInfo, "selfGagInfo");
        String str = selfGagInfo.f300234a;
        String str2 = this.mTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            QLog.i("TroopGagHelper", 1, "updateGagUI selfGagInfo = " + selfGagInfo.f300235b + " " + selfGagInfo.f300236c);
            if (selfGagInfo.f300235b) {
                String str3 = selfGagInfo.f300236c;
                Intrinsics.checkNotNullExpressionValue(str3, "selfGagInfo.buttonText");
                p(true, str3);
                if (this.mHasDestroy) {
                    return;
                }
                this.mTimerHandler.removeMessages(1);
                this.mTimerHandler.sendEmptyMessageDelayed(1, selfGagInfo.f300237d * 1000);
                return;
            }
            p(false, "");
        }
    }

    private final void k() {
        this.mHasDestroy = true;
        String str = null;
        this.mTimerHandler.removeCallbacksAndMessages(null);
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null) {
            e16.removeObserver(this.mTroopGagObserver);
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        String str2 = this.mTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
        } else {
            str = str2;
        }
        QLog.i("TroopGagHelper", 1, "doOnDestroy mTroopUin = " + str);
    }

    private final void m() {
        com.tencent.mobileqq.troop.troopgag.data.d n3 = n(true);
        QLog.i("TroopGagHelper", 1, "gapInfoInit selfGagInfo = " + (n3 != null ? Boolean.valueOf(n3.f300235b) : null) + " " + (n3 != null ? n3.f300236c : null));
        Message obtainMessage = this.mTimerHandler.obtainMessage(2);
        obtainMessage.obj = n3;
        this.mTimerHandler.sendMessage(obtainMessage);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    public final void q(com.tencent.mobileqq.troop.troopgag.data.d selfGagInfo, boolean isFirst) {
        if (selfGagInfo == null) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            Lifecycle lifecycle = aVar.d().getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "mAIOContext.lifecycleOwner.lifecycle");
            BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new TroopGagHelper$updateGagStatus$1(this, isFirst, null), 3, null);
            return;
        }
        s(selfGagInfo);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            i();
        } else {
            if (state != 12) {
                return;
            }
            k();
        }
    }
}
