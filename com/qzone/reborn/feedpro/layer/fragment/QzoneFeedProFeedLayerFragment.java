package com.qzone.reborn.feedpro.layer.fragment;

import android.os.Bundle;
import com.qzone.reborn.feedpro.layer.part.d;
import com.qzone.reborn.feedpro.layer.part.f;
import com.qzone.reborn.feedpro.layer.part.j;
import com.qzone.reborn.feedpro.layer.part.s;
import com.qzone.reborn.feedpro.layer.part.v;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import java.util.ArrayList;
import java.util.List;
import ke.c;
import kotlin.Metadata;
import mqq.app.Constants;
import re.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/fragment/QzoneFeedProFeedLayerFragment;", "Lcom/qzone/reborn/feedpro/layer/fragment/QzoneFeedProBaseLayerFragment;", "", "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lge/f;", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lke/c;", "G", "Lke/c;", "layerViewModel", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProFeedLayerFragment extends QzoneFeedProBaseLayerFragment {

    /* renamed from: G, reason: from kotlin metadata */
    private c layerViewModel;

    @Override // com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProBaseLayerFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new f());
        arrayList.add(new d());
        arrayList.add(new j());
        arrayList.add(new s());
        arrayList.add(new v());
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.b());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, a.class));
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.layerViewModel = (c) getViewModel(c.class);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SceneTracker.f258213d.traceEnd("QzoneFeedProFeedLayerFragment");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SceneTracker.f258213d.m("QzoneFeedProFeedLayerFragment");
    }

    @Override // com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProBaseLayerFragment
    public ge.f uh() {
        ge.f fVar = new ge.f();
        fVar.e(1);
        return fVar;
    }
}
