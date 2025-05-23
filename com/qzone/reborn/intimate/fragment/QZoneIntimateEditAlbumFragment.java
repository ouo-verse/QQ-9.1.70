package com.qzone.reborn.intimate.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditChangeCoverPart;
import com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditDescPart;
import com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditLoadingPart;
import com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditNamePart;
import com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditTitleBarPart;
import com.qzone.reborn.albumx.common.viewmodel.c;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.part.editalbum.QZoneEditAlbumDeletePart;
import com.qzone.reborn.intimate.part.editalbum.QZoneEditAlbumStickTopPart;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import l9.f;
import mqq.app.Constants;
import nk.ap;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZoneIntimateEditAlbumFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Ll9/f;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "te", "Lnk/ap;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()Lnk/ap;", "vm", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateEditAlbumFragment extends QZoneBaseFragment implements f {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy vm;

    public QZoneIntimateEditAlbumFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ap>() { // from class: com.qzone.reborn.intimate.fragment.QZoneIntimateEditAlbumFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ap invoke() {
                return (ap) QZoneIntimateEditAlbumFragment.this.getViewModel(ap.class);
            }
        });
        this.vm = lazy;
    }

    private final ap ph() {
        return (ap) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127460q;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ap ph5 = ph();
        FragmentActivity activity = getActivity();
        ph5.T1(activity != null ? activity.getIntent() : null);
        RFWIocAbilityProvider.g().registerIoc(view, this, f.class);
    }

    @Override // l9.f
    public c te() {
        ap vm5 = ph();
        Intrinsics.checkNotNullExpressionValue(vm5, "vm");
        return vm5;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new CommonAlbumEditTitleBarPart(), new CommonAlbumEditNamePart(), new CommonAlbumEditDescPart(), new CommonAlbumEditChangeCoverPart(), new QZoneEditAlbumStickTopPart(), new QZoneEditAlbumDeletePart(), new CommonAlbumEditLoadingPart());
        return mutableListOf;
    }
}
