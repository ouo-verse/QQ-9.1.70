package com.tencent.sqshow.zootopia.recommend.specialtab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabContentUrl;
import com.tencent.sqshow.zootopia.recommend.main.tab.a;
import com.tencent.sqshow.zootopia.recommend.specialtab.event.TabBackFrom;
import com.tencent.sqshow.zootopia.recommend.specialtab.event.ZPlanTabBackEvent;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import id3.d;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lb4.b;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 F2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001GB\u000f\u0012\u0006\u00103\u001a\u00020.\u00a2\u0006\u0004\bD\u0010EJ\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0014H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010$\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0014H\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J$\u0010,\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*`+H\u0016J\b\u0010-\u001a\u00020\fH\u0016R\u001a\u00103\u001a\u00020.8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010C\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?\u00a8\u0006H"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/specialtab/ZPlanTabH5Fragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Llb4/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/zootopia/api/b;", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "vh", "Lcom/tencent/mobileqq/zootopia/Source;", "th", "", "getSubSource", "", "init", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "sh", "uh", "Landroidx/fragment/app/Fragment;", "getFragment", "", MiniGamePAHippyBaseFragment.KEY_THEME, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "", "tabIndex", "f", "refreshDataWhenDoubleCLick", "Be", "ib", "event", "onReceiveEvent", "onResume", "hidden", "onHiddenChanged", "onBackPressedEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", com.tencent.bugly.common.constants.Constants.BASE_IN_PLUGIN_ID, "()Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "tabContentUrl", "Lid3/d;", "D", "Lid3/d;", "reporter", "E", "Landroid/view/View;", "mContentView", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "xh", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, "G", "wh", "sourceCurrent", "<init>", "(Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;)V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTabH5Fragment extends WebViewFragment implements b, SimpleEventReceiver<SimpleBaseEvent>, com.tencent.mobileqq.zootopia.api.b {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final ZPlanTabContentUrl tabContentUrl;

    /* renamed from: D, reason: from kotlin metadata */
    private final d reporter;

    /* renamed from: E, reason: from kotlin metadata */
    private View mContentView;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy sourceFrom;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy sourceCurrent;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/specialtab/ZPlanTabH5Fragment$a;", "", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "tabContentUrl", "Lcom/tencent/sqshow/zootopia/recommend/specialtab/ZPlanTabH5Fragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.recommend.specialtab.ZPlanTabH5Fragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanTabH5Fragment a(ZPlanTabContentUrl tabContentUrl) {
            Intrinsics.checkNotNullParameter(tabContentUrl, "tabContentUrl");
            QLog.i("ZPlanTabH5Fragment_", 1, "build tabContentUrl:" + tabContentUrl);
            Intent intent = new Intent();
            intent.putExtra("url", tabContentUrl.getUrl());
            Bundle bundle = new Bundle();
            bundle.putParcelable("intent", intent);
            ZPlanTabH5Fragment zPlanTabH5Fragment = new ZPlanTabH5Fragment(tabContentUrl);
            zPlanTabH5Fragment.setArguments(bundle);
            return zPlanTabH5Fragment;
        }

        Companion() {
        }
    }

    public ZPlanTabH5Fragment(ZPlanTabContentUrl tabContentUrl) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(tabContentUrl, "tabContentUrl");
        this.tabContentUrl = tabContentUrl;
        this.reporter = new d(null, 1, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.recommend.specialtab.ZPlanTabH5Fragment$sourceFrom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                FragmentSource vh5;
                ZootopiaSource from;
                vh5 = ZPlanTabH5Fragment.this.vh();
                return (vh5 == null || (from = vh5.getFrom()) == null) ? ZootopiaSource.INSTANCE.i() : from;
            }
        });
        this.sourceFrom = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.recommend.specialtab.ZPlanTabH5Fragment$sourceCurrent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                Source th5;
                String subSource;
                ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                th5 = ZPlanTabH5Fragment.this.th();
                subSource = ZPlanTabH5Fragment.this.getSubSource();
                return companion.c(th5, subSource, ZPlanTabH5Fragment.this.xh());
            }
        });
        this.sourceCurrent = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSubSource() {
        return "sub_source_tab_h5_page";
    }

    private final void init() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void sh(View rootView) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(wh()));
            this.reporter.j(activity, rootView, uh(), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source th() {
        Source current;
        FragmentSource vh5 = vh();
        return (vh5 == null || (current = vh5.getCurrent()) == null) ? Source.UnSet : current;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSource vh() {
        Intent intent;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getArguments());
        if (f16 != null) {
            return f16;
        }
        FragmentActivity activity = getActivity();
        return companion.f((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
    }

    private final ZootopiaSource wh() {
        return (ZootopiaSource) this.sourceCurrent.getValue();
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.g
    public void Be(int tabIndex, boolean refreshDataWhenDoubleCLick) {
        TouchWebView touchWebView;
        QLog.i("ZPlanTabH5Fragment_", 1, "onTabReSelected tabIndex:" + tabIndex + ", refreshDataWhenDoubleCLick:" + refreshDataWhenDoubleCLick);
        if (!refreshDataWhenDoubleCLick || (touchWebView = this.webView) == null) {
            return;
        }
        touchWebView.reload();
    }

    @Override // lb4.b
    /* renamed from: D1, reason: from getter */
    public ZPlanTabContentUrl getTabContentUrl() {
        return this.tabContentUrl;
    }

    @Override // lb4.b
    public void dh() {
        b.a.b(this);
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.g
    public void f(int tabIndex) {
        QLog.i("ZPlanTabH5Fragment_", 1, "onTabSelected tabIndex:" + tabIndex);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZPlanTabBackEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public boolean isNightMode() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        FragmentActivity activity = getActivity();
        a aVar = activity != null ? (a) CommonExKt.p(activity, ZplanCacheComponentType.MAIN_TAB) : null;
        if (aVar != null && aVar.getMSelectedTab() == 0) {
            return false;
        }
        if (aVar != null) {
            aVar.c(0);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        this.mContentView = onCreateView;
        if (onCreateView != null) {
            sh(onCreateView);
        }
        init();
        return this.mContentView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        VideoReport.traversePage(this.mContentView);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        FragmentActivity activity;
        a aVar;
        if (!(event instanceof ZPlanTabBackEvent) || ((ZPlanTabBackEvent) event).getFrom() != TabBackFrom.H5 || (activity = getActivity()) == null || (aVar = (a) CommonExKt.p(activity, ZplanCacheComponentType.MAIN_TAB)) == null) {
            return;
        }
        aVar.c(0);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VideoReport.traversePage(this.mContentView);
        FragmentActivity activity = getActivity();
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            com.tencent.sqshow.zootopia.utils.a.a(qBaseActivity);
        }
    }

    public String uh() {
        return "zplan_tab_h5_page";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ZootopiaSource xh() {
        return (ZootopiaSource) this.sourceFrom.getValue();
    }

    @Override // lb4.b
    public void z6() {
        b.a.c(this);
    }

    @Override // lb4.b
    public Fragment getFragment() {
        return this;
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.g
    public void ib(int tabIndex) {
    }
}
