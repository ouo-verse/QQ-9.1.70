package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.dh;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.membersetting.fragment.MemberGagFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.ActionSheet;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import ys2.MemberSettingUIModel;
import zs2.a;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\tH\u0002J$\u0010&\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020$H\u0002J$\u0010(\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010)\u001a\u00020\u0002H\u0002J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016\u00a2\u0006\u0004\b,\u0010-J\u0010\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016J\"\u00105\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\b\u00104\u001a\u0004\u0018\u000103H\u0016R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R.\u0010E\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030A0@j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030A`B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\"\u0010K\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\"\u0010M\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010JR\"\u0010O\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010JR\"\u0010R\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020P0F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010J\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/MemberSettingGroupManagePart;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "", "ca", "Ha", "La", "", "memberName", "Na", "", "isGaged", "Ga", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "Ka", "", "errorCode", "Ja", "isSuccess", "Ia", "ia", "Aa", "Ca", "isChecked", "sa", "va", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "reqCode", "Da", "Fa", "na", "la", "ma", "troopUin", "memberUin", "Landroid/os/Handler$Callback;", "callback", "oa", IProfileProtocolConst.PARAM_TROOP_CODE, "Ea", "qa", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lys2/a;", "e", "Lys2/a;", "uiModel", "f", "Z", "mAdminSettingSwitch", tl.h.F, "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/x;", "myTroopMemberCardConfig", BdhLogUtil.LogTag.Tag_Conn, "gagMsgConfig", "D", "msgTipConfig", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "E", "adminSettingConfig", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MemberSettingGroupManagePart extends t {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> gagMsgConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> msgTipConfig;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> adminSettingConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mAdminSettingSwitch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Group[] groups = new Group[0];

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> myTroopMemberCardConfig;

    private final void Aa() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel.getTroopMemberCard();
        int i3 = 1;
        int i16 = 2;
        if (troopMemberCard != null && troopMemberCard.memberRole == 0) {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f1319322, 0).show();
            return;
        }
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        TroopMemberCard troopMemberCard2 = memberSettingUIModel3.getTroopMemberCard();
        if (troopMemberCard2 != null) {
            if (!troopMemberCard2.isConcerned) {
                MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
                if (memberSettingUIModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel2 = memberSettingUIModel4;
                }
                if (!memberSettingUIModel2.getIsOrgMgr()) {
                    i3 = 0;
                }
            }
            if (!troopMemberCard2.mIsShield) {
                i16 = i3;
            }
        } else {
            i16 = 0;
        }
        final ActionSheet create = ActionSheet.create(getContext());
        create.addRadioButton(R.string.f131641_, false);
        create.addRadioButton(R.string.f132222u, false);
        create.addRadioButton(R.string.f132142m, false);
        create.addCancelButton(R.string.f1311902);
        create.setRadioButtonChecked(i16);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ay
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i17) {
                MemberSettingGroupManagePart.Ba(MemberSettingGroupManagePart.this, create, view, i17);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r9 != 2) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Ba(MemberSettingGroupManagePart this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i16 = 0;
        if (i3 != 0) {
            int i17 = i3 != 1 ? 2 : 1;
            i16 = i17;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0.getPartHost()), null, null, new MemberSettingGroupManagePart$onMsgTipEntryClick$2$1(this$0, i16, null), 3, null);
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }

    private final void Ca() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getCardType() == 0) {
            Fa(getActivity());
        } else {
            Da(getActivity(), 5);
        }
    }

    private final void Da(Activity activity, int reqCode) {
        xs2.c cVar = xs2.c.f448459a;
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (cVar.f(memberSettingUIModel.getTroopUin())) {
            if (activity == null) {
                QLog.e("MemberSettingGroupManagePart", 1, "openEditInfoActivity fail for activity is null");
                return;
            }
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            String memberUin = memberSettingUIModel3.getMemberUin();
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel2 = memberSettingUIModel4;
            }
            com.tencent.mobileqq.troop.utils.d.c(activity, memberUin, memberSettingUIModel2.getTroopUin(), "qqProfile");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("edit_mode", 0);
        MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
        if (memberSettingUIModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel5 = null;
        }
        intent.putExtra("troopUin", memberSettingUIModel5.getTroopUin());
        MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
        if (memberSettingUIModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel6 = null;
        }
        intent.putExtra("uin", memberSettingUIModel6.getMemberUin());
        String string = getContext().getResources().getString(R.string.f131771m);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ember_setting_edit_title)");
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 5);
        MemberSettingUIModel memberSettingUIModel7 = this.uiModel;
        if (memberSettingUIModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel7;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel2.getTroopMemberCard();
        if (troopMemberCard != null) {
            intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, troopMemberCard.colorCard);
            intent.putExtra("default_nick_id", troopMemberCard.colorCardId);
        }
        intent.putExtra("max_num", 60);
        intent.putExtra("auto_remark", true);
        intent.putExtra("title", string);
        intent.putExtra("default_hint", getContext().getResources().getString(R.string.f1319625));
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, reqCode);
    }

    private final void Ea(byte operation, String troopCode, String memberUin) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), dh.class);
        newIntent.putExtra("command", 0);
        newIntent.putExtra(QCircleDaTongConstant.ElementParamValue.OPERATION, operation);
        newIntent.putExtra(AppConstants.Key.TROOP_CODE, troopCode);
        newIntent.putExtra("troop_member_uin", memberUin);
        MobileQQ.sMobileQQ.peekAppRuntime().startServlet(newIntent);
    }

    private final void Fa(Activity activity) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        String troopUin = memberSettingUIModel.getTroopUin();
        if (troopUin == null) {
            troopUin = "";
        }
        String str = troopUin;
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel3.getTroopMemberCard();
        int i3 = troopMemberCard != null ? troopMemberCard.colorCardId : 0;
        xs2.c cVar = xs2.c.f448459a;
        boolean f16 = cVar.f(str);
        MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
        if (memberSettingUIModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel4 = null;
        }
        TroopMemberCard troopMemberCard2 = memberSettingUIModel4.getTroopMemberCard();
        String str2 = troopMemberCard2 != null ? troopMemberCard2.colorCard : null;
        MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
        if (memberSettingUIModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel5;
        }
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).startTroopMemberCard(activity, z9(), new com.tencent.mobileqq.troop.k(str, f16, str2, i3, cVar.d(memberSettingUIModel2.getMyRole())), 5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        if (r4.getIsOrgMgr() != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ha() {
        String string = getContext().getResources().getString(R.string.f131641_);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026p_member_setting_default)");
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel.getTroopMemberCard();
        if (troopMemberCard != null) {
            if (!troopMemberCard.isConcerned) {
                MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
                if (memberSettingUIModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel2 = null;
                }
            }
            string = getContext().getResources().getString(R.string.f132222u);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026er_setting_special_focus)");
            if (troopMemberCard.mIsShield) {
                string = getContext().getResources().getString(R.string.f132142m);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026er_setting_shield_action)");
            }
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.msgTipConfig;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgTipConfig");
            xVar2 = null;
        }
        xVar2.O().h(string);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.msgTipConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgTipConfig");
        } else {
            xVar = xVar3;
        }
        D9(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka(byte operation) {
        Byte b16 = vs2.a.f443295b;
        MemberSettingUIModel memberSettingUIModel = null;
        if (b16 != null && operation == b16.byteValue()) {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f131731i, 0).show();
            MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
            if (memberSettingUIModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel = memberSettingUIModel2;
            }
            TroopMemberCard troopMemberCard = memberSettingUIModel.getTroopMemberCard();
            if (troopMemberCard != null) {
                troopMemberCard.memberRole = 1;
            }
        } else {
            Byte b17 = vs2.a.f443294a;
            if (b17 != null && operation == b17.byteValue()) {
                QQToast.makeText(BaseApplication.getContext(), 2, R.string.f132112j, 0).show();
                MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
                if (memberSettingUIModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel = memberSettingUIModel3;
                }
                TroopMemberCard troopMemberCard2 = memberSettingUIModel.getTroopMemberCard();
                if (troopMemberCard2 != null) {
                    troopMemberCard2.memberRole = 2;
                }
            }
        }
        La();
    }

    private final void La() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel.getTroopMemberCard();
        boolean z16 = false;
        if (troopMemberCard != null && troopMemberCard.memberRole == 2) {
            z16 = true;
        }
        this.mAdminSettingSwitch = z16;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = this.adminSettingConfig;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adminSettingConfig");
            xVar2 = null;
        }
        x.c.f O = xVar2.O();
        O.h(null);
        O.f(this.mAdminSettingSwitch);
        O.h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ao
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                MemberSettingGroupManagePart.Ma(MemberSettingGroupManagePart.this, compoundButton, z17);
            }
        });
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this.adminSettingConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adminSettingConfig");
        } else {
            xVar = xVar3;
        }
        D9(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(MemberSettingGroupManagePart this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa(this$0.mAdminSettingSwitch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na(String memberName) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.myTroopMemberCardConfig;
        if (xVar == null) {
            return;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myTroopMemberCardConfig");
            xVar = null;
        }
        x.c.g O = xVar.O();
        if (TextUtils.isEmpty(memberName)) {
            String string = getContext().getResources().getString(R.string.f132052d);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026r_setting_remark_not_set)");
            O.h(string);
        } else {
            INickNameApi iNickNameApi = (INickNameApi) QRoute.api(INickNameApi.class);
            if (memberName == null) {
                memberName = "";
            }
            O.h(iNickNameApi.getEmotionNickName(memberName, 16));
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.myTroopMemberCardConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myTroopMemberCardConfig");
        } else {
            xVar2 = xVar3;
        }
        D9(xVar2);
    }

    private final void ca() {
        Group[] groupArr;
        MemberSettingUIModel memberSettingUIModel = null;
        if (na()) {
            String string = getContext().getString(R.string.f1319221);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_member_setting_nickname)");
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, false, 6, null));
            xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.as
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberSettingGroupManagePart.da(MemberSettingGroupManagePart.this, view);
                }
            });
            this.configList.add(xVar);
            this.myTroopMemberCardConfig = xVar;
            MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
            if (memberSettingUIModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel2 = null;
            }
            TroopMemberCard troopMemberCard = memberSettingUIModel2.getTroopMemberCard();
            Na(troopMemberCard != null ? troopMemberCard.colorCard : null);
        }
        if (la()) {
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            TroopMemberCard troopMemberCard2 = memberSettingUIModel3.getTroopMemberCard();
            this.mAdminSettingSwitch = troopMemberCard2 != null && troopMemberCard2.memberRole == 2;
            String string2 = getContext().getString(R.string.f1315713);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026er_setting_admin_setting)");
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string2), new x.c.f(this.mAdminSettingSwitch, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.at
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    MemberSettingGroupManagePart.ea(MemberSettingGroupManagePart.this, compoundButton, z16);
                }
            }));
            this.adminSettingConfig = xVar2;
            this.configList.add(xVar2);
        }
        MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
        if (memberSettingUIModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel4 = null;
        }
        if (memberSettingUIModel4.getCardType() != 0 && ma()) {
            String string3 = getContext().getString(R.string.f131831s);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026_setting_gag_msg_setting)");
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string3), new x.c.g("", false, false, 6, null));
            xVar3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.au
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberSettingGroupManagePart.ga(MemberSettingGroupManagePart.this, view);
                }
            });
            this.configList.add(xVar3);
            this.gagMsgConfig = xVar3;
            ia();
        }
        MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
        if (memberSettingUIModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel5 = null;
        }
        if (memberSettingUIModel5.getCardType() != 0) {
            String string4 = getContext().getString(R.string.f132202s);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026er_setting_speak_setting)");
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar4 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string4), new x.c.g("", false, false, 6, null));
            xVar4.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.av
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberSettingGroupManagePart.ha(MemberSettingGroupManagePart.this, view);
                }
            });
            this.configList.add(xVar4);
            this.msgTipConfig = xVar4;
            Ha();
        }
        MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
        if (memberSettingUIModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel = memberSettingUIModel6;
        }
        if (memberSettingUIModel.getCardType() != 0) {
            String string5 = getContext().getResources().getString(R.string.f132212t);
            Intrinsics.checkNotNullExpressionValue(string5, "context.resources.getStr\u2026etting_speak_setting_tip)");
            Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
            groupArr = new Group[]{new Group("", string5, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
        } else {
            Object[] array2 = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = (com.tencent.mobileqq.widget.listitem.a[]) array2;
            groupArr = new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length))};
        }
        this.groups = groupArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(MemberSettingGroupManagePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ca();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(MemberSettingGroupManagePart this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(MemberSettingGroupManagePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(MemberSettingGroupManagePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Aa();
    }

    private final void ia() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        String troopUin = memberSettingUIModel.getTroopUin();
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel3;
        }
        oa(troopUin, memberSettingUIModel2.getMemberUin(), new Handler.Callback() { // from class: com.tencent.mobileqq.troop.membersetting.part.aw
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean ja5;
                ja5 = MemberSettingGroupManagePart.ja(MemberSettingGroupManagePart.this, message);
                return ja5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ja(MemberSettingGroupManagePart this$0, Message msg2) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Object obj = msg2.obj;
        if (obj instanceof Boolean) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            z16 = ((Boolean) obj).booleanValue();
        } else {
            z16 = false;
        }
        this$0.Ga(z16);
        return false;
    }

    private final boolean la() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getMyRole() != 3) {
            return false;
        }
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        if (memberSettingUIModel3.getCardType() == 0) {
            return false;
        }
        MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
        if (memberSettingUIModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel4;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel2.getTroopMemberCard();
        return !(troopMemberCard != null && troopMemberCard.memberRole == 0);
    }

    private final boolean ma() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getMyRole() == 3) {
            return true;
        }
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        if (memberSettingUIModel3.getMyRole() == 2) {
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            TroopMemberCard troopMemberCard = memberSettingUIModel4.getTroopMemberCard();
            if (!(troopMemberCard != null && troopMemberCard.memberRole == 3)) {
                MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
                if (memberSettingUIModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel2 = memberSettingUIModel5;
                }
                TroopMemberCard troopMemberCard2 = memberSettingUIModel2.getTroopMemberCard();
                if (!(troopMemberCard2 != null && troopMemberCard2.memberRole == 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if ((r0 != null && r0.memberRole == 3) == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean na() {
        boolean z16;
        MemberSettingUIModel memberSettingUIModel;
        MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
        MemberSettingUIModel memberSettingUIModel3 = null;
        if (memberSettingUIModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel2 = null;
        }
        if (memberSettingUIModel2.getMyRole() != 3) {
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            if (memberSettingUIModel4.getMyRole() == 2) {
                MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
                if (memberSettingUIModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel5 = null;
                }
                TroopMemberCard troopMemberCard = memberSettingUIModel5.getTroopMemberCard();
            }
            z16 = false;
            memberSettingUIModel = this.uiModel;
            if (memberSettingUIModel != null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel3 = memberSettingUIModel;
            }
            return z16 || (memberSettingUIModel3.getCardType() != 0);
        }
        z16 = true;
        memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel != null) {
        }
        if (z16) {
            return true;
        }
    }

    private final void oa(String troopUin, String memberUin, final Handler.Callback callback) {
        final Message obtain = Message.obtain();
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(troopUin, memberUin, false, null, "MemberSettingGroupManagePart", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.troop.membersetting.part.ap
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                MemberSettingGroupManagePart.pa(obtain, callback, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(Message message, Handler.Callback callback, TroopMemberInfo troopMemberInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (troopMemberInfo != null) {
            long j3 = troopMemberInfo.gagTimeStamp;
            if (j3 != 0 && j3 > NetConnInfoCenter.getServerTime()) {
                z16 = true;
                message.obj = Boolean.valueOf(z16);
                callback.handleMessage(message);
            }
        }
        z16 = false;
        message.obj = Boolean.valueOf(z16);
        callback.handleMessage(message);
    }

    private final void qa() {
        MutableLiveData<zs2.a> obtainUiState = C9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<zs2.a, Unit> function1 = new Function1<zs2.a, Unit>() { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingGroupManagePart$observeUiState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(zs2.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(zs2.a aVar) {
                if (aVar instanceof a.TroopMemberNameUpdate) {
                    MemberSettingGroupManagePart.this.Na(((a.TroopMemberNameUpdate) aVar).getMemberName());
                    return;
                }
                if (aVar instanceof a.TroopAdminUpdateSuccess) {
                    MemberSettingGroupManagePart.this.Ka(((a.TroopAdminUpdateSuccess) aVar).getOperation());
                    return;
                }
                if (aVar instanceof a.TroopAdminUpdateFail) {
                    MemberSettingGroupManagePart.this.Ja(((a.TroopAdminUpdateFail) aVar).getErrorCode());
                    return;
                }
                if (aVar instanceof a.GagMsgSettingUpdate) {
                    MemberSettingGroupManagePart.this.Ga(((a.GagMsgSettingUpdate) aVar).getGagMsg());
                } else if (aVar instanceof a.MsgTipUpdate) {
                    a.MsgTipUpdate msgTipUpdate = (a.MsgTipUpdate) aVar;
                    MemberSettingGroupManagePart.this.Ia(msgTipUpdate.getIsSuccess(), msgTipUpdate.getErrorCode());
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.membersetting.part.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemberSettingGroupManagePart.ra(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void sa(boolean isChecked) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        final String troopUin = memberSettingUIModel.getTroopUin();
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        final String memberUin = memberSettingUIModel3.getMemberUin();
        MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
        if (memberSettingUIModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel4 = null;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel4.getTroopMemberCard();
        if (troopMemberCard != null && troopMemberCard.memberRole == 2) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, getContext().getResources().getString(R.string.f131721h), getContext().getResources().getString(R.string.f131651a), getContext().getResources().getString(R.string.f1311902), getContext().getResources().getString(R.string.f131440q), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.az
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MemberSettingGroupManagePart.ta(MemberSettingGroupManagePart.this, troopUin, memberUin, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ba
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MemberSettingGroupManagePart.ua(MemberSettingGroupManagePart.this, dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026()\n                    })");
            createCustomDialog.show();
            return;
        }
        MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
        if (memberSettingUIModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel5;
        }
        TroopMemberCard troopMemberCard2 = memberSettingUIModel2.getTroopMemberCard();
        if (troopMemberCard2 != null && troopMemberCard2.memberRole == 1) {
            Ea(vs2.a.f443294a.byteValue(), troopUin, memberUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(MemberSettingGroupManagePart this$0, String str, String str2, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ea(vs2.a.f443295b.byteValue(), str, str2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(MemberSettingGroupManagePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.La();
    }

    private final void va() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        final String troopUin = memberSettingUIModel.getTroopUin();
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel3;
        }
        final String memberUin = memberSettingUIModel2.getMemberUin();
        oa(troopUin, memberUin, new Handler.Callback() { // from class: com.tencent.mobileqq.troop.membersetting.part.ax
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean wa5;
                wa5 = MemberSettingGroupManagePart.wa(troopUin, memberUin, this, message);
                return wa5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean wa(String str, String str2, final MemberSettingGroupManagePart this$0, Message msg2) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Object obj = msg2.obj;
        if (obj instanceof Boolean) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            z16 = ((Boolean) obj).booleanValue();
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.membersetting.part.aq
                @Override // java.lang.Runnable
                public final void run() {
                    MemberSettingGroupManagePart.xa(MemberSettingGroupManagePart.this);
                }
            });
        } else {
            Intent intent = new Intent();
            intent.putExtra("param_key_troopUin", str);
            intent.putExtra("param_key_memberUin", str2);
            QPublicFragmentActivity.start(this$0.getActivity(), intent, MemberGagFragment.class);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(final MemberSettingGroupManagePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ActionSheet create = ActionSheet.create(this$0.getContext());
        create.addCancelButton(R.string.f1311902);
        create.addButton(R.string.f131781n);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ar
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                MemberSettingGroupManagePart.za(MemberSettingGroupManagePart.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(MemberSettingGroupManagePart this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0.getPartHost()), null, null, new MemberSettingGroupManagePart$onGagMsgClick$1$1$1$1(this$0, null), 3, null);
        }
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.troop.membersetting.part.t
    /* renamed from: H9, reason: from getter */
    public Group[] getGroups() {
        return this.groups;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.uiModel = C9().Q1();
        ca();
        qa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga(boolean isGaged) {
        String str;
        if (isGaged) {
            str = getContext().getResources().getString(R.string.f131871w);
        } else {
            str = "";
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = null;
        if (str != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.gagMsgConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gagMsgConfig");
                xVar2 = null;
            }
            xVar2.O().h(str);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.gagMsgConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gagMsgConfig");
        } else {
            xVar = xVar3;
        }
        D9(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia(boolean isSuccess, int errorCode) {
        if (isSuccess) {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.i8f, 0).show();
            Ha();
        } else if (errorCode == 4) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f131881x, 0).show();
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.i8c, 0).show();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        Bundle extras2;
        if (requestCode == 5) {
            if ((data == null || (extras2 = data.getExtras()) == null) ? false : extras2.getBoolean(AppConstants.Key.IS_NEED_FINISH)) {
                Intent resultIntent = C9().Q1().getResultIntent();
                resultIntent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                Activity activity = getActivity();
                if (activity != null) {
                    xs2.c.f448459a.h(activity, resultIntent);
                    return;
                }
                return;
            }
            MemberSettingUIModel memberSettingUIModel = null;
            String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("result");
            if (string != null) {
                MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
                if (memberSettingUIModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel = memberSettingUIModel2;
                }
                TroopMemberCard troopMemberCard = memberSettingUIModel.getTroopMemberCard();
                if (troopMemberCard != null) {
                    troopMemberCard.colorCard = string;
                }
                Na(string);
                QQToast.makeText(BaseApplication.getContext(), 2, R.string.i9j, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja(int errorCode) {
        String string;
        if (errorCode == 4) {
            ITroopListRepoApi iTroopListRepoApi = (ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class);
            MemberSettingUIModel memberSettingUIModel = this.uiModel;
            if (memberSettingUIModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel = null;
            }
            TroopInfo troopInfoFromCache = iTroopListRepoApi.getTroopInfoFromCache(memberSettingUIModel.getTroopUin());
            int i3 = troopInfoFromCache != null ? troopInfoFromCache.maxAdminNum : 0;
            if (i3 > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = getContext().getResources().getString(R.string.i4u);
                Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026troop_admin_overload_tip)");
                string = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
            } else {
                string = BaseApplication.getContext().getResources().getString(R.string.i4v);
            }
        } else if (errorCode == 7) {
            string = getContext().getResources().getString(R.string.cjf);
        } else if (errorCode != 17) {
            string = getContext().getResources().getString(R.string.cpp);
        } else {
            string = getContext().getResources().getString(R.string.f235307ba);
        }
        QQToast.makeText(BaseApplication.getContext(), 1, string, 0).show();
    }
}
