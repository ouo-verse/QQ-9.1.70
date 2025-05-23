package com.tencent.qqnt.graytips.decoder;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.graytips.decoder.buddy.BuddyGrayDecoderProvider;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernelpublic.nativeinterface.BuddyGrayElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/b;", "Lcom/tencent/qqnt/graytips/decoder/f;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/BuddyGrayElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/graytips/util/h$a;", "b", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", "a", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements f {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final h.a b(BuddyGrayElement element) {
        com.tencent.qqnt.graytips.decoder.buddy.a aVar = BuddyGrayDecoderProvider.INSTANCE.a().get(element.type);
        if (aVar == null) {
            aVar = new com.tencent.qqnt.graytips.decoder.buddy.c();
        }
        return aVar.a(element);
    }

    @Override // com.tencent.qqnt.graytips.decoder.f
    @NotNull
    public h.a a(@NotNull GrayTipElement element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        BuddyGrayElement buddyGrayElement = element.buddyElement;
        if (buddyGrayElement != null) {
            Intrinsics.checkNotNullExpressionValue(buddyGrayElement, "element.buddyElement");
            return b(buddyGrayElement);
        }
        String grayTipElement = element.toString();
        Intrinsics.checkNotNullExpressionValue(grayTipElement, "element.toString()");
        return new h.a(zw3.a.b(grayTipElement));
    }
}
