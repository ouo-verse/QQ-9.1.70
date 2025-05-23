package com.tencent.aio.main.engine;

import android.R;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.fragment.ChatFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J=\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f\"\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aio/main/engine/a;", "", "", "factoryName", "Landroidx/fragment/app/FragmentManager;", "fm", "", "containerId", "Lus/a;", "c", "Landroid/os/Bundle;", "customBundle", "", "factoryNames", "a", "(Landroidx/fragment/app/FragmentManager;ILandroid/os/Bundle;[Ljava/lang/String;)Lus/a;", "Lcom/tencent/aio/data/AIOParam$a;", "aioParamBuilder", "fragmentTAG", "b", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f69376a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44773);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f69376a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public static /* synthetic */ us.a d(a aVar, AIOParam.a aVar2, FragmentManager fragmentManager, String str, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str = ChatFragment.FRAGMENT_TAG;
        }
        if ((i16 & 8) != 0) {
            i3 = R.id.content;
        }
        return aVar.b(aVar2, fragmentManager, str, i3);
    }

    @Nullable
    public final us.a a(@NotNull FragmentManager fm5, int containerId, @NotNull Bundle customBundle, @NotNull String... factoryNames) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (us.a) iPatchRedirector.redirect((short) 2, this, fm5, Integer.valueOf(containerId), customBundle, factoryNames);
        }
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(customBundle, "customBundle");
        Intrinsics.checkNotNullParameter(factoryNames, "factoryNames");
        return d(this, new AIOParam.a().f((String[]) Arrays.copyOf(factoryNames, factoryNames.length)).j(true).h(new AIOSession(new AIOContact(1, "", "", null, 8, null))).a(customBundle).i(true).d(0), fm5, null, containerId, 4, null);
    }

    @Nullable
    public final us.a b(@NotNull AIOParam.a aioParamBuilder, @NotNull FragmentManager fm5, @NotNull String fragmentTAG, int containerId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (us.a) iPatchRedirector.redirect((short) 4, this, aioParamBuilder, fm5, fragmentTAG, Integer.valueOf(containerId));
        }
        Intrinsics.checkNotNullParameter(aioParamBuilder, "aioParamBuilder");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(fragmentTAG, "fragmentTAG");
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            ChatFragment chatFragment = (ChatFragment) fm5.findFragmentByTag(fragmentTAG);
            if (chatFragment == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("aio_param", aioParamBuilder.c());
                ChatFragment a16 = ChatFragment.INSTANCE.a(bundle);
                FragmentTransaction beginTransaction = fm5.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
                beginTransaction.add(containerId, a16, fragmentTAG);
                beginTransaction.hide(a16);
                beginTransaction.commitNowAllowingStateLoss();
                return a16.getProvider$sdk_debug();
            }
            return chatFragment.getProvider$sdk_debug();
        }
        aVar.b("preloadAIO");
        if (!aVar.h()) {
            ChatFragment chatFragment2 = (ChatFragment) fm5.findFragmentByTag(fragmentTAG);
            if (chatFragment2 == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("aio_param", aioParamBuilder.c());
                ChatFragment a17 = ChatFragment.INSTANCE.a(bundle2);
                FragmentTransaction beginTransaction2 = fm5.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction2, "fm.beginTransaction()");
                beginTransaction2.add(containerId, a17, fragmentTAG);
                beginTransaction2.hide(a17);
                beginTransaction2.commitNowAllowingStateLoss();
                return a17.getProvider$sdk_debug();
            }
            return chatFragment2.getProvider$sdk_debug();
        }
        System.currentTimeMillis();
        ChatFragment chatFragment3 = (ChatFragment) fm5.findFragmentByTag(fragmentTAG);
        if (chatFragment3 == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable("aio_param", aioParamBuilder.c());
            ChatFragment a18 = ChatFragment.INSTANCE.a(bundle3);
            FragmentTransaction beginTransaction3 = fm5.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction3, "fm.beginTransaction()");
            beginTransaction3.add(containerId, a18, fragmentTAG);
            beginTransaction3.hide(a18);
            beginTransaction3.commitNowAllowingStateLoss();
            return a18.getProvider$sdk_debug();
        }
        return chatFragment3.getProvider$sdk_debug();
    }

    @Nullable
    public final us.a c(@NotNull String factoryName, @NotNull FragmentManager fm5, int containerId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (us.a) iPatchRedirector.redirect((short) 1, this, factoryName, fm5, Integer.valueOf(containerId));
        }
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        return d(this, new AIOParam.a().e(factoryName).j(true).h(new AIOSession(new AIOContact(1, "", "", null, 8, null))).i(true).d(0), fm5, null, containerId, 4, null);
    }
}
