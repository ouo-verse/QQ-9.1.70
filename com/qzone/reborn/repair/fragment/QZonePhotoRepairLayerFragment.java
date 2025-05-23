package com.qzone.reborn.repair.fragment;

import com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment;
import com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerBeginPart;
import com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerCompletePart;
import com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerControlPart;
import com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerLoadingPart;
import com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerOprLoadingPart;
import com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerUploadPart;
import com.qzone.reborn.repair.part.layer.ac;
import com.qzone.reborn.repair.part.layer.ah;
import com.qzone.reborn.repair.part.layer.ak;
import com.qzone.reborn.repair.part.layer.j;
import com.qzone.reborn.repair.part.layer.m;
import com.qzone.reborn.repair.part.layer.p;
import com.qzone.reborn.repair.part.layer.q;
import com.qzone.reborn.repair.part.layer.s;
import com.qzone.reborn.repair.part.layer.z;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/repair/fragment/QZonePhotoRepairLayerFragment;", "Lcom/qzone/reborn/layer/fragment/QZoneLayerBaseFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getMediaStrategyPart", "getPlayScene", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZonePhotoRepairLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new m());
        arrayList.addAll(super.assembleParts());
        arrayList.add(new QZonePhotoRepairLayerControlPart());
        arrayList.add(new s());
        arrayList.add(new ah());
        arrayList.add(new QZonePhotoRepairLayerBeginPart());
        arrayList.add(new j());
        arrayList.add(new QZonePhotoRepairLayerLoadingPart());
        arrayList.add(new QZonePhotoRepairLayerCompletePart());
        arrayList.add(new z());
        arrayList.add(new ac());
        arrayList.add(new QZonePhotoRepairLayerUploadPart());
        arrayList.add(new q());
        arrayList.add(new p());
        arrayList.add(new QZonePhotoRepairLayerOprLoadingPart());
        return arrayList;
    }

    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment
    public Part getMediaStrategyPart() {
        return new ak();
    }

    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 151;
    }
}
