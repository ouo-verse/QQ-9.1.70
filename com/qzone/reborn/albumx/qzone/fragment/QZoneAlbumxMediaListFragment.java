package com.qzone.reborn.albumx.qzone.fragment;

import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBodyPart;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBottomOperatePart;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListTitlePart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/fragment/QZoneAlbumxMediaListFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "", "getLogTag", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxMediaListFragment extends QZoneBaseFragment {
    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneAlbumxMediaListTitlePart());
        arrayList.add(new QZoneAlbumxMediaListBodyPart());
        arrayList.add(new QZoneAlbumxMediaListBottomOperatePart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f129014x;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxMediaListFragment";
    }
}
