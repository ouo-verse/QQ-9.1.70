package ac;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.e;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxTaskDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends x9.b {

    /* renamed from: i, reason: collision with root package name */
    private QZAlbumxTaskDetailInitBean f25790i;

    /* JADX WARN: Multi-variable type inference failed */
    private void w(View view) {
        QLog.d(getTAG(), 1, "[handleDeleteClick] ");
        kc.b.INSTANCE.a().e(((e) this.mData).getStateData().getUrl());
    }

    private void x() {
        if (p() == null || p().getIntent() == null) {
            return;
        }
        this.f25790i = (QZAlbumxTaskDetailInitBean) p().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x9.b, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumDownloadQueueDeleteSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.mgv) {
            this.f447487e.g();
            w(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x9.b, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(e eVar, int i3, List<Object> list) {
        String str;
        kc.b a16 = kc.b.INSTANCE.a();
        QZAlbumxTaskDetailInitBean qZAlbumxTaskDetailInitBean = this.f25790i;
        if (qZAlbumxTaskDetailInitBean != null) {
            str = qZAlbumxTaskDetailInitBean.getAlbumId();
        } else {
            str = "";
        }
        int i16 = a16.i(str);
        if (i16 > 0) {
            v(i3, i16);
        } else {
            QLog.e(getTAG(), 1, "[onBindData] data list is empty");
        }
    }
}
