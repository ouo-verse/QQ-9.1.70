package com.qzone.reborn.groupalbum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.block.GroupAlbumAlbumListHeaderAdapter;
import com.qzone.reborn.groupalbum.part.albumlist.GroupAlbumAlbumListOperatePart;
import com.qzone.reborn.groupalbum.part.albumlist.k;
import com.qzone.reborn.groupalbum.viewmodel.g;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupAlbumAlbumListFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "Lcom/qzone/reborn/groupalbum/viewmodel/g;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/viewmodel/g;", "mAlbumListViewModel", "Lcom/qzone/reborn/groupalbum/part/albumlist/g;", "D", "Lcom/qzone/reborn/groupalbum/part/albumlist/g;", "mBlockPart", "E", "Ljava/lang/Integer;", "albumNum", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumAlbumListFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private g mAlbumListViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.groupalbum.part.albumlist.g mBlockPart;

    /* renamed from: E, reason: from kotlin metadata */
    private Integer albumNum;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new k());
        com.qzone.reborn.groupalbum.part.albumlist.g gVar = new com.qzone.reborn.groupalbum.part.albumlist.g();
        this.mBlockPart = gVar;
        arrayList.add(gVar);
        arrayList.add(new GroupAlbumAlbumListOperatePart(getTabReportPageId()));
        return arrayList;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        g gVar = null;
        if (this.albumNum == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("albums_number", String.valueOf(this.albumNum));
        g gVar2 = this.mAlbumListViewModel;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListViewModel");
        } else {
            gVar = gVar2;
        }
        hashMap.put("group_uin", gVar.T1());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127741h;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        return "pg_qz_group_album_tab";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = getViewModel(g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumA\u2026istViewModel::class.java)");
        this.mAlbumListViewModel = (g) viewModel;
        FragmentActivity activity = getActivity();
        g gVar = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            g gVar2 = this.mAlbumListViewModel;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumListViewModel");
                gVar2 = null;
            }
            gVar2.d2(intent);
        }
        g gVar3 = this.mAlbumListViewModel;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListViewModel");
        } else {
            gVar = gVar3;
        }
        MutableLiveData<GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean> W1 = gVar.W1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean, Unit> function1 = new Function1<GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean, Unit>() { // from class: com.qzone.reborn.groupalbum.fragment.GroupAlbumAlbumListFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean groupAlbumHeadInfoBean) {
                invoke2(groupAlbumHeadInfoBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean groupAlbumHeadInfoBean) {
                GroupAlbumAlbumListFragment.this.albumNum = Integer.valueOf(groupAlbumHeadInfoBean.getAlbumNum());
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumAlbumListFragment.rh(Function1.this, obj);
            }
        });
    }
}
