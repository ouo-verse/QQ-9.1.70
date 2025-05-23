package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateTaskDetailInitBean;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bq extends com.qzone.reborn.albumx.common.part.n {
    private QZoneIntimateTaskDetailInitBean D;

    @Override // com.qzone.reborn.albumx.common.part.n
    protected String F9() {
        return this.D.getAlbumId();
    }

    @Override // com.qzone.reborn.albumx.common.part.n
    protected com.qzone.reborn.albumx.common.viewmodel.k G9() {
        return (com.qzone.reborn.albumx.common.viewmodel.k) getViewModel(nk.az.class);
    }

    @Override // com.qzone.reborn.albumx.common.part.n
    protected String H9() {
        return this.D.getSpaceId();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        this.D = (QZoneIntimateTaskDetailInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }
}
