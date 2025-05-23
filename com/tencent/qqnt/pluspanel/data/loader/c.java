package com.tencent.qqnt.pluspanel.data.loader;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR2\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u001bj\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b`\u001c8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/loader/c;", "Lcom/tencent/qqnt/pluspanel/data/loader/e;", "", "g", "Landroid/os/Bundle;", "bundle", "", "uinType", "Lcom/tencent/qqnt/pluspanel/data/loader/d;", "injector", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "Lkotlin/collections/ArrayList;", tl.h.F, "i", "e", "appInfo", "index", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/pluspanel/data/a;", "d", "", "Ljava/lang/String;", "chatId", "f", "I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "appLoaderInjector", "Lcom/tencent/qqnt/pluspanel/data/appinfo/a;", "Lcom/tencent/qqnt/pluspanel/data/appinfo/a;", "appInfoFactory", "<init>", "(Ljava/lang/String;I)V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static HashMap f360422i;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String chatId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int uinType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/PlusPanel/Inject_AppLoader.yml", version = 1)
    @NotNull
    private HashMap<String, d> appLoaderInjector;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.pluspanel.data.appinfo.a appInfoFactory;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40057);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        HashMap hashMap = new HashMap();
        f360422i = hashMap;
        hashMap.put("103", g.class);
        f360422i.put("102", b.class);
        f360422i.put("2", h.class);
        f360422i.put("1", a.class);
    }

    public c(@NotNull String chatId, int i3) {
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatId, i3);
            return;
        }
        this.chatId = chatId;
        this.uinType = i3;
        this.appLoaderInjector = new HashMap<>();
        this.appInfoFactory = new com.tencent.qqnt.pluspanel.data.appinfo.a();
    }

    private final void g() {
        HashMap<String, d> hashMap = this.appLoaderInjector;
        if (hashMap == null || hashMap.isEmpty()) {
            i();
        }
    }

    private final ArrayList<PlusPanelAppInfo> h(Bundle bundle, int uinType, d injector) {
        boolean z16;
        if (bundle == null) {
            return null;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("child_list");
        ArrayList<PlusPanelAppInfo> arrayList = new ArrayList<>();
        if (integerArrayList != null && !integerArrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return arrayList;
        }
        Iterator<Integer> it = integerArrayList.iterator();
        while (it.hasNext()) {
            Integer childId = it.next();
            com.tencent.qqnt.pluspanel.data.appinfo.a aVar = this.appInfoFactory;
            Intrinsics.checkNotNullExpressionValue(childId, "childId");
            PlusPanelAppInfo a16 = aVar.a(uinType, childId.intValue());
            com.tencent.qqnt.pluspanel.data.b b16 = injector.b(childId.intValue(), this.chatId, uinType);
            if (b16 != null && a16 != null) {
                a16.decorate(b16, null);
            }
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.e
    @Nullable
    public com.tencent.qqnt.pluspanel.data.a d(@NotNull PlusPanelAppInfo appInfo, int index, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.pluspanel.data.a) iPatchRedirector.redirect((short) 4, this, appInfo, Integer.valueOf(index), context);
        }
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        return com.tencent.qqnt.pluspanel.utils.b.INSTANCE.a(appInfo, index, context, this.uinType, this.chatId, true);
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.e
    public void e() {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.e();
        g();
        if ((!this.appLoaderInjector.isEmpty()) && (dVar = this.appLoaderInjector.get(String.valueOf(this.uinType))) != null) {
            Iterator<Pair<Integer, Bundle>> it = dVar.a(this.chatId, this.uinType).iterator();
            while (it.hasNext()) {
                Pair<Integer, Bundle> next = it.next();
                int intValue = next.getFirst().intValue();
                ArrayList<PlusPanelAppInfo> h16 = h(next.getSecond(), this.uinType, dVar);
                PlusPanelAppInfo a16 = this.appInfoFactory.a(this.uinType, intValue);
                com.tencent.qqnt.pluspanel.data.b b16 = dVar.b(intValue, this.chatId, this.uinType);
                if (b16 != null && a16 != null) {
                    a16.decorate(b16, h16);
                }
                b(a16);
            }
            f(0, "");
        }
    }

    @QAutoInitMethod
    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            com.tencent.mobileqq.qroute.utils.b.b(f360422i, this.appLoaderInjector);
        }
    }
}
