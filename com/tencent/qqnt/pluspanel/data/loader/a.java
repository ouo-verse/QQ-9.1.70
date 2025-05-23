package com.tencent.qqnt.pluspanel.data.loader;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.api.IAIOContactApi;
import com.tencent.qqnt.pluspanel.api.IHotPicApi;
import com.tencent.qqnt.pluspanel.utils.a;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b \u0010!J*\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J6\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000eH\u0002J \u0010\u0013\u001a\u00020\u00122\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000eH\u0002J\u0018\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000eH\u0002J \u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J>\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0002JB\u0010\u001d\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b0\rj\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b`\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0002JD\u0010\u001e\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b0\rj\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b`\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\"\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/loader/a;", "Lcom/tencent/qqnt/pluspanel/data/loader/d;", "", "appID", "", "curId", "curType", "", "needChild", "Lcom/tencent/qqnt/pluspanel/data/b;", "c", "Lcom/tencent/qqnt/pluspanel/config/b;", "appInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "i", "list", "", "j", "f", "uid", tl.h.F, "source", "", "configList", "e", "Lkotlin/Pair;", "Landroid/os/Bundle;", "g", "a", "b", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/loader/a$a;", "", "", "HOT_PIC_INDEX", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.data.loader.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qqnt.pluspanel.data.b c(int appID, String curId, int curType, boolean needChild) {
        com.tencent.qqnt.pluspanel.config.b f16 = com.tencent.qqnt.pluspanel.config.e.f360364a.f(String.valueOf(appID));
        if (f16 != null) {
            com.tencent.qqnt.pluspanel.data.b bVar = new com.tencent.qqnt.pluspanel.data.b(0);
            bVar.q(f16.r());
            bVar.p(f16.o());
            bVar.w(f16.p());
            bVar.l(f16.h());
            bVar.v(f16.h());
            bVar.m(f16.i());
            bVar.t(f16.n());
            bVar.s(((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).isRobot(curId));
            if (needChild) {
                bVar.n(d(f16, curId, curType));
            }
            if (f16.s() < 1) {
                bVar.p("");
            }
            return bVar;
        }
        if (((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).isRobot(curId)) {
            com.tencent.qqnt.pluspanel.data.b bVar2 = new com.tencent.qqnt.pluspanel.data.b(0);
            bVar2.s(true);
            return bVar2;
        }
        return null;
    }

    private final ArrayList<com.tencent.qqnt.pluspanel.data.b> d(com.tencent.qqnt.pluspanel.config.b appInfo, String curId, int curType) {
        boolean z16;
        boolean z17;
        if (appInfo == null) {
            return null;
        }
        ArrayList<Integer> k3 = appInfo.k();
        ArrayList<com.tencent.qqnt.pluspanel.data.b> arrayList = new ArrayList<>();
        boolean z18 = true;
        if (QQTheme.isNowSimpleUI()) {
            ArrayList<Integer> l3 = appInfo.l();
            if (l3 != null && !l3.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                k3 = appInfo.l();
            }
        }
        if (((IStudyModeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStudyModeApi.class)).isStudyMode()) {
            ArrayList<Integer> q16 = appInfo.q();
            if (q16 != null && !q16.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                k3 = appInfo.q();
            }
        }
        if (k3 != null && !k3.isEmpty()) {
            z18 = false;
        }
        if (z18) {
            return arrayList;
        }
        Iterator<Integer> it = k3.iterator();
        while (it.hasNext()) {
            Integer appId = it.next();
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            com.tencent.qqnt.pluspanel.data.b c16 = c(appId.intValue(), curId, curType, false);
            if (c16 != null) {
                arrayList.add(c16);
            }
        }
        return arrayList;
    }

    private final ArrayList<Integer> e(ArrayList<Integer> source, List<Integer> configList) {
        boolean z16;
        List<Integer> list = configList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return source;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Iterator<Integer> it = configList.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (source.contains(Integer.valueOf(intValue))) {
                arrayList.add(Integer.valueOf(intValue));
            }
        }
        return arrayList;
    }

    private final ArrayList<Integer> f() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        arrayList.add(Integer.valueOf(companion.x()));
        arrayList.add(Integer.valueOf(companion.y()));
        return arrayList;
    }

    private final ArrayList<Pair<Integer, Bundle>> g(List<Integer> list) {
        ArrayList<Pair<Integer, Bundle>> arrayList = new ArrayList<>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Pair<>(Integer.valueOf(((Number) it.next()).intValue()), null));
        }
        return arrayList;
    }

    private final ArrayList<Integer> h(String uid) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).getAppListForRobot(uid));
        return arrayList;
    }

    private final ArrayList<Integer> i() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        j(arrayList);
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        arrayList.add(Integer.valueOf(companion.A()));
        if (((IHotPicApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IHotPicApi.class)).showEntry()) {
            arrayList.add(Integer.valueOf(companion.s()));
        }
        arrayList.add(Integer.valueOf(companion.u()));
        arrayList.add(Integer.valueOf(companion.q()));
        arrayList.add(Integer.valueOf(companion.p()));
        return arrayList;
    }

    private final void j(ArrayList<Integer> list) {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
            list.add(Integer.valueOf(companion.f0()));
            list.add(Integer.valueOf(companion.j0()));
        }
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.d
    @NotNull
    public ArrayList<Pair<Integer, Bundle>> a(@NotNull String curId, int curType) {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) curId, curType);
        }
        Intrinsics.checkNotNullParameter(curId, "curId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ArrayList<Pair<Integer, Bundle>> e16 = com.tencent.qqnt.pluspanel.config.e.f360364a.e();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = e16.iterator();
        while (it.hasNext()) {
            arrayList.add(((Pair) it.next()).getFirst());
        }
        if (peekAppRuntime != null && Intrinsics.areEqual(peekAppRuntime.getCurrentUid(), curId)) {
            QLog.i("C2CAppLoaderInjector", 1, "[fillAppList]: use self applist");
            return g(e(i(), arrayList));
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        IAIOContactApi iAIOContactApi = (IAIOContactApi) companion.a(IAIOContactApi.class);
        if (iAIOContactApi.isRobot(curId)) {
            QLog.i("C2CAppLoaderInjector", 1, "[fillAppList]: use robot applist");
            return g(h(curId));
        }
        if (!iAIOContactApi.isFriend(curId)) {
            QLog.i("C2CAppLoaderInjector", 1, "[fillAppList]: is not friend");
            return g(e(f(), arrayList));
        }
        if (!e16.isEmpty()) {
            QLog.i("C2CAppLoaderInjector", 1, "[fillAppList]: use config app");
            ArrayList<Pair<Integer, Bundle>> arrayList2 = new ArrayList<>();
            for (Pair<Integer, Bundle> pair : e16) {
                if (pair.getFirst().intValue() == com.tencent.qqnt.pluspanel.utils.a.INSTANCE.r()) {
                    com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
                    if (!bVar.isGooglePlayVersion() && !bVar.h(BaseApplication.getContext())) {
                        arrayList2.add(pair);
                    }
                } else {
                    arrayList2.add(pair);
                }
            }
            return arrayList2;
        }
        QLog.i("C2CAppLoaderInjector", 1, "[fillAppList]: use local app");
        a.Companion companion2 = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(companion2.x()), Integer.valueOf(companion2.y()), Integer.valueOf(companion2.u()), Integer.valueOf(companion2.q()), Integer.valueOf(companion2.J()), Integer.valueOf(companion2.p()), Integer.valueOf(companion2.l()), Integer.valueOf(companion2.F()));
        if (QQTheme.isNowSimpleUI()) {
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(companion2.f0()), Integer.valueOf(companion2.j0()));
            arrayListOf.addAll(0, arrayListOf2);
            arrayListOf.add(6, Integer.valueOf(companion2.E()));
        }
        if (((IStudyModeApi) companion.a(IStudyModeApi.class)).isStudyMode()) {
            arrayListOf.remove(Integer.valueOf(companion2.J()));
        }
        return g(arrayListOf);
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.d
    @Nullable
    public com.tencent.qqnt.pluspanel.data.b b(int appID, @NotNull String curId, int curType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.pluspanel.data.b) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(appID), curId, Integer.valueOf(curType));
        }
        Intrinsics.checkNotNullParameter(curId, "curId");
        if (com.tencent.qqnt.pluspanel.config.e.f360364a.f(String.valueOf(appID)) != null) {
            return c(appID, curId, curType, true);
        }
        if (((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).isRobot(curId)) {
            com.tencent.qqnt.pluspanel.data.b bVar = new com.tencent.qqnt.pluspanel.data.b(0);
            bVar.s(true);
            return bVar;
        }
        return null;
    }
}
