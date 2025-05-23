package nj3;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplanservice.pbjava.ResourceEtagInfo$etag_info;
import com.tencent.qphone.base.util.QLog;
import el0.ETagInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lnj3/h;", "Lel0/f;", "Lcom/tencent/filament/zplanservice/pbjava/ResourceEtagInfo$etag_info;", "req", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h implements el0.f {
    @Override // el0.f
    public void a(ResourceEtagInfo$etag_info req) {
        Intrinsics.checkNotNullParameter(req, "req");
        String eTag = req.etag.get();
        String url = req.url.get();
        String fassetCachePath = req.save_path.get();
        QLog.i("ResourceETagInfoChannelProxyImpl", 1, "handleETagInfo, eTag: " + eTag + ", url: " + url + ", fasst: " + fassetCachePath);
        if (!(eTag == null || eTag.length() == 0)) {
            if (!(url == null || url.length() == 0)) {
                if (!(fassetCachePath == null || fassetCachePath.length() == 0)) {
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                    Intrinsics.checkNotNullExpressionValue(eTag, "eTag");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    Intrinsics.checkNotNullExpressionValue(fassetCachePath, "fassetCachePath");
                    zPlanAvatarResourceHelper.q0(new ETagInfo(eTag, url, fassetCachePath));
                    return;
                }
            }
        }
        QLog.e("ResourceETagInfoChannelProxyImpl", 1, "handleETagInfo failed, etag_info invalid.");
    }
}
