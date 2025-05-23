package com.tencent.mobileqq.multishare.item;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.multishare.action.ShareActionLine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/multishare/item/b;", "Lcom/tencent/mobileqq/multishare/action/b;", "", "e", "", "d", "a", "Lcom/tencent/mobileqq/multishare/action/ShareActionLine;", "b", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends com.tencent.mobileqq.multishare.action.b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.multishare.action.a
    /* renamed from: a */
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.multishare.action.a
    @NotNull
    /* renamed from: b */
    public ShareActionLine getLine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ShareActionLine) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ShareActionLine.NONE;
    }

    @Override // com.tencent.mobileqq.multishare.action.b
    @NotNull
    /* renamed from: d */
    public String getLabel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.w7l);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.share_componet_v2_more_friends)");
        return qqStr;
    }

    @Override // com.tencent.mobileqq.multishare.action.b
    /* renamed from: e */
    public int getDrawableId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.drawable.dgc;
    }
}
