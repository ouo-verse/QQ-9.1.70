package com.tencent.mobileqq.troop.homework.entry.ui.utils;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d;", "", "", "", "domains", "", "domainToPsKeyMap", "", "Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d$b;", "d", "([Ljava/lang/String;Ljava/util/Map;)Ljava/util/List;", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d$a;", "callback", "", "c", "(Lmqq/app/AppRuntime;[Ljava/lang/String;Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d$a;)V", "Landroid/content/Context;", "context", "e", "<init>", "()V", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f297051a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d$a;", "", "", "Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d$b;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void onFailed(@Nullable String msg2);

        void onSuccess(@NotNull List<b> pSKeys);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/entry/ui/utils/d$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "b", "value", "c", "Z", "isExpired", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String domain;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String value;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isExpired;

        public b(@NotNull String domain, @Nullable String str, boolean z16) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, domain, str, Boolean.valueOf(z16));
                return;
            }
            this.domain = domain;
            this.value = str;
            this.isExpired = z16;
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.value;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.domain, bVar.domain) && Intrinsics.areEqual(this.value, bVar.value) && this.isExpired == bVar.isExpired) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int hashCode2 = this.domain.hashCode() * 31;
            String str = this.value;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i3 = (hashCode2 + hashCode) * 31;
            boolean z16 = this.isExpired;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "TroopHWPsKey(domain=" + this.domain + ", value=" + this.value + ", isExpired=" + this.isExpired + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/homework/entry/ui/utils/d$c", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f297055a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f297056b;

        c(String[] strArr, a aVar) {
            this.f297055a = strArr;
            this.f297056b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) strArr, (Object) aVar);
            }
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("TroopHWTicketManager", 1, "getPsKey Failed errMsg:" + errMsg);
            this.f297056b.onFailed(errMsg);
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToKeyMap);
                return;
            }
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            List<b> d16 = d.f297051a.d(this.f297055a, domainToKeyMap);
            QLog.d("TroopHWTicketManager", 1, "getPsKey Success");
            this.f297056b.onSuccess(d16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50887);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f297051a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<b> d(String[] domains, Map<String, String> domainToPsKeyMap) {
        ArrayList arrayList = new ArrayList();
        for (String str : domains) {
            arrayList.add(new b(str, domainToPsKeyMap.get(str), false));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context) {
        QQToast.makeText(context, "\u767b\u5f55\u6001\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u6216\u7a0d\u540e\u91cd\u8bd5\uff01", 0).show();
    }

    public final void c(@Nullable AppRuntime appRuntime, @NotNull String[] domains, @NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, domains, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String arrays = Arrays.toString(domains);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.d("TroopHWTicketManager", 1, "getPsKeysAsync,domains:" + arrays);
        if (appRuntime == null) {
            QLog.e("TroopHWTicketManager", 1, "getPsKeysAsync | app is null");
            callback.onFailed("appInterface is null");
        } else {
            if (!appRuntime.isLogin()) {
                QLog.e("TroopHWTicketManager", 1, "getPsKeysAsync | app not login");
                callback.onFailed("not login");
                return;
            }
            Object[] copyOf = Arrays.copyOf(domains, domains.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IPskeyManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026essConstant.ALL\n        )");
            ((IPskeyManager) runtimeService).getPskey((String[]) copyOf, new c(domains, callback));
        }
    }

    public final void e(@Nullable final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.entry.ui.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.f(context);
                }
            });
        }
    }
}
