package com.qzone.reborn.groupalbum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.albumx.common.part.selectalbum.e;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.upload.selectalbum.h;
import com.qzone.reborn.groupalbum.upload.selectalbum.j;
import com.qzone.reborn.groupalbum.upload.selectalbum.k;
import com.qzone.reborn.groupalbum.upload.selectalbum.n;
import com.tencent.ams.dsdk.core.DKEngine;
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

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupUploadSelectAlbumFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/qzone/reborn/groupalbum/upload/selectalbum/n;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()Lcom/qzone/reborn/groupalbum/upload/selectalbum/n;", "vm", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupUploadSelectAlbumFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy vm;

    public GroupUploadSelectAlbumFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<n>() { // from class: com.qzone.reborn.groupalbum.fragment.GroupUploadSelectAlbumFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final n invoke() {
                return (n) GroupUploadSelectAlbumFragment.this.getViewModel(n.class);
            }
        });
        this.vm = lazy;
    }

    private final n ph() {
        return (n) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ckj;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        n ph5 = ph();
        Intent intent = requireActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
        ph5.c2(intent);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.qzone.reborn.groupalbum.upload.selectalbum.a(), new e(), new k(), new h(), new j());
        return mutableListOf;
    }
}
