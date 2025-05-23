package com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.guildsearch.UpdateDisplayGuild;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0018\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00160\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0016`\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/guildlist/TroopBindGuildListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/guildsearch/UpdateDisplayGuild;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "vh", OcrConfig.CHINESE, "initDtPageReport", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Llt2/c;", BdhLogUtil.LogTag.Tag_Conn, "Llt2/c;", "viewModel", "Ljt2/a;", "D", "Ljt2/a;", "guildAdapter", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGuildListFragment extends QIphoneTitleBarFragment implements SimpleEventReceiver<UpdateDisplayGuild> {

    /* renamed from: C, reason: from kotlin metadata */
    private lt2.c viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private jt2.a guildAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/guildmanage/guildlist/TroopBindGuildListFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            int i3;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            lt2.c cVar = TroopBindGuildListFragment.this.viewModel;
            lt2.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            if (!cVar.getIsEnd() && newState == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                jt2.a aVar = TroopBindGuildListFragment.this.guildAdapter;
                if (aVar != null) {
                    i3 = aVar.getNUM_BACKGOURND_ICON();
                } else {
                    i3 = 0;
                }
                if (i3 - findLastVisibleItemPosition < 3) {
                    lt2.c cVar3 = TroopBindGuildListFragment.this.viewModel;
                    if (cVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        cVar2 = cVar3;
                    }
                    cVar2.a2(true);
                }
            }
        }
    }

    private final void initDtPageReport() {
        Map mutableMapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_group_app_channel_show");
        Pair[] pairArr = new Pair[2];
        lt2.c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        pairArr[0] = TuplesKt.to("group_id", cVar.getTroopUin());
        pairArr[1] = TuplesKt.to("group_uin_type", "1");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, new PageParams((Map<String, ?>) mutableMapOf));
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
    }

    private final void initUI(View rootView) {
        View findViewById = rootView.findViewById(R.id.f71833p8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.recycler_layout)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        lt2.c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        jt2.a aVar = new jt2.a(qBaseActivity, cVar);
        this.guildAdapter = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setItemAnimator(null);
        recyclerView.addOnScrollListener(new b());
    }

    private final void initViewModel() {
        String string = requireArguments().getString("troop_uin");
        if (string == null) {
            string = "";
        }
        this.viewModel = new lt2.c(string);
    }

    private final void vh() {
        lt2.c cVar = this.viewModel;
        lt2.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        LiveData<ArrayList<AIOBindGuildInfo>> O1 = cVar.O1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ArrayList<AIOBindGuildInfo>, Unit> function1 = new Function1<ArrayList<AIOBindGuildInfo>, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.TroopBindGuildListFragment$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<AIOBindGuildInfo> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<AIOBindGuildInfo> it) {
                jt2.a aVar = TroopBindGuildListFragment.this.guildAdapter;
                if (aVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    aVar.setData(it);
                }
            }
        };
        O1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBindGuildListFragment.wh(Function1.this, obj);
            }
        });
        lt2.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        MutableLiveData<Boolean> U1 = cVar3.U1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.TroopBindGuildListFragment$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                TroopBindGuildListFragment.this.zh();
            }
        };
        U1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBindGuildListFragment.xh(Function1.this, obj);
            }
        });
        lt2.c cVar4 = this.viewModel;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar4;
        }
        LiveData<Boolean> S1 = cVar2.S1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.TroopBindGuildListFragment$initObserver$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                jt2.a aVar = TroopBindGuildListFragment.this.guildAdapter;
                if (aVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    aVar.j0(it.booleanValue());
                }
            }
        };
        S1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBindGuildListFragment.yh(Function1.this, obj);
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh() {
        Long longOrNull;
        long j3;
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_force_restart", true);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
            lt2.c cVar = this.viewModel;
            lt2.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            String troopUin = cVar.getTroopUin();
            lt2.c cVar3 = this.viewModel;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar3 = null;
            }
            String troopName = cVar3.getTroopName();
            lt2.c cVar4 = this.viewModel;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar2 = cVar4;
            }
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(cVar2.getTroopUin());
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            iAIOStarterApi.navigateToAIO(applicationContext, 2, troopUin, troopName, j3, bundle);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.fzt;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<UpdateDisplayGuild>> getEventClass() {
        ArrayList<Class<UpdateDisplayGuild>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateDisplayGuild.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof UpdateDisplayGuild) {
            lt2.c cVar = this.viewModel;
            Long l3 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            UpdateDisplayGuild updateDisplayGuild = (UpdateDisplayGuild) event;
            cVar.W1(updateDisplayGuild.getGuildInfo());
            AIOBindGuildInfo guildInfo = updateDisplayGuild.getGuildInfo();
            if (guildInfo != null) {
                l3 = Long.valueOf(guildInfo.guildId);
            }
            QLog.i("TroopBindGuildListFragment", 1, "[onReceiveEvent] id = " + l3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle(getString(R.string.f2324174h));
        initViewModel();
        View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        initUI(mContentView);
        vh();
        lt2.c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        lt2.c.b2(cVar, false, 1, null);
        initDtPageReport();
    }
}
