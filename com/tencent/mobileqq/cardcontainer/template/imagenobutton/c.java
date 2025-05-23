package com.tencent.mobileqq.cardcontainer.template.imagenobutton;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/c;", "Lcom/tencent/mobileqq/cardcontainer/c;", "", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "d", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "", "b", "Lcom/tencent/mobileqq/cardcontainer/f;", "c", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "containerData", "a", "e", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c implements com.tencent.mobileqq.cardcontainer.c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/cardcontainer/template/imagenobutton/c$a", "Lcom/tencent/mobileqq/cardcontainer/f;", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "cardType", "Landroid/view/ViewGroup;", "parentView", "Lcom/tencent/mobileqq/cardcontainer/d;", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mobileqq.cardcontainer.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.f
        @NotNull
        public com.tencent.mobileqq.cardcontainer.d a(@NotNull CardType cardType, @NotNull ViewGroup parentView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.cardcontainer.d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cardType, (Object) parentView);
            }
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            Intrinsics.checkNotNullParameter(parentView, "parentView");
            Context context = parentView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
            return new ImageNoButtonCardView(context);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    @NotNull
    public ContainerData a(@NotNull ContainerData containerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ContainerData) iPatchRedirector.redirect((short) 5, (Object) this, (Object) containerData);
        }
        Intrinsics.checkNotNullParameter(containerData, "containerData");
        return new b(containerData);
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    public boolean b(@NotNull com.tencent.mobileqq.cardcontainer.data.a data) {
        com.tencent.mobileqq.cardcontainer.template.imagenobutton.a t16;
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof b) || (t16 = ((b) data).t()) == null) {
            return false;
        }
        String a16 = t16.a();
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        String e16 = t16.e();
        if (e16 != null && e16.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return false;
        }
        String d16 = t16.d();
        if (d16 != null && d16.length() != 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    @NotNull
    public com.tencent.mobileqq.cardcontainer.f c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.cardcontainer.f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    @NotNull
    public List<CardType> d() {
        List<CardType> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(CardType.ImageNoButton);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }
}
