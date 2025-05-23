package com.qzone.reborn.groupalbum.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.part.GroupAlbumTransmitPart;
import com.qzone.reborn.groupalbum.part.c;
import com.qzone.reborn.groupalbum.part.j;
import com.qzone.reborn.groupalbum.part.m;
import com.qzone.reborn.groupalbum.part.myalbum.b;
import com.qzone.reborn.groupalbum.part.t;
import com.qzone.reborn.groupalbum.viewmodel.aj;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupAlbumMainFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "enableRootViewSetFitsSystemWindows", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "ph", "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", "mTabViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumMainFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private aj mTabViewModel;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        return ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127861t;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_group_dynamic_tab";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = getViewModel(aj.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumM\u2026TabViewModel::class.java)");
        aj ajVar = (aj) viewModel;
        this.mTabViewModel = ajVar;
        if (ajVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar = null;
        }
        FragmentActivity activity = getActivity();
        ajVar.S1(activity != null ? activity.getIntent() : null);
    }

    public final Map<String, Object> ph() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        aj ajVar = this.mTabViewModel;
        aj ajVar2 = null;
        if (ajVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar = null;
        }
        linkedHashMap.put("group_uin", ajVar.P1().getGroupId());
        aj ajVar3 = this.mTabViewModel;
        if (ajVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
        } else {
            ajVar2 = ajVar3;
        }
        linkedHashMap.put("come_from", Integer.valueOf(ajVar2.P1().getFrom()));
        return linkedHashMap;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[7];
        partArr[0] = new m();
        partArr[1] = new j();
        partArr[2] = new t();
        partArr[3] = new com.qzone.reborn.groupalbum.part.a();
        aj ajVar = this.mTabViewModel;
        if (ajVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar = null;
        }
        partArr[4] = new GroupAlbumTransmitPart(ajVar.P1().getGroupId(), null, 24);
        aj ajVar2 = this.mTabViewModel;
        if (ajVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar2 = null;
        }
        partArr[5] = new b(ajVar2.P1().getGroupId(), null);
        partArr[6] = new c();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }
}
