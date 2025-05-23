package com.qzone.reborn.groupalbum.layer.fragment;

import android.os.Bundle;
import com.qzone.reborn.groupalbum.layer.part.k;
import com.qzone.reborn.groupalbum.layer.part.r;
import com.qzone.reborn.groupalbum.layer.part.u;
import com.tencent.biz.richframework.part.Part;
import ii.a;
import ii.e;
import java.util.List;
import kotlin.Metadata;
import mqq.app.Constants;
import p9.b;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/fragment/GroupAlbumFeedLayerFragment;", "Lcom/qzone/reborn/groupalbum/layer/fragment/GroupAlbumLayerBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lii/a;", "E", "", "th", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lp9/b;", "vh", "Lii/e;", "H", "Lii/e;", "feedLayerViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumFeedLayerFragment extends GroupAlbumLayerBaseFragment {

    /* renamed from: H, reason: from kotlin metadata */
    private e feedLayerViewModel;

    @Override // ai.c
    public a E() {
        return this.feedLayerViewModel;
    }

    @Override // com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLayerBaseFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new k());
        assembleParts.add(new u());
        assembleParts.add(new r());
        return assembleParts;
    }

    @Override // com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLayerBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.feedLayerViewModel = (e) getViewModel(e.class);
    }

    @Override // com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLayerBaseFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 3;
    }

    @Override // com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLayerBaseFragment
    public b vh() {
        b vh5 = super.vh();
        vh5.b(false);
        return vh5;
    }
}
