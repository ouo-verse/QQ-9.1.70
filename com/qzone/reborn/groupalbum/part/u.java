package com.qzone.reborn.groupalbum.part;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.qzone.reborn.groupalbum.viewmodel.an;

/* compiled from: P */
/* loaded from: classes37.dex */
public class u extends com.qzone.reborn.albumx.common.part.n {
    private GroupAlbumTaskDetailInitBean D;

    @Override // com.qzone.reborn.albumx.common.part.n
    protected String F9() {
        return this.D.getAlbumId();
    }

    @Override // com.qzone.reborn.albumx.common.part.n
    protected com.qzone.reborn.albumx.common.viewmodel.k G9() {
        return (com.qzone.reborn.albumx.common.viewmodel.k) getViewModel(an.class);
    }

    @Override // com.qzone.reborn.albumx.common.part.n
    protected String H9() {
        return this.D.getGroupId();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        this.D = (GroupAlbumTaskDetailInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }
}
