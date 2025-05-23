package com.tencent.mobileqq.cardcontainer.framework;

import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0003R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/j;", "", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "", "a", "cardData", "", "b", "", "clickPosition", "customData", "c", "d", "Lcom/tencent/mobileqq/cardcontainer/j;", "Lcom/tencent/mobileqq/cardcontainer/j;", "daTongReportDelegate", "Lcom/tencent/mobileqq/cardcontainer/framework/g;", "Lcom/tencent/mobileqq/cardcontainer/framework/g;", "daTongReport", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/j;)V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.cardcontainer.j daTongReportDelegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g daTongReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/j$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.framework.j$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40405);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j(@NotNull com.tencent.mobileqq.cardcontainer.j daTongReportDelegate) {
        Intrinsics.checkNotNullParameter(daTongReportDelegate, "daTongReportDelegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) daTongReportDelegate);
        } else {
            this.daTongReportDelegate = daTongReportDelegate;
            this.daTongReport = new g(daTongReportDelegate);
        }
    }

    private final String a(ContainerData containerData) {
        return "{dataId=" + containerData.n() + ",busiName:" + containerData.g() + ",cardType:" + containerData.i() + ",itemId=" + containerData.r();
    }

    public final void b(@NotNull ContainerData cardData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cardData);
            return;
        }
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        this.daTongReportDelegate.a(cardData, 2, null);
        g gVar = this.daTongReport;
        String g16 = cardData.g();
        String value = cardData.i().getValue();
        String p16 = cardData.p();
        if (p16 == null) {
            p16 = "";
        }
        gVar.i(g16, value, p16, cardData.q(), "");
        QLog.d("CardContainer.Report", 1, "[reportCardExposed] type=" + cardData.c() + " cardData=" + a(cardData));
    }

    public final void c(@NotNull ContainerData cardData, int clickPosition, @Nullable String customData) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, cardData, Integer.valueOf(clickPosition), customData);
            return;
        }
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        if (QLog.isDevelopLevel()) {
            QLog.d("CardContainer.Report", 1, "[reportClick] type=" + cardData.c() + " cardData: " + a(cardData) + " element: " + clickPosition);
        }
        if (clickPosition == 1) {
            com.tencent.mobileqq.cardcontainer.j jVar = this.daTongReportDelegate;
            if (customData == null) {
                str3 = "";
            } else {
                str3 = customData;
            }
            jVar.a(cardData, 1, str3);
        }
        g gVar = this.daTongReport;
        String g16 = cardData.g();
        String value = cardData.i().getValue();
        String p16 = cardData.p();
        if (p16 == null) {
            str = "";
        } else {
            str = p16;
        }
        String q16 = cardData.q();
        if (customData == null) {
            str2 = "";
        } else {
            str2 = customData;
        }
        gVar.e(g16, value, str, q16, str2, clickPosition);
    }

    public final void d(@NotNull ContainerData cardData, @Nullable String customData) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cardData, (Object) customData);
            return;
        }
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        if (QLog.isDevelopLevel()) {
            QLog.d("CardContainer.Report", 1, "[reportClosed] type=" + cardData.c() + " cardData: " + a(cardData));
        }
        this.daTongReportDelegate.a(cardData, 3, customData);
        g gVar = this.daTongReport;
        String g16 = cardData.g();
        String value = cardData.i().getValue();
        String p16 = cardData.p();
        if (p16 == null) {
            str = "";
        } else {
            str = p16;
        }
        String q16 = cardData.q();
        if (customData == null) {
            str2 = "";
        } else {
            str2 = customData;
        }
        gVar.g(g16, value, str, q16, str2);
    }
}
