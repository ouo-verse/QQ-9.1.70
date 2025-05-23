package com.qzone.reborn.repair.fragment;

import ao.c;
import ao.e;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.repair.part.layer.p;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/repair/fragment/QZonePhotoRepairTaskListFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getContentLayoutId", "", "getDaTongPageId", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZonePhotoRepairTaskListFragment extends QZoneBaseFragment {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167315cn4;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected String getDaTongPageId() {
        return "pg_qz_pic_recent_task";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new e(), new c(), new p());
        return mutableListOf;
    }
}
