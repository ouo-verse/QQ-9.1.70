package com.tencent.mobileqq.troop.membersetting.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import ys2.MemberSettingUIModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R.\u0010\u0018\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/bk;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "", "J9", "L9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lys2/a;", "e", "Lys2/a;", "uiModel", "f", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "i", "Lcom/tencent/mobileqq/widget/listitem/x;", "qzonePrivacyConfig", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class bk extends t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberSettingUIModel uiModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Group[] groups = new Group[0];

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<?, ?> qzonePrivacyConfig;

    private final void J9() {
        String qqStr = HardCodeUtil.qqStr(R.string.f1319928);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(\n                R\u2026qzone_permission_setting)");
        com.tencent.mobileqq.widget.listitem.x<?, ?> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(qqStr), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.bj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bk.K9(bk.this, view);
            }
        });
        this.configList.add(xVar);
        this.qzonePrivacyConfig = xVar;
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        this.groups = new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(bk this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
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
        J9();
    }

    private final void L9() {
        String str;
        try {
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            MemberSettingUIModel memberSettingUIModel = this.uiModel;
            MemberSettingUIModel memberSettingUIModel2 = null;
            if (memberSettingUIModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel = null;
            }
            userInfo.nickname = memberSettingUIModel.getCurrentNick();
            MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
            if (memberSettingUIModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel3 = null;
            }
            AllInOne allInOne = memberSettingUIModel3.getAllInOne();
            if (allInOne != null && (str = allInOne.uin) != null) {
                QZoneHelper.forwardToSinglePermissionSetting(getActivity(), userInfo, Long.parseLong(str), -1);
            }
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            AllInOne allInOne2 = memberSettingUIModel4.getAllInOne();
            if (allInOne2 != null) {
                AppInterface z95 = z9();
                int profileEntryType = ProfileEntryUtils.getProfileEntryType(allInOne2.profileEntryType);
                MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
                if (memberSettingUIModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                } else {
                    memberSettingUIModel2 = memberSettingUIModel5;
                }
                ReportController.o(z95, "CliOper", "", "", "P_prof", "Pp_more_qzone", profileEntryType, 0, String.valueOf(ProfileEntryUtils.getIdentityFlag(memberSettingUIModel2.getAllInOne())), "", "", "");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MemberSettingQzonePrivacyPart", 1, e16.toString());
            }
        }
    }
}
