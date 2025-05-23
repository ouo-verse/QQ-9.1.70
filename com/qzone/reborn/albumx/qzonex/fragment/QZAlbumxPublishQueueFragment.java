package com.qzone.reborn.albumx.qzonex.fragment;

import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxPublishQueueFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getContentLayoutId", "", "getDaTongPageId", "", "setUserVisibleHint", "", "isVisibleToUser", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxPublishQueueFragment extends QZoneBaseFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(QZAlbumxPublishQueueFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.registerDaTongReportPageId();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new sb.c());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cke;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected String getDaTongPageId() {
        return "pg_qz_outbox";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        QLog.d(getTAG(), 1, "[setUserVisibleHint]: " + isVisibleToUser);
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.fragment.e
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxPublishQueueFragment.qh(QZAlbumxPublishQueueFragment.this);
            }
        }, 200L);
    }
}
