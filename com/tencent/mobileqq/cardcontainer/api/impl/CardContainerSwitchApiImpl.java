package com.tencent.mobileqq.cardcontainer.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi;
import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForNum;
import com.tencent.qqnt.kernel.nativeinterface.bp;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerSwitchApiImpl;", "Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerSwitchApi;", "", "removeCardContainerSwitchChangedListenerInner", "Lcom/tencent/mobileqq/cardcontainer/api/a;", "listener", "setCardContainerSwitchChangedListenerInner", "Lcom/tencent/mobileqq/cardcontainer/data/CardContainerSwitchState;", "state", "setRemoteCardContainerSwitchStateInner", "", "remoteShowCardContainerSwitch", "removeCardContainerSwitchChangedListener", "setCardContainerSwitchChangedListener", "getRemoteCardContainerSwitchState", "setRemoteCardContainerSwitchState", "getLocalCardContainerSwitchShowingState", "show", "setLocalCardContainerSwitchShowingState", "ntSettingServiceSubThread$delegate", "Lkotlin/Lazy;", "getNtSettingServiceSubThread", "()Z", "ntSettingServiceSubThread", "cardContainerSwitchChangeListener", "Lcom/tencent/mobileqq/cardcontainer/api/a;", "", "listenerId", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "kernelSettingListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "<init>", "()V", "Companion", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardContainerSwitchApiImpl implements ICardContainerSwitchApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String REMOTE_SHOW_SWITCH_KEY = "103118";

    @NotNull
    public static final String SETTING_SERVICE_SUB_THREAD_KEY = "setting_service_thread_9090";

    @NotNull
    public static final String TAG = "CardContainer.CardContainerSwitchImpl";

    @Nullable
    private com.tencent.mobileqq.cardcontainer.api.a cardContainerSwitchChangeListener;

    @NotNull
    private final IKernelSettingListener kernelSettingListener;
    private long listenerId;

    /* renamed from: ntSettingServiceSubThread$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy ntSettingServiceSubThread;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerSwitchApiImpl$a;", "", "", "REMOTE_SHOW_SWITCH_KEY", "Ljava/lang/String;", "SETTING_SERVICE_SUB_THREAD_KEY", "TAG", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.api.impl.CardContainerSwitchApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/cardcontainer/api/impl/CardContainerSwitchApiImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForNum;", "", "Lkotlin/collections/HashMap;", "setting", "", "onNumSettingChanged", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements IKernelSettingListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardContainerSwitchApiImpl.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onBufferSettingChanged(HashMap hashMap) {
            bp.a(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onCleanCacheProgressChanged(int i3, int i16) {
            bp.b(this, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public void onNumSettingChanged(@NotNull HashMap<SettingKeyForNum, Integer> setting) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) setting);
                return;
            }
            Intrinsics.checkNotNullParameter(setting, "setting");
            SettingKeyForNum settingKeyForNum = SettingKeyForNum.KCARDCONTAINER;
            if (setting.containsKey(settingKeyForNum)) {
                Integer num = setting.get(settingKeyForNum);
                QLog.i(CardContainerSwitchApiImpl.TAG, 1, "onNumSettingChanged state:" + num);
                if (num != null) {
                    CardContainerSwitchApiImpl cardContainerSwitchApiImpl = CardContainerSwitchApiImpl.this;
                    CardContainerSwitchState a16 = CardContainerSwitchState.INSTANCE.a(num.intValue());
                    com.tencent.mobileqq.cardcontainer.api.a aVar = cardContainerSwitchApiImpl.cardContainerSwitchChangeListener;
                    if (aVar != null) {
                        aVar.a(a16);
                    }
                    if (a16 != CardContainerSwitchState.DEFAULT) {
                        com.tencent.mobileqq.cardcontainer.data.mmkv.a aVar2 = com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a;
                        aVar2.n(true);
                        aVar2.p(a16);
                    }
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onPrivacySettingChanged(PrivacySetting privacySetting) {
            bp.d(this, privacySetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onStrSettingChanged(HashMap hashMap) {
            bp.e(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onVerifyInfoChange(int i3) {
            bp.f(this, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39735);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CardContainerSwitchApiImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(CardContainerSwitchApiImpl$ntSettingServiceSubThread$2.INSTANCE);
            this.ntSettingServiceSubThread = lazy;
            this.kernelSettingListener = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final boolean getNtSettingServiceSubThread() {
        return ((Boolean) this.ntSettingServiceSubThread.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeCardContainerSwitchChangedListener$lambda$0(CardContainerSwitchApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeCardContainerSwitchChangedListenerInner();
    }

    private final void removeCardContainerSwitchChangedListenerInner() {
        IKernelSettingService iKernelSettingService;
        IKernelService iKernelService;
        IQQNTWrapperSession wrapperSession;
        QLog.i(TAG, 1, "removeCardContainerSwitchChangedListener");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (wrapperSession = iKernelService.getWrapperSession()) != null) {
            iKernelSettingService = wrapperSession.getSettingService();
        } else {
            iKernelSettingService = null;
        }
        if (iKernelSettingService != null) {
            iKernelSettingService.removeKernelSettingListener(this.listenerId);
            this.cardContainerSwitchChangeListener = null;
            this.listenerId = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCardContainerSwitchChangedListener$lambda$1(CardContainerSwitchApiImpl this$0, com.tencent.mobileqq.cardcontainer.api.a listener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        this$0.setCardContainerSwitchChangedListenerInner(listener);
    }

    private final void setCardContainerSwitchChangedListenerInner(com.tencent.mobileqq.cardcontainer.api.a listener) {
        IKernelSettingService iKernelSettingService;
        IKernelService iKernelService;
        IQQNTWrapperSession wrapperSession;
        if (this.listenerId != 0) {
            removeCardContainerSwitchChangedListenerInner();
        }
        QLog.i(TAG, 1, "setCardContainerSwitchChangedListener");
        this.cardContainerSwitchChangeListener = listener;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (wrapperSession = iKernelService.getWrapperSession()) != null) {
            iKernelSettingService = wrapperSession.getSettingService();
        } else {
            iKernelSettingService = null;
        }
        if (iKernelSettingService != null) {
            this.listenerId = iKernelSettingService.addKernelSettingListener(this.kernelSettingListener);
            ArrayList<SettingKeyForNum> arrayList = new ArrayList<>();
            arrayList.add(SettingKeyForNum.KCARDCONTAINER);
            iKernelSettingService.getSettingForNum(arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.cardcontainer.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    CardContainerSwitchApiImpl.setCardContainerSwitchChangedListenerInner$lambda$5$lambda$4(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCardContainerSwitchChangedListenerInner$lambda$5$lambda$4(int i3, String str) {
        QLog.i(TAG, 1, "getRemoteCardContainerSwitchStateFromNet callback, result: " + i3 + " errMsg: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRemoteCardContainerSwitchState$lambda$2(CardContainerSwitchApiImpl this$0, CardContainerSwitchState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.setRemoteCardContainerSwitchStateInner(state);
    }

    private final void setRemoteCardContainerSwitchStateInner(final CardContainerSwitchState state) {
        IKernelSettingService iKernelSettingService;
        IKernelService iKernelService;
        IQQNTWrapperSession wrapperSession;
        QLog.i(TAG, 1, "setRemoteCardContainerSwitchState state:" + state);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (wrapperSession = iKernelService.getWrapperSession()) != null) {
            iKernelSettingService = wrapperSession.getSettingService();
        } else {
            iKernelSettingService = null;
        }
        if (iKernelSettingService != null) {
            HashMap<SettingKeyForNum, Integer> hashMap = new HashMap<>();
            hashMap.put(SettingKeyForNum.KCARDCONTAINER, Integer.valueOf(state.getValue()));
            iKernelSettingService.setSettingForNum(hashMap, new IOperateCallback() { // from class: com.tencent.mobileqq.cardcontainer.api.impl.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    CardContainerSwitchApiImpl.setRemoteCardContainerSwitchStateInner$lambda$7$lambda$6(CardContainerSwitchState.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRemoteCardContainerSwitchStateInner$lambda$7$lambda$6(CardContainerSwitchState state, int i3, String str) {
        Intrinsics.checkNotNullParameter(state, "$state");
        QLog.i(TAG, 1, "setRemoteCardContainerSwitchState callback state:" + state + ", result: " + i3 + ", errMsg: " + str);
        if (i3 == 0) {
            com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.p(state);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi
    public boolean getLocalCardContainerSwitchShowingState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        boolean f16 = com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.f();
        QLog.i(TAG, 1, "getLocalCardContainerSwitchShowingState:" + f16);
        return f16;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi
    @NotNull
    public CardContainerSwitchState getRemoteCardContainerSwitchState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CardContainerSwitchState) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        CardContainerSwitchState h16 = com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.h();
        QLog.i(TAG, 1, "getRemoteCardContainerSwitchState from mmkv,state:" + h16);
        return h16;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi
    public boolean remoteShowCardContainerSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(REMOTE_SHOW_SWITCH_KEY, false);
        QLog.i(TAG, 1, "remoteShowCardContainerSwitch: " + isSwitchOn);
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi
    public void removeCardContainerSwitchChangedListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (getNtSettingServiceSubThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    CardContainerSwitchApiImpl.removeCardContainerSwitchChangedListener$lambda$0(CardContainerSwitchApiImpl.this);
                }
            }, 16, null, false);
        } else {
            removeCardContainerSwitchChangedListenerInner();
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi
    public void setCardContainerSwitchChangedListener(@NotNull final com.tencent.mobileqq.cardcontainer.api.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (getNtSettingServiceSubThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    CardContainerSwitchApiImpl.setCardContainerSwitchChangedListener$lambda$1(CardContainerSwitchApiImpl.this, listener);
                }
            }, 16, null, false);
        } else {
            setCardContainerSwitchChangedListenerInner(listener);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi
    public void setLocalCardContainerSwitchShowingState(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, show);
            return;
        }
        com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.n(show);
        QLog.i(TAG, 1, "setLocalCardContainerSwitchShowingState:" + show);
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi
    public void setRemoteCardContainerSwitchState(@NotNull final CardContainerSwitchState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (getNtSettingServiceSubThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    CardContainerSwitchApiImpl.setRemoteCardContainerSwitchState$lambda$2(CardContainerSwitchApiImpl.this, state);
                }
            }, 16, null, false);
        } else {
            setRemoteCardContainerSwitchStateInner(state);
        }
    }
}
