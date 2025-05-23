package com.tencent.qqnt.http.okhttp3;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.dns.NtDnsManager;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\tB\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/http/okhttp3/a;", "Lokhttp3/Dns;", "", "dnsSource", "hostname", "", "Ljava/net/InetAddress;", "ipList", "", "a", "lookup", "Lcom/tencent/qqnt/http/api/a;", "Lcom/tencent/qqnt/http/api/a;", "getDnsResolver", "()Lcom/tencent/qqnt/http/api/a;", "dnsResolver", "<init>", "(Lcom/tencent/qqnt/http/api/a;)V", "b", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements Dns {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.http.api.a dnsResolver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/http/okhttp3/a$a;", "", "", "DNS_TYPE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.http.okhttp3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34057);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@Nullable com.tencent.qqnt.http.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.dnsResolver = aVar;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private final void a(String dnsSource, String hostname, List<? extends InetAddress> ipList) {
        String joinToString$default;
        if (QLog.isColorLevel()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(ipList, null, null, null, 0, null, null, 63, null);
            QLog.d("NTHttp.DNS", 2, "lookup by " + dnsSource + " hostname:" + hostname + " ipList:" + joinToString$default);
        }
    }

    @Override // okhttp3.Dns
    @NotNull
    public List<InetAddress> lookup(@NotNull String hostname) {
        boolean z16;
        int collectionSizeOrDefault;
        List<InetAddress> filterNotNull;
        List<InetAddress> plus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hostname);
        }
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        com.tencent.qqnt.http.api.a aVar = this.dnsResolver;
        if (aVar != null) {
            List<InetAddress> lookup = aVar.lookup(hostname);
            List<InetAddress> list = lookup;
            boolean z17 = false;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(lookup);
                List<InetAddress> list2 = filterNotNull;
                if (!list2.isEmpty()) {
                    a("customResolveResult", hostname, filterNotNull);
                    if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("100820", false)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("NTHttp.DNS", 2, "FreesiaWrapperImpl 100820 open true ");
                        }
                        plus = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) Dns.SYSTEM.lookup(hostname));
                        return plus;
                    }
                    return filterNotNull;
                }
            }
            if (this.dnsResolver.useDefaultDns()) {
                ArrayList<String> k3 = NtDnsManager.f355947a.a().k(hostname, -1001);
                if (k3 == null || k3.isEmpty()) {
                    z17 = true;
                }
                if (!z17) {
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(k3, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = k3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(InetAddress.getByName((String) it.next()));
                    }
                    a("defaultResolverResult", hostname, arrayList);
                    return arrayList;
                }
            }
        }
        List<InetAddress> lookup2 = Dns.SYSTEM.lookup(hostname);
        a("systemResolverResult", hostname, lookup2);
        return lookup2;
    }

    public /* synthetic */ a(com.tencent.qqnt.http.api.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
