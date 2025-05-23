package com.qzone.reborn.albumx.qzonex.part.invite;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.nativeinterface.InviteJoinStatus;
import com.tencent.qqnt.kernel.nativeinterface.JoinApprovalStatus;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bf;
import wa.QZAlbumxParentFamilyBean;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/invite/QZAlbumxInviteBottomPart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "X9", "initData", "", ViewStickEventHelper.IS_SHOW, "S9", "P9", "", "roleId", "ga", "ha", "ba", "ea", "ca", "aa", "Z9", "da", "Q9", "R9", "T9", "N9", "", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lnc/bf;", "d", "Lnc/bf;", "inviteViewModel", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "e", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "joinBtn", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tipsTV", tl.h.F, "I", "selectedId", "i", "Landroid/view/View;", ParseCommon.CONTAINER, "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxInviteBottomPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bf inviteViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIButton joinBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tipsTV;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int selectedId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View container;

    private final void N9() {
        if (this.joinBtn == null) {
            return;
        }
        fo.c.o(this.joinBtn, "em_qz_middle_btn", new fo.b().h(new IDynamicParams() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.i
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map O9;
                O9 = QZAlbumxInviteBottomPart.O9(QZAlbumxInviteBottomPart.this, str);
                return O9;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map O9(QZAlbumxInviteBottomPart this$0, String str) {
        String str2;
        CharSequence text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        QUIButton qUIButton = this$0.joinBtn;
        if (qUIButton == null || (text = qUIButton.getText()) == null || (str2 = text.toString()) == null) {
            str2 = "";
        }
        linkedHashMap.put(ProfileCardBlacklistReportConst.ELEM_PARAM_BUTTON_TEXT_CONTENT, str2);
        return linkedHashMap;
    }

    private final void P9() {
        if (ca()) {
            Q9();
            return;
        }
        if (aa() || Z9()) {
            return;
        }
        if (da()) {
            R9();
        } else if (ea()) {
            T9();
        } else {
            Q9();
        }
    }

    private final void Q9() {
        bf bfVar = this.inviteViewModel;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        bfVar.p2(this.selectedId);
    }

    private final void R9() {
        bf bfVar = this.inviteViewModel;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bfVar.s2(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        ha();
        N9();
    }

    private final void T9() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QZAlbumxParentingSelectIdentityDialog qZAlbumxParentingSelectIdentityDialog = new QZAlbumxParentingSelectIdentityDialog(activity, null);
        qZAlbumxParentingSelectIdentityDialog.b0(new b());
        qZAlbumxParentingSelectIdentityDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QZAlbumxInviteBottomPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean Z9() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 0) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar3 = null;
            }
            if (bfVar3.o2()) {
                bf bfVar4 = this.inviteViewModel;
                if (bfVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar4 = null;
                }
                ab.a value = bfVar4.c2().getValue();
                if (value != null && value.getApprovalStatus() == JoinApprovalStatus.KAPPROVALSTATUSPENDING.ordinal()) {
                    return true;
                }
            }
        }
        bf bfVar5 = this.inviteViewModel;
        if (bfVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar5 = null;
        }
        if (!bfVar5.n2()) {
            bf bfVar6 = this.inviteViewModel;
            if (bfVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar6 = null;
            }
            if (!bfVar6.o2()) {
                bf bfVar7 = this.inviteViewModel;
                if (bfVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar7 = null;
                }
                ab.a value2 = bfVar7.c2().getValue();
                if (value2 != null && value2.getLoginUserStatus() == 2) {
                    return true;
                }
            }
        }
        bf bfVar8 = this.inviteViewModel;
        if (bfVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar8;
        }
        Integer value3 = bfVar2.h2().getValue();
        return value3 != null && value3.intValue() == 2;
    }

    private final boolean aa() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() != 0) {
            return false;
        }
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar3 = null;
        }
        if (!bfVar3.o2()) {
            return false;
        }
        bf bfVar4 = this.inviteViewModel;
        if (bfVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar4;
        }
        ab.a value = bfVar2.c2().getValue();
        return value != null && value.getApprovalStatus() == JoinApprovalStatus.KAPPROVALSTATUSREJECTED.ordinal();
    }

    private final boolean ba() {
        CommonAlbumInfo albumInfo;
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() != 1) {
            return false;
        }
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar3 = null;
        }
        ab.a value = bfVar3.c2().getValue();
        if (cVar.c((value == null || (albumInfo = value.getAlbumInfo()) == null) ? null : Integer.valueOf(albumInfo.getQzAlbumType())) != 2) {
            return false;
        }
        bf bfVar4 = this.inviteViewModel;
        if (bfVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar4 = null;
        }
        if (!bfVar4.o2()) {
            return false;
        }
        bf bfVar5 = this.inviteViewModel;
        if (bfVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar5;
        }
        ab.a value2 = bfVar2.c2().getValue();
        return (value2 != null && value2.getInviteStatus() == InviteJoinStatus.KINVITESTATUSPENDING.ordinal()) && this.selectedId <= 0;
    }

    private final boolean ca() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() != 1) {
            return false;
        }
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar3 = null;
        }
        if (!bfVar3.o2()) {
            return false;
        }
        bf bfVar4 = this.inviteViewModel;
        if (bfVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar4 = null;
        }
        ab.a value = bfVar4.c2().getValue();
        if (!(value != null && value.getInviteStatus() == InviteJoinStatus.KINVITESTATUSPENDING.ordinal())) {
            return false;
        }
        bf bfVar5 = this.inviteViewModel;
        if (bfVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar5;
        }
        Integer value2 = bfVar2.h2().getValue();
        return value2 == null || value2.intValue() != 3;
    }

    private final boolean da() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 1) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar3 = null;
            }
            if (bfVar3.n2()) {
                return true;
            }
        }
        bf bfVar4 = this.inviteViewModel;
        if (bfVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar4 = null;
        }
        if (bfVar4.g2().getPageType() == 0) {
            bf bfVar5 = this.inviteViewModel;
            if (bfVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar5 = null;
            }
            if (bfVar5.o2()) {
                bf bfVar6 = this.inviteViewModel;
                if (bfVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar6 = null;
                }
                ab.a value = bfVar6.c2().getValue();
                if (value != null && value.getApprovalStatus() == JoinApprovalStatus.KAPPROVALSTATUSPASSED.ordinal()) {
                    return true;
                }
            }
        }
        bf bfVar7 = this.inviteViewModel;
        if (bfVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar7 = null;
        }
        if (bfVar7.g2().getPageType() == 1) {
            bf bfVar8 = this.inviteViewModel;
            if (bfVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar8 = null;
            }
            if (bfVar8.o2()) {
                bf bfVar9 = this.inviteViewModel;
                if (bfVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar9 = null;
                }
                ab.a value2 = bfVar9.c2().getValue();
                if (value2 != null && value2.getInviteStatus() == InviteJoinStatus.KINVITESTATUSPASSED.ordinal()) {
                    return true;
                }
            }
        }
        bf bfVar10 = this.inviteViewModel;
        if (bfVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar10 = null;
        }
        if (!bfVar10.n2()) {
            bf bfVar11 = this.inviteViewModel;
            if (bfVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar11 = null;
            }
            if (!bfVar11.o2()) {
                bf bfVar12 = this.inviteViewModel;
                if (bfVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar12 = null;
                }
                ab.a value3 = bfVar12.c2().getValue();
                if (value3 != null && value3.getLoginUserStatus() == 3) {
                    return true;
                }
            }
        }
        bf bfVar13 = this.inviteViewModel;
        if (bfVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar13;
        }
        Integer value4 = bfVar2.h2().getValue();
        return value4 != null && value4.intValue() == 3;
    }

    private final boolean ea() {
        CommonAlbumInfo albumInfo;
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        ab.a value = bfVar.c2().getValue();
        if (cVar.c((value == null || (albumInfo = value.getAlbumInfo()) == null) ? null : Integer.valueOf(albumInfo.getQzAlbumType())) != 2) {
            return false;
        }
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar3 = null;
        }
        if (!bfVar3.o2()) {
            bf bfVar4 = this.inviteViewModel;
            if (bfVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            } else {
                bfVar2 = bfVar4;
            }
            if (!bfVar2.n2()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga(int roleId) {
        QUIButton qUIButton;
        QUIButton qUIButton2;
        this.selectedId = roleId;
        if (roleId <= 0) {
            return;
        }
        QUIButton qUIButton3 = this.joinBtn;
        boolean z16 = false;
        if ((qUIButton3 != null && (qUIButton3.isClickable() ^ true)) && (qUIButton2 = this.joinBtn) != null) {
            qUIButton2.setClickable(true);
        }
        if (this.joinBtn != null && (!r3.isEnabled())) {
            z16 = true;
        }
        if (!z16 || (qUIButton = this.joinBtn) == null) {
            return;
        }
        qUIButton.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha() {
        if (ba()) {
            QUIButton qUIButton = this.joinBtn;
            if (qUIButton != null) {
                qUIButton.setClickable(false);
            }
            QUIButton qUIButton2 = this.joinBtn;
            if (qUIButton2 != null) {
                qUIButton2.setEnabled(false);
            }
            QUIButton qUIButton3 = this.joinBtn;
            if (qUIButton3 != null) {
                qUIButton3.setText(com.qzone.util.l.a(R.string.jfb));
            }
        } else if (ca()) {
            QUIButton qUIButton4 = this.joinBtn;
            if (qUIButton4 != null) {
                qUIButton4.setText(com.qzone.util.l.a(R.string.jfb));
            }
        } else if (aa()) {
            QUIButton qUIButton5 = this.joinBtn;
            if (qUIButton5 != null) {
                qUIButton5.setVisibility(8);
            }
            TextView textView = this.tipsTV;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.tipsTV;
            if (textView2 != null) {
                textView2.setText(com.qzone.util.l.a(R.string.f134338j));
            }
        } else if (Z9()) {
            QUIButton qUIButton6 = this.joinBtn;
            if (qUIButton6 != null) {
                qUIButton6.setClickable(false);
            }
            QUIButton qUIButton7 = this.joinBtn;
            if (qUIButton7 != null) {
                qUIButton7.setEnabled(false);
            }
            QUIButton qUIButton8 = this.joinBtn;
            if (qUIButton8 != null) {
                qUIButton8.setText(com.qzone.util.l.a(R.string.f134388o));
            }
        } else if (da()) {
            QUIButton qUIButton9 = this.joinBtn;
            if (qUIButton9 != null) {
                qUIButton9.setText(com.qzone.util.l.a(R.string.jfc));
            }
        } else {
            QUIButton qUIButton10 = this.joinBtn;
            if (qUIButton10 != null) {
                qUIButton10.setText(com.qzone.util.l.a(R.string.f134348k));
            }
        }
        QUIButton qUIButton11 = this.joinBtn;
        QLog.i("QZAlbumxInviteBottomPart", 2, "btn text:" + ((Object) (qUIButton11 != null ? qUIButton11.getText() : null)));
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
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteBottomPart$initData$1
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
                QZAlbumxInviteBottomPart qZAlbumxInviteBottomPart = QZAlbumxInviteBottomPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZAlbumxInviteBottomPart.ga(it.intValue());
            }
        };
        b26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxInviteBottomPart.U9(Function1.this, obj);
            }
        });
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar3 = null;
        }
        MutableLiveData<Integer> h26 = bfVar3.h2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteBottomPart$initData$2
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
            public final void invoke2(Integer num) {
                QZAlbumxInviteBottomPart.this.ha();
            }
        };
        h26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxInviteBottomPart.V9(Function1.this, obj);
            }
        });
        bf bfVar4 = this.inviteViewModel;
        if (bfVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar4;
        }
        MutableLiveData<ab.a> c26 = bfVar2.c2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<ab.a, Unit> function13 = new Function1<ab.a, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteBottomPart$initData$3
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
            public final void invoke2(ab.a aVar) {
                boolean isShow;
                boolean isShow2;
                View view;
                View view2;
                isShow = QZAlbumxInviteBottomPart.this.isShow();
                QLog.i("QZAlbumxInviteBottomPart", 1, "getInfoRsp  isShow()=" + isShow);
                isShow2 = QZAlbumxInviteBottomPart.this.isShow();
                if (isShow2) {
                    view2 = QZAlbumxInviteBottomPart.this.container;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    QZAlbumxInviteBottomPart.this.S9();
                    return;
                }
                view = QZAlbumxInviteBottomPart.this.container;
                if (view == null) {
                    return;
                }
                view.setVisibility(8);
            }
        };
        c26.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxInviteBottomPart.W9(Function1.this, obj);
            }
        });
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(bf.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxInviteViewModel::class.java)");
        this.inviteViewModel = (bf) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isShow() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 0) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            } else {
                bfVar2 = bfVar3;
            }
            if (bfVar2.n2()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxInviteBottomPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        X9(rootView);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }

    private final void X9(View rootView) {
        this.container = rootView != null ? rootView.findViewById(R.id.kr9) : null;
        this.joinBtn = rootView != null ? (QUIButton) rootView.findViewById(R.id.lxp) : null;
        this.tipsTV = rootView != null ? (TextView) rootView.findViewById(R.id.kr7) : null;
        QUIButton qUIButton = this.joinBtn;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxInviteBottomPart.Y9(QZAlbumxInviteBottomPart.this, view);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/invite/QZAlbumxInviteBottomPart$b", "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$b;", "", "onCancel", "Lwa/b;", "selectedBean", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZAlbumxParentingSelectIdentityDialog.b {
        b() {
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void a(QZAlbumxParentFamilyBean selectedBean) {
            QLog.i("QZAlbumxInviteBottomPart", 1, "onConfirm  selectedBean=" + selectedBean);
            if (selectedBean != null) {
                bf bfVar = QZAlbumxInviteBottomPart.this.inviteViewModel;
                if (bfVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar = null;
                }
                bfVar.p2(selectedBean.getRoleId());
            }
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void onCancel() {
        }
    }
}
