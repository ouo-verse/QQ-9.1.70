package com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "setPortraitImageDescrpt", "(Landroidx/lifecycle/MutableLiveData;)V", "portraitImageDescrpt", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "L1", "()Ljava/lang/String;", "N1", "(Ljava/lang/String;)V", "nameText", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<String> portraitImageDescrpt;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String nameText;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.portraitImageDescrpt = new MutableLiveData<>();
            this.nameText = "";
        }
    }

    @NotNull
    public final String L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nameText;
    }

    @NotNull
    public final MutableLiveData<String> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.portraitImageDescrpt;
    }

    public final void N1(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nameText = str;
        }
    }
}
