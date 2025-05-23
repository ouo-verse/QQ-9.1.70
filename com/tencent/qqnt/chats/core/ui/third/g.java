package com.tencent.qqnt.chats.core.ui.third;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u000fJ\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R<\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/g;", "", "", "Lcom/tencent/qqnt/chats/core/ui/third/f;", "list", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/chats/core/ui/third/g$a;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getParamsProviders", "()Ljava/util/ArrayList;", "getParamsProviders$annotations", "()V", "paramsProviders", "c", "Ljava/util/List;", "getProvider", "()Ljava/util/List;", "provider", "<init>", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f354998a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ThirdView.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<a>> paramsProviders;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> provider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/g$a;", "", "", "Lcom/tencent/qqnt/chats/core/ui/third/f;", "existList", "", "update", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface a {
        void update(@NotNull List<f> existList);
    }

    static {
        int collectionSizeOrDefault;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43470);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f354998a = new g();
        ArrayList<Class<a>> arrayList = new ArrayList<>();
        paramsProviders = arrayList;
        arrayList.add(com.tencent.qqnt.chats.main.func.littleear.a.class);
        arrayList.add(com.tencent.mobileqq.activity.home.chats.biz.tianshu.b.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Object newInstance = ((Class) it.next()).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.ui.third.ThirdViewParamsInject.IThirdViewPramsProvider");
            arrayList2.add((a) newInstance);
        }
        provider = arrayList2;
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<f> a(@NotNull List<f> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator<T> it = provider.iterator();
        while (it.hasNext()) {
            ((a) it.next()).update(arrayList);
        }
        return arrayList;
    }
}
