package co;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.reborn.repair.bean.QZonePhotoRepairMainInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import ef.d;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lco/b;", "Lbo/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends bo.a {
    @Override // bo.a
    public void b(Context context, QZoneSchemeBean schemeBean) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        if (schemeBean.getAttrs() != null) {
            Intrinsics.checkNotNullExpressionValue(schemeBean.getAttrs(), "schemeBean.attrs");
            if (!r0.isEmpty()) {
                String str = schemeBean.getAttrs().get("from");
                if (!TextUtils.isEmpty(str)) {
                    Intrinsics.checkNotNull(str);
                    i3 = d.i(str);
                    i.v().b(context, new QZonePhotoRepairMainInitBean(i3));
                }
            }
        }
        i3 = 0;
        i.v().b(context, new QZonePhotoRepairMainInitBean(i3));
    }
}
