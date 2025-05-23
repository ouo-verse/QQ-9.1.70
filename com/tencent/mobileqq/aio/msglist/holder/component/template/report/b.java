package com.tencent.mobileqq.aio.msglist.holder.component.template.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.TemplateMsgConfigManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/a;", "", "endTime", "sample", "", "j", "", AdMetricTag.EVENT_NAME, "", "i", "(Ljava/lang/String;Ljava/lang/Long;)V", "", "code", "msg", h.F, "Lcom/tencent/mobileqq/aio/msg/template/d;", "templateMsgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/template/d;)V", "e", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/b$a;", "", "", "ERROR_CODE_BIND_VIEW_ERROR", "I", "ERROR_CODE_PARSE_ERROR", "ERROR_CODE_TEMPLATE_NULL", "", "EVENT_NAME_AIO_FAILED", "Ljava/lang/String;", "EVENT_NAME_AIO_SUCCESS", "EVENT_NAME_SHARE_FAILED", "EVENT_NAME_SHARE_SUCCESS", "", "SAMPLE_BASE_POINT", "J", "SAMPLE_POINT", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.report.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63502);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@Nullable d dVar) {
        super(dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        }
    }

    public final void h(@NotNull String eventName, int code, @NotNull String msg2) {
        String str;
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, eventName, Integer.valueOf(code), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (d()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TemplateMsgConfigManager templateMsgConfigManager = TemplateMsgConfigManager.f191899a;
        d f16 = f();
        String str2 = "";
        if (f16 == null || (str = f16.a()) == null) {
            str = "";
        }
        d f17 = f();
        if (f17 != null && (b16 = f17.b()) != null) {
            str2 = b16;
        }
        if (templateMsgConfigManager.j(str, str2) == null) {
            z16 = false;
        }
        c().put("has_config", Integer.valueOf(g(z16)));
        c().put("cost_time", Long.valueOf(currentTimeMillis - e()));
        c().put("error_msg", msg2);
        c().put("error_code", Integer.valueOf(code));
        b(eventName);
    }

    public final void i(@NotNull String eventName, @Nullable Long sample) {
        String str;
        boolean z16;
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eventName, (Object) sample);
            return;
        }
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (d()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (sample != null && !j(currentTimeMillis, sample.longValue())) {
            return;
        }
        TemplateMsgConfigManager templateMsgConfigManager = TemplateMsgConfigManager.f191899a;
        d f16 = f();
        String str2 = "";
        if (f16 == null || (str = f16.a()) == null) {
            str = "";
        }
        d f17 = f();
        if (f17 != null && (b16 = f17.b()) != null) {
            str2 = b16;
        }
        if (templateMsgConfigManager.j(str, str2) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        c().put("has_config", Integer.valueOf(g(z16)));
        c().put("cost_time", Long.valueOf(currentTimeMillis - e()));
        b(eventName);
    }

    protected final boolean j(long endTime, long sample) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(endTime), Long.valueOf(sample))).booleanValue();
        }
        if (endTime % 10000 <= sample) {
            return true;
        }
        return false;
    }
}
