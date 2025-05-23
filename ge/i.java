package ge;

import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lge/i;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "a", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "b", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "()Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "extraInfo", "<init>", "(Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RFWLayerItemMediaInfo mediaInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final QzoneFeedProLayerExtraInfoBean extraInfo;

    public i(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean) {
        this.mediaInfo = rFWLayerItemMediaInfo;
        this.extraInfo = qzoneFeedProLayerExtraInfoBean;
    }

    /* renamed from: a, reason: from getter */
    public final QzoneFeedProLayerExtraInfoBean getExtraInfo() {
        return this.extraInfo;
    }

    /* renamed from: b, reason: from getter */
    public final RFWLayerItemMediaInfo getMediaInfo() {
        return this.mediaInfo;
    }
}
