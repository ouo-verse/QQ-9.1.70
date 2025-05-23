package com.qzone.reborn.feedx.itemview.ad;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.presenter.ad.QZoneAdRecommendAdPresenter;
import com.qzone.reborn.feedx.presenter.ad.i;
import com.qzone.reborn.feedx.presenter.ad.multipicture.QZoneAdFeedMDPAPresenter;
import com.qzone.reborn.feedx.presenter.ad.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vg.a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004H\u0014R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/ad/QZoneAdPictureFeedItemView;", "Lcom/qzone/reborn/feedx/itemview/ad/QZoneAdBaseFeedItemView;", "", "getLogTag", "", "Ljava/lang/Class;", "Lvg/a;", "s0", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "TAG", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneAdPictureFeedItemView extends QZoneAdBaseFeedItemView {

    /* renamed from: F, reason: from kotlin metadata */
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdPictureFeedItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "QZoneAdPictureFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag, reason: from getter */
    protected String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.ad.QZoneAdBaseFeedItemView, com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public List<Class<? extends a>> s0() {
        List<Class<? extends a>> s06 = super.s0();
        s06.add(QZoneAdRecommendAdPresenter.class);
        s06.add(i.class);
        s06.add(x.class);
        s06.add(QZoneAdFeedMDPAPresenter.class);
        return s06;
    }
}
