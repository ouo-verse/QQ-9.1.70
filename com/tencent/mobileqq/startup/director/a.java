package com.tencent.mobileqq.startup.director;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.startup.task.config.f;
import com.tencent.mobileqq.startup.task.config.g;
import com.tencent.mobileqq.startup.task.config.i;
import com.tencent.mobileqq.startup.task.config.j;
import com.tencent.mobileqq.startup.task.config.k;
import com.tencent.mobileqq.startup.task.config.l;
import com.tencent.mobileqq.startup.task.config.m;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ck;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.NtStartup;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.crashdefend.test.StartUpCrashDefendDebugHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\b*\u0001P\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u0004\u0018\u00010\u0005J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%J\u000e\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020(J\u0016\u0010,\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\u0003J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0016J\b\u00101\u001a\u00020\u0003H\u0016R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R0\u0010:\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050206j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000502`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010CR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010CR\u0016\u0010F\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010CR\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/startup/director/a;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mobileqq/startup/permission/b;", "", "u", "Lmqq/app/AppActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, HippyTKDListViewAdapter.X, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "k", "j", "i", "", "what", "arg0", "", "delayMillis", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l", h.F, "Landroid/content/Context;", "context", "", "stageName", "Lcom/tencent/qqnt/startup/d;", "listener", "B", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/qqnt/startup/parse/a;", "p", "Lcom/tencent/qqnt/startup/parse/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "t", "Landroid/app/Application;", "application", ReportConstant.COSTREPORT_PREFIX, "Ljava/lang/Object;", HippyQQConstants.URL_COMPONENT_NAME, "w", "hasFocus", "r", "y", "Landroid/os/Message;", "msg", "handleMessage", "a", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "mCurrentActivity", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mSplashingActivities", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "mUiHandler", "Lcom/tencent/mobileqq/startup/permission/a;", "Lcom/tencent/mobileqq/startup/permission/a;", "mPermissionChecker", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "mRealCreateRemainCount", "mPreloadUiRemainCount", "mPreloadBusiRemainCount", "D", "Ljava/util/List;", "mStageList", "E", "Ljava/lang/String;", "mCurrentStage", UserInfo.SEX_FEMALE, "Z", "mNotifyProxyEnd", "com/tencent/mobileqq/startup/director/a$e", "G", "Lcom/tencent/mobileqq/startup/director/a$e;", "realCreateCheckTask", "<init>", "()V", "H", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a implements Handler.Callback, com.tencent.mobileqq.startup.permission.b {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private static a I;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AtomicInteger mPreloadBusiRemainCount;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private List<com.tencent.qqnt.startup.parse.a> mStageList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String mCurrentStage;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mNotifyProxyEnd;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e realCreateCheckTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AppActivity> mCurrentActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<WeakReference<AppActivity>> mSplashingActivities;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler mUiHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.startup.permission.a mPermissionChecker;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger mRealCreateRemainCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger mPreloadUiRemainCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\nR*\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/startup/director/a$a;", "", "Lcom/tencent/mobileqq/startup/director/a;", "ntDirector", "Lcom/tencent/mobileqq/startup/director/a;", "a", "()Lcom/tencent/mobileqq/startup/director/a;", "b", "(Lcom/tencent/mobileqq/startup/director/a;)V", "getNtDirector$annotations", "()V", "", "DEPEND_STAGE_COUNT_THREE", "I", "DEPEND_STAGE_COUNT_TWO", "MSG_ACTIVITY_FOCUSED", "MSG_ACTIVITY_REAL_CREATE", "MSG_BACKGROUND_DETECT", "MSG_BACKGROUND_REPORT", "", "TAG", "Ljava/lang/String;", "", "TIMEOUT_ACTIVITY_FOCUS", "J", "TIMEOUT_EIGHT_SECONDS", "TIMEOUT_THREE_SECONDS", "<init>", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.director.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return a.I;
            }
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final void b(@Nullable a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                a.I = aVar;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            }
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/startup/director/a$b", "Lcom/tencent/qqnt/startup/d;", "", "onTasksComplete", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.qqnt.startup.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.qqnt.startup.d
        public void onTasksComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.j();
                com.tencent.mobileqq.startup.a.f289667h = SystemClock.elapsedRealtime();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/startup/director/a$c", "Lcom/tencent/qqnt/startup/d;", "", "onTasksComplete", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements com.tencent.qqnt.startup.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.qqnt.startup.d
        public void onTasksComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("NtStartupDirector", 1, "StartupBg tasks complete");
                a.this.z(104, 0, 8000L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/startup/director/a$d", "Lcom/tencent/qqnt/startup/d;", "", "onTasksComplete", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements com.tencent.qqnt.startup.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.qqnt.startup.d
        public void onTasksComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.i();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/startup/director/a$e", "Lcom/tencent/qqnt/startup/d;", "", "onTasksComplete", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements com.tencent.qqnt.startup.d {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.qqnt.startup.d
        public void onTasksComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.k();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSplashingActivities = new ArrayList<>();
        this.mUiHandler = new Handler(Looper.getMainLooper(), this);
        this.mRealCreateRemainCount = new AtomicInteger();
        this.mPreloadUiRemainCount = new AtomicInteger();
        this.mPreloadBusiRemainCount = new AtomicInteger();
        this.mCurrentStage = "";
        this.realCreateCheckTask = new e();
    }

    public static final void A(@Nullable a aVar) {
        INSTANCE.b(aVar);
    }

    private final void B(Context context, String stageName, com.tencent.qqnt.startup.d listener) {
        this.mCurrentStage = stageName;
        C(context, stageName, listener);
    }

    private final void C(Context context, String stageName, com.tencent.qqnt.startup.d listener) {
        Object obj;
        Iterator<T> it = p().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((com.tencent.qqnt.startup.parse.a) obj).b(), stageName)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.qqnt.startup.parse.a aVar = (com.tencent.qqnt.startup.parse.a) obj;
        if (aVar != null) {
            new NtStartup.a().c(new com.tencent.qqnt.startup.e(aVar, com.tencent.mobileqq.startup.task.config.b.f289850a)).a(listener).b(context).c();
        }
    }

    private final void h() {
        if (com.tencent.mobileqq.startup.monitor.d.f289708a.e()) {
            if (QLog.isColorLevel()) {
                QLog.d("NtStartupDirector", 2, "close startup hardCoder");
                return;
            }
            return;
        }
        HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{0}, 8000, 101, 1L, Process.myTid(), "mainStartup", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        if (this.mPreloadBusiRemainCount.decrementAndGet() <= 0) {
            QLog.d("NtStartupDirector", 1, "checkNeedPreloadBusiness and result is true");
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            B(context, "RegProxyEnd", null);
            I = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        QLog.d("NtStartupDirector", 1, "checkNeedPreloadUiTasks remain count:", Integer.valueOf(this.mPreloadUiRemainCount.get()));
        if (this.mPreloadUiRemainCount.decrementAndGet() == 0) {
            QLog.d("NtStartupDirector", 1, "checkNeedPreloadUiTasks and result is true");
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            C(context, "PreloadUiStage", this.realCreateCheckTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        QLog.d("NtStartupDirector", 1, "checkNeedRealCreate remain count:", Integer.valueOf(this.mRealCreateRemainCount.get()));
        if (this.mRealCreateRemainCount.decrementAndGet() == 0) {
            QLog.d("NtStartupDirector", 1, "checkNeedRealCreate and result is true");
            z(102, 0, 0L);
        }
    }

    private final void l() {
        QLog.d("NtStartupDirector", 1, "doActivityRealCreate curState:" + this.mCurrentStage + ", activities:" + this.mSplashingActivities.size());
        h();
        Iterator<WeakReference<AppActivity>> it = this.mSplashingActivities.iterator();
        while (it.hasNext()) {
            AppActivity appActivity = it.next().get();
            if (appActivity != null) {
                QLog.d("NtStartupDirector", 1, "doActivityRealCreate activity:" + appActivity);
                appActivity.realOnCreate();
            }
        }
        this.mCurrentStage = "ActivityRealCreate";
        com.tencent.mobileqq.startup.monitor.d.f289708a.l();
        z(101, 0, 3000L);
    }

    private final com.tencent.qqnt.startup.parse.c m() {
        int i3 = MobileQQ.sProcessId;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 7) {
                        if (i3 != 15) {
                            if (i3 != 17) {
                                switch (i3) {
                                    case 9:
                                        return new i();
                                    case 10:
                                        return new l();
                                    case 11:
                                        return new g();
                                    default:
                                        ck ckVar = ck.f307533a;
                                        if (ckVar.b()) {
                                            return new m();
                                        }
                                        if (ckVar.a()) {
                                            return new f();
                                        }
                                        return new com.tencent.mobileqq.startup.task.config.h();
                                }
                            }
                            return new com.tencent.mobileqq.startup.task.config.a();
                        }
                        return new com.tencent.mobileqq.startup.task.config.c();
                    }
                    return new k();
                }
                return new com.tencent.mobileqq.startup.task.config.d();
            }
            return new j();
        }
        return new com.tencent.mobileqq.startup.task.config.e();
    }

    @Nullable
    public static final a n() {
        return INSTANCE.a();
    }

    private final List<com.tencent.qqnt.startup.parse.a> p() {
        List<com.tencent.qqnt.startup.parse.a> list = this.mStageList;
        if (list != null) {
            return list;
        }
        List<com.tencent.qqnt.startup.parse.a> a16 = com.tencent.qqnt.startup.parse.d.a(m());
        this.mStageList = a16;
        return a16;
    }

    private final boolean q(AppActivity activity) {
        if (this.mPermissionChecker == null) {
            this.mPermissionChecker = new com.tencent.mobileqq.startup.permission.a(this);
        }
        com.tencent.mobileqq.startup.permission.a aVar = this.mPermissionChecker;
        if (aVar != null && !aVar.e(activity)) {
            com.tencent.mobileqq.startup.monitor.d.f289708a.c(true, "NeedPermission");
            return true;
        }
        return false;
    }

    private final void u() {
        com.tencent.mobileqq.startup.monitor.d.f289708a.o();
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.updateStateOnPreStartEvent(0);
        }
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        B(context, "BackgroundCreate", new c());
    }

    private final void v(AppActivity activity) {
        com.tencent.mobileqq.startup.monitor.d.f289708a.r();
        this.mUiHandler.removeMessages(104);
        com.tencent.mobileqq.startup.b.f289681a.c();
        B(activity, "MainPageShow", new d());
    }

    private final void x(AppActivity activity) {
        String str;
        this.mCurrentActivity = new WeakReference<>(activity);
        if (Intrinsics.areEqual(this.mCurrentStage, "BackgroundCreate")) {
            com.tencent.mobileqq.startup.monitor.d.f289708a.j();
            str = "ActivityAfterBgCreate";
        } else {
            com.tencent.mobileqq.startup.monitor.d.f289708a.k();
            str = "ActivityFirstCreate";
        }
        B(activity, str, this.realCreateCheckTask);
        z(101, 0, 800L);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(int what, int arg0, long delayMillis) {
        this.mUiHandler.removeMessages(what);
        Message obtainMessage = this.mUiHandler.obtainMessage(what, arg0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "mUiHandler.obtainMessage(what, arg0, 0)");
        this.mUiHandler.sendMessageDelayed(obtainMessage, delayMillis);
    }

    @Override // com.tencent.mobileqq.startup.permission.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            z(101, 0, 0L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.d("NtStartupDirector", 2, "handleMessage ", msg2);
        }
        switch (msg2.what) {
            case 101:
                AppActivity o16 = o();
                if (o16 != null) {
                    r(o16, true);
                    break;
                }
                break;
            case 102:
                if (!CrashDefendManager.i().d()) {
                    wy3.b.a("HotFix", "doOnMsgRealCreate invoke");
                    l();
                    if (MobileQQ.sProcessId == 1) {
                        StartUpCrashDefendDebugHelper.b(BaseApplication.getContext(), "testThirdCrashTest");
                        StartUpCrashDefendDebugHelper.c();
                        break;
                    }
                } else {
                    wy3.b.a("HotFix", "doOnMsgRealCreate jump");
                    break;
                }
                break;
            case 103:
                if (Intrinsics.areEqual(this.mCurrentStage, "ApplicationCreate")) {
                    QLog.d("NtStartupDirector", 1, "detect background and create");
                    u();
                    break;
                }
                break;
            case 104:
                QLog.d("NtStartupDirector", 1, "StartupBg detect and report");
                com.tencent.mobileqq.startup.b.f289681a.d(false);
                break;
        }
        return true;
    }

    @Nullable
    public final AppActivity o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppActivity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        WeakReference<AppActivity> weakReference = this.mCurrentActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void r(@NotNull AppActivity activity, boolean hasFocus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, Boolean.valueOf(hasFocus));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d("NtStartupDirector", 1, "onActivityFocusChanged, mCurState: " + this.mCurrentStage + ", " + activity + ", " + hasFocus);
        if (!hasFocus) {
            return;
        }
        this.mUiHandler.removeMessages(101);
        if (q(activity)) {
            return;
        }
        String str = this.mCurrentStage;
        int hashCode = str.hashCode();
        String str2 = null;
        if (hashCode != -864969554) {
            if (hashCode != -584713015) {
                if (hashCode == 508619037 && str.equals("ActivityFirstCreate")) {
                    com.tencent.mobileqq.startup.monitor.d.f289708a.w(false);
                    str2 = "SplashShow";
                }
            } else if (str.equals("ActivityRealCreate")) {
                v(activity);
            }
        } else if (str.equals("ActivityAfterBgCreate")) {
            com.tencent.mobileqq.startup.monitor.d.f289708a.w(true);
            str2 = "SplashShowBgCreate";
        }
        if (str2 != null) {
            B(activity, str2, this.realCreateCheckTask);
        }
    }

    public final void s(@NotNull Application application) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) application);
            return;
        }
        Intrinsics.checkNotNullParameter(application, "application");
        com.tencent.mobileqq.startup.monitor.d.f289708a.m();
        if (MobileQQ.sProcessId == 1) {
            this.mRealCreateRemainCount.set(3);
            this.mPreloadUiRemainCount.set(2);
            this.mPreloadBusiRemainCount.set(2);
            B(application, "ApplicationCreate", new b());
            z(103, 0, 3000L);
            return;
        }
        B(application, "ApplicationCreate", null);
        I = null;
    }

    public final void t(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.qqnt.startup.utils.d.f362285a.e(false);
        com.tencent.mobileqq.startup.monitor.d.f289708a.n();
        B(context, "ApplicationAttach", null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0061, code lost:
    
        if (r0.equals("ActivityFirstCreate") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ce, code lost:
    
        if (com.tencent.mobileqq.startup.monitor.d.f289708a.d() != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00d4, code lost:
    
        if (com.tencent.mobileqq.app.PrivacyPolicyHelper.isUserAllow() != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d6, code lost:
    
        r5.mCurrentActivity = new java.lang.ref.WeakReference<>(r6);
        com.tencent.mobileqq.startup.task.config.b.f289850a.createTask("SplashSetupTask").run((android.content.Context) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        if (r0.equals("SplashShowBgCreate") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
    
        if (r0.equals("ActivityAfterBgCreate") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c5, code lost:
    
        if (r0.equals("SplashShow") == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean w(@NotNull Object component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, component)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(component, "component");
        boolean z16 = true;
        QLog.i("NtStartupDirector", 1, "onComponentCreate component:" + component + ", mCurStage:" + this.mCurrentStage);
        this.mUiHandler.removeMessages(103);
        if (component instanceof AppActivity) {
            String str = this.mCurrentStage;
            switch (str.hashCode()) {
                case -1172714972:
                    break;
                case -1135765940:
                    if (str.equals("ApplicationCreate")) {
                        com.tencent.mobileqq.startup.b.f289681a.d(true);
                        x((AppActivity) component);
                        break;
                    }
                    z16 = false;
                    break;
                case -864969554:
                    break;
                case -584713015:
                    if (str.equals("ActivityRealCreate")) {
                        com.tencent.mobileqq.startup.monitor.d dVar = com.tencent.mobileqq.startup.monitor.d.f289708a;
                        String obj = component.toString();
                        Intrinsics.checkNotNullExpressionValue(obj, "component.toString()");
                        dVar.c(true, obj);
                    }
                    z16 = false;
                    break;
                case -204907547:
                    break;
                case 405933034:
                    if (str.equals("BackgroundCreate")) {
                        x((AppActivity) component);
                        com.tencent.mobileqq.startup.monitor.d.f289708a.c(false, "BackgroundCreate");
                        break;
                    }
                    z16 = false;
                    break;
                case 508619037:
                    break;
                default:
                    z16 = false;
                    break;
            }
            if (z16) {
                this.mSplashingActivities.add(new WeakReference<>(component));
            }
            return z16;
        }
        if (!Intrinsics.areEqual(this.mCurrentStage, "ApplicationCreate")) {
            return false;
        }
        u();
        return false;
    }

    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("NtStartupDirector", 1, "onRegisterProxyEnd mNotifyProxyEnd:" + this.mNotifyProxyEnd);
        if (!this.mNotifyProxyEnd) {
            this.mNotifyProxyEnd = true;
            com.tencent.mobileqq.startup.monitor.d.f289708a.s();
            i();
        }
    }
}
