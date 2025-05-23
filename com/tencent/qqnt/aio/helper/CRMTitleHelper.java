package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.CRMTitleHelper;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0003:>B\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/aio/helper/CRMTitleHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qidian/data/QidianExternalInfo;", "info", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "p", "", "source", "y", "Lcom/tencent/qidian/QidianManager;", "r", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "u", HippyTKDListViewAdapter.X, "t", "", "getId", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/app/FriendListHandler;", "e", "Lcom/tencent/mobileqq/app/FriendListHandler;", "friendListHandler", "f", "Ljava/lang/String;", "peerUin", tl.h.F, "Z", "hasGetNavigation", "i", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Z", "titleNameFixSwitch", "Lcom/tencent/mvi/base/route/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/a;", "mAction1", "com/tencent/qqnt/aio/helper/CRMTitleHelper$c", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/helper/CRMTitleHelper$c;", "friendListObserver", "com/tencent/qqnt/aio/helper/CRMTitleHelper$b", "D", "Lcom/tencent/qqnt/aio/helper/CRMTitleHelper$b;", "crmBusinessObserver", "com/tencent/qqnt/aio/helper/CRMTitleHelper$e", "E", "Lcom/tencent/qqnt/aio/helper/CRMTitleHelper$e;", "profileCardObserver", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CRMTitleHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    private final c friendListObserver;

    /* renamed from: D, reason: from kotlin metadata */
    private final b crmBusinessObserver;

    /* renamed from: E, reason: from kotlin metadata */
    private final e profileCardObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FriendListHandler friendListHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String peerUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasGetNavigation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy titleNameFixSwitch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/CRMTitleHelper$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOTitleEvent.TitleRequestEvent) {
                CRMTitleHelper.this.u(i3);
            } else if (i3 instanceof AIOTitleEvent.SubTitleRequestEvent) {
                CRMTitleHelper.this.t(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/helper/CRMTitleHelper$e", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "", "isSuccess", "", "uin", "Lcom/tencent/mobileqq/data/Card;", "profileCard", "", "onGetProfileDetail", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends ProfileCardObserver {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(CRMTitleHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.p();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        public void onGetProfileDetail(boolean isSuccess, String uin, Card profileCard) {
            if (CRMTitleHelper.this.hasGetNavigation) {
                return;
            }
            final CRMTitleHelper cRMTitleHelper = CRMTitleHelper.this;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ai
                @Override // java.lang.Runnable
                public final void run() {
                    CRMTitleHelper.e.b(CRMTitleHelper.this);
                }
            }, 16, null, false);
        }
    }

    public CRMTitleHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.helper.CRMTitleHelper$titleNameFixSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qidian_aio_title_name_fix_switch", true);
                QLog.i("CRMTitleHelper", 1, "titleNameFixSwitch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        this.titleNameFixSwitch = lazy;
        this.mAction1 = new d();
        this.friendListObserver = new c();
        this.crmBusinessObserver = new b();
        this.profileCardObserver = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        Intrinsics.checkNotNull(aVar);
        String string = aVar.g().l().getString("uin");
        if (string == null && (string = this.peerUin) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            string = null;
        }
        if (r().S(string, false)) {
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            Intrinsics.checkNotNull(aVar2);
            q((QQAppInterface) peekAppRuntime, aVar2);
        }
    }

    private final void q(QQAppInterface app, com.tencent.aio.api.runtime.a context) {
        String string = context.g().l().getString("uin");
        if (string == null && (string = this.peerUin) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            string = null;
        }
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        if (ChatActivityUtils.L(app, com.tencent.nt.adapter.session.c.c(com.tencent.guild.aio.util.a.e(g16)), string, com.tencent.mobileqq.utils.ac.V(app, string))) {
            if (QLog.isColorLevel()) {
                QLog.d("CRMTitleHelper", 2, "checkNavigationMenuUpdate msg shielded");
            }
        } else {
            if (this.hasGetNavigation) {
                return;
            }
            this.hasGetNavigation = true;
            long parseLong = Long.parseLong(string);
            BusinessHandler businessHandler = app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.qidian.controller.QidianPubAccountBigDataHandler");
            PubAccountNavigationMenu O2 = ((QidianPubAccountBigDataHandler) businessHandler).O2(string);
            BusinessHandler businessHandler2 = app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
            Intrinsics.checkNotNull(businessHandler2, "null cannot be cast to non-null type com.tencent.qidian.controller.QidianHandler");
            ((QidianHandler) businessHandler2).L2(parseLong, app.getLongAccountUin(), O2 != null ? O2.version : 0, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QidianManager r() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) peekAppRuntime).getManager(QQManagerFactory.QIDIAN_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.qidian.QidianManager");
        return (QidianManager) manager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s() {
        return ((Boolean) this.titleNameFixSwitch.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(MsgIntent intent) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        Intrinsics.checkNotNull(aVar);
        byte[] byteArray = aVar.g().l().getByteArray("sigt");
        String str = null;
        if (byteArray != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            com.tencent.mobileqq.service.message.e msgCache = ((QQAppInterface) peekAppRuntime).getMsgCache();
            String str2 = this.peerUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUin");
                str2 = null;
            }
            msgCache.i(str2, byteArray);
            if (QLog.isDevelopLevel()) {
                QLog.d("CRMTitleHelper", 4, "updateSession()--AIO \u5df2\u4fdd\u5b58 sigt");
            }
        }
        Map<String, Integer> map = r().f342666d;
        String str3 = this.peerUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str3 = null;
        }
        if (map.containsKey(str3)) {
            QidianManager r16 = r();
            String str4 = this.peerUin;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUin");
                str4 = null;
            }
            r16.N(str4, true);
        }
        QidianManager r17 = r();
        String str5 = this.peerUin;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str5 = null;
        }
        if (r17.L(str5)) {
            FriendListHandler friendListHandler = this.friendListHandler;
            if (friendListHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendListHandler");
                friendListHandler = null;
            }
            String str6 = this.peerUin;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            } else {
                str = str6;
            }
            friendListHandler.getFriendInfo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(MsgIntent intent) {
        if (s()) {
            x();
            return;
        }
        if (z()) {
            return;
        }
        QLog.d("CRMTitleHelper", 1, "handleTitleRequest need request title nick");
        FriendListHandler friendListHandler = this.friendListHandler;
        String str = null;
        if (friendListHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendListHandler");
            friendListHandler = null;
        }
        String str2 = this.peerUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
        } else {
            str = str2;
        }
        friendListHandler.getFriendInfo(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(CRMTitleHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    private final void w() {
        QidianManager r16 = r();
        String str = this.peerUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str = null;
        }
        if (r16.M(str, false)) {
            QidianManager r17 = r();
            Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
            String str3 = this.peerUin;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            } else {
                str2 = str3;
            }
            String source = r17.t(applicationContext, str2);
            Intrinsics.checkNotNullExpressionValue(source, "source");
            y(source);
        }
    }

    private final void x() {
        QidianManager r16 = r();
        String str = this.peerUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str = null;
        }
        if (A(r16.q(str))) {
            return;
        }
        String str3 = this.peerUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str3 = null;
        }
        r16.N(str3, true);
        String str4 = this.peerUin;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str4 = null;
        }
        if (r16.D(str4, true)) {
            QLog.i("CRMTitleHelper", 1, "requestQidianExternalInfo bmqqExt");
            return;
        }
        String str5 = this.peerUin;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str5 = null;
        }
        if (r16.M(str5, false)) {
            QLog.i("CRMTitleHelper", 1, "requestQidianExternalInfo qidianExt");
            return;
        }
        QLog.i("CRMTitleHelper", 1, "requestQidianExternalInfo master");
        String str6 = this.peerUin;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
        } else {
            str2 = str6;
        }
        r16.T(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String source) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        Intrinsics.checkNotNull(aVar);
        aVar.e().h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, null, null, source, "5")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        String str = this.peerUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str = null;
        }
        String s16 = com.tencent.mobileqq.utils.ac.s(qQAppInterface, str, null, com.tencent.mobileqq.utils.ac.w(1025), 3);
        if (TextUtils.isEmpty(s16)) {
            return false;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        Intrinsics.checkNotNull(aVar);
        aVar.g().l().putString("key_chat_name", s16);
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        Intrinsics.checkNotNull(aVar2);
        aVar2.e().h(new AIOTitleEvent.TitleResponseEvent(4, s16));
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350632f0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "CRMTitleHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.aioContext = param.a();
        this.hasGetNavigation = false;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        Intrinsics.checkNotNull(aVar);
        this.peerUin = String.valueOf(aVar.g().l().getLong("key_peerUin"));
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        Intrinsics.checkNotNull(aVar2);
        aVar2.e().d(Reflection.getOrCreateKotlinClass(AIOTitleEvent.TitleRequestEvent.class).getQualifiedName(), this.mAction1);
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        Intrinsics.checkNotNull(aVar3);
        aVar3.e().d(Reflection.getOrCreateKotlinClass(AIOTitleEvent.SubTitleRequestEvent.class).getQualifiedName(), this.mAction1);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).addObserver(this.friendListObserver);
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime2).addObserver(this.crmBusinessObserver);
        AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime3, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime3).addObserver(this.profileCardObserver);
        AppRuntime peekAppRuntime4 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime4, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) peekAppRuntime4).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendListHandler");
        this.friendListHandler = (FriendListHandler) businessHandler;
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        String str = this.peerUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUin");
            str = null;
        }
        if (iRelationNTUinAndUidApi.isValidUin(str)) {
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi2 = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
            String str2 = this.peerUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUin");
                str2 = null;
            }
            com.tencent.aio.api.runtime.a aVar4 = this.aioContext;
            Intrinsics.checkNotNull(aVar4);
            iRelationNTUinAndUidApi2.saveUidByUin(str2, aVar4.g().r().c().j());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ah
            @Override // java.lang.Runnable
            public final void run() {
                CRMTitleHelper.v(CRMTitleHelper.this);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(AIOTitleEvent.TitleRequestEvent.class).getQualifiedName(), this.mAction1);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).removeObserver(this.friendListObserver);
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime2).removeObserver(this.crmBusinessObserver);
        AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime3, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime3).removeObserver(this.profileCardObserver);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0, 3};
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/CRMTitleHelper$c", "Lcom/tencent/mobileqq/app/ar;", "", "uin", "", "isSuccess", "", "onUpdateFriendInfo", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.app.ar {
        c() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String uin, boolean isSuccess) {
            if (isSuccess) {
                String str = CRMTitleHelper.this.peerUin;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("peerUin");
                    str = null;
                }
                if (Intrinsics.areEqual(uin, str)) {
                    CRMTitleHelper.this.z();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(QidianExternalInfo info) {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar;
        String str = info != null ? info.nickname : null;
        if (str == null || str.length() == 0) {
            str = info != null ? info.uin : null;
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("CRMTitleHelper", 4, "updateTitleShowByCrm: " + ((Object) str));
        }
        if (!(str == null || str.length() == 0) && (aVar = this.aioContext) != null) {
            aVar.g().l().putString("key_chat_name", str);
            aVar.e().h(new AIOTitleEvent.TitleResponseEvent(4, str));
        }
        return z16;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H\u0014J&\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/helper/CRMTitleHelper$b", "Lcom/tencent/qidian/controller/a;", "", "isSuccess", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "data", "", "i", tl.h.F, "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.qidian.controller.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qidian.controller.a
        public void h(boolean isSuccess, HashMap<String, Object> data) {
            if (CRMTitleHelper.this.s()) {
                com.tencent.aio.api.runtime.a aVar = CRMTitleHelper.this.aioContext;
                Intrinsics.checkNotNull(aVar);
                if (aVar.g().r().c().e() == 102 && isSuccess && data != null) {
                    QidianExternalInfo qidianExternalInfo = (QidianExternalInfo) data.get("external");
                    String str = null;
                    String str2 = qidianExternalInfo != null ? qidianExternalInfo.uin : null;
                    String str3 = CRMTitleHelper.this.peerUin;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("peerUin");
                    } else {
                        str = str3;
                    }
                    if (Intrinsics.areEqual(str2, str)) {
                        CRMTitleHelper.this.A(qidianExternalInfo);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qidian.controller.a
        public void i(boolean isSuccess, HashMap<String, Object> data) {
            if (data != null && isSuccess && data.containsKey("external") && data.get("external") != null) {
                com.tencent.aio.api.runtime.a aVar = CRMTitleHelper.this.aioContext;
                Intrinsics.checkNotNull(aVar);
                if (aVar.g().r().c().e() != 102) {
                    return;
                }
                QidianExternalInfo qidianExternalInfo = (QidianExternalInfo) data.get("external");
                String str = null;
                String str2 = qidianExternalInfo != null ? qidianExternalInfo.uin : null;
                String str3 = CRMTitleHelper.this.peerUin;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("peerUin");
                    str3 = null;
                }
                if (Intrinsics.areEqual(str2, str3)) {
                    QidianManager r16 = CRMTitleHelper.this.r();
                    Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
                    String str4 = CRMTitleHelper.this.peerUin;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("peerUin");
                    } else {
                        str = str4;
                    }
                    String source = r16.t(applicationContext, str);
                    CRMTitleHelper cRMTitleHelper = CRMTitleHelper.this;
                    Intrinsics.checkNotNullExpressionValue(source, "source");
                    cRMTitleHelper.y(source);
                    if (CRMTitleHelper.this.s()) {
                        CRMTitleHelper.this.A(qidianExternalInfo);
                    }
                }
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            w();
        } else {
            if (state != 12) {
                return;
            }
            onDestroy();
        }
    }
}
