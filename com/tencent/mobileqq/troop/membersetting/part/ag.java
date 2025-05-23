package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import ys2.MemberSettingUIModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/ag;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "", "ga", "", "uin", "da", "V9", "Y9", "ea", "S9", "R9", "", "haveCheckBox", LocaleUtils.L_JAPANESE, "friendUin", "", "shieldTempSessionParam", "ca", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lys2/a;", "e", "Lys2/a;", "uiModel", "f", "Z", "isShieldFriend", "Lcom/tencent/biz/qui/quibutton/QUIButton;", tl.h.F, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "quitBtn", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "i", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "delFriendDialog", "Lus2/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lus2/b;", "quitConfig", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ag extends t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isShieldFriend = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIButton quitBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQCustomDialog delFriendDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private us2.b<View> quitConfig;

    private final void R9() {
        QQCustomDialog qQCustomDialog = this.delFriendDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        ReportController.o(z9(), "dc00898", "", "", "0X800C00C", "0X800C00C", 0, 0, "", "", "", "");
    }

    private final void S9(final String uin) {
        String string = getContext().getResources().getString(R.string.zlf);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026Q_del_friend_dialog_tile)");
        this.delFriendDialog = DialogUtil.createCustomDialog(getContext(), 0, string, "", R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.T9(ag.this, uin, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ac
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.U9(ag.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(ag this$0, String uin, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        this$0.ja(uin, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(ag this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
    }

    private final void V9(final String uin) {
        this.delFriendDialog = DialogUtil.createCustomDialog(getContext(), 0, ea(), "", R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.W9(ag.this, uin, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.aa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.X9(ag.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(ag this$0, String uin, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        this$0.isShieldFriend = false;
        this$0.ja(uin, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(ag this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
    }

    private final void Y9(final String uin) {
        String string = getContext().getResources().getString(R.string.f175402yg);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026_del_friend_dialog_check)");
        String string2 = getContext().getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getString(R.string.cancel)");
        String string3 = getContext().getResources().getString(R.string.f171151ok);
        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getString(R.string.ok)");
        this.delFriendDialog = DialogUtil.createDialogWithCheckBox(getContext(), 0, ea(), null, string, true, string2, string3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ad
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.ba(ag.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.ae
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.Z9(ag.this, uin, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.af
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.aa(ag.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(ag this$0, String uin, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        this$0.ja(uin, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(ag this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(ag this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isShieldFriend = i3 == 1;
    }

    private final void ca(String friendUin, int shieldTempSessionParam) {
        BusinessHandler businessHandler = z9().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendListHandler");
        ((FriendListHandler) businessHandler).delFriend("MemberSettingDeleteFriendPart", friendUin, (byte) 2, shieldTempSessionParam);
        MqqHandler handler = z9().getHandler(ChatSettingFragment.class);
        Intrinsics.checkNotNullExpressionValue(handler, "app.getHandler(ChatSettingFragment::class.java)");
        handler.sendMessage(handler.obtainMessage(16711681, friendUin));
        if (Utils.G(friendUin)) {
            ReportController.o(z9(), "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
        }
        Intent intent = new Intent("ACTION_DELETE_FRIEND");
        intent.putExtra("KEY_DELETE_FRIEND_UIN", friendUin);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    private final void da(String uin) {
        if (this.delFriendDialog == null) {
            if (Utils.G(uin)) {
                S9(uin);
            } else if (com.tencent.relation.common.config.toggle.c.I.g(false)) {
                V9(uin);
            } else {
                Y9(uin);
            }
            QQCustomDialog qQCustomDialog = this.delFriendDialog;
            if (qQCustomDialog != null) {
                qQCustomDialog.setTitleMutiLine();
            }
        }
        QQCustomDialog qQCustomDialog2 = this.delFriendDialog;
        if (qQCustomDialog2 == null || qQCustomDialog2.isShowing()) {
            return;
        }
        qQCustomDialog2.show();
        ReportController.o(z9(), "dc00898", "", "", "0X800C00A", "0X800C00A", 0, 0, "", "", "", "");
    }

    private final String ea() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        if (memberSettingUIModel.getIsHasInteraction()) {
            String qqStr = HardCodeUtil.qqStr(R.string.zli);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.chat_sett\u2026r_del_friend_dialog_tile)");
            return qqStr;
        }
        String qqStr2 = HardCodeUtil.qqStr(R.string.f175412yh);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.profile_c\u2026e_del_friend_dialog_tile)");
        return qqStr2;
    }

    private final void ga() {
        View inflate = View.inflate(getActivity(), R.layout.h6t, null);
        us2.b<View> bVar = new us2.b<>(inflate);
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.membersetting.part.x
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ag.ha(view);
            }
        });
        this.quitConfig = bVar;
        View findViewById = inflate.findViewById(R.id.f66713bd);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.biz.qui.quibutton.QUIButton");
        QUIButton qUIButton = (QUIButton) findViewById;
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.AllRound;
        Context context = qUIButton.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        qUIButton.setBackground(qUIListItemBackgroundType.getBackground(context, 1000));
        ViewGroup.LayoutParams layoutParams = qUIButton.getLayoutParams();
        layoutParams.height = qUIButton.getContext().getResources().getDimensionPixelSize(R.dimen.dar);
        qUIButton.setLayoutParams(layoutParams);
        qUIButton.setText(R.string.ak8);
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ag.ia(ag.this, view);
            }
        });
        this.quitBtn = qUIButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(ag this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MemberSettingUIModel memberSettingUIModel = this$0.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        AllInOne allInOne = memberSettingUIModel.getAllInOne();
        if (allInOne == null || (str = allInOne.uin) == null) {
            return;
        }
        this$0.da(str);
    }

    @Override // com.tencent.mobileqq.troop.membersetting.part.t
    /* renamed from: H9 */
    public Group[] getGroups() {
        us2.b<View> bVar = this.quitConfig;
        if (bVar != null) {
            return new Group[]{new Group(bVar)};
        }
        return new Group[0];
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.uiModel = C9().Q1();
        ga();
    }

    private final void ja(String uin, boolean haveCheckBox) {
        String str;
        int i3 = 0;
        int i16 = 1;
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (!haveCheckBox || this.isShieldFriend) {
                str = uin;
            } else {
                str = uin;
                i3 = 1;
            }
            ca(str, i3);
            AppInterface z95 = z9();
            if (haveCheckBox && !this.isShieldFriend) {
                i16 = 2;
            }
            ReportController.o(z95, "dc00898", "", "", "0X800C00B", "0X800C00B", i16, 0, "", "", "", "");
            MemberSettingUIModel memberSettingUIModel = this.uiModel;
            MemberSettingUIModel memberSettingUIModel2 = null;
            if (memberSettingUIModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel = null;
            }
            Intent resultIntent = memberSettingUIModel.getResultIntent();
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            resultIntent.putExtra("troopMemberCard", memberSettingUIModel3.getTroopMemberCard());
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            Intent resultIntent2 = memberSettingUIModel4.getResultIntent();
            MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
            if (memberSettingUIModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel5 = null;
            }
            resultIntent2.putExtra("remark", memberSettingUIModel5.getRemark());
            xs2.c cVar = xs2.c.f448459a;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
            if (memberSettingUIModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            } else {
                memberSettingUIModel2 = memberSettingUIModel6;
            }
            cVar.h(activity, memberSettingUIModel2.getResultIntent());
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.ajl, 0).show();
        }
        QQCustomDialog qQCustomDialog = this.delFriendDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }
}
