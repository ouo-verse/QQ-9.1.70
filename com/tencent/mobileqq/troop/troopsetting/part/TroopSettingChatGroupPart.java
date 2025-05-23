package com.tencent.mobileqq.troop.troopsetting.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.troop.ITroopNickManager;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 j2\u00020\u0001:\u0001kB\u0007\u00a2\u0006\u0004\bh\u0010iJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0003J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u001a\u0010*\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J\b\u0010+\u001a\u00020\u0004H\u0002J\u001a\u0010,\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\u0012\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u00101\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0002H\u0002J\u0015\u00104\u001a\b\u0012\u0004\u0012\u00020302H\u0016\u00a2\u0006\u0004\b4\u00105J\u0012\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0016J\"\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010:\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u000203028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R.\u0010C\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0>j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?`@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\"\u0010I\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010PR\"\u0010W\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010HR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR#\u0010g\u001a\n b*\u0004\u0018\u00010\\0\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingChatGroupPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "title", "", "Na", "na", "troopRemark", "Ra", LocaleUtils.L_JAPANESE, "", "isHomeworkTroop", "Pa", "va", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Qa", "xa", "Fa", "Aa", "ha", "Sa", "showIcon", "Ua", "isShowUin", "showUinLockIcon", "Ta", "Landroid/view/View;", "target", "Ca", "wa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "ia", "za", "Ia", "Ga", "ea", "", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "la", "Ba", "ma", "Ka", "troopName", "Ja", "uinString", "Oa", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", "onActivityResult", "onPartDestroy", "e", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/x;", "groupNameConfig", "i", "Landroid/view/View;", "groupNameView", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "Lcom/tencent/mobileqq/widget/FormItemRelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "troopCodeQrEntryConfig2", BdhLogUtil.LogTag.Tag_Conn, "troopNoticeConfig", "D", "myTroopMemberCardConfig", "E", "troopRemarkConfig", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "mTroopInfoData", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "G", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mNoticeDialog", "H", "Z", "kotlin.jvm.PlatformType", "I", "Lkotlin/Lazy;", "ga", "()Lcom/tencent/mobileqq/utils/QQCustomDialog;", "modifyTroopNameDialog", "<init>", "()V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingChatGroupPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean K;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> troopNoticeConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> myTroopMemberCardConfig;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> troopRemarkConfig;

    /* renamed from: F, reason: from kotlin metadata */
    private TroopInfoData mTroopInfoData;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog mNoticeDialog;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isHomeworkTroop;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy modifyTroopNameDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group[] groups;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> groupNameConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View groupNameView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> troopCodeQrEntryConfig2;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingChatGroupPart$a;", "", "", "TAG", "Ljava/lang/String;", "", "vasTempNickSwitch", "Z", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatGroupPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60669);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            K = VasNormalToggle.VAS_TROOP_NICK_SETTING.isEnable(true);
        }
    }

    public TroopSettingChatGroupPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.groups = new Group[0];
        this.configList = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new TroopSettingChatGroupPart$modifyTroopNameDialog$2(this));
        this.modifyTroopNameDialog = lazy;
    }

    private final void Aa() {
        String str;
        ha();
        TroopInfoData T2 = B9().T2();
        AppInterface z95 = z9();
        String str2 = T2.troopUin;
        if (T2.bOwner) {
            str = "0";
        } else if (T2.bAdmin) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(z95, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, str2, "0", str, "");
    }

    private final void Ba() {
        TroopInfo S2 = B9().S2();
        IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
        Activity activity = getActivity();
        TroopInfoData troopInfoData = this.mTroopInfoData;
        TroopInfoData troopInfoData2 = null;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData = null;
        }
        String str = troopInfoData.troopUin;
        TroopInfoData troopInfoData3 = this.mTroopInfoData;
        if (troopInfoData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
        } else {
            troopInfoData2 = troopInfoData3;
        }
        iChatSettingForTroopApi.startTroopRemarkActivity(activity, str, troopInfoData2.troopCode, com.tencent.mobileqq.troop.troopsetting.modules.base.b.e(S2, B9().B2()), S2.troopRemark, 20);
    }

    private final void Ca(boolean isShowUin, boolean showUinLockIcon, View target) {
        if (isShowUin && showUinLockIcon) {
            TextView textView = (TextView) target.findViewById(R.id.i_f);
            wa();
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.an
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopSettingChatGroupPart.Da(TroopSettingChatGroupPart.this, view);
                }
            });
            textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ad
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean Ea;
                    Ea = TroopSettingChatGroupPart.Ea(TroopSettingChatGroupPart.this, view);
                    return Ea;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(TroopSettingChatGroupPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(this$0.B9().S2()) == TroopSearchWay.PRIVATE) {
            TroopInfoData troopInfoData = this$0.mTroopInfoData;
            if (troopInfoData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                troopInfoData = null;
            }
            if (troopInfoData.isOwnerOrAdim()) {
                Activity activity = this$0.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                this$0.ia(activity);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ea(TroopSettingChatGroupPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(this$0.B9().S2()) == TroopSearchWay.PRIVATE) {
            TroopInfoData troopInfoData = this$0.mTroopInfoData;
            if (troopInfoData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                troopInfoData = null;
            }
            if (troopInfoData.isOwnerOrAdim()) {
                Activity activity = this$0.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                this$0.ia(activity);
                return true;
            }
            return true;
        }
        return true;
    }

    private final void Fa() {
        if (!ga().isShowing()) {
            ga().show();
        }
    }

    private final void Ga() {
        ea();
        QQCustomDialog title = DialogUtil.createCustomDialog(getActivity(), 230).setTitle(getContext().getResources().getString(R.string.esb));
        this.mNoticeDialog = title;
        if (title != null) {
            title.setPositiveButton(getContext().getResources().getString(R.string.esa), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.am
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSettingChatGroupPart.Ha(TroopSettingChatGroupPart.this, dialogInterface, i3);
                }
            });
        }
        try {
            QQCustomDialog qQCustomDialog = this.mNoticeDialog;
            if (qQCustomDialog != null) {
                qQCustomDialog.show();
            }
        } catch (Exception e16) {
            QLog.e("TroopSettingChatGroupPart", 1, "[showNoticeDialog] e = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(TroopSettingChatGroupPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea();
    }

    private final void Ia() {
        String str;
        TroopInfoData troopInfoData = this.mTroopInfoData;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData = null;
        }
        if (!troopInfoData.isOwnerOrAdim() && TextUtils.isEmpty(B9().J2())) {
            Ga();
            return;
        }
        if (B9().C2() == null) {
            B9().H3(TroopUrlConfProcessor.a());
        }
        com.tencent.mobileqq.troop.troopurl.config.a C2 = B9().C2();
        if (C2 != null) {
            str = C2.f301841a;
        } else {
            str = null;
        }
        Navigator createNavigator = QRoute.createNavigator(getActivity(), RouterConstants.UI_ROUTE_BROWSER);
        ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
        TroopInfoData troopInfoData2 = this.mTroopInfoData;
        if (troopInfoData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData2 = null;
        }
        Navigator withLong = createNavigator.withString("url", iTroopUtilsApi.replaceSpecialTag(str, 0L, 0, troopInfoData2, z9(), true)).withString("webStyle", "noBottomBar").withLong("startOpenPageTime", System.currentTimeMillis());
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Navigator.withRequestCode$default(withLong, activity, 17, (Bundle) null, 4, (Object) null).request();
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.z(B9().T2());
    }

    private final void Ja(String troopName) {
        String str;
        if (troopName != null && AppSetting.f99565y) {
            View view = this.groupNameView;
            QUISecNavBar qUISecNavBar = null;
            if (view != null) {
                String string = getContext().getString(R.string.f171730kh1);
                TroopInfoData troopInfoData = this.mTroopInfoData;
                if (troopInfoData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                    troopInfoData = null;
                }
                if (troopInfoData.isOwnerOrAdim()) {
                    str = getContext().getString(R.string.kgp);
                } else {
                    str = "";
                }
                view.setContentDescription(string + troopName + str);
            }
            View partRootView = getPartRootView();
            if (partRootView != null) {
                qUISecNavBar = (QUISecNavBar) partRootView.findViewById(R.id.jo9);
            }
            if (qUISecNavBar != null) {
                qUISecNavBar.setBaseViewDescription(BaseAction.ACTION_CENTER_TEXT, troopName + " " + getContext().getString(R.string.im5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka() {
        IRuntimeService runtimeService = z9().getRuntimeService(ITroopMemberInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        final TroopInfoData T2 = B9().T2();
        ((ITroopMemberInfoService) runtimeService).getTroopMemberInfoAsync(T2.troopUin, z9().getCurrentAccountUin(), "TroopSettingChatGroupPart", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ac
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopSettingChatGroupPart.La(TroopInfoData.this, this, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(TroopInfoData mTroopInfoData, final TroopSettingChatGroupPart this$0, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (troopMemberInfo != null) {
            String str = troopMemberInfo.troopColorNick;
            mTroopInfoData.troopColorNick = str;
            int i3 = troopMemberInfo.troopColorNickId;
            mTroopInfoData.troopColorNickId = i3;
            String str2 = troopMemberInfo.troopnick;
            mTroopInfoData.troopCard = str2;
            QLog.i("TroopSettingChatGroupPart", 1, "resultForTroopMemberList nick=" + str + ", nickId=" + i3 + ", name=" + str2);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ae
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingChatGroupPart.Ma(TroopSettingChatGroupPart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(TroopSettingChatGroupPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.C9()) {
            return;
        }
        this$0.ja();
    }

    private final void Na(String title) {
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar = this.troopCodeQrEntryConfig2;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopCodeQrEntryConfig2");
            bVar = null;
        }
        View findViewById = bVar.K().findViewById(R.id.title);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(title);
    }

    private final void Oa(boolean showIcon, String uinString) {
        boolean z16;
        if (uinString != null && uinString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && AppSetting.f99565y) {
            com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar = this.troopCodeQrEntryConfig2;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopCodeQrEntryConfig2");
                bVar = null;
            }
            View findViewById = bVar.K().findViewById(R.id.i_f);
            Intrinsics.checkNotNullExpressionValue(findViewById, "troopCodeQrEntryConfig2.\u2026dViewById(R.id.rightInfo)");
            TextView textView = (TextView) findViewById;
            StringBuilder sb5 = new StringBuilder("\u7fa4\u53f7" + uinString);
            if (showIcon) {
                sb5.append(" ");
                sb5.append(getContext().getString(R.string.f235647c8));
            }
            textView.setContentDescription(sb5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pa(boolean isHomeworkTroop) {
        QLog.i("TroopSettingChatGroupPart", 1, "updateTroopMemberCardTitle: " + isHomeworkTroop);
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar = this.myTroopMemberCardConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myTroopMemberCardConfig");
            bVar = null;
        }
        TextView textView = (TextView) bVar.K().findViewById(R.id.title);
        if (isHomeworkTroop) {
            textView.setText(getContext().getResources().getString(R.string.f169752j7));
        } else {
            textView.setText(getContext().getResources().getString(R.string.cfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa(TroopInfo troopInfo) {
        String B2 = B9().B2();
        String qqStr = HardCodeUtil.qqStr(R.string.kh8);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = null;
        if (B9().S2().getTroopUin() != null) {
            if (troopInfo != null) {
                qqStr = com.tencent.mobileqq.troop.troopsetting.modules.base.b.b(troopInfo, B2);
            } else {
                qqStr = null;
            }
        } else if (B9().T2().troopUin != null) {
            TroopInfoData troopInfoData = this.mTroopInfoData;
            if (troopInfoData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                troopInfoData = null;
            }
            qqStr = com.tencent.mobileqq.troop.troopsetting.modules.base.a.a(troopInfoData, B2);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.groupNameConfig;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupNameConfig");
            xVar2 = null;
        }
        x.c.g O = xVar2.O();
        SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(qqStr, 16);
        Intrinsics.checkNotNullExpressionValue(spannableStringFromColorNickText, "api(IChatSettingForTroop\u2026e, QQText.SMALL_EMO_SIZE)");
        O.h(spannableStringFromColorNickText);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.groupNameConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupNameConfig");
        } else {
            xVar = xVar3;
        }
        D9(xVar);
        Ja(qqStr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ra(String troopRemark) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.troopRemarkConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRemarkConfig");
            xVar = null;
        }
        x.c.g O = xVar.O();
        if (TextUtils.isEmpty(troopRemark)) {
            String string = getContext().getResources().getString(R.string.f2065858p);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026.qq_troop_remark_not_set)");
            O.h(string);
        } else {
            if (troopRemark == null) {
                troopRemark = "";
            }
            O.h(troopRemark);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.troopRemarkConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRemarkConfig");
        } else {
            xVar2 = xVar3;
        }
        D9(xVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa() {
        boolean z16;
        if (com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(B9().S2()) == TroopSearchWay.PRIVATE) {
            z16 = true;
        } else {
            z16 = false;
        }
        Ta(!B9().G2(), z16);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void Ta(boolean isShowUin, boolean showUinLockIcon) {
        int i3;
        boolean z16;
        TroopInfo S2 = B9().S2();
        String str = B9().T2().troopUin;
        if (!isShowUin || str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = " ";
        }
        if (isShowUin) {
            i3 = R.string.fvd;
        } else {
            i3 = R.string.fvf;
        }
        String string = getContext().getResources().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(titleRes)");
        Na(string);
        SpannableString spannableString = new SpannableString(str);
        boolean z17 = true;
        if (isShowUin && showUinLockIcon && getContext() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Ua(z16);
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar = this.troopCodeQrEntryConfig2;
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopCodeQrEntryConfig2");
            bVar = null;
        }
        Ca(isShowUin, showUinLockIcon, bVar.K());
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar3 = this.troopCodeQrEntryConfig2;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopCodeQrEntryConfig2");
            bVar3 = null;
        }
        View findViewById = bVar3.K().findViewById(R.id.d_6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "troopCodeQrEntryConfig2.\u2026eqq.troop.api.R.id.icon2)");
        ImageView imageView = (ImageView) findViewById;
        imageView.setBackgroundResource(R.drawable.qui_qrcode_vas_icon_secondary);
        com.tencent.mobileqq.widget.listitem.ab.f(imageView, ViewUtils.dip2px(18.0f), ViewUtils.dip2px(18.0f));
        imageView.setVisibility(0);
        QLog.e("vip_pretty.TroopSettingChatGroupPart", 1, "show the pretty troop icon :" + S2.groupFlagExt4);
        if ((!S2.checkFlagExt4(1) || S2.checkFreezeReason(2)) && !S2.checkFlagExt4(2)) {
            z17 = false;
        }
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar4 = this.troopCodeQrEntryConfig2;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopCodeQrEntryConfig2");
            bVar4 = null;
        }
        View findViewById2 = bVar4.K().findViewById(R.id.d_5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "troopCodeQrEntryConfig2.\u2026eqq.troop.api.R.id.icon1)");
        ImageView imageView2 = (ImageView) findViewById2;
        if (z17) {
            imageView2.setVisibility(0);
            imageView2.setBackgroundResource(R.drawable.hvw);
            com.tencent.mobileqq.widget.listitem.ab.f(imageView2, ViewUtils.dip2px(40.0f), ViewUtils.dip2px(15.0f));
        } else {
            imageView2.setVisibility(8);
        }
        IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
        AppInterface z95 = z9();
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar5 = this.troopCodeQrEntryConfig2;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopCodeQrEntryConfig2");
        } else {
            bVar2 = bVar5;
        }
        iChatSettingForTroopApi.updateEntryItem(z95, bVar2.K(), spannableString, null, null, true, str, HardCodeUtil.qqStr(R.string.aep));
        Oa(z16, str);
    }

    private final void Ua(boolean showIcon) {
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar = this.troopCodeQrEntryConfig2;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopCodeQrEntryConfig2");
            bVar = null;
        }
        View findViewById = bVar.K().findViewById(R.id.i_f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "troopCodeQrEntryConfig2.\u2026dViewById(R.id.rightInfo)");
        TextView textView = (TextView) findViewById;
        if (showIcon) {
            textView.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_4);
            int dip2px = ViewUtils.dip2px(16.0f);
            Drawable drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.n9t, null);
            if (drawable != null) {
                drawable.setTint(ContextCompat.getColor(getContext(), R.color.qui_common_text_secondary));
                drawable.setBounds(0, 0, dip2px, dip2px);
            } else {
                drawable = null;
            }
            textView.setCompoundDrawables(drawable, null, null, null);
            int dip2px2 = ViewUtils.dip2px(2.0f);
            int dip2px3 = ViewUtils.dip2px(4.0f);
            textView.setPadding(dip2px3, dip2px2, dip2px3, dip2px2);
            textView.setTextSize(12.0f);
            return;
        }
        textView.setBackgroundColor(0);
        textView.setCompoundDrawables(null, null, null, null);
        textView.setPadding(0, 0, 0, 0);
        textView.setTextSize(14.0f);
    }

    private final void ea() {
        QQCustomDialog qQCustomDialog = this.mNoticeDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            try {
                qQCustomDialog.dismiss();
            } catch (Exception e16) {
                QLog.e("TroopSettingChatGroupPart", 1, "[dismissNoticeDialog] exception = " + e16);
            }
        }
        this.mNoticeDialog = null;
    }

    private final QQCustomDialog ga() {
        return (QQCustomDialog) this.modifyTroopNameDialog.getValue();
    }

    private final void ha() {
        try {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).newTroopShareUtility(getActivity(), B9().T2());
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).startTroop2DCode();
        } catch (Exception e16) {
            QLog.d("TroopSettingChatGroupPart", 1, "gotoTroopQRCodeActivity NullPointerException ", e16);
        }
    }

    private final void ia(final Activity activity) {
        final TroopInfo S2 = B9().S2();
        final TroopSearchWay d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(S2);
        TroopInfoData troopInfoData = this.mTroopInfoData;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData = null;
        }
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.b.e(activity, d16, com.tencent.mobileqq.troop.troopsetting.activity.c.f(troopInfoData), new Function1<TroopSearchWay, Unit>(S2, activity, this) { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatGroupPart$handleShowSearchWayActionSheet$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity $activity;
            final /* synthetic */ TroopInfo $mTroopInfo;
            final /* synthetic */ TroopSettingChatGroupPart this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$mTroopInfo = S2;
                this.$activity = activity;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopSearchWay.this, S2, activity, this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopSearchWay troopSearchWay) {
                invoke2(troopSearchWay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopSearchWay newOption) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) newOption);
                    return;
                }
                Intrinsics.checkNotNullParameter(newOption, "newOption");
                if (TroopSearchWay.this == newOption) {
                    return;
                }
                TroopInfo troopInfo = this.$mTroopInfo;
                if (troopInfo.hasSetNewTroopHead && troopInfo.hasSetNewTroopName) {
                    com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b P2 = this.this$0.B9().P2();
                    if (P2 != null) {
                        String str = this.$mTroopInfo.troopuin;
                        Intrinsics.checkNotNullExpressionValue(str, "mTroopInfo.troopuin");
                        P2.c(str, newOption);
                        return;
                    }
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_new_search_way", newOption.name());
                TroopModifyBaseInfoFragment.Companion companion = TroopModifyBaseInfoFragment.INSTANCE;
                Activity activity2 = this.$activity;
                String troopUin = this.$mTroopInfo.getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin, "mTroopInfo.troopUin");
                companion.a(activity2, 22, troopUin, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0135 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ja() {
        float measureText;
        int i3;
        TroopInfoData troopInfoData;
        TroopInfoData troopInfoData2;
        TroopInfoData troopInfoData3;
        com.tencent.qqnt.aio.nick.c customCloth;
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar = this.myTroopMemberCardConfig;
        TroopInfoData troopInfoData4 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myTroopMemberCardConfig");
            bVar = null;
        }
        TextView textView = (TextView) bVar.K().findViewById(R.id.i_f);
        TroopInfoData troopInfoData5 = this.mTroopInfoData;
        if (troopInfoData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData5 = null;
        }
        if (!TextUtils.isEmpty(troopInfoData5.troopColorNick)) {
            TroopInfoData troopInfoData6 = this.mTroopInfoData;
            if (troopInfoData6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                troopInfoData6 = null;
            }
            textView.setContentDescription(new QQText(troopInfoData6.troopColorNick, 16, 16).toPlainText());
            if (K) {
                INickNameApi iNickNameApi = (INickNameApi) QRoute.api(INickNameApi.class);
                TroopInfoData troopInfoData7 = this.mTroopInfoData;
                if (troopInfoData7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                    troopInfoData7 = null;
                }
                String str = troopInfoData7.troopColorNick;
                Intrinsics.checkNotNullExpressionValue(str, "mTroopInfoData.troopColorNick");
                CharSequence emotionNickName = iNickNameApi.getEmotionNickName(str, 16);
                textView.setText(emotionNickName);
                TroopInfoData troopInfoData8 = this.mTroopInfoData;
                if (troopInfoData8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                    troopInfoData8 = null;
                }
                if (troopInfoData8.troopColorNickId <= 0) {
                    com.tencent.mobileqq.troop.troopsetting.ktx.a aVar = com.tencent.mobileqq.troop.troopsetting.ktx.a.f301140a;
                    Intrinsics.checkNotNullExpressionValue(textView, "textView");
                    aVar.d(textView);
                    return;
                }
                if (emotionNickName instanceof QQText) {
                    QQText qQText = (QQText) emotionNickName;
                    if (qQText.mSpanCount == 0) {
                        i3 = 0;
                    } else {
                        i3 = com.tencent.mobileqq.troop.troopsetting.activity.d.f301060a.g();
                    }
                    TextPaint paint = textView.getPaint();
                    Intrinsics.checkNotNullExpressionValue(paint, "textView.paint");
                    measureText = com.tencent.mobileqq.troop.troopsetting.modules.nickname.a.a(qQText, paint);
                    Rect rect = new Rect();
                    TextPaint paint2 = textView.getPaint();
                    troopInfoData = this.mTroopInfoData;
                    if (troopInfoData == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                        troopInfoData = null;
                    }
                    String str2 = troopInfoData.troopColorNick;
                    troopInfoData2 = this.mTroopInfoData;
                    if (troopInfoData2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                        troopInfoData2 = null;
                    }
                    paint2.getTextBounds(str2, 0, troopInfoData2.troopColorNick.length(), rect);
                    ITroopNickManager iTroopNickManager = (ITroopNickManager) QRoute.api(ITroopNickManager.class);
                    troopInfoData3 = this.mTroopInfoData;
                    if (troopInfoData3 != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                    } else {
                        troopInfoData4 = troopInfoData3;
                    }
                    customCloth = iTroopNickManager.setCustomCloth(troopInfoData4.troopColorNickId, new com.tencent.qqnt.aio.nick.i(measureText, rect), ViewUtils.dip2px(150.0f));
                    if (customCloth != null) {
                        return;
                    }
                    int a16 = customCloth.a();
                    int b16 = customCloth.b();
                    int c16 = customCloth.c();
                    textView.setBackground(customCloth.d());
                    textView.setPadding(c16, 0, c16, 0);
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = a16;
                    layoutParams.height = b16 + i3;
                    textView.setLayoutParams(layoutParams);
                    return;
                }
                TextPaint paint3 = textView.getPaint();
                TroopInfoData troopInfoData9 = this.mTroopInfoData;
                if (troopInfoData9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                    troopInfoData9 = null;
                }
                measureText = paint3.measureText(troopInfoData9.troopColorNick);
            } else {
                TroopInfoData troopInfoData10 = this.mTroopInfoData;
                if (troopInfoData10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                    troopInfoData10 = null;
                }
                textView.setText(troopInfoData10.troopColorNick);
                TroopInfoData troopInfoData11 = this.mTroopInfoData;
                if (troopInfoData11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                    troopInfoData11 = null;
                }
                if (troopInfoData11.troopColorNickId <= 0) {
                    com.tencent.mobileqq.troop.troopsetting.ktx.a aVar2 = com.tencent.mobileqq.troop.troopsetting.ktx.a.f301140a;
                    Intrinsics.checkNotNullExpressionValue(textView, "textView");
                    aVar2.d(textView);
                    return;
                } else {
                    TextPaint paint4 = textView.getPaint();
                    TroopInfoData troopInfoData12 = this.mTroopInfoData;
                    if (troopInfoData12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                        troopInfoData12 = null;
                    }
                    measureText = paint4.measureText(troopInfoData12.troopColorNick);
                }
            }
            i3 = 0;
            Rect rect2 = new Rect();
            TextPaint paint22 = textView.getPaint();
            troopInfoData = this.mTroopInfoData;
            if (troopInfoData == null) {
            }
            String str22 = troopInfoData.troopColorNick;
            troopInfoData2 = this.mTroopInfoData;
            if (troopInfoData2 == null) {
            }
            paint22.getTextBounds(str22, 0, troopInfoData2.troopColorNick.length(), rect2);
            ITroopNickManager iTroopNickManager2 = (ITroopNickManager) QRoute.api(ITroopNickManager.class);
            troopInfoData3 = this.mTroopInfoData;
            if (troopInfoData3 != null) {
            }
            customCloth = iTroopNickManager2.setCustomCloth(troopInfoData4.troopColorNickId, new com.tencent.qqnt.aio.nick.i(measureText, rect2), ViewUtils.dip2px(150.0f));
            if (customCloth != null) {
            }
        } else {
            textView.setText(getContext().getResources().getString(R.string.eqt));
            textView.setContentDescription(getContext().getResources().getString(R.string.eqt));
            com.tencent.mobileqq.troop.troopsetting.ktx.a aVar3 = com.tencent.mobileqq.troop.troopsetting.ktx.a.f301140a;
            Intrinsics.checkNotNullExpressionValue(textView, "textView");
            aVar3.d(textView);
        }
    }

    private final void la(int resultCode, Intent data) {
        boolean z16;
        String str = B9().T2().troopUin;
        String str2 = null;
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar = null;
        long j3 = 0;
        if (resultCode == -1 && data != null) {
            z16 = data.getBooleanExtra("updateFromWeb", false);
            String stringExtra = data.getStringExtra("lastAnnouncement");
            j3 = data.getLongExtra("groupCode", 0L);
            if (z16 && TextUtils.equals(str, String.valueOf(j3))) {
                com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar2 = this.troopNoticeConfig;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopNoticeConfig");
                } else {
                    bVar = bVar2;
                }
                com.tencent.mobileqq.troop.troopsetting.activity.a.k(bVar.K(), stringExtra);
                String str3 = "";
                IRuntimeService runtimeService = z9().getRuntimeService(ITroopInfoService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
                ITroopInfoService iTroopInfoService = (ITroopInfoService) runtimeService;
                if (B9().S2().getTroopUin() == null) {
                    TroopSettingViewModel B9 = B9();
                    TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(str);
                    Intrinsics.checkNotNullExpressionValue(findTroopInfo, "troopInfoService.findTroopInfo(troopUin)");
                    B9.R3(findTroopInfo);
                }
                ITroopExtInfoDBApi iTroopExtInfoDBApi = (ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class);
                if (stringExtra != null) {
                    str3 = stringExtra;
                }
                iTroopExtInfoDBApi.updateAnnouncement(str, str3);
            }
            str2 = stringExtra;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("doOnActivityResult get last memo [%s, %s, %s, %s]", Arrays.copyOf(new Object[]{Boolean.valueOf(z16), str, Long.valueOf(j3), str2}, 4));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.i("TroopSettingChatGroupPart", 2, format);
        }
    }

    private final void ma(int resultCode, Intent data) {
        QBaseActivity qBaseActivity;
        if (resultCode == -1 && data != null) {
            if (!NetworkUtil.isNetworkAvailable(getActivity())) {
                int i3 = 0;
                QQToast makeText = QQToast.makeText(getActivity(), 1, R.string.ci5, 0);
                Activity activity = getActivity();
                if (activity instanceof QBaseActivity) {
                    qBaseActivity = (QBaseActivity) activity;
                } else {
                    qBaseActivity = null;
                }
                if (qBaseActivity != null) {
                    i3 = qBaseActivity.getTitleBarHeight();
                }
                makeText.show(i3);
                return;
            }
            Ra(data.getStringExtra("result"));
        }
    }

    private final void na() {
        String string = getContext().getString(R.string.atv);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.discussion_name)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, false, 6, null));
        this.groupNameConfig = xVar;
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingChatGroupPart.qa(TroopSettingChatGroupPart.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ag
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopSettingChatGroupPart.ra(TroopSettingChatGroupPart.this, view);
            }
        });
        B9().m4();
        this.configList.add(xVar);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(com.tencent.mobileqq.troop.troopsetting.activity.d.d(context));
        this.troopCodeQrEntryConfig2 = bVar;
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ah
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingChatGroupPart.sa(TroopSettingChatGroupPart.this, view);
            }
        });
        bVar.O();
        bVar.L(2, getContext().getString(R.string.fvf), true);
        bVar.J();
        this.configList.add(bVar);
        Sa();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar2 = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(com.tencent.mobileqq.troop.troopsetting.activity.d.c(activity));
        this.troopNoticeConfig = bVar2;
        bVar2.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingChatGroupPart.ta(TroopSettingChatGroupPart.this, view);
            }
        });
        bVar2.O();
        bVar2.L(2, getContext().getResources().getString(R.string.fvl), true);
        this.configList.add(bVar2);
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar3 = this.troopNoticeConfig;
        TroopInfoData troopInfoData = null;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopNoticeConfig");
            bVar3 = null;
        }
        FormItemRelativeLayout K2 = bVar3.K();
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.A(K2, "em_group_announcement_entrance", B9().T2(), null);
        com.tencent.mobileqq.troop.troopsetting.activity.a.k(K2, null);
        com.tencent.mobileqq.troop.troopsetting.activity.a.m(K2);
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        FormItemRelativeLayout c16 = com.tencent.mobileqq.troop.troopsetting.activity.d.c(activity2);
        c16.findViewById(R.id.abv).setVisibility(8);
        com.tencent.mobileqq.troop.troopsetting.activity.a.l(c16);
        com.tencent.mobileqq.troop.troopsetting.ktx.a aVar = com.tencent.mobileqq.troop.troopsetting.ktx.a.f301140a;
        View findViewById = c16.findViewById(R.id.i_f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "myTroopMemberCardItem.findViewById(R.id.rightInfo)");
        aVar.d((TextView) findViewById);
        TroopInfoData troopInfoData2 = this.mTroopInfoData;
        if (troopInfoData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData2 = null;
        }
        boolean isHomeworkTroop = troopInfoData2.isHomeworkTroop();
        this.isHomeworkTroop = isHomeworkTroop;
        TroopInfoData troopInfoData3 = this.mTroopInfoData;
        if (troopInfoData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData3 = null;
        }
        QLog.i("TroopSettingChatGroupPart", 1, "init troop card " + isHomeworkTroop + " nick=" + troopInfoData3.troopColorNick);
        String string2 = getContext().getResources().getString(R.string.cfg);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026.my_troopmember_card_txt)");
        if (this.isHomeworkTroop) {
            string2 = getContext().getResources().getString(R.string.f169752j7);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026.my_troopmember_role_txt)");
        }
        String str = string2;
        Context context2 = getContext();
        TroopInfoData troopInfoData4 = this.mTroopInfoData;
        if (troopInfoData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
        } else {
            troopInfoData = troopInfoData4;
        }
        aVar.b(context2, 0, 2, c16, str, troopInfoData.troopColorNick, true);
        aVar.a(getContext(), c16);
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<FormItemRelativeLayout> bVar4 = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(c16);
        bVar4.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingChatGroupPart.ua(TroopSettingChatGroupPart.this, view);
            }
        });
        this.configList.add(bVar4);
        this.myTroopMemberCardConfig = bVar4;
        String string3 = getContext().getString(R.string.f2065358k);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.te\u2026R.string.qq_troop_remark)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string3), new x.c.g("", false, false, 6, null));
        this.troopRemarkConfig = xVar2;
        xVar2.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingChatGroupPart.oa(TroopSettingChatGroupPart.this, view);
            }
        });
        xVar2.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.al
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopSettingChatGroupPart.pa(TroopSettingChatGroupPart.this, view);
            }
        });
        this.configList.add(xVar2);
        Ra(B9().S2().troopRemark);
        CharSequence d16 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.d(getContext().getResources().getString(R.string.f20678599));
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        this.groups = new Group[]{new Group(d16, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(TroopSettingChatGroupPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ba();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(TroopSettingChatGroupPart this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AppInterface z95 = this$0.z9();
        TroopInfoData troopInfoData = this$0.mTroopInfoData;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData = null;
        }
        ReportController.o(z95, "dc00899", "Grp_set_new", "", "groupnameRemarks", "entrance_exp", 0, 0, troopInfoData.troopUin, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(TroopSettingChatGroupPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(TroopSettingChatGroupPart this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.groupNameView = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(TroopSettingChatGroupPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Aa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(TroopSettingChatGroupPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.za();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(TroopSettingChatGroupPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B9().U3(this$0.getActivity());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void va() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingChatGroupPart$initObserver$1(this, null), 3, null);
    }

    private final void wa() {
        TroopSearchWay d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(B9().S2());
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b P2 = B9().P2();
        if (P2 != null) {
            P2.g(d16);
        }
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b P22 = B9().P2();
        if (P22 != null) {
            P22.f(new Function1<com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatGroupPart$initSearchWayStateObserver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingChatGroupPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c cVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                    } else {
                        Intrinsics.checkNotNullParameter(cVar, "<name for destructuring parameter 0>");
                        TroopSettingChatGroupPart.this.B9().b4(a.ai.f301113a);
                    }
                }
            });
        }
    }

    private final void xa() {
        TroopInfoData troopInfoData;
        QLog.i("TroopSettingChatGroupPart", 1, "[onTroopNameEntryClick] isNewTroop:" + B9().S2().isNewTroop + ", memberChangeGroupNameSwitch:" + B9().S2().getMemberChangeGroupNameSwitch());
        TroopInfoData troopInfoData2 = null;
        if (!B9().S2().canModifyTroopName()) {
            Fa();
        } else {
            IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
            TroopInfoData troopInfoData3 = this.mTroopInfoData;
            if (troopInfoData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
                troopInfoData = null;
            } else {
                troopInfoData = troopInfoData3;
            }
            iChatSettingForTroopApi.TroopNameEntry(troopInfoData, getActivity(), B9().G2(), 96, 16);
        }
        com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
        AppInterface z95 = z9();
        TroopInfoData troopInfoData4 = this.mTroopInfoData;
        if (troopInfoData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
        } else {
            troopInfoData2 = troopInfoData4;
        }
        cVar.y(z95, troopInfoData2);
    }

    private final void za() {
        IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
        Activity activity = getActivity();
        TroopInfoData troopInfoData = this.mTroopInfoData;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopInfoData");
            troopInfoData = null;
        }
        if (!iChatSettingForTroopApi.troopNoticeFreezed(activity, troopInfoData)) {
            Ia();
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
        if (requestCode != 2) {
            if (requestCode != 17) {
                if (requestCode != 20) {
                    if (requestCode != 23) {
                        return;
                    }
                } else {
                    ma(resultCode, data);
                    return;
                }
            } else {
                la(resultCode, data);
                return;
            }
        }
        if (resultCode == -1 && getContext() != null) {
            QQToast.makeText(getContext(), 2, getContext().getString(R.string.f234837a1), 0).show();
        }
        TroopSettingViewModel B9 = B9();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        B9.g3(data, activity, z9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        this.mTroopInfoData = B9().T2();
        na();
        va();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            ea();
        }
    }
}
