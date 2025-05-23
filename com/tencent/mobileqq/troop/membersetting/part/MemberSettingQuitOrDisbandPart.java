package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ys2.MemberSettingUIModel;
import zs2.a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J0\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/MemberSettingQuitOrDisbandPart;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "", "aa", "Y9", "", "normalMemberDel", "R9", "U9", "isSuccess", "", "errorCode", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "Z9", "ea", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lys2/a;", "e", "Lys2/a;", "uiModel", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "f", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "quitBtn", "Lus2/b;", tl.h.F, "Lus2/b;", "quitConfig", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "i", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "da", "()Z", "ha", "(Z)V", "isChecked", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class MemberSettingQuitOrDisbandPart extends t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIButton quitBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private us2.b<View> quitConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQCustomDialog dialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isChecked;

    private final void R9(final boolean normalMemberDel) {
        this.dialog = DialogUtil.createCustomDialog(getActivity(), 0, getContext().getResources().getString(R.string.c0g), "", R.string.f1311902, R.string.f131440q, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.bh
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingQuitOrDisbandPart.S9(MemberSettingQuitOrDisbandPart.this, normalMemberDel, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.bi
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingQuitOrDisbandPart.T9(MemberSettingQuitOrDisbandPart.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(MemberSettingQuitOrDisbandPart this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0.getPartHost()), null, null, new MemberSettingQuitOrDisbandPart$createDelTroopMemberDialogNoCheckBox$1$1(this$0, z16, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(MemberSettingQuitOrDisbandPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog qQCustomDialog = this$0.dialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    private final void U9(final boolean normalMemberDel) {
        String string = getContext().getResources().getString(R.string.f132272z);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026.refuse_join_troop_again)");
        String string2 = getContext().getResources().getString(R.string.f1311902);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getString(R.string.cancel)");
        String string3 = getContext().getResources().getString(R.string.f131440q);
        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getString(R.string.ok)");
        String string4 = getContext().getResources().getString(R.string.c0g);
        Intrinsics.checkNotNullExpressionValue(string4, "context.resources.getStr\u2026.string.kick_out_confirm)");
        this.isChecked = false;
        this.dialog = DialogUtil.createDialogWithCheckBox(getActivity(), 0, string4, "", string, this.isChecked, string2, string3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.be
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingQuitOrDisbandPart.V9(MemberSettingQuitOrDisbandPart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.bf
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingQuitOrDisbandPart.W9(MemberSettingQuitOrDisbandPart.this, normalMemberDel, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.bg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MemberSettingQuitOrDisbandPart.X9(MemberSettingQuitOrDisbandPart.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(MemberSettingQuitOrDisbandPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isChecked = i3 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(MemberSettingQuitOrDisbandPart this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0.getPartHost()), null, null, new MemberSettingQuitOrDisbandPart$createNoBabyDelTroopMemberDialog$2$1(this$0, z16, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(MemberSettingQuitOrDisbandPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog qQCustomDialog = this$0.dialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if ((r3 != null && r3.allowMemberKick == 1) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
    
        if (r0.intValue() != 3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        if (r0.intValue() != 2) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void aa() {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        QUIButton qUIButton = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel.getTroopMemberCard();
        Integer valueOf = troopMemberCard != null ? Integer.valueOf(troopMemberCard.memberRole) : null;
        ITroopListRepoApi iTroopListRepoApi = (ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class);
        MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
        if (memberSettingUIModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel2 = null;
        }
        TroopInfo troopInfoFromCache = iTroopListRepoApi.getTroopInfoFromCache(memberSettingUIModel2.getTroopUin());
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        boolean z16 = true;
        if (memberSettingUIModel3.getMyRole() != 3) {
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            if (memberSettingUIModel4.getMyRole() != 2) {
            }
            if (valueOf != null) {
            }
            if (valueOf != null) {
            }
        }
        if (z16) {
            if (valueOf != null && valueOf.intValue() == 0) {
                return;
            }
            this.uiModel = C9().Q1();
            View btnWrapper = View.inflate(getActivity(), R.layout.h6t, null);
            Intrinsics.checkNotNullExpressionValue(btnWrapper, "btnWrapper");
            us2.b<View> bVar = new us2.b<>(btnWrapper);
            this.quitConfig = bVar;
            bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.membersetting.part.bc
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    MemberSettingQuitOrDisbandPart.ba(view);
                }
            });
            View findViewById = btnWrapper.findViewById(R.id.f66713bd);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.biz.qui.quibutton.QUIButton");
            QUIButton qUIButton2 = (QUIButton) findViewById;
            this.quitBtn = qUIButton2;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
                qUIButton2 = null;
            }
            QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.AllRound;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qUIButton2.setBackground(qUIListItemBackgroundType.getBackground(context, 1000));
            QUIButton qUIButton3 = this.quitBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
                qUIButton3 = null;
            }
            ViewGroup.LayoutParams layoutParams = qUIButton3.getLayoutParams();
            layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.dar);
            QUIButton qUIButton4 = this.quitBtn;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
                qUIButton4 = null;
            }
            qUIButton4.setLayoutParams(layoutParams);
            QUIButton qUIButton5 = this.quitBtn;
            if (qUIButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
                qUIButton5 = null;
            }
            qUIButton5.setText(R.string.f132072f);
            QUIButton qUIButton6 = this.quitBtn;
            if (qUIButton6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
            } else {
                qUIButton = qUIButton6;
            }
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.bd
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberSettingQuitOrDisbandPart.ca(MemberSettingQuitOrDisbandPart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(MemberSettingQuitOrDisbandPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y9();
    }

    private final void ea() {
        MutableLiveData<zs2.a> obtainUiState = C9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<zs2.a, Unit> function1 = new Function1<zs2.a, Unit>() { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingQuitOrDisbandPart$observeUiState$1
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
                if (aVar instanceof a.DeleteTroopMemberUpdate) {
                    a.DeleteTroopMemberUpdate deleteTroopMemberUpdate = (a.DeleteTroopMemberUpdate) aVar;
                    MemberSettingQuitOrDisbandPart.this.Z9(deleteTroopMemberUpdate.getIsSuccess(), deleteTroopMemberUpdate.getErrorCode(), deleteTroopMemberUpdate.b());
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.membersetting.part.bb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemberSettingQuitOrDisbandPart.ga(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    /* renamed from: da, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void ha(boolean z16) {
        this.isChecked = z16;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.uiModel = C9().Q1();
        aa();
        ea();
    }

    private final void Y9() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("MemberSettingQuitOrDisbandPart", 2, " delTroopMember");
        }
        ITroopListRepoApi iTroopListRepoApi = (ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class);
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        MemberSettingUIModel memberSettingUIModel2 = null;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        TroopInfo troopInfoFromCache = iTroopListRepoApi.getTroopInfoFromCache(memberSettingUIModel.getTroopUin());
        boolean z16 = true;
        if (troopInfoFromCache != null && (troopInfoFromCache.isOwnerOrAdmin() || troopInfoFromCache.allowMemberKick != 1)) {
            z16 = false;
        }
        if (z16) {
            R9(z16);
        } else {
            U9(z16);
        }
        QQCustomDialog qQCustomDialog = this.dialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.show();
        }
        xs2.c cVar = xs2.c.f448459a;
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel3 = null;
        }
        String d16 = cVar.d(memberSettingUIModel3.getMyRole());
        if (this.isChecked) {
            str = "0";
        } else {
            str = "1";
        }
        String str2 = str;
        AppInterface z95 = z9();
        MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
        if (memberSettingUIModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel4 = null;
        }
        ReportController.o(z95, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 0, 0, memberSettingUIModel4.getTroopUin(), d16, str2, "");
        AppInterface z96 = z9();
        MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
        if (memberSettingUIModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel5 = null;
        }
        String troopUin = memberSettingUIModel5.getTroopUin();
        MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
        if (memberSettingUIModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel2 = memberSettingUIModel6;
        }
        ReportController.o(z96, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_movegrp", 0, 0, troopUin, cVar.d(memberSettingUIModel2.getMyRole()), "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(boolean isSuccess, int errorCode, ArrayList<String> uinList) {
        QUIButton qUIButton = null;
        MemberSettingUIModel memberSettingUIModel = null;
        if (!isSuccess) {
            if (errorCode != 2) {
                if (errorCode != 3) {
                    QQToast.makeText(getContext(), 1, R.string.f132082g, 0).show();
                    return;
                } else {
                    QQToast.makeText(getContext(), 1, R.string.f1319120, 0).show();
                    return;
                }
            }
            QQToast.makeText(getContext(), 1, R.string.f132062e, 0).show();
            QUIButton qUIButton2 = this.quitBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
            } else {
                qUIButton = qUIButton2;
            }
            qUIButton.setVisibility(8);
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f132092h, 0).show();
        xs2.c cVar = xs2.c.f448459a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
        if (memberSettingUIModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel2 = null;
        }
        cVar.b(activity, memberSettingUIModel2.getResultIntent());
        Intent intent = new Intent("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
        MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
        if (memberSettingUIModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel = memberSettingUIModel3;
        }
        intent.putExtra("troopUin", memberSettingUIModel.getTroopUin());
        intent.putExtra("delMemberUins", uinList);
        BaseApplication.getContext().sendBroadcast(intent);
    }
}
