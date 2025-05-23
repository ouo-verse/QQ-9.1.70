package com.tencent.aio.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aio.api.widget.WidgetsKt;
import com.tencent.aio.main.fragment.ChatFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\f\u001a\u00020\t*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/main/fragment/ChatFragment;", "Landroid/widget/FrameLayout;", "a", "(Lcom/tencent/aio/main/fragment/ChatFragment;)Landroid/widget/FrameLayout;", "chatPieContainer", "Lcom/tencent/mvi/dispatcher/a;", "b", "(Lcom/tencent/aio/main/fragment/ChatFragment;)Lcom/tencent/mvi/dispatcher/a;", "dispatcherExecutor", "Landroid/view/View;", "c", "(Lcom/tencent/aio/main/fragment/ChatFragment;)Landroid/view/View;", "emptyHostView", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ChatFragmentWidgetKt {
    @NotNull
    public static final FrameLayout a(@NotNull final ChatFragment chatPieContainer) {
        Intrinsics.checkNotNullParameter(chatPieContainer, "$this$chatPieContainer");
        return (FrameLayout) chatPieContainer.getRef$sdk_debug("chatPieContainer", new Function0<FrameLayout>() { // from class: com.tencent.aio.widget.ChatFragmentWidgetKt$chatPieContainer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) ChatFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (FrameLayout) iPatchRedirector.redirect((short) 1, (Object) this);
                }
                FrameLayout frameLayout = new FrameLayout(ChatFragment.this.requireContext());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                frameLayout.setId(WidgetsKt.a());
                return frameLayout;
            }
        });
    }

    @NotNull
    public static final com.tencent.mvi.dispatcher.a b(@NotNull ChatFragment dispatcherExecutor) {
        Intrinsics.checkNotNullParameter(dispatcherExecutor, "$this$dispatcherExecutor");
        return (com.tencent.mvi.dispatcher.a) dispatcherExecutor.getRef$sdk_debug("dispatcherExecutor", ChatFragmentWidgetKt$dispatcherExecutor$1.INSTANCE);
    }

    @NotNull
    public static final View c(@NotNull final ChatFragment emptyHostView) {
        Intrinsics.checkNotNullParameter(emptyHostView, "$this$emptyHostView");
        return (View) emptyHostView.getRef$sdk_debug("emptyHostView", new Function0<View>() { // from class: com.tencent.aio.widget.ChatFragmentWidgetKt$emptyHostView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) ChatFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) ? new View(ChatFragment.this.requireContext()) : (View) iPatchRedirector.redirect((short) 1, (Object) this);
            }
        });
    }
}
