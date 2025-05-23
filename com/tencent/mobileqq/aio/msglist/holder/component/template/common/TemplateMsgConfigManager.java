package com.tencent.mobileqq.aio.msglist.holder.component.template.common;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ArkMsgBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.ArkMsgConfig;
import com.tencent.qqnt.kernel.nativeinterface.ArkMsgConfigInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetArgMsgConfigReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetArkMsgConfigCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0002J8\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0010j\b\u0012\u0004\u0012\u00020\u0013`\u00112\u001e\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0010j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010!\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0018\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R0\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020/0.j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020/`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R \u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0;0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/TemplateMsgConfigManager;", "", "", "p", "", "appName", "bizName", "t", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ArkMsgConfigInfo;", "configList", "g", "u", "ntData", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/b;", "v", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listData", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/TemplateMsgWhiteUrlItem;", HippyTKDListViewAdapter.X, "r", "Lcom/tencent/qqnt/kernel/api/w;", "l", "w", "url", "", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/d;", "listener", "f", "o", "i", "j", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "msg", DomainData.DOMAIN_NAME, "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "templateMsgConfigCache", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/j;", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/j;", "loadingStatus", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "loadingConfigs", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/i;", "e", "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/i;", "globalCheckConfig", "Ljava/util/LinkedList;", "Lmqq/util/WeakReference;", "Ljava/util/LinkedList;", "configListenerList", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TemplateMsgConfigManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TemplateMsgConfigManager f191899a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, b> templateMsgConfigCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final j loadingStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Long> loadingConfigs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy globalCheckConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LinkedList<WeakReference<d>> configListenerList;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f191899a = new TemplateMsgConfigManager();
        templateMsgConfigCache = new ConcurrentHashMap<>();
        loadingStatus = new j();
        loadingConfigs = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(TemplateMsgConfigManager$globalCheckConfig$2.INSTANCE);
        globalCheckConfig = lazy;
        configListenerList = new LinkedList<>();
    }

    TemplateMsgConfigManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(List<ArkMsgConfigInfo> configList) {
        String str;
        String str2;
        String str3;
        Iterator<ArkMsgConfigInfo> it = configList.iterator();
        while (true) {
            String str4 = null;
            if (!it.hasNext()) {
                break;
            }
            ArkMsgConfigInfo next = it.next();
            ArkMsgBaseInfo arkMsgBaseInfo = next.baseInfo;
            if (arkMsgBaseInfo != null) {
                str3 = arkMsgBaseInfo.appName;
            } else {
                str3 = null;
            }
            if (arkMsgBaseInfo != null) {
                str4 = arkMsgBaseInfo.bizName;
            }
            templateMsgConfigCache.put(t(str3, str4), v(next));
        }
        Iterator<ArkMsgConfigInfo> it5 = configList.iterator();
        while (it5.hasNext()) {
            ArkMsgBaseInfo arkMsgBaseInfo2 = it5.next().baseInfo;
            if (arkMsgBaseInfo2 != null) {
                str = arkMsgBaseInfo2.appName;
            } else {
                str = null;
            }
            if (arkMsgBaseInfo2 != null) {
                str2 = arkMsgBaseInfo2.bizName;
            } else {
                str2 = null;
            }
            u(str, str2);
        }
    }

    private final i k() {
        return (i) globalCheckConfig.getValue();
    }

    private final w l() {
        AppRuntime peekAppRuntime;
        IKernelService iKernelService;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getMsgService();
        }
        return null;
    }

    private final void p() {
        if (!loadingStatus.b()) {
            return;
        }
        w l3 = l();
        if (l3 == null) {
            QLog.e("TemMsg.config", 1, "load config fail for msgService got null !!!");
            return;
        }
        GetArgMsgConfigReqInfo getArgMsgConfigReqInfo = new GetArgMsgConfigReqInfo();
        getArgMsgConfigReqInfo.reqType = 1;
        IGetArkMsgConfigCallback iGetArkMsgConfigCallback = new IGetArkMsgConfigCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.template.common.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetArkMsgConfigCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                TemplateMsgConfigManager.q(i3, str, arrayList);
            }
        };
        QLog.d("TemMsg.config", 1, "loadLocalCachedConfig start");
        l3.y(getArgMsgConfigReqInfo, iGetArkMsgConfigCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3, String str, ArrayList arrayList) {
        if (i3 == 0 && arrayList != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new TemplateMsgConfigManager$loadLocalCachedConfig$callback$1$1(arrayList, null), 2, null);
            return;
        }
        QLog.e("TemMsg.config", 1, "loadLocalCachedConfig failed, code:" + i3 + ", msg:" + str);
    }

    private final void r(final String appName, final String bizName) {
        w l3 = l();
        if (l3 == null) {
            QLog.e("TemMsg.config", 1, "loadSingleConfig " + appName + "," + bizName + " fail for msgService got null !!!");
            return;
        }
        final String t16 = t(appName, bizName);
        synchronized (this) {
            HashMap<String, Long> hashMap = loadingConfigs;
            Long l16 = hashMap.get(t16);
            if (l16 != null && System.currentTimeMillis() - l16.longValue() < 5000) {
                return;
            }
            hashMap.put(t16, Long.valueOf(System.currentTimeMillis()));
            QLog.d("TemMsg.config", 1, "loadSingleConfig start, appName:" + appName + ", bizName:" + bizName);
            GetArgMsgConfigReqInfo getArgMsgConfigReqInfo = new GetArgMsgConfigReqInfo();
            getArgMsgConfigReqInfo.reqType = 2;
            ArrayList<ArkMsgBaseInfo> arrayList = getArgMsgConfigReqInfo.arkMsgBaseInfos;
            ArkMsgBaseInfo arkMsgBaseInfo = new ArkMsgBaseInfo();
            arkMsgBaseInfo.appName = appName;
            arkMsgBaseInfo.bizName = bizName;
            arrayList.add(arkMsgBaseInfo);
            IGetArkMsgConfigCallback iGetArkMsgConfigCallback = new IGetArkMsgConfigCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.template.common.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetArkMsgConfigCallback
                public final void onResult(int i3, String str, ArrayList arrayList2) {
                    TemplateMsgConfigManager.s(appName, bizName, this, t16, i3, str, arrayList2);
                }
            };
            com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a, "TemMsg.config", "getTemplateMsgConfig for " + appName + "," + bizName, null, 4, null);
            l3.y(getArgMsgConfigReqInfo, iGetArkMsgConfigCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String appName, String bizName, TemplateMsgConfigManager this$0, String cacheKey, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(appName, "$appName");
        Intrinsics.checkNotNullParameter(bizName, "$bizName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cacheKey, "$cacheKey");
        if (i3 == 0 && arrayList != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new TemplateMsgConfigManager$loadSingleConfig$callback$1$1(appName, bizName, arrayList, this$0, cacheKey, null), 2, null);
            return;
        }
        QLog.e("TemMsg.config", 1, "loadSingleConfig failed, code:" + i3 + ", msg:" + str);
    }

    private final String t(String appName, String bizName) {
        return appName + ";" + bizName;
    }

    private final void u(String appName, String bizName) {
        b bVar;
        if (appName == null || bizName == null || (bVar = templateMsgConfigCache.get(t(appName, bizName))) == null) {
            return;
        }
        Iterator<WeakReference<d>> it = configListenerList.iterator();
        while (it.hasNext()) {
            d dVar = it.next().get();
            if (dVar != null) {
                dVar.L(appName, bizName, bVar);
            }
        }
        CollectionsKt__MutableCollectionsKt.removeAll((List) configListenerList, (Function1) TemplateMsgConfigManager$notifyCacheUpdate$1.INSTANCE);
    }

    private final b v(ArkMsgConfigInfo ntData) {
        int i3;
        boolean z16;
        int i16;
        List list;
        List emptyList;
        b bVar = new b();
        TemplateMsgConfigManager templateMsgConfigManager = f191899a;
        bVar.m(templateMsgConfigManager.x(ntData.resourceList));
        bVar.l(templateMsgConfigManager.x(ntData.jumpList));
        ArkMsgConfig arkMsgConfig = ntData.config;
        int i17 = 0;
        if (arkMsgConfig != null) {
            i3 = arkMsgConfig.collect;
        } else {
            i3 = 0;
        }
        boolean z17 = true;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        bVar.i(z16);
        ArkMsgConfig arkMsgConfig2 = ntData.config;
        if (arkMsgConfig2 != null) {
            i16 = arkMsgConfig2.reply;
        } else {
            i16 = 0;
        }
        if (i16 == 0) {
            z17 = false;
        }
        bVar.j(z17);
        ArrayList<String> e16 = bVar.e();
        ArkMsgConfig arkMsgConfig3 = ntData.config;
        if (arkMsgConfig3 != null) {
            list = arkMsgConfig3.getFwdViews();
        } else {
            list = null;
        }
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            Intrinsics.checkNotNullExpressionValue(list, "ntData.config?.getFwdViews() ?: emptyList()");
        }
        e16.addAll(list);
        bVar.h(bVar.e().contains("*"));
        ArkMsgConfig arkMsgConfig4 = ntData.config;
        if (arkMsgConfig4 != null) {
            i17 = arkMsgConfig4.retCode;
        }
        bVar.k(i17);
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r4 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<TemplateMsgWhiteUrlItem> x(ArrayList<String> listData) {
        List filterNotNull;
        ArrayList<TemplateMsgWhiteUrlItem> arrayList = new ArrayList<>();
        if (listData != null && filterNotNull != null) {
            Iterator it = filterNotNull.iterator();
            while (it.hasNext()) {
                TemplateMsgWhiteUrlItem a16 = l.f191934a.a((String) it.next());
                if (a16 != null) {
                    arrayList.add(a16);
                }
            }
        }
        return arrayList;
    }

    public final void f(@NotNull d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<WeakReference<d>> it = configListenerList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().get(), listener)) {
                return;
            }
        }
        configListenerList.add(new WeakReference<>(listener));
    }

    public final boolean h(@NotNull String appName, @NotNull String bizName, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, appName, bizName, url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(url, "url");
        if (loadingStatus.c()) {
            p();
        }
        if (k().a(url)) {
            QLog.i("TemMsg.config", 1, "block by global black list");
            return false;
        }
        if (k().b(url)) {
            QLog.i("TemMsg.config", 1, "allowed by global white list");
            return true;
        }
        b bVar = templateMsgConfigCache.get(t(appName, bizName));
        if (bVar == null) {
            QLog.w("TemMsg.config", 1, "allow jump for config got null");
            return true;
        }
        return l.f191934a.b(url, bVar.f());
    }

    public final boolean i(@NotNull String appName, @NotNull String bizName, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, appName, bizName, url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(url, "url");
        if (loadingStatus.c()) {
            p();
        }
        b bVar = templateMsgConfigCache.get(t(appName, bizName));
        if (bVar == null) {
            r(appName, bizName);
            return true;
        }
        if (bVar.g().isEmpty()) {
            return true;
        }
        if (k().a(url)) {
            com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a, "TemMsg.config", "block resource " + url + " by global black list", null, 4, null);
            return false;
        }
        if (k().b(url)) {
            com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a, "TemMsg.config", "allow rsource " + url + " for global white list", null, 4, null);
            return true;
        }
        return l.f191934a.b(url, bVar.g());
    }

    @Nullable
    public final b j(@NotNull String appName, @NotNull String bizName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appName, (Object) bizName);
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        return templateMsgConfigCache.get(t(appName, bizName));
    }

    public final boolean m(@Nullable String appName, @Nullable String bizName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appName, (Object) bizName)).booleanValue();
        }
        if (appName == null || bizName == null || j(appName, bizName) == null) {
            return false;
        }
        return true;
    }

    public final boolean n(@NotNull TemplateMsgItem msg2) {
        String str;
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getMsgRecord().chatType != 2) {
            return false;
        }
        if (msg2.getMsgRecord().sendStatus != 2 && msg2.getMsgRecord().sendStatus != 1) {
            return false;
        }
        com.tencent.mobileqq.aio.msg.template.d n26 = msg2.n2();
        if (n26 != null) {
            str = n26.a();
        } else {
            str = null;
        }
        contains = CollectionsKt___CollectionsKt.contains(g.f191921a.a(), str);
        return contains;
    }

    public final void o(@NotNull String appName, @NotNull String bizName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appName, (Object) bizName);
            return;
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        if (loadingStatus.c()) {
            p();
        }
        if (m(appName, bizName)) {
            u(appName, bizName);
        } else {
            r(appName, bizName);
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            p();
        }
    }
}
