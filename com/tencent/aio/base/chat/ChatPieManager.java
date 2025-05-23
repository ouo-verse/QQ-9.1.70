package com.tencent.aio.base.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.tencent.aio.api.factory.g;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.dispatcher.HandlerPoster;
import com.tencent.aio.main.fragment.ChatFragment;
import com.tencent.aio.pref.annotation.HookMethodTrace;
import com.tencent.aio.widget.ChatFragmentWidgetKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 52\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\bT\u0010UJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007J7\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013\u00a2\u0006\u0002\b\u0015J\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%J\u000e\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020(J\u0016\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,J\u0016\u0010/\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,J)\u00105\u001a\u00020\n2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\b\u00104\u001a\u0004\u0018\u000103H\u0000\u00a2\u0006\u0004\b5\u00106J\u000e\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020\u0004J\u000e\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u000209R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010=R$\u0010D\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010FR\"\u0010O\u001a\u00020I8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060Q0P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010R\u00a8\u0006V"}, d2 = {"Lcom/tencent/aio/base/chat/ChatPieManager;", "", "", "factoryName", "", "useDispatcher", "Lcom/tencent/aio/base/chat/ChatPie;", "b", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "e", "Landroid/os/Bundle;", "bundle", "d", "Lcom/tencent/aio/main/fragment/ChatFragment;", "fragment", "Landroid/view/LayoutInflater;", "inflater", "Lkotlin/Function1;", "Lcom/tencent/aio/api/runtime/a;", "Lkotlin/ExtensionFunctionType;", "wrapContext", "Landroid/view/View;", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", DomainData.DOMAIN_NAME, "r", "k", "l", "a", h.F, "isInMultiWindowMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isInPictureInPictureMode", "o", "Landroid/content/res/Configuration;", "newConfig", "i", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "u", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "action", ReportConstant.COSTREPORT_PREFIX, "w", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "g", "(IILandroid/content/Intent;)V", "fitSystemWindows", "v", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "t", "Lcom/tencent/aio/base/chat/ChatPieCache;", "Lcom/tencent/aio/base/chat/ChatPieCache;", "mCache", "Lcom/tencent/aio/base/chat/ChatPie;", "f", "()Lcom/tencent/aio/base/chat/ChatPie;", "setMCurrChatPie$sdk_debug", "(Lcom/tencent/aio/base/chat/ChatPie;)V", "mCurrChatPie", "c", "Z", "mIsPreLoad", "isDestroy", "Landroid/content/Context;", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "", "Ljava/lang/ref/WeakReference;", "Ljava/util/List;", "prepareChatPies", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ChatPieManager {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ChatPieCache mCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ChatPie mCurrChatPie;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPreLoad;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<WeakReference<ChatPie>> prepareChatPies;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/base/chat/ChatPieManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.base.chat.ChatPieManager$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatPieManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mCache = new ChatPieCache();
            this.prepareChatPies = new ArrayList();
        }
    }

    private final ChatPie b(String factoryName, boolean useDispatcher) {
        g b16 = com.tencent.aio.api.factory.b.INSTANCE.b(factoryName);
        Intrinsics.checkNotNull(b16);
        return new ChatPie(b16, useDispatcher);
    }

    static /* synthetic */ ChatPie c(ChatPieManager chatPieManager, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return chatPieManager.b(str, z16);
    }

    private final void e(Lifecycle.Event event) {
        ChatPie chatPie;
        if (!this.isDestroy && (chatPie = this.mCurrChatPie) != null) {
            chatPie.k(event);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.mCache.clear();
        }
    }

    @HookMethodTrace(tag = "ChatPieContainer#createOrReuseChatPie")
    public final void d(@NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        AIOParam aIOParam = (AIOParam) bundle.getParcelable("aio_param");
        if (aIOParam == null) {
            com.tencent.aio.base.log.a.f69187b.e("ChatPieContainer", "createOrReuseChatPie aioParam == null");
            this.mCurrChatPie = null;
            return;
        }
        this.mIsPreLoad = aIOParam.s();
        boolean g16 = ft.a.g(aIOParam);
        if (this.mIsPreLoad) {
            List<String> o16 = aIOParam.o();
            com.tencent.aio.base.log.a.f69187b.d("ChatPieContainer", "preCreateFactory " + o16);
            for (String str : o16) {
                ChatPieCache chatPieCache = this.mCache;
                ChatPie b16 = b(str, g16);
                b16.E(aIOParam);
                Unit unit = Unit.INSTANCE;
                this.prepareChatPies.add(new WeakReference<>(b16));
                chatPieCache.put(str, b16);
                com.tencent.aio.base.log.a.f69187b.d("ChatPieContainer", "savePreCache " + this.mCache);
            }
            return;
        }
        String n3 = aIOParam.n();
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        aVar.d("ChatPieContainer", "getFactoryName " + n3 + "  curCache " + this.mCache);
        if (!aIOParam.k()) {
            ChatPie c16 = c(this, n3, false, 2, null);
            c16.E(aIOParam);
            Unit unit2 = Unit.INSTANCE;
            this.mCurrChatPie = c16;
            return;
        }
        String n16 = aIOParam.n();
        ChatPie chatPie = (ChatPie) this.mCache.get((Object) n16);
        if (chatPie != null) {
            chatPie.E(aIOParam);
            aVar.d("ChatPieContainer", "\u547d\u4e2d\u7f13\u5b58" + chatPie);
            Unit unit3 = Unit.INSTANCE;
            this.mCurrChatPie = chatPie;
            return;
        }
        ChatPie c17 = c(this, n3, false, 2, null);
        c17.E(aIOParam);
        aVar.d("ChatPieContainer", "\u65b0\u5efa" + c17);
        this.mCurrChatPie = c17;
        this.mCache.putAndGetRemoved(n16, c17);
    }

    @Nullable
    public final ChatPie f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ChatPie) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mCurrChatPie;
    }

    public final void g(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        ChatPie chatPie = this.mCurrChatPie;
        if (chatPie != null) {
            chatPie.t(requestCode, resultCode, data);
        }
    }

    public final boolean h() {
        ChatPie chatPie;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.mIsPreLoad || (chatPie = this.mCurrChatPie) == null || !chatPie.u()) {
            return false;
        }
        return true;
    }

    public final void i(@NotNull Configuration newConfig) {
        ChatPie chatPie;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (!this.mIsPreLoad && (chatPie = this.mCurrChatPie) != null) {
            chatPie.v(newConfig);
        }
    }

    @NotNull
    public final View j(@NotNull Bundle bundle, @NotNull ChatFragment fragment, @NotNull LayoutInflater inflater, @NotNull Function1<? super com.tencent.aio.api.runtime.a, Unit> wrapContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, bundle, fragment, inflater, wrapContext);
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(wrapContext, "wrapContext");
        this.isDestroy = false;
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        this.mContext = requireContext;
        FrameLayout a16 = ChatFragmentWidgetKt.a(fragment);
        boolean z16 = this.mIsPreLoad;
        if (z16) {
            Iterator<T> it = this.prepareChatPies.iterator();
            while (it.hasNext()) {
                final ChatPie chatPie = (ChatPie) ((WeakReference) it.next()).get();
                if (chatPie != null) {
                    com.tencent.aio.base.log.a.f69187b.d("ChatPieContainer", "preCreateView " + chatPie);
                    if (chatPie.p() != null) {
                        chatPie.g(fragment, inflater, a16, this.mIsPreLoad);
                        HandlerPoster p16 = chatPie.p();
                        Intrinsics.checkNotNull(p16);
                        p16.f(new Runnable() { // from class: com.tencent.aio.base.chat.ChatPieManager$onCreateView$1$1$1$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ChatPie.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this);
                                } else {
                                    ChatPie.this.z();
                                }
                            }
                        });
                    } else {
                        chatPie.g(fragment, inflater, a16, this.mIsPreLoad);
                        chatPie.z();
                    }
                }
            }
        } else {
            ChatPie chatPie2 = this.mCurrChatPie;
            if (chatPie2 != null) {
                chatPie2.g(fragment, inflater, a16, z16);
            }
            ChatPie chatPie3 = this.mCurrChatPie;
            if (chatPie3 != null) {
                chatPie3.w(bundle, fragment, wrapContext);
            }
        }
        return a16;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.isDestroy = true;
        if (this.mIsPreLoad) {
            return;
        }
        ChatPie chatPie = this.mCurrChatPie;
        if (chatPie != null) {
            chatPie.onDestroy();
        }
        com.tencent.aio.base.log.a.f69187b.d("ChatPieContainer", " onDestroy " + hashCode());
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public final void m(boolean isInMultiWindowMode) {
        ChatPie chatPie;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, isInMultiWindowMode);
        } else if (!this.mIsPreLoad && (chatPie = this.mCurrChatPie) != null) {
            chatPie.x(isInMultiWindowMode);
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mIsPreLoad) {
            return;
        }
        e(Lifecycle.Event.ON_PAUSE);
        com.tencent.aio.base.log.a.f69187b.d("ChatPieContainer", " onPause " + hashCode());
    }

    public final void o(boolean isInPictureInPictureMode) {
        ChatPie chatPie;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, isInPictureInPictureMode);
        } else if (!this.mIsPreLoad && (chatPie = this.mCurrChatPie) != null) {
            chatPie.y(isInPictureInPictureMode);
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mIsPreLoad) {
            return;
        }
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            e(Lifecycle.Event.ON_RESUME);
        } else {
            aVar.b("chaPieOnResume");
            String str = "AIO#chaPieOnResume";
            if (!aVar.h()) {
                e(Lifecycle.Event.ON_RESUME);
                Unit unit = Unit.INSTANCE;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                e(Lifecycle.Event.ON_RESUME);
                Unit unit2 = Unit.INSTANCE;
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar.e();
        }
        com.tencent.aio.base.log.a.f69187b.d("ChatPieContainer", " onResume " + hashCode());
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.mIsPreLoad) {
            return;
        }
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            e(Lifecycle.Event.ON_START);
        } else {
            aVar.b("chaPieOnStart");
            String str = "AIO#chaPieOnStart";
            if (!aVar.h()) {
                e(Lifecycle.Event.ON_START);
                Unit unit = Unit.INSTANCE;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                e(Lifecycle.Event.ON_START);
                Unit unit2 = Unit.INSTANCE;
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar.e();
        }
        com.tencent.aio.base.log.a.f69187b.d("ChatPieContainer", " onStart " + hashCode());
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.mIsPreLoad) {
            return;
        }
        e(Lifecycle.Event.ON_STOP);
        com.tencent.aio.base.log.a.f69187b.d("ChatPieContainer", " onStop " + hashCode());
    }

    public final void s(@NotNull String actionCode, @NotNull com.tencent.aio.runtime.message.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        ChatPie chatPie = this.mCurrChatPie;
        if (chatPie != null) {
            chatPie.A(actionCode, action);
        }
    }

    public final void t(@NotNull Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) rect);
            return;
        }
        Intrinsics.checkNotNullParameter(rect, "rect");
        ChatPie chatPie = this.mCurrChatPie;
        if (chatPie != null) {
            chatPie.B(rect);
        }
    }

    public final void u(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) msgIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
        ChatPie chatPie = this.mCurrChatPie;
        if (chatPie != null) {
            chatPie.C(msgIntent);
        }
    }

    public final void v(boolean fitSystemWindows) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, fitSystemWindows);
            return;
        }
        ChatPie chatPie = this.mCurrChatPie;
        if (chatPie != null) {
            chatPie.D(fitSystemWindows);
        }
    }

    public final void w(@NotNull String actionCode, @NotNull com.tencent.aio.runtime.message.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        ChatPie chatPie = this.mCurrChatPie;
        if (chatPie != null) {
            chatPie.F(actionCode, action);
        }
    }
}
