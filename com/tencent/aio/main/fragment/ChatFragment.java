package com.tencent.aio.main.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.api.frame.IAIOFramesProvider;
import com.tencent.aio.base.chat.ChatPie;
import com.tencent.aio.base.chat.ChatPieManager;
import com.tencent.aio.main.businesshelper.c;
import com.tencent.aio.monitor.PerfTimeCollector;
import com.tencent.aio.pref.annotation.HookMethodTrace;
import com.tencent.aio.runtime.AIOContextImpl;
import com.tencent.aio.runtime.IChatFragmentScopeRefFragment;
import com.tencent.aio.runtime.emitter.AIOFunctionEmitter;
import com.tencent.aio.runtime.provider.ChatFragmentProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ml3.b;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@HookMethodTrace(hookMethods = {"<clinit>", "<init>"}, tag = ChatFragment.TAG)
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001kB\t\b\u0000\u00a2\u0006\u0004\bi\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0003J\b\u0010\b\u001a\u00020\u0007H\u0003J\b\u0010\t\u001a\u00020\u0005H\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0003J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0017J\u001a\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u000f\u0010\u0011\u001a\u00020\u0005H\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\"\u00103\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0017\u00108\u001a\u00020\u00052\u0006\u00105\u001a\u000204H\u0000\u00a2\u0006\u0004\b6\u00107J\u0013\u0010;\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000109H\u0096\u0001J\t\u0010<\u001a\u00020\u0005H\u0096\u0001R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR,\u0010J\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010I8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR,\u0010P\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010I8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u001b\u0010X\u001a\u00020S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u001e\u0010c\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001e\u0010:\u001a\u0004\u0018\u0001098\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\be\u0010f\"\u0004\bg\u0010h\u00a8\u0006l"}, d2 = {"Lcom/tencent/aio/main/fragment/ChatFragment;", "Lcom/tencent/aio/runtime/IChatFragmentScopeRefFragment;", "", "Landroid/os/Bundle;", "getAIOParam", "", "handleCreateFrameContainer", "Landroid/view/View;", "handleCreateChatFrame", "handleClearAllFrames", "chaPieFrame", "handleAddMainFrame", "handleChatPieDestroy", "Landroid/content/Context;", "context", "onAttach", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "bundle", "onNewIntent", "", "hidden", "onHiddenChanged", "onCreate$sdk_debug", "()V", "onDestroyView", "isInMultiWindowMode", "onMultiWindowModeChanged", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onDetach", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/graphics/drawable/Drawable;", "drawable", "setBackground$sdk_debug", "(Landroid/graphics/drawable/Drawable;)V", "setBackground", "Lts/b;", "service", "attachAssistance", "extAIO", "Lcom/tencent/aio/base/chat/ChatPieManager;", "chatPieManager", "Lcom/tencent/aio/base/chat/ChatPieManager;", "bgDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/aio/main/businesshelper/c;", "firstScreenHelper", "Lcom/tencent/aio/main/businesshelper/c;", "getFirstScreenHelper$sdk_debug", "()Lcom/tencent/aio/main/businesshelper/c;", "setFirstScreenHelper$sdk_debug", "(Lcom/tencent/aio/main/businesshelper/c;)V", "Lcom/tencent/aio/api/frame/IAIOFramesProvider;", "frameProvider", "Lcom/tencent/aio/api/frame/IAIOFramesProvider;", "getFrameProvider$sdk_debug", "()Lcom/tencent/aio/api/frame/IAIOFramesProvider;", "setFrameProvider$sdk_debug", "(Lcom/tencent/aio/api/frame/IAIOFramesProvider;)V", "preparedFrameProvider", "getPreparedFrameProvider$sdk_debug", "setPreparedFrameProvider$sdk_debug", "Lcom/tencent/aio/main/fragment/ChatFragmentRootView;", "viewRoot$delegate", "Lkotlin/Lazy;", "getViewRoot", "()Lcom/tencent/aio/main/fragment/ChatFragmentRootView;", "viewRoot", "Lcom/tencent/aio/runtime/provider/ChatFragmentProvider;", "provider$delegate", "getProvider$sdk_debug", "()Lcom/tencent/aio/runtime/provider/ChatFragmentProvider;", "provider", "Lcom/tencent/mvi/api/runtime/a;", "preLoadPoster", "Lcom/tencent/mvi/api/runtime/a;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/aio/api/runtime/a;", "currentContext", "Ljava/lang/ref/WeakReference;", "getService", "()Lts/b;", "setService", "(Lts/b;)V", "<init>", "Companion", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class ChatFragment extends IChatFragmentScopeRefFragment {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String AIO_PARAM_KEY = "AIOParamKey";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String FRAGMENT_TAG = "com.tencent.aio.fragment.token";
    private static final String TAG = "ChatFragment";
    private final /* synthetic */ com.tencent.aio.main.businesshelper.a $$delegate_0;
    private Drawable bgDrawable;
    private final ChatPieManager chatPieManager;
    private WeakReference<com.tencent.aio.api.runtime.a> currentContext;

    @Nullable
    private c firstScreenHelper;

    @Nullable
    private IAIOFramesProvider<?, ?> frameProvider;
    private com.tencent.mvi.api.runtime.a preLoadPoster;

    @Nullable
    private IAIOFramesProvider<?, ?> preparedFrameProvider;

    /* renamed from: provider$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy provider;

    /* renamed from: viewRoot$delegate, reason: from kotlin metadata */
    private final Lazy viewRoot;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/main/fragment/ChatFragment$a;", "", "Landroid/os/Bundle;", "args", "Lcom/tencent/aio/main/fragment/ChatFragment;", "a", "", "AIO_PARAM_KEY", "Ljava/lang/String;", "FRAGMENT_TAG", "TAG", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.main.fragment.ChatFragment$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final ChatFragment a(@NotNull Bundle args) {
            Bundle b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (ChatFragment) iPatchRedirector.redirect((short) 1, (Object) this, (Object) args);
            }
            Intrinsics.checkNotNullParameter(args, "args");
            ChatFragment chatFragment = new ChatFragment();
            b16 = a.b(new Bundle(), args);
            chatFragment.setArguments(b16);
            return chatFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        this.$$delegate_0 = new com.tencent.aio.main.businesshelper.a();
        this.chatPieManager = new ChatPieManager();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChatFragmentRootView>() { // from class: com.tencent.aio.main.fragment.ChatFragment$viewRoot$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ChatFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChatFragmentRootView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (ChatFragmentRootView) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                Context requireContext = ChatFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                ChatFragmentRootView chatFragmentRootView = new ChatFragmentRootView(requireContext);
                chatFragmentRootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return chatFragmentRootView;
            }
        });
        this.viewRoot = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ChatFragmentProvider>() { // from class: com.tencent.aio.main.fragment.ChatFragment$provider$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ChatFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChatFragmentProvider invoke() {
                ChatPieManager chatPieManager;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (ChatFragmentProvider) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                chatPieManager = ChatFragment.this.chatPieManager;
                return new ChatFragmentProvider(chatPieManager, ChatFragment.this);
            }
        });
        this.provider = lazy2;
        com.tencent.aio.base.log.a.f69187b.d(TAG, "constructor " + hashCode());
    }

    private final Bundle getAIOParam() {
        Parcelable parcelable = requireArguments().getParcelable("AIOParamKey");
        if (parcelable != null) {
            return (Bundle) parcelable;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final ChatFragmentRootView getViewRoot() {
        return (ChatFragmentRootView) this.viewRoot.getValue();
    }

    @HookMethodTrace(tag = "ChatFragment-handleAddMainFrame")
    private final void handleAddMainFrame(View chaPieFrame) {
        IAIOFramesProvider<?, ?> iAIOFramesProvider = this.frameProvider;
        if (iAIOFramesProvider != null) {
            WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.currentContext;
            if (weakReference != null) {
                com.tencent.aio.api.runtime.a aVar = weakReference.get();
                Intrinsics.checkNotNull(aVar);
                Intrinsics.checkNotNullExpressionValue(aVar, "checkNotNull(currentContext).get()!!");
                LifecycleOwner d16 = aVar.d();
                Intrinsics.checkNotNullExpressionValue(d16, "checkNotNull(currentCont\u2026t).get()!!.lifecycleOwner");
                WeakReference<com.tencent.aio.api.runtime.a> weakReference2 = this.currentContext;
                if (weakReference2 != null) {
                    com.tencent.aio.api.runtime.a aVar2 = weakReference2.get();
                    Intrinsics.checkNotNull(aVar2);
                    ts.a f16 = aVar2.f();
                    Intrinsics.checkNotNullExpressionValue(f16, "checkNotNull(currentCont\u2026tActivityResultLauncher()");
                    WeakReference<com.tencent.aio.api.runtime.a> weakReference3 = this.currentContext;
                    if (weakReference3 != null) {
                        com.tencent.aio.api.runtime.a aVar3 = weakReference3.get();
                        Intrinsics.checkNotNull(aVar3);
                        Intrinsics.checkNotNullExpressionValue(aVar3, "checkNotNull(currentContext).get()!!");
                        b b16 = aVar3.b();
                        Intrinsics.checkNotNullExpressionValue(b16, "checkNotNull(currentContext).get()!!.emitter");
                        iAIOFramesProvider.e(chaPieFrame, new com.tencent.aio.api.frame.a(d16, f16, b16, LifecycleOwnerKt.getLifecycleScope(this)));
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    private final void handleChatPieDestroy() {
        extAIO();
        this.chatPieManager.k();
        this.frameProvider = null;
    }

    @HookMethodTrace(tag = "ChatFragment-handleClearAllFrames")
    private final void handleClearAllFrames() {
        IAIOFramesProvider<?, ?> iAIOFramesProvider = this.frameProvider;
        if (iAIOFramesProvider != null) {
            iAIOFramesProvider.a();
        }
    }

    @HookMethodTrace(tag = "ChatFragment-handleCreateChatFrame")
    private final View handleCreateChatFrame() {
        ChatPieManager chatPieManager = this.chatPieManager;
        Bundle aIOParam = getAIOParam();
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        View j3 = chatPieManager.j(aIOParam, this, layoutInflater, new Function1<com.tencent.aio.api.runtime.a, Unit>() { // from class: com.tencent.aio.main.fragment.ChatFragment$handleCreateChatFrame$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) ChatFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.api.runtime.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.aio.api.runtime.a receiver) {
                Pair<Class<?>, ?> d16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) receiver);
                    return;
                }
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                IAIOFramesProvider<?, ?> frameProvider$sdk_debug = ChatFragment.this.getFrameProvider$sdk_debug();
                if (frameProvider$sdk_debug != null && (d16 = frameProvider$sdk_debug.d()) != null) {
                    b b16 = receiver.b();
                    if (b16 != null) {
                        com.tencent.aio.runtime.emitter.a aVar = (com.tencent.aio.runtime.emitter.a) b16;
                        Class<?> first = d16.getFirst();
                        Object second = d16.getSecond();
                        if (second != null) {
                            aVar.c(first, (AIOFunctionEmitter) second);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.runtime.emitter.AIOFunctionEmitter<*>");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.runtime.emitter.FunctionEmitterService");
                    }
                }
                ChatFragment.this.currentContext = new WeakReference(receiver);
            }
        });
        j3.post(new Runnable() { // from class: com.tencent.aio.main.fragment.ChatFragment$handleCreateChatFrame$$inlined$also$lambda$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    PerfTimeCollector.f69389c.e();
                    ChatFragment.this.getProvider$sdk_debug().c();
                }
            }
        });
        return j3;
    }

    @HookMethodTrace(tag = "ChatFragment-handleCreateFrameContainer")
    private final void handleCreateFrameContainer() {
        IAIOFramesProvider<?, ?> iAIOFramesProvider = this.preparedFrameProvider;
        this.frameProvider = iAIOFramesProvider;
        ViewGroup viewGroup = null;
        this.preparedFrameProvider = null;
        if (iAIOFramesProvider != null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            iAIOFramesProvider.i(requireContext);
        }
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            IAIOFramesProvider<?, ?> iAIOFramesProvider2 = this.frameProvider;
            if (iAIOFramesProvider2 != null) {
                viewGroup = iAIOFramesProvider2.c();
            }
        } else {
            aVar.b("createFrameContainerViewGroup");
            String str = "AIO#createFrameContainerViewGroup";
            if (!aVar.h()) {
                IAIOFramesProvider<?, ?> iAIOFramesProvider3 = this.frameProvider;
                if (iAIOFramesProvider3 != null) {
                    viewGroup = iAIOFramesProvider3.c();
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                IAIOFramesProvider<?, ?> iAIOFramesProvider4 = this.frameProvider;
                if (iAIOFramesProvider4 != null) {
                    viewGroup = iAIOFramesProvider4.c();
                }
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar.e();
        }
        getViewRoot().removeAllViewsInLayout();
        if (viewGroup != null) {
            getViewRoot().addView(viewGroup, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void attachAssistance(@Nullable ts.b service) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) service);
        } else {
            this.$$delegate_0.a(service);
        }
    }

    public void extAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            this.$$delegate_0.b();
        }
    }

    @Nullable
    public final c getFirstScreenHelper$sdk_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (c) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.firstScreenHelper;
    }

    @Nullable
    public final IAIOFramesProvider<?, ?> getFrameProvider$sdk_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IAIOFramesProvider) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.frameProvider;
    }

    @Nullable
    public final IAIOFramesProvider<?, ?> getPreparedFrameProvider$sdk_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IAIOFramesProvider) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.preparedFrameProvider;
    }

    @NotNull
    public final ChatFragmentProvider getProvider$sdk_debug() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            value = iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            value = this.provider.getValue();
        }
        return (ChatFragmentProvider) value;
    }

    @Nullable
    public ts.b getService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (ts.b) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.$$delegate_0.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            this.chatPieManager.g(requestCode, resultCode, data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onAttach " + hashCode());
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onConfigurationChanged " + hashCode());
        super.onConfigurationChanged(newConfig);
        this.chatPieManager.i(newConfig);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) savedInstanceState);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onCreate " + hashCode());
        super.onCreate(savedInstanceState);
    }

    @HookMethodTrace(tag = "ChatFragment-onCreate")
    public final void onCreate$sdk_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "inner onCreate " + hashCode());
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            handleCreateFrameContainer();
            View handleCreateChatFrame = handleCreateChatFrame();
            handleClearAllFrames();
            handleAddMainFrame(handleCreateChatFrame);
            return;
        }
        aVar.b("onCreate");
        String str = "AIO#onCreate";
        if (!aVar.h()) {
            handleCreateFrameContainer();
            View handleCreateChatFrame2 = handleCreateChatFrame();
            handleClearAllFrames();
            handleAddMainFrame(handleCreateChatFrame2);
            Unit unit = Unit.INSTANCE;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            handleCreateFrameContainer();
            View handleCreateChatFrame3 = handleCreateChatFrame();
            handleClearAllFrames();
            handleAddMainFrame(handleCreateChatFrame3);
            Unit unit2 = Unit.INSTANCE;
            Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
        }
        aVar.e();
    }

    @Override // androidx.fragment.app.Fragment
    @HookMethodTrace(tag = "ChatFragment-onCreateView")
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            viewRoot = (View) iPatchRedirector.redirect((short) 10, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            com.tencent.aio.base.log.a.f69187b.d(TAG, "onCreateView " + hashCode());
            com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
            if (!aVar.g()) {
                this.chatPieManager.d(getAIOParam());
                onCreate$sdk_debug();
            } else {
                aVar.b("onCreateView");
                String str = "AIO#onCreateView";
                if (!aVar.h()) {
                    this.chatPieManager.d(getAIOParam());
                    onCreate$sdk_debug();
                    Unit unit = Unit.INSTANCE;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.chatPieManager.d(getAIOParam());
                    onCreate$sdk_debug();
                    Unit unit2 = Unit.INSTANCE;
                    Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                }
                aVar.e();
            }
            viewRoot = getViewRoot();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewRoot);
        return viewRoot;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onDestroy " + hashCode());
        super.onDestroy();
        handleChatPieDestroy();
        this.chatPieManager.a();
        c cVar = this.firstScreenHelper;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onDestroyView " + hashCode());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onDetach " + hashCode());
        super.onDetach();
        this.chatPieManager.l();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        com.tencent.mvi.api.runtime.a aVar;
        AIOContextImpl l3;
        super.onHiddenChanged(hidden);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, hidden);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onHiddenChanged " + hashCode() + " + hidden=" + hidden);
        if (hidden) {
            this.chatPieManager.n();
            this.chatPieManager.r();
            handleChatPieDestroy();
            return;
        }
        onCreate$sdk_debug();
        ChatPie f16 = this.chatPieManager.f();
        if (f16 != null && (l3 = f16.l()) != null) {
            aVar = l3.a();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.f(new Runnable() { // from class: com.tencent.aio.main.fragment.ChatFragment$onHiddenChanged$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ChatFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ChatPieManager chatPieManager;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                        chatPieManager = ChatFragment.this.chatPieManager;
                        chatPieManager.q();
                    } else {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }
            });
            aVar.f(new Runnable() { // from class: com.tencent.aio.main.fragment.ChatFragment$onHiddenChanged$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ChatFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ChatPieManager chatPieManager;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                        chatPieManager = ChatFragment.this.chatPieManager;
                        chatPieManager.p();
                    } else {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }
            });
        } else {
            this.chatPieManager.q();
            this.chatPieManager.p();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, isInMultiWindowMode);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onMultiWindowModeChanged " + hashCode());
        this.chatPieManager.m(isInMultiWindowMode);
    }

    public final void onNewIntent(@NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Bundle arguments = getArguments();
        if (arguments != null) {
            a.b(arguments, bundle);
        }
        this.chatPieManager.d(bundle);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onPause " + hashCode());
        super.onPause();
        this.chatPieManager.n();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, isInPictureInPictureMode);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onPictureInPictureModeChanged " + hashCode());
        this.chatPieManager.o(isInPictureInPictureMode);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onResume " + hashCode());
        super.onResume();
        this.chatPieManager.p();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onStart " + hashCode());
        super.onStart();
        this.chatPieManager.q();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d(TAG, "onStop " + hashCode());
        super.onStop();
        this.chatPieManager.r();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Drawable drawable = this.bgDrawable;
        if (drawable != null) {
            view.setBackground(drawable);
        }
    }

    public final void setBackground$sdk_debug(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        View it = getView();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.setBackground(drawable);
        }
        this.bgDrawable = drawable;
    }

    public final void setFirstScreenHelper$sdk_debug(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        } else {
            this.firstScreenHelper = cVar;
        }
    }

    public final void setFrameProvider$sdk_debug(@Nullable IAIOFramesProvider<?, ?> iAIOFramesProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iAIOFramesProvider);
        } else {
            this.frameProvider = iAIOFramesProvider;
        }
    }

    public final void setPreparedFrameProvider$sdk_debug(@Nullable IAIOFramesProvider<?, ?> iAIOFramesProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iAIOFramesProvider);
        } else {
            this.preparedFrameProvider = iAIOFramesProvider;
        }
    }

    public void setService(@Nullable ts.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) bVar);
        } else {
            this.$$delegate_0.d(bVar);
        }
    }
}
