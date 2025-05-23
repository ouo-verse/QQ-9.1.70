package com.qzone.reborn.feedx.fragment;

import com.qzone.reborn.feedx.block.QZoneMessageBoardBlock;
import com.qzone.reborn.feedx.block.ab;
import com.qzone.reborn.feedx.block.ad;
import com.qzone.reborn.feedx.block.ag;
import com.qzone.reborn.feedx.block.ah;
import com.qzone.reborn.feedx.block.k;
import com.qzone.reborn.feedx.widget.header.bj;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/feedx/fragment/QZoneFeedxDIYUserHomeFragment;", "Lcom/qzone/reborn/feedx/fragment/QZoneFeedxUserHomeFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "buildBlockList", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneFeedxDIYUserHomeFragment extends QZoneFeedxUserHomeFragment {
    @Override // com.qzone.reborn.feedx.fragment.QZoneFeedxUserHomeFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new bj());
        return assembleParts;
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFeedxUserHomeFragment
    public List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        Fh(new com.qzone.reborn.feedx.block.c(null));
        arrayList.add(uh());
        Jh(new ah(null));
        arrayList.add(yh());
        Dh(new ad(null));
        arrayList.add(sh());
        Ih(new QZoneMessageBoardBlock(null));
        arrayList.add(xh());
        Ch(new k(null));
        rh().setBlockVisible(false);
        arrayList.add(rh());
        Hh(new ab(null));
        wh().setBlockVisible(false);
        arrayList.add(wh());
        Eh(new ag(null));
        arrayList.add(th());
        return arrayList;
    }
}
