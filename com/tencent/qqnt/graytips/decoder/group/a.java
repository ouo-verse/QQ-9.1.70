package com.tencent.qqnt.graytips.decoder.group;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.graytips.action.p;
import com.tencent.qqnt.graytips.decoder.group.c;
import com.tencent.qqnt.graytips.util.a;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernelpublic.nativeinterface.GroupGrayElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GroupGrayElementRole;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/group/a;", "Lcom/tencent/qqnt/graytips/decoder/group/c;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GroupGrayElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/graytips/util/h$a;", "a", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.graytips.decoder.group.c
    @NotNull
    public h.a a(@NotNull GroupGrayElement element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.role == GroupGrayElementRole.KADMIN) {
            h.a aVar = new h.a();
            aVar.f356916a = new SpannableStringBuilder(com.tencent.qqnt.language.a.b(com.tencent.qqnt.language.a.f359318a, R.string.f180033_z, null, 2, null));
            return aVar;
        }
        String b16 = b(element);
        com.tencent.qqnt.graytips.util.a aVar2 = new com.tencent.qqnt.graytips.util.a();
        String str = element.adminUid;
        Intrinsics.checkNotNullExpressionValue(str, "element.adminUid");
        a.C9628a e16 = com.tencent.qqnt.graytips.util.a.c(com.tencent.qqnt.graytips.util.a.d(aVar2, b16, new p(str, b16, null, 4, null), 0, 4, null), com.tencent.qqnt.language.a.b(com.tencent.qqnt.language.a.f359318a, R.string.f180703bs, null, 2, null).toString(), 0, 2, null).e();
        h.a c16 = h.c(e16.a(), e16.b(), true);
        Intrinsics.checkNotNullExpressionValue(c16, "getHighlightMsgText(resu\u2026ult.highlightItems, true)");
        return c16;
    }

    @NotNull
    public String b(@NotNull GroupGrayElement groupGrayElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) groupGrayElement);
        }
        return c.a.a(this, groupGrayElement);
    }
}
