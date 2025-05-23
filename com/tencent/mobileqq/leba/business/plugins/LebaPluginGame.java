package com.tencent.mobileqq.leba.business.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.gamecenter.ui.MarqueeTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginGame$gcObserver$2;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.perf.memory.preload.PreloadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.ItemAnimationHelper;
import com.tencent.mobileqq.tianshu.ui.ScreenAnimationDialog;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.util.MqqWeakReferenceHandler;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001&B\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\u0005J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0015H\u0016R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u00109\u001a\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010BR\u0014\u0010F\u001a\u00020D8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010E\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginGame;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/mobileqq/gamecenter/api/c;", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", "clickActionParam", "", "f0", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "c0", "b0", "Z", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "H", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "k", "", "", ReportConstant.COSTREPORT_PREFIX, "t", "X", "E", "", "tabChange", "", "style", "I", "G", "e", "M", "J", "Lcom/tencent/mobileqq/gamecenter/ui/o;", "c", "d", "a", "b", "Landroid/os/Handler$Callback;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Handler$Callback;", "getCallback", "()Landroid/os/Handler$Callback;", IECSearchBar.METHOD_SET_CALLBACK, "(Landroid/os/Handler$Callback;)V", "callback", "Lcom/tencent/util/MqqWeakReferenceHandler;", "D", "Lcom/tencent/util/MqqWeakReferenceHandler;", "getHandler", "()Lcom/tencent/util/MqqWeakReferenceHandler;", "setHandler", "(Lcom/tencent/util/MqqWeakReferenceHandler;)V", "handler", "Lcom/tencent/mobileqq/observer/a;", "Lkotlin/Lazy;", "a0", "()Lcom/tencent/mobileqq/observer/a;", "gcObserver", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/gamecenter/ui/o;", "mChildView", "mPullPadFaceRunnablePosted", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mPullPadFaceRunnable", "", "()J", "resId", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginGame extends BaseLebaPluginItem implements com.tencent.mobileqq.gamecenter.api.c {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final List<String> J;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Handler.Callback callback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MqqWeakReferenceHandler handler;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy gcObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.gamecenter.ui.o mChildView;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mPullPadFaceRunnablePosted;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Runnable mPullPadFaceRunnable;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginGame$a;", "", "", "DELAY_FOR_MSG_GAME_CENTER_SONIC_PRELOAD", "J", "", "MSG_GAME_CENTER_SONIC_PRELOAD", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginGame$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginGame$b", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends DefaultClickProcessor {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginGame.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        @NotNull
        public DefaultClickProcessor.a c(@NotNull View view, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DefaultClickProcessor.a) iPatchRedirector.redirect((short) 2, this, view, item, reportInfo);
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            DefaultClickProcessor.a c16 = super.c(view, item, reportInfo);
            LebaPluginGame.this.f0(c16);
            return c16;
        }
    }

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58608);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"m.gamecenter.qq.com", "web.gamecenter.qq.com", "imgcache.qq.com", "imgcache.gtimg.cn", "youxi.vip.qq.com"});
        J = listOf;
    }

    public LebaPluginGame() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.callback = new Handler.Callback() { // from class: com.tencent.mobileqq.leba.business.plugins.f
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean W;
                W = LebaPluginGame.W(LebaPluginGame.this, message);
                return W;
            }
        };
        this.handler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.callback);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LebaPluginGame$gcObserver$2.a>() { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginGame$gcObserver$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginGame$gcObserver$2$a", "Lcom/tencent/mobileqq/observer/a;", "", "isSuccess", "hasNew", "", "type", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a extends com.tencent.mobileqq.observer.a {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ LebaPluginGame f240130d;

                a(LebaPluginGame lebaPluginGame) {
                    this.f240130d = lebaPluginGame;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginGame);
                    }
                }

                @Override // com.tencent.mobileqq.observer.a
                protected void a(boolean isSuccess, boolean hasNew, int type) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Boolean.valueOf(hasNew), Integer.valueOf(type));
                    } else if (isSuccess && type != 2) {
                        this.f240130d.A();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginGame.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(LebaPluginGame.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.gcObserver = lazy;
        this.mChildView = new com.tencent.mobileqq.gamecenter.ui.o();
        this.mPullPadFaceRunnable = new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.g
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginGame.d0(LebaPluginGame.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean W(LebaPluginGame this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i("LebaPluginGame", 1, "callback handleMessage,what = " + msg2.what);
        if (msg2.what == 1134010) {
            this$0.X();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(QQAppInterface qQAppInterface, LebaPluginGame this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("LebaPluginGame", 2, "checkPreloadGameCenter");
                    return;
                }
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("LebaPluginGame", 2, "checkPreloadGameCenter, send message delay");
            }
            IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026AIN\n                    )");
            if (((IWebProcessManagerService) runtimeService).isNeedPreloadWebProcess()) {
                this$0.handler.removeMessages(1134010);
                this$0.handler.sendEmptyMessageDelayed(1134010, 100L);
            }
        } catch (Exception e16) {
            QLog.e("LebaPluginGame", 1, "checkPreloadGameCenter exception, e=", e16);
        }
    }

    private final void Z() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            Manager manager = qQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.GameCenterManagerImp");
            PadFaceManager b16 = ((com.tencent.mobileqq.servlet.e) manager).b();
            IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026nstant.MAIN\n            )");
            b16.o(((IRedTouchManager) runtimeService).getAppInfoByPath(IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID));
        }
        this.mPullPadFaceRunnablePosted = false;
    }

    private final com.tencent.mobileqq.observer.a a0() {
        return (com.tencent.mobileqq.observer.a) this.gcObserver.getValue();
    }

    private final void b0(View view, com.tencent.mobileqq.leba.entity.f reportInfo) {
        Activity activity;
        PreloadManager.f257781a.b(PreloadManager.PreloadEntry.GameCenterLeba.name());
        Context context = view.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        StatisticCollector.getInstance(activity).reportActionCount(peekAppRuntime, peekAppRuntime.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
    }

    private final void c0(View view, com.tencent.mobileqq.leba.entity.f reportInfo) {
        int i3;
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) runtimeService).getAppInfoByPath(String.valueOf(v()));
        IGameCenterRedPointConfigApi iGameCenterRedPointConfigApi = (IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class);
        boolean z16 = reportInfo.f240480d;
        if (QQTheme.isNowSimpleUI()) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        iGameCenterRedPointConfigApi.reportClickForCommonVersion(appInfoByPath, z16, i3);
        if (reportInfo.f240480d) {
            ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).onItemClick(v());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(LebaPluginGame this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(LebaPluginGame this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(DefaultClickProcessor.a clickActionParam) {
        boolean startsWith$default;
        short k3;
        Integer num;
        String str;
        String str2;
        String url;
        String replace$default;
        int i3;
        int i16;
        boolean z16;
        PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField;
        List<BusinessInfoCheckUpdate.RedTypeInfo> list;
        PBRepeatField<String> pBRepeatField;
        String url2 = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_GAMECENTER_LEBA);
        List<String> list2 = null;
        if (TextUtils.isEmpty(url2)) {
            url2 = clickActionParam.l();
            QLog.d("LebaPluginGame", 1, "clickAction gamecenter use plugin info url=" + url2);
        } else {
            Intrinsics.checkNotNullExpressionValue(url2, "url");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url2, "http", false, 2, null);
            if (startsWith$default) {
                k3 = 0;
            } else {
                k3 = clickActionParam.k();
            }
            QLog.d("LebaPluginGame", 1, "clickAction gamecenter use IndividuationUrl url=" + url2);
            clickActionParam.y(k3);
        }
        String url3 = url2;
        com.tencent.mobileqq.leba.widget.a q16 = q();
        if (q16 != null) {
            num = Integer.valueOf(q16.b());
        } else {
            num = null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (clickActionParam.k() == 0) {
            url = url3 + "&dstyle=" + num;
            str = "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface";
            str2 = "oldUrl";
        } else {
            if (clickActionParam.k() != 2) {
                str = "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface";
                str2 = "oldUrl";
            } else {
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                String oldUrl = bi.c((QQAppInterface) peekAppRuntime, MobileQQ.sMobileQQ.getApplicationContext(), url3).f("url");
                String str3 = oldUrl + URLEncoder.encode("&dstyle=" + num);
                Intrinsics.checkNotNullExpressionValue(url3, "url");
                Intrinsics.checkNotNullExpressionValue(oldUrl, "oldUrl");
                str = "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface";
                str2 = "oldUrl";
                url3 = StringsKt__StringsJVMKt.replace$default(url3, oldUrl, str3, false, 4, (Object) null);
            }
            url = url3;
        }
        if (clickActionParam.d()) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IR\u2026nstant.MAIN\n            )");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) runtimeService).getAppInfoByPath(String.valueOf(v()));
            RedTouchUtil.setGameCenterAppInfoCache(appInfoByPath);
            if (appInfoByPath != null && (pBRepeatField = appInfoByPath.missions) != null) {
                list2 = pBRepeatField.get();
            }
            String str4 = "-1";
            if (list2 != null && list2.size() > 0) {
                int size = list2.size();
                for (int i17 = 0; i17 < size; i17++) {
                    if (i17 == 0) {
                        String str5 = list2.get(i17);
                        Intrinsics.checkNotNullExpressionValue(str5, "missions[i]");
                        str4 = str5;
                    } else {
                        str4 = str4 + "_" + ((Object) list2.get(i17));
                    }
                }
            }
            if (clickActionParam.k() == 0) {
                replace$default = url + "&missions=" + str4;
            } else {
                if (clickActionParam.k() == 2) {
                    Intrinsics.checkNotNull(peekAppRuntime, str);
                    String f16 = bi.c((QQAppInterface) peekAppRuntime, MobileQQ.sMobileQQ.getApplicationContext(), url).f("url");
                    String str6 = f16 + URLEncoder.encode("&missions=" + str4);
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    Intrinsics.checkNotNullExpressionValue(f16, str2);
                    replace$default = StringsKt__StringsJVMKt.replace$default(url, f16, str6, false, 4, (Object) null);
                }
                QLog.i("LebaPluginGame", 1, "[dealGameCenterUrl] add redPointId :" + url);
                if (appInfoByPath != null) {
                    PBInt32Field pBInt32Field = appInfoByPath.iNewFlag;
                    if (pBInt32Field != null && pBInt32Field.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        clickActionParam.r(true);
                        new ArrayList();
                        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = appInfoByPath.red_display_info;
                        if (redDisplayInfo != null && (pBRepeatMessageField = redDisplayInfo.red_type_info) != null && (list = pBRepeatMessageField.get()) != null && list.size() >= 2) {
                            i16 = list.get(1).red_type.get();
                        } else {
                            i16 = 0;
                        }
                        i3 = appInfoByPath.num.get();
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("status=");
                        stringBuffer.append(i16);
                        stringBuffer.append("&number=");
                        stringBuffer.append(i3);
                        stringBuffer.append("&path=");
                        stringBuffer.append(appInfoByPath.path.get());
                        clickActionParam.w(stringBuffer.toString());
                        clickActionParam.x(i16);
                        clickActionParam.v(i3);
                    }
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("status=");
                stringBuffer2.append(-1);
                stringBuffer2.append("&number=0");
                stringBuffer2.append("&path=");
                stringBuffer2.append(v());
                clickActionParam.w(stringBuffer2.toString());
                i3 = 0;
                i16 = 0;
                clickActionParam.x(i16);
                clickActionParam.v(i3);
            }
            url = replace$default;
            QLog.i("LebaPluginGame", 1, "[dealGameCenterUrl] add redPointId :" + url);
            if (appInfoByPath != null) {
            }
            StringBuffer stringBuffer22 = new StringBuffer();
            stringBuffer22.append("status=");
            stringBuffer22.append(-1);
            stringBuffer22.append("&number=0");
            stringBuffer22.append("&path=");
            stringBuffer22.append(v());
            clickActionParam.w(stringBuffer22.toString());
            i3 = 0;
            i16 = 0;
            clickActionParam.x(i16);
            clickActionParam.v(i3);
        }
        clickActionParam.z(url);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.E();
            ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).setGameViewContainer(this);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (ScreenAnimationDialog.getShowingDialog() != null) {
            ScreenAnimationDialog.getShowingDialog().onLebaPause();
        }
        ItemAnimationHelper.onLebaPause();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        c0(v3, reportInfo);
        super.H(v3, item, reportInfo);
        b0(v3, reportInfo);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void I(boolean tabChange, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
            return;
        }
        super.I(tabChange, style);
        if (tabChange && !this.mPullPadFaceRunnablePosted) {
            this.mPullPadFaceRunnablePosted = true;
            ThreadManagerV2.excute(this.mPullPadFaceRunnable, 16, null, false);
        }
        if (ScreenAnimationDialog.getShowingDialog() != null) {
            ScreenAnimationDialog.getShowingDialog().onLebaResume();
        }
        ItemAnimationHelper.onLebaResume();
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            com.tencent.mobileqq.leba.util.a.c(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginGame$onResume$$inlined$runOnWorkThread$1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).preloadQQGameCenterByHippy();
                    }
                }
            });
        } else {
            ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).preloadQQGameCenterByHippy();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        ScreenAnimationDialog showingDialog = ScreenAnimationDialog.getShowingDialog();
        QLog.d("LebaPluginGame", 4, "onUnbind dismiss screen animation dialog. dialog=" + showingDialog);
        if (showingDialog != null) {
            showingDialog.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void M() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.unRegistObserver(a0());
        }
    }

    public final void X() {
        final QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.i("LebaPluginGame", 1, "handerQzoneJumpScheme app == null");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.i
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginGame.Y(QQAppInterface.this, this);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.c
    @Nullable
    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return o();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.c
    @Nullable
    public String b() {
        LebaPluginInfo lebaPluginInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        com.tencent.mobileqq.leba.entity.n r16 = r();
        if (r16 != null && (lebaPluginInfo = r16.f240505b) != null) {
            return lebaPluginInfo.strResURL;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.c
    @NotNull
    public com.tencent.mobileqq.gamecenter.ui.o c() {
        LinearLayout linearLayout;
        Context context;
        FrameLayout frameLayout;
        ImageView imageView;
        ImageView imageView2;
        LinearLayout linearLayout2;
        MarqueeTextView marqueeTextView;
        ImageView imageView3;
        RelativeLayout relativeLayout;
        FrameLayout frameLayout2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.mobileqq.gamecenter.ui.o) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        com.tencent.mobileqq.gamecenter.ui.o oVar = new com.tencent.mobileqq.gamecenter.ui.o();
        this.mChildView = oVar;
        View o16 = o();
        TextView textView = null;
        if (o16 != null) {
            linearLayout = (LinearLayout) o16.findViewById(R.id.ypr);
        } else {
            linearLayout = null;
        }
        oVar.f213338a = linearLayout;
        com.tencent.mobileqq.gamecenter.ui.o oVar2 = this.mChildView;
        if (oVar2 != null) {
            View o17 = o();
            if (o17 != null) {
                frameLayout2 = (FrameLayout) o17.findViewById(R.id.yps);
            } else {
                frameLayout2 = null;
            }
            oVar2.f213339b = frameLayout2;
        }
        View o18 = o();
        if (o18 != null) {
            context = o18.getContext();
        } else {
            context = null;
        }
        LayoutInflater from = LayoutInflater.from(context);
        com.tencent.mobileqq.gamecenter.ui.o oVar3 = this.mChildView;
        if (oVar3 != null) {
            frameLayout = oVar3.f213339b;
        } else {
            frameLayout = null;
        }
        from.inflate(R.layout.gxh, frameLayout);
        com.tencent.mobileqq.gamecenter.ui.o oVar4 = this.mChildView;
        if (oVar4 != null) {
            View o19 = o();
            if (o19 != null) {
                relativeLayout = (RelativeLayout) o19.findViewById(R.id.ypw);
            } else {
                relativeLayout = null;
            }
            oVar4.f213340c = relativeLayout;
        }
        com.tencent.mobileqq.gamecenter.ui.o oVar5 = this.mChildView;
        if (oVar5 != null) {
            View o26 = o();
            if (o26 != null) {
                imageView3 = (ImageView) o26.findViewById(R.id.y2j);
            } else {
                imageView3 = null;
            }
            oVar5.f213342e = imageView3;
        }
        com.tencent.mobileqq.gamecenter.ui.o oVar6 = this.mChildView;
        if (oVar6 != null) {
            View o27 = o();
            if (o27 != null) {
                marqueeTextView = (MarqueeTextView) o27.findViewById(R.id.f110146hq);
            } else {
                marqueeTextView = null;
            }
            oVar6.f213343f = marqueeTextView;
        }
        com.tencent.mobileqq.gamecenter.ui.o oVar7 = this.mChildView;
        if (oVar7 != null) {
            View o28 = o();
            if (o28 != null) {
                linearLayout2 = (LinearLayout) o28.findViewById(R.id.ypj);
            } else {
                linearLayout2 = null;
            }
            oVar7.f213344g = linearLayout2;
        }
        com.tencent.mobileqq.gamecenter.ui.o oVar8 = this.mChildView;
        if (oVar8 != null) {
            View o29 = o();
            if (o29 != null) {
                imageView2 = (ImageView) o29.findViewById(R.id.y2k);
            } else {
                imageView2 = null;
            }
            oVar8.f213345h = imageView2;
        }
        com.tencent.mobileqq.gamecenter.ui.o oVar9 = this.mChildView;
        if (oVar9 != null) {
            View o36 = o();
            if (o36 != null) {
                imageView = (ImageView) o36.findViewById(R.id.y2l);
            } else {
                imageView = null;
            }
            oVar9.f213347j = imageView;
        }
        com.tencent.mobileqq.gamecenter.ui.o oVar10 = this.mChildView;
        if (oVar10 != null) {
            View o37 = o();
            if (o37 != null) {
                textView = (TextView) o37.findViewById(R.id.k6s);
            }
            oVar10.f213348k = textView;
        }
        return this.mChildView;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.h
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginGame.e0(LebaPluginGame.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void e() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.registObserver(a0());
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public DefaultClickProcessor k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DefaultClickProcessor) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public List<String> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return J;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "key_gamecenter_dns_parse";
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return 489L;
    }
}
