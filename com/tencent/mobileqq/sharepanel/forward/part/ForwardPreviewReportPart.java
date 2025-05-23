package com.tencent.mobileqq.sharepanel.forward.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0016j\b\u0012\u0004\u0012\u00020\b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewReportPart;", "Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewBasePart;", "Lcom/tencent/mobileqq/sharepanel/ioc/b;", "", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "elemId", "", "", "elemParams", "j2", "K1", "X8", "Lcom/tencent/mobileqq/sharepanel/report/b;", "f", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/sharepanel/report/b;", "reportHelper", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", tl.h.F, "Ljava/util/HashSet;", "hasImpElementSet", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ForwardPreviewReportPart extends ForwardPreviewBasePart implements com.tencent.mobileqq.sharepanel.ioc.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy reportHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> hasImpElementSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardPreviewReportPart(@NotNull com.tencent.mobileqq.sharepanel.forward.d param) {
        super(param);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ForwardPreviewReportPart$reportHelper$2.INSTANCE);
            this.reportHelper = lazy;
            this.hasImpElementSet = new HashSet<>();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
    }

    private final com.tencent.mobileqq.sharepanel.report.b E9() {
        return (com.tencent.mobileqq.sharepanel.report.b) this.reportHelper.getValue();
    }

    private final void F9() {
        Map<String, ? extends Object> emptyMap;
        com.tencent.mobileqq.sharepanel.report.b E9 = E9();
        com.tencent.mobileqq.sharepanel.forward.e b16 = B9().b();
        if (b16 == null || (emptyMap = b16.a()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        E9.d("pg_share_send_preview_float", emptyMap);
        E9().h();
    }

    @Override // com.tencent.mobileqq.sharepanel.ioc.b
    public void K1(@NotNull String elemId, @NotNull Map<String, ? extends Object> elemParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) elemId, (Object) elemParams);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(elemParams, "elemParams");
        String b16 = E9().b(elemId, elemParams);
        if (!this.hasImpElementSet.contains(b16)) {
            E9().g(elemId, elemParams);
            this.hasImpElementSet.add(b16);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.ioc.b
    public void X8(@NotNull String elemId, @NotNull Map<String, ? extends Object> elemParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) elemId, (Object) elemParams);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(elemParams, "elemParams");
        E9().e(elemId, elemParams);
    }

    @Override // com.tencent.mobileqq.sharepanel.ioc.b
    public void j2(@NotNull String elemId, @NotNull Map<String, ? extends Object> elemParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) elemId, (Object) elemParams);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(elemParams, "elemParams");
        E9().c(elemId, elemParams);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        F9();
        RFWIocAbilityProvider.g().registerIoc(rootView, this, com.tencent.mobileqq.sharepanel.ioc.b.class);
    }
}
