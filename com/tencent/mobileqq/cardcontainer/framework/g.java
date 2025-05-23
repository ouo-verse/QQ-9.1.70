package com.tencent.mobileqq.cardcontainer.framework;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J]\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J6\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ.\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/g;", "", "", "businessType", "cardTemplateType", "cardReportData", "itemReportData", "businessCustomData", "", "clickPosition", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/HashMap;", "", "i", "e", "g", "Lcom/tencent/mobileqq/cardcontainer/j;", "a", "Lcom/tencent/mobileqq/cardcontainer/j;", "daTongReport", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/j;)V", "b", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.cardcontainer.j daTongReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.framework.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40328);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull com.tencent.mobileqq.cardcontainer.j daTongReport) {
        Intrinsics.checkNotNullParameter(daTongReport, "daTongReport");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) daTongReport);
        } else {
            this.daTongReport = daTongReport;
        }
    }

    private final HashMap<String, Object> d(String businessType, String cardTemplateType, String cardReportData, String itemReportData, String businessCustomData, Integer clickPosition) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("business_type", businessType);
        hashMap.put("card_template_type", cardTemplateType);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("cardReportData", cardReportData);
        hashMap2.put("itemReportData", itemReportData);
        hashMap2.put("customReportData", businessCustomData);
        Unit unit = Unit.INSTANCE;
        hashMap.put("service_custom_field", hashMap2);
        if (clickPosition != null) {
            hashMap.put("click_pos", Integer.valueOf(clickPosition.intValue()));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(g this$0, String businessType, String cardTemplateType, String cardReportData, String itemReportData, String businessCustomData, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(businessType, "$businessType");
        Intrinsics.checkNotNullParameter(cardTemplateType, "$cardTemplateType");
        Intrinsics.checkNotNullParameter(cardReportData, "$cardReportData");
        Intrinsics.checkNotNullParameter(itemReportData, "$itemReportData");
        Intrinsics.checkNotNullParameter(businessCustomData, "$businessCustomData");
        this$0.daTongReport.c("em_bas_growth_acceptance_card", this$0.d(businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData, Integer.valueOf(i3)));
        if (QLog.isDevelopLevel()) {
            QLog.d("CardContainer.DaTongReport", 4, "reportClick: businessType: " + businessType + " cardTemplateType: " + cardTemplateType + " cardReportData: " + cardReportData + " itemReportData: " + itemReportData + " customData: " + businessCustomData + " clickPosition: " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(g this$0, String businessType, String cardTemplateType, String cardReportData, String itemReportData, String businessCustomData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(businessType, "$businessType");
        Intrinsics.checkNotNullParameter(cardTemplateType, "$cardTemplateType");
        Intrinsics.checkNotNullParameter(cardReportData, "$cardReportData");
        Intrinsics.checkNotNullParameter(itemReportData, "$itemReportData");
        Intrinsics.checkNotNullParameter(businessCustomData, "$businessCustomData");
        this$0.daTongReport.c("em_bas_card_close", this$0.d(businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData, null));
        if (QLog.isDevelopLevel()) {
            QLog.d("CardContainer.DaTongReport", 4, "reportClose: businessType: " + businessType + " cardTemplateType: " + cardTemplateType + " cardReportData: " + cardReportData + " itemReportData: " + itemReportData + " customData: " + businessCustomData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(g this$0, String businessType, String cardTemplateType, String cardReportData, String itemReportData, String businessCustomData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(businessType, "$businessType");
        Intrinsics.checkNotNullParameter(cardTemplateType, "$cardTemplateType");
        Intrinsics.checkNotNullParameter(cardReportData, "$cardReportData");
        Intrinsics.checkNotNullParameter(itemReportData, "$itemReportData");
        Intrinsics.checkNotNullParameter(businessCustomData, "$businessCustomData");
        this$0.daTongReport.b("em_bas_growth_acceptance_card", this$0.d(businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData, 0));
        if (QLog.isDevelopLevel()) {
            QLog.d("CardContainer.DaTongReport", 4, "reportExposure: businessType: " + businessType + " cardTemplateType: " + cardTemplateType + " cardReportData: " + cardReportData + " itemReportData: " + itemReportData + " customData: " + businessCustomData);
        }
    }

    public final void e(@NotNull final String businessType, @NotNull final String cardTemplateType, @NotNull final String cardReportData, @NotNull final String itemReportData, @NotNull final String businessCustomData, final int clickPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData, Integer.valueOf(clickPosition));
            return;
        }
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(cardTemplateType, "cardTemplateType");
        Intrinsics.checkNotNullParameter(cardReportData, "cardReportData");
        Intrinsics.checkNotNullParameter(itemReportData, "itemReportData");
        Intrinsics.checkNotNullParameter(businessCustomData, "businessCustomData");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.framework.e
            @Override // java.lang.Runnable
            public final void run() {
                g.f(g.this, businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData, clickPosition);
            }
        }, 16, null, false);
    }

    public final void g(@NotNull final String businessType, @NotNull final String cardTemplateType, @NotNull final String cardReportData, @NotNull final String itemReportData, @NotNull final String businessCustomData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData);
            return;
        }
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(cardTemplateType, "cardTemplateType");
        Intrinsics.checkNotNullParameter(cardReportData, "cardReportData");
        Intrinsics.checkNotNullParameter(itemReportData, "itemReportData");
        Intrinsics.checkNotNullParameter(businessCustomData, "businessCustomData");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.framework.f
            @Override // java.lang.Runnable
            public final void run() {
                g.h(g.this, businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData);
            }
        }, 16, null, false);
    }

    public final void i(@NotNull final String businessType, @NotNull final String cardTemplateType, @NotNull final String cardReportData, @NotNull final String itemReportData, @NotNull final String businessCustomData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData);
            return;
        }
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(cardTemplateType, "cardTemplateType");
        Intrinsics.checkNotNullParameter(cardReportData, "cardReportData");
        Intrinsics.checkNotNullParameter(itemReportData, "itemReportData");
        Intrinsics.checkNotNullParameter(businessCustomData, "businessCustomData");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.framework.d
            @Override // java.lang.Runnable
            public final void run() {
                g.j(g.this, businessType, cardTemplateType, cardReportData, itemReportData, businessCustomData);
            }
        }, 16, null, false);
    }
}
