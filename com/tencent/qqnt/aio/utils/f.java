package com.tencent.qqnt.aio.utils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOFactoryClassApi;
import com.tencent.qqnt.aio.api.IPreloadUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\n*\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006J \u0010\u0012\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/utils/f;", "", "", "e", "Landroid/content/Intent;", "intent", "Lkotlin/Pair;", "", "", "b", "", "f", "", "containerId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/tencent/qqnt/aio/api/IAIOFactoryClassApi;", "mFactoryApi", "c", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f352295a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47921);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f352295a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        f352295a.e();
    }

    private final void e() {
        QLog.i("AIOPreLoad", 1, "runOtherPreloadTask");
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            com.tencent.qqnt.aio.factory.b.f349915a.a(new com.tencent.qqnt.aio.factory.a(1, false, false, null, 14, null));
            ((IPreloadUtils) QRoute.api(IPreloadUtils.class)).preload();
            QLog.d("AIOPreLoad", 1, "refreshInject: " + com.tencent.mobileqq.aio.msglist.holder.external.a.b().size());
            return;
        }
        aVar.b("runOtherPreloadTask");
        String str = "AIO#runOtherPreloadTask";
        if (!aVar.h()) {
            com.tencent.qqnt.aio.factory.b.f349915a.a(new com.tencent.qqnt.aio.factory.a(1, false, false, null, 14, null));
            ((IPreloadUtils) QRoute.api(IPreloadUtils.class)).preload();
            QLog.d("AIOPreLoad", 1, "refreshInject: " + com.tencent.mobileqq.aio.msglist.holder.external.a.b().size());
            Unit unit = Unit.INSTANCE;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.qqnt.aio.factory.b.f349915a.a(new com.tencent.qqnt.aio.factory.a(1, false, false, null, 14, null));
            ((IPreloadUtils) QRoute.api(IPreloadUtils.class)).preload();
            QLog.d("AIOPreLoad", 1, "refreshInject: " + com.tencent.mobileqq.aio.msglist.holder.external.a.b().size());
            Unit unit2 = Unit.INSTANCE;
            Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
        }
        aVar.e();
    }

    @NotNull
    public final Pair<String, Long> b(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        return TuplesKt.to(intent.getStringExtra("key_peerId"), Long.valueOf(intent.getLongExtra("key_peerUin", 0L)));
    }

    public final void c(@IdRes int containerId, @NotNull FragmentManager fragmentManager, @NotNull IAIOFactoryClassApi mFactoryApi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(containerId), fragmentManager, mFactoryApi);
            return;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(mFactoryApi, "mFactoryApi");
        String c2CAIOFactory = mFactoryApi.getC2CAIOFactory();
        String groupAIOFactory = mFactoryApi.getGroupAIOFactory();
        QLog.d("AIOPreLoad", 1, "preLoadAIO  " + c2CAIOFactory + "  groupAIOFactory " + groupAIOFactory);
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            com.tencent.aio.main.engine.a aVar2 = com.tencent.aio.main.engine.a.f69376a;
            Bundle bundle = new Bundle();
            bundle.putBoolean("Key_toggle_opt_dispatcher", AIOOptConfigKt.j());
            bundle.putBoolean("key_toggle_opt_concurrent_initialization", AIOOptConfigKt.l());
            Unit unit = Unit.INSTANCE;
            aVar2.a(fragmentManager, containerId, bundle, c2CAIOFactory, groupAIOFactory);
        } else {
            aVar.b("preLoadAIOC2CGroupAIOFactory");
            String str = "AIO#preLoadAIOC2CGroupAIOFactory";
            if (!aVar.h()) {
                com.tencent.aio.main.engine.a aVar3 = com.tencent.aio.main.engine.a.f69376a;
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("Key_toggle_opt_dispatcher", AIOOptConfigKt.j());
                bundle2.putBoolean("key_toggle_opt_concurrent_initialization", AIOOptConfigKt.l());
                Unit unit2 = Unit.INSTANCE;
                aVar3.a(fragmentManager, containerId, bundle2, c2CAIOFactory, groupAIOFactory);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.aio.main.engine.a aVar4 = com.tencent.aio.main.engine.a.f69376a;
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("Key_toggle_opt_dispatcher", AIOOptConfigKt.j());
                bundle3.putBoolean("key_toggle_opt_concurrent_initialization", AIOOptConfigKt.l());
                Unit unit3 = Unit.INSTANCE;
                aVar4.a(fragmentManager, containerId, bundle3, c2CAIOFactory, groupAIOFactory);
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar.e();
        }
        Iterator<T> it = com.tencent.qqnt.aio.shortcutbar.k.f352115a.a(2).a(2, "0").iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.aio.shortcutbar.a) it.next()).b();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                f.d();
            }
        }, 16, null, true);
    }

    public final boolean f(@NotNull Pair<String, Long> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pair)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(pair, "<this>");
        if (pair.getFirst() == null && pair.getSecond().longValue() == 0) {
            return false;
        }
        return true;
    }
}
