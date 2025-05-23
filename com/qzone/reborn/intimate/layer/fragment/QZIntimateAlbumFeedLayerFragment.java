package com.qzone.reborn.intimate.layer.fragment;

import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import kotlin.Metadata;
import mqq.app.Constants;
import tj.b;
import tj.k;
import tj.r;
import wj.c;
import wj.d;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/intimate/layer/fragment/QZIntimateAlbumFeedLayerFragment;", "Lcom/qzone/reborn/intimate/layer/fragment/QZIntimateBaseLayerFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "th", "Lwj/d;", "E", "Lwj/c;", UserInfo.SEX_FEMALE, "Lwj/c;", "layerViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateAlbumFeedLayerFragment extends QZIntimateBaseLayerFragment {

    /* renamed from: F, reason: from kotlin metadata */
    private c layerViewModel;

    @Override // qj.a
    public d E() {
        return this.layerViewModel;
    }

    @Override // com.qzone.reborn.intimate.layer.fragment.QZIntimateBaseLayerFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new b());
        assembleParts.add(new tj.d());
        assembleParts.add(new k());
        assembleParts.add(new r());
        return assembleParts;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.layerViewModel = (c) getViewModel(c.class);
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 1;
    }
}
