package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\u001b\u001a\u00020\u0002R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR.\u0010$\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u001fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 `!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010*\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\"\u00103\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020'0%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010)R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingManageGroupPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "O9", "W9", "T9", "Landroid/view/View;", "view", "X9", "Lcom/tencent/common/app/AppInterface;", "app", "", "troopUin", "Lcom/tencent/troopguild/api/ITroopUpgradeUtilsApi;", "troopUpgradeApi", "N9", "S9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "R9", "e", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/x;", "manageTroopConfig", "", "i", "Z", "mIsShowRedPointForAssociateForTroop", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mIsShowKingTeamReadPoint", "Lcom/tencent/mobileqq/widget/listitem/x$b;", BdhLogUtil.LogTag.Tag_Conn, "troopUpgradeConfig", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/q;", "D", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/q;", "troopOwnerTaskSettingConfig", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingManageGroupPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b, x.c.g> troopUpgradeConfig;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsetting.bizconfig.q troopOwnerTaskSettingConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group[] groups;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> manageTroopConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowRedPointForAssociateForTroop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowKingTeamReadPoint;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingManageGroupPart$a;", "", "", "RED_POINT_KEY_TROOP_ADMIN", "Ljava/lang/String;", "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME", "RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingManageGroupPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingManageGroupPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.groups = new Group[0];
            this.configList = new ArrayList<>();
        }
    }

    private final void N9(AppInterface app, String troopUin, ITroopUpgradeUtilsApi troopUpgradeApi) {
        if (troopUpgradeApi.hasTouchRedDotOfTroopUpgrade(troopUin)) {
            return;
        }
        troopUpgradeApi.noteHasTouchRedDotOfTroopUpgrade(troopUin, true);
        com.tencent.mobileqq.widget.listitem.x<x.b, x.c.g> xVar = this.troopUpgradeConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUpgradeConfig");
            xVar = null;
        }
        xVar.O().g(false);
        ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(app, troopUin, "troop", 6, 0);
    }

    private final void O9() {
        boolean z16;
        final TroopInfoData T2 = B9().T2();
        TroopInfo S2 = B9().S2();
        if (!T2.isOwnerOrAdim()) {
            return;
        }
        String string = getContext().getString(R.string.i6r);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026.string.troop_info_admin)");
        x.b.d dVar = new x.b.d(string);
        String qqStr = HardCodeUtil.qqStr(R.string.kgg);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.qqstr_chatsett_0a042dcf)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.g(qqStr, false, false, 6, null));
        this.manageTroopConfig = xVar;
        xVar.p(T2.isOwnerOrAdim());
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingManageGroupPart.P9(TroopSettingManageGroupPart.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bj
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopSettingManageGroupPart.Q9(TroopInfoData.this, view);
            }
        });
        this.mIsShowRedPointForAssociateForTroop = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + z9().getCurrentAccountUin());
        this.mIsShowKingTeamReadPoint = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isShowKingTeamRedPoint(S2.isKingBattleTroop(), "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + z9().getCurrentAccountUin());
        boolean isShowRedPoint = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isShowRedPoint(((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(getActivity(), "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.manageTroopConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = null;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageTroopConfig");
            xVar2 = null;
        }
        x.c.g O = xVar2.O();
        if (!isShowRedPoint && !this.mIsShowKingTeamReadPoint && !this.mIsShowRedPointForAssociateForTroop) {
            z16 = false;
        } else {
            z16 = true;
        }
        O.g(z16);
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> arrayList = this.configList;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar4 = this.manageTroopConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageTroopConfig");
        } else {
            xVar3 = xVar4;
        }
        arrayList.add(xVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(TroopSettingManageGroupPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(TroopInfoData mTroopInfoData, View it) {
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        Intrinsics.checkNotNullParameter(it, "it");
        eu.g("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, mTroopInfoData.troopUin);
    }

    private final void S9() {
        TroopInfoData T2 = B9().T2();
        com.tencent.mobileqq.troop.troopownertask.g gVar = com.tencent.mobileqq.troop.troopownertask.g.f301003a;
        String str = T2.troopUin;
        Intrinsics.checkNotNullExpressionValue(str, "mTroopInfoData.troopUin");
        if (gVar.f(str)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QUIListItemAdapter x95 = x9();
            String str2 = T2.troopUin;
            Intrinsics.checkNotNullExpressionValue(str2, "mTroopInfoData.troopUin");
            com.tencent.mobileqq.troop.troopsetting.bizconfig.q qVar = new com.tencent.mobileqq.troop.troopsetting.bizconfig.q(context, x95, str2);
            this.troopOwnerTaskSettingConfig = qVar;
            this.configList.add(qVar);
            gVar.j();
        }
    }

    private final void T9() {
        String string = getContext().getString(R.string.f236677f0);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026pi.R.string.troop_update)");
        this.troopUpgradeConfig = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, false, 6, null));
        TroopInfoData T2 = B9().T2();
        String str = T2.troopUin;
        if (str != null && com.tencent.mobileqq.troop.troopsetting.activity.f.f(z9(), T2) && getContext() != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b, x.c.g> xVar = this.troopUpgradeConfig;
            com.tencent.mobileqq.widget.listitem.x<x.b, x.c.g> xVar2 = null;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUpgradeConfig");
                xVar = null;
            }
            xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopSettingManageGroupPart.U9(TroopSettingManageGroupPart.this, view);
                }
            });
            xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bl
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    TroopSettingManageGroupPart.V9(view);
                }
            });
            com.tencent.mobileqq.widget.listitem.x<x.b, x.c.g> xVar3 = this.troopUpgradeConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUpgradeConfig");
                xVar3 = null;
            }
            xVar3.O().g(com.tencent.mobileqq.troop.troopsetting.activity.f.g(str));
            ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> arrayList = this.configList;
            com.tencent.mobileqq.widget.listitem.x<x.b, x.c.g> xVar4 = this.troopUpgradeConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUpgradeConfig");
            } else {
                xVar2 = xVar4;
            }
            arrayList.add(xVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(TroopSettingManageGroupPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.X9(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.troop.troopsetting.activity.f.e(view);
    }

    private final void W9() {
        String str;
        String str2;
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setRedPointSP("RED_POINT_KEY_TROOP_ADMIN");
        if (this.mIsShowKingTeamReadPoint) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setRedPointSP("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + z9().getCurrentAccountUin());
        }
        if (this.mIsShowRedPointForAssociateForTroop) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + z9().getCurrentAccountUin());
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.manageTroopConfig;
        Boolean bool = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageTroopConfig");
            xVar = null;
        }
        xVar.O().g(false);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.manageTroopConfig;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageTroopConfig");
            xVar2 = null;
        }
        D9(xVar2);
        Intent intent = new Intent();
        TroopInfoData T2 = B9().T2();
        intent.putExtra("uin", z9().getCurrentAccountUin());
        intent.putExtra("troop_uin", T2.troopUin);
        intent.putExtra(AppConstants.Key.FORWARD_LOCATION, T2.troopLocation);
        intent.putExtra(AppConstants.Key.FORWARD_LATITUDE, T2.troopLat);
        intent.putExtra(AppConstants.Key.FORWARD_LONGITUDE, T2.troopLon);
        intent.putExtra(AppConstants.Key.FORWARD_CITYID, T2.cityId);
        intent.putExtra(AppConstants.Key.TROOP_INFO_TROOP_AUTH_SUBMIT_TIME, B9().I2());
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, getContext().getResources().getString(R.string.a1o));
        intent.putExtra(AppConstants.Key.KEY_QIDIAN_PRIVATE_TROOP, B9().G2());
        intent.putExtra(AppConstants.Key.KEY_IS_UPDATE_BEFORE_805, ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(getActivity(), "8.0.5"));
        intent.putExtra("key_start_time", SystemClock.uptimeMillis());
        intent.putExtra("is_troop_process_on", com.tencent.mobileqq.troop.troopsetting.modules.base.f.a() ? 1 : 0);
        TroopInfo S2 = B9().S2();
        boolean isKingBattleTroop = S2.isKingBattleTroop();
        intent.putExtra(AppConstants.Key.KEY_CUSTOMED_GAME_TROOP, isKingBattleTroop);
        if (isKingBattleTroop) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).reportDC00087(null, "846", "205605", "", "84601", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD);
        }
        if (B9().C2() == null) {
            B9().H3(TroopUrlConfProcessor.a());
        }
        com.tencent.mobileqq.troop.troopurl.config.a C2 = B9().C2();
        if (C2 != null) {
            str = C2.f301842b;
        } else {
            str = null;
        }
        intent.putExtra("autoApprovalUrl", str);
        com.tencent.mobileqq.troop.troopurl.config.a C22 = B9().C2();
        if (C22 != null) {
            bool = Boolean.valueOf(C22.f301843c);
        }
        intent.putExtra("frequencyLimitVisible", bool);
        if (QLog.isDevelopLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("start troop mng [flag: %s, msgLimitFreq: %s]", Arrays.copyOf(new Object[]{Long.valueOf(S2.dwGroupFlagExt3 & 1048576), Integer.valueOf(S2.nMsgLimitFreq)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.i("TroopMngTest", 4, format);
        }
        intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_EDIT_CURRENT_UIN, z9().getCurrentUin());
        boolean isTroopGuild = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(T2.troopUin);
        intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_IS_GUILD, isTroopGuild);
        if (isTroopGuild) {
            ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
            String str3 = T2.troopUin;
            Intrinsics.checkNotNullExpressionValue(str3, "mTroopInfoData.troopUin");
            String troopGuildId = iTroopGuildApi.getTroopGuildId(str3);
            intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_ID, troopGuildId);
            intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_CHANNEL_ID, ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopFeedChannelId(troopGuildId));
            intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_PERMISSION, ((ITroopGuildPermissionService) z9().getRuntimeService(ITroopGuildPermissionService.class, "")).getTroopFeedTalkPermission(troopGuildId, false));
            intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_SWITCH, S2.isTroopGuildSwitchOpen());
        }
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopManageForResult(getActivity(), intent, T2.bOwner, 8);
        AppInterface z95 = z9();
        String str4 = T2.troopUin;
        if (T2.bOwner) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        ReportController.o(z95, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, str4, str2, "", "");
        eu.g("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, T2.troopUin, eu.c(T2));
    }

    private final void X9(View view) {
        if (!getActivity().isDestroyed() && !getPartHost().isDetached()) {
            String str = B9().T2().troopUin;
            if (str == null) {
                str = "";
            }
            final String str2 = str;
            QRouteApi api = QRoute.api(ITroopUpgradeUtilsApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUpgradeUtilsApi::class.java)");
            final ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) api;
            N9(z9(), str2, iTroopUpgradeUtilsApi);
            FragmentManager childFragmentManager = getPartHost().getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "partHost.childFragmentManager");
            iTroopUpgradeUtilsApi.showUpgradeGuideDialog(str2, childFragmentManager, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bm
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSettingManageGroupPart.Y9(ITroopUpgradeUtilsApi.this, str2, this, dialogInterface, i3);
                }
            }, null, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(ITroopUpgradeUtilsApi troopUpgradeApi, String troopUin, TroopSettingManageGroupPart this$0, DialogInterface dialog, int i3) {
        Intrinsics.checkNotNullParameter(troopUpgradeApi, "$troopUpgradeApi");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (i3 == -1) {
            troopUpgradeApi.noteUserConfirmUpgrade(troopUin);
            com.tencent.mobileqq.troop.troopsetting.activity.f.b(this$0.z9(), troopUin);
            this$0.B9().b4(new a.s(false));
        }
        dialog.dismiss();
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groups;
    }

    public final void R9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingManageGroupPart$initObserver$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        O9();
        T9();
        S9();
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        this.groups = new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
        R9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.troop.troopsetting.bizconfig.q qVar = this.troopOwnerTaskSettingConfig;
        if (qVar != null) {
            qVar.b0();
        }
        com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.a();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        com.tencent.mobileqq.troop.troopsetting.bizconfig.q qVar = this.troopOwnerTaskSettingConfig;
        if (qVar != null) {
            qVar.c0();
        }
    }
}
