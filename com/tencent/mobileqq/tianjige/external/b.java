package com.tencent.mobileqq.tianjige.external;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanBuilder;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.context.e;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\n\u0018\u0000 42\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b\u0010\u0010\u001eR\"\u0010(\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\t\u001a\u0004\b)\u0010\u000b\"\u0004\b\u0015\u0010\u0013R.\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b\r\u0010.\"\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/tianjige/external/b;", "Lcom/tencent/mobileqq/tianjige/external/a;", "", "getSpanId", "getTraceId", "Lcom/tencent/opentelemetry/api/trace/Tracer;", "tracer", "", "a", "Ljava/lang/String;", "getZplanSpanId", "()Ljava/lang/String;", "zplanSpanId", "b", "getZplanTraceId", "zplanTraceId", "c", "getParentId", "f", "(Ljava/lang/String;)V", "parentId", "d", "getName", "e", "name", "", "J", "getStartTime", "()J", "g", "(J)V", "startTime", "getEndTime", "endTime", "Lcom/tencent/opentelemetry/api/trace/StatusCode;", "Lcom/tencent/opentelemetry/api/trace/StatusCode;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/opentelemetry/api/trace/StatusCode;", h.F, "(Lcom/tencent/opentelemetry/api/trace/StatusCode;)V", "status", "getErrorMessage", "errorMessage", "", "i", "Ljava/util/Map;", "()Ljava/util/Map;", "setInnerAttribute", "(Ljava/util/Map;)V", "innerAttribute", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "j", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String zplanSpanId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String zplanTraceId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String parentId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private StatusCode status;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String errorMessage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, String> innerAttribute;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tianjige/external/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianjige.external.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.tianjige.external.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public /* synthetic */ class C8650b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292947a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34509);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[StatusCode.values().length];
            try {
                iArr[StatusCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatusCode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f292947a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34510);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull String zplanSpanId, @NotNull String zplanTraceId) {
        Intrinsics.checkNotNullParameter(zplanSpanId, "zplanSpanId");
        Intrinsics.checkNotNullParameter(zplanTraceId, "zplanTraceId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) zplanSpanId, (Object) zplanTraceId);
            return;
        }
        this.zplanSpanId = zplanSpanId;
        this.zplanTraceId = zplanTraceId;
        this.name = "";
        this.status = StatusCode.UNSET;
        this.innerAttribute = new LinkedHashMap();
    }

    @Override // com.tencent.mobileqq.tianjige.external.a
    public void a(@NotNull Tracer tracer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) tracer);
            return;
        }
        Intrinsics.checkNotNullParameter(tracer, "tracer");
        try {
            SpanBuilder startTimestamp = tracer.spanBuilder(this.name).setSpanKind(SpanKind.CLIENT).setStartTimestamp(this.startTime, TimeUnit.NANOSECONDS);
            String str = this.parentId;
            if (str != null) {
                Intrinsics.checkNotNull(str);
                startTimestamp.setParent(e.k().with(tracer.spanBuilder("").startSpan(new b(str, getTraceId()))));
            } else {
                startTimestamp.setNoParent();
            }
            if (this.innerAttribute.size() > 0) {
                for (String str2 : this.innerAttribute.keySet()) {
                    startTimestamp.setAttribute(str2, this.innerAttribute.get(str2));
                }
            }
            Span startSpan = startTimestamp.startSpan(this);
            int i3 = C8650b.f292947a[this.status.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    startSpan.setStatus(StatusCode.UNSET);
                } else {
                    startSpan.setStatus(StatusCode.ERROR, this.errorMessage);
                }
            } else {
                startSpan.setStatus(StatusCode.OK);
            }
            startSpan.end(this.endTime, TimeUnit.NANOSECONDS);
        } catch (Exception e16) {
            QLog.e("ZPlanTracingExternalSpanData", 1, "handleReportZPlanTracingSpan exception", e16);
        }
    }

    @NotNull
    public final Map<String, String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Map) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.innerAttribute;
    }

    public final void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.endTime = j3;
        }
    }

    public final void d(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.errorMessage = str;
        }
    }

    public final void e(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }
    }

    public final void f(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.parentId = str;
        }
    }

    public final void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.startTime = j3;
        }
    }

    @Override // com.tencent.opentelemetry.api.trace.ExternalSpanData
    @NotNull
    public String getSpanId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.zplanSpanId;
    }

    @Override // com.tencent.opentelemetry.api.trace.ExternalSpanData
    @NotNull
    public String getTraceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.zplanTraceId;
    }

    public final void h(@NotNull StatusCode statusCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) statusCode);
        } else {
            Intrinsics.checkNotNullParameter(statusCode, "<set-?>");
            this.status = statusCode;
        }
    }
}
