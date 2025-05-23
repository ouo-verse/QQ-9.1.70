package com.tencent.mobileqq.zplan.manager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.au;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;
import y84.d;
import zb3.FriendsDressUpData;
import zb3.FriendsRespData;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u0002\u0017?B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0006R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b3\u00104R\u001b\u00109\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u00102\u001a\u0004\b7\u00108R\u0018\u0010<\u001a\u00060:R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010;\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager;", "", "", "friendUin", "Lzb3/b;", "result", "", "t", "", "msg", "", "iconType", ReportConstant.COSTREPORT_PREFIX, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", h.F, "peerUin", "o", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "a", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "context", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "_totalLikeNum", "Landroidx/lifecycle/LiveData;", "c", "Landroidx/lifecycle/LiveData;", "k", "()Landroidx/lifecycle/LiveData;", "totalLikeNum", "Lcom/tencent/mobileqq/zplan/manager/a;", "d", "Lcom/tencent/mobileqq/zplan/manager/a;", "likeData", "e", "I", "SUB_THREAD_MSG_REQ_FAVORITE", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "remainForSendVoteNum", "Landroid/os/Handler$Callback;", "Lkotlin/Lazy;", "i", "()Landroid/os/Handler$Callback;", "subCallback", "Lcom/tencent/util/WeakReferenceHandler;", "j", "()Lcom/tencent/util/WeakReferenceHandler;", "subHandler", "Lcom/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager$ZPlanSVipManager;", "Lcom/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager$ZPlanSVipManager;", "sVipManager", "<init>", "(Landroid/content/Context;)V", "ZPlanSVipManager", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanProfileLikeManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Long> _totalLikeNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Long> totalLikeNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LikeData likeData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int SUB_THREAD_MSG_REQ_FAVORITE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger remainForSendVoteNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy subCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy subHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ZPlanSVipManager sVipManager;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager$ZPlanSVipManager;", "", "", "j", "", "l", "g", h.F, "", "event", "k", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "vipStatusChangeCallback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasShownSVipPayedDialog", "c", "didOpenSVipPay", "Lcom/tencent/mobileqq/app/SVIPObserver;", "d", "Lcom/tencent/mobileqq/app/SVIPObserver;", "sVipObserver", "<init>", "(Lcom/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager;Lkotlin/jvm/functions/Function0;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class ZPlanSVipManager {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Function0<Unit> vipStatusChangeCallback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final AtomicBoolean hasShownSVipPayedDialog;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final AtomicBoolean didOpenSVipPay;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private SVIPObserver sVipObserver;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanProfileLikeManager f333869e;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager$ZPlanSVipManager$a", "Lcom/tencent/mobileqq/app/SVIPObserver;", "", "onVipStatusChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a extends SVIPObserver {
            a() {
            }

            @Override // com.tencent.mobileqq.app.SVIPObserver
            public void onVipStatusChanged() {
                if (!ZPlanSVipManager.this.i()) {
                    QLog.d("ZPlanProfileLikeManager", 1, "!isVip");
                    return;
                }
                ZPlanSVipManager.this.vipStatusChangeCallback.invoke();
                if (ZPlanSVipManager.this.j()) {
                    ZPlanSVipManager.this.l();
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                    if (qQAppInterface != null) {
                        qQAppInterface.removeObserver(this);
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager$ZPlanSVipManager$b", "Lcom/tencent/mobileqq/vas/au$b;", "", "onLeftClick", "onRightClick", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class b implements au.b {
            b() {
            }

            @Override // com.tencent.mobileqq.vas.au.b
            public void onLeftClick() {
                ZPlanSVipManager.this.g();
            }

            @Override // com.tencent.mobileqq.vas.au.b
            public void onRightClick() {
                ZPlanSVipManager.this.h();
            }
        }

        public ZPlanSVipManager(ZPlanProfileLikeManager zPlanProfileLikeManager, Function0<Unit> vipStatusChangeCallback) {
            Intrinsics.checkNotNullParameter(vipStatusChangeCallback, "vipStatusChangeCallback");
            this.f333869e = zPlanProfileLikeManager;
            this.vipStatusChangeCallback = vipStatusChangeCallback;
            this.hasShownSVipPayedDialog = new AtomicBoolean(false);
            this.didOpenSVipPay = new AtomicBoolean(false);
            a aVar = new a();
            this.sVipObserver = aVar;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            if (qQAppInterface != null) {
                qQAppInterface.addObserver(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            if (QLog.isColorLevel()) {
                QLog.d("ZPlanProfileLikeManager", 2, "ZanDoubleDialog: onLeftClick: ");
            }
            k("click_getit");
            Intent intent = new Intent(this.f333869e.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("fragmentStyle", 3);
            intent.putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
            intent.putExtra("isTransparentTitle", true);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            this.f333869e.getContext().startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            if (QLog.isColorLevel()) {
                QLog.d("ZPlanProfileLikeManager", 2, "ZanDoubleDialog: onRightClick: ");
            }
            k("click_pay");
            VasH5PayUtil.openH5Pay(this.f333869e.getContext(), "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
            this.didOpenSVipPay.set(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean j() {
            QLog.i("ZPlanProfileLikeManager", 1, "check needShowSVipPayedDialog, hasShown: " + this.hasShownSVipPayedDialog.get() + ", didOpenSVipPay: " + this.didOpenSVipPay.get());
            return this.hasShownSVipPayedDialog.compareAndSet(false, true) && this.didOpenSVipPay.get();
        }

        private final void k(String event) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            if (qQAppInterface == null) {
                return;
            }
            VasWebviewUtil.reportCommercialDrainage(qQAppInterface.getCurrentAccountUin(), "thumbup", event, "", 1, 0, 0, "", "0", "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l() {
            CommonExKt.j(new ZPlanProfileLikeManager$ZPlanSVipManager$showDialog$1(this.f333869e));
        }

        public final void f() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            if (qQAppInterface != null) {
                qQAppInterface.removeObserver(this.sVipObserver);
            }
            this.sVipObserver = null;
        }

        public final boolean i() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            if (qQAppInterface != null) {
                return VasUtil.getSignedService(qQAppInterface).getVipStatus().isSVip();
            }
            return false;
        }

        public final void m() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!VoteHelper.n(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null)) {
                this.f333869e.s("\u975eSVIP\u7528\u6237\u6bcf\u5929\u53ea\u80fd\u70b910\u4e2a\u8d5e\u54e6\uff5e", 0);
                return;
            }
            au auVar = new au(this.f333869e.getContext());
            auVar.N(new b());
            auVar.show();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<FriendsRespData> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f333873e;

        b(long j3) {
            this.f333873e = j3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(FriendsRespData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZPlanProfileLikeManager.this.t(this.f333873e, result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanProfileLikeManager", 1, "getSingleFriendZPlanInfo failed, errorCode: " + error + ", msg: " + message);
        }
    }

    public ZPlanProfileLikeManager(Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        MutableLiveData<Long> mutableLiveData = new MutableLiveData<>();
        this._totalLikeNum = mutableLiveData;
        this.totalLikeNum = mutableLiveData;
        this.SUB_THREAD_MSG_REQ_FAVORITE = 1;
        this.remainForSendVoteNum = new AtomicInteger(0);
        lazy = LazyKt__LazyJVMKt.lazy(new ZPlanProfileLikeManager$subCallback$2(this));
        this.subCallback = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WeakReferenceHandler>() { // from class: com.tencent.mobileqq.zplan.manager.ZPlanProfileLikeManager$subHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WeakReferenceHandler invoke() {
                Handler.Callback i3;
                Looper qQCommonThreadLooper = ThreadManagerV2.getQQCommonThreadLooper();
                i3 = ZPlanProfileLikeManager.this.i();
                return new WeakReferenceHandler(qQCommonThreadLooper, i3);
            }
        });
        this.subHandler = lazy2;
        this.sVipManager = new ZPlanSVipManager(this, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.manager.ZPlanProfileLikeManager$sVipManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final ZPlanProfileLikeManager zPlanProfileLikeManager = ZPlanProfileLikeManager.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.manager.ZPlanProfileLikeManager$sVipManager$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LikeData likeData;
                        LikeData likeData2;
                        QLog.d("ZPlanProfileLikeManager", 1, "update likedata");
                        likeData = ZPlanProfileLikeManager.this.likeData;
                        if (likeData != null) {
                            ZPlanProfileLikeManager zPlanProfileLikeManager2 = ZPlanProfileLikeManager.this;
                            long j3 = likeData.getVipMaxVoteNum().get() - (likeData.getTodayAvailableVotedCount().get() + likeData.getTodayVotedCount().get());
                            likeData2 = zPlanProfileLikeManager2.likeData;
                            QLog.d("ZPlanProfileLikeManager", 1, "likeData: " + likeData2 + ", vipRemainVoteNum: " + j3);
                            if (j3 > 0) {
                                QLog.d("ZPlanProfileLikeManager", 1, "getAndSet vipRemainVoteNum: " + j3);
                                likeData.getTodayAvailableVotedCount().getAndSet(j3);
                            }
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler.Callback i() {
        return (Handler.Callback) this.subCallback.getValue();
    }

    private final WeakReferenceHandler j() {
        return (WeakReferenceHandler) this.subHandler.getValue();
    }

    private final void p() {
        if (j().hasMessages(this.SUB_THREAD_MSG_REQ_FAVORITE)) {
            return;
        }
        WeakReferenceHandler j3 = j();
        Message obtain = Message.obtain();
        obtain.what = this.SUB_THREAD_MSG_REQ_FAVORITE;
        j3.sendMessageDelayed(obtain, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        AtomicLong friendUin;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        String selfUin = qQAppInterface.getCurrentAccountUin();
        if (selfUin == null || selfUin.length() == 0) {
            return;
        }
        LikeData likeData = this.likeData;
        Long valueOf = (likeData == null || (friendUin = likeData.getFriendUin()) == null) ? null : Long.valueOf(friendUin.get());
        if (valueOf == null) {
            QLog.e("ZPlanProfileLikeManager", 1, "sendLikeRequest failed, targetUin null.");
            return;
        }
        int andSet = this.remainForSendVoteNum.getAndSet(0);
        QLog.d("ZPlanProfileLikeManager", 1, "reqFavorite updatedVoteNum = " + andSet);
        if (andSet <= 0) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", selfUin, "VisitorSvc.ReqFavorite");
        Bundle bundle = toServiceMsg.extraData;
        Intrinsics.checkNotNullExpressionValue(selfUin, "selfUin");
        bundle.putLong("selfUin", Long.parseLong(selfUin));
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, valueOf.longValue());
        toServiceMsg.extraData.putByteArray("vCookies", null);
        toServiceMsg.extraData.putInt("favoriteSource", 70);
        toServiceMsg.extraData.putInt(FloatCacheData.ICOUNT, andSet);
        toServiceMsg.extraData.putInt("from", 3);
        qQAppInterface.sendToService(toServiceMsg);
    }

    private final void r() {
        if (this.sVipManager.i()) {
            LikeData likeData = this.likeData;
            if (likeData != null) {
                s(likeData.getSvipFriendMaxVoteNotice(), 0);
                return;
            }
            return;
        }
        this.sVipManager.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(final String msg2, final int iconType) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.manager.ZPlanProfileLikeManager$showToast$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(BaseApplication.getContext(), iconType, msg2, 0).show();
            }
        });
    }

    /* renamed from: g, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final long h() {
        AtomicLong todayVotedCount;
        LikeData likeData = this.likeData;
        if (likeData == null || (todayVotedCount = likeData.getTodayVotedCount()) == null) {
            return 0L;
        }
        return todayVotedCount.get();
    }

    public final LiveData<Long> k() {
        return this.totalLikeNum;
    }

    public final void l(long peerUin) {
        AtomicLong todayAvailableVotedCount;
        AtomicLong friendUin;
        AtomicLong friendUin2;
        LikeData likeData = this.likeData;
        boolean z16 = false;
        if (!((likeData == null || (friendUin2 = likeData.getFriendUin()) == null || friendUin2.get() != 0) ? false : true) && peerUin != 0) {
            LikeData likeData2 = this.likeData;
            if ((likeData2 == null || (friendUin = likeData2.getFriendUin()) == null || peerUin != friendUin.get()) ? false : true) {
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    QLog.e("ZPlanProfileLikeManager", 1, "giveLike fail, net error.");
                    s("\u8d5e\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc", 1);
                    return;
                }
                LikeData likeData3 = this.likeData;
                if (likeData3 != null && (todayAvailableVotedCount = likeData3.getTodayAvailableVotedCount()) != null && todayAvailableVotedCount.get() == 0) {
                    z16 = true;
                }
                if (z16) {
                    QLog.d("ZPlanProfileLikeManager", 1, "likeData?.todayAvailableVotedCount?.get() == 0L");
                    r();
                    return;
                }
                QLog.d("ZPlanProfileLikeManager", 1, "like success");
                this.remainForSendVoteNum.incrementAndGet();
                LikeData likeData4 = this.likeData;
                if (likeData4 != null) {
                    likeData4.getTodayVotedCount().incrementAndGet();
                    likeData4.getTotalVoted().incrementAndGet();
                    likeData4.getTodayAvailableVotedCount().decrementAndGet();
                    this._totalLikeNum.setValue(Long.valueOf(likeData4.getTotalVoted().get()));
                }
                p();
                return;
            }
        }
        QLog.e("ZPlanProfileLikeManager", 1, "giveLike fail, likeData error, please call requestAndUpdateLikeData first.");
    }

    public final void m() {
        n();
        this.sVipManager.f();
    }

    public final void n() {
        if (j().hasMessages(this.SUB_THREAD_MSG_REQ_FAVORITE)) {
            j().removeMessages(this.SUB_THREAD_MSG_REQ_FAVORITE);
            q();
        }
    }

    public final void o(long peerUin) {
        n();
        d.f449567a.f(peerUin, new b(peerUin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(long friendUin, FriendsRespData result) {
        Object firstOrNull;
        QLog.i("ZPlanProfileLikeManager", 1, "trySetNewData, friendUin: " + friendUin + ", result: " + result);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) result.a());
        FriendsDressUpData friendsDressUpData = (FriendsDressUpData) firstOrNull;
        if (friendsDressUpData == null) {
            return;
        }
        this.likeData = new LikeData(new AtomicLong(result.getVipMaxVote()), result.getVipFriendsMaxVotesNotice(), new AtomicLong(friendUin), new AtomicLong(friendsDressUpData.getTodayVotedCount()), new AtomicLong(friendsDressUpData.getTodayVailableVotedCount()), new AtomicLong(friendsDressUpData.getTotalVoted()));
        QLog.i("ZPlanProfileLikeManager", 1, "trySetNewData, friendUin: " + friendUin + ", totalVoted: " + friendsDressUpData + ".totalVoted");
        this._totalLikeNum.postValue(Long.valueOf(friendsDressUpData.getTotalVoted()));
    }
}
