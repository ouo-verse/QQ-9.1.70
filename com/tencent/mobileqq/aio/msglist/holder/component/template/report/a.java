package com.tencent.mobileqq.aio.msglist.holder.component.template.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\f\u0010\u000b\u001a\u00020\n*\u00020\tH\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00108\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R6\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0015j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\u00168\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\"\u0010 \u001a\u00020\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/a;", "", "Lcom/tencent/mobileqq/aio/msg/template/d;", "templateInfo", "", "a", "", AdMetricTag.EVENT_NAME, "b", "", "", "g", "Lcom/tencent/mobileqq/aio/msg/template/d;", "f", "()Lcom/tencent/mobileqq/aio/msg/template/d;", "templateMsgInfo", "", "J", "e", "()J", "startTime", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "params", "d", "Z", "()Z", "setReported", "(Z)V", "reported", "<init>", "(Lcom/tencent/mobileqq/aio/msg/template/d;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d templateMsgInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> params;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean reported;

    public a(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            return;
        }
        this.templateMsgInfo = dVar;
        this.startTime = System.currentTimeMillis();
        this.params = new HashMap<>();
    }

    private final void a(d templateInfo) {
        if (templateInfo == null) {
            this.params.put("app_name", "info_null");
            this.params.put("biz_src", "info_null");
            this.params.put("view", "info_null");
            return;
        }
        HashMap<String, Object> hashMap = this.params;
        String a16 = templateInfo.a();
        String str = "null";
        if (a16 == null) {
            a16 = "null";
        }
        hashMap.put("app_name", a16);
        HashMap<String, Object> hashMap2 = this.params;
        String b16 = templateInfo.b();
        if (b16 == null) {
            b16 = "null";
        }
        hashMap2.put("biz_src", b16);
        HashMap<String, Object> hashMap3 = this.params;
        String f16 = templateInfo.f();
        if (f16 != null) {
            str = f16;
        }
        hashMap3.put("view", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(@NotNull String eventName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) eventName);
            return;
        }
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        a(this.templateMsgInfo);
        ((ITroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITroopApi.class)).troopBeaconReport(eventName, this.params);
        this.reported = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashMap<String, Object> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.params;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.reported;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.startTime;
    }

    @Nullable
    public final d f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.templateMsgInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null) {
            return z16 ? 1 : 0;
        }
        if (iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, z16)).intValue();
        }
        return z16 ? 1 : 0;
    }
}
