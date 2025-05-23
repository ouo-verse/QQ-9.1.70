package com.tencent.mobileqq.cardcontainer;

import android.content.Context;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bR&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0017j\b\u0012\u0004\u0012\u00020\u0006`\u00188\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u001bj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001dR2\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001f0\u001bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001f`\u001c8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/b;", "", "", "e", "d", "", "Lcom/tencent/mobileqq/cardcontainer/c;", "b", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardDataList", "a", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "containerData", "g", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "cardType", "", "f", "Landroid/content/Context;", "context", "", ZPlanPublishSource.FROM_SCHEME, "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "cardProviderList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "cardTypeProviderMap", "Lcom/tencent/mobileqq/cardcontainer/a;", "businessSchemeHandlers", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f201051a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/Chats/Inject_CardContainerBusiness.yml", version = 1)
    @NotNull
    private static ArrayList<c> cardProviderList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<CardType, c> cardTypeProviderMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/Chats/Inject_CardContainerBusiness.yml", version = 1)
    @NotNull
    private static HashMap<String, a> businessSchemeHandlers;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList f201055e;

    /* renamed from: f, reason: collision with root package name */
    private static HashMap f201056f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        HashMap hashMap = new HashMap();
        f201056f = hashMap;
        hashMap.put("qzone", com.tencent.mobileqq.cardcontainer.template.qzone.a.class);
        f201056f.put("DemoBusiness", com.tencent.mobileqq.cardcontainer.template.demo.h.class);
        ArrayList arrayList = new ArrayList();
        f201055e = arrayList;
        arrayList.add(com.tencent.mobileqq.cardcontainer.template.demo.b.class);
        f201055e.add(com.tencent.mobileqq.reminder.chats.notifycard.provider.a.class);
        f201055e.add(com.tencent.mobileqq.cardcontainer.template.avatarbtn.c.class);
        f201055e.add(com.tencent.mobileqq.cardcontainer.template.imagenobutton.c.class);
        f201055e.add(com.tencent.mobileqq.cardcontainer.template.iconbtn.c.class);
        b bVar = new b();
        f201051a = bVar;
        cardProviderList = new ArrayList<>();
        cardTypeProviderMap = new HashMap<>();
        businessSchemeHandlers = new HashMap<>();
        e();
        bVar.d();
        QLog.i("CardContainer.Inject", 2, "[init] provider count: " + cardProviderList.size());
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d() {
        cardTypeProviderMap.clear();
        for (c cVar : cardProviderList) {
            Iterator<T> it = cVar.d().iterator();
            while (it.hasNext()) {
                cardTypeProviderMap.put((CardType) it.next(), cVar);
            }
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void e() {
        com.tencent.mobileqq.qroute.utils.b.b(f201056f, businessSchemeHandlers);
        com.tencent.mobileqq.qroute.utils.b.c(f201055e, cardProviderList);
        QLog.i("CardContainer.Inject", 2, "injected");
    }

    @NotNull
    public final List<com.tencent.mobileqq.cardcontainer.data.a> a(@NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cardDataList);
        }
        Intrinsics.checkNotNullParameter(cardDataList, "cardDataList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : cardDataList) {
            com.tencent.mobileqq.cardcontainer.data.a aVar = (com.tencent.mobileqq.cardcontainer.data.a) obj;
            boolean z17 = false;
            try {
                c cVar = cardTypeProviderMap.get(aVar.c());
                if (cVar != null && cVar.b(aVar)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                } else {
                    QLog.i("CardContainer.Inject", 1, "[filterCardDataShouldShow] cardData should not show, data: " + aVar);
                }
            } catch (Throwable th5) {
                QLog.w("CardContainer.Inject", 1, "[filterCardDataShouldShow] exception occurred, data: " + aVar + ", exc:" + th5);
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<c> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return cardProviderList;
    }

    public final boolean c(@NotNull Context context, @NotNull String scheme, @NotNull ContainerData containerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, context, scheme, containerData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(containerData, "containerData");
        a aVar = businessSchemeHandlers.get(containerData.g());
        if (aVar == null) {
            return false;
        }
        try {
            aVar.a(context, scheme, containerData);
            if (QLog.isDevelopLevel()) {
                QLog.d("CardContainer.Inject", 2, "[doJumpAction] handled by business, scheme:'" + scheme + "', cardItem:" + containerData);
            }
        } catch (Exception e16) {
            QLog.w("CardContainer.Inject", 1, "[doJumpAction] failed to handle by business, scheme:'" + scheme + "', cardItem:" + containerData + " exc:" + e16);
        }
        return true;
    }

    public final boolean f(@NotNull CardType cardType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cardType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        c cVar = cardTypeProviderMap.get(cardType);
        if (cVar != null) {
            return cVar.e();
        }
        return false;
    }

    @Nullable
    public final ContainerData g(@NotNull ContainerData containerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ContainerData) iPatchRedirector.redirect((short) 4, (Object) this, (Object) containerData);
        }
        Intrinsics.checkNotNullParameter(containerData, "containerData");
        c cVar = cardTypeProviderMap.get(containerData.i());
        if (cVar != null) {
            return cVar.a(containerData);
        }
        return null;
    }
}
