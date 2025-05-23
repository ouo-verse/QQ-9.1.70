package com.tencent.mobileqq.aio.factory.inputadorn;

import android.content.Context;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.aio.input.adorn.a;
import com.tencent.mobileqq.aio.input.at.InputAtVBDelegate;
import com.tencent.mobileqq.aio.input.at.InputAtVMDelegate;
import com.tencent.mobileqq.aio.input.draft.InputDraftVMDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.AIOEditTextInitializeVBDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextTalkbackDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.p;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenVBDelegate;
import com.tencent.mobileqq.aio.input.fullscreen.entry.FullScreenBtnVBDelegate;
import com.tencent.mobileqq.aio.input.fullscreen.o;
import com.tencent.mobileqq.aio.input.gag.InputGagVBDelegate;
import com.tencent.mobileqq.aio.input.reply.h;
import com.tencent.mobileqq.aio.input.reply.i;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVBDelegate;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate;
import com.tencent.mobileqq.aio.zhitu.InputRightIconVMDelegate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.smtt.sdk.QbSdk;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0015\u0016\u0012B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J<\u0010\r\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0006\b\u0000\u0012\u00020\u00020\tj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\u0012\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000fj\u0002`\u00110\b2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/inputadorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "e", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "c", "<init>", "()V", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c implements com.tencent.mobileqq.aio.input.adorn.a<com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/inputadorn/c$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.factory.inputadorn.c$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final com.tencent.mobileqq.aio.input.inputbar.viewbinding.a a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.aio.input.inputbar.viewbinding.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return new com.tencent.mobileqq.aio.input.inputbar.viewbinding.a(context);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\n\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0000\u0012\u00020\b0\u0005j\n\u0012\u0006\b\u0000\u0012\u00020\b`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J:\u0010\u000b\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0000\u0012\u00020\b0\u0005j\n\u0012\u0006\b\u0000\u0012\u00020\b`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J:\u0010\f\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0000\u0012\u00020\b0\u0005j\n\u0012\u0006\b\u0000\u0012\u00020\b`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J:\u0010\r\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0000\u0012\u00020\b0\u0005j\n\u0012\u0006\b\u0000\u0012\u00020\b`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J:\u0010\u000e\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0000\u0012\u00020\b0\u0005j\n\u0012\u0006\b\u0000\u0012\u00020\b`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J:\u0010\u000f\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0000\u0012\u00020\b0\u0005j\n\u0012\u0006\b\u0000\u0012\u00020\b`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/inputadorn/c$b;", "", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "a", "d", "e", "c", "b", "f", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f188793a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(QbSdk.CORE_VER_ENABLE_202112);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                f188793a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> a(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
            List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.c[]{new AIOEditTextInitializeVBDelegate(host), new AIOSendMsgVBDelegate(host), new com.tencent.mobileqq.aio.input.inputbar.compat.b(host), new InputEditTextVBDelegate(host), new InputEditTextTalkbackDelegate(host), new com.tencent.mobileqq.aio.input.inputbar.compat.e(host)});
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> b(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
            List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.c[]{new h(host), new com.tencent.mobileqq.aio.zhitu.d(host), new com.tencent.mobileqq.aio.input.draft.b(host), new com.tencent.mobileqq.aio.input.quicksearch.b(host), ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).getAssistedChatInputVBDelegate(host)});
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> c(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
            List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> mutableListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new h(host), new com.tencent.mobileqq.aio.zhitu.d(host), new com.tencent.mobileqq.aio.input.simpleui.b(host), new com.tencent.mobileqq.aio.input.draft.b(host), new com.tencent.mobileqq.aio.input.quicksearch.b(host));
            if (((IAssistedChatAdapterApi) QRoute.api(IAssistedChatAdapterApi.class)).isExperiment(1)) {
                mutableListOf.add(((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).getAssistedChatInputVBDelegate(host));
            }
            return mutableListOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> d(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
            List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.c[]{new FullScreenVBDelegate(host), new FullScreenBtnVBDelegate(host)});
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> e(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
            List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.c[]{new InputAtVBDelegate(host), new h(host), new com.tencent.mobileqq.aio.zhitu.d(host), new InputGagVBDelegate(host), new com.tencent.mobileqq.aio.input.simpleui.b(host), new com.tencent.mobileqq.aio.input.draft.b(host), new com.tencent.mobileqq.aio.input.quicksearch.b(host)});
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> f(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
            List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.c[]{new h(host), new com.tencent.mobileqq.aio.input.draft.b(host)});
            return listOf;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\n\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\f\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\r\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\u000e\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\u000f\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\u0010\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/inputadorn/c$c;", "", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "host", "", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "b", "f", "d", "g", "c", "a", "e", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.factory.inputadorn.c$c, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7245c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C7245c f188794a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45913);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
            } else {
                f188794a = new C7245c();
            }
        }

        C7245c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> a(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
            List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new InputDraftVMDelegate(host));
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> b(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
            List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.e[]{new p(host), new com.tencent.mobileqq.aio.input.edit.delegate.e(host), new AIOSendMsgVMDelegate(host), new com.tencent.mobileqq.aio.input.inputbar.compat.d(host)});
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> c(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
            List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.e[]{new i(host), new InputRightIconVMDelegate(host), new com.tencent.mobileqq.aio.input.quicksearch.c(host), ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).getAssistedChatInputVMDelegate(host)});
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> d(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
            List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> mutableListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new i(host), new InputRightIconVMDelegate(host), new com.tencent.mobileqq.aio.input.simpleui.c(host), new com.tencent.mobileqq.aio.input.quicksearch.c(host));
            if (((IAssistedChatAdapterApi) QRoute.api(IAssistedChatAdapterApi.class)).isExperiment(1)) {
                mutableListOf.add(((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).getAssistedChatInputVMDelegate(host));
            }
            return mutableListOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> e(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
            List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (List) iPatchRedirector.redirect((short) 8, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.e[]{new com.tencent.mobileqq.aio.input.fullscreen.entry.c(host), new o(host)});
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> f(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
            List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.e[]{new InputAtVMDelegate(host), new i(host), new InputRightIconVMDelegate(host), new com.tencent.mobileqq.aio.input.gag.e(host), new com.tencent.mobileqq.aio.input.joinstate.a(host), new com.tencent.mobileqq.aio.input.blockstate.c(host), new com.tencent.mobileqq.aio.input.simpleui.c(host), new com.tencent.mobileqq.aio.input.quicksearch.c(host)});
            return listOf;
        }

        @NotNull
        public final List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> g(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
            List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new i(host));
            return listOf;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45914);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return a.C7250a.a(this);
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> c(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
        List plus;
        List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> plus2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        C7245c c7245c = C7245c.f188794a;
        plus = CollectionsKt___CollectionsKt.plus((Collection) c7245c.b(host), (Iterable) c7245c.f(host));
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) c7245c.a(host));
        return plus2;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return a.C7250a.b(this);
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> e(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
        List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> plus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        b bVar = b.f188793a;
        plus = CollectionsKt___CollectionsKt.plus((Collection) bVar.a(host), (Iterable) bVar.e(host));
        return plus;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.inputbar.viewbinding.a b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.inputbar.viewbinding.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.a(context);
    }
}
