package com.qzone.reborn.intimate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.viewmodel.b;
import com.qzone.reborn.albumx.common.viewmodel.e;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.part.albumDetail.QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart;
import com.qzone.reborn.intimate.part.albumDetail.g;
import com.qzone.reborn.intimate.part.albumDetail.i;
import com.qzone.reborn.intimate.part.albumDetail.o;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l9.c;
import mqq.app.Constants;
import nk.aa;
import nk.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZoneIntimateAlbumBatchDownloadFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Ll9/c;", "", "ph", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "enableRootViewSetFitsSystemWindows", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "Ne", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "qf", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumBatchDownloadFragment extends QZoneBaseFragment implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneIntimateAlbumDetailInitBean initBean;

    private final void ph() {
        Intent intent;
        if (this.initBean == null) {
            FragmentActivity activity = getActivity();
            Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
            this.initBean = serializableExtra instanceof QZoneIntimateAlbumDetailInitBean ? (QZoneIntimateAlbumDetailInitBean) serializableExtra : null;
        }
    }

    @Override // l9.c
    public b Ne() {
        ViewModel viewModel = getViewModel(w.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026ailViewModel::class.java)");
        return (b) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cie;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ph();
        b Ne = Ne();
        Intrinsics.checkNotNull(Ne, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateAlbumDetailViewModel");
        ((w) Ne).m2(getActivity());
        RFWIocAbilityProvider.g().registerIoc(view, this, c.class);
    }

    @Override // l9.c
    public e qf() {
        ViewModel viewModel = getViewModel(aa.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026ateViewModel::class.java)");
        return (e) viewModel;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.qzone.reborn.intimate.part.albumDetail.e(), new i(), new g(), new o(), new QZoneIntimateAlbumBatchDownloadBottomOperateBannerPart());
        return mutableListOf;
    }
}
