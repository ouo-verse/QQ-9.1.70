package com.tencent.qqnt.kernel.api.impl;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.CacheType;
import com.tencent.qqnt.kernel.nativeinterface.IKernelCleanCacheCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetSwitchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNeedConfirmSwitchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelScanCacheCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.NeedConfirmState;
import com.tencent.qqnt.kernel.nativeinterface.NewAccount;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForBuffer;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForNum;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForStr;
import com.tencent.qqnt.kernel.nativeinterface.VerifyInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0003:\u0001=B\u0019\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00109\u001a\u000208\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J(\u0010\u0014\u001a\u00020\b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0017\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0019\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u001c\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u001e\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010 \u001a\u00020\b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010\"\u001a\u00020\b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020!\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010(\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010)\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010+\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010*H\u0016J\"\u0010/\u001a\u00020\b2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00101\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u000100H\u0016J\u001c\u00103\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u0001022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u00105\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u000104H\u0016J\u001a\u00106\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006>"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/pz;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "listener", "", "addKernelSettingListener", "listenerId", "", "removeKernelSettingListener", "", "getSelfStartSwitch", "state", "setSelfStartSwitch", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForNum;", "", "setting", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "result", "setSettingForNum", "Ljava/util/ArrayList;", "key", "getSettingForNum", "Lcom/tencent/qqnt/kernel/nativeinterface/PrivacySetting;", "setPrivacySetting", "getPrivacySetting", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForStr;", "getSettingForStr", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForBuffer;", "getSettingForBuffer", "", "setSettingForStr", "", "setSettingForBuffer", "Lcom/tencent/qqnt/kernel/nativeinterface/NewAccount;", "newInfo", "verifyNewAccount", "Lcom/tencent/qqnt/kernel/nativeinterface/VerifyInfo;", "verifyInfo", "modifyAccount", "destroyAccount", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelScanCacheCallback;", "scanCache", "Lcom/tencent/qqnt/kernel/nativeinterface/CacheType;", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelCleanCacheCallback;", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNeedConfirmSwitchCallback;", "getNeedConfirmSwitch", "Lcom/tencent/qqnt/kernel/nativeinterface/NeedConfirmState;", "setNeedConfirmSwitch", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetSwitchCallback;", "getAutoLoginSwitch", "setAutoLoginSwitch", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class pz extends BaseService<IKernelSettingListener, IKernelSettingService> implements IKernelSettingService {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/pz$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.pz$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pz(@Nullable IKernelSettingService iKernelSettingService, @NotNull py content) {
        super("SettingService", content, iKernelSettingService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelSettingService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public long addKernelSettingListener(@Nullable IKernelSettingListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener)).longValue();
        }
        IKernelSettingService service = getService();
        if (service != null) {
            return service.addKernelSettingListener(listener);
        }
        return 0L;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void clearCache(@Nullable ArrayList<CacheType> type, @Nullable IKernelCleanCacheCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) type, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.clearCache(type, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void destroyAccount(@Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.destroyAccount(result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void getAutoLoginSwitch(@Nullable IKernelGetSwitchCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.getAutoLoginSwitch(result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void getNeedConfirmSwitch(@Nullable IKernelNeedConfirmSwitchCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.getNeedConfirmSwitch(result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void getPrivacySetting(@Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.getPrivacySetting(result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public boolean getSelfStartSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        IKernelSettingService service = getService();
        if (service == null || !service.getSelfStartSwitch()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void getSettingForBuffer(@Nullable ArrayList<SettingKeyForBuffer> key, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) key, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.getSettingForBuffer(key, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void getSettingForNum(@Nullable ArrayList<SettingKeyForNum> key, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.getSettingForNum(key, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void getSettingForStr(@Nullable ArrayList<SettingKeyForStr> key, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) key, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.getSettingForStr(key, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void modifyAccount(@Nullable VerifyInfo verifyInfo, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) verifyInfo, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.modifyAccount(verifyInfo, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void removeKernelSettingListener(long listenerId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, listenerId);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.removeKernelSettingListener(listenerId);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void scanCache(@Nullable IKernelScanCacheCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.scanCache(result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void setAutoLoginSwitch(boolean state, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(state), result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.setAutoLoginSwitch(state, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void setNeedConfirmSwitch(@Nullable NeedConfirmState state, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) state, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.setNeedConfirmSwitch(state, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void setPrivacySetting(@Nullable PrivacySetting setting, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) setting, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.setPrivacySetting(setting, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public boolean setSelfStartSwitch(boolean state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, state)).booleanValue();
        }
        if (getService() == null) {
            return false;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.setSelfStartSwitch(state);
            return true;
        }
        return true;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void setSettingForBuffer(@Nullable HashMap<SettingKeyForBuffer, byte[]> setting, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) setting, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.setSettingForBuffer(setting, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void setSettingForNum(@Nullable HashMap<SettingKeyForNum, Integer> setting, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) setting, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.setSettingForNum(setting, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void setSettingForStr(@Nullable HashMap<SettingKeyForStr, String> setting, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) setting, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.setSettingForStr(setting, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService
    public void verifyNewAccount(@Nullable NewAccount newInfo, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newInfo, (Object) result);
            return;
        }
        IKernelSettingService service = getService();
        if (service != null) {
            service.verifyNewAccount(newInfo, result);
        }
    }
}
