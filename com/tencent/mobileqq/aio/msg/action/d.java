package com.tencent.mobileqq.aio.msg.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006R,\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u0012\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/action/d;", "", "", "b", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/msg/action/a;", "updater", "Lcom/tencent/mobileqq/aio/msg/action/c;", "a", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msg/action/b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getMFactoryList$annotations", "()V", "mFactoryList", "<init>", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f190103a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/AIO/msg/Inject_AIO_Msg_Action_Factory.yml", version = 1)
    @NotNull
    private static ArrayList<b> mFactoryList;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f190105c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f190105c = arrayList;
        arrayList.add(com.tencent.robot.aio.actionbar.a.class);
        f190103a = new d();
        mFactoryList = new ArrayList<>();
        b();
        QLog.i("MsgActionFactoryInject", 2, "[init] count: " + mFactoryList.size());
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void b() {
        com.tencent.mobileqq.qroute.utils.b.c(f190105c, mFactoryList);
        QLog.i("MsgActionFactoryInject", 2, "injected");
    }

    @Nullable
    public final c a(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull a updater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext, (Object) updater);
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        if (aioContext == null) {
            return null;
        }
        for (b bVar : mFactoryList) {
            if (bVar.b(aioContext)) {
                return bVar.a(aioContext, updater);
            }
        }
        return null;
    }
}
