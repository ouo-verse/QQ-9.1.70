package ac;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.e;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxTaskDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends x9.a {
    private QZAlbumxTaskDetailInitBean D;

    /* JADX WARN: Multi-variable type inference failed */
    private void A(View view) {
        QLog.d(getTAG(), 1, "[handleOpeIconClick] ");
        T t16 = this.mData;
        if (t16 == 0) {
            return;
        }
        if (v((e) t16)) {
            kc.b.INSTANCE.a().g(((e) this.mData).getStateData().getUrl());
        } else if (w((e) this.mData)) {
            kc.b.INSTANCE.a().o(((e) this.mData).getStateData().getUrl());
        }
    }

    private void B() {
        if (p() == null || p().getIntent() == null) {
            return;
        }
        this.D = (QZAlbumxTaskDetailInitBean) p().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxDownloadQueueContentSection";
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean z16) {
        super.onAttachedChanged(z16);
        if (this.D != null) {
            if (z16) {
                kc.b.INSTANCE.a().r(this.D.getUin(), this);
            } else {
                kc.b.INSTANCE.a().s(this.D.getUin(), this);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.ngm) {
            A(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        if (this.D != null) {
            kc.b.INSTANCE.a().s(this.D.getUin(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x9.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        B();
    }
}
