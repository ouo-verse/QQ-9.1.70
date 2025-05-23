package com.tencent.mobileqq.troopmanage.multigroup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.TroopMultiGroupManageDataFrom;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.TroopMultiGroupManageItemType;
import com.tencent.mobileqq.troopmanage.component.bv;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J-\u0010\u0010\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\tj\u0002`\u000fH\u0002J<\u0010\u0016\u001a6\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u0011j\u0002`\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u001e\u0010\u001b\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0012\u0010 \u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\u001eH\u0016J\b\u0010$\u001a\u00020\u0012H\u0014J&\u0010+\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0014J\"\u00100\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u0004H\u0016R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/TroopMultiGroupManageFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initUI", "", "troopUin", "Ah", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/f;", "Lkotlin/ParameterName;", "name", "dataList", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/MultiGroupHomeDataSuccessBlock;", OcrConfig.CHINESE, "Lkotlin/Function2;", "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/TroopMultiGroupManageErrorBlock;", "yh", "Bh", "", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageDataFrom;", "dataFrom", "uh", "contentView", "xh", "", "Eh", "Dh", "Ch", "useQUISecNavBar", "secNavBarNeedImmersive", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "Lcom/tencent/mobileqq/troopmanage/multigroup/g;", "D", "Lcom/tencent/mobileqq/troopmanage/multigroup/g;", "troopMultiGroupManageAdapter", "<init>", "()V", "E", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopMultiGroupManageFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TroopManageViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private g troopMultiGroupManageAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/TroopMultiGroupManageFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.multigroup.TroopMultiGroupManageFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63012);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMultiGroupManageFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ah(String troopUin) {
        Long longOrNull;
        long j3 = 0;
        if (troopUin != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        }
        Bh();
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.repo.a.f297668a.a(j3, zh(), yh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh() {
        ArrayList arrayList = new ArrayList();
        TroopMultiGroupManageItemType troopMultiGroupManageItemType = TroopMultiGroupManageItemType.MULTI_GROUP_MANAGE_DATA;
        TroopMultiGroupManageDataFrom troopMultiGroupManageDataFrom = TroopMultiGroupManageDataFrom.MULTI_GROUP_MANAGE_DATA_FROM_LOCAL;
        arrayList.add(new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f(troopMultiGroupManageItemType, null, null, troopMultiGroupManageDataFrom, 6, null));
        arrayList.add(new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f(TroopMultiGroupManageItemType.MULTI_GROUP_MANAGE_OPERATION, null, null, troopMultiGroupManageDataFrom, 6, null));
        uh(arrayList, troopMultiGroupManageDataFrom);
    }

    private final boolean Ch() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean Dh(String troopUin) {
        Long longOrNull;
        long longValue;
        if (TextUtils.isEmpty(troopUin)) {
            return false;
        }
        if (troopUin != null) {
            try {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            } catch (Throwable th5) {
                QLog.e("TroopMultiGroupManageFragment", 1, "troopUin.toLongOrNull() e: " + th5);
            }
            if (longOrNull != null) {
                longValue = longOrNull.longValue();
                if (longValue <= 0) {
                    return false;
                }
                return true;
            }
        }
        longValue = 0;
        if (longValue <= 0) {
        }
        return true;
    }

    private final boolean Eh() {
        return requireArguments().getBoolean("from_multi_troop_manage_tab", false);
    }

    private final void initUI(View rootView) {
        TroopManageViewModel troopManageViewModel = this.viewModel;
        if (troopManageViewModel == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.f102905z6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lti_manage_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.troopMultiGroupManageAdapter = new g(troopManageViewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.troopMultiGroupManageAdapter);
        g gVar = this.troopMultiGroupManageAdapter;
        if (gVar != null) {
            gVar.w0(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troopmanage.multigroup.TroopMultiGroupManageFragment$initUI$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMultiGroupManageFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String url) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(url, "url");
                    Intent intent = new Intent(TroopMultiGroupManageFragment.this.requireActivity(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", url + "&user_from=2");
                    TroopMultiGroupManageFragment.this.requireActivity().startActivity(intent);
                }
            });
        }
        g gVar2 = this.troopMultiGroupManageAdapter;
        if (gVar2 != null) {
            gVar2.x0(new Function1<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f, Unit>() { // from class: com.tencent.mobileqq.troopmanage.multigroup.TroopMultiGroupManageFragment$initUI$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMultiGroupManageFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f fVar) {
                    invoke2(fVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f troopData) {
                    TroopManageViewModel troopManageViewModel2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopData);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(troopData, "troopData");
                    com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.c c16 = troopData.c();
                    if (c16 != null) {
                        TroopMultiGroupManageFragment troopMultiGroupManageFragment = TroopMultiGroupManageFragment.this;
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        Intent intent = new Intent();
                        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
                        if (currentAccountUin == null) {
                            currentAccountUin = "0";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app?.currentAccountUin ?: \"0\"");
                        }
                        intent.putExtra("uin", currentAccountUin);
                        intent.putExtra("troop_uin", c16.a());
                        QPublicFragmentActivity.startForResult(troopMultiGroupManageFragment.requireActivity(), intent, com.tencent.mobileqq.troopmanage.base.b.c(), 28);
                        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                        troopManageViewModel2 = troopMultiGroupManageFragment.viewModel;
                        simpleEventBus.unRegisterReceiver(troopManageViewModel2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh(final List<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f> dataList, final TroopMultiGroupManageDataFrom dataFrom) {
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getCreatedTroopListAsync(true, new Consumer() { // from class: com.tencent.mobileqq.troopmanage.multigroup.h
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                TroopMultiGroupManageFragment.vh(TroopMultiGroupManageDataFrom.this, dataList, this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(final TroopMultiGroupManageDataFrom dataFrom, final List dataList, final TroopMultiGroupManageFragment this$0, final List list) {
        Intrinsics.checkNotNullParameter(dataFrom, "$dataFrom");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troopmanage.multigroup.i
            @Override // java.lang.Runnable
            public final void run() {
                TroopMultiGroupManageFragment.wh(list, dataFrom, dataList, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(List list, TroopMultiGroupManageDataFrom dataFrom, List dataList, TroopMultiGroupManageFragment this$0) {
        Intrinsics.checkNotNullParameter(dataFrom, "$dataFrom");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TroopInfo troopInfo = (TroopInfo) it.next();
            dataList.add(new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f(TroopMultiGroupManageItemType.MULTI_GROUP_MANAGE_SETTING, null, new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.c(troopInfo.getTroopUin(), troopInfo.getNewTroopNameOrTroopName(), troopInfo.wMemberNum), dataFrom, 2, null));
        }
        g gVar = this$0.troopMultiGroupManageAdapter;
        if (gVar != null) {
            gVar.v0(dataList);
        }
    }

    private final void xh(View contentView) {
        try {
            VideoReport.addToDetectionWhitelist(getQBaseActivity());
            VideoReport.setPageId(contentView, "pg_group_set_manage");
            VideoReport.setPageParams(contentView, new PageParams(bv.INSTANCE.a(this.viewModel)));
            VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_ALL);
        } catch (Exception e16) {
            QLog.e("TroopMultiGroupManageFragment", 1, "reportDtOnCreate e: " + e16);
        }
    }

    private final Function2<Integer, String, Unit> yh() {
        return new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.troopmanage.multigroup.TroopMultiGroupManageFragment$handleErrorBlock$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMultiGroupManageFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                } else {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    TroopMultiGroupManageFragment.this.Bh();
                }
            }
        };
    }

    private final Function1<List<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f>, Unit> zh() {
        return new Function1<List<? extends com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f>, Unit>() { // from class: com.tencent.mobileqq.troopmanage.multigroup.TroopMultiGroupManageFragment$handleSuccessBlock$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMultiGroupManageFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f> list) {
                invoke2((List<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(it);
                TroopMultiGroupManageFragment.this.uh(arrayList, TroopMultiGroupManageDataFrom.MULTI_GROUP_MANAGE_DATA_FROM_SERVER);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        String string = requireArguments().getString("troop_uin");
        if (Ch() && Dh(string)) {
            if (Eh()) {
                QUISecNavBar qUISecNavBar = this.quiSecNavBar;
                if (qUISecNavBar != null) {
                    qUISecNavBar.setVisibility(8);
                }
            } else {
                requireArguments().putInt(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 1);
                requireArguments().putInt("page_status", 1);
                setTitle(getString(R.string.f234977ae));
            }
            com.tencent.mobileqq.troopmanage.repo.h hVar = com.tencent.mobileqq.troopmanage.repo.h.f303236a;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            TroopManageViewModel troopManageViewModel = (TroopManageViewModel) hVar.c(string, requireActivity).get(TroopManageViewModel.class);
            this.viewModel = troopManageViewModel;
            if (troopManageViewModel != null) {
                Bundle requireArguments = requireArguments();
                Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
                troopManageViewModel.L1(requireArguments);
            }
            View view = ((QIphoneTitleBarFragment) this).mContentView;
            if (view != null) {
                initUI(view);
                Ah(string);
                xh(view);
                return;
            }
            return;
        }
        getQBaseActivity().finish();
        QLog.e("TroopMultiGroupManageFragment", 1, "doOnCreateView trooopUin invalid, troopUin = " + string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.g19;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        com.tencent.mobileqq.troopmanage.repo.a X1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 28) {
            SimpleEventBus.getInstance().registerReceiver(this.viewModel);
            TroopManageViewModel troopManageViewModel = this.viewModel;
            if (troopManageViewModel != null && (X1 = troopManageViewModel.X1()) != null) {
                com.tencent.mobileqq.troopmanage.repo.b m3 = X1.m();
                if (m3.i().bOwner) {
                    LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                    X1.j(viewLifecycleOwner, "TroopMultiGroupManageFragment-REQUEST_FRO_TROOP_MANAGE");
                }
                X1.q(m3.h().cGroupOption);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        TroopManageViewModel troopManageViewModel = this.viewModel;
        if (troopManageViewModel != null) {
            troopManageViewModel.M1();
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("troop_uin");
        } else {
            str = null;
        }
        com.tencent.mobileqq.troopmanage.repo.h.f303236a.d(str);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean secNavBarNeedImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return !Eh();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
