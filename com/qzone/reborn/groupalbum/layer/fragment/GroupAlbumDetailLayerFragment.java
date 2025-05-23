package com.qzone.reborn.groupalbum.layer.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.layer.part.h;
import com.qzone.reborn.groupalbum.layer.part.r;
import com.qzone.reborn.groupalbum.layer.part.u;
import com.tencent.biz.richframework.part.Part;
import hi.c;
import ii.a;
import ii.b;
import java.util.List;
import ki.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/fragment/GroupAlbumDetailLayerFragment;", "Lcom/qzone/reborn/groupalbum/layer/fragment/GroupAlbumLayerBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lii/a;", "E", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "th", "Lhi/c;", "uh", "Lii/b;", "H", "Lii/b;", "albumDetailLayerViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumDetailLayerFragment extends GroupAlbumLayerBaseFragment {

    /* renamed from: H, reason: from kotlin metadata */
    private b albumDetailLayerViewModel;

    @Override // ai.c
    public a E() {
        return this.albumDetailLayerViewModel;
    }

    @Override // com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLayerBaseFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new h());
        assembleParts.add(new u());
        assembleParts.add(new r());
        return assembleParts;
    }

    @Override // com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLayerBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        b bVar;
        GroupAlbumAlbumDetailInitBean d26;
        b bVar2;
        Intent intent;
        super.onCreate(savedInstanceState);
        this.albumDetailLayerViewModel = (b) getViewModel(b.class);
        FragmentActivity activity = getActivity();
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        boolean z16 = false;
        if (extras != null && extras.containsKey("key_album_detail_init_bean")) {
            z16 = true;
        }
        if (z16 && (bVar2 = this.albumDetailLayerViewModel) != null) {
            Object obj = extras.get("key_album_detail_init_bean");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean");
            bVar2.h2((GroupAlbumAlbumDetailInitBean) obj);
        }
        fj.a aVar = fj.a.f399444a;
        b bVar3 = this.albumDetailLayerViewModel;
        if (bVar3 == null || (d26 = bVar3.d2()) == null || (str = d26.getDataRepoKey()) == null) {
            str = "";
        }
        Object a16 = aVar.a(str);
        if (!(a16 instanceof g) || (bVar = this.albumDetailLayerViewModel) == null) {
            return;
        }
        bVar.g2((g) a16);
    }

    @Override // com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLayerBaseFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 4;
    }

    @Override // com.qzone.reborn.groupalbum.layer.fragment.GroupAlbumLayerBaseFragment
    public c uh() {
        b bVar = this.albumDetailLayerViewModel;
        return new c(bVar != null ? bVar.getDataRepo() : null);
    }
}
