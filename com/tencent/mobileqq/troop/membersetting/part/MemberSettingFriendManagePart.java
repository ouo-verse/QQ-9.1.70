package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.launcher.api.ITroopLauncherApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ys2.MemberSettingUIModel;
import zs2.a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\"\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R.\u0010*\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0%j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00100\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/MemberSettingFriendManagePart;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "", "N9", "", "remark", "W9", "Lcom/tencent/mobileqq/businessCard/data/BusinessCard;", IndividuationUrlHelper.UrlId.CARD_HOME, "X9", "strRemark", "U9", VipFunCallConstants.KEY_GROUP, "V9", "T9", "S9", "Q9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lys2/a;", "e", "Lys2/a;", "uiModel", "f", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "i", "Lcom/tencent/mobileqq/widget/listitem/x;", "remarkNameConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "friendGroupConfig", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MemberSettingFriendManagePart extends t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Group[] groups = new Group[0];

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> remarkNameConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> friendGroupConfig;

    private final void N9() {
        String string = getContext().getString(R.string.f131761l);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ing_divider_info_comment)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberSettingFriendManagePart.O9(MemberSettingFriendManagePart.this, view);
            }
        });
        this.configList.add(xVar);
        this.remarkNameConfig = xVar;
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        W9(memberSettingUIModel.getRemark());
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        if (memberSettingUIModel3.getIsFriend()) {
            String string2 = getContext().getString(R.string.f131751k);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026p_member_setting_divider)");
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string2), new x.c.g("", false, false, 6, null));
            xVar2.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.aj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberSettingFriendManagePart.P9(MemberSettingFriendManagePart.this, view);
                }
            });
            this.configList.add(xVar2);
            this.friendGroupConfig = xVar2;
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel2 = memberSettingUIModel4;
            }
            V9(memberSettingUIModel2.getStrGroup());
            String string3 = getContext().getResources().getString(R.string.f131811q);
            Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026r_setting_friend_setting)");
            Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
            this.groups = new Group[]{new Group(string3, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
            return;
        }
        Object[] array2 = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = (com.tencent.mobileqq.widget.listitem.a[]) array2;
        this.groups = new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(MemberSettingFriendManagePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(MemberSettingFriendManagePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S9();
    }

    private final void Q9() {
        MutableLiveData<zs2.a> obtainUiState = C9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<zs2.a, Unit> function1 = new Function1<zs2.a, Unit>() { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingFriendManagePart$observeUiState$1
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
                if (aVar instanceof a.FriendRemarkNameUpdate) {
                    MemberSettingFriendManagePart.this.X9(((a.FriendRemarkNameUpdate) aVar).getCard());
                } else if (aVar instanceof a.FriendRemarkNameByRemarkUpdate) {
                    MemberSettingFriendManagePart.this.U9(((a.FriendRemarkNameByRemarkUpdate) aVar).getRemark());
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.membersetting.part.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemberSettingFriendManagePart.R9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S9() {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.MoveToGroupActivity");
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        AllInOne allInOne = memberSettingUIModel.getAllInOne();
        if (allInOne != null) {
            Intent putExtra = intent.putExtra("friendUin", allInOne.uin);
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel2 = memberSettingUIModel3;
            }
            putExtra.putExtra("mgid", (byte) memberSettingUIModel2.getGroupId());
        }
        intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        getActivity().startActivityForResult(intent, 8);
    }

    private final void T9() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsFriend()) {
            Activity activity = getActivity();
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            BusinessCard businessCard = memberSettingUIModel3.getBusinessCard();
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            ProfileCardUtil.n0(activity, businessCard, memberSettingUIModel4.getAllInOne(), true, null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("title", "\u8bbe\u7f6e\u5907\u6ce8");
        MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
        if (memberSettingUIModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel5 = null;
        }
        intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, memberSettingUIModel5.getRemark());
        MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
        if (memberSettingUIModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel6 = null;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel6.getTroopMemberCard();
        if (troopMemberCard != null) {
            String str = troopMemberCard.card;
            if (TextUtils.isEmpty(str)) {
                str = troopMemberCard.nick;
            }
            QLog.d("MemberSettingFriendManagePart", 2, "open editInfoActivity, card:" + troopMemberCard.card + ",nick:" + troopMemberCard.nick);
            intent.putExtra("default_hint", str);
        }
        MemberSettingUIModel memberSettingUIModel7 = this.uiModel;
        if (memberSettingUIModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel7 = null;
        }
        intent.putExtra("uin", memberSettingUIModel7.getMemberUin());
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        MemberSettingUIModel memberSettingUIModel8 = this.uiModel;
        if (memberSettingUIModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel8 = null;
        }
        intent.putExtra("uid", iRelationNTUinAndUidApi.getUidFromUin(memberSettingUIModel8.getMemberUin()));
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 4);
        intent.putExtra("max_limit_mode", 1);
        intent.putExtra("edit_mode", 2);
        intent.putExtra("from", 1);
        MemberSettingUIModel memberSettingUIModel9 = this.uiModel;
        if (memberSettingUIModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel9;
        }
        intent.putExtra("troopUin", memberSettingUIModel2.getTroopUin());
        intent.putExtra("max_num", 96);
        intent.setClassName("com.tencent.mobileqq", ((ITroopLauncherApi) QRoute.api(ITroopLauncherApi.class)).getEditInfoActivityClass().getName());
        getActivity().startActivityForResult(intent, 1034);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(String strRemark) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        String businessCardMessage = memberSettingUIModel.getBusinessCardMessage();
        if (!TextUtils.isEmpty(businessCardMessage)) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.remarkNameConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remarkNameConfig");
                xVar2 = null;
            }
            x.c.g O = xVar2.O();
            if (TextUtils.isEmpty(strRemark)) {
                O.h(businessCardMessage);
            } else {
                O.h(strRemark + "\uff0c" + businessCardMessage);
            }
        } else {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.remarkNameConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remarkNameConfig");
                xVar3 = null;
            }
            x.c.g O2 = xVar3.O();
            if (TextUtils.isEmpty(strRemark)) {
                O2.h("");
            } else {
                if (strRemark == null) {
                    strRemark = "";
                }
                O2.h(strRemark);
            }
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar4 = this.remarkNameConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remarkNameConfig");
        } else {
            xVar = xVar4;
        }
        D9(xVar);
    }

    private final void V9(String group) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.friendGroupConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendGroupConfig");
            xVar = null;
        }
        x.c.g O = xVar.O();
        if (TextUtils.isEmpty(group)) {
            O.h("");
        } else {
            if (group == null) {
                group = "";
            }
            O.h(group);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.friendGroupConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendGroupConfig");
        } else {
            xVar2 = xVar3;
        }
        D9(xVar2);
    }

    private final void W9(String remark) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsFriend()) {
            MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
            if (memberSettingUIModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel2 = null;
            }
            X9(memberSettingUIModel2.getBusinessCard());
        } else {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.remarkNameConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remarkNameConfig");
                xVar2 = null;
            }
            x.c.g O = xVar2.O();
            if (TextUtils.isEmpty(remark)) {
                String string = getContext().getResources().getString(R.string.f132052d);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026r_setting_remark_not_set)");
                O.h(string);
            } else {
                if (remark == null) {
                    remark = "";
                }
                O.h(remark);
            }
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.remarkNameConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remarkNameConfig");
        } else {
            xVar = xVar3;
        }
        D9(xVar);
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
        N9();
        Q9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String strGroup;
        int groupId;
        Bundle extras;
        Bundle extras2;
        String remark;
        Bundle extras3;
        MemberSettingUIModel memberSettingUIModel = null;
        if (requestCode != 8) {
            if (requestCode != 1034) {
                return;
            }
            if (data == null || (extras3 = data.getExtras()) == null || (remark = extras3.getString("result")) == null) {
                MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
                if (memberSettingUIModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel = memberSettingUIModel2;
                }
                remark = memberSettingUIModel.getRemark();
            }
            W9(remark);
            return;
        }
        if (data == null || (extras2 = data.getExtras()) == null || (strGroup = extras2.getString("group_name")) == null) {
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            strGroup = memberSettingUIModel3.getStrGroup();
        }
        if (data != null && (extras = data.getExtras()) != null) {
            groupId = extras.getByte("result");
        } else {
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            groupId = memberSettingUIModel4.getGroupId();
        }
        if (strGroup != null) {
            V9(strGroup);
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getPartHost()), null, null, new MemberSettingFriendManagePart$onActivityResult$1(this, strGroup, groupId, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(BusinessCard card) {
        if (card == null) {
            return;
        }
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        AllInOne allInOne = memberSettingUIModel.getAllInOne();
        String uid = iRelationNTUinAndUidApi.getUidFromUin(allInOne != null ? allInOne.uin : null);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, "ProfileCardMoreActivity");
        String r16 = friendsSimpleInfoWithUid != null ? friendsSimpleInfoWithUid.r() : null;
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(card.company)) {
            if (sb5.length() > 0) {
                sb5.append("\uff0c");
            }
            sb5.append(card.company);
        }
        List<String> list = card.mobilesNum;
        if (list != null) {
            Intrinsics.checkNotNullExpressionValue(list, "card.mobilesNum");
            if (!list.isEmpty()) {
                int size = card.mobilesNum.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (sb5.length() > 0) {
                        sb5.append("\uff0c");
                    }
                    sb5.append(card.mobilesNum.get(i3));
                }
            }
        }
        List<String> list2 = card.descs;
        if (list2 != null) {
            Intrinsics.checkNotNullExpressionValue(list2, "card.descs");
            if (!list2.isEmpty()) {
                if (sb5.length() > 0) {
                    sb5.append("\uff0c");
                }
                int size2 = card.descs.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    sb5.append(card.descs.get(i16));
                }
            }
        }
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel3;
        }
        memberSettingUIModel2.M(sb5.toString());
        U9(r16);
    }
}
