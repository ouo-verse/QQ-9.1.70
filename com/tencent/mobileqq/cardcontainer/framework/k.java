package com.tencent.mobileqq.cardcontainer.framework;

import android.view.ViewGroup;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/k;", "", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "data", "", "b", "", "c", "viewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/cardcontainer/d;", "a", "I", "nextViewType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "cardTypeToViewTypeMap", "d", "viewTypeToCardTypeMap", "Lcom/tencent/mobileqq/cardcontainer/f;", "e", "cardViewProviderMap", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f201131a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int nextViewType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<CardType, Integer> cardTypeToViewTypeMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, CardType> viewTypeToCardTypeMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, com.tencent.mobileqq.cardcontainer.f> cardViewProviderMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40408);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f201131a = new k();
        nextViewType = 1;
        cardTypeToViewTypeMap = new HashMap<>();
        viewTypeToCardTypeMap = new HashMap<>();
        cardViewProviderMap = new HashMap<>();
        for (com.tencent.mobileqq.cardcontainer.c cVar : com.tencent.mobileqq.cardcontainer.b.f201051a.b()) {
            com.tencent.mobileqq.cardcontainer.f c16 = cVar.c();
            for (CardType cardType : cVar.d()) {
                int i3 = nextViewType;
                nextViewType = i3 + 1;
                cardViewProviderMap.put(Integer.valueOf(i3), c16);
                cardTypeToViewTypeMap.put(cardType, Integer.valueOf(i3));
                viewTypeToCardTypeMap.put(Integer.valueOf(i3), cardType);
            }
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final com.tencent.mobileqq.cardcontainer.d a(int viewType, @NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.cardcontainer.d) iPatchRedirector.redirect((short) 4, (Object) this, viewType, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        com.tencent.mobileqq.cardcontainer.f fVar = cardViewProviderMap.get(Integer.valueOf(viewType));
        if (fVar == null) {
            QLog.w("CardContainer.CardViewFactory", 1, "[createView] provider not found, viewType: " + viewType);
            return null;
        }
        CardType cardType = viewTypeToCardTypeMap.get(Integer.valueOf(viewType));
        if (cardType == null) {
            QLog.w("CardContainer.CardViewFactory", 1, "[createView] invalid view type, viewType: " + viewType);
            return null;
        }
        try {
            return fVar.a(cardType, parent);
        } catch (Throwable th5) {
            QLog.w("CardContainer.CardViewFactory", 1, "[createView] viewType: " + viewType + ", error: " + th5.getMessage());
            return null;
        }
    }

    public final int b(@NotNull CardType data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) data)).intValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Integer num = cardTypeToViewTypeMap.get(data);
        if (num != null) {
            return num.intValue();
        }
        QLog.w("CardContainer.CardViewFactory", 1, "[getViewType] invalid card type: " + data);
        return 0;
    }

    public final boolean c(@NotNull CardType data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        return cardTypeToViewTypeMap.containsKey(data);
    }
}
