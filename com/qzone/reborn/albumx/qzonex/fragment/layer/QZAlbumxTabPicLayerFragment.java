package com.qzone.reborn.albumx.qzonex.fragment.layer;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import bb.i;
import com.qzone.reborn.albumx.qzonex.part.layer.ah;
import com.qzone.reborn.albumx.qzonex.part.layer.p;
import com.qzone.reborn.albumx.qzonex.part.layer.t;
import com.qzone.reborn.layer.part.bc;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import jc.d;
import kotlin.Metadata;
import mqq.app.Constants;
import oc.a;
import oc.x;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/layer/QZAlbumxTabPicLayerFragment;", "Lcom/qzone/reborn/albumx/qzonex/fragment/layer/QZAlbumxLayerBaseFragment;", "Lbb/i;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Loc/a;", "E", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "th", "Ljc/d;", "uh", "Loc/x;", "H", "Loc/x;", "tabPicLayerViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxTabPicLayerFragment extends QZAlbumxLayerBaseFragment<i> {

    /* renamed from: H, reason: from kotlin metadata */
    private x tabPicLayerViewModel;

    @Override // hb.c
    public a<i> E() {
        return this.tabPicLayerViewModel;
    }

    @Override // com.qzone.reborn.albumx.qzonex.fragment.layer.QZAlbumxLayerBaseFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new ah());
        assembleParts.add(new t());
        assembleParts.add(new p());
        assembleParts.add(new bc(10));
        return assembleParts;
    }

    @Override // com.qzone.reborn.albumx.qzonex.fragment.layer.QZAlbumxLayerBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        x xVar;
        Intent intent;
        super.onCreate(savedInstanceState);
        this.tabPicLayerViewModel = (x) getViewModel(x.class);
        FragmentActivity activity = getActivity();
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        boolean z16 = false;
        if (extras != null && extras.containsKey("key_data_repo_key")) {
            z16 = true;
        }
        if (z16) {
            fj.a aVar = fj.a.f399444a;
            Object obj = extras.get("key_data_repo_key");
            if (obj == null) {
                obj = "";
            }
            Object a16 = aVar.a((String) obj);
            if (!(a16 instanceof ub.p) || (xVar = this.tabPicLayerViewModel) == null) {
                return;
            }
            xVar.c2((ub.p) a16);
        }
    }

    @Override // com.qzone.reborn.albumx.qzonex.fragment.layer.QZAlbumxLayerBaseFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 7;
    }

    @Override // com.qzone.reborn.albumx.qzonex.fragment.layer.QZAlbumxLayerBaseFragment
    public d uh() {
        x xVar = this.tabPicLayerViewModel;
        return new d(xVar != null ? xVar.getDataRepo() : null);
    }
}
