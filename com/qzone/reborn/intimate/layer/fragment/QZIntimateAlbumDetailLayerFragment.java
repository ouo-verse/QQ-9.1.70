package com.qzone.reborn.intimate.layer.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tj.k;
import tj.p;
import tj.r;
import vj.c;
import wj.a;
import wj.d;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/intimate/layer/fragment/QZIntimateAlbumDetailLayerFragment;", "Lcom/qzone/reborn/intimate/layer/fragment/QZIntimateBaseLayerFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "th", "Lwj/d;", "E", "Lwj/a;", UserInfo.SEX_FEMALE, "Lwj/a;", "layerViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateAlbumDetailLayerFragment extends QZIntimateBaseLayerFragment {

    /* renamed from: F, reason: from kotlin metadata */
    private a layerViewModel;

    @Override // qj.a
    public d E() {
        return this.layerViewModel;
    }

    @Override // com.qzone.reborn.intimate.layer.fragment.QZIntimateBaseLayerFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new tj.a());
        assembleParts.add(new tj.d());
        assembleParts.add(new k());
        assembleParts.add(new r());
        int scene = getInitBean().getScene();
        a aVar = this.layerViewModel;
        assembleParts.add(new p(scene, aVar != null ? aVar.getDataRepo() : null));
        return assembleParts;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        a aVar;
        QZoneIntimateAlbumDetailInitBean d26;
        a aVar2;
        Intent intent;
        super.onCreate(savedInstanceState);
        this.layerViewModel = (a) getViewModel(a.class);
        FragmentActivity activity = getActivity();
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        boolean z16 = false;
        if (extras != null && extras.containsKey("key_album_detail_init_bean")) {
            z16 = true;
        }
        if (z16 && (aVar2 = this.layerViewModel) != null) {
            Object obj = extras.get("key_album_detail_init_bean");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean");
            aVar2.h2((QZoneIntimateAlbumDetailInitBean) obj);
        }
        fj.a aVar3 = fj.a.f399444a;
        a aVar4 = this.layerViewModel;
        if (aVar4 == null || (d26 = aVar4.d2()) == null || (str = d26.getDataRepoKey()) == null) {
            str = "";
        }
        Object a16 = aVar3.a(str);
        if (!(a16 instanceof c) || (aVar = this.layerViewModel) == null) {
            return;
        }
        aVar.g2((c) a16);
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 0;
    }
}
