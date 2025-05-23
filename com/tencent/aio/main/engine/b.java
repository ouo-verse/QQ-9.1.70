package com.tencent.aio.main.engine;

import android.R;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aio.api.frame.IAIOFramesProvider;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.d;
import com.tencent.aio.main.fragment.ChatFragment;
import com.tencent.aio.monitor.PerfTimeCollector;
import com.tencent.aio.runtime.emitter.AIOFunctionEmitter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0002J,\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012JX\u0010\u001a\u001a\u00020\u0014\"\b\b\u0000\u0010\u0017*\u00020\u0016\"\f\b\u0001\u0010\u0019*\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/aio/main/engine/b;", "", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Landroidx/fragment/app/FragmentManager;", "fm", "", "containerId", "Lcom/tencent/aio/api/frame/IAIOFramesProvider;", "frameProvider", "Lcom/tencent/aio/main/fragment/ChatFragment;", "a", "Landroid/os/Bundle;", "bundle", "chatFragment", "", "e", "f", "Lcom/tencent/aio/api/perf/a;", "startUpTimeCallback", "Lus/a;", "c", "Landroid/view/ViewGroup;", "T", "Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;", "K", "g", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final b f69377a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44777);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f69377a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    private final ChatFragment a(AIOParam aioParam, FragmentManager fm5, int containerId, IAIOFramesProvider<?, ?> frameProvider) {
        ChatFragment chatFragment;
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        aVar.b("innerStartAIO");
        Bundle bundle = new Bundle();
        bundle.putParcelable("aio_param", aioParam);
        Fragment findFragmentByTag = fm5.findFragmentByTag(ChatFragment.FRAGMENT_TAG);
        FragmentTransaction beginTransaction = fm5.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
        ts.b q16 = aioParam.q();
        if (findFragmentByTag != null && (findFragmentByTag instanceof ChatFragment)) {
            chatFragment = (ChatFragment) findFragmentByTag;
            chatFragment.setPreparedFrameProvider$sdk_debug(frameProvider);
            d.a(chatFragment, aioParam);
            chatFragment.attachAssistance(q16);
            if (chatFragment.isVisible()) {
                FragmentManager fragmentManager = chatFragment.getFragmentManager();
                if (fragmentManager != null && fragmentManager.isStateSaved()) {
                    com.tencent.aio.base.log.a.f69187b.d("AIOStartEngine", "chatFragment  isStateSaved");
                    f(bundle, chatFragment);
                } else {
                    com.tencent.aio.base.log.a.f69187b.d("AIOStartEngine", "isVisible start");
                    e(bundle, chatFragment);
                }
            } else {
                com.tencent.aio.base.log.a.f69187b.d("AIOStartEngine", "no visible start");
                chatFragment.onNewIntent(bundle);
                beginTransaction.show(findFragmentByTag);
                beginTransaction.commitAllowingStateLoss();
            }
        } else {
            com.tencent.aio.base.log.a.f69187b.d("AIOStartEngine", "first start");
            ChatFragment a16 = ChatFragment.INSTANCE.a(bundle);
            a16.setPreparedFrameProvider$sdk_debug(frameProvider);
            d.a(a16, aioParam);
            a16.attachAssistance(q16);
            beginTransaction.add(containerId, a16, ChatFragment.FRAGMENT_TAG);
            beginTransaction.show(a16);
            beginTransaction.commitAllowingStateLoss();
            chatFragment = a16;
        }
        aVar.e();
        return chatFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ChatFragment b(b bVar, AIOParam aIOParam, FragmentManager fragmentManager, int i3, IAIOFramesProvider iAIOFramesProvider, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = R.id.content;
        }
        if ((i16 & 8) != 0) {
            iAIOFramesProvider = new com.tencent.aio.widget.a();
        }
        return bVar.a(aIOParam, fragmentManager, i3, iAIOFramesProvider);
    }

    public static /* synthetic */ us.a d(b bVar, AIOParam aIOParam, FragmentManager fragmentManager, int i3, com.tencent.aio.api.perf.a aVar, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = R.id.content;
        }
        if ((i16 & 8) != 0) {
            aVar = null;
        }
        return bVar.c(aIOParam, fragmentManager, i3, aVar);
    }

    private final void e(Bundle bundle, ChatFragment chatFragment) {
        com.tencent.aio.base.log.a.f69187b.d("AIOStartEngine", "reuse start");
        chatFragment.onHiddenChanged(true);
        chatFragment.onNewIntent(bundle);
        chatFragment.onHiddenChanged(false);
    }

    private final void f(Bundle bundle, ChatFragment chatFragment) {
        com.tencent.aio.base.log.a.f69187b.d("AIOStartEngine", "startAIOFragmentInAIOFragmentWithStateSaved");
        chatFragment.onHiddenChanged(true);
        chatFragment.onNewIntent(bundle);
        chatFragment.onCreate$sdk_debug();
    }

    @NotNull
    public final us.a c(@NotNull AIOParam aioParam, @NotNull FragmentManager fm5, int containerId, @Nullable com.tencent.aio.api.perf.a startUpTimeCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (us.a) iPatchRedirector.redirect((short) 1, this, aioParam, fm5, Integer.valueOf(containerId), startUpTimeCallback);
        }
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        if (startUpTimeCallback != null) {
            PerfTimeCollector.f69389c.b(startUpTimeCallback);
        }
        PerfTimeCollector.f69389c.c();
        return b(this, aioParam, fm5, containerId, null, 8, null).getProvider$sdk_debug();
    }

    @NotNull
    public final <T extends ViewGroup, K extends AIOFunctionEmitter<?>> us.a g(@NotNull AIOParam aioParam, @NotNull FragmentManager fm5, int containerId, @Nullable com.tencent.aio.api.perf.a startUpTimeCallback, @NotNull IAIOFramesProvider<T, K> frameProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (us.a) iPatchRedirector.redirect((short) 2, this, aioParam, fm5, Integer.valueOf(containerId), startUpTimeCallback, frameProvider);
        }
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(frameProvider, "frameProvider");
        if (startUpTimeCallback != null) {
            PerfTimeCollector.f69389c.b(startUpTimeCallback);
        }
        PerfTimeCollector.f69389c.c();
        return a(aioParam, fm5, containerId, frameProvider).getProvider$sdk_debug();
    }
}
