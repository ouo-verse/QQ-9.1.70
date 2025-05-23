package ic;

import android.app.Activity;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lic/c;", "Lcom/qzone/reborn/albumx/common/share/b;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "c", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "e", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "layerItemInfo", "", "d", "Z", "getFromDetail", "()Z", "fromDetail", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "()Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "extraInfoBean", "", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "existSaveOrEditPath", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "shareManger", "<init>", "(Landroid/app/Activity;Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;ZLcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends com.qzone.reborn.albumx.common.share.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final RFWLayerItemMediaInfo layerItemInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean fromDetail;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final QZAlbumxLayerExtraInfoBean extraInfoBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String existSaveOrEditPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Activity activity, QQShareActionManager<?> shareManger, RFWLayerItemMediaInfo layerItemInfo, boolean z16, QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean) {
        super(activity, shareManger);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareManger, "shareManger");
        Intrinsics.checkNotNullParameter(layerItemInfo, "layerItemInfo");
        this.layerItemInfo = layerItemInfo;
        this.fromDetail = z16;
        this.extraInfoBean = qZAlbumxLayerExtraInfoBean;
        this.existSaveOrEditPath = layerItemInfo.getExistSaveOrEditPath();
    }

    /* renamed from: c, reason: from getter */
    public final String getExistSaveOrEditPath() {
        return this.existSaveOrEditPath;
    }

    /* renamed from: d, reason: from getter */
    public final QZAlbumxLayerExtraInfoBean getExtraInfoBean() {
        return this.extraInfoBean;
    }

    /* renamed from: e, reason: from getter */
    public final RFWLayerItemMediaInfo getLayerItemInfo() {
        return this.layerItemInfo;
    }
}
