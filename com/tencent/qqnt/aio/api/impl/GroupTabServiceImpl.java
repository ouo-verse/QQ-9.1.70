package com.tencent.qqnt.aio.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IGroupTabKeyApi;
import com.tencent.qqnt.aio.api.IGroupTabService;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupTabListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupTabService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J*\u0010\u0015\u001a\u00020\u00072 \u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u0012H\u0016R,\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u00120\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/GroupTabServiceImpl;", "Lcom/tencent/qqnt/aio/api/IGroupTabService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupTabListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupTabService;", "getService", "", "msg", "", "log", "onLogin", "", "groupCode", "tabKey", "getGroupTabInfoByUin", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/HashMap;", "", "tab", "onGroupTabUpdate", "Ljava/util/concurrent/ConcurrentHashMap;", "cachedGroupTabData", "Ljava/util/concurrent/ConcurrentHashMap;", "listenerId", "J", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class GroupTabServiceImpl implements IGroupTabService, IKernelGroupTabListener {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "GroupTabService";

    @NotNull
    private final ConcurrentHashMap<String, HashMap<Long, byte[]>> cachedGroupTabData;
    private long listenerId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/GroupTabServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.GroupTabServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GroupTabServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cachedGroupTabData = new ConcurrentHashMap<>();
            this.listenerId = -1L;
        }
    }

    private final IKernelGroupTabService getService() {
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null) {
            return i3.getGroupTabService();
        }
        return null;
    }

    private final void log(String msg2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLogin$lambda$0(GroupTabServiceImpl this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.log("getGroupTab: result:" + i3 + ", err:" + str);
    }

    @Override // com.tencent.qqnt.aio.api.IGroupTabService
    @Nullable
    public String getGroupTabInfoByUin(long groupCode, @NotNull String tabKey) {
        String str;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Long.valueOf(groupCode), tabKey);
        }
        Intrinsics.checkNotNullParameter(tabKey, "tabKey");
        HashMap<Long, byte[]> hashMap = this.cachedGroupTabData.get(tabKey);
        if (hashMap != null && (bArr = hashMap.get(Long.valueOf(groupCode))) != null) {
            str = x.b(bArr);
        } else {
            str = null;
        }
        log("getGroupTabInfoByUin groupCode=" + groupCode + " tabKey=" + tabKey + " info:" + str);
        return str;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        } else {
            log("onCreate");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        log("onDestroy onLogout curUin=" + str);
        IKernelGroupTabService service = getService();
        if (service != null) {
            service.removeListener(this.listenerId);
        }
        this.cachedGroupTabData.clear();
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupTabListener
    public void onGroupTabUpdate(@Nullable HashMap<String, HashMap<Long, byte[]>> tab) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tab);
            return;
        }
        if (tab != null && !tab.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            log("onGroupTabUpdate: result null");
            return;
        }
        log("onGroupTabUpdate: tab:" + tab);
        this.cachedGroupTabData.clear();
        this.cachedGroupTabData.putAll(tab);
    }

    @Override // com.tencent.qqnt.aio.api.IGroupTabService
    public void onLogin() {
        String str;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        log("onLogin curUin=" + str);
        IKernelGroupTabService service = getService();
        if (service != null) {
            j3 = service.addListener(this);
        } else {
            j3 = -1;
        }
        this.listenerId = j3;
        ArrayList<String> groupTabKeys = ((IGroupTabKeyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGroupTabKeyApi.class)).getGroupTabKeys();
        IKernelGroupTabService service2 = getService();
        if (service2 != null) {
            service2.getGroupTab(new ArrayList<>(), groupTabKeys, new IOperateCallback() { // from class: com.tencent.qqnt.aio.api.impl.w
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    GroupTabServiceImpl.onLogin$lambda$0(GroupTabServiceImpl.this, i3, str2);
                }
            });
        }
    }
}
