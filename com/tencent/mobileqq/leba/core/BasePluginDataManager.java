package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.LebaPluginProxy;
import com.tencent.mobileqq.leba.data.LebaPluginListUnitedConfigParser;
import com.tencent.mobileqq.leba.data.LebaUnitedConfigHelper;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u000f2\u00020\u0001:\u0002+)B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0016J\u001e\u0010\u0013\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0004J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0014J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0004J&\u0010\u001d\u001a\u00020\u00052\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00022\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0016\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0005R\u0017\u0010\t\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b+\u0010*R\u001b\u00101\u001a\u00020-8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010.\u001a\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00102R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0014048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00105R\u001a\u0010;\u001a\u0002078\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b%\u00108\u001a\u0004\b9\u0010:R\u001a\u0010@\u001a\u00020<8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010D\u001a\u00020A8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010B\u001a\u0004\b'\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", "", "", "Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;", "list", "", "r", "", "mode", "style", "", "a", "from", "", "reason", "j", "Lcom/tencent/mobileqq/leba/entity/n;", "f", "Lkotlin/Pair;", "e", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager$d;", "listener", ReportConstant.COSTREPORT_PREFIX, "t", h.F, "i", "l", "pluginDataList", "morePluginList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "p", "", "tabChange", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "I", "g", "()I", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "c", "morePluginDataList", "Lcom/tencent/mobileqq/leba/business/e;", "Lkotlin/Lazy;", "getLebaProxyFilter", "()Lcom/tencent/mobileqq/leba/business/e;", "lebaProxyFilter", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager$d;", "loadPluginListener", "", "Ljava/util/Set;", "loadPluginListenerList", "Lcom/tencent/mobileqq/leba/data/LebaPluginListUnitedConfigParser$b;", "Lcom/tencent/mobileqq/leba/data/LebaPluginListUnitedConfigParser$b;", "getConfigUpdateCallback", "()Lcom/tencent/mobileqq/leba/data/LebaPluginListUnitedConfigParser$b;", "configUpdateCallback", "Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;", "Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;", "getResourcePluginListener", "()Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;", "resourcePluginListener", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "()Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "lebaPluginProxy", "<init>", "(I)V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class BasePluginDataManager {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int style;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<n> pluginDataList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<n> morePluginDataList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy lebaProxyFilter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d loadPluginListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<d> loadPluginListenerList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginListUnitedConfigParser.b configUpdateCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ResourcePluginListener resourcePluginListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginProxy lebaPluginProxy;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/leba/core/BasePluginDataManager$a", "Lcom/tencent/mobileqq/leba/data/LebaPluginListUnitedConfigParser$b;", "", "onUpdate", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements LebaPluginListUnitedConfigParser.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BasePluginDataManager.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.data.LebaPluginListUnitedConfigParser.b
        public void onUpdate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                BasePluginDataManager.k(BasePluginDataManager.this, 2, null, 2, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/leba/core/BasePluginDataManager$b", "Lcom/tencent/mobileqq/leba/observer/ResourcePluginListener;", "", "state", "", "c", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends ResourcePluginListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BasePluginDataManager.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.observer.ResourcePluginListener
        public void c(byte state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Byte.valueOf(state));
            } else {
                BasePluginDataManager.k(BasePluginDataManager.this, 1, null, 2, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/leba/core/BasePluginDataManager$c;", "", "", "FROM_ACCOUNT_CHANGE", "I", "FROM_INIT", "FROM_NOTIFY_STATE", "FROM_PATCH_CONFIG_UPDATE", "FROM_PLUGIN_REQUEST", "FROM_REFRESH_FLAG", "FROM_REMOTE_USER_SETTING", "FROM_THEME_CHANGE", "FROM_UNITED_CONFIG_NOTIFY", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.core.BasePluginDataManager$c, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/leba/core/BasePluginDataManager$d;", "", "", "Lcom/tencent/mobileqq/leba/entity/n;", "pluginDataList", "morePluginList", "", "Ef", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface d {
        void Ef(@Nullable List<? extends n> pluginDataList, @Nullable List<? extends n> morePluginList);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17313);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BasePluginDataManager(int i3) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.style = i3;
        this.pluginDataList = new ArrayList();
        this.morePluginDataList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(BasePluginDataManager$lebaProxyFilter$2.INSTANCE);
        this.lebaProxyFilter = lazy;
        this.loadPluginListenerList = new LinkedHashSet();
        this.lebaPluginProxy = new LebaPluginProxy();
        a aVar = new a();
        this.configUpdateCallback = aVar;
        b bVar = new b();
        this.resourcePluginListener = bVar;
        ((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, "")).addLebaListener(bVar);
        LebaPluginListUnitedConfigParser.INSTANCE.c(aVar);
    }

    private final List<LebaPluginInfo> a(int mode, int style) {
        List<com.tencent.mobileqq.leba.entity.d> j3;
        QLog.d("BasePluginDataManager", 2, "loadServerPlugins");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean c16 = com.tencent.mobileqq.leba.utils.c.c(mode, style);
        if (c16) {
            j3 = f.k(peekAppRuntime, mode, style);
            Intrinsics.checkNotNullExpressionValue(j3, "{\n            LebaUtil.g\u2026p, mode, style)\n        }");
        } else {
            j3 = f.j(peekAppRuntime);
            Intrinsics.checkNotNullExpressionValue(j3, "{\n            LebaUtil.g\u2026GroupInfo(mApp)\n        }");
        }
        Map<Long, com.tencent.mobileqq.leba.entity.d> b16 = f.b(j3);
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BasePluginDataManager", 2, "loadServerPlugins, groupMap is null");
                return null;
            }
            return null;
        }
        EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
        Intrinsics.checkNotNullExpressionValue(createEntityManager, "mApp.entityManagerFactory.createEntityManager()");
        List<LebaPluginInfo> all = LebaPluginInfo.getAll(createEntityManager);
        createEntityManager.close();
        if (all != null && all.size() > 0) {
            int size = all.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = size - 1;
                    LebaPluginInfo lebaPluginInfo = all.get(size);
                    com.tencent.mobileqq.leba.entity.d dVar = b16.get(Long.valueOf(lebaPluginInfo.uiResId));
                    if (dVar == null) {
                        QLog.i("BasePluginDataManager", 1, "loadServerPlugins remove: " + lebaPluginInfo);
                        all.remove(lebaPluginInfo);
                    } else {
                        QLog.i("BasePluginDataManager", 4, "loadServerPlugins add: " + lebaPluginInfo);
                        lebaPluginInfo.groupId = dVar.f240472b + 1;
                        lebaPluginInfo.sPriority = f.i(dVar);
                    }
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                }
            }
            if (c16) {
                JSONObject n3 = f.n(peekAppRuntime, mode, style);
                Intrinsics.checkNotNullExpressionValue(n3, "getLebaPluginResConf(mApp, mode, style)");
                for (LebaPluginInfo lebaPluginInfo2 : all) {
                    if (lebaPluginInfo2 != null) {
                        try {
                            lebaPluginInfo2.resConf = n3.getString(String.valueOf(lebaPluginInfo2.uiResId));
                        } catch (JSONException e16) {
                            QLog.e("BasePluginDataManager", 1, "loadServerPlugins exception! current resConf: " + lebaPluginInfo2.resConf, e16);
                        }
                    }
                }
            }
        }
        return all;
    }

    public static /* synthetic */ void k(BasePluginDataManager basePluginDataManager, int i3, String str, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                str = "";
            }
            basePluginDataManager.j(i3, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPluginList");
    }

    private final void r(List<? extends LebaPluginInfo> list) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IL\u2026va, ProcessConstant.MAIN)");
        ((ILebaHelperService) runtimeService).pluginInfoPatch(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LebaPluginProxy b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LebaPluginProxy) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.lebaPluginProxy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<n> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.morePluginDataList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<n> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.pluginDataList;
    }

    @NotNull
    public final synchronized Pair<List<n>, List<n>> e() {
        List list;
        List list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            list = CollectionsKt___CollectionsKt.toList(this.pluginDataList);
            list2 = CollectionsKt___CollectionsKt.toList(this.morePluginDataList);
            return new Pair<>(list, list2);
        }
        return (Pair) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @NotNull
    public synchronized List<n> f() {
        List<n> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            list = CollectionsKt___CollectionsKt.toList(this.pluginDataList);
            return list;
        }
        return (List) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.style;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<LebaPluginInfo> h(int mode, int style) {
        List<LebaPluginInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(mode), Integer.valueOf(style));
        }
        QLog.d("BasePluginDataManager", 2, "loadAllPlugins mode: " + mode + ", style: " + style + " ");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(i(style));
        arrayList.addAll(l(mode, style));
        r(arrayList);
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    @NotNull
    protected List<LebaPluginInfo> i(int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this, style);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.lebaPluginProxy.k(style));
        return arrayList;
    }

    public abstract void j(int from, @Nullable String reason);

    @NotNull
    protected final List<LebaPluginInfo> l(int mode, int style) {
        int i3;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(mode), Integer.valueOf(style));
        }
        ArrayList arrayList = new ArrayList();
        if (mode == 1 || mode == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            List<LebaPluginInfo> g16 = LebaUnitedConfigHelper.f240392a.g(mode, style);
            List<LebaPluginInfo> list = g16;
            if (!list.isEmpty()) {
                arrayList.addAll(list);
                com.tencent.mobileqq.leba.report.e eVar = com.tencent.mobileqq.leba.report.e.f240760a;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                int size = g16.size();
                if (style == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                eVar.a(true, currentTimeMillis2, size, z17);
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                List<LebaPluginInfo> a16 = a(mode, style);
                com.tencent.mobileqq.leba.report.e eVar2 = com.tencent.mobileqq.leba.report.e.f240760a;
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                if (a16 != null) {
                    i3 = a16.size();
                } else {
                    i3 = 0;
                }
                if (style == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                eVar2.a(false, currentTimeMillis4, i3, z16);
                if (a16 != null) {
                    arrayList.addAll(a16);
                }
            }
        }
        return arrayList;
    }

    public final void m(@Nullable List<? extends n> pluginDataList, @Nullable List<? extends n> morePluginList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) pluginDataList, (Object) morePluginList);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("BasePluginDataManager", 4, "notifyListenerPluginDataChanged: " + this.loadPluginListenerList.size() + ", " + this.loadPluginListener);
        }
        d dVar = this.loadPluginListener;
        if (dVar != null) {
            dVar.Ef(pluginDataList, morePluginList);
        }
        for (d dVar2 : this.loadPluginListenerList) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BasePluginDataManager", 2, "notifyListenerPluginDataChanged listener: " + dVar2 + " ");
            }
            dVar2.Ef(pluginDataList, morePluginList);
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        synchronized (this) {
            if (!this.pluginDataList.isEmpty()) {
                m(this.pluginDataList, this.morePluginDataList);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            ((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, "")).removeLebaListener(this.resourcePluginListener);
            LebaPluginListUnitedConfigParser.INSTANCE.d(this.configUpdateCallback);
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    public final void q(boolean tabChange, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
        }
    }

    public final void s(@NotNull d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.loadPluginListenerList.add(listener);
        QLog.d("BasePluginDataManager", 2, "registerListener listener: " + listener);
    }

    public final void t(@NotNull d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.loadPluginListenerList.remove(listener);
        QLog.d("BasePluginDataManager", 2, "unregisterListener listener: " + listener + " ");
    }
}
