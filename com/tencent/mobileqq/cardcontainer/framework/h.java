package com.tencent.mobileqq.cardcontainer.framework;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/h;", "", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardDataList", "a", "Lcom/tencent/mobileqq/cardcontainer/framework/h$a;", "b", "Ljava/util/List;", "cardDataFilters", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f201126a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> cardDataFilters;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/h$a;", "", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardDataList", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {
        @NotNull
        List<com.tencent.mobileqq.cardcontainer.data.a> a(@NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/cardcontainer/framework/h$b", "Lcom/tencent/mobileqq/cardcontainer/framework/h$a;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardDataList", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.framework.h.a
        @NotNull
        public List<com.tencent.mobileqq.cardcontainer.data.a> a(@NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cardDataList);
            }
            Intrinsics.checkNotNullParameter(cardDataList, "cardDataList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : cardDataList) {
                if (!com.tencent.mobileqq.cardcontainer.config.a.INSTANCE.a().d().contains(((com.tencent.mobileqq.cardcontainer.data.a) obj).c())) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/cardcontainer/framework/h$c", "Lcom/tencent/mobileqq/cardcontainer/framework/h$a;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardDataList", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.framework.h.a
        @NotNull
        public List<com.tencent.mobileqq.cardcontainer.data.a> a(@NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cardDataList);
            }
            Intrinsics.checkNotNullParameter(cardDataList, "cardDataList");
            return com.tencent.mobileqq.cardcontainer.b.f201051a.a(cardDataList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/cardcontainer/framework/h$d", "Lcom/tencent/mobileqq/cardcontainer/framework/h$a;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardDataList", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.framework.h.a
        @NotNull
        public List<com.tencent.mobileqq.cardcontainer.data.a> a(@NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cardDataList);
            }
            Intrinsics.checkNotNullParameter(cardDataList, "cardDataList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : cardDataList) {
                if (k.f201131a.c(((com.tencent.mobileqq.cardcontainer.data.a) obj).c())) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    static {
        List<a> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40394);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f201126a = new h();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new b(), new c(), new d()});
        cardDataFilters = listOf;
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    @NotNull
    public static final List<com.tencent.mobileqq.cardcontainer.data.a> a(@NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList) {
        Intrinsics.checkNotNullParameter(cardDataList, "cardDataList");
        Iterator<T> it = cardDataFilters.iterator();
        List list = cardDataList;
        while (it.hasNext()) {
            list = ((a) it.next()).a(list);
        }
        if (list.size() != cardDataList.size()) {
            QLog.i("CardContainer.CardDataFilter", 1, "[filterCardData] filter result: " + list.size() + "/" + cardDataList.size());
        }
        return list;
    }
}
