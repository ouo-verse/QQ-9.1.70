package com.qzone.reborn.feedpro.layer.fragment;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment;
import com.qzone.reborn.feedpro.layer.part.g;
import com.qzone.reborn.feedpro.layer.part.o;
import com.qzone.reborn.feedpro.layer.part.p;
import com.qzone.reborn.feedpro.layer.part.q;
import com.qzone.reborn.feedpro.layer.part.t;
import com.tencent.biz.richframework.part.Part;
import ge.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/fragment/QzoneFeedProBaseLayerFragment;", "Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "Lcom/tencent/biz/richframework/part/Part;", "sh", "", "getDaTongPageId", "", "th", "getPlayScene", "", "assembleParts", "rh", "Lge/f;", "uh", "Lp9/a;", "vh", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneFeedProBaseLayerFragment extends CommonLayerFragment {
    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new p());
        arrayList.add(new q());
        arrayList.add(new g(vh()));
        return arrayList;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public String getDaTongPageId() {
        return "pg_qz_dynamic_floating_layer";
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 175;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part rh() {
        return new o();
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part sh() {
        return new t(uh());
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 9;
    }

    public f uh() {
        return new f();
    }

    protected a vh() {
        return new a();
    }
}
