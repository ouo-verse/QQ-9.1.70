package com.tencent.qqnt.graytips.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0004\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/graytips/action/h;", "Lcom/tencent/qqnt/graytips/action/f;", "", "getActionType", "a", "I", "b", "()I", "jp", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "param", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/JsonGrayElement;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/JsonGrayElement;", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/JsonGrayElement;", DTConstants.TAG.ELEMENT, "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/kernelpublic/nativeinterface/JsonGrayElement;)V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int jp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String param;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JsonGrayElement element;

    public h(int i3, @NotNull String param, @NotNull JsonGrayElement element) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(element, "element");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), param, element);
            return;
        }
        this.jp = i3;
        this.param = param;
        this.element = element;
    }

    @NotNull
    public final JsonGrayElement a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JsonGrayElement) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.element;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.jp;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.param;
    }

    @Override // com.tencent.qqnt.graytips.action.f
    public int getActionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 84;
    }
}
