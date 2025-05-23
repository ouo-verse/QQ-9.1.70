package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.fans.api.ITroopFansService;
import com.tencent.mobileqq.troop.fans.data.a;
import com.tencent.mobileqq.troop.troopmedal.TroopMedalUpdateEventReceiver;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtMedalData;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\u001a\u0010'\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016J\"\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u00103\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u00104\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u000101H\u0016R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020,058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010?R$\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR$\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010J\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingGroupInfoPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "Z9", "Landroid/content/Context;", "viewContext", "aa", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "sa", "pa", "ea", "ga", "X9", LocaleUtils.L_JAPANESE, "", "idolName", "", "rank", "ma", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", DownloadInfo.spKey_Config, "oa", "ha", "da", "V9", "", "count", "ra", "", "bForce", "ia", "ca", "la", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "U9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "e", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "troopInfoProfileConfig", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "f", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "headView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "troopNameView", "i", "subTitleView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/x;", "associationTroopConfig", BdhLogUtil.LogTag.Tag_Conn, "starConfig", "D", "Z", "mHadOpenTroopAssociation", "Lcom/tencent/mobileqq/troop/troopmedal/TroopMedalUpdateEventReceiver;", "E", "Lcom/tencent/mobileqq/troop/troopmedal/TroopMedalUpdateEventReceiver;", "medalUpdateReceiver", UserInfo.SEX_FEMALE, "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "<init>", "()V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingGroupInfoPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> starConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mHadOpenTroopAssociation;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TroopMedalUpdateEventReceiver medalUpdateReceiver;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Group[] groups;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> troopInfoProfileConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView headView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView troopNameView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView subTitleView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> associationTroopConfig;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingGroupInfoPart$a;", "", "", "RED_POINT_KEY_TROOP_ASSOCIATION", "Ljava/lang/String;", "RED_POINT_KEY_TROOP_IDOL_RANK", "TAG", "", "TROOP_STAR_RANK_MAX_NUM", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingGroupInfoPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingGroupInfoPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.medalUpdateReceiver = new TroopMedalUpdateEventReceiver();
            this.groups = new Group[0];
        }
    }

    private final void U9(int resultCode, Intent data) {
        boolean z16;
        if (resultCode == -1 && data != null) {
            if (data.hasExtra("bundle_key_new_troop_name")) {
                B9().d4(data.getStringExtra("bundle_key_new_troop_name"));
                B9().m4();
            }
            if (data.hasExtra("bundle_key_new_search_way")) {
                String stringExtra = data.getStringExtra("bundle_key_new_search_way");
                if (stringExtra != null && stringExtra.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && B9().S2().getTroopUin() != null) {
                    TroopSearchWay valueOf = TroopSearchWay.valueOf(stringExtra);
                    com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b P2 = B9().P2();
                    if (P2 != null) {
                        String troopUin = B9().S2().getTroopUin();
                        Intrinsics.checkNotNullExpressionValue(troopUin, "viewModel.troopInfo.troopUin");
                        P2.c(troopUin, valueOf);
                    }
                }
            }
        }
    }

    private final void V9() {
        TroopInfoData T2 = B9().T2();
        if (((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopAssociations(T2.troopUin, T2.troopMemberMaxNum, T2.dwGroupClassExt)) {
            IRuntimeService runtimeService = z9().getRuntimeService(IBizTroopInfoService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IB\u2026va, ProcessConstant.MAIN)");
            int associatedTroopCount = ((IBizTroopInfoService) runtimeService).getAssociatedTroopCount(T2.troopUin);
            boolean isEmptyRedPointSP = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION");
            String string = getContext().getString(R.string.f2057956k);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026_troop_association_title)");
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, isEmptyRedPointSP, 2, null));
            this.associationTroopConfig = xVar;
            xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopSettingGroupInfoPart.W9(TroopSettingGroupInfoPart.this, view);
                }
            });
            ra(associatedTroopCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(TroopSettingGroupInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ca();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X9() {
        boolean z16;
        TroopInfoData T2 = B9().T2();
        TroopInfo S2 = B9().S2();
        if (((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).isGroupEntranceSwitchOn() && T2.isFansTroop()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String string = getContext().getString(R.string.f2068759h);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026tring.qq_troop_star_rank)");
            x.b.d dVar = new x.b.d(string);
            String string2 = getContext().getString(R.string.rcv);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026.qqstr_qqtroopi_72401633)");
            this.starConfig = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.g(string2, false, false, 6, null));
            if (S2.getFansTroopStarId() == 0) {
                com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.starConfig;
                if (xVar != null) {
                    oa(xVar);
                    xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bd
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TroopSettingGroupInfoPart.Y9(TroopSettingGroupInfoPart.this, view);
                        }
                    });
                }
            } else {
                com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.starConfig;
                if (xVar2 != null) {
                    E9(xVar2, false);
                }
                ja();
            }
            ReportController.o(z9(), "dc00898", "", "", "0X800B595", "0X800B595", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(TroopSettingGroupInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ha();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Z9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingGroupInfoPart$initObserver$1(this, null), 3, null);
        this.medalUpdateReceiver.a(new Function2<String, GroupExtMedalData, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingGroupInfoPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingGroupInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupExtMedalData groupExtMedalData) {
                invoke2(str, groupExtMedalData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopUin, @Nullable GroupExtMedalData groupExtMedalData) {
                TextView textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) groupExtMedalData);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                if (!Intrinsics.areEqual(troopUin, TroopSettingGroupInfoPart.this.B9().S2().getTroopUin()) || groupExtMedalData == null) {
                    return;
                }
                textView = TroopSettingGroupInfoPart.this.troopNameView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopNameView");
                    textView = null;
                }
                com.tencent.mobileqq.troop.troopmedal.a aVar = com.tencent.mobileqq.troop.troopmedal.a.f300588a;
                Context context = TroopSettingGroupInfoPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                textView.setTextColor(aVar.a(context, groupExtMedalData));
            }
        });
    }

    private final void aa(Context viewContext) {
        String troopShareDescDefaultWording;
        TextView textView = null;
        View troopProfileCardView = View.inflate(viewContext, R.layout.cc_, null);
        Intrinsics.checkNotNullExpressionValue(troopProfileCardView, "troopProfileCardView");
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(troopProfileCardView);
        this.troopInfoProfileConfig = bVar;
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingGroupInfoPart.ba(TroopSettingGroupInfoPart.this, view);
            }
        });
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, (TextView) troopProfileCardView.findViewById(R.id.i_f));
        View findViewById = troopProfileCardView.findViewById(R.id.f164472yw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "troopProfileCardView.findViewById(R.id.arrow)");
        ((ImageView) findViewById).setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
        View findViewById2 = troopProfileCardView.findViewById(R.id.head);
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById2;
        qQProAvatarView.x(4, B9().T2().troopUin, null);
        if (SimpleUIUtil.getSimpleUISwitch()) {
            qQProAvatarView.setBackground(null);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById2, "troopProfileCardView.fin\u2026l\n            }\n        }");
        this.headView = qQProAvatarView;
        View findViewById3 = troopProfileCardView.findViewById(R.id.k0i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "troopProfileCardView.findViewById(R.id.troop_name)");
        this.troopNameView = (TextView) findViewById3;
        B9().m4();
        if (!TextUtils.isEmpty(B9().T2().mRichFingerMemo)) {
            troopShareDescDefaultWording = B9().T2().mRichFingerMemo;
            Intrinsics.checkNotNullExpressionValue(troopShareDescDefaultWording, "{\n            viewModel.\u2026mRichFingerMemo\n        }");
        } else {
            troopShareDescDefaultWording = ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).getTroopShareDescDefaultWording();
            Intrinsics.checkNotNullExpressionValue(troopShareDescDefaultWording, "{\n            QRoute.api\u2026cDefaultWording\n        }");
        }
        View findViewById4 = troopProfileCardView.findViewById(R.id.j5r);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "troopProfileCardView.findViewById(R.id.subTitle)");
        TextView textView2 = (TextView) findViewById4;
        this.subTitleView = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
            textView2 = null;
        }
        textView2.setText(new QQText(troopShareDescDefaultWording, 11, 16), TextView.BufferType.SPANNABLE);
        if (!B9().T2().hasSetNewTroopHead) {
            TextView textView3 = this.subTitleView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
            } else {
                textView = textView3;
            }
            textView.setVisibility(8);
        }
        pa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(TroopSettingGroupInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ca() {
        this.mHadOpenTroopAssociation = true;
        TroopInfoData T2 = B9().T2();
        if (!TextUtils.isEmpty(T2.troopUin)) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopAssociationWebPage(getActivity(), T2.troopUin);
        }
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.associationTroopConfig;
        if (xVar != null) {
            xVar.O().g(false);
            D9(xVar);
        }
        ReportController.o(z9(), "dc00898", "", T2.troopUin, "0X800B4AE", "0X800B4AE", 0, 0, String.valueOf(T2.dwGroupClassExt), "", "", "");
    }

    private final void da() {
        TroopInfoData T2 = B9().T2();
        if (!TextUtils.isEmpty(T2.troopUin)) {
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                QQToast makeText = QQToast.makeText(getActivity(), getContext().getString(R.string.f2068459e), 0);
                Activity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                makeText.show(((QBaseActivity) activity).getTitleBarHeight());
                if (QLog.isColorLevel()) {
                    QLog.d("TroopInfoGroupPart", 2, "onclick:StudyMode Forbidden context = ", getActivity());
                    return;
                }
                return;
            }
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).startFansTroopIdolPage(getActivity(), T2.troopUin, B9().S2().getFansTroopStarId(), 21);
            ReportController.o(z9(), "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoGroupPart", 2, "onclick: troopUin = ", T2.troopUin);
        }
    }

    private final void ea() {
        int i3;
        TroopSettingViewModel B9 = B9();
        if (B9.T2().troopUin == null && B9.S2().getTroopUin() != null) {
            B9.T2().troopUin = B9.S2().getTroopUin();
        }
        Bundle troopProfileExtra = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getTroopProfileExtra(B9().T2().troopUin, 0);
        troopProfileExtra.putBoolean("troop_info_from_troopsetting", true);
        troopProfileExtra.putInt("exposureSource", 1);
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(getActivity(), troopProfileExtra, 2);
        AppInterface z95 = z9();
        if (!B9().T2().hasSetNewTroopHead) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(z95, "dc00898", "", "", "0X800A524", "0X800A524", i3, 0, "", "", "", "");
    }

    private final void ga() {
        int i3;
        TroopInfoData T2 = B9().T2();
        int i16 = T2.nActiveMemberNum;
        int i17 = T2.wMemberNum;
        if (i16 > i17) {
            T2.nActiveMemberNum = i17;
        }
        if ((T2.dwGroupFlagExt & VasBusiness.CHAT_FONT_SWITCH) != VasBusiness.CHAT_FONT_SWITCH) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        Intent intent = new Intent();
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, true);
        intent.putExtra("isScreenOrientationPortrait", true);
        intent.putExtra("uin", z9().getCurrentAccountUin());
        intent.putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + T2.troopUin + "&role=1&group_level=" + T2.nTroopGrade + "&group_mem_num=" + T2.wMemberNum + "&group_active_num=" + T2.nActiveMemberNum + "&show_level=" + i3);
        QRoute.createNavigator(getActivity(), IPublicAccountBrowser.ROUTE_NAME).withAll(intent.getExtras()).request();
        ReportController.o(z9(), "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, T2.troopUin, "", "", "");
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).bnrReport(z9(), 72);
    }

    private final void ha() {
        TroopInfoData T2 = B9().T2();
        if (!TextUtils.isEmpty(T2.troopUin)) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setRedPointSP("RED_POINT_KEY_TROOP_IDOL_RANK" + T2.troopUin);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.starConfig;
            if (xVar != null) {
                xVar.O().g(false);
                D9(xVar);
            }
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                QQToast makeText = QQToast.makeText(getActivity(), getContext().getString(R.string.f2068459e), 0);
                Activity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                makeText.show(((QBaseActivity) activity).getTitleBarHeight());
                if (QLog.isColorLevel()) {
                    QLog.d("TroopInfoGroupPart", 2, "onclick:StudyMode Forbidden context = ", getActivity());
                    return;
                }
                return;
            }
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).startFansTroopIdolRank(getActivity(), T2.troopUin, 21);
            ReportController.o(z9(), "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoGroupPart", 2, "onclick: troopUin = ", T2.troopUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia(boolean bForce) {
        com.tencent.mobileqq.troop.association.api.a aVar;
        TroopInfoData T2 = B9().T2();
        if (T2.troopUin == null || !((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopAssociations(T2.troopUin, T2.troopMemberMaxNum, T2.dwGroupClassExt)) {
            return;
        }
        if (!T2.hasTroopAssociation() && !bForce) {
            ra(0);
            return;
        }
        Object businessHandler = z9().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAssociationHandlerName());
        if (businessHandler instanceof com.tencent.mobileqq.troop.association.api.a) {
            aVar = (com.tencent.mobileqq.troop.association.api.a) businessHandler;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.z0(T2.troopUin, 3, "");
        }
    }

    private final void ja() {
        IRuntimeService runtimeService = z9().getRuntimeService(ITroopFansService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        a.C8682a troopIdolInfoDate = ((ITroopFansService) runtimeService).getTroopIdolInfoDate(B9().T2().troopUin);
        if (troopIdolInfoDate != null) {
            String idolName = troopIdolInfoDate.f295405b;
            long j3 = troopIdolInfoDate.f295408e;
            Intrinsics.checkNotNullExpressionValue(idolName, "idolName");
            ma(idolName, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar;
        if (!((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).isGroupEntranceSwitchOn()) {
            return;
        }
        TroopInfo S2 = B9().S2();
        if ((!S2.isFansTroop() || S2.getFansTroopStarId() == 0) && (xVar = this.starConfig) != null) {
            oa(xVar);
        }
    }

    private final void ma(String idolName, long rank) {
        boolean z16;
        com.tencent.mobileqq.widget.listitem.a<?> aVar = this.starConfig;
        if (aVar != null) {
            E9(aVar, true);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.starConfig;
        if (xVar != null) {
            xVar.O().g(false);
            D9(xVar);
        }
        if (TextUtils.isEmpty(idolName)) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.starConfig;
            if (xVar2 != null) {
                oa(xVar2);
                return;
            }
            return;
        }
        String string = getContext().getString(R.string.f2068659g);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026q_troop_star_not_on_rank)");
        if (1 <= rank && rank < 51) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = getContext().getString(R.string.f2065258j);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026roop_rank_number_of_star)");
            string = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(rank)}, 1));
            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.starConfig;
        if (xVar3 != null) {
            xVar3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopSettingGroupInfoPart.na(TroopSettingGroupInfoPart.this, view);
                }
            });
            xVar3.K().b(idolName);
            xVar3.O().h(string);
            D9(xVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(TroopSettingGroupInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.da();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void oa(com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> config) {
        boolean isEmptyRedPointSP = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isEmptyRedPointSP("RED_POINT_KEY_TROOP_IDOL_RANK" + B9().T2().troopUin);
        x.c.g O = config.O();
        String string = getContext().getString(R.string.f2068559f);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026.qq_troop_star_bind_tips)");
        O.h(string);
        O.g(isEmptyRedPointSP);
        D9(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa() {
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = this.troopInfoProfileConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoProfileConfig");
            bVar = null;
        }
        TextView textView = (TextView) bVar.K().findViewById(R.id.jzl);
        int i3 = B9().T2().nTroopGrade;
        if (!B9().T2().isShowActivityGrade()) {
            i3 = 0;
        }
        if (i3 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.bxg);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026.string.info_troop_level)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            textView.setContentDescription(format);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (B9().G2()) {
            textView.setVisibility(8);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.be
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingGroupInfoPart.qa(TroopSettingGroupInfoPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(TroopSettingGroupInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ga();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra(int count) {
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("count = %s", Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.i("TroopInfoGroupPart", 2, format);
        }
        TroopInfoData T2 = B9().T2();
        if (count > 0) {
            ReportController.o(z9(), "dc00898", "", T2.troopUin, "0X800B4AD", "0X800B4AD", 0, 0, String.valueOf(T2.dwGroupClassExt), "", "", "");
            String str = getContext().getString(R.string.f2057756i) + count + getContext().getString(R.string.f2057856j);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.associationTroopConfig;
            if (xVar != null) {
                xVar.O().h(str);
                E9(xVar, false);
                D9(xVar);
                return;
            }
            return;
        }
        com.tencent.mobileqq.widget.listitem.a<?> aVar = this.associationTroopConfig;
        if (aVar != null) {
            aVar.p(false);
            D9(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(TroopInfo troopInfo) {
        String str;
        GroupExtMedalData groupExtMedalData;
        String B2 = B9().B2();
        String qqStr = HardCodeUtil.qqStr(R.string.khr);
        TextView textView = null;
        if (troopInfo != null) {
            str = troopInfo.getTroopUin();
        } else {
            str = null;
        }
        if (str != null) {
            qqStr = com.tencent.mobileqq.troop.troopsetting.modules.base.b.c(troopInfo, B2);
        } else if (B9().T2().troopUin != null) {
            qqStr = com.tencent.mobileqq.troop.troopsetting.modules.base.a.b(B9().T2(), B2);
        }
        TextView textView2 = this.troopNameView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopNameView");
            textView2 = null;
        }
        textView2.setText(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(qqStr, 16));
        TextView textView3 = this.troopNameView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopNameView");
            textView3 = null;
        }
        com.tencent.mobileqq.troop.troopmedal.a aVar = com.tencent.mobileqq.troop.troopmedal.a.f300588a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GroupExt groupExt = B9().S2().groupExt;
        if (groupExt != null) {
            groupExtMedalData = groupExt.groupExtMedalData;
        } else {
            groupExtMedalData = null;
        }
        textView3.setTextColor(aVar.a(context, groupExtMedalData));
        if (AppSetting.f99565y) {
            if (com.tencent.mobileqq.util.ab.a()) {
                com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = this.troopInfoProfileConfig;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopInfoProfileConfig");
                    bVar = null;
                }
                AccessibilityUtil.s(bVar.K(), qqStr + "\uff0c" + HardCodeUtil.qqStr(R.string.kgt));
            }
            TextView textView4 = this.troopNameView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopNameView");
            } else {
                textView = textView4;
            }
            textView.setContentDescription(HardCodeUtil.qqStr(R.string.kgk) + qqStr);
        }
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

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 21) {
            if (requestCode == 22) {
                U9(resultCode, data);
                return;
            }
            return;
        }
        la();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        aa(context);
        X9();
        V9();
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = this.troopInfoProfileConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoProfileConfig");
            bVar = null;
        }
        arrayList.add(bVar);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.starConfig;
        if (xVar != null) {
            arrayList.add(xVar);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.associationTroopConfig;
        if (xVar2 != null) {
            arrayList.add(xVar2);
        }
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        this.groups = new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
        Z9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            this.medalUpdateReceiver.b();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        if (this.mHadOpenTroopAssociation) {
            ia(true);
            this.mHadOpenTroopAssociation = false;
        }
    }
}
