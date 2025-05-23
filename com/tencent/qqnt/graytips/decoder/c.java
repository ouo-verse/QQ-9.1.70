package com.tencent.qqnt.graytips.decoder;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernelpublic.nativeinterface.FileReceiptElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/c;", "Lcom/tencent/qqnt/graytips/decoder/f;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/graytips/util/h$a;", "a", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements f {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.graytips.decoder.f
    @NotNull
    public h.a a(@NotNull GrayTipElement element) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        String string = BaseApplication.context.getResources().getString(R.string.zzb);
        FileReceiptElement fileReceiptElement = element.fileReceiptElement;
        if (fileReceiptElement != null) {
            str = fileReceiptElement.fileName;
        } else {
            str = null;
        }
        return new h.a(string + "\"" + str + "\"");
    }
}
