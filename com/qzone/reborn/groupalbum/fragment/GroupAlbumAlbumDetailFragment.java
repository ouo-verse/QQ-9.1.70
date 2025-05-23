package com.qzone.reborn.groupalbum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.viewmodel.b;
import com.qzone.reborn.albumx.common.viewmodel.e;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.part.GroupAlbumTransmitPart;
import com.qzone.reborn.groupalbum.part.albumdetail.GroupAlbumAlbumDetailOperatePanelPart;
import com.qzone.reborn.groupalbum.part.albumdetail.GroupAlbumAlbumDetailPlusMenuPart;
import com.qzone.reborn.groupalbum.part.albumdetail.i;
import com.qzone.reborn.groupalbum.part.albumdetail.u;
import com.qzone.reborn.groupalbum.viewmodel.h;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l9.c;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0006\u0010\f\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\rH\u0014J\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupAlbumAlbumDetailFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Ll9/c;", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "ph", "", "enableRootViewSetFitsSystemWindows", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "Ne", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "qf", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumAlbumDetailFragment extends QZoneBaseFragment implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private GroupAlbumAlbumDetailInitBean initBean;

    @Override // l9.c
    public b Ne() {
        ViewModel viewModel = getViewModel(com.qzone.reborn.groupalbum.viewmodel.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumA\u2026ailViewModel::class.java)");
        return (b) viewModel;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ph();
        ArrayList arrayList = new ArrayList();
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        String groupId = groupAlbumAlbumDetailInitBean != null ? groupAlbumAlbumDetailInitBean.getGroupId() : null;
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean2 = this.initBean;
        arrayList.add(new GroupAlbumTransmitPart(groupId, groupAlbumAlbumDetailInitBean2 != null ? groupAlbumAlbumDetailInitBean2.getAlbumId() : null, 20));
        arrayList.add(new u());
        arrayList.add(new com.qzone.reborn.groupalbum.part.albumdetail.c());
        arrayList.add(new com.qzone.reborn.groupalbum.part.albumdetail.a());
        arrayList.add(new i());
        arrayList.add(new GroupAlbumAlbumDetailPlusMenuPart(this.initBean));
        arrayList.add(new GroupAlbumAlbumDetailOperatePanelPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        if (groupAlbumAlbumDetailInitBean != null) {
            linkedHashMap.put("group_uin", groupAlbumAlbumDetailInitBean.getGroupId());
            linkedHashMap.put("albumid", groupAlbumAlbumDetailInitBean.getAlbumId());
            linkedHashMap.put("album_name", groupAlbumAlbumDetailInitBean.getAlbumName());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127711e;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_group_album_details";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            fj.a aVar = fj.a.f399444a;
            GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
            String albumId = groupAlbumAlbumDetailInitBean != null ? groupAlbumAlbumDetailInitBean.getAlbumId() : null;
            aVar.b(albumId + hashCode());
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ph();
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        if (groupAlbumAlbumDetailInitBean != null) {
            b Ne = Ne();
            Intrinsics.checkNotNull(Ne, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.viewmodel.GroupAlbumAlbumDetailViewModel");
            com.qzone.reborn.groupalbum.viewmodel.b bVar = (com.qzone.reborn.groupalbum.viewmodel.b) Ne;
            bVar.n2(groupAlbumAlbumDetailInitBean);
            bVar.m2(groupAlbumAlbumDetailInitBean.getAlbumId() + hashCode());
            fj.a.f399444a.c(groupAlbumAlbumDetailInitBean.getAlbumId() + hashCode(), bVar.getDataRepo());
        }
        RFWIocAbilityProvider.g().registerIoc(view, this, c.class);
    }

    public final void ph() {
        Intent intent;
        if (this.initBean == null) {
            FragmentActivity activity = getActivity();
            Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
            this.initBean = serializableExtra instanceof GroupAlbumAlbumDetailInitBean ? (GroupAlbumAlbumDetailInitBean) serializableExtra : null;
        }
    }

    @Override // l9.c
    public e qf() {
        ViewModel viewModel = getViewModel(h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumA\u2026ateViewModel::class.java)");
        return (e) viewModel;
    }
}
