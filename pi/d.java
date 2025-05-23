package pi;

import android.content.Context;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumNoticeInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import ho.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lpi/d;", "Loi/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "b", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends oi.a {
    @Override // oi.a
    public void b(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        HashMap<String, String> attrs = schemeBean.getAttrs();
        String str = attrs != null ? attrs.get(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID) : null;
        if (str == null) {
            str = "";
        }
        i.m().k(context, new GroupAlbumNoticeInitBean(str));
    }
}
