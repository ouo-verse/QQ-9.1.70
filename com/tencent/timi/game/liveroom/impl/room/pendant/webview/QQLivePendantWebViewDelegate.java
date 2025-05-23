package com.tencent.timi.game.liveroom.impl.room.pendant.webview;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.pendant.PendantViewData;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.mobileqq.qqlive.webview.SendPendantData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.smtt.sdk.WebView;
import com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLivePendantWebViewDelegate;
import com.tencent.timi.game.liveroom.impl.room.pendant.webview.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import ug4.a;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u00012\u0018\u0000 82\u00020\u0001:\u0002#9B\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J,\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010*R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u00060.R\u00020\u00000-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate;", "", "Lcom/tencent/mobileqq/qqlive/data/pendant/PendantViewData;", "pendantViewData", "", "o", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/PendantWebView;", "webView", "pendantData", ReportConstant.COSTREPORT_PREFIX, "", "delayTime", "", "forceSend", "i", MiniChatConstants.MINI_APP_LANDSCAPE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "pid", "l", "r", "fullScreenWatchTime", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "p", "y", "v", "name", "data", tl.h.F, "w", "u", "t", "a", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/PendantWebView;", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/a;", "b", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/a;", "webBuilder", "c", "Lcom/tencent/mobileqq/qqlive/data/pendant/PendantViewData;", "d", "lastPendantViewData", "", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate$Task;", "e", "Ljava/util/Map;", "taskMap", "com/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate$b", "f", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate$b;", "sendPendantDataMsgReceiver", "<init>", "()V", "g", "Task", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLivePendantWebViewDelegate {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f378206h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PendantWebView webView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private a webBuilder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PendantViewData pendantViewData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PendantViewData lastPendantViewData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Task> taskMap = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b sendPendantDataMsgReceiver = new b();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010%\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020\u001e\u0012\u0006\u0010,\u001a\u00020\u001e\u00a2\u0006\u0004\b7\u00108J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0018\u00010\u0000R\u00020\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010,\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\"\u00103\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate$Task;", "", "", "o", "g", "e", "p", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate;", "tmpTask", ReportConstant.COSTREPORT_PREFIX, "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "setPid", "(Ljava/lang/String;)V", "pid", "b", "I", "k", "()I", "setMode", "(I)V", "mode", "", "c", "J", "getLandscapeTime", "()J", "setLandscapeTime", "(J)V", "landscapeTime", "d", "j", "setLandscapeViewTime", "landscapeViewTime", "l", "setModifyTime", "modifyTime", "f", "Z", DomainData.DOMAIN_NAME, "()Z", "r", "(Z)V", "taskDeprecated", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "delayRunnable", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate;Ljava/lang/String;IJJJ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class Task {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String pid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int mode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long landscapeTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long landscapeViewTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long modifyTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean taskDeprecated;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Unit> delayRunnable;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQLivePendantWebViewDelegate f378220h;

        public Task(@NotNull QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate, String pid, int i3, long j3, long j16, long j17) {
            Intrinsics.checkNotNullParameter(pid, "pid");
            this.f378220h = qQLivePendantWebViewDelegate;
            this.pid = pid;
            this.mode = i3;
            this.landscapeTime = j3;
            this.landscapeViewTime = j16;
            this.modifyTime = j17;
            this.delayRunnable = new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLivePendantWebViewDelegate$Task$delayRunnable$1
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
                    QQLivePendantWebViewDelegate.Task.this.e();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f() {
            SimpleEventBus.getInstance().dispatchEvent(new RightBottomPendantPushEvent(true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(Function0 tmp0) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Function0 tmp0) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(Function0 tmp0) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }

        public final void e() {
            if (!this.taskDeprecated) {
                QQLivePendantWebViewDelegate.f378206h.i("Pendant|QQLivePendantWebViewDelegate", "exec: taskid:" + this.pid);
                this.f378220h.l(this.pid);
                PendantWebView pendantWebView = this.f378220h.webView;
                if (pendantWebView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    pendantWebView = null;
                }
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLivePendantWebViewDelegate.Task.f();
                    }
                }, pendantWebView.s("pushPendantDelay", 100));
                this.taskDeprecated = true;
                return;
            }
            QQLivePendantWebViewDelegate.f378206h.e("Pendant|QQLivePendantWebViewDelegate", "exec taskDeprecated");
        }

        public boolean equals(@Nullable Object other) {
            Class<?> cls;
            if (this == other) {
                return true;
            }
            if (other != null) {
                cls = other.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(Task.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLivePendantWebViewDelegate.Task");
            Task task = (Task) other;
            if (Intrinsics.areEqual(this.pid, task.pid) && this.mode == task.mode && this.landscapeTime == task.landscapeTime && this.landscapeViewTime == task.landscapeViewTime && this.modifyTime == task.modifyTime && this.taskDeprecated == task.taskDeprecated && Intrinsics.areEqual(this.delayRunnable, task.delayRunnable)) {
                return true;
            }
            return false;
        }

        public final void g() {
            QQLivePendantWebViewDelegate.f378206h.i("Pendant|QQLivePendantWebViewDelegate", "execAtTime: taskid:" + this.pid + ", landscapeTime:" + this.landscapeTime + ", currentTime:" + System.currentTimeMillis());
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function0<Unit> function0 = this.delayRunnable;
            uIHandlerV2.removeCallbacks(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.l
                @Override // java.lang.Runnable
                public final void run() {
                    QQLivePendantWebViewDelegate.Task.h(Function0.this);
                }
            });
            long currentTimeMillis = (this.landscapeTime * 1000) - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                QQLivePendantWebViewDelegate.f378206h.i("Pendant|QQLivePendantWebViewDelegate", "execAtTime: taskid:" + this.pid + ", post delay millis:" + currentTimeMillis);
                Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                final Function0<Unit> function02 = this.delayRunnable;
                uIHandlerV22.postAtTime(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLivePendantWebViewDelegate.Task.i(Function0.this);
                    }
                }, SystemClock.uptimeMillis() + currentTimeMillis);
            }
        }

        public int hashCode() {
            return (((((((((((this.pid.hashCode() * 31) + this.mode) * 31) + androidx.fragment.app.a.a(this.landscapeTime)) * 31) + androidx.fragment.app.a.a(this.landscapeViewTime)) * 31) + androidx.fragment.app.a.a(this.modifyTime)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.taskDeprecated)) * 31) + this.delayRunnable.hashCode();
        }

        /* renamed from: j, reason: from getter */
        public final long getLandscapeViewTime() {
            return this.landscapeViewTime;
        }

        /* renamed from: k, reason: from getter */
        public final int getMode() {
            return this.mode;
        }

        /* renamed from: l, reason: from getter */
        public final long getModifyTime() {
            return this.modifyTime;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final String getPid() {
            return this.pid;
        }

        /* renamed from: n, reason: from getter */
        public final boolean getTaskDeprecated() {
            return this.taskDeprecated;
        }

        public final void o() {
            QQLivePendantWebViewDelegate.f378206h.i("Pendant|QQLivePendantWebViewDelegate", "execEmptyPushNotify");
            this.f378220h.l("");
        }

        public final void p() {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function0<Unit> function0 = this.delayRunnable;
            uIHandlerV2.removeCallbacks(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.j
                @Override // java.lang.Runnable
                public final void run() {
                    QQLivePendantWebViewDelegate.Task.q(Function0.this);
                }
            });
            this.taskDeprecated = false;
        }

        public final void r(boolean z16) {
            this.taskDeprecated = z16;
        }

        public final void s(@Nullable Task tmpTask) {
            if (tmpTask != null) {
                this.mode = tmpTask.mode;
                this.landscapeTime = tmpTask.landscapeTime;
                this.landscapeViewTime = tmpTask.landscapeViewTime;
                this.modifyTime = tmpTask.modifyTime;
                QQLivePendantWebViewDelegate.f378206h.i("Pendant|QQLivePendantWebViewDelegate", "pendant task updated! taskid:" + this.pid + ", mode:" + this.mode + ", landscapeTime" + this.landscapeTime + ", landscapeViewTime" + this.landscapeViewTime + ", modifyTime" + this.modifyTime);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate$a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/PendantWebView;", "webView", "", "event", "data", "", "b", "JS_PARAMS_CALLBACK_INFERENCE", "Ljava/lang/String;", "JS_PARAMS_CALLBACK_NAME", "JS_PARAMS_PUSH_PENDANT_DELAY", "KEY_PUSH_PENDANT_DELAY", "", "PUSH_PENDANT_DELAY_MILLS", "I", "TAG", "", "firstDelayTime", "J", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "minimumDelayTime", "normalDelayTime", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLivePendantWebViewDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(PendantWebView webView, String event, String data) {
            if (webView != null && !TextUtils.isEmpty(event)) {
                try {
                    JSONArray jSONArray = new JSONArray(data);
                    QQLivePendantWebViewDelegate.f378206h.i("Pendant|QQLivePendantWebViewDelegate", "onCallJS, event=" + event + ", jsonArray=" + jSONArray);
                    webView.loadUrl("javascript:execEventCallback('" + event + "','" + jSONArray + "')");
                } catch (Exception e16) {
                    QQLivePendantWebViewDelegate.f378206h.e("Pendant|QQLivePendantWebViewDelegate", "onCallJS JSONException: " + e16.getMessage());
                }
            }
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate$b", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qqlive/webview/SendPendantData;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements SimpleEventReceiver<SendPendantData> {
        b() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<SendPendantData>> getEventClass() {
            ArrayList<Class<SendPendantData>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SendPendantData.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            PendantViewData pendantViewData;
            if ((event instanceof SendPendantData) && (pendantViewData = QQLivePendantWebViewDelegate.this.pendantViewData) != null) {
                QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = QQLivePendantWebViewDelegate.this;
                PendantWebView pendantWebView = qQLivePendantWebViewDelegate.webView;
                if (pendantWebView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    pendantWebView = null;
                }
                qQLivePendantWebViewDelegate.i(pendantWebView, pendantViewData, 10L, true);
            }
        }
    }

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f378206h = (IAegisLogApi) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(final PendantWebView webView, final PendantViewData pendantViewData, long delayTime, boolean forceSend) {
        IAegisLogApi iAegisLogApi = f378206h;
        iAegisLogApi.i("Pendant|QQLivePendantWebViewDelegate", "callJsAsync start");
        if (!pendantViewData.modifyTimeChanged(this.lastPendantViewData) && !forceSend) {
            iAegisLogApi.d("Pendant|QQLivePendantWebViewDelegate", "Same data, do not send.");
        } else {
            this.lastPendantViewData = pendantViewData;
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.i
                @Override // java.lang.Runnable
                public final void run() {
                    QQLivePendantWebViewDelegate.k(PendantWebView.this, pendantViewData);
                }
            }, delayTime);
        }
    }

    static /* synthetic */ void j(QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate, PendantWebView pendantWebView, PendantViewData pendantViewData, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        qQLivePendantWebViewDelegate.i(pendantWebView, pendantViewData, j3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(PendantWebView pendantWebView, PendantViewData pendantViewData) {
        Intrinsics.checkNotNullParameter(pendantViewData, "$pendantViewData");
        Companion companion = INSTANCE;
        String webData = pendantViewData.getWebData();
        Intrinsics.checkNotNullExpressionValue(webData, "pendantViewData.getWebData()");
        companion.b(pendantWebView, "setActData", webData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String pid) {
        if (this.webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        PendantWebView pendantWebView = this.webView;
        PendantWebView pendantWebView2 = null;
        if (pendantWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pendantWebView = null;
        }
        String r16 = pendantWebView.r("pushPendant");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pid", pid);
        if (!TextUtils.isEmpty(r16)) {
            f378206h.i("Pendant|QQLivePendantWebViewDelegate", "onCallJS, callback=" + r16 + ", json=" + jSONObject);
            PendantWebView pendantWebView3 = this.webView;
            if (pendantWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                pendantWebView2 = pendantWebView3;
            }
            pendantWebView2.callJs(r16, jSONObject.toString());
        }
    }

    private final void m(boolean isLandscape) {
        String str;
        if (this.webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        if (isLandscape) {
            str = "landscape";
        } else {
            str = "portrait";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("orientation", str);
        PendantWebView pendantWebView = this.webView;
        PendantWebView pendantWebView2 = null;
        if (pendantWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pendantWebView = null;
        }
        String r16 = pendantWebView.r("scene");
        if (!TextUtils.isEmpty(r16)) {
            f378206h.i("Pendant|QQLivePendantWebViewDelegate", "onCallJS, callback=" + r16 + ", json=" + jSONObject);
            PendantWebView pendantWebView3 = this.webView;
            if (pendantWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                pendantWebView2 = pendantWebView3;
            }
            pendantWebView2.callJs(r16, jSONObject.toString());
        }
    }

    private final void n() {
        f378206h.d("Pendant|QQLivePendantWebViewDelegate", "executePushTaskAtTime");
        for (Task task : this.taskMap.values()) {
            if (!task.getTaskDeprecated() && task.getMode() == 1) {
                f378206h.i("Pendant|QQLivePendantWebViewDelegate", "executePushTaskAtTime taskId:" + task.getPid());
                task.g();
            }
        }
    }

    private final void o(PendantViewData pendantViewData) {
        long j3;
        cr4.g[] gVarArr;
        int i3;
        QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        cr4.g[] gVarArr2 = pendantViewData.pendantInfoArray;
        Intrinsics.checkNotNullExpressionValue(gVarArr2, "pendantViewData.pendantInfoArray");
        int length = gVarArr2.length;
        int i16 = 0;
        while (i16 < length) {
            cr4.g gVar = gVarArr2[i16];
            int i17 = gVar.f391752r;
            if (i17 != 1 && i17 != 2) {
                gVarArr = gVarArr2;
                i3 = length;
            } else {
                String str = gVar.f391737c;
                Intrinsics.checkNotNullExpressionValue(str, "pendantInfo.pid");
                String str2 = gVar.f391737c;
                Intrinsics.checkNotNullExpressionValue(str2, "pendantInfo.pid");
                gVarArr = gVarArr2;
                i3 = length;
                linkedHashMap.put(str, new Task(this, str2, gVar.f391752r, gVar.f391753s, gVar.f391754t * 60 * 1000, gVar.f391751q));
            }
            i16++;
            qQLivePendantWebViewDelegate = this;
            gVarArr2 = gVarArr;
            length = i3;
        }
        QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate2 = qQLivePendantWebViewDelegate;
        for (Task task : qQLivePendantWebViewDelegate2.taskMap.values()) {
            if (linkedHashMap.containsKey(task.getPid())) {
                Task task2 = (Task) linkedHashMap.get(task.getPid());
                if (task2 != null) {
                    j3 = task2.getModifyTime();
                } else {
                    j3 = 0;
                }
                if (j3 > task.getModifyTime()) {
                    task.s(task2);
                }
                linkedHashMap.remove(task.getPid());
            } else {
                task.r(true);
            }
        }
        qQLivePendantWebViewDelegate2.taskMap.putAll(linkedHashMap);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(PendantViewData pendantViewData, QQLivePendantWebViewDelegate this$0, WebView webView, String str) {
        PendantWebView pendantWebView;
        Intrinsics.checkNotNullParameter(pendantViewData, "$pendantViewData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PendantWebView pendantWebView2 = this$0.webView;
        if (pendantWebView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pendantWebView2 = null;
        }
        if (Intrinsics.areEqual(pendantWebView2, webView)) {
            f378206h.i("Pendant|QQLivePendantWebViewDelegate", "onPageFinish, url=" + str);
            PendantWebView pendantWebView3 = this$0.webView;
            if (pendantWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                pendantWebView = null;
            } else {
                pendantWebView = pendantWebView3;
            }
            j(this$0, pendantWebView, pendantViewData, 500L, false, 8, null);
        }
    }

    private final void r() {
        f378206h.i("Pendant|QQLivePendantWebViewDelegate", "interruptPushTask");
        for (Task task : this.taskMap.values()) {
            f378206h.i("Pendant|QQLivePendantWebViewDelegate", "interruptPushTask taskId:" + task.getPid());
            task.o();
        }
    }

    private final void s(PendantWebView webView, PendantViewData pendantData) {
        if (webView == null) {
            f378206h.e("Pendant|QQLivePendantWebViewDelegate", "loadPendantWebView fail, webview is null");
        } else if (pendantData == null) {
            f378206h.e("Pendant|QQLivePendantWebViewDelegate", "loadPendantWebView fail, pendantData is null");
        } else {
            webView.loadUrl(pendantData.pendantUrl);
            j(this, webView, pendantData, 2000L, false, 8, null);
        }
    }

    private final void x(long fullScreenWatchTime, boolean isLandscape) {
        for (Task task : this.taskMap.values()) {
            if (!task.getTaskDeprecated() && task.getMode() == 2 && isLandscape && fullScreenWatchTime >= task.getLandscapeViewTime()) {
                f378206h.i("Pendant|QQLivePendantWebViewDelegate", "tryExecutePushTask fullScreenWatchTime:" + fullScreenWatchTime + ", isLandscape:" + isLandscape + " taskId:" + task.getPid());
                task.e();
            }
        }
    }

    public final void h(@NotNull String name, @NotNull String data) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(data, "data");
        PendantWebView pendantWebView = this.webView;
        if (pendantWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pendantWebView = null;
        }
        pendantWebView.q(name, data);
    }

    public final void p(@NotNull ViewGroup container, @NotNull final PendantViewData pendantViewData) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(pendantViewData, "pendantViewData");
        PendantWebView pendantWebView = new PendantWebView(container.getContext());
        pendantWebView.setBackgroundColor(0);
        pendantWebView.setVisibility(8);
        VideoReport.setElementId(pendantWebView, "em_qqlive_pendant");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qqlive_pendant_location", String.valueOf(pendantViewData.getLocationForReport()));
        linkedHashMap.put("qqlive_resource_id", String.valueOf(pendantViewData.viewPosition));
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b16, pendantWebView, false, null, "em_qqlive_pendant", linkedHashMap, 6, null);
        this.webView = pendantWebView;
        a aVar = new a(container.getContext(), com.tencent.timi.game.utils.b.d(container), com.tencent.mobileqq.qqlive.utils.g.a(), pendantWebView);
        this.webBuilder = aVar;
        aVar.a(new a.InterfaceC9948a() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.h
            @Override // com.tencent.timi.game.liveroom.impl.room.pendant.webview.a.InterfaceC9948a
            public final void onPageFinished(WebView webView, String str) {
                QQLivePendantWebViewDelegate.q(PendantViewData.this, this, webView, str);
            }
        });
        y(pendantViewData, container);
        SimpleEventBus.getInstance().registerReceiver(this.sendPendantDataMsgReceiver);
    }

    public final void t(long fullScreenWatchTime, boolean isLandscape) {
        x(fullScreenWatchTime, isLandscape);
    }

    public final void u(boolean isLandscape) {
        m(isLandscape);
        if (!isLandscape) {
            r();
        }
    }

    public final void v() {
        r();
    }

    public final void w() {
        SimpleEventBus.getInstance().unRegisterReceiver(this.sendPendantDataMsgReceiver);
        PendantWebView pendantWebView = null;
        this.pendantViewData = null;
        PendantWebView pendantWebView2 = this.webView;
        if (pendantWebView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            pendantWebView = pendantWebView2;
        }
        pendantWebView.destroy();
        Iterator<Task> it = this.taskMap.values().iterator();
        while (it.hasNext()) {
            it.next().p();
        }
        this.taskMap.clear();
    }

    public final void y(@NotNull PendantViewData pendantViewData, @NotNull ViewGroup container) {
        PendantWebView pendantWebView;
        Intrinsics.checkNotNullParameter(pendantViewData, "pendantViewData");
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        if (pendantViewData.viewPosition == 4) {
            o(pendantViewData);
        }
        PendantWebView pendantWebView2 = null;
        if (this.pendantViewData != null) {
            PendantWebView pendantWebView3 = this.webView;
            if (pendantWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                pendantWebView = null;
            } else {
                pendantWebView = pendantWebView3;
            }
            j(this, pendantWebView, pendantViewData, 500L, false, 8, null);
            return;
        }
        this.pendantViewData = pendantViewData;
        int c16 = q.c(pendantViewData.viewWidthDp);
        int c17 = q.c(pendantViewData.viewHeightDp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c16, c17);
        container.removeAllViews();
        PendantWebView pendantWebView4 = this.webView;
        if (pendantWebView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pendantWebView4 = null;
        }
        container.addView(pendantWebView4, layoutParams);
        f378206h.i("Pendant|QQLivePendantWebViewDelegate", "viewPosition:" + pendantViewData.viewPosition + ", width:" + c16 + ", height:" + c17);
        PendantWebView pendantWebView5 = this.webView;
        if (pendantWebView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            pendantWebView2 = pendantWebView5;
        }
        s(pendantWebView2, pendantViewData);
    }
}
