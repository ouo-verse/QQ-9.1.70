package com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit;

import com.tencent.cachedrawable.dynamicdrawable.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u03.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/business/dynamicInit/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/dynamicInit/b;", "", "c", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "a", "", "b", "Lcom/tencent/cachedrawable/dynamicdrawable/business/dynamicInit/b;", "getSInstance", "()Lcom/tencent/cachedrawable/dynamicdrawable/business/dynamicInit/b;", "setSInstance", "(Lcom/tencent/cachedrawable/dynamicdrawable/business/dynamicInit/b;)V", "sInstance", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f98862a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/DynamicDrawable/Inject_DynamicInitManager.yml", version = 1)
    @Nullable
    private static b sInstance;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f98864c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8009);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f98864c = arrayList;
        arrayList.add(d.class);
        a aVar = new a();
        f98862a = aVar;
        aVar.c();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit.b
    @NotNull
    public e a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        b bVar = sInstance;
        Intrinsics.checkNotNull(bVar);
        return bVar.a();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit.b
    @NotNull
    public String b() {
        boolean endsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        b bVar = sInstance;
        Intrinsics.checkNotNull(bVar);
        String b16 = bVar.b();
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(b16, separator, false, 2, null);
        if (endsWith$default) {
            return Intrinsics.stringPlus(b16, "dynamic_cache/");
        }
        return b16 + ((Object) separator) + "dynamic_cache/";
    }

    @QAutoInitMethod
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            sInstance = (b) com.tencent.mobileqq.qroute.utils.b.a(f98864c);
        }
    }
}
