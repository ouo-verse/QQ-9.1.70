package com.tencent.mobileqq.aio.msglist.holder.component.markdown.biz;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.markdown.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004R2\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006`\t8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/biz/a;", "", "", "b", "", "bizId", "Lcom/tencent/qqnt/aio/markdown/b;", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "providers", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f191008a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/AIO/msg/Inject_AIO_Markdown_Business_Provider.yml", version = 1)
    @NotNull
    private static HashMap<String, b> providers;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap f191010c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61267);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        HashMap hashMap = new HashMap();
        f191010c = hashMap;
        hashMap.put("1", com.tencent.mobileqq.aio.msglist.holder.component.markdown.flashtransfer.a.class);
        f191008a = new a();
        providers = new HashMap<>();
        b();
        QLog.i("MarkdownBusinessInject", 1, "[init] count: " + providers.size());
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void b() {
        com.tencent.mobileqq.qroute.utils.b.b(f191010c, providers);
        QLog.i("MarkdownBusinessInject", 1, "injected");
    }

    @Nullable
    public final b a(@NotNull String bizId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bizId);
        }
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        return providers.get(bizId);
    }
}
