package com.qzone.reborn.intimate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.part.QZIntimateActivateSpaceDialogPart;
import com.qzone.reborn.intimate.part.QZIntimateBadgeArkSharePart;
import com.qzone.reborn.intimate.part.QZIntimateBottomGuideBubblePart;
import com.qzone.reborn.intimate.part.QZIntimateLoverSpaceMigrationQueryPart;
import com.qzone.reborn.intimate.part.QZIntimateMainPageVisionResourcesPart;
import com.qzone.reborn.intimate.part.QZIntimatePunchDialogArkSharePart;
import com.qzone.reborn.intimate.part.QZIntimateSpaceAvatarAnimPart;
import com.qzone.reborn.intimate.part.QZIntimateSpaceLoveTreeEntrancePart;
import com.qzone.reborn.intimate.part.QZIntimateSpaceMenuViewPart;
import com.qzone.reborn.intimate.part.QZIntimateSpaceTitleSharePart;
import com.qzone.reborn.intimate.part.QZIntimateTitleMedalPart;
import com.qzone.reborn.intimate.part.QZoneIntimatePlusMenuPart;
import com.qzone.reborn.intimate.part.QZoneIntimateSpaceBadgeWallPart;
import com.qzone.reborn.intimate.part.QZoneIntimateSpaceCoverPart;
import com.qzone.reborn.intimate.part.QZoneIntimateSpaceMoreMenuPart;
import com.qzone.reborn.intimate.part.QZoneIntimateSpaceTransmitPart;
import com.qzone.reborn.intimate.part.ap;
import com.qzone.reborn.intimate.part.cg;
import com.qzone.reborn.intimate.part.cn;
import com.qzone.reborn.intimate.part.cs;
import com.qzone.reborn.intimate.part.o;
import com.qzone.reborn.intimate.part.q;
import com.qzone.reborn.intimate.part.vip.QZIntimateSpaceVipAvatarPart;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.state.report.SquareReportConst;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mk.d;
import mqq.app.Constants;
import nk.at;
import nk.b;
import qj.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u0015H\u0014J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u0015J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u0015H\u0014J\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u0015R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZoneIntimateSpaceMainFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lqj/m;", "Lcom/tencent/biz/richframework/part/Part;", "ph", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "assembleParts", "", "enableRootViewSetFitsSystemWindows", "fa", "W5", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "rh", "getChildDaTongDynamicParams", "qh", "Lnk/at;", BdhLogUtil.LogTag.Tag_Conn, "Lnk/at;", "mSpaceViewModel", "Lnk/b;", "D", "Lnk/b;", "checkInViewModel", "Lcom/google/android/material/appbar/AppBarLayout;", "E", "Lcom/google/android/material/appbar/AppBarLayout;", "mAppBarLayout", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "mIntiBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateSpaceMainFragment extends QZoneBaseFragment implements m {

    /* renamed from: C, reason: from kotlin metadata */
    private at mSpaceViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private b checkInViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private AppBarLayout mAppBarLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneIntimateMainPageInitBean mIntiBean;

    private final Part ph() {
        if (d.f416875a.K()) {
            return new o();
        }
        return new ap();
    }

    @Override // qj.m
    public void W5() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppBarLayout");
            appBarLayout = null;
        }
        appBarLayout.setExpanded(true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // qj.m
    public boolean fa() {
        return true;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        return qh();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        return rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cii;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_intimate_space_home";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = getViewModel(at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        at atVar = (at) viewModel;
        this.mSpaceViewModel = atVar;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        FragmentActivity activity = getActivity();
        atVar.d2(activity != null ? activity.getIntent() : null);
        ViewModel viewModel2 = getViewModel(b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZIntimateC\u2026kInViewModel::class.java)");
        b bVar = (b) viewModel2;
        this.checkInViewModel = bVar;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
            bVar = null;
        }
        FragmentActivity activity2 = getActivity();
        bVar.l2(activity2 != null ? activity2.getIntent() : null);
        View findViewById = view.findViewById(R.id.n5k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.q\u2026ate_space_app_bar_layout)");
        this.mAppBarLayout = (AppBarLayout) findViewById;
        FragmentActivity activity3 = getActivity();
        if (activity3 == null || (intent = activity3.getIntent()) == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean");
        this.mIntiBean = (QZoneIntimateMainPageInitBean) serializable;
    }

    public final Map<String, Object> qh() {
        String str;
        String str2;
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        at atVar = this.mSpaceViewModel;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        QZoneIntimateSpaceBean X1 = atVar.X1();
        if (X1 != null) {
            linkedHashMap.put("close_friend_space_type", Integer.valueOf(X1.getSpaceType()));
            if (X1.isMasterSpace()) {
                str = "0";
            } else {
                str = "1";
            }
            linkedHashMap.put("open_visit_state", str);
            QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = this.mIntiBean;
            if (qZoneIntimateMainPageInitBean == null || (str2 = qZoneIntimateMainPageInitBean.getAdId()) == null) {
                str2 = "";
            }
            linkedHashMap.put("operation_scheme_source_parameter", str2);
            Iterator<T> it = X1.getMembers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!ef.b.g((User) obj)) {
                    break;
                }
            }
            User user = (User) obj;
            if (user != null) {
                String str3 = user.uid;
                Intrinsics.checkNotNullExpressionValue(str3, "user.uid");
                linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str3);
                linkedHashMap.put("touin", Long.valueOf(user.uin));
            }
        }
        at atVar3 = this.mSpaceViewModel;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar3 = null;
        }
        linkedHashMap.put("is_intercept", Integer.valueOf(atVar3.getMIsIntercept()));
        at atVar4 = this.mSpaceViewModel;
        if (atVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
        } else {
            atVar2 = atVar4;
        }
        linkedHashMap.put("interception_cause", Long.valueOf(atVar2.getMInterceptionCause()));
        return linkedHashMap;
    }

    public final Map<String, Object> rh() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        at atVar = this.mSpaceViewModel;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        linkedHashMap.put("close_friend_space_id", atVar.getMSpaceId());
        at atVar3 = this.mSpaceViewModel;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
        } else {
            atVar2 = atVar3;
        }
        linkedHashMap.put("visit_src", atVar2.getMFrom());
        return linkedHashMap;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[23];
        partArr[0] = new QZIntimateMainPageVisionResourcesPart();
        partArr[1] = new QZIntimateLoverSpaceMigrationQueryPart();
        int i3 = 2;
        partArr[2] = new QZIntimateActivateSpaceDialogPart();
        partArr[3] = new cg();
        partArr[4] = new cs();
        partArr[5] = new QZIntimateTitleMedalPart();
        partArr[6] = new QZIntimateSpaceTitleSharePart();
        partArr[7] = new QZoneIntimateSpaceCoverPart();
        partArr[8] = new QZIntimateSpaceAvatarAnimPart();
        partArr[9] = new QZIntimateSpaceMenuViewPart();
        at atVar = this.mSpaceViewModel;
        String str = null;
        byte b16 = 0;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        partArr[10] = new QZoneIntimateSpaceTransmitPart(atVar.getMSpaceId(), str, i3, b16 == true ? 1 : 0);
        partArr[11] = new QZoneIntimateSpaceMoreMenuPart();
        partArr[12] = new q();
        partArr[13] = new QZIntimateSpaceLoveTreeEntrancePart();
        partArr[14] = new QZoneIntimatePlusMenuPart();
        partArr[15] = new QZoneIntimateSpaceBadgeWallPart();
        partArr[16] = new cn();
        partArr[17] = ph();
        partArr[18] = new s9.a();
        partArr[19] = new QZIntimatePunchDialogArkSharePart();
        partArr[20] = new QZIntimateBadgeArkSharePart();
        partArr[21] = new QZIntimateBottomGuideBubblePart();
        partArr[22] = new QZIntimateSpaceVipAvatarPart();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }
}
