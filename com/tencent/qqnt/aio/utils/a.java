package com.tencent.qqnt.aio.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/utils/a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/tencent/aio/data/AIOContact;", "b", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "a", "aioContact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "c", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f352276a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52464);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f352276a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AIOContact b(FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragmentManager.fragments");
        AIOContact aIOContact = null;
        for (Fragment fragment : fragments) {
            if (fragment instanceof com.tencent.qqnt.aio.e) {
                return ((com.tencent.qqnt.aio.e) fragment).getAIOContact();
            }
            if (fragment.isAdded()) {
                a aVar = f352276a;
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "it.childFragmentManager");
                aIOContact = aVar.b(childFragmentManager);
                if (aIOContact != null) {
                    break;
                }
            }
        }
        return aIOContact;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final AIOContact a(@NotNull FragmentActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOContact) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof com.tencent.qqnt.aio.e) {
            return ((com.tencent.qqnt.aio.e) activity).getAIOContact();
        }
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        return b(supportFragmentManager);
    }

    @NotNull
    public final Contact c(@NotNull AIOContact aioContact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Contact) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioContact);
        }
        Intrinsics.checkNotNullParameter(aioContact, "aioContact");
        return new Contact(aioContact.e(), aioContact.j(), "");
    }
}
