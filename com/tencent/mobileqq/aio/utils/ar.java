package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/ar;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "", "needBrackets", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ar {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ar f194115a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65301);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f194115a = new ar();
        }
    }

    ar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ String b(ar arVar, FaceElement faceElement, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return arVar.a(faceElement, z16);
    }

    @NotNull
    public final String a(@NotNull FaceElement faceElement, boolean needBrackets) {
        String summary;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, faceElement, Boolean.valueOf(needBrackets));
        }
        Intrinsics.checkNotNullParameter(faceElement, "faceElement");
        Integer num = faceElement.pokeType;
        if (num != null && num.intValue() == 1) {
            summary = HardCodeUtil.qqStr(R.string.yss);
        } else if (num != null && num.intValue() == 2) {
            summary = HardCodeUtil.qqStr(R.string.yso);
        } else if (num != null && num.intValue() == 3) {
            summary = HardCodeUtil.qqStr(R.string.ysn);
        } else if (num != null && num.intValue() == 4) {
            summary = HardCodeUtil.qqStr(R.string.ysq);
        } else if (num != null && num.intValue() == 5) {
            summary = HardCodeUtil.qqStr(R.string.ysr);
        } else if (num != null && num.intValue() == 6) {
            summary = HardCodeUtil.qqStr(R.string.ysp);
        } else if (num != null && num.intValue() == 126) {
            summary = faceElement.vaspokeName;
            if (summary == null) {
                summary = HardCodeUtil.qqStr(R.string.yss);
            }
        } else {
            summary = HardCodeUtil.qqStr(R.string.yss);
        }
        if (needBrackets) {
            return "[" + summary + "]";
        }
        Intrinsics.checkNotNullExpressionValue(summary, "summary");
        return summary;
    }
}
