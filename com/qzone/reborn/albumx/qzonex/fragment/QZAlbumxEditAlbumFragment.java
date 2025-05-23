package com.qzone.reborn.albumx.qzonex.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditLoadingPart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAlbumDeletePart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAlbumTypePart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditAutoJoinPart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditBabyBirthPart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditLoverTimePart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditPermissionsPart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditStickTopPart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditTitleBarPart;
import com.qzone.reborn.albumx.qzonex.part.editalbum.n;
import com.qzone.reborn.albumx.qzonex.part.editalbum.o;
import com.qzone.reborn.albumx.qzonex.part.editalbum.r;
import com.qzone.reborn.base.QZoneBaseFragment;
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
import mqq.app.Constants;
import nc.au;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014R#\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxEditAlbumFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Ll9/f;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "te", "", "getDaTongPageId", "Lnc/au;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()Lnc/au;", "vm", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxEditAlbumFragment extends QZoneBaseFragment implements l9.f {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy vm;

    public QZAlbumxEditAlbumFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<au>() { // from class: com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxEditAlbumFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final au invoke() {
                return (au) QZAlbumxEditAlbumFragment.this.getViewModel(au.class);
            }
        });
        this.vm = lazy;
    }

    private final au ph() {
        return (au) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128824e;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_album_edit";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        au ph5 = ph();
        FragmentActivity activity = getActivity();
        ph5.T1(activity != null ? activity.getIntent() : null);
        RFWIocAbilityProvider.g().registerIoc(view, this, l9.f.class);
    }

    @Override // l9.f
    public com.qzone.reborn.albumx.common.viewmodel.c te() {
        au vm5 = ph();
        Intrinsics.checkNotNullExpressionValue(vm5, "vm");
        return vm5;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QZAlbumxEditTitleBarPart(), new r(), new o(), new n(), new QZAlbumxEditStickTopPart(), new CommonAlbumEditLoadingPart(), new QZAlbumxEditAlbumDeletePart(), new QZAlbumxEditPermissionsPart(), new QZAlbumxEditAlbumTypePart(), new QZAlbumxEditLoverTimePart(), new QZAlbumxEditBabyBirthPart(), new QZAlbumxEditAutoJoinPart());
        return mutableListOf;
    }
}
