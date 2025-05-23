package og;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.b;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gf.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00032\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Log/c;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b;", "", "P", "M", "", "k", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "N", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "getMTianShuAd", "()Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "setMTianShuAd", "(Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;)V", "mTianShuAd", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends com.qzone.reborn.feedx.presenter.ad.basepresenter.b {

    /* renamed from: N, reason: from kotlin metadata */
    private QZoneAdTianshuFeedData mTianShuAd;

    private final void P() {
        if (getMInteractOperateIoc() == null) {
            N((h) j(h.class));
        }
        h mInteractOperateIoc = getMInteractOperateIoc();
        if (mInteractOperateIoc != null) {
            mInteractOperateIoc.h2(this.f441565h, this.f441567m, null);
        }
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.b
    public void M() {
        String str;
        String str2;
        String desc;
        this.mTianShuAd = QZoneAdFeedDataExtKt.getTianshuData(this.f441565h);
        b.a mAdFeedHeadData = getMAdFeedHeadData();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
        String str3 = "";
        if (qZoneAdTianshuFeedData == null || (str = qZoneAdTianshuFeedData.getTitle()) == null) {
            str = "";
        }
        mAdFeedHeadData.g(str);
        b.a mAdFeedHeadData2 = getMAdFeedHeadData();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData2 = this.mTianShuAd;
        if (qZoneAdTianshuFeedData2 == null || (str2 = qZoneAdTianshuFeedData2.getIconUrl()) == null) {
            str2 = "";
        }
        mAdFeedHeadData2.f(str2);
        b.a mAdFeedHeadData3 = getMAdFeedHeadData();
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData3 = this.mTianShuAd;
        if (qZoneAdTianshuFeedData3 != null && (desc = qZoneAdTianshuFeedData3.getDesc()) != null) {
            str3 = desc;
        }
        mAdFeedHeadData3.e(str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdTianshuHeadPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            switch (v3.getId()) {
                case R.id.mmc /* 1745224432 */:
                case R.id.mmd /* 1745224433 */:
                    P();
                    break;
                default:
                    QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
                    if (qZoneAdTianshuFeedData != null) {
                        ih.e.f407623a.k(qZoneAdTianshuFeedData, this.C);
                        break;
                    }
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
