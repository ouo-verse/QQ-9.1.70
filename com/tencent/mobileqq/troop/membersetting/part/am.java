package com.tencent.mobileqq.troop.membersetting.part;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profile.ProfileCardShareHelper;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ys2.MemberSettingUIModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR.\u0010!\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001cj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/am;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "", "L9", "N9", "", "uin", "nickname", "", "serviceId", "P9", "titleName", "Lcom/tencent/mobileqq/structmsg/a;", "K9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lys2/a;", "e", "Lys2/a;", "uiModel", "f", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "i", "Lcom/tencent/mobileqq/widget/listitem/x;", "friendRecommendConfig", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class am extends t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Group[] groups = new Group[0];

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<?, ?> friendRecommendConfig;

    private final com.tencent.mobileqq.structmsg.a K9(String titleName) {
        com.tencent.mobileqq.structmsg.view.ag agVar = new com.tencent.mobileqq.structmsg.view.ag();
        agVar.C(1);
        agVar.s(titleName);
        return agVar;
    }

    private final void L9() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsFriend()) {
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel2 = memberSettingUIModel3;
            }
            if (memberSettingUIModel2.getIsForbidAccount()) {
                return;
            }
            String qqStr = HardCodeUtil.qqStr(R.string.f132012_);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qb_troop_\u2026setting_recommend_friend)");
            com.tencent.mobileqq.widget.listitem.x<?, ?> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(qqStr), new x.c.g("", false, false, 6, null));
            xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ak
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    am.M9(am.this, view);
                }
            });
            this.configList.add(xVar);
            this.friendRecommendConfig = xVar;
            Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
            this.groups = new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(am this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
    }

    private final void N9() {
        String nickname;
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsQidianMaster()) {
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            if (memberSettingUIModel4.getNickname() == null) {
                MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
                if (memberSettingUIModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel5 = null;
                }
                AllInOne allInOne = memberSettingUIModel5.getAllInOne();
                nickname = allInOne != null ? allInOne.nickname : null;
            } else {
                MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
                if (memberSettingUIModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel6 = null;
                }
                nickname = memberSettingUIModel6.getNickname();
            }
            memberSettingUIModel3.f0(nickname);
            MemberSettingUIModel memberSettingUIModel7 = this.uiModel;
            if (memberSettingUIModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel7 = null;
            }
            AllInOne allInOne2 = memberSettingUIModel7.getAllInOne();
            String str = allInOne2 != null ? allInOne2.uin : null;
            MemberSettingUIModel memberSettingUIModel8 = this.uiModel;
            if (memberSettingUIModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel2 = memberSettingUIModel8;
            }
            P9(str, memberSettingUIModel2.getNickname(), 14);
            return;
        }
        MemberSettingUIModel memberSettingUIModel9 = this.uiModel;
        if (memberSettingUIModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel9 = null;
        }
        if (memberSettingUIModel9.getShareHelper() == null) {
            MemberSettingUIModel memberSettingUIModel10 = this.uiModel;
            if (memberSettingUIModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel10 = null;
            }
            memberSettingUIModel10.n0(new ProfileCardShareHelper(getActivity(), null, 1, new ProfileCardShareHelper.d() { // from class: com.tencent.mobileqq.troop.membersetting.part.al
                @Override // com.tencent.mobileqq.profile.ProfileCardShareHelper.d
                public final void a(int i3, String str2) {
                    am.O9(am.this, i3, str2);
                }
            }));
        }
        MemberSettingUIModel memberSettingUIModel11 = this.uiModel;
        if (memberSettingUIModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel11 = null;
        }
        AllInOne allInOne3 = memberSettingUIModel11.getAllInOne();
        if (TextUtils.isEmpty(allInOne3 != null ? allInOne3.nickname : null)) {
            MemberSettingUIModel memberSettingUIModel12 = this.uiModel;
            if (memberSettingUIModel12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel12 = null;
            }
            AllInOne allInOne4 = memberSettingUIModel12.getAllInOne();
            if (allInOne4 != null) {
                MemberSettingUIModel memberSettingUIModel13 = this.uiModel;
                if (memberSettingUIModel13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel13 = null;
                }
                AllInOne allInOne5 = memberSettingUIModel13.getAllInOne();
                allInOne4.nickname = allInOne5 != null ? allInOne5.uin : null;
            }
        }
        MemberSettingUIModel memberSettingUIModel14 = this.uiModel;
        if (memberSettingUIModel14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel14 = null;
        }
        ProfileCardShareHelper shareHelper = memberSettingUIModel14.getShareHelper();
        if (shareHelper != null) {
            MemberSettingUIModel memberSettingUIModel15 = this.uiModel;
            if (memberSettingUIModel15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel15 = null;
            }
            AllInOne allInOne6 = memberSettingUIModel15.getAllInOne();
            String str2 = allInOne6 != null ? allInOne6.uin : null;
            MemberSettingUIModel memberSettingUIModel16 = this.uiModel;
            if (memberSettingUIModel16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel16 = null;
            }
            AllInOne allInOne7 = memberSettingUIModel16.getAllInOne();
            shareHelper.A(str2, allInOne7 != null ? allInOne7.nickname : null);
        }
    }

    private final void P9(String uin, String nickname, int serviceId) {
        int i3;
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getSpecialFlag() != 0) {
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            i3 = memberSettingUIModel3.getSpecialFlag();
        } else {
            i3 = 17;
        }
        String str = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + uin + "&cspecialflag=" + i3;
        String str2 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + uin + "&version=1&cspecialflag=" + i3;
        String str3 = "https://share.mp.qq.com/cgi/share.php?uin=" + uin + "&account_flag=-7&jumptype=1&card_type=crm&cspecialflag=" + i3;
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(14).f(2).f(1).d(HardCodeUtil.qqStr(R.string.f1320029) + nickname).b("plugin", str3, "", str, str2).e(getContext().getResources().getString(R.string.f132022a)).a();
        com.tencent.mobileqq.structmsg.view.u uVar = new com.tencent.mobileqq.structmsg.view.u();
        uVar.C(1);
        uVar.m(new com.tencent.mobileqq.structmsg.view.c("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + uin));
        uVar.m(new StructMsgItemTitle(nickname));
        String qqStr = HardCodeUtil.qqStr(R.string.f1315410);
        MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
        if (memberSettingUIModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel4;
        }
        uVar.m(new com.tencent.mobileqq.structmsg.view.ap(qqStr + memberSettingUIModel2.getQidianShowUin()));
        String qqStr2 = HardCodeUtil.qqStr(R.string.f132032b);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qb_troop_\u2026ng_recommend_good_friend)");
        a16.addItem(K9(qqStr2));
        a16.addItem(uVar);
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 20);
        bundle.putInt(AppConstants.Key.STRUCT_MSG_SERVICE_ID, serviceId);
        bundle.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        bundle.putBoolean("k_dataline", false);
        Intent intent = new Intent();
        bundle.putString(GetAdInfoRequest.SOURCE_FROM, "share_from_troop_member_card");
        intent.putExtras(bundle);
        RouteUtils.startActivity(getActivity(), intent, "/share/toqq/activity");
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
        L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(am this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 2) {
            if (i3 != 9) {
                return;
            }
            ReportController.o(this$0.z9(), "dc00898", "", "", "0X800A4FE", "0X800A4FE", 0, 0, "", "", "", "");
            return;
        }
        MemberSettingUIModel memberSettingUIModel = this$0.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        ReportController.o(this$0.z9(), "CliOper", "", "", "0X80050E7", "0X80050E7", ProfilePAUtils.isPaTypeFriend(memberSettingUIModel.getAllInOne()) ? 1 : 2, 0, "", "", "", "");
        ReportController.o(this$0.z9(), "dc00898", "", "", "0X800A4FD", "0X800A4FD", 0, 0, "", "", "", "");
    }
}
