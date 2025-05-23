package cg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.permissionsetting.QZonePermissionSettingFeedItemView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends nf.a<QZonePermissionSettingFeedItemView> {
    @Override // nf.a
    public Class<QZonePermissionSettingFeedItemView> a() {
        return QZonePermissionSettingFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_PERMISSION_SETTING;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isFunctionGuideFeed();
    }
}
