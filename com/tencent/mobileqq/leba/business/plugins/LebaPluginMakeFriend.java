package com.tencent.mobileqq.leba.business.plugins;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginMakeFriend;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.redtouch.ILebaRedTouchReportApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.event.TianshuRedDataChangeEvent;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0010*\u00012\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J \u0010\u001b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\fH\u0016Jb\u0010*\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0018\u0010(\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0016J2\u0010+\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0004R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\u001dR\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginMakeFriend;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "", "redTouchId", "", "resID", "", "isTableModel", "", "X", FileReaderHelper.OPEN_FILE_FROM_FORCE, "V", "", "U", "mode", "style", "l", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "tabChange", "I", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "w", "e", "M", "Lmqq/app/AppRuntime;", "Landroid/content/Context;", "context", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "y", "a0", "Lcom/tencent/relation/common/servlet/b;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "T", "()Lcom/tencent/relation/common/servlet/b;", "mMatchFriendObserver", "com/tencent/mobileqq/leba/business/plugins/LebaPluginMakeFriend$b", "D", "Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginMakeFriend$b;", "mEventReceiver", "E", "mLastSyncTotal", UserInfo.SEX_FEMALE, "Z", "mLastSyncSuccess", "()J", "resId", "<init>", "()V", "G", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginMakeFriend extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMatchFriendObserver;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b mEventReceiver;

    /* renamed from: E, reason: from kotlin metadata */
    private int mLastSyncTotal;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mLastSyncSuccess;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginMakeFriend$a;", "", "", "MF_REDDOT_TIANSHU_PATH", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginMakeFriend$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginMakeFriend$b", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements SimpleEventReceiver<SimpleBaseEvent> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginMakeFriend.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(LebaPluginMakeFriend this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LebaPluginMakeFriend.W(this$0, false, 1, null);
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
            ArrayList<Class<SimpleBaseEvent>> arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TianshuRedDataChangeEvent.class);
                return arrayListOf;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            Object obj;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            if (event instanceof TianshuRedDataChangeEvent) {
                Iterator<T> it = ((TianshuRedDataChangeEvent) event).getList().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((com.tencent.mobileqq.tianshu.bean.a) obj).a(), "4038.0")) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.i("LebaPluginMakeFriend", 1, "onReceiveEvent: TianshuRedDataChangeEvent, tianshuLoaded=" + z16);
                if (z16) {
                    MqqHandler uIHandler = ThreadManager.getUIHandler();
                    final LebaPluginMakeFriend lebaPluginMakeFriend = LebaPluginMakeFriend.this;
                    uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            LebaPluginMakeFriend.b.b(LebaPluginMakeFriend.this);
                        }
                    });
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58658);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginMakeFriend() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new LebaPluginMakeFriend$mMatchFriendObserver$2(this));
            this.mMatchFriendObserver = lazy;
            this.mEventReceiver = new b();
            this.mLastSyncTotal = -1;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final com.tencent.relation.common.servlet.b T() {
        return (com.tencent.relation.common.servlet.b) this.mMatchFriendObserver.getValue();
    }

    private final int U() {
        return ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getEntryVisibleUnreadCount();
    }

    private final synchronized void V(boolean force) {
        if (!TianshuRedTouch.INSTANCE.j()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
        int U = U();
        if (!force && this.mLastSyncTotal == U && this.mLastSyncSuccess) {
            QLog.i("LebaPluginMakeFriend", 1, "\u540c\u6b65\u5929\u67a2[\u5ffd\u7565]: total=" + U);
            return;
        }
        this.mLastSyncTotal = U;
        boolean updateNumberRedInfoByPath = iRedTouchManager.updateNumberRedInfoByPath("4038.0", U);
        this.mLastSyncSuccess = updateNumberRedInfoByPath;
        QLog.i("LebaPluginMakeFriend", 1, "\u540c\u6b65\u5929\u67a2: total=" + U + ", success=" + updateNumberRedInfoByPath + ", force=" + force);
        A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void W(LebaPluginMakeFriend lebaPluginMakeFriend, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        lebaPluginMakeFriend.V(z16);
    }

    private final void X(final QQAppInterface app, final RedTouch redTouch, final String redTouchId, final long resID, final boolean isTableModel) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.k
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginMakeFriend.Y(LebaPluginMakeFriend.this, redTouch, app, redTouchId, resID, isTableModel);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(final LebaPluginMakeFriend this$0, final RedTouch redTouch, final QQAppInterface app, final String redTouchId, final long j3, final boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(redTouchId, "$redTouchId");
        final int U = this$0.U();
        if (QLog.isColorLevel()) {
            if (redTouch == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.d("LebaPluginMakeFriend", 2, "updateLebaNewKuolieRedTouch() : " + U + " , redTouch is null?(" + z17 + ")}");
        }
        if (redTouch != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.l
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginMakeFriend.Z(U, redTouch, this$0, app, redTouchId, j3, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(int i3, RedTouch redTouch, LebaPluginMakeFriend this$0, QQAppInterface app, String redTouchId, long j3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(redTouchId, "$redTouchId");
        if (i3 <= 0) {
            redTouch.clearRedTouch();
            this$0.a0(app, redTouch, redTouchId, j3, z16);
        } else {
            redTouch.clearRedTouchInLebaTable();
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTouch.setMaxNum(99);
            redTouch.setUseNewStyle(true);
            redTypeInfo.red_content.set(String.valueOf(i3));
            redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
            redTypeInfo.red_type.set(5);
            redTouch.parseRedTouch(redTypeInfo);
            this$0.L(j3, redTouch);
        }
        redTouch.checkAndShowLebaWaterMark();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        Context context = v3.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterHomePage((Activity) context, 1, 0);
        ((ILebaRedTouchReportApi) QRoute.api(ILebaRedTouchReportApi.class)).reportLevelOneRedInfo((int) item.f240505b.uiResId, 31, reportInfo.f240481e);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void I(boolean tabChange, int style) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
            return;
        }
        super.I(tabChange, style);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).onLebaResume(qQAppInterface);
        V(true);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void M() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(T());
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this.mEventReceiver);
    }

    protected final void a0(@NotNull QQAppInterface app, @NotNull RedTouch redTouch, @Nullable String redTouchId, long resID, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, app, redTouch, redTouchId, Long.valueOf(resID), Boolean.valueOf(isTableModel));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(redTouch, "redTouch");
        BusinessInfoCheckUpdate.AppInfo n3 = n();
        if (isTableModel) {
            redTouch.parseRedTouchInLebaTable(n3);
        } else {
            redTouch.parseRedTouch(n3);
        }
        L(resID, redTouch);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void e() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(T());
        }
        SimpleEventBus.getInstance().registerReceiver(this.mEventReceiver);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean l(int mode, int style) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.e("LebaPluginMakeFriend", 1, "filterPlugin QQAppInterface is null ");
            return true;
        }
        boolean matchFriendEntrance = ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).getMatchFriendEntrance(qQAppInterface);
        QLog.i("LebaSpecificListFilterImpl", 1, "PLUGIN_MATCH_FRIEND canShow:" + matchFriendEntrance);
        return !matchFriendEntrance;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 4038L;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @Nullable
    public RedTypeInfo w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int U = U();
        if (U > 0) {
            RedTypeInfo redTypeInfo = new RedTypeInfo();
            redTypeInfo.setRedType(5);
            redTypeInfo.setRedContent(String.valueOf(U));
            return redTypeInfo;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean y(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Intrinsics.checkNotNull(redTouch);
        X((QQAppInterface) app, redTouch, "", resID, isTableModel);
        return true;
    }
}
