package com.tencent.mobileqq.webview.html;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001NB\u0017\u0012\u0006\u00105\u001a\u000200\u0012\u0006\u0010;\u001a\u000206\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J*\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020#H\u0016J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\b\u0010(\u001a\u00020\u0005H\u0016J\u001a\u0010*\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010)\u001a\u0004\u0018\u00010\rJ,\u0010/\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010-\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\u001cR\u001a\u00105\u001a\u0002008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u0010;\u001a\u0002068\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010=R\u0016\u0010@\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010?R\u0016\u0010A\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/webview/html/HtmlSession;", "Landroid/os/Handler$Callback;", "Ljava/lang/Runnable;", "", "url", "", "w", DomainData.DOMAIN_NAME, "", "rc", "o", tl.h.F, "cachedHtml", "Lcom/tencent/mobileqq/webview/html/SessionData;", "sessionData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "rspHeaders", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "id", TextComponent.SpanType.HTML, "u", "sessionKey", "p", "cacheControl", "i", "k", "", "r", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/os/Message;", "msg", "handleMessage", "f", "stop", TencentLocation.RUN_MODE, "sessionDataForReq", ReportConstant.COSTREPORT_PREFIX, "what", "data", "delay", "fromReq", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/webview/html/m;", "d", "Lcom/tencent/mobileqq/webview/html/m;", "j", "()Lcom/tencent/mobileqq/webview/html/m;", "sessionConfig", "Lcom/tencent/mobileqq/webview/html/o;", "e", "Lcom/tencent/mobileqq/webview/html/o;", "l", "()Lcom/tencent/mobileqq/webview/html/o;", "stat", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Z", "webClientRead2Load", "stopped", "Landroid/os/Message;", "preHangUpMessage", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Object;", "webResourceResponse", "Ljava/util/concurrent/atomic/AtomicInteger;", "D", "Ljava/util/concurrent/atomic/AtomicInteger;", "sessionState", "<init>", "(Lcom/tencent/mobileqq/webview/html/m;Lcom/tencent/mobileqq/webview/html/o;)V", "E", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HtmlSession implements Handler.Callback, Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Object webResourceResponse;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private AtomicInteger sessionState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m sessionConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final o stat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean webClientRead2Load;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean stopped;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Message preHangUpMessage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\tR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/webview/html/HtmlSession$a;", "", "", "msg", "", "b", "result", "a", "CACHE_RESULT_FRESH", "I", "CACHE_RESULT_INVALID", "CACHE_RESULT_VALID", "FLAG_HANG_UP_MSG", "RESULT_MSG_BUSI_HANDLE_REDIRECT", "RESULT_MSG_CACHE_SUC", "RESULT_MSG_MSG_END", "RESULT_MSG_REDIRECT_FAIL", "RESULT_MSG_RESPONSE_FAIL", "RESULT_MSG_RESPONSE_SUC", "RESULT_MSG_SESSION_TIMEOUT", "STATE_EMPTY", "STATE_END", "STATE_READY", "STATE_RUNNING", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.html.HtmlSession$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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

        @NotNull
        public final String a(int result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, result);
            }
            if (result != 0) {
                if (result != 1) {
                    if (result != 2) {
                        return "UNKNOWN_RESULT_TYPE";
                    }
                    return "CACHE_RESULT_INVALID";
                }
                return "CACHE_RESULT_VALID";
            }
            return "CACHE_RESULT_FRESH";
        }

        @NotNull
        public final String b(int msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, msg2);
            }
            if (msg2 != 0) {
                if (msg2 != 1) {
                    if (msg2 != 2) {
                        if (msg2 != 3) {
                            if (msg2 != 4) {
                                if (msg2 != 5) {
                                    return "UNKNOWN_MSG_TYPE";
                                }
                                return "RESULT_MSG_SESSION_TIMEOUT";
                            }
                            return "RESULT_MSG_BUSI_HANDLE_REDIRECT";
                        }
                        return "RESULT_MSG_REDIRECT_FAIL";
                    }
                    return "RESULT_MSG_RESPONSE_FAIL";
                }
                return "RESULT_MSG_CACHE_SUC";
            }
            return "RESULT_MSG_RESPONSE_SUC";
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HtmlSession(@NotNull m sessionConfig, @NotNull o stat) {
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        Intrinsics.checkNotNullParameter(stat, "stat");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sessionConfig, (Object) stat);
            return;
        }
        this.sessionConfig = sessionConfig;
        this.stat = stat;
        this.uiHandler = new Handler(Looper.getMainLooper(), this);
        this.sessionState = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        n.f313939a.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int h(String url) {
        SessionData sessionData;
        String str;
        Integer num;
        String l3 = n.f313939a.l(url, this.sessionConfig.j());
        k h16 = this.sessionConfig.h();
        h c16 = this.sessionConfig.c();
        boolean z16 = true;
        if (!this.sessionConfig.f()) {
            SessionData b16 = c16.b(l3);
            if (b16 != null) {
                str = c16.c(b16);
                int m3 = m(str, b16);
                c cVar = c.f313882a;
                if (str != null) {
                    num = Integer.valueOf(str.length());
                } else {
                    num = null;
                }
                c.g(cVar, "htmlAgent_HtmlSession", 3, "doConnection cachedHtml:" + num + " result:" + INSTANCE.a(m3), null, 8, null);
                if (m3 != 0) {
                    if (m3 == 1) {
                        sessionData = new SessionData(b16);
                        if (sessionData == null) {
                            SessionData sessionData2 = new SessionData();
                            sessionData2.sessionId = l3;
                            sessionData = sessionData2;
                        }
                        if (str != null) {
                            sessionData.setHtml(str);
                        }
                    }
                } else {
                    return -1;
                }
            } else {
                str = null;
            }
            sessionData = null;
            if (sessionData == null) {
            }
            if (str != null) {
            }
        } else {
            sessionData = null;
        }
        c cVar2 = c.f313882a;
        if (sessionData == null) {
            z16 = false;
        }
        c.g(cVar2, "htmlAgent_HtmlSession", 4, "doConnection has sessionDataForReq=" + z16, null, 8, null);
        try {
            h16.b(url, this.sessionConfig, sessionData);
            return h16.connect();
        } catch (IOException e16) {
            this.stat.l(e16.getClass().getName());
            c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "handleConnect() ioException. ", e16);
            return -1000;
        } catch (Exception e17) {
            this.stat.l(e17.getClass().getName());
            c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "handleConnect() exception. ", e17);
            return -1000;
        }
    }

    private final int i(String cacheControl) {
        List split$default;
        List split$default2;
        CharSequence trim;
        split$default = StringsKt__StringsKt.split$default((CharSequence) cacheControl, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
        if (split$default.size() > 1) {
            try {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{","}, false, 0, 6, (Object) null);
                trim = StringsKt__StringsKt.trim((CharSequence) split$default2.get(0));
                int parseInt = Integer.parseInt(trim.toString());
                if (parseInt <= 0) {
                    return 0;
                }
                return parseInt;
            } catch (Exception e16) {
                c.f313882a.f("htmlAgent_HtmlSession", 5, "handleSaveHtml ex. ", e16);
                return 0;
            }
        }
        return 0;
    }

    private final int m(String cachedHtml, SessionData sessionData) {
        int i3;
        Object obj;
        if (!TextUtils.isEmpty(cachedHtml)) {
            if (n.f313939a.j(sessionData)) {
                if (this.sessionConfig.i().c(sessionData.getRspHeaders())) {
                    d e16 = c.f313882a.e();
                    if (e16 != null) {
                        a aVar = a.f313876a;
                        String b16 = aVar.b();
                        Map<String, List<String>> c16 = this.sessionConfig.h().c();
                        Intrinsics.checkNotNull(cachedHtml);
                        byte[] bytes = cachedHtml.getBytes(aVar.a());
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        obj = e16.a("text/html", b16, c16, new ByteArrayInputStream(bytes));
                    } else {
                        obj = null;
                    }
                    y(this, 1, obj, 0, false, 12, null);
                } else {
                    y(this, 1, cachedHtml, 0, false, 12, null);
                }
                i3 = 0;
            } else {
                i3 = 1;
            }
            sessionData.hitCount++;
            this.sessionConfig.c().a(sessionData);
            return i3;
        }
        return 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0067, code lost:
    
        if (r13 != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void n(String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        k h16 = this.sessionConfig.h();
        String g16 = h16.g("Location");
        boolean a16 = this.sessionConfig.a();
        c.g(c.f313882a, "htmlAgent_DefaultReqHandler", 5, "connect() redirect autoRedirect=" + a16 + " loc=" + g16, null, 8, null);
        z(url, h16.c());
        if (g16 != null) {
            if (a16) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(g16, "http://", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(g16, "https://", false, 2, null);
                }
                h16.disconnect();
                w(g16);
                return;
            }
            y(this, 4, g16, 0, false, 12, null);
            h16.disconnect();
            return;
        }
        y(this, 2, null, 0, false, 12, null);
        h16.disconnect();
    }

    private final void o(String url, int rc5) {
        String str;
        Object obj;
        k h16 = this.sessionConfig.h();
        z(url, h16.c());
        boolean c16 = this.sessionConfig.i().c(h16.c());
        try {
            str = h16.f(c16);
        } catch (Exception e16) {
            c.f313882a.f("htmlAgent_HtmlSession", 5, "readHtml() exception. ", e16);
            str = null;
        }
        InputStream inputStream = h16.getInputStream();
        if (c16 && inputStream != null) {
            d e17 = c.f313882a.e();
            if (e17 != null) {
                obj = e17.a("text/html", h16.d(), h16.c(), inputStream);
            } else {
                obj = null;
            }
            y(this, 0, obj, 0, false, 12, null);
        } else if (!TextUtils.isEmpty(str)) {
            y(this, 0, str, 0, false, 12, null);
        } else {
            y(this, 2, null, 0, false, 12, null);
        }
        if (rc5 == 0) {
            s(str, h16.e());
        }
        h16.disconnect();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009e, code lost:
    
        if (r15 != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void p(String html, String sessionKey) {
        int i3;
        boolean z16;
        boolean z17;
        c cVar;
        boolean q16;
        boolean contains$default;
        boolean contains$default2;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean contains$default3;
        boolean contains$default4;
        k h16 = this.sessionConfig.h();
        h c16 = this.sessionConfig.c();
        SessionData sessionData = new SessionData();
        sessionData.sessionId = sessionKey;
        n nVar = n.f313939a;
        sessionData.htmlSha1 = nVar.h(html);
        sessionData.htmlSize = html.length();
        long currentTimeMillis = System.currentTimeMillis();
        String g16 = h16.g("Cache-Control");
        String g17 = h16.g("Pragma");
        String g18 = h16.g("Last-Modified");
        String g19 = h16.g("eTag");
        sessionData.eTag = g19;
        sessionData.lastModified = g18;
        sessionData.expiredTime = currentTimeMillis;
        boolean z27 = false;
        if (g17 == null) {
            if (g16 != null) {
                contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) g16, (CharSequence) "no-cache", false, 2, (Object) null);
                z18 = true;
                if (contains$default4) {
                    z19 = true;
                    if (!z19) {
                        if (g16 != null) {
                            contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) g16, (CharSequence) "max-age", false, 2, (Object) null);
                            if (contains$default3 == z18) {
                                z26 = true;
                                if (z26) {
                                    i3 = i(g16);
                                    if (g16 == null) {
                                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) g16, (CharSequence) "private", false, 2, (Object) null);
                                        z16 = true;
                                        if (contains$default2) {
                                            z17 = true;
                                            if (!z17) {
                                                if (g16 != null) {
                                                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) g16, (CharSequence) "public", false, 2, (Object) null);
                                                    if (contains$default == z16) {
                                                        z27 = z16;
                                                    }
                                                }
                                            }
                                            cVar = c.f313882a;
                                            if (i3 > cVar.d().b()) {
                                                i3 = cVar.d().b();
                                            }
                                            if (i3 > 0 && TextUtils.isEmpty(g18) && TextUtils.isEmpty(g19)) {
                                                c.g(c.f313882a, "htmlAgent_HtmlSession", 3, "handleSaveHtml() no revalidation data, don't cache", null, 8, null);
                                                return;
                                            }
                                            sessionData.expiredTime = currentTimeMillis + (i3 * 1000);
                                            sessionData.getRspHeaders().putAll(h16.c());
                                            q16 = nVar.q(html, nVar.f(sessionData.sessionId));
                                            if (q16) {
                                                c16.a(sessionData);
                                            }
                                            c.g(c.f313882a, "htmlAgent_HtmlSession", 3, "handleSaveHtml() id:" + sessionKey + " saveHtmlSuc:" + q16, null, 8, null);
                                        }
                                    } else {
                                        z16 = true;
                                    }
                                    z17 = false;
                                    if (!z17) {
                                    }
                                    cVar = c.f313882a;
                                    if (i3 > cVar.d().b()) {
                                    }
                                    if (i3 > 0) {
                                    }
                                    sessionData.expiredTime = currentTimeMillis + (i3 * 1000);
                                    sessionData.getRspHeaders().putAll(h16.c());
                                    q16 = nVar.q(html, nVar.f(sessionData.sessionId));
                                    if (q16) {
                                    }
                                    c.g(c.f313882a, "htmlAgent_HtmlSession", 3, "handleSaveHtml() id:" + sessionKey + " saveHtmlSuc:" + q16, null, 8, null);
                                }
                            }
                        }
                        z26 = false;
                        if (z26) {
                        }
                    }
                }
            } else {
                z18 = true;
            }
            z19 = false;
            if (!z19) {
            }
        }
        i3 = 0;
        if (g16 == null) {
        }
        z17 = false;
        if (!z17) {
        }
        cVar = c.f313882a;
        if (i3 > cVar.d().b()) {
        }
        if (i3 > 0) {
        }
        sessionData.expiredTime = currentTimeMillis + (i3 * 1000);
        sessionData.getRspHeaders().putAll(h16.c());
        q16 = nVar.q(html, nVar.f(sessionData.sessionId));
        if (q16) {
        }
        c.g(c.f313882a, "htmlAgent_HtmlSession", 3, "handleSaveHtml() id:" + sessionKey + " saveHtmlSuc:" + q16, null, 8, null);
    }

    private final void u(final String id5, final String html) {
        c cVar = c.f313882a;
        c.g(cVar, "htmlAgent_HtmlSession", 4, "postSaveSessionData() id:" + id5, null, 8, null);
        d e16 = cVar.e();
        if (e16 != null) {
            e16.i(new Runnable() { // from class: com.tencent.mobileqq.webview.html.f
                @Override // java.lang.Runnable
                public final void run() {
                    HtmlSession.v(HtmlSession.this, html, id5);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(HtmlSession this$0, String html, String id5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(html, "$html");
        Intrinsics.checkNotNullParameter(id5, "$id");
        this$0.p(html, id5);
    }

    private final void w(String url) {
        o oVar = this.stat;
        oVar.n(oVar.c() + 1);
        c.g(c.f313882a, "htmlAgent_HtmlSession", 4, "run() curCount:" + this.stat.c(), null, 8, null);
        k h16 = this.sessionConfig.h();
        int h17 = h(url);
        if (!q()) {
            h16.disconnect();
            return;
        }
        if (h17 != -1001) {
            if (h17 != -1) {
                if (h17 != 0) {
                    if (h17 != 1) {
                        if (h17 != 2) {
                            y(this, 2, null, 0, false, 12, null);
                            h16.disconnect();
                            return;
                        }
                    } else {
                        n(url);
                        return;
                    }
                }
                o(url, h17);
                return;
            }
            return;
        }
        y(this, 3, null, 0, false, 12, null);
        h16.disconnect();
    }

    public static /* synthetic */ void y(HtmlSession htmlSession, int i3, Object obj, int i16, boolean z16, int i17, Object obj2) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        if ((i17 & 8) != 0) {
            z16 = true;
        }
        htmlSession.x(i3, obj, i16, z16);
    }

    private final void z(String url, Map<String, ? extends List<String>> rspHeaders) {
        d e16;
        String lowerCase = "Set-Cookie".toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        List<String> list = rspHeaders.get(lowerCase);
        if (list != null && (e16 = c.f313882a.e()) != null) {
            e16.j(url, list);
        }
    }

    @Nullable
    public final Object A(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (r(url)) {
            return this.webResourceResponse;
        }
        return null;
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            g.f313896a.a(this);
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        c cVar = c.f313882a;
        c.g(cVar, "htmlAgent_HtmlSession", 3, "destroy()", null, 8, null);
        this.sessionConfig.h().disconnect();
        stop();
        this.uiHandler.removeCallbacksAndMessages(null);
        d e16 = cVar.e();
        if (e16 != null) {
            e16.i(new Runnable() { // from class: com.tencent.mobileqq.webview.html.e
                @Override // java.lang.Runnable
                public final void run() {
                    HtmlSession.g();
                }
            }, 500L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!q()) {
            return true;
        }
        this.sessionState.set(2);
        this.stat.r(msg2.what);
        if (msg2.arg2 != 1) {
            this.stat.q(SystemClock.elapsedRealtime());
        }
        if (!this.webClientRead2Load) {
            Message obtain = Message.obtain(msg2);
            obtain.arg2 = 1;
            this.preHangUpMessage = obtain;
            this.stat.u(false);
            c.g(c.f313882a, "htmlAgent_HtmlSession", 5, "handleMessage [" + INSTANCE.b(msg2.what) + "] webClient not ready, hang up...", null, 8, null);
            return true;
        }
        int i3 = msg2.what;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            c.g(c.f313882a, "htmlAgent_HtmlSession", 4, "handleMessage [" + INSTANCE.b(i3) + "] session timeout", null, 8, null);
                            this.sessionConfig.i().a(this.sessionConfig.k(), null);
                        }
                    } else {
                        Object obj = msg2.obj;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        c.g(c.f313882a, "htmlAgent_HtmlSession", 4, "handleMessage [" + INSTANCE.b(msg2.what) + "] onUrlChange", null, 8, null);
                        this.sessionConfig.i().h((String) obj);
                    }
                } else {
                    c.g(c.f313882a, "htmlAgent_HtmlSession", 5, "handleMessage [" + INSTANCE.b(i3) + "] call webClient loadUrl", null, 8, null);
                    this.sessionConfig.i().a(this.sessionConfig.k(), null);
                }
            } else {
                c.g(c.f313882a, "htmlAgent_HtmlSession", 5, "handleMessage [" + INSTANCE.b(i3) + "] call webClient loadUrl", null, 8, null);
                this.sessionConfig.i().a(this.sessionConfig.k(), null);
            }
        } else {
            Object obj2 = msg2.obj;
            if (obj2 instanceof String) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj2;
                k h16 = this.sessionConfig.h();
                c.g(c.f313882a, "htmlAgent_HtmlSession", 4, "handleMessage [" + INSTANCE.b(msg2.what) + "] load html data", null, 8, null);
                this.sessionConfig.i().g(this.sessionConfig.k(), str, "text/html", h16.d(), this.sessionConfig.k(), h16.a());
            } else {
                this.webResourceResponse = obj2;
                c.g(c.f313882a, "htmlAgent_HtmlSession", 4, "handleMessage [" + INSTANCE.b(i3) + "] intercept with webResourceResponse", null, 8, null);
                this.sessionConfig.i().a(this.sessionConfig.k(), null);
            }
        }
        if (msg2.arg2 == 1) {
            msg2.recycle();
        }
        this.sessionState.set(3);
        return true;
    }

    @NotNull
    public final m j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (m) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sessionConfig;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.sessionConfig.k();
    }

    @NotNull
    public final o l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (o) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.stat;
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (!this.stopped && this.sessionState.get() != 3) {
            return true;
        }
        return false;
    }

    public final boolean r(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return Intrinsics.areEqual(this.sessionConfig.k(), url);
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (!q()) {
            return;
        }
        this.stat.s(SystemClock.elapsedRealtime());
        this.stat.m(this.sessionConfig.g());
        if (this.sessionState.compareAndSet(0, 1)) {
            try {
                w(this.sessionConfig.k());
            } catch (Exception e16) {
                c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "doRequest() exception. ", e16);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(@Nullable String html, @Nullable SessionData sessionDataForReq) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) html, (Object) sessionDataForReq);
            return;
        }
        if (sessionDataForReq == null) {
            return;
        }
        k h16 = this.sessionConfig.h();
        boolean z18 = true;
        if (!TextUtils.isEmpty(html)) {
            Map<String, List<String>> c16 = h16.c();
            String lowerCase = "Cache-Control".toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            List<String> list = c16.get(lowerCase);
            if (list != null) {
                List<String> list2 = list;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual("no-store", (String) it.next())) {
                            z17 = true;
                            break;
                        }
                    }
                }
                z17 = false;
                if (true == z17) {
                    z16 = true;
                    if (!z16) {
                        z18 = false;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        c.g(c.f313882a, "htmlAgent_HtmlSession", 3, "onGetHtml() id:" + sessionDataForReq.sessionId + " noStore:" + z18, null, 8, null);
        if (z18) {
            return;
        }
        String str = sessionDataForReq.sessionId;
        Intrinsics.checkNotNull(html);
        u(str, html);
    }

    public final void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (this.stopped) {
                return;
            }
            this.stopped = true;
            c.g(c.f313882a, "htmlAgent_HtmlSession", 3, "stop()", null, 8, null);
        }
    }

    public final void t(@NotNull String url) {
        boolean startsWith$default;
        String str;
        String str2;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
            if (!startsWith$default2) {
                this.sessionConfig.i().a(url, null);
                return;
            }
        }
        if (!q()) {
            c.g(c.f313882a, "htmlAgent_HtmlSession", 3, "onWebViewReady2Load session not alive", null, 8, null);
            this.sessionConfig.i().a(url, null);
            return;
        }
        if (!r(url)) {
            c cVar = c.f313882a;
            if (url.length() > 120) {
                str2 = url.substring(0, 80);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                str2 = url;
            }
            c.g(cVar, "htmlAgent_HtmlSession", 4, "onWebViewReady2Load isUrlMatch:false loadUrl:" + str2 + ", sessionUrl:" + k(), null, 8, null);
            stop();
            this.sessionConfig.i().a(url, null);
            return;
        }
        c cVar2 = c.f313882a;
        c.g(cVar2, "htmlAgent_HtmlSession", 4, "onWebViewReady2Load isUrlMatch:true", null, 8, null);
        this.stat.v(SystemClock.elapsedRealtime());
        this.webClientRead2Load = true;
        Message message = this.preHangUpMessage;
        if (message != null) {
            str = INSTANCE.b(message.what);
        } else {
            str = null;
        }
        c.g(cVar2, "htmlAgent_HtmlSession", 4, "onWebViewReady preHangUpMessage.what=" + str, null, 8, null);
        Message message2 = this.preHangUpMessage;
        if (message2 != null) {
            this.stat.u(false);
            handleMessage(message2);
            this.sessionState.set(3);
            this.preHangUpMessage = null;
            return;
        }
        x(5, null, this.sessionConfig.m() * 1000, false);
    }

    public final void x(int what, @Nullable Object data, int delay, boolean fromReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(what), data, Integer.valueOf(delay), Boolean.valueOf(fromReq));
            return;
        }
        if (fromReq) {
            this.stat.p(SystemClock.elapsedRealtime());
        }
        c.g(c.f313882a, "htmlAgent_HtmlSession", 3, "sendMsg [" + INSTANCE.b(what) + "] delay:" + delay, null, 8, null);
        Message obtainMessage = this.uiHandler.obtainMessage(what, data);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "uiHandler.obtainMessage(what, data)");
        if (delay > 0) {
            this.uiHandler.sendMessageDelayed(obtainMessage, delay);
        } else {
            obtainMessage.sendToTarget();
        }
    }
}
