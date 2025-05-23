package com.tencent.mobileqq.leba.business.plugins;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginNearbyPro$nearbyProEntryNotifyObserver$2;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.redtouch.ILebaRedTouchReportApi;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryService;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadMgr;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016Jb\u0010%\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0018\u0010#\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010!2\u0006\u0010$\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginNearbyPro;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "", "resID", "", "isTableModel", "", "W", "", "mode", "style", "l", "tabChange", "I", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "w", "e", "M", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "y", "Lcom/tencent/mobileqq/nearbypro/entry/api/impl/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "T", "()Lcom/tencent/mobileqq/nearbypro/entry/api/impl/a;", "nearbyProEntryNotifyObserver", "()J", "resId", "<init>", "()V", "D", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginNearbyPro extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy nearbyProEntryNotifyObserver;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginNearbyPro$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginNearbyPro$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58700);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginNearbyPro() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<LebaPluginNearbyPro$nearbyProEntryNotifyObserver$2.a>() { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginNearbyPro$nearbyProEntryNotifyObserver$2

                @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginNearbyPro$nearbyProEntryNotifyObserver$2$a", "Lcom/tencent/mobileqq/nearbypro/entry/api/impl/a;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes15.dex */
                public static final class a extends com.tencent.mobileqq.nearbypro.entry.api.impl.a {

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ LebaPluginNearbyPro f240133e;

                    a(LebaPluginNearbyPro lebaPluginNearbyPro) {
                        this.f240133e = lebaPluginNearbyPro;
                    }

                    @Override // com.tencent.mobileqq.nearbypro.entry.api.impl.a, com.tencent.mobileqq.app.BusinessObserver
                    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
                        QLog.i("LebaPluginNearbyPro", 1, "nearbyProEntryUnreadObserver onReceive type: " + type);
                        if (type == 0) {
                            this.f240133e.A();
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    return new a(LebaPluginNearbyPro.this);
                }
            });
            this.nearbyProEntryNotifyObserver = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.nearbypro.entry.api.impl.a T() {
        return (com.tencent.mobileqq.nearbypro.entry.api.impl.a) this.nearbyProEntryNotifyObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AppRuntime appRuntime, final RedTouch redTouch, final LebaPluginNearbyPro this$0, final long j3, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(appRuntime);
        IRuntimeService runtimeService = appRuntime.getRuntimeService(INearbyProEntryService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app!!.getRuntimeService(\u2026va, ProcessConstant.MAIN)");
        final boolean isShowNearbyProEntry = ((INearbyProEntryService) runtimeService).isShowNearbyProEntry();
        IRuntimeService runtimeService2 = appRuntime.getRuntimeService(INearbyProEntryUnreadService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(IN\u2026va, ProcessConstant.MAIN)");
        final INearbyProEntryUnreadService iNearbyProEntryUnreadService = (INearbyProEntryUnreadService) runtimeService2;
        final boolean isShowRedDot = iNearbyProEntryUnreadService.isShowRedDot();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.p
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginNearbyPro.V(isShowNearbyProEntry, isShowRedDot, iNearbyProEntryUnreadService, redTouch, this$0, j3, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(boolean z16, boolean z17, INearbyProEntryUnreadService unreadService, RedTouch redTouch, LebaPluginNearbyPro this$0, long j3, boolean z18) {
        boolean z19;
        Intrinsics.checkNotNullParameter(unreadService, "$unreadService");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && z17) {
            if (!unreadService.hasUnreadMsgCntDot() && !unreadService.getMHasUnreadInteract()) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo.red_type.set(0);
                redTypeInfo.red_content.set("");
                redTypeInfo.red_desc.set("");
                if (redTouch != null) {
                    redTouch.parseRedTouch(redTypeInfo);
                }
                this$0.L(j3, redTouch);
                return;
            }
            if (redTouch != null) {
                redTouch.clearRedTouch();
                this$0.W(redTouch, j3, z18);
                return;
            }
            return;
        }
        if (redTouch != null) {
            redTouch.clearRedTouch();
        }
    }

    private final void W(RedTouch redTouch, long resID, boolean isTableModel) {
        BusinessInfoCheckUpdate.AppInfo n3 = n();
        if (isTableModel) {
            redTouch.parseRedTouchInLebaTable(n3);
        } else {
            redTouch.parseRedTouch(n3);
        }
        L(resID, redTouch);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        QQAppInterface qQAppInterface;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QBaseActivity qBaseActivity = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Context context = v3.getContext();
        if (context instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) context;
        }
        if (qQAppInterface != null && qBaseActivity != null) {
            if (TianshuRedTouch.INSTANCE.j()) {
                IRuntimeService runtimeService = qQAppInterface.getRuntimeService(INearbyProEntryUnreadMgr.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IN\u2026va, ProcessConstant.MAIN)");
                intent = ((INearbyProEntryUnreadMgr) runtimeService).getJumpIntent();
            } else {
                IRuntimeService runtimeService2 = qQAppInterface.getRuntimeService(INearbyProEntryUnreadService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(IN\u2026va, ProcessConstant.MAIN)");
                INearbyProEntryUnreadService iNearbyProEntryUnreadService = (INearbyProEntryUnreadService) runtimeService2;
                Intent jumpIntent = iNearbyProEntryUnreadService.getJumpIntent();
                iNearbyProEntryUnreadService.clearEntryUnreadMsgCnt();
                iNearbyProEntryUnreadService.clearEntryUnreadInteractCnt();
                intent = jumpIntent;
            }
            ((ILebaRedTouchReportApi) QRoute.api(ILebaRedTouchReportApi.class)).reportLevelOneRedInfo((int) v(), 31, reportInfo.f240481e);
            ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchNearbyMainFragment(qBaseActivity, intent);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void I(boolean tabChange, int style) {
        QQAppInterface qQAppInterface;
        INearbyProEntryUnreadMgr iNearbyProEntryUnreadMgr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
            return;
        }
        super.I(tabChange, style);
        if (TianshuRedTouch.INSTANCE.j()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface != null && (iNearbyProEntryUnreadMgr = (INearbyProEntryUnreadMgr) qQAppInterface.getRuntimeService(INearbyProEntryUnreadMgr.class, "")) != null) {
                iNearbyProEntryUnreadMgr.syncTianshuRedDotCount(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void M() {
        BaseQQAppInterface baseQQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        baseQQAppInterface.removeObserver(T());
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void e() {
        BaseQQAppInterface baseQQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        baseQQAppInterface.addObserver(T());
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean l(int mode, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
        }
        Intrinsics.checkNotNullExpressionValue(MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(INearbyProEntryService.class, ""), "app.getRuntimeService<IN\u2026ssConstant.MAIN\n        )");
        return !((INearbyProEntryService) r6).isShowNearbyProEntry();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 4050L;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @Deprecated(message = "9.1.50\u542f\u75282025\u5929\u67a2\u7ea2\u70b9\u7ec4\u4ef6\u540e\uff0c\u4f1a\u5e9f\u5f03\uff0c\u6240\u6709\u7ea2\u70b9\u8d70\u5929\u67a2")
    @Nullable
    public RedTypeInfo w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        QLog.i("LebaPluginNearbyPro", 1, "getTabRedTouchInfo");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(INearbyProEntryUnreadService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IN\u2026va, ProcessConstant.MAIN)");
        INearbyProEntryUnreadService iNearbyProEntryUnreadService = (INearbyProEntryUnreadService) runtimeService;
        if (iNearbyProEntryUnreadService.isShowRedDot()) {
            QLog.i("LebaPluginNearbyPro", 1, "show " + iNearbyProEntryUnreadService.hasUnreadMsgCntDot() + "| " + iNearbyProEntryUnreadService.getMHasUnreadInteract());
            RedTypeInfo redTypeInfo = new RedTypeInfo();
            redTypeInfo.setRedType(0);
            return redTypeInfo;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean y(@Nullable final AppRuntime app, @Nullable Context context, final long resID, @Nullable final RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, final boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.o
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginNearbyPro.U(AppRuntime.this, redTouch, this, resID, isTableModel);
            }
        }, 16, null, true);
        return true;
    }
}
