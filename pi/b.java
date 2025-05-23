package pi;

import android.content.Context;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import ho.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lpi/b;", "Loi/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "b", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends oi.a {
    @Override // oi.a
    public void b(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        HashMap<String, String> attrs = schemeBean.getAttrs();
        String str = attrs != null ? attrs.get(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID) : null;
        HashMap<String, String> attrs2 = schemeBean.getAttrs();
        String str2 = attrs2 != null ? attrs2.get("albumid") : null;
        HashMap<String, String> attrs3 = schemeBean.getAttrs();
        String str3 = attrs3 != null ? attrs3.get(s4.c.BATCHID) : null;
        HashMap<String, String> attrs4 = schemeBean.getAttrs();
        String str4 = attrs4 != null ? attrs4.get("llocid") : null;
        HashMap<String, String> attrs5 = schemeBean.getAttrs();
        String str5 = attrs5 != null ? attrs5.get("fromark") : null;
        vh.b bVar = new vh.b();
        Intrinsics.checkNotNull(str);
        bVar.i(str);
        Intrinsics.checkNotNull(str2);
        bVar.f(str2);
        Intrinsics.checkNotNull(str3);
        bVar.g(str3);
        if (str4 == null || str4.length() == 0) {
            str4 = "";
        }
        bVar.j(str4);
        bVar.h((str5 == null || Intrinsics.areEqual(str5, "0")) ? false : true);
        i.m().p(context, bVar);
    }
}
