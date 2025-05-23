package com.qzone.reborn.albumx.qzonex.part.invite;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.InviteJoinStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bf;
import wa.QZAlbumxParentFamilyBean;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/invite/QZAlbumxInviteBabyOperatePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Q9", "initData", "", ViewStickEventHelper.IS_SHOW, "Lab/a;", "rsp", "M9", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "", "L9", "roleId", "R9", "N9", "", "getLogTag", "onInitView", "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lnc/bf;", "d", "Lnc/bf;", "inviteViewModel", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "babyRoleContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "babyRoleTV", "Lwa/b;", tl.h.F, "Lwa/b;", "selectedFamilyBean", "i", "Landroid/view/View;", ParseCommon.CONTAINER, "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxInviteBabyOperatePart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bf inviteViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout babyRoleContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView babyRoleTV;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxParentFamilyBean selectedFamilyBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View container;

    private final int L9(CommonAlbumInfo albumInfo) {
        for (CommonClientAttr commonClientAttr : albumInfo.getShareAlbum().e()) {
            if (Intrinsics.areEqual(commonClientAttr.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), LoginData.getInstance().getUinString())) {
                return commonClientAttr.getAttr().getFamilyRole();
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(ab.a rsp) {
        R9(L9(rsp.getAlbumInfo()));
        RelativeLayout relativeLayout = this.babyRoleContainer;
        if (relativeLayout == null) {
            return;
        }
        bf bfVar = this.inviteViewModel;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        ab.a value = bfVar.c2().getValue();
        boolean z16 = false;
        if (value != null && value.getInviteStatus() == InviteJoinStatus.KINVITESTATUSPENDING.ordinal()) {
            z16 = true;
        }
        relativeLayout.setClickable(z16);
    }

    private final void N9() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QZAlbumxParentingSelectIdentityDialog qZAlbumxParentingSelectIdentityDialog = new QZAlbumxParentingSelectIdentityDialog(activity, this.selectedFamilyBean);
        qZAlbumxParentingSelectIdentityDialog.b0(new b());
        qZAlbumxParentingSelectIdentityDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R9(int roleId) {
        String c16 = com.qzone.reborn.albumx.qzonex.utils.b.f53400a.c(roleId);
        if (c16.length() == 0) {
            bf bfVar = this.inviteViewModel;
            bf bfVar2 = null;
            if (bfVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar = null;
            }
            ab.a value = bfVar.c2().getValue();
            if (value != null && value.getInviteStatus() == InviteJoinStatus.KINVITESTATUSPENDING.ordinal()) {
                bf bfVar3 = this.inviteViewModel;
                if (bfVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                } else {
                    bfVar2 = bfVar3;
                }
                if (!bfVar2.n2()) {
                    return;
                }
            }
            View view = this.container;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        TextView textView = this.babyRoleTV;
        if (textView == null) {
            return;
        }
        textView.setText(c16);
    }

    private final void initData() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        MutableLiveData<Integer> b26 = bfVar.b2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteBabyOperatePart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                TextView textView;
                textView = QZAlbumxInviteBabyOperatePart.this.babyRoleTV;
                if (textView == null) {
                    return;
                }
                com.qzone.reborn.albumx.qzonex.utils.b bVar = com.qzone.reborn.albumx.qzonex.utils.b.f53400a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                textView.setText(bVar.c(it.intValue()));
            }
        };
        b26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxInviteBabyOperatePart.O9(Function1.this, obj);
            }
        });
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar3;
        }
        MutableLiveData<ab.a> c26 = bfVar2.c2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<ab.a, Unit> function12 = new Function1<ab.a, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteBabyOperatePart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ab.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ab.a it) {
                boolean isShow;
                boolean isShow2;
                View view;
                View view2;
                isShow = QZAlbumxInviteBabyOperatePart.this.isShow();
                QLog.i("QZAlbumxInviteBabyOperatePart", 1, "getInfoRsp  isShow()=" + isShow);
                isShow2 = QZAlbumxInviteBabyOperatePart.this.isShow();
                if (isShow2) {
                    view2 = QZAlbumxInviteBabyOperatePart.this.container;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    QZAlbumxInviteBabyOperatePart qZAlbumxInviteBabyOperatePart = QZAlbumxInviteBabyOperatePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qZAlbumxInviteBabyOperatePart.M9(it);
                    return;
                }
                view = QZAlbumxInviteBabyOperatePart.this.container;
                if (view == null) {
                    return;
                }
                view.setVisibility(8);
            }
        };
        c26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxInviteBabyOperatePart.P9(Function1.this, obj);
            }
        });
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(bf.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxInviteViewModel::class.java)");
        this.inviteViewModel = (bf) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0.n2() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isShow() {
        CommonAlbumInfo albumInfo;
        bf bfVar = this.inviteViewModel;
        Integer num = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 1) {
            bf bfVar2 = this.inviteViewModel;
            if (bfVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar2 = null;
            }
            if (!bfVar2.o2()) {
                bf bfVar3 = this.inviteViewModel;
                if (bfVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar3 = null;
                }
            }
            com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
            bf bfVar4 = this.inviteViewModel;
            if (bfVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar4 = null;
            }
            ab.a value = bfVar4.c2().getValue();
            if (value != null && (albumInfo = value.getAlbumInfo()) != null) {
                num = Integer.valueOf(albumInfo.getQzAlbumType());
            }
            if (cVar.c(num) == 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxInviteBabyOperatePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f19134v) {
            N9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        Q9(rootView);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }

    private final void Q9(View rootView) {
        this.container = rootView != null ? rootView.findViewById(R.id.mho) : null;
        this.babyRoleContainer = rootView != null ? (RelativeLayout) rootView.findViewById(R.id.f19134v) : null;
        this.babyRoleTV = rootView != null ? (TextView) rootView.findViewById(R.id.f19124u) : null;
        RelativeLayout relativeLayout = this.babyRoleContainer;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/invite/QZAlbumxInviteBabyOperatePart$b", "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$b;", "", "onCancel", "Lwa/b;", "selectedBean", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZAlbumxParentingSelectIdentityDialog.b {
        b() {
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void a(QZAlbumxParentFamilyBean selectedBean) {
            QLog.i("QZAlbumxInviteBabyOperatePart", 1, "onConfirm  selectedFamilyBean=" + QZAlbumxInviteBabyOperatePart.this.selectedFamilyBean + ", afterSelectedBean=" + selectedBean);
            QZAlbumxInviteBabyOperatePart.this.selectedFamilyBean = selectedBean;
            QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean = QZAlbumxInviteBabyOperatePart.this.selectedFamilyBean;
            if (qZAlbumxParentFamilyBean != null) {
                int roleId = qZAlbumxParentFamilyBean.getRoleId();
                bf bfVar = QZAlbumxInviteBabyOperatePart.this.inviteViewModel;
                if (bfVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar = null;
                }
                bfVar.B2(roleId);
            }
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void onCancel() {
        }
    }
}
