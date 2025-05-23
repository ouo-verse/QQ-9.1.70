package com.qzone.reborn.groupalbum.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class v extends com.qzone.reborn.albumx.common.part.o implements com.qzone.reborn.groupalbum.reship.manager.b {

    /* renamed from: i, reason: collision with root package name */
    private GroupAlbumTaskDetailInitBean f56838i;

    private void G9() {
        F9(GroupAlbumReshipSendBoxManager.f56848a.n(this.f56838i.getGroupId()));
    }

    @Override // com.qzone.reborn.groupalbum.reship.manager.b
    public void H5(List<IQueueTask> list) {
        F9(list);
    }

    @Override // com.qzone.reborn.albumx.common.part.o, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        GroupAlbumReshipSendBoxManager.f56848a.i(this.f56838i.getGroupId(), this);
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        this.f56838i = (GroupAlbumTaskDetailInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        GroupAlbumReshipSendBoxManager.f56848a.v(this.f56838i.getGroupId(), this);
    }
}
