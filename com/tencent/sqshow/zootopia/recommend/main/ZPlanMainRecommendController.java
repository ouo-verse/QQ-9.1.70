package com.tencent.sqshow.zootopia.recommend.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabContentUrl;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabData;
import com.tencent.sqshow.zootopia.recommend.main.tab.a;
import com.tencent.sqshow.zootopia.recommend.main.tab.network.ZPlanTabServerDataManager;
import com.tencent.sqshow.zootopia.recommend.specialtab.ZPlanTabH5Fragment;
import com.tencent.sqshow.zootopia.recommend.specialtab.ZPlanTabHippyFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qv4.x;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001cB\u000f\u0012\u0006\u0010J\u001a\u00020I\u00a2\u0006\u0004\bK\u0010LJ\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\u0010\u0010$\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010%\u001a\u00020\nJ\u0010\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001eH\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R0\u00106\u001a\u001e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001702j\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0017`48\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u00105R\u0016\u00108\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00107R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00109R\u0016\u0010;\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010:R$\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u00120<j\b\u0012\u0004\u0012\u00020\u0012`=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00107R\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00107R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010:\u00a8\u0006N"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendController;", "Lcom/tencent/mobileqq/zootopia/api/b;", "Llb4/a;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/sqshow/zootopia/recommend/main/tab/a;", "tabView", "Landroid/content/Intent;", "intent", "", "k", "t", ReportConstant.COSTREPORT_PREFIX, "", "targetTabId", "u", "", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/f;", "l", "j", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", FunctionConfigManagerImpl.CONFIG_CONTENT_URL, "Llb4/b;", "i", "fragmentContainerId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tabData", "a", "b", "", "onBackPressedEvent", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "g", "p", "f", "isNetEffective", "onNetChangeEvent", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "La94/b;", "e", "Lkotlin/Lazy;", h.F, "()La94/b;", "fragmentHelper", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "fragmentPool", "I", "fragContainerId", "Landroidx/fragment/app/FragmentActivity;", "Z", "alreadyHandlerAutoOpen", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "tabList", "D", "selectedTabIndex", "E", "selectedTabId", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/recommend/main/tab/a;", "G", "tabRefreshTaskFailed", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "source", "<init>", "(Lcom/tencent/mobileqq/zootopia/FragmentSource;)V", "H", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMainRecommendController implements com.tencent.mobileqq.zootopia.api.b, lb4.a, INetEventHandler {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final ArrayList<ZPlanTabData> tabList;

    /* renamed from: D, reason: from kotlin metadata */
    private int selectedTabIndex;

    /* renamed from: E, reason: from kotlin metadata */
    private int selectedTabId;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.recommend.main.tab.a tabView;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean tabRefreshTaskFailed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy fragmentHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, lb4.b> fragmentPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int fragContainerId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FragmentActivity activity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean alreadyHandlerAutoOpen;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendController$a;", "", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "source", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendController$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ZootopiaSource b(FragmentSource source) {
            return ZootopiaSource.INSTANCE.c(source.getCurrent(), ZootopiaSource.SUB_SOURCE_STORE, source.getFrom());
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendController$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/x;", "", "error", "", "message", "", "onResultFailure", "result", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<x> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(x result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZPlanMainRecommendController", 1, "refreshTab onResultSuccess");
            ZPlanMainRecommendController.this.tabRefreshTaskFailed = false;
            ZPlanMainRecommendController.this.t();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ZPlanMainRecommendController.this.tabRefreshTaskFailed = true;
            QLog.e("ZPlanMainRecommendController", 1, "refreshTab onResultFailure error:" + error + ", message:" + message);
        }
    }

    public ZPlanMainRecommendController(FragmentSource source) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(source, "source");
        this.sourceCurrent = INSTANCE.b(source);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a94.b>() { // from class: com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendController$fragmentHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a94.b invoke() {
                return new a94.b(new ArrayList());
            }
        });
        this.fragmentHelper = lazy;
        this.fragmentPool = new HashMap<>();
        this.tabList = new ArrayList<>();
    }

    private final a94.b h() {
        return (a94.b) this.fragmentHelper.getValue();
    }

    private final lb4.b i(ZPlanTabContentUrl contentUrl) {
        lb4.b zPlanRoleFragmentV2;
        String f16 = contentUrl.f();
        lb4.b bVar = this.fragmentPool.get(f16);
        if (bVar != null) {
            return bVar;
        }
        int pageType = contentUrl.getPageType();
        if (pageType == 1) {
            zPlanRoleFragmentV2 = new ZPlanRoleFragmentV2(contentUrl);
        } else if (pageType == 5) {
            zPlanRoleFragmentV2 = ZPlanTabH5Fragment.INSTANCE.a(contentUrl);
        } else if (pageType != 6) {
            zPlanRoleFragmentV2 = ZPlanTabH5Fragment.INSTANCE.a(contentUrl);
        } else {
            zPlanRoleFragmentV2 = ZPlanTabHippyFragment.INSTANCE.a(contentUrl);
        }
        this.fragmentPool.put(f16, zPlanRoleFragmentV2);
        return zPlanRoleFragmentV2;
    }

    private final void j(FragmentActivity activity) {
        Bundle bundle;
        Intent intent = activity.getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras == null || (bundle = extras.getBundle("autoOpenUeParams")) == null || this.alreadyHandlerAutoOpen) {
            return;
        }
        this.alreadyHandlerAutoOpen = true;
        extras.remove("autoOpenUeParams");
        ((IEntryApi) QRoute.api(IEntryApi.class)).startAvatarSubSceneFragment(activity, this.sourceCurrent, bundle);
    }

    private final void k(FragmentActivity activity, com.tencent.sqshow.zootopia.recommend.main.tab.a tabView, Intent intent) {
        this.tabView = tabView;
        tabView.g(this);
        l();
        s(intent);
        tabView.f(this.selectedTabIndex, this.tabList);
        a.C9836a.b(tabView, false, null, 3, null);
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).saveCache(activity, ZplanCacheComponentType.MAIN_TAB, tabView);
        b();
    }

    private final List<ZPlanTabData> l() {
        this.tabList.clear();
        this.tabList.addAll(com.tencent.sqshow.zootopia.recommend.main.tab.b.f372639a.d());
        return this.tabList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ZPlanMainRecommendController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        com.tencent.sqshow.zootopia.recommend.main.tab.a aVar = this.tabView;
        if (aVar == null) {
            return;
        }
        l();
        QLog.i("ZPlanMainRecommendController", 1, "refreshTabData selectedTabId:" + this.selectedTabId);
        u(this.selectedTabId);
        aVar.f(this.selectedTabIndex, this.tabList);
    }

    private final void u(int targetTabId) {
        Object obj;
        Iterator<T> it = this.tabList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((ZPlanTabData) obj).getTabId() == targetTabId) {
                    break;
                }
            }
        }
        ZPlanTabData zPlanTabData = (ZPlanTabData) obj;
        QLog.i("ZPlanMainRecommendController", 1, "updateSelectedData targetTabId:" + targetTabId);
        if (zPlanTabData == null) {
            this.selectedTabId = 0;
            this.selectedTabIndex = 0;
        } else {
            this.selectedTabId = zPlanTabData.getTabId();
            this.selectedTabIndex = this.tabList.indexOf(zPlanTabData);
        }
    }

    @Override // lb4.a
    public void a(ZPlanTabData tabData) {
        Intent intent;
        Bundle extras;
        Bundle arguments;
        Intent intent2;
        Intrinsics.checkNotNullParameter(tabData, "tabData");
        u(tabData.getTabId());
        lb4.b i3 = i(tabData.getContentUrlInfo());
        Fragment fragment = i3.getFragment();
        QLog.i("ZPlanMainRecommendController", 1, "showMainFragment , createNew - " + fragment);
        if (fragment.getArguments() == null) {
            FragmentActivity fragmentActivity = this.activity;
            fragment.setArguments((fragmentActivity == null || (intent2 = fragmentActivity.getIntent()) == null) ? null : intent2.getExtras());
        } else {
            FragmentActivity fragmentActivity2 = this.activity;
            if (fragmentActivity2 != null && (intent = fragmentActivity2.getIntent()) != null && (extras = intent.getExtras()) != null && (arguments = fragment.getArguments()) != null) {
                arguments.putAll(extras);
            }
        }
        h().d(fragment);
        FragmentActivity fragmentActivity3 = this.activity;
        if (fragmentActivity3 != null) {
            h().g(fragmentActivity3, this.fragContainerId, fragment, false);
        }
        com.tencent.sqshow.zootopia.recommend.main.tab.a aVar = this.tabView;
        if (aVar != null) {
            aVar.e(i3);
        }
    }

    public final void g() {
        for (Fragment fragment : h().e()) {
            QPublicBaseFragment qPublicBaseFragment = fragment instanceof QPublicBaseFragment ? (QPublicBaseFragment) fragment : null;
            if (qPublicBaseFragment != null) {
                qPublicBaseFragment.beforeFinish();
            }
        }
    }

    public final void m(int fragmentContainerId, FragmentActivity activity, com.tencent.sqshow.zootopia.recommend.main.tab.a tabView, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        AppNetConnInfo.registerNetChangeReceiver(activity, this);
        this.activity = activity;
        this.fragContainerId = fragmentContainerId;
        k(activity, tabView, intent);
    }

    public final void n() {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            Iterator<T> it = h().e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityResultCaller activityResultCaller = (Fragment) it.next();
                lb4.b bVar = activityResultCaller instanceof lb4.b ? (lb4.b) activityResultCaller : null;
                if (bVar != null) {
                    bVar.dh();
                }
            }
            h().f(fragmentActivity);
            com.tencent.sqshow.zootopia.player.h.f372229a.a(fragmentActivity);
            for (ActivityResultCaller activityResultCaller2 : h().e()) {
                lb4.b bVar2 = activityResultCaller2 instanceof lb4.b ? (lb4.b) activityResultCaller2 : null;
                if (bVar2 != null) {
                    bVar2.z6();
                }
            }
        }
        h().e().clear();
        this.fragmentPool.clear();
        com.tencent.sqshow.zootopia.recommend.main.tab.a aVar = this.tabView;
        if (aVar != null) {
            aVar.destroy();
        }
        AppNetConnInfo.unregisterNetEventHandler(this);
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        ActivityResultCaller b16 = h().b();
        com.tencent.mobileqq.zootopia.api.b bVar = b16 instanceof com.tencent.mobileqq.zootopia.api.b ? (com.tencent.mobileqq.zootopia.api.b) b16 : null;
        if (bVar != null) {
            return bVar.onBackPressedEvent();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean isNetEffective) {
        QLog.i("ZPlanMainRecommendController", 1, "onNetChangeEvent isNetEffective:" + isNetEffective + ", tabRefreshTaskFailed:" + this.tabRefreshTaskFailed);
        if (isNetEffective && this.tabRefreshTaskFailed) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanMainRecommendController.o(ZPlanMainRecommendController.this);
                }
            }, 1000L);
        }
    }

    public final void p(Intent intent) {
        for (Fragment fragment : h().e()) {
            QPublicBaseFragment qPublicBaseFragment = fragment instanceof QPublicBaseFragment ? (QPublicBaseFragment) fragment : null;
            if (qPublicBaseFragment != null) {
                qPublicBaseFragment.onNewIntent(intent);
            }
        }
        s(intent);
    }

    public final void r() {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            j(fragmentActivity);
        }
    }

    @Override // lb4.a
    public void b() {
        this.tabRefreshTaskFailed = false;
        QLog.i("ZPlanMainRecommendController", 1, "refreshTab start");
        ZPlanTabServerDataManager.f372670a.p(new b());
    }

    public final void f() {
        QLog.i("ZPlanMainRecommendController", 1, "afterActivityFinish");
    }

    private final void s(Intent intent) {
        String str;
        Object obj;
        if (intent == null || (str = intent.getStringExtra("targetTab")) == null) {
            str = "";
        }
        QLog.i("ZPlanMainRecommendController", 1, "refreshSelectedTabIndex targetTab in intent:" + str);
        ZPlanTabContentUrl a16 = ZPlanTabContentUrl.INSTANCE.a(ISchemeApi.INSTANCE.a(str));
        Iterator<T> it = this.tabList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((ZPlanTabData) next).getContentUrlInfo().f(), a16 != null ? a16.f() : null)) {
                obj = next;
                break;
            }
        }
        ZPlanTabData zPlanTabData = (ZPlanTabData) obj;
        if (zPlanTabData != null) {
            u(zPlanTabData.getTabId());
        }
        QLog.i("ZPlanMainRecommendController", 1, "refreshSelectedTabIndex selectedTabData:" + zPlanTabData + ", selectedTabIndex:" + this.selectedTabIndex);
        com.tencent.sqshow.zootopia.recommend.main.tab.a aVar = this.tabView;
        if (aVar != null) {
            aVar.c(this.selectedTabIndex);
        }
    }

    public final void q() {
    }
}
