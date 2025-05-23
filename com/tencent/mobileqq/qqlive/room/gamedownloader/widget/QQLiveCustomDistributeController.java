package com.tencent.mobileqq.qqlive.room.gamedownloader.widget;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.gamedownloader.GameDistributeDoActionEvent;
import com.tencent.mobileqq.qqlive.gamedownloader.GameDistributeNotifyEvent;
import com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u0007\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0012\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020#0\"H\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qqlive/gamedownloader/GameDistributeDoActionEvent;", "", VirtualAppProxy.KEY_GAME_ID, "", "actionId", "", "i", "o", "Lcom/tencent/halley/downloader/DownloaderTask;", "task", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "fromQQLive", ReportConstant.COSTREPORT_PREFIX, "Lcr4/b;", "refreshGameInfo", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController$b;", "listener", "j", "w", "u", "t", "k", "l", HippyTKDListViewAdapter.X, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Lcr4/b;", "gameInfo", "e", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController$b;", "distributeListener", "f", "Z", "installing", "Lcom/tencent/halley/downloader/DownloaderTaskListener;", tl.h.F, "Lcom/tencent/halley/downloader/DownloaderTaskListener;", "statueListener", "<init>", "()V", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveCustomDistributeController implements SimpleEventReceiver<GameDistributeDoActionEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private cr4.b gameInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b distributeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean installing;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DownloaderTaskListener statueListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController$a;", "", "", "APK_SUFFIX", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController$b;", "", "", "d", "onDownloadStart", "", "progress", "a", "onDownloadPause", "onDownloadFinish", "", "fromQQLive", "c", "errorCode", "e", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(int progress);

        void b();

        void c(boolean fromQQLive);

        void d();

        void e(int errorCode);

        void onDownloadFinish();

        void onDownloadPause();

        void onDownloadStart();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController$c", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/downloader/a;", "Lcom/tencent/halley/downloader/DownloaderTask;", "task", "", "onTaskStartedMainloop", "onTaskReceivedMainloop", "onTaskPausedMainloop", "onTaskFailedMainloop", "onTaskCompletedMainloop", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends com.tencent.mobileqq.qqlive.room.gamedownloader.downloader.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveCustomDistributeController.this);
            }
        }

        @Override // com.tencent.halley.downloader.DownloaderTaskListener
        public void onTaskCompletedMainloop(@Nullable DownloaderTask task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                QQLiveCustomDistributeController.this.m(task);
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) task);
            }
        }

        @Override // com.tencent.halley.downloader.DownloaderTaskListener
        public void onTaskFailedMainloop(@Nullable DownloaderTask task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                QQLiveCustomDistributeController.this.n(task);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) task);
            }
        }

        @Override // com.tencent.halley.downloader.DownloaderTaskListener
        public void onTaskPausedMainloop(@Nullable DownloaderTask task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                QQLiveCustomDistributeController.this.p(task);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
            }
        }

        @Override // com.tencent.halley.downloader.DownloaderTaskListener
        public void onTaskReceivedMainloop(@Nullable DownloaderTask task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QQLiveCustomDistributeController.this.q(task);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task);
            }
        }

        @Override // com.tencent.halley.downloader.DownloaderTaskListener
        public void onTaskStartedMainloop(@Nullable DownloaderTask task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQLiveCustomDistributeController.this.r(task);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveCustomDistributeController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.statueListener = new c();
        }
    }

    private final void i(String gameId, int actionId) {
        String str;
        cr4.b bVar = this.gameInfo;
        if (bVar != null) {
            str = bVar.f391710a;
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(gameId, str)) {
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Audience|DistributeController", "handleJsCall", "gameId=" + gameId + ", actionId=" + actionId);
        if (actionId == ActionId.START_OR_RESUME_DOWNLOAD.getValue()) {
            companion.i("Audience|DistributeController", "handleJsCall", "START_OR_RESUME_DOWNLOAD");
            u();
            return;
        }
        if (actionId == ActionId.PAUSE_DOWNLOAD.getValue()) {
            companion.i("Audience|DistributeController", "handleJsCall", "PAUSE_DOWNLOAD");
            t();
        } else if (actionId == ActionId.INSTALL_GAME.getValue()) {
            companion.i("Audience|DistributeController", "handleJsCall", "INSTALL_GAME");
            k();
        } else if (actionId == ActionId.OPEN_GAME.getValue()) {
            companion.i("Audience|DistributeController", "handleJsCall", "OPEN_GAME");
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(DownloaderTask task) {
        b bVar = this.distributeListener;
        if (bVar != null) {
            bVar.onDownloadFinish();
        }
        cr4.b bVar2 = this.gameInfo;
        if (bVar2 != null) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = bVar2.f391710a;
            Intrinsics.checkNotNullExpressionValue(str, "it.gameId");
            simpleEventBus.dispatchEvent(new GameDistributeNotifyEvent(str, "", State.FINISH.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final DownloaderTask task) {
        if (task != null) {
            new Function0<Unit>(task) { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController$onDownloadFail$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DownloaderTask $targetTask;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$targetTask = task;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveCustomDistributeController.this, (Object) task);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    QQLiveCustomDistributeController.b bVar;
                    cr4.b bVar2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    bVar = QQLiveCustomDistributeController.this.distributeListener;
                    if (bVar != null) {
                        bVar.e(this.$targetTask.getRet());
                    }
                    bVar2 = QQLiveCustomDistributeController.this.gameInfo;
                    if (bVar2 == null) {
                        return null;
                    }
                    DownloaderTask downloaderTask = this.$targetTask;
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    String str = bVar2.f391710a;
                    Intrinsics.checkNotNullExpressionValue(str, "it.gameId");
                    simpleEventBus.dispatchEvent(new GameDistributeNotifyEvent(str, String.valueOf(downloaderTask.getRet()), State.ERROR.getValue()));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    private final void o() {
        b bVar = this.distributeListener;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(DownloaderTask task) {
        b bVar = this.distributeListener;
        if (bVar != null) {
            bVar.onDownloadPause();
        }
        cr4.b bVar2 = this.gameInfo;
        if (bVar2 != null) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = bVar2.f391710a;
            Intrinsics.checkNotNullExpressionValue(str, "it.gameId");
            simpleEventBus.dispatchEvent(new GameDistributeNotifyEvent(str, "", State.PAUSE.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(DownloaderTask task) {
        int i3;
        cr4.b bVar = this.gameInfo;
        if (bVar != null) {
            if (task != null) {
                i3 = task.getPercentage();
            } else {
                i3 = 0;
            }
            b bVar2 = this.distributeListener;
            if (bVar2 != null) {
                bVar2.a(i3);
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = bVar.f391710a;
            Intrinsics.checkNotNullExpressionValue(str, "it.gameId");
            simpleEventBus.dispatchEvent(new GameDistributeNotifyEvent(str, String.valueOf(i3), State.DOWNLOADING.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(DownloaderTask task) {
        b bVar = this.distributeListener;
        if (bVar != null) {
            bVar.onDownloadStart();
        }
    }

    private final void s(boolean fromQQLive) {
        String str;
        cr4.b bVar = this.gameInfo;
        if (bVar != null && (str = bVar.f391722m) != null) {
            com.tencent.mobileqq.qqlive.room.gamedownloader.downloader.b.f271569a.a(str);
        }
        b bVar2 = this.distributeListener;
        if (bVar2 != null) {
            bVar2.c(fromQQLive);
        }
        cr4.b bVar3 = this.gameInfo;
        if (bVar3 != null) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str2 = bVar3.f391710a;
            Intrinsics.checkNotNullExpressionValue(str2, "it.gameId");
            simpleEventBus.dispatchEvent(new GameDistributeNotifyEvent(str2, "", State.INSTALLED.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QQLiveCustomDistributeController this$0) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cr4.b bVar = this$0.gameInfo;
        if (bVar != null && (str = bVar.f391722m) != null) {
            com.tencent.mobileqq.qqlive.room.gamedownloader.downloader.b bVar2 = com.tencent.mobileqq.qqlive.room.gamedownloader.downloader.b.f271569a;
            if (bVar != null) {
                str2 = bVar.f391710a;
            } else {
                str2 = null;
            }
            bVar2.b(str, "", str2 + ".apk", this$0.statueListener);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GameDistributeDoActionEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<Class<GameDistributeDoActionEvent>> arrayList = new ArrayList<>();
        arrayList.add(GameDistributeDoActionEvent.class);
        return arrayList;
    }

    public final void j(@NotNull cr4.b refreshGameInfo, @NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) refreshGameInfo, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshGameInfo, "refreshGameInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.gameInfo = refreshGameInfo;
        this.distributeListener = listener;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final void k() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        cr4.b bVar = this.gameInfo;
        if (bVar != null && (str = bVar.f391722m) != null) {
            this.installing = com.tencent.mobileqq.qqlive.room.gamedownloader.downloader.b.f271569a.d(str);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        PackageManager packageManager = topActivity.getPackageManager();
        cr4.b bVar = this.gameInfo;
        Intrinsics.checkNotNull(bVar);
        String str = bVar.f391725p;
        Intrinsics.checkNotNull(str);
        Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, str);
        if (launchIntentForPackage != null) {
            cr4.b bVar2 = this.gameInfo;
            Intrinsics.checkNotNull(bVar2);
            String str2 = bVar2.f391725p;
            Intrinsics.checkNotNull(str2);
            launchIntentForPackage.setPackage(str2);
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.putExtra("big_brother_source_key", "biz_src_jc_qqlive");
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(268435456);
        }
        Intrinsics.checkNotNull(launchIntentForPackage);
        topActivity.startActivity(launchIntentForPackage);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
        } else if (event instanceof GameDistributeDoActionEvent) {
            GameDistributeDoActionEvent gameDistributeDoActionEvent = (GameDistributeDoActionEvent) event;
            i(gameDistributeDoActionEvent.getGameId(), gameDistributeDoActionEvent.getActionId());
        }
    }

    public final void t() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        cr4.b bVar = this.gameInfo;
        if (bVar != null && (str = bVar.f391722m) != null) {
            com.tencent.mobileqq.qqlive.room.gamedownloader.downloader.b.f271569a.h(str);
        }
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            AegisLogger.INSTANCE.i("Audience|DistributeController", "startDownload", "");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.gamedownloader.widget.i
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveCustomDistributeController.v(QQLiveCustomDistributeController.this);
                }
            }, 16, null, false);
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.gameInfo = null;
        this.distributeListener = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public final void x() {
        Intent intent;
        boolean z16;
        boolean z17;
        PackageManager packageManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        cr4.b bVar = this.gameInfo;
        if (bVar != null) {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null && (packageManager = topActivity.getPackageManager()) != null) {
                intent = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, bVar.f391725p);
            } else {
                intent = null;
            }
            if (intent != null) {
                s(this.installing);
                return;
            }
            com.tencent.mobileqq.qqlive.room.gamedownloader.downloader.b bVar2 = com.tencent.mobileqq.qqlive.room.gamedownloader.downloader.b.f271569a;
            String str = bVar.f391722m;
            Intrinsics.checkNotNullExpressionValue(str, "it.andDownload");
            DownloaderTask c16 = bVar2.c(str);
            boolean z18 = true;
            if (c16 != null && true == c16.isRunning()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                bVar2.i(c16, this.statueListener);
                q(c16);
                return;
            }
            if (c16 != null && true == c16.isPaused()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                bVar2.i(c16, this.statueListener);
                p(c16);
                return;
            }
            if (c16 == null || true != c16.isFailed()) {
                z18 = false;
            }
            if (z18) {
                bVar2.i(c16, this.statueListener);
                n(c16);
                return;
            }
            String str2 = bVar.f391722m;
            Intrinsics.checkNotNullExpressionValue(str2, "it.andDownload");
            if (bVar2.e(str2)) {
                bVar2.i(c16, this.statueListener);
                m(c16);
                return;
            }
            o();
        }
        this.installing = false;
    }
}
