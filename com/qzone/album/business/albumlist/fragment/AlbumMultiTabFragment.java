package com.qzone.album.business.albumlist.fragment;

import androidx.fragment.app.Fragment;
import com.qzone.album.business.albumlist.part.QZoneAlbumListMultiTabPart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/album/business/albumlist/fragment/AlbumMultiTabFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lcom/qzone/album/business/albumlist/fragment/d;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "update", "", "counter", "", "I6", "Landroidx/fragment/app/Fragment;", "fragment", "isSelected", "Lcom/qzone/album/business/albumlist/fragment/e;", "ioc", "Y4", "onWindowFocusChanged", "Lcom/qzone/album/business/albumlist/part/QZoneAlbumListMultiTabPart;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/album/business/albumlist/part/QZoneAlbumListMultiTabPart;", "ph", "()Lcom/qzone/album/business/albumlist/part/QZoneAlbumListMultiTabPart;", "setMAlbumListMultiTabPart", "(Lcom/qzone/album/business/albumlist/part/QZoneAlbumListMultiTabPart;)V", "mAlbumListMultiTabPart", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class AlbumMultiTabFragment extends QZoneBaseFragment implements d {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneAlbumListMultiTabPart mAlbumListMultiTabPart = new QZoneAlbumListMultiTabPart();

    @Override // com.qzone.album.business.albumlist.fragment.d
    public boolean I6(long counter) {
        QZoneAlbumListMultiTabPart qZoneAlbumListMultiTabPart = this.mAlbumListMultiTabPart;
        if (qZoneAlbumListMultiTabPart != null) {
            return qZoneAlbumListMultiTabPart.I6(counter);
        }
        return false;
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void Y4(Fragment fragment, boolean isSelected, e ioc) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        QZoneAlbumListMultiTabPart qZoneAlbumListMultiTabPart = this.mAlbumListMultiTabPart;
        if (qZoneAlbumListMultiTabPart != null) {
            qZoneAlbumListMultiTabPart.Y4(fragment, isSelected, ioc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cj5;
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void onWindowFocusChanged() {
        QZoneAlbumListMultiTabPart qZoneAlbumListMultiTabPart = this.mAlbumListMultiTabPart;
        if (qZoneAlbumListMultiTabPart != null) {
            qZoneAlbumListMultiTabPart.onWindowFocusChanged();
        }
    }

    /* renamed from: ph, reason: from getter */
    public final QZoneAlbumListMultiTabPart getMAlbumListMultiTabPart() {
        return this.mAlbumListMultiTabPart;
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void update() {
        QZoneAlbumListMultiTabPart qZoneAlbumListMultiTabPart = this.mAlbumListMultiTabPart;
        if (qZoneAlbumListMultiTabPart != null) {
            qZoneAlbumListMultiTabPart.update();
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        QZoneAlbumListMultiTabPart qZoneAlbumListMultiTabPart = this.mAlbumListMultiTabPart;
        Intrinsics.checkNotNull(qZoneAlbumListMultiTabPart, "null cannot be cast to non-null type com.tencent.biz.richframework.part.Part");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(qZoneAlbumListMultiTabPart);
        return mutableListOf;
    }
}
