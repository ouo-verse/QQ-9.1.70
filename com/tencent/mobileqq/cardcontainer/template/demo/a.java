package com.tencent.mobileqq.cardcontainer.template.demo;

import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\bBm\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/demo/a;", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "c", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "other", "", "b", "a", "", "l", "I", "t", "()I", "u", "(I)V", "color", "dataId", "cardType", "", "busiName", "boxBackground", "boxTitle", "cardSummary", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/b;", "Lkotlin/collections/ArrayList;", "cardItemList", "extrInfo", "reportDate", "<init>", "(ILcom/tencent/mobileqq/cardcontainer/data/CardType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends ContainerData {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int color;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/demo/a$a;", "", "", "dateId", "", "title", "color", "Lcom/tencent/mobileqq/cardcontainer/template/demo/a;", "a", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.demo.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a(int dateId, @NotNull String title, int color) {
            ArrayList arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(dateId), title, Integer.valueOf(color));
            }
            Intrinsics.checkNotNullParameter(title, "title");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("item id", "item title", "item summary", "item summary", "item background", "item scheme", "[item extra data]", "[item report data]"));
            a aVar = new a(dateId, CardType.DemoCardType, "DemoBusiness", "background", title, "card summary " + dateId, arrayListOf, "[extra info]", "[card report data]");
            aVar.u(color);
            return aVar;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i3, @NotNull CardType cardType, @NotNull String busiName, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ArrayList<com.tencent.mobileqq.cardcontainer.data.b> arrayList, @Nullable String str4, @Nullable String str5) {
        super(i3, cardType, busiName, str, str2, str3, arrayList, str4, str5);
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(busiName, "busiName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), cardType, busiName, str, str2, str3, arrayList, str4, str5);
        } else {
            this.color = -7829368;
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    public boolean a(@NotNull com.tencent.mobileqq.cardcontainer.data.a other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) other)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof a) || ((a) other).color != this.color) {
            return false;
        }
        return super.a(other);
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    public boolean b(@NotNull com.tencent.mobileqq.cardcontainer.data.a other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) other)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof a) || n() != ((a) other).n()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.ContainerData, com.tencent.mobileqq.cardcontainer.data.a
    @NotNull
    public CardType c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CardType) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CardType.DemoCardType;
    }

    public final int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.color;
    }

    public final void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.color = i3;
        }
    }
}
