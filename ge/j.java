package ge;

import android.text.TextUtils;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.utils.ao;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Lge/i;", "", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j {
    public static final String a(i iVar) {
        if (iVar == null) {
            return "";
        }
        QzoneFeedProLayerExtraInfoBean extraInfo = iVar.getExtraInfo();
        String lLoc = extraInfo != null ? extraInfo.getLLoc() : null;
        if (!TextUtils.isEmpty(lLoc)) {
            return lLoc == null ? "" : lLoc;
        }
        RFWLayerItemMediaInfo mediaInfo = iVar.getMediaInfo();
        String p16 = mediaInfo != null ? ao.f54312a.p(mediaInfo) : null;
        return p16 == null ? "" : p16;
    }
}
