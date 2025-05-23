package of;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.favorite.QZoneFavoriteShareItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneFavoriteShareItemView> {
    @Override // nf.a
    public Class<QZoneFavoriteShareItemView> a() {
        return QZoneFavoriteShareItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FAVORITE_SHARE;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return com.qzone.reborn.feedx.itemview.d.c(businessFeedData) && com.qzone.reborn.feedx.itemview.d.b(businessFeedData.getOriginalInfo()) == 2;
    }
}
