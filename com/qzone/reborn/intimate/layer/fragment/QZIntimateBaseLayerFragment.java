package com.qzone.reborn.intimate.layer.fragment;

import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import p9.b;
import qj.a;
import tj.g;
import tj.l;
import tj.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/intimate/layer/fragment/QZIntimateBaseLayerFragment;", "Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "Lqj/a;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getDaTongPageId", "sh", "rh", "Lp9/b;", "uh", "", "", "getChildDaTongDynamicParams", "", "getPlayScene", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZIntimateBaseLayerFragment extends CommonLayerFragment implements a {
    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new g());
        return assembleParts;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public Map<String, Object> getChildDaTongDynamicParams() {
        return super.getChildDaTongDynamicParams();
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public String getDaTongPageId() {
        return "pg_qz_superposed_layer";
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 150;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RFWIocAbilityProvider.g().registerIoc(view, this, a.class);
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part rh() {
        return new l();
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part sh() {
        return new s(uh());
    }

    public b uh() {
        return new b();
    }
}
