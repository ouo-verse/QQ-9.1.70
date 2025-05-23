package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment;
import com.qzone.reborn.layer.part.cc;
import com.qzone.reborn.layer.part.cg;
import com.qzone.reborn.layer.part.ci;
import com.qzone.reborn.layer.part.ck;
import com.qzone.reborn.layer.part.co;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import eo.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/layer/fragment/QZoneLocalLayerFragment;", "Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getMediaStrategyPart", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "sh", "", "th", "getPlayScene", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneLocalLayerFragment extends CommonLayerFragment {
    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new cc());
        assembleParts.add(new ck());
        assembleParts.add(new cg());
        assembleParts.add(new ci());
        return assembleParts;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public String getDaTongPageId() {
        return "pg_qz_view_before_publish";
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment
    public Part getMediaStrategyPart() {
        return new co();
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 146;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part sh() {
        return null;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return -1;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, c.f396879a.c()));
        return mutableMapOf;
    }
}
