package com.qzone.reborn.intimate.fragment;

import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.part.albumDetail.o;
import com.qzone.reborn.intimate.part.albumselectcover.QZoneAlbumSelectCoverBodyPart;
import com.qzone.reborn.intimate.part.albumselectcover.c;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZoneIntimateAlbumSelectCoverFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "needAdjustImmersive", "isUseDarkTextStatusBar", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumSelectCoverFragment extends QZoneBaseFragment {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cj6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return true;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new c(), new QZoneAlbumSelectCoverBodyPart(), new o());
        return mutableListOf;
    }
}
