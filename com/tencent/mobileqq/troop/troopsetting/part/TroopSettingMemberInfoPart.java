package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopsetting.modules.memberface.TroopMemberFaceUpdateSource;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R*\u00100\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00140,j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014`-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingMemberInfoPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "Q9", "P9", "T9", "W9", "U9", "Lcom/tencent/mobileqq/troop/troopsetting/modules/memberface/TroopMemberFaceUpdateSource;", "source", "X9", "O9", "Z9", "Landroid/content/Intent;", "data", "V9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "e", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "troopMemberTitleView", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "troopMemberTitleConfig", tl.h.F, "Landroid/view/View;", "troopMemberPreView", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "previewRecyclerView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "itemViewList", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingMemberInfoPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISingleLineListItem troopMemberTitleView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b, x.c> troopMemberTitleConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View troopMemberPreView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView previewRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<View> itemViewList;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingMemberInfoPart$a;", "", "", "COLUMN_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingMemberInfoPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/part/TroopSettingMemberInfoPart$b", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends GridLayoutManager {
        static IPatchRedirector $redirector_;

        b(Context context) {
            super(context, 5);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60795);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingMemberInfoPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.itemViewList = new ArrayList<>();
        }
    }

    private final void O9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingMemberInfoPart$initObserver$1(this, null), 3, null);
    }

    private final void P9() {
        View inflate = View.inflate(getContext(), R.layout.h6s, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, com.ten\u2026nfo_item_member_v2, null)");
        this.troopMemberPreView = inflate;
        U9();
        ArrayList<View> arrayList = this.itemViewList;
        View view = this.troopMemberPreView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemberPreView");
            view = null;
        }
        arrayList.add(view);
        com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
        View view2 = this.troopMemberPreView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemberPreView");
            view2 = null;
        }
        cVar.A(view2, "em_group_member_unit", B9().T2(), null);
        View view3 = this.troopMemberPreView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemberPreView");
            view3 = null;
        }
        RecyclerView recyclerView = (RecyclerView) view3.findViewById(R.id.f27380g3);
        this.previewRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new b(getContext()));
            recyclerView.setItemAnimator(null);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TroopSettingViewModel B9 = B9();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            recyclerView.setAdapter(new com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.f(context, B9, activity));
            recyclerView.setVisibility(0);
        }
    }

    private final void Q9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.troopMemberTitleView = new QUISingleLineListItem(context, null, 2, null);
        String string = getContext().getString(R.string.ds7);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026ing.qb_group_member_list)");
        x.b.d dVar = new x.b.d(string);
        String string2 = getContext().getString(R.string.f235657c9, Integer.valueOf(B9().T2().wMemberNum));
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026troopInfoData.wMemberNum)");
        com.tencent.mobileqq.widget.listitem.x<x.b, x.c> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.g(string2, false, false, 6, null));
        this.troopMemberTitleConfig = xVar;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bn
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopSettingMemberInfoPart.R9(view);
            }
        });
        QUISingleLineListItem qUISingleLineListItem = this.troopMemberTitleView;
        if (qUISingleLineListItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemberTitleView");
            qUISingleLineListItem = null;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b, x.c> xVar2 = this.troopMemberTitleConfig;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemberTitleConfig");
            xVar2 = null;
        }
        qUISingleLineListItem.setConfig(xVar2);
        TriggerRunnerKt.b(qUISingleLineListItem, 1500L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingMemberInfoPart.S9(TroopSettingMemberInfoPart.this, view);
            }
        });
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.None);
        ArrayList<View> arrayList = this.itemViewList;
        QUISingleLineListItem qUISingleLineListItem2 = this.troopMemberTitleView;
        if (qUISingleLineListItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemberTitleView");
            qUISingleLineListItem2 = null;
        }
        arrayList.add(qUISingleLineListItem2);
        QUISingleLineListItem qUISingleLineListItem3 = this.troopMemberTitleView;
        if (qUISingleLineListItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemberTitleView");
            qUISingleLineListItem3 = null;
        }
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.A(qUISingleLineListItem3.findViewById(R.id.f66293a9), "em_group_member_detail", B9().T2(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(TroopSettingMemberInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9() {
        W9();
        B9().w3("Grp_Admin_data", "Clk_mber", "");
        eu.g("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, B9().T2().troopUin, eu.c(B9().T2()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9() {
        com.tencent.mobileqq.widget.listitem.x<x.b, x.c> xVar = this.troopMemberTitleConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b, x.c> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemberTitleConfig");
            xVar = null;
        }
        x.c O = xVar.O();
        if (O instanceof x.c.g) {
            String string = getContext().getString(R.string.f235657c9, Integer.valueOf(B9().T2().wMemberNum));
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026.wMemberNum\n            )");
            ((x.c.g) O).h(string);
            QUISingleLineListItem qUISingleLineListItem = this.troopMemberTitleView;
            if (qUISingleLineListItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopMemberTitleView");
                qUISingleLineListItem = null;
            }
            com.tencent.mobileqq.widget.listitem.x<x.b, x.c> xVar3 = this.troopMemberTitleConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopMemberTitleConfig");
            } else {
                xVar2 = xVar3;
            }
            qUISingleLineListItem.setConfig(xVar2);
        }
    }

    private final void V9(Intent data) {
        int i3;
        boolean z16;
        if (data != null && data.getExtras() != null) {
            Bundle extras = data.getExtras();
            Intrinsics.checkNotNull(extras);
            if (extras.getBoolean(AppConstants.Key.IS_NEED_FINISH)) {
                Intent intent = new Intent();
                intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                getActivity().setResult(-1, intent);
                com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                aVar.h(activity);
                return;
            }
            Bundle extras2 = data.getExtras();
            if (extras2 != null) {
                z16 = extras2.getBoolean("finish_chat_setting");
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.mobileqq.troop.troopsetting.activity.a aVar2 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                Activity activity2 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                aVar2.h(activity2);
                return;
            }
        }
        IRuntimeService runtimeService = z9().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        TroopInfoData T2 = B9().T2();
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(T2.troopUin);
        if (findTroopInfo != null && (i3 = findTroopInfo.wMemberNum) != T2.wMemberNum) {
            T2.updateTroopAdmMemberNum(findTroopInfo, i3);
            U9();
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_relation_troop_invite_refresh", false);
            QLog.i("TroopMemberInfoGroupPart", 1, "[resultForTroopMemberList] switchOn:" + isSwitchOn);
            if (isSwitchOn) {
                B9().C3();
            }
        }
        X9(TroopMemberFaceUpdateSource.RESULT_CODE_MEMBER_LIST);
        B9().b4(a.b.f301114a);
    }

    private final void W9() {
        TroopInfoData T2 = B9().T2();
        Intent intent = new Intent();
        intent.putExtra("troop_uin", T2.troopUin);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 0);
        intent.putExtra(AppConstants.Key.TROOP_INFO_MEMBER_NUM, T2.wMemberNum);
        RouteUtils.startActivityForResult(getActivity(), intent, "/troop/memberlist/TroopMemberList", 9);
        try {
            String str = "2";
            if (T2.bOwner) {
                str = "0";
            } else if (T2.bAdmin) {
                str = "1";
            }
            ReportController.o(z9(), "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, T2.troopUin, "0", str, "");
        } catch (Exception e16) {
            QLog.e("TroopMemberInfoGroupPart", 1, "[startViewTroopMember] e = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(TroopMemberFaceUpdateSource source) {
        Long longOrNull;
        long j3;
        CopyOnWriteArrayList<String> L2 = B9().L2();
        if (L2 == null) {
            QLog.e("TroopMemberInfoGroupPart", 1, "[updateGridTroopMemberFace] failed. list is null. from = " + source.ordinal());
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = L2.size();
        for (int i3 = 0; i3 < size; i3++) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(L2.get(i3));
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            arrayList.add(Long.valueOf(j3));
        }
        B9().N3(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberInfoGroupPart", 2, "[updateGridTroopMemberFace] from = " + source.ordinal() + " list size = " + L2.size() + " memberUins.size = " + arrayList.size());
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bp
            @Override // java.lang.Runnable
            public final void run() {
                TroopSettingMemberInfoPart.Y9(TroopSettingMemberInfoPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(TroopSettingMemberInfoPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberInfoGroupPart", 2, "[updateGridTroopMemberFace] isFinishing = " + activity.isFinishing());
        }
        if (activity.isFinishing()) {
            return;
        }
        this$0.Z9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.f] */
    public final void Z9() {
        RecyclerView.Adapter adapter;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        RecyclerView recyclerView = this.previewRecyclerView;
        T t16 = 0;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.f) {
            t16 = (com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.f) adapter;
        }
        objectRef.element = t16;
        if (t16 == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TroopSettingViewModel B9 = B9();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            ?? fVar = new com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.f(context, B9, activity);
            objectRef.element = fVar;
            RecyclerView recyclerView2 = this.previewRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter((RecyclerView.Adapter) fVar);
            }
        }
        com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bq
            @Override // java.lang.Runnable
            public final void run() {
                TroopSettingMemberInfoPart.aa(Ref.ObjectRef.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void aa(Ref.ObjectRef recyclerViewAdapter, TroopSettingMemberInfoPart this$0) {
        Intrinsics.checkNotNullParameter(recyclerViewAdapter, "$recyclerViewAdapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.f) recyclerViewAdapter.element).F0(this$0.B9().M2());
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        Iterator<T> it = this.itemViewList.iterator();
        while (true) {
            boolean z16 = false;
            if (it.hasNext()) {
                View view = (View) it.next();
                if (view != null) {
                    if (view.getVisibility() == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        view.setBackground(null);
                        linearLayout.addView(view);
                    }
                }
            } else {
                return new Group[]{new Group(new com.tencent.mobileqq.troop.troopsetting.customconfig.b(linearLayout))};
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9) {
            V9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        O9();
        Q9();
        P9();
        B9().K2();
    }
}
